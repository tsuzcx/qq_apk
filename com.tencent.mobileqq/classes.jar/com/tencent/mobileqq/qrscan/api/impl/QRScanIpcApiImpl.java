package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qrscan.api.IQRScanIpcApi;
import com.tencent.mobileqq.qrscan.ipc.QRScanMainQIPCModule;
import com.tencent.mobileqq.qrscan.ipc.QRScanSubQIPCModule;

public class QRScanIpcApiImpl
  implements IQRScanIpcApi
{
  public QIPCModule getModule(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -925388039)
    {
      if ((i == 148853422) && (paramString.equals("QRScanMainQIPCModule")))
      {
        i = 0;
        break label50;
      }
    }
    else if (paramString.equals("QRScanSubQIPCModule"))
    {
      i = 1;
      break label50;
    }
    i = -1;
    label50:
    if (i != 0)
    {
      if (i != 1) {
        return null;
      }
      return QRScanSubQIPCModule.a();
    }
    return QRScanMainQIPCModule.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRScanIpcApiImpl
 * JD-Core Version:    0.7.0.1
 */