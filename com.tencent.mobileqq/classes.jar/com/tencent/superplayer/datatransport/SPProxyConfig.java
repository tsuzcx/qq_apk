package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.thumbplayer.config.TPPlayerConfig;

public class SPProxyConfig
{
  public static void init(SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    if (paramSuperPlayerSdkOption == null) {
      return;
    }
    TPPlayerConfig.setProxyConfigStr(paramSuperPlayerSdkOption.proxyConfigStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPProxyConfig
 * JD-Core Version:    0.7.0.1
 */