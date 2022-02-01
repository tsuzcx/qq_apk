package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.ArrayList;

class NearbyJsInterface$3
  implements ITroopMemberApiClientApi.Callback
{
  NearbyJsInterface$3(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void callback(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")))
    {
      Object localObject = paramBundle.getStringArrayList("uins");
      paramBundle.getStringArrayList("tinyIds");
      paramBundle = (String)((ArrayList)localObject).get(0);
      localObject = this.a.mRuntime.a();
      Intent localIntent = new Intent((Context)localObject, ChatActivity.class);
      localIntent.putExtra("PREVIOUS_UIN", paramBundle);
      localIntent.putExtra("uin", paramBundle);
      int i;
      if (NearbyJsInterface.a(this.a) == 1) {
        i = 10002;
      } else {
        i = 1001;
      }
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("gender", 1);
      localIntent.addFlags(67108864);
      ((Context)localObject).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.3
 * JD-Core Version:    0.7.0.1
 */