package com.tencent.mobileqq.filemanageraux.fileviewer.model;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DeviceImageInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceFileModel
  extends DefaultFileModel
{
  private long A = -1L;
  private long B = -1L;
  private DeviceFileObserver z;
  
  public DeviceFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceFileModel<FileAssistant>", 1, "FileBrowserModel init: type = device");
    }
    a(paramList, paramInt);
  }
  
  private void au()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
      return;
    }
    Object localObject = this.a.getMessageFacade().a(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.msgSeq);
    if (localObject == null) {
      return;
    }
    localObject = (MessageForDeviceSingleStruct)localObject;
    ((DeviceMsgHandle)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).c().c((MessageForDeviceSingleStruct)localObject);
    localFileManagerEntity.status = 3;
    this.A = -1L;
  }
  
  private boolean av()
  {
    Object localObject = this.c.r();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
      return false;
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      return false;
    }
    localObject = this.a.getMessageFacade().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    if (localObject == null) {
      return false;
    }
    localObject = (MessageForDeviceSingleStruct)localObject;
    DevSingleStructMsgProcessor localDevSingleStructMsgProcessor = ((DeviceMsgHandle)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).c();
    if ((((MessageForDeviceSingleStruct)localObject).nMediaSessionID > 0L) && (localDevSingleStructMsgProcessor.a((MessageForDeviceSingleStruct)localObject)))
    {
      this.A = ((MessageForDeviceSingleStruct)localObject).nMediaSessionID;
      return true;
    }
    return false;
  }
  
  public int O()
  {
    return 2;
  }
  
  public boolean P()
  {
    return NetworkUtil.isWifiConnected(this.i);
  }
  
  public IThumbController Q()
  {
    return new DeviceFileModel.3(this);
  }
  
  public int R()
  {
    if (FileManagerUtil.n(y())) {
      return 2;
    }
    if (av()) {
      return 4;
    }
    return 3;
  }
  
  public List<FileBrowserModelBase.ImageFileInfo> S()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new DeviceImageInfo((IFileViewerAdapter)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public int a()
  {
    int j = z();
    int i = super.a();
    if (i != 0) {
      return i;
    }
    i = 2;
    if (j != 0)
    {
      if (j != 2) {
        return 1;
      }
    }
    else {
      i = 6;
    }
    return i;
  }
  
  protected void c()
  {
    if (this.z != null) {
      return;
    }
    this.z = new DeviceFileModel.1(this);
    this.a.addObserver(this.z);
  }
  
  protected void d()
  {
    if (this.z != null)
    {
      this.a.removeObserver(this.z);
      this.z = null;
    }
  }
  
  public IUploadController e()
  {
    return null;
  }
  
  public IDownloadController f()
  {
    if (this.o == null) {
      this.o = new DeviceFileModel.2(this);
    }
    return this.o;
  }
  
  public void h()
  {
    Object localObject = this.c.r();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
      return;
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      return;
    }
    localObject = this.a.getMessageFacade().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    if (localObject == null) {
      return;
    }
    localObject = (MessageForDeviceSingleStruct)localObject;
    this.A = ((DeviceMsgHandle)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).c().b((MessageForDeviceSingleStruct)localObject);
    if (this.q != null) {
      this.q.d();
    }
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
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel
 * JD-Core Version:    0.7.0.1
 */