package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.QLog;

class MPcFileModel$5
  extends MessageObserver
{
  MPcFileModel$5(MPcFileModel paramMPcFileModel) {}
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (MPcFileModel.b(this.a)) {
        FMToastUtil.a(2131891911);
      }
      MPcFileModel.a(this.a, false);
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 2, "PC offline!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel.5
 * JD-Core Version:    0.7.0.1
 */