package com.tencent.mobileqq.mini.reuse;

import bkzc;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;

class QzoneBackupConfig
  extends IPConfigStrategy
  implements bkzc
{
  private static final String TAG = "QzoneIPStracyConfig";
  private Map<String, String> mConfigs = new HashMap();
  
  public QzoneBackupConfig()
  {
    initConfig();
    setDefaultIsp(2);
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void addConfigItem(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramMap.put(paramString1 + "||" + paramString2, QzoneConfig.getInstance().getConfig(paramString1, paramString2));
  }
  
  private void initConfig()
  {
    this.mConfigs.clear();
    addConfigItem(this.mConfigs, "PhotoSvrList", "DownloadBackupIP");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_backupIplist");
    addConfigItem(this.mConfigs, "PhotoABSvrList", "DownloadBackupIP_a");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_backupIplist_a");
    addConfigItem(this.mConfigs, "PhotoABSvrList", "DownloadBackupIP_b");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_backupIplist_b");
    addConfigItem(this.mConfigs, "VideoSvrList", "DownloadBackupIPVideo");
    addConfigItem(this.mConfigs, "ExtraConfig", "video_backupIplist");
    super.setConfig(this.mConfigs);
  }
  
  public void onConfigChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPStracyConfig", 2, "QzoneBackupConfig receive change");
    }
    initConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.QzoneBackupConfig
 * JD-Core Version:    0.7.0.1
 */