package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReport_TagInfo_dc02283
  implements LpReportInfo
{
  public int data_version;
  public long operation_id;
  public long operation_type;
  public String photo_id;
  public String photo_tag;
  public String qua;
  public long uin;
  public int version_code;
  
  public String getSimpleInfo()
  {
    return null;
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
    localHashMap.put("operation_id", String.valueOf(this.operation_id));
    localHashMap.put("operation_type", String.valueOf(this.operation_type));
    LpReportUtils.safePut(localHashMap, "photo_id", this.photo_id);
    LpReportUtils.safePut(localHashMap, "photo_tag", this.photo_tag);
    LpReportUtils.safePut(localHashMap, "qua", this.qua);
    localHashMap.put("version_code", String.valueOf(this.version_code));
    localHashMap.put("data_version", String.valueOf(this.data_version));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_TagInfo_dc02283
 * JD-Core Version:    0.7.0.1
 */