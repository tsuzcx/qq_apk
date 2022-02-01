package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QFileMultiSaveReq
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  private QFileSaveModel jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
  private QFileSaveReqUiCallback jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback;
  
  public QFileMultiSaveReq(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel = QFileSaveModel.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.a();
    }
    return 0L;
  }
  
  public QFileControlReq a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback.a(false);
        }
      }
      return;
    }
  }
  
  public void a(QFileSaveReqUiCallback paramQFileSaveReqUiCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback = paramQFileSaveReqUiCallback;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback);
    }
  }
  
  public void a(String paramString, QFileMultiSaveReq.ISaveFileCallBack paramISaveFileCallBack)
  {
    if (!FileUtils.b(paramString))
    {
      if (paramISaveFileCallBack != null) {
        paramISaveFileCallBack.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramISaveFileCallBack));
  }
  
  public boolean a()
  {
    return FileUtils.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq
 * JD-Core Version:    0.7.0.1
 */