package com.tencent.qqprotect.qsec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SFUBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent = paramIntent.getPackage();
    } while ((paramIntent == null) || (!paramIntent.equals(paramContext.getPackageName())));
    QSecFramework.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.SFUBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */