package cooperation.qzone.report.lp;

import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

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
    return "dc03701:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    LpReportUtils.safePut(localHashMap, "qua", QUA.getQUA3());
    if (this.uin == 0L) {}
    for (String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();; str = String.valueOf(this.uin))
    {
      LpReportUtils.safePut(localHashMap, "uin", str);
      LpReportUtils.safePut(localHashMap, "actiontype", this.actiontype);
      LpReportUtils.safePut(localHashMap, "subactiontype", this.subactiontype);
      LpReportUtils.safePut(localHashMap, "reserves", this.reserves);
      if ((this.extraInfoMap != null) && (this.extraInfoMap.size() > 0)) {
        localHashMap.putAll(this.extraInfoMap);
      }
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc03701
 * JD-Core Version:    0.7.0.1
 */