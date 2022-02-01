package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class TroopAlbumPlugin$1
  extends BroadcastReceiver
{
  TroopAlbumPlugin$1(TroopAlbumPlugin paramTroopAlbumPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("troop_upload".equals(paramIntent.getAction())) {
      if (TroopAlbumPlugin.a(this.a).getAttachedActivity() == null) {
        QMLog.e("TroopAlbumPlugin", "Failed to handle troop_upload, activity is null");
      }
    }
    while (!"troop_select".equals(paramIntent.getAction()))
    {
      return;
      paramContext = TroopAlbumPlugin.b(this.a).getAttachedActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).edit();
      localObject = new JSONObject();
      i = paramIntent.getIntExtra("count", 0);
      boolean bool = paramIntent.getBooleanExtra("fail", false);
      for (;;)
      {
        try
        {
          ((JSONObject)localObject).put("count", i);
          ((JSONObject)localObject).put("isFail", bool);
          if (QLog.isColorLevel()) {
            QLog.w("TroopAlbumPlugin", 2, "troopAlbumReceiver" + i + ",isfail" + bool);
          }
          if (!bool) {
            continue;
          }
          paramContext.putBoolean("is_exit_fail_misson", true).apply();
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
          continue;
        }
        TroopAlbumPlugin.a(this.a, "groupAlbum_onGroupAlbumUpload", ((JSONObject)localObject).toString());
        if (i != 0) {
          break;
        }
        paramContext.putBoolean("is_exit_fail_misson", false).apply();
        TroopAlbumPlugin.c(this.a).getAttachedActivity().unregisterReceiver(TroopAlbumPlugin.a(this.a));
        TroopAlbumPlugin.a(this.a, null);
        return;
        paramContext.putBoolean("is_exit_fail_misson", false).apply();
      }
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
      TroopAlbumPlugin.a(this.a).ok(paramContext);
      TroopAlbumPlugin.d(this.a).getAttachedActivity().unregisterReceiver(TroopAlbumPlugin.a(this.a));
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.1
 * JD-Core Version:    0.7.0.1
 */