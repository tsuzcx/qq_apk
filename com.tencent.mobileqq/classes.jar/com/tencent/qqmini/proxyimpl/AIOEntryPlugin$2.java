package com.tencent.qqmini.proxyimpl;

import bjat;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AIOEntryPlugin$2
  implements Runnable
{
  public AIOEntryPlugin$2(bjat parambjat, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if ((bjat.g(this.this$0).getAttachedActivity() instanceof GameActivity1)) {
      ((GameActivity1)bjat.h(this.this$0).getAttachedActivity()).hideMiniAIOEntrance();
    }
    for (;;)
    {
      this.a.ok();
      return;
      if ((bjat.i(this.this$0).getMiniAppInfo() != null) && (bjat.j(this.this$0).getMiniAppInfo().isEngineTypeMiniApp()) && ((bjat.k(this.this$0) instanceof BaseRuntime)))
      {
        IPage localIPage = ((BaseRuntime)bjat.l(this.this$0)).getPage();
        if (localIPage != null) {
          localIPage.setMiniAIOEntranceVisible(false, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.2
 * JD-Core Version:    0.7.0.1
 */