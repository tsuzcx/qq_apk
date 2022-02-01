package com.tencent.open.model;

import android.os.Bundle;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

class AccountManage$1
  extends SSOAccountObserver
{
  AccountManage$1(AccountManage paramAccountManage, AccountManage.GetTicketCallback paramGetTicketCallback) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramBundle.getInt("code"));
    }
    SSOLog.a("SSOAccountObserver", new Object[] { "-->getTicketNoPasswd onFailed", ", action", Integer.valueOf(paramInt1), ", code=", localObject });
    this.jdField_a_of_type_ComTencentOpenModelAccountManage$GetTicketCallback.a(paramString, paramBundle);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    SSOLog.a("BaseAccountManage", new Object[] { "getTicketNoPasswd onGetTicketNoPasswd" });
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    WtloginManager localWtloginManager = (WtloginManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(1);
    AccountInfo localAccountInfo = new AccountInfo();
    localAccountInfo.jdField_b_of_type_JavaLangString = new String(paramArrayOfByte);
    localAccountInfo.jdField_a_of_type_JavaLangString = OpenSdkVirtualUtil.a(localWtloginManager, paramString);
    localAccountInfo.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
    localAccountInfo.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    this.jdField_a_of_type_ComTencentOpenModelAccountManage$GetTicketCallback.a(localAccountInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.1
 * JD-Core Version:    0.7.0.1
 */