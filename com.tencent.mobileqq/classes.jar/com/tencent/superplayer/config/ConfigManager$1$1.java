package com.tencent.superplayer.config;

class ConfigManager$1$1
  implements Runnable
{
  ConfigManager$1$1(ConfigManager.1 param1) {}
  
  public void run()
  {
    if (ConfigManager.access$100(this.this$1.this$0) != null) {
      ConfigManager.access$100(this.this$1.this$0).onConfigPulled();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.config.ConfigManager.1.1
 * JD-Core Version:    0.7.0.1
 */