package com.tencent.tmediacodec.codec;

import android.media.MediaCodec;
import android.support.annotation.NonNull;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.util.TUtils;

public final class VideoCodecWrapper
  extends ReuseCodecWrapper
{
  public VideoCodecWrapper(@NonNull MediaCodec paramMediaCodec, @NonNull FormatWrapper paramFormatWrapper)
  {
    super(paramMediaCodec, paramFormatWrapper);
  }
  
  @NonNull
  public ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper paramFormatWrapper)
  {
    if ((ReuseHelper.isSeamlessAdaptationSupported(this, paramFormatWrapper)) && (paramFormatWrapper.width <= this.codecMaxValues.width) && (paramFormatWrapper.height <= this.codecMaxValues.height) && (TUtils.getMaxInputSize(this, paramFormatWrapper) <= this.codecMaxValues.inputSize))
    {
      if (paramFormatWrapper.initializationDataEquals(this.format)) {
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
      }
      return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;
    }
    return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
  }
  
  public boolean isNeedKeep()
  {
    return (super.isNeedKeep()) && (this.mSurface != null) && (this.format.rotationDegrees == 0);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoCodecWrapper[");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.VideoCodecWrapper
 * JD-Core Version:    0.7.0.1
 */