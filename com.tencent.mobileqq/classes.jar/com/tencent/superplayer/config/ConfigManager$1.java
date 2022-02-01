package com.tencent.superplayer.config;

import com.tencent.superplayer.utils.ThreadUtil;

class ConfigManager$1
  implements DataHandler.ConfigGroupParseCallback
{
  ConfigManager$1(ConfigManager paramConfigManager) {}
  
  public void onConfigGroupParsed(CacheContent paramCacheContent, String paramString)
  {
    ConfigManager.access$000(this.this$0).save(paramCacheContent, paramString);
    ThreadUtil.runOnUiThread(new ConfigManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.config.ConfigManager.1
 * JD-Core Version:    0.7.0.1
 */