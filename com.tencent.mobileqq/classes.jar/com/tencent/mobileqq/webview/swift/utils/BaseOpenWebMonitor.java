package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;
import java.util.HashMap;

public class BaseOpenWebMonitor
{
  private static int a = 0;
  private static HashMap<String, String> b;
  private static ArrayMap<String, Long> c;
  private static String d = "";
  private static int e = -1;
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT > 10)
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("web_process_preload_file", 4);
      int i = localSharedPreferences.getInt("aio_preload_qweb_cout", 0);
      localSharedPreferences.edit().putInt("aio_preload_qweb_cout", i + 1).commit();
    }
  }
  
  public static void a(Intent paramIntent)
  {
    a += 1;
    if (paramIntent == null) {
      return;
    }
    if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
      return;
    }
    long l = paramIntent.getLongExtra("from_aio_time", -1L);
    Object localObject1 = b;
    if ((localObject1 != null) && (((HashMap)localObject1).size() <= 25)) {
      b.clear();
    } else {
      b = new HashMap();
    }
    localObject1 = c;
    if ((localObject1 != null) && (((ArrayMap)localObject1).size() <= 25)) {
      c.clear();
    } else {
      c = new ArrayMap();
    }
    int i = WebProcessReceiver.a;
    int j;
    if ((a == 1) && (i == 1)) {
      j = 1;
    } else {
      j = 0;
    }
    e = 1;
    localObject1 = b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramIntent.getIntExtra("from_aio", 1));
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("from", ((StringBuilder)localObject2).toString());
    localObject1 = b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramIntent.getIntExtra("from_aio_opt", 2));
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("use_optimization", ((StringBuilder)localObject2).toString());
    Object localObject3 = b;
    int k = a;
    localObject2 = "1";
    if (k == 1) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    ((HashMap)localObject3).put("first_open", localObject1);
    localObject1 = b;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(HttpUtil.getNetWorkType());
    ((StringBuilder)localObject3).append("");
    ((HashMap)localObject1).put("network_type", ((StringBuilder)localObject3).toString());
    localObject3 = b;
    if (i == 1) {
      localObject1 = localObject2;
    } else {
      localObject1 = "2";
    }
    ((HashMap)localObject3).put("has_pp", localObject1);
    if (i == 1) {
      i = 1;
    } else if ((!SwiftBrowserStatistics.aD) && (a <= 1)) {
      i = 3;
    } else {
      i = 2;
    }
    localObject1 = b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("ps_state", ((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(SystemClock.uptimeMillis() - l);
    ((StringBuilder)localObject1).append("");
    b(paramIntent, "click_to_activity", ((StringBuilder)localObject1).toString());
    b.put("open_finished", "2");
    c.put("web_finish", Long.valueOf(l));
    a(paramIntent, "click_to_activity", "activity_to_webview");
    paramIntent.removeExtra("from_aio");
    paramIntent.removeExtra("from_aio_time");
    paramIntent.removeExtra("from_aio_opt");
    if ((Build.VERSION.SDK_INT > 10) && (j != 0))
    {
      paramIntent = BaseApplication.getContext().getSharedPreferences("web_process_preload_file", 4);
      i = paramIntent.getInt("aio_hit_count", 0);
      paramIntent.edit().putInt("aio_hit_count", i + 1).commit();
    }
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("aio_open_web", true);
    paramIntent.putExtra("from_aio_opt", paramInt2);
    paramIntent.putExtra("from_aio", paramInt1);
    paramIntent.putExtra("from_aio_time", SystemClock.uptimeMillis());
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return;
    }
    if (e == 1)
    {
      if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
        return;
      }
      if ((!paramString.startsWith("http:")) && (!paramString.startsWith("https:"))) {
        return;
      }
      a(paramIntent, "activity_to_webview", null);
      c(paramIntent, paramString);
      e(paramIntent, paramString);
      a(paramIntent, null, "wb_c");
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {
      return;
    }
    if (e == 1)
    {
      if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
        return;
      }
      long l = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        paramIntent = (Long)c.remove(paramString1);
        if (paramIntent != null)
        {
          HashMap localHashMap = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(l - paramIntent.longValue());
          localStringBuilder.append("");
          localHashMap.put(paramString1, localStringBuilder.toString());
        }
      }
      if (paramString2 != null) {
        c.put(paramString2, Long.valueOf(l));
      }
    }
  }
  
  public static final boolean a(String paramString)
  {
    return (paramString.startsWith("https://url.cn/")) || (paramString.startsWith("http%3A%2F%2Furl.cn%2F"));
  }
  
  public static void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (e == 1)
    {
      if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
        return;
      }
      a(paramIntent, "wb_c", null);
      a(paramIntent, "web_finish", null);
      if (e == 1)
      {
        e = 2;
        b.put("open_finished", "1");
      }
    }
  }
  
  public static void b(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return;
    }
    if (e == 1)
    {
      if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
        return;
      }
      d(paramIntent, paramString);
      f(paramIntent, paramString);
    }
  }
  
  public static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {
      return;
    }
    if (e == 1)
    {
      if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
        return;
      }
      b.put(paramString1, paramString2);
    }
  }
  
  public static void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
      return;
    }
    Object localObject = b;
    if (localObject == null) {
      return;
    }
    localObject = (String)((HashMap)localObject).get("open_finished");
    if ((localObject != null) && (((String)localObject).equals("2"))) {
      a(paramIntent, "web_finish", null);
    }
  }
  
  private static void c(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      if (paramString == null) {
        return;
      }
      if ((paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")))
      {
        d = paramString;
        a(paramIntent, null, "safe_check");
      }
    }
  }
  
  public static void d(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!paramIntent.getBooleanExtra("aio_open_web", false)) {
      return;
    }
    paramIntent.removeExtra("aio_open_web");
    paramIntent = b;
    Object localObject;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty((CharSequence)paramIntent.get("from"))) {
        return;
      }
      localObject = (String)b.get("safe_check");
      paramIntent = (String)b.get("short_link");
    }
    try
    {
      l1 = Long.parseLong((String)localObject);
    }
    catch (Exception localException)
    {
      long l1;
      label82:
      break label82;
    }
    l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramIntent);
    }
    catch (Exception paramIntent)
    {
      long l2;
      label93:
      int i;
      int j;
      StringBuilder localStringBuilder;
      break label93;
    }
    l2 = 0L;
    if (l1 == 0L) {
      b.put("has_safecheck", "2");
    } else {
      b.put("has_safecheck", "1");
    }
    if (l2 == 0L) {
      b.put("has_short_link", "2");
    } else {
      b.put("has_short_link", "1");
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOWeb", false, 0L, 0L, b, "", false);
    e = -1;
    if (Build.VERSION.SDK_INT > 10)
    {
      paramIntent = BaseApplication.getContext().getSharedPreferences("web_process_preload_file", 4);
      l1 = paramIntent.getLong("aio_preload_qweb_last", 0L);
      l2 = System.currentTimeMillis();
      if (l1 == 0L)
      {
        paramIntent.edit().putLong("aio_preload_qweb_last", l2).commit();
      }
      else if (l2 - l1 > 86400000L)
      {
        i = paramIntent.getInt("aio_preload_qweb_cout", 0);
        j = paramIntent.getInt("aio_hit_count", 0);
        localObject = new HashMap();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("");
        ((HashMap)localObject).put("hit_count", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ((HashMap)localObject).put("preload_count", localStringBuilder.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOWebPreloadhit", false, 0L, 0L, (HashMap)localObject, "", false);
        paramIntent.edit().putInt("aio_preload_qweb_cout", 0).putLong("aio_preload_qweb_last", l2).putInt("aio_hit_count", 0).commit();
      }
    }
    b.clear();
    c.clear();
  }
  
  private static void d(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      if (paramString == null) {
        return;
      }
      String str = d;
      if ((str != null) && (str.contains(URLEncoder.encode(paramString)))) {
        a(paramIntent, "safe_check", null);
      }
      d = "";
    }
  }
  
  private static void e(Intent paramIntent, String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (a(paramString)) {
      a(paramIntent, null, "short_link");
    }
  }
  
  private static void f(Intent paramIntent, String paramString)
  {
    if (paramString == null) {
      return;
    }
    if ((paramString.startsWith("http:")) || (paramString.startsWith("https:"))) {
      a(paramIntent, "short_link", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor
 * JD-Core Version:    0.7.0.1
 */