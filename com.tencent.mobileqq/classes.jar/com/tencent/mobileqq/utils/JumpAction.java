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
  public static String A;
  public static String B;
  public static int l = 1;
  public static String y;
  public static String z;
  protected Handler C;
  protected boolean D;
  protected boolean E;
  protected AppInterface F;
  public boolean G = false;
  private boolean H = false;
  public final BaseQQAppInterface a;
  public Context b;
  public String c;
  public String d;
  public String e;
  public HashMap<String, String> f;
  public boolean g;
  public String h;
  public String i;
  public String j;
  public boolean k;
  public String m;
  public boolean n = false;
  public String o;
  public boolean p = false;
  public String q = "";
  public String r = "";
  public String s = "";
  public boolean t = false;
  public Hashtable<String, Long> u = new Hashtable();
  public boolean v = true;
  public boolean w = false;
  public BusinessInfoCheckUpdate.AppInfo x;
  
  protected JumpAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    this.b = paramContext;
    this.a = paramBaseQQAppInterface;
    this.f = new HashMap();
  }
  
  public static String h(String paramString)
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
  
  private void i(String paramString)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("keyJumpParserUtilUrlErrorKey", paramString);
    localHashMap.put("keyJumpParserUtilSceneErrorKey", "2");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, localHashMap, "", false);
  }
  
  public void a(Activity paramActivity)
  {
    i(this.c);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.F = paramAppInterface;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.x = paramAppInfo;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.f.put(paramString1, paramString2);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      this.f.putAll(paramHashMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNewFlag.newflag=");
      localStringBuilder.append(this.n);
      QLog.d("Jumpaction", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b(String paramString)
  {
    return (String)this.f.get(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public boolean bY_()
  {
    i(this.c);
    return false;
  }
  
  public void c(String paramString)
  {
    this.h = paramString;
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public void e(String paramString)
  {
    this.j = paramString;
  }
  
  public void f(String paramString)
  {
    this.m = paramString;
  }
  
  public void g()
  {
    this.H = true;
  }
  
  public void g(String paramString)
  {
    this.o = paramString;
  }
  
  public boolean h()
  {
    return this.H;
  }
  
  public void h_(String paramString)
  {
    HashMap localHashMap = new HashMap(1);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    if (this.e == null) {
      this.e = "";
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append("source:");
    paramString.append(this.c);
    paramString.append("server_name:");
    paramString.append(this.d);
    paramString.append("action_name:");
    paramString.append(this.e);
    localHashMap.put("keyJumpParserUtilDoActionErrorInfo", paramString.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, localHashMap, "", false);
  }
  
  public String i()
  {
    return this.d;
  }
  
  public void j()
  {
    this.k = true;
  }
  
  public boolean k()
  {
    i(this.c);
    return false;
  }
  
  public boolean l()
  {
    i(this.c);
    return false;
  }
  
  public boolean m()
  {
    i(this.c);
    return false;
  }
  
  public boolean n()
  {
    return (this.d.equals("share")) && (this.e.equals("to_fri"));
  }
  
  public boolean o()
  {
    if ((this.d.equals("im")) && (this.e.equals("aioorprofile"))) {
      return true;
    }
    if ((this.d.equals("group")) && (this.e.equals("creategroup"))) {
      return true;
    }
    return (this.d.equals("qstory")) && (this.e.equals("publish"));
  }
  
  public BaseQQAppInterface p()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction
 * JD-Core Version:    0.7.0.1
 */