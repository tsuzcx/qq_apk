package com.tencent.open.agent.strategy;

import android.os.Bundle;
import com.tencent.open.agent.util.SSOLog;

class SSOLoginAction$8
  implements Runnable
{
  SSOLoginAction$8(SSOLoginAction paramSSOLoginAction, Bundle paramBundle, String paramString) {}
  
  public void run()
  {
    SSOLog.a("SSOLoginAction", new Object[] { "registerExpiredCallback" });
    SSOLoginAction.a(this.this$0, this.a, this.b);
    SSOLoginAction.b(this.this$0, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction.8
 * JD-Core Version:    0.7.0.1
 */