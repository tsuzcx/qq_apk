package com.tencent.mobileqq.msf.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class i
{
  private static final String a = "MSFConfigManager";
  private static final String b = "msf_config";
  private static final int c = 12;
  private static final int d = 2;
  private static final String e = "manager_config";
  private static final String f = "isIPCDivideToTransportEnable";
  private static final String g = "isSleepThreadWhenIPCBlockEnable";
  private static final String h = "isSendQuickHBByDeepSleepEnable";
  private static final String i = "isSendQuickHBByScreenOnEnable";
  private static final String j = "isMultiChannelReportEnable";
  private static final String k = "isBinderConnectOptEnable";
  private static final String l = "isChangeHuaweiDSCheck";
  private static final String m = "udpSendSwitchOn";
  private static final String n = "udpMaxRetryCount";
  private static final String o = "udpSendTimeout";
  private static final String p = "deepSleepDetectInterval";
  private static final int q = 120;
  private final AtomicInteger A = new AtomicInteger(a("udpSendTimeout", 2));
  private final AtomicInteger B = new AtomicInteger(a("deepSleepDetectInterval", 120));
  private AtomicBoolean r = new AtomicBoolean(a("isIPCDivideToTransportEnable", false));
  private AtomicBoolean s = new AtomicBoolean(a("isSleepThreadWhenIPCBlockEnable", false));
  private AtomicBoolean t = new AtomicBoolean(a("isSendQuickHBByDeepSleepEnable", true));
  private AtomicBoolean u = new AtomicBoolean(a("isSendQuickHBByScreenOnEnable", true));
  private AtomicBoolean v = new AtomicBoolean(a("isMultiChannelReportEnable", true));
  private AtomicBoolean w = new AtomicBoolean(a("isBinderConnectOptEnable", false));
  private AtomicBoolean x = new AtomicBoolean(a("isChangeHuaweiDSCheck", false));
  private final AtomicBoolean y = new AtomicBoolean(a("udpSendSwitchOn", false));
  private final AtomicInteger z = new AtomicInteger(a("udpMaxRetryCount", 12));
  
  private int a(String paramString, int paramInt)
  {
    return BaseApplication.getContext().getSharedPreferences("msf_config", 4).getInt(paramString, paramInt);
  }
  
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
  
  private void a(String paramString1, JSONObject paramJSONObject, AtomicInteger paramAtomicInteger, String paramString2)
  {
    if (paramString1.contains(paramString2))
    {
      int i1 = paramJSONObject.optInt(paramString2, paramAtomicInteger.get());
      paramAtomicInteger.set(i1);
      b(paramString2, i1);
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return BaseApplication.getContext().getSharedPreferences("msf_config", 4).getBoolean(paramString, paramBoolean);
  }
  
  private void b(String paramString, int paramInt)
  {
    BaseApplication.getContext().getSharedPreferences("msf_config", 4).edit().putInt(paramString, paramInt).apply();
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    BaseApplication.getContext().getSharedPreferences("msf_config", 4).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = paramToServiceMsg.getAttributes().get("manager_config");
    if ((localObject instanceof String)) {
      try
      {
        paramToServiceMsg = (String)localObject;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateManagerConfig, common config = ");
        localStringBuilder.append(paramToServiceMsg);
        QLog.d("MSFConfigManager", 1, localStringBuilder.toString());
        localObject = new JSONObject((String)localObject);
        a(paramToServiceMsg, (JSONObject)localObject, this.r, "isIPCDivideToTransportEnable");
        a(paramToServiceMsg, (JSONObject)localObject, this.s, "isSleepThreadWhenIPCBlockEnable");
        a(paramToServiceMsg, (JSONObject)localObject, this.t, "isSendQuickHBByDeepSleepEnable");
        a(paramToServiceMsg, (JSONObject)localObject, this.u, "isSendQuickHBByScreenOnEnable");
        a(paramToServiceMsg, (JSONObject)localObject, this.v, "isMultiChannelReportEnable");
        a(paramToServiceMsg, (JSONObject)localObject, this.w, "isBinderConnectOptEnable");
        a(paramToServiceMsg, (JSONObject)localObject, this.x, "isChangeHuaweiDSCheck");
        a(paramToServiceMsg, (JSONObject)localObject, this.y, "udpSendSwitchOn");
        a(paramToServiceMsg, (JSONObject)localObject, this.z, "udpMaxRetryCount");
        a(paramToServiceMsg, (JSONObject)localObject, this.A, "udpSendTimeout");
        a(paramToServiceMsg, (JSONObject)localObject, this.B, "deepSleepDetectInterval");
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSFConfigManager", 2, "updateManagerConfig throw e", paramToServiceMsg);
        }
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("after updateManagerConfig, res =");
    paramToServiceMsg.append(toString());
    QLog.d("MSFConfigManager", 1, paramToServiceMsg.toString());
  }
  
  public int b()
  {
    return this.z.get();
  }
  
  public int c()
  {
    return this.A.get();
  }
  
  public boolean d()
  {
    return this.r.get();
  }
  
  public boolean e()
  {
    return this.s.get();
  }
  
  public boolean f()
  {
    return this.t.get();
  }
  
  public boolean g()
  {
    return this.u.get();
  }
  
  public boolean h()
  {
    return this.v.get();
  }
  
  public boolean i()
  {
    return this.w.get();
  }
  
  public boolean j()
  {
    return this.x.get();
  }
  
  public boolean k()
  {
    return this.y.get();
  }
  
  public int l()
  {
    return this.B.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MSFConfigManager{isIPCDivideToTransportEnable=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", isSleepThreadWhenIPCBlockEnable=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", isSendQuickHBByDeepSleepEnable=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", isSendQuickHBByScreenOnEnable=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", isMultiChannelReportEnable=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", isBinderConnectOptEnable=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", isChangeHuaweiDSCheck=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", udpSendSwitchOn=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", deepSleepDetectInterval=");
    localStringBuilder.append(this.B);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.i
 * JD-Core Version:    0.7.0.1
 */