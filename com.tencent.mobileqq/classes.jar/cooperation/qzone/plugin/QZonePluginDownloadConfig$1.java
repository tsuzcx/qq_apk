package cooperation.qzone.plugin;

import bctj;
import bmdh;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class QZonePluginDownloadConfig$1
  implements Runnable
{
  public QZonePluginDownloadConfig$1(bmdh parambmdh, Properties paramProperties, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilProperties.entrySet().iterator();
    HashMap localHashMap = new HashMap();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    bctj.a(BaseApplicationImpl.getContext()).a(null, this.jdField_a_of_type_JavaLangString, true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloadConfig.1
 * JD-Core Version:    0.7.0.1
 */