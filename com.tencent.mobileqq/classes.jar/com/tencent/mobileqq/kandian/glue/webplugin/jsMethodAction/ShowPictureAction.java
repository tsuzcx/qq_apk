package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/ShowPictureAction;", "Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodAction;", "()V", "callback", "", "name", "getName", "()Ljava/lang/String;", "seq", "", "action", "", "client", "Lcom/tencent/biz/troop/TroopMemberApiClient;", "activity", "Landroid/app/Activity;", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/biz/troop/TroopMemberApiClient;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "showPicture", "", "data", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ShowPictureAction
  implements JsMethodAction
{
  private String a = "";
  private int b = -1;
  
  private final void a(TroopMemberApiClient paramTroopMemberApiClient, Activity paramActivity, String paramString)
  {
    int i;
    label319:
    do
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.optString("callback");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "json.optString(\"callback\")");
        this.a = ((String)localObject);
        i = ((CharSequence)this.a).length();
        j = 0;
        if (i != 0) {
          break label319;
        }
        i = 1;
      }
      catch (JSONException paramTroopMemberApiClient)
      {
        Object localObject;
        int j;
        int k;
        return;
      }
      this.b = paramTroopMemberApiClient.e((ITroopMemberApiClientApi.Callback)new ShowPictureAction.showPicture.1(this, paramTroopMemberApiClient));
      localObject = paramString.optJSONArray("imageIDs");
      if (localObject != null)
      {
        if (((JSONArray)localObject).length() == 0) {
          return;
        }
        paramTroopMemberApiClient = new ArrayList();
        k = ((JSONArray)localObject).length();
        i = j;
      }
      for (;;)
      {
        if (i < k)
        {
          paramTroopMemberApiClient.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
        else
        {
          localObject = new Bundle();
          ((Bundle)localObject).putStringArrayList("seqNum", paramTroopMemberApiClient);
          ((Bundle)localObject).putString("src_id", paramString.optString("srcID"));
          ((Bundle)localObject).putInt("index", paramString.optInt("index"));
          ((Bundle)localObject).putBoolean("is_not_show_index", true);
          ((Bundle)localObject).putBoolean("show_title_bar", paramString.optBoolean("showTitleBar", true));
          ((Bundle)localObject).putString("acticle_info_rowkey", paramString.optString("rowkey"));
          boolean bool = paramString.optBoolean("showSocialBottomBar", true);
          ((Bundle)localObject).putBoolean("show_social_bottom_bar", bool);
          if (bool)
          {
            ((Bundle)localObject).putString("show_social_bottom_bar_data", paramString.optJSONObject("socialBottomBar").toString());
            ((Bundle)localObject).putString("callback_seq", String.valueOf(this.b));
          }
          ((Bundle)localObject).putBoolean("is_from_tool_process", true);
          paramTroopMemberApiClient = new Intent((Context)paramActivity, TroopAvatarWallPreviewActivity.class);
          paramTroopMemberApiClient.putExtras((Bundle)localObject);
          if (paramActivity != null) {
            paramActivity.startActivity(paramTroopMemberApiClient);
          }
          return;
          i = 0;
        }
      }
    } while (i == 0);
  }
  
  @NotNull
  public String a()
  {
    return "showPicture";
  }
  
  public boolean a(@NotNull TroopMemberApiClient paramTroopMemberApiClient, @Nullable Activity paramActivity, @Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramTroopMemberApiClient, "client");
    Intrinsics.checkParameterIsNotNull(paramString2, "pkgName");
    Intrinsics.checkParameterIsNotNull(paramString3, "method");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (paramActivity != null)
    {
      int i;
      if (paramVarArgs.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      paramJsBridgeListener = paramVarArgs[0];
      if (paramJsBridgeListener != null) {
        a(paramTroopMemberApiClient, paramActivity, paramJsBridgeListener);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ShowPictureAction
 * JD-Core Version:    0.7.0.1
 */