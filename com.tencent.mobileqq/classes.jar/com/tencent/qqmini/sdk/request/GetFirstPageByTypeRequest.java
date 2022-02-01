package com.tencent.qqmini.sdk.request;

import NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeReq;
import NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JSONConverter;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetFirstPageByTypeRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetFirstPageByTypeRequest";
  private MiniAppStore.StGetFirstPageByTypeReq req = new MiniAppStore.StGetFirstPageByTypeReq();
  
  public GetFirstPageByTypeRequest(int paramInt)
  {
    this.req.uiPageType.set(paramInt);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetFirstPageByType";
  }
  
  protected String getModule()
  {
    return "store_app_client";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniAppStore.StGetFirstPageByTypeRsp localStGetFirstPageByTypeRsp = new MiniAppStore.StGetFirstPageByTypeRsp();
    try
    {
      localStGetFirstPageByTypeRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("data", JSONConverter.convert2JSONArray(localStGetFirstPageByTypeRsp.vecAppInfo.get()).toString());
      paramJSONObject.put("dataType", "string");
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetFirstPageByTypeRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetFirstPageByTypeRequest
 * JD-Core Version:    0.7.0.1
 */