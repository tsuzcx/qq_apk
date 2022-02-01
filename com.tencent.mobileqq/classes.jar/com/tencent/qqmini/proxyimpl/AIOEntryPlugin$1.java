package com.tencent.qqmini.proxyimpl;

import bkma;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class AIOEntryPlugin$1
  implements Runnable
{
  public AIOEntryPlugin$1(bkma parambkma, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if ((bkma.a(this.this$0).getAttachedActivity() instanceof GameActivity1)) {}
    for (boolean bool = ((GameActivity1)bkma.b(this.this$0).getAttachedActivity()).showMiniAIOEntrance(this.jdField_a_of_type_OrgJsonJSONObject); bool; bool = false)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
      return;
      if ((bkma.c(this.this$0).getMiniAppInfo() != null) && (bkma.d(this.this$0).getMiniAppInfo().isEngineTypeMiniApp()) && ((bkma.e(this.this$0) instanceof BaseRuntime)))
      {
        IPage localIPage = ((BaseRuntime)bkma.f(this.this$0)).getPage();
        if (localIPage != null) {
          localIPage.setMiniAIOEntranceVisible(true, this.jdField_a_of_type_OrgJsonJSONObject);
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.1
 * JD-Core Version:    0.7.0.1
 */