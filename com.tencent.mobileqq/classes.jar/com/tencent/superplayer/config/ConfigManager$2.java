package com.tencent.superplayer.config;

import com.tencent.superplayer.utils.ThreadUtil;

class ConfigManager$2
  implements PullConfigRequest.PullConfigCallback
{
  ConfigManager$2(ConfigManager paramConfigManager) {}
  
  public void onConfigPulled(String paramString)
  {
    ThreadUtil.runOnThreadPool(new ConfigManager.2.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.config.ConfigManager.2
 * JD-Core Version:    0.7.0.1
 */