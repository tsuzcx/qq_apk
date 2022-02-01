package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJUserDeviceInfoReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

final class RIJAppSetting$3
  implements Runnable
{
  RIJAppSetting$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!((QQAppInterface)localObject).isLogin()) {
        return;
      }
      if (NetworkUtil.isWifiEnabled(this.a.getApp()))
      {
        RIJAppSetting.c(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("RIJAppSetting", 2, "handConversationToShow is wifi");
        }
      }
      if (!ReadInJoyHelper.aq(this.a))
      {
        RIJUserDeviceInfoReport.a(this.a);
        ReadInJoyHelper.ar(this.a);
      }
      localObject = (KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (ReadInJoyHelper.ak(this.a))
      {
        ReadInJoyHelper.v(this.a, false);
        if (localObject != null) {
          ((KandianMergeManager)localObject).D();
        }
      }
      else if (localObject != null)
      {
        ((KandianMergeManager)localObject).B();
      }
      ((KandianSubscribeManager)this.a.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).d();
      ((KandianDailyManager)this.a.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting.3
 * JD-Core Version:    0.7.0.1
 */