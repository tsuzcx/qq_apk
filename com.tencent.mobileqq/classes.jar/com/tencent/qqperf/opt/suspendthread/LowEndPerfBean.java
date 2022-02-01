package com.tencent.qqperf.opt.suspendthread;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LowEndPerfBean
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = true;
  
  public LowEndPerfBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "0.0f|0.0f|0.0f|0.0f";
    this.jdField_b_of_type_JavaLangString = "-1";
    this.jdField_c_of_type_JavaLangString = "-1";
  }
  
  public static LowEndPerfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        LowEndPerfBean localLowEndPerfBean = new LowEndPerfBean();
        Object localObject1 = new JSONObject(paramString);
        localLowEndPerfBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("userratio_new", "0.0f|0.0f|0.0f|0.0f");
        localLowEndPerfBean.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("extralsteps_new", "-1");
        localLowEndPerfBean.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("predownloadwhitelist_new", "-1");
        localLowEndPerfBean.e = ((JSONObject)localObject1).optBoolean("useapm_new", false);
        localLowEndPerfBean.h = ((JSONObject)localObject1).optBoolean("suspendWhiteListOnly", true);
        paramString = Float.valueOf(Float.parseFloat(((JSONObject)localObject1).optString("suspend_user_ratio", "0.0f")));
        if (paramString != null)
        {
          if (paramString.floatValue() > Math.random())
          {
            bool = true;
            localLowEndPerfBean.f = bool;
          }
        }
        else
        {
          localObject1 = Float.valueOf(Float.parseFloat(((JSONObject)localObject1).optString("fake_suspend_user_ratio", "0.0f")));
          if (localObject1 != null)
          {
            if (((Float)localObject1).floatValue() <= Math.random()) {
              break label531;
            }
            bool = true;
            localLowEndPerfBean.g = bool;
          }
          if (!localLowEndPerfBean.jdField_a_of_type_JavaLangString.isEmpty())
          {
            Object localObject2 = localLowEndPerfBean.jdField_a_of_type_JavaLangString.split("\\|");
            if (localObject2.length == 4)
            {
              float f1 = Float.parseFloat(localObject2[0]);
              float f2 = Float.parseFloat(localObject2[1]);
              float f3 = Float.parseFloat(localObject2[2]);
              float f4 = Float.parseFloat(localObject2[3]);
              if (f1 <= Math.random()) {
                break label537;
              }
              bool = true;
              localLowEndPerfBean.jdField_a_of_type_Boolean = bool;
              if (f2 <= Math.random()) {
                break label543;
              }
              bool = true;
              localLowEndPerfBean.jdField_b_of_type_Boolean = bool;
              if (f3 <= Math.random()) {
                break label549;
              }
              bool = true;
              localLowEndPerfBean.jdField_c_of_type_Boolean = bool;
              if (f4 <= Math.random()) {
                break label555;
              }
              bool = true;
              localLowEndPerfBean.d = bool;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("disable_preload_user_ratio = ");
              ((StringBuilder)localObject2).append(f1);
              ((StringBuilder)localObject2).append(",disable_predownload_user_ratio = ");
              ((StringBuilder)localObject2).append(f2);
              ((StringBuilder)localObject2).append(",disable_gettroop_user_ratio = ");
              ((StringBuilder)localObject2).append(f3);
              ((StringBuilder)localObject2).append(",enable_auto_user_ratio = ");
              ((StringBuilder)localObject2).append(f4);
              ((StringBuilder)localObject2).append(",suspend_user_ratio = ");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(",fake_suspend_user_ratio = ");
              ((StringBuilder)localObject2).append(localObject1);
              QLog.d("Perf", 1, ((StringBuilder)localObject2).toString());
            }
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("confBean = ");
            paramString.append(localLowEndPerfBean.toString());
            QLog.d("Perf", 2, paramString.toString());
          }
          return localLowEndPerfBean;
        }
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Perf", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
      continue;
      label531:
      bool = false;
      continue;
      label537:
      bool = false;
      continue;
      label543:
      bool = false;
      continue;
      label549:
      bool = false;
      continue;
      label555:
      bool = false;
    }
  }
  
  public boolean a()
  {
    return this.e ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LowEndPerfBean{mDisablePreloadProcess=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",mDisablePredownload=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",mDisableGetTroopList=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(",mEnableAutomatorDelay=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",mUserRatio=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mExtraSteps=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",mPredownLoadWhiteList=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",mUseApmConfig=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",mSuspend_Thread=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",mFake_Suspend_Thread = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",mSuspendWhiteListThreadOnly = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.LowEndPerfBean
 * JD-Core Version:    0.7.0.1
 */