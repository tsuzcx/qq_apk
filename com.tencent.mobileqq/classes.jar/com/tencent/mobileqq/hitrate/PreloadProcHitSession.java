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
  public String b;
  public String c;
  public String d;
  protected boolean e;
  public HashMap<String, String> f = new HashMap();
  public boolean g;
  
  public PreloadProcHitSession(String paramString1, String paramString2)
  {
    this("default", paramString1, paramString2);
  }
  
  protected PreloadProcHitSession(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    d();
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
  
  public void a()
  {
    if (this.e) {
      e();
    }
    PreloadProcHitMgr.a(this);
    this.e = true;
    if (!(this instanceof PreloadProcHitPluginSessionProc)) {
      PreloadProcHitMgr.e(this.d);
    }
  }
  
  public void b()
  {
    if (!this.e) {
      return;
    }
    this.g = true;
    if (!(this instanceof PreloadProcHitPluginSessionProc)) {
      PreloadProcHitMgr.d(this.d);
    }
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  void d()
  {
    synchronized (this.f)
    {
      this.f.put("loss", "0");
      this.f.put("benefit", "0");
      this.e = false;
      this.g = false;
      return;
    }
  }
  
  public void e()
  {
    if (!this.e) {
      return;
    }
    Object localObject3 = MobileQQ.getMobileQQ();
    HashMap localHashMap = new HashMap();
    synchronized (this.f)
    {
      localHashMap.putAll(this.f);
      if (localObject3 != null)
      {
        ??? = ((MobileQQ)localObject3).getApplicationContext();
        localObject3 = ((MobileQQ)localObject3).peekAppRuntime();
        if (localObject3 != null)
        {
          localObject3 = ((AppRuntime)localObject3).getAccount();
          String str = this.c;
          if (this.g) {
            StatisticCollector.getInstance((Context)???).collectPerformance((String)localObject3, str, true, 0L, 0L, localHashMap, null);
          } else {
            StatisticCollector.getInstance((Context)???).collectPerformance((String)localObject3, str, false, 0L, 0L, localHashMap, null);
          }
        }
      }
      d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hitrate.PreloadProcHitSession
 * JD-Core Version:    0.7.0.1
 */