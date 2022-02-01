package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

public class ActDAUReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ActDAUReceiver
 * JD-Core Version:    0.7.0.1
 */