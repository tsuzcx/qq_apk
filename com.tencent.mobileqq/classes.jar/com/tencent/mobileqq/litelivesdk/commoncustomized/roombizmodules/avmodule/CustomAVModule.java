package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.avmodule;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RecordVideoStateManager;

public class CustomAVModule
  extends AVPreloadPlayerModule
{
  private LifecycleOwner e;
  private Runnable f = new CustomAVModule.1(this);
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityPause(paramLifecycleOwner);
    if (BusinessManager.a.d()) {
      ThreadCenter.removeDefaultUITask(this.f);
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    if (BusinessManager.a.d())
    {
      this.e = paramLifecycleOwner;
      if (!RecordVideoStateManager.a().b())
      {
        ThreadCenter.removeDefaultUITask(this.f);
        ThreadCenter.postDefaultUITask(this.f, 100L);
      }
    }
    else
    {
      super.onActivityResume(paramLifecycleOwner);
    }
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    if (!BusinessManager.a.d()) {
      super.onActivityStart(paramLifecycleOwner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.avmodule.CustomAVModule
 * JD-Core Version:    0.7.0.1
 */