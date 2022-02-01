package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class TroopUtils$4
  implements Runnable
{
  TroopUtils$4(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    Object localObject = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.b, this.c);
    int m = 0;
    int k = 0;
    int i = k;
    int j;
    try
    {
      String[] arrayOfString = this.d.split("_");
      j = m;
      if (arrayOfString != null)
      {
        i = k;
        j = m;
        if (arrayOfString.length > 2)
        {
          i = k;
          m = Integer.parseInt(arrayOfString[0]);
          i = k;
          j = Integer.parseInt(arrayOfString[1]);
          i = j;
          long l = Long.parseLong(arrayOfString[2]);
          i = j;
          ReportController.b(this.a, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(j), "", "", "");
          i = j;
          ((ITroopRecommendHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER)).a(this.b, 2, m);
        }
      }
    }
    catch (Exception localException)
    {
      j = i;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndOpenMemberProfileForRecommendTipsClick ");
        localStringBuilder.append(localException);
        QLog.i("TroopMemberUtil", 2, localStringBuilder.toString());
        j = i;
      }
    }
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndOpenMemberProfileForRecommendTipsClick open card ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.d);
        QLog.i("TroopMemberUtil", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.e;
      if (localObject != null) {
        TroopUtils.a(this.a, (Context)localObject, this.c, j, this.b);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndOpenMemberProfileForRecommendTipsClick no member ");
        ((StringBuilder)localObject).append(this.c);
        QLog.i("TroopMemberUtil", 2, ((StringBuilder)localObject).toString());
      }
      ThreadManager.getUIHandler().post(new TroopUtils.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.4
 * JD-Core Version:    0.7.0.1
 */