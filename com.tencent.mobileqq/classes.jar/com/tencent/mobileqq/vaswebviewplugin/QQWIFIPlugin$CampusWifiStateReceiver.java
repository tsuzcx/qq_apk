package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QQWIFIPlugin$CampusWifiStateReceiver
  extends BroadcastReceiver
{
  public String callback;
  
  private QQWIFIPlugin$CampusWifiStateReceiver(QQWIFIPlugin paramQQWIFIPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (("campus_wifi_state_changed".equals(paramIntent.getAction())) && (!TextUtils.isEmpty(this.callback)))
      {
        int i = paramIntent.getIntExtra("state", -1);
        paramContext = new JSONObject();
        paramContext.put("state", i);
        paramContext = paramContext.toString();
        QLog.i("QQWIFIPlugin", 2, "state callback:" + this.callback + " jsonstring:" + paramContext);
        this.this$0.callJs(this.callback, new String[] { paramContext });
      }
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQWIFIPlugin", 2, "campus wifi state receive erro ", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin.CampusWifiStateReceiver
 * JD-Core Version:    0.7.0.1
 */