package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import cooperation.comic.VipComicJumpActivity;

class LebaQzoneAndPluginPart$12$1
  implements Runnable
{
  LebaQzoneAndPluginPart$12$1(LebaQzoneAndPluginPart.12 param12) {}
  
  public void run()
  {
    IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.a.a.getRuntimeService(IWebProcessManagerService.class, "");
    if ((localIWebProcessManagerService != null) && (localIWebProcessManagerService.isNeedPreloadWebProcess())) {
      localIWebProcessManagerService.startWebProcess(202, new LebaQzoneAndPluginPart.12.1.1(this));
    }
    this.a.this$0.b(this.a.a);
    if (NearbyUtils.b()) {
      NearbyUtils.a("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    NearbyProcessMonitor.a(this.a.a.getAccount(), 0);
    QQGameHelper.e();
    VipComicJumpActivity.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.12.1
 * JD-Core Version:    0.7.0.1
 */