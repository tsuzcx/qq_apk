package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class AIOEntryPlugin$2
  implements Runnable
{
  AIOEntryPlugin$2(AIOEntryPlugin paramAIOEntryPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if ((AIOEntryPlugin.g(this.this$0).getAttachedActivity() instanceof GameActivity1)) {
      ((GameActivity1)AIOEntryPlugin.h(this.this$0).getAttachedActivity()).hideMiniAIOEntrance();
    }
    for (;;)
    {
      this.a.ok();
      return;
      if ((AIOEntryPlugin.i(this.this$0).getMiniAppInfo() != null) && (AIOEntryPlugin.j(this.this$0).getMiniAppInfo().isEngineTypeMiniApp()) && ((AIOEntryPlugin.k(this.this$0) instanceof BaseRuntime)))
      {
        IPage localIPage = ((BaseRuntime)AIOEntryPlugin.l(this.this$0)).getPage();
        if (localIPage != null) {
          localIPage.setMiniAIOEntranceVisible(false, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.2
 * JD-Core Version:    0.7.0.1
 */