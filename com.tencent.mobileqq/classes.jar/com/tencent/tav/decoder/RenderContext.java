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
      Logger.e("RenderContext", "checkEglActionSuccess: ", new RuntimeException("EGL error encountered (see log): " + localStringBuilder.toString()));
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
      Logger.e("RenderContext", "线程不对，注意EGL相关的泄露问题！threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
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
    //   3: invokestatic 155	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: invokevirtual 159	java/lang/Thread:getId	()J
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
    //   28: invokestatic 205	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   31: putfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   34: aload_0
    //   35: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   38: getstatic 210	android/opengl/EGL14:EGL_NO_DISPLAY	Landroid/opengl/EGLDisplay;
    //   41: if_acmpne +39 -> 80
    //   44: ldc 15
    //   46: ldc 212
    //   48: new 137	java/lang/RuntimeException
    //   51: dup
    //   52: ldc 214
    //   54: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   57: invokestatic 145	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: goto -37 -> 23
    //   63: astore_1
    //   64: ldc 15
    //   66: ldc 212
    //   68: aload_1
    //   69: invokestatic 145	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: goto -49 -> 23
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: iconst_2
    //   81: newarray int
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   89: aload 5
    //   91: iconst_0
    //   92: aload 5
    //   94: iconst_1
    //   95: invokestatic 218	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   98: ifne +27 -> 125
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   106: ldc 15
    //   108: ldc 212
    //   110: new 137	java/lang/RuntimeException
    //   113: dup
    //   114: ldc 220
    //   116: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   119: invokestatic 145	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto -99 -> 23
    //   125: iconst_1
    //   126: anewarray 222	android/opengl/EGLConfig
    //   129: astore 5
    //   131: iconst_1
    //   132: newarray int
    //   134: astore 6
    //   136: aload_0
    //   137: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   140: astore 7
    //   142: aload 5
    //   144: arraylength
    //   145: istore_2
    //   146: aload 7
    //   148: bipush 11
    //   150: newarray int
    //   152: dup
    //   153: iconst_0
    //   154: sipush 12324
    //   157: iastore
    //   158: dup
    //   159: iconst_1
    //   160: bipush 8
    //   162: iastore
    //   163: dup
    //   164: iconst_2
    //   165: sipush 12323
    //   168: iastore
    //   169: dup
    //   170: iconst_3
    //   171: bipush 8
    //   173: iastore
    //   174: dup
    //   175: iconst_4
    //   176: sipush 12322
    //   179: iastore
    //   180: dup
    //   181: iconst_5
    //   182: bipush 8
    //   184: iastore
    //   185: dup
    //   186: bipush 6
    //   188: sipush 12352
    //   191: iastore
    //   192: dup
    //   193: bipush 7
    //   195: iconst_4
    //   196: iastore
    //   197: dup
    //   198: bipush 8
    //   200: sipush 12610
    //   203: iastore
    //   204: dup
    //   205: bipush 9
    //   207: iconst_1
    //   208: iastore
    //   209: dup
    //   210: bipush 10
    //   212: sipush 12344
    //   215: iastore
    //   216: iconst_0
    //   217: aload 5
    //   219: iconst_0
    //   220: iload_2
    //   221: aload 6
    //   223: iconst_0
    //   224: invokestatic 226	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   227: ifne +22 -> 249
    //   230: ldc 15
    //   232: ldc 212
    //   234: new 137	java/lang/RuntimeException
    //   237: dup
    //   238: ldc 228
    //   240: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   243: invokestatic 145	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: goto -223 -> 23
    //   249: iconst_3
    //   250: newarray int
    //   252: astore 6
    //   254: aload 6
    //   256: dup
    //   257: iconst_0
    //   258: sipush 12440
    //   261: iastore
    //   262: dup
    //   263: iconst_1
    //   264: iconst_2
    //   265: iastore
    //   266: dup
    //   267: iconst_2
    //   268: sipush 12344
    //   271: iastore
    //   272: pop
    //   273: aload_1
    //   274: ifnull +58 -> 332
    //   277: aload_0
    //   278: iconst_1
    //   279: putfield 60	com/tencent/tav/decoder/RenderContext:isSharedContext	Z
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   287: aload 5
    //   289: iconst_0
    //   290: aaload
    //   291: aload_1
    //   292: aload 6
    //   294: iconst_0
    //   295: invokestatic 232	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   298: putfield 234	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   301: ldc 235
    //   303: invokestatic 185	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   306: aload_0
    //   307: getfield 234	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   310: ifnonnull +74 -> 384
    //   313: ldc 15
    //   315: ldc 212
    //   317: new 137	java/lang/RuntimeException
    //   320: dup
    //   321: ldc 237
    //   323: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   326: invokestatic 145	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: goto -306 -> 23
    //   332: aload_0
    //   333: aload_0
    //   334: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   337: aload 5
    //   339: iconst_0
    //   340: aaload
    //   341: getstatic 240	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   344: aload 6
    //   346: iconst_0
    //   347: invokestatic 232	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   350: putfield 234	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   353: ldc 235
    //   355: invokestatic 185	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
    //   358: aload_0
    //   359: getfield 234	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   362: ifnonnull +22 -> 384
    //   365: ldc 15
    //   367: ldc 212
    //   369: new 137	java/lang/RuntimeException
    //   372: dup
    //   373: ldc 237
    //   375: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   378: invokestatic 145	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: goto -358 -> 23
    //   384: aload_0
    //   385: getfield 84	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   388: ifnull +71 -> 459
    //   391: aload_0
    //   392: aload_0
    //   393: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   396: aload 5
    //   398: iconst_0
    //   399: aaload
    //   400: aload_0
    //   401: getfield 84	com/tencent/tav/decoder/RenderContext:surface	Landroid/view/Surface;
    //   404: iconst_1
    //   405: newarray int
    //   407: dup
    //   408: iconst_0
    //   409: sipush 12344
    //   412: iastore
    //   413: iconst_0
    //   414: invokestatic 244	android/opengl/EGL14:eglCreateWindowSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Ljava/lang/Object;[II)Landroid/opengl/EGLSurface;
    //   417: putfield 246	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   420: ldc 247
    //   422: invokestatic 148	com/tencent/tav/decoder/RenderContext:checkEglActionSuccess	(Ljava/lang/String;)Z
    //   425: ifeq +8 -> 433
    //   428: aload_0
    //   429: iconst_1
    //   430: putfield 68	com/tencent/tav/decoder/RenderContext:pBufferEnable	Z
    //   433: aload_0
    //   434: getfield 246	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   437: ifnonnull -414 -> 23
    //   440: ldc 15
    //   442: ldc 212
    //   444: new 137	java/lang/RuntimeException
    //   447: dup
    //   448: ldc 249
    //   450: invokespecial 140	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   453: invokestatic 145	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   456: goto -433 -> 23
    //   459: aload_0
    //   460: getfield 86	com/tencent/tav/decoder/RenderContext:width	I
    //   463: istore_2
    //   464: aload_0
    //   465: getfield 88	com/tencent/tav/decoder/RenderContext:height	I
    //   468: istore_3
    //   469: aload_0
    //   470: aload_0
    //   471: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   474: aload 5
    //   476: iconst_0
    //   477: aaload
    //   478: iconst_5
    //   479: newarray int
    //   481: dup
    //   482: iconst_0
    //   483: sipush 12375
    //   486: iastore
    //   487: dup
    //   488: iconst_1
    //   489: iload_2
    //   490: iastore
    //   491: dup
    //   492: iconst_2
    //   493: sipush 12374
    //   496: iastore
    //   497: dup
    //   498: iconst_3
    //   499: iload_3
    //   500: iastore
    //   501: dup
    //   502: iconst_4
    //   503: sipush 12344
    //   506: iastore
    //   507: iconst_0
    //   508: invokestatic 253	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   511: putfield 246	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   514: goto -94 -> 420
    //   517: astore_1
    //   518: goto -454 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	RenderContext
    //   0	521	1	paramEGLContext	EGLContext
    //   145	345	2	i	int
    //   468	32	3	j	int
    //   16	3	4	bool	boolean
    //   83	392	5	localObject	Object
    //   134	211	6	arrayOfInt	int[]
    //   140	7	7	localEGLDisplay	EGLDisplay
    // Exception table:
    //   from	to	target	type
    //   26	60	63	java/lang/Exception
    //   80	122	63	java/lang/Exception
    //   125	246	63	java/lang/Exception
    //   249	273	63	java/lang/Exception
    //   277	329	63	java/lang/Exception
    //   332	381	63	java/lang/Exception
    //   384	420	63	java/lang/Exception
    //   420	433	63	java/lang/Exception
    //   433	456	63	java/lang/Exception
    //   459	514	63	java/lang/Exception
    //   2	18	75	finally
    //   26	60	75	finally
    //   64	72	75	finally
    //   80	122	75	finally
    //   125	246	75	finally
    //   249	273	75	finally
    //   277	329	75	finally
    //   332	381	75	finally
    //   384	420	75	finally
    //   420	433	75	finally
    //   433	456	75	finally
    //   459	514	75	finally
    //   26	60	517	java/lang/Error
    //   80	122	517	java/lang/Error
    //   125	246	517	java/lang/Error
    //   249	273	517	java/lang/Error
    //   277	329	517	java/lang/Error
    //   332	381	517	java/lang/Error
    //   384	420	517	java/lang/Error
    //   420	433	517	java/lang/Error
    //   433	456	517	java/lang/Error
    //   459	514	517	java/lang/Error
  }
  
  /* Error */
  private void release(Surface paramSurface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 257	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   6: aload_1
    //   7: ifnonnull +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 73	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 261	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +17 -> 38
    //   24: aload_0
    //   25: getfield 73	com/tencent/tav/decoder/RenderContext:videoTextureMap	Ljava/util/HashMap;
    //   28: aload_1
    //   29: invokevirtual 265	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 267	com/tencent/tav/decoder/VideoTexture
    //   35: invokevirtual 269	com/tencent/tav/decoder/VideoTexture:release	()V
    //   38: aload_1
    //   39: invokevirtual 272	android/view/Surface:release	()V
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
    //   11: ldc_w 318
    //   14: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokestatic 155	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   20: invokevirtual 159	java/lang/Thread:getId	()J
    //   23: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 322	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_1
    //   33: ifnonnull +6 -> 39
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: getfield 75	com/tencent/tav/decoder/RenderContext:activeSurfaceCache	Ljava/util/HashMap;
    //   43: aload_1
    //   44: invokevirtual 265	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 324	java/lang/String
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic 330	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +14 -> 69
    //   58: aload_0
    //   59: getfield 77	com/tencent/tav/decoder/RenderContext:freeSurfaceCache	Ljava/util/HashMap;
    //   62: aload_2
    //   63: invokevirtual 261	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   66: ifne +3 -> 69
    //   69: aload_0
    //   70: getfield 82	com/tencent/tav/decoder/RenderContext:releasingSurfaceCache	Ljava/util/List;
    //   73: aload_1
    //   74: invokeinterface 333 2 0
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
    //   3: invokespecial 257	com/tencent/tav/decoder/RenderContext:checkThread	()V
    //   6: aload_0
    //   7: getfield 62	com/tencent/tav/decoder/RenderContext:released	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   22: aload_0
    //   23: getfield 246	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   26: aload_0
    //   27: getfield 246	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   30: aload_0
    //   31: getfield 234	com/tencent/tav/decoder/RenderContext:_eglContext	Landroid/opengl/EGLContext;
    //   34: invokestatic 362	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   37: ifne -22 -> 15
    //   40: ldc_w 364
    //   43: invokestatic 185	com/tencent/tav/decoder/RenderContext:checkEglError	(Ljava/lang/String;)V
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
          Logger.e("RenderContext", "release: ", localException);
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          Logger.e("RenderContext", "release: ", localError);
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
  @android.support.annotation.RequiresApi(api=18)
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
    //   22: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   25: aload_0
    //   26: getfield 246	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   29: ldc2_w 425
    //   32: lload_1
    //   33: lmul
    //   34: invokestatic 432	android/opengl/EGLExt:eglPresentationTimeANDROID	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;J)Z
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
    //   3: invokespecial 257	com/tencent/tav/decoder/RenderContext:checkThread	()V
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
    //   22: getfield 207	com/tencent/tav/decoder/RenderContext:eglDisplay	Landroid/opengl/EGLDisplay;
    //   25: aload_0
    //   26: getfield 246	com/tencent/tav/decoder/RenderContext:eglSurface	Landroid/opengl/EGLSurface;
    //   29: invokestatic 437	android/opengl/EGL14:eglSwapBuffers	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContext
 * JD-Core Version:    0.7.0.1
 */