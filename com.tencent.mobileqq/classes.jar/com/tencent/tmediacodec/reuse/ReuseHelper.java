package com.tencent.tmediacodec.reuse;

import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.TCodecManager.Companion;
import com.tencent.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/reuse/ReuseHelper;", "", "()V", "TAG", "", "codecAdaptationWorkaroundMode", "Lcom/tencent/tmediacodec/reuse/ReuseHelper$AdaptationWorkaroundMode;", "name", "initFormatWrapper", "", "format", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "isSeamlessAdaptationSupported", "", "codecWrapper", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "newFormat", "isNewFormatComplete", "AdaptationWorkaroundMode", "ReuseType", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class ReuseHelper
{
  public static final ReuseHelper INSTANCE = new ReuseHelper();
  @NotNull
  public static final String TAG = "ReuseHelper";
  
  @NotNull
  public final ReuseHelper.AdaptationWorkaroundMode codecAdaptationWorkaroundMode(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    if ((Build.VERSION.SDK_INT <= 25) && (Intrinsics.areEqual("OMX.Exynos.avc.dec.secure", paramString)))
    {
      String str = Build.MODEL;
      Intrinsics.checkExpressionValueIsNotNull(str, "Build.MODEL");
      if (!StringsKt.startsWith$default(str, "SM-T585", false, 2, null))
      {
        str = Build.MODEL;
        Intrinsics.checkExpressionValueIsNotNull(str, "Build.MODEL");
        if (!StringsKt.startsWith$default(str, "SM-A510", false, 2, null))
        {
          str = Build.MODEL;
          Intrinsics.checkExpressionValueIsNotNull(str, "Build.MODEL");
          if (!StringsKt.startsWith$default(str, "SM-A520", false, 2, null))
          {
            str = Build.MODEL;
            Intrinsics.checkExpressionValueIsNotNull(str, "Build.MODEL");
            if (!StringsKt.startsWith$default(str, "SM-J700", false, 2, null)) {
              break label115;
            }
          }
        }
      }
      return ReuseHelper.AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_ALWAYS;
    }
    label115:
    if ((Build.VERSION.SDK_INT < 24) && ((Intrinsics.areEqual("OMX.Nvidia.h264.decode", paramString)) || (Intrinsics.areEqual("OMX.Nvidia.h264.decode.secure", paramString))) && ((Intrinsics.areEqual("flounder", Build.DEVICE)) || (Intrinsics.areEqual("flounder_lte", Build.DEVICE)) || (Intrinsics.areEqual("grouper", Build.DEVICE)) || (Intrinsics.areEqual("tilapia", Build.DEVICE)))) {
      return ReuseHelper.AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;
    }
    return ReuseHelper.AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_NEVER;
  }
  
  public final void initFormatWrapper(@NotNull FormatWrapper paramFormatWrapper, @NotNull MediaFormat paramMediaFormat)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "format");
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "mediaFormat");
    ReusePolicy localReusePolicy = TCodecManager.Companion.getInstance().getReusePolicy();
    int k = Math.max(localReusePolicy.getInitWidth(), paramFormatWrapper.getWidth());
    int m = Math.max(localReusePolicy.getInitHeight(), paramFormatWrapper.getHeight());
    if (localReusePolicy.getReConfigByRealFormat())
    {
      localReusePolicy.setInitWidth(k);
      localReusePolicy.setInitHeight(m);
    }
    int j = Math.max(0, TUtils.getCodecMaxInputSize$default(TUtils.INSTANCE, paramFormatWrapper.getSampleMimeType(), k, m, false, 8, null));
    LogUtils.INSTANCE.d("ReuseHelper", "initFormatWrapper initWidth:" + k + " initHeight:" + m + " initMaxInputSize:" + j + ' ' + "reusePolicy:" + localReusePolicy);
    paramFormatWrapper.setMaxWidth(k);
    paramFormatWrapper.setMaxHeight(m);
    paramFormatWrapper.setMaxInputSize(j);
    if (j > 0) {
      i = j;
    }
    paramMediaFormat.setInteger("max-input-size", i);
    if ((paramFormatWrapper.isVideo()) && (Build.VERSION.SDK_INT >= 19))
    {
      paramMediaFormat.setInteger("max-width", k);
      paramMediaFormat.setInteger("max-height", m);
    }
  }
  
  public final boolean isSeamlessAdaptationSupported(@NotNull ReuseCodecWrapper paramReuseCodecWrapper, @NotNull FormatWrapper paramFormatWrapper, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "codecWrapper");
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "newFormat");
    FormatWrapper localFormatWrapper = paramReuseCodecWrapper.getFormat();
    if ((paramReuseCodecWrapper instanceof VideoCodecWrapper)) {
      if ((!Intrinsics.areEqual(localFormatWrapper.getSampleMimeType(), paramFormatWrapper.getSampleMimeType())) || (localFormatWrapper.getRotationDegrees() != paramFormatWrapper.getRotationDegrees()) || ((!paramReuseCodecWrapper.getAdaptive()) && ((localFormatWrapper.getWidth() != paramFormatWrapper.getWidth()) || (localFormatWrapper.getHeight() != paramFormatWrapper.getHeight())))) {}
    }
    while (!(paramReuseCodecWrapper instanceof AudioCodecWrapper))
    {
      return true;
      return false;
    }
    return (!(Intrinsics.areEqual("audio/mp4a-latm", localFormatWrapper.getSampleMimeType()) ^ true)) && (!(Intrinsics.areEqual(localFormatWrapper.getSampleMimeType(), paramFormatWrapper.getSampleMimeType()) ^ true)) && (localFormatWrapper.getChannelCount() == paramFormatWrapper.getChannelCount()) && (localFormatWrapper.getSampleRate() == paramFormatWrapper.getSampleRate());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.reuse.ReuseHelper
 * JD-Core Version:    0.7.0.1
 */