package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.wake.aicore.AIModelParam;
import com.tencent.mobileqq.qassistant.wake.aicore.QQWakeUICallback;

class HelloQQHelper$1
  implements QQWakeUICallback
{
  HelloQQHelper$1(HelloQQHelper paramHelloQQHelper) {}
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetectResult detected:");
    localStringBuilder.append(paramFloat);
    AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    if ((paramFloat > HelloQQHelper.a(this.a).i) && (System.currentTimeMillis() - HelloQQHelper.b(this.a) > 2500L))
    {
      HelloQQHelper.a(this.a, System.currentTimeMillis());
      if (HelloQQHelper.c(this.a) != null) {
        HelloQQHelper.c(this.a).a();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (HelloQQHelper.c(this.a) != null) {
      HelloQQHelper.c(this.a).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.HelloQQHelper.1
 * JD-Core Version:    0.7.0.1
 */