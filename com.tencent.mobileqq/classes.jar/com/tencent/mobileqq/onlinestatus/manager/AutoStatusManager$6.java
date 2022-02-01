package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AutoStatusManager$6
  extends OnlineStatusPermissionObserver
{
  AutoStatusManager$6(AutoStatusManager paramAutoStatusManager) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)AutoStatusManager.a(this.a).getRuntimeService(IOnlineStatusService.class, "");
    boolean bool1 = paramBundle.getBoolean("from_register", false);
    boolean bool2 = OnlineStatusItem.a(localIOnlineStatusService.getOnlineStatus(), localIOnlineStatusService.getExtOnlineStatus());
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, new Object[] { "[status][autoMgr] receiveReqOnlineStatusPermission isSuccess=", Boolean.valueOf(paramBoolean), " isFromRegister :", Boolean.valueOf(bool1), " isSmart=", Boolean.valueOf(bool2) });
    }
    if ((paramBoolean) && (bool1) && (bool2)) {
      this.a.a("enableList");
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission");
      }
      AutoStatusManager.b(this.a);
      int i = this.a.a();
      if ((AutoStatusManager.a(this.a)) && (i > 40001) && (!Constant.a.contains(Integer.valueOf(i))))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("[status][autoMgr] receiveModOnlineStatusPermission cur status: ");
          paramBundle.append(AutoStatusManager.a(this.a));
          paramBundle.append(" is disabled, updateAutoStatus()");
          QLog.e("AutoStatusManager", 2, paramBundle.toString());
        }
        AutoStatusManager.c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.6
 * JD-Core Version:    0.7.0.1
 */