package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileReq;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetProfileRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetProfileRequest";
  private INTERFACE.StGetProfileReq req = new INTERFACE.StGetProfileReq();
  
  public GetProfileRequest(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.req.appid.set(paramString1);
    paramString1 = this.req.withCredentials;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1.set(i);
      if (!TextUtils.isEmpty(paramString2)) {
        this.req.lang.set(paramString2);
      }
      return;
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetProfile";
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
    INTERFACE.StGetProfileRsp localStGetProfileRsp = new INTERFACE.StGetProfileRsp();
    try
    {
      localStGetProfileRsp.mergeFrom(paramArrayOfByte);
      if (localStGetProfileRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        if (localStGetProfileRsp.user != null)
        {
          paramArrayOfByte.put("nickName", localStGetProfileRsp.user.nick.get());
          paramArrayOfByte.put("avatarUrl", localStGetProfileRsp.user.avatar.get());
          paramArrayOfByte.put("gender", localStGetProfileRsp.user.gender.get());
          paramArrayOfByte.put("language", localStGetProfileRsp.user.language.get());
          if (localStGetProfileRsp.user.address != null)
          {
            paramArrayOfByte.put("province", localStGetProfileRsp.user.address.province.get());
            paramArrayOfByte.put("city", localStGetProfileRsp.user.address.city.get());
            paramArrayOfByte.put("country", localStGetProfileRsp.user.address.country.get());
          }
        }
        paramJSONObject.put("rawData", localStGetProfileRsp.rawData.get());
        paramJSONObject.put("signature", localStGetProfileRsp.signature.get());
        paramJSONObject.put("encryptedData", localStGetProfileRsp.encryptedData.get());
        paramJSONObject.put("iv", localStGetProfileRsp.iv.get());
        paramJSONObject.put("userInfo", paramArrayOfByte);
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("data", localStGetProfileRsp.rawData.get());
        paramArrayOfByte.put("signature", localStGetProfileRsp.signature.get());
        paramJSONObject.put("data", paramArrayOfByte.toString());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetProfileRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("GetProfileRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetProfileRequest
 * JD-Core Version:    0.7.0.1
 */