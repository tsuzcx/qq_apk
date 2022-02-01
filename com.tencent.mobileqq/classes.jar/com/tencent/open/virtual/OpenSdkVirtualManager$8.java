package com.tencent.open.virtual;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.model.AccountInfo;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class OpenSdkVirtualManager$8
  implements BusinessObserver
{
  OpenSdkVirtualManager$8(OpenSdkVirtualManager paramOpenSdkVirtualManager, AccountInfo paramAccountInfo, boolean paramBoolean, OpenSdkVirtualManager.PreAuthCallback paramPreAuthCallback, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(OpenSdkVirtualManager.c(this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager)), ", errorCode=", Integer.valueOf(paramInt) });
    if ((OpenSdkVirtualManager.c(this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager) < this.jdField_a_of_type_Int) && (paramInt != 110537) && (paramInt != 110509))
    {
      OpenSdkVirtualManager.d(this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager);
      this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentOpenModelAccountInfo, this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager$PreAuthCallback, this.jdField_a_of_type_Int);
      return;
    }
    OpenSdkVirtualManager.b(this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager, 0);
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager$PreAuthCallback.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(OpenSdkVirtualManager.c(this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager)) });
    if (!paramBoolean)
    {
      ForwardStatisticsReporter.a("KEY_PRE_AUTH", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      ForwardStatisticsReporter.a("KEY_PRE_AUTH", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (this.jdField_a_of_type_Boolean) {
      localObject = OpenSdkVirtualUtil.b(arrayOfByte, this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        ForwardStatisticsReporter.a("KEY_PRE_AUTH", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, true);
        OpenSdkVirtualManager.a(this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager, (preAuth.PreAuthResponse)localObject);
        OpenSdkVirtualManager.b(this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager, 0);
        this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager$PreAuthCallback.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "Exception", localException);
      ForwardStatisticsReporter.a("KEY_PRE_AUTH", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    ForwardStatisticsReporter.a("KEY_PRE_AUTH", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.8
 * JD-Core Version:    0.7.0.1
 */