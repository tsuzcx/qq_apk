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
    int[] arrayOfInt1 = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = getConfig();
    if (!this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt2, arrayOfEGLConfig, 1, arrayOfInt1)) {
      throw new IllegalArgumentException("Failed to choose config: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
    }
    if (arrayOfInt1[0] > 0) {
      return arrayOfEGLConfig[0];
    }
    return null;
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
    if ((this.eglSurface == null) || (this.eglSurface == EGL10.EGL_NO_SURFACE)) {
      throw new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
    }
    if (!this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
      throw new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
    }
  }
  
  private void pingFps()
  {
    if (this.lastFpsOutput == 0L) {
      this.lastFpsOutput = System.currentTimeMillis();
    }
    this.frames += 1;
    if (System.currentTimeMillis() - this.lastFpsOutput > 1000L)
    {
      PlayerUtils.log(2, LOG_TAG, "FPS: " + this.frames);
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
    synchronized (this.mLock)
    {
      try
      {
        this.mLock.wait(800L);
        PlayerUtils.log(4, LOG_TAG, "released");
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          PlayerUtils.log(4, LOG_TAG, "interrupted " + PlayerUtils.getPrintableStackTrace(localInterruptedException));
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_4
    //   1: getstatic 40	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   4: ldc 236
    //   6: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokespecial 238	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:initEGL	()V
    //   13: aload_0
    //   14: invokevirtual 240	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:initGLComponents	()V
    //   17: iconst_4
    //   18: getstatic 40	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   21: ldc 242
    //   23: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 47	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:running	Z
    //   30: ifeq +66 -> 96
    //   33: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   36: lstore_1
    //   37: aload_0
    //   38: invokespecial 244	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:pingFps	()V
    //   41: aload_0
    //   42: invokevirtual 246	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:draw	()Z
    //   45: ifeq +21 -> 66
    //   48: aload_0
    //   49: getfield 75	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:egl	Ljavax/microedition/khronos/egl/EGL10;
    //   52: aload_0
    //   53: getfield 77	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   56: aload_0
    //   57: getfield 130	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
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
    //   91: astore 5
    //   93: goto -67 -> 26
    //   96: aload_0
    //   97: invokevirtual 256	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:deinitGLComponents	()V
    //   100: aload_0
    //   101: invokespecial 258	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:deinitEGL	()V
    //   104: iconst_4
    //   105: getstatic 40	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   108: ldc_w 260
    //   111: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 57	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   118: astore 5
    //   120: aload 5
    //   122: monitorenter
    //   123: aload_0
    //   124: getfield 57	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   127: invokevirtual 263	java/lang/Object:notify	()V
    //   130: aload 5
    //   132: monitorexit
    //   133: return
    //   134: astore 6
    //   136: aload 5
    //   138: monitorexit
    //   139: aload 6
    //   141: athrow
    //   142: astore 5
    //   144: bipush 6
    //   146: getstatic 40	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   149: new 87	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 265
    //   159: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 5
    //   164: invokevirtual 266	java/lang/Exception:toString	()Ljava/lang/String;
    //   167: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 268
    //   173: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 5
    //   178: invokestatic 231	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   181: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   190: iconst_4
    //   191: getstatic 40	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   194: ldc_w 260
    //   197: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   200: aload_0
    //   201: getfield 57	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   204: astore 5
    //   206: aload 5
    //   208: monitorenter
    //   209: aload_0
    //   210: getfield 57	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   213: invokevirtual 263	java/lang/Object:notify	()V
    //   216: aload 5
    //   218: monitorexit
    //   219: return
    //   220: astore 6
    //   222: aload 5
    //   224: monitorexit
    //   225: aload 6
    //   227: athrow
    //   228: astore 6
    //   230: iconst_4
    //   231: getstatic 40	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:LOG_TAG	Ljava/lang/String;
    //   234: ldc_w 260
    //   237: invokestatic 152	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 57	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   244: astore 5
    //   246: aload 5
    //   248: monitorenter
    //   249: aload_0
    //   250: getfield 57	com/tencent/oskplayer/videorenderer/TextureSurfaceRenderer:mLock	Ljava/lang/Object;
    //   253: invokevirtual 263	java/lang/Object:notify	()V
    //   256: aload 5
    //   258: monitorexit
    //   259: aload 6
    //   261: athrow
    //   262: astore 6
    //   264: aload 5
    //   266: monitorexit
    //   267: aload 6
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	TextureSurfaceRenderer
    //   36	49	1	l1	long
    //   69	5	3	l2	long
    //   91	1	5	localInterruptedException	InterruptedException
    //   118	19	5	localObject1	Object
    //   142	35	5	localException	java.lang.Exception
    //   204	61	5	localObject2	Object
    //   134	6	6	localObject3	Object
    //   220	6	6	localObject4	Object
    //   228	32	6	localObject5	Object
    //   262	6	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   84	88	91	java/lang/InterruptedException
    //   123	133	134	finally
    //   136	139	134	finally
    //   0	26	142	java/lang/Exception
    //   26	66	142	java/lang/Exception
    //   66	70	142	java/lang/Exception
    //   84	88	142	java/lang/Exception
    //   96	104	142	java/lang/Exception
    //   209	219	220	finally
    //   222	225	220	finally
    //   0	26	228	finally
    //   26	66	228	finally
    //   66	70	228	finally
    //   84	88	228	finally
    //   96	104	228	finally
    //   144	190	228	finally
    //   249	259	262	finally
    //   264	267	262	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.videorenderer.TextureSurfaceRenderer
 * JD-Core Version:    0.7.0.1
 */