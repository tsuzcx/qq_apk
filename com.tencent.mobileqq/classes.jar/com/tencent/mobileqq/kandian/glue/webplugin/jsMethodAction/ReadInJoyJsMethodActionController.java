package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/ReadInJoyJsMethodActionController;", "", "()V", "mWebPlugin", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callBackToWebView", "", "jsCallbackFunc", "jsMethodModel", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodModel;", "retCode", "", "msg", "data", "Lorg/json/JSONObject;", "func", "jsonObject", "getActionByName", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodAction;", "name", "init", "webViewPlugin", "registerAction", "action", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyJsMethodActionController
{
  public static final ReadInJoyJsMethodActionController a = new ReadInJoyJsMethodActionController();
  private static WebViewPlugin b;
  private static final HashMap<String, String> c = new HashMap();
  
  @Nullable
  public final JsMethodAction a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    if (!c.containsKey(paramString)) {
      return null;
    }
    return (JsMethodAction)Class.forName((String)c.get(paramString)).newInstance();
  }
  
  public final void a(@NotNull JsMethodAction paramJsMethodAction)
  {
    Intrinsics.checkParameterIsNotNull(paramJsMethodAction, "action");
    Map localMap = (Map)c;
    String str = paramJsMethodAction.a();
    paramJsMethodAction = paramJsMethodAction.getClass().getName();
    Intrinsics.checkExpressionValueIsNotNull(paramJsMethodAction, "action.javaClass.name");
    localMap.put(str, paramJsMethodAction);
  }
  
  public final void a(@NotNull WebViewPlugin paramWebViewPlugin)
  {
    Intrinsics.checkParameterIsNotNull(paramWebViewPlugin, "webViewPlugin");
    b = paramWebViewPlugin;
  }
  
  public final void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "jsCallbackFunc");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    a(paramString1, new JsMethodModel(paramInt, paramString2, paramJSONObject));
  }
  
  public final void a(@NotNull String paramString, @NotNull JsMethodModel paramJsMethodModel)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "jsCallbackFunc");
    Intrinsics.checkParameterIsNotNull(paramJsMethodModel, "jsMethodModel");
    a(paramString, paramJsMethodModel.a());
  }
  
  public final void a(@NotNull String paramString, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "func");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    WebViewPlugin localWebViewPlugin = b;
    if (localWebViewPlugin != null) {
      localWebViewPlugin.callJs(paramString, new String[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ReadInJoyJsMethodActionController
 * JD-Core Version:    0.7.0.1
 */