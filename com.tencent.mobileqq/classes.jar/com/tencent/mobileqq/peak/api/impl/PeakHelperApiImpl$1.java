package com.tencent.mobileqq.peak.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMShortVideoUtils;

class PeakHelperApiImpl$1
  implements Runnable
{
  PeakHelperApiImpl$1(PeakHelperApiImpl paramPeakHelperApiImpl, Context paramContext) {}
  
  public void run()
  {
    if (QIMShortVideoUtils.a(this.a)) {}
    do
    {
      return;
      Intent localIntent = new Intent(this.a, PeakService.class);
      localIntent.putExtra("ServiceAction", 2);
      localIntent.putExtra("key_alive", true);
      try
      {
        this.a.startService(localIntent);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("QCirclePluginInitHelper", 2, "preload peak fail ", localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.peak.api.impl.PeakHelperApiImpl.1
 * JD-Core Version:    0.7.0.1
 */