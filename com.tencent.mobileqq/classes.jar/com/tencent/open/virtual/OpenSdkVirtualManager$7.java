package com.tencent.open.virtual;

import android.os.Bundle;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

class OpenSdkVirtualManager$7
  extends SSOAccountObserver
{
  OpenSdkVirtualManager$7(OpenSdkVirtualManager paramOpenSdkVirtualManager, OpenSDKAppInterface paramOpenSDKAppInterface, OpenSdkVirtualManager.GetTicketCallback paramGetTicketCallback) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramBundle.getInt("code")))
    {
      QLog.d("SSOAccountObserver", 1, new Object[] { "-->getTicketNoPasswd onFailed", ", action", Integer.valueOf(paramInt1), ", code=", localObject });
      this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager$GetTicketCallback.a(paramString, paramBundle);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SSOAccountObserver", 1, "-->getTicketNoPasswd onGetTicketNoPasswd");
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    WtloginManager localWtloginManager = (WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1);
    AccountInfo localAccountInfo = new AccountInfo();
    localAccountInfo.jdField_b_of_type_JavaLangString = new String(paramArrayOfByte);
    localAccountInfo.jdField_a_of_type_JavaLangString = Long.toString(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(localWtloginManager, paramString));
    localAccountInfo.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
    localAccountInfo.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager$GetTicketCallback.a(localAccountInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.7
 * JD-Core Version:    0.7.0.1
 */