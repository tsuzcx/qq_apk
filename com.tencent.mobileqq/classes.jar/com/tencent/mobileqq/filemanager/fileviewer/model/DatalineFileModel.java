package com.tencent.mobileqq.filemanager.fileviewer.model;

import adcn;
import adco;
import adcq;
import android.app.Activity;
import com.dataline.core.DirectForwarder;
import com.dataline.util.DataLineReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class DatalineFileModel
  extends DefaultFileModel
{
  private DataLineObserver a;
  
  public DatalineFileModel(Activity paramActivity, List paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
    }
    a(paramList, paramInt);
  }
  
  private void l()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localDataLineHandler.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label187;
        }
        DataLineReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localDataLineHandler.a(localArrayList)) {
        break;
      }
      localFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      if (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0) {
        localDataLineMsgRecord.progress = 0.0F;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).c(localDataLineMsgRecord.msgId);
      return;
      label187:
      DataLineReportUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    FMToastUtil.a(2131427558);
  }
  
  private void m()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    DataLineHandler localDataLineHandler;
    DataLineMsgRecord localDataLineMsgRecord;
    if ((localFileManagerEntity.getCloudType() == 6) && (localFileManagerEntity.peerDin == 0L))
    {
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(localFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DatalineFileModel<FileAssistant>", 2, "datalineFileStopTransfer : dataline record is null");
        }
        return;
      }
      if ((localDataLineMsgRecord.strMoloKey == null) || (!DataLineMsgSet.isSingle(localDataLineMsgRecord))) {
        break label147;
      }
      if (!localDataLineMsgRecord.isReportPause)
      {
        localDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      localFileManagerEntity.status = 3;
      return;
      label147:
      if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == -2335))
      {
        localDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  private void n()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity)) {
      FMToastUtil.a(2131428327);
    }
    Object localObject;
    DataLineHandler localDataLineHandler;
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
      i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).a(((FileManagerEntity)localObject).uniseq);
    } while ((localObject == null) || (f() != 6000));
    ((DataLineMsgRecord)localObject).bIsResendOrRecvFile = true;
    switch (e())
    {
    default: 
      return;
    case -1: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      if (FileUtils.a(b()))
      {
        localDataLineHandler.a(b(), ((DataLineMsgRecord)localObject).thumbPath, 0, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      break;
    case 0: 
      localDataLineHandler.a(b(), ((DataLineMsgRecord)localObject).thumbPath, 1, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    case 2: 
      localDataLineHandler.a(b(), ((DataLineMsgRecord)localObject).thumbPath, 2, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    }
    localDataLineHandler.a().a((DataLineMsgRecord)localObject, i, 2);
  }
  
  public int a()
  {
    int i = e();
    int j = super.a();
    if (j != 0) {
      return j;
    }
    switch (i)
    {
    default: 
      return 1;
    }
    return 6;
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new adcq(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IUploadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController = new adco(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController;
  }
  
  public ArrayList a()
  {
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new adcn(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
    }
  }
  
  public int d()
  {
    if (FileManagerUtil.b(b())) {
      return 3;
    }
    return super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel
 * JD-Core Version:    0.7.0.1
 */