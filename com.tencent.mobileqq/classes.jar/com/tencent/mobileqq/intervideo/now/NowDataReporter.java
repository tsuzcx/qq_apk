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
  public static long a;
  public static long b;
  protected int a;
  String jdField_a_of_type_JavaLangString;
  HashMap<Long, JSONObject> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected boolean a;
  protected int b;
  String b;
  protected boolean b;
  protected int c;
  String c;
  protected int d;
  protected String d;
  protected int e;
  protected String e;
  protected int f;
  protected String f;
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  protected String l;
  protected String m = Build.VERSION.RELEASE;
  protected String n = Build.MODEL;
  protected String o;
  String p;
  
  public NowDataReporter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
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
    else
    {
      localJSONObject = (JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
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
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localJSONObject);
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
    jdField_a_of_type_Long = 0L;
    this.jdField_f_of_type_JavaLangString = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.jdField_a_of_type_Int = 11;
    this.jdField_d_of_type_Int = 0;
    this.l = "";
    this.jdField_f_of_type_Int = 0;
  }
  
  public NowDataReporter a(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void a()
  {
    try
    {
      localNowDataReporter = b("show_loading");
      if (!this.jdField_a_of_type_Boolean) {
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
    a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "show_loading", false, this.jdField_f_of_type_Int, this.jdField_d_of_type_Int, this.h, this.i, this.j, this.k, "", false);
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
    try
    {
      this.jdField_f_of_type_JavaLangString = paramBundle.getString("op_name");
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        return;
      }
      this.jdField_f_of_type_Int = paramBundle.getInt("op_in");
      this.jdField_d_of_type_Int = paramBundle.getInt("op_result");
      this.l = paramBundle.getString("timeconsume");
      String str = paramBundle.getString("sdkversion");
      bool1 = TextUtils.isEmpty(str);
      if ((!bool1) && (!str.equals("0"))) {
        this.p = paramBundle.getString("sdkversion");
      }
      this.h = paramBundle.getString("d1");
      this.i = paramBundle.getString("d2");
      this.j = paramBundle.getString("d3");
      this.k = paramBundle.getString("d4");
      if (this.jdField_f_of_type_JavaLangString.equals("enter_shadow"))
      {
        this.jdField_b_of_type_Int = Integer.parseInt(paramBundle.getString("status1", "0"));
        this.jdField_a_of_type_Int = paramBundle.getInt("frameVersion");
      }
      b();
      if ((this.jdField_f_of_type_JavaLangString.equals("check_version_complete")) && (this.j.equals("1")))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Int = 0;
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(jdField_a_of_type_Long))) {
        return;
      }
      bool1 = this.jdField_f_of_type_JavaLangString.equals("cancel_run");
      if ((bool1) || (this.jdField_f_of_type_JavaLangString.equals("cancel_in_plugin")) || (this.jdField_f_of_type_JavaLangString.equals("download_fail")) || (this.jdField_f_of_type_JavaLangString.equals("boot_fail")) || (this.jdField_f_of_type_JavaLangString.equals("login_fail")) || (this.jdField_f_of_type_JavaLangString.equals("enter_fail")) || (this.jdField_f_of_type_JavaLangString.equals("user_cancel_in_plugin")) || (this.jdField_f_of_type_JavaLangString.equals("enter_room")) || (this.jdField_f_of_type_JavaLangString.equals("jump_h5"))) {
        break label725;
      }
      if (!this.jdField_f_of_type_JavaLangString.equals("jump_app")) {
        break label716;
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
    bool5 = this.jdField_f_of_type_JavaLangString.equals("download_biz_plugin");
    bool4 = bool1;
    bool2 = bool3;
    if (bool5)
    {
      bool4 = bool1;
      bool2 = bool3;
      if (this.h.equals("fail"))
      {
        bool4 = true;
        bool2 = true;
      }
    }
    if ((this.jdField_f_of_type_JavaLangString.equals("unzip_biz_plugin")) && (this.h.equals("fail")))
    {
      bool1 = true;
      bool2 = true;
      bool3 = this.jdField_f_of_type_JavaLangString.equals("download_start");
      if ((!bool3) || (!this.h.equals("2"))) {
        break label741;
      }
      i2 = 0;
      i1 = i2;
      if (this.jdField_f_of_type_JavaLangString.equals("download_complete"))
      {
        i1 = i2;
        if (this.h.equals("2")) {
          i1 = 0;
        }
      }
      i2 = i1;
      if (this.jdField_f_of_type_JavaLangString.equals("download_fail"))
      {
        i2 = i1;
        if (this.h.equals("2")) {
          i2 = 0;
        }
      }
      i1 = i2;
      if (this.jdField_f_of_type_JavaLangString.equals("install_start"))
      {
        i1 = i2;
        if (this.jdField_f_of_type_Int != 1) {
          i1 = 0;
        }
      }
      i2 = i1;
      if (this.jdField_f_of_type_JavaLangString.equals("install_complete"))
      {
        i2 = i1;
        if (this.jdField_f_of_type_Int != 1) {
          i2 = 0;
        }
      }
      i1 = i2;
      if (this.jdField_f_of_type_JavaLangString.equals("install_fail"))
      {
        i1 = i2;
        if (this.jdField_f_of_type_Int != 1) {
          i1 = 0;
        }
      }
      if (i1 != 0)
      {
        a(jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, bool1, this.jdField_f_of_type_Int, this.jdField_d_of_type_Int, this.h, this.i, this.j, this.k, this.l, bool2);
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
    a(jdField_a_of_type_Long, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, "jump_h5", true, this.jdField_f_of_type_Int, this.jdField_d_of_type_Int, this.h, this.i, this.j, this.k, "", true);
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
    this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
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
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append(" op_result = ");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(" qq_version = ");
    ((StringBuilder)localObject).append(str9);
    ((StringBuilder)localObject).append("  optime = ");
    ((StringBuilder)localObject).append(str8);
    ((StringBuilder)localObject).append(" lastOpName = ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" pluginstatus =");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(" preloadStatus =");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    ((StringBuilder)localObject).append(" sdkversion = ");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(" useShadow =");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    QLog.i("NowDataReporter", 2, ((StringBuilder)localObject).toString());
    localObject = this.g;
    String str10 = this.jdField_e_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str5);
    localStringBuilder.append("|");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuilder.append(str7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("|");
    localStringBuilder.append(str6);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append(str9);
    localStringBuilder.append("|");
    localStringBuilder.append(str8);
    localStringBuilder.append("|");
    localStringBuilder.append(str1);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    ReportController.b(null, "dc02882", "grp_lbs", (String)localObject, str10, paramString, i1, 1, i2, str2, str3, str4, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    c();
    long l1 = System.currentTimeMillis();
    jdField_a_of_type_Long = l1;
    this.jdField_b_of_type_Boolean = paramBoolean4;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Int = 11;
    }
    this.jdField_a_of_type_Boolean = paramBoolean1;
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
      a(jdField_a_of_type_Long, paramString1, paramString2, paramString3, "now_entry", false, 0, 0, this.h, this.i, this.j, this.k, "", false);
      new Handler().postDelayed(new NowDataReporter.1(this, l1), 90000L);
      return;
    }
  }
  
  public NowDataReporter b(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void b()
  {
    String str1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str2 = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HttpUtil.getNetWorkType());
    ((StringBuilder)localObject).append("");
    this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nowDatareport: source = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" roomid = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" roomType = ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" op_name = ");
    ((StringBuilder)localObject).append(this.jdField_f_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" op_in = ");
    ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
    ((StringBuilder)localObject).append(" d1= ");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(" d2=");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(" d3=");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append(" d4=");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append(" timelong=");
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append(" op_result = ");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject).append(" qq_version = ");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("  optime = ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" lastOpName = ");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append(" pluginstatus =");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(" preloadStatus =");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    ((StringBuilder)localObject).append(" sdkversion = ");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append("useShadow =");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    QLog.i("NowDataReporter", 1, ((StringBuilder)localObject).toString());
    localObject = this.g;
    String str3 = this.jdField_e_of_type_JavaLangString;
    String str4 = this.jdField_f_of_type_JavaLangString;
    int i1 = this.jdField_f_of_type_Int;
    int i2 = this.jdField_d_of_type_Int;
    String str5 = this.h;
    String str6 = this.i;
    String str7 = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append(str2);
    localStringBuilder.append("|");
    localStringBuilder.append(str1);
    localStringBuilder.append("|");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    ReportController.b(null, "dc02882", "grp_lbs", (String)localObject, str3, str4, i1, 1, i2, str5, str6, str7, localStringBuilder.toString());
  }
  
  public NowDataReporter c(String paramString)
  {
    this.h = paramString;
    return this;
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
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public NowDataReporter g(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public NowDataReporter h(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public NowDataReporter i(String paramString)
  {
    this.l = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowDataReporter
 * JD-Core Version:    0.7.0.1
 */