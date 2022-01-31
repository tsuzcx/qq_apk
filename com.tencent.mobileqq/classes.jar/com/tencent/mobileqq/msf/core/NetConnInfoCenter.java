package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.push.f;
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
  public static byte[] GUID;
  public static String RDMREPORT_INTENT;
  public static final String TAG = "NetConnInfoCenter";
  public static boolean isUseNewImpl = true;
  public static MsfCore msfCore;
  public static boolean needWifiAuth;
  private static AtomicBoolean netSupport = new AtomicBoolean(false);
  public static int sAppTimeoutConfig;
  private static boolean sHasBooted;
  public static long servetTimeSecondInterv;
  public static volatile int socketConnState = 0;
  
  static
  {
    RDMREPORT_INTENT = "com.tencent.mobileqq.rdm.report";
    GUID = new byte[0];
    sAppTimeoutConfig = 2000;
  }
  
  public static void callQQProcess(String paramString)
  {
    int i = 0;
    try
    {
      if (f.r)
      {
        long l = com.tencent.mobileqq.msf.core.a.a.W();
        Object localObject = new Intent(paramString);
        paramString = f.s;
        if (msfCore != null) {
          i = msfCore.getUinPushStatus(paramString);
        }
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("istatus", i);
        ((Intent)localObject).putExtra("gatewayip", af.n());
        if (l > 0L)
        {
          localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
          ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.a.a.W(), (PendingIntent)localObject);
          QLog.d("NetConnInfoCenter", 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(paramString) + " delayed: " + l);
        }
        for (;;)
        {
          f.r = false;
          return;
          BaseApplication.getContext().sendBroadcast((Intent)localObject);
          QLog.d("NetConnInfoCenter", 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(paramString) + " right now");
        }
      }
      QLog.d("NetConnInfoCenter", 1, "not need send bootAction for QQ");
    }
    catch (Exception paramString)
    {
      QLog.d("NetConnInfoCenter", 1, "send bootAction for QQ error " + paramString);
      return;
    }
  }
  
  public static void checkConnInfo()
  {
    v.a().a(BaseApplication.getContext(), null, false);
  }
  
  public static void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    v.a().a(paramContext, paramNetworkInfo, paramBoolean);
  }
  
  public static void checkConnInfo(Context paramContext, boolean paramBoolean)
  {
    v.a().a(paramContext, null, paramBoolean);
  }
  
  public static void checkRecordTime()
  {
    v.a().z();
  }
  
  public static int getActiveNetworkType()
  {
    return v.a().x();
  }
  
  public static int getCdmaStrength()
  {
    return v.a().B();
  }
  
  public static String getCurrentAPN()
  {
    return v.a().u();
  }
  
  public static int getGsmStrength()
  {
    return v.a().C();
  }
  
  public static String getLastWifiSSID()
  {
    return v.a().r();
  }
  
  public static int getMobileNetworkType()
  {
    return v.a().t();
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
    return " SignalStrengths wifi:" + getWifiStrength() + " gsm:" + getGsmStrength() + " cdma:" + getCdmaStrength() + " net:" + getSystemNetworkType();
  }
  
  public static int getSystemNetState()
  {
    return v.a().l();
  }
  
  public static String getSystemNetStateString()
  {
    return com.tencent.mobileqq.msf.sdk.a.a.a(getSystemNetState());
  }
  
  public static int getSystemNetworkType()
  {
    return v.a().w();
  }
  
  public static int getWifiStrength()
  {
    return v.a().A();
  }
  
  public static void handleGetServerTimeResp(long paramLong)
  {
    v.a().a(paramLong);
  }
  
  public static void init(MsfCore paramMsfCore)
  {
    msfCore = paramMsfCore;
    v.a().a(paramMsfCore);
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
      throw new AssertionError();
    }
  }
  
  public static boolean isMobileConn()
  {
    return v.a().p();
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
    return v.a().o();
  }
  
  public static boolean isWifiOrMobileConn()
  {
    return v.a().n();
  }
  
  public static void onConnClosed(com.tencent.qphone.base.a parama)
  {
    v.a().a(parama);
  }
  
  public static void onConnOpened(String paramString1, String paramString2)
  {
    v.a().c(paramString1, paramString2);
  }
  
  public static void onOepnConnAllFailed()
  {
    v.a().q();
  }
  
  public static void onRecvFirstResp()
  {
    v.a().s();
  }
  
  public static void setLastConnSuccWithoutNet()
  {
    v.a().k();
  }
  
  public static void setNeedWifiAuth(boolean paramBoolean)
  {
    needWifiAuth = paramBoolean;
  }
  
  public static void setNetSupport(boolean paramBoolean)
  {
    netSupport.set(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("NetConnInfoCenter", 2, "setNetSupport " + paramBoolean);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("NetConnInfoCenter", 2, "receive broadcast intent == null return");
      }
    }
    do
    {
      do
      {
        do
        {
          boolean bool1;
          do
          {
            do
            {
              return;
              QLog.d("NetConnInfoCenter", 1, "receive broadcast " + paramIntent);
              if (paramIntent.getAction() != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("NetConnInfoCenter", 2, "receive broadcast intent.getAction() == null return");
            return;
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
            bool1 = bool2;
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
            if (!MsfService.inited)
            {
              MsfService.sIsCreatedByAutoBoot = bool1;
              paramContext.startService(new Intent(paramContext, MsfService.class));
            }
            if (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
              break;
            }
            try
            {
              paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
              if (QLog.isColorLevel()) {
                QLog.i("NetConnInfoCenter", 2, "onReceive CONNECTIVITY_CHANGE, extra: " + paramIntent);
              }
              Intent localIntent = new Intent();
              localIntent.setAction("com.tencent.mobileqq.msf.bd.netchange");
              localIntent.setPackage("com.tencent.mobileqq");
              localIntent.putExtra("networkInfo", paramIntent);
              paramContext.sendBroadcast(localIntent);
              checkConnInfo(paramContext, paramIntent, true);
              x.a().d();
              return;
            }
            catch (Exception paramContext) {}
          } while (!QLog.isColorLevel());
          QLog.d("NetConnInfoCenter", 2, paramContext.toString(), paramContext);
          return;
          if ((paramIntent.getAction().equals("android.intent.action.TIME_SET")) || (paramIntent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NetConnInfoCenter", 2, "recv broadcast " + paramIntent.getAction());
            }
            v.a().y();
            return;
          }
          if (!bool1) {
            break;
          }
          com.tencent.mobileqq.msf.core.a.a.a(true);
          com.tencent.mobileqq.msf.core.c.j.K = true;
        } while (!QLog.isColorLevel());
        QLog.d("NetConnInfoCenter", 2, "set StatReporter.needReportBooting true");
        return;
        if (!paramIntent.getAction().equals(RDMREPORT_INTENT)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NetConnInfoCenter", 2, "receive reportRDM call");
      return;
    } while (!"android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent.getAction()));
    if (QLog.isColorLevel()) {
      QLog.i("NetConnInfoCenter", 2, "receive WIFI_STATE_CHANGED_ACTION");
    }
    x.a().a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.NetConnInfoCenter
 * JD-Core Version:    0.7.0.1
 */