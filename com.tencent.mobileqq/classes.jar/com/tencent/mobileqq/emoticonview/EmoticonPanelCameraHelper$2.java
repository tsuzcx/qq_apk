package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.CameraEmoRoamingObserver;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelCameraHelper$2
  extends CameraEmoRoamingObserver
{
  EmoticonPanelCameraHelper$2(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper) {}
  
  protected void doOnDeleteEmoResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnDeleteEmoResult");
    }
    if (paramInt == 0) {
      this.this$0.updateCameraEmoticonPanel();
    }
  }
  
  public void doOnGetEmoListResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnGetEmoListResult");
    }
    if (paramInt == 0)
    {
      if ((((EmoticonPanelController)this.this$0.mPanelController).app != null) && (((CameraEmotionRoamingDBManagerServiceProxy)((EmoticonPanelController)this.this$0.mPanelController).app.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getCatchDataCount() > 0)) {
        this.this$0.tryHiddenCameraEmoGuide();
      }
      this.this$0.updateCameraEmoticonPanel();
    }
  }
  
  protected void onCameraEmoInsert()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoInsert");
    }
    this.this$0.updateCameraEmoticonPanel();
    if ((((EmoticonPanelController)this.this$0.mPanelController).app != null) && (((CameraEmotionRoamingDBManagerServiceProxy)((EmoticonPanelController)this.this$0.mPanelController).app.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getCatchDataCount() > 0)) {
      this.this$0.tryHiddenCameraEmoGuide();
    }
  }
  
  public void onCameraEmoSend(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoSend");
    }
    this.this$0.updateCameraEmoticonPanel();
    EmoticonPanelCameraHelper.access$100(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.2
 * JD-Core Version:    0.7.0.1
 */