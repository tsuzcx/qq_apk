package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QQGameHelperImpl$4
  implements Runnable
{
  QQGameHelperImpl$4(QQGameHelperImpl paramQQGameHelperImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.a == 2)
    {
      Object localObject = ((IGamePubAccountMsgService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGamePubAccountMsgService.class, "")).findMessage("2747277822", 1);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (QQGameMsgInfo)((ArrayList)localObject).get(0);
        if ((((QQGameMsgInfo)localObject).isAdMsg) && (((QQGameMsgInfo)localObject).adJson != null)) {
          ((IQQGameAdService)QRoute.api(IQQGameAdService.class)).reportGdt((QQGameMsgInfo)localObject, 2);
        }
      }
    }
    new WadlReportBuilder().a("dc00087").h("771").c("206612").a(1, "76918").a(11, "1").a(12, "160").a(13, this.this$0.getGamePaHippyModuleName()).a(this.b).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.4
 * JD-Core Version:    0.7.0.1
 */