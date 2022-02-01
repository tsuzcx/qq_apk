package com.tencent.oskplayer.miscellaneous;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@TargetApi(17)
public class HardwareDecodeProbe
  implements SurfaceTexture.OnFrameAvailableListener
{
  public static final String TAG = "HardwareDecodeProbe";
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
          ILogger localILogger = Logger.g();
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[awaitNewImage] frame not available, exception occured, ");
          localStringBuilder.append(localException.toString());
          localILogger.e(str, localStringBuilder.toString());
          return 10021;
        }
      }
      this.mFrameAvailable = false;
      this.mSurfaceTexture.updateTexImage();
      return 0;
    }
  }
  
  private boolean checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (12288 != i)
    {
      ILogger localILogger = Logger.g();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkEglError] ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ");
      localStringBuilder.append(Integer.toHexString(i));
      localILogger.e(str, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private int doExtract(Set<Integer> paramSet)
  {
    Object localObject1 = new MediaCodec.BufferInfo();
    long l1 = 0L;
    int i = 0;
    int k = 1;
    Object localObject2;
    int n;
    for (int m = 0; i == 0; m = n)
    {
      for (;;)
      {
        if (k > this.mMaxSavedFrame)
        {
          paramSet = Logger.g();
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[doExtract] reach max save frame, decodeCount=");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(", mMaxSavedFrame=");
          ((StringBuilder)localObject2).append(this.mMaxSavedFrame);
          paramSet.d((String)localObject1, ((StringBuilder)localObject2).toString());
          break label688;
        }
        n = m;
        int j;
        Object localObject3;
        StringBuilder localStringBuilder;
        long l2;
        if (m == 0) {
          try
          {
            j = this.mMediaDecoder.dequeueInputBuffer(10000L);
            localObject2 = Logger.g();
            localObject3 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[doExtract] input index=");
            localStringBuilder.append(j);
            ((ILogger)localObject2).d((String)localObject3, localStringBuilder.toString());
            if (j >= 0)
            {
              localObject2 = getInputBuffer(j);
              n = this.mMediaExtractor.readSampleData((ByteBuffer)localObject2, 0);
              if (n < 0)
              {
                this.mMediaDecoder.queueInputBuffer(j, 0, 0, 0L, 4);
                Logger.g().d(TAG, "[doExtract] queue input EOS");
                n = 1;
              }
              else
              {
                l2 = this.mMediaExtractor.getSampleTime();
                this.mMediaDecoder.queueInputBuffer(j, 0, n, l2, 0);
                this.mMediaExtractor.advance();
                n = m;
              }
            }
            else
            {
              Logger.g().d(TAG, "[doExtract] input buffer not available");
              n = m;
            }
          }
          catch (Exception paramSet)
          {
            localObject1 = Logger.g();
            localObject2 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[doExtract] dequeueInputBuffer error");
            ((StringBuilder)localObject3).append(paramSet.toString());
            ((ILogger)localObject1).e((String)localObject2, ((StringBuilder)localObject3).toString());
            return 10026;
          }
        }
        m = i;
        if (i == 0)
        {
          l2 = System.currentTimeMillis();
          try
          {
            int i1 = this.mMediaDecoder.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, 10000L);
            localObject2 = Logger.g();
            localObject3 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[doExtract] output index=");
            localStringBuilder.append(i1);
            localStringBuilder.append(", buffer size=");
            localStringBuilder.append(((MediaCodec.BufferInfo)localObject1).size);
            ((ILogger)localObject2).d((String)localObject3, localStringBuilder.toString());
            m = i;
            if (i1 >= 0)
            {
              j = i;
              if ((((MediaCodec.BufferInfo)localObject1).flags & 0x4) != 0)
              {
                Logger.g().d(TAG, "[doExtract] output EOS");
                j = 1;
              }
              boolean bool;
              if (((MediaCodec.BufferInfo)localObject1).size != 0) {
                bool = true;
              } else {
                bool = false;
              }
              this.mMediaDecoder.releaseOutputBuffer(i1, bool);
              m = j;
              if (bool)
              {
                l2 = l1 + (System.currentTimeMillis() - l2);
                awaitNewImage();
                this.mRenderer.drawFrame(this.mSurfaceTexture, true);
                if (paramSet.contains(Integer.valueOf(k))) {
                  saveFrame(k);
                }
                i1 = k + 1;
                localObject2 = this.mProbeCallback;
                i = j;
                k = i1;
                m = n;
                l1 = l2;
                if (localObject2 == null) {
                  break;
                }
                ((HardwareDecodeProbe.HwProbeCallback)localObject2).onHwProbeOneFrame(i1);
                i = j;
                k = i1;
                m = n;
                l1 = l2;
              }
            }
          }
          catch (Exception paramSet)
          {
            localObject1 = Logger.g();
            localObject2 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[doExtract] dequeueOutputBuffer error");
            ((StringBuilder)localObject3).append(paramSet.toString());
            ((ILogger)localObject1).e((String)localObject2, ((StringBuilder)localObject3).toString());
            return 10025;
          }
        }
      }
      i = m;
    }
    label688:
    i = k - 1;
    if (i > 0)
    {
      this.mDecodeFrameAvgCost = (l1 / i);
      paramSet = Logger.g();
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[doExtract] decode frame avgCost=");
      ((StringBuilder)localObject2).append(this.mDecodeFrameAvgCost);
      paramSet.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    return 0;
  }
  
  private int eglSetup()
  {
    this.mEglDisplay = EGL14.eglGetDisplay(0);
    if (!checkEglError("eglGetDisplay"))
    {
      Object localObject1 = EGL14.EGL_NO_DISPLAY;
      Object localObject2 = this.mEglDisplay;
      if (localObject1 != localObject2)
      {
        localObject1 = new int[2];
        boolean bool = EGL14.eglInitialize((EGLDisplay)localObject2, (int[])localObject1, 0, (int[])localObject1, 0);
        if ((!checkEglError("eglInitialize")) && (bool))
        {
          localObject2 = Logger.g();
          Object localObject3 = TAG;
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[eglSetup] major version=");
          ((StringBuilder)localObject4).append(localObject1[0]);
          ((StringBuilder)localObject4).append(", minor version=");
          ((StringBuilder)localObject4).append(localObject1[1]);
          ((ILogger)localObject2).d((String)localObject3, ((StringBuilder)localObject4).toString());
          localObject1 = new EGLConfig[1];
          localObject2 = new int[1];
          localObject3 = this.mEglDisplay;
          int i = localObject1.length;
          bool = EGL14.eglChooseConfig((EGLDisplay)localObject3, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject1, 0, i, (int[])localObject2, 0);
          if ((!checkEglError("eglChooseConfig")) && (bool))
          {
            localObject3 = Logger.g();
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[eglSetup] numConfigs=");
            localStringBuilder.append(localObject2[0]);
            ((ILogger)localObject3).d((String)localObject4, localStringBuilder.toString());
            this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, localObject1[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
            if ((!checkEglError("eglCreateContext")) && (this.mEglContext != null))
            {
              i = this.mSaveWidth;
              int j = this.mSaveHeight;
              this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, localObject1[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
              if (!checkEglError("eglCreatePbufferSurface"))
              {
                localObject1 = this.mEglSurface;
                if (localObject1 != null)
                {
                  bool = EGL14.eglMakeCurrent(this.mEglDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, this.mEglContext);
                  if ((!checkEglError("eglMakeCurrent")) && (bool))
                  {
                    Logger.g().d(TAG, "[eglSetup] setup success");
                    return 0;
                  }
                  Logger.g().e(TAG, "[eglSetup] eglMakeCurrent failed");
                  return 10008;
                }
              }
              Logger.g().e(TAG, "[eglSetup] eglCreatePbufferSurface failed");
              return 10007;
            }
            Logger.g().e(TAG, "[eglSetup] eglCreateContext failed");
            return 10006;
          }
          Logger.g().e(TAG, "[eglSetup] eglChooseConfig failed");
          return 10005;
        }
        Logger.g().e(TAG, "[eglSetup] eglInitialize failed");
        return 10004;
      }
    }
    Logger.g().e(TAG, "[eglSetup] eglGetDisplay failed");
    return 10003;
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
        paramString = Logger.g();
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getVideoFormat] get MediaFormat failed, lib load=");
        ((StringBuilder)localObject2).append(IjkMediaPlayer.sIsLibLoadSuccess);
        paramString.e((String)localObject1, ((StringBuilder)localObject2).toString());
        return 10028;
      }
      paramString = IjkMediaPlayer.getHEVCVideoFormat(paramString);
      if ((paramString != null) && (paramString.videoFormat != null))
      {
        this.mMediaFormat = paramString.videoFormat;
        localObject1 = Logger.g();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getVideoFormat] video track=");
        localStringBuilder.append(paramString.videoTrack);
        ((ILogger)localObject1).d((String)localObject2, localStringBuilder.toString());
        this.mMediaExtractor.selectTrack(paramString.videoTrack);
        return 0;
      }
      Logger.g().e(TAG, "[getVideoFormat] get MediaFormat failed");
      return 10028;
    }
    catch (Exception paramString)
    {
      Object localObject1 = Logger.g();
      Object localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getVideoFormat] exception, ");
      localStringBuilder.append(paramString.toString());
      ((ILogger)localObject1).e((String)localObject2, localStringBuilder.toString());
    }
    return 10002;
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
      paramString = Logger.g();
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[mediaDecoderSetup] video size=");
      ((StringBuilder)localObject2).append(this.mVideoWidth);
      ((StringBuilder)localObject2).append("x");
      ((StringBuilder)localObject2).append(this.mVideoHeight);
      paramString.d((String)localObject1, ((StringBuilder)localObject2).toString());
      this.mSaveWidth = this.mVideoWidth;
      this.mSaveHeight = this.mVideoHeight;
      this.mMediaDecoder = MediaCodec.createDecoderByType(this.mMediaFormat.getString("mime"));
      if (Build.VERSION.SDK_INT >= 18)
      {
        paramString = this.mMediaDecoder.getCodecInfo();
        localObject1 = Logger.g();
        localObject2 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("codec name=");
        localStringBuilder.append(paramString.getName());
        localStringBuilder.append("\n");
        ((ILogger)localObject1).e((String)localObject2, localStringBuilder.toString());
      }
      Logger.g().d(TAG, "[mediaDecoderSetup] setup success");
      return 0;
    }
    catch (Exception paramString)
    {
      Object localObject1 = Logger.g();
      Object localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[mediaDecoderSetup] setup failed, ");
      localStringBuilder.append(paramString.toString());
      ((ILogger)localObject1).e((String)localObject2, localStringBuilder.toString());
    }
    return 10010;
  }
  
  /* Error */
  private int saveFrame(int paramInt)
  {
    // Byte code:
    //   0: new 441	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 443	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSavedDir	Ljava/lang/String;
    //   8: invokestatic 449	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   11: ldc_w 451
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_1
    //   21: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 457	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokespecial 460	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 8
    //   33: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   36: lstore_2
    //   37: aload_0
    //   38: getfield 462	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   41: invokevirtual 468	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   44: pop
    //   45: iconst_0
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 65	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveWidth	I
    //   51: aload_0
    //   52: getfield 67	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveHeight	I
    //   55: sipush 6408
    //   58: sipush 5121
    //   61: aload_0
    //   62: getfield 462	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   65: invokestatic 474	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   68: new 476	java/io/BufferedOutputStream
    //   71: dup
    //   72: new 478	java/io/FileOutputStream
    //   75: dup
    //   76: aload 8
    //   78: invokespecial 481	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 484	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore 7
    //   86: aload 7
    //   88: astore 6
    //   90: aload_0
    //   91: getfield 65	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveWidth	I
    //   94: aload_0
    //   95: getfield 67	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mSaveHeight	I
    //   98: getstatic 490	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   101: invokestatic 496	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   104: astore 9
    //   106: aload 7
    //   108: astore 6
    //   110: aload_0
    //   111: getfield 462	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   114: invokevirtual 468	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   117: pop
    //   118: aload 7
    //   120: astore 6
    //   122: aload 9
    //   124: aload_0
    //   125: getfield 462	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:mPixelBuf	Ljava/nio/ByteBuffer;
    //   128: invokevirtual 500	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   131: aload 7
    //   133: astore 6
    //   135: aload 9
    //   137: getstatic 506	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   140: bipush 80
    //   142: aload 7
    //   144: invokevirtual 510	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   147: pop
    //   148: aload 7
    //   150: astore 6
    //   152: aload 9
    //   154: invokevirtual 513	android/graphics/Bitmap:recycle	()V
    //   157: aload 7
    //   159: astore 6
    //   161: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   164: lstore 4
    //   166: aload 7
    //   168: astore 6
    //   170: invokestatic 92	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   173: astore 9
    //   175: aload 7
    //   177: astore 6
    //   179: getstatic 94	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   182: astore 10
    //   184: aload 7
    //   186: astore 6
    //   188: new 104	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   195: astore 11
    //   197: aload 7
    //   199: astore 6
    //   201: aload 11
    //   203: ldc_w 515
    //   206: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 7
    //   212: astore 6
    //   214: aload 11
    //   216: lload 4
    //   218: lload_2
    //   219: lsub
    //   220: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 7
    //   226: astore 6
    //   228: aload 11
    //   230: ldc_w 517
    //   233: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 7
    //   239: astore 6
    //   241: aload 11
    //   243: aload 8
    //   245: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   248: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 7
    //   254: astore 6
    //   256: aload 9
    //   258: aload 10
    //   260: aload 11
    //   262: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokeinterface 157 3 0
    //   270: pop
    //   271: aload 7
    //   273: invokevirtual 523	java/io/BufferedOutputStream:close	()V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore 9
    //   280: invokestatic 92	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   283: astore 6
    //   285: getstatic 94	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   288: astore 7
    //   290: new 104	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   297: astore 8
    //   299: goto +129 -> 428
    //   302: astore 8
    //   304: goto +16 -> 320
    //   307: astore 7
    //   309: aconst_null
    //   310: astore 6
    //   312: goto +152 -> 464
    //   315: astore 8
    //   317: aconst_null
    //   318: astore 7
    //   320: aload 7
    //   322: astore 6
    //   324: invokestatic 92	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   327: astore 9
    //   329: aload 7
    //   331: astore 6
    //   333: getstatic 94	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   336: astore 10
    //   338: aload 7
    //   340: astore 6
    //   342: new 104	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   349: astore 11
    //   351: aload 7
    //   353: astore 6
    //   355: aload 11
    //   357: ldc_w 525
    //   360: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 7
    //   366: astore 6
    //   368: aload 11
    //   370: aload 8
    //   372: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 7
    //   378: astore 6
    //   380: aload 9
    //   382: aload 10
    //   384: aload 11
    //   386: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokeinterface 531 3 0
    //   394: pop
    //   395: aload 7
    //   397: ifnull +63 -> 460
    //   400: aload 7
    //   402: invokevirtual 523	java/io/BufferedOutputStream:close	()V
    //   405: iconst_0
    //   406: ireturn
    //   407: astore 9
    //   409: invokestatic 92	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   412: astore 6
    //   414: getstatic 94	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   417: astore 7
    //   419: new 104	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   426: astore 8
    //   428: aload 8
    //   430: ldc_w 533
    //   433: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 8
    //   439: aload 9
    //   441: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 6
    //   447: aload 7
    //   449: aload 8
    //   451: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokeinterface 531 3 0
    //   459: pop
    //   460: iconst_0
    //   461: ireturn
    //   462: astore 7
    //   464: aload 6
    //   466: ifnull +64 -> 530
    //   469: aload 6
    //   471: invokevirtual 523	java/io/BufferedOutputStream:close	()V
    //   474: goto +56 -> 530
    //   477: astore 6
    //   479: invokestatic 92	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   482: astore 8
    //   484: getstatic 94	com/tencent/oskplayer/miscellaneous/HardwareDecodeProbe:TAG	Ljava/lang/String;
    //   487: astore 9
    //   489: new 104	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   496: astore 10
    //   498: aload 10
    //   500: ldc_w 533
    //   503: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 10
    //   509: aload 6
    //   511: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 8
    //   517: aload 9
    //   519: aload 10
    //   521: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokeinterface 531 3 0
    //   529: pop
    //   530: aload 7
    //   532: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	HardwareDecodeProbe
    //   0	533	1	paramInt	int
    //   36	183	2	l1	long
    //   164	53	4	l2	long
    //   88	382	6	localObject1	Object
    //   477	33	6	localException1	Exception
    //   84	205	7	localObject2	Object
    //   307	1	7	localObject3	Object
    //   318	130	7	str1	String
    //   462	69	7	localObject4	Object
    //   31	267	8	localObject5	Object
    //   302	1	8	localException2	Exception
    //   315	56	8	localException3	Exception
    //   426	90	8	localObject6	Object
    //   104	153	9	localObject7	Object
    //   278	1	9	localException4	Exception
    //   327	54	9	localILogger	ILogger
    //   407	33	9	localException5	Exception
    //   487	31	9	str2	String
    //   182	338	10	localObject8	Object
    //   195	190	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   271	276	278	java/lang/Exception
    //   90	106	302	java/lang/Exception
    //   110	118	302	java/lang/Exception
    //   122	131	302	java/lang/Exception
    //   135	148	302	java/lang/Exception
    //   152	157	302	java/lang/Exception
    //   161	166	302	java/lang/Exception
    //   170	175	302	java/lang/Exception
    //   179	184	302	java/lang/Exception
    //   188	197	302	java/lang/Exception
    //   201	210	302	java/lang/Exception
    //   214	224	302	java/lang/Exception
    //   228	237	302	java/lang/Exception
    //   241	252	302	java/lang/Exception
    //   256	271	302	java/lang/Exception
    //   68	86	307	finally
    //   68	86	315	java/lang/Exception
    //   400	405	407	java/lang/Exception
    //   90	106	462	finally
    //   110	118	462	finally
    //   122	131	462	finally
    //   135	148	462	finally
    //   152	157	462	finally
    //   161	166	462	finally
    //   170	175	462	finally
    //   179	184	462	finally
    //   188	197	462	finally
    //   201	210	462	finally
    //   214	224	462	finally
    //   228	237	462	finally
    //   241	252	462	finally
    //   256	271	462	finally
    //   324	329	462	finally
    //   333	338	462	finally
    //   342	351	462	finally
    //   355	364	462	finally
    //   368	376	462	finally
    //   380	395	462	finally
    //   469	474	477	java/lang/Exception
  }
  
  private int surfaceSetup()
  {
    this.mRenderer = new TextureRenderer();
    int i = this.mRenderer.createTexture();
    if (i != 0)
    {
      ILogger localILogger = Logger.g();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[surfaceSetup] surfaceSetup failed, ");
      localStringBuilder.append(i);
      localILogger.e(str, localStringBuilder.toString());
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
  
  public int probe(@NonNull String paramString1, @NonNull String paramString2, Set<Integer> paramSet)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return 10001;
    }
    if ((OskFile.isLocalFile(paramString1)) && (!new File(paramString1).canRead()))
    {
      paramString2 = Logger.g();
      paramSet = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[decode] file cannot read, ");
      ((StringBuilder)localObject).append(paramString1);
      paramString2.e(paramSet, ((StringBuilder)localObject).toString());
      return 10002;
    }
    Object localObject = new File(paramString2);
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return 10023;
    }
    this.mSavedDir = paramString2;
    int i = mediaDecoderSetup(paramString1);
    if (i != 0) {
      return i;
    }
    i = eglSetup();
    if (i != 0) {
      return i;
    }
    i = surfaceSetup();
    if (i != 0) {
      return i;
    }
    paramString1 = paramSet.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (Integer)paramString1.next();
      this.mMaxSavedFrame = Math.max(this.mMaxSavedFrame, paramString2.intValue());
      this.mSavedFrameSet.add(paramString2);
    }
    try
    {
      this.mMediaDecoder.configure(this.mMediaFormat, this.mSurface, null, 0);
      this.mMediaDecoder.start();
      try
      {
        i = doExtract(this.mSavedFrameSet);
      }
      catch (Exception paramString1)
      {
        paramString2 = Logger.g();
        paramSet = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[probe] doExtract error, ");
        ((StringBuilder)localObject).append(paramString1.toString());
        paramString2.e(paramSet, ((StringBuilder)localObject).toString());
        i = 10027;
      }
      release();
      return i;
    }
    catch (Exception paramString1)
    {
      paramString2 = Logger.g();
      paramSet = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MediaCodec configure failed, ");
      ((StringBuilder)localObject).append(paramString1.toString());
      paramString2.e(paramSet, ((StringBuilder)localObject).toString());
      release();
    }
    return 10024;
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
    Object localObject = this.mMediaDecoder;
    if (localObject != null)
    {
      ((MediaCodec)localObject).stop();
      this.mMediaDecoder.release();
    }
    localObject = this.mMediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).release();
    }
  }
  
  public void setProbeCallback(HardwareDecodeProbe.HwProbeCallback paramHwProbeCallback)
  {
    this.mProbeCallback = paramHwProbeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.HardwareDecodeProbe
 * JD-Core Version:    0.7.0.1
 */