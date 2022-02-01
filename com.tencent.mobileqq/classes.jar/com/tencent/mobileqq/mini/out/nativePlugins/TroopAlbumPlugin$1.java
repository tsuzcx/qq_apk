package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
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
      paramContext = TroopAlbumPlugin.access$000(this.this$0);
      if (paramContext != null) {}
    }
    label230:
    while (!"troop_select".equals(paramIntent.getAction()))
    {
      do
      {
        return;
        localObject1 = paramContext.getActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).edit();
        localObject2 = new JSONObject();
        i = paramIntent.getIntExtra("count", 0);
        boolean bool = paramIntent.getBooleanExtra("fail", false);
        try
        {
          ((JSONObject)localObject2).put("count", i);
          ((JSONObject)localObject2).put("isFail", bool);
          if (QLog.isColorLevel()) {
            QLog.w("TroopAlbumPlugin", 2, "troopAlbumReceiver" + i + ",isfail" + bool);
          }
          if (!bool) {
            break label230;
          }
          ((SharedPreferences.Editor)localObject1).putBoolean("is_exit_fail_misson", true).apply();
        }
        catch (JSONException paramIntent)
        {
          try
          {
            for (;;)
            {
              paramContext.getActivity().unregisterReceiver(TroopAlbumPlugin.access$100(this.this$0));
              TroopAlbumPlugin.access$002(this.this$0, null);
              return;
              ((SharedPreferences.Editor)localObject1).putBoolean("is_exit_fail_misson", false).apply();
            }
            paramIntent = paramIntent;
            paramIntent.printStackTrace();
          }
          catch (IllegalArgumentException paramContext)
          {
            for (;;)
            {
              QLog.i("TroopAlbumPlugin", 2, paramContext.getMessage());
            }
          }
        }
        paramContext.callJs("groupAlbum_onGroupAlbumUpload", (JSONObject)localObject2);
      } while (i != 0);
      ((SharedPreferences.Editor)localObject1).putBoolean("is_exit_fail_misson", false).apply();
    }
    QLog.w("TroopAlbumPlugin", 2, "troop_select recive");
    paramContext = paramIntent.getStringExtra("key_selected_albuminfo.id");
    Object localObject1 = paramIntent.getStringExtra("key_selected_albuminfo.name");
    Object localObject2 = paramIntent.getStringExtra("key_selected_albuminfo.cover");
    int i = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
    paramIntent = new StringBuilder();
    paramIntent.append("{albumid:\"").append(paramContext).append("\",albumname:\"").append((String)localObject1).append("\",albumcover:\"").append((String)localObject2).append("\",albumpermission:").append(i).append("}");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.1
 * JD-Core Version:    0.7.0.1
 */