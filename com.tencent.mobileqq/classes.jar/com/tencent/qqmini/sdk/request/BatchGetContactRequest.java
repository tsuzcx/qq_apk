package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StBatchGetContactReq;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
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
    paramJSONObject = new INTERFACE.StGetRobotUinRsp();
    paramJSONObject.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = GdtJsonPbUtil.pbToJson(paramJSONObject);
    if ((paramArrayOfByte instanceof JSONObject)) {
      return (JSONObject)JSONObject.class.cast(paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.BatchGetContactRequest
 * JD-Core Version:    0.7.0.1
 */