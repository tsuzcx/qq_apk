package com.tencent.oskplayer.videorenderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class TextureSurfaceRenderer
  implements OnSurfaceSizeChangedListener, Runnable
{
  private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static String LOG_TAG = "TextureSurfaceRenderer";
  private EGL10 egl;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private int frames;
  protected int height;
  private long lastFpsOutput = 0L;
  private final Object mLock;
  private boolean running = false;
  protected final SurfaceTexture texture;
  protected int width;
  
  public TextureSurfaceRenderer(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.texture = paramSurfaceTexture;
    this.width = paramInt1;
    this.height = paramInt2;
    this.running = true;
    this.mLock = new Object();
    new Thread(this, "TextureSurfaceRenderer").start();
  }
  
  private EGLConfig chooseEglConfig()
  {
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = getConfig();
    if (this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      if (localObject[0] > 0) {
        return arrayOfEGLConfig[0];
      }
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to choose config: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  private void deinitEGL()
  {
    this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
    this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
    this.egl.eglTerminate(this.eglDisplay);
    PlayerUtils.log(4, LOG_TAG, "OpenGL deinit OK.");
  }
  
  private int[] getConfig()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  private void initEGL()
  {
    this.egl = ((EGL10)EGLContext.getEGL());
    this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject = new int[2];
    this.egl.eglInitialize(this.eglDisplay, (int[])localObject);
    localObject = chooseEglConfig();
    this.eglContext = createContext(this.egl, this.eglDisplay, (EGLConfig)localObject);
    this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, (EGLConfig)localObject, this.texture, null);
    localObject = this.eglSurface;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      localObject = this.egl;
      EGLDisplay localEGLDisplay = this.eglDisplay;
      EGLSurface localEGLSurface = this.eglSurface;
      if (((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.eglContext)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GL Make current error: ");
      ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL Error: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  private void pingFps()
  {
    if (this.lastFpsOutput == 0L) {
      this.lastFpsOutput = System.currentTimeMillis();
    }
    this.frames += 1;
    if (System.currentTimeMillis() - this.lastFpsOutput > 1000L)
    {
      String str = LOG_TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FPS: ");
      localStringBuilder.append(this.frames);
      PlayerUtils.log(2, str, localStringBuilder.toString());
      this.lastFpsOutput = System.currentTimeMillis();
      this.frames = 0;
    }
  }
  
  protected abstract void deinitGLComponents();
  
  protected abstract boolean draw();
  
  protected void finalize()
  {
    super.finalize();
    this.running = false;
  }
  
  public abstract SurfaceTexture getSurfaceTexture();
  
  protected abstract void initGLComponents();
  
  public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void release()
  {
    this.running = false;
    PlayerUtils.log(4, LOG_TAG, "start release");
    try
    {
      synchronized (this.mLock)
      {
        this.mLock.wait(800L);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      String str = LOG_TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("interrupted ");
      localStringBuilder.append(PlayerUtils.getPrintableStackTrace(localInterruptedException));
      PlayerUtils.log(4, str, localStringBuilder.toString());
      PlayerUtils.log(4, LOG_TAG, "released");
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_4
    //   1: getstatic 144	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   4: ldc 236
    //   6: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokespecial 238	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:initEGL	()V
    //   13: aload_0
    //   14: invokevirtual 240	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:initGLComponents	()V
    //   17: iconst_4
    //   18: getstatic 144	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   21: ldc 242
    //   23: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 45	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:running	Z
    //   30: ifeq +61 -> 91
    //   33: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   36: lstore_1
    //   37: aload_0
    //   38: invokespecial 244	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:pingFps	()V
    //   41: aload_0
    //   42: invokevirtual 246	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:draw	()Z
    //   45: ifeq +21 -> 66
    //   48: aload_0
    //   49: getfield 73	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:egl	Ljavax/microedition/khronos/egl/EGL10;
    //   52: aload_0
    //   53: getfield 75	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   56: aload_0
    //   57: getfield 128	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
    //   60: invokeinterface 249 3 0
    //   65: pop
    //   66: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   69: lstore_3
    //   70: ldc2_w 250
    //   73: lload_3
    //   74: lload_1
    //   75: lsub
    //   76: lsub
    //   77: lstore_1
    //   78: lload_1
    //   79: lconst_0
    //   80: lcmp
    //   81: ifle -55 -> 26
    //   84: lload_1
    //   85: invokestatic 254	java/lang/Thread:sleep	(J)V
    //   88: goto -62 -> 26
    //   91: aload_0
    //   92: invokevirtual 256	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:deinitGLComponents	()V
    //   95: aload_0
    //   96: invokespecial 258	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:deinitEGL	()V
    //   99: iconst_4
    //   100: getstatic 144	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   103: ldc_w 260
    //   106: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 55	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   113: astore 5
    //   115: aload 5
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield 55	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   122: invokevirtual 263	java/lang/Object:notify	()V
    //   125: aload 5
    //   127: monitorexit
    //   128: return
    //   129: astore 6
    //   131: aload 5
    //   133: monitorexit
    //   134: aload 6
    //   136: athrow
    //   137: astore 6
    //   139: goto +109 -> 248
    //   142: astore 5
    //   144: getstatic 144	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   147: astore 6
    //   149: new 83	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   156: astore 7
    //   158: aload 7
    //   160: ldc_w 265
    //   163: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 7
    //   169: aload 5
    //   171: invokevirtual 266	java/lang/Exception:toString	()Ljava/lang/String;
    //   174: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 7
    //   180: ldc_w 268
    //   183: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 7
    //   189: aload 5
    //   191: invokestatic 229	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   194: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: bipush 6
    //   200: aload 6
    //   202: aload 7
    //   204: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   210: iconst_4
    //   211: getstatic 144	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   214: ldc_w 260
    //   217: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield 55	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   224: astore 5
    //   226: aload 5
    //   228: monitorenter
    //   229: aload_0
    //   230: getfield 55	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   233: invokevirtual 263	java/lang/Object:notify	()V
    //   236: aload 5
    //   238: monitorexit
    //   239: return
    //   240: astore 6
    //   242: aload 5
    //   244: monitorexit
    //   245: aload 6
    //   247: athrow
    //   248: iconst_4
    //   249: getstatic 144	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   252: ldc_w 260
    //   255: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 55	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   262: astore 5
    //   264: aload 5
    //   266: monitorenter
    //   267: aload_0
    //   268: getfield 55	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   271: invokevirtual 263	java/lang/Object:notify	()V
    //   274: aload 5
    //   276: monitorexit
    //   277: aload 6
    //   279: athrow
    //   280: astore 6
    //   282: aload 5
    //   284: monitorexit
    //   285: goto +6 -> 291
    //   288: aload 6
    //   290: athrow
    //   291: goto -3 -> 288
    //   294: astore 5
    //   296: goto -270 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	TextureSurfaceRenderer
    //   36	49	1	l1	long
    //   69	5	3	l2	long
    //   113	19	5	localObject1	Object
    //   142	48	5	localException	java.lang.Exception
    //   224	59	5	localObject2	Object
    //   294	1	5	localInterruptedException	InterruptedException
    //   129	6	6	localObject3	Object
    //   137	1	6	localObject4	Object
    //   147	54	6	str	String
    //   240	38	6	localObject5	Object
    //   280	9	6	localObject6	Object
    //   156	47	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   118	128	129	finally
    //   131	134	129	finally
    //   0	26	137	finally
    //   26	66	137	finally
    //   66	70	137	finally
    //   84	88	137	finally
    //   91	99	137	finally
    //   144	210	137	finally
    //   0	26	142	java/lang/Exception
    //   26	66	142	java/lang/Exception
    //   66	70	142	java/lang/Exception
    //   84	88	142	java/lang/Exception
    //   91	99	142	java/lang/Exception
    //   229	239	240	finally
    //   242	245	240	finally
    //   267	277	280	finally
    //   282	285	280	finally
    //   84	88	294	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.videorenderer.TextureSurfaceRenderer
 * JD-Core Version:    0.7.0.1
 */