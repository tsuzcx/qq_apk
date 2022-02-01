package com.tencent.mobileqq.kandian.repo.webarticle;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.smtt.sdk.QbSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "", "()V", "r5", "Lorg/json/JSONObject;", "getR5", "()Lorg/json/JSONObject;", "addString", "key", "", "value", "build", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleReportUtil$ReportR5Builder
{
  @NotNull
  private final JSONObject a = new JSONObject();
  
  public RIJWebArticleReportUtil$ReportR5Builder()
  {
    JSONObject localJSONObject = this.a;
    boolean bool = RIJWebArticleUtil.a.b();
    String str = "1";
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_webviewPoolReuse", localObject);
    localJSONObject = this.a;
    if (RIJWebArticleUtil.a.c()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_useVasSonic", localObject);
    localJSONObject = this.a;
    if (RIJWebArticleUtil.a.e()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_usePreload", localObject);
    localJSONObject = this.a;
    if (RIJWebArticleUtil.a.f()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_warmup_template", localObject);
    localJSONObject = this.a;
    if (RIJWebArticleUtil.a.g()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_use_web_data_preload", localObject);
    localJSONObject = this.a;
    if (RIJWebArticleUtil.a.h()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_foreground_preload", localObject);
    localJSONObject = this.a;
    Object localObject = BaseApplicationImpl.sApplication;
    if (localObject != null) {
      localObject = ((BaseApplicationImpl)localObject).getApplicationContext();
    } else {
      localObject = null;
    }
    if (QbSdk.getTbsVersion((Context)localObject) != 0) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_isX5", localObject);
    localJSONObject = this.a;
    if (RIJWebArticleUtil.a.i()) {
      localObject = str;
    } else {
      localObject = "0";
    }
    localJSONObject.put("param_load_url_optimize", localObject);
  }
  
  @NotNull
  public final ReportR5Builder a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  @NotNull
  public final String a()
  {
    String str = this.a.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "r5.toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleReportUtil.ReportR5Builder
 * JD-Core Version:    0.7.0.1
 */