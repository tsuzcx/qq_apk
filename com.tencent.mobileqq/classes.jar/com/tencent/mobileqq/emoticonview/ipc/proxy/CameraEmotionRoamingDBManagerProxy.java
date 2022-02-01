package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmotionRoamingDBManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CameraEmotionRoamingDBManagerProxy
  extends AbsManagerProxy<CameraEmotionRoamingDBManager>
{
  public static final String TAG = "CameraEmotionRoamingDBManagerProxy";
  
  public CameraEmotionRoamingDBManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
  }
  
  public int getCatchDataCount()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManagerProxy", 4, "do catchDataCount.");
      }
      return ((CameraEmotionRoamingDBManager)this.manager).a();
    }
    return 0;
  }
  
  public List<CameraEmotionData> getEmoticonDataList()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManagerProxy", 4, "do emoticonDataList.");
      }
      return ((CameraEmotionRoamingDBManager)this.manager).a();
    }
    return new ArrayList();
  }
  
  public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel()
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManagerProxy", 4, "do syncGetCustomEmotionInfoShowedInPanel.");
      }
      return ((CameraEmotionRoamingDBManager)this.manager).b();
    }
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerProxy
 * JD-Core Version:    0.7.0.1
 */