package com.tencent.mobileqq.teamwork.spread;

import java.lang.ref.WeakReference;

class ConfigSettingForDataLine$LocalWtTicketPromise$1
  implements Runnable
{
  ConfigSettingForDataLine$LocalWtTicketPromise$1(ConfigSettingForDataLine.LocalWtTicketPromise paramLocalWtTicketPromise) {}
  
  public void run()
  {
    ConfigSettingForDataLine localConfigSettingForDataLine = (ConfigSettingForDataLine)ConfigSettingForDataLine.LocalWtTicketPromise.a(this.this$0).get();
    if (localConfigSettingForDataLine != null) {
      ConfigSettingForDataLine.a(localConfigSettingForDataLine, ConfigSettingForDataLine.LocalWtTicketPromise.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.LocalWtTicketPromise.1
 * JD-Core Version:    0.7.0.1
 */