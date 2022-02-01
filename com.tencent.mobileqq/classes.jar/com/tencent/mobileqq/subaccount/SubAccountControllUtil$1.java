package com.tencent.mobileqq.subaccount;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;

final class SubAccountControllUtil$1
  extends SubAccountObserver
{
  SubAccountControllUtil$1(AppInterface paramAppInterface) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("initAllData() onGetKeyBack() thread.name=");
      paramString1.append(Thread.currentThread().getName());
      QLog.d("SUB_ACCOUNT", 2, paramString1.toString());
    }
    paramString1 = (ISubAccountService)this.a.getRuntimeService(ISubAccountService.class, "");
    int j = 0;
    int i = j;
    if (paramString3 != null)
    {
      i = j;
      if (paramString3.length() > 0)
      {
        if (paramString1 != null) {
          paramString1.updateA2(paramString2, paramString3, false);
        }
        i = 1;
      }
    }
    if (i == 0) {
      paramString1.clearUnreadNum(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControllUtil.1
 * JD-Core Version:    0.7.0.1
 */