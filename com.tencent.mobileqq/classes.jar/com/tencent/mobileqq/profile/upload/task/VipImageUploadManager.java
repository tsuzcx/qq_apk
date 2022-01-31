package com.tencent.mobileqq.profile.upload.task;

import agci;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import cooperation.qzone.UploadEnv;
import mqq.manager.Manager;

public class VipImageUploadManager
  implements Manager
{
  public VipImageUploadManager(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (paramVipUploadConfigImpl != null)
    {
      IUploadService.UploadServiceCreator.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramVipUploadConfigImpl, null, null, new UploadEnv());
      return;
    }
    IUploadService.UploadServiceCreator.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), new agci(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin())), null, null, new UploadEnv());
  }
  
  public void a(QQAppInterface paramQQAppInterface, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (!IUploadService.UploadServiceCreator.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramVipUploadConfigImpl);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, VipBaseUploadTask paramVipBaseUploadTask, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (!IUploadService.UploadServiceCreator.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramVipUploadConfigImpl);
    }
    paramVipBaseUploadTask.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipImageUploadManager
 * JD-Core Version:    0.7.0.1
 */