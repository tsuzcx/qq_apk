package com.tencent.mobileqq.service.qzone;

import android.content.ContentResolver;
import azaw;
import azbw;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import zih;

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
      } while ((localObject == null) || (!(localObject instanceof azbw)));
      localObject = (azbw)localObject;
      if (((azbw)localObject).jdField_a_of_type_JavaUtilArrayList == null) {
        ((azbw)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (((azbw)localObject).jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        zih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((azbw)localObject).jdField_a_of_type_JavaUtilArrayList);
      }
    } while (azaw.a(this.jdField_a_of_type_JavaUtilArrayList, ((azbw)localObject).jdField_a_of_type_JavaUtilArrayList));
    ((azbw)localObject).jdField_a_of_type_JavaUtilArrayList.clear();
    ((azbw)localObject).jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.g, null, null);
      zih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaUtilArrayList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.1
 * JD-Core Version:    0.7.0.1
 */