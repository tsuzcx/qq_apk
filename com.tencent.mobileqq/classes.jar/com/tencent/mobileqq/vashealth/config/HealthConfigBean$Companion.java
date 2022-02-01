package com.tencent.mobileqq.vashealth.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthConfigBean$Companion;", "", "()V", "IS_REDIRECT_AIO_TO_MAIN_PAGE", "", "MAIN_PAGE_JUMP_URL", "MAIN_PAGE_JUMP_URL_DEFVALUE", "TAG", "parse", "Lcom/tencent/mobileqq/vashealth/config/HealthConfigBean;", "content", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthConfigBean$Companion
{
  @JvmStatic
  @NotNull
  public final HealthConfigBean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse from:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(' ');
      QLog.d("HealthEntryConfigBean", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject(paramString);
      boolean bool = Intrinsics.areEqual(((JSONObject)localObject).optString("is_redirect_aio_to_main_page"), "1");
      localObject = ((JSONObject)localObject).optString("main_page_jump_url", "https://web.yundong.qq.com/pushsport/index?_wv=18950115&asyncMode=1&crashFrom=40501&_wwv=265&ls=1&spec=1&ADTAG=gzh.menu_page.main");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mainPageUrl");
      localObject = new HealthConfigBean(bool, (String)localObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error parse weather manage content:");
      localStringBuilder.append(paramString);
      QLog.e("HealthEntryConfigBean", 1, localStringBuilder.toString(), (Throwable)localJSONException);
    }
    return new HealthConfigBean(false, null, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */