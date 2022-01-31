package com.tencent.mobileqq.intervideo.now;

import adut;
import aduu;
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
  public static long a;
  protected int a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected boolean a;
  protected int b;
  String b;
  protected int c;
  String c;
  protected int d;
  protected String d;
  protected String e = "";
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  String p;
  
  public NowDataReporter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 7;
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.m = Build.VERSION.RELEASE;
    this.n = Build.MODEL;
    a("now_plugin");
  }
  
  private void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean2)
  {
    if (paramLong == 0L) {
      return;
    }
    JSONObject localJSONObject;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      localJSONObject = new JSONObject();
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localJSONObject);
    }
    for (;;)
    {
      try
      {
        if (localJSONObject.optBoolean("noneedadd")) {
          break label223;
        }
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
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localJSONObject);
        if (!paramBoolean2) {
          break;
        }
        a(paramLong);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      localJSONObject = (JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      continue;
      label223:
      QLog.i("NowDataReporter", 1, "本次opname不影响上报");
    }
  }
  
  private void d()
  {
    jdField_a_of_type_Long = 0L;
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.jdField_a_of_type_Int = 7;
    this.p = "";
    this.jdField_b_of_type_Int = 0;
    this.l = "";
    this.jdField_d_of_type_Int = 0;
  }
  
  public NowDataReporter a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public NowDataReporter a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    jdField_a_of_type_Long = l1;
    try
    {
      b("now_retry").c();
      a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "now_retry", false, 0, 0, this.h, this.i, this.j, this.k, "", false);
      new Handler().postDelayed(new aduu(this, l1), 60000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowDataReporter", 2, "reportRetry Exception");
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    JSONObject localJSONObject = (JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localJSONObject != null) && (localJSONObject.has("opname")))
    {
      a("last_op_name", localJSONObject);
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    for (;;)
    {
      try
      {
        this.f = paramBundle.getString("op_name");
        bool1 = false;
        int i2 = 1;
        bool2 = false;
        this.jdField_d_of_type_Int = paramBundle.getInt("op_in");
        this.jdField_b_of_type_Int = paramBundle.getInt("op_result");
        this.l = paramBundle.getString("timeconsume");
        if (!TextUtils.isEmpty(paramBundle.getString("sdkversion"))) {
          this.p = paramBundle.getString("sdkversion");
        }
        this.h = paramBundle.getString("d1");
        this.i = paramBundle.getString("d2");
        this.j = paramBundle.getString("d3");
        this.k = paramBundle.getString("d4");
        c();
        if ((this.f.equals("check_version_complete")) && (this.j.equals("1"))) {
          this.jdField_a_of_type_Boolean = false;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(jdField_a_of_type_Long))) {
          break;
        }
        if ((this.f.equals("cancel_run")) || (this.f.equals("cancel_in_plugin")) || (this.f.equals("download_fail")) || (this.f.equals("boot_fail")) || (this.f.equals("login_fail")) || (this.f.equals("enter_fail"))) {
          break label499;
        }
        int i1 = i2;
        if (this.f.equals("download_start"))
        {
          i1 = i2;
          if (this.h.equals("2")) {
            i1 = 0;
          }
        }
        i2 = i1;
        if (this.f.equals("download_complete"))
        {
          i2 = i1;
          if (this.h.equals("2")) {
            i2 = 0;
          }
        }
        i1 = i2;
        if (this.f.equals("download_fail"))
        {
          i1 = i2;
          if (this.h.equals("2")) {
            i1 = 0;
          }
        }
        i2 = i1;
        if (this.f.equals("install_start"))
        {
          i2 = i1;
          if (this.jdField_d_of_type_Int != 1) {
            i2 = 0;
          }
        }
        i1 = i2;
        if (this.f.equals("install_complete"))
        {
          i1 = i2;
          if (this.jdField_d_of_type_Int != 1) {
            i1 = 0;
          }
        }
        i2 = i1;
        if (this.f.equals("install_fail"))
        {
          i2 = i1;
          if (this.jdField_d_of_type_Int != 1) {
            i2 = 0;
          }
        }
        if (i2 == 0) {
          break;
        }
        a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.f, bool1, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k, this.l, bool2);
        return;
      }
      catch (Exception paramBundle) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NowDataReporter", 2, "onReportFromXProxy Exception");
      return;
      label499:
      boolean bool1 = true;
      boolean bool2 = true;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowDataReporter", 2, "reportEnterPluginActivity souece = " + paramString);
    }
    String str2 = String.valueOf(System.currentTimeMillis() - jdField_a_of_type_Long);
    for (;;)
    {
      try
      {
        NowDataReporter localNowDataReporter = i(paramString);
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        str1 = "1";
        localNowDataReporter.c(str1).j(str2).b("enter_activity").c();
      }
      catch (Exception localException)
      {
        String str1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NowDataReporter", 2, "reportEnterPluginActivity Exception");
        continue;
      }
      a(jdField_a_of_type_Long, paramString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.f, false, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k, str2, false);
      return;
      str1 = "0";
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("flag", 0L);
    long l2 = paramBundle.getLong("code", 0L);
    long l3 = paramBundle.getLong("subcode", 0L);
    long l4 = System.currentTimeMillis();
    long l5 = jdField_a_of_type_Long;
    for (;;)
    {
      try
      {
        paramBundle = i(paramString1).g(paramString2).h(this.jdField_c_of_type_JavaLangString).a((int)l2).b("enter_room");
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        paramString2 = "1";
        paramBundle.c(paramString2).d(String.valueOf(l2)).e(String.valueOf(l3)).f(String.valueOf(l1)).j(String.valueOf(System.currentTimeMillis() - jdField_a_of_type_Long)).c();
      }
      catch (Exception paramString2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NowDataReporter", 2, "reportEnterPluginRoom Exception");
        continue;
      }
      a(jdField_a_of_type_Long, paramString1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "enter_room", true, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k, String.valueOf(l4 - l5), true);
      return;
      paramString2 = "0";
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowDataReporter", 2, "reportAutoEnterAnswer souece = " + paramString1 + ", opname = " + paramString2);
    }
    try
    {
      i(paramString1).b(paramString2).c(paramString3).c();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NowDataReporter", 2, "reportEnterPluginActivity Exception");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      i(paramString1).g(paramString2).b("jump_h5").c(paramString3).d(paramString4).c();
      a(jdField_a_of_type_Long, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, "jump_h5", true, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k, "", true);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowDataReporter", 2, "reportJumpH5 Exception");
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    for (;;)
    {
      try
      {
        NowDataReporter localNowDataReporter = b(paramString1).c(paramString2).d(paramString3).e(paramString4).f(paramString5);
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        i1 = 1;
        localNowDataReporter.a(i1);
      }
      catch (Exception localException)
      {
        int i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NowDataReporter", 2, "reportJumpPlugin Exception");
        continue;
      }
      a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramString1, false, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, paramString2, paramString3, paramString4, paramString5, "", false);
      return;
      i1 = 0;
    }
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
    this.jdField_d_of_type_JavaLangString = (HttpUtil.a() + "");
    QLog.i("NowDataReporter", 1, "nowDatareport: source = " + str6 + " roomid = " + str7 + " roomType = " + paramJSONObject + " op_name = " + paramString + " op_in = " + i1 + " d1= " + str2 + " d2=" + str3 + " d3=" + str4 + " d4=" + str5 + " timelong=" + this.l + " op_result = " + i2 + " qq_version = " + str9 + "  optime = " + str8 + " lastOpName = " + str1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc02882", "grp_lbs", this.g, this.e, paramString, i1, 1, i2, str2, str3, str4, str5 + "|" + this.l + "|" + str7 + "|" + paramJSONObject + "|" + str6 + "|" + this.jdField_d_of_type_JavaLangString + "|" + this.jdField_c_of_type_Int + "|" + this.n + "|" + this.m + "|" + this.jdField_a_of_type_Int + "|" + this.p + "|" + str9 + "|" + str8 + "|" + str1);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    for (;;)
    {
      try
      {
        NowDataReporter localNowDataReporter = i(paramString1).g(paramString2).h(paramString3).b("jump_plugin");
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        str = "1";
        localNowDataReporter.c(str).c();
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NowDataReporter", 2, "reportJumpPlugin Exception");
        continue;
      }
      a(jdField_a_of_type_Long, paramString1, paramString2, paramString3, "jump_plugin", false, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k, "", false);
      return;
      str = "0";
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
  {
    d();
    long l1 = System.currentTimeMillis();
    jdField_a_of_type_Long = l1;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    if (QLog.isColorLevel()) {
      QLog.d("NowDataReporter", 2, "reportNowEntry: source = " + paramString1 + "roomid = " + paramString2 + "roomType = " + paramString3);
    }
    try
    {
      localNowDataReporter = i(paramString1).g(paramString2).h(paramString3).b("nowentry");
      if (!paramBoolean1) {
        break label209;
      }
      str1 = "1";
      localNowDataReporter = localNowDataReporter.c(str1);
      if (!paramBoolean2) {
        break label245;
      }
      str1 = "1";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        NowDataReporter localNowDataReporter;
        String str1;
        if (QLog.isColorLevel())
        {
          QLog.d("NowDataReporter", 2, "reportNowEntry Exception");
          continue;
          String str2 = "0";
        }
      }
    }
    localNowDataReporter = localNowDataReporter.d(str1);
    if (paramBoolean3) {}
    for (str1 = "1";; str1 = "0")
    {
      localNowDataReporter.e(str1).c();
      a(jdField_a_of_type_Long, paramString1, paramString2, paramString3, "now_entry", false, 0, 0, this.h, this.i, this.j, this.k, "", false);
      new Handler().postDelayed(new adut(this, l1), 60000L);
      return;
      label209:
      str1 = "0";
      break;
    }
  }
  
  public NowDataReporter b(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        NowDataReporter localNowDataReporter = b("show_loading");
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        str = "1";
        localNowDataReporter.c(str).c();
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NowDataReporter", 2, "reportJumpPlugin Exception");
        continue;
      }
      a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "show_loading", false, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k, "", false);
      return;
      str = "0";
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowDataReporter", 2, "reportAutoEnterAnswer souece = " + paramString1 + ", opname = " + paramString2);
    }
    try
    {
      i(paramString1).b(paramString2).c(paramString3).c();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NowDataReporter", 2, "reportEnterPluginActivity Exception");
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      i(paramString1).g(paramString2).h(paramString3).b("jump_app").c(paramString4).c();
      a(jdField_a_of_type_Long, paramString1, paramString2, paramString3, "jump_app", true, this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k, "", true);
      return;
    }
    catch (Exception paramString4)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowDataReporter", 2, "reportJumpAPP Exception");
        }
      }
    }
  }
  
  public NowDataReporter c(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void c()
  {
    String str1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str2 = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
    this.jdField_d_of_type_JavaLangString = (HttpUtil.a() + "");
    QLog.i("NowDataReporter", 1, "nowDatareport: source = " + this.jdField_a_of_type_JavaLangString + " roomid = " + this.jdField_b_of_type_JavaLangString + " roomType = " + this.jdField_c_of_type_JavaLangString + " op_name = " + this.f + " op_in = " + this.jdField_d_of_type_Int + " d1= " + this.h + " d2=" + this.i + " d3=" + this.j + " d4=" + this.k + " timelong=" + this.l + " op_result = " + this.jdField_b_of_type_Int + " qq_version = " + str2 + "  optime = " + str1 + " lastOpName = " + this.o);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc02882", "grp_lbs", this.g, this.e, this.f, this.jdField_d_of_type_Int, 1, this.jdField_b_of_type_Int, this.h, this.i, this.j, this.k + "|" + this.l + "|" + this.jdField_b_of_type_JavaLangString + "|" + this.jdField_c_of_type_JavaLangString + "|" + this.jdField_a_of_type_JavaLangString + "|" + this.jdField_d_of_type_JavaLangString + "|" + this.jdField_c_of_type_Int + "|" + this.n + "|" + this.m + "|" + this.jdField_a_of_type_Int + "|" + this.p + "|" + str2 + "|" + str1 + "|" + this.o);
  }
  
  public NowDataReporter d(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public NowDataReporter e(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public NowDataReporter f(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public NowDataReporter g(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public NowDataReporter h(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public NowDataReporter i(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public NowDataReporter j(String paramString)
  {
    this.l = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowDataReporter
 * JD-Core Version:    0.7.0.1
 */