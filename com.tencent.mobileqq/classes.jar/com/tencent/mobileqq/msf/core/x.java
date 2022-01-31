package com.tencent.mobileqq.msf.core;

import LBS.LBSInfo;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
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
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.mobileqq.msf.service.l;
import com.tencent.msf.service.protocol.QQWiFi.WiFiService;
import com.tencent.msf.service.protocol.QQWiFi.a;
import com.tencent.msf.service.protocol.QQWiFi.b;
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

public class x
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
  static SensorManager L;
  static boolean M = true;
  static boolean N = false;
  public static int O = 1;
  public static int P = O + 1;
  public static int Q = P + 1;
  static int R = 0;
  static int S = 0;
  static int T = 99999999;
  static int U = 20000;
  static int V = 3000000;
  static volatile int W = 0;
  static volatile int X = 0;
  static volatile int Y = 0;
  static AtomicBoolean Z = new AtomicBoolean(false);
  public static final String a = "mobileqq.service";
  private static BroadcastReceiver aK = new ad();
  static long aa = 0L;
  static final String ab = BaseApplication.getContext().getFilesDir() + File.separator + "step.info";
  static JSONObject ac;
  static AtomicBoolean ad = new AtomicBoolean(false);
  static final String ae = BaseApplication.getContext().getFilesDir() + File.separator + "stepSign.info";
  static final String af = "step_info";
  static boolean ag = true;
  public static final String ah = "4eY#X@~g.+U)2%$-";
  static volatile boolean ai = false;
  static AtomicBoolean aj = new AtomicBoolean(false);
  static SensorEventListener ak;
  private static final String al = "QQWiFiScanManager";
  private static x am;
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
  private boolean aC;
  private boolean aD;
  private boolean aE;
  private boolean aF;
  private boolean aG = true;
  private boolean aH;
  private int aI = 1;
  private final BroadcastReceiver aJ = new y(this);
  private MsfCore an;
  private Context ao = BaseApplication.getContext();
  private a ap = new a(null);
  private Notification aq;
  private int ar;
  private String as = "";
  private RemoteViews at;
  private LBSInfo au;
  private long av;
  private long aw;
  private long ax;
  private List ay = Collections.synchronizedList(new ArrayList());
  private List az = Collections.synchronizedList(new ArrayList());
  
  public static x a()
  {
    if (am == null) {
      am = new x();
    }
    return am;
  }
  
  private String a(Context paramContext, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.ap.r))
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
        localJSONArray1 = new JSONArray(this.ap.r);
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
        BaseApplication.getContext().unregisterReceiver(aK);
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
        BaseApplication.getContext().registerReceiver(aK, (IntentFilter)localObject);
        N = true;
        if (!SignUtils.isSupportKeyStore())
        {
          bool = true;
          ai = bool;
          if (ai) {
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
          if (ac == null) {
            new Thread(new ab()).start();
          }
          ak = new ac();
          try
          {
            L.registerListener(ak, localSensor, 3, 360000000);
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
      if (ac != null) {
        ac.put("shut_down", f());
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
    String str = this.ap.c;
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
    if (!this.ap.b) {}
    do
    {
      do
      {
        return;
      } while ((!c(paramInt)) && (!paramBoolean2));
      a(paramInt, paramString, paramBoolean1);
      this.ar = paramInt;
      this.as = paramString;
    } while (paramInt == 1008);
    this.aE = true;
  }
  
  private void a(Intent paramIntent, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
    if (this.at == null) {
      this.at = new RemoteViews(BaseApplication.getContext().getPackageName(), BaseApplication.qqWifiLayout);
    }
    Object localObject;
    int i1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.at.setImageViewResource(BaseApplication.qqWifiSettingViewId, BaseApplication.qqWifiSettings);
      this.at.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 8);
      localObject = new Intent("com.tencent.mobileqq.msf.qqwifi.settings");
      ((Intent)localObject).putExtras(new Bundle());
      ((Intent)localObject).addFlags(603979776);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      this.at.setOnClickPendingIntent(BaseApplication.qqWifiSettingViewId, (PendingIntent)localObject);
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label672;
      }
      i1 = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
      i1 = ((SharedPreferences)localObject).getInt("BarOperation_id", 0);
      if (i1 != 0)
      {
        boolean bool = ((SharedPreferences)localObject).getBoolean(this.ap.c + "hasClicked" + i1, false);
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
          this.at.setOnClickPendingIntent(BaseApplication.qqWifiRedTouchViewId, (PendingIntent)localObject);
          this.at.setImageViewResource(BaseApplication.qqWifiRedTouchViewId, BaseApplication.qqWifiOperation);
          this.at.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 0);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("id", i1);
          a(2, (Bundle)localObject);
        }
      }
    }
    this.at.setImageViewResource(BaseApplication.qqWifiStateIconViewId, paramInt2);
    this.at.setTextViewText(BaseApplication.qqWifiStateTextSingleLine, paramString1);
    this.at.setViewVisibility(BaseApplication.qqWifiTextDoubleLine, 8);
    this.at.setViewVisibility(BaseApplication.qqWifiStateTextSingleLine, 0);
    if (this.aq == null)
    {
      this.aq = new Notification();
      if (Build.VERSION.SDK_INT >= 16) {
        this.aq.priority = 2;
      }
      localObject = this.aq;
      ((Notification)localObject).flags |= 0x20;
      this.aq.contentView = this.at;
    }
    if (paramInt1 == 1008)
    {
      this.aq.flags = 16;
      label535:
      paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), f.I, paramIntent, 0);
      if (BaseApplication.qqWifiNoSignal != paramInt2) {
        break label690;
      }
      this.aq.icon = BaseApplication.qqwifinotifynoneicon;
      label564:
      if (paramString3 == null) {
        break label741;
      }
      this.aq.defaults = 1;
    }
    for (this.aq.tickerText = paramString3;; this.aq.tickerText = "")
    {
      this.aq.contentIntent = paramIntent;
      localNotificationManager.notify(f.I, this.aq);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "type=" + paramInt1 + "," + paramString1 + ", " + paramString2 + "," + paramString3);
      }
      return;
      label672:
      i1 = 0;
      break;
      this.aq.flags = 32;
      break label535;
      label690:
      if (BaseApplication.qqWifiUserful == paramInt2)
      {
        this.aq.icon = BaseApplication.qqwifinotifyusefulicon;
        break label564;
      }
      if (BaseApplication.qqWifiConnecticon3 == paramInt2)
      {
        this.aq.icon = BaseApplication.qqwifinotifyconnectedicon;
        break label564;
      }
      this.aq.icon = paramInt2;
      break label564;
      label741:
      this.aq.defaults = 0;
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
          break label143;
        }
        this.aB.add(paramSharedPreferences);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "updateConfig, bssidsString=" + paramSharedPreferences + " ssid list=" + this.aB.toString());
      }
      return;
      i1 = 0;
      break;
      label143:
      int i3 = localObject1.length;
      i1 = i2;
      while (i1 < i3)
      {
        Object localObject2 = localObject1[i1];
        this.aB.add(localObject2);
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
    BaseApplication.getContext().registerReceiver(this.aJ, paramMsfCore);
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
            if ((!M) && (L != null) && (ak != null))
            {
              L.unregisterListener(ak);
              L = null;
              ak = null;
            }
            if ((!M) || (H <= X) || (H - X > U))
            {
              localObject = l.a(paramToServiceMsg);
              ((FromServiceMsg)localObject).setMsgSuccess();
              if (ac != null) {
                ((FromServiceMsg)localObject).addAttribute("StepInfoJSON", ac.toString());
              }
              com.tencent.mobileqq.msf.service.d.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject);
              return;
            }
            X = H;
            a(true, paramString, paramToServiceMsg);
            return;
          }
          if (((String)localObject).equals("cmd_health_switch"))
          {
            localObject = l.a(paramToServiceMsg);
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
                com.tencent.mobileqq.msf.service.d.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject);
                return;
                M = false;
                if ((L != null) && (ak != null))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("health_manager", 2, "step counter off.");
                  }
                  L.unregisterListener(ak);
                  L = null;
                  ak = null;
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
          if (ac.has("isRestart")) {
            ac.remove("isRestart");
          }
          paramString = paramToServiceMsg.getAttribute("has_report_yes");
        } while ((!(paramString instanceof Boolean)) || (!((Boolean)paramString).booleanValue()));
        ac = new JSONObject();
        paramString = String.valueOf(f());
        try
        {
          ac.put(paramString + "_offset", Y);
          ac.put(paramString + "_init", W);
          ac.put(paramString + "_total", X);
          ac.put("isStepCounterEnable", M);
          ac.put("last_report_time", aa);
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
      com.tencent.msf.service.protocol.QQWiFi.d locald = (com.tencent.msf.service.protocol.QQWiFi.d)localIterator.next();
      if (locald.c < -80) {
        localIterator.remove();
      } else {
        ((List)localObject).add(locald.b);
      }
    }
    if (!a(this.az, (List)localObject))
    {
      e(paramArrayList);
      this.az.clear();
      paramArrayList = ((List)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.az.add(localObject);
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
            this.ax = System.currentTimeMillis();
            Intent localIntent = new Intent("com.tencent.mobileqq.msf.qqwifi.autoconnect");
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
    if (aj.get())
    {
      QLog.e("health_manager", 1, "writing file,return");
      return;
    }
    aj.set(true);
    new Thread(new ae(paramBoolean, paramString, paramToServiceMsg)).start();
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
            File localFile = new File(this.ao.getDir("qqwifi_dir", 0), "enable_file");
            if (localFile.exists()) {
              try
              {
                if (new JSONObject(a(localFile)).has("mIsQQWiFiEnable_" + this.ap.c)) {
                  this.ap.b = false;
                }
                if (QLog.isColorLevel())
                {
                  QLog.d("QQWiFiScanManager", 2, "updateConfig, mIsQQWiFiEnable_" + this.ap.c + "=" + this.ap.b);
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
          this.ap.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.ap.c, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "updateConfig, BarSwitch=" + this.ap.d);
          }
          if (this.ap.d != -1) {
            break;
          }
          this.aE = false;
          this.ar = 0;
          return;
          i1 = 0;
        }
        localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (;;)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
          this.ap.e = ((SharedPreferences)localObject).getBoolean("availNotificationSwitch", false);
          return;
          i1 = 0;
        }
        localObject = new File(this.ao.getDir("qqwifi_dir", 0), "ssids_file");
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
            break label606;
          }
          localObject = str + "|";
          break label606;
        }
        this.ap.a = ((String)localObject);
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
      label606:
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
        this.ap.m = localSharedPreferences.getInt("autoconnect_switch_operation" + this.ap.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "updateConfig, AutoSwitch=" + this.ap.m);
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
      com.tencent.msf.service.protocol.QQWiFi.d locald;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (com.tencent.msf.service.protocol.QQWiFi.d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist before filter:" + ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.msf.service.protocol.QQWiFi.d)((Iterator)localObject1).next();
        if (((com.tencent.msf.service.protocol.QQWiFi.d)localObject2).c < -80) {
          ((Iterator)localObject1).remove();
        } else {
          localArrayList.add(((com.tencent.msf.service.protocol.QQWiFi.d)localObject2).b);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (com.tencent.msf.service.protocol.QQWiFi.d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist after filter:" + ((StringBuilder)localObject1).toString());
        QLog.d("QQWiFiScanManager", 2, "bssidSet:" + localArrayList.toString());
      }
      bool = a(this.ay, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, isSubset=" + bool + ", bssidSet.size=" + localArrayList.size());
      }
    } while (bool);
    e(paramArrayList);
    this.ay.clear();
    this.ay.addAll(localArrayList);
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
      Pattern localPattern = Pattern.compile(this.ap.a);
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
          QLog.i("QQWiFiScanManager", 2, "isInAutoconnectIntervalProtected lasttime=" + l1 + " interval=" + l2 + " autoConnectProtectedInterval=" + this.ap.n);
        }
        bool1 = bool2;
        if (l2 < this.ap.n)
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
    if (this.aE)
    {
      if (this.aC) {
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
            List localList = ((WifiManager)this.ao.getSystemService("wifi")).getScanResults();
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
          if ((localObject != null) && (!TextUtils.isEmpty(this.ap.c)))
          {
            this.ap.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.ap.c, 0);
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "canPushNotification, BarSwitch=" + this.ap.d);
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
        localObject = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (((NetworkInfo)localObject).getType() != 1) || (paramInt != 1001)) {
          break label292;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQWiFiScanManager", 2, "canPushNotification, dont push qqwifi info while wifi is connected");
      return false;
    } while (!a(this.ap.c));
    label292:
    return true;
  }
  
  private boolean c(ArrayList paramArrayList)
  {
    if (this.aA != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.aA.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(((WiFiService)localIterator.next()).wifi.b);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (localHashSet.contains(((com.tencent.msf.service.protocol.QQWiFi.d)paramArrayList.next()).b)) {
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
    int i2 = Math.min(Math.min(localArrayList.size(), this.aB.size()), this.ap.o);
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "lastAutoBssids=" + this.aB.toString() + " curSet:" + localArrayList.toString() + " isSubSet= maxAutoConnecttimes=" + this.ap.o + " min=" + i2);
    }
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = (String)localArrayList.get(i1);
      if (this.aB.contains(paramList))
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
      if ((localWiFiService.autoConnFlag == 1) && (localArrayList.size() < this.ap.o)) {
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
      Iterator localIterator = this.aA.iterator();
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
      } while (!localHashSet.contains(((com.tencent.msf.service.protocol.QQWiFi.d)paramArrayList.next()).b));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasAutoIntersection=" + bool);
      }
      if (bool) {
        a(this.aA);
      }
      return;
    }
  }
  
  private void e(ArrayList paramArrayList)
  {
    try
    {
      this.aw = System.currentTimeMillis();
      int i1 = n();
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "getAvailableQQWifi size:" + paramArrayList.size() + " scanType=" + i1 + " needcallback=" + true);
      }
      Object localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("UTF-8");
      a locala = new a();
      locala.a = paramArrayList;
      locala.b = c.f(this.ao);
      locala.c = "Android";
      locala.d = i1;
      ((UniPacket)localObject).setServantName("MQQ.QQWiFiMgrServer.QQWiFiMgrObj");
      ((UniPacket)localObject).setFuncName("AvailQQWiFiForMSF");
      ((UniPacket)localObject).put("req", locala);
      paramArrayList = ((UniPacket)localObject).encode();
      localObject = new ToServiceMsg("mobileqq.service", this.ap.c, "QQWifiSvc.AvailQQWiFiForMSF");
      ((ToServiceMsg)localObject).setAppId(this.an.sender.j());
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setTimeout(20000L);
      ((ToServiceMsg)localObject).setNeedCallback(true);
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayList);
      ((ToServiceMsg)localObject).addAttribute("isformsf", Boolean.valueOf(true));
      this.an.sendSsoMsg((ToServiceMsg)localObject);
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
    if (this.aD) {
      return;
    }
    this.aD = true;
    i();
    h();
    v();
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 271	com/tencent/mobileqq/msf/core/x:ao	Landroid/content/Context;
    //   4: ldc_w 380
    //   7: iconst_0
    //   8: invokevirtual 386	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   11: astore_3
    //   12: new 206	java/io/File
    //   15: dup
    //   16: aload_3
    //   17: ldc_w 1037
    //   20: invokespecial 391	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 4
    //   25: aload 4
    //   27: invokevirtual 1040	java/io/File:exists	()Z
    //   30: ifeq +110 -> 140
    //   33: new 333	org/json/JSONObject
    //   36: dup
    //   37: aload_0
    //   38: aload 4
    //   40: invokevirtual 394	com/tencent/mobileqq/msf/core/x:a	(Ljava/io/File;)Ljava/lang/String;
    //   43: invokespecial 395	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: new 188	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 1042
    //   56: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   63: getfield 568	com/tencent/mobileqq/msf/core/x$a:c	Ljava/lang/String;
    //   66: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 907	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   75: ifeq +65 -> 140
    //   78: aload_0
    //   79: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   82: iconst_0
    //   83: putfield 596	com/tencent/mobileqq/msf/core/x$a:b	Z
    //   86: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +51 -> 140
    //   92: ldc 72
    //   94: iconst_2
    //   95: new 188	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 1347
    //   105: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   112: getfield 568	com/tencent/mobileqq/msf/core/x$a:c	Ljava/lang/String;
    //   115: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 1046
    //   121: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   128: getfield 596	com/tencent/mobileqq/msf/core/x$a:b	Z
    //   131: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   134: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: new 206	java/io/File
    //   143: dup
    //   144: aload_3
    //   145: ldc_w 1060
    //   148: invokespecial 391	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   151: astore_3
    //   152: aload_3
    //   153: invokevirtual 1040	java/io/File:exists	()Z
    //   156: ifeq +170 -> 326
    //   159: new 333	org/json/JSONObject
    //   162: dup
    //   163: aload_0
    //   164: aload_3
    //   165: invokevirtual 394	com/tencent/mobileqq/msf/core/x:a	(Ljava/io/File;)Ljava/lang/String;
    //   168: invokespecial 395	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   171: ldc_w 1062
    //   174: invokevirtual 1065	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   177: astore 5
    //   179: aload 5
    //   181: invokevirtual 325	org/json/JSONArray:length	()I
    //   184: istore_2
    //   185: ldc 239
    //   187: astore_3
    //   188: iconst_0
    //   189: istore_1
    //   190: iload_1
    //   191: aload 5
    //   193: invokevirtual 325	org/json/JSONArray:length	()I
    //   196: if_icmpge +90 -> 286
    //   199: new 188	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   206: aload_3
    //   207: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 5
    //   212: iload_1
    //   213: invokevirtual 1068	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   216: invokevirtual 806	java/lang/Object:toString	()Ljava/lang/String;
    //   219: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore 4
    //   227: aload 4
    //   229: astore_3
    //   230: iload_1
    //   231: iload_2
    //   232: iconst_1
    //   233: isub
    //   234: if_icmpge +25 -> 259
    //   237: new 188	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   244: aload 4
    //   246: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 371
    //   252: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_3
    //   259: iload_1
    //   260: iconst_1
    //   261: iadd
    //   262: istore_1
    //   263: goto -73 -> 190
    //   266: astore 4
    //   268: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq -131 -> 140
    //   274: ldc 72
    //   276: iconst_2
    //   277: ldc_w 1349
    //   280: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: goto -143 -> 140
    //   286: aload_0
    //   287: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   290: aload_3
    //   291: putfield 1070	com/tencent/mobileqq/msf/core/x$a:a	Ljava/lang/String;
    //   294: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +29 -> 326
    //   300: ldc 72
    //   302: iconst_2
    //   303: new 188	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 1351
    //   313: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_3
    //   317: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: return
    //   327: astore_3
    //   328: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq -5 -> 326
    //   334: ldc 72
    //   336: iconst_2
    //   337: ldc_w 1353
    //   340: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	x
    //   189	74	1	i1	int
    //   184	50	2	i2	int
    //   11	306	3	localObject1	Object
    //   327	1	3	localException1	Exception
    //   23	222	4	localObject2	Object
    //   266	1	4	localException2	Exception
    //   177	34	5	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   33	140	266	java/lang/Exception
    //   159	185	327	java/lang/Exception
    //   190	227	327	java/lang/Exception
    //   237	259	327	java/lang/Exception
    //   286	326	327	java/lang/Exception
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
        this.ap.c = ((SharedPreferences)localObject).getString("uin", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "lastLoginUin = " + this.ap.c);
        }
      }
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label227;
      }
    }
    label227:
    for (int i1 = i2;; i1 = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
      if (localObject != null)
      {
        this.ap.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.ap.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "initConfig, barOperation=" + this.ap.d);
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
    if ((this.aC) && (this.aE) && (o()))
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(f.I);
      this.aE = false;
      this.ar = 0;
    }
  }
  
  private boolean l()
  {
    if (!this.ap.b) {}
    int i1;
    label269:
    do
    {
      do
      {
        return false;
      } while (this.aH);
      Object localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (i1 = 4;; i1 = 0)
      {
        localObject = ((BaseApplication)localObject).getSharedPreferences("Last_Login", i1).getString("uin", "");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!((String)localObject).equals(this.ap.c))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "onAccountChange, " + this.ap.c + ", " + (String)localObject);
          }
          this.ap.c = ((String)localObject);
          k();
        }
        if ((!a(this.ap.c)) || (!this.aG) || (!this.aC)) {
          break;
        }
        localObject = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (((NetworkInfo)localObject).getType() != 1)) {
          break label269;
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
    while (System.currentTimeMillis() - this.aw >= this.ap.k) {
      return true;
    }
    return false;
  }
  
  private boolean m()
  {
    if (this.aI == 0) {
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
    if (this.ap.g) {
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
    if (this.ap.d == 1) {}
    do
    {
      return false;
      if (this.ap.d == -1) {
        return true;
      }
    } while (this.ap.f);
    return true;
  }
  
  private boolean p()
  {
    if (!this.ap.b) {}
    do
    {
      return false;
      if (this.ap.m == 1) {
        return true;
      }
    } while ((this.ap.m == -1) || (!this.ap.l));
    return true;
  }
  
  private void q()
  {
    if (!this.ap.b) {}
    label906:
    label912:
    label915:
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
      if (!b(this.ao))
      {
        localObject2 = a(this.ao, o());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = Pattern.compile((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "NotNetworkSupportSsidList pattern: " + (String)localObject2);
          }
          localObject2 = ((WifiManager)this.ao.getSystemService("wifi")).getScanResults();
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
                localObject6 = new com.tencent.msf.service.protocol.QQWiFi.d();
                ((com.tencent.msf.service.protocol.QQWiFi.d)localObject6).a = ((String)localObject5);
                ((com.tencent.msf.service.protocol.QQWiFi.d)localObject6).b = ((ScanResult)localObject4).BSSID;
                ((com.tencent.msf.service.protocol.QQWiFi.d)localObject6).c = ((short)((ScanResult)localObject4).level);
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
                  label251:
                  long l1 = ((BaseApplication)localObject1).getSharedPreferences("qqwifi", i1).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
                  if ((l1 > 0L) && (System.currentTimeMillis() - l1 < 21600000L)) {
                    break label912;
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
        label301:
        if ((i1 != 0) || (!l())) {
          break label915;
        }
        this.av = System.currentTimeMillis();
        localObject5 = new ArrayList();
        if ((!TextUtils.isEmpty(this.ap.a)) || (!TextUtils.isEmpty(this.ap.q))) {
          if (TextUtils.isEmpty(this.ap.a)) {
            break label906;
          }
        }
        for (localObject1 = Pattern.compile(this.ap.a);; localObject1 = null)
        {
          if (!TextUtils.isEmpty(this.ap.q)) {}
          for (localObject2 = Pattern.compile(this.ap.q);; localObject2 = null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "pattern: " + this.ap.a + " reportPattern: " + this.ap.q);
            }
            localObject6 = ((WifiManager)this.ao.getSystemService("wifi")).getScanResults();
            label483:
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
                  break label894;
                }
              }
            }
            label894:
            for (localObject3 = ((Pattern)localObject1).matcher(str);; localObject3 = null)
            {
              if (localObject2 != null) {}
              for (localObject4 = ((Pattern)localObject2).matcher(str);; localObject4 = null)
              {
                if (((localObject3 != null) && (((Matcher)localObject3).matches())) || ((localObject4 != null) && (((Matcher)localObject4).matches())))
                {
                  localObject3 = new com.tencent.msf.service.protocol.QQWiFi.d();
                  ((com.tencent.msf.service.protocol.QQWiFi.d)localObject3).a = str;
                  ((com.tencent.msf.service.protocol.QQWiFi.d)localObject3).b = localScanResult.BSSID;
                  ((com.tencent.msf.service.protocol.QQWiFi.d)localObject3).c = ((short)localScanResult.level);
                  ((ArrayList)localObject5).add(localObject3);
                }
                i1 += 1;
                break label483;
                i1 = 0;
                break label251;
                a(1001, "", false, true);
                i1 = 1;
                break label301;
                if (((ArrayList)localObject5).isEmpty())
                {
                  j();
                  localObject1 = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
                  localObject2 = (WifiManager)this.ao.getSystemService("wifi");
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
    if (this.aH) {
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
            if (System.currentTimeMillis() - this.ax >= 60000L) {
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
    return this.aG;
  }
  
  private boolean t()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
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
    if (!this.aF)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "startAccScan");
      }
      new aa(this).start();
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
    //   2: getfield 271	com/tencent/mobileqq/msf/core/x:ao	Landroid/content/Context;
    //   5: invokespecial 1480	com/tencent/mobileqq/msf/core/x:a	(Landroid/content/Context;)Ljava/util/Map;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +998 -> 1008
    //   13: aload_2
    //   14: ldc_w 1482
    //   17: invokeinterface 1485 2 0
    //   22: checkcast 413	java/lang/String
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +52 -> 79
    //   30: aload_0
    //   31: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   34: aload_3
    //   35: invokestatic 1488	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   38: putfield 1490	com/tencent/mobileqq/msf/core/x$a:h	I
    //   41: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: ldc 72
    //   49: iconst_2
    //   50: new 188	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 1492
    //   60: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   67: getfield 1490	com/tencent/mobileqq/msf/core/x$a:h	I
    //   70: invokevirtual 560	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_2
    //   80: ldc_w 1494
    //   83: invokeinterface 1485 2 0
    //   88: checkcast 413	java/lang/String
    //   91: astore_3
    //   92: aload_3
    //   93: ifnull +57 -> 150
    //   96: aload_0
    //   97: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   100: aload_3
    //   101: invokestatic 1488	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   104: sipush 1000
    //   107: imul
    //   108: i2l
    //   109: putfield 1496	com/tencent/mobileqq/msf/core/x$a:i	J
    //   112: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +35 -> 150
    //   118: ldc 72
    //   120: iconst_2
    //   121: new 188	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 1492
    //   131: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   138: getfield 1496	com/tencent/mobileqq/msf/core/x$a:i	J
    //   141: invokevirtual 1154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_2
    //   151: ldc_w 1498
    //   154: invokeinterface 1485 2 0
    //   159: checkcast 413	java/lang/String
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull +57 -> 221
    //   167: aload_0
    //   168: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   171: aload_3
    //   172: invokestatic 1488	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   175: sipush 1000
    //   178: imul
    //   179: i2l
    //   180: putfield 1500	com/tencent/mobileqq/msf/core/x$a:j	J
    //   183: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +35 -> 221
    //   189: ldc 72
    //   191: iconst_2
    //   192: new 188	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 1502
    //   202: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   209: getfield 1500	com/tencent/mobileqq/msf/core/x$a:j	J
    //   212: invokevirtual 1154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_2
    //   222: ldc_w 1504
    //   225: invokeinterface 1485 2 0
    //   230: checkcast 413	java/lang/String
    //   233: astore_3
    //   234: aload_0
    //   235: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   238: astore 4
    //   240: ldc_w 1506
    //   243: aload_3
    //   244: invokevirtual 833	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +762 -> 1009
    //   250: iconst_1
    //   251: istore_1
    //   252: aload 4
    //   254: iload_1
    //   255: putfield 1415	com/tencent/mobileqq/msf/core/x$a:f	Z
    //   258: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +45 -> 306
    //   264: ldc 72
    //   266: iconst_2
    //   267: new 188	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 1508
    //   277: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   284: getfield 1415	com/tencent/mobileqq/msf/core/x$a:f	Z
    //   287: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   290: ldc_w 770
    //   293: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_3
    //   297: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_2
    //   307: ldc_w 1510
    //   310: invokeinterface 1485 2 0
    //   315: checkcast 413	java/lang/String
    //   318: astore_3
    //   319: aload_0
    //   320: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   323: astore 4
    //   325: ldc_w 1506
    //   328: aload_3
    //   329: invokevirtual 833	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   332: ifeq +682 -> 1014
    //   335: iconst_1
    //   336: istore_1
    //   337: aload 4
    //   339: iload_1
    //   340: putfield 1409	com/tencent/mobileqq/msf/core/x$a:g	Z
    //   343: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +45 -> 391
    //   349: ldc 72
    //   351: iconst_2
    //   352: new 188	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 1512
    //   362: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   369: getfield 1409	com/tencent/mobileqq/msf/core/x$a:g	Z
    //   372: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   375: ldc_w 768
    //   378: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_3
    //   382: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_2
    //   392: ldc_w 1514
    //   395: invokeinterface 1485 2 0
    //   400: checkcast 413	java/lang/String
    //   403: astore_3
    //   404: aload_0
    //   405: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   408: astore 4
    //   410: ldc_w 1506
    //   413: aload_3
    //   414: invokevirtual 833	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   417: ifeq +602 -> 1019
    //   420: iconst_1
    //   421: istore_1
    //   422: aload 4
    //   424: iload_1
    //   425: putfield 1417	com/tencent/mobileqq/msf/core/x$a:l	Z
    //   428: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +45 -> 476
    //   434: ldc 72
    //   436: iconst_2
    //   437: new 188	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 1516
    //   447: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_0
    //   451: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   454: getfield 1417	com/tencent/mobileqq/msf/core/x$a:l	Z
    //   457: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: ldc_w 768
    //   463: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_3
    //   467: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload_2
    //   477: ldc_w 1518
    //   480: invokeinterface 1485 2 0
    //   485: checkcast 413	java/lang/String
    //   488: astore_3
    //   489: aload_3
    //   490: ifnull +56 -> 546
    //   493: aload_0
    //   494: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   497: aload_3
    //   498: invokestatic 1522	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   501: ldc2_w 681
    //   504: lmul
    //   505: putfield 1160	com/tencent/mobileqq/msf/core/x$a:n	J
    //   508: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +35 -> 546
    //   514: ldc 72
    //   516: iconst_2
    //   517: new 188	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 1524
    //   527: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   534: getfield 1160	com/tencent/mobileqq/msf/core/x$a:n	J
    //   537: invokevirtual 1154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   540: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: aload_2
    //   547: ldc_w 1526
    //   550: invokeinterface 1485 2 0
    //   555: checkcast 413	java/lang/String
    //   558: astore_3
    //   559: aload_3
    //   560: ifnull +52 -> 612
    //   563: aload_0
    //   564: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   567: aload_3
    //   568: invokestatic 1488	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   571: putfield 1211	com/tencent/mobileqq/msf/core/x$a:o	I
    //   574: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +35 -> 612
    //   580: ldc 72
    //   582: iconst_2
    //   583: new 188	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 1528
    //   593: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_0
    //   597: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   600: getfield 1211	com/tencent/mobileqq/msf/core/x$a:o	I
    //   603: invokevirtual 560	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_2
    //   613: ldc_w 1526
    //   616: invokeinterface 1485 2 0
    //   621: checkcast 413	java/lang/String
    //   624: astore 4
    //   626: aload 4
    //   628: ifnull +65 -> 693
    //   631: aload_0
    //   632: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   635: astore 4
    //   637: aload_3
    //   638: ldc_w 1506
    //   641: invokevirtual 833	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +380 -> 1024
    //   647: iconst_1
    //   648: istore_1
    //   649: aload 4
    //   651: iload_1
    //   652: putfield 1530	com/tencent/mobileqq/msf/core/x$a:p	Z
    //   655: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +35 -> 693
    //   661: ldc 72
    //   663: iconst_2
    //   664: new 188	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 1532
    //   674: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_0
    //   678: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   681: getfield 1530	com/tencent/mobileqq/msf/core/x$a:p	Z
    //   684: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: aload_2
    //   694: ldc_w 1534
    //   697: invokeinterface 1485 2 0
    //   702: checkcast 413	java/lang/String
    //   705: astore_3
    //   706: aload_3
    //   707: ifnull +57 -> 764
    //   710: aload_0
    //   711: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   714: aload_3
    //   715: ldc_w 1536
    //   718: ldc 239
    //   720: invokevirtual 1539	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   723: putfield 285	com/tencent/mobileqq/msf/core/x$a:r	Ljava/lang/String;
    //   726: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq +35 -> 764
    //   732: ldc 72
    //   734: iconst_2
    //   735: new 188	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   742: ldc_w 1541
    //   745: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload_0
    //   749: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   752: getfield 285	com/tencent/mobileqq/msf/core/x$a:r	Ljava/lang/String;
    //   755: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload_2
    //   765: ldc_w 1543
    //   768: invokeinterface 1485 2 0
    //   773: checkcast 413	java/lang/String
    //   776: astore_2
    //   777: aload_2
    //   778: ifnull +230 -> 1008
    //   781: aload_0
    //   782: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   785: aload_2
    //   786: putfield 1441	com/tencent/mobileqq/msf/core/x$a:q	Ljava/lang/String;
    //   789: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   792: ifeq +216 -> 1008
    //   795: ldc 72
    //   797: iconst_2
    //   798: new 188	java/lang/StringBuilder
    //   801: dup
    //   802: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   805: ldc_w 1545
    //   808: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload_0
    //   812: getfield 276	com/tencent/mobileqq/msf/core/x:ap	Lcom/tencent/mobileqq/msf/core/x$a;
    //   815: getfield 1441	com/tencent/mobileqq/msf/core/x$a:q	Ljava/lang/String;
    //   818: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   827: return
    //   828: astore_3
    //   829: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq -791 -> 41
    //   835: ldc 72
    //   837: iconst_2
    //   838: ldc_w 1547
    //   841: aload_3
    //   842: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   845: goto -804 -> 41
    //   848: astore_2
    //   849: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   852: ifeq +156 -> 1008
    //   855: ldc 72
    //   857: iconst_2
    //   858: aload_2
    //   859: invokevirtual 544	java/lang/Exception:toString	()Ljava/lang/String;
    //   862: invokestatic 1552	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   865: return
    //   866: astore_3
    //   867: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   870: ifeq -758 -> 112
    //   873: ldc 72
    //   875: iconst_2
    //   876: ldc_w 1554
    //   879: aload_3
    //   880: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   883: goto -771 -> 112
    //   886: astore_3
    //   887: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   890: ifeq -669 -> 221
    //   893: ldc 72
    //   895: iconst_2
    //   896: ldc_w 1556
    //   899: aload_3
    //   900: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   903: goto -682 -> 221
    //   906: astore_3
    //   907: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   910: ifeq -402 -> 508
    //   913: ldc 72
    //   915: iconst_2
    //   916: ldc_w 1558
    //   919: aload_3
    //   920: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   923: goto -415 -> 508
    //   926: astore 4
    //   928: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq -357 -> 574
    //   934: ldc 72
    //   936: iconst_2
    //   937: ldc_w 1560
    //   940: aload 4
    //   942: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   945: goto -371 -> 574
    //   948: astore_3
    //   949: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq -297 -> 655
    //   955: ldc 72
    //   957: iconst_2
    //   958: ldc_w 1562
    //   961: aload_3
    //   962: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   965: goto -310 -> 655
    //   968: astore_3
    //   969: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq -246 -> 726
    //   975: ldc 72
    //   977: iconst_2
    //   978: ldc_w 1564
    //   981: aload_3
    //   982: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   985: goto -259 -> 726
    //   988: astore_2
    //   989: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   992: ifeq -203 -> 789
    //   995: ldc 72
    //   997: iconst_2
    //   998: ldc_w 1566
    //   1001: aload_2
    //   1002: invokestatic 1550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1005: goto -216 -> 789
    //   1008: return
    //   1009: iconst_0
    //   1010: istore_1
    //   1011: goto -759 -> 252
    //   1014: iconst_0
    //   1015: istore_1
    //   1016: goto -679 -> 337
    //   1019: iconst_0
    //   1020: istore_1
    //   1021: goto -599 -> 422
    //   1024: iconst_0
    //   1025: istore_1
    //   1026: goto -377 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1029	0	this	x
    //   251	775	1	bool	boolean
    //   8	778	2	localObject1	Object
    //   848	11	2	localException1	Exception
    //   988	14	2	localException2	Exception
    //   25	690	3	str	String
    //   828	14	3	localNumberFormatException1	java.lang.NumberFormatException
    //   866	14	3	localNumberFormatException2	java.lang.NumberFormatException
    //   886	14	3	localNumberFormatException3	java.lang.NumberFormatException
    //   906	14	3	localNumberFormatException4	java.lang.NumberFormatException
    //   948	14	3	localException3	Exception
    //   968	14	3	localException4	Exception
    //   238	412	4	localObject2	Object
    //   926	15	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   30	41	828	java/lang/NumberFormatException
    //   0	9	848	java/lang/Exception
    //   13	26	848	java/lang/Exception
    //   30	41	848	java/lang/Exception
    //   41	79	848	java/lang/Exception
    //   79	92	848	java/lang/Exception
    //   96	112	848	java/lang/Exception
    //   112	150	848	java/lang/Exception
    //   150	163	848	java/lang/Exception
    //   167	221	848	java/lang/Exception
    //   221	250	848	java/lang/Exception
    //   252	306	848	java/lang/Exception
    //   306	335	848	java/lang/Exception
    //   337	391	848	java/lang/Exception
    //   391	420	848	java/lang/Exception
    //   422	476	848	java/lang/Exception
    //   476	489	848	java/lang/Exception
    //   493	508	848	java/lang/Exception
    //   508	546	848	java/lang/Exception
    //   546	559	848	java/lang/Exception
    //   574	612	848	java/lang/Exception
    //   612	626	848	java/lang/Exception
    //   655	693	848	java/lang/Exception
    //   693	706	848	java/lang/Exception
    //   726	764	848	java/lang/Exception
    //   764	777	848	java/lang/Exception
    //   789	827	848	java/lang/Exception
    //   829	845	848	java/lang/Exception
    //   867	883	848	java/lang/Exception
    //   887	903	848	java/lang/Exception
    //   907	923	848	java/lang/Exception
    //   928	945	848	java/lang/Exception
    //   949	965	848	java/lang/Exception
    //   969	985	848	java/lang/Exception
    //   989	1005	848	java/lang/Exception
    //   96	112	866	java/lang/NumberFormatException
    //   167	221	886	java/lang/NumberFormatException
    //   493	508	906	java/lang/NumberFormatException
    //   563	574	926	java/lang/Exception
    //   631	647	948	java/lang/Exception
    //   649	655	948	java/lang/Exception
    //   710	726	968	java/lang/Exception
    //   781	789	988	java/lang/Exception
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
    //   9: invokevirtual 1040	java/io/File:exists	()Z
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 188	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: new 1572	java/io/BufferedReader
    //   31: dup
    //   32: new 1574	java/io/FileReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 1577	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   40: invokespecial 1580	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: invokevirtual 1583	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +46 -> 98
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: aload_1
    //   60: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: goto -20 -> 44
    //   67: astore 4
    //   69: ldc 239
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 1584	java/io/FileNotFoundException:printStackTrace	()V
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: ifnull -65 -> 17
    //   85: aload_3
    //   86: invokevirtual 1587	java/io/BufferedReader:close	()V
    //   89: aload_1
    //   90: areturn
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 1588	java/io/IOException:printStackTrace	()V
    //   96: aload_1
    //   97: areturn
    //   98: aload_3
    //   99: astore_2
    //   100: aload 4
    //   102: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore_1
    //   106: aload_3
    //   107: astore_2
    //   108: aload_3
    //   109: invokevirtual 1587	java/io/BufferedReader:close	()V
    //   112: aload_1
    //   113: astore_2
    //   114: aload_3
    //   115: ifnull -98 -> 17
    //   118: aload_3
    //   119: invokevirtual 1587	java/io/BufferedReader:close	()V
    //   122: aload_1
    //   123: areturn
    //   124: astore_2
    //   125: goto -33 -> 92
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_3
    //   132: ldc 239
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: aload 4
    //   139: invokevirtual 1588	java/io/IOException:printStackTrace	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: ifnull -128 -> 17
    //   148: aload_3
    //   149: invokevirtual 1587	java/io/BufferedReader:close	()V
    //   152: aload_1
    //   153: areturn
    //   154: astore_2
    //   155: goto -63 -> 92
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 1587	java/io/BufferedReader:close	()V
    //   169: aload_1
    //   170: athrow
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 1588	java/io/IOException:printStackTrace	()V
    //   176: goto -7 -> 169
    //   179: astore_1
    //   180: goto -19 -> 161
    //   183: astore 4
    //   185: ldc 239
    //   187: astore_1
    //   188: goto -53 -> 135
    //   191: astore 4
    //   193: goto -58 -> 135
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_3
    //   200: ldc 239
    //   202: astore_1
    //   203: goto -131 -> 72
    //   206: astore 4
    //   208: goto -136 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	x
    //   0	211	1	paramFile	File
    //   3	78	2	localObject1	Object
    //   91	2	2	localIOException1	java.io.IOException
    //   99	15	2	localObject2	Object
    //   124	1	2	localIOException2	java.io.IOException
    //   136	8	2	localObject3	Object
    //   154	1	2	localIOException3	java.io.IOException
    //   160	6	2	localObject4	Object
    //   171	2	2	localIOException4	java.io.IOException
    //   1	199	3	localBufferedReader	java.io.BufferedReader
    //   26	32	4	localStringBuilder	StringBuilder
    //   67	34	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   128	10	4	localIOException5	java.io.IOException
    //   183	1	4	localIOException6	java.io.IOException
    //   191	1	4	localIOException7	java.io.IOException
    //   196	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   206	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   46	51	67	java/io/FileNotFoundException
    //   57	64	67	java/io/FileNotFoundException
    //   100	106	67	java/io/FileNotFoundException
    //   85	89	91	java/io/IOException
    //   118	122	124	java/io/IOException
    //   19	44	128	java/io/IOException
    //   148	152	154	java/io/IOException
    //   19	44	158	finally
    //   165	169	171	java/io/IOException
    //   46	51	179	finally
    //   57	64	179	finally
    //   74	79	179	finally
    //   100	106	179	finally
    //   108	112	179	finally
    //   137	142	179	finally
    //   46	51	183	java/io/IOException
    //   57	64	183	java/io/IOException
    //   100	106	183	java/io/IOException
    //   108	112	191	java/io/IOException
    //   19	44	196	java/io/FileNotFoundException
    //   108	112	206	java/io/FileNotFoundException
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (!this.ap.b) {
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
    if (this.aH)
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
    paramIntent = (ConnectivityManager)this.ao.getSystemService("connectivity");
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getAllNetworkInfo();
        if ((paramIntent == null) || (paramIntent.length >= 0) || (paramIntent[0].getState() != NetworkInfo.State.CONNECTED)) {
          break label181;
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
      label181:
      i1 = 0;
    }
  }
  
  public void a(MsfCore paramMsfCore, boolean paramBoolean)
  {
    if (this.aC)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "QQWifi already register.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "QQWifi register,isSyncRegister=" + paramBoolean);
    }
    this.an = paramMsfCore;
    this.aC = true;
    if (paramBoolean)
    {
      a(paramMsfCore);
      return;
    }
    new Thread(new z(this, paramMsfCore)).start();
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
        break label430;
      }
      paramToServiceMsg = new UniPacket(true);
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (b)paramToServiceMsg.getByClass("rsp", new b());
      if ((paramToServiceMsg == null) || (paramToServiceMsg.a != 0)) {
        break label351;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, availpush=" + paramToServiceMsg.d);
      }
      this.aI = paramToServiceMsg.d;
      if (paramToServiceMsg.b.isEmpty()) {
        break label283;
      }
      if (!o()) {
        break label261;
      }
      if ((this.ap.e) && (this.aI == 1)) {
        a(1008, "", false, false);
      }
      label199:
      if (!a(this.aA, paramToServiceMsg.b)) {
        break label275;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, isSubset=true");
      }
    }
    for (;;)
    {
      this.aA.clear();
      this.aA.addAll(paramToServiceMsg.b);
      return;
      paramToServiceMsg = paramFromServiceMsg.toString();
      break;
      label261:
      a(1001, "", false, false);
      break label199;
      label275:
      u();
    }
    for (;;)
    {
      try
      {
        label283:
        paramToServiceMsg = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
          break label346;
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
      label346:
      i1 = 0;
    }
    label351:
    this.ay.clear();
    for (;;)
    {
      try
      {
        paramToServiceMsg = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
          break label425;
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
      label425:
      i1 = 0;
    }
    label430:
    this.ay.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    this.aH = paramBoolean;
    if (paramBoolean) {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(f.I);
    }
  }
  
  public void b()
  {
    if (this.aC) {
      BaseApplication.getContext().unregisterReceiver(this.aJ);
    }
    this.aC = false;
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
      if (this.aH) {
        return;
      }
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
      localObject2 = (WifiManager)this.ao.getSystemService("wifi");
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
    if (!this.ap.b) {}
    Object localObject3;
    int i1;
    label425:
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = ((ConnectivityManager)this.ao.getSystemService("connectivity")).getActiveNetworkInfo();
          if ((localObject1 != null) && (((NetworkInfo)localObject1).getType() == 1))
          {
            localObject1 = ((ActivityManager)this.ao.getSystemService("activity")).getRunningAppProcesses();
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
            Object localObject4 = ((WifiManager)this.ao.getSystemService("wifi")).getConnectionInfo();
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
                break label639;
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
                    localObject5 = (WifiManager)this.ao.getSystemService("wifi");
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
                          break label644;
                        }
                        if (TextUtils.isEmpty(((WifiConfiguration)localObject4).SSID)) {
                          break label632;
                        }
                        String str = ((WifiConfiguration)localObject4).SSID.replace("\"", "");
                        localObject1 = ((String)localObject1).replace("\"", "");
                        localObject3 = localObject1;
                        if (!str.equals(localObject1)) {
                          break label644;
                        }
                        ((WifiManager)localObject5).removeNetwork(((WifiConfiguration)localObject4).networkId);
                        localObject3 = localObject1;
                        if (!QLog.isColorLevel()) {
                          break label644;
                        }
                        QLog.i("QQWiFiScanManager", 2, "checkConnection：已经删除了" + ((WifiConfiguration)localObject4).SSID + "网络 networkId:" + ((WifiConfiguration)localObject4).networkId + " bssid:" + ((WifiConfiguration)localObject4).BSSID);
                        localObject3 = localObject1;
                        break label644;
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
      label632:
      i1 += 1;
      break label425;
      label639:
      i1 = 0;
      break;
      label644:
      Object localObject2 = localObject3;
    }
  }
  
  private class a
  {
    public String a = "";
    public boolean b;
    public String c = "";
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h = 10;
    public long i = 30000L;
    public long j = 60000L;
    public long k = 86400000L;
    public boolean l;
    public int m;
    public long n = 21600000L;
    public int o = 1;
    public boolean p;
    public String q;
    public String r;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.x
 * JD-Core Version:    0.7.0.1
 */