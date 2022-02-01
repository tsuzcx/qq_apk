package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;

class QWalletIPCModule$5
  implements IQWalletConfigService.ConfigUpdateListener
{
  QWalletIPCModule$5(QWalletIPCModule paramQWalletIPCModule, ResultReceiver paramResultReceiver) {}
  
  public void onUpdate(String paramString1, String paramString2, ConfigInfo paramConfigInfo)
  {
    paramString1 = new Bundle();
    paramString1.putString("res", paramString2);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.5
 * JD-Core Version:    0.7.0.1
 */