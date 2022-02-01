package com.tencent.qqmini.sdk.request;

import NS_MINI_REPORT.REPORT.StDcReportRsp;
import NS_MINI_REPORT.REPORT.StGameDcReportRsp;
import NS_MINI_REPORT.REPORT.StThirdDcReportRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class DcReportRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "DcReport";
  public static final String CMD_STRING_GAME_CP_REPORT = "GameDcReport";
  public static final String CMD_STRING_THIRD_PARTY_REPORT = "ThirdDcReport";
  public static final String MODULE_APIREPORT = "mini_app_apireport";
  public static final String MODULE_DCREPORT = "mini_app_dcreport";
  private String cmdName;
  private byte[] datas;
  private String module;
  
  public DcReportRequest(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.datas = paramArrayOfByte;
    this.module = paramString1;
    this.cmdName = paramString2;
  }
  
  public byte[] getBusiBuf()
  {
    return this.datas;
  }
  
  protected String getCmdName()
  {
    String str = this.cmdName;
    if (str != null) {
      return str;
    }
    return "DcReport";
  }
  
  protected String getModule()
  {
    String str = this.module;
    if (str != null) {
      return str;
    }
    return "mini_app_dcreport";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int i;
    do
    {
      try
      {
        Object localObject;
        if ("ThirdDcReport".equals(this.cmdName))
        {
          localObject = new REPORT.StThirdDcReportRsp();
          ((REPORT.StThirdDcReportRsp)localObject).mergeFrom(paramArrayOfByte);
          i = ((REPORT.StThirdDcReportRsp)localObject).ret.get();
        }
        else if ("GameDcReport".equals(this.cmdName))
        {
          localObject = new REPORT.StGameDcReportRsp();
          ((REPORT.StGameDcReportRsp)localObject).mergeFrom(paramArrayOfByte);
          i = ((REPORT.StGameDcReportRsp)localObject).ret.get();
        }
        else
        {
          localObject = new REPORT.StDcReportRsp();
          ((REPORT.StDcReportRsp)localObject).mergeFrom(paramArrayOfByte);
          i = ((REPORT.StDcReportRsp)localObject).ret.get();
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onResponse fail.");
        paramJSONObject.append(paramArrayOfByte);
        QMLog.d("ProtoBufRequest", paramJSONObject.toString());
        return null;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onResponse fail.retCode = ");
      paramArrayOfByte.append(i);
      QMLog.d("ProtoBufRequest", paramArrayOfByte.toString());
      return null;
    } while (i != 0);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.DcReportRequest
 * JD-Core Version:    0.7.0.1
 */