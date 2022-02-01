package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppProxyImpl$13
  extends SosoInterfaceOnLocationListener
{
  MiniAppProxyImpl$13(MiniAppProxyImpl paramMiniAppProxyImpl, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, boolean paramBoolean5, boolean paramBoolean6, AsyncResult paramAsyncResult)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.jdField_a_of_type_Boolean) && (paramSosoLbsInfo.mLat84 != 0.0D) && (paramSosoLbsInfo.mLon84 != 0.0D))
        {
          localJSONObject.put("latitude", paramSosoLbsInfo.mLat84);
          localJSONObject.put("longitude", paramSosoLbsInfo.mLon84);
        }
        for (;;)
        {
          localJSONObject.put("speed", paramSosoLbsInfo.speed);
          localJSONObject.put("accuracy", paramSosoLbsInfo.accuracy);
          if (this.b) {
            localJSONObject.put("altitude", paramSosoLbsInfo.altitude);
          }
          localJSONObject.put("verticalAccuracy", 0.0D);
          localJSONObject.put("horizontalAccuracy", paramSosoLbsInfo.accuracy);
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(true, localJSONObject);
          return;
          localJSONObject.put("latitude", paramSosoLbsInfo.mLat02);
          localJSONObject.put("longitude", paramSosoLbsInfo.mLon02);
        }
        paramSosoLbsInfo = new JSONObject();
      }
      catch (JSONException paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppProxyImpl", 2, paramSosoLbsInfo, new Object[0]);
        }
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(false, new JSONObject());
        return;
      }
    }
    try
    {
      paramSosoLbsInfo.put("errCode", paramInt);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(false, paramSosoLbsInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.13
 * JD-Core Version:    0.7.0.1
 */