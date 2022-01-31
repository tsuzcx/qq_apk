package com.tencent.tav.decoder;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RenderContext
  implements IDecoderTrack.SurfaceCreator
{
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private static final String TAG = "RenderContext";
  private EGLContext _eglContext;
  private HashMap<Surface, String> activeSurfaceCache = new HashMap();
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private HashMap<String, Surface> freeSurfaceCache = new HashMap();
  @Nullable
  private CGRect glViewportRect;
  private int height;
  private boolean isSharedContext = false;
  private boolean pBufferEnable = false;
  @Nullable
  private RenderContextParams params;
  private volatile boolean released = false;
  private List<Surface> releasingSurfaceCache = new ArrayList();
  private Surface surface;
  private long threadId = -1L;
  private HashMap<Surface, VideoTexture> videoTextureMap = new HashMap();
  private int width;
  
  public RenderContext(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }
  
  public RenderContext(int paramInt1, int paramInt2, Surface paramSurface)
  {
    this(paramInt1, paramInt2, paramSurface, null);
  }
  
  public RenderContext(int paramInt1, int paramInt2, Surface paramSurface, EGLContext paramEGLContext)
  {
    this.surface = paramSurface;
    this.width = paramInt1;
    this.height = paramInt2;
    eglSetup(paramEGLContext);
    makeCurrent();
  }
  
  public static boolean checkEglActionSuccess(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      Log.e("RenderContext", paramString + ": EGL error: 0x" + Integer.toHexString(j));
      localStringBuilder.append(paramString + ": EGL error: 0x" + Integer.toHexString(j));
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): " + localStringBuilder.toString()).printStackTrace();
    }
    return i == 0;
  }
  
  public static void checkEglError(String paramString)
  {
    checkEglActionSuccess(paramString);
  }
  
  private void checkThread()
  {
    if (this.threadId != Thread.currentThread().getId()) {
      Logger.e("RenderContext", "Thread wrong!! ", new RuntimeException());
    }
  }
  
  public static int createTexture(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    checkEglError("glBindTexture mTextureID");
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameteri(paramInt, 10242, 33071);
    GLES20.glTexParameteri(paramInt, 10243, 33071);
    checkEglError("glTexParameter");
    return i;
  }
  
  /* Error */
  private void eglSetup(EGLContext paramEGLContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 151	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: invokevirtual 155	java/lang/Thread:getId	()J
    //   9: putfield 66	com/tencent/tav/decoder/RenderContext:threadId	J
    //   12: aload_0
    //   13: getfield 62	com/tencent/tav/decoder/RenderContext:released	Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifeq +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: iconst_0
    //   28: invokestatic 198	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   31: putfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   34: aload_0
    //   35: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   38: getstatic 203	android/opengl/EGL14:EGL_NO_DISPLAY	Landroid/opengl/EGLDisplay;
    //   41: if_acmpne +31 -> 72
    //   44: new 135	java/lang/RuntimeException
    //   47: dup
    //   48: ldc 205
    //   50: invokespecial 138	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   53: invokevirtual 141	java/lang/RuntimeException:printStackTrace	()V
    //   56: goto -33 -> 23
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 208	java/lang/Throwable:printStackTrace	()V
    //   64: goto -41 -> 23
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: iconst_2
    //   73: newarray int
    //   75: astore 5
    //   77: aload_0
    //   78: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   81: aload 5
    //   83: iconst_0
    //   84: aload 5
    //   86: iconst_1
    //   87: invokestatic 212	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   90: ifne +23 -> 113
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   98: new 135	java/lang/RuntimeException
    //   101: dup
    //   102: ldc 214
    //   104: invokespecial 138	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 141	java/lang/RuntimeException:printStackTrace	()V
    //   110: goto -87 -> 23
    //   113: iconst_1
    //   114: anewarray 216	android/opengl/EGLConfig
    //   117: astore 5
    //   119: iconst_1
    //   120: newarray int
    //   122: astore 6
    //   124: aload_0
    //   125: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   128: astore 7
    //   130: aload 5
    //   132: arraylength
    //   133: istore_2
    //   134: aload 7
    //   136: bipush 11
    //   138: newarray int
    //   140: dup
    //   141: iconst_0
    //   142: sipush 12324
    //   145: iastore
    //   146: dup
    //   147: iconst_1
    //   148: bipush 8
    //   150: iastore
    //   151: dup
    //   152: iconst_2
    //   153: sipush 12323
    //   156: iastore
    //   157: dup
    //   158: iconst_3
    //   159: bipush 8
    //   161: iastore
    //   162: dup
    //   163: iconst_4
    //   164: sipush 12322
    //   167: iastore
    //   168: dup
    //   169: iconst_5
    //   170: bipush 8
    //   172: iastore
    //   173: dup
    //   174: bipush 6
    //   176: sipush 12352
    //   179: iastore
    //   180: dup
    //   181: bipush 7
    //   183: iconst_4
    //   184: iastore
    //   185: dup
    //   186: bipush 8
    //   188: sipush 12610
    //   191: iastore
    //   192: dup
    //   193: bipush 9
    //   195: iconst_1
    //   196: iastore
    //   197: dup
    //   198: bipush 10
    //   200: sipush 12344
    //   203: iastore
    //   204: iconst_0
    //   205: aload 5
    //   207: iconst_0
    //   208: iload_2
    //   209: aload 6
    //   211: iconst_0
    //   212: invokestatic 220	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   215: ifne +18 -> 233
    //   218: new 135	java/lang/RuntimeException
    //   221: dup
    //   222: ldc 222
    //   224: invokespecial 138	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   227: invokevirtual 141	java/lang/RuntimeException:printStackTrace	()V
    //   230: goto -207 -> 23
    //   233: iconst_3
    //   234: newarray int
    //   236: astore 6
    //   238: aload 6
    //   240: dup
    //   241: iconst_0
    //   242: sipush 12440
    //   245: iastore
    //   246: dup
    //   247: iconst_1
    //   248: iconst_2
    //   249: iastore
    //   250: dup
    //   251: iconst_2
    //   252: sipush 12344
    //   255: iastore
    //   256: pop
    //   257: aload_1
    //   258: ifnull +54 -> 312
    //   261: aload_0
    //   262: iconst_1
    //   263: putfield 60	com/tencent/tav/decoder/RenderContext:isSharedContext	Z
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   271: aload 5
    //   273: iconst_0
    //   274: aaload
    //   275: aload_1
    //   276: aload 6
    //   278: iconst_0
    //   279: invokestatic 226	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   282: putfield 228	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   285: ldc 229
    //   287: invokestatic 178	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   290: aload_0
    //   291: getfield 228	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   294: ifnonnull +66 -> 360
    //   297: new 135	java/lang/RuntimeException
    //   300: dup
    //   301: ldc 231
    //   303: invokespecial 138	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   306: invokevirtual 141	java/lang/RuntimeException:printStackTrace	()V
    //   309: goto -286 -> 23
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   317: aload 5
    //   319: iconst_0
    //   320: aaload
    //   321: getstatic 234	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   324: aload 6
    //   326: iconst_0
    //   327: invokestatic 226	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   330: putfield 228	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   333: ldc 229
    //   335: invokestatic 178	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   338: aload_0
    //   339: getfield 228	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   342: ifnonnull +18 -> 360
    //   345: new 135	java/lang/RuntimeException
    //   348: dup
    //   349: ldc 231
    //   351: invokespecial 138	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   354: invokevirtual 141	java/lang/RuntimeException:printStackTrace	()V
    //   357: goto -334 -> 23
    //   360: aload_0
    //   361: getfield 84	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   364: ifnull +67 -> 431
    //   367: aload_0
    //   368: aload_0
    //   369: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   372: aload 5
    //   374: iconst_0
    //   375: aaload
    //   376: aload_0
    //   377: getfield 84	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   380: iconst_1
    //   381: newarray int
    //   383: dup
    //   384: iconst_0
    //   385: sipush 12344
    //   388: iastore
    //   389: iconst_0
    //   390: invokestatic 238	android/opengl/EGL14:eglCreateWindowSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Ljava/lang/Object;[II)Landroid/opengl/EGLSurface;
    //   393: putfield 240	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   396: ldc 241
    //   398: invokestatic 144	com/tencent/tav/decoder/RenderContext:checkEglActionSuccess	(Ljava/lang/String;)Z
    //   401: ifeq +8 -> 409
    //   404: aload_0
    //   405: iconst_1
    //   406: putfield 68	com/tencent/tav/decoder/RenderContext:pBufferEnable	Z
    //   409: aload_0
    //   410: getfield 240	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   413: ifnonnull -390 -> 23
    //   416: new 135	java/lang/RuntimeException
    //   419: dup
    //   420: ldc 243
    //   422: invokespecial 138	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   425: invokevirtual 141	java/lang/RuntimeException:printStackTrace	()V
    //   428: goto -405 -> 23
    //   431: aload_0
    //   432: getfield 86	com/tencent/tav/decoder/RenderContext:width	I
    //   435: istore_2
    //   436: aload_0
    //   437: getfield 88	com/tencent/tav/decoder/RenderContext:height	I
    //   440: istore_3
    //   441: aload_0
    //   442: aload_0
    //   443: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   446: aload 5
    //   448: iconst_0
    //   449: aaload
    //   450: iconst_5
    //   451: newarray int
    //   453: dup
    //   454: iconst_0
    //   455: sipush 12375
    //   458: iastore
    //   459: dup
    //   460: iconst_1
    //   461: iload_2
    //   462: iastore
    //   463: dup
    //   464: iconst_2
    //   465: sipush 12374
    //   468: iastore
    //   469: dup
    //   470: iconst_3
    //   471: iload_3
    //   472: iastore
    //   473: dup
    //   474: iconst_4
    //   475: sipush 12344
    //   478: iastore
    //   479: iconst_0
    //   480: invokestatic 247	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   483: putfield 240	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   486: goto -90 -> 396
    //   489: astore_1
    //   490: goto -430 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	RenderContext
    //   0	493	1	paramEGLContext	EGLContext
    //   133	329	2	i	int
    //   440	32	3	j	int
    //   16	3	4	bool	boolean
    //   75	372	5	localObject	Object
    //   122	203	6	arrayOfInt	int[]
    //   128	7	7	localEGLDisplay	EGLDisplay
    // Exception table:
    //   from	to	target	type
    //   26	56	59	java/lang/Exception
    //   72	110	59	java/lang/Exception
    //   113	230	59	java/lang/Exception
    //   233	257	59	java/lang/Exception
    //   261	309	59	java/lang/Exception
    //   312	357	59	java/lang/Exception
    //   360	396	59	java/lang/Exception
    //   396	409	59	java/lang/Exception
    //   409	428	59	java/lang/Exception
    //   431	486	59	java/lang/Exception
    //   2	18	67	finally
    //   26	56	67	finally
    //   60	64	67	finally
    //   72	110	67	finally
    //   113	230	67	finally
    //   233	257	67	finally
    //   261	309	67	finally
    //   312	357	67	finally
    //   360	396	67	finally
    //   396	409	67	finally
    //   409	428	67	finally
    //   431	486	67	finally
    //   26	56	489	java/lang/Error
    //   72	110	489	java/lang/Error
    //   113	230	489	java/lang/Error
    //   233	257	489	java/lang/Error
    //   261	309	489	java/lang/Error
    //   312	357	489	java/lang/Error
    //   360	396	489	java/lang/Error
    //   396	409	489	java/lang/Error
    //   409	428	489	java/lang/Error
    //   431	486	489	java/lang/Error
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        boolean bool = this.released;
        if (bool)
        {
          paramInt = i;
          return paramInt;
        }
        int j = GLES20.glCreateShader(paramInt);
        checkEglError("glCreateShader type=" + paramInt);
        GLES20.glShaderSource(j, paramString);
        GLES20.glCompileShader(j);
        paramString = new int[1];
        GLES20.glGetShaderiv(j, 35713, paramString, 0);
        if (paramString[0] == 0)
        {
          Log.e("RenderContext", "Could not compile shader " + paramInt + ":");
          Log.e("RenderContext", " " + GLES20.glGetShaderInfoLog(j));
          GLES20.glDeleteShader(j);
          paramInt = i;
        }
        else
        {
          paramInt = j;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private void release(Surface paramSurface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 286	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   6: aload_1
    //   7: ifnonnull +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 73	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 290	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +17 -> 38
    //   24: aload_0
    //   25: getfield 73	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   28: aload_1
    //   29: invokevirtual 294	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 296	com/tencent/tav/decoder/VideoTexture
    //   35: invokevirtual 298	com/tencent/tav/decoder/VideoTexture:release	()V
    //   38: aload_1
    //   39: invokevirtual 301	android/view/Surface:release	()V
    //   42: goto -32 -> 10
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	RenderContext
    //   0	50	1	paramSurface	Surface
    // Exception table:
    //   from	to	target	type
    //   2	6	45	finally
    //   13	38	45	finally
    //   38	42	45	finally
  }
  
  private void releaseReleadingSurface()
  {
    checkThread();
    int i = 0;
    while (i < this.releasingSurfaceCache.size())
    {
      release((Surface)this.releasingSurfaceCache.remove(i));
      i += 1;
    }
  }
  
  public Surface createOutputSurface(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      String str;
      try
      {
        boolean bool = this.released;
        Surface localSurface1;
        if (bool)
        {
          localSurface1 = null;
          return localSurface1;
        }
        checkThread();
        releaseReleadingSurface();
        str = paramInt1 + "*" + paramInt2 + "-" + paramInt3;
        if (this.freeSurfaceCache.containsKey(str))
        {
          localSurface1 = (Surface)this.freeSurfaceCache.remove(str);
          if (localSurface1 != null)
          {
            this.activeSurfaceCache.put(localSurface1, str);
            continue;
          }
        }
        makeCurrent();
      }
      finally {}
      VideoTexture localVideoTexture = new VideoTexture(paramInt1, paramInt2, 36197, paramInt3);
      localVideoTexture.setRenderContext(this);
      Surface localSurface2 = new Surface(localVideoTexture.surfaceTexture());
      this.videoTextureMap.put(localSurface2, localVideoTexture);
      this.activeSurfaceCache.put(localSurface2, str);
    }
  }
  
  public EGLContext eglContext()
  {
    return this._eglContext;
  }
  
  /* Error */
  public void free(Surface paramSurface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 15
    //   4: new 99	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 344
    //   14: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokestatic 151	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   20: invokevirtual 155	java/lang/Thread:getId	()J
    //   23: invokevirtual 347	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 351	com/tencent/tav/decoder/logger/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_1
    //   33: ifnonnull +6 -> 39
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: getfield 75	com/tencent/tav/decoder/RenderContext:activeSurfaceCache	Ljava/util/HashMap;
    //   43: aload_1
    //   44: invokevirtual 294	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 353	java/lang/String
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +14 -> 69
    //   58: aload_0
    //   59: getfield 77	com/tencent/tav/decoder/RenderContext:freeSurfaceCache	Ljava/util/HashMap;
    //   62: aload_2
    //   63: invokevirtual 290	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   66: ifne +3 -> 69
    //   69: aload_0
    //   70: getfield 82	com/tencent/tav/decoder/RenderContext:releasingSurfaceCache	Ljava/util/List;
    //   73: aload_1
    //   74: invokeinterface 362 2 0
    //   79: pop
    //   80: goto -44 -> 36
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	RenderContext
    //   0	88	1	paramSurface	Surface
    //   50	13	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	32	83	finally
    //   39	69	83	finally
    //   69	80	83	finally
  }
  
  public long getEglSurfaceHandle()
  {
    if (this.eglSurface != null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return this.eglSurface.getNativeHandle();
      }
      return this.eglSurface.getHandle();
    }
    return 0L;
  }
  
  @Nullable
  public CGRect getGlViewportRect()
  {
    return this.glViewportRect;
  }
  
  @Nullable
  public RenderContextParams getParams()
  {
    return this.params;
  }
  
  public int height()
  {
    return this.height;
  }
  
  public boolean isPBufferEnable()
  {
    return this.pBufferEnable;
  }
  
  /* Error */
  public void makeCurrent()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 286	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   6: aload_0
    //   7: getfield 62	com/tencent/tav/decoder/RenderContext:released	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   22: aload_0
    //   23: getfield 240	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   26: aload_0
    //   27: getfield 240	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   30: aload_0
    //   31: getfield 228	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   34: invokestatic 391	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   37: ifne -22 -> 15
    //   40: ldc_w 393
    //   43: invokestatic 178	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   46: goto -31 -> 15
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	RenderContext
    //   10	2	1	bool	boolean
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	49	finally
    //   18	46	49	finally
  }
  
  public void release()
  {
    for (;;)
    {
      try
      {
        checkThread();
        boolean bool = this.released;
        if (bool) {
          return;
        }
        makeCurrent();
        this.released = true;
        releaseReleadingSurface();
        Iterator localIterator1 = this.videoTextureMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          ((Surface)localIterator1.next()).release();
          continue;
        }
        localIterator2 = this.videoTextureMap.values().iterator();
      }
      finally {}
      Iterator localIterator2;
      while (localIterator2.hasNext()) {
        ((VideoTexture)localIterator2.next()).release();
      }
      this.videoTextureMap.clear();
      try
      {
        if (EGL14.eglGetCurrentContext().equals(this._eglContext)) {
          EGL14.eglMakeCurrent(this.eglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
        if (!this.isSharedContext) {
          EGL14.eglDestroyContext(this.eglDisplay, this._eglContext);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
        }
      }
      this.eglDisplay = null;
      this._eglContext = null;
      this.eglSurface = null;
      this.surface = null;
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setParams(@Nullable RenderContextParams paramRenderContextParams)
  {
    this.params = paramRenderContextParams;
  }
  
  /* Error */
  public void setPresentationTime(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/tav/decoder/RenderContext:released	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 84	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   18: ifnull -7 -> 11
    //   21: aload_0
    //   22: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   25: aload_0
    //   26: getfield 240	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   29: ldc2_w 450
    //   32: lload_1
    //   33: lmul
    //   34: invokestatic 457	android/opengl/EGLExt:eglPresentationTimeANDROID	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;J)Z
    //   37: pop
    //   38: goto -27 -> 11
    //   41: astore 4
    //   43: aload_0
    //   44: monitorexit
    //   45: aload 4
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	RenderContext
    //   0	48	1	paramLong	long
    //   6	2	3	bool	boolean
    //   41	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	41	finally
    //   14	38	41	finally
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  /* Error */
  public boolean swapBuffers()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 286	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   6: aload_0
    //   7: getfield 62	com/tencent/tav/decoder/RenderContext:released	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +9 -> 21
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 200	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   25: aload_0
    //   26: getfield 240	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   29: invokestatic 462	android/opengl/EGL14:eglSwapBuffers	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
    //   32: istore_1
    //   33: goto -16 -> 17
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	RenderContext
    //   10	23	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	36	finally
    //   21	33	36	finally
  }
  
  public String toString()
  {
    return "RenderContext{_eglContext=" + this._eglContext + ", isSharedContext=" + this.isSharedContext + ", released=" + this.released + '}';
  }
  
  public void updateViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    makeCurrent();
    GLES20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void updateViewport(CGRect paramCGRect)
  {
    if ((paramCGRect == null) || (paramCGRect.origin == null) || (paramCGRect.size == null)) {
      return;
    }
    this.glViewportRect = paramCGRect;
    updateViewport((int)paramCGRect.origin.x, (int)paramCGRect.origin.y, (int)paramCGRect.size.width, (int)paramCGRect.size.height);
  }
  
  public VideoTexture videoTextureForSurface(Surface paramSurface)
  {
    try
    {
      paramSurface = (VideoTexture)this.videoTextureMap.get(paramSurface);
      return paramSurface;
    }
    finally
    {
      paramSurface = finally;
      throw paramSurface;
    }
  }
  
  public int width()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContext
 * JD-Core Version:    0.7.0.1
 */