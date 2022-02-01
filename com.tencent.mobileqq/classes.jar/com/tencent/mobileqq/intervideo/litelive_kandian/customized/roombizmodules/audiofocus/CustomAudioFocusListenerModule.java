package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.audiofocus;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;

public class CustomAudioFocusListenerModule
  extends AudioFocusListenerModule
{
  private LifecycleOwner a;
  private Runnable b = new CustomAudioFocusListenerModule.1(this);
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityPause(paramLifecycleOwner);
    if (BusinessManager.a.d()) {
      ThreadCenter.removeDefaultUITask(this.b);
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    if (BusinessManager.a.d())
    {
      this.a = paramLifecycleOwner;
      ThreadCenter.removeDefaultUITask(this.b);
      ThreadCenter.postDefaultUITask(this.b, 100L);
      return;
    }
    super.onActivityResume(paramLifecycleOwner);
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    if (!BusinessManager.a.d()) {
      super.onActivityStart(paramLifecycleOwner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.audiofocus.CustomAudioFocusListenerModule
 * JD-Core Version:    0.7.0.1
 */