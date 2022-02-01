package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.ArrayList;

class NearbyJsInterface$3
  implements TroopMemberApiClient.Callback
{
  NearbyJsInterface$3(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void callback(Bundle paramBundle)
  {
    Object localObject;
    Intent localIntent;
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")))
    {
      localObject = paramBundle.getStringArrayList("uins");
      paramBundle.getStringArrayList("tinyIds");
      paramBundle = (String)((ArrayList)localObject).get(0);
      localObject = this.a.mRuntime.a();
      localIntent = new Intent((Context)localObject, ChatActivity.class);
      localIntent.putExtra("PREVIOUS_UIN", paramBundle);
      localIntent.putExtra("uin", paramBundle);
      if (NearbyJsInterface.a(this.a) != 1) {
        break label125;
      }
    }
    label125:
    for (int i = 10002;; i = 1001)
    {
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("gender", 1);
      localIntent.addFlags(67108864);
      ((Context)localObject).startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.3
 * JD-Core Version:    0.7.0.1
 */