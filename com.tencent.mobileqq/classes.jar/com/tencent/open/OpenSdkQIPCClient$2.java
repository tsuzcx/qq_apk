package com.tencent.open;

import android.os.Bundle;
import mqq.observer.SSOAccountObserver;

class OpenSdkQIPCClient$2
  extends SSOAccountObserver
{
  OpenSdkQIPCClient$2(OpenSdkQIPCClient paramOpenSdkQIPCClient, int paramInt) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    OpenSdkQIPCClient.a(this.jdField_a_of_type_ComTencentOpenOpenSdkQIPCClient, paramString, this.jdField_a_of_type_Int, paramInt2, -102);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    OpenProxy.a().a(paramString);
    BaseOpenSdkQIPCClient.a(paramString);
    OpenSdkQIPCClient.a(this.jdField_a_of_type_ComTencentOpenOpenSdkQIPCClient, paramString, this.jdField_a_of_type_Int, 0, 0);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    OpenSdkQIPCClient.a(this.jdField_a_of_type_ComTencentOpenOpenSdkQIPCClient, paramString, this.jdField_a_of_type_Int, 2006, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.OpenSdkQIPCClient.2
 * JD-Core Version:    0.7.0.1
 */