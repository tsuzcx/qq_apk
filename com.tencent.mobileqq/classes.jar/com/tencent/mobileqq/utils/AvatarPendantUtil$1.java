package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
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
    AvatarPendantUtil.g = false;
    synchronized (AvatarPendantUtil.f)
    {
      String[] arrayOfString = new String[AvatarPendantUtil.f.size()];
      AvatarPendantUtil.f.toArray(arrayOfString);
      AvatarPendantUtil.f.clear();
      if (arrayOfString.length == 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("bulkGetStrangerPendantId, getStrangerInfo, size=");
        ((StringBuilder)???).append(arrayOfString.length);
        QLog.i("AvatarPendantUtil", 2, ((StringBuilder)???).toString());
      }
      ??? = (IApolloExtensionHandler)this.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      if (??? != null)
      {
        ((IApolloExtensionHandler)???).a(arrayOfString, new int[] { 40530, 27025, 27201, 27235, 27238, 27254 });
        AvatarPendantUtil.c(System.currentTimeMillis());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AvatarPendantUtil.1
 * JD-Core Version:    0.7.0.1
 */