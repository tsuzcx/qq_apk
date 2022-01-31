package com.tencent.mobileqq.service.qzone;

import android.content.ContentResolver;
import axbj;
import axcj;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import xoz;

public final class QZoneUnreadServletLogic$1
  implements Runnable
{
  public QZoneUnreadServletLogic$1(QQAppInterface paramQQAppInterface, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      } while ((localObject == null) || (!(localObject instanceof axcj)));
      localObject = (axcj)localObject;
      if (((axcj)localObject).jdField_a_of_type_JavaUtilArrayList == null) {
        ((axcj)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (((axcj)localObject).jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        xoz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((axcj)localObject).jdField_a_of_type_JavaUtilArrayList);
      }
    } while (axbj.a(this.jdField_a_of_type_JavaUtilArrayList, ((axcj)localObject).jdField_a_of_type_JavaUtilArrayList));
    ((axcj)localObject).jdField_a_of_type_JavaUtilArrayList.clear();
    ((axcj)localObject).jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.g, null, null);
      xoz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("UndealCount.QZoneUnreadServletLogic", 2, "getNavigatorConfigs error:" + localException.getMessage(), localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.1
 * JD-Core Version:    0.7.0.1
 */