package com.tencent.mobileqq.peak.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class PeakHelperApiImpl$2
  implements Runnable
{
  PeakHelperApiImpl$2(PeakHelperApiImpl paramPeakHelperApiImpl, Context paramContext) {}
  
  public void run()
  {
    if (((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(this.a)) {
      return;
    }
    Intent localIntent = new Intent(this.a, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getPeakServiceClass());
    localIntent.putExtra("ServiceAction", 5);
    localIntent.putExtra("key_alive", false);
    try
    {
      this.a.startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QCirclePluginInitHelper", 2, "preload peak fail ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.peak.api.impl.PeakHelperApiImpl.2
 * JD-Core Version:    0.7.0.1
 */