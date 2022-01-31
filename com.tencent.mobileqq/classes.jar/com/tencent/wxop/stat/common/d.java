package com.tencent.wxop.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.au;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

class d
{
  String a;
  String b = "2.0.4";
  DisplayMetrics c;
  int d = Build.VERSION.SDK_INT;
  String e = Build.MODEL;
  String f = Build.MANUFACTURER;
  String g = Locale.getDefault().getLanguage();
  String h;
  String i;
  String j;
  String k;
  int l = 0;
  String m = null;
  String n = null;
  Context o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  
  private d(Context paramContext)
  {
    this.o = paramContext.getApplicationContext();
    this.c = l.d(this.o);
    this.a = l.h(this.o);
    this.h = StatConfig.getInstallChannel(this.o);
    this.i = l.g(this.o);
    this.j = TimeZone.getDefault().getID();
    this.l = l.m(this.o);
    this.k = l.n(this.o);
    this.m = this.o.getPackageName();
    if (this.d >= 14) {
      this.p = l.t(this.o);
    }
    this.q = l.s(this.o).toString();
    this.r = l.r(this.o);
    this.s = l.d();
    this.n = l.A(this.o);
  }
  
  void a(JSONObject paramJSONObject, Thread paramThread)
  {
    if (paramThread == null)
    {
      if (this.c != null)
      {
        paramJSONObject.put("sr", this.c.widthPixels + "*" + this.c.heightPixels);
        paramJSONObject.put("dpi", this.c.xdpi + "*" + this.c.ydpi);
      }
      if (com.tencent.wxop.stat.a.a(this.o).e())
      {
        paramThread = new JSONObject();
        r.a(paramThread, "bs", r.d(this.o));
        r.a(paramThread, "ss", r.e(this.o));
        if (paramThread.length() > 0) {
          r.a(paramJSONObject, "wf", paramThread.toString());
        }
      }
      paramThread = r.a(this.o, 10);
      if ((paramThread != null) && (paramThread.length() > 0)) {
        r.a(paramJSONObject, "wflist", paramThread.toString());
      }
      r.a(paramJSONObject, "sen", this.p);
    }
    for (;;)
    {
      r.a(paramJSONObject, "pcn", l.o(this.o));
      r.a(paramJSONObject, "osn", Build.VERSION.RELEASE);
      r.a(paramJSONObject, "av", this.a);
      r.a(paramJSONObject, "ch", this.h);
      r.a(paramJSONObject, "mf", this.f);
      r.a(paramJSONObject, "sv", this.b);
      r.a(paramJSONObject, "osd", Build.DISPLAY);
      r.a(paramJSONObject, "prod", Build.PRODUCT);
      r.a(paramJSONObject, "tags", Build.TAGS);
      r.a(paramJSONObject, "id", Build.ID);
      r.a(paramJSONObject, "fng", Build.FINGERPRINT);
      r.a(paramJSONObject, "lch", this.n);
      r.a(paramJSONObject, "ov", Integer.toString(this.d));
      paramJSONObject.put("os", 1);
      r.a(paramJSONObject, "op", this.i);
      r.a(paramJSONObject, "lg", this.g);
      r.a(paramJSONObject, "md", this.e);
      r.a(paramJSONObject, "tz", this.j);
      if (this.l != 0) {
        paramJSONObject.put("jb", this.l);
      }
      r.a(paramJSONObject, "sd", this.k);
      r.a(paramJSONObject, "apn", this.m);
      r.a(paramJSONObject, "cpu", this.q);
      r.a(paramJSONObject, "abi", Build.CPU_ABI);
      r.a(paramJSONObject, "abi2", Build.CPU_ABI2);
      r.a(paramJSONObject, "ram", this.r);
      r.a(paramJSONObject, "rom", this.s);
      return;
      r.a(paramJSONObject, "thn", paramThread.getName());
      r.a(paramJSONObject, "qq", StatConfig.getQQ(this.o));
      r.a(paramJSONObject, "cui", StatConfig.getCustomUserId(this.o));
      if ((l.c(this.r)) && (this.r.split("/").length == 2)) {
        r.a(paramJSONObject, "fram", this.r.split("/")[0]);
      }
      if ((l.c(this.s)) && (this.s.split("/").length == 2)) {
        r.a(paramJSONObject, "from", this.s.split("/")[0]);
      }
      if (au.a(this.o).b(this.o) != null) {
        paramJSONObject.put("ui", au.a(this.o).b(this.o).b());
      }
      r.a(paramJSONObject, "mid", StatConfig.getLocalMidOnly(this.o));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.d
 * JD-Core Version:    0.7.0.1
 */