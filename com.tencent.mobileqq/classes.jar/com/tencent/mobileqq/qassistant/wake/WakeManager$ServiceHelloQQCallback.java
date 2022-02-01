package com.tencent.mobileqq.qassistant.wake;

import android.os.Handler;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;

class WakeManager$ServiceHelloQQCallback
  implements HelloQQHelper.Callback
{
  WakeManager$ServiceHelloQQCallback(WakeManager paramWakeManager) {}
  
  public void a()
  {
    WakeManager.a(this.a).post(new WakeManager.ServiceHelloQQCallback.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.b = false;
    if (paramBoolean) {
      this.a.a("ServiceHelloQQCallback onInit success");
    }
    for (;;)
    {
      AssistantUtils.a("HelloQQWake", "HelloQQHelper init isMonitor：" + this.a.b);
      return;
      AssistantUtils.a("HelloQQWake", "HelloQQHelper init failure");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.ServiceHelloQQCallback
 * JD-Core Version:    0.7.0.1
 */