package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
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
    Object localObject1;
    Object localObject2;
    int i;
    if ("troop_upload".equals(paramIntent.getAction()))
    {
      paramContext = TroopAlbumPlugin.access$000(this.this$0);
      if (paramContext == null) {
        return;
      }
      localObject1 = paramContext.getActivity();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("troop_album");
      ((StringBuilder)localObject2).append(BaseApplicationImpl.sApplication.getRuntime().getAccount());
      localObject1 = ((Activity)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit();
      localObject2 = new JSONObject();
      i = paramIntent.getIntExtra("count", 0);
      boolean bool = paramIntent.getBooleanExtra("fail", false);
      try
      {
        ((JSONObject)localObject2).put("count", i);
        ((JSONObject)localObject2).put("isFail", bool);
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
          ((SharedPreferences.Editor)localObject1).putBoolean("is_exit_fail_misson", true).apply();
        } else {
          ((SharedPreferences.Editor)localObject1).putBoolean("is_exit_fail_misson", false).apply();
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      paramContext.callJs("groupAlbum_onGroupAlbumUpload", (JSONObject)localObject2);
      if (i == 0)
      {
        ((SharedPreferences.Editor)localObject1).putBoolean("is_exit_fail_misson", false).apply();
        try
        {
          paramContext.getActivity().unregisterReceiver(TroopAlbumPlugin.access$100(this.this$0));
        }
        catch (IllegalArgumentException paramContext)
        {
          QLog.i("TroopAlbumPlugin", 2, paramContext.getMessage());
        }
        TroopAlbumPlugin.access$002(this.this$0, null);
      }
    }
    else if ("troop_select".equals(paramIntent.getAction()))
    {
      QLog.w("TroopAlbumPlugin", 2, "troop_select recive");
      paramContext = paramIntent.getStringExtra("key_selected_albuminfo.id");
      localObject1 = paramIntent.getStringExtra("key_selected_albuminfo.name");
      localObject2 = paramIntent.getStringExtra("key_selected_albuminfo.cover");
      i = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
      paramIntent = new StringBuilder();
      paramIntent.append("{albumid:\"");
      paramIntent.append(paramContext);
      paramIntent.append("\",albumname:\"");
      paramIntent.append((String)localObject1);
      paramIntent.append("\",albumcover:\"");
      paramIntent.append((String)localObject2);
      paramIntent.append("\",albumpermission:");
      paramIntent.append(i);
      paramIntent.append("}");
      try
      {
        paramContext = new JSONObject(paramIntent.toString());
        TroopAlbumPlugin.access$000(this.this$0).evaluateCallback(true, paramContext, "");
        TroopAlbumPlugin.access$000(this.this$0).getActivity().unregisterReceiver(TroopAlbumPlugin.access$100(this.this$0));
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
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.1
 * JD-Core Version:    0.7.0.1
 */