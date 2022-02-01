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
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[onReceive] action=");
      paramContext.append(paramIntent.getAction());
      QLog.d("QCircleBroadcastReceiver", 2, paramContext.toString());
    }
    paramContext = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("followstate", -1);
    if ((!TextUtils.isEmpty(paramContext)) && (i >= 0))
    {
      paramIntent = new HashMap();
      paramIntent.put("userId", paramContext);
      paramIntent.put("followState", Integer.valueOf(i));
      TencentQQCirclePlugin.sendEvent("tencent_qqcircle/follow", paramIntent);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] invalid params, uin=");
    paramIntent.append(paramContext);
    paramIntent.append(", state=");
    paramIntent.append(i);
    QLog.e("QCircleBroadcastReceiver", 1, paramIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */