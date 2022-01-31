package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class a
{
  private static a g = null;
  private List<String> a = null;
  private volatile int b = 2;
  private volatile String c = "";
  private volatile HttpHost d = null;
  private e e = null;
  private int f = 0;
  private Context h = null;
  private StatLogger i = null;
  
  private a(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    this.e = new e();
    i.a(paramContext);
    this.i = l.b();
    l();
    i();
    g();
  }
  
  public static a a(Context paramContext)
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new a(paramContext);
      }
      return g;
    }
    finally {}
  }
  
  private boolean b(String paramString)
  {
    return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(paramString).matches();
  }
  
  private void i()
  {
    this.a = new ArrayList(10);
    this.a.add("117.135.169.101");
    this.a.add("140.207.54.125");
    this.a.add("180.153.8.53");
    this.a.add("120.198.203.175");
    this.a.add("14.17.43.18");
    this.a.add("163.177.71.186");
    this.a.add("111.30.131.31");
    this.a.add("123.126.121.167");
    this.a.add("123.151.152.111");
    this.a.add("113.142.45.79");
    this.a.add("123.138.162.90");
    this.a.add("103.7.30.94");
  }
  
  private String j()
  {
    try
    {
      if (!b("pingma.qq.com"))
      {
        String str = InetAddress.getByName("pingma.qq.com").getHostAddress();
        return str;
      }
    }
    catch (Exception localException)
    {
      this.i.e(localException);
    }
    return "";
  }
  
  private void k()
  {
    String str1 = j();
    if (StatConfig.isDebugEnable()) {
      this.i.i("remoteIp ip is " + str1);
    }
    Object localObject;
    if (l.c(str1))
    {
      if (!this.a.contains(str1)) {
        break label81;
      }
      localObject = str1;
    }
    for (;;)
    {
      StatConfig.setStatReportUrl("http://" + (String)localObject + ":80/mstat/report");
      return;
      label81:
      String str2 = (String)this.a.get(this.f);
      localObject = str2;
      if (StatConfig.isDebugEnable())
      {
        this.i.w(str1 + " not in ip list, change to:" + str2);
        localObject = str2;
      }
    }
  }
  
  private void l()
  {
    this.b = 0;
    this.d = null;
    this.c = null;
  }
  
  public HttpHost a()
  {
    return this.d;
  }
  
  public void a(String paramString)
  {
    if (StatConfig.isDebugEnable()) {
      this.i.i("updateIpList " + paramString);
    }
    try
    {
      if (l.c(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString.length() > 0)
        {
          Iterator localIterator = paramString.keys();
          while (localIterator.hasNext())
          {
            Object localObject1 = paramString.getString((String)localIterator.next());
            if (l.c((String)localObject1))
            {
              localObject1 = ((String)localObject1).split(";");
              int k = localObject1.length;
              int j = 0;
              while (j < k)
              {
                Object localObject2 = localObject1[j];
                if (l.c((String)localObject2))
                {
                  localObject2 = ((String)localObject2).split(":");
                  if (localObject2.length > 1)
                  {
                    localObject2 = localObject2[0];
                    if ((b((String)localObject2)) && (!this.a.contains(localObject2)))
                    {
                      if (StatConfig.isDebugEnable()) {
                        this.i.i("add new ip:" + (String)localObject2);
                      }
                      this.a.add(localObject2);
                    }
                  }
                }
                j += 1;
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      this.i.e(paramString);
      this.f = new Random().nextInt(this.a.size());
    }
  }
  
  public String b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void d()
  {
    this.f = ((this.f + 1) % this.a.size());
  }
  
  public boolean e()
  {
    return this.b == 1;
  }
  
  public boolean f()
  {
    return this.b != 0;
  }
  
  void g()
  {
    if (r.f(this.h))
    {
      if (StatConfig.g) {
        k();
      }
      this.c = l.j(this.h);
      if (StatConfig.isDebugEnable()) {
        this.i.i("NETWORK name:" + this.c);
      }
      if (l.c(this.c)) {
        if (!"WIFI".equalsIgnoreCase(this.c)) {
          break label117;
        }
      }
      label117:
      for (this.b = 1;; this.b = 2)
      {
        this.d = l.a(this.h);
        if (StatServiceImpl.a()) {
          StatServiceImpl.d(this.h);
        }
        return;
      }
    }
    if (StatConfig.isDebugEnable()) {
      this.i.i("NETWORK TYPE: network is close.");
    }
    l();
  }
  
  public void h()
  {
    this.h.getApplicationContext().registerReceiver(new b(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.a
 * JD-Core Version:    0.7.0.1
 */