package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

class DailyHandler$1
  implements Runnable
{
  DailyHandler$1(DailyHandler paramDailyHandler, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (this.a.size() > 10) {
          i = this.a.size() - 10;
        }
        Object localObject1 = new StringBuilder();
        j = this.a.size() - 1;
        if (j >= i)
        {
          localObject2 = (BaseReportData)this.a.get(j);
          if ((localObject2 != null) && (((BaseReportData)localObject2).a != null))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((BaseReportData)localObject2).a.mArticleID);
            localStringBuilder.append("_");
            ((StringBuilder)localObject1).append(localStringBuilder.toString());
            ((StringBuilder)localObject1).append(((BaseReportData)localObject2).a.mJumpType);
            if (j != i) {
              ((StringBuilder)localObject1).append("|");
            }
          }
        }
        else
        {
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("epList", localObject1);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009CCA", "0X8009CCA", 0, 0, "", "", "", ((JSONObject)localObject2).toString(), false);
          this.a.clear();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("detachFromViewGroup,msg:");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.d("DailyHandler", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.DailyHandler.1
 * JD-Core Version:    0.7.0.1
 */