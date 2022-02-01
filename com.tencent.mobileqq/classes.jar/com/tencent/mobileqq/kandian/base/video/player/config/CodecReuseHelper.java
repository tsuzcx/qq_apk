package com.tencent.mobileqq.kandian.base.video.player.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/config/CodecReuseHelper;", "", "()V", "cacheDebugText", "", "codecJson", "getDebugText", "setCodecJson", "", "setMediaCodecInfo", "mediaCodecInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPMediaCodecInfo;", "Companion", "OnCodecReuseInfoUpdateCallback", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CodecReuseHelper
{
  public static final CodecReuseHelper.Companion a;
  private String a;
  private String b = "";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigCodecReuseHelper$Companion = new CodecReuseHelper.Companion(null);
  }
  
  public CodecReuseHelper()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  @NotNull
  public final String a()
  {
    if (TextUtils.isEmpty((CharSequence)this.b)) {}
    try
    {
      localObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      if (!((JSONObject)localObject).optBoolean("isVideo", false)) {
        break label168;
      }
      boolean bool1 = ((JSONObject)localObject).optBoolean("isReuse", false);
      boolean bool2 = ((JSONObject)localObject).optBoolean("reuseEnable", false);
      int i = ((JSONObject)localObject).optInt("totalCodec", -1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isReuse:");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" reuseEnable:");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("\ntotalCodec:");
      ((StringBuilder)localObject).append(i);
      this.b = ((StringBuilder)localObject).toString();
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label130:
      break label130;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDebugText error for parse Json:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.w("CodecReuseHelper", 1, ((StringBuilder)localObject).toString());
    label168:
    return this.b;
  }
  
  public final void a(@Nullable TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo)
  {
    if (paramTPMediaCodecInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CodecReuseHelper", 2, "parseAndSetMediaCodecInfo failed for mediaCodecInfo is null.");
      }
      return;
    }
    if ((paramTPMediaCodecInfo.infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) && (paramTPMediaCodecInfo.mediaType == TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO))
    {
      paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
      Intrinsics.checkExpressionValueIsNotNull(paramTPMediaCodecInfo, "mediaCodecInfo.msg");
      a(paramTPMediaCodecInfo);
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "codecJson");
    if (TextUtils.equals((CharSequence)this.jdField_a_of_type_JavaLangString, (CharSequence)paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper
 * JD-Core Version:    0.7.0.1
 */