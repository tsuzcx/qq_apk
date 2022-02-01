package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class JumpReportCtr
{
  public static boolean a = false;
  private static boolean e = false;
  String b;
  String c;
  String d;
  private boolean f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  
  public JumpReportCtr()
  {
    boolean bool = false;
    this.f = false;
    this.g = "-1";
    this.h = "-1";
    this.i = "-1";
    this.j = "-1";
    this.k = "-1";
    this.l = "-1";
    this.b = "-1";
    this.c = "";
    this.d = "";
    if (e) {
      return;
    }
    e = true;
    Object localObject = BaseApplication.getContext().getSharedPreferences("JumpReportCtr_SP", 0);
    long l1 = ((SharedPreferences)localObject).getLong("lastShotTime", 0L);
    if (Math.abs(System.currentTimeMillis() - l1) >= 43200000L)
    {
      if (0.01F >= Math.random()) {
        bool = true;
      }
      a = bool;
      ((SharedPreferences)localObject).edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", a).apply();
    }
    else
    {
      a = ((SharedPreferences)localObject).getBoolean("lastShotResult", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JumpReportCtr init needReport= ");
      ((StringBuilder)localObject).append(a);
      QLog.d("JumpActivity.Report", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!a) {
      return;
    }
    Object localObject = JumpForwardPkgManager.c(paramActivity);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localObject != null) && (!((HashSet)localObject).isEmpty()))
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(str);
      }
    }
    this.g = localStringBuilder.toString();
    this.f = a(paramIntent);
    this.i = paramIntent.getAction();
    this.j = paramIntent.getScheme();
    this.k = paramIntent.getType();
    this.l = paramIntent.getDataString();
    if (this.f)
    {
      if ((this.i.equals("android.intent.action.SEND")) || (this.i.equals("android.intent.action.SEND_MULTIPLE")))
      {
        paramAppRuntime = paramIntent.getExtras();
        if (paramAppRuntime != null) {
          if (!TextUtils.isEmpty(paramAppRuntime.getString("android.intent.extra.TEXT")))
          {
            this.b = paramAppRuntime.getString("android.intent.extra.TEXT");
          }
          else
          {
            paramAppRuntime = paramAppRuntime.get("android.intent.extra.STREAM");
            if (paramAppRuntime != null) {
              if ((paramAppRuntime instanceof Uri)) {
                this.b = ((Uri)paramAppRuntime).toString();
              } else if ((paramAppRuntime instanceof String)) {
                this.b = ((String)paramAppRuntime);
              } else if ((paramAppRuntime instanceof ArrayList)) {
                this.b = "MULTIPLE_SHARE";
              }
            }
          }
        }
      }
    }
    else if ((!TextUtils.isEmpty(this.l)) && (paramAppRuntime != null))
    {
      this.d = ((IQJumpApi)QRoute.api(IQJumpApi.class)).parseJumpActionName(paramAppRuntime, paramActivity, this.l);
      this.c = ((IQJumpApi)QRoute.api(IQJumpApi.class)).parseJumpServerName(paramAppRuntime, paramActivity, this.l);
    }
    paramActivity = (IMobileReportManager)QRoute.api(IMobileReportManager.class);
    paramIntent = this.g;
    if (!TextUtils.isEmpty(this.l))
    {
      paramAppRuntime = this.l;
    }
    else
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(this.i);
      paramAppRuntime.append("/shareContext:");
      paramAppRuntime.append(this.b);
      paramAppRuntime = paramAppRuntime.toString();
    }
    paramActivity.reportSchemaInfo(paramIntent, paramAppRuntime);
  }
  
  public boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    String str = paramIntent.getAction();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (!str.equals("android.intent.action.SEND"))
    {
      if (str.equals("android.intent.action.SEND_MULTIPLE")) {
        return true;
      }
      paramIntent = paramIntent.getScheme();
      return (str.equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(paramIntent)) && ((paramIntent.equals("file")) || (paramIntent.equals("content")));
    }
    return true;
  }
  
  public void b(Intent paramIntent)
  {
    if (!a) {
      return;
    }
    if (paramIntent != null) {
      this.h = paramIntent.getComponent().getClassName();
    }
    Object localObject1;
    if (this.f)
    {
      paramIntent = new HashMap(5);
      paramIntent.put("action", this.i);
      paramIntent.put("scheme", this.j);
      paramIntent.put("type", this.k);
      paramIntent.put("data", this.l);
      paramIntent.put("fromPkg", this.g);
      paramIntent.put("jumpToAct", this.h);
      paramIntent.put("shareContext", this.b);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "jump_act_system_report", true, 0L, 0L, paramIntent, null);
      paramIntent = new StringBuilder(256);
      paramIntent.append("action=");
      paramIntent.append(this.i);
      paramIntent.append(", pkgName=");
      paramIntent.append(this.g);
      paramIntent.append(", jumpToAct=");
      paramIntent.append(this.h);
      paramIntent.append(", scheme=");
      paramIntent.append(this.j);
      paramIntent.append(", type=");
      paramIntent.append(this.k);
      paramIntent.append(", shareContext=");
      paramIntent.append(this.b);
      paramIntent.append("\n data=");
      paramIntent.append(this.l);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("systemShare|report : \n");
        ((StringBuilder)localObject1).append(paramIntent.toString());
        QLog.d("JumpActivity.Report", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      paramIntent = this.d;
      if (paramIntent == null) {
        paramIntent = "-1";
      }
      localObject1 = this.c;
      if (localObject1 == null) {
        localObject1 = "-1";
      }
      Object localObject2 = new HashMap(8);
      ((HashMap)localObject2).put("action", this.i);
      ((HashMap)localObject2).put("scheme", this.j);
      ((HashMap)localObject2).put("type", this.k);
      ((HashMap)localObject2).put("data", this.l);
      ((HashMap)localObject2).put("fromPkg", this.g);
      ((HashMap)localObject2).put("jumpToAct", this.h);
      ((HashMap)localObject2).put("server_name", localObject1);
      ((HashMap)localObject2).put("action_name", paramIntent);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "jump_act_business_report", true, 0L, 0L, (HashMap)localObject2, null);
      localObject2 = new StringBuilder(256);
      ((StringBuilder)localObject2).append("action=");
      ((StringBuilder)localObject2).append(this.i);
      ((StringBuilder)localObject2).append(", type=");
      ((StringBuilder)localObject2).append(this.k);
      ((StringBuilder)localObject2).append(", pkgName=");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append(", jumpToAct=");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append(", scheme=");
      ((StringBuilder)localObject2).append(this.j);
      ((StringBuilder)localObject2).append(", server_name=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", action_name=");
      ((StringBuilder)localObject2).append(paramIntent);
      ((StringBuilder)localObject2).append("\n data=");
      ((StringBuilder)localObject2).append(this.l);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("business share |report params: \n");
        paramIntent.append(((StringBuilder)localObject2).toString());
        QLog.d("JumpActivity.Report", 2, paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpReportCtr
 * JD-Core Version:    0.7.0.1
 */