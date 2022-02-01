package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class CustomEmotionRoamingDBManagerBase$4
  implements Runnable
{
  CustomEmotionRoamingDBManagerBase$4(CustomEmotionRoamingDBManagerBase paramCustomEmotionRoamingDBManagerBase, CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback) {}
  
  public void run()
  {
    List localList = this.this$0.syncGetCustomEmotionInfoShowedInPreview();
    ThreadManager.getUIHandler().post(new CustomEmotionRoamingDBManagerBase.4.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.4
 * JD-Core Version:    0.7.0.1
 */