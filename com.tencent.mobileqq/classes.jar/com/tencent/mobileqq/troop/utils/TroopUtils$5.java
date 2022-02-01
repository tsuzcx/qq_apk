package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import aoep;
import bdla;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class TroopUtils$5
  implements Runnable
{
  TroopUtils$5(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.val$app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.val$troopUin, this.val$memberUin);
    int j = 0;
    for (;;)
    {
      try
      {
        String[] arrayOfString = this.val$grayTypeAndSubID.split("_");
        i = j;
        if (arrayOfString != null)
        {
          i = j;
          if (arrayOfString.length > 2)
          {
            j = Integer.parseInt(arrayOfString[0]);
            i = Integer.parseInt(arrayOfString[1]);
          }
        }
        long l;
        j = i;
      }
      catch (Exception localException1)
      {
        try
        {
          l = Long.parseLong(arrayOfString[2]);
          bdla.b(this.val$app, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(i), "", "", "");
          ((aoep)this.val$app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).c(this.val$troopUin, 2, j);
          j = i;
          if (localTroopMemberInfo == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick open card " + this.val$memberUin + " " + this.val$grayTypeAndSubID);
          }
          if (this.val$context != null) {
            TroopUtils.openUserProfileCardForTroopRecommend(this.val$app, this.val$context, this.val$memberUin, j, this.val$troopUin);
          }
          return;
        }
        catch (Exception localException2)
        {
          int i;
          break label216;
        }
        localException1 = localException1;
        i = 0;
      }
      label216:
      if (QLog.isColorLevel())
      {
        QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick " + localException1);
        j = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick no member " + this.val$memberUin);
    }
    ThreadManager.getUIHandler().post(new TroopUtils.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.5
 * JD-Core Version:    0.7.0.1
 */