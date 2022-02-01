package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPCodecUtils;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.tmediacodec.TMediaCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@RequiresApi(api=16)
public abstract class TPBaseMediaCodecDecoder
  implements ITPMediaCodecDecoder
{
  private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
  private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 2000L;
  private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 2000L;
  private static final int MSG_FLUSH = 1002;
  private static final int MSG_RELEASE = 1003;
  private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
  private static final int MSG_SET_OUTPUT_SURFACE = 1001;
  public static boolean forceRelease = false;
  private TMediaCodec mCodec = null;
  protected int mCodecId;
  private MediaCodec.CryptoInfo mCryptoInfo = null;
  private HandlerThread mDecodeThread = null;
  private TPBaseMediaCodecDecoder.AsyncDecodeHandler mDecoderHandler = null;
  protected int mDolbyVisionLevel = 0;
  protected int mDolbyVisionProfile = 0;
  protected int mDrmType = -1;
  protected boolean mEnableAsyncMode = false;
  private boolean mEnableAudioPassThrough = false;
  protected boolean mEnableMediaCodecReuse = false;
  private boolean mEnableSetOutputSurfaceApi = false;
  private TPFrameInfo mFrameInfo = new TPFrameInfo();
  private int mHandlerResult = 0;
  private BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
  protected MediaCrypto mMediaCrypto = null;
  private BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
  private boolean mRestartCodecOnException = false;
  private boolean mStarted = false;
  protected Surface mSurface = null;
  private final Object mThreadLock = new Object();
  
  public TPBaseMediaCodecDecoder(int paramInt)
  {
    this.mCodecId = paramInt;
  }
  
  @RequiresApi(api=21)
  private int decodeAsync(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    Object localObject1 = (Integer)this.mInputQueue.poll();
    if (localObject1 == null) {
      return 1;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = this.mCodec.getInputBuffer(((Integer)localObject1).intValue());
        if (localObject2 != null) {
          ((ByteBuffer)localObject2).put(paramArrayOfByte);
        }
        int j;
        if ((paramBoolean2) && (this.mCryptoInfo != null))
        {
          paramArrayOfByte = this.mCodec;
          j = ((Integer)localObject1).intValue();
          localObject1 = this.mCryptoInfo;
          if (paramBoolean1)
          {
            i = 1;
            paramArrayOfByte.queueSecureInputBuffer(j, 0, (MediaCodec.CryptoInfo)localObject1, paramLong, i);
            return 0;
          }
        }
        else
        {
          localObject2 = this.mCodec;
          j = ((Integer)localObject1).intValue();
          int k = paramArrayOfByte.length;
          if (!paramBoolean1) {
            break label156;
          }
          i = 1;
          ((TMediaCodec)localObject2).queueInputBuffer(j, 0, k, paramLong, i);
          return 0;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return onMediaCodecException(paramArrayOfByte);
      }
      int i = 0;
      continue;
      label156:
      i = 0;
    }
  }
  
  private TPFrameInfo dequeueOutputBufferAsync()
  {
    this.mFrameInfo.errCode = 1;
    TPFrameInfo localTPFrameInfo2 = (TPFrameInfo)this.mOutputQueue.poll();
    TPFrameInfo localTPFrameInfo1 = localTPFrameInfo2;
    if (localTPFrameInfo2 == null) {
      localTPFrameInfo1 = this.mFrameInfo;
    }
    return localTPFrameInfo1;
  }
  
  private void exitDecodeThread()
  {
    if (this.mDecodeThread != null)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        this.mDecodeThread.quitSafely();
      } else {
        this.mDecodeThread.quit();
      }
      try
      {
        this.mDecodeThread.join();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  private int flushAsync()
  {
    TPNativeLog.printLog(2, getLogTag(), "flushAsync: ");
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1002;
    return waitingForHandleMessage(localMessage);
  }
  
  /* Error */
  private int forceHandleRelease()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +6 -> 12
    //   9: bipush 101
    //   11: ireturn
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 73	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mStarted	Z
    //   17: aload_1
    //   18: invokevirtual 252	com/tencent/tmediacodec/TMediaCodec:stop	()V
    //   21: goto +44 -> 65
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 225	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:getLogTag	()Ljava/lang/String;
    //   29: astore_2
    //   30: new 254	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: ldc_w 257
    //   42: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 265	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:getStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   52: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: iconst_4
    //   57: aload_2
    //   58: aload_3
    //   59: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 233	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   69: invokevirtual 271	com/tencent/tmediacodec/TMediaCodec:release	()V
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_1
    //   80: goto +51 -> 131
    //   83: astore_1
    //   84: aload_0
    //   85: invokevirtual 225	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:getLogTag	()Ljava/lang/String;
    //   88: astore_2
    //   89: new 254	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   96: astore_3
    //   97: aload_3
    //   98: ldc_w 273
    //   101: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 265	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:getStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   111: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: iconst_4
    //   116: aload_2
    //   117: aload_3
    //   118: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 233	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   129: iconst_3
    //   130: ireturn
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	TPBaseMediaCodecDecoder
    //   4	14	1	localTMediaCodec	TMediaCodec
    //   24	25	1	localException1	Exception
    //   79	1	1	localObject	Object
    //   83	54	1	localException2	Exception
    //   29	88	2	str	String
    //   37	81	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	21	24	java/lang/Exception
    //   65	72	79	finally
    //   84	124	79	finally
    //   65	72	83	java/lang/Exception
  }
  
  private int handleFlush()
  {
    TPNativeLog.printLog(2, getLogTag(), "handleFlush: ");
    TMediaCodec localTMediaCodec = this.mCodec;
    if (localTMediaCodec == null) {
      return 104;
    }
    try
    {
      localTMediaCodec.flush();
      return 0;
    }
    catch (Exception localException)
    {
      return onMediaCodecException(localException);
    }
  }
  
  private void handleMessageComplete(int paramInt)
  {
    this.mHandlerResult = paramInt;
    this.mThreadLock.notify();
  }
  
  private int handleRelease()
  {
    String str = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRelease:");
    localStringBuilder.append(forceRelease);
    TPNativeLog.printLog(4, str, localStringBuilder.toString());
    if (forceRelease) {
      return forceHandleRelease();
    }
    return originHandleRelease();
  }
  
  private int handleReleaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    TMediaCodec localTMediaCodec = this.mCodec;
    if ((localTMediaCodec != null) && (paramInt >= 0)) {
      try
      {
        localTMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
        return 0;
      }
      catch (Exception localException)
      {
        return onMediaCodecException(localException);
      }
    }
    return 3;
  }
  
  private int handleSetOutputSurface(Surface paramSurface)
  {
    Object localObject = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOutputSurface: ");
    localStringBuilder.append(paramSurface);
    TPNativeLog.printLog(2, (String)localObject, localStringBuilder.toString());
    localObject = this.mSurface;
    int i = 0;
    if (localObject == paramSurface)
    {
      TPNativeLog.printLog(3, getLogTag(), "setOutputSurface: set the same surface.");
      return 0;
    }
    this.mSurface = paramSurface;
    if (this.mCodec != null)
    {
      if ((localObject != null) && (paramSurface != null)) {
        try
        {
          if ((paramSurface.isValid()) && (Build.VERSION.SDK_INT >= 23) && (this.mEnableSetOutputSurfaceApi))
          {
            this.mCodec.setOutputSurface(paramSurface);
            return 0;
          }
        }
        catch (Exception paramSurface)
        {
          localObject = getLogTag();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setOutputSurface onMediaCodecException:\n");
          localStringBuilder.append(getStackTrace(paramSurface));
          TPNativeLog.printLog(4, (String)localObject, localStringBuilder.toString());
          return 3;
        }
      }
      i = 3;
    }
    return i;
  }
  
  private int handleSignalEndOfStream(int paramInt)
  {
    try
    {
      this.mCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
      return 0;
    }
    catch (Exception localException)
    {
      String str = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSignalEndOfStream: failed!");
      localStringBuilder.append(getStackTrace(localException));
      TPNativeLog.printLog(4, str, localStringBuilder.toString());
    }
    return 3;
  }
  
  private boolean initMediaCodecInternal()
  {
    for (;;)
    {
      try
      {
        if (getMimeType().equals("audio/vnd.dts"))
        {
          str = getLogTag();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initMediaCodec current mime type:");
          ((StringBuilder)localObject).append(getMimeType());
          ((StringBuilder)localObject).append(" is audio dts, need set input timeout to 0!");
          TPNativeLog.printLog(2, str, ((StringBuilder)localObject).toString());
          MEDIA_CODEC_INPUT_TIMEOUT_US = 0L;
          MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0L;
        }
        String str = getLogTag();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initMediaCodec mime:");
        ((StringBuilder)localObject).append(getMimeType());
        ((StringBuilder)localObject).append(" profile:");
        ((StringBuilder)localObject).append(this.mDolbyVisionProfile);
        ((StringBuilder)localObject).append(" level:");
        ((StringBuilder)localObject).append(this.mDolbyVisionLevel);
        ((StringBuilder)localObject).append(" mDrmType:");
        ((StringBuilder)localObject).append(this.mDrmType);
        TPNativeLog.printLog(2, str, ((StringBuilder)localObject).toString());
        if (this.mMediaCrypto != null)
        {
          bool1 = this.mMediaCrypto.requiresSecureDecoderComponent(getMimeType());
          boolean bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (TPCodecUtils.isInDRMLevel1Blacklist(this.mDrmType))
            {
              str = getLogTag();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Device ");
              ((StringBuilder)localObject).append(Build.MODEL);
              ((StringBuilder)localObject).append(" DrmType ");
              ((StringBuilder)localObject).append(this.mDrmType);
              ((StringBuilder)localObject).append(" fallback to L3.");
              TPNativeLog.printLog(2, str, ((StringBuilder)localObject).toString());
              bool2 = false;
            }
          }
          if (this.mDolbyVisionProfile > 0) {
            str = TPCodecUtils.getDolbyVisionDecoderName(getMimeType(), this.mDolbyVisionProfile, this.mDolbyVisionLevel, bool2);
          } else {
            str = TPCodecUtils.getDecoderName(getMimeType(), bool2);
          }
          localObject = getLogTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initMediaCodec codecName:");
          localStringBuilder.append(str);
          localStringBuilder.append(" secureComponent ");
          localStringBuilder.append(bool2);
          TPNativeLog.printLog(2, (String)localObject, localStringBuilder.toString());
          if (str == null)
          {
            TPNativeLog.printLog(4, getLogTag(), "initMediaCodec failed, codecName is null.");
            return false;
          }
          this.mCodec = TMediaCodec.createByCodecName(str);
          localObject = this.mCodec;
          if ((!this.mEnableMediaCodecReuse) || (this.mEnableAsyncMode)) {
            break label794;
          }
          bool1 = true;
          ((TMediaCodec)localObject).setReuseEnable(bool1);
          this.mCodec.setCodecCallback(new TPBaseMediaCodecDecoder.1(this));
          localObject = getLogTag();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initMediaCodec codec name: ");
          localStringBuilder.append(str);
          TPNativeLog.printLog(2, (String)localObject, localStringBuilder.toString());
          if ((this.mEnableAsyncMode) && (Build.VERSION.SDK_INT >= 23))
          {
            TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode！");
            this.mDecodeThread = new HandlerThread("MediaCodecThread");
            this.mDecodeThread.start();
            this.mDecoderHandler = new TPBaseMediaCodecDecoder.AsyncDecodeHandler(this, this.mDecodeThread.getLooper());
            this.mCodec.setCallback(new TPBaseMediaCodecDecoder.BufferCallback(this, null), this.mDecoderHandler);
          }
          configCodec(this.mCodec);
          this.mCodec.start();
          this.mStarted = true;
          if (this.mDrmType != -1)
          {
            if (TPCodecUtils.getDecoderName(getMimeType(), true) == null) {
              break label799;
            }
            bool1 = true;
            localObject = new TPMediaDrmInfo();
            ((TPMediaDrmInfo)localObject).supportSecureDecoder = bool1;
            ((TPMediaDrmInfo)localObject).supportSecureDecrypt = bool2;
            ((TPMediaDrmInfo)localObject).componentName = str;
            ((TPMediaDrmInfo)localObject).drmType = this.mDrmType;
            str = getLogTag();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("DRM Info: supportSecureDecoder: ");
            localStringBuilder.append(((TPMediaDrmInfo)localObject).supportSecureDecoder);
            localStringBuilder.append(" supportSecureDecrypt:");
            localStringBuilder.append(((TPMediaDrmInfo)localObject).supportSecureDecrypt);
            localStringBuilder.append(" componentName: ");
            localStringBuilder.append(((TPMediaDrmInfo)localObject).componentName);
            localStringBuilder.append(" drmType: ");
            localStringBuilder.append(((TPMediaDrmInfo)localObject).drmType);
            TPNativeLog.printLog(2, str, localStringBuilder.toString());
            TPMediaCodecManager.onMediaDrmInfo(this.mCodecId, localObject);
          }
          return true;
        }
      }
      catch (Exception localException)
      {
        TPNativeLog.printLog(4, getLogTag(), getStackTrace(localException));
        return false;
      }
      boolean bool1 = false;
      continue;
      label794:
      bool1 = false;
      continue;
      label799:
      bool1 = false;
    }
  }
  
  private int onFlush()
  {
    this.mInputQueue.clear();
    this.mOutputQueue.clear();
    int i = handleFlush();
    this.mCodec.start();
    return i;
  }
  
  private int onMediaCodecException(Exception paramException)
  {
    String str = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMediaCodecException!\n");
    localStringBuilder.append(getStackTrace(paramException));
    TPNativeLog.printLog(4, str, localStringBuilder.toString());
    resetFrameInfo();
    processMediaCodecException(paramException);
    if (this.mRestartCodecOnException)
    {
      initMediaCodecInternal();
      return 4;
    }
    release();
    return 103;
  }
  
  private int onRelease()
  {
    this.mInputQueue.clear();
    this.mOutputQueue.clear();
    return handleRelease();
  }
  
  private int onReleaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    return handleReleaseOutputBuffer(paramInt, paramBoolean);
  }
  
  private int onSetOutputSurface(Surface paramSurface)
  {
    return handleSetOutputSurface(paramSurface);
  }
  
  /* Error */
  private int originHandleRelease()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +6 -> 12
    //   9: bipush 101
    //   11: ireturn
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 73	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mStarted	Z
    //   17: aload_1
    //   18: invokevirtual 252	com/tencent/tmediacodec/TMediaCodec:stop	()V
    //   21: aload_0
    //   22: getfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   25: invokevirtual 271	com/tencent/tmediacodec/TMediaCodec:release	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   33: iconst_0
    //   34: ireturn
    //   35: astore_1
    //   36: goto +51 -> 87
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 225	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:getLogTag	()Ljava/lang/String;
    //   44: astore_2
    //   45: new 254	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   52: astore_3
    //   53: aload_3
    //   54: ldc_w 273
    //   57: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 265	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:getStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   67: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: iconst_4
    //   72: aload_2
    //   73: aload_3
    //   74: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 233	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   85: iconst_3
    //   86: ireturn
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 69	com/tencent/thumbplayer/core/decoder/TPBaseMediaCodecDecoder:mCodec	Lcom/tencent/tmediacodec/TMediaCodec;
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	TPBaseMediaCodecDecoder
    //   4	14	1	localTMediaCodec	TMediaCodec
    //   35	1	1	localObject	Object
    //   39	54	1	localException	Exception
    //   44	29	2	str	String
    //   52	22	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	28	35	finally
    //   40	80	35	finally
    //   17	28	39	java/lang/Exception
  }
  
  private int queueInputBuffer(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    ByteBuffer[] arrayOfByteBuffer = this.mCodec.getInputBuffers();
    try
    {
      int i = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
      if (i >= 0)
      {
        arrayOfByteBuffer[i].put(paramArrayOfByte);
        if ((paramBoolean) && (this.mCryptoInfo != null)) {
          this.mCodec.queueSecureInputBuffer(i, 0, this.mCryptoInfo, paramLong, 0);
        } else {
          this.mCodec.queueInputBuffer(i, 0, paramArrayOfByte.length, paramLong, 0);
        }
        return 0;
      }
      if (i == -1) {
        return 1;
      }
      return 103;
    }
    catch (Exception paramArrayOfByte) {}
    return onMediaCodecException(paramArrayOfByte);
  }
  
  private int releaseAsync()
  {
    TPNativeLog.printLog(2, getLogTag(), "releaseAsync: ");
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1003;
    int i = waitingForHandleMessage(localMessage);
    exitDecodeThread();
    return i;
  }
  
  private int releaseOutputBufferAsync(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void resetFrameInfo()
  {
    TPFrameInfo localTPFrameInfo = this.mFrameInfo;
    localTPFrameInfo.bufferIndex = -1000;
    localTPFrameInfo.ptsUs = -1L;
    localTPFrameInfo.data = null;
    localTPFrameInfo.errCode = 103;
  }
  
  private MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private int setOutputSurfaceAsync(Surface paramSurface)
  {
    Object localObject = getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOutputSurfaceAsync: ");
    localStringBuilder.append(paramSurface);
    TPNativeLog.printLog(2, (String)localObject, localStringBuilder.toString());
    localObject = this.mDecoderHandler.obtainMessage();
    ((Message)localObject).what = 1001;
    ((Message)localObject).obj = paramSurface;
    return waitingForHandleMessage((Message)localObject);
  }
  
  private int signalEndOfStreamAsync()
  {
    Integer localInteger = (Integer)this.mInputQueue.poll();
    if (localInteger == null) {
      return 1;
    }
    return handleSignalEndOfStream(localInteger.intValue());
  }
  
  private int waitingForHandleMessage(Message paramMessage)
  {
    synchronized (this.mThreadLock)
    {
      paramMessage.sendToTarget();
      try
      {
        this.mThreadLock.wait();
      }
      catch (InterruptedException paramMessage)
      {
        paramMessage.printStackTrace();
      }
      return this.mHandlerResult;
    }
  }
  
  abstract void configCodec(@NonNull TMediaCodec paramTMediaCodec);
  
  public int decode(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if ((this.mStarted) && (this.mCodec != null))
    {
      if ((this.mEnableAsyncMode) && (Build.VERSION.SDK_INT >= 23)) {
        return decodeAsync(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
      }
      return queueInputBuffer(paramArrayOfByte, paramLong, paramBoolean2);
    }
    return 101;
  }
  
  public TPFrameInfo dequeueOutputBuffer()
  {
    if (this.mCodec == null) {
      return this.mFrameInfo;
    }
    resetFrameInfo();
    if (this.mEnableAsyncMode) {
      return dequeueOutputBufferAsync();
    }
    Object localObject1 = new MediaCodec.BufferInfo();
    try
    {
      int i = this.mCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, MEDIA_CODEC_OUTPUT_TIMEOUT_US);
      Object localObject2;
      if (i >= 0)
      {
        if (((MediaCodec.BufferInfo)localObject1).flags == 4)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM");
          this.mFrameInfo.errCode = 2;
        }
        else if ((((MediaCodec.BufferInfo)localObject1).flags == 2) && (this.mEnableAudioPassThrough))
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
          localObject2 = this.mFrameInfo;
          ((TPFrameInfo)localObject2).bufferIndex = i;
          ((TPFrameInfo)localObject2).ptsUs = ((MediaCodec.BufferInfo)localObject1).presentationTimeUs;
          processOutputConfigData(this.mCodec, i, (MediaCodec.BufferInfo)localObject1, this.mFrameInfo);
        }
        else
        {
          localObject2 = this.mFrameInfo;
          ((TPFrameInfo)localObject2).bufferIndex = i;
          ((TPFrameInfo)localObject2).ptsUs = ((MediaCodec.BufferInfo)localObject1).presentationTimeUs;
          localObject2 = this.mFrameInfo;
          ((TPFrameInfo)localObject2).errCode = 0;
          processOutputBuffer(this.mCodec, i, (MediaCodec.BufferInfo)localObject1, (TPFrameInfo)localObject2);
        }
      }
      else if (i == -2)
      {
        processOutputFormatChanged(this.mCodec.getOutputFormat());
        this.mFrameInfo.errCode = 1;
      }
      else if (i == -1)
      {
        this.mFrameInfo.errCode = 1;
      }
      else if (i == -3)
      {
        TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
        this.mFrameInfo.errCode = 1;
      }
      else if (((MediaCodec.BufferInfo)localObject1).flags == 4)
      {
        TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM!");
        this.mFrameInfo.errCode = 2;
      }
      else
      {
        localObject1 = getLogTag();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dequeueOutputBuffer: TP_ERROR_DECODE_FAILED! index = ");
        ((StringBuilder)localObject2).append(i);
        TPNativeLog.printLog(4, (String)localObject1, ((StringBuilder)localObject2).toString());
        this.mFrameInfo.errCode = 103;
      }
      return this.mFrameInfo;
    }
    catch (Exception localException)
    {
      this.mFrameInfo.errCode = onMediaCodecException(localException);
    }
    return this.mFrameInfo;
  }
  
  public int flush()
  {
    TPNativeLog.printLog(2, getLogTag(), "flush: ");
    if (this.mCodec == null) {
      return 104;
    }
    if (this.mEnableAsyncMode) {
      return flushAsync();
    }
    return handleFlush();
  }
  
  abstract String getLogTag();
  
  abstract String getMimeType();
  
  protected String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  abstract void processMediaCodecException(Exception paramException);
  
  abstract void processOutputBuffer(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo);
  
  abstract void processOutputConfigData(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo);
  
  abstract void processOutputFormatChanged(@NonNull MediaFormat paramMediaFormat);
  
  public int release()
  {
    if (this.mEnableAsyncMode) {
      return releaseAsync();
    }
    return handleRelease();
  }
  
  public int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if ((this.mCodec != null) && (paramInt >= 0))
    {
      if (this.mEnableAsyncMode) {
        return releaseOutputBufferAsync(paramInt, paramBoolean);
      }
      return handleReleaseOutputBuffer(paramInt, paramBoolean);
    }
    return 3;
  }
  
  public void setCryptoInfo(int paramInt1, @NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, @NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.mCryptoInfo == null) {
      this.mCryptoInfo = new MediaCodec.CryptoInfo();
    }
    this.mCryptoInfo.set(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt2);
  }
  
  public int setOperateRate(float paramFloat)
  {
    if (this.mCodec != null) {}
    try
    {
      if (Build.VERSION.SDK_INT < 19) {
        break label129;
      }
      localObject = getLogTag();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOperateRate: ");
      localStringBuilder.append(paramFloat);
      TPNativeLog.printLog(2, (String)localObject, localStringBuilder.toString());
      localObject = new Bundle();
      ((Bundle)localObject).putShort("priority", (short)0);
      ((Bundle)localObject).putFloat("operating-rate", paramFloat);
      this.mCodec.setParameters((Bundle)localObject);
      return 0;
    }
    catch (Exception localException)
    {
      Object localObject;
      StringBuilder localStringBuilder;
      label85:
      break label85;
    }
    localObject = getLogTag();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOperateRate: ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(" failed.");
    TPNativeLog.printLog(3, (String)localObject, localStringBuilder.toString());
    label129:
    return 0;
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    if (this.mEnableAsyncMode) {
      return setOutputSurfaceAsync(paramSurface);
    }
    return handleSetOutputSurface(paramSurface);
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            str = getLogTag();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown paramKey: ");
            localStringBuilder.append(paramInt);
            TPNativeLog.printLog(3, str, localStringBuilder.toString());
            return false;
          }
          this.mEnableMediaCodecReuse = paramBoolean;
          return true;
        }
        this.mEnableAudioPassThrough = paramBoolean;
        String str = getLogTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BOOL_SET_IS_AUDIO_PASSTHROUGH mEnableAudioPassThrough:");
        localStringBuilder.append(this.mEnableAudioPassThrough);
        TPNativeLog.printLog(2, str, localStringBuilder.toString());
        return true;
      }
      if (!this.mStarted)
      {
        this.mEnableAsyncMode = paramBoolean;
        return true;
      }
      TPNativeLog.printLog(3, getLogTag(), "BOOL_ENABLE_ASYNC_MODE must setup before started!");
      return true;
    }
    this.mEnableSetOutputSurfaceApi = paramBoolean;
    return true;
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public boolean setParamInt(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean setParamLong(int paramInt, long paramLong)
  {
    return false;
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      return true;
    }
    return false;
  }
  
  public boolean setParamString(int paramInt, String paramString)
  {
    return false;
  }
  
  public int signalEndOfStream()
  {
    TPNativeLog.printLog(2, getLogTag(), "signalEndOfStream: ");
    TMediaCodec localTMediaCodec = this.mCodec;
    if (localTMediaCodec == null) {
      return 3;
    }
    if (this.mEnableAsyncMode) {
      return signalEndOfStreamAsync();
    }
    int i = localTMediaCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
    if (i >= 0) {
      return handleSignalEndOfStream(i);
    }
    if (i == -1) {
      return 1;
    }
    return 3;
  }
  
  public boolean startDecoder()
  {
    return initMediaCodecInternal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */