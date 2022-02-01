package com.tencent.mobileqq.webprocess;

import com.tencent.sonic.sdk.SonicEngine;
import java.util.Map;

class WebProcessReceiver$3
  implements Runnable
{
  WebProcessReceiver$3(WebProcessReceiver paramWebProcessReceiver, Map paramMap) {}
  
  public void run()
  {
    SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
    if (localSonicEngine != null) {
      localSonicEngine.removeExpiredSessionCache(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver.3
 * JD-Core Version:    0.7.0.1
 */