package cooperation.qzone.statistic.serverip;

import common.config.service.QzoneConfig;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class WebAppIpRecord$FixedSizeLinkedHashMap
  extends LinkedHashMap
{
  private static int a = QzoneConfig.getInstance().getConfig("QZoneSetting", "LatestWebappIPCount", 3);
  private static final long serialVersionUID = 6918023506928428613L;
  
  public static int getMAX_ENTRIES()
  {
    return a;
  }
  
  public static void setMAX_ENTRIES(int paramInt)
  {
    a = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpRecord.FixedSizeLinkedHashMap
 * JD-Core Version:    0.7.0.1
 */