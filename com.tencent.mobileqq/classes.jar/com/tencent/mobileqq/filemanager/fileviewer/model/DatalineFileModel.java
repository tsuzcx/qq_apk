package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
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
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class DatalineFileModel
  extends DefaultFileModel
{
  private DataLineObserver z;
  
  public DatalineFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
    }
    a(paramList, paramInt);
  }
  
  private void au()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    int i = DataLineMsgRecord.getDevTypeBySeId(this.c.r().uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.a.getMessageFacade().d(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localDataLineHandler.e(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L) {
        if (DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          DataLineReportUtil.d(this.a);
        } else {
          DataLineReportUtil.e(this.a);
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
    if (localDataLineHandler.b(localArrayList))
    {
      localFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      if (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0) {
        localDataLineMsgRecord.progress = 0.0F;
      }
      this.a.getMessageFacade().d(i).f(localDataLineMsgRecord.msgId);
      return;
    }
    FMToastUtil.a(2131891335);
  }
  
  private void av()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if ((localFileManagerEntity.getCloudType() == 6) && (localFileManagerEntity.peerDin == 0L))
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
      DataLineMsgRecord localDataLineMsgRecord = this.a.getMessageFacade().d(i).a(localFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DatalineFileModel<FileAssistant>", 2, "datalineFileStopTransfer : dataline record is null");
        }
        return;
      }
      if ((localDataLineMsgRecord.strMoloKey != null) && (DataLineMsgSet.isSingle(localDataLineMsgRecord)))
      {
        if (!localDataLineMsgRecord.isReportPause)
        {
          localDataLineMsgRecord.isReportPause = true;
          DataLineReportUtil.k(this.a);
        }
      }
      else if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == -2335))
      {
        localDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.m(this.a);
      }
      localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
    }
    localFileManagerEntity.status = 3;
  }
  
  private void aw()
  {
    if (!NetworkUtil.isNetSupport(this.i))
    {
      FMToastUtil.a(2131889577);
      return;
    }
    Object localObject = this.c.r();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    DataLineHandler localDataLineHandler = (DataLineHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    int i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
    localObject = localQQAppInterface.getMessageFacade().d(i).a(((FileManagerEntity)localObject).uniseq);
    if (localObject != null)
    {
      if (B() != 6000) {
        return;
      }
      ((DataLineMsgRecord)localObject).bIsResendOrRecvFile = true;
      switch (z())
      {
      default: 
        return;
      case 2: 
        localDataLineHandler.a(y(), ((DataLineMsgRecord)localObject).thumbPath, 2, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      case 0: 
        localDataLineHandler.a(y(), ((DataLineMsgRecord)localObject).thumbPath, 1, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      if (FileUtils.fileExists(y()))
      {
        localDataLineHandler.a(y(), ((DataLineMsgRecord)localObject).thumbPath, 0, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      if (((DataLineMsgRecord)localObject).nOpType == 35)
      {
        localDataLineHandler.c((DataLineMsgRecord)localObject);
        return;
      }
      localDataLineHandler.n().a((DataLineMsgRecord)localObject, i, 2);
    }
  }
  
  public String I()
  {
    String str = super.I();
    int i = R();
    if (i == 5) {
      return "";
    }
    if (((i == 0) || (i == 6)) && (this.c != null))
    {
      FileManagerEntity localFileManagerEntity = this.c.r();
      if ((localFileManagerEntity != null) && (!FileManagerUtil.s(localFileManagerEntity.getFilePath())) && (FileManagerUtil.d(localFileManagerEntity))) {
        return "";
      }
    }
    return str;
  }
  
  public boolean P()
  {
    if (L() == 35) {
      return false;
    }
    return super.P();
  }
  
  public int R()
  {
    int j = super.R();
    int i;
    if (j != 0)
    {
      i = j;
      if (j != 6) {}
    }
    else
    {
      i = j;
      if (this.c != null)
      {
        FileManagerEntity localFileManagerEntity = this.c.r();
        i = j;
        if (localFileManagerEntity != null)
        {
          i = j;
          if (!FileManagerUtil.s(localFileManagerEntity.getFilePath()))
          {
            i = j;
            if (FileManagerUtil.d(localFileManagerEntity)) {
              i = 5;
            }
          }
        }
      }
    }
    return i;
  }
  
  public int W()
  {
    int i = z();
    if ((i != 0) && (i != 2) && (i != 13)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0;
    }
    FileManagerEntity localFileManagerEntity = this.c.r();
    if ((localFileManagerEntity != null) && (localFileManagerEntity.uniseq != 0L))
    {
      if ((this.k != null) && (this.k.k())) {
        return 2;
      }
      if (i != 0) {
        return 1;
      }
    }
    return 0;
  }
  
  public IServiceInfo X()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    return new DatalineFileColorNoteServiceInfo(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getMessageFacade().d(i).a(localFileManagerEntity.uniseq));
  }
  
  public int a()
  {
    int i = z();
    int j = super.a();
    if (j != 0) {
      return j;
    }
    if (i != 0) {
      return 1;
    }
    return 6;
  }
  
  protected void c()
  {
    if (this.z != null) {
      return;
    }
    this.z = new DatalineFileModel.1(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.z);
  }
  
  protected void d()
  {
    if (this.z != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.z);
      this.z = null;
    }
  }
  
  public IUploadController e()
  {
    if (this.p == null) {
      this.p = new DatalineFileModel.2(this);
    }
    return this.p;
  }
  
  public IDownloadController f()
  {
    if (this.o == null) {
      this.o = new DatalineFileModel.3(this);
    }
    return this.o;
  }
  
  public void h()
  {
    int i = L();
    if (B() == 6000)
    {
      if (i == 0)
      {
        if (O() == 2) {
          au();
        } else {
          aw();
        }
      }
      else {
        au();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 2, "DatalineFileModel doStartDownload : error, this file is not from dataline");
    }
    if (this.q != null) {
      this.q.d();
    }
  }
  
  public String l()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    ArrayList[] arrayOfArrayList = super.m();
    if (!FileUtil.b(y())) {
      arrayOfArrayList = null;
    }
    return arrayOfArrayList;
  }
  
  public int w()
  {
    if (FileManagerUtil.n(y())) {
      return 3;
    }
    return super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel
 * JD-Core Version:    0.7.0.1
 */