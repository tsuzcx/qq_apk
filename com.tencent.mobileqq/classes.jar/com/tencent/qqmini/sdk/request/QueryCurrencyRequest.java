package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class QueryCurrencyRequest
  extends ProtoBufRequest
{
  private static final String TAG = "QueryCurrencyRequest";
  private MiniAppMidasPay.StQueryStarCurrencyReq req = new MiniAppMidasPay.StQueryStarCurrencyReq();
  
  public QueryCurrencyRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.appId.set(paramString1);
    this.req.prepayId.set(paramString2);
    this.req.starCurrency.set(paramInt1);
    this.req.sandboxEnv.set(paramInt2);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "QueryStarCurrency";
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
    MiniAppMidasPay.StQueryStarCurrencyRsp localStQueryStarCurrencyRsp = new MiniAppMidasPay.StQueryStarCurrencyRsp();
    try
    {
      localStQueryStarCurrencyRsp.mergeFrom(paramArrayOfByte);
      if (localStQueryStarCurrencyRsp != null)
      {
        paramJSONObject.put("response", localStQueryStarCurrencyRsp);
        paramJSONObject.put("resultCode", paramJSONObject.get("retCode"));
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("QueryCurrencyRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("QueryCurrencyRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.QueryCurrencyRequest
 * JD-Core Version:    0.7.0.1
 */