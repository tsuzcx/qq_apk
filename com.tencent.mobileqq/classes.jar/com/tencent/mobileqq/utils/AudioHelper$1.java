package com.tencent.mobileqq.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class AudioHelper$1
  extends BroadcastReceiver
{
  AudioHelper$1(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!"tencent.video.q2v.debug".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("_debug_Event_index", -1);
      int j = paramIntent.getIntExtra("_debug_Event_value", -1);
      if ((i >= 0) && (i < 39))
      {
        AudioHelper.a[i] = j;
        QLog.w("AudioHelper", 1, "ReceiverDebugValue, [" + i + "]=[" + j + "]");
      }
    } while (i != 2);
    AudioHelper.a(this.a.getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper.1
 * JD-Core Version:    0.7.0.1
 */