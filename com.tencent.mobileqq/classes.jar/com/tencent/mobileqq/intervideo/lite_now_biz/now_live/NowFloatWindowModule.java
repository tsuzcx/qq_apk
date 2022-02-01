package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.litepages.room.bizmodule.AudLiteFloatWindowModule;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.WebPageEvent;

public class NowFloatWindowModule
  extends AudLiteFloatWindowModule
{
  private Observer<WebPageEvent> a = new NowFloatWindowModule.1(this);
  
  private void a()
  {
    FloatWindowConfigServiceInterface localFloatWindowConfigServiceInterface = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    localFloatWindowConfigServiceInterface.setFloatWindowEnabledOnce(true);
    localFloatWindowConfigServiceInterface.setFloatWindowEnabledAllTime(true);
  }
  
  private void b()
  {
    FloatWindowConfigServiceInterface localFloatWindowConfigServiceInterface = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    localFloatWindowConfigServiceInterface.setFloatWindowEnabledOnce(false);
    localFloatWindowConfigServiceInterface.setFloatWindowEnabledAllTime(false);
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    getEvent().observe(WebPageEvent.class, this.a);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getEvent().removeObserver(WebPageEvent.class, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowFloatWindowModule
 * JD-Core Version:    0.7.0.1
 */