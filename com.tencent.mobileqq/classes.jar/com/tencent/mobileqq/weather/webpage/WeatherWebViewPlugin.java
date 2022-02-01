package com.tencent.mobileqq.weather.webpage;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherWebViewPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "callJsOnFail", "", "callback", "", "errMsg", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "handleOpenWeatherPage", "jsonArgs", "onWebCallArk", "argument", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebViewPlugin
  extends WebViewPlugin
{
  public static final WeatherWebViewPlugin.Companion a = new WeatherWebViewPlugin.Companion(null);
  
  public WeatherWebViewPlugin()
  {
    this.mPluginNameSpace = "weather";
  }
  
  private final void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWebCallArk -> argument : ");
      localStringBuilder.append(paramString);
      QLog.d("WeatherWebViewPlugin", 2, localStringBuilder.toString());
    }
    try
    {
      ark.arkNotify("com.tencent.weather_v2", "receive_web_msg", paramString, "json");
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("WeatherWebViewPlugin", 1, "arkNotify", paramString);
    }
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString1))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -1);
      localJSONObject.put("message", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString(0) });
    }
  }
  
  private final void b(String paramString)
  {
    Object localObject1 = this.mRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRuntime");
    Object localObject3 = ((WebViewPlugin.PluginRuntime)localObject1).a();
    if (localObject3 != null)
    {
      Object localObject2 = new JSONObject(paramString);
      localObject1 = ((JSONObject)localObject2).optString("callback");
      try
      {
        String str = ((JSONObject)localObject2).optString("adcode");
        localObject2 = ((JSONObject)localObject2).optString("businessId");
        if ((!TextUtils.isEmpty((CharSequence)str)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localObject3 = (Context)localObject3;
          Intrinsics.checkExpressionValueIsNotNull(str, "adCode");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "businessId");
          WeatherWebPageHelper.a((Context)localObject3, str, (String)localObject2);
          return;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("adcode=");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(", businessId=");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(", can't be empty");
        str = ((StringBuilder)localObject3).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "callback");
        a((String)localObject1, str);
        QLog.d("WeatherWebViewPlugin", 1, str);
        return;
      }
      catch (Throwable localThrowable)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "callback");
        a((String)localObject1, localThrowable.getMessage());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleOpenWeatherPage, jsonArgs: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("WeatherWebViewPlugin", 1, ((StringBuilder)localObject1).toString(), localThrowable);
      }
    }
  }
  
  protected boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJsRequest -> url : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",pkgName : ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",method : ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(",args[0 : ");
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      QLog.d("WeatherWebViewPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if ((Intrinsics.areEqual("weather", paramString2) ^ true)) {
      return false;
    }
    Object localObject = (String)ArraysKt.firstOrNull(paramVarArgs);
    if (localObject != null)
    {
      if (paramString3 != null)
      {
        int i = paramString3.hashCode();
        if (i != -1708620807)
        {
          if ((i == -798394074) && (paramString3.equals("notify_ark_msg")))
          {
            a((String)localObject);
            return true;
          }
        }
        else if (paramString3.equals("openWeatherPage"))
        {
          b((String)localObject);
          return true;
        }
      }
      return false;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */