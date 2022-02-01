package com.tencent.mobileqq.kandian.base.video.player.config;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.tmediacodec.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/config/CodecReuseHelper$Companion;", "", "()V", "SEPARATOR", "", "TAG", "appendBySeparator", "originStr", "appendStr", "separator", "setToReportData", "", "mediaCodecInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPMediaCodecInfo;", "reportData", "Lcom/tencent/mobileqq/kandian/base/video/player/data/AbsReadInJoyVideoReportData;", "setToReportDataByExtraObject", "extraObject", "Ljava/lang/Object;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CodecReuseHelper$Companion
{
  private final String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      return paramString2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public final void a(@NotNull TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo, @NotNull AbsReadInJoyVideoReportData paramAbsReadInJoyVideoReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramTPMediaCodecInfo, "mediaCodecInfo");
    Intrinsics.checkParameterIsNotNull(paramAbsReadInJoyVideoReportData, "reportData");
    if (paramTPMediaCodecInfo.mediaType == TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)
    {
      if (paramTPMediaCodecInfo.infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY)
      {
        paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
        paramAbsReadInJoyVideoReportData.as = paramTPMediaCodecInfo;
        try
        {
          paramTPMediaCodecInfo = new JSONObject(paramTPMediaCodecInfo);
          paramAbsReadInJoyVideoReportData.ap = paramTPMediaCodecInfo.optBoolean("reuseEnable");
          paramAbsReadInJoyVideoReportData.aq = paramTPMediaCodecInfo.optBoolean("isReuse");
          paramAbsReadInJoyVideoReportData.ar = paramTPMediaCodecInfo.optInt("totalCodec");
          return;
        }
        catch (Throwable paramTPMediaCodecInfo)
        {
          paramAbsReadInJoyVideoReportData = new StringBuilder();
          paramAbsReadInJoyVideoReportData.append("onCodecReuseInfo error:");
          paramAbsReadInJoyVideoReportData.append(paramTPMediaCodecInfo.getMessage());
          LogUtil.e("CodecReuseHelper", paramAbsReadInJoyVideoReportData.toString());
          return;
        }
      }
      if (paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION) {}
    }
    try
    {
      String str = new JSONObject(paramTPMediaCodecInfo.msg).optString("errorCode");
      paramAbsReadInJoyVideoReportData.aw = ((Companion)this).a(paramAbsReadInJoyVideoReportData.aw, str, ";");
      paramAbsReadInJoyVideoReportData.ax = ((Companion)this).a(paramAbsReadInJoyVideoReportData.ax, paramTPMediaCodecInfo.msg, ";");
      return;
    }
    catch (Throwable paramAbsReadInJoyVideoReportData)
    {
      label185:
      break label185;
    }
    paramAbsReadInJoyVideoReportData = new StringBuilder();
    paramAbsReadInJoyVideoReportData.append("onCodecReuseInfo error for jsonObject:");
    paramAbsReadInJoyVideoReportData.append(paramTPMediaCodecInfo.msg);
    LogUtils.e("CodecReuseHelper", paramAbsReadInJoyVideoReportData.toString());
  }
  
  public final void a(@NotNull Object paramObject, @NotNull AbsReadInJoyVideoReportData paramAbsReadInJoyVideoReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "extraObject");
    Intrinsics.checkParameterIsNotNull(paramAbsReadInJoyVideoReportData, "reportData");
    if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
    {
      paramObject = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
      ((Companion)this).a(paramObject, paramAbsReadInJoyVideoReportData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper.Companion
 * JD-Core Version:    0.7.0.1
 */