package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc00420
  implements LpReportInfo
{
  public int Active;
  public int actionid;
  public int actiontype;
  public String apilevel;
  public int clientid;
  public String display;
  public String gateway_ip;
  public String imei;
  public int interact_type;
  public int is_online;
  public int isbreak;
  public int mainid;
  public int mergenum;
  public int mergetype;
  public String mobile_type;
  int mubanid;
  public String network_type;
  public String os_version;
  public String pushstatkey;
  public String qua;
  public String reserves;
  public int subactiontype;
  public String system_rom_type;
  public int type;
  public long uin;
  
  public LpReportInfo_dc00420(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramString1;
    this.pushstatkey = paramString2;
    this.mergenum = paramInt3;
  }
  
  public static void report(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    paramString1 = new LpReportInfo_dc00420(paramInt1, paramInt2, paramString1, paramString2, paramInt3);
    LpReportManager.getInstance().reportToDC00420(paramString1, false, true);
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc00420:");
    localStringBuilder.append(this.actiontype);
    localStringBuilder.append(",");
    localStringBuilder.append(this.subactiontype);
    localStringBuilder.append(",");
    localStringBuilder.append(this.reserves);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    localHashMap.put("actiontype", String.valueOf(this.actiontype));
    localHashMap.put("subactiontype", String.valueOf(this.subactiontype));
    LpReportUtils.safePut(localHashMap, "reserves", this.reserves);
    LpReportUtils.safePut(localHashMap, "pushstatkey", this.pushstatkey);
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("mergenum", String.valueOf(this.mergenum));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc00420
 * JD-Core Version:    0.7.0.1
 */