package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.litepages.room.bizmodule.AudLiteFloatWindowModule;
import com.tencent.livesdk.liveengine.LiveEngine;

public class NowFloatWindowModule
  extends AudLiteFloatWindowModule
{
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    paramContext = (FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class);
    paramContext.setFloatWindowEnabledOnce(true);
    paramContext.setFloatWindowEnabledAllTime(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowFloatWindowModule
 * JD-Core Version:    0.7.0.1
 */