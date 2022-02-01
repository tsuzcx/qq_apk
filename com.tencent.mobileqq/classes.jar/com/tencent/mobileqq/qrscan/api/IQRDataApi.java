package com.tencent.mobileqq.qrscan.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.QRCodeBusinessObserver;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@QAPI(process={""})
public abstract interface IQRDataApi
  extends QRouteApi
{
  public static final String PARAM_BQQ = "bqq";
  public static final String PARAM_CMD = "cmd";
  public static final String PARAM_D = "d";
  public static final String PARAM_EXTRA = "extra";
  public static final String PARAM_NO_VERIFY_TOKEN = "no_verify_token";
  public static final String PARAM_SKEY = "skey";
  
  public abstract void requestUrlDecode(AppRuntime paramAppRuntime, String paramString, JSONObject paramJSONObject, Bundle paramBundle, QRCodeBusinessObserver paramQRCodeBusinessObserver);
  
  public abstract void requestUrlEncode(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, QRCodeBusinessObserver paramQRCodeBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRDataApi
 * JD-Core Version:    0.7.0.1
 */