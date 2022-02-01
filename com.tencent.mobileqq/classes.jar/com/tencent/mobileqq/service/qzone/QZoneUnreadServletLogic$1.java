package com.tencent.mobileqq.service.qzone;

import android.content.ContentResolver;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class QZoneUnreadServletLogic$1
  implements Runnable
{
  QZoneUnreadServletLogic$1(QQAppInterface paramQQAppInterface, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.QZONE_MANAGER);
    if (localObject == null) {
      return;
    }
    if (!(localObject instanceof QZoneManagerImp)) {
      return;
    }
    localObject = (QZoneManagerImp)localObject;
    if (((QZoneManagerImp)localObject).b == null) {
      ((QZoneManagerImp)localObject).b = new ArrayList();
    }
    if (((QZoneManagerImp)localObject).b.size() == 0) {
      QZConfigProviderUtil.b(this.a.getCurrentAccountUin(), ((QZoneManagerImp)localObject).b);
    }
    if (!QZoneUnreadServletLogic.a(this.b, ((QZoneManagerImp)localObject).b))
    {
      ((QZoneManagerImp)localObject).b.clear();
      ((QZoneManagerImp)localObject).b.addAll(this.b);
      try
      {
        BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.h, null, null);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getNavigatorConfigs error:");
          localStringBuilder.append(localException.getMessage());
          QLog.e("UndealCount.QZoneUnreadServletLogic", 2, localStringBuilder.toString(), localException);
        }
      }
      QZConfigProviderUtil.a(this.a.getCurrentAccountUin(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.1
 * JD-Core Version:    0.7.0.1
 */