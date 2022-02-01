package com.tencent.mobileqq.msf.core.d;

import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qphone.base.util.c;
import java.util.ArrayList;
import java.util.HashMap;

public class a
{
  public static final String a = "BigTReportUtil";
  public static final String b = "dc04272";
  
  private static String a()
  {
    int i = c.b();
    long l = c.c() / 1024L / 1024L;
    Object localObject3 = c.d();
    Object localObject2 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkOperator();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = String.format("%.2f", new Object[] { Double.valueOf(c.f()) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(";");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(";");
    ((StringBuilder)localObject2).append(localObject3[0]);
    ((StringBuilder)localObject2).append(";");
    ((StringBuilder)localObject2).append(localObject3[1]);
    ((StringBuilder)localObject2).append(";");
    ((StringBuilder)localObject2).append(((String)localObject1).replaceAll(";", ""));
    ((StringBuilder)localObject2).append(";");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(";");
    ((StringBuilder)localObject2).append(c.b);
    ((StringBuilder)localObject2).append(";");
    ((StringBuilder)localObject2).append(c.c);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getExtraDeviceInfo=");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("BigTReportUtil", 2, ((StringBuilder)localObject3).toString());
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    String str = NetConnInfoCenter.getSystemNetStateString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime());
    localStringBuilder.append("|");
    localStringBuilder.append(BaseApplication.getContext().getAppId());
    localStringBuilder.append("|");
    localStringBuilder.append("android");
    localStringBuilder.append("|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString6);
    localStringBuilder.append("|");
    localStringBuilder.append(c.a());
    localStringBuilder.append("|");
    localStringBuilder.append("|");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("|");
    localStringBuilder.append(ROMUtil.getRomDetailInfo());
    localStringBuilder.append("|");
    localStringBuilder.append(paramString7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString8);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString9);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString10);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString11);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString12);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString13);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString14);
    localStringBuilder.append("|");
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getDC04272ReportDetail=");
      paramString2.append(paramString1);
      QLog.d("BigTReportUtil", 2, paramString2.toString());
    }
    return paramString1;
  }
  
  public static void a(MsfCore paramMsfCore, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(paramString2.getBytes("UTF-8"));
      paramString2 = new HashMap();
      paramString2.put(paramString1, localArrayList);
      paramMsfCore.configManager.a(new HashMap(paramString2), "");
      return;
    }
    catch (Exception paramMsfCore)
    {
      paramMsfCore.printStackTrace();
    }
  }
  
  public static void a(MsfCore paramMsfCore, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    String str = a();
    a(paramMsfCore, "dc04272", a(paramMsfCore.getMainAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, str, "", "", "", "", "", "", ""));
  }
  
  public static void a(MsfCore paramMsfCore, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    String str = a();
    a(paramMsfCore, "dc04272", a(paramMsfCore.getMainAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, str, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.a
 * JD-Core Version:    0.7.0.1
 */