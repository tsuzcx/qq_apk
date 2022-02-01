package com.tencent.mobileqq.intervideo.now;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

public class NowDataReporter
{
  public static long d;
  public static long e;
  HashMap<Long, JSONObject> A = new HashMap();
  String a;
  String b;
  String c;
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  protected String l = "";
  protected String m = "";
  protected int n = 0;
  protected int o = 0;
  protected int p = 0;
  protected int q;
  protected String r;
  protected String s = Build.VERSION.RELEASE;
  protected String t = Build.MODEL;
  protected String u;
  protected int v = 2;
  protected int w;
  protected boolean x = false;
  protected boolean y = false;
  String z;
  
  public NowDataReporter(QQAppInterface paramQQAppInterface)
  {
    a("now_plugin");
  }
  
  private void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean2)
  {
    if (paramLong == 0L) {
      return;
    }
    JSONObject localJSONObject;
    if (!this.A.containsKey(Long.valueOf(paramLong)))
    {
      localJSONObject = new JSONObject();
      this.A.put(Long.valueOf(paramLong), localJSONObject);
    }
    else
    {
      localJSONObject = (JSONObject)this.A.get(Long.valueOf(paramLong));
    }
    try
    {
      if (!localJSONObject.optBoolean("noneedadd"))
      {
        localJSONObject.put("opname", paramString4);
        localJSONObject.put("roomid", paramString2);
        localJSONObject.put("roomtype", paramString3);
        localJSONObject.put("source", paramString1);
        localJSONObject.put("d1", paramString5);
        localJSONObject.put("d2", paramString6);
        localJSONObject.put("d3", paramString7);
        localJSONObject.put("d4", paramString8);
        localJSONObject.put("op_in", paramInt1);
        localJSONObject.put("op_result", paramInt2);
        localJSONObject.put("noneedadd", paramBoolean1);
        localJSONObject.put("timelong", paramString9);
      }
      else
      {
        QLog.i("NowDataReporter", 1, "本次opname不影响上报");
      }
      this.A.put(Long.valueOf(paramLong), localJSONObject);
      if (paramBoolean2)
      {
        a(paramLong);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void c()
  {
    d = 0L;
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = "";
    this.m = "";
    this.n = 11;
    this.q = 0;
    this.r = "";
    this.w = 0;
  }
  
  public NowDataReporter a(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public void a()
  {
    try
    {
      localNowDataReporter = b("show_loading");
      if (!this.x) {
        break label99;
      }
      str1 = "1";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        NowDataReporter localNowDataReporter;
        String str1;
        label45:
        continue;
        label99:
        String str2 = "0";
      }
    }
    localNowDataReporter.c(str1).b();
    break label45;
    if (QLog.isColorLevel()) {
      QLog.d("NowDataReporter", 2, "reportJumpPlugin Exception");
    }
    a(d, this.a, this.b, this.c, "show_loading", false, this.w, this.q, this.j, this.k, this.l, this.m, "", false);
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    try
    {
      b("get_record_res").c(String.valueOf(paramInt1)).d(paramString).e(String.valueOf(paramInt2)).i(String.valueOf(paramLong)).b();
      return;
    }
    catch (Exception paramString)
    {
      label36:
      break label36;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NowDataReporter", 2, "reportRecordCgi Exception");
    }
  }
  
  public void a(long paramLong)
  {
    JSONObject localJSONObject = (JSONObject)this.A.get(Long.valueOf(paramLong));
    if ((localJSONObject != null) && (localJSONObject.has("opname")))
    {
      a("last_op_name", localJSONObject);
      this.A.remove(Long.valueOf(paramLong));
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    try
    {
      this.h = paramBundle.getString("op_name");
      if (TextUtils.isEmpty(this.h)) {
        return;
      }
      this.w = paramBundle.getInt("op_in");
      this.q = paramBundle.getInt("op_result");
      this.r = paramBundle.getString("timeconsume");
      String str = paramBundle.getString("sdkversion");
      bool1 = TextUtils.isEmpty(str);
      if ((!bool1) && (!str.equals("0"))) {
        this.z = paramBundle.getString("sdkversion");
      }
      this.j = paramBundle.getString("d1");
      this.k = paramBundle.getString("d2");
      this.l = paramBundle.getString("d3");
      this.m = paramBundle.getString("d4");
      if (this.h.equals("enter_shadow"))
      {
        this.o = Integer.parseInt(paramBundle.getString("status1", "0"));
        this.n = paramBundle.getInt("frameVersion");
      }
      b();
      if ((this.h.equals("check_version_complete")) && (this.l.equals("1")))
      {
        this.x = false;
        this.o = 0;
      }
      if (!this.A.containsKey(Long.valueOf(d))) {
        return;
      }
      bool1 = this.h.equals("cancel_run");
      if ((bool1) || (this.h.equals("cancel_in_plugin")) || (this.h.equals("download_fail")) || (this.h.equals("boot_fail")) || (this.h.equals("login_fail")) || (this.h.equals("enter_fail")) || (this.h.equals("user_cancel_in_plugin")) || (this.h.equals("enter_room")) || (this.h.equals("jump_h5"))) {
        break label728;
      }
      if (!this.h.equals("jump_app")) {
        break label719;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        boolean bool5;
        boolean bool4;
        boolean bool2;
        int i1;
        continue;
        boolean bool1 = false;
        boolean bool3 = false;
        continue;
        bool1 = true;
        bool3 = true;
        continue;
        bool1 = bool4;
        continue;
        int i2 = 1;
      }
    }
    bool5 = this.h.equals("download_biz_plugin");
    bool4 = bool1;
    bool2 = bool3;
    if (bool5)
    {
      bool4 = bool1;
      bool2 = bool3;
      if (this.j.equals("fail"))
      {
        bool4 = true;
        bool2 = true;
      }
    }
    if ((this.h.equals("unzip_biz_plugin")) && (this.j.equals("fail")))
    {
      bool1 = true;
      bool2 = true;
      bool3 = this.h.equals("download_start");
      if ((!bool3) || (!this.j.equals("2"))) {
        break label744;
      }
      i2 = 0;
      i1 = i2;
      if (this.h.equals("download_complete"))
      {
        i1 = i2;
        if (this.j.equals("2")) {
          i1 = 0;
        }
      }
      i2 = i1;
      if (this.h.equals("download_fail"))
      {
        i2 = i1;
        if (this.j.equals("2")) {
          i2 = 0;
        }
      }
      i1 = i2;
      if (this.h.equals("install_start"))
      {
        i1 = i2;
        if (this.w != 1) {
          i1 = 0;
        }
      }
      i2 = i1;
      if (this.h.equals("install_complete"))
      {
        i2 = i1;
        if (this.w != 1) {
          i2 = 0;
        }
      }
      i1 = i2;
      if (this.h.equals("install_fail"))
      {
        i1 = i2;
        if (this.w != 1) {
          i1 = 0;
        }
      }
      if (i1 != 0)
      {
        a(d, this.a, this.b, this.c, this.h, bool1, this.w, this.q, this.j, this.k, this.l, this.m, this.r, bool2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("NowDataReporter", 2, "onReportFromXProxy Exception");
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      localNowDataReporter = h(paramString1);
    }
    catch (Exception paramString3)
    {
      NowDataReporter localNowDataReporter;
      label34:
      label37:
      break label37;
    }
    try
    {
      localNowDataReporter.f(paramString2).b("jump_h5").c(paramString3).d(paramString4).b();
    }
    catch (Exception paramString3)
    {
      break label34;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NowDataReporter", 2, "reportJumpH5 Exception");
    }
    a(d, paramString1, paramString2, this.c, "jump_h5", true, this.w, this.q, this.j, this.k, this.l, this.m, "", true);
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("opname");
    int i1 = paramJSONObject.optInt("op_in");
    int i2 = paramJSONObject.optInt("op_result");
    String str2 = paramJSONObject.optString("d1");
    String str3 = paramJSONObject.optString("d2");
    String str4 = paramJSONObject.optString("d3");
    String str5 = paramJSONObject.optString("d4");
    String str6 = paramJSONObject.optString("source");
    String str7 = paramJSONObject.optString("roomid");
    paramJSONObject = paramJSONObject.optString("roomtype");
    String str8 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str9 = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HttpUtil.getNetWorkType());
    ((StringBuilder)localObject).append("");
    this.f = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nowDatareportlastop: source = ");
    ((StringBuilder)localObject).append(str6);
    ((StringBuilder)localObject).append(" roomid = ");
    ((StringBuilder)localObject).append(str7);
    ((StringBuilder)localObject).append(" roomType = ");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(" op_name = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" op_in = ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" d1= ");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(" d2=");
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append(" d3=");
    ((StringBuilder)localObject).append(str4);
    ((StringBuilder)localObject).append(" d4=");
    ((StringBuilder)localObject).append(str5);
    ((StringBuilder)localObject).append(" timelong=");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append(" op_result = ");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(" qq_version = ");
    ((StringBuilder)localObject).append(str9);
    ((StringBuilder)localObject).append("  optime = ");
    ((StringBuilder)localObject).append(str8);
    ((StringBuilder)localObject).append(" lastOpName = ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" pluginstatus =");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append(" preloadStatus =");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(" sdkversion = ");
    ((StringBuilder)localObject).append(this.z);
    ((StringBuilder)localObject).append(" useShadow =");
    ((StringBuilder)localObject).append(this.y);
    QLog.i("NowDataReporter", 2, ((StringBuilder)localObject).toString());
    localObject = this.i;
    String str10 = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str5);
    localStringBuilder.append("|");
    localStringBuilder.append(this.r);
    localStringBuilder.append("|");
    localStringBuilder.append(str7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("|");
    localStringBuilder.append(str6);
    localStringBuilder.append("|");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(this.v);
    localStringBuilder.append("|");
    localStringBuilder.append(this.t);
    localStringBuilder.append("|");
    localStringBuilder.append(this.s);
    localStringBuilder.append("|");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuilder.append(this.z);
    localStringBuilder.append("|");
    localStringBuilder.append(str9);
    localStringBuilder.append("|");
    localStringBuilder.append(str8);
    localStringBuilder.append("|");
    localStringBuilder.append(str1);
    localStringBuilder.append("|");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append(this.y);
    ReportController.b(null, "dc02882", "grp_lbs", (String)localObject, str10, paramString, i1, 1, i2, str2, str3, str4, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    c();
    long l1 = System.currentTimeMillis();
    d = l1;
    this.y = paramBoolean4;
    if (this.y) {
      this.n = 11;
    }
    this.x = paramBoolean1;
    label129:
    label142:
    label145:
    label160:
    try
    {
      localObject = h(paramString1);
    }
    catch (Exception localException1)
    {
      Object localObject;
      NowDataReporter localNowDataReporter;
      String str2;
      label108:
      break label145;
    }
    try
    {
      localObject = ((NowDataReporter)localObject).f(paramString2);
    }
    catch (Exception localException2)
    {
      break label145;
    }
    try
    {
      localNowDataReporter = ((NowDataReporter)localObject).g(paramString3).b("nowentry");
      str2 = "1";
      if (paramBoolean1) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localNowDataReporter = localNowDataReporter.c((String)localObject);
      if (!paramBoolean2) {
        break label236;
      }
      localObject = "1";
    }
    catch (Exception localException3)
    {
      break label142;
      String str1 = "0";
      break label108;
      str1 = "0";
      break label129;
    }
    localNowDataReporter = localNowDataReporter.d((String)localObject);
    if (paramBoolean3)
    {
      localObject = str2;
      localNowDataReporter.e((String)localObject).b();
      break label160;
      if (QLog.isColorLevel()) {
        QLog.d("NowDataReporter", 2, "reportNowEntry Exception");
      }
      a(d, paramString1, paramString2, paramString3, "now_entry", false, 0, 0, this.j, this.k, this.l, this.m, "", false);
      new Handler().postDelayed(new NowDataReporter.1(this, l1), 90000L);
      return;
    }
  }
  
  public NowDataReporter b(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void b()
  {
    String str1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str2 = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HttpUtil.getNetWorkType());
    ((StringBuilder)localObject).append("");
    this.f = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nowDatareport: source = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" roomid = ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" roomType = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" op_name = ");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(" op_in = ");
    ((StringBuilder)localObject).append(this.w);
    ((StringBuilder)localObject).append(" d1= ");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append(" d2=");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append(" d3=");
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append(" d4=");
    ((StringBuilder)localObject).append(this.m);
    ((StringBuilder)localObject).append(" timelong=");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append(" op_result = ");
    ((StringBuilder)localObject).append(this.q);
    ((StringBuilder)localObject).append(" qq_version = ");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("  optime = ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" lastOpName = ");
    ((StringBuilder)localObject).append(this.u);
    ((StringBuilder)localObject).append(" pluginstatus =");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append(" preloadStatus =");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(" sdkversion = ");
    ((StringBuilder)localObject).append(this.z);
    ((StringBuilder)localObject).append("useShadow =");
    ((StringBuilder)localObject).append(this.y);
    QLog.i("NowDataReporter", 1, ((StringBuilder)localObject).toString());
    localObject = this.i;
    String str3 = this.g;
    String str4 = this.h;
    int i1 = this.w;
    int i2 = this.q;
    String str5 = this.j;
    String str6 = this.k;
    String str7 = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuilder.append(this.r);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(this.v);
    localStringBuilder.append("|");
    localStringBuilder.append(this.t);
    localStringBuilder.append("|");
    localStringBuilder.append(this.s);
    localStringBuilder.append("|");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuilder.append(this.z);
    localStringBuilder.append("|");
    localStringBuilder.append(str2);
    localStringBuilder.append("|");
    localStringBuilder.append(str1);
    localStringBuilder.append("|");
    localStringBuilder.append(this.u);
    localStringBuilder.append("|");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append(this.y);
    ReportController.b(null, "dc02882", "grp_lbs", (String)localObject, str3, str4, i1, 1, i2, str5, str6, str7, localStringBuilder.toString());
  }
  
  public NowDataReporter c(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public NowDataReporter d(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public NowDataReporter e(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public NowDataReporter f(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public NowDataReporter g(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public NowDataReporter h(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public NowDataReporter i(String paramString)
  {
    this.r = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowDataReporter
 * JD-Core Version:    0.7.0.1
 */