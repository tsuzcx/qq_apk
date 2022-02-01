package com.tencent.qqmini.sdk.request;

import NS_MINI_AD.MiniAppAd.StGetSdkAdInfoReq;
import NS_MINI_AD.MiniAppAd.StGetSdkAdInfoRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetAdInfoRequest
  extends ProtoBufRequest
{
  public static final String CATEGORY = "category";
  public static final String POSID = "posId";
  public static final String SOURCE_FROM = "sourceFrom";
  private static final String TAG = "GetAdRequest";
  private MiniAppAd.StGetSdkAdInfoReq req = new MiniAppAd.StGetSdkAdInfoReq();
  
  public GetAdInfoRequest(String paramString1, int paramInt, String paramString2)
  {
    this.req.strAppid.set(paramString1);
    this.req.iAdType.set(paramInt);
    this.req.strSubPosId.set(paramString2);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetSdkAdInfo";
  }
  
  protected String getModule()
  {
    return "mini_app_ad";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniAppAd.StGetSdkAdInfoRsp localStGetSdkAdInfoRsp = new MiniAppAd.StGetSdkAdInfoRsp();
    try
    {
      localStGetSdkAdInfoRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("sourceFrom", localStGetSdkAdInfoRsp.strSourceFrom.get());
      paramJSONObject.put("category", localStGetSdkAdInfoRsp.strMiniCategory.get());
      paramJSONObject.put("posId", localStGetSdkAdInfoRsp.strPosId.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetAdRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAdInfoRequest
 * JD-Core Version:    0.7.0.1
 */