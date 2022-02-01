package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class QWalletIPCModule$6
  implements IPreloadService.OnGetPathListener
{
  QWalletIPCModule$6(QWalletIPCModule paramQWalletIPCModule, ResultReceiver paramResultReceiver) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QWalletIPC downloadUrls");
      ((StringBuilder)localObject).append(paramPathResult);
      QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("result_code", paramInt);
    ((Bundle)localObject).putSerializable("path_result", paramPathResult);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.6
 * JD-Core Version:    0.7.0.1
 */