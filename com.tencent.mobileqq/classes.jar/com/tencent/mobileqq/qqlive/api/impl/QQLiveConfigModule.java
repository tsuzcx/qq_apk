package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.callback.config.ConfigPreparedListener;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.config.ConfigData.Builder;
import java.util.HashMap;

public class QQLiveConfigModule
  implements IQQLiveConfigModule
{
  private static final ConfigData CONFIG_DEFAULT = ConfigData.createBuilder().setLiveAppId("0").setLiveClientType(0).setLiveAppKey("0").setOpenSdkAppId("0").setTrtcAppId("0").setSmartEyeAppId("0").build();
  private static final ConfigData CONFIG_GUILD;
  private static final HashMap<String, ConfigData> CONFIG_MAPS;
  private static final ConfigData CONFIG_QQ_LIVE = ConfigData.createBuilder().setLiveAppId("1037").setLiveAppKey("7fb756e068374416930f7d252785dd30").setLiveClientType(16594).setOpenSdkAppId("1400368383").setTrtcAppId("1400515537").setSmartEyeAppId("").build();
  private ConfigData configData;
  
  static
  {
    CONFIG_GUILD = ConfigData.createBuilder().setLiveAppId("1054").setLiveAppKey("4252dd3874f345cb8b674bf7397c5b57").setLiveClientType(16866).setOpenSdkAppId("1400525011").setTrtcAppId("1400526639").setSmartEyeAppId("IDA2bMIY").build();
    CONFIG_MAPS = new HashMap();
    CONFIG_MAPS.put("1037", CONFIG_QQ_LIVE);
    CONFIG_MAPS.put("1054", CONFIG_GUILD);
  }
  
  public void asyncGetConfigData(ConfigPreparedListener paramConfigPreparedListener)
  {
    paramConfigPreparedListener.onPrepared(this.configData);
  }
  
  public void destroy()
  {
    this.configData = null;
  }
  
  public ConfigData getConfigData()
  {
    return this.configData;
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.configData = ((ConfigData)CONFIG_MAPS.get(paramIQQLiveSDK.getAppId()));
    if (this.configData == null) {
      this.configData = CONFIG_DEFAULT;
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLiveConfigModule
 * JD-Core Version:    0.7.0.1
 */