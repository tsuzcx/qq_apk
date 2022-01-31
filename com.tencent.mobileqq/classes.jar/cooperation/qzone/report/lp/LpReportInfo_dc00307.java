package cooperation.qzone.report.lp;

import bhsp;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReportInfo_dc00307
  implements LpReportInfo
{
  public static int ACTION_TYPE_RED_PACK = 48;
  public static int SUB_ACTION_TYPE_RED_PACK_CLICK = 27;
  public static int SUB_ACTION_TYPE_RED_PACK_EXPOSURE = 26;
  public static final int platform_id = 2;
  public int act_id;
  public int act_type;
  public int module_id;
  public String uin;
  
  public LpReportInfo_dc00307(int paramInt1, int paramInt2, int paramInt3)
  {
    this.act_id = paramInt1;
    this.act_type = paramInt2;
    this.module_id = paramInt3;
  }
  
  public String getSimpleInfo()
  {
    return "dc00307:" + this.act_id + "," + this.act_type;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (BaseApplicationImpl.getApplication().getRuntime().getAccount() != null)) {
      LpReportUtils.safePut(localHashMap, "uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }
    LpReportUtils.safePut(localHashMap, "act_id", this.act_id);
    LpReportUtils.safePut(localHashMap, "act_type", this.act_type);
    LpReportUtils.safePut(localHashMap, "platform_id", 2);
    LpReportUtils.safePut(localHashMap, "qq_version", "8.3.5.4555");
    LpReportUtils.safePut(localHashMap, "imei", bhsp.a("52b7f2"));
    LpReportUtils.safePut(localHashMap, "module_id", this.module_id);
    LpReportUtils.safePut(localHashMap, "data_timestamp", String.valueOf(System.currentTimeMillis()));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc00307
 * JD-Core Version:    0.7.0.1
 */