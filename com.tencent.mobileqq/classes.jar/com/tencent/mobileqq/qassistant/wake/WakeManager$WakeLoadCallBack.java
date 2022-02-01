package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.LoadManager;
import com.tencent.mobileqq.qassistant.core.LoadManager.LoadCallBack;

public class WakeManager$WakeLoadCallBack
  implements LoadManager.LoadCallBack
{
  public void a()
  {
    AssistantUtils.a("HelloQQWake", "WakeLoadCallBack,onSuccess()");
    if (LoadManager.a()) {
      WakeManager.a().a("WakeLoadCallBack onSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.WakeLoadCallBack
 * JD-Core Version:    0.7.0.1
 */