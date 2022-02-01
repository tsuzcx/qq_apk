package com.tencent.mobileqq.newnearby.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.report.IOkHttpClientFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyCGIReporterImpl$2
  implements Runnable
{
  NearbyCGIReporterImpl$2(NearbyCGIReporterImpl paramNearbyCGIReporterImpl, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = new JSONObject();
    try
    {
      this.a.put("platform", "Android");
      this.a.put("version", DeviceInfoUtil.e());
      Object localObject2 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
      if ((!this.a.has("latitude")) && (localObject2 != null)) {
        this.a.put("latitude", String.valueOf(((SosoLbsInfo)localObject2).mLocation.mLat02));
      }
      if ((!this.a.has("longitude")) && (localObject2 != null)) {
        this.a.put("longitude", String.valueOf(((SosoLbsInfo)localObject2).mLocation.mLon02));
      }
      localObject2 = HippyUtils.getAppInterface();
      if ((localObject2 != null) && (((AppInterface)localObject2).isLogin()))
      {
        localObject2 = ((AppInterface)localObject2).getCurrentAccountUin();
        int i = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue((String)localObject2, "self_gender", Integer.valueOf(-1))).intValue();
        int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue((String)localObject2, "self_age", Integer.valueOf(-1))).intValue();
        this.a.put("d2", String.valueOf(i - 1));
        this.a.put("d3", String.valueOf(j));
      }
      ((JSONObject)localObject1).put("bid_type", "1");
      ((JSONObject)localObject1).put("table_name", "nearby_report");
      ((JSONObject)localObject1).put("fields_json", this.a.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("report: ");
    ((StringBuilder)localObject3).append(((JSONObject)localObject1).toString());
    QLog.i("NearbyCGIReporter", 2, ((StringBuilder)localObject3).toString());
    localObject3 = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "").build();
    localObject1 = RequestBody.create(MediaType.parse("application/json"), ((JSONObject)localObject1).toString());
    localObject1 = new Request.Builder().url("https://ias.nearby.qq.com/cgi-bin/nearby/report").headers((Headers)localObject3).post((RequestBody)localObject1).build();
    ((IOkHttpClientFactory)QRoute.api(IOkHttpClientFactory.class)).getRequestClient().newCall((Request)localObject1).enqueue(NearbyCGIReporterImpl.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyCGIReporterImpl.2
 * JD-Core Version:    0.7.0.1
 */