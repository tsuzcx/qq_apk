package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import com.dataline.core.DirectForwarder;
import com.dataline.util.DataLineReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DatalineFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class DatalineFileModel
  extends DefaultFileModel
{
  private DataLineObserver a;
  
  public DatalineFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
    }
    a(paramList, paramInt);
  }
  
  private void o()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localDataLineHandler.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label188;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(localDataLineMsgRecord.msgId);
      return;
      label188:
      DataLineReportUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    FMToastUtil.a(2131693807);
  }
  
  private void p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    DataLineHandler localDataLineHandler;
    DataLineMsgRecord localDataLineMsgRecord;
    if ((localFileManagerEntity.getCloudType() == 6) && (localFileManagerEntity.peerDin == 0L))
    {
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DatalineFileModel<FileAssistant>", 2, "datalineFileStopTransfer : dataline record is null");
        }
        return;
      }
      if ((localDataLineMsgRecord.strMoloKey == null) || (!DataLineMsgSet.isSingle(localDataLineMsgRecord))) {
        break label148;
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
      label148:
      if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == -2335))
      {
        localDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  private void q()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity)) {
      FMToastUtil.a(2131692602);
    }
    Object localObject;
    DataLineHandler localDataLineHandler;
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getMessageFacade().a(i).a(((FileManagerEntity)localObject).uniseq);
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
      if (FileUtils.a(d()))
      {
        localDataLineHandler.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 0, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      break;
    case 0: 
      localDataLineHandler.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 1, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    case 2: 
      localDataLineHandler.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 2, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    }
    if (((DataLineMsgRecord)localObject).nOpType == 35)
    {
      localDataLineHandler.b((DataLineMsgRecord)localObject);
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
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public IServiceInfo a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    return new DatalineFileColorNoteServiceInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getMessageFacade().a(i).a(localFileManagerEntity.uniseq));
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new DatalineFileModel.3(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IUploadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController = new DatalineFileModel.2(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new DatalineFileModel.1(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList[] arrayOfArrayList = super.a();
    if (!FileUtil.b(d())) {
      arrayOfArrayList = null;
    }
    return arrayOfArrayList;
  }
  
  protected void b()
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
    if (FileManagerUtil.b(d())) {
      return 3;
    }
    return super.d();
  }
  
  public String h()
  {
    String str2 = super.h();
    int i = i();
    String str1;
    if (i == 5) {
      str1 = "";
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return str1;
              if (i == 0) {
                break;
              }
              str1 = str2;
            } while (i != 6);
            str1 = str2;
          } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null);
          localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
          str1 = str2;
        } while (localFileManagerEntity == null);
        str1 = str2;
      } while (FileManagerUtil.c(localFileManagerEntity.getFilePath()));
      str1 = str2;
    } while (!FileManagerUtil.b(localFileManagerEntity));
    return "";
  }
  
  public int i()
  {
    int j = super.i();
    int i;
    if (j != 0)
    {
      i = j;
      if (j != 6) {}
    }
    else
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
        i = j;
        if (localFileManagerEntity != null)
        {
          i = j;
          if (!FileManagerUtil.c(localFileManagerEntity.getFilePath()))
          {
            i = j;
            if (FileManagerUtil.b(localFileManagerEntity)) {
              i = 5;
            }
          }
        }
      }
    }
    return i;
  }
  
  public boolean i()
  {
    if (g() == 35) {
      return false;
    }
    return super.i();
  }
  
  public int j()
  {
    int j = 2;
    int i = e();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        return 0;
      }
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.uniseq != 0L)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e())) {
          i = j;
        }
      }
      for (;;)
      {
        return i;
        if (i != 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel
 * JD-Core Version:    0.7.0.1
 */