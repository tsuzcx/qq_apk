package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SendHbLogic
{
  private SendHbActivity a;
  
  public SendHbLogic(SendHbActivity paramSendHbActivity)
  {
    this.a = paramSendHbActivity;
  }
  
  public void a()
  {
    Map localMap = this.a.getMapPacketExtra();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.nChannel);
    localStringBuilder.append("");
    localMap.put("channel", localStringBuilder.toString());
    localMap.put("bus_type", "1");
    localMap.put("type", "1");
    a(localMap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      localJSONObject.put("userId", paramString2);
      localJSONObject.put("viewTag", "qrcodeHb");
      localJSONObject.put("comeForm", 1);
      paramString2 = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        paramString2.putOpt("qrToken", paramString1);
      }
      paramString2.putOpt("comeFrom", Integer.valueOf(1));
      localJSONObject.put("extra_data", paramString2.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", localJSONObject.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.a.mReportSeq);
      PayBridgeActivity.tenpay(this.a, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    Object localObject = new JSONObject(paramMap);
    paramMap = this.a.getMapPacketJson();
    paramMap.put("extra_data", ((JSONObject)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("json", new JSONObject(paramMap).toString());
    ((Bundle)localObject).putString("callbackSn", "0");
    ((Bundle)localObject).putLong("vacreport_key_seq", this.a.mReportSeq);
    PayBridgeActivity.tenpay(this.a, 5, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic
 * JD-Core Version:    0.7.0.1
 */