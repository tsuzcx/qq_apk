package com.tencent.superplayer.api;

import com.tencent.superplayer.config.CacheContent;
import com.tencent.superplayer.config.ConfigManager;

public class SuperPlayerSdkOption
{
  public static final boolean DEFAULT_SERVER_CONFIG_ENABLE = true;
  public int configRequestIntervalInHour = 12;
  public String deviceId = "";
  public String proxyConfigStr = "{\"EnableUseQuic\":true}";
  public boolean serverConfigEnable = true;
  public String uid = "";
  
  private SuperPlayerSdkOption()
  {
    loadConfigFromConfigManager();
  }
  
  private void loadConfigFromConfigManager()
  {
    this.proxyConfigStr = ConfigManager.get().getConfig("sdkOption").getString("proxyConfigStr", this.proxyConfigStr);
  }
  
  public static SuperPlayerSdkOption option()
  {
    return new SuperPlayerSdkOption();
  }
  
  public String toString()
  {
    return "SuperPlayerSdkOption{proxyConfigStr='" + this.proxyConfigStr + '\'' + "deviceId=" + this.deviceId + '\n' + "uid=" + this.uid + '\n' + "serverConfigEnable=" + this.serverConfigEnable + "\nconfigRequestIntervalInHour:" + this.configRequestIntervalInHour + "\n" + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSdkOption
 * JD-Core Version:    0.7.0.1
 */