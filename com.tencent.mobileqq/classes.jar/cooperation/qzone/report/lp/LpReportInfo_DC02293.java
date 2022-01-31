package cooperation.qzone.report.lp;

import bgxr;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.NetworkState;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

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
    localHashMap.put("Uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localHashMap.put("tabletype", String.valueOf(21));
    LpReportUtils.safePut(localHashMap, "LogTime", getStringDate());
    localHashMap.put("Event", this.mQzoneCmd);
    localHashMap.put("RetCode", String.valueOf(this.mRetCode));
    if (this.mMsg != null) {}
    for (String str = this.mMsg;; str = "")
    {
      localHashMap.put("CmdMsg", str);
      localHashMap.put("TimeCost", String.valueOf(this.mTimeCost));
      localHashMap.put("AppId", "Android-QzoneInQQ");
      localHashMap.put("network", String.valueOf(NetworkState.getNetworkType()));
      localHashMap.put("qua", bgxr.a());
      localHashMap.put("deviceinfo", bgxr.a());
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_DC02293
 * JD-Core Version:    0.7.0.1
 */