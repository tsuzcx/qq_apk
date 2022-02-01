package com.tencent.open.sdk.checker;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class AccountChecker$1
  extends ProtoUtils.TroopProtocolObserver
{
  AccountChecker$1(AccountChecker paramAccountChecker, BaseAccountChecker.IAccountCheckCallback paramIAccountCheckCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("check: checkOpenidDiff, code=");
    paramArrayOfByte.append(paramInt);
    QLog.d("AccountChecker", 1, paramArrayOfByte.toString());
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentOpenSdkCheckerBaseAccountChecker$IAccountCheckCallback.a(true);
      return;
    }
    if (paramInt == 16)
    {
      this.jdField_a_of_type_ComTencentOpenSdkCheckerBaseAccountChecker$IAccountCheckCallback.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenSdkCheckerBaseAccountChecker$IAccountCheckCallback.a(paramInt, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.sdk.checker.AccountChecker.1
 * JD-Core Version:    0.7.0.1
 */