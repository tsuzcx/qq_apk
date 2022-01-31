package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.CodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/TMediaCodec;", "Lcom/tencent/tmediacodec/IMediaCodec;", "nameOrType", "", "(Ljava/lang/String;)V", "<set-?>", "Lcom/tencent/tmediacodec/callback/CodecCallback;", "codecCallback", "getCodecCallback", "()Lcom/tencent/tmediacodec/callback/CodecCallback;", "Lcom/tencent/tmediacodec/codec/CodecWrapper;", "codecWrapper", "getCodecWrapper", "()Lcom/tencent/tmediacodec/codec/CodecWrapper;", "isReUsed", "", "isReUsed$tmediacodec_lib_debug", "()Z", "setReUsed$tmediacodec_lib_debug", "(Z)V", "isVideo", "mConfigureCalled", "getNameOrType", "()Ljava/lang/String;", "configure", "", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "", "descrambler", "Landroid/media/MediaDescrambler;", "dequeueInputBuffer", "timeoutUs", "", "dequeueOutputBuffer", "info", "Landroid/media/MediaCodec$BufferInfo;", "flush", "getInputBuffer", "Ljava/nio/ByteBuffer;", "index", "getInputBuffers", "", "kotlin.jvm.PlatformType", "()[Ljava/nio/ByteBuffer;", "getOutputBuffer", "getOutputBuffers", "getOutputFormat", "queueInputBuffer", "offset", "size", "presentationTimeUs", "queueSecureInputBuffer", "Landroid/media/MediaCodec$CryptoInfo;", "release", "releaseOutputBuffer", "render", "renderTimestampNs", "reset", "setCallback", "cb", "Lcom/tencent/tmediacodec/TMediaCodec$Callback;", "handler", "Landroid/os/Handler;", "setCodecCallback", "setOutputSurface", "setVideoScalingMode", "mode", "start", "stop", "Callback", "Companion", "HookCallback", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class TMediaCodec
  implements IMediaCodec
{
  public static final TMediaCodec.Companion Companion = new TMediaCodec.Companion(null);
  public static final int ERROR_CODEC_NULL = -1000;
  @NotNull
  public static final String TAG = "TMediaCodec";
  @org.jetbrains.annotations.Nullable
  private CodecCallback codecCallback;
  @org.jetbrains.annotations.Nullable
  private CodecWrapper codecWrapper;
  private boolean isReUsed;
  private boolean mConfigureCalled;
  @NotNull
  private final String nameOrType;
  
  private TMediaCodec(String paramString)
  {
    this.nameOrType = paramString;
  }
  
  @JvmStatic
  @NotNull
  public static final TMediaCodec createByCodecName(@NotNull String paramString)
  {
    return Companion.createByCodecName(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final TMediaCodec createDecoderByType(@NotNull String paramString)
  {
    return Companion.createDecoderByType(paramString);
  }
  
  @TargetApi(26)
  public void configure(@NotNull MediaFormat paramMediaFormat, @org.jetbrains.annotations.Nullable Surface paramSurface, int paramInt, @org.jetbrains.annotations.Nullable MediaDescrambler paramMediaDescrambler)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    if (this.mConfigureCalled) {
      LogUtils.w$default(LogUtils.INSTANCE, "TMediaCodec", "configure ignored, mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " flags:" + paramInt + " descrambler:" + paramMediaDescrambler + " stack:" + Log.getStackTraceString(new Throwable()), null, 4, null);
    }
    do
    {
      return;
      this.mConfigureCalled = true;
      LogUtils.INSTANCE.d("TMediaCodec", "configure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " flags:" + paramInt + " descrambler:" + paramMediaDescrambler);
      this.codecWrapper = TCodecManager.Companion.getInstance().configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler, this);
      paramMediaFormat = this.codecWrapper;
      if (paramMediaFormat != null) {
        paramMediaFormat.setCodecCallback(this.codecCallback);
      }
      paramMediaFormat = this.codecCallback;
    } while (paramMediaFormat == null);
    paramMediaFormat.onCreate(this.isReUsed);
  }
  
  public void configure(@NotNull MediaFormat paramMediaFormat, @org.jetbrains.annotations.Nullable Surface paramSurface, @org.jetbrains.annotations.Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    if (this.mConfigureCalled) {
      LogUtils.w$default(LogUtils.INSTANCE, "TMediaCodec", "configure ignored, mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:" + paramInt + " stack:" + Log.getStackTraceString(new Throwable()), null, 4, null);
    }
    do
    {
      return;
      this.mConfigureCalled = true;
      LogUtils.INSTANCE.d("TMediaCodec", "configure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:" + paramInt);
      this.codecWrapper = TCodecManager.Companion.getInstance().configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt, this);
      paramMediaFormat = this.codecWrapper;
      if (paramMediaFormat != null) {
        paramMediaFormat.setCodecCallback(this.codecCallback);
      }
      paramMediaFormat = this.codecCallback;
    } while (paramMediaFormat == null);
    paramMediaFormat.onCreate(this.isReUsed);
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      return localCodecWrapper.dequeueInputBuffer(paramLong);
    }
    return -1000;
  }
  
  public final int dequeueOutputBuffer(@NotNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferInfo, "info");
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      return localCodecWrapper.dequeueOutputBuffer(paramBufferInfo, paramLong);
    }
    return -1000;
  }
  
  public final void flush()
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.flush();
    }
  }
  
  @org.jetbrains.annotations.Nullable
  public final CodecCallback getCodecCallback()
  {
    return this.codecCallback;
  }
  
  @org.jetbrains.annotations.Nullable
  public final CodecWrapper getCodecWrapper()
  {
    return this.codecWrapper;
  }
  
  @TargetApi(21)
  @androidx.annotation.Nullable
  @org.jetbrains.annotations.Nullable
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        return ((MediaCodec)localObject).getInputBuffer(paramInt);
      }
    }
    return null;
  }
  
  @NonNull
  @org.jetbrains.annotations.Nullable
  public final ByteBuffer[] getInputBuffers()
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        return ((MediaCodec)localObject).getInputBuffers();
      }
    }
    return null;
  }
  
  @NotNull
  public final String getNameOrType()
  {
    return this.nameOrType;
  }
  
  @TargetApi(21)
  @androidx.annotation.Nullable
  @org.jetbrains.annotations.Nullable
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        return ((MediaCodec)localObject).getOutputBuffer(paramInt);
      }
    }
    return null;
  }
  
  @NonNull
  @org.jetbrains.annotations.Nullable
  public final ByteBuffer[] getOutputBuffers()
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        return ((MediaCodec)localObject).getOutputBuffers();
      }
    }
    return null;
  }
  
  @NonNull
  @org.jetbrains.annotations.Nullable
  public final MediaFormat getOutputFormat()
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        return ((MediaCodec)localObject).getOutputFormat();
      }
    }
    return null;
  }
  
  public final boolean isReUsed$tmediacodec_lib_debug()
  {
    return this.isReUsed;
  }
  
  public final boolean isVideo()
  {
    return TUtils.INSTANCE.isVideo(this.nameOrType);
  }
  
  public final void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
    }
  }
  
  public final void queueSecureInputBuffer(int paramInt1, int paramInt2, @NonNull @NotNull MediaCodec.CryptoInfo paramCryptoInfo, long paramLong, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramCryptoInfo, "info");
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        ((MediaCodec)localObject).queueSecureInputBuffer(paramInt1, paramInt2, paramCryptoInfo, paramLong, paramInt3);
      }
    }
  }
  
  public void release()
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.release();
    }
  }
  
  @TargetApi(21)
  public void releaseOutputBuffer(int paramInt, long paramLong)
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.releaseOutputBuffer(paramInt, paramLong);
    }
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.releaseOutputBuffer(paramInt, paramBoolean);
    }
  }
  
  @TargetApi(21)
  public void reset()
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.reset();
    }
  }
  
  @TargetApi(21)
  public final void setCallback(@org.jetbrains.annotations.Nullable TMediaCodec.Callback paramCallback)
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        ((MediaCodec)localObject).setCallback((MediaCodec.Callback)new TMediaCodec.HookCallback(this, paramCallback));
      }
    }
  }
  
  @TargetApi(23)
  public final void setCallback(@androidx.annotation.Nullable @NotNull TMediaCodec.Callback paramCallback, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Handler paramHandler)
  {
    Intrinsics.checkParameterIsNotNull(paramCallback, "cb");
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        ((MediaCodec)localObject).setCallback((MediaCodec.Callback)new TMediaCodec.HookCallback(this, paramCallback), paramHandler);
      }
    }
  }
  
  public final void setCodecCallback(@org.jetbrains.annotations.Nullable CodecCallback paramCodecCallback)
  {
    this.codecCallback = paramCodecCallback;
  }
  
  @TargetApi(23)
  public final void setOutputSurface(@NonNull @NotNull Surface paramSurface)
  {
    Intrinsics.checkParameterIsNotNull(paramSurface, "surface");
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.setOutputSurface(paramSurface);
    }
  }
  
  public final void setReUsed$tmediacodec_lib_debug(boolean paramBoolean)
  {
    this.isReUsed = paramBoolean;
  }
  
  public final void setVideoScalingMode(int paramInt)
  {
    Object localObject = this.codecWrapper;
    if (localObject != null)
    {
      localObject = ((CodecWrapper)localObject).getMediaCodec();
      if (localObject != null) {
        ((MediaCodec)localObject).setVideoScalingMode(paramInt);
      }
    }
  }
  
  public void start()
  {
    LogUtils.INSTANCE.d("TMediaCodec", "start codecWrapper:" + this.codecWrapper);
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.start();
    }
  }
  
  public void stop()
  {
    CodecWrapper localCodecWrapper = this.codecWrapper;
    if (localCodecWrapper != null) {
      localCodecWrapper.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec
 * JD-Core Version:    0.7.0.1
 */