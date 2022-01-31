package com.tencent.mobileqq.filemanager.fileviewer.model;

import actc;
import acte;
import actg;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DeviceImageInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceFileModel
  extends DefaultFileModel
{
  private long jdField_a_of_type_Long = -1L;
  private DeviceFileObserver jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver;
  private long b = -1L;
  
  public DeviceFileModel(Activity paramActivity, List paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceFileModel<FileAssistant>", 1, "FileBrowserModel init: type = device");
    }
    a(paramList, paramInt);
  }
  
  private boolean k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    if (localObject == null) {
      return false;
    }
    localObject = (MessageForDeviceSingleStruct)localObject;
    DevSingleStructMsgProcessor localDevSingleStructMsgProcessor = ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    if ((((MessageForDeviceSingleStruct)localObject).nMediaSessionID > 0L) && (localDevSingleStructMsgProcessor.a((MessageForDeviceSingleStruct)localObject)))
    {
      this.jdField_a_of_type_Long = ((MessageForDeviceSingleStruct)localObject).nMediaSessionID;
      return true;
    }
    return false;
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
    }
    do
    {
      do
      {
        return;
      } while (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath()));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    } while (localObject == null);
    localObject = (MessageForDeviceSingleStruct)localObject;
    this.jdField_a_of_type_Long = ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a((MessageForDeviceSingleStruct)localObject);
  }
  
  private void m()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.msgSeq);
    } while (localObject == null);
    Object localObject = (MessageForDeviceSingleStruct)localObject;
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().b((MessageForDeviceSingleStruct)localObject);
    localFileManagerEntity.status = 3;
    this.jdField_a_of_type_Long = -1L;
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
    case 1: 
    default: 
      return 1;
    case 0: 
      return 6;
    }
    return 2;
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new acte(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IThumbController a()
  {
    return new actg(this);
  }
  
  public IUploadController a()
  {
    return null;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new DeviceImageInfo((IFileViewerAdapter)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = new actc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
      this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = null;
    }
  }
  
  public int d()
  {
    if (FileManagerUtil.b(b())) {
      return 3;
    }
    return super.d();
  }
  
  public int h()
  {
    return 2;
  }
  
  public boolean h()
  {
    return NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public int i()
  {
    if (FileManagerUtil.b(b())) {
      return 2;
    }
    if (k()) {
      return 4;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel
 * JD-Core Version:    0.7.0.1
 */