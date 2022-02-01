package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class BaseAppBrandRuntime$2
  implements StateMachine.OnStateChangeListener
{
  BaseAppBrandRuntime$2(BaseAppBrandRuntime paramBaseAppBrandRuntime, MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString) {}
  
  public void onStateChanged()
  {
    if (((AbsAppBrandService)this.this$0.appBrandService).getCurrState() == ((AbsAppBrandService)this.this$0.appBrandService).stateLoadSucc) {
      AppBrandTask.runTaskOnUiThread(new BaseAppBrandRuntime.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime.2
 * JD-Core Version:    0.7.0.1
 */