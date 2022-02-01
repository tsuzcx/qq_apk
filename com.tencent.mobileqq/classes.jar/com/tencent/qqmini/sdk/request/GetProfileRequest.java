package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileReq;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetProfileRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetProfileRequest";
  private INTERFACE.StGetProfileReq req;
  
  public GetProfileRequest(String paramString1, boolean paramBoolean, String paramString2) {}
  
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
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetProfileRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetProfileRequest
 * JD-Core Version:    0.7.0.1
 */