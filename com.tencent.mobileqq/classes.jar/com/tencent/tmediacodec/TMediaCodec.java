package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.CodecWrapper;
import com.tencent.tmediacodec.statistics.MediaCodecStatistics;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TMediaCodec
  implements IMediaCodec
{
  public static final String TAG = "TMediaCodec";
  @Nullable
  private CodecCallback codecCallback;
  public boolean codecFinalReuseEnable;
  @Nullable
  private CodecWrapper codecWrapper;
  private TMediaCodec.CreateBy createBy;
  public boolean isReUsed;
  private final MediaCodecStatistics mCodecStatistics;
  private boolean mConfigureCalled;
  @NonNull
  private final String nameOrType;
  private boolean reUseEnable = true;
  
  private TMediaCodec(String paramString, TMediaCodec.CreateBy paramCreateBy)
  {
    this.nameOrType = paramString;
    this.createBy = paramCreateBy;
    this.mCodecStatistics = new MediaCodecStatistics(isVideo());
  }
  
  public static TMediaCodec createByCodecName(@NonNull String paramString)
  {
    return new TMediaCodec(paramString, TMediaCodec.CreateBy.CreateByName);
  }
  
  public static TMediaCodec createDecoderByType(@NonNull String paramString)
  {
    return new TMediaCodec(paramString, TMediaCodec.CreateBy.CreateByType);
  }
  
  private void onAfterConfigure()
  {
    this.mCodecStatistics.configCodecEnd(this.isReUsed);
    ThreadManager.postOnSubThread(new TMediaCodec.1(this));
  }
  
  private void onAfterStart()
  {
    this.mCodecStatistics.startCodecEnd();
    ThreadManager.postOnSubThread(new TMediaCodec.2(this));
  }
  
  private void onBeforeConfigure(Surface paramSurface)
  {
    this.codecFinalReuseEnable = TCodecManager.getInstance().reuseEnable(this, paramSurface);
    this.mCodecStatistics.createByCodecStart();
    this.mCodecStatistics.createByCodecEnd();
    this.mCodecStatistics.configCodecStart(this.codecFinalReuseEnable);
  }
  
  private void onBeforeStart()
  {
    this.mCodecStatistics.startCodecStart();
  }
  
  @TargetApi(26)
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    if (this.mConfigureCalled)
    {
      LogUtils.w("TMediaCodec", "configure ignored, mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " flags:" + paramInt + " descrambler:" + paramMediaDescrambler + " stack:" + Log.getStackTraceString(new Throwable()));
      return;
    }
    this.mConfigureCalled = true;
    onBeforeConfigure(paramSurface);
    try
    {
      this.codecWrapper = TCodecManager.getInstance().configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler, this);
      onAfterConfigure();
      return;
    }
    catch (IOException paramSurface)
    {
      for (;;)
      {
        LogUtils.e("TMediaCodec", "createCodec mediaFormat:" + paramMediaFormat, paramSurface);
      }
    }
  }
  
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    if (this.mConfigureCalled)
    {
      LogUtils.w("TMediaCodec", "configure ignored, mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:" + paramInt + " stack:" + Log.getStackTraceString(new Throwable()));
      return;
    }
    this.mConfigureCalled = true;
    onBeforeConfigure(paramSurface);
    try
    {
      this.codecWrapper = TCodecManager.getInstance().configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt, this);
      onAfterConfigure();
      return;
    }
    catch (IOException paramSurface)
    {
      for (;;)
      {
        LogUtils.e("TMediaCodec", "createCodec mediaFormat:" + paramMediaFormat, paramSurface);
      }
    }
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    if (this.codecWrapper != null) {
      return this.codecWrapper.dequeueInputBuffer(paramLong);
    }
    return -1000;
  }
  
  public final int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    if (this.codecWrapper != null) {
      return this.codecWrapper.dequeueOutputBuffer(paramBufferInfo, paramLong);
    }
    return -1000;
  }
  
  public final void flush()
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.flush();
    }
  }
  
  public final CodecCallback getCodecCallback()
  {
    return this.codecCallback;
  }
  
  @Nullable
  public final CodecWrapper getCodecWrapper()
  {
    return this.codecWrapper;
  }
  
  public TMediaCodec.CreateBy getCreateBy()
  {
    return this.createBy;
  }
  
  @TargetApi(21)
  @Nullable
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    if (this.codecWrapper != null) {
      return this.codecWrapper.getMediaCodec().getInputBuffer(paramInt);
    }
    return null;
  }
  
  @NonNull
  @Nullable
  public final ByteBuffer[] getInputBuffers()
  {
    if (this.codecWrapper != null)
    {
      MediaCodec localMediaCodec = this.codecWrapper.getMediaCodec();
      if (localMediaCodec != null) {
        return localMediaCodec.getInputBuffers();
      }
    }
    return null;
  }
  
  @NonNull
  public final String getNameOrType()
  {
    return this.nameOrType;
  }
  
  @TargetApi(21)
  @Nullable
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    if (this.codecWrapper != null)
    {
      MediaCodec localMediaCodec = this.codecWrapper.getMediaCodec();
      if (localMediaCodec != null) {
        return localMediaCodec.getOutputBuffer(paramInt);
      }
    }
    return null;
  }
  
  @NonNull
  @Nullable
  public final ByteBuffer[] getOutputBuffers()
  {
    if (this.codecWrapper != null)
    {
      MediaCodec localMediaCodec = this.codecWrapper.getMediaCodec();
      if (localMediaCodec != null) {
        return localMediaCodec.getOutputBuffers();
      }
    }
    return null;
  }
  
  @NonNull
  @Nullable
  public final MediaFormat getOutputFormat()
  {
    if (this.codecWrapper != null)
    {
      MediaCodec localMediaCodec = this.codecWrapper.getMediaCodec();
      if (localMediaCodec != null) {
        return localMediaCodec.getOutputFormat();
      }
    }
    return null;
  }
  
  public final boolean isReuseEnable()
  {
    return this.reUseEnable;
  }
  
  public final boolean isVideo()
  {
    return TUtils.isVideo(this.nameOrType);
  }
  
  public final void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
    }
  }
  
  public final void queueSecureInputBuffer(int paramInt1, int paramInt2, @NonNull MediaCodec.CryptoInfo paramCryptoInfo, long paramLong, int paramInt3)
  {
    if (this.codecWrapper != null)
    {
      MediaCodec localMediaCodec = this.codecWrapper.getMediaCodec();
      if (localMediaCodec != null) {
        localMediaCodec.queueSecureInputBuffer(paramInt1, paramInt2, paramCryptoInfo, paramLong, paramInt3);
      }
    }
  }
  
  public void release()
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.release();
    }
  }
  
  @TargetApi(21)
  public void releaseOutputBuffer(int paramInt, long paramLong)
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.releaseOutputBuffer(paramInt, paramLong);
    }
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.releaseOutputBuffer(paramInt, paramBoolean);
    }
  }
  
  @TargetApi(21)
  public void reset()
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.reset();
    }
  }
  
  @TargetApi(21)
  public final void setCallback(@Nullable TMediaCodec.Callback paramCallback)
  {
    if (Build.VERSION.SDK_INT < 21) {
      LogUtils.w("TMediaCodec", "ignore method setCallback for API lower than 21");
    }
    MediaCodec localMediaCodec;
    do
    {
      do
      {
        return;
      } while (this.codecWrapper == null);
      localMediaCodec = this.codecWrapper.getMediaCodec();
    } while (localMediaCodec == null);
    localMediaCodec.setCallback(new TMediaCodec.HookCallback(this, paramCallback));
  }
  
  @TargetApi(23)
  public final void setCallback(@NonNull TMediaCodec.Callback paramCallback, @Nullable Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT < 23) {
      LogUtils.w("TMediaCodec", "ignore method setCallback for API lower than 23");
    }
    MediaCodec localMediaCodec;
    do
    {
      do
      {
        return;
      } while (this.codecWrapper == null);
      localMediaCodec = this.codecWrapper.getMediaCodec();
    } while (localMediaCodec == null);
    localMediaCodec.setCallback(new TMediaCodec.HookCallback(this, paramCallback), paramHandler);
  }
  
  public final void setCodecCallback(@Nullable CodecCallback paramCodecCallback)
  {
    this.codecCallback = paramCodecCallback;
  }
  
  @TargetApi(23)
  public final void setOutputSurface(@NonNull Surface paramSurface)
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.setOutputSurface(paramSurface);
    }
  }
  
  @TargetApi(19)
  public void setParameters(@Nullable Bundle paramBundle)
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        ((MediaCodec)localObject).setParameters(paramBundle);
      }
    }
  }
  
  public final void setReuseEnable(boolean paramBoolean)
  {
    this.reUseEnable = paramBoolean;
  }
  
  public final void setVideoScalingMode(int paramInt)
  {
    if (this.codecWrapper != null)
    {
      MediaCodec localMediaCodec = this.codecWrapper.getMediaCodec();
      if (localMediaCodec != null) {
        localMediaCodec.setVideoScalingMode(paramInt);
      }
    }
  }
  
  public void start()
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TMediaCodec", "start codecWrapper:" + this.codecWrapper);
    }
    onBeforeStart();
    if (this.codecWrapper != null) {
      this.codecWrapper.start();
    }
    onAfterStart();
  }
  
  public void stop()
  {
    if (this.codecWrapper != null) {
      this.codecWrapper.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec
 * JD-Core Version:    0.7.0.1
 */