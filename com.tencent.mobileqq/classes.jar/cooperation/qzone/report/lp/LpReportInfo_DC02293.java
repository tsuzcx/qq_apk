package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_DC02293
  implements LpReportInfo
{
  private static String TAG = "LpReport.LpReportInfo_DC02293";
  private String mMsg;
  private String mQzoneCmd;
  private int mRetCode;
  private long mTimeCost;
  
  public LpReportInfo_DC02293(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    this.mQzoneCmd = paramString1;
    this.mRetCode = paramInt;
    this.mMsg = paramString2;
    if (paramLong > 0L) {
      this.mTimeCost = (System.currentTimeMillis() - paramLong);
    }
  }
  
  public String getSimpleInfo()
  {
    return "DC02293";
  }
  
  public String getStringDate()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(localDate);
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    localHashMap.put("tabletype", String.valueOf(21));
    LpReportUtils.safePut(localHashMap, "LogTime", getStringDate());
    localHashMap.put("Event", this.mQzoneCmd);
    localHashMap.put("RetCode", String.valueOf(this.mRetCode));
    String str = this.mMsg;
    if (str == null) {
      str = "";
    }
    localHashMap.put("CmdMsg", str);
    localHashMap.put("TimeCost", String.valueOf(this.mTimeCost));
    localHashMap.put("AppId", "Android-QzoneInQQ");
    localHashMap.put("network", String.valueOf(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getnetworkType()));
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("deviceinfo", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_DC02293
 * JD-Core Version:    0.7.0.1
 */