package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.audiofocus;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;

public class CustomAudioFocusListenerModule
  extends AudioFocusListenerModule
{
  private LifecycleOwner jdField_a_of_type_AndroidxLifecycleLifecycleOwner;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CustomAudioFocusListenerModule.1(this);
  
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
      ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
      ThreadCenter.postDefaultUITask(this.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    super.onActivityResume(paramLifecycleOwner);
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    if (!BusinessManager.a.b()) {
      super.onActivityStart(paramLifecycleOwner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.audiofocus.CustomAudioFocusListenerModule
 * JD-Core Version:    0.7.0.1
 */