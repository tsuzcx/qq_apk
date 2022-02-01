package com.tencent.open.model;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

class AccountManage$2
  extends SSOAccountObserver
{
  AccountManage$2(AccountManage paramAccountManage, SSOAccountObserver paramSSOAccountObserver) {}
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    Manager localManager = AccountManage.a(this.jdField_a_of_type_ComTencentOpenModelAccountManage).getManager(1);
    if (localManager != null)
    {
      long l = System.currentTimeMillis();
      ((WtloginManager)localManager).refreshMemorySig();
      QLog.d("open_log", 1, new Object[] { "refreshMemorySig cost : ", Long.valueOf(System.currentTimeMillis() - l) });
    }
    ThreadManager.getUIHandler().post(new AccountManage.2.2(this, paramString, paramArrayOfByte, paramInt, paramBundle));
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver.onFailed(paramString, paramInt1, paramInt2, paramBundle);
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver.onGetA1WithA1(paramString, paramInt1, paramArrayOfByte, paramInt2, paramBundle);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    ThreadManager.excute(new AccountManage.2.1(this, paramString, paramArrayOfByte, paramInt, paramBundle), 128, null, true);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver.onLoginSuccess(paramString, paramArrayOfByte, paramInt, paramBundle);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver.onUserCancel(paramString, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.2
 * JD-Core Version:    0.7.0.1
 */