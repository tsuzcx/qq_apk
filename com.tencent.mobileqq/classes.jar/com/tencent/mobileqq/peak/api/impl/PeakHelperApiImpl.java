package com.tencent.mobileqq.peak.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

public class PeakHelperApiImpl
  implements IPeakHelperApi
{
  public String TIMESTAMP()
  {
    return "PhotoConst.timestamp";
  }
  
  public String TIMESTAMP_LAST_ACTIVITY()
  {
    return "PhotoConst.timestamp_last_activity";
  }
  
  public void cancelPeakAlive(Context paramContext)
  {
    ThreadManager.getSubThreadHandler().post(new PeakHelperApiImpl.2(this, paramContext));
  }
  
  public Class getPublicFragmentActivityForPeakClass()
  {
    return PublicFragmentActivityForPeak.class;
  }
  
  public boolean isPeakAlive(Context paramContext)
  {
    return ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(paramContext);
  }
  
  public void preloadPeakProcess(Context paramContext)
  {
    ThreadManager.getSubThreadHandler().post(new PeakHelperApiImpl.1(this, paramContext));
  }
  
  public void startWithPublicFragmentActivityForPeak(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, paramClass1, paramClass2);
  }
  
  public void startWithPublicFragmentActivityForPeakForResult(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, paramClass1, paramClass2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.peak.api.impl.PeakHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */