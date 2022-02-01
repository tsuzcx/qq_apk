package com.tencent.mobileqq.teamwork.spread;

import java.lang.ref.WeakReference;

class ConfigSetting$LocalWtTicketPromise$1
  implements Runnable
{
  ConfigSetting$LocalWtTicketPromise$1(ConfigSetting.LocalWtTicketPromise paramLocalWtTicketPromise) {}
  
  public void run()
  {
    ConfigSetting localConfigSetting = (ConfigSetting)ConfigSetting.LocalWtTicketPromise.a(this.this$0).get();
    if (localConfigSetting != null) {
      ConfigSetting.a(localConfigSetting, ConfigSetting.LocalWtTicketPromise.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSetting.LocalWtTicketPromise.1
 * JD-Core Version:    0.7.0.1
 */