package com.tencent.mobileqq.qassistant.wake;

import bakl;
import bang;
import banp;
import com.tencent.mobileqq.app.BaseActivity;

public class WakeManager$2
  implements Runnable
{
  public WakeManager$2(banp parambanp, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    try
    {
      new bang(this.a).show();
      return;
    }
    catch (Exception localException)
    {
      bakl.a("HelloQQWake", "show guider error: " + localException.getMessage());
      bang.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.2
 * JD-Core Version:    0.7.0.1
 */