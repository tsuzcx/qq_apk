package com.tencent.mobileqq.download.unite.util;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class UniteDownloadIPCModule$UniteDownloadIPCListenerWrapper
  implements UniteDownloadUtil.DownloadDialogListener, EIPCResultCallback
{
  private UniteDownloadUtil.DownloadDialogListener a;
  
  UniteDownloadIPCModule$UniteDownloadIPCListenerWrapper(UniteDownloadUtil.DownloadDialogListener paramDownloadDialogListener)
  {
    this.a = paramDownloadDialogListener;
  }
  
  public void a(int paramInt)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      if (this.a == null) {
        bool = true;
      }
      QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, new Object[] { "listener is null: ", Boolean.valueOf(bool) });
    }
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, new Object[] { "IPC onCallBack: ", Integer.valueOf(paramEIPCResult.code) });
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0)) {}
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = null)
    {
      if (paramEIPCResult != null) {
        i = paramEIPCResult.getInt("result");
      }
      a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.util.UniteDownloadIPCModule.UniteDownloadIPCListenerWrapper
 * JD-Core Version:    0.7.0.1
 */