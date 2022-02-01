package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;

class QWalletIPCModule$2$1
  implements IPreloadService.DownloadCallback
{
  QWalletIPCModule$2$1(QWalletIPCModule.2 param2, ResultReceiver paramResultReceiver) {}
  
  public void onDownloadResFinished(String paramString1, int paramInt, String paramString2, ResourceInfo paramResourceInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QWalletIPC downloadModule");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramResourceInfo);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("QWalletIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("id", paramString1);
    ((Bundle)localObject).putInt("result", paramInt);
    ((Bundle)localObject).putString("path", paramString2);
    ((Bundle)localObject).putSerializable("res_info", paramResourceInfo);
    this.a.send(0, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.2.1
 * JD-Core Version:    0.7.0.1
 */