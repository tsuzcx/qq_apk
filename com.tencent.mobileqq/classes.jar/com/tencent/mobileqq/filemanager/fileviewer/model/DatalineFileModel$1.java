package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.qphone.base.util.QLog;

class DatalineFileModel$1
  extends DataLineObserver
{
  DatalineFileModel$1(DatalineFileModel paramDatalineFileModel) {}
  
  public void a(long paramLong, float paramFloat)
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localObject == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onProgress : opType[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e() + "], uniseq[" + ((FileManagerEntity)localObject).uniseq + "], nSessionId[" + ((FileManagerEntity)localObject).nSessionId + "], peerType[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b() + "]");
      }
      int i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(((FileManagerEntity)localObject).uniseq);
    } while ((localObject == null) || (paramLong != ((DataLineMsgRecord)localObject).sessionid) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null));
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a(paramFloat);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onRecvFile : isSuccess[" + paramBoolean + "], uniseq[" + localFileManagerEntity.uniseq + "], nSessionId[" + localFileManagerEntity.nSessionId + "], peerType[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b() + "]");
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        if (paramLong == localDataLineMsgRecord.sessionid) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("DatalineFileModel<FileAssistant>", 1, "this recv file done is not current visit file");
      return;
      localFileManagerEntity.setFilePath(paramString);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null);
    if (paramBoolean)
    {
      localFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
      return;
    }
    localFileManagerEntity.status = 3;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString)
  {
    paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onSendFile : isSuccess[" + paramBoolean + "], uniseq[" + paramString.uniseq + "], nSessionId[" + paramString.nSessionId + "], peerType[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b() + "]");
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramString.uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(paramString.uniseq);
    if (localDataLineMsgRecord == null) {}
    do
    {
      return;
      if (paramLong != localDataLineMsgRecord.sessionid)
      {
        QLog.i("DatalineFileModel<FileAssistant>", 1, "this send file done is not current visit file");
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null);
    if (paramBoolean)
    {
      paramString.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel.1
 * JD-Core Version:    0.7.0.1
 */