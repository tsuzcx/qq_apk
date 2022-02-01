package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import atig;
import atii;
import atio;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QCircleBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleBroadcastReceiver", 2, "[onReceive]");
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
    atig localatig = atii.a().a("tencent_qqcircle");
    if (!(localatig instanceof atio))
    {
      QLog.e("QCircleBroadcastReceiver", 1, "[onReceive] channel=" + localatig);
      return;
    }
    QLog.d("QCircleBroadcastReceiver", 1, "[onReceive] userId=" + paramContext + ", state=" + i);
    ((atio)localatig).a("tencent_qqcircle/follow", paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */