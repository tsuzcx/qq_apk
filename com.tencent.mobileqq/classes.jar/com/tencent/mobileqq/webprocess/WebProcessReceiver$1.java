package com.tencent.mobileqq.webprocess;

import com.tencent.sonic.sdk.SonicEngine;
import java.util.Map;

class WebProcessReceiver$1
  implements Runnable
{
  WebProcessReceiver$1(WebProcessReceiver paramWebProcessReceiver, Map paramMap) {}
  
  public void run()
  {
    SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
    if (localSonicEngine != null) {
      localSonicEngine.removeExpiredSessionCache(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiver.1
 * JD-Core Version:    0.7.0.1
 */