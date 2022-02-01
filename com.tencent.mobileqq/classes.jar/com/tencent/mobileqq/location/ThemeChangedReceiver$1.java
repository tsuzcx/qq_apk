package com.tencent.mobileqq.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

class ThemeChangedReceiver$1
  extends BroadcastReceiver
{
  ThemeChangedReceiver$1(ThemeChangedReceiver paramThemeChangedReceiver) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if ((paramIntent.getIntExtra("pid", Process.myPid()) == Process.myPid()) && (ThemeChangedReceiver.a(this.a) != null)) {
      ThemeChangedReceiver.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ThemeChangedReceiver.1
 * JD-Core Version:    0.7.0.1
 */