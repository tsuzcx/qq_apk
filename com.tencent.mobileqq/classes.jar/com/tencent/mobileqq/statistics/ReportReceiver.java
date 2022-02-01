package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ReportReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {
      return;
    }
    MobileQQ.sMobileQQ.onActivityCreate(this, paramIntent);
    ThreadManager.getSubThreadHandler().post(new ReportReceiver.ReportRunner(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportReceiver
 * JD-Core Version:    0.7.0.1
 */