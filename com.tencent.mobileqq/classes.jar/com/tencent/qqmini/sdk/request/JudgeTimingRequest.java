package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class JudgeTimingRequest
  extends ProtoBufRequest
{
  public static final String TAG = "JudgeTimingRequest";
  private INTERFACE.StJudgeTimingReq req = new INTERFACE.StJudgeTimingReq();
  
  public JudgeTimingRequest(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, String paramString4, String paramString5)
  {
    this.req.appid.set(paramString1);
    this.req.appType.set(paramInt1);
    this.req.scene.set(paramInt2);
    this.req.factType.set(paramInt3);
    this.req.reportTime.set(paramLong);
    this.req.totalTime.set(paramInt4);
    this.req.launchId.set(paramString2);
    this.req.afterCertify.set(paramInt5);
    this.req.via.set(paramString3);
    this.req.AdsTotalTime.set(paramInt6);
    this.req.sourceID.set(paramString5);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    if (paramString4 != null) {
      this.req.hostExtInfo.set(paramString4);
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "JudgeTiming";
  }
  
  protected String getModule()
  {
    return "mini_app_growguard";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StJudgeTimingRsp localStJudgeTimingRsp = new INTERFACE.StJudgeTimingRsp();
    try
    {
      localStJudgeTimingRsp.mergeFrom(paramArrayOfByte);
      if (localStJudgeTimingRsp != null)
      {
        paramJSONObject.put("response", localStJudgeTimingRsp);
        paramJSONObject.put("resultCode", 0);
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("JudgeTimingRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("JudgeTimingRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.JudgeTimingRequest
 * JD-Core Version:    0.7.0.1
 */