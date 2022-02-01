package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class RIJKanDianTabReport$2
  implements Runnable
{
  RIJKanDianTabReport$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        Object localObject = (KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        if (localObject != null)
        {
          localObject = ((KandianMergeManager)localObject).a();
          if ((localObject != null) && (!((KandianMsgBoxRedPntInfo)localObject).isExpose))
          {
            ((KandianMsgBoxRedPntInfo)localObject).isExpose = true;
            ((KandianMsgBoxRedPntInfo)localObject).asyncWriteToSP();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("tab_status", 3);
            localJSONObject.put("reddot_num", ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80091DC", "0X80091DC", 0, 0, "0", "", "", localJSONObject.toString(), false);
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RIJKanDianTabReport", 2, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport.2
 * JD-Core Version:    0.7.0.1
 */