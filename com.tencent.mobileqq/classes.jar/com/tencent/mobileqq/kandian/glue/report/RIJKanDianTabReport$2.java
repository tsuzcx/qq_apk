package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
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
          localObject = ((KandianMergeManager)localObject).Q();
          if ((localObject != null) && (!((KandianMsgBoxRedPntInfo)localObject).isExpose))
          {
            ((KandianMsgBoxRedPntInfo)localObject).isExpose = true;
            ((KandianMsgBoxRedPntInfo)localObject).asyncWriteToSP();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("tab_status", 3);
            localJSONObject.put("reddot_num", RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount((KandianMsgBoxRedPntInfo)localObject));
            PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80091DC", "0X80091DC", 0, 0, "0", "", "", localJSONObject.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport.2
 * JD-Core Version:    0.7.0.1
 */