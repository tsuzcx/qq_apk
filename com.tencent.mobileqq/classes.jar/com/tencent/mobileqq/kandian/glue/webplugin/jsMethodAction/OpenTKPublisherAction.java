package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/OpenTKPublisherAction;", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodAction;", "()V", "callback", "", "name", "getName", "()Ljava/lang/String;", "action", "", "client", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "activity", "Landroid/app/Activity;", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/biz/troop/TroopMemberApiClient;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "checkTopicVideoUploadNum", "", "json", "Lorg/json/JSONObject;", "callbackSeq", "", "clickEntryViewBtn", "openUGCPublisher", "showEntryDialog", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class OpenTKPublisherAction
  implements JsMethodAction
{
  public static final OpenTKPublisherAction.Companion a = new OpenTKPublisherAction.Companion(null);
  private String b = "";
  
  private final void a(TroopMemberApiClient paramTroopMemberApiClient, JSONObject paramJSONObject)
  {
    int i = paramTroopMemberApiClient.e((ITroopMemberApiClientApi.Callback)new OpenTKPublisherAction.clickEntryViewBtn.callbackSeq.1(this));
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", 410);
    localJSONObject.put("key", "publish_permission");
    paramJSONObject = paramJSONObject.optJSONObject("eventInfo");
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    paramTroopMemberApiClient.a(localJSONObject, (ITroopMemberApiClientApi.Callback)new OpenTKPublisherAction.clickEntryViewBtn.1(this, paramTroopMemberApiClient, paramJSONObject, i));
  }
  
  private final void a(TroopMemberApiClient paramTroopMemberApiClient, JSONObject paramJSONObject, int paramInt)
  {
    RIJEntryViewUtils localRIJEntryViewUtils = RIJEntryViewUtils.a;
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "QBaseActivity.sTopActivity");
    localRIJEntryViewUtils.a((Activity)localQBaseActivity, (Function0)new OpenTKPublisherAction.showEntryDialog.1(this, paramTroopMemberApiClient, paramJSONObject, paramInt), (Function0)new OpenTKPublisherAction.showEntryDialog.2(this, paramTroopMemberApiClient, paramJSONObject, paramInt), 8);
  }
  
  private final void b(TroopMemberApiClient paramTroopMemberApiClient, JSONObject paramJSONObject, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramInt);
    localBundle.putString("extra", paramJSONObject.toString());
    paramTroopMemberApiClient.a(162, localBundle);
  }
  
  private final void c(TroopMemberApiClient paramTroopMemberApiClient, JSONObject paramJSONObject, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramInt);
    localBundle.putString("extra", paramJSONObject.toString());
    paramTroopMemberApiClient.a(161, localBundle);
  }
  
  @NotNull
  public String a()
  {
    return "openTKPublisher";
  }
  
  public boolean a(@NotNull TroopMemberApiClient paramTroopMemberApiClient, @Nullable Activity paramActivity, @Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopMemberApiClient, "client");
    Intrinsics.checkParameterIsNotNull(paramString2, "pkgName");
    Intrinsics.checkParameterIsNotNull(paramString3, "method");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (paramActivity == null) {
      return false;
    }
    int i;
    if (paramVarArgs.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i ^ 0x1) != 0) {}
    try
    {
      paramActivity = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramActivity.optString("callback");
      Intrinsics.checkExpressionValueIsNotNull(paramJsBridgeListener, "json.optString(\"callback\")");
      this.b = paramJsBridgeListener;
      a(paramTroopMemberApiClient, paramActivity);
      return true;
    }
    catch (JSONException paramTroopMemberApiClient)
    {
      label93:
      break label93;
    }
    paramTroopMemberApiClient = new StringBuilder();
    paramTroopMemberApiClient.append("error in jsonObject with ");
    paramTroopMemberApiClient.append(paramVarArgs);
    QLog.e("OpenTKPublisherAction", 1, paramTroopMemberApiClient.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.OpenTKPublisherAction
 * JD-Core Version:    0.7.0.1
 */