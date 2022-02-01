package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerReport$R5Builder;", "", "()V", "r5Json", "Lorg/json/JSONObject;", "getR5Json", "()Lorg/json/JSONObject;", "addCardReportJson", "cardReportJson", "", "addString", "key", "value", "build", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerReport$R5Builder
{
  @NotNull
  private final JSONObject a = new JSONObject();
  
  @NotNull
  public final R5Builder a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cardReportJson");
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Object localObject = localJSONObject.keys();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        Intrinsics.checkExpressionValueIsNotNull(str1, "key");
        String str2 = localJSONObject.optString(str1);
        Intrinsics.checkExpressionValueIsNotNull(str2, "json.optString(key)");
        a(str1, str2);
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[addCardReportJson] failed, e = ");
      ((StringBuilder)localObject).append(localJSONException);
      ((StringBuilder)localObject).append(", cardReportJson = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("RIJChannelBannerReport", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  @NotNull
  public final R5Builder a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    try
    {
      if (!TextUtils.isEmpty((CharSequence)paramString1))
      {
        this.a.put(paramString1, paramString2);
        return this;
      }
      paramString1 = new StringBuilder();
      paramString1.append("[addString] failed, key is empty, value = ");
      paramString1.append(paramString2);
      QLog.i("RIJChannelBannerReport", 2, paramString1.toString());
      return this;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[addString] e = ");
      paramString2.append(paramString1);
      QLog.e("RIJChannelBannerReport", 1, paramString2.toString());
    }
    return this;
  }
  
  @NotNull
  public final String a()
  {
    String str = this.a.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "r5Json.toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerReport.R5Builder
 * JD-Core Version:    0.7.0.1
 */