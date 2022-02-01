package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AutoStatusManager$6
  extends OnlineStatusPermissionObserver
{
  AutoStatusManager$6(AutoStatusManager paramAutoStatusManager) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission");
      }
      AutoStatusManager.b(this.a);
      int i = this.a.a();
      if ((AutoStatusManager.a(this.a)) && (i > 40001) && (!Constant.a.contains(Integer.valueOf(i))))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] receiveModOnlineStatusPermission cur status: " + AutoStatusManager.a(this.a) + " is disabled, updateAutoStatus()");
        }
        AutoStatusManager.c(this.a);
      }
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    boolean bool1 = paramBundle.getBoolean("from_register", false);
    boolean bool2 = OnlineStatusItem.a(AutoStatusManager.a(this.a).getOnlineStatus(), AutoStatusManager.a(this.a).getExtOnlineStatus());
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, new Object[] { "[status][autoMgr] receiveReqOnlineStatusPermission isSuccess=", Boolean.valueOf(paramBoolean), " isFromRegister :", Boolean.valueOf(bool1), " isSmart=", Boolean.valueOf(bool2) });
    }
    if ((paramBoolean) && (bool1) && (bool2)) {
      this.a.a("enableList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.6
 * JD-Core Version:    0.7.0.1
 */