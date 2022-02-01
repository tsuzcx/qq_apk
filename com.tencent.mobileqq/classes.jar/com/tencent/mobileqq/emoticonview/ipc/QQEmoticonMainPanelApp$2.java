package com.tencent.mobileqq.emoticonview.ipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class QQEmoticonMainPanelApp$2
  implements EIPCResultCallback
{
  QQEmoticonMainPanelApp$2(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQEmoticonMainPanelApp", 4, "registerOtherProcessCallback suc.");
      }
    }
    else {
      QLog.e("QQEmoticonMainPanelApp", 4, "registerOtherProcessCallback fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp.2
 * JD-Core Version:    0.7.0.1
 */