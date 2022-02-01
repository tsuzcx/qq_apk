package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class PayRequest
  extends ProtoBufRequest
{
  private static final String TAG = "MiniAppPayRequest";
  private MiniAppMidasPay.StGamePayReq req = new MiniAppMidasPay.StGamePayReq();
  
  public PayRequest(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4)
  {
    this.req.appId.set(paramString1);
    this.req.prepayId.set(paramString2);
    this.req.starCurrency.set(paramInt1);
    this.req.balanceAmount.set(paramInt2);
    this.req.topupAmount.set(paramInt3);
    this.req.payChannel.set(paramInt4);
    this.req.sandboxEnv.set(paramInt5);
    paramString2 = new COMM.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new COMM.Entry();
    ((COMM.Entry)localObject).key.set("refer");
    PBStringField localPBStringField = ((COMM.Entry)localObject).value;
    boolean bool = TextUtils.isEmpty(paramString3);
    paramString1 = "";
    if (bool) {
      paramString3 = "";
    }
    localPBStringField.set(paramString3);
    localArrayList.add(localObject);
    paramString3 = new COMM.Entry();
    paramString3.key.set("via");
    localObject = paramString3.value;
    if (TextUtils.isEmpty(paramString4)) {
      paramString4 = paramString1;
    }
    ((PBStringField)localObject).set(paramString4);
    localArrayList.add(paramString3);
    paramString2.mapInfo.set(localArrayList);
    this.req.extInfo.setHasFlag(true);
    this.req.extInfo.set(paramString2);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GamePay";
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
    MiniAppMidasPay.StGamePayRsp localStGamePayRsp = new MiniAppMidasPay.StGamePayRsp();
    try
    {
      localStGamePayRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("response", localStGamePayRsp);
      paramJSONObject.put("resultCode", paramJSONObject.get("retCode"));
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("MiniAppPayRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.PayRequest
 * JD-Core Version:    0.7.0.1
 */