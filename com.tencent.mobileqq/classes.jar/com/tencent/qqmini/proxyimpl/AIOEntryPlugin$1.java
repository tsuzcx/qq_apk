package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class AIOEntryPlugin$1
  implements Runnable
{
  AIOEntryPlugin$1(AIOEntryPlugin paramAIOEntryPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    boolean bool;
    if ((AIOEntryPlugin.a(this.this$0).getAttachedActivity() instanceof GameActivity1))
    {
      bool = ((GameActivity1)AIOEntryPlugin.b(this.this$0).getAttachedActivity()).showMiniAIOEntrance(this.a);
    }
    else
    {
      if ((AIOEntryPlugin.c(this.this$0).getMiniAppInfo() != null) && (AIOEntryPlugin.d(this.this$0).getMiniAppInfo().isEngineTypeMiniApp()) && ((AIOEntryPlugin.e(this.this$0) instanceof BaseRuntime)))
      {
        IPage localIPage = ((BaseRuntime)AIOEntryPlugin.f(this.this$0)).getPage();
        if (localIPage != null) {
          localIPage.setMiniAIOEntranceVisible(true, this.a);
        }
      }
      bool = false;
    }
    if (bool)
    {
      this.b.ok();
      return;
    }
    this.b.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.1
 * JD-Core Version:    0.7.0.1
 */