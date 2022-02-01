package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.nearby.report.IOkHttpClientFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyCGIReporter
{
  private Callback a = new NearbyCGIReporter.1(this);
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      paramJSONObject.put("platform", "Android");
      paramJSONObject.put("version", DeviceInfoUtil.c());
      SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
      if ((!paramJSONObject.has("latitude")) && (localSosoLbsInfo != null)) {
        paramJSONObject.put("latitude", String.valueOf(localSosoLbsInfo.mLocation.mLat02));
      }
      if ((!paramJSONObject.has("longitude")) && (localSosoLbsInfo != null)) {
        paramJSONObject.put("longitude", String.valueOf(localSosoLbsInfo.mLocation.mLon02));
      }
      ((JSONObject)localObject).put("bid_type", "1");
      ((JSONObject)localObject).put("table_name", "nearby_report");
      ((JSONObject)localObject).put("fields_json", paramJSONObject.toString());
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("report: ");
    paramJSONObject.append(((JSONObject)localObject).toString());
    QLog.i("NearbyCGIReporter", 2, paramJSONObject.toString());
    paramJSONObject = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "").build();
    localObject = RequestBody.create(MediaType.parse("application/json"), ((JSONObject)localObject).toString());
    paramJSONObject = new Request.Builder().url("https://ias.nearby.qq.com/cgi-bin/nearby/report").headers(paramJSONObject).post((RequestBody)localObject).build();
    ((IOkHttpClientFactory)QRoute.api(IOkHttpClientFactory.class)).getRequestClient().newCall(paramJSONObject).enqueue(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyCGIReporter
 * JD-Core Version:    0.7.0.1
 */