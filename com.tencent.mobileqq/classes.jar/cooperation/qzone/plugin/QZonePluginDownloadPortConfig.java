package cooperation.qzone.plugin;

import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class QZonePluginDownloadPortConfig
  extends PortConfigStrategy
  implements QzoneConfig.QzoneConfigChangeListener
{
  private static final String defaultPortStrategy = "{'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}";
  
  public QZonePluginDownloadPortConfig()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadPortConfig", 2, "defaultPortStrategy={'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}");
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZonePluginDownloadPortConfig.1(this));
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void initConfig()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadAccessPortList");
    if (str != null) {}
    for (;;)
    {
      setConfig(str);
      return;
      str = "{'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}";
    }
  }
  
  private void initPort()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadAccessPortList");
    if (str != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginDownloadPortConfig", 2, "initPort, ports=" + str);
      }
      setConfig(str);
    }
  }
  
  public void onConfigChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadPortConfig", 2, "QzoneDownloadPortConfig receive change");
    }
    initPort();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloadPortConfig
 * JD-Core Version:    0.7.0.1
 */