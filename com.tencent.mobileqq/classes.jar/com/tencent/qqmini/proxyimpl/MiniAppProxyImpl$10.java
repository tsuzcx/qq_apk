package com.tencent.qqmini.proxyimpl;

import akgd;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppProxyImpl$10
  extends akgd
{
  MiniAppProxyImpl$10(MiniAppProxyImpl paramMiniAppProxyImpl, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, boolean paramBoolean5, boolean paramBoolean6, AsyncResult paramAsyncResult)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.val$isWgs84) && (paramSosoLbsInfo.c != 0.0D) && (paramSosoLbsInfo.d != 0.0D))
        {
          localJSONObject.put("latitude", paramSosoLbsInfo.c);
          localJSONObject.put("longitude", paramSosoLbsInfo.d);
        }
        for (;;)
        {
          localJSONObject.put("speed", paramSosoLbsInfo.jdField_b_of_type_Float);
          localJSONObject.put("accuracy", paramSosoLbsInfo.jdField_a_of_type_Float);
          if (this.val$needAltitude) {
            localJSONObject.put("altitude", paramSosoLbsInfo.e);
          }
          localJSONObject.put("verticalAccuracy", 0.0D);
          localJSONObject.put("horizontalAccuracy", paramSosoLbsInfo.jdField_a_of_type_Float);
          this.val$asyncResult.onReceiveResult(true, localJSONObject);
          return;
          localJSONObject.put("latitude", paramSosoLbsInfo.jdField_a_of_type_Double);
          localJSONObject.put("longitude", paramSosoLbsInfo.jdField_b_of_type_Double);
        }
        paramSosoLbsInfo = new JSONObject();
      }
      catch (JSONException paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppProxyImpl", 2, paramSosoLbsInfo, new Object[0]);
        }
        this.val$asyncResult.onReceiveResult(false, new JSONObject());
        return;
      }
    }
    try
    {
      paramSosoLbsInfo.put("errCode", paramInt);
      this.val$asyncResult.onReceiveResult(false, paramSosoLbsInfo);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MiniAppProxyImpl", 1, "getLocationJsonObject exception:", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.10
 * JD-Core Version:    0.7.0.1
 */