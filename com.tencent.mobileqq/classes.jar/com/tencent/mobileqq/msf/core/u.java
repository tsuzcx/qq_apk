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
import com.tencent.mobileqq.msf.core.stepcount.e.a;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.mobileqq.msf.service.e;
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
import java.util.Collection;
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

public class u
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
  public static boolean M = true;
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
  public static volatile int X = 0;
  public static volatile int Y = 0;
  static AtomicBoolean Z = new AtomicBoolean(false);
  public static final String a = "mobileqq.service";
  private static BroadcastReceiver aN = new aa();
  static long aa = 0L;
  public static long ab = 0L;
  static final String ac;
  static JSONObject ad;
  static AtomicBoolean ae;
  static final String af;
  static final String ag = "step_info";
  static boolean ah = false;
  public static final String ai = "4eY#X@~g.+U)2%$-";
  static volatile boolean aj = false;
  static AtomicBoolean ak;
  static SensorEventListener al;
  public static e.a am;
  public static boolean an = false;
  private static final String ao = "QQWiFiScanManager";
  private static u ap;
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
  private long aA = 0L;
  private List aB = Collections.synchronizedList(new ArrayList());
  private List aC = Collections.synchronizedList(new ArrayList());
  private List aD = Collections.synchronizedList(new ArrayList());
  private List aE = Collections.synchronizedList(new ArrayList());
  private boolean aF;
  private boolean aG = false;
  private boolean aH = false;
  private boolean aI = false;
  private boolean aJ = true;
  private boolean aK = false;
  private int aL = 1;
  private final BroadcastReceiver aM = new v(this);
  private MsfCore aq;
  private Context ar = BaseApplication.getContext();
  private u.a as = new u.a(this, null);
  private Notification at;
  private int au = 0;
  private String av = "";
  private RemoteViews aw;
  private LBSInfo ax;
  private long ay = 0L;
  private long az = 0L;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("step.info");
    ac = localStringBuilder.toString();
    ad = null;
    ae = new AtomicBoolean(false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("stepSign.info");
    af = localStringBuilder.toString();
    ah = true;
    aj = false;
    ak = new AtomicBoolean(false);
    al = null;
  }
  
  public static u a()
  {
    if (ap == null) {
      ap = new u();
    }
    return ap;
  }
  
  private String a(Context paramContext, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.as.r))
    {
      if (QLog.isColorLevel()) {
        QLog.e("health_manager", 2, "getNotNetworkSupportSsidList mControlConfig.noNetSupport is empty");
      }
      return null;
    }
    paramContext = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("no_network_support_qqwifi", i1);
    paramContext = new StringBuffer();
    try
    {
      localJSONArray1 = new JSONArray(this.as.r);
      i4 = localJSONArray1.length();
      i1 = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONArray localJSONArray1;
        int i4;
        int i3;
        JSONObject localJSONObject1;
        JSONArray localJSONArray2;
        int i5;
        JSONObject localJSONObject2;
        String str;
        int i6;
        continue;
        i2 += 1;
        continue;
        int i2 = 0;
        continue;
        i1 += 1;
      }
    }
    i3 = 1;
    if (i1 < i4)
    {
      localJSONObject1 = localJSONArray1.getJSONObject(i1);
      if ((localJSONObject1 == null) || ((paramBoolean) && (localJSONObject1.optInt("canPush") != 1))) {
        break label296;
      }
      localJSONArray2 = localJSONObject1.optJSONArray("jar");
      i5 = localJSONArray2.length();
      i2 = 0;
      if (i2 >= i5) {
        break label290;
      }
      localJSONObject2 = localJSONArray2.optJSONObject(i2);
      str = localJSONObject2.optString("pkgid");
      i6 = localJSONObject2.optInt("limitVersion");
      if ((localSharedPreferences.contains(str)) && (localSharedPreferences.getInt(str, 0) > i6))
      {
        i2 = i3;
        if (i2 == 0) {
          break label296;
        }
        paramContext.append(localJSONObject1.optString("ssid"));
        paramContext.append("|");
        break label296;
      }
    }
    else
    {
      if (paramContext.length() > 0) {
        paramContext.delete(paramContext.length() - 1, paramContext.length());
      }
      return paramContext.toString();
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
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    Object localObject1;
    if (paramInt == P)
    {
      QLog.i("health_manager", 1, "msf ondestory!");
      if (N)
      {
        BaseApplication.getContext().unregisterReceiver(aN);
        N = false;
      }
      localObject1 = am;
      if (localObject1 != null) {
        ((e.a)localObject1).a();
      }
    }
    else
    {
      if (paramInt == O)
      {
        if (Build.VERSION.SDK_INT < 19) {
          break label514;
        }
        L = (SensorManager)BaseApplication.getContext().getSystemService("sensor");
        localObject1 = L.getDefaultSensor(19);
        if (localObject1 == null) {
          break label514;
        }
        if (!N) {
          try
          {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
            localIntentFilter.addAction("MSF_Action_Refresh_Steps");
            BaseApplication.getContext().registerReceiver(aN, localIntentFilter);
            N = true;
          }
          catch (Exception localException3)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("register receiver Exception:");
              ((StringBuilder)localObject3).append(localException3.toString());
              QLog.e("health_manager", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
        aj = SignUtils.isSupportKeyStore() ^ true;
        if (aj) {
          QLog.e("health_manager", 1, "switch to old mode.");
        }
        Object localObject2 = new Intent("MSF_Action_Refresh_Steps");
        ((Intent)localObject2).setAction("MSF_Action_Refresh_Steps");
        localObject2 = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject2, 0);
        Object localObject3 = (AlarmManager)BaseApplication.getContext().getSystemService("alarm");
        Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        localCalendar.set(11, 23);
        localCalendar.set(12, 56);
        localCalendar.set(13, 59);
        ((AlarmManager)localObject3).setRepeating(0, localCalendar.getTimeInMillis(), 86400000L, (PendingIntent)localObject2);
        if (ad == null) {
          new Thread(new y()).start();
        }
        al = new z();
        try
        {
          L.registerListener(al, (Sensor)localObject1, 3, 360000000);
          return;
        }
        catch (Exception localException1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Exception:");
          ((StringBuilder)localObject2).append(localException1.toString());
          QLog.e("health_manager", 1, ((StringBuilder)localObject2).toString());
          return;
        }
      }
      if (paramInt == Q)
      {
        if ((H > X) && (H - X < U)) {
          X = H;
        }
        Y += X - W;
        W = X;
      }
    }
    try
    {
      if (ad != null) {
        ad.put("shut_down", g());
      }
      label458:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("system shut down set offset:");
      localStringBuilder.append(Y);
      localStringBuilder.append(",step:");
      localStringBuilder.append(W);
      QLog.i("health_manager", 1, localStringBuilder.toString());
      a(false, null, null);
      label514:
      return;
    }
    catch (Exception localException2)
    {
      break label458;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = BaseApplication.getContext();
    String str = this.as.c;
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences(str, i1);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        paramInt = ((SharedPreferences)localObject).getInt("showQQWiFiAvailExtend", 0);
        ((SharedPreferences)localObject).edit().putInt("showQQWiFiAvailExtend", paramInt + 1).commit();
        return;
      }
      ((SharedPreferences)localObject).edit().putInt("QQWiFiShowRedTouch", paramBundle.getInt("id")).commit();
      return;
    }
    paramInt = ((SharedPreferences)localObject).getInt("showQQWiFiNotifyCount", 0);
    ((SharedPreferences)localObject).edit().putInt("showQQWiFiNotifyCount", paramInt + 1).commit();
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.as.b) {
      return;
    }
    if ((c(paramInt)) || (paramBoolean2))
    {
      a(paramInt, paramString, paramBoolean1);
      this.au = paramInt;
      this.av = paramString;
      if (paramInt != 1008) {
        this.aH = true;
      }
    }
  }
  
  private void a(Intent paramIntent, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (this.aw == null) {
      this.aw = new RemoteViews(BaseApplication.getContext().getPackageName(), BaseApplication.qqWifiLayout);
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.aw.setImageViewResource(BaseApplication.qqWifiSettingViewId, BaseApplication.qqWifiSettings);
      this.aw.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 8);
      localObject1 = new Intent("com.tencent.mobileqq.msf.qqwifi.settings");
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).addFlags(603979776);
      localObject1 = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject1, 134217728);
      this.aw.setOnClickPendingIntent(BaseApplication.qqWifiSettingViewId, (PendingIntent)localObject1);
      localObject1 = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("qqwifi", i1);
      int i1 = ((SharedPreferences)localObject1).getInt("BarOperation_id", 0);
      if (i1 != 0)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.as.c);
        ((StringBuilder)localObject2).append("hasClicked");
        ((StringBuilder)localObject2).append(i1);
        boolean bool = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
        long l1 = ((SharedPreferences)localObject1).getLong("BarOperation_expiry", 0L);
        if ((!bool) && (System.currentTimeMillis() < l1 * 1000L))
        {
          int i2 = ((SharedPreferences)localObject1).getInt("BarOperation_type", 0);
          localObject1 = ((SharedPreferences)localObject1).getString("BarOperation_url", "");
          localObject2 = new Intent("com.tencent.mobileqq.msf.qqwifi.redtouch");
          ((Intent)localObject2).putExtra("type", i2);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("id", i1);
          ((Intent)localObject2).addFlags(603979776);
          localObject1 = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject2, 134217728);
          this.aw.setOnClickPendingIntent(BaseApplication.qqWifiRedTouchViewId, (PendingIntent)localObject1);
          this.aw.setImageViewResource(BaseApplication.qqWifiRedTouchViewId, BaseApplication.qqWifiOperation);
          this.aw.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 0);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("id", i1);
          a(2, (Bundle)localObject1);
        }
      }
    }
    this.aw.setImageViewResource(BaseApplication.qqWifiStateIconViewId, paramInt2);
    this.aw.setTextViewText(BaseApplication.qqWifiStateTextSingleLine, paramString1);
    this.aw.setViewVisibility(BaseApplication.qqWifiTextDoubleLine, 8);
    this.aw.setViewVisibility(BaseApplication.qqWifiStateTextSingleLine, 0);
    if (this.at == null)
    {
      this.at = new Notification();
      if (Build.VERSION.SDK_INT >= 16) {
        this.at.priority = 2;
      }
      localObject1 = this.at;
      ((Notification)localObject1).flags |= 0x20;
      this.at.contentView = this.aw;
    }
    if (paramInt1 == 1008) {
      this.at.flags = 16;
    } else {
      this.at.flags = 32;
    }
    paramIntent.putExtra("param_notifyid", 481);
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 481, paramIntent, 0);
    if (BaseApplication.qqWifiNoSignal == paramInt2) {
      this.at.icon = BaseApplication.qqwifinotifynoneicon;
    } else if (BaseApplication.qqWifiUserful == paramInt2) {
      this.at.icon = BaseApplication.qqwifinotifyusefulicon;
    } else if (BaseApplication.qqWifiConnecticon3 == paramInt2) {
      this.at.icon = BaseApplication.qqwifinotifyconnectedicon;
    } else {
      this.at.icon = paramInt2;
    }
    if (paramString3 != null)
    {
      localObject1 = this.at;
      ((Notification)localObject1).defaults = 1;
      ((Notification)localObject1).tickerText = paramString3;
    }
    else
    {
      localObject1 = this.at;
      ((Notification)localObject1).defaults = 0;
      ((Notification)localObject1).tickerText = "";
    }
    Object localObject1 = this.at;
    ((Notification)localObject1).contentIntent = paramIntent;
    QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_OTHER");
    localQQNotificationManager.notify("QQWiFiScanManager", 481, this.at);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("type=");
      paramIntent.append(paramInt1);
      paramIntent.append(",");
      paramIntent.append(paramString1);
      paramIntent.append(", ");
      paramIntent.append(paramString2);
      paramIntent.append(",");
      paramIntent.append(paramString3);
      QLog.d("QQWiFiScanManager", 2, paramIntent.toString());
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
      if (Build.VERSION.SDK_INT > 10) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      localObject1 = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
    }
    if (localObject1 != null)
    {
      paramSharedPreferences = ((SharedPreferences)localObject1).getString("autoconnect_bssids", "");
      if (!TextUtils.isEmpty(paramSharedPreferences))
      {
        localObject1 = paramSharedPreferences.split("\\|");
        int i3;
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          i3 = localObject1.length;
          i1 = i2;
        }
        while (i1 < i3)
        {
          Object localObject2 = localObject1[i1];
          this.aE.add(localObject2);
          i1 += 1;
          continue;
          this.aE.add(paramSharedPreferences);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateConfig, bssidsString=");
        ((StringBuilder)localObject1).append(paramSharedPreferences);
        ((StringBuilder)localObject1).append(" ssid list=");
        ((StringBuilder)localObject1).append(this.aE.toString());
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void a(MsfCore paramMsfCore)
  {
    h();
    paramMsfCore = new IntentFilter();
    paramMsfCore.addAction("android.intent.action.SCREEN_ON");
    paramMsfCore.addAction("android.intent.action.SCREEN_OFF");
    paramMsfCore.addAction("android.net.wifi.SCAN_RESULTS");
    BaseApplication.getContext().registerReceiver(this.aM, paramMsfCore);
    e();
  }
  
  public static void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject2;
    StringBuilder localStringBuilder;
    if (((String)localObject1).equals("cmd_refresh_steps"))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("MSF_Action_Refresh_Steps:");
        ((StringBuilder)localObject1).append(M);
        QLog.i("health_manager", 2, ((StringBuilder)localObject1).toString());
      }
      if (!M)
      {
        localObject1 = L;
        if (localObject1 != null)
        {
          localObject2 = al;
          if (localObject2 != null)
          {
            ((SensorManager)localObject1).unregisterListener((SensorEventListener)localObject2);
            L = null;
            al = null;
          }
        }
      }
      if ((M) && (H > X) && (H - X <= U))
      {
        X = H;
        a(true, paramString, paramToServiceMsg);
      }
      else
      {
        localObject1 = com.tencent.mobileqq.msf.service.u.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setMsgSuccess();
        localObject2 = ad;
        if (localObject2 != null) {
          ((FromServiceMsg)localObject1).addAttribute("StepInfoJSON", ((JSONObject)localObject2).toString());
        }
        e.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject1);
      }
    }
    else if (((String)localObject1).equals("cmd_health_switch"))
    {
      localObject1 = com.tencent.mobileqq.msf.service.u.a(paramToServiceMsg);
      ((FromServiceMsg)localObject1).setMsgSuccess();
      boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isOpen", Boolean.valueOf(false))).booleanValue();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Action_Register_Step_Listener:");
        ((StringBuilder)localObject2).append(bool);
        QLog.i("health_manager", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool) {}
      try
      {
        if (M) {
          break label412;
        }
        M = true;
        a(O);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label407;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception:");
        localStringBuilder.append(localException2.toString());
        QLog.e("health_manager", 2, localStringBuilder.toString());
        ((FromServiceMsg)localObject1).setMsgFail();
      }
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
      label407:
      label412:
      e.a(paramString, paramToServiceMsg, (FromServiceMsg)localObject1);
    }
    else if (((String)localObject1).equals("cmd_update_lastreport_time"))
    {
      localObject1 = paramToServiceMsg.getAttribute("last_report_time");
      if ((localObject1 instanceof Long)) {
        aa = ((Long)localObject1).longValue();
      }
      if (ad.has("isRestart")) {
        ad.remove("isRestart");
      }
      localObject1 = paramToServiceMsg.getAttribute("has_report_yes");
      if ((!(localObject1 instanceof Boolean)) || (!((Boolean)localObject1).booleanValue())) {
        break label818;
      }
      ad = new JSONObject();
      localObject1 = String.valueOf(g());
    }
    try
    {
      localObject3 = ad;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_offset");
      ((JSONObject)localObject3).put(localStringBuilder.toString(), Y);
      localObject3 = ad;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_init");
      ((JSONObject)localObject3).put(localStringBuilder.toString(), W);
      localObject3 = ad;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_total");
      ((JSONObject)localObject3).put(localStringBuilder.toString(), X);
      ad.put("isStepCounterEnable", M);
      ad.put("last_report_time", aa);
    }
    catch (Exception localException1)
    {
      Object localObject3;
      label693:
      int i1;
      int i2;
      int i3;
      label818:
      break label693;
    }
    break label818;
    if (((String)localObject1).equals("cmd_reset_step"))
    {
      localObject1 = paramToServiceMsg.getAttribute("server_step");
      if ((localObject1 instanceof Integer))
      {
        i1 = X;
        i2 = W;
        i3 = Y;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("reset by server,local:");
        ((StringBuilder)localObject3).append(i1 - i2 + i3);
        ((StringBuilder)localObject3).append(",server:");
        ((StringBuilder)localObject3).append(localObject1);
        QLog.e("health_manager", 1, ((StringBuilder)localObject3).toString());
        W = X;
        Y = ((Integer)localObject1).intValue();
        a(false, null, null);
      }
    }
    localObject1 = am;
    if (localObject1 != null) {
      ((e.a)localObject1).a(paramString, paramToServiceMsg);
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "checkAvailForOperation");
    }
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processWiFiScanResultForBar, hasIntersection=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
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
    if (!a(this.aC, (List)localObject))
    {
      e(paramArrayList);
      this.aC.clear();
      paramArrayList = ((List)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.aC.add(localObject);
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
        boolean bool = QLog.isColorLevel();
        Object localObject;
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("startAutoConnect services all avail:");
          ((StringBuilder)localObject).append(paramList.toString());
          QLog.i("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
        }
        if (!s())
        {
          if (!QLog.isColorLevel()) {
            break label257;
          }
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isEnableAutoconnect false,return");
          return;
        }
        paramList = d(paramList);
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          if (b(paramList))
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in time protected,return");
            return;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("startAutoConnect services:");
            ((StringBuilder)localObject).append(paramList.toString());
            QLog.i("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
          }
          this.aA = System.currentTimeMillis();
          localObject = new Intent("com.tencent.mobileqq.msf.qqwifi.autoconnect");
          ((Intent)localObject).setPackage(BaseApplication.getContext().getPackageName());
          ((Intent)localObject).putExtra("services", new ArrayList(paramList));
          BaseApplication.getContext().sendBroadcast((Intent)localObject);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect services empty after filtered,return");
        }
        return;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          paramList.printStackTrace();
        }
      }
    } else {
      return;
    }
    label257:
    return;
  }
  
  public static void a(boolean paramBoolean, String paramString, ToServiceMsg paramToServiceMsg)
  {
    if (X != 0.0F)
    {
      if (!Z.get()) {
        return;
      }
      if (ak.get())
      {
        QLog.e("health_manager", 1, "writing file,return");
        return;
      }
      ak.set(true);
      new Thread(new ab(paramBoolean, paramString, paramToServiceMsg)).start();
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (!bool2)
    {
      Object localObject1 = BaseApplication.getContext();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((Context)localObject1).getPackageName());
      ((StringBuilder)localObject2).append("_preferences");
      localObject2 = ((StringBuilder)localObject2).toString();
      int i1;
      if (Build.VERSION.SDK_INT > 10) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      localObject1 = ((Context)localObject1).getSharedPreferences((String)localObject2, i1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("login_auto");
      ((StringBuilder)localObject2).append(paramString);
      bool1 = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
    }
    return bool1;
  }
  
  private boolean a(List paramList1, List paramList2)
  {
    if ((paramList1 != null) && (paramList2 != null) && (paramList1.size() > 0))
    {
      Iterator localIterator = paramList2.iterator();
      int i1 = 0;
      while ((localIterator.hasNext()) && (paramList1.contains(localIterator.next()))) {
        i1 += 1;
      }
      if (i1 == paramList2.size()) {
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    int i1 = 4;
    int i2 = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      localObject1 = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        i1 = 0;
      }
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("qqwifi", i1);
      this.as.e = ((SharedPreferences)localObject1).getBoolean("availNotificationSwitch", false);
      return;
    case 5: 
      a(null);
      return;
    case 4: 
      b(null);
      return;
    case 3: 
      w();
      return;
    case 2: 
      localObject1 = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        i1 = 0;
      }
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("mobileQQ", i1);
      if (localObject1 != null)
      {
        localObject2 = this.as;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("bar_switch_operation");
        ((StringBuilder)localObject3).append(this.as.c);
        ((u.a)localObject2).d = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject3).toString(), 0);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateConfig, BarSwitch=");
          ((StringBuilder)localObject1).append(this.as.d);
          QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (this.as.d == -1)
        {
          this.aH = false;
          this.au = 0;
          return;
        }
      }
      break;
    case 1: 
      localObject1 = new File(this.ar.getDir("qqwifi_dir", 0), "ssids_file");
      if (!((File)localObject1).exists()) {
        break;
      }
    }
    try
    {
      localObject3 = new JSONObject(a((File)localObject1)).getJSONArray("ssidList");
      localObject1 = "";
      i1 = ((JSONArray)localObject3).length();
      paramInt = i2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label671:
        label686:
        continue;
        paramInt += 1;
      }
    }
    if (paramInt < ((JSONArray)localObject3).length())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(((JSONArray)localObject3).get(paramInt).toString());
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (paramInt < i1 - 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("|");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      this.as.a = ((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateConfig, pattern - ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("QQWiFiScanManager", 2, "updateConfig, ssids_file exception");
          return;
          localObject1 = new File(this.ar.getDir("qqwifi_dir", 0), "enable_file");
          if (!((File)localObject1).exists()) {}
        }
      }
      try
      {
        localObject1 = new JSONObject(a((File)localObject1));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mIsQQWiFiEnable_");
        ((StringBuilder)localObject2).append(this.as.c);
        if (((JSONObject)localObject1).has(((StringBuilder)localObject2).toString())) {
          this.as.b = false;
        }
        if (!QLog.isColorLevel()) {
          break label686;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateConfig, mIsQQWiFiEnable_");
        ((StringBuilder)localObject1).append(this.as.c);
        ((StringBuilder)localObject1).append("=");
        ((StringBuilder)localObject1).append(this.as.b);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      catch (Exception localException2)
      {
        break label671;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQWiFiScanManager", 2, "updateConfig, enable_file exception");
      }
      return;
    }
  }
  
  private void b(SharedPreferences paramSharedPreferences)
  {
    SharedPreferences localSharedPreferences = paramSharedPreferences;
    if (paramSharedPreferences == null)
    {
      paramSharedPreferences = BaseApplication.getContext();
      int i1;
      if (Build.VERSION.SDK_INT > 10) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      localSharedPreferences = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
    }
    if (localSharedPreferences != null)
    {
      paramSharedPreferences = this.as;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("autoconnect_switch_operation");
      localStringBuilder.append(this.as.c);
      paramSharedPreferences.m = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
      if (QLog.isColorLevel())
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("updateConfig, AutoSwitch=");
        paramSharedPreferences.append(this.as.m);
        QLog.d("QQWiFiScanManager", 2, paramSharedPreferences.toString());
      }
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processWiFiScanResultForBar, hasIntersection=");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool)
    {
      if (p())
      {
        if (n()) {
          a(1008, "", false, false);
        }
      }
      else {
        a(1001, "", false, false);
      }
      d(paramArrayList);
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject3;
    d locald;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      localObject3 = paramArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        locald = (d)((Iterator)localObject3).next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(locald.a);
        localStringBuilder.append(",");
        localStringBuilder.append(locald.b);
        localStringBuilder.append(",");
        localStringBuilder.append(locald.c);
        localStringBuilder.append("|");
        ((StringBuilder)localObject2).append(localStringBuilder.toString());
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("scanlist before filter:");
      ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
      QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d)((Iterator)localObject2).next();
      if (((d)localObject3).c < -80) {
        ((Iterator)localObject2).remove();
      } else {
        ((List)localObject1).add(((d)localObject3).b);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      localObject3 = paramArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        locald = (d)((Iterator)localObject3).next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(locald.a);
        localStringBuilder.append(",");
        localStringBuilder.append(locald.b);
        localStringBuilder.append(",");
        localStringBuilder.append(locald.c);
        localStringBuilder.append("|");
        ((StringBuilder)localObject2).append(localStringBuilder.toString());
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("scanlist after filter:");
      ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
      QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject3).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bssidSet:");
      ((StringBuilder)localObject2).append(localObject1.toString());
      QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
    }
    bool = a(this.aB, (List)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processWiFiScanResultForBar, isSubset=");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", bssidSet.size=");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (!bool)
    {
      e(paramArrayList);
      this.aB.clear();
      this.aB.addAll((Collection)localObject1);
    }
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
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean b(String paramString)
  {
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace("\"", "");
      Pattern localPattern = Pattern.compile(this.as.a);
      boolean bool2 = localPattern.matcher(paramString).matches();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isQQWiFi, ");
        localStringBuilder.append(localPattern);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", ");
        localStringBuilder.append(bool2);
        QLog.d("QQWiFiScanManager", 2, localStringBuilder.toString());
        return bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean b(List paramList)
  {
    Object localObject = BaseApplication.getContext();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
    if (localObject != null)
    {
      long l1 = ((SharedPreferences)localObject).getLong("autoconnect_reference_time", 0L);
      long l2 = System.currentTimeMillis() - l1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isInAutoconnectIntervalProtected lasttime=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" interval=");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(" autoConnectProtectedInterval=");
        ((StringBuilder)localObject).append(this.as.n);
        QLog.i("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((l2 < this.as.n) && (c(paramList))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean c(int paramInt)
  {
    u.a locala;
    if (!this.aH)
    {
      locala = null;
      try
      {
        localObject = ((WifiManager)this.ar.getSystemService("wifi")).getScanResults();
      }
      catch (Exception localException)
      {
        localObject = locala;
        if (QLog.isColorLevel())
        {
          QLog.d("QQWiFiScanManager", 2, localException.getMessage());
          localObject = locala;
        }
      }
      if (localObject == null) {
        break label342;
      }
      if (((List)localObject).size() <= 0) {
        return false;
      }
    }
    if (!this.aF)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, not registered.");
      }
      return false;
    }
    Object localObject = BaseApplication.getContext();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
    if ((localObject != null) && (!TextUtils.isEmpty(this.as.c)))
    {
      locala = this.as;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bar_switch_operation");
      localStringBuilder.append(this.as.c);
      locala.d = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("canPushNotification, BarSwitch=");
        ((StringBuilder)localObject).append(this.as.d);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((p()) && (paramInt != 1008))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, bar closed.");
      }
      return false;
    }
    localObject = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).getType() == 1) && (paramInt == 1001))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, dont push qqwifi info while wifi is connected");
      }
      return false;
    }
    return a(this.as.c);
    label342:
    return false;
  }
  
  private boolean c(ArrayList paramArrayList)
  {
    if (this.aD != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.aD.iterator();
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
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((List)localObject).add(((WiFiService)paramList.next()).wifi.b);
    }
    int i2 = Math.min(Math.min(((List)localObject).size(), this.aE.size()), this.as.o);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("lastAutoBssids=");
      paramList.append(this.aE.toString());
      paramList.append(" curSet:");
      paramList.append(localObject.toString());
      paramList.append(" isSubSet= maxAutoConnecttimes=");
      paramList.append(this.as.o);
      paramList.append(" min=");
      paramList.append(i2);
      QLog.i("QQWiFiScanManager", 2, paramList.toString());
    }
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = (String)((List)localObject).get(i1);
      if (this.aE.contains(paramList))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("return true:");
          ((StringBuilder)localObject).append(paramList);
          ((StringBuilder)localObject).append("has already tryed i=");
          ((StringBuilder)localObject).append(i1);
          QLog.i("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      i1 += 1;
    }
    k();
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
      if ((localWiFiService.autoConnFlag == 1) && (localArrayList.size() < this.as.o)) {
        localArrayList.add(localWiFiService);
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("after filtered:");
      paramList.append(localArrayList.toString());
      QLog.i("QQWiFiScanManager", 2, paramList.toString());
    }
    return localArrayList;
  }
  
  private void d(ArrayList paramArrayList)
  {
    if (s())
    {
      boolean bool2 = false;
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.aD.iterator();
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
        bool1 = bool2;
        if (!paramArrayList.hasNext()) {
          break;
        }
      } while (!localHashSet.contains(((d)paramArrayList.next()).b));
      boolean bool1 = true;
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("processWiFiScanResultForBar, hasAutoIntersection=");
        paramArrayList.append(bool1);
        QLog.d("QQWiFiScanManager", 2, paramArrayList.toString());
      }
      if (bool1) {
        a(this.aD);
      }
    }
  }
  
  private void e(ArrayList paramArrayList)
  {
    try
    {
      this.az = System.currentTimeMillis();
      int i1 = o();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAvailableQQWifi size:");
        ((StringBuilder)localObject).append(paramArrayList.size());
        ((StringBuilder)localObject).append(" scanType=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" needcallback=");
        ((StringBuilder)localObject).append(true);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("UTF-8");
      a locala = new a();
      locala.a = paramArrayList;
      locala.b = c.f(this.ar);
      locala.c = "Android";
      locala.d = i1;
      ((UniPacket)localObject).setServantName("MQQ.QQWiFiMgrServer.QQWiFiMgrObj");
      ((UniPacket)localObject).setFuncName("AvailQQWiFiForMSF");
      ((UniPacket)localObject).put("req", locala);
      paramArrayList = ((UniPacket)localObject).encode();
      localObject = new ToServiceMsg("mobileqq.service", this.as.c, "QQWifiSvc.AvailQQWiFiForMSF");
      ((ToServiceMsg)localObject).setAppId(this.aq.sender.m());
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setTimeout(20000L);
      ((ToServiceMsg)localObject).setNeedCallback(true);
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayList);
      ((ToServiceMsg)localObject).addAttribute("isformsf", Boolean.valueOf(true));
      this.aq.sendSsoMsg((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramArrayList)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAvailableQQWifi exp:");
        ((StringBuilder)localObject).append(paramArrayList);
        QLog.e("QQWiFiScanManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static int f()
  {
    return X - W + Y;
  }
  
  static long g()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private void h()
  {
    if (this.aG) {
      return;
    }
    this.aG = true;
    j();
    i();
    w();
  }
  
  private void i()
  {
    Object localObject1 = this.ar;
    i1 = 0;
    localObject1 = ((Context)localObject1).getDir("qqwifi_dir", 0);
    Object localObject2 = new File((File)localObject1, "enable_file");
    if (((File)localObject2).exists()) {}
    try
    {
      localObject2 = new JSONObject(a((File)localObject2));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mIsQQWiFiEnable_");
      ((StringBuilder)localObject3).append(this.as.c);
      if (!((JSONObject)localObject2).has(((StringBuilder)localObject3).toString())) {
        break label192;
      }
      this.as.b = false;
      if (!QLog.isColorLevel()) {
        break label192;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initConfig, mIsQQWiFiEnable_");
      ((StringBuilder)localObject2).append(this.as.c);
      ((StringBuilder)localObject2).append("=");
      ((StringBuilder)localObject2).append(this.as.b);
      QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
    }
    catch (Exception localException2)
    {
      Object localObject3;
      label177:
      label192:
      break label177;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQWiFiScanManager", 2, "initConfig, enable_file exception");
    }
    localObject1 = new File((File)localObject1, "ssids_file");
    if (((File)localObject1).exists()) {}
    try
    {
      localObject3 = new JSONObject(a((File)localObject1)).getJSONArray("ssidList");
      localObject1 = "";
      i2 = ((JSONArray)localObject3).length();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i2;
        continue;
        i1 += 1;
      }
    }
    if (i1 < ((JSONArray)localObject3).length())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(((JSONArray)localObject3).get(i1).toString());
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (i1 < i2 - 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("|");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      this.as.a = ((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initConfig, pattern - ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.e("QQWiFiScanManager", 2, "initConfig, ssids_file exception");
        }
      }
      return;
    }
  }
  
  private void j()
  {
    Object localObject1 = BaseApplication.getContext();
    int i1 = Build.VERSION.SDK_INT;
    int i2 = 4;
    if (i1 > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i1);
    if (localObject1 != null)
    {
      this.as.c = ((SharedPreferences)localObject1).getString("uin", "");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lastLoginUin = ");
        ((StringBuilder)localObject1).append(this.as.c);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
    localObject1 = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences("mobileQQ", i1);
    if (localObject1 != null)
    {
      Object localObject2 = this.as;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bar_switch_operation");
      localStringBuilder.append(this.as.c);
      ((u.a)localObject2).d = ((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), 0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initConfig, barOperation=");
        ((StringBuilder)localObject2).append(this.as.d);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
      }
      a((SharedPreferences)localObject1);
      b((SharedPreferences)localObject1);
    }
    ((SharedPreferences)localObject1).edit().putBoolean("hasPushedAvailNotification", false).commit();
  }
  
  private void k()
  {
    Object localObject = BaseApplication.getContext();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i1);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().remove("autoconnect_bssids").commit();
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onAccountChange");
    }
    b(0);
    b(2);
    b(4);
    b(3);
    if ((this.aF) && (this.aH) && (p()))
    {
      QQNotificationManager.getInstance().cancel("QQWiFiScanManager", 481);
      this.aH = false;
      this.au = 0;
    }
  }
  
  private boolean m()
  {
    if (!this.as.b) {
      return false;
    }
    if (this.aK) {
      return false;
    }
    Object localObject1 = BaseApplication.getContext();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i1);
    String str = "";
    localObject1 = ((SharedPreferences)localObject1).getString("uin", "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return false;
    }
    Object localObject2;
    if (!((String)localObject1).equals(this.as.c))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onAccountChange, ");
        ((StringBuilder)localObject2).append(this.as.c);
        ((StringBuilder)localObject2).append(", ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
      }
      this.as.c = ((String)localObject1);
      l();
    }
    if (!a(this.as.c)) {
      return false;
    }
    if (!this.aJ) {
      return false;
    }
    if (!this.aF) {
      return false;
    }
    localObject1 = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject1 != null) && (((NetworkInfo)localObject1).getType() == 1))
    {
      localObject2 = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (!TextUtils.isEmpty(((WifiInfo)localObject2).getSSID())) {
          localObject1 = ((WifiInfo)localObject2).getSSID().replace("\"", "");
        }
      }
      if (!b((String)localObject1)) {
        a(1007, (String)localObject1, false, false);
      }
      return false;
    }
    if ((localObject1 != null) && (((NetworkInfo)localObject1).isAvailable()))
    {
      i1 = o();
      if (i1 <= 0) {
        return n();
      }
      if (i1 == 2)
      {
        if (n()) {
          return true;
        }
        if (System.currentTimeMillis() - this.az < this.as.k) {
          return false;
        }
      }
      return true;
    }
    a(1003, "", false, false);
    return false;
  }
  
  private boolean n()
  {
    if (this.aL == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, availpush=0");
      }
      return false;
    }
    Object localObject = BaseApplication.getContext();
    int i1;
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("qqwifi", i1);
    long l1 = ((SharedPreferences)localObject).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
    if (System.currentTimeMillis() - l1 < 21600000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, time limit");
      }
      return false;
    }
    if (!((SharedPreferences)localObject).getBoolean("availNotificationSwitch", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushAvailableWiFiToBarClosedUser, avail switch is turned off");
      }
      return false;
    }
    return true;
  }
  
  private int o()
  {
    if (!p()) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1 = i2;
    if (this.as.g) {
      i1 = i2 | 0x2;
    }
    int i2 = i1;
    if (q()) {
      i2 = i1 | 0x4;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scantype=");
      localStringBuilder.append(i2);
      QLog.i("QQWiFiScanManager", 2, localStringBuilder.toString());
    }
    return i2;
  }
  
  private boolean p()
  {
    if (this.as.d == 1) {
      return false;
    }
    if (this.as.d == -1) {
      return true;
    }
    return !this.as.f;
  }
  
  private boolean q()
  {
    if (!this.as.b) {
      return false;
    }
    if (this.as.m == 1) {
      return true;
    }
    if (this.as.m == -1) {
      return false;
    }
    return this.as.l;
  }
  
  private void r()
  {
    if (!this.as.b) {
      return;
    }
    boolean bool = b(this.ar);
    String str1 = "";
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (!bool)
    {
      localObject2 = a(this.ar, p());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = Pattern.compile((String)localObject2);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("NotNetworkSupportSsidList pattern: ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject3).toString());
        }
        localObject2 = ((WifiManager)this.ar.getSystemService("wifi")).getScanResults();
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
          if (!((ArrayList)localObject3).isEmpty())
          {
            if (p())
            {
              localObject1 = BaseApplication.getContext();
              if (Build.VERSION.SDK_INT > 10) {
                i1 = 4;
              } else {
                i1 = 0;
              }
              long l1 = ((BaseApplication)localObject1).getSharedPreferences("qqwifi", i1).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
              if ((l1 > 0L) && (System.currentTimeMillis() - l1 < 21600000L)) {
                break label343;
              }
              a(1008, "", false, true);
            }
            else
            {
              a(1001, "", false, true);
            }
            i1 = 1;
            break label345;
          }
        }
      }
    }
    label343:
    int i1 = 0;
    label345:
    if (i1 != 0) {
      return;
    }
    if (m())
    {
      this.ay = System.currentTimeMillis();
      localObject5 = new ArrayList();
      if ((!TextUtils.isEmpty(this.as.a)) || (!TextUtils.isEmpty(this.as.q)))
      {
        if (!TextUtils.isEmpty(this.as.a)) {
          localObject1 = Pattern.compile(this.as.a);
        } else {
          localObject1 = null;
        }
        if (!TextUtils.isEmpty(this.as.q)) {
          localObject2 = Pattern.compile(this.as.q);
        } else {
          localObject2 = null;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("pattern: ");
          ((StringBuilder)localObject3).append(this.as.a);
          ((StringBuilder)localObject3).append(" reportPattern: ");
          ((StringBuilder)localObject3).append(this.as.q);
          QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject3).toString());
        }
        localObject6 = ((WifiManager)this.ar.getSystemService("wifi")).getScanResults();
        if (localObject6 != null)
        {
          i1 = 0;
          while (i1 < ((List)localObject6).size())
          {
            ScanResult localScanResult = (ScanResult)((List)localObject6).get(i1);
            String str2 = localScanResult.SSID.replace("\"", "");
            if (localObject1 != null) {
              localObject3 = ((Pattern)localObject1).matcher(str2);
            } else {
              localObject3 = null;
            }
            if (localObject2 != null) {
              localObject4 = ((Pattern)localObject2).matcher(str2);
            } else {
              localObject4 = null;
            }
            if (((localObject3 != null) && (((Matcher)localObject3).matches())) || ((localObject4 != null) && (((Matcher)localObject4).matches())))
            {
              localObject3 = new d();
              ((d)localObject3).a = str2;
              ((d)localObject3).b = localScanResult.BSSID;
              ((d)localObject3).c = ((short)localScanResult.level);
              ((ArrayList)localObject5).add(localObject3);
            }
            i1 += 1;
          }
        }
      }
      if (((ArrayList)localObject5).isEmpty())
      {
        k();
        localObject1 = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
        localObject2 = (WifiManager)this.ar.getSystemService("wifi");
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
        if ((((NetworkInfo)localObject1).getType() != 1) && (((NetworkInfo)localObject1).getType() != 9))
        {
          a(1009, "", false, false);
          return;
        }
        localObject2 = ((WifiManager)localObject2).getConnectionInfo();
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (!TextUtils.isEmpty(((WifiInfo)localObject2).getSSID())) {
            localObject1 = ((WifiInfo)localObject2).getSSID().replace("\"", "");
          }
        }
        a(1007, (String)localObject1, false, false);
        return;
      }
      i1 = o();
      if (((i1 & 0x1) <= 0) && (!n()))
      {
        if (((i1 & 0x2) > 0) || ((0x4 & i1) > 0)) {
          a((ArrayList)localObject5);
        }
      }
      else {
        b((ArrayList)localObject5);
      }
    }
  }
  
  private boolean s()
  {
    if (this.aK)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "CurUinQuited,return");
      }
      return false;
    }
    if (System.currentTimeMillis() - this.aA < 60000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in frequency limit,return");
      }
      return false;
    }
    if (!q())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isOpened false,return");
      }
      return false;
    }
    if (!t())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isDeviceSituationOk false,return");
      }
      return false;
    }
    if (!u())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isCurNetstatuAvailForAutoconnect false,return");
      }
      return false;
    }
    return true;
  }
  
  private boolean t()
  {
    return this.aJ;
  }
  
  private boolean u()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {
      return localNetworkInfo.getType() != 1;
    }
    return false;
  }
  
  private boolean v()
  {
    if (!this.aI)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "startAccScan");
      }
      new x(this).start();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "startAccScan, already running.");
    }
    return false;
  }
  
  private void w()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a(this.ar);
        if (localObject1 != null)
        {
          String str1 = (String)((Map)localObject1).get("QuickScanTimes");
          if (str1 != null)
          {
            try
            {
              this.as.h = Integer.parseInt(str1);
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "init QuickScanTimes:", localNumberFormatException1);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("loadParams, accScanTimes=");
              ((StringBuilder)localObject2).append(this.as.h);
              QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
            }
          }
          Object localObject2 = (String)((Map)localObject1).get("QuickScanInterval");
          if (localObject2 != null)
          {
            try
            {
              this.as.i = (Integer.parseInt((String)localObject2) * 1000);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "init mAccScanInterval:", localNumberFormatException2);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("loadParams, accScanTimes=");
              ((StringBuilder)localObject3).append(this.as.i);
              QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject3).toString());
            }
          }
          Object localObject3 = (String)((Map)localObject1).get("barstatechangeinterval");
          if (localObject3 != null) {
            try
            {
              this.as.j = (Integer.parseInt((String)localObject3) * 1000);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("loadParams, barstatechangeinterval=");
                ((StringBuilder)localObject3).append(this.as.j);
                QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject3).toString());
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "loadParams, barstatechangeinterval:", localNumberFormatException3);
              }
            }
          }
          String str2 = (String)((Map)localObject1).get("systemNotifyBarSwitch");
          Object localObject6 = this.as;
          bool1 = "1".equals(str2);
          boolean bool2 = true;
          if (!bool1) {
            break label1191;
          }
          bool1 = true;
          ((u.a)localObject6).f = bool1;
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("systemNotifyBarSwitch=");
            ((StringBuilder)localObject6).append(this.as.f);
            ((StringBuilder)localObject6).append(", ");
            ((StringBuilder)localObject6).append(str2);
            QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject6).toString());
          }
          str2 = (String)((Map)localObject1).get("QQWiFiActivitySwitch");
          localObject6 = this.as;
          if (!"1".equals(str2)) {
            break label1196;
          }
          bool1 = true;
          ((u.a)localObject6).g = bool1;
          bool1 = QLog.isColorLevel();
          if (bool1)
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("QQWiFiActivitySwitch=");
            ((StringBuilder)localObject6).append(this.as.g);
            ((StringBuilder)localObject6).append(",");
            ((StringBuilder)localObject6).append(str2);
            QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject6).toString());
          }
          str2 = (String)((Map)localObject1).get("autoConnectSwitch");
          localObject6 = this.as;
          if (!"1".equals(str2)) {
            break label1201;
          }
          bool1 = true;
          ((u.a)localObject6).l = bool1;
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("autoConnectFlag=");
            ((StringBuilder)localObject6).append(this.as.l);
            ((StringBuilder)localObject6).append(",");
            ((StringBuilder)localObject6).append(str2);
            QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject6).toString());
          }
          str2 = (String)((Map)localObject1).get("autoConnectProtectedInterval");
          if (str2 != null)
          {
            try
            {
              this.as.n = (Long.parseLong(str2) * 1000L);
            }
            catch (NumberFormatException localNumberFormatException4)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "init autoConnectProtectedInterval:", localNumberFormatException4);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("loadParams, autoConnectProtectedInterval=");
              ((StringBuilder)localObject4).append(this.as.n);
              QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject4).toString());
            }
          }
          Object localObject4 = (String)((Map)localObject1).get("autoMaxconnecttimes");
          if (localObject4 != null)
          {
            try
            {
              this.as.o = Integer.parseInt((String)localObject4);
            }
            catch (Exception localException5)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "init maxAutoConnecttimes:", localException5);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("loadParams, maxAutoConnecttimes=");
              ((StringBuilder)localObject7).append(this.as.o);
              QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject7).toString());
            }
          }
          Object localObject7 = (String)((Map)localObject1).get("autoMaxconnecttimes");
          if (localObject7 != null)
          {
            try
            {
              localObject7 = this.as;
              if (!((String)localObject4).equals("1")) {
                break label1206;
              }
              bool1 = bool2;
              ((u.a)localObject7).p = bool1;
            }
            catch (Exception localException3)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "init isRootReport:", localException3);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("loadParams, isRootReport=");
              ((StringBuilder)localObject5).append(this.as.p);
              QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject5).toString());
            }
          }
          Object localObject5 = (String)((Map)localObject1).get("noNetSupport");
          if (localObject5 != null)
          {
            try
            {
              this.as.r = ((String)localObject5).replaceAll("\\\\", "");
            }
            catch (Exception localException4)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "init noNetSupport:", localException4);
              }
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("loadParams, noNetSupport=");
              localStringBuilder2.append(this.as.r);
              QLog.d("QQWiFiScanManager", 2, localStringBuilder2.toString());
            }
          }
          localObject1 = (String)((Map)localObject1).get("onlyReport");
          if (localObject1 != null)
          {
            try
            {
              this.as.q = ((String)localObject1);
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQWiFiScanManager", 2, "init reportPattern:", localException1);
              }
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("loadParams, reportPattern=");
              localStringBuilder1.append(this.as.q);
              QLog.d("QQWiFiScanManager", 2, localStringBuilder1.toString());
              return;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQWiFiScanManager", 2, localException2.toString());
        }
      }
      return;
      label1191:
      boolean bool1 = false;
      continue;
      label1196:
      bool1 = false;
      continue;
      label1201:
      bool1 = false;
      continue;
      label1206:
      bool1 = false;
    }
  }
  
  /* Error */
  public String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_1
    //   10: ifnull +215 -> 225
    //   13: aload_1
    //   14: invokevirtual 1093	java/io/File:exists	()Z
    //   17: ifne +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: ldc_w 256
    //   25: astore_2
    //   26: aload 4
    //   28: astore_3
    //   29: new 197	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   36: astore 7
    //   38: aload 4
    //   40: astore_3
    //   41: new 1599	java/io/BufferedReader
    //   44: dup
    //   45: new 1601	java/io/FileReader
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 1604	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   53: invokespecial 1607	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   56: astore_1
    //   57: aload_2
    //   58: astore_3
    //   59: aload_2
    //   60: astore 4
    //   62: aload_1
    //   63: invokevirtual 1610	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +19 -> 89
    //   73: aload_2
    //   74: astore_3
    //   75: aload_2
    //   76: astore 4
    //   78: aload 7
    //   80: aload 5
    //   82: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: goto -29 -> 57
    //   89: aload_2
    //   90: astore_3
    //   91: aload_2
    //   92: astore 4
    //   94: aload 7
    //   96: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_2
    //   100: aload_2
    //   101: astore_3
    //   102: aload_2
    //   103: astore 4
    //   105: aload_1
    //   106: invokevirtual 1613	java/io/BufferedReader:close	()V
    //   109: aload_2
    //   110: astore_3
    //   111: aload_1
    //   112: invokevirtual 1613	java/io/BufferedReader:close	()V
    //   115: aload_2
    //   116: areturn
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 1614	java/io/IOException:printStackTrace	()V
    //   122: aload_3
    //   123: areturn
    //   124: astore_2
    //   125: aload_1
    //   126: astore_3
    //   127: aload_2
    //   128: astore_1
    //   129: goto +78 -> 207
    //   132: astore 4
    //   134: aload_3
    //   135: astore_2
    //   136: goto +22 -> 158
    //   139: astore_3
    //   140: aload 4
    //   142: astore_2
    //   143: aload_3
    //   144: astore 4
    //   146: goto +38 -> 184
    //   149: astore_1
    //   150: goto +57 -> 207
    //   153: astore 4
    //   155: aload 5
    //   157: astore_1
    //   158: aload_1
    //   159: astore_3
    //   160: aload 4
    //   162: invokevirtual 1614	java/io/IOException:printStackTrace	()V
    //   165: aload_2
    //   166: astore_3
    //   167: aload_1
    //   168: ifnull +37 -> 205
    //   171: aload_2
    //   172: astore_3
    //   173: aload_1
    //   174: invokevirtual 1613	java/io/BufferedReader:close	()V
    //   177: aload_2
    //   178: areturn
    //   179: astore 4
    //   181: aload 6
    //   183: astore_1
    //   184: aload_1
    //   185: astore_3
    //   186: aload 4
    //   188: invokevirtual 1615	java/io/FileNotFoundException:printStackTrace	()V
    //   191: aload_2
    //   192: astore_3
    //   193: aload_1
    //   194: ifnull +11 -> 205
    //   197: aload_2
    //   198: astore_3
    //   199: aload_1
    //   200: invokevirtual 1613	java/io/BufferedReader:close	()V
    //   203: aload_2
    //   204: astore_3
    //   205: aload_3
    //   206: areturn
    //   207: aload_3
    //   208: ifnull +15 -> 223
    //   211: aload_3
    //   212: invokevirtual 1613	java/io/BufferedReader:close	()V
    //   215: goto +8 -> 223
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 1614	java/io/IOException:printStackTrace	()V
    //   223: aload_1
    //   224: athrow
    //   225: aconst_null
    //   226: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	u
    //   0	227	1	paramFile	File
    //   25	91	2	str1	String
    //   124	4	2	localObject1	Object
    //   135	69	2	localObject2	Object
    //   218	2	2	localIOException1	java.io.IOException
    //   28	107	3	localObject3	Object
    //   139	5	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   159	53	3	localObject4	Object
    //   7	97	4	localObject5	Object
    //   132	9	4	localIOException2	java.io.IOException
    //   144	1	4	localObject6	Object
    //   153	8	4	localIOException3	java.io.IOException
    //   179	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	155	5	str2	String
    //   4	178	6	localObject7	Object
    //   36	59	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   111	115	117	java/io/IOException
    //   173	177	117	java/io/IOException
    //   199	203	117	java/io/IOException
    //   62	68	124	finally
    //   78	86	124	finally
    //   94	100	124	finally
    //   105	109	124	finally
    //   62	68	132	java/io/IOException
    //   78	86	132	java/io/IOException
    //   94	100	132	java/io/IOException
    //   105	109	132	java/io/IOException
    //   62	68	139	java/io/FileNotFoundException
    //   78	86	139	java/io/FileNotFoundException
    //   94	100	139	java/io/FileNotFoundException
    //   105	109	139	java/io/FileNotFoundException
    //   29	38	149	finally
    //   41	57	149	finally
    //   160	165	149	finally
    //   186	191	149	finally
    //   29	38	153	java/io/IOException
    //   41	57	153	java/io/IOException
    //   29	38	179	java/io/FileNotFoundException
    //   41	57	179	java/io/FileNotFoundException
    //   211	215	218	java/io/IOException
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (!this.as.b) {
      return;
    }
    int i1;
    switch (paramInt)
    {
    case 1002: 
    case 1005: 
    case 1006: 
    default: 
      return;
    case 1009: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "未连接任何WiFi", "xxx", null);
      return;
    case 1008: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiUserful, "当前有免费WiFi，点击查看", "试试一键连接", "当前有可用的QQ WiFi，点击进入连接");
      paramString = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        paramInt = 4;
      } else {
        paramInt = 0;
      }
      paramString.getSharedPreferences("qqwifi", paramInt).edit().putLong("lastPushAvailableWiFiToBarClosedUser", System.currentTimeMillis()).commit();
      a(3, null);
      return;
    case 1007: 
      localIntent = new Intent("com.tencent.mobileqq.action.QQWiFi");
      i1 = BaseApplication.qqWifiConnecticon3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("已连接 ");
      localStringBuilder.append(paramString);
      a(localIntent, paramInt, i1, localStringBuilder.toString(), "快来赚取免费QQ WiFi时长", null);
      return;
    case 1004: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "已关闭无线网络", "打开后查看", null);
      return;
    case 1003: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), paramInt, BaseApplication.qqWifiNoSignal, "网络连接不可用", "网络恢复后查看", null);
      return;
    }
    Intent localIntent = new Intent("com.tencent.mobileqq.action.QQWiFi");
    localIntent.putExtra("hasvailable", true);
    if (paramBoolean)
    {
      i1 = BaseApplication.qqWifiUserful;
      if (TextUtils.isEmpty(paramString)) {
        paramString = "当前有免费WiFi，点击查看";
      }
      a(localIntent, paramInt, i1, paramString, "试试一键连接", "当前有可用的 QQ WiFi,点击进入连接");
    }
    else
    {
      i1 = BaseApplication.qqWifiUserful;
      if (TextUtils.isEmpty(paramString)) {
        paramString = "当前有免费WiFi，点击查看";
      }
      a(localIntent, paramInt, i1, paramString, "试试一键连接", null);
    }
    a(1, null);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.aK)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onResponseWifiStatechange isCurUinQuited true, return");
      }
      return;
    }
    int i2 = paramIntent.getIntExtra("wifi_state", 0);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(" onResponseWifiStatechange, wifiState=");
      paramIntent.append(i2);
      QLog.i("QQWiFiScanManager", 2, paramIntent.toString());
    }
    int i1 = 1;
    if (i2 != 1)
    {
      if (i2 != 3) {
        return;
      }
      paramIntent = (ConnectivityManager)this.ar.getSystemService("connectivity");
    }
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getAllNetworkInfo();
        if ((paramIntent == null) || (paramIntent.length <= 0) || (paramIntent[0].getState() != NetworkInfo.State.CONNECTED)) {
          break label175;
        }
        if (i1 != 0) {
          break label174;
        }
        a(1003, "", false, false);
        return;
      }
      catch (Throwable paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label174;
        }
      }
      QLog.e("QQWiFiScanManager", 2, paramIntent, new Object[0]);
      return;
      a(1004, "", false, false);
      label174:
      return;
      label175:
      i1 = 0;
    }
  }
  
  public void a(MsfCore paramMsfCore, boolean paramBoolean)
  {
    if (this.aF)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "QQWifi already register.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQWifi register,isSyncRegister=");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQWiFiScanManager", 2, localStringBuilder.toString());
    }
    this.aq = paramMsfCore;
    this.aF = true;
    if (paramBoolean)
    {
      a(paramMsfCore);
      return;
    }
    new Thread(new w(this, paramMsfCore)).start();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvAvailResponse :");
      if (paramFromServiceMsg == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = paramFromServiceMsg.toString();
      }
      localStringBuilder.append(paramToServiceMsg);
      QLog.d("QQWiFiScanManager", 2, localStringBuilder.toString());
    }
    int i2;
    int i1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      i2 = 1;
      i1 = 1;
      paramToServiceMsg = new UniPacket(true);
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (b)paramToServiceMsg.getByClass("rsp", new b());
      if ((paramToServiceMsg != null) && (paramToServiceMsg.a == 0))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onRecvAvailResponse, availpush=");
          paramFromServiceMsg.append(paramToServiceMsg.d);
          QLog.d("QQWiFiScanManager", 2, paramFromServiceMsg.toString());
        }
        this.aL = paramToServiceMsg.d;
        if (!paramToServiceMsg.b.isEmpty())
        {
          if (p())
          {
            if ((this.as.e) && (this.aL == 1)) {
              a(1008, "", false, false);
            }
          }
          else {
            a(1001, "", false, false);
          }
          if (a(this.aD, paramToServiceMsg.b))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, isSubset=true");
            }
          }
          else {
            v();
          }
          this.aD.clear();
          this.aD.addAll(paramToServiceMsg.b);
          return;
        }
        try
        {
          paramToServiceMsg = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
            break label456;
          }
          if (i1 != 0) {
            break label455;
          }
          a(1009, "", false, false);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            break label455;
          }
        }
        QLog.e("QQWiFiScanManager", 2, "onRecvAvailResponse, qqwifi not avail", paramToServiceMsg);
        return;
      }
      this.aB.clear();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.getType() != 1)) {
          break label461;
        }
        i1 = i2;
        if (i1 != 0) {
          break label455;
        }
        a(1009, "", false, false);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break label455;
        }
      }
      QLog.e("QQWiFiScanManager", 2, "onRecvAvailResponse, qqwifi not avail", paramToServiceMsg);
      return;
      this.aB.clear();
      label455:
      return;
      label456:
      i1 = 0;
      break;
      label461:
      i1 = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.aK = paramBoolean;
    if (paramBoolean) {
      QQNotificationManager.getInstance().cancel("QQWiFiScanManager", 481);
    }
  }
  
  public void b()
  {
    if (this.aF) {
      BaseApplication.getContext().unregisterReceiver(this.aM);
    }
    this.aF = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "unregister");
    }
  }
  
  public void c()
  {
    try
    {
      m();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWiFiScanManager", 2, "scan", localThrowable);
      }
    }
  }
  
  public void d()
  {
    try
    {
      if (this.aK) {
        return;
      }
      Object localObject1 = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
      Object localObject2 = (WifiManager)this.ar.getSystemService("wifi");
      int i1 = ((WifiManager)localObject2).getWifiState();
      String str = "";
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
      if ((((NetworkInfo)localObject1).getType() != 1) && (((NetworkInfo)localObject1).getType() != 9))
      {
        m();
        return;
      }
      localObject2 = ((WifiManager)localObject2).getConnectionInfo();
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (!TextUtils.isEmpty(((WifiInfo)localObject2).getSSID())) {
          localObject1 = ((WifiInfo)localObject2).getSSID().replace("\"", "");
        }
      }
      a(1007, (String)localObject1, false, false);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWiFiScanManager", 2, localException.getMessage());
      }
    }
  }
  
  public void e()
  {
    if (!this.as.b) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = ((ConnectivityManager)this.ar.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject1 != null)
        {
          if (((NetworkInfo)localObject1).getType() != 1) {
            return;
          }
          localObject1 = ((ActivityManager)this.ar.getSystemService("activity")).getRunningAppProcesses();
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              if (!"com.tencent.mobileqq:qqwifi".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).processName)) {
                continue;
              }
              return;
            }
          }
          a(NetConnInfoCenter.msfCore, true);
          localObject1 = ((WifiManager)this.ar.getSystemService("wifi")).getConnectionInfo();
          i1 = 4;
          int i2 = 0;
          if (localObject1 == null) {
            break label728;
          }
          localObject2 = ((WifiInfo)localObject1).getBSSID();
          int i3 = ((WifiInfo)localObject1).getIpAddress();
          localObject1 = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i3 & 0xFF), Integer.valueOf(i3 >> 8 & 0xFF), Integer.valueOf(i3 >> 16 & 0xFF), Integer.valueOf(i3 >> 24 & 0xFF) });
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              return;
            }
            Object localObject3 = BaseApplication.getContext();
            if (Build.VERSION.SDK_INT <= 10) {
              break label740;
            }
            localObject3 = ((BaseApplication)localObject3).getSharedPreferences("mobileQQ", i1);
            if (localObject3 == null) {
              break label727;
            }
            localObject3 = ((SharedPreferences)localObject3).getString("qqwifiConnInfo", "");
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label727;
            }
            Object localObject5 = new JSONObject((String)localObject3);
            localObject3 = ((JSONObject)localObject5).optString("ssid");
            Object localObject4 = ((JSONObject)localObject5).optString("bssid");
            localObject5 = ((JSONObject)localObject5).optString("IPAdress");
            if ((!((String)localObject2).equals(localObject4)) || (!((String)localObject1).equals(localObject5))) {
              break label727;
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("checkConnection:remove netWork！ssid=");
              ((StringBuilder)localObject1).append((String)localObject3);
              ((StringBuilder)localObject1).append(" bssid=");
              ((StringBuilder)localObject1).append((String)localObject4);
              ((StringBuilder)localObject1).append(" IPAdress=");
              ((StringBuilder)localObject1).append((String)localObject5);
              QLog.i("QQWiFiScanManager", 2, ((StringBuilder)localObject1).toString());
            }
            localObject4 = (WifiManager)this.ar.getSystemService("wifi");
            localObject5 = ((WifiManager)localObject4).getConfiguredNetworks();
            localObject2 = localObject3;
            i1 = i2;
            if (localObject5 == null) {
              return;
            }
            if (i1 < ((List)localObject5).size())
            {
              localObject3 = (WifiConfiguration)((List)localObject5).get(i1);
              localObject1 = localObject2;
              if (localObject3 == null) {
                break label745;
              }
              if (TextUtils.isEmpty(((WifiConfiguration)localObject3).SSID))
              {
                localObject1 = localObject2;
                break label745;
              }
              String str2 = ((WifiConfiguration)localObject3).SSID.replace("\"", "");
              localObject2 = ((String)localObject2).replace("\"", "");
              localObject1 = localObject2;
              if (!str2.equals(localObject2)) {
                break label745;
              }
              ((WifiManager)localObject4).removeNetwork(((WifiConfiguration)localObject3).networkId);
              localObject1 = localObject2;
              if (!QLog.isColorLevel()) {
                break label745;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("checkConnection：已经删除了");
              ((StringBuilder)localObject1).append(((WifiConfiguration)localObject3).SSID);
              ((StringBuilder)localObject1).append("网络 networkId:");
              ((StringBuilder)localObject1).append(((WifiConfiguration)localObject3).networkId);
              ((StringBuilder)localObject1).append(" bssid:");
              ((StringBuilder)localObject1).append(((WifiConfiguration)localObject3).BSSID);
              QLog.i("QQWiFiScanManager", 2, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
              break label745;
            }
            ((WifiManager)localObject4).saveConfiguration();
            return;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkConnection:Exception:");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QLog.d("QQWiFiScanManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      label727:
      return;
      label728:
      String str1 = "";
      Object localObject2 = str1;
      continue;
      label740:
      int i1 = 0;
      continue;
      label745:
      i1 += 1;
      localObject2 = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.u
 * JD-Core Version:    0.7.0.1
 */