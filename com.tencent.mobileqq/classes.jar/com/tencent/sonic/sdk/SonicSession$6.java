package com.tencent.sonic.sdk;

import java.util.List;

class SonicSession$6
  implements Runnable
{
  SonicSession$6(SonicSession paramSonicSession, List paramList) {}
  
  public void run()
  {
    SonicEngine.getInstance().getRuntime().setCookie(this.this$0.getCurrentUrl(), this.val$cookies);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession.6
 * JD-Core Version:    0.7.0.1
 */