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
    QFileSaveModel localQFileSaveModel = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.a();
    }
    return 0L;
  }
  
  public QFileControlReq a()
  {
    QFileSaveModel localQFileSaveModel = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.a();
    }
    return null;
  }
  
  public String a()
  {
    QFileSaveModel localQFileSaveModel = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.b();
    }
    return "";
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    boolean bool;
    if (localObject != null) {
      bool = ((QFileSaveModel)localObject).a();
    } else {
      bool = false;
    }
    if (!bool)
    {
      QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback;
      if (localObject != null) {
        ((QFileSaveReqUiCallback)localObject).a(false);
      }
    }
  }
  
  public void a(QFileSaveReqUiCallback paramQFileSaveReqUiCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback = paramQFileSaveReqUiCallback;
    paramQFileSaveReqUiCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    if (paramQFileSaveReqUiCallback != null) {
      paramQFileSaveReqUiCallback.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback);
    }
  }
  
  public void a(String paramString, QFileMultiSaveReq.ISaveFileCallBack paramISaveFileCallBack)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
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
    return FileUtils.fileExistsAndNotEmpty(b());
  }
  
  public String b()
  {
    QFileSaveModel localQFileSaveModel = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.a();
    }
    return "";
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    boolean bool;
    if (localObject != null) {
      bool = ((QFileSaveModel)localObject).b();
    } else {
      bool = false;
    }
    if (!bool)
    {
      QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveReqUiCallback;
      if (localObject != null) {
        ((QFileSaveReqUiCallback)localObject).b(false);
      }
    }
  }
  
  public boolean b()
  {
    QFileSaveModel localQFileSaveModel = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileSaveModel;
    if (localQFileSaveModel != null) {
      localQFileSaveModel.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq
 * JD-Core Version:    0.7.0.1
 */