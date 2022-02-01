package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QCircleBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleBroadcastReceiver", 2, "[onReceive] action=" + paramIntent.getAction());
    }
    paramContext = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("followstate", -1);
    if ((TextUtils.isEmpty(paramContext)) || (i < 0))
    {
      QLog.e("QCircleBroadcastReceiver", 1, "[onReceive] invalid params, uin=" + paramContext + ", state=" + i);
      return;
    }
    paramIntent = new HashMap();
    paramIntent.put("userId", paramContext);
    paramIntent.put("followState", Integer.valueOf(i));
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/follow", paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */