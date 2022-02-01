package com.tencent.mobileqq.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

final class BusinessUtils$1
  implements Runnable
{
  BusinessUtils$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mLoginTime = NetConnInfoCenter.getServerTime();
    RecentDataListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.sApplication, false, true);
    try
    {
      Common.OnLogin(BaseApplicationImpl.sApplication, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loginSuccessInit kingkong OnLogin throwable: ");
        localStringBuilder.append(localThrowable);
        QLog.d("login", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.BusinessUtils.1
 * JD-Core Version:    0.7.0.1
 */