package com.tencent.mobileqq.download.unite.util;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class UniteDownloadIPCModule
  extends QIPCModule
{
  private static volatile UniteDownloadIPCModule a;
  
  public UniteDownloadIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static UniteDownloadIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new UniteDownloadIPCModule("UniteDownloadIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, new Object[] { "downloadIPC onCall: ", paramString, " callBackid: ", Integer.valueOf(paramInt) });
    }
    if ("showDialogAction".equals(paramString))
    {
      paramBundle.setClassLoader(DownloadInfo.class.getClassLoader());
      UniteDownloadUtil.a((DownloadInfo)paramBundle.getParcelable("downloadInfoKey"), new UniteDownloadIPCModule.1(this, paramInt));
    }
    return EIPCResult.createResult(-100, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.util.UniteDownloadIPCModule
 * JD-Core Version:    0.7.0.1
 */