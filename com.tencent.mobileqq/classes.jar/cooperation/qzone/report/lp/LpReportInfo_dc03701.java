package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc03701
  implements LpReportInfo
{
  public static String TAG = "LpReport.LpReportInfo_dc03701";
  public String actiontype;
  public HashMap<String, String> extraInfoMap;
  private boolean isNeedSample;
  private boolean isReportNow;
  public String qua;
  public String reserves;
  public String subactiontype;
  public long uin;
  
  public LpReportInfo_dc03701(String paramString1, String paramString2)
  {
    this.actiontype = paramString1;
    this.subactiontype = paramString2;
    this.isNeedSample = false;
    this.isReportNow = false;
  }
  
  public LpReportInfo_dc03701(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2);
    this.reserves = paramString3;
  }
  
  public LpReportInfo_dc03701(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    this(paramString1, paramString2, paramString3);
    this.extraInfoMap = paramHashMap;
  }
  
  public static void report(LpReportInfo_dc03701 paramLpReportInfo_dc03701)
  {
    LpReportManager.getInstance().reportToDC03701(paramLpReportInfo_dc03701, paramLpReportInfo_dc03701.isNeedSample, paramLpReportInfo_dc03701.isReportNow);
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc03701:");
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
    LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    long l = this.uin;
    if (l == 0L) {
      localObject = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount();
    } else {
      localObject = String.valueOf(l);
    }
    LpReportUtils.safePut(localHashMap, "uin", (String)localObject);
    LpReportUtils.safePut(localHashMap, "actiontype", this.actiontype);
    LpReportUtils.safePut(localHashMap, "subactiontype", this.subactiontype);
    LpReportUtils.safePut(localHashMap, "reserves", this.reserves);
    Object localObject = this.extraInfoMap;
    if ((localObject != null) && (((HashMap)localObject).size() > 0)) {
      localHashMap.putAll(this.extraInfoMap);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc03701
 * JD-Core Version:    0.7.0.1
 */