package com.tencent.oskplayer.miscellaneous;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Set;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@TargetApi(17)
public class HardwareDecodeProbe
  implements SurfaceTexture.OnFrameAvailableListener
{
  public static final String TAG;
  private long mDecodeFrameAvgCost = 2147483647L;
  private EGLContext mEglContext;
  private EGLDisplay mEglDisplay;
  private EGLSurface mEglSurface;
  private volatile boolean mFrameAvailable = false;
  private Object mFrameSyncObject = new Object();
  private int mMaxSavedFrame;
  private MediaCodec mMediaDecoder;
  private MediaExtractor mMediaExtractor;
  private MediaFormat mMediaFormat;
  private ByteBuffer mPixelBuf;
  private HardwareDecodeProbe.HwProbeCallback mProbeCallback;
  private TextureRenderer mRenderer;
  private int mSaveHeight = 1024;
  private int mSaveWidth = 512;
  private String mSavedDir;
  private Set<Integer> mSavedFrameSet = new HashSet();
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private int mVideoHeight;
  private int mVideoWidth;
  
  static
  {
    if (!HardwareDecodeProbe.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TAG = HardwareDecodeProbe.class.getSimpleName();
      return;
    }
  }
  
  private int awaitNewImage()
  {
    synchronized (this.mFrameSyncObject)
    {
      boolean bool = this.mFrameAvailable;
      if (!bool) {
        try
        {
          this.mFrameSyncObject.wait(2500L);
          if (!this.mFrameAvailable)
          {
            Logger.g().e(TAG, "[awaitNewImage] frame not available");
            return 10021;
          }
        }
        catch (Exception localException)
        {
          Logger.g().e(TAG, "[awaitNewImage] frame not available, exception occured, " + localException.toString());
          return 10021;
        }
      }
    }
    this.mFrameAvailable = false;
    this.mSurfaceTexture.updateTexImage();
    return 0;
  }
  
  private boolean checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (12288 != i)
    {
      Logger.g().e(TAG, "[checkEglError] " + paramString + ", " + Integer.toHexString(i));
      return true;
    }
    return false;
  }
  
  /* Error */
  private int doExtract(Set<Integer> paramSet)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: iconst_1
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iconst_0
    //   8: istore 4
    //   10: new 152	android/media/MediaCodec$BufferInfo
    //   13: dup
    //   14: invokespecial 153	android/media/MediaCodec$BufferInfo:<init>	()V
    //   17: astore 12
    //   19: iload_3
    //   20: ifne +54 -> 74
    //   23: iload_2
    //   24: aload_0
    //   25: getfield 155	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMaxSavedFrame	I
    //   28: if_icmple +99 -> 127
    //   31: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   34: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   37: new 113	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   44: ldc 157
    //   46: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_2
    //   50: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 162
    //   55: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 155	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMaxSavedFrame	I
    //   62: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokeinterface 165 3 0
    //   73: pop
    //   74: iload_2
    //   75: iconst_1
    //   76: isub
    //   77: ifle +48 -> 125
    //   80: aload_0
    //   81: lload 7
    //   83: iload_2
    //   84: iconst_1
    //   85: isub
    //   86: i2l
    //   87: ldiv
    //   88: putfield 87	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mDecodeFrameAvgCost	J
    //   91: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   94: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   97: new 113	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   104: ldc 167
    //   106: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 87	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mDecodeFrameAvgCost	J
    //   113: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokeinterface 165 3 0
    //   124: pop
    //   125: iconst_0
    //   126: ireturn
    //   127: iload 4
    //   129: istore 5
    //   131: iload 4
    //   133: ifne +111 -> 244
    //   136: aload_0
    //   137: getfield 172	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaDecoder	Landroid/media/MediaCodec;
    //   140: ldc2_w 173
    //   143: invokevirtual 180	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   146: istore 5
    //   148: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   151: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   154: new 113	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   161: ldc 182
    //   163: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload 5
    //   168: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokeinterface 165 3 0
    //   179: pop
    //   180: iload 5
    //   182: iflt +367 -> 549
    //   185: aload_0
    //   186: iload 5
    //   188: invokespecial 186	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   191: astore 13
    //   193: aload_0
    //   194: getfield 188	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaExtractor	Landroid/media/MediaExtractor;
    //   197: aload 13
    //   199: iconst_0
    //   200: invokevirtual 194	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   203: istore 6
    //   205: iload 6
    //   207: ifge +307 -> 514
    //   210: aload_0
    //   211: getfield 172	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaDecoder	Landroid/media/MediaCodec;
    //   214: iload 5
    //   216: iconst_0
    //   217: iconst_0
    //   218: lconst_0
    //   219: iconst_4
    //   220: invokevirtual 198	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   223: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   226: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   229: ldc 200
    //   231: invokeinterface 165 3 0
    //   236: pop
    //   237: iconst_1
    //   238: istore 4
    //   240: iload 4
    //   242: istore 5
    //   244: iload 5
    //   246: istore 4
    //   248: iload_3
    //   249: ifne -230 -> 19
    //   252: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   255: lstore 9
    //   257: aload_0
    //   258: getfield 172	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaDecoder	Landroid/media/MediaCodec;
    //   261: aload 12
    //   263: ldc2_w 173
    //   266: invokevirtual 210	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   269: istore 4
    //   271: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   274: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   277: new 113	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   284: ldc 212
    //   286: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 4
    //   291: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: ldc 214
    //   296: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 12
    //   301: getfield 217	android/media/MediaCodec$BufferInfo:size	I
    //   304: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokeinterface 165 3 0
    //   315: pop
    //   316: iload 4
    //   318: iflt +308 -> 626
    //   321: aload 12
    //   323: getfield 220	android/media/MediaCodec$BufferInfo:flags	I
    //   326: iconst_4
    //   327: iand
    //   328: ifeq +295 -> 623
    //   331: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   334: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   337: ldc 222
    //   339: invokeinterface 165 3 0
    //   344: pop
    //   345: iconst_1
    //   346: istore_3
    //   347: aload 12
    //   349: getfield 217	android/media/MediaCodec$BufferInfo:size	I
    //   352: ifeq +259 -> 611
    //   355: iconst_1
    //   356: istore 11
    //   358: aload_0
    //   359: getfield 172	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaDecoder	Landroid/media/MediaCodec;
    //   362: iload 4
    //   364: iload 11
    //   366: invokevirtual 226	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   369: iload 11
    //   371: ifeq +246 -> 617
    //   374: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   377: lload 9
    //   379: lsub
    //   380: lload 7
    //   382: ladd
    //   383: lstore 9
    //   385: aload_0
    //   386: invokespecial 228	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:awaitNewImage	()I
    //   389: pop
    //   390: aload_0
    //   391: getfield 230	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mRenderer	Lcom/tencent/oskplayer/miscellaneous/TextureRenderer;
    //   394: aload_0
    //   395: getfield 126	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   398: iconst_1
    //   399: invokevirtual 236	com/tencent/oskplayer/miscellaneous/TextureRenderer:drawFrame	(Landroid/graphics/SurfaceTexture;Z)V
    //   402: aload_1
    //   403: iload_2
    //   404: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: invokeinterface 246 2 0
    //   412: ifeq +9 -> 421
    //   415: aload_0
    //   416: iload_2
    //   417: invokespecial 250	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:saveFrame	(I)I
    //   420: pop
    //   421: iload_2
    //   422: iconst_1
    //   423: iadd
    //   424: istore 6
    //   426: iload_3
    //   427: istore 4
    //   429: iload 6
    //   431: istore_2
    //   432: lload 9
    //   434: lstore 7
    //   436: aload_0
    //   437: getfield 252	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mProbeCallback	Lcom/tencent/oskplayer/miscellaneous/HardwareDecodeProbe$HwProbeCallback;
    //   440: ifnull +24 -> 464
    //   443: aload_0
    //   444: getfield 252	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mProbeCallback	Lcom/tencent/oskplayer/miscellaneous/HardwareDecodeProbe$HwProbeCallback;
    //   447: iload 6
    //   449: invokeinterface 258 2 0
    //   454: lload 9
    //   456: lstore 7
    //   458: iload 6
    //   460: istore_2
    //   461: iload_3
    //   462: istore 4
    //   464: iload 4
    //   466: istore_3
    //   467: iload 5
    //   469: istore 4
    //   471: goto -452 -> 19
    //   474: astore_1
    //   475: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   478: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   481: new 113	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 260
    //   491: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 123	java/lang/Exception:toString	()Ljava/lang/String;
    //   498: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokeinterface 111 3 0
    //   509: pop
    //   510: sipush 10026
    //   513: ireturn
    //   514: aload_0
    //   515: getfield 188	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaExtractor	Landroid/media/MediaExtractor;
    //   518: invokevirtual 263	android/media/MediaExtractor:getSampleTime	()J
    //   521: lstore 9
    //   523: aload_0
    //   524: getfield 172	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaDecoder	Landroid/media/MediaCodec;
    //   527: iload 5
    //   529: iconst_0
    //   530: iload 6
    //   532: lload 9
    //   534: iconst_0
    //   535: invokevirtual 198	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   538: aload_0
    //   539: getfield 188	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaExtractor	Landroid/media/MediaExtractor;
    //   542: invokevirtual 266	android/media/MediaExtractor:advance	()Z
    //   545: pop
    //   546: goto -306 -> 240
    //   549: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   552: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   555: ldc_w 268
    //   558: invokeinterface 165 3 0
    //   563: pop
    //   564: iload 4
    //   566: istore 5
    //   568: goto -324 -> 244
    //   571: astore_1
    //   572: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   575: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   578: new 113	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 270
    //   588: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload_1
    //   592: invokevirtual 123	java/lang/Exception:toString	()Ljava/lang/String;
    //   595: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokeinterface 111 3 0
    //   606: pop
    //   607: sipush 10025
    //   610: ireturn
    //   611: iconst_0
    //   612: istore 11
    //   614: goto -256 -> 358
    //   617: iload_3
    //   618: istore 4
    //   620: goto -156 -> 464
    //   623: goto -276 -> 347
    //   626: iload_3
    //   627: istore 4
    //   629: goto -165 -> 464
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	this	HardwareDecodeProbe
    //   0	632	1	paramSet	Set<Integer>
    //   4	457	2	i	int
    //   6	621	3	j	int
    //   8	620	4	k	int
    //   129	438	5	m	int
    //   203	328	6	n	int
    //   1	456	7	l1	long
    //   255	278	9	l2	long
    //   356	257	11	bool	boolean
    //   17	331	12	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   191	7	13	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   136	148	474	java/lang/Exception
    //   257	271	571	java/lang/Exception
  }
  
  private int eglSetup()
  {
    this.mEglDisplay = EGL14.eglGetDisplay(0);
    if ((checkEglError("eglGetDisplay")) || (EGL14.EGL_NO_DISPLAY == this.mEglDisplay))
    {
      Logger.g().e(TAG, "[eglSetup] eglGetDisplay failed");
      return 10003;
    }
    Object localObject = new int[2];
    boolean bool = EGL14.eglInitialize(this.mEglDisplay, (int[])localObject, 0, (int[])localObject, 0);
    if ((checkEglError("eglInitialize")) || (!bool))
    {
      Logger.g().e(TAG, "[eglSetup] eglInitialize failed");
      return 10004;
    }
    Logger.g().d(TAG, "[eglSetup] major version=" + localObject[0] + ", minor version=" + localObject[1]);
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.mEglDisplay;
    int i = localObject.length;
    bool = EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0);
    if ((checkEglError("eglChooseConfig")) || (!bool))
    {
      Logger.g().e(TAG, "[eglSetup] eglChooseConfig failed");
      return 10005;
    }
    Logger.g().d(TAG, "[eglSetup] numConfigs=" + arrayOfInt[0]);
    this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    if ((checkEglError("eglCreateContext")) || (this.mEglContext == null))
    {
      Logger.g().e(TAG, "[eglSetup] eglCreateContext failed");
      return 10006;
    }
    i = this.mSaveWidth;
    int j = this.mSaveHeight;
    this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, localObject[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
    if ((checkEglError("eglCreatePbufferSurface")) || (this.mEglSurface == null))
    {
      Logger.g().e(TAG, "[eglSetup] eglCreatePbufferSurface failed");
      return 10007;
    }
    bool = EGL14.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext);
    if ((checkEglError("eglMakeCurrent")) || (!bool))
    {
      Logger.g().e(TAG, "[eglSetup] eglMakeCurrent failed");
      return 10008;
    }
    Logger.g().d(TAG, "[eglSetup] setup success");
    return 0;
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mMediaDecoder.getInputBuffer(paramInt);
    }
    return this.mMediaDecoder.getInputBuffers()[paramInt];
  }
  
  private int getVideoFormat(String paramString)
  {
    try
    {
      this.mMediaExtractor = new MediaExtractor();
      this.mMediaExtractor.setDataSource(paramString);
      IjkMediaPlayer.loadLibrariesOnce(OskSupport.getLibLoader());
      if (!IjkMediaPlayer.sIsLibLoadSuccess)
      {
        Logger.g().e(TAG, "[getVideoFormat] get MediaFormat failed, lib load=" + IjkMediaPlayer.sIsLibLoadSuccess);
        return 10028;
      }
      paramString = IjkMediaPlayer.getHEVCVideoFormat(paramString);
      if ((paramString == null) || (paramString.videoFormat == null))
      {
        Logger.g().e(TAG, "[getVideoFormat] get MediaFormat failed");
        return 10028;
      }
    }
    catch (Exception paramString)
    {
      Logger.g().e(TAG, "[getVideoFormat] exception, " + paramString.toString());
      return 10002;
    }
    this.mMediaFormat = paramString.videoFormat;
    Logger.g().d(TAG, "[getVideoFormat] video track=" + paramString.videoTrack);
    this.mMediaExtractor.selectTrack(paramString.videoTrack);
    return 0;
  }
  
  private int mediaDecoderSetup(String paramString)
  {
    try
    {
      int i = getVideoFormat(paramString);
      if (i != 0) {
        return i;
      }
      this.mVideoWidth = this.mMediaFormat.getInteger("width");
      this.mVideoHeight = this.mMediaFormat.getInteger("height");
      Logger.g().d(TAG, "[mediaDecoderSetup] video size=" + this.mVideoWidth + "x" + this.mVideoHeight);
      this.mSaveWidth = this.mVideoWidth;
      this.mSaveHeight = this.mVideoHeight;
      this.mMediaDecoder = MediaCodec.createDecoderByType(this.mMediaFormat.getString("mime"));
      if (Build.VERSION.SDK_INT >= 18)
      {
        paramString = this.mMediaDecoder.getCodecInfo();
        Logger.g().e(TAG, "codec name=" + paramString.getName() + "\n");
      }
      Logger.g().d(TAG, "[mediaDecoderSetup] setup success");
      return 0;
    }
    catch (Exception paramString)
    {
      Logger.g().e(TAG, "[mediaDecoderSetup] setup failed, " + paramString.toString());
    }
    return 10010;
  }
  
  /* Error */
  private int saveFrame(int paramInt)
  {
    // Byte code:
    //   0: new 448	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 450	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSavedDir	Ljava/lang/String;
    //   8: invokestatic 456	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   11: ldc_w 458
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_1
    //   21: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 464	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokespecial 467	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 8
    //   33: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   36: lstore_2
    //   37: aload_0
    //   38: getfield 469	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   41: invokevirtual 475	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   44: pop
    //   45: iconst_0
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 76	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveWidth	I
    //   51: aload_0
    //   52: getfield 78	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveHeight	I
    //   55: sipush 6408
    //   58: sipush 5121
    //   61: aload_0
    //   62: getfield 469	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   65: invokestatic 481	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   68: new 483	java/io/BufferedOutputStream
    //   71: dup
    //   72: new 485	java/io/FileOutputStream
    //   75: dup
    //   76: aload 8
    //   78: invokespecial 488	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 491	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore 7
    //   86: aload 7
    //   88: astore 6
    //   90: aload_0
    //   91: getfield 76	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveWidth	I
    //   94: aload_0
    //   95: getfield 78	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveHeight	I
    //   98: getstatic 497	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   101: invokestatic 503	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   104: astore 9
    //   106: aload 7
    //   108: astore 6
    //   110: aload_0
    //   111: getfield 469	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   114: invokevirtual 475	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   117: pop
    //   118: aload 7
    //   120: astore 6
    //   122: aload 9
    //   124: aload_0
    //   125: getfield 469	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   128: invokevirtual 507	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   131: aload 7
    //   133: astore 6
    //   135: aload 9
    //   137: getstatic 513	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   140: bipush 80
    //   142: aload 7
    //   144: invokevirtual 517	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   147: pop
    //   148: aload 7
    //   150: astore 6
    //   152: aload 9
    //   154: invokevirtual 520	android/graphics/Bitmap:recycle	()V
    //   157: aload 7
    //   159: astore 6
    //   161: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   164: lstore 4
    //   166: aload 7
    //   168: astore 6
    //   170: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   173: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   176: new 113	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 522
    //   186: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: lload 4
    //   191: lload_2
    //   192: lsub
    //   193: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: ldc_w 524
    //   199: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 8
    //   204: invokevirtual 527	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   207: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokeinterface 165 3 0
    //   218: pop
    //   219: aload 7
    //   221: ifnull +8 -> 229
    //   224: aload 7
    //   226: invokevirtual 530	java/io/BufferedOutputStream:close	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore 6
    //   233: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   236: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   239: new 113	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 532
    //   249: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 6
    //   254: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokeinterface 538 3 0
    //   265: pop
    //   266: iconst_0
    //   267: ireturn
    //   268: astore 8
    //   270: aconst_null
    //   271: astore 7
    //   273: aload 7
    //   275: astore 6
    //   277: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   280: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   283: new 113	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 540
    //   293: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 8
    //   298: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokeinterface 538 3 0
    //   309: pop
    //   310: aload 7
    //   312: ifnull -83 -> 229
    //   315: aload 7
    //   317: invokevirtual 530	java/io/BufferedOutputStream:close	()V
    //   320: iconst_0
    //   321: ireturn
    //   322: astore 6
    //   324: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   327: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   330: new 113	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 532
    //   340: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 6
    //   345: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokeinterface 538 3 0
    //   356: pop
    //   357: iconst_0
    //   358: ireturn
    //   359: astore 7
    //   361: aconst_null
    //   362: astore 6
    //   364: aload 6
    //   366: ifnull +8 -> 374
    //   369: aload 6
    //   371: invokevirtual 530	java/io/BufferedOutputStream:close	()V
    //   374: aload 7
    //   376: athrow
    //   377: astore 6
    //   379: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   382: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   385: new 113	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 532
    //   395: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 6
    //   400: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokeinterface 538 3 0
    //   411: pop
    //   412: goto -38 -> 374
    //   415: astore 7
    //   417: goto -53 -> 364
    //   420: astore 8
    //   422: goto -149 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	HardwareDecodeProbe
    //   0	425	1	paramInt	int
    //   36	156	2	l1	long
    //   164	26	4	l2	long
    //   88	81	6	localBufferedOutputStream1	java.io.BufferedOutputStream
    //   231	22	6	localException1	Exception
    //   275	1	6	localBufferedOutputStream2	java.io.BufferedOutputStream
    //   322	22	6	localException2	Exception
    //   362	8	6	localObject1	Object
    //   377	22	6	localException3	Exception
    //   84	232	7	localBufferedOutputStream3	java.io.BufferedOutputStream
    //   359	16	7	localObject2	Object
    //   415	1	7	localObject3	Object
    //   31	172	8	localFile	java.io.File
    //   268	29	8	localException4	Exception
    //   420	1	8	localException5	Exception
    //   104	49	9	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   224	229	231	java/lang/Exception
    //   68	86	268	java/lang/Exception
    //   315	320	322	java/lang/Exception
    //   68	86	359	finally
    //   369	374	377	java/lang/Exception
    //   90	106	415	finally
    //   110	118	415	finally
    //   122	131	415	finally
    //   135	148	415	finally
    //   152	157	415	finally
    //   161	166	415	finally
    //   170	219	415	finally
    //   277	310	415	finally
    //   90	106	420	java/lang/Exception
    //   110	118	420	java/lang/Exception
    //   122	131	420	java/lang/Exception
    //   135	148	420	java/lang/Exception
    //   152	157	420	java/lang/Exception
    //   161	166	420	java/lang/Exception
    //   170	219	420	java/lang/Exception
  }
  
  private int surfaceSetup()
  {
    this.mRenderer = new TextureRenderer();
    int i = this.mRenderer.createTexture();
    if (i != 0)
    {
      Logger.g().e(TAG, "[surfaceSetup] surfaceSetup failed, " + i);
      return i;
    }
    this.mSurfaceTexture = new SurfaceTexture(this.mRenderer.getTextureId());
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mPixelBuf = ByteBuffer.allocateDirect(this.mSaveWidth * this.mSaveHeight * 4);
    this.mPixelBuf.order(ByteOrder.LITTLE_ENDIAN);
    Logger.g().d(TAG, "[surfaceSetup] surfaceSetup success");
    return 0;
  }
  
  public long getDecodeFrameAvgCost()
  {
    return this.mDecodeFrameAvgCost;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.mFrameSyncObject)
    {
      if (this.mFrameAvailable)
      {
        Logger.g().e(TAG, "[onFrameAvailable] mFrameAvailable already set, frame could be dropped");
        this.mFrameAvailable = false;
        this.mFrameSyncObject.notifyAll();
      }
      this.mFrameAvailable = true;
      this.mFrameSyncObject.notifyAll();
      return;
    }
  }
  
  /* Error */
  public int probe(@android.support.annotation.NonNull String paramString1, @android.support.annotation.NonNull String paramString2, Set<Integer> paramSet)
  {
    // Byte code:
    //   0: getstatic 344	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 17
    //   5: if_icmpge +11 -> 16
    //   8: sipush 10001
    //   11: istore 4
    //   13: iload 4
    //   15: ireturn
    //   16: aload_1
    //   17: invokestatic 593	com/tencent/oskplayer/support/util/OskFile:isLocalFile	(Ljava/lang/String;)Z
    //   20: ifeq +53 -> 73
    //   23: new 448	java/io/File
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 595	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: invokevirtual 598	java/io/File:canRead	()Z
    //   34: ifne +39 -> 73
    //   37: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   40: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   43: new 113	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 600
    //   53: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokeinterface 111 3 0
    //   68: pop
    //   69: sipush 10002
    //   72: ireturn
    //   73: new 448	java/io/File
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 595	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore 6
    //   83: aload 6
    //   85: invokevirtual 603	java/io/File:exists	()Z
    //   88: ifne +15 -> 103
    //   91: aload 6
    //   93: invokevirtual 606	java/io/File:mkdirs	()Z
    //   96: ifne +7 -> 103
    //   99: sipush 10023
    //   102: ireturn
    //   103: aload_0
    //   104: aload_2
    //   105: putfield 450	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSavedDir	Ljava/lang/String;
    //   108: aload_0
    //   109: aload_1
    //   110: invokespecial 608	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mediaDecoderSetup	(Ljava/lang/String;)I
    //   113: istore 5
    //   115: iload 5
    //   117: istore 4
    //   119: iload 5
    //   121: ifne -108 -> 13
    //   124: aload_0
    //   125: invokespecial 610	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:eglSetup	()I
    //   128: istore 5
    //   130: iload 5
    //   132: istore 4
    //   134: iload 5
    //   136: ifne -123 -> 13
    //   139: aload_0
    //   140: invokespecial 612	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:surfaceSetup	()I
    //   143: istore 5
    //   145: iload 5
    //   147: istore 4
    //   149: iload 5
    //   151: ifne -138 -> 13
    //   154: aload_3
    //   155: invokeinterface 616 1 0
    //   160: astore_1
    //   161: aload_1
    //   162: invokeinterface 621 1 0
    //   167: ifeq +42 -> 209
    //   170: aload_1
    //   171: invokeinterface 625 1 0
    //   176: checkcast 144	java/lang/Integer
    //   179: astore_2
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 155	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMaxSavedFrame	I
    //   185: aload_2
    //   186: invokevirtual 628	java/lang/Integer:intValue	()I
    //   189: invokestatic 634	java/lang/Math:max	(II)I
    //   192: putfield 155	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMaxSavedFrame	I
    //   195: aload_0
    //   196: getfield 83	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSavedFrameSet	Ljava/util/Set;
    //   199: aload_2
    //   200: invokeinterface 637 2 0
    //   205: pop
    //   206: goto -45 -> 161
    //   209: getstatic 60	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:$assertionsDisabled	Z
    //   212: ifne +18 -> 230
    //   215: aload_0
    //   216: getfield 559	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSurface	Landroid/view/Surface;
    //   219: ifnonnull +11 -> 230
    //   222: new 639	java/lang/AssertionError
    //   225: dup
    //   226: invokespecial 640	java/lang/AssertionError:<init>	()V
    //   229: athrow
    //   230: aload_0
    //   231: getfield 172	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaDecoder	Landroid/media/MediaCodec;
    //   234: aload_0
    //   235: getfield 391	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaFormat	Landroid/media/MediaFormat;
    //   238: aload_0
    //   239: getfield 559	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSurface	Landroid/view/Surface;
    //   242: aconst_null
    //   243: iconst_0
    //   244: invokevirtual 644	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   247: aload_0
    //   248: getfield 172	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mMediaDecoder	Landroid/media/MediaCodec;
    //   251: invokevirtual 647	android/media/MediaCodec:start	()V
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 83	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSavedFrameSet	Ljava/util/Set;
    //   259: invokespecial 649	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:doExtract	(Ljava/util/Set;)I
    //   262: istore 4
    //   264: aload_0
    //   265: invokevirtual 652	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:release	()V
    //   268: iload 4
    //   270: ireturn
    //   271: astore_1
    //   272: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   275: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   278: new 113	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 654
    //   288: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_1
    //   292: invokevirtual 123	java/lang/Exception:toString	()Ljava/lang/String;
    //   295: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokeinterface 111 3 0
    //   306: pop
    //   307: aload_0
    //   308: invokevirtual 652	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:release	()V
    //   311: sipush 10024
    //   314: ireturn
    //   315: astore_1
    //   316: invokestatic 103	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   319: getstatic 66	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   322: new 113	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 656
    //   332: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: invokevirtual 123	java/lang/Exception:toString	()Ljava/lang/String;
    //   339: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokeinterface 111 3 0
    //   350: pop
    //   351: sipush 10027
    //   354: istore 4
    //   356: goto -92 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	HardwareDecodeProbe
    //   0	359	1	paramString1	String
    //   0	359	2	paramString2	String
    //   0	359	3	paramSet	Set<Integer>
    //   11	344	4	i	int
    //   113	37	5	j	int
    //   81	11	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   230	247	271	java/lang/Exception
    //   254	264	315	java/lang/Exception
  }
  
  public void release()
  {
    if (this.mEglDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
      EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEglDisplay);
    }
    this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEglContext = EGL14.EGL_NO_CONTEXT;
    this.mEglSurface = EGL14.EGL_NO_SURFACE;
    this.mSurface.release();
    if (this.mMediaDecoder != null)
    {
      this.mMediaDecoder.stop();
      this.mMediaDecoder.release();
    }
    if (this.mMediaExtractor != null) {
      this.mMediaExtractor.release();
    }
  }
  
  public void setProbeCallback(HardwareDecodeProbe.HwProbeCallback paramHwProbeCallback)
  {
    this.mProbeCallback = paramHwProbeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.HardwareDecodeProbe
 * JD-Core Version:    0.7.0.1
 */