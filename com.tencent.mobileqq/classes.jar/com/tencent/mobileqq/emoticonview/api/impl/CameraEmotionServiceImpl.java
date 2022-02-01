package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.ICameraEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerProxy;
import java.util.List;

public class CameraEmotionServiceImpl
  implements ICameraEmotionService<CameraEmotionData>
{
  public List<CameraEmotionData> getEmoticonDataList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    return ((CameraEmotionRoamingDBManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER)).getEmoticonDataList();
  }
  
  public void reUploadCameraEmotion(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, CameraEmotionData paramCameraEmotionData)
  {
    ((CameraEmoRoamingHandlerProxy)paramIEmoticonMainPanelApp.getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER)).notifyUI(4, true, null);
    com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.a = false;
    ThreadManager.excute(new CameraEmoSingleSend(paramCameraEmotionData, true), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.CameraEmotionServiceImpl
 * JD-Core Version:    0.7.0.1
 */