package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/TweetTopicEntranceShouldShowAction;", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodAction;", "()V", "jsCallback", "", "name", "getName", "()Ljava/lang/String;", "action", "", "client", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "activity", "Landroid/app/Activity;", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/biz/troop/TroopMemberApiClient;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "callBack", "", "resultCode", "", "msg", "data", "Lorg/json/JSONObject;", "shouldShowPublisherEntrance", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicEntranceShouldShowAction
  implements JsMethodAction
{
  public static final TweetTopicEntranceShouldShowAction.Companion a;
  private String a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginJsMethodActionTweetTopicEntranceShouldShowAction$Companion = new TweetTopicEntranceShouldShowAction.Companion(null);
  }
  
  public TweetTopicEntranceShouldShowAction()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localJSONObject.put("entranceShouldShow", paramInt);
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    paramString = new JsMethodModel(i, paramString, localJSONObject);
    ReadInJoyJsMethodActionController.a.a(this.jdField_a_of_type_JavaLangString, paramString.a());
  }
  
  private final void a(TroopMemberApiClient paramTroopMemberApiClient)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramTroopMemberApiClient.a((ITroopMemberApiClientApi.Callback)new TweetTopicEntranceShouldShowAction.shouldShowPublisherEntrance.callbackSeq.1(this)));
    paramTroopMemberApiClient.a(160, localBundle);
  }
  
  @NotNull
  public String a()
  {
    return "publisherEntranceShouldShow";
  }
  
  public boolean a(@NotNull TroopMemberApiClient paramTroopMemberApiClient, @Nullable Activity paramActivity, @Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopMemberApiClient, "client");
    Intrinsics.checkParameterIsNotNull(paramString2, "pkgName");
    Intrinsics.checkParameterIsNotNull(paramString3, "method");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    int i;
    if (paramVarArgs.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i ^ 0x1) != 0) {
      try
      {
        paramActivity = new JSONObject(paramVarArgs[0]).optString("callback");
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "jobj.optString(\"callback\")");
        this.jdField_a_of_type_JavaLangString = paramActivity;
        if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString))
        {
          a(paramTroopMemberApiClient);
          return true;
        }
      }
      catch (JSONException paramTroopMemberApiClient)
      {
        QLog.e("TweetTopicEntranceShouldShowAction", 1, paramTroopMemberApiClient.getMessage());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.TweetTopicEntranceShouldShowAction
 * JD-Core Version:    0.7.0.1
 */