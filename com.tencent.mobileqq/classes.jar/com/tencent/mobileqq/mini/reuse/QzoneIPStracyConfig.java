package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import bilp;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class QzoneIPStracyConfig
  extends IPConfigStrategy
  implements bilp
{
  private static final String TAG = "QzoneIPStracyConfig";
  private static final String VIDEO_HOST_QZPB = "qzpb.qq.com";
  private static final String VIDEO_HOST_QZVV = "qzvv.video.qq.com";
  private ReadWriteLock RW_Lock = new ReentrantReadWriteLock();
  private String extraJsonAIPConfig;
  private String extraJsonBIPConfig;
  private String extraJsonIPConfig;
  private String jsonAIPConfig;
  private String jsonBIPConfig;
  private String jsonIPConfig;
  private Map<String, String> mConfigs = new HashMap();
  
  public QzoneIPStracyConfig()
  {
    initConfig();
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void addConfigItem(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramMap.put(paramString1 + "||" + paramString2, QzoneConfig.getInstance().getConfig(paramString1, paramString2));
  }
  
  private void addSpecifyItem(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMap == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    Object localObject = null;
    paramString4 = QzoneConfig.getInstance().getConfig(paramString1, paramString3, paramString4);
    paramString3 = paramString1 + "||" + paramString2;
    paramString2 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
    paramString1 = localObject;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = localObject;
      if (!TextUtils.isEmpty(paramString4)) {
        paramString1 = paramString2.replace("ips", paramString4);
      }
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramMap.put(paramString3, paramString2);
      return;
    }
    paramMap.put(paramString3, paramString1);
  }
  
  private void initConfig()
  {
    this.mConfigs.clear();
    addConfigItem(this.mConfigs, "PhotoSvrList", "DownloadDirectIP");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_masterIplist");
    addConfigItem(this.mConfigs, "PhotoABSvrList", "DownloadDirectIP_a");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_masterIplist_a");
    addConfigItem(this.mConfigs, "PhotoABSvrList", "DownloadDirectIP_b");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_masterIplist_b");
    addConfigItem(this.mConfigs, "VideoSvrList", "DownloadDirectIPVideo");
    addConfigItem(this.mConfigs, "ExtraConfig", "video_masterIplist");
    addSpecifyItem(this.mConfigs, "PhotoSvrList", "optimumip_qzvv", "video_host_qzvv", "qzvv.video.qq.com");
    addSpecifyItem(this.mConfigs, "PhotoSvrList", "qzpb.qq.com", "video_host_qzpb", "qzpb.qq.com");
    super.setConfig(this.mConfigs);
  }
  
  public void onConfigChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPStracyConfig", 2, "QzoneIPStracyConfig receive change");
    }
    initConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.QzoneIPStracyConfig
 * JD-Core Version:    0.7.0.1
 */