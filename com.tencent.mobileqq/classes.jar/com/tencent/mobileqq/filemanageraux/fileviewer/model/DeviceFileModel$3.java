package com.tencent.mobileqq.filemanageraux.fileviewer.model;

import android.text.TextUtils;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DeviceImageInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class DeviceFileModel$3
  implements IThumbController
{
  DeviceFileModel$3(DeviceFileModel paramDeviceFileModel) {}
  
  public void a(FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    paramImageFileInfo = ((DeviceImageInfo)paramImageFileInfo).h();
    if (paramImageFileInfo == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramImageFileInfo.b())) && (FileManagerUtil.c(paramImageFileInfo.b()) == 0) && (TextUtils.isEmpty(paramImageFileInfo.o())))
    {
      paramImageFileInfo = paramImageFileInfo.r();
      if (paramImageFileInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        }
        return;
      }
      if (!TextUtils.isEmpty(paramImageFileInfo.strThumbPath))
      {
        if (DeviceFileModel.s(this.a) != null) {
          DeviceFileModel.t(this.a).a(String.valueOf(paramImageFileInfo.nSessionId), paramImageFileInfo.strThumbPath);
        }
        return;
      }
      paramImageFileInfo = DeviceFileModel.u(this.a).getMessageFacade().a(paramImageFileInfo.peerUin, paramImageFileInfo.peerType, paramImageFileInfo.msgSeq);
      if (paramImageFileInfo == null) {
        return;
      }
      paramImageFileInfo = (MessageForDeviceSingleStruct)paramImageFileInfo;
      DevSingleStructMsgProcessor localDevSingleStructMsgProcessor = ((DeviceMsgHandle)DeviceFileModel.v(this.a).getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).c();
      DeviceFileModel.a(this.a, localDevSingleStructMsgProcessor.a(paramImageFileInfo, null, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel.3
 * JD-Core Version:    0.7.0.1
 */