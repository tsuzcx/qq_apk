package com.tencent.mobileqq.mini.utils;

import common.config.service.QzoneConfig;

public class MiniAppWnsConfig
{
  public static final int DEFAULT_MINI_PRIVACY_ENABLE = 1;
  public static final String SECONDARY_KEY_PRIVACY_ENABLE = "privacy_info_enable";
  
  public static boolean privacyInfoEnable()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "privacy_info_enable", 1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.MiniAppWnsConfig
 * JD-Core Version:    0.7.0.1
 */