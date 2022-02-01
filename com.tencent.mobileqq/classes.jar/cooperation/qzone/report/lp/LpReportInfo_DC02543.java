package cooperation.qzone.report.lp;

import blru;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LpReportInfo_DC02543
  implements LpReportInfo
{
  private static final String QUA = ;
  private static final String TABLE_NAME = "DC02543";
  private long clientTime;
  private String envent;
  private HashMap<String, String> msgMap;
  private String retcode = "0";
  private long serverTime;
  private long timeCost;
  private String uin;
  
  public LpReportInfo_DC02543(String paramString1, String paramString2, long paramLong)
  {
    this(paramString1, paramString2, "0", paramLong, null);
  }
  
  public LpReportInfo_DC02543(String paramString1, String paramString2, String paramString3, long paramLong, HashMap<String, String> paramHashMap)
  {
    this.uin = paramString1;
    this.envent = paramString2;
    this.retcode = paramString3;
    this.timeCost = paramLong;
    this.msgMap = paramHashMap;
    this.clientTime = System.currentTimeMillis();
    this.serverTime = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public String getSimpleInfo()
  {
    return "DC02543";
  }
  
  public Map<String, String> toMap()
  {
    localObject3 = "";
    Object localObject1 = localObject3;
    if (this.msgMap != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msgMap);
      localObject1 = localObject3;
      if (localJSONObject != null) {
        localObject1 = localJSONObject.toString();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.d("QZLog", 4, "", localException);
        Object localObject2 = localObject3;
      }
    }
    localObject3 = new HashMap();
    ((HashMap)localObject3).put("Uin", this.uin);
    ((HashMap)localObject3).put("Event", this.envent);
    ((HashMap)localObject3).put("RetCode", this.retcode);
    ((HashMap)localObject3).put("TimeCost", String.valueOf(this.timeCost));
    ((HashMap)localObject3).put("msg", localObject1);
    ((HashMap)localObject3).put("QUA", QUA);
    ((HashMap)localObject3).put("clientTime", String.valueOf(this.clientTime));
    ((HashMap)localObject3).put("serverTime", String.valueOf(this.serverTime));
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_DC02543
 * JD-Core Version:    0.7.0.1
 */