package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.qphone.base.util.QLog;

public class CameraEmoRoamingManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<ICameraEmoRoamingManagerService>
{
  private static final String TAG = "CameraEmoRoamingManagerServiceProxy";
  
  public CameraEmoRoamingManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, ICameraEmoRoamingManagerService.class);
  }
  
  public boolean getIsNeedShowGuide()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManagerServiceProxy", 4, "do getIsNeedShowGuide.");
      }
      return ((ICameraEmoRoamingManagerService)this.manager).getIsNeedShowGuide();
    }
    return false;
  }
  
  public boolean isShowCameraEmoInApp()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManagerServiceProxy", 4, "do showCameraEmoInApp.");
      }
      return ((ICameraEmoRoamingManagerService)this.manager).isShowCameraEmoInApp();
    }
    return false;
  }
  
  public void setIsNeedShowGuide(boolean paramBoolean)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("do IsNeedShowGuide: ");
        localStringBuilder.append(paramBoolean);
        QLog.d("CameraEmoRoamingManagerServiceProxy", 4, localStringBuilder.toString());
      }
      ((ICameraEmoRoamingManagerService)this.manager).setIsNeedShowGuide(paramBoolean);
    }
  }
  
  public void syncRoaming()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManagerServiceProxy", 4, "do syncRoaming.");
      }
      ((ICameraEmoRoamingManagerService)this.manager).syncRoaming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */