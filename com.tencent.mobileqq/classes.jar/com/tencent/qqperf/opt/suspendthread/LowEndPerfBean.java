package com.tencent.qqperf.opt.suspendthread;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LowEndPerfBean
{
  public boolean a = false;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public String e = "0.0f|0.0f|0.0f|0.0f";
  public String f = "-1";
  public String g = "-1";
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = true;
  
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
        localLowEndPerfBean.e = ((JSONObject)localObject1).optString("userratio_new", "0.0f|0.0f|0.0f|0.0f");
        localLowEndPerfBean.f = ((JSONObject)localObject1).optString("extralsteps_new", "-1");
        localLowEndPerfBean.g = ((JSONObject)localObject1).optString("predownloadwhitelist_new", "-1");
        localLowEndPerfBean.h = ((JSONObject)localObject1).optBoolean("useapm_new", false);
        localLowEndPerfBean.k = ((JSONObject)localObject1).optBoolean("suspendWhiteListOnly", true);
        paramString = Float.valueOf(Float.parseFloat(((JSONObject)localObject1).optString("suspend_user_ratio", "0.0f")));
        if (paramString != null)
        {
          if (paramString.floatValue() > Math.random())
          {
            bool = true;
            localLowEndPerfBean.i = bool;
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
            localLowEndPerfBean.j = bool;
          }
          if (!localLowEndPerfBean.e.isEmpty())
          {
            Object localObject2 = localLowEndPerfBean.e.split("\\|");
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
              localLowEndPerfBean.a = bool;
              if (f2 <= Math.random()) {
                break label543;
              }
              bool = true;
              localLowEndPerfBean.b = bool;
              if (f3 <= Math.random()) {
                break label549;
              }
              bool = true;
              localLowEndPerfBean.c = bool;
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
    return this.h ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LowEndPerfBean{mDisablePreloadProcess=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",mDisablePredownload=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",mDisableGetTroopList=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",mEnableAutomatorDelay=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",mUserRatio=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",mExtraSteps=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",mPredownLoadWhiteList=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",mUseApmConfig=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",mSuspend_Thread=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",mFake_Suspend_Thread = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",mSuspendWhiteListThreadOnly = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.LowEndPerfBean
 * JD-Core Version:    0.7.0.1
 */