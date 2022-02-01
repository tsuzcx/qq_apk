package com.tencent.mobileqq.msf.core;

import LBS.LBSInfo;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.qq.jce.wup.UniPacket;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.mobileqq.msf.service.e;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.msf.service.protocol.QQWiFi.WiFiService;
import com.tencent.msf.service.protocol.QQWiFi.a;
import com.tencent.msf.service.protocol.QQWiFi.b;
import com.tencent.msf.service.protocol.QQWiFi.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class ab
{
  public static final int A = 4;
  public static final int B = 5;
  public static final int C = 6;
  public static final int D = 1;
  public static final int E = 2;
  public static final int F = 3;
  static final String G = "health_manager";
  static volatile int H = 0;
  static volatile int I = 0;
  static long J = 0L;
  static final int K = 1200000;
  static SensorManager L = null;
  static boolean M = true;
  static boolean N = false;
  public static int O = 1;
  public static int P = O + 1;
  public static int Q = P + 1;
  static int R = 0;
  static int S = 0;
  static int T = 99999999;
  static int U = 70000;
  static int V = 3000000;
  static volatile int W = 0;
  static volatile int X = 0;
  static volatile int Y = 0;
  static AtomicBoolean Z = new AtomicBoolean(false);
  public static final String a = "mobileqq.service";
  private static BroadcastReceiver aL = new ah();
  static long aa = 0L;
  static long ab = 0L;
  static final String ac = BaseApplication.getContext().getFilesDir() + File.separator + "step.info";
  static JSONObject ad = null;
  static AtomicBoolean ae = new AtomicBoolean(false);
  static final String af = BaseApplication.getContext().getFilesDir() + File.separator + "stepSign.info";
  static final String ag = "step_info";
  static boolean ah = true;
  public static final String ai = "4eY#X@~g.+U)2%$-";
  static volatile boolean aj = false;
  static AtomicBoolean ak = new AtomicBoolean(false);
  static SensorEventListener al = null;
  private static final String am = "QQWiFiScanManager";
  private static ab an;
  public static final String b = "MQQ.QQWiFiMgrServer.QQWiFiMgrObj";
  public static final String c = "AvailQQWiFiForMSF";
  public static final String d = "QQWifiSvc.AvailQQWiFiForMSF";
  public static final String e = "MQQ.WiFiMapServer.WiFiMapObj";
  public static final String f = "getNearbyAvailWiFiInfo";
  public static final String g = "QQWifiSvc.getNearbyAvailWiFiInfo";
  public static final long h = 25000L;
  public static final long i = 21600000L;
  public static final int j = 1001;
  public static final int k = 1003;
  public static final int l = 1004;
  public static final int m = 1007;
  public static final int n = 1008;
  public static final int o = 1009;
  public static final int p = -80;
  public static final int q = 20000;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 4;
  public static final int u = 1;
  public static final int v = -1;
  public static final int w = 0;
  public static final int x = 1;
  public static final int y = 2;
  public static final int z = 3;
  private List aA = Collections.synchronizedList(new ArrayList());
  private List aB = Collections.synchronizedList(new ArrayList());
  private List aC = Collections.synchronizedList(new ArrayList());
  private boolean aD;
  private boolean aE = false;
  private boolean aF = false;
  private boolean aG = false;
  private boolean aH = true;
  private boolean aI = false;
  private int aJ = 1;
  private final BroadcastReceiver aK = new ac(this);
  private MsfCore ao;
  private Context ap = BaseApplication.getContext();
  private ab.a aq = new ab.a(this, null);
  private Notification ar;
  private int as = 0;
  private String at = "";
  private RemoteViews au;
  private LBSInfo av;
  private long aw = 0L;
  private long ax = 0L;
  private long ay = 0L;
  private List az = Collections.synchronizedList(new ArrayList());
  
  public static ab a()
  {
    if (an == null) {
      an = new ab();
    }
    return an;
  }
  
  private String a(Context paramContext, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.aq.r))
    {
      if (QLog.isColorLevel()) {
        QLog.e("health_manager", 2, "getNotNetworkSupportSsidList mControlConfig.noNetSupport is empty");
      }
      return null;
    }
    paramContext = BaseApplication.getContext();
    int i1;
    SharedPreferences localSharedPreferences;
    int i2;
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localSharedPreferences = paramContext.getSharedPreferences("no_network_support_qqwifi", i1);
      paramContext = new StringBuffer();
      try
      {
        localJSONArray1 = new JSONArray(this.aq.r);
        i5 = localJSONArray1.length();
        i1 = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          JSONArray localJSONArray1;
          int i5;
          JSONObject localJSONObject1;
          JSONArray localJSONArray2;
          int i6;
          int i4;
          continue;
          i1 += 1;
        }
      }
      if (i1 < i5)
      {
        localJSONObject1 = localJSONArray1.getJSONObject(i1);
        if ((localJSONObject1 == null) || ((paramBoolean) && (localJSONObject1.optInt("canPush") != 1))) {
          break label276;
        }
        localJSONArray2 = localJSONObject1.optJSONArray("jar");
        i6 = localJSONArray2.length();
        i4 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      int i3 = i4;
      if (i2 < i6)
      {
        JSONObject localJSONObject2 = localJSONArray2.optJSONObject(i2);
        String str = localJSONObject2.optString("pkgid");
        i3 = localJSONObject2.optInt("limitVersion");
        if ((localSharedPreferences.contains(str)) && (localSharedPreferences.getInt(str, 0) > i3)) {
          i3 = 1;
        }
      }
      else
      {
        if (i3 != 0)
        {
          paramContext.append(localJSONObject1.optString("ssid"));
          paramContext.append("|");
          break label276;
          if (paramContext.length() > 0) {
            paramContext.delete(paramContext.length() - 1, paramContext.length());
          }
          return paramContext.toString();
        }
        label276:
        i1 = 0;
        break;
      }
      i2 += 1;
    }
  }
  
  private Map a(Context paramContext)
  {
    try
    {
      paramContext = a(new File(paramContext.getDir("qqwifi_dir", 0), "params_file"));
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
      paramContext = new JSONObject(paramContext);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramContext.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramContext.getString(str));
      }
      return localHashMap;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == P)
    {
      QLog.i("health_manager", 1, "msf ondestory!");
      if (N)
      {
        BaseApplication.getContext().unregisterReceiver(aL);
        N = false;
      }
    }
    do
    {
      Sensor localSensor;
      do
      {
        do
        {
          return;
          if (paramInt != O) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 19);
        L = (SensorManager)BaseApplication.getContext().getSystemService("sensor");
        localSensor = L.getDefaultSensor(19);
      } while (localSensor == null);
      if (!N) {}
      try
      {
        Object localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.ACTION_SHUTDOWN");
        ((IntentFilter)localObject).addAction("MSF_Action_Refresh_Steps");
        BaseApplication.getContext().registerReceiver(aL, (IntentFilter)localObject);
        N = true;
        if (!SignUtils.isSupportKeyStore())
        {
          bool = true;
          aj = bool;
          if (aj) {
            QLog.e("health_manager", 1, "switch to old mode.");
          }
          localObject = new Intent("MSF_Action_Refresh_Steps");
          ((Intent)localObject).setAction("MSF_Action_Refresh_Steps");
          localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
          AlarmManager localAlarmManager = (AlarmManager)BaseApplication.getContext().getSystemService("alarm");
          Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
          localCalendar.set(11, 23);
          localCalendar.set(12, 56);
          localCalendar.set(13, 59);
          localAlarmManager.setRepeating(0, localCalendar.getTimeInMillis(), 86400000L, (PendingIntent)localObject);
          if (ad == null) {
            new Thread(new af()).start();
          }
          al = new ag();
          try
          {
            L.registerListener(al, localSensor, 3, 360000000);
            return;
          }
          catch (Exception localException1)
          {
            QLog.e("health_manager", 1, "Exception:" + localException1.toString());
            return;
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isColorLevel())
          {
            QLog.e("health_manager", 2, "register receiver Exception:" + localException3.toString());
            continue;
            bool = false;
          }
        }
      }
    } while (paramInt != Q);
    if ((H > X) && (H - X < U)) {
      X = H;
    }
    Y += X - W;
    W = X;
    try
    {
      if (ad != null) {
        ad.put("shut_down", f());
      }
      label443:
      QLog.i("health_manager", 1, "system shut down set offset:" + Y + ",step:" + W);
      a(false, null, null);
      return;
    }
    catch (Exception localException2)
    {
      break label443;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = BaseApplication.getContext();
    String str = this.aq.c;
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences(str, i1);
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    paramInt = ((SharedPreferences)localObject).getInt("showQQWiFiNotifyCount", 0);
    ((SharedPreferences)localObject).edit().putInt("showQQWiFiNotifyCount", paramInt + 1).commit();
    return;
    ((SharedPreferences)localObject).edit().putInt("QQWiFiShowRedTouch", paramBundle.getInt("id")).commit();
    return;
    paramInt = ((SharedPreferences)localObject).getInt("showQQWiFiAvailExtend", 0);
    ((SharedPreferences)localObject).edit().putInt("showQQWiFiAvailExtend", paramInt + 1).commit();
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.aq.b) {}
    do
    {
      do
      {
        return;
      } while ((!c(paramInt)) && (!paramBoolean2));
      a(paramInt, paramString, paramBoolean1);
      this.as = paramInt;
      this.at = paramString;
    } while (paramInt == 1008);
    this.aF = true;
  }
  
  private void a(Intent paramIntent, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (this.au == null) {
      this.au = new RemoteViews(BaseApplication.getContext().getPackageName(), BaseApplication.qqWifiLayout);
    }
    Object localObject;
    int i1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.au.setImageViewResource(BaseApplication.qqWifiSettingViewId, BaseApplication.qqWifiSettings);
      this.au.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 8);
      localObject = new Intent("com.tencent.mobileqq.msf.qqwifi.settings");
      ((Intent)localObject).putExtras(new Bundle());
      ((Intent)localObject).addFlags(603979776);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      this.au.setOnClickPendingIntent(BaseApplication.qqWifiSettingViewId, (PendingIntent)localObject);
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label687;
      }
      i1 = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
      i1 = ((SharedPreferences)localObject).getInt("BarOperation_id", 0);
      if (i1 != 0)
      {
        boolean bool = ((SharedPreferences)localObject).getBoolean(this.aq.c + "hasClicked" + i1, false);
        long l1 = ((SharedPreferences)localObject).getLong("BarOperation_expiry", 0L);
        if ((!bool) && (System.currentTimeMillis() < l1 * 1000L))
        {
          int i2 = ((SharedPreferences)localObject).getInt("BarOperation_type", 0);
          localObject = ((SharedPreferences)localObject).getString("BarOperation_url", "");
          Intent localIntent = new Intent("com.tencent.mobileqq.msf.qqwifi.redtouch");
          localIntent.putExtra("type", i2);
          localIntent.putExtra("url", (String)localObject);
          localIntent.putExtra("id", i1);
          localIntent.addFlags(603979776);
          localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, localIntent, 134217728);
          this.au.setOnClickPendingIntent(BaseApplication.qqWifiRedTouchViewId, (PendingIntent)localObject);
          this.au.setImageViewResource(BaseApplication.qqWifiRedTouchViewId, BaseApplication.qqWifiOperation);
          this.au.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 0);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("id", i1);
          a(2, (Bundle)localObject);
        }
      }
    }
    this.au.setImageViewResource(BaseApplication.qqWifiStateIconViewId, paramInt2);
    this.au.setTextViewText(BaseApplication.qqWifiStateTextSingleLine, paramString1);
    this.au.setViewVisibility(BaseApplication.qqWifiTextDoubleLine, 8);
    this.au.setViewVisibility(BaseApplication.qqWifiStateTextSingleLine, 0);
    if (this.ar == null)
    {
      this.ar = new Notification();
      if (Build.VERSION.SDK_INT >= 16) {
        this.ar.priority = 2;
      }
      localObject = this.ar;
      ((Notification)localObject).flags |= 0x20;
      this.ar.contentView = this.au;
    }
    if (paramInt1 == 1008)
    {
      this.ar.flags = 16;
      label527:
      paramIntent.putExtra("param_notifyid", 481);
      paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 481, paramIntent, 0);
      if (BaseApplication.qqWifiNoSignal != paramInt2) {
        break label705;
      }
      this.ar.icon = BaseApplication.qqwifinotifynoneicon;
      label567:
      if (paramString3 == null) {
        break label756;
      }
      this.ar.defaults = 1;
    }
    for (this.ar.tickerText = paramString3;; this.ar.tickerText = "")
    {
      this.ar.contentIntent = paramIntent;
      QQNotificationManager.addChannelIfNeed(this.ar, "CHANNEL_ID_OTHER");
      localQQNotificationManager.notify("QQWiFiScanManager", 481, this.ar);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "type=" + paramInt1 + "," + paramString1 + ", " + paramString2 + "," + paramString3);
      }
      return;
      label687:
      i1 = 0;
      break;
      this.ar.flags = 32;
      break label527;
      label705:
      if (BaseApplication.qqWifiUserful == paramInt2)
      {
        this.ar.icon = BaseApplication.qqwifinotifyusefulicon;
        break label567;
      }
      if (BaseApplication.qqWifiConnecticon3 == paramInt2)
      {
        this.ar.icon = BaseApplication.qqwifinotifyconnectedicon;
        break label567;
      }
      this.ar.icon = paramInt2;
      break label567;
      label756:
      this.ar.defaults = 0;
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    int i2 = 0;
    Object localObject1 = paramSharedPreferences;
    int i1;
    if (paramSharedPreferences == null)
    {
      paramSharedPreferences = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10)
      {
        i1 = 4;
        localObject1 = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
      }
    }
    else if (localObject1 != null)
    {
      paramSharedPreferences = ((SharedPreferences)localObject1).getString("autoconnect_bssids", "");
      if (!TextUtils.isEmpty(paramSharedPreferences))
      {
        localObject1 = paramSharedPreferences.split("\\|");
        if ((localObject1 != null) && (localObject1.length != 0)) {
          break label144;
        }
        this.aC.add(paramSharedPreferences);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "updateConfig, bssidsString=" + paramSharedPreferences + " ssid list=" + this.aC.toString());
      }
      return;
      i1 = 0;
      break;
      label144:
      int i3 = localObject1.length;
      i1 = i2;
      while (i1 < i3)
      {
        Object localObject2 = localObject1[i1];
        this.aC.add(localObject2);
        i1 += 1;
      }
    }
  }
  
  private void a(MsfCore paramMsfCore)
  {
    g();
    paramMsfCore = new IntentFilter();
    paramMsfCore.addAction("android.intent.action.SCREEN_ON");
    paramMsfCore.addAction("android.intent.action.SCREEN_OFF");
    paramMsfCore.addAction("android.net.wifi.SCAN_RESULTS");
    BaseApplication.getContext().registerReceiver(this.aK, paramMsfCore);
    e();
  }
  
  public static void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (((String)localObject).equals("cmd_refresh_steps"))
          {
            if (QLog.isColorLevel()) {
              QLog.i("health_manager", 2, "MSF_Action_Refresh_Steps:" + M);
            }
            if ((!M) && (L != null) && (al != null))
            {
              L.unregisterListener(al);
              L = null;
              al = null;
            }
            if ((!M) || (H <= X) || (H - X > U))
            {
              localObject = u.a(paramToServiceMsg);
              ((FromServiceMsg)localObject).setMsgSuccess();
              if (ad != null) {
                ((FromServiceMsg)localObject).addAttribute("StepInfoJSON", ad.toString());
              }
              e.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject);
              return;
            }
            X = H;
            a(true, paramString, paramToServiceMsg);
            return;
          }
          if (((String)localObject).equals("cmd_health_switch"))
          {
            localObject = u.a(paramToServiceMsg);
            ((FromServiceMsg)localObject).setMsgSuccess();
            boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isOpen", Boolean.valueOf(false))).booleanValue();
            if (QLog.isColorLevel()) {
              QLog.i("health_manager", 2, "Action_Register_Step_Listener:" + bool);
            }
            if (bool) {}
            try
            {
              if (!M)
              {
                M = true;
                a(O);
              }
              for (;;)
              {
                e.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject);
                return;
                M = false;
                if ((L != null) && (al != null))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("health_manager", 2, "step counter off.");
                  }
                  L.unregisterListener(al);
                  L = null;
                  al = null;
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("health_manager", 2, "Exception:" + localException.toString());
                }
                ((FromServiceMsg)localObject).setMsgFail();
              }
            }
          }
          if (!((String)localObject).equals("cmd_update_lastreport_time")) {
            break;
          }
          paramString = paramToServiceMsg.getAttribute("last_report_time");
          if ((paramString instanceof Long)) {
            aa = ((Long)paramString).longValue();
          }
          if (ad.has("isRestart")) {
            ad.remove("isRestart");
          }
          paramString = paramToServiceMsg.getAttribute("has_report_yes");
        } while ((!(paramString instanceof Boolean)) || (!((Boolean)paramString).booleanValue()));
        ad = new JSONObject();
        paramString = String.valueOf(f());
        try
        {
          ad.put(paramString + "_offset", Y);
          ad.put(paramString + "_init", W);
          ad.put(paramString + "_total", X);
          ad.put("isStepCounterEnable", M);
          ad.put("last_report_time", aa);
          return;
        }
        catch (Exception paramString)
        {
          return;
        }
      } while (!((String)localObject).equals("cmd_reset_step"));
      paramString = paramToServiceMsg.getAttribute("server_step");
    } while (!(paramString instanceof Integer));
    int i1 = X;
    int i2 = W;
    int i3 = Y;
    QLog.e("health_manager", 1, "reset by server,local:" + (i1 - i2 + i3) + ",server:" + paramString);
    W = X;
    Y = ((Integer)paramString).intValue();
    a(false, null, null);
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "checkAvailForOperation");
    }
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasIntersection=" + bool);
    }
    if (bool) {
      d(paramArrayList);
    }
    Object localObject = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.c < -80) {
        localIterator.remove();
      } else {
        ((List)localObject).add(locald.b);
      }
    }
    if (!a(this.aA, (List)localObject))
    {
      e(paramArrayList);
      this.aA.clear();
      paramArrayList = ((List)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.aA.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForOperation, isSubset=true");
    }
  }
  
  private void a(List paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.isEmpty()) {
          return;
        }
        paramList = new ArrayList(paramList);
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "startAutoConnect services all avail:" + paramList.toString());
        }
        if (!r())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isEnableAutoconnect false,return");
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel())
        {
          paramList.printStackTrace();
          return;
          paramList = d(paramList);
          if ((paramList == null) || (paramList.isEmpty()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect services empty after filtered,return");
            }
          }
          else if (b(paramList))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in time protected,return");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "startAutoConnect services:" + paramList.toString());
            }
            this.ay = System.currentTimeMillis();
            Intent localIntent = new Intent("com.tencent.mobileqq.msf.qqwifi.autoconnect");
            localIntent.setPackage(BaseApplication.getContext().getPackageName());
            localIntent.putExtra("services", new ArrayList(paramList));
            BaseApplication.getContext().sendBroadcast(localIntent);
          }
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, ToServiceMsg paramToServiceMsg)
  {
    if ((X == 0.0F) || (!Z.get())) {
      return;
    }
    if (ak.get())
    {
      QLog.e("health_manager", 1, "writing file,return");
      return;
    }
    ak.set(true);
    new Thread(new ai(paramBoolean, paramString, paramToServiceMsg)).start();
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    BaseApplication localBaseApplication;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      localBaseApplication = BaseApplication.getContext();
      str = localBaseApplication.getPackageName() + "_preferences";
      if (Build.VERSION.SDK_INT <= 10) {
        break label87;
      }
    }
    label87:
    for (int i1 = 4;; i1 = 0)
    {
      bool = localBaseApplication.getSharedPreferences(str, i1).getBoolean("login_auto" + paramString, false);
      return bool;
    }
  }
  
  private boolean a(List paramList1, List paramList2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList1 != null)
    {
      bool1 = bool2;
      if (paramList2 != null)
      {
        bool1 = bool2;
        if (paramList1.size() > 0)
        {
          Iterator localIterator = paramList2.iterator();
          int i1 = 0;
          while ((localIterator.hasNext()) && (paramList1.contains(localIterator.next()))) {
            i1 += 1;
          }
          bool1 = bool2;
          if (i1 == paramList2.size()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    int i1 = 4;
    int i2 = 0;
    Object localObject;
    switch (paramInt)
    {
    default: 
    case 0: 
    case 2: 
    case 6: 
    case 1: 
      do
      {
        do
        {
          for (;;)
          {
            return;
            File localFile = new File(this.ap.getDir("qqwifi_dir", 0), "enable_file");
            if (localFile.exists()) {
              try
              {
                if (new JSONObject(a(localFile)).has("mIsQQWiFiEnable_" + this.aq.c)) {
                  this.aq.b = false;
                }
                if (QLog.isColorLevel())
                {
                  QLog.d("QQWiFiScanManager", 2, "updateConfig, mIsQQWiFiEnable_" + this.aq.c + "=" + this.aq.b);
                  return;
                }
              }
              catch (Exception localException1) {}
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQWiFiScanManager", 2, "updateConfig, enable_file exception");
        return;
        localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (;;)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
          if (localObject == null) {
            break;
          }
          this.aq.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.aq.c, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "updateConfig, BarSwitch=" + this.aq.d);
          }
          if (this.aq.d != -1) {
            break;
          }
          this.aF = false;
          this.as = 0;
          return;
          i1 = 0;
        }
        localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (;;)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
          this.aq.e = ((SharedPreferences)localObject).getBoolean("availNotificationSwitch", false);
          return;
          i1 = 0;
        }
        localObject = new File(this.ap.getDir("qqwifi_dir", 0), "ssids_file");
      } while (!((File)localObject).exists());
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(a((File)localObject)).getJSONArray("ssidList");
        localObject = "";
        i1 = localJSONArray.length();
        paramInt = i2;
        if (paramInt < localJSONArray.length())
        {
          String str = (String)localObject + localJSONArray.get(paramInt).toString();
          localObject = str;
          if (paramInt >= i1 - 1) {
            break label607;
          }
          localObject = str + "|";
          break label607;
        }
        this.aq.a = ((String)localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQWiFiScanManager", 2, "updateConfig, pattern - " + (String)localObject);
        return;
      }
      catch (Exception localException2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, "updateConfig, ssids_file exception");
      return;
      v();
      return;
      b(null);
      return;
      a(null);
      return;
      label607:
      paramInt += 1;
    }
  }
  
  private void b(SharedPreferences paramSharedPreferences)
  {
    SharedPreferences localSharedPreferences = paramSharedPreferences;
    if (paramSharedPreferences == null)
    {
      paramSharedPreferences = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label112;
      }
    }
    label112:
    for (int i1 = 4;; i1 = 0)
    {
      localSharedPreferences = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
      if (localSharedPreferences != null)
      {
        this.aq.m = localSharedPreferences.getInt("autoconnect_switch_operation" + this.aq.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "updateConfig, AutoSwitch=" + this.aq.m);
        }
      }
      return;
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasIntersection=" + bool);
    }
    if (bool) {
      if (o())
      {
        if (m()) {
          a(1008, "", false, false);
        }
        d(paramArrayList);
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      a(1001, "", false, false);
      break;
      localArrayList = new ArrayList();
      Object localObject2;
      d locald;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist before filter:" + ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if (((d)localObject2).c < -80) {
          ((Iterator)localObject1).remove();
        } else {
          localArrayList.add(((d)localObject2).b);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist after filter:" + ((StringBuilder)localObject1).toString());
        QLog.d("QQWiFiScanManager", 2, "bssidSet:" + localArrayList.toString());
      }
      bool = a(this.az, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, isSubset=" + bool + ", bssidSet.size=" + localArrayList.size());
      }
    } while (bool);
    e(paramArrayList);
    this.az.clear();
    this.az.addAll(localArrayList);
  }
  
  private static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean b(String paramString)
  {
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace("\"", "");
      Pattern localPattern = Pattern.compile(this.aq.a);
      boolean bool2 = localPattern.matcher(paramString).matches();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQWiFiScanManager", 2, "isQQWiFi, " + localPattern + ", " + paramString + ", " + bool2);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private boolean b(List paramList)
  {
    boolean bool2 = false;
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
      boolean bool1 = bool2;
      if (localObject != null)
      {
        long l1 = ((SharedPreferences)localObject).getLong("autoconnect_reference_time", 0L);
        long l2 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "isInAutoconnectIntervalProtected lasttime=" + l1 + " interval=" + l2 + " autoConnectProtectedInterval=" + this.aq.n);
        }
        bool1 = bool2;
        if (l2 < this.aq.n)
        {
          bool1 = bool2;
          if (c(paramList)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
  
  private boolean c(int paramInt)
  {
    if (this.aF)
    {
      if (this.aD) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, not registered.");
      }
    }
    label85:
    label239:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          try
          {
            List localList = ((WifiManager)this.ap.getSystemService("wifi")).getScanResults();
            if (localList != null)
            {
              if (localList.size() > 0) {
                break;
              }
              return false;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQWiFiScanManager", 2, localException.getMessage());
              }
              localObject = null;
            }
          }
        }
        Object localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (int i1 = 4;; i1 = 0)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
          if ((localObject != null) && (!TextUtils.isEmpty(this.aq.c)))
          {
            this.aq.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.aq.c, 0);
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "canPushNotification, BarSwitch=" + this.aq.d);
            }
          }
          if ((!o()) || (paramInt == 1008)) {
            break label239;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQWiFiScanManager", 2, "canPushNotification, bar closed.");
          return false;
        }
        localObject = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (((NetworkInfo)localObject).getType() != 1) || (paramInt != 1001)) {
          break label292;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQWiFiScanManager", 2, "canPushNotification, dont push qqwifi info while wifi is connected");
      return false;
    } while (!a(this.aq.c));
    label292:
    return true;
  }
  
  private boolean c(ArrayList paramArrayList)
  {
    if (this.aB != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.aB.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(((WiFiService)localIterator.next()).wifi.b);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (localHashSet.contains(((d)paramArrayList.next()).b)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean c(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((WiFiService)paramList.next()).wifi.b);
    }
    int i2 = Math.min(Math.min(localArrayList.size(), this.aC.size()), this.aq.o);
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "lastAutoBssids=" + this.aC.toString() + " curSet:" + localArrayList.toString() + " isSubSet= maxAutoConnecttimes=" + this.aq.o + " min=" + i2);
    }
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = (String)localArrayList.get(i1);
      if (this.aC.contains(paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "return true:" + paramList + "has already tryed i=" + i1);
        }
        return true;
      }
      i1 += 1;
    }
    j();
    return false;
  }
  
  private List d(List paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WiFiService localWiFiService = (WiFiService)paramList.next();
      if ((localWiFiService.autoConnFlag == 1) && (localArrayList.size() < this.aq.o)) {
        localArrayList.add(localWiFiService);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "after filtered:" + localArrayList.toString());
    }
    return localArrayList;
  }
  
  private void d(ArrayList paramArrayList)
  {
    if (r())
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.aB.iterator();
      while (localIterator.hasNext())
      {
        WiFiService localWiFiService = (WiFiService)localIterator.next();
        if (localWiFiService.autoConnFlag == 1) {
          localHashSet.add(localWiFiService.wifi.b);
        }
      }
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
      } while (!localHashSet.contains(((d)paramArrayList.next()).b));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasAutoIntersection=" + bool);
      }
      if (bool) {
        a(this.aB);
      }
      return;
    }
  }
  
  private void e(ArrayList paramArrayList)
  {
    try
    {
      this.ax = System.currentTimeMillis();
      int i1 = n();
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "getAvailableQQWifi size:" + paramArrayList.size() + " scanType=" + i1 + " needcallback=" + true);
      }
      Object localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("UTF-8");
      a locala = new a();
      locala.a = paramArrayList;
      locala.b = c.f(this.ap);
      locala.c = "Android";
      locala.d = i1;
      ((UniPacket)localObject).setServantName("MQQ.QQWiFiMgrServer.QQWiFiMgrObj");
      ((UniPacket)localObject).setFuncName("AvailQQWiFiForMSF");
      ((UniPacket)localObject).put("req", locala);
      paramArrayList = ((UniPacket)localObject).encode();
      localObject = new ToServiceMsg("mobileqq.service", this.aq.c, "QQWifiSvc.AvailQQWiFiForMSF");
      ((ToServiceMsg)localObject).setAppId(this.ao.sender.k());
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setTimeout(20000L);
      ((ToServiceMsg)localObject).setNeedCallback(true);
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayList);
      ((ToServiceMsg)localObject).addAttribute("isformsf", Boolean.valueOf(true));
      this.ao.sendSsoMsg((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramArrayList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQWiFiScanManager", 2, "getAvailableQQWifi exp:" + paramArrayList);
    }
  }
  
  static long f()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private void g()
  {
    if (this.aE) {
      return;
    }
    this.aE = true;
    i();
    h();
    v();
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 311	com/tencent/mobileqq/msf/core/ab:ap	Landroid/content/Context;
    //   4: ldc_w 422
    //   7: iconst_0
    //   8: invokevirtual 428	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   11: astore_3
    //   12: new 224	java/io/File
    //   15: dup
    //   16: aload_3
    //   17: ldc_w 1067
    //   20: invokespecial 433	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 4
    //   25: aload 4
    //   27: invokevirtual 1070	java/io/File:exists	()Z
    //   30: ifeq +110 -> 140
    //   33: new 375	org/json/JSONObject
    //   36: dup
    //   37: aload_0
    //   38: aload 4
    //   40: invokevirtual 436	com/tencent/mobileqq/msf/core/ab:a	(Ljava/io/File;)Ljava/lang/String;
    //   43: invokespecial 437	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: new 206	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 1072
    //   56: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   63: getfield 598	com/tencent/mobileqq/msf/core/ab$a:c	Ljava/lang/String;
    //   66: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   75: ifeq +65 -> 140
    //   78: aload_0
    //   79: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   82: iconst_0
    //   83: putfield 626	com/tencent/mobileqq/msf/core/ab$a:b	Z
    //   86: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +51 -> 140
    //   92: ldc 71
    //   94: iconst_2
    //   95: new 206	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 1371
    //   105: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   112: getfield 598	com/tencent/mobileqq/msf/core/ab$a:c	Ljava/lang/String;
    //   115: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 1076
    //   121: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   128: getfield 626	com/tencent/mobileqq/msf/core/ab$a:b	Z
    //   131: invokevirtual 869	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   134: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: new 224	java/io/File
    //   143: dup
    //   144: aload_3
    //   145: ldc_w 1090
    //   148: invokespecial 433	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   151: astore_3
    //   152: aload_3
    //   153: invokevirtual 1070	java/io/File:exists	()Z
    //   156: ifeq +171 -> 327
    //   159: new 375	org/json/JSONObject
    //   162: dup
    //   163: aload_0
    //   164: aload_3
    //   165: invokevirtual 436	com/tencent/mobileqq/msf/core/ab:a	(Ljava/io/File;)Ljava/lang/String;
    //   168: invokespecial 437	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   171: ldc_w 1092
    //   174: invokevirtual 1095	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   177: astore 5
    //   179: aload 5
    //   181: invokevirtual 367	org/json/JSONArray:length	()I
    //   184: istore_2
    //   185: ldc_w 265
    //   188: astore_3
    //   189: iconst_0
    //   190: istore_1
    //   191: iload_1
    //   192: aload 5
    //   194: invokevirtual 367	org/json/JSONArray:length	()I
    //   197: if_icmpge +90 -> 287
    //   200: new 206	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   207: aload_3
    //   208: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 5
    //   213: iload_1
    //   214: invokevirtual 1098	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   217: invokevirtual 837	java/lang/Object:toString	()Ljava/lang/String;
    //   220: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: astore 4
    //   228: aload 4
    //   230: astore_3
    //   231: iload_1
    //   232: iload_2
    //   233: iconst_1
    //   234: isub
    //   235: if_icmpge +25 -> 260
    //   238: new 206	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   245: aload 4
    //   247: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 413
    //   253: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore_3
    //   260: iload_1
    //   261: iconst_1
    //   262: iadd
    //   263: istore_1
    //   264: goto -73 -> 191
    //   267: astore 4
    //   269: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -132 -> 140
    //   275: ldc 71
    //   277: iconst_2
    //   278: ldc_w 1373
    //   281: invokestatic 344	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: goto -144 -> 140
    //   287: aload_0
    //   288: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   291: aload_3
    //   292: putfield 1100	com/tencent/mobileqq/msf/core/ab$a:a	Ljava/lang/String;
    //   295: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +29 -> 327
    //   301: ldc 71
    //   303: iconst_2
    //   304: new 206	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 1375
    //   314: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: return
    //   328: astore_3
    //   329: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -5 -> 327
    //   335: ldc 71
    //   337: iconst_2
    //   338: ldc_w 1377
    //   341: invokestatic 344	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	ab
    //   190	74	1	i1	int
    //   184	51	2	i2	int
    //   11	307	3	localObject1	Object
    //   328	1	3	localException1	Exception
    //   23	223	4	localObject2	Object
    //   267	1	4	localException2	Exception
    //   177	35	5	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   33	140	267	java/lang/Exception
    //   159	185	328	java/lang/Exception
    //   191	228	328	java/lang/Exception
    //   238	260	328	java/lang/Exception
    //   287	327	328	java/lang/Exception
  }
  
  private void i()
  {
    int i2 = 4;
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("Last_Login", i1);
      if (localObject != null)
      {
        this.aq.c = ((SharedPreferences)localObject).getString("uin", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "lastLoginUin = " + this.aq.c);
        }
      }
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label228;
      }
    }
    label228:
    for (int i1 = i2;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
      if (localObject != null)
      {
        this.aq.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.aq.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "initConfig, barOperation=" + this.aq.d);
        }
        a((SharedPreferences)localObject);
        b((SharedPreferences)localObject);
      }
      ((SharedPreferences)localObject).edit().putBoolean("hasPushedAvailNotification", false).commit();
      return;
      i1 = 0;
      break;
    }
  }
  
  private void j()
  {
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().remove("autoconnect_bssids").commit();
      }
      return;
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onAccountChange");
    }
    b(0);
    b(2);
    b(4);
    b(3);
    if ((this.aD) && (this.aF) && (o()))
    {
      QQNotificationManager.getInstance().cancel("QQWiFiScanManager", 481);
      this.aF = false;
      this.as = 0;
    }
  }
  
  private boolean l()
  {
    if (!this.aq.b) {}
    int i1;
    label272:
    do
    {
      do
      {
        return false;
      } while (this.aI);
      Object localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (i1 = 4;; i1 = 0)
      {
        localObject = ((BaseApplication)localObject).getSharedPreferences("Last_Login", i1).getString("uin", "");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!((String)localObject).equals(this.aq.c))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "onAccountChange, " + this.aq.c + ", " + (String)localObject);
          }
          this.aq.c = ((String)localObject);
          k();
        }
        if ((!a(this.aq.c)) || (!this.aH) || (!this.aD)) {
          break;
        }
        localObject = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (((NetworkInfo)localObject).getType() != 1)) {
          break label272;
        }
        WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
        String str = "";
        localObject = str;
        if (localWifiInfo != null)
        {
          localObject = str;
          if (!TextUtils.isEmpty(localWifiInfo.getSSID())) {
            localObject = localWifiInfo.getSSID().replace("\"", "");
          }
        }
        if (b((String)localObject)) {
          break;
        }
        a(1007, (String)localObject, false, false);
        return false;
      }
      if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable()))
      {
        a(1003, "", false, false);
        return false;
      }
      i1 = n();
      if (i1 > 0) {
        break;
      }
    } while (!m());
    return true;
    if ((i1 != 2) || (m())) {}
    while (System.currentTimeMillis() - this.ax >= this.aq.k) {
      return true;
    }
    return false;
  }
  
  private boolean m()
  {
    if (this.aJ == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, availpush=0");
      }
    }
    label96:
    do
    {
      return false;
      Object localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i1 = 4;; i1 = 0)
      {
        localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
        long l1 = ((SharedPreferences)localObject).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
        if (System.currentTimeMillis() - l1 >= 21600000L) {
          break label96;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, time limit");
        return false;
      }
      if (((SharedPreferences)localObject).getBoolean("availNotificationSwitch", false)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, avail switch is turned off");
    return false;
    return true;
  }
  
  private int n()
  {
    int i2 = 0;
    if (!o()) {
      i2 = 1;
    }
    int i1 = i2;
    if (this.aq.g) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (p()) {
      i2 = i1 | 0x4;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "scantype=" + i2);
    }
    return i2;
  }
  
  private boolean o()
  {
    if (this.aq.d == 1) {}
    do
    {
      return false;
      if (this.aq.d == -1) {
        return true;
      }
    } while (this.aq.f);
    return true;
  }
  
  private boolean p()
  {
    if (!this.aq.b) {}
    do
    {
      return false;
      if (this.aq.m == 1) {
        return true;
      }
    } while ((this.aq.m == -1) || (!this.aq.l));
    return true;
  }
  
  private void q()
  {
    if (!this.aq.b) {}
    label904:
    label916:
    label922:
    label925:
    for (;;)
    {
      return;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      int i1;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if (!b(this.ap))
      {
        localObject2 = a(this.ap, o());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = Pattern.compile((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "NotNetworkSupportSsidList pattern: " + (String)localObject2);
          }
          localObject2 = ((WifiManager)this.ap.getSystemService("wifi")).getScanResults();
          if (localObject2 != null)
          {
            localObject3 = new ArrayList();
            i1 = 0;
            while (i1 < ((List)localObject2).size())
            {
              localObject4 = (ScanResult)((List)localObject2).get(i1);
              localObject5 = ((ScanResult)localObject4).SSID.replace("\"", "");
              if (((Pattern)localObject1).matcher((CharSequence)localObject5).matches())
              {
                localObject6 = new d();
                ((d)localObject6).a = ((String)localObject5);
                ((d)localObject6).b = ((ScanResult)localObject4).BSSID;
                ((d)localObject6).c = ((short)((ScanResult)localObject4).level);
                ((ArrayList)localObject3).add(localObject6);
              }
              i1 += 1;
            }
            if (!((ArrayList)localObject3).isEmpty()) {
              if (o())
              {
                localObject1 = BaseApplication.getContext();
                if (Build.VERSION.SDK_INT > 10)
                {
                  i1 = 4;
                  label252:
                  long l1 = ((BaseApplication)localObject1).getSharedPreferences("qqwifi", i1).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
                  if ((l1 > 0L) && (System.currentTimeMillis() - l1 < 21600000L)) {
                    break label922;
                  }
                  a(1008, "", false, true);
                  i1 = 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        label303:
        if ((i1 != 0) || (!l())) {
          break label925;
        }
        this.aw = System.currentTimeMillis();
        localObject5 = new ArrayList();
        if ((!TextUtils.isEmpty(this.aq.a)) || (!TextUtils.isEmpty(this.aq.q))) {
          if (TextUtils.isEmpty(this.aq.a)) {
            break label916;
          }
        }
        for (localObject1 = Pattern.compile(this.aq.a);; localObject1 = null)
        {
          if (!TextUtils.isEmpty(this.aq.q)) {}
          for (localObject2 = Pattern.compile(this.aq.q);; localObject2 = null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "pattern: " + this.aq.a + " reportPattern: " + this.aq.q);
            }
            localObject6 = ((WifiManager)this.ap.getSystemService("wifi")).getScanResults();
            label485:
            ScanResult localScanResult;
            String str;
            if (localObject6 != null)
            {
              i1 = 0;
              if (i1 < ((List)localObject6).size())
              {
                localScanResult = (ScanResult)((List)localObject6).get(i1);
                str = localScanResult.SSID.replace("\"", "");
                if (localObject1 == null) {
                  break label904;
                }
              }
            }
            for (localObject3 = ((Pattern)localObject1).matcher(str);; localObject3 = null)
            {
              if (localObject2 != null) {}
              for (localObject4 = ((Pattern)localObject2).matcher(str);; localObject4 = null)
              {
                if (((localObject3 != null) && (((Matcher)localObject3).matches())) || ((localObject4 != null) && (((Matcher)localObject4).matches())))
                {
                  localObject3 = new d();
                  ((d)localObject3).a = str;
                  ((d)localObject3).b = localScanResult.BSSID;
                  ((d)localObject3).c = ((short)localScanResult.level);
                  ((ArrayList)localObject5).add(localObject3);
                }
                i1 += 1;
                break label485;
                i1 = 0;
                break label252;
                a(1001, "", false, true);
                i1 = 1;
                break label303;
                if (((ArrayList)localObject5).isEmpty())
                {
                  j();
                  localObject1 = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
                  localObject2 = (WifiManager)this.ap.getSystemService("wifi");
                  i1 = ((WifiManager)localObject2).getWifiState();
                  if (localObject1 == null)
                  {
                    if (3 == i1)
                    {
                      a(1003, "", false, false);
                      return;
                    }
                    a(1004, "", false, false);
                    return;
                  }
                  if (3 != i1)
                  {
                    a(1004, "", false, false);
                    return;
                  }
                  if ((((NetworkInfo)localObject1).getType() == 1) || (((NetworkInfo)localObject1).getType() == 9))
                  {
                    localObject3 = ((WifiManager)localObject2).getConnectionInfo();
                    localObject2 = "";
                    localObject1 = localObject2;
                    if (localObject3 != null)
                    {
                      localObject1 = localObject2;
                      if (!TextUtils.isEmpty(((WifiInfo)localObject3).getSSID())) {
                        localObject1 = ((WifiInfo)localObject3).getSSID().replace("\"", "");
                      }
                    }
                    a(1007, (String)localObject1, false, false);
                    return;
                  }
                  a(1009, "", false, false);
                  return;
                }
                i1 = n();
                if (((i1 & 0x1) > 0) || (m()))
                {
                  b((ArrayList)localObject5);
                  return;
                }
                if (((i1 & 0x2) <= 0) && ((i1 & 0x4) <= 0)) {
                  break;
                }
                a((ArrayList)localObject5);
                return;
              }
            }
          }
        }
        i1 = 0;
      }
    }
  }
  
  private boolean r()
  {
    if (this.aI) {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "CurUinQuited,return");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if (System.currentTimeMillis() - this.ay >= 60000L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in frequency limit,return");
          return false;
          if (p()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isOpened false,return");
        return false;
        if (s()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isDeviceSituationOk false,return");
      return false;
      if (t()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isCurNetstatuAvailForAutoconnect false,return");
    return false;
    return true;
  }
  
  private boolean s()
  {
    return this.aH;
  }
  
  private boolean t()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      if (localNetworkInfo.getType() == 1) {
        return false;
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private boolean u()
  {
    if (!this.aG)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "startAccScan");
      }
      new ae(this).start();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "startAccScan, already running.");
    }
    return false;
  }
  
  /* Error */
  private void v()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 311	com/tencent/mobileqq/msf/core/ab:ap	Landroid/content/Context;
    //   5: invokespecial 1500	com/tencent/mobileqq/msf/core/ab:a	(Landroid/content/Context;)Ljava/util/Map;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +999 -> 1009
    //   13: aload_2
    //   14: ldc_w 1502
    //   17: invokeinterface 1505 2 0
    //   22: checkcast 455	java/lang/String
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +52 -> 79
    //   30: aload_0
    //   31: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   34: aload_3
    //   35: invokestatic 1508	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   38: putfield 1510	com/tencent/mobileqq/msf/core/ab$a:h	I
    //   41: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: ldc 71
    //   49: iconst_2
    //   50: new 206	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 1512
    //   60: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   67: getfield 1510	com/tencent/mobileqq/msf/core/ab$a:h	I
    //   70: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_2
    //   80: ldc_w 1514
    //   83: invokeinterface 1505 2 0
    //   88: checkcast 455	java/lang/String
    //   91: astore_3
    //   92: aload_3
    //   93: ifnull +57 -> 150
    //   96: aload_0
    //   97: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   100: aload_3
    //   101: invokestatic 1508	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   104: sipush 1000
    //   107: imul
    //   108: i2l
    //   109: putfield 1516	com/tencent/mobileqq/msf/core/ab$a:i	J
    //   112: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +35 -> 150
    //   118: ldc 71
    //   120: iconst_2
    //   121: new 206	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 1512
    //   131: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   138: getfield 1516	com/tencent/mobileqq/msf/core/ab$a:i	J
    //   141: invokevirtual 1182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_2
    //   151: ldc_w 1518
    //   154: invokeinterface 1505 2 0
    //   159: checkcast 455	java/lang/String
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull +57 -> 221
    //   167: aload_0
    //   168: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   171: aload_3
    //   172: invokestatic 1508	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   175: sipush 1000
    //   178: imul
    //   179: i2l
    //   180: putfield 1520	com/tencent/mobileqq/msf/core/ab$a:j	J
    //   183: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +35 -> 221
    //   189: ldc 71
    //   191: iconst_2
    //   192: new 206	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 1522
    //   202: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   209: getfield 1520	com/tencent/mobileqq/msf/core/ab$a:j	J
    //   212: invokevirtual 1182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_2
    //   222: ldc_w 1524
    //   225: invokeinterface 1505 2 0
    //   230: checkcast 455	java/lang/String
    //   233: astore_3
    //   234: aload_0
    //   235: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   238: astore 4
    //   240: ldc_w 1526
    //   243: aload_3
    //   244: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +763 -> 1010
    //   250: iconst_1
    //   251: istore_1
    //   252: aload 4
    //   254: iload_1
    //   255: putfield 1437	com/tencent/mobileqq/msf/core/ab$a:f	Z
    //   258: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +45 -> 306
    //   264: ldc 71
    //   266: iconst_2
    //   267: new 206	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 1528
    //   277: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   284: getfield 1437	com/tencent/mobileqq/msf/core/ab$a:f	Z
    //   287: invokevirtual 869	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   290: ldc_w 801
    //   293: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_3
    //   297: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_2
    //   307: ldc_w 1530
    //   310: invokeinterface 1505 2 0
    //   315: checkcast 455	java/lang/String
    //   318: astore_3
    //   319: aload_0
    //   320: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   323: astore 4
    //   325: ldc_w 1526
    //   328: aload_3
    //   329: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   332: ifeq +683 -> 1015
    //   335: iconst_1
    //   336: istore_1
    //   337: aload 4
    //   339: iload_1
    //   340: putfield 1431	com/tencent/mobileqq/msf/core/ab$a:g	Z
    //   343: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +45 -> 391
    //   349: ldc 71
    //   351: iconst_2
    //   352: new 206	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 1532
    //   362: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   369: getfield 1431	com/tencent/mobileqq/msf/core/ab$a:g	Z
    //   372: invokevirtual 869	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   375: ldc_w 799
    //   378: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_3
    //   382: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_2
    //   392: ldc_w 1534
    //   395: invokeinterface 1505 2 0
    //   400: checkcast 455	java/lang/String
    //   403: astore_3
    //   404: aload_0
    //   405: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   408: astore 4
    //   410: ldc_w 1526
    //   413: aload_3
    //   414: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   417: ifeq +603 -> 1020
    //   420: iconst_1
    //   421: istore_1
    //   422: aload 4
    //   424: iload_1
    //   425: putfield 1439	com/tencent/mobileqq/msf/core/ab$a:l	Z
    //   428: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +45 -> 476
    //   434: ldc 71
    //   436: iconst_2
    //   437: new 206	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 1536
    //   447: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_0
    //   451: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   454: getfield 1439	com/tencent/mobileqq/msf/core/ab$a:l	Z
    //   457: invokevirtual 869	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: ldc_w 799
    //   463: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_3
    //   467: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload_2
    //   477: ldc_w 1538
    //   480: invokeinterface 1505 2 0
    //   485: checkcast 455	java/lang/String
    //   488: astore_3
    //   489: aload_3
    //   490: ifnull +56 -> 546
    //   493: aload_0
    //   494: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   497: aload_3
    //   498: invokestatic 1542	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   501: ldc2_w 708
    //   504: lmul
    //   505: putfield 1188	com/tencent/mobileqq/msf/core/ab$a:n	J
    //   508: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +35 -> 546
    //   514: ldc 71
    //   516: iconst_2
    //   517: new 206	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 1544
    //   527: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   534: getfield 1188	com/tencent/mobileqq/msf/core/ab$a:n	J
    //   537: invokevirtual 1182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   540: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: aload_2
    //   547: ldc_w 1546
    //   550: invokeinterface 1505 2 0
    //   555: checkcast 455	java/lang/String
    //   558: astore_3
    //   559: aload_3
    //   560: ifnull +52 -> 612
    //   563: aload_0
    //   564: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   567: aload_3
    //   568: invokestatic 1508	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   571: putfield 1239	com/tencent/mobileqq/msf/core/ab$a:o	I
    //   574: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +35 -> 612
    //   580: ldc 71
    //   582: iconst_2
    //   583: new 206	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 1548
    //   593: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_0
    //   597: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   600: getfield 1239	com/tencent/mobileqq/msf/core/ab$a:o	I
    //   603: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_2
    //   613: ldc_w 1546
    //   616: invokeinterface 1505 2 0
    //   621: checkcast 455	java/lang/String
    //   624: astore 4
    //   626: aload 4
    //   628: ifnull +65 -> 693
    //   631: aload_0
    //   632: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   635: astore 4
    //   637: aload_3
    //   638: ldc_w 1526
    //   641: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +381 -> 1025
    //   647: iconst_1
    //   648: istore_1
    //   649: aload 4
    //   651: iload_1
    //   652: putfield 1550	com/tencent/mobileqq/msf/core/ab$a:p	Z
    //   655: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +35 -> 693
    //   661: ldc 71
    //   663: iconst_2
    //   664: new 206	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 1552
    //   674: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_0
    //   678: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   681: getfield 1550	com/tencent/mobileqq/msf/core/ab$a:p	Z
    //   684: invokevirtual 869	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: aload_2
    //   694: ldc_w 1554
    //   697: invokeinterface 1505 2 0
    //   702: checkcast 455	java/lang/String
    //   705: astore_3
    //   706: aload_3
    //   707: ifnull +58 -> 765
    //   710: aload_0
    //   711: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   714: aload_3
    //   715: ldc_w 1556
    //   718: ldc_w 265
    //   721: invokevirtual 1559	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   724: putfield 327	com/tencent/mobileqq/msf/core/ab$a:r	Ljava/lang/String;
    //   727: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +35 -> 765
    //   733: ldc 71
    //   735: iconst_2
    //   736: new 206	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 1561
    //   746: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_0
    //   750: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   753: getfield 327	com/tencent/mobileqq/msf/core/ab$a:r	Ljava/lang/String;
    //   756: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_2
    //   766: ldc_w 1563
    //   769: invokeinterface 1505 2 0
    //   774: checkcast 455	java/lang/String
    //   777: astore_2
    //   778: aload_2
    //   779: ifnull +230 -> 1009
    //   782: aload_0
    //   783: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   786: aload_2
    //   787: putfield 1461	com/tencent/mobileqq/msf/core/ab$a:q	Ljava/lang/String;
    //   790: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   793: ifeq +216 -> 1009
    //   796: ldc 71
    //   798: iconst_2
    //   799: new 206	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   806: ldc_w 1565
    //   809: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload_0
    //   813: getfield 318	com/tencent/mobileqq/msf/core/ab:aq	Lcom/tencent/mobileqq/msf/core/ab$a;
    //   816: getfield 1461	com/tencent/mobileqq/msf/core/ab$a:q	Ljava/lang/String;
    //   819: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 803	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: return
    //   829: astore_3
    //   830: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   833: ifeq -792 -> 41
    //   836: ldc 71
    //   838: iconst_2
    //   839: ldc_w 1567
    //   842: aload_3
    //   843: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   846: goto -805 -> 41
    //   849: astore_2
    //   850: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq +156 -> 1009
    //   856: ldc 71
    //   858: iconst_2
    //   859: aload_2
    //   860: invokevirtual 576	java/lang/Exception:toString	()Ljava/lang/String;
    //   863: invokestatic 1572	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: return
    //   867: astore_3
    //   868: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   871: ifeq -759 -> 112
    //   874: ldc 71
    //   876: iconst_2
    //   877: ldc_w 1574
    //   880: aload_3
    //   881: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   884: goto -772 -> 112
    //   887: astore_3
    //   888: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq -670 -> 221
    //   894: ldc 71
    //   896: iconst_2
    //   897: ldc_w 1576
    //   900: aload_3
    //   901: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   904: goto -683 -> 221
    //   907: astore_3
    //   908: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   911: ifeq -403 -> 508
    //   914: ldc 71
    //   916: iconst_2
    //   917: ldc_w 1578
    //   920: aload_3
    //   921: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   924: goto -416 -> 508
    //   927: astore 4
    //   929: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   932: ifeq -358 -> 574
    //   935: ldc 71
    //   937: iconst_2
    //   938: ldc_w 1580
    //   941: aload 4
    //   943: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   946: goto -372 -> 574
    //   949: astore_3
    //   950: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   953: ifeq -298 -> 655
    //   956: ldc 71
    //   958: iconst_2
    //   959: ldc_w 1582
    //   962: aload_3
    //   963: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   966: goto -311 -> 655
    //   969: astore_3
    //   970: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   973: ifeq -246 -> 727
    //   976: ldc 71
    //   978: iconst_2
    //   979: ldc_w 1584
    //   982: aload_3
    //   983: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   986: goto -259 -> 727
    //   989: astore_2
    //   990: invokestatic 339	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   993: ifeq -203 -> 790
    //   996: ldc 71
    //   998: iconst_2
    //   999: ldc_w 1586
    //   1002: aload_2
    //   1003: invokestatic 1570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1006: goto -216 -> 790
    //   1009: return
    //   1010: iconst_0
    //   1011: istore_1
    //   1012: goto -760 -> 252
    //   1015: iconst_0
    //   1016: istore_1
    //   1017: goto -680 -> 337
    //   1020: iconst_0
    //   1021: istore_1
    //   1022: goto -600 -> 422
    //   1025: iconst_0
    //   1026: istore_1
    //   1027: goto -378 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1030	0	this	ab
    //   251	776	1	bool	boolean
    //   8	779	2	localObject1	Object
    //   849	11	2	localException1	Exception
    //   989	14	2	localException2	Exception
    //   25	690	3	str	String
    //   829	14	3	localNumberFormatException1	java.lang.NumberFormatException
    //   867	14	3	localNumberFormatException2	java.lang.NumberFormatException
    //   887	14	3	localNumberFormatException3	java.lang.NumberFormatException
    //   907	14	3	localNumberFormatException4	java.lang.NumberFormatException
    //   949	14	3	localException3	Exception
    //   969	14	3	localException4	Exception
    //   238	412	4	localObject2	Object
    //   927	15	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   30	41	829	java/lang/NumberFormatException
    //   0	9	849	java/lang/Exception
    //   13	26	849	java/lang/Exception
    //   30	41	849	java/lang/Exception
    //   41	79	849	java/lang/Exception
    //   79	92	849	java/lang/Exception
    //   96	112	849	java/lang/Exception
    //   112	150	849	java/lang/Exception
    //   150	163	849	java/lang/Exception
    //   167	221	849	java/lang/Exception
    //   221	250	849	java/lang/Exception
    //   252	306	849	java/lang/Exception
    //   306	335	849	java/lang/Exception
    //   337	391	849	java/lang/Exception
    //   391	420	849	java/lang/Exception
    //   422	476	849	java/lang/Exception
    //   476	489	849	java/lang/Exception
    //   493	508	849	java/lang/Exception
    //   508	546	849	java/lang/Exception
    //   546	559	849	java/lang/Exception
    //   574	612	849	java/lang/Exception
    //   612	626	849	java/lang/Exception
    //   655	693	849	java/lang/Exception
    //   693	706	849	java/lang/Exception
    //   727	765	849	java/lang/Exception
    //   765	778	849	java/lang/Exception
    //   790	828	849	java/lang/Exception
    //   830	846	849	java/lang/Exception
    //   868	884	849	java/lang/Exception
    //   888	904	849	java/lang/Exception
    //   908	924	849	java/lang/Exception
    //   929	946	849	java/lang/Exception
    //   950	966	849	java/lang/Exception
    //   970	986	849	java/lang/Exception
    //   990	1006	849	java/lang/Exception
    //   96	112	867	java/lang/NumberFormatException
    //   167	221	887	java/lang/NumberFormatException
    //   493	508	907	java/lang/NumberFormatException
    //   563	574	927	java/lang/Exception
    //   631	647	949	java/lang/Exception
    //   649	655	949	java/lang/Exception
    //   710	727	969	java/lang/Exception
    //   782	790	989	java/lang/Exception
  }
  
  /* Error */
  public String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokevirtual 1070	java/io/File:exists	()Z
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 206	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: new 1592	java/io/BufferedReader
    //   31: dup
    //   32: new 1594	java/io/FileReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 1597	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   40: invokespecial 1600	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: invokevirtual 1603	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +47 -> 99
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: aload_1
    //   60: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: goto -20 -> 44
    //   67: astore 4
    //   69: ldc_w 265
    //   72: astore_1
    //   73: aload_3
    //   74: astore_2
    //   75: aload 4
    //   77: invokevirtual 1604	java/io/FileNotFoundException:printStackTrace	()V
    //   80: aload_1
    //   81: astore_2
    //   82: aload_3
    //   83: ifnull -66 -> 17
    //   86: aload_3
    //   87: invokevirtual 1607	java/io/BufferedReader:close	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 1608	java/io/IOException:printStackTrace	()V
    //   97: aload_1
    //   98: areturn
    //   99: aload_3
    //   100: astore_2
    //   101: aload 4
    //   103: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore_1
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: invokevirtual 1607	java/io/BufferedReader:close	()V
    //   113: aload_1
    //   114: astore_2
    //   115: aload_3
    //   116: ifnull -99 -> 17
    //   119: aload_3
    //   120: invokevirtual 1607	java/io/BufferedReader:close	()V
    //   123: aload_1
    //   124: areturn
    //   125: astore_2
    //   126: goto -33 -> 93
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_3
    //   133: ldc_w 265
    //   136: astore_1
    //   137: aload_3
    //   138: astore_2
    //   139: aload 4
    //   141: invokevirtual 1608	java/io/IOException:printStackTrace	()V
    //   144: aload_1
    //   145: astore_2
    //   146: aload_3
    //   147: ifnull -130 -> 17
    //   150: aload_3
    //   151: invokevirtual 1607	java/io/BufferedReader:close	()V
    //   154: aload_1
    //   155: areturn
    //   156: astore_2
    //   157: goto -64 -> 93
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 1607	java/io/BufferedReader:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_2
    //   174: aload_2
    //   175: invokevirtual 1608	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_1
    //   182: goto -19 -> 163
    //   185: astore 4
    //   187: ldc_w 265
    //   190: astore_1
    //   191: goto -54 -> 137
    //   194: astore 4
    //   196: goto -59 -> 137
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_3
    //   203: ldc_w 265
    //   206: astore_1
    //   207: goto -134 -> 73
    //   210: astore 4
    //   212: goto -139 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	ab
    //   0	215	1	paramFile	File
    //   3	79	2	localObject1	Object
    //   92	2	2	localIOException1	java.io.IOException
    //   100	15	2	localObject2	Object
    //   125	1	2	localIOException2	java.io.IOException
    //   138	8	2	localObject3	Object
    //   156	1	2	localIOException3	java.io.IOException
    //   162	6	2	localObject4	Object
    //   173	2	2	localIOException4	java.io.IOException
    //   1	202	3	localBufferedReader	java.io.BufferedReader
    //   26	32	4	localStringBuilder	StringBuilder
    //   67	35	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   129	11	4	localIOException5	java.io.IOException
    //   185	1	4	localIOException6	java.io.IOException
    //   194	1	4	localIOException7	java.io.IOException
    //   199	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   210	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   46	51	67	java/io/FileNotFoundException
    //   57	64	67	java/io/FileNotFoundException
    //   101	107	67	java/io/FileNotFoundException
    //   86	90	92	java/io/IOException
    //   119	123	125	java/io/IOException
    //   19	44	129	java/io/IOException
    //   150	154	156	java/io/IOException
    //   19	44	160	finally
    //   167	171	173	java/io/IOException
    //   46	51	181	finally
    //   57	64	181	finally
    //   75	80	181	finally
    //   101	107	181	finally
    //   109	113	181	finally
    //   139	144	181	finally
    //   46	51	185	java/io/IOException
    //   57	64	185	java/io/IOException
    //   101	107	185	java/io/IOException
    //   109	113	194	java/io/IOException
    //   19	44	199	java/io/FileNotFoundException
    //   109	113	210	java/io/FileNotFoundException
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (!this.aq.b) {
      return;
    }
    switch (paramInt)
    {
    case 1002: 
    case 1005: 
    case 1006: 
    default: 
      return;
    case 1001: 
      Intent localIntent = new Intent("com.tencent.mobileqq.action.QQWiFi");
      localIntent.putExtra("hasvailable", true);
      if (paramBoolean)
      {
        i1 = BaseApplication.qqWifiUserful;
        if (TextUtils.isEmpty(paramString)) {
          paramString = "当前有免费WiFi，点击查看";
        }
        for (;;)
        {
          a(localIntent, paramInt, i1, paramString, "试试一键连接", "当前有可用的 QQ WiFi,点击进入连接");
          a(1, null);
          return;
        }
      }
      int i1 = BaseApplication.qqWifiUserful;
      if (TextUtils.isEmpty(paramString)) {
        paramString = "当前有免费WiFi，点击查看";
      }
      for (;;)
      {
        a(localIntent, paramInt, i1, paramString, "试试一键连接", null);
        break;
      }
    case 1003: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "网络连接不可用", "网络恢复后查看", null);
      return;
    case 1004: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "已关闭无线网络", "打开后查看", null);
      return;
    case 1007: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiConnecticon3, "已连接 " + paramString, "快来赚取免费QQ WiFi时长", null);
      return;
    case 1008: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiUserful, "当前有免费WiFi，点击查看", "试试一键连接", "当前有可用的QQ WiFi，点击进入连接");
      paramString = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (paramInt = 4;; paramInt = 0)
      {
        paramString.getSharedPreferences("qqwifi", paramInt).edit().putLong("lastPushAvailableWiFiToBarClosedUser", System.currentTimeMillis()).commit();
        a(3, null);
        return;
      }
    }
    a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "未连接任何WiFi", "xxx", null);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.aI)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onResponseWifiStatechange isCurUinQuited true, return");
      }
      return;
    }
    int i1 = paramIntent.getIntExtra("wifi_state", 0);
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, " onResponseWifiStatechange, wifiState=" + i1);
    }
    switch (i1)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a(1004, "", false, false);
      return;
    }
    paramIntent = (ConnectivityManager)this.ap.getSystemService("connectivity");
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getAllNetworkInfo();
        if ((paramIntent == null) || (paramIntent.length >= 0) || (paramIntent[0].getState() != NetworkInfo.State.CONNECTED)) {
          break label183;
        }
        i1 = 1;
        if (i1 != 0) {
          break;
        }
        a(1003, "", false, false);
        return;
      }
      catch (Throwable paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, QLog.getStackTraceString(paramIntent));
      return;
      label183:
      i1 = 0;
    }
  }
  
  public void a(MsfCore paramMsfCore, boolean paramBoolean)
  {
    if (this.aD)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "QQWifi already register.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "QQWifi register,isSyncRegister=" + paramBoolean);
    }
    this.ao = paramMsfCore;
    this.aD = true;
    if (paramBoolean)
    {
      a(paramMsfCore);
      return;
    }
    new Thread(new ad(this, paramMsfCore)).start();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvAvailResponse :");
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = "null";
        QLog.d("QQWiFiScanManager", 2, paramToServiceMsg);
      }
    }
    else
    {
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
        break label434;
      }
      paramToServiceMsg = new UniPacket(true);
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (b)paramToServiceMsg.getByClass("rsp", new b());
      if ((paramToServiceMsg == null) || (paramToServiceMsg.a != 0)) {
        break label354;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, availpush=" + paramToServiceMsg.d);
      }
      this.aJ = paramToServiceMsg.d;
      if (paramToServiceMsg.b.isEmpty()) {
        break label285;
      }
      if (!o()) {
        break label262;
      }
      if ((this.aq.e) && (this.aJ == 1)) {
        a(1008, "", false, false);
      }
      label200:
      if (!a(this.aB, paramToServiceMsg.b)) {
        break label277;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, isSubset=true");
      }
    }
    for (;;)
    {
      this.aB.clear();
      this.aB.addAll(paramToServiceMsg.b);
      return;
      paramToServiceMsg = paramFromServiceMsg.toString();
      break;
      label262:
      a(1001, "", false, false);
      break label200;
      label277:
      u();
    }
    for (;;)
    {
      try
      {
        label285:
        paramToServiceMsg = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
          break label349;
        }
        if (i1 != 0) {
          break;
        }
        a(1009, "", false, false);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, "onRecvAvailResponse, qqwifi not avail", paramToServiceMsg);
      return;
      label349:
      i1 = 0;
    }
    label354:
    this.az.clear();
    for (;;)
    {
      try
      {
        paramToServiceMsg = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
          break label429;
        }
        i1 = 1;
        if (i1 != 0) {
          break;
        }
        a(1009, "", false, false);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, "onRecvAvailResponse, qqwifi not avail", paramToServiceMsg);
      return;
      label429:
      i1 = 0;
    }
    label434:
    this.az.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    this.aI = paramBoolean;
    if (paramBoolean) {
      QQNotificationManager.getInstance().cancel("QQWiFiScanManager", 481);
    }
  }
  
  public void b()
  {
    if (this.aD) {
      BaseApplication.getContext().unregisterReceiver(this.aK);
    }
    this.aD = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "unregister");
    }
  }
  
  public void c()
  {
    try
    {
      boolean bool = l();
      if (bool) {}
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQWiFiScanManager", 2, "scan", localThrowable);
    }
  }
  
  public void d()
  {
    try
    {
      if (this.aI) {
        return;
      }
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
      localObject2 = (WifiManager)this.ap.getSystemService("wifi");
      i1 = ((WifiManager)localObject2).getWifiState();
      if (localNetworkInfo == null) {
        if (3 == i1)
        {
          a(1003, "", false, false);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      int i1;
      if (QLog.isColorLevel())
      {
        QLog.e("QQWiFiScanManager", 2, localException.getMessage());
        return;
        a(1004, "", false, false);
        return;
        if (3 != i1)
        {
          a(1004, "", false, false);
          return;
        }
        if ((localException.getType() == 1) || (localException.getType() == 9))
        {
          WifiInfo localWifiInfo = ((WifiManager)localObject2).getConnectionInfo();
          localObject2 = "";
          Object localObject1 = localObject2;
          if (localWifiInfo != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localWifiInfo.getSSID())) {
              localObject1 = localWifiInfo.getSSID().replace("\"", "");
            }
          }
          a(1007, (String)localObject1, false, false);
          return;
        }
        boolean bool = l();
        if (!bool) {}
      }
    }
  }
  
  public void e()
  {
    if (!this.aq.b) {}
    Object localObject3;
    int i1;
    label428:
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = ((ConnectivityManager)this.ap.getSystemService("connectivity")).getActiveNetworkInfo();
          if ((localObject1 != null) && (((NetworkInfo)localObject1).getType() == 1))
          {
            localObject1 = ((ActivityManager)this.ap.getSystemService("activity")).getRunningAppProcesses();
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                if ("com.tencent.mobileqq:qqwifi".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).processName)) {
                  return;
                }
              }
            }
            a(NetConnInfoCenter.msfCore, true);
            localObject3 = "";
            localObject1 = "";
            Object localObject4 = ((WifiManager)this.ap.getSystemService("wifi")).getConnectionInfo();
            if (localObject4 != null)
            {
              localObject3 = ((WifiInfo)localObject4).getBSSID();
              i1 = ((WifiInfo)localObject4).getIpAddress();
              localObject1 = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i1 & 0xFF), Integer.valueOf(i1 >> 8 & 0xFF), Integer.valueOf(i1 >> 16 & 0xFF), Integer.valueOf(i1 >> 24 & 0xFF) });
            }
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
            {
              localObject4 = BaseApplication.getContext();
              if (Build.VERSION.SDK_INT <= 10) {
                break label644;
              }
              i1 = 4;
              localObject4 = ((BaseApplication)localObject4).getSharedPreferences("mobileQQ", i1);
              if (localObject4 != null)
              {
                localObject4 = ((SharedPreferences)localObject4).getString("qqwifiConnInfo", "");
                if (!TextUtils.isEmpty((CharSequence)localObject4))
                {
                  Object localObject6 = new JSONObject((String)localObject4);
                  localObject4 = ((JSONObject)localObject6).optString("ssid");
                  Object localObject5 = ((JSONObject)localObject6).optString("bssid");
                  localObject6 = ((JSONObject)localObject6).optString("IPAdress");
                  if ((((String)localObject3).equals(localObject5)) && (((String)localObject1).equals(localObject6)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("QQWiFiScanManager", 2, "checkConnection:remove netWork！ssid=" + (String)localObject4 + " bssid=" + (String)localObject5 + " IPAdress=" + (String)localObject6);
                    }
                    localObject5 = (WifiManager)this.ap.getSystemService("wifi");
                    localObject6 = ((WifiManager)localObject5).getConfiguredNetworks();
                    if (localObject6 != null)
                    {
                      i1 = 0;
                      localObject1 = localObject4;
                      if (i1 < ((List)localObject6).size())
                      {
                        localObject4 = (WifiConfiguration)((List)localObject6).get(i1);
                        localObject3 = localObject1;
                        if (localObject4 == null) {
                          break label649;
                        }
                        if (TextUtils.isEmpty(((WifiConfiguration)localObject4).SSID)) {
                          break label637;
                        }
                        String str = ((WifiConfiguration)localObject4).SSID.replace("\"", "");
                        localObject1 = ((String)localObject1).replace("\"", "");
                        localObject3 = localObject1;
                        if (!str.equals(localObject1)) {
                          break label649;
                        }
                        ((WifiManager)localObject5).removeNetwork(((WifiConfiguration)localObject4).networkId);
                        localObject3 = localObject1;
                        if (!QLog.isColorLevel()) {
                          break label649;
                        }
                        QLog.i("QQWiFiScanManager", 2, "checkConnection：已经删除了" + ((WifiConfiguration)localObject4).SSID + "网络 networkId:" + ((WifiConfiguration)localObject4).networkId + " bssid:" + ((WifiConfiguration)localObject4).BSSID);
                        localObject3 = localObject1;
                        break label649;
                      }
                      ((WifiManager)localObject5).saveConfiguration();
                      return;
                    }
                  }
                }
              }
            }
          }
        }
        catch (Throwable localThrowable) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQWiFiScanManager", 2, "checkConnection:Exception:" + localThrowable.getMessage());
    return;
    for (;;)
    {
      label637:
      i1 += 1;
      break label428;
      label644:
      i1 = 0;
      break;
      label649:
      Object localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ab
 * JD-Core Version:    0.7.0.1
 */