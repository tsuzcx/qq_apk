package com.tencent.mobileqq.hitrate;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PreloadProcHitSession
{
  public HashMap<String, String> a;
  protected boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  
  public PreloadProcHitSession(String paramString1, String paramString2)
  {
    this("default", paramString1, paramString2);
  }
  
  protected PreloadProcHitSession(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    c();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName)) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    PreloadProcHitMgr.a(this);
    this.jdField_a_of_type_Boolean = true;
    if (!(this instanceof PreloadProcHitPluginSessionProc)) {
      PreloadProcHitMgr.e(this.d);
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (!(this instanceof PreloadProcHitPluginSessionProc)) {
      PreloadProcHitMgr.d(this.d);
    }
  }
  
  void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("loss", "0");
      this.jdField_a_of_type_JavaUtilHashMap.put("benefit", "0");
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = MobileQQ.getMobileQQ();
    HashMap localHashMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localHashMap.putAll(this.jdField_a_of_type_JavaUtilHashMap);
      if (localObject3 != null)
      {
        ??? = ((MobileQQ)localObject3).getApplicationContext();
        localObject3 = ((MobileQQ)localObject3).peekAppRuntime();
        if (localObject3 != null)
        {
          localObject3 = ((AppRuntime)localObject3).getAccount();
          String str = this.c;
          if (this.jdField_b_of_type_Boolean) {
            StatisticCollector.getInstance((Context)???).collectPerformance((String)localObject3, str, true, 0L, 0L, localHashMap, null);
          } else {
            StatisticCollector.getInstance((Context)???).collectPerformance((String)localObject3, str, false, 0L, 0L, localHashMap, null);
          }
        }
      }
      c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.hitrate.PreloadProcHitSession
 * JD-Core Version:    0.7.0.1
 */