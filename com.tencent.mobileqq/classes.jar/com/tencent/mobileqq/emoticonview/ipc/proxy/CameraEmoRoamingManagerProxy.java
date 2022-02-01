package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager;
import com.tencent.qphone.base.util.QLog;

public class CameraEmoRoamingManagerProxy
  extends AbsManagerProxy<CameraEmoRoamingManager>
{
  private static final String TAG = "CameraEmoRoamingManagerProxy";
  
  public CameraEmoRoamingManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.CAMERA_EMOTION_MANAGER);
  }
  
  public boolean getIsNeedShowGuide()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManagerProxy", 4, "do getIsNeedShowGuide.");
      }
      return ((CameraEmoRoamingManager)this.manager).b();
    }
    return false;
  }
  
  public boolean isShowCameraEmoInApp()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManagerProxy", 4, "do showCameraEmoInApp.");
      }
      return ((CameraEmoRoamingManager)this.manager).c();
    }
    return false;
  }
  
  public void setIsNeedShowGuide(boolean paramBoolean)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManagerProxy", 4, "do IsNeedShowGuide: " + paramBoolean);
      }
      ((CameraEmoRoamingManager)this.manager).a(paramBoolean);
    }
  }
  
  public void syncRoaming()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManagerProxy", 4, "do syncRoaming.");
      }
      ((CameraEmoRoamingManager)this.manager).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerProxy
 * JD-Core Version:    0.7.0.1
 */