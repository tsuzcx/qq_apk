package com.tencent.mobileqq.emoticonview;

import amou;
import arad;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelCameraHelper$2
  extends amou
{
  EmoticonPanelCameraHelper$2(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper) {}
  
  public void doOnDeleteEmoResult(int paramInt)
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
      if ((this.this$0.mPanelController.app != null) && (((arad)this.this$0.mPanelController.app.getManager(333)).a() > 0)) {
        this.this$0.tryHiddenCameraEmoGuide();
      }
      this.this$0.updateCameraEmoticonPanel();
    }
  }
  
  public void onCameraEmoInsert()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoInsert");
    }
    this.this$0.updateCameraEmoticonPanel();
    if ((this.this$0.mPanelController.app != null) && (((arad)this.this$0.mPanelController.app.getManager(333)).a() > 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.2
 * JD-Core Version:    0.7.0.1
 */