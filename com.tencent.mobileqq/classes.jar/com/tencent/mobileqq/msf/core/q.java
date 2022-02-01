package com.tencent.mobileqq.msf.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class q
{
  private static final String a = "MSFConfigManager";
  private static final String b = "msf_config";
  private static final String c = "manager_config";
  private static final String d = "isIPCDivideToTransportEnable";
  private static final String e = "isSleepThreadWhenIPCBlockEnable";
  private static final String f = "isSendQuickHBByDeepSleepEnable";
  private static final String g = "isMultiChannelReportEnable";
  private AtomicBoolean h = new AtomicBoolean(a("isIPCDivideToTransportEnable", false));
  private AtomicBoolean i = new AtomicBoolean(a("isSleepThreadWhenIPCBlockEnable", false));
  private AtomicBoolean j = new AtomicBoolean(a("isSendQuickHBByDeepSleepEnable", true));
  private AtomicBoolean k = new AtomicBoolean(a("isMultiChannelReportEnable", true));
  
  public static q a()
  {
    return q.a.a();
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
      a(paramToServiceMsg, (JSONObject)localObject, this.h, "isIPCDivideToTransportEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.i, "isSleepThreadWhenIPCBlockEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.j, "isSendQuickHBByDeepSleepEnable");
      a(paramToServiceMsg, (JSONObject)localObject, this.k, "isMultiChannelReportEnable");
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
    return this.h.get();
  }
  
  public boolean c()
  {
    return this.i.get();
  }
  
  public boolean d()
  {
    return this.j.get();
  }
  
  public boolean e()
  {
    return this.k.get();
  }
  
  public String toString()
  {
    return "MSFConfigManager{isIPCDivideToTransportEnable=" + this.h + ", isSleepThreadWhenIPCBlockEnable=" + this.i + ", isSendQuickHBByDeepSleepEnable=" + this.j + ", isMultiChannelReportEnable=" + this.k + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.q
 * JD-Core Version:    0.7.0.1
 */