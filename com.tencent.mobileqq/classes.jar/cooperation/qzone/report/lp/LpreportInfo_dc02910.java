package cooperation.qzone.report.lp;

import bgyi;
import java.util.HashMap;
import java.util.Map;

public class LpreportInfo_dc02910
  implements LpReportInfo
{
  public int index;
  public int operTimes;
  public int operType;
  public String traceInfo;
  public long uin;
  
  public String getSimpleInfo()
  {
    return String.format("dc02910 traceinfo:%s ,index:%d,operType:%d operTime:%d", new Object[] { this.traceInfo, Integer.valueOf(this.index), Integer.valueOf(this.operType), Integer.valueOf(this.operTimes) });
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qua", bgyi.a());
    localHashMap.put("uin", String.valueOf(this.uin));
    localHashMap.put("traceinfo", String.valueOf(this.traceInfo));
    localHashMap.put("idx", String.valueOf(this.index));
    localHashMap.put("opt_times", String.valueOf(this.operTimes));
    localHashMap.put("opt_type", String.valueOf(this.operType));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpreportInfo_dc02910
 * JD-Core Version:    0.7.0.1
 */