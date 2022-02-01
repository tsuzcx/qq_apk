package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class b
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  private static final String g = "QualityIpv6TestReport";
  private static final String h = "EvtIpv6QualityReport";
  
  public static b a()
  {
    return b.a.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, f.b paramb, String paramString1, String paramString2)
  {
    try
    {
      if (k.d.getStatReporter() != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("result", String.valueOf(paramInt1));
        localHashMap.put("clientIpFamily", String.valueOf(paramInt2));
        localHashMap.put("clientNetType", String.valueOf(paramInt3));
        localHashMap.put("serverIpFamily", String.valueOf(paramInt4));
        localHashMap.put("testType", String.valueOf(paramb));
        localHashMap.put("domain", paramString1);
        localHashMap.put("nat64Prefix", paramString2);
        localHashMap.put("apn", NetConnInfoCenter.getCurrentAPN());
        localHashMap.put("imsi", o.e());
        localHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("deviceBrand", Build.BRAND);
        localHashMap.put("deviceModel", Build.MODEL);
        if (QLog.isDebugVersion())
        {
          StringBuilder localStringBuilder = new StringBuilder("reportQualityTest result=");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", clientIpFamily=");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(", clientNetType=");
          localStringBuilder.append(paramInt3);
          localStringBuilder.append(", serverIpFamily=");
          localStringBuilder.append(paramInt4);
          localStringBuilder.append(", testType=");
          localStringBuilder.append(paramb);
          localStringBuilder.append(", domain=");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(", nat64Prefix=");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(", apn=");
          localStringBuilder.append(NetConnInfoCenter.getCurrentAPN());
          localStringBuilder.append(", imsi=");
          localStringBuilder.append(o.e());
          localStringBuilder.append(", os=");
          localStringBuilder.append(Build.VERSION.SDK_INT);
          localStringBuilder.append(", brand=");
          localStringBuilder.append(Build.BRAND);
          localStringBuilder.append(", model=");
          localStringBuilder.append(Build.MODEL);
          QLog.d("QualityIpv6TestReport", 4, localStringBuilder.toString());
        }
        k.d.getStatReporter().a("EvtIpv6QualityReport", true, 0L, 0L, localHashMap, false, false);
        return;
      }
    }
    catch (Throwable paramb)
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportQualityTest exception=");
      paramString1.append(paramb);
      QLog.d("QualityIpv6TestReport", 1, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.b
 * JD-Core Version:    0.7.0.1
 */