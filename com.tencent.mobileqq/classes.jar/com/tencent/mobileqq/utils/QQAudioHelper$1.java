package com.tencent.mobileqq.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class QQAudioHelper$1
  extends BroadcastReceiver
{
  QQAudioHelper$1(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if ("tencent.video.q2v.debug".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("_debug_Event_index", -1);
        int j = paramIntent.getIntExtra("_debug_Event_value", -1);
        if ((i >= 0) && (i < 39))
        {
          QQAudioHelper.a[i] = j;
          paramContext = new StringBuilder();
          paramContext.append("ReceiverDebugValue, [");
          paramContext.append(i);
          paramContext.append("]=[");
          paramContext.append(j);
          paramContext.append("]");
          QLog.w("AudioHelper", 1, paramContext.toString());
        }
        if (i == 2) {
          QQAudioHelper.a(this.a.getApplicationContext());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQAudioHelper.1
 * JD-Core Version:    0.7.0.1
 */