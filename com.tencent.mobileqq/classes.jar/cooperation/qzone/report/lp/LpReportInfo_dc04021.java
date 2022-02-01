package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc04021
  implements LpReportInfo
{
  public long delayCallback;
  public long flingCallback;
  public long idleCallback;
  public long intimeCallback;
  public long noCallback;
  private String qua = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3();
  public long totalDuration;
  public long touchScrollCallback;
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc04021: total_duration=");
    localStringBuilder.append(this.totalDuration);
    localStringBuilder.append(" intime_callback=");
    localStringBuilder.append(this.intimeCallback);
    localStringBuilder.append(" delay_callback=");
    localStringBuilder.append(this.delayCallback);
    localStringBuilder.append(" no_callback=");
    localStringBuilder.append(this.noCallback);
    localStringBuilder.append(" idle_callback=");
    localStringBuilder.append(this.idleCallback);
    localStringBuilder.append(" touch_scroll_callback=");
    localStringBuilder.append(this.touchScrollCallback);
    localStringBuilder.append(" fling_callback=");
    localStringBuilder.append(this.flingCallback);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_duration", String.valueOf(this.totalDuration));
    localHashMap.put("intime_callback", String.valueOf(this.intimeCallback));
    localHashMap.put("delay_callback", String.valueOf(this.delayCallback));
    localHashMap.put("no_callback", String.valueOf(this.noCallback));
    localHashMap.put("idle_callback", String.valueOf(this.idleCallback));
    localHashMap.put("touch_scroll_callback", String.valueOf(this.touchScrollCallback));
    localHashMap.put("fling_callback", String.valueOf(this.flingCallback));
    localHashMap.put("qua", this.qua);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc04021
 * JD-Core Version:    0.7.0.1
 */