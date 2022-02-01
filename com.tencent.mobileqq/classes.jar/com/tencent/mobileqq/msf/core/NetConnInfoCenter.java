package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetConnInfoCenter
  extends BroadcastReceiver
{
  public static final String ACTION_FILTER_MSF_NET_CHANGE = "com.tencent.mobileqq.msf.bd.netchange";
  public static byte[] GUID = new byte[0];
  public static String RDMREPORT_INTENT = "com.tencent.mobileqq.rdm.report";
  public static final String TAG = "NetConnInfoCenter";
  public static boolean isUseNewImpl = true;
  public static MsfCore msfCore;
  public static boolean needWifiAuth;
  private static AtomicBoolean netSupport = new AtomicBoolean(false);
  public static int sAppTimeoutConfig;
  private static boolean sHasBooted = false;
  public static NetConnInfoCenter sNetConnIfnoCenter = new NetConnInfoCenter();
  public static long servetTimeSecondInterv;
  public static volatile int socketConnState;
  
  static
  {
    sAppTimeoutConfig = 2000;
  }
  
  public static void callQQProcess(String paramString)
  {
    for (;;)
    {
      try
      {
        if (g.t)
        {
          long l = com.tencent.mobileqq.msf.core.a.a.X();
          localObject = new Intent(paramString);
          paramString = g.u;
          if (msfCore != null)
          {
            i = msfCore.getUinPushStatus(paramString);
            ((Intent)localObject).putExtra("uin", paramString);
            ((Intent)localObject).putExtra("istatus", i);
            ((Intent)localObject).putExtra("gatewayip", ac.q());
            ((Intent)localObject).setPackage(BaseApplication.getContext().getPackageName());
            if (l > 0L)
            {
              localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
              ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.a.a.X(), (PendingIntent)localObject);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("send bootAction for QQ ");
              ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
              ((StringBuilder)localObject).append(" delayed: ");
              ((StringBuilder)localObject).append(l);
              QLog.d("NetConnInfoCenter", 1, ((StringBuilder)localObject).toString());
            }
            else
            {
              BaseApplication.getContext().sendBroadcast((Intent)localObject);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("send bootAction for QQ ");
              ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
              ((StringBuilder)localObject).append(" right now");
              QLog.d("NetConnInfoCenter", 1, ((StringBuilder)localObject).toString());
            }
            g.t = false;
          }
        }
        else
        {
          QLog.d("NetConnInfoCenter", 1, "not need send bootAction for QQ");
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send bootAction for QQ error ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("NetConnInfoCenter", 1, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 0;
    }
  }
  
  public static void checkConnInfo()
  {
    s.a().a(BaseApplication.getContext(), null, false);
  }
  
  public static void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    s.a().a(paramContext, paramNetworkInfo, paramBoolean);
  }
  
  public static void checkConnInfo(Context paramContext, boolean paramBoolean)
  {
    s.a().a(paramContext, null, paramBoolean);
  }
  
  public static void checkRecordTime()
  {
    s.a().z();
  }
  
  public static int getActiveNetIpFamily(boolean paramBoolean)
  {
    return s.a().c(paramBoolean);
  }
  
  public static int getActiveNetworkType()
  {
    return s.a().x();
  }
  
  public static int getCdmaStrength()
  {
    return s.a().B();
  }
  
  public static String getCurrentAPN()
  {
    return s.a().u();
  }
  
  public static String getCurrentAPN(boolean paramBoolean)
  {
    return s.a().b(paramBoolean);
  }
  
  public static String getCurrentSSID()
  {
    return s.a().q();
  }
  
  public static String getCurrentSSID(boolean paramBoolean)
  {
    return s.a().a(paramBoolean);
  }
  
  public static int getGsmStrength()
  {
    return s.a().C();
  }
  
  public static String getLastWifiSSID()
  {
    return s.a().r();
  }
  
  public static int getMobileNetworkType()
  {
    return s.a().t();
  }
  
  public static long getServerTime()
  {
    return System.currentTimeMillis() / 1000L + servetTimeSecondInterv;
  }
  
  public static long getServerTimeMillis()
  {
    return System.currentTimeMillis() + servetTimeSecondInterv * 1000L;
  }
  
  public static String getSignalStrengthsLog()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" SignalStrengths wifi:");
    localStringBuilder.append(getWifiStrength());
    localStringBuilder.append(" gsm:");
    localStringBuilder.append(getGsmStrength());
    localStringBuilder.append(" cdma:");
    localStringBuilder.append(getCdmaStrength());
    localStringBuilder.append(" net:");
    localStringBuilder.append(getSystemNetworkType());
    return localStringBuilder.toString();
  }
  
  public static int getSystemNetState()
  {
    return s.a().k();
  }
  
  public static String getSystemNetStateString()
  {
    return com.tencent.mobileqq.msf.sdk.a.a.a(getSystemNetState());
  }
  
  public static int getSystemNetworkType()
  {
    return s.a().w();
  }
  
  public static int getWifiStrength()
  {
    return s.a().A();
  }
  
  public static void handleGetServerTimeResp(long paramLong)
  {
    s.a().a(paramLong);
  }
  
  public static void init(MsfCore paramMsfCore)
  {
    msfCore = paramMsfCore;
    s.a().a(paramMsfCore);
    if (Build.VERSION.SDK_INT >= 24)
    {
      int i = BaseApplication.getContext().getApplicationInfo().targetSdkVersion;
      if (i >= 24)
      {
        paramMsfCore = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        BaseApplication.getContext().registerReceiver(sNetConnIfnoCenter, paramMsfCore);
        if ((Build.VERSION.SDK_INT >= 26) && (i >= 26))
        {
          paramMsfCore = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
          BaseApplication.getContext().registerReceiver(sNetConnIfnoCenter, paramMsfCore);
        }
      }
    }
  }
  
  public static InetAddress intToInetAddress(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(new byte[] { i, j, k, m });
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      label66:
      break label66;
    }
    throw new AssertionError();
  }
  
  public static boolean isMobileConn()
  {
    return s.a().o();
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static boolean isNeedWifiAuth()
  {
    return needWifiAuth;
  }
  
  public static boolean isNetSupport()
  {
    return netSupport.get();
  }
  
  public static boolean isWifiConn()
  {
    return s.a().n();
  }
  
  public static boolean isWifiOrMobileConn()
  {
    return s.a().m();
  }
  
  public static void onConnClosed(com.tencent.qphone.base.a parama)
  {
    s.a().a(parama);
  }
  
  public static void onConnOpened(String paramString1, String paramString2)
  {
    s.a().c(paramString1, paramString2);
  }
  
  public static void onOepnConnAllFailed()
  {
    s.a().p();
  }
  
  public static void onRecvFirstResp()
  {
    s.a().s();
  }
  
  public static void setLastConnSuccWithoutNet()
  {
    s.a().j();
  }
  
  public static void setNeedWifiAuth(boolean paramBoolean)
  {
    needWifiAuth = paramBoolean;
  }
  
  public static void setNetSupport(boolean paramBoolean)
  {
    netSupport.set(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNetSupport ");
      localStringBuilder.append(paramBoolean);
      QLog.d("NetConnInfoCenter", 2, localStringBuilder.toString());
    }
  }
  
  public static void startOrBindService(Intent paramIntent)
  {
    try
    {
      BaseApplication.getContext().startService(paramIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("NetConnInfoCenter", 1, "init msf startService exception:", localException);
      try
      {
        BaseApplication.getContext().bindService(paramIntent, new r(), 1);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.d("NetConnInfoCenter", 1, "init msf bindService exception:", paramIntent);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetConnInfoCenter", 2, "receive broadcast intent == null return");
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive broadcast ");
    ((StringBuilder)localObject).append(paramIntent);
    ((StringBuilder)localObject).append(", init = ");
    ((StringBuilder)localObject).append(MsfService.inited);
    QLog.d("NetConnInfoCenter", 1, ((StringBuilder)localObject).toString());
    if (paramIntent.getAction() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetConnInfoCenter", 2, "receive broadcast intent.getAction() == null return");
      }
      return;
    }
    if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.receiveofflinepush"))
    {
      msfCore.pushManager.n();
      return;
    }
    if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.offlinepushclearall"))
    {
      msfCore.pushManager.i();
      return;
    }
    if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.receiveofflinepushav"))
    {
      msfCore.pushManager.o();
      return;
    }
    if (paramIntent.getAction().equals("com.tencent.mobileqq.msf.offlinepushclearallav"))
    {
      msfCore.pushManager.j();
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!sHasBooted)
    {
      sHasBooted = true;
      if (SystemClock.elapsedRealtime() >= 300000L)
      {
        bool1 = bool2;
        if (!"android.intent.action.MY_PACKAGE_REPLACED".equals(paramIntent.getAction())) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if ((!MsfService.inited) && ("1".equals(paramContext.getSharedPreferences("c_profile_sharepreference", 4).getString("privacypolicy_state", "0"))))
    {
      MsfService.sIsCreatedByAutoBoot = bool1;
      localObject = new Intent(paramContext, MsfService.class);
      ((Intent)localObject).putExtra("key_action_name", paramIntent.getAction());
      startOrBindService((Intent)localObject);
    }
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      try
      {
        paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceive CONNECTIVITY_CHANGE, extra: ");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.i("NetConnInfoCenter", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.msf.bd.netchange");
        ((Intent)localObject).setPackage("com.tencent.mobileqq");
        ((Intent)localObject).putExtra("networkInfo", paramIntent);
        paramContext.sendBroadcast((Intent)localObject);
        checkConnInfo(paramContext, paramIntent, true);
        u.a().d();
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("NetConnInfoCenter", 2, paramContext.toString(), paramContext);
    }
    else if ((!paramIntent.getAction().equals("android.intent.action.TIME_SET")) && (!paramIntent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")))
    {
      if (bool1)
      {
        com.tencent.mobileqq.msf.core.a.a.a(true);
        com.tencent.mobileqq.msf.core.c.j.S = true;
        if (QLog.isColorLevel()) {
          QLog.d("NetConnInfoCenter", 2, "set StatReporter.needReportBooting true");
        }
      }
      else if (paramIntent.getAction().equals(RDMREPORT_INTENT))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NetConnInfoCenter", 2, "receive reportRDM call");
        }
      }
      else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NetConnInfoCenter", 2, "receive WIFI_STATE_CHANGED_ACTION");
        }
        u.a().a(paramIntent);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("recv broadcast ");
        paramContext.append(paramIntent.getAction());
        QLog.d("NetConnInfoCenter", 2, paramContext.toString());
      }
      s.a().y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.NetConnInfoCenter
 * JD-Core Version:    0.7.0.1
 */