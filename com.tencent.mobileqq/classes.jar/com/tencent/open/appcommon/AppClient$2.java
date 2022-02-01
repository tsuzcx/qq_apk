package com.tencent.open.appcommon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.util.HashMap;

final class AppClient$2
  implements Runnable
{
  AppClient$2(Bundle paramBundle1, Bundle paramBundle2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    boolean bool;
    if (Common.b(this.a.getString("schemaUrl")).get("auto_download") != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (!MyAppApi.l().a(CommonDataAdapter.a().b(), this.b, bool, false))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Common.h());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("qapp_center_detail.htm");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1);
      Object localObject3;
      if (!((File)localObject2).exists())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("file");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" not exist copyassets.");
        LogUtility.d("AppClient", ((StringBuilder)localObject3).toString());
        FileUtils.a("Page/system", Common.i());
      }
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      if (((File)localObject2).exists())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("file:///");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject3 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Common.o());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("qapp_center_detail.htm");
        localObject3 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&from=-10&id=");
      ((StringBuilder)localObject1).append(this.c);
      localObject2 = ((StringBuilder)localObject1).toString();
      if (!TextUtils.isEmpty(this.d))
      {
        localObject1 = localObject2;
        if (this.d.contains("channelId")) {}
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&channelId=");
        ((StringBuilder)localObject1).append(this.e);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (bool)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&auto_download=1");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.d)) {
        if (this.d.equals(this.c))
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append(this.d);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      localIntent.setClass(CommonDataAdapter.a().b(), QZoneAppListActivity.class);
      if (DownloadSDKConfigManager.canGotoNewDetailPage(this.f)) {
        localBundle.putInt("goto_type", 7);
      } else {
        localBundle.putInt("goto_type", 3);
      }
      localBundle.putString("APP_URL", (String)localObject3);
      localBundle.putBoolean("FROM_FEED", true);
      localBundle.putString("APP_PARAMS", (String)localObject1);
      if (this.a.getInt("process_id") == 2) {
        localBundle.putInt("process_id", 2);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("APP_URL:");
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(" |  PARAMS >>> ");
      ((StringBuilder)localObject1).append(localBundle.getString("APP_PARAMS"));
      LogUtility.b("Jie", ((StringBuilder)localObject1).toString());
      localIntent.putExtras(localBundle);
      localIntent.putExtra("adapter_action", "action_app_detail");
      localIntent.addFlags(872415232);
      CommonDataAdapter.a().b().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.2
 * JD-Core Version:    0.7.0.1
 */