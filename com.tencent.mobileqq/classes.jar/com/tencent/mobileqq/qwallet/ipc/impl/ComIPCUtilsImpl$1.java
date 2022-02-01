package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;

final class ComIPCUtilsImpl$1
  extends ResultReceiver
{
  ComIPCUtilsImpl$1(Handler paramHandler, IQWalletConfigService.ConfigUpdateListener paramConfigUpdateListener, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("res");
      this.jdField_a_of_type_ComTencentMobileqqQwalletConfigIQWalletConfigService$ConfigUpdateListener.onUpdate(this.jdField_a_of_type_JavaLangString, paramBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.ComIPCUtilsImpl.1
 * JD-Core Version:    0.7.0.1
 */