package cooperation.qzone.report.lp;

import android.os.Build;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReport_Retention_dc03208
  implements LpReportInfo
{
  public static final String TAG = "LpReport.LpReport_Retention_dc03208";
  public int device;
  public String function;
  public String mobile_type;
  public int network_type;
  public String qua;
  public String reserves;
  public String reserves2;
  public String reserves3;
  public long uin;
  public String version;
  
  public LpReport_Retention_dc03208(String paramString1, String paramString2)
  {
    this.function = paramString1;
    this.reserves = paramString2;
  }
  
  public static void report(String paramString, HashMap<String, String> paramHashMap)
  {
    String str = null;
    if (paramHashMap != null) {
      str = paramHashMap.toString();
    }
    paramString = new LpReport_Retention_dc03208(paramString, str);
    LpReportManager.getInstance().reportToDC03208(paramString, false, false);
  }
  
  public String getSimpleInfo()
  {
    return "function:" + this.function;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    LpReportUtils.safePut(localHashMap, "uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    int i = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType();
    localHashMap.put("network_type", String.valueOf(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).convertNetworkTypeToFitInDc00518(i)));
    LpReportUtils.safePut(localHashMap, "mobile_type", Build.MODEL);
    localHashMap.put("device", "2");
    LpReportUtils.safePut(localHashMap, "function", this.function);
    LpReportUtils.safePut(localHashMap, "version", this.version);
    LpReportUtils.safePut(localHashMap, "reserves", this.reserves);
    LpReportUtils.safePut(localHashMap, "reserves2", this.reserves2);
    LpReportUtils.safePut(localHashMap, "reserves3", this.reserves3);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReport_Retention_dc03208
 * JD-Core Version:    0.7.0.1
 */