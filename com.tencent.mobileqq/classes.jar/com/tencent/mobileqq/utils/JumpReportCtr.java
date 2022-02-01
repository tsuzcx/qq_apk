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
  private static boolean jdField_b_of_type_Boolean = false;
  String a;
  String jdField_b_of_type_JavaLangString;
  String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public JumpReportCtr()
  {
    boolean bool = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = "-1";
    this.e = "-1";
    this.f = "-1";
    this.g = "-1";
    this.h = "-1";
    this.i = "-1";
    this.jdField_a_of_type_JavaLangString = "-1";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    if (jdField_b_of_type_Boolean) {
      return;
    }
    jdField_b_of_type_Boolean = true;
    Object localObject = BaseApplication.getContext().getSharedPreferences("JumpReportCtr_SP", 0);
    long l = ((SharedPreferences)localObject).getLong("lastShotTime", 0L);
    if (Math.abs(System.currentTimeMillis() - l) >= 43200000L)
    {
      if (0.01F >= Math.random()) {
        bool = true;
      }
      jdField_a_of_type_Boolean = bool;
      ((SharedPreferences)localObject).edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", jdField_a_of_type_Boolean).apply();
    }
    else
    {
      jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("lastShotResult", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JumpReportCtr init needReport= ");
      ((StringBuilder)localObject).append(jdField_a_of_type_Boolean);
      QLog.d("JumpActivity.Report", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    if (paramIntent != null) {
      this.e = paramIntent.getComponent().getClassName();
    }
    Object localObject1;
    if (this.jdField_c_of_type_Boolean)
    {
      paramIntent = new HashMap(5);
      paramIntent.put("action", this.f);
      paramIntent.put("scheme", this.g);
      paramIntent.put("type", this.h);
      paramIntent.put("data", this.i);
      paramIntent.put("fromPkg", this.d);
      paramIntent.put("jumpToAct", this.e);
      paramIntent.put("shareContext", this.jdField_a_of_type_JavaLangString);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "jump_act_system_report", true, 0L, 0L, paramIntent, null);
      paramIntent = new StringBuilder(256);
      paramIntent.append("action=");
      paramIntent.append(this.f);
      paramIntent.append(", pkgName=");
      paramIntent.append(this.d);
      paramIntent.append(", jumpToAct=");
      paramIntent.append(this.e);
      paramIntent.append(", scheme=");
      paramIntent.append(this.g);
      paramIntent.append(", type=");
      paramIntent.append(this.h);
      paramIntent.append(", shareContext=");
      paramIntent.append(this.jdField_a_of_type_JavaLangString);
      paramIntent.append("\n data=");
      paramIntent.append(this.i);
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
      paramIntent = this.jdField_c_of_type_JavaLangString;
      if (paramIntent == null) {
        paramIntent = "-1";
      }
      localObject1 = this.jdField_b_of_type_JavaLangString;
      if (localObject1 == null) {
        localObject1 = "-1";
      }
      Object localObject2 = new HashMap(8);
      ((HashMap)localObject2).put("action", this.f);
      ((HashMap)localObject2).put("scheme", this.g);
      ((HashMap)localObject2).put("type", this.h);
      ((HashMap)localObject2).put("data", this.i);
      ((HashMap)localObject2).put("fromPkg", this.d);
      ((HashMap)localObject2).put("jumpToAct", this.e);
      ((HashMap)localObject2).put("server_name", localObject1);
      ((HashMap)localObject2).put("action_name", paramIntent);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "jump_act_business_report", true, 0L, 0L, (HashMap)localObject2, null);
      localObject2 = new StringBuilder(256);
      ((StringBuilder)localObject2).append("action=");
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append(", type=");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append(", pkgName=");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append(", jumpToAct=");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(", scheme=");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append(", server_name=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", action_name=");
      ((StringBuilder)localObject2).append(paramIntent);
      ((StringBuilder)localObject2).append("\n data=");
      ((StringBuilder)localObject2).append(this.i);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("business share |report params: \n");
        paramIntent.append(((StringBuilder)localObject2).toString());
        QLog.d("JumpActivity.Report", 2, paramIntent.toString());
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = JumpForwardPkgManager.a(paramActivity);
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
    this.d = localStringBuilder.toString();
    this.jdField_c_of_type_Boolean = a(paramIntent);
    this.f = paramIntent.getAction();
    this.g = paramIntent.getScheme();
    this.h = paramIntent.getType();
    this.i = paramIntent.getDataString();
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.f.equals("android.intent.action.SEND")) || (this.f.equals("android.intent.action.SEND_MULTIPLE")))
      {
        paramAppRuntime = paramIntent.getExtras();
        if (paramAppRuntime != null) {
          if (!TextUtils.isEmpty(paramAppRuntime.getString("android.intent.extra.TEXT")))
          {
            this.jdField_a_of_type_JavaLangString = paramAppRuntime.getString("android.intent.extra.TEXT");
          }
          else
          {
            paramAppRuntime = paramAppRuntime.get("android.intent.extra.STREAM");
            if (paramAppRuntime != null) {
              if ((paramAppRuntime instanceof Uri)) {
                this.jdField_a_of_type_JavaLangString = ((Uri)paramAppRuntime).toString();
              } else if ((paramAppRuntime instanceof String)) {
                this.jdField_a_of_type_JavaLangString = ((String)paramAppRuntime);
              } else if ((paramAppRuntime instanceof ArrayList)) {
                this.jdField_a_of_type_JavaLangString = "MULTIPLE_SHARE";
              }
            }
          }
        }
      }
    }
    else if ((!TextUtils.isEmpty(this.i)) && (paramAppRuntime != null))
    {
      this.jdField_c_of_type_JavaLangString = ((IQJumpApi)QRoute.api(IQJumpApi.class)).parseJumpActionName(paramAppRuntime, paramActivity, this.i);
      this.jdField_b_of_type_JavaLangString = ((IQJumpApi)QRoute.api(IQJumpApi.class)).parseJumpServerName(paramAppRuntime, paramActivity, this.i);
    }
    paramActivity = (IMobileReportManager)QRoute.api(IMobileReportManager.class);
    paramIntent = this.d;
    if (!TextUtils.isEmpty(this.i))
    {
      paramAppRuntime = this.i;
    }
    else
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(this.f);
      paramAppRuntime.append("/shareContext:");
      paramAppRuntime.append(this.jdField_a_of_type_JavaLangString);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpReportCtr
 * JD-Core Version:    0.7.0.1
 */