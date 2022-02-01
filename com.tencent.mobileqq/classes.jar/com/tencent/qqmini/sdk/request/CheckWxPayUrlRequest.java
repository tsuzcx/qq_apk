package com.tencent.qqmini.sdk.request;

import NS_MINI_APP_PAY.MiniAppMidasPay.StWxpayCheckMWebURLReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StWxpayCheckMWebURLRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class CheckWxPayUrlRequest
  extends ProtoBufRequest
{
  public static final String KEY_URL_VALID = "key_url_valid";
  private static final String TAG = "CheckWxPayUrlRequest";
  private MiniAppMidasPay.StWxpayCheckMWebURLReq req = new MiniAppMidasPay.StWxpayCheckMWebURLReq();
  
  public CheckWxPayUrlRequest(String paramString1, String paramString2)
  {
    this.req.appid.set(paramString1);
    this.req.mweb_url.set(paramString2);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "WxpayCheckMWebURL";
  }
  
  protected String getModule()
  {
    return "mini_app_pay";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniAppMidasPay.StWxpayCheckMWebURLRsp localStWxpayCheckMWebURLRsp = new MiniAppMidasPay.StWxpayCheckMWebURLRsp();
    try
    {
      localStWxpayCheckMWebURLRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("key_url_valid", localStWxpayCheckMWebURLRsp.is_valid);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("CheckWxPayUrlRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.CheckWxPayUrlRequest
 * JD-Core Version:    0.7.0.1
 */