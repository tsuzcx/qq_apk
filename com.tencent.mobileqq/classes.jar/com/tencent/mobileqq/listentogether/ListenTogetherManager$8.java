package com.tencent.mobileqq.listentogether;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

class ListenTogetherManager$8
  extends BroadcastReceiver
{
  ListenTogetherManager$8(ListenTogetherManager paramListenTogetherManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
      return;
    }
    QLog.i("ListenTogether.Manager", 1, "onThemeChange.");
    ListenTogetherManager.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.8
 * JD-Core Version:    0.7.0.1
 */