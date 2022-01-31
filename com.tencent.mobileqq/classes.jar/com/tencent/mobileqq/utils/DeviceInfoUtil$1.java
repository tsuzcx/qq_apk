package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import bdgk;
import bhsp;
import com.tencent.qphone.base.util.QLog;
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

public final class DeviceInfoUtil$1
  implements Runnable
{
  public DeviceInfoUtil$1(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    Object localObject1 = null;
    bdgk.a(System.currentTimeMillis());
    this.a.edit().putLong("device_perf_level_timestamps", bdgk.n()).apply();
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("pid", "1");
        ((JSONObject)localObject2).put("device", URLEncoder.encode(Build.MODEL, "UTF-8"));
        ((JSONObject)localObject2).put("version", "1.0.0");
        ((JSONObject)localObject2).put("uin", bhsp.a("a4bd32"));
        ((JSONObject)localObject2).put("userSwitch", "0");
        ((JSONObject)localObject2).put("lastSwitch", "0");
        if (QLog.isColorLevel())
        {
          QLog.e("DeviceInfoUtil", 1, "perf level sendRequest");
          QLog.e("DeviceInfoUtil", 1, ((JSONObject)localObject2).toString());
        }
        localObject2 = new Request.Builder().url("https://ten.sngapm.qq.com/appconfig/v4/config/14199/").post(RequestBody.create(null, ((JSONObject)localObject2).toString())).build();
        localObject4 = new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        Object localObject4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DeviceInfoUtil", 2, localThrowable.toString());
        continue;
      }
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
            QLog.e("DeviceInfoUtil", 1, ((JSONObject)localObject4).toString());
          }
          localObject1 = localObject2;
          int i = ((JSONObject)localObject4).getInt("deviceLevel");
          if (i != 0)
          {
            localObject1 = localObject2;
            this.a.edit().putInt("device_perf_level", i).apply();
            localObject1 = localObject2;
            bdgk.a(i);
          }
        }
        if (localObject2 != null) {
          ((Response)localObject2).close();
        }
        bdgk.a().set(false);
        return;
      }
      finally
      {
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DeviceInfoUtil.1
 * JD-Core Version:    0.7.0.1
 */