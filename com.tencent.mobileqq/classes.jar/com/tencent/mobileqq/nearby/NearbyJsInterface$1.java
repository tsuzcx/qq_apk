package com.tencent.mobileqq.nearby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyJsInterface$1
  extends BroadcastReceiver
{
  NearbyJsInterface$1(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    paramContext = new StringBuilder();
    paramContext.append("receive request");
    paramContext.append(paramIntent.getExtras());
    QLog.i("NearbyJsInterface", 2, paramContext.toString());
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (!TextUtils.isEmpty(NearbyJsInterface.c(this.a)))
        {
          i = paramIntent.getIntExtra("exit_mode", 0);
          int j = paramIntent.getIntExtra("exit_action", 0);
          paramContext = new JSONObject();
          try
          {
            paramContext.put("mode", i);
            paramContext.put("action", j);
            this.a.callJs(NearbyJsInterface.c(this.a), new String[] { paramContext.toString() });
          }
          catch (JSONException paramContext)
          {
            paramIntent = new StringBuilder();
            paramIntent.append("onExitProfile, exp:");
            paramIntent.append(paramContext.toString());
            QLog.e("NearbyJsInterface", 2, paramIntent.toString());
          }
          NearbyJsInterface.b(this.a, "");
        }
      }
      else if (!TextUtils.isEmpty(NearbyJsInterface.b(this.a)))
      {
        paramContext = this.a;
        paramContext.callJs(NearbyJsInterface.b(paramContext), new String[] { paramIntent.getStringExtra("data") });
      }
    }
    else if (!TextUtils.isEmpty(NearbyJsInterface.a(this.a)))
    {
      paramContext = this.a;
      paramContext.callJs(NearbyJsInterface.a(paramContext), new String[] { paramIntent.getStringExtra("data") });
      NearbyJsInterface.a(this.a, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.1
 * JD-Core Version:    0.7.0.1
 */