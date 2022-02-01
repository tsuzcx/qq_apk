package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpReq;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetNativeAppInfoRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetAppInfoByIdRequest";
  private INTERFACE.StGetNAppForJumpReq req = new INTERFACE.StGetNAppForJumpReq();
  
  public GetNativeAppInfoRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.req.android_pkg_name.set(paramString3);
    this.req.mini_appid.set(paramString1);
    this.req.native_appid.set(paramString2);
    this.req.scene.set(paramInt);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetNAppForJump";
  }
  
  protected String getModule()
  {
    return "mini_user_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetNAppForJumpRsp localStGetNAppForJumpRsp = new INTERFACE.StGetNAppForJumpRsp();
    try
    {
      localStGetNAppForJumpRsp.mergeFrom(paramArrayOfByte);
      if (localStGetNAppForJumpRsp != null)
      {
        paramJSONObject.put("packageName", localStGetNAppForJumpRsp.android_pkg.get());
        paramJSONObject.put("nativeAppId", localStGetNAppForJumpRsp.native_appid.get());
        paramJSONObject.put("downloadUrl", localStGetNAppForJumpRsp.android_donwload_url.get());
        paramJSONObject.put("appName", localStGetNAppForJumpRsp.appName.get());
        paramJSONObject.put("onlyOpen", localStGetNAppForJumpRsp.onlyOpen.get());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetAppInfoByIdRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("GetAppInfoByIdRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetNativeAppInfoRequest
 * JD-Core Version:    0.7.0.1
 */