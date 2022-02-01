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
    Object localObject;
    int i;
    if ("troop_upload".equals(paramIntent.getAction()))
    {
      if (TroopAlbumPlugin.a(this.a).getAttachedActivity() == null)
      {
        QMLog.e("TroopAlbumPlugin", "Failed to handle troop_upload, activity is null");
        return;
      }
      paramContext = TroopAlbumPlugin.b(this.a).getAttachedActivity();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troop_album");
      ((StringBuilder)localObject).append(BaseApplicationImpl.sApplication.getRuntime().getAccount());
      paramContext = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 0).edit();
      localObject = new JSONObject();
      i = paramIntent.getIntExtra("count", 0);
      boolean bool = paramIntent.getBooleanExtra("fail", false);
      try
      {
        ((JSONObject)localObject).put("count", i);
        ((JSONObject)localObject).put("isFail", bool);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("troopAlbumReceiver");
          paramIntent.append(i);
          paramIntent.append(",isfail");
          paramIntent.append(bool);
          QLog.w("TroopAlbumPlugin", 2, paramIntent.toString());
        }
        if (bool) {
          paramContext.putBoolean("is_exit_fail_misson", true).apply();
        } else {
          paramContext.putBoolean("is_exit_fail_misson", false).apply();
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      TroopAlbumPlugin.a(this.a, "groupAlbum_onGroupAlbumUpload", ((JSONObject)localObject).toString());
      if (i == 0)
      {
        paramContext.putBoolean("is_exit_fail_misson", false).apply();
        TroopAlbumPlugin.d(this.a).getAttachedActivity().unregisterReceiver(TroopAlbumPlugin.c(this.a));
        TroopAlbumPlugin.a(this.a, null);
      }
    }
    else if ("troop_select".equals(paramIntent.getAction()))
    {
      QLog.w("TroopAlbumPlugin", 2, "troop_select recive");
      paramContext = paramIntent.getStringExtra("key_selected_albuminfo.id");
      localObject = paramIntent.getStringExtra("key_selected_albuminfo.name");
      String str = paramIntent.getStringExtra("key_selected_albuminfo.cover");
      i = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
      paramIntent = new StringBuilder();
      paramIntent.append("{albumid:\"");
      paramIntent.append(paramContext);
      paramIntent.append("\",albumname:\"");
      paramIntent.append((String)localObject);
      paramIntent.append("\",albumcover:\"");
      paramIntent.append(str);
      paramIntent.append("\",albumpermission:");
      paramIntent.append(i);
      paramIntent.append("}");
      try
      {
        paramContext = new JSONObject(paramIntent.toString());
        TroopAlbumPlugin.e(this.a).ok(paramContext);
        TroopAlbumPlugin.f(this.a).getAttachedActivity().unregisterReceiver(TroopAlbumPlugin.c(this.a));
        return;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.1
 * JD-Core Version:    0.7.0.1
 */