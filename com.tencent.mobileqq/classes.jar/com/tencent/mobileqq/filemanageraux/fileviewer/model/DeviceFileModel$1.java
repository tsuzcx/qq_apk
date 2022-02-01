package com.tencent.mobileqq.filemanageraux.fileviewer.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;

class DeviceFileModel$1
  extends DeviceFileObserver
{
  DeviceFileModel$1(DeviceFileModel paramDeviceFileModel) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = DeviceFileModel.d(this.a).r();
    if (localFileManagerEntity == null) {
      return;
    }
    if ((DeviceFileModel.e(this.a) != null) && (paramSession.uSessionID == DeviceFileModel.b(this.a)))
    {
      localFileManagerEntity.fProgress = paramFloat;
      DeviceFileModel.f(this.a).a(paramFloat);
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = DeviceFileModel.g(this.a).r();
    if (localFileManagerEntity == null) {
      return;
    }
    if ((DeviceFileModel.h(this.a) != null) && (paramSession.uSessionID == DeviceFileModel.i(this.a)) && (paramBoolean))
    {
      localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
      DeviceFileModel.j(this.a).a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
    }
    if ((DeviceFileModel.k(this.a) != null) && (paramSession.uSessionID == DeviceFileModel.b(this.a)))
    {
      if (paramBoolean)
      {
        localFileManagerEntity.fProgress = 1.0F;
        localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
        DeviceFileModel.l(this.a).f();
        if (this.a.z() == 2)
        {
          new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
          return;
        }
        DeviceFileModel.o(this.a).f();
        return;
      }
      DeviceFileModel.p(this.a).g();
    }
  }
  
  public void b(Session paramSession)
  {
    if ((DeviceFileModel.a(this.a) != null) && (paramSession.uSessionID == DeviceFileModel.b(this.a))) {
      DeviceFileModel.c(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel.1
 * JD-Core Version:    0.7.0.1
 */