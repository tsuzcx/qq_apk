package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgho;
import bgkd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class TroopAlbumPlugin$1
  extends BroadcastReceiver
{
  TroopAlbumPlugin$1(TroopAlbumPlugin paramTroopAlbumPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("troop_upload".equals(paramIntent.getAction()))
    {
      paramContext = TroopAlbumPlugin.access$000(this.this$0).a().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).edit();
      localObject = new JSONObject();
      i = paramIntent.getIntExtra("count", 0);
      boolean bool = paramIntent.getBooleanExtra("fail", false);
      try
      {
        ((JSONObject)localObject).put("count", i);
        ((JSONObject)localObject).put("isFail", bool);
        if (QLog.isColorLevel()) {
          QLog.w("TroopAlbumPlugin", 2, "troopAlbumReceiver" + i + ",isfail" + bool);
        }
        if (!bool) {
          break label230;
        }
        paramContext.putBoolean("is_exit_fail_misson", true).apply();
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
      TroopAlbumPlugin.access$100(this.this$0, "groupAlbum_onGroupAlbumUpload", ((JSONObject)localObject).toString());
      if (i == 0)
      {
        paramContext.putBoolean("is_exit_fail_misson", false).apply();
        TroopAlbumPlugin.access$300(this.this$0).a().unregisterReceiver(TroopAlbumPlugin.access$200(this.this$0));
        TroopAlbumPlugin.access$402(this.this$0, null);
      }
    }
    label230:
    while (!"troop_select".equals(paramIntent.getAction()))
    {
      return;
      paramContext.putBoolean("is_exit_fail_misson", false).apply();
      break;
    }
    QLog.w("TroopAlbumPlugin", 2, "troop_select recive");
    paramContext = paramIntent.getStringExtra("key_selected_albuminfo.id");
    Object localObject = paramIntent.getStringExtra("key_selected_albuminfo.name");
    String str = paramIntent.getStringExtra("key_selected_albuminfo.cover");
    int i = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
    paramIntent = new StringBuilder();
    paramIntent.append("{albumid:\"").append(paramContext).append("\",albumname:\"").append((String)localObject).append("\",albumcover:\"").append(str).append("\",albumpermission:").append(i).append("}");
    try
    {
      paramContext = new JSONObject(paramIntent.toString());
      TroopAlbumPlugin.access$400(this.this$0).a(paramContext);
      TroopAlbumPlugin.access$500(this.this$0).a().unregisterReceiver(TroopAlbumPlugin.access$200(this.this$0));
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.1
 * JD-Core Version:    0.7.0.1
 */