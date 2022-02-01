package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REALTIMELOG.REALTIMELOG.StLogItem;
import NS_MINI_REALTIMELOG.REALTIMELOG.StReportLogReq;
import NS_MINI_REALTIMELOG.REALTIMELOG.StReportLogRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import java.util.Iterator;
import java.util.List;

public class RealTimeLogReportRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_log_report.ReportLog";
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
    }
  }
  
  public static REALTIMELOG.StReportLogRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      REALTIMELOG.StReportLogRsp localStReportLogRsp = new REALTIMELOG.StReportLogRsp();
      try
      {
        localStReportLogRsp.mergeFrom(decode(paramArrayOfByte));
        return localStReportLogRsp;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ProtoBufRequest", 2, "onResponse fail." + paramArrayOfByte);
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.RealTimeLogReportRequest
 * JD-Core Version:    0.7.0.1
 */