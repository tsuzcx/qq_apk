package com.tencent.mobileqq.qqgamepub.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class GamePubAccountHelper$2
  implements Runnable
{
  GamePubAccountHelper$2(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {}
  
  public void run()
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.f = "vab_push";
    localTianShuReportData.g = "vab_push";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.c = 1;
    localTianShuReportData.h = this.a;
    localTianShuReportData.i = "";
    localTianShuReportData.o = l;
    localTianShuReportData.p = this.b;
    localTianShuReportData.l = Integer.toString(this.c);
    localTianShuReportData.q = 1;
    localTianShuReportData.r = this.d;
    localTianShuReportData.s = this.e;
    ((ITianshuManager)QRoute.api(ITianshuManager.class)).report(localTianShuReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.2
 * JD-Core Version:    0.7.0.1
 */