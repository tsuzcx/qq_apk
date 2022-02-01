package com.tencent.mobileqq.qrscan.ipc;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qrscan.IQRScanIPCConst;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class QRScanMainQIPCModule
  extends QIPCModule
  implements IQRScanIPCConst
{
  private static volatile QRScanMainQIPCModule a;
  
  public QRScanMainQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QRScanMainQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QRScanMainQIPCModule("QRScanMainQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localObject instanceof AppInterface)) {
      return;
    }
    localObject = (AppInterface)localObject;
    QRScanResDownloadManager.a(new QRScanMainQIPCModule.1(this, paramInt, paramString));
    QLog.i("MiniRecog.QRScanMainQIPCModule", 1, String.format("downloadQRScanRes resType=%d procName=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    QRScanResDownloadManager.a(paramInt, (AppInterface)localObject);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    String str = paramBundle.getString("key_call_proc", "");
    QLog.i("MiniRecog.QRScanMainQIPCModule", 1, String.format("onCall_%s procName=%s", new Object[] { paramString, str }));
    if ("action_call_download_res".equalsIgnoreCase(paramString)) {
      a(paramBundle.getInt("key_res_type", -1), str);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanMainQIPCModule
 * JD-Core Version:    0.7.0.1
 */