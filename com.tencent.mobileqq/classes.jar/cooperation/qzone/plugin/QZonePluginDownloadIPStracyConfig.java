package cooperation.qzone.plugin;

import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class QZonePluginDownloadIPStracyConfig
  extends IPConfigStrategy
  implements QzoneConfig.QzoneConfigChangeListener
{
  private static final String TAG = "QZonePluginDownloadIPStracyConfig";
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
  
  public QZonePluginDownloadIPStracyConfig()
  {
    initConfig();
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void addConfigItem(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("||");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
      paramString1 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("addConfigItem, key=");
        paramString2.append((String)localObject);
        paramString2.append(", content=");
        paramString2.append(paramString1);
        QLog.d("QZonePluginDownloadIPStracyConfig", 2, paramString2.toString());
      }
      paramMap.put(localObject, paramString1);
    }
  }
  
  private void addSpecifyItem(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMap != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      Object localObject = null;
      paramString3 = QzoneConfig.getInstance().getConfig(paramString1, paramString3, paramString4);
      paramString4 = new StringBuilder();
      paramString4.append(paramString1);
      paramString4.append("||");
      paramString4.append(paramString2);
      paramString4 = paramString4.toString();
      paramString2 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
      paramString1 = localObject;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = localObject;
        if (!TextUtils.isEmpty(paramString3)) {
          paramString1 = paramString2.replace("ips", paramString3);
        }
      }
      if (TextUtils.isEmpty(paramString1))
      {
        paramMap.put(paramString4, paramString2);
        return;
      }
      paramMap.put(paramString4, paramString1);
    }
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
  
  private boolean strEqual(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return paramString2 == null;
  }
  
  public void onConfigChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPStracyConfig", 2, "QzoneIPStracyConfig receive change");
    }
    initConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloadIPStracyConfig
 * JD-Core Version:    0.7.0.1
 */