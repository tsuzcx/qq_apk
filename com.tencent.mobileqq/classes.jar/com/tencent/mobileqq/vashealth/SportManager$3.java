package com.tencent.mobileqq.vashealth;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.BusinessObserver;

class SportManager$3
  implements BusinessObserver
{
  SportManager$3(SportManager paramSportManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      ThreadManager.post(new SportManager.3.1(this, paramBundle.getString("StepInfoJSON")), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportManager.3
 * JD-Core Version:    0.7.0.1
 */