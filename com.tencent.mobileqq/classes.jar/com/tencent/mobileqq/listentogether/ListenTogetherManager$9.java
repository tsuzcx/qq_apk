package com.tencent.mobileqq.listentogether;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

class ListenTogetherManager$9
  extends BroadcastReceiver
{
  ListenTogetherManager$9(ListenTogetherManager paramListenTogetherManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getIntExtra("pid", Process.myPid()) == Process.myPid())
    {
      QLog.i("ListenTogether.Manager", 1, "onThemeChange.");
      ListenTogetherManager.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.9
 * JD-Core Version:    0.7.0.1
 */