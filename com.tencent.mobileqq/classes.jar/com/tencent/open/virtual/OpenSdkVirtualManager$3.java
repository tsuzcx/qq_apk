package com.tencent.open.virtual;

import com.tencent.qphone.base.util.QLog;

class OpenSdkVirtualManager$3
  implements OpenSdkVirtualManager.PreAuthCallback
{
  OpenSdkVirtualManager$3(OpenSdkVirtualManager paramOpenSdkVirtualManager, OpenSdkVirtualManager.PreAuthCallback paramPreAuthCallback) {}
  
  public void a()
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager$PreAuthCallback.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager$PreAuthCallback.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.3
 * JD-Core Version:    0.7.0.1
 */