package cooperation.qzone.report.lp;

import bfpk;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

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
    return "dc02363:batch_id:," + this.batch_id;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.uin <= 1000L) {}
    for (String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();; str = String.valueOf(this.uin))
    {
      localHashMap.put("uin", str);
      LpReportUtils.safePut(localHashMap, "qua", bfpk.a());
      localHashMap.put("batch_id", String.valueOf(this.batch_id));
      LpReportUtils.safePut(localHashMap, "msg", this.msg);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_Smart_dc02363
 * JD-Core Version:    0.7.0.1
 */