package com.tencent.rmonitor.base.config.impl;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/impl/ConfigApply$LoadConfigMode;", "", "(Ljava/lang/String;I)V", "NO_AUTHORITY", "FROM_LOCAL", "FROM_SERVICE", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public enum ConfigApply$LoadConfigMode
{
  static
  {
    LoadConfigMode localLoadConfigMode1 = new LoadConfigMode("NO_AUTHORITY", 0);
    NO_AUTHORITY = localLoadConfigMode1;
    LoadConfigMode localLoadConfigMode2 = new LoadConfigMode("FROM_LOCAL", 1);
    FROM_LOCAL = localLoadConfigMode2;
    LoadConfigMode localLoadConfigMode3 = new LoadConfigMode("FROM_SERVICE", 2);
    FROM_SERVICE = localLoadConfigMode3;
    $VALUES = new LoadConfigMode[] { localLoadConfigMode1, localLoadConfigMode2, localLoadConfigMode3 };
  }
  
  private ConfigApply$LoadConfigMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigApply.LoadConfigMode
 * JD-Core Version:    0.7.0.1
 */