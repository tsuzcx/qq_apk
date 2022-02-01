package com.tencent.mobileqq.emosm;

import aqyq;
import aqyr;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class CustomEmotionRoamingDBManagerBase$3
  implements Runnable
{
  public CustomEmotionRoamingDBManagerBase$3(aqyq paramaqyq, aqyr paramaqyr) {}
  
  public void run()
  {
    List localList = this.this$0.b();
    ThreadManager.getUIHandler().post(new CustomEmotionRoamingDBManagerBase.3.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.3
 * JD-Core Version:    0.7.0.1
 */