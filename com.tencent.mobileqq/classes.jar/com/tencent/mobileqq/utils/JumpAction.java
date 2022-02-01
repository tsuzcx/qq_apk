package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Hashtable;

public class JumpAction
{
  public static int a = 1;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public Context a;
  protected Handler a;
  protected AppInterface a;
  public final BaseQQAppInterface a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public HashMap<String, String> a;
  public Hashtable<String, Long> a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  protected boolean h;
  public String i = "";
  protected boolean i;
  public String j;
  public boolean j;
  public String k;
  private boolean k;
  
  protected JumpAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static String c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (!"".equals(paramString)) {
        if (paramString.length() == 0) {
          return null;
        }
      }
    }
    try
    {
      localObject1 = new String(Base64Util.decode(paramString, 0));
      return localObject1;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void g(String paramString)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("keyJumpParserUtilUrlErrorKey", paramString);
    localHashMap.put("keyJumpParserUtilSceneErrorKey", "2");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, localHashMap, "", false);
  }
  
  public BaseQQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(Activity paramActivity)
  {
    g(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.putAll(paramHashMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNewFlag.newflag=");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("Jumpaction", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b_(String paramString)
  {
    HashMap localHashMap = new HashMap(1);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = "";
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append("source:");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    paramString.append("server_name:");
    paramString.append(this.jdField_b_of_type_JavaLangString);
    paramString.append("action_name:");
    paramString.append(this.jdField_c_of_type_JavaLangString);
    localHashMap.put("keyJumpParserUtilDoActionErrorInfo", paramString.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, localHashMap, "", false);
  }
  
  public void c(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void d()
  {
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void d(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public boolean d()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void e(String paramString)
  {
    this.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public boolean e()
  {
    g(this.jdField_a_of_type_JavaLangString);
    return false;
  }
  
  public void f(String paramString)
  {
    this.h = paramString;
  }
  
  public boolean f()
  {
    g(this.jdField_a_of_type_JavaLangString);
    return false;
  }
  
  public boolean g()
  {
    g(this.jdField_a_of_type_JavaLangString);
    return false;
  }
  
  public boolean h()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"));
  }
  
  public boolean i()
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {
      return true;
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("group")) && (this.jdField_c_of_type_JavaLangString.equals("creategroup"))) {
      return true;
    }
    return (this.jdField_b_of_type_JavaLangString.equals("qstory")) && (this.jdField_c_of_type_JavaLangString.equals("publish"));
  }
  
  public boolean i_()
  {
    g(this.jdField_a_of_type_JavaLangString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction
 * JD-Core Version:    0.7.0.1
 */