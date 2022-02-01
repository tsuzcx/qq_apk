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
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.a == null) {
        bool = true;
      }
      QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, new Object[] { "listener is null: ", Boolean.valueOf(bool) });
    }
    UniteDownloadUtil.DownloadDialogListener localDownloadDialogListener = this.a;
    if (localDownloadDialogListener != null) {
      localDownloadDialogListener.a(paramInt);
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, new Object[] { "IPC onCallBack: ", Integer.valueOf(paramEIPCResult.code) });
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0)) {
      paramEIPCResult = paramEIPCResult.data;
    } else {
      paramEIPCResult = null;
    }
    if (paramEIPCResult != null) {
      i = paramEIPCResult.getInt("result");
    }
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.util.UniteDownloadIPCModule.UniteDownloadIPCListenerWrapper
 * JD-Core Version:    0.7.0.1
 */