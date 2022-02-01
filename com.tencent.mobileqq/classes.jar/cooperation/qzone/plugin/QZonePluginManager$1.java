package cooperation.qzone.plugin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class QZonePluginManager$1
  implements Runnable
{
  QZonePluginManager$1(QZonePluginManager paramQZonePluginManager, String paramString, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("plugin_id", this.val$pluginId);
    localHashMap.put("refer", String.valueOf(this.val$refer));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "QzonePluginDownloadRefer", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager.1
 * JD-Core Version:    0.7.0.1
 */