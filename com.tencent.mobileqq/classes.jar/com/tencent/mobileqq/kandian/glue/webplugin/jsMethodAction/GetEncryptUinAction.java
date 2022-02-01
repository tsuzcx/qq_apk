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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/GetEncryptUinAction;", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodAction;", "()V", "jsCallback", "", "name", "getName", "()Ljava/lang/String;", "action", "", "client", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "activity", "Landroid/app/Activity;", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/biz/troop/TroopMemberApiClient;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "callBack", "", "resultCode", "", "msg", "uin", "getCurrentUserEncryptedUin", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class GetEncryptUinAction
  implements JsMethodAction
{
  public static final GetEncryptUinAction.Companion a;
  private String a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginJsMethodActionGetEncryptUinAction$Companion = new GetEncryptUinAction.Companion(null);
  }
  
  public GetEncryptUinAction()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private final void a(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("encrytedUin", paramString2);
    paramString1 = new JsMethodModel(paramInt, paramString1, localJSONObject);
    ReadInJoyJsMethodActionController.a.a(this.jdField_a_of_type_JavaLangString, paramString1.a());
  }
  
  private final void a(TroopMemberApiClient paramTroopMemberApiClient)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramTroopMemberApiClient.a((ITroopMemberApiClientApi.Callback)new GetEncryptUinAction.getCurrentUserEncryptedUin.callbackSeq.1(this)));
    paramTroopMemberApiClient.a(162, localBundle);
  }
  
  @NotNull
  public String a()
  {
    return "getCurrentUserEncryptedUin";
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
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.GetEncryptUinAction
 * JD-Core Version:    0.7.0.1
 */