package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.config.TPPlayerConfig;

public class SPProxyConfig
{
  private static final String TAG = "SPProxyConfig";
  
  public static void init(SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    if (paramSuperPlayerSdkOption == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init: ");
    localStringBuilder.append(paramSuperPlayerSdkOption);
    LogUtil.d("SPProxyConfig", localStringBuilder.toString());
    TPPlayerConfig.setProxyConfigStr(paramSuperPlayerSdkOption.getDownloadProxyConfig());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPProxyConfig
 * JD-Core Version:    0.7.0.1
 */