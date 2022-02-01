package com.tencent.tmediacodec.reuse;

import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;

public final class ReuseHelper
{
  public static final String TAG = "ReuseHelper";
  
  @NonNull
  public static ReuseHelper.AdaptationWorkaroundMode codecAdaptationWorkaroundMode(@NonNull String paramString)
  {
    if ((Build.VERSION.SDK_INT <= 25) && ("OMX.Exynos.avc.dec.secure" == paramString) && ((Build.MODEL.startsWith("SM-T585")) || (Build.MODEL.startsWith("SM-A510")) || (Build.MODEL.startsWith("SM-A520")) || (Build.MODEL.startsWith("SM-J700")))) {
      return ReuseHelper.AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_ALWAYS;
    }
    if ((Build.VERSION.SDK_INT < 24) && (("OMX.Nvidia.h264.decode" == paramString) || ("OMX.Nvidia.h264.decode.secure" == paramString)) && (("flounder" == Build.DEVICE) || ("flounder_lte" == Build.DEVICE) || ("grouper" == Build.DEVICE) || ("tilapia" == Build.DEVICE))) {
      return ReuseHelper.AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;
    }
    return ReuseHelper.AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_NEVER;
  }
  
  public static void initFormatWrapper(@NonNull FormatWrapper paramFormatWrapper, @NonNull MediaFormat paramMediaFormat)
  {
    ReusePolicy localReusePolicy = TCodecManager.getInstance().getReusePolicy();
    int i = Math.max(localReusePolicy.initWidth, paramFormatWrapper.width);
    int j = Math.max(localReusePolicy.initHeight, paramFormatWrapper.height);
    if (localReusePolicy.reConfigByRealFormat)
    {
      localReusePolicy.initWidth = i;
      localReusePolicy.initHeight = j;
    }
    int k = Math.max(0, TUtils.getCodecMaxInputSize(paramFormatWrapper.sampleMimeType, i, j, false));
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseHelper", "initFormatWrapper initWidth:" + i + " initHeight:" + j + " initMaxInputSize:" + k + ' ' + "reusePolicy:" + localReusePolicy);
    }
    paramFormatWrapper.maxWidth = i;
    paramFormatWrapper.maxHeight = j;
    paramFormatWrapper.maxInputSize = k;
    paramMediaFormat.setInteger("max-input-size", Math.max(k, 0));
    if ((paramFormatWrapper.isVideo()) && (Build.VERSION.SDK_INT >= 19))
    {
      paramMediaFormat.setInteger("max-width", i);
      paramMediaFormat.setInteger("max-height", j);
    }
  }
  
  public static boolean isSeamlessAdaptationSupported(@NonNull ReuseCodecWrapper paramReuseCodecWrapper, @NonNull FormatWrapper paramFormatWrapper)
  {
    return isSeamlessAdaptationSupported(paramReuseCodecWrapper, paramFormatWrapper, false);
  }
  
  public static boolean isSeamlessAdaptationSupported(@NonNull ReuseCodecWrapper paramReuseCodecWrapper, @NonNull FormatWrapper paramFormatWrapper, boolean paramBoolean)
  {
    FormatWrapper localFormatWrapper = paramReuseCodecWrapper.format;
    if ((paramReuseCodecWrapper instanceof VideoCodecWrapper)) {
      if ((!TextUtils.equals(localFormatWrapper.sampleMimeType, paramFormatWrapper.sampleMimeType)) || (localFormatWrapper.rotationDegrees != paramFormatWrapper.rotationDegrees) || ((!paramReuseCodecWrapper.adaptive) && ((localFormatWrapper.width != paramFormatWrapper.width) || (localFormatWrapper.height != paramFormatWrapper.height)))) {}
    }
    while (!(paramReuseCodecWrapper instanceof AudioCodecWrapper))
    {
      return true;
      return false;
    }
    return (TextUtils.equals("audio/mp4a-latm", localFormatWrapper.sampleMimeType)) && (TextUtils.equals(localFormatWrapper.sampleMimeType, paramFormatWrapper.sampleMimeType)) && (localFormatWrapper.channelCount == paramFormatWrapper.channelCount) && (localFormatWrapper.sampleRate == paramFormatWrapper.sampleRate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.reuse.ReuseHelper
 * JD-Core Version:    0.7.0.1
 */