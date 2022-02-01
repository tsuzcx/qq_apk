package com.tencent.mobileqq.msf.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class i
{
  private static final String a = "MSFConfigManager";
  private static final String b = "msf_config";
  private static final String c = "manager_config";
  private static final String d = "isIPCDivideToTransportEnable";
  private static final String e = "isSleepThreadWhenIPCBlockEnable";
  private static final String f = "isSendQuickHBByDeepSleepEnable";
  private static final String g = "isSendQuickHBByScreenOnEnable";
  private static final String h = "isMultiChannelReportEnable";
  private static final String i = "isBinderConnectOptEnable";
  private static final String j = "isChangeHuaweiDSCheck";
  private AtomicBoolean k = new AtomicBoolean(a("isIPCDivideToTransportEnable", false));
  private AtomicBoolean l = new AtomicBoolean(a("isSleepThreadWhenIPCBlockEnable", false));
  private AtomicBoolean m = new AtomicBoolean(a("isSendQuickHBByDeepSleepEnable", true));
  private AtomicBoolean n = new AtomicBoolean(a("isSendQuickHBByScreenOnEnable", true));
  private AtomicBoolean o = new AtomicBoolean(a("isMultiChannelReportEnable", true));
  private AtomicBoolean p = new AtomicBoolean(a("isBinderConnectOptEnable", false));
  private AtomicBoolean q = new AtomicBoolean(a("isChangeHuaweiDSCheck", false));
  
  public static i a()
  {
    return i.a.a();
  }
  
  private void a(String paramString1, JSONObject paramJSONObject, AtomicBoolean paramAtomicBoolean, String paramString2)
  {
    if (paramString1.contains(paramString2))
    {
      boolean bool = paramJSONObject.optBoolean(paramString2, paramAtomicBoolean.get());
      paramAtomicBoolean.set(bool);
      b(paramString2, bool);
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return BaseApplication.getContext().getSharedPreferences("msf_config", 4).getBoolean(paramString, paramBoolean);
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    BaseApplication.getContext().getSharedPreferences("msf_config", 4).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = paramToServiceMsg.getAttributes().get("manager_config");
    if ((localObject instanceof String)) {}
    try
    {
      paramToServiceMsg = (String)localObject;
      QLog.d("MSFConfigManager", 1, "updateManagerConfig, common config = " + paramToServiceMsg);
      localObject = new JSONObject((String)localObject);
      a(paramToServiceMsg, (JSONObject)localObject, this.k, "isIPCDivideToTransportEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.l, "isSleepThreadWhenIPCBlockEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.m, "isSendQuickHBByDeepSleepEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.n, "isSendQuickHBByScreenOnEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.o, "isMultiChannelReportEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.p, "isBinderConnectOptEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.q, "isChangeHuaweiDSCheck");
      QLog.d("MSFConfigManager", 1, "after updateManagerConfig, res =" + toString());
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSFConfigManager", 2, "updateManagerConfig throw e", paramToServiceMsg);
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.k.get();
  }
  
  public boolean c()
  {
    return this.l.get();
  }
  
  public boolean d()
  {
    return this.m.get();
  }
  
  public boolean e()
  {
    return this.n.get();
  }
  
  public boolean f()
  {
    return this.o.get();
  }
  
  public boolean g()
  {
    return this.p.get();
  }
  
  public boolean h()
  {
    return this.q.get();
  }
  
  public String toString()
  {
    return "MSFConfigManager{isIPCDivideToTransportEnable=" + this.k + ", isSleepThreadWhenIPCBlockEnable=" + this.l + ", isSendQuickHBByDeepSleepEnable=" + this.m + ", isSendQuickHBByScreenOnEnable=" + this.n + ", isMultiChannelReportEnable=" + this.o + ", isBinderConnectOptEnable=" + this.p + ", isChangeHuaweiDSCheck=" + this.q + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.i
 * JD-Core Version:    0.7.0.1
 */