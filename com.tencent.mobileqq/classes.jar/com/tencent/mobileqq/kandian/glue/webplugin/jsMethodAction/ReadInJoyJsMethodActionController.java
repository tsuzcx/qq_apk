package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/ReadInJoyJsMethodActionController;", "", "()V", "mWebPlugin", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "map", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodAction;", "Lkotlin/collections/HashMap;", "callBackToWebView", "", "jsCallbackFunc", "jsMethodModel", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodModel;", "retCode", "", "msg", "data", "Lorg/json/JSONObject;", "func", "jsonObject", "getActionByName", "name", "init", "webViewPlugin", "registerAction", "action", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyJsMethodActionController
{
  public static final ReadInJoyJsMethodActionController a;
  private static WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  private static final HashMap<String, JsMethodAction> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginJsMethodActionReadInJoyJsMethodActionController = new ReadInJoyJsMethodActionController();
  }
  
  @Nullable
  public final JsMethodAction a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return (JsMethodAction)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public final void a(@NotNull JsMethodAction paramJsMethodAction)
  {
    Intrinsics.checkParameterIsNotNull(paramJsMethodAction, "action");
    ((Map)jdField_a_of_type_JavaUtilHashMap).put(paramJsMethodAction.a(), paramJsMethodAction);
  }
  
  public final void a(@NotNull WebViewPlugin paramWebViewPlugin)
  {
    Intrinsics.checkParameterIsNotNull(paramWebViewPlugin, "webViewPlugin");
    jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
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
    WebViewPlugin localWebViewPlugin = jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
    if (localWebViewPlugin != null) {
      localWebViewPlugin.callJs(paramString, new String[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ReadInJoyJsMethodActionController
 * JD-Core Version:    0.7.0.1
 */