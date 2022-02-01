package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EmoticonPanelMallHelper$1
  implements Runnable
{
  EmoticonPanelMallHelper$1(EmoticonPanelMallHelper paramEmoticonPanelMallHelper, boolean paramBoolean, EmoticonPanelController.PanelDataCallback paramPanelDataCallback) {}
  
  public void run()
  {
    this.this$0.mPanelController.syncInitPanelDataList(this.val$hasBigEmotion);
    if (this.val$callback != null) {
      ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1
 * JD-Core Version:    0.7.0.1
 */