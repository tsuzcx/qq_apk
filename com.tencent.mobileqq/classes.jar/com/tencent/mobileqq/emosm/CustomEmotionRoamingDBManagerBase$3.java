package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class CustomEmotionRoamingDBManagerBase$3
  implements Runnable
{
  CustomEmotionRoamingDBManagerBase$3(CustomEmotionRoamingDBManagerBase paramCustomEmotionRoamingDBManagerBase, CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback) {}
  
  public void run()
  {
    List localList = this.this$0.syncGetCustomEmotionInfoShowedInPanel();
    ThreadManager.getUIHandler().post(new CustomEmotionRoamingDBManagerBase.3.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.3
 * JD-Core Version:    0.7.0.1
 */