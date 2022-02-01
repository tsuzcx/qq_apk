package com.tencent.mobileqq.vashealth.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.config.StepConfigBean;
import com.tencent.mobileqq.vashealth.config.StepConfigProcessor;
import mqq.observer.BusinessObserver;

class SportManagerImpl$3
  implements BusinessObserver
{
  SportManagerImpl$3(SportManagerImpl paramSportManagerImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if (StepConfigProcessor.a().a() == 2)
      {
        SSOHttpUtils.a(this.a.mApp, paramBundle);
        return;
      }
      ThreadManager.post(new SportManagerImpl.3.1(this, paramBundle.getString("StepInfoJSON")), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */