package cooperation.qzone.report.lp;

import bgyi;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReportInfo_dc02216
  implements LpReportInfo
{
  public static final int ACTION_TYPE_HOME_PAGE_FOOTER_BANNER = 17;
  public static final int SUB_ACTION_FOOTER_BANNER_CLICK = 1;
  public static final int SUB_ACTION_FOOTER_BANNER_CLOSE = 2;
  public static final int SUB_ACTION_FOOTER_BANNER_EXPOSE = 3;
  public int actiontype;
  public String platform;
  public String qua;
  public int subactiontype;
  public long uin;
  
  public LpReportInfo_dc02216(int paramInt1, int paramInt2)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
  }
  
  public static void reportExit()
  {
    LpReportInfo_dc02216 localLpReportInfo_dc02216 = new LpReportInfo_dc02216(9, 4);
    LpReportManager.getInstance().reportToDC02216(localLpReportInfo_dc02216, false, true);
  }
  
  public static void reportSend()
  {
    LpReportInfo_dc02216 localLpReportInfo_dc02216 = new LpReportInfo_dc02216(9, 2);
    LpReportManager.getInstance().reportToDC02216(localLpReportInfo_dc02216, false, true);
  }
  
  public static void reportShare()
  {
    LpReportInfo_dc02216 localLpReportInfo_dc02216 = new LpReportInfo_dc02216(9, 1);
    LpReportManager.getInstance().reportToDC02216(localLpReportInfo_dc02216, false, true);
  }
  
  public String getSimpleInfo()
  {
    return "dc02216:" + "actiontype:" + this.actiontype + " subactiontype:" + this.subactiontype;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.uin != 0L) {
      localHashMap.put("uin", String.valueOf(this.uin));
    }
    for (;;)
    {
      localHashMap.put("qua", bgyi.a());
      LpReportUtils.safePut(localHashMap, "platform", this.platform);
      localHashMap.put("actiontype", String.valueOf(this.actiontype));
      localHashMap.put("subactiontype", String.valueOf(this.subactiontype));
      return localHashMap;
      localHashMap.put("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02216
 * JD-Core Version:    0.7.0.1
 */