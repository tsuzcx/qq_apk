package cooperation.qzone.plugin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

class QZonePluginDownloadConfig$1
  implements Runnable
{
  QZonePluginDownloadConfig$1(QZonePluginDownloadConfig paramQZonePluginDownloadConfig, Properties paramProperties, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.val$properties.entrySet().iterator();
    HashMap localHashMap = new HashMap();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, this.val$s, true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloadConfig.1
 * JD-Core Version:    0.7.0.1
 */