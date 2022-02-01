package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReport_Smart_dc02363
  implements LpReportInfo
{
  public long batch_id;
  public String msg;
  public String qua;
  public long uin;
  
  public LpReport_Smart_dc02363(long paramLong, String paramString)
  {
    this.batch_id = paramLong;
    this.msg = paramString;
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc02363:batch_id:,");
    localStringBuilder.append(this.batch_id);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    long l = this.uin;
    String str;
    if (l <= 1000L) {
      str = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount();
    } else {
      str = String.valueOf(l);
    }
    localHashMap.put("uin", str);
    LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("batch_id", String.valueOf(this.batch_id));
    LpReportUtils.safePut(localHashMap, "msg", this.msg);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_Smart_dc02363
 * JD-Core Version:    0.7.0.1
 */