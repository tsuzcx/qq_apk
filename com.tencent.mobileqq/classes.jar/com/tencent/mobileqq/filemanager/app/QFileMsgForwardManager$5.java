package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver;
import com.tencent.qphone.base.util.QLog;

final class QFileMsgForwardManager$5
  extends TroopFileReqFeedsObserver
{
  QFileMsgForwardManager$5(String paramString, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback, long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("onReqFeedsResult return failed fileid ");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, false), true);
      return;
    }
    paramBundle.putString("_m_ForwardBusType", String.valueOf(paramInt2));
    paramBundle.putString("_m_ForwardDeadTime", String.valueOf(paramInt3));
    if (paramInt1 == 0)
    {
      paramString = new StringBuilder();
      paramString.append("onReqFeedsResult success fileid ");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(this.jdField_a_of_type_JavaLangString, paramBundle);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("onReqFeedsResult return[");
    paramString.append(paramInt1);
    paramString.append("] fileid ");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, false), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.5
 * JD-Core Version:    0.7.0.1
 */