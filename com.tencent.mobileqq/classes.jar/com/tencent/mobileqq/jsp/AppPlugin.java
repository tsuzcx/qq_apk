package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.util.privacy.handler.IJSPackageInfoHandler;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/jsp/AppPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "mHandlerList", "", "Lcom/tencent/mobileqq/util/privacy/handler/IJSPackageInfoHandler;", "getMHandlerList", "()Ljava/util/List;", "mHandlerList$delegate", "Lkotlin/Lazy;", "callbackJS", "", "args", "", "param", "Lorg/json/JSONObject;", "getCurrentContext", "Landroid/app/Activity;", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AppPlugin
  extends WebViewPlugin
{
  public static final AppPlugin.Companion a = new AppPlugin.Companion(null);
  private final Lazy b = LazyKt.lazy((Function0)AppPlugin.mHandlerList.2.INSTANCE);
  
  public AppPlugin()
  {
    this.mPluginNameSpace = "app";
  }
  
  private final List<IJSPackageInfoHandler> a()
  {
    return (List)this.b.getValue();
  }
  
  private final void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null)
    {
      QLog.d("AppPlugin", 1, "callbackJS args null");
      return;
    }
    paramString = new JSONObject(paramString).optString("callback", "");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.d("AppPlugin", 1, "callbackJS callbackFunc null");
      return;
    }
    callJs(paramString, new String[] { paramJSONObject.toString() });
  }
  
  private final Activity b()
  {
    Object localObject = this.mRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mRuntime");
    for (localObject = ((WebViewPlugin.PluginRuntime)localObject).d(); (localObject instanceof BasePluginActivity); localObject = ((BasePluginActivity)localObject).getOutActivity()) {}
    return localObject;
  }
  
  protected boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    paramJsBridgeListener = new StringBuilder();
    paramJsBridgeListener.append("handleJsPackageInfoRequest methodName: ");
    paramJsBridgeListener.append(paramString3);
    QLog.d("AppPlugin", 1, paramJsBridgeListener.toString());
    paramString1 = b();
    if (paramString1 == null)
    {
      QLog.d("AppPlugin", 1, "handleJsPackageInfoRequest context null");
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramString3))
    {
      QLog.d("AppPlugin", 1, "handleJsPackageInfoRequest method null");
      return false;
    }
    paramJsBridgeListener = new Ref.ObjectRef();
    paramString2 = a().iterator();
    while (paramString2.hasNext())
    {
      IJSPackageInfoHandler localIJSPackageInfoHandler = (IJSPackageInfoHandler)paramString2.next();
      Context localContext = (Context)paramString1;
      if (paramString3 == null) {
        Intrinsics.throwNpe();
      }
      paramJsBridgeListener.element = localIJSPackageInfoHandler.a(localContext, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      if (paramJsBridgeListener.element != null)
      {
        int i;
        if (paramVarArgs.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0)
        {
          paramString1 = new JSONObject();
          paramString1.put("info", paramJsBridgeListener.element);
          a(paramVarArgs[0], paramString1);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AppPlugin
 * JD-Core Version:    0.7.0.1
 */