package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StBatchGetContactReq;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinRsp;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.GdtJsonPbUtil;
import java.util.List;
import org.json.JSONObject;

public class BatchGetContactRequest
  extends ProtoBufRequest
{
  private static final String TAG = "VerifyPluginRequest";
  private INTERFACE.StBatchGetContactReq req = new INTERFACE.StBatchGetContactReq();
  
  public BatchGetContactRequest(List<String> paramList)
  {
    this.req.appids.set(paramList);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "BatchGetContact";
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    paramJSONObject = null;
    Object localObject = new INTERFACE.StGetRobotUinRsp();
    ((INTERFACE.StGetRobotUinRsp)localObject).mergeFrom(paramArrayOfByte);
    if (localObject != null)
    {
      localObject = GdtJsonPbUtil.pbToJson((PBField)localObject);
      paramArrayOfByte = paramJSONObject;
      if ((localObject instanceof JSONObject)) {
        paramArrayOfByte = (JSONObject)JSONObject.class.cast(localObject);
      }
      return paramArrayOfByte;
    }
    QMLog.d("VerifyPluginRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.BatchGetContactRequest
 * JD-Core Version:    0.7.0.1
 */