package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.avmodule;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RecordVideoStateManager;

public class CustomAVModule
  extends AVPreloadPlayerModule
{
  private LifecycleOwner jdField_a_of_type_AndroidxLifecycleLifecycleOwner;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CustomAVModule.1(this);
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityPause(paramLifecycleOwner);
    if (BusinessManager.a.b()) {
      ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    if (BusinessManager.a.b())
    {
      this.jdField_a_of_type_AndroidxLifecycleLifecycleOwner = paramLifecycleOwner;
      if (!RecordVideoStateManager.a().a())
      {
        ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
        ThreadCenter.postDefaultUITask(this.jdField_a_of_type_JavaLangRunnable, 100L);
      }
    }
    else
    {
      super.onActivityResume(paramLifecycleOwner);
    }
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    if (!BusinessManager.a.b()) {
      super.onActivityStart(paramLifecycleOwner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.avmodule.CustomAVModule
 * JD-Core Version:    0.7.0.1
 */