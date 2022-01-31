package cooperation.qzone.report.lp;

import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

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
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.uin <= 1000L) {}
    for (String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();; str = String.valueOf(this.uin))
    {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_TagInfo_dc02283
 * JD-Core Version:    0.7.0.1
 */