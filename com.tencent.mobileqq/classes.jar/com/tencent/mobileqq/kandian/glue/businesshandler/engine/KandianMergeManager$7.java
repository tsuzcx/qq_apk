package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.ad.api.IRIJMiniGameService;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

class KandianMergeManager$7
  implements MiniAppNotify.IMiniAppNotifyListener
{
  KandianMergeManager$7(KandianMergeManager paramKandianMergeManager) {}
  
  public void onNotify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appid: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" scene: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" via: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" event: ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" timestamp: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
    localObject = Arrays.asList(Aladdin.getConfig(329).getString("scene", "").split("\\|"));
    List localList = Arrays.asList(Aladdin.getConfig(329).getString("via", "").split("\\|"));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniapp config: ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(localList);
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
    if ("onResume".equals(paramString3))
    {
      if (localObject != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramInt);
        paramString1.append("");
        if ((((List)localObject).contains(paramString1.toString())) && (localList != null) && (localList.contains(paramString2)))
        {
          paramInt = RIJAppSetting.a();
          int i = RIJKanDianFolderStatus.reportFolderStatus;
          KandianMergeManager.a(this.a).a(KandianMergeManager.a(this.a), NetConnInfoCenter.getServerTimeMillis(), paramInt, i);
        }
      }
      ((IRIJMiniGameService)QRoute.api(IRIJMiniGameService.class)).setEnterTime(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      return;
    }
    if ("onPause".equals(paramString3))
    {
      paramString3 = new StringBuilder();
      paramString3.append(paramInt);
      paramString3.append("");
      if ((((List)localObject).contains(paramString3.toString())) && (localList != null) && (localList.contains(paramString2)) && (KandianMergeManager.a(this.a).a() > 0L)) {
        KandianMergeManager.a(this.a).a();
      }
      ((IRIJMiniGameService)QRoute.api(IRIJMiniGameService.class)).notifySmallGameView(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.7
 * JD-Core Version:    0.7.0.1
 */