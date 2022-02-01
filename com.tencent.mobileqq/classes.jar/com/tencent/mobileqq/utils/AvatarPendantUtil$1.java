package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class AvatarPendantUtil$1
  implements Runnable
{
  AvatarPendantUtil$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    AvatarPendantUtil.jdField_a_of_type_Boolean = false;
    do
    {
      synchronized (AvatarPendantUtil.jdField_a_of_type_JavaUtilArrayList)
      {
        String[] arrayOfString1 = new String[AvatarPendantUtil.jdField_a_of_type_JavaUtilArrayList.size()];
        AvatarPendantUtil.jdField_a_of_type_JavaUtilArrayList.toArray(arrayOfString1);
        AvatarPendantUtil.jdField_a_of_type_JavaUtilArrayList.clear();
        if (arrayOfString1.length == 0) {
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, getStrangerInfo, size=" + arrayOfString2.length);
      }
      ??? = (IApolloExtensionHandler)this.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    } while (??? == null);
    ((IApolloExtensionHandler)???).a(arrayOfString2, new int[] { 40530, 27025, 27201, 27235, 27238, 27254 });
    AvatarPendantUtil.a(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AvatarPendantUtil.1
 * JD-Core Version:    0.7.0.1
 */