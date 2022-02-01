package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.List;
import mqq.os.MqqHandler;

class EmotionPanelDataBuilder$1
  implements Runnable
{
  EmotionPanelDataBuilder$1(EmotionPanelDataBuilder paramEmotionPanelDataBuilder, QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, EmotionPanelDataBuilder.EmotionPanelDataCallback paramEmotionPanelDataCallback) {}
  
  public void run()
  {
    List localList = this.this$0.syncGetEmotionPanelData(this.val$app, this.val$panelType, this.val$emotionPkg, this.val$uinType, this.val$businessType, this.val$kanDianBiu);
    ThreadManager.getUIHandler().post(new EmotionPanelDataBuilder.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1
 * JD-Core Version:    0.7.0.1
 */