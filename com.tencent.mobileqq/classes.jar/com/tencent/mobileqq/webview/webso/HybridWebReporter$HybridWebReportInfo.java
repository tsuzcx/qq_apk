package com.tencent.mobileqq.webview.webso;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class HybridWebReporter$HybridWebReportInfo
{
  private AtomicInteger A = new AtomicInteger(0);
  public long a;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public int j;
  public String k = "";
  public boolean l;
  public int m;
  public boolean n = false;
  public boolean o;
  public int p;
  public int q;
  public int r = 0;
  public String s = "html";
  public long t = 0L;
  public String u = VasUtil.b().websoGetAPN();
  public String v = "QQ";
  public String w = VasUtil.b().websoGetQUA();
  public String x = "Android";
  public int y = -1;
  public boolean z = false;
  
  public void a()
  {
    this.r = 0;
    this.s = "html";
    this.t = 0L;
  }
  
  public JSONObject b()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", this.a);
        String str = this.b;
        if (!TextUtils.isEmpty(this.b))
        {
          int i2 = this.b.indexOf('?');
          i1 = i2;
          if (i2 < 0) {
            i1 = this.b.length();
          }
          str = this.b.substring(0, i1);
        }
        localJSONObject.put("url", this.b);
        localJSONObject.put("path", str);
        localJSONObject.put("errordomain", this.c);
        localJSONObject.put("errorcode", this.d);
        localJSONObject.put("httpstatus", this.e);
        localJSONObject.put("userip", this.f);
        localJSONObject.put("serverip", this.g);
        localJSONObject.put("port", this.h);
        localJSONObject.put("dnsresult", this.i);
        localJSONObject.put("apn", this.u);
        localJSONObject.put("timecost", this.j / 1000.0F);
        localJSONObject.put("app", this.v);
        localJSONObject.put("appversion", this.w);
        localJSONObject.put("platform", this.x);
        localJSONObject.put("sampling", this.y);
        localJSONObject.put("usewns", this.l);
        i1 = this.m;
        if ((i1 != 1000) && (i1 != 0))
        {
          i1 = this.m + 300000;
          localJSONObject.put("wnscode", i1);
          localJSONObject.put("detail", this.k);
          localJSONObject.put("usecache", this.n);
          localJSONObject.put("cachehasdata", this.o);
          localJSONObject.put("cacheupdatepolicy", this.p);
          localJSONObject.put("cacheupdatetimecost", this.q / 1000.0F);
          localJSONObject.put("serviceversion", this.r);
          localJSONObject.put("webso3_type", this.s);
          localJSONObject.put("datasize", this.t);
          return localJSONObject;
        }
      }
      catch (Exception localException)
      {
        QLog.e("HybridWebReporter", 1, localException, new Object[0]);
        return null;
      }
      int i1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HybridWebReporter.HybridWebReportInfo
 * JD-Core Version:    0.7.0.1
 */