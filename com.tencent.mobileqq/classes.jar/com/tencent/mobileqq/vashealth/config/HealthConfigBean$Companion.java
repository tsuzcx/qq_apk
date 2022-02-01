package com.tencent.mobileqq.vashealth.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthConfigBean$Companion;", "", "()V", "IS_REDIRECT_AIO_TO_MAIN_PAGE", "", "MAIN_PAGE_JUMP_URL", "MAIN_PAGE_JUMP_URL_CONTACT", "MAIN_PAGE_JUMP_URL_DEFAULT", "MAIN_PAGE_JUMP_URL_SEARCH", "MAIN_PAGE_JUMP_URL_SEARCH_PA", "TAG", "parse", "Lcom/tencent/mobileqq/vashealth/config/HealthConfigBean;", "content", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthConfigBean$Companion
{
  @JvmStatic
  @NotNull
  public final HealthConfigBean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse from:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(' ');
      QLog.d("HealthEntryConfigBean", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      Object localObject3 = new JSONObject(paramString);
      boolean bool = Intrinsics.areEqual(((JSONObject)localObject3).optString("is_redirect_aio_to_main_page"), "1");
      localObject1 = ((JSONObject)localObject3).optString("main_page_jump_url", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
      localObject2 = ((JSONObject)localObject3).optString("main_page_jump_url_search", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
      String str = ((JSONObject)localObject3).optString("main_page_jump_url_search_pa", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
      localObject3 = ((JSONObject)localObject3).optString("main_page_jump_url_contact", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mainPageUrl");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mainPageUrlSearch");
      Intrinsics.checkExpressionValueIsNotNull(str, "mainPageUrlSearchPA");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "mainPageUrlContact");
      localObject1 = new HealthConfigBean(bool, (String)localObject1, (String)localObject2, str, (String)localObject3);
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("error parse weather manage content:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("HealthEntryConfigBean", 1, ((StringBuilder)localObject2).toString(), (Throwable)localJSONException);
    }
    return new HealthConfigBean(false, null, null, null, null, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */