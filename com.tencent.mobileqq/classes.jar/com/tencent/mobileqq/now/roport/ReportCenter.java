package com.tencent.mobileqq.now.roport;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.now.netchannel.okhttp.OkHttpClientFactory;
import com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONArray;

public class ReportCenter
{
  public static ReportCenter a = new ReportCenter();
  private BaseApplication b = BaseApplicationImpl.getContext();
  private String c = DeviceInfoUtil.e();
  private String d = String.valueOf(DeviceInfoUtil.a(this.b));
  private String e = DeviceInfoUtil.b();
  private String f;
  private String g;
  private String h = Build.MODEL;
  private int i = 0;
  private Callback j = new ReportCenter.1(this);
  
  private ReportCenter()
  {
    if (this.h == null) {
      this.h = "unknown";
    }
    this.g = Build.VERSION.RELEASE;
    if (this.g == null) {
      this.g = "unknown";
    }
    this.f = Build.MANUFACTURER;
    if (this.f == null) {
      this.f = "unknown";
    }
  }
  
  private static int a(Context paramContext)
  {
    int k = NetworkUtil.getNetworkType(paramContext);
    if (k == 1) {
      return 2;
    }
    if (k == 2) {
      return 3;
    }
    if (k == 3) {
      return 4;
    }
    return 1;
  }
  
  private void b(Bundle paramBundle)
  {
    Headers localHeaders = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "https://now.qq.com/").build();
    paramBundle = RequestBody.create(MediaType.get("application/x-www-form-urlencoded"), c(paramBundle));
    paramBundle = new Request.Builder().url("https://now.qq.com/cgi-bin/now/web/tdw/report").headers(localHeaders).post(paramBundle).build();
    OkHttpClientFactory.a().newCall(paramBundle).enqueue(this.j);
  }
  
  private String c(Bundle paramBundle)
  {
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    Iterator localIterator = paramBundle.keySet().iterator();
    String str1 = "personal_live_base";
    Object localObject;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      localObject = "";
      if (!bool) {
        break;
      }
      String str2 = (String)localIterator.next();
      if ("tid".equals(str2))
      {
        str1 = paramBundle.getString(str2);
      }
      else if (!"bid".equals(str2))
      {
        localJSONArray1.put(str2);
        if (!StringUtil.isEmpty(paramBundle.getString(str2))) {
          localObject = paramBundle.getString(str2);
        }
        localJSONArray2.put(localObject);
      }
    }
    paramBundle = new JSONArray();
    paramBundle.put(localJSONArray2);
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&table=");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("&fields=");
      ((StringBuilder)localObject).append(URLEncoder.encode(localJSONArray1.toString(), "UTF-8"));
      ((StringBuilder)localObject).append("&datas=");
      ((StringBuilder)localObject).append(URLEncoder.encode(paramBundle.toString(), "UTF-8"));
      paramBundle = ((StringBuilder)localObject).toString();
      return paramBundle;
    }
    catch (UnsupportedEncodingException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return "";
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", String.valueOf(16130));
    localBundle.putString("installsrc", String.valueOf(16130));
    localBundle.putString("platform", "Android");
    localBundle.putString("opername", "now_jiehe");
    localBundle.putString("uin_type", "0");
    localBundle.putString("uin", String.valueOf(UserInfoMgr.e()));
    localBundle.putString("rom", this.f);
    localBundle.putString("deviceID", this.e);
    localBundle.putString("osversion", this.g);
    localBundle.putString("clientVersion", this.d);
    localBundle.putString("qqversion", this.c);
    localBundle.putString("timestr", String.valueOf(System.currentTimeMillis() / 1000L));
    localBundle.putString("networktype", String.valueOf(a(this.b)));
    try
    {
      str = DeviceInfoUtil.b();
    }
    catch (Exception localException)
    {
      String str;
      label172:
      break label172;
    }
    QLog.i("ReportCenter", 4, "no phone permission");
    str = "";
    localBundle.putString("imei", str);
    return localBundle;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.d("ReportCenter", 4, "send(): no data to report");
      return;
    }
    b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.roport.ReportCenter
 * JD-Core Version:    0.7.0.1
 */