package com.tencent.mobileqq.qqgamepub.web;

import android.os.SystemClock;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GameWebCostLogic
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public boolean p;
  public long q;
  boolean r = false;
  private long s;
  
  private String m()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("GamePub H5 pref data=");
    localStringBuffer.append("{");
    localStringBuffer.append("isColdBoot=");
    localStringBuffer.append(this.p);
    localStringBuffer.append("showWebViewTime=");
    localStringBuffer.append(this.n);
    localStringBuffer.append("|");
    localStringBuffer.append("initWebViewTime=");
    localStringBuffer.append(this.j);
    localStringBuffer.append("|");
    localStringBuffer.append("webViewLoadTime=");
    localStringBuffer.append(this.o);
    localStringBuffer.append("|");
    localStringBuffer.append("initUiTime=");
    localStringBuffer.append(this.i);
    localStringBuffer.append("|");
    localStringBuffer.append("loadUrlTime=");
    localStringBuffer.append(this.k);
    localStringBuffer.append("|");
    localStringBuffer.append("parsePageTime=");
    localStringBuffer.append(this.l);
    localStringBuffer.append("|");
    localStringBuffer.append("enterQQGamePubTime=");
    localStringBuffer.append(this.m);
    localStringBuffer.append("|");
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    this.h = SystemClock.elapsedRealtime();
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.p = paramBoolean;
    this.m = paramLong3;
  }
  
  public void b()
  {
    this.c = SystemClock.elapsedRealtime();
    this.d = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.e = SystemClock.elapsedRealtime();
  }
  
  public void d()
  {
    this.g = SystemClock.elapsedRealtime();
    this.f = System.currentTimeMillis();
  }
  
  public void e()
  {
    this.q = (SystemClock.elapsedRealtime() - this.h);
  }
  
  public void f()
  {
    this.i = (SystemClock.elapsedRealtime() - this.h);
  }
  
  public void g()
  {
    this.s = SystemClock.elapsedRealtime();
  }
  
  public void h()
  {
    this.j = (SystemClock.elapsedRealtime() - this.s);
  }
  
  public void i()
  {
    if (this.h < 0L) {
      return;
    }
    long l1 = (SystemClock.elapsedRealtime() - this.h) / 1000L;
    if (l1 > 0L)
    {
      WadlReportBuilder localWadlReportBuilder = GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76916").c("206471");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      localWadlReportBuilder.a(17, localStringBuilder.toString()).a();
    }
  }
  
  public void j()
  {
    if (!this.r)
    {
      this.r = true;
      long l1 = this.e;
      this.k = (l1 - this.c);
      long l2 = this.g;
      this.l = (l2 - l1);
      this.n = (l2 - this.h + this.m);
      this.o = (this.k + this.l);
      if (QLog.isColorLevel()) {
        QLog.d("GameWebPrefTrace", 1, m());
      }
      k();
    }
  }
  
  public void k()
  {
    WadlReportBuilder localWadlReportBuilder = GamePubAccountHelper.c("1");
    localWadlReportBuilder.d("76918").c("206612").a(29, String.valueOf(this.p)).a(30, String.valueOf(this.n)).a(31, String.valueOf(this.j)).a(32, String.valueOf(this.o)).a(33, String.valueOf(this.i)).a(34, String.valueOf(this.l)).a(36, String.valueOf(this.m)).a(37, String.valueOf(this.q));
    localWadlReportBuilder.a();
  }
  
  public String l()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("clickTime", this.b);
      ((JSONObject)localObject).put("initPageTime", this.i);
      ((JSONObject)localObject).put("showWebViewTime", this.j + this.o);
      ((JSONObject)localObject).put("initWebViewTime", this.j);
      ((JSONObject)localObject).put("loadRequestStart", this.d);
      ((JSONObject)localObject).put("finishLoadEnd", this.f);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.GameWebCostLogic
 * JD-Core Version:    0.7.0.1
 */