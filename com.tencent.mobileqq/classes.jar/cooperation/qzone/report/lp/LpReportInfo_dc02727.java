package cooperation.qzone.report.lp;

import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class LpReportInfo_dc02727
  implements LpReportInfo
{
  private static final String TAG = "LpReportInfo_dc02727";
  private String appId;
  private long batchCtrlElapse;
  private long ctrlElapse;
  private long dataElapse;
  private long elapse;
  private long endTime;
  private String entry = "";
  private String errMsg;
  private String extend;
  private long fileSize;
  private int flow;
  private int networkType;
  private String qua;
  private String refer;
  private int reportType;
  private int retCode;
  private String serverIp;
  private String terminal;
  private String terminalVersion;
  private long uin;
  
  public LpReportInfo_dc02727(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
    this.qua = QUA.a();
  }
  
  private void init(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.fileSize = paramJSONObject.optLong("size");
      this.elapse = paramJSONObject.optLong("delay");
      this.networkType = paramJSONObject.optInt("network");
      this.terminal = paramJSONObject.optString("terminal");
      this.terminalVersion = paramJSONObject.optString("terminalver");
      this.refer = paramJSONObject.optString("refer");
      this.retCode = paramJSONObject.optInt("errcode");
      this.uin = paramJSONObject.optLong("uin");
      this.endTime = paramJSONObject.optLong("time");
      this.flow = paramJSONObject.optInt("flow");
      this.serverIp = paramJSONObject.optString("sip");
      this.appId = paramJSONObject.optString("appid");
      this.errMsg = paramJSONObject.optString("msg");
      this.extend = paramJSONObject.optString("extend");
      this.entry = paramJSONObject.optString("entry");
      this.ctrlElapse = paramJSONObject.optLong("ctrlDelay");
      this.dataElapse = paramJSONObject.optLong("dataDelay");
      this.batchCtrlElapse = paramJSONObject.optLong("batchCtrlDelayPer");
      this.reportType = paramJSONObject.optInt("reportType");
    }
  }
  
  public static void report(LpReportInfo_dc02727 paramLpReportInfo_dc02727, boolean paramBoolean1, boolean paramBoolean2)
  {
    LpReportManager.getInstance().reportToDC02727(paramLpReportInfo_dc02727, paramBoolean1, paramBoolean2);
  }
  
  public static void report(JSONArray paramJSONArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0)) {
      return;
    }
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        report(new LpReportInfo_dc02727(paramJSONArray.getJSONObject(i)), paramBoolean1, paramBoolean2);
        i += 1;
      }
      QZLog.i("LpReportInfo_dc02727", "upload2: report to lp dc02727");
      return;
    }
    catch (Throwable paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public String getSimpleInfo()
  {
    return "dc02727: flowId=" + this.flow + ", file size=" + this.fileSize + ", cost time=" + this.elapse;
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("size", String.valueOf(this.fileSize));
    localHashMap.put("delay", String.valueOf(this.elapse));
    localHashMap.put("network", String.valueOf(this.networkType));
    localHashMap.put("terminal", this.terminal);
    localHashMap.put("terminalver", this.terminalVersion);
    localHashMap.put("refer", this.refer);
    localHashMap.put("errcode", String.valueOf(this.retCode));
    localHashMap.put("uin", String.valueOf(this.uin));
    localHashMap.put("time", String.valueOf(this.endTime));
    localHashMap.put("flow", String.valueOf(this.flow));
    localHashMap.put("sip", this.serverIp);
    localHashMap.put("appid", this.appId);
    localHashMap.put("msg", this.errMsg);
    localHashMap.put("extend", this.extend);
    localHashMap.put("entry", this.entry);
    localHashMap.put("ctrlDelay", String.valueOf(this.ctrlElapse));
    localHashMap.put("dataDelay", String.valueOf(this.dataElapse));
    localHashMap.put("batchCtrlDelayPer", String.valueOf(this.batchCtrlElapse));
    localHashMap.put("reportType", String.valueOf(this.reportType));
    localHashMap.put("qua", this.qua);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02727
 * JD-Core Version:    0.7.0.1
 */