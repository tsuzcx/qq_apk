package com.tencent.qqperf.tools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class DeviceInfoUtils$1
  implements Runnable
{
  DeviceInfoUtils$1(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    DeviceInfoUtils.a(System.currentTimeMillis());
    this.a.edit().putLong("device_perf_level_timestamps", DeviceInfoUtils.a()).apply();
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("pid", "1");
      ((JSONObject)localObject1).put("device", URLEncoder.encode(Build.MODEL, "UTF-8"));
      ((JSONObject)localObject1).put("version", "1.0.0");
      ((JSONObject)localObject1).put("uin", QQDeviceInfo.getIMEI("a4bd32"));
      ((JSONObject)localObject1).put("userSwitch", "0");
      ((JSONObject)localObject1).put("lastSwitch", "0");
      if (QLog.isColorLevel())
      {
        QLog.e("DeviceInfoUtils", 1, "perf level sendRequest");
        QLog.e("DeviceInfoUtils", 1, ((JSONObject)localObject1).toString());
      }
      Object localObject2 = new Request.Builder().url("https://ten.sngapm.qq.com/appconfig/v4/config/14199/");
      Object localObject4 = ((JSONObject)localObject1).toString();
      localObject1 = null;
      localObject2 = ((Request.Builder)localObject2).post(RequestBody.create(null, (String)localObject4)).build();
      localObject4 = new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
      try
      {
        localObject2 = ((OkHttpClient)localObject4).newCall((Request)localObject2).execute();
        localObject1 = localObject2;
        if (((Response)localObject2).code() == 200)
        {
          localObject1 = localObject2;
          localObject4 = new JSONObject(((Response)localObject2).body().string());
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject2;
            QLog.e("DeviceInfoUtils", 1, ((JSONObject)localObject4).toString());
          }
          localObject1 = localObject2;
          int i = ((JSONObject)localObject4).getInt("deviceLevel");
          if (i != 0)
          {
            localObject1 = localObject2;
            this.a.edit().putInt("device_perf_level", i).apply();
            localObject1 = localObject2;
            DeviceInfoUtils.a(i);
          }
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((Response)localObject1).close();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceInfoUtils", 2, localThrowable.toString());
      }
      DeviceInfoUtils.a().set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.tools.DeviceInfoUtils.1
 * JD-Core Version:    0.7.0.1
 */