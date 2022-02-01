package com.tencent.mobileqq.profile.upload.task;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.UploadEnv;
import mqq.manager.Manager;

public class VipImageUploadManager
  implements Manager
{
  public VipImageUploadManager(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    UploadEnv localUploadEnv = new UploadEnv();
    if (paramVipUploadConfigImpl != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramVipUploadConfigImpl, null, null, localUploadEnv, localUploadEnv);
      return;
    }
    paramVipUploadConfigImpl = new VipImageUploadManager.1(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramVipUploadConfigImpl, null, null, localUploadEnv, localUploadEnv);
  }
  
  public void a(QQAppInterface paramQQAppInterface, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramVipUploadConfigImpl);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, VipBaseUploadTask paramVipBaseUploadTask, VipUploadConfigImpl paramVipUploadConfigImpl)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramVipUploadConfigImpl);
    }
    paramVipBaseUploadTask.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipImageUploadManager
 * JD-Core Version:    0.7.0.1
 */