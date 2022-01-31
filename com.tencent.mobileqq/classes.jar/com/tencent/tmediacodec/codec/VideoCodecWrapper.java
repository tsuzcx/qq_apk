package com.tencent.tmediacodec.codec;

import android.media.MediaCodec;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/VideoCodecWrapper;", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "codec", "Landroid/media/MediaCodec;", "format", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "(Landroid/media/MediaCodec;Lcom/tencent/tmediacodec/codec/FormatWrapper;)V", "canReuse", "Lcom/tencent/tmediacodec/reuse/ReuseHelper$ReuseType;", "newFormat", "dequeueInputBuffer", "", "timeoutUs", "", "isNeedKeep", "", "toString", "", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class VideoCodecWrapper
  extends ReuseCodecWrapper
{
  public VideoCodecWrapper(@NotNull MediaCodec paramMediaCodec, @NotNull FormatWrapper paramFormatWrapper)
  {
    super(paramMediaCodec, paramFormatWrapper);
  }
  
  @NotNull
  public ReuseHelper.ReuseType canReuse(@NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "newFormat");
    if ((ReuseHelper.isSeamlessAdaptationSupported$default(ReuseHelper.INSTANCE, (ReuseCodecWrapper)this, paramFormatWrapper, false, 4, null)) && (paramFormatWrapper.getWidth() <= getCodecMaxValues().getWidth()) && (paramFormatWrapper.getHeight() <= getCodecMaxValues().getHeight()) && (TUtils.INSTANCE.getMaxInputSize((ReuseCodecWrapper)this, paramFormatWrapper) <= getCodecMaxValues().getInputSize()))
    {
      if (paramFormatWrapper.initializationDataEquals(getFormat())) {
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
      }
      return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;
    }
    return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
  }
  
  public int dequeueInputBuffer(long paramLong)
  {
    LogUtils.INSTANCE.v("ReuseCodecWrapper", "dequeueInputBuffer decodeState:" + getDecodeState());
    return super.dequeueInputBuffer(paramLong);
  }
  
  public boolean isNeedKeep()
  {
    return (super.isNeedKeep()) && (getMSurface() != null) && (getFormat().getRotationDegrees() == 0);
  }
  
  @NotNull
  public String toString()
  {
    return "VideoCodecWrapper[" + hashCode() + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.VideoCodecWrapper
 * JD-Core Version:    0.7.0.1
 */