package cooperation.qzone.report.lp;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LpReport_ImgPreload_dc02506
  implements LpReportInfo
{
  private static String TAG = "LpReport_ImgPreload_dc02506";
  private ConcurrentHashMap<String, String> reportMap;
  
  public LpReport_ImgPreload_dc02506(ConcurrentHashMap<String, String> paramConcurrentHashMap)
  {
    this.reportMap = paramConcurrentHashMap;
  }
  
  public String getSimpleInfo()
  {
    return null;
  }
  
  public Map<String, String> toMap()
  {
    return this.reportMap;
  }
  
  public String toString()
  {
    if (this.reportMap == null) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = this.reportMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)this.reportMap.get(str1);
        localStringBuilder.append(str1);
        if (str2 != null)
        {
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          localStringBuilder.append("\n");
        }
        else
        {
          localStringBuilder.append(":null \n");
        }
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_ImgPreload_dc02506
 * JD-Core Version:    0.7.0.1
 */