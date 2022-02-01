package com.tencent.mobileqq.emoticonview.ipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class EmoticonMainPanelIpcModule$1
  implements EIPCResultCallback
{
  EmoticonMainPanelIpcModule$1(EmoticonMainPanelIpcModule paramEmoticonMainPanelIpcModule) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanelIpcModule", 4, "postChildIPCBundle suc.");
      }
    }
    else {
      QLog.e("EmoticonMainPanelIpcModule", 4, "postChildIPCBundle fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule.1
 * JD-Core Version:    0.7.0.1
 */