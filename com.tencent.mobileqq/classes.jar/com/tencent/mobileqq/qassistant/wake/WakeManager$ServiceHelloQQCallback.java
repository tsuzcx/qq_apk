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
    Object localObject = this.a;
    ((WakeManager)localObject).b = false;
    if (paramBoolean) {
      ((WakeManager)localObject).a("ServiceHelloQQCallback onInit success");
    } else {
      AssistantUtils.a("HelloQQWake", "HelloQQHelper init failure");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HelloQQHelper init isMonitor：");
    ((StringBuilder)localObject).append(this.a.b);
    AssistantUtils.a("HelloQQWake", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.ServiceHelloQQCallback
 * JD-Core Version:    0.7.0.1
 */