package cooperation.qzone.statistic.serverip;

import common.config.service.QzoneConfig;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class WebAppIpRecord$FixedSizeLinkedHashMap<K, V>
  extends LinkedHashMap<K, V>
{
  private static int MAX_ENTRIES = QzoneConfig.getInstance().getConfig("QZoneSetting", "LatestWebappIPCount", 3);
  private static final long serialVersionUID = 6918023506928428613L;
  
  public static int getMAX_ENTRIES()
  {
    return MAX_ENTRIES;
  }
  
  public static void setMAX_ENTRIES(int paramInt)
  {
    MAX_ENTRIES = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > MAX_ENTRIES;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpRecord.FixedSizeLinkedHashMap
 * JD-Core Version:    0.7.0.1
 */