package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

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
    StringBuilder localStringBuilder = new StringBuilder("dc02216:");
    localStringBuilder.append("actiontype:");
    localStringBuilder.append(this.actiontype);
    localStringBuilder.append(" subactiontype:");
    localStringBuilder.append(this.subactiontype);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    long l = this.uin;
    if (l != 0L) {
      localHashMap.put("uin", String.valueOf(l));
    } else {
      localHashMap.put("uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    }
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    LpReportUtils.safePut(localHashMap, "platform", this.platform);
    localHashMap.put("actiontype", String.valueOf(this.actiontype));
    localHashMap.put("subactiontype", String.valueOf(this.subactiontype));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02216
 * JD-Core Version:    0.7.0.1
 */