package com.tencent.qqmini.sdk.request;

import NS_MINI_REALTIMELOG.REALTIMELOG.StLogItem;
import NS_MINI_REALTIMELOG.REALTIMELOG.StReportLogReq;
import NS_MINI_REALTIMELOG.REALTIMELOG.StReportLogRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RealTimeLogReportRequest
  extends ProtoBufRequest
{
  private static final String unikey = "RealTimeLogReport";
  private REALTIMELOG.StReportLogReq req = new REALTIMELOG.StReportLogReq();
  
  public RealTimeLogReportRequest(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, List<RealTimeLogItem> paramList)
  {
    this.req.page.set(paramString1);
    this.req.jslib_version.set(paramString2);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString1 = paramArrayOfString[i];
      this.req.filter_msgs.add(paramString1);
      i += 1;
    }
    this.req.report_time.set(System.currentTimeMillis());
    this.req.appid.set(paramString3);
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (RealTimeLogItem)paramString1.next();
      paramString3 = new REALTIMELOG.StLogItem();
      paramString3.log_level.set(paramString2.level);
      paramString3.log_time.set(paramString2.time);
      paramString3.msg.set(paramString2.msg);
      this.req.logs.add(paramString3);
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "RealTimeLogReport";
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramJSONObject = new REALTIMELOG.StReportLogRsp();
    try
    {
      paramJSONObject.mergeFrom(decode(paramArrayOfByte));
      paramArrayOfByte = new JSONObject();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("ProtoBufRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.RealTimeLogReportRequest
 * JD-Core Version:    0.7.0.1
 */