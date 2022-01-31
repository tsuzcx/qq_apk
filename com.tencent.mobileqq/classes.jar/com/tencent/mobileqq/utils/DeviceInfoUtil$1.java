package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import babp;
import befc;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class DeviceInfoUtil$1
  implements Runnable
{
  public DeviceInfoUtil$1(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    babp.a(System.currentTimeMillis());
    this.a.edit().putLong("device_perf_level_timestamps", babp.n()).apply();
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("pid", "1");
      ((JSONObject)localObject).put("device", URLEncoder.encode(Build.MODEL, "UTF-8"));
      ((JSONObject)localObject).put("version", "1.0.0");
      ((JSONObject)localObject).put("uin", befc.a("a4bd32"));
      ((JSONObject)localObject).put("userSwitch", "0");
      ((JSONObject)localObject).put("lastSwitch", "0");
      if (QLog.isColorLevel())
      {
        QLog.e("DeviceInfoUtil", 1, "perf level sendRequest");
        QLog.e("DeviceInfoUtil", 1, ((JSONObject)localObject).toString());
      }
      localObject = new Request.Builder().url("https://ten.sngapm.qq.com/appconfig/v4/config/14199/").post(RequestBody.create(null, ((JSONObject)localObject).toString())).build();
      OkHttpClient localOkHttpClient = new OkHttpClient();
      localOkHttpClient.setConnectTimeout(5L, TimeUnit.SECONDS);
      localOkHttpClient.setReadTimeout(5L, TimeUnit.SECONDS);
      localObject = localOkHttpClient.newCall((Request)localObject).execute();
      if (((Response)localObject).code() == 200)
      {
        localObject = new JSONObject(((Response)localObject).body().string());
        if (QLog.isColorLevel()) {
          QLog.e("DeviceInfoUtil", 1, ((JSONObject)localObject).toString());
        }
        int i = ((JSONObject)localObject).getInt("deviceLevel");
        if (i != 0)
        {
          this.a.edit().putInt("device_perf_level", i).apply();
          babp.a(i);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceInfoUtil", 2, localThrowable.toString());
        }
      }
    }
    babp.a().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DeviceInfoUtil.1
 * JD-Core Version:    0.7.0.1
 */