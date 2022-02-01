package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import aoip;
import bdll;
import bguq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class TroopUtils$5
  implements Runnable
{
  public TroopUtils$5(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString, this.b);
    int j = 0;
    for (;;)
    {
      try
      {
        String[] arrayOfString = this.c.split("_");
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
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD4F", "0X800AD4F", (int)l, 0, String.valueOf(i), "", "", "");
          ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).c(this.jdField_a_of_type_JavaLangString, 2, j);
          j = i;
          if (localTroopMemberInfo == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick open card " + this.b + " " + this.c);
          }
          if (this.jdField_a_of_type_AndroidContentContext != null) {
            bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.b, j, this.jdField_a_of_type_JavaLangString);
          }
          return;
        }
        catch (Exception localException2)
        {
          int i;
          break label214;
        }
        localException1 = localException1;
        i = 0;
      }
      label214:
      if (QLog.isColorLevel())
      {
        QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick " + localException1);
        j = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopUtils", 2, "checkAndOpenMemberProfileForRecommendTipsClick no member " + this.b);
    }
    ThreadManager.getUIHandler().post(new TroopUtils.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.5
 * JD-Core Version:    0.7.0.1
 */