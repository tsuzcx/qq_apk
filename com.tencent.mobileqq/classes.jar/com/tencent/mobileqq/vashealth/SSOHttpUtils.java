package com.tencent.mobileqq.vashealth;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent.UniSsoServerReq;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgentServlet;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SSOHttpUtils
{
  public static float a = 0.0F;
  public static String b = "";
  public static volatile long c;
  static long d;
  static String e;
  public static volatile int f;
  public static volatile int g;
  public static volatile int h;
  public static final String i;
  static boolean j;
  static String k;
  static String l;
  static final String m;
  public static boolean n = false;
  static final String[] o = { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
  static final Uri p = Uri.parse("content://com.miui.providers.steps/item");
  private static String[] q;
  private static String[] r;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getMobileQQ().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("step.info");
    i = localStringBuilder.toString();
    j = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("stepSign.info");
    m = localStringBuilder.toString();
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    Object localObject1 = new Date();
    String str = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append("-RedPack");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("-RedPack-TimeLimit");
    str = ((StringBuilder)localObject2).toString();
    localObject2 = paramAppRuntime.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localStringBuilder.append(".qqsport");
    localObject2 = ((MobileQQ)localObject2).getSharedPreferences(localStringBuilder.toString(), 4);
    boolean bool = false;
    if (((SharedPreferences)localObject2).getInt("STEP_RED_PACK_STATUS", 0) == 1) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("redPackStatus:");
      localStringBuilder.append(bool);
      QLog.i("SSOHttpUtils", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp.getBoolean(sortRedPackKey, true):");
        localStringBuilder.append(((SharedPreferences)localObject2).getBoolean((String)localObject1, true));
        QLog.i("SSOHttpUtils", 2, localStringBuilder.toString());
      }
      if (((SharedPreferences)localObject2).getBoolean((String)localObject1, true))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sortRedPackTimeLimit:");
          ((StringBuilder)localObject1).append(((SharedPreferences)localObject2).getLong(str, 0L));
          QLog.i("SSOHttpUtils", 2, ((StringBuilder)localObject1).toString());
        }
        if ((((SharedPreferences)localObject2).getLong(str, 0L) == 0L) || (((SharedPreferences)localObject2).getLong(str, 0L) - System.currentTimeMillis() > 3600000L))
        {
          b(paramAppRuntime);
          ((SharedPreferences)localObject2).edit().putLong(str, System.currentTimeMillis()).commit();
        }
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.w("SSOHttpUtils", 1, "report params is null");
      return;
    }
    Object localObject1 = null;
    if (paramBundle.containsKey("health_step_count_history")) {
      localObject1 = (Map)paramBundle.getSerializable("health_step_count_history");
    }
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      boolean bool;
      if (paramBundle.containsKey("health_has_shutdown_flag")) {
        bool = paramBundle.getBoolean("health_has_shutdown_flag");
      } else {
        bool = false;
      }
      long l1 = 0L;
      if (paramBundle.containsKey("health_last_sensor_event_time")) {
        l1 = paramBundle.getLong("health_last_sensor_event_time");
      }
      paramBundle = new JSONArray();
      long l2 = a() / 1000L;
      int[] arrayOfInt = e();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      int i2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        long l3 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
        int i4 = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        int i3 = i4;
        int i1 = i2;
        if (l2 == l3)
        {
          i3 = i4;
          i1 = i2;
          if (arrayOfInt[1] != -1)
          {
            i3 = i4;
            i1 = i2;
            if (arrayOfInt[1] > i4)
            {
              i3 = arrayOfInt[1];
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("get step from manufacturer: ");
                ((StringBuilder)localObject2).append(arrayOfInt[1]);
                ((StringBuilder)localObject2).append(" , sensor value:");
                ((StringBuilder)localObject2).append(i3);
                QLog.d("SSOHttpUtils", 2, ((StringBuilder)localObject2).toString());
              }
              i1 = 1;
            }
          }
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("type", 1);
          ((JSONObject)localObject2).put("time", l3);
          ((JSONObject)localObject2).put("steps", i3);
          paramBundle.put(localObject2);
          i2 = i1;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("SSOHttpUtils", 1, "error read step count from step history", localJSONException);
          i2 = i1;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ready for new step counter report, data:");
        ((StringBuilder)localObject1).append(paramBundle.toString());
        ((StringBuilder)localObject1).append(", hasShutdown:");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(" , stepSource:");
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append(" , lastRecordTime:");
        ((StringBuilder)localObject1).append(l1);
        QLog.d("SSOHttpUtils", 2, ((StringBuilder)localObject1).toString());
      }
      a(paramAppRuntime, paramBundle, bool, i2, l1);
      return;
    }
    QLog.w("SSOHttpUtils", 1, "step count history is null or empty, no data to report");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if (System.currentTimeMillis() - d < 1000L) {
      return;
    }
    d = System.currentTimeMillis();
    if (NetConnInfoCenter.getServerTimeMillis() - c < 60000L) {
      return;
    }
    if (paramAppRuntime == null)
    {
      QLog.e("SSOHttpUtils", 1, "appRuntime is NULL", new NullPointerException());
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    j = false;
    Object localObject1 = (ISportManager)paramAppRuntime.getRuntimeService(ISportManager.class, "multi");
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.getBoolean("isStepCounterEnable"))
        {
          ((ISportManager)localObject1).setStepCounterEnable(false);
          QLog.i("SSOHttpUtils", 1, "step counter off.");
          b(-2, "step counter off");
          return;
        }
        ((ISportManager)localObject1).setStepCounterEnable(true);
        localObject1 = new HashMap();
        long l2 = a();
        Object localObject2 = String.valueOf(l2);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("_total");
        if (paramString.has(((StringBuilder)localObject3).toString()))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("_init");
          if (!paramString.has(((StringBuilder)localObject3).toString())) {
            return;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("_total");
          f = paramString.getInt(((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("_init");
          g = paramString.getInt(((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("_offset");
          h = paramString.getInt(((StringBuilder)localObject3).toString());
          int i2 = f - g + h;
          localObject2 = e();
          if ((localObject2[1] == -1) || (localObject2[1] <= i2)) {
            break label1387;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("use device step :");
          ((StringBuilder)localObject3).append(localObject2[1]);
          ((StringBuilder)localObject3).append(" instead of sensor:");
          ((StringBuilder)localObject3).append(i2);
          ((StringBuilder)localObject3).append(", yesterday: ");
          ((StringBuilder)localObject3).append(localObject2[0]);
          QLog.e("SSOHttpUtils", 1, ((StringBuilder)localObject3).toString());
          i2 = localObject2[1];
          if ((!j) && (localObject2[0] > 0))
          {
            ((Map)localObject1).put(Long.valueOf(c() + 86399000L), Integer.valueOf(localObject2[0]));
            j = true;
            break label1382;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("file contains cur_init:");
            ((StringBuilder)localObject2).append(g);
            ((StringBuilder)localObject2).append(",cur_total:");
            ((StringBuilder)localObject2).append(f);
            ((StringBuilder)localObject2).append(",cur_offset:");
            ((StringBuilder)localObject2).append(h);
            QLog.i("SSOHttpUtils", 1, ((StringBuilder)localObject2).toString());
            if (i2 > 0) {
              ((Map)localObject1).put(Long.valueOf(NetConnInfoCenter.getServerTime() * 1000L), Integer.valueOf(i2));
            }
            if (!paramString.has("last_report_time")) {
              break label1404;
            }
            l1 = paramString.getLong("last_report_time");
            localObject3 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            ((Calendar)localObject3).setTimeInMillis(l1);
            ((Calendar)localObject3).set(11, 0);
            ((Calendar)localObject3).set(12, 0);
            ((Calendar)localObject3).set(13, 0);
            ((Calendar)localObject3).set(14, 0);
            l1 = ((Calendar)localObject3).getTimeInMillis();
            if (l2 - l1 <= 604800000L) {
              break label1392;
            }
            ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
            ((Calendar)localObject3).set(11, 0);
            ((Calendar)localObject3).set(12, 0);
            ((Calendar)localObject3).set(13, 0);
            ((Calendar)localObject3).set(14, 0);
            ((Calendar)localObject3).set(5, ((Calendar)localObject3).get(5) - 6);
            l1 = ((Calendar)localObject3).getTimeInMillis();
            if (l1 >= l2) {
              break label1401;
            }
            localObject2 = String.valueOf(l1);
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject2);
            ((StringBuilder)localObject4).append("_init");
            if (paramString.has(((StringBuilder)localObject4).toString()))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append("_total");
              if (paramString.has(((StringBuilder)localObject4).toString()))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("SSOHttpUtils", 2, "report yesterday~");
                }
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append((String)localObject2);
                ((StringBuilder)localObject4).append("_total");
                int i3 = paramString.getInt(((StringBuilder)localObject4).toString());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append((String)localObject2);
                ((StringBuilder)localObject4).append("_init");
                int i4 = i3 - paramString.getInt(((StringBuilder)localObject4).toString());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append((String)localObject2);
                ((StringBuilder)localObject4).append("_offset");
                localObject2 = ((StringBuilder)localObject4).toString();
                i3 = i4;
                if (paramString.has((String)localObject2))
                {
                  j = true;
                  i3 = i4 + paramString.getInt((String)localObject2);
                }
                if (i3 <= 0) {
                  break label1395;
                }
                l1 += 86399000L;
                localObject2 = localObject1;
                if (!((Map)localObject2).containsKey(Long.valueOf(l1))) {
                  ((Map)localObject2).put(Long.valueOf(l1), Integer.valueOf(i3));
                }
                ((Calendar)localObject3).set(5, ((Calendar)localObject3).get(5) + 1);
                l1 = ((Calendar)localObject3).getTimeInMillis();
                break label1398;
              }
            }
            ((Calendar)localObject3).set(5, ((Calendar)localObject3).get(5) + 1);
            l1 = ((Calendar)localObject3).getTimeInMillis();
            break label1398;
            if (!paramString.has("last_record_time")) {
              break label1407;
            }
            l1 = paramString.getLong("last_record_time");
            if (((Map)localObject1).isEmpty())
            {
              b(-3, "parameter is Empty.");
              return;
            }
            if ((i2 == a) && (i2 > 0) && (((Map)localObject1).size() == 1))
            {
              localObject2 = paramAppRuntime.getAccount();
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(b)))
              {
                QLog.i("SSOHttpUtils", 1, "steps duplicate , return.");
                return;
              }
            }
            localObject2 = new JSONArray();
            localObject1 = ((Map)localObject1).entrySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("type", 1);
              ((JSONObject)localObject4).put("time", ((Long)((Map.Entry)localObject3).getKey()).longValue() / 1000L);
              ((JSONObject)localObject4).put("steps", ((Integer)((Map.Entry)localObject3).getValue()).longValue());
              ((JSONArray)localObject2).put(localObject4);
              continue;
            }
            a(paramAppRuntime, (JSONArray)localObject2, paramString.optBoolean("isRestart", false), i1, l1);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramString = new StringBuilder();
        paramString.append("report step count Exception:");
        paramString.append(paramAppRuntime);
        QLog.e("SSOHttpUtils", 1, paramString.toString());
        return;
      }
      label1382:
      int i1 = 1;
      continue;
      label1387:
      i1 = 0;
      continue;
      label1392:
      continue;
      label1395:
      continue;
      label1398:
      continue;
      label1401:
      continue;
      label1404:
      continue;
      label1407:
      long l1 = 0L;
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramAppRuntime.getAccount()))
    {
      if (paramJSONArray == null) {
        return;
      }
      Object localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("oauth_consumer_key", 1002);
        ((JSONObject)localObject1).put("data", paramJSONArray);
        ((JSONObject)localObject1).put("version", "8.8.17");
        ((JSONObject)localObject1).put("lastRecordTime", paramLong / 1000L);
        if (TextUtils.isEmpty(e)) {
          e = URLEncoder.encode(Build.MODEL, "utf-8");
        }
        ((JSONObject)localObject1).put("model", e);
        if (TextUtils.isEmpty(k))
        {
          paramJSONArray = TimeZone.getDefault();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramJSONArray.getDisplayName(false, 0));
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(paramJSONArray.getID());
          k = ((StringBuilder)localObject2).toString();
        }
        ((JSONObject)localObject1).put("zone", String.valueOf(k));
        if (TextUtils.isEmpty(l)) {
          l = MobileInfoUtil.getImei();
        }
        ((JSONObject)localObject1).put("imei", String.valueOf(l));
        ((JSONObject)localObject1).put("adcode", ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode());
        int i1 = 1;
        if ((paramInt == 0) && (paramBoolean))
        {
          QLog.i("SSOHttpUtils", 1, "report with exception_0");
          ((JSONObject)localObject1).put("exception_0", 1);
        }
        if (n) {
          i1 = 0;
        }
        ((JSONObject)localObject1).put("mode", i1);
        ((JSONObject)localObject1).put("stepSource", paramInt);
      }
      catch (Exception paramJSONArray)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Exception:");
          ((StringBuilder)localObject2).append(paramJSONArray.toString());
          QLog.e("SSOHttpUtils", 2, ((StringBuilder)localObject2).toString());
        }
      }
      Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
      paramJSONArray = new WebSSOAgent.UniSsoServerReq();
      paramJSONArray.comm.set((MessageMicro)localObject2);
      paramJSONArray.reqdata.set(((JSONObject)localObject1).toString());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parameter:");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        QLog.i("SSOHttpUtils", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new NewIntent(paramAppRuntime.getApplication().getApplicationContext(), WebSSOAgentServlet.class);
      ((NewIntent)localObject1).putExtra("extra_cmd", "yundong_report.steps");
      ((NewIntent)localObject1).putExtra("extra_data", paramJSONArray.toByteArray());
      ((NewIntent)localObject1).setObserver(new SSOHttpUtils.1(paramAppRuntime));
      paramAppRuntime.startServlet((NewIntent)localObject1);
    }
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if ((q == null) || (r == null))
    {
      Object localObject1 = new File(MobileQQ.getMobileQQ().getFilesDir(), ClubContentJsonTask.e.a);
      if (((File)localObject1).exists())
      {
        localObject1 = FileUtils.readFileContent((File)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          try
          {
            localObject2 = new JSONObject((String)localObject1);
            localObject1 = ((JSONObject)localObject2).optString("login_report");
            localObject2 = ((JSONObject)localObject2).optString("timmer_report");
            boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (!bool) {
              q = ((String)localObject1).split(",");
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              r = ((String)localObject2).split(",");
            }
          }
          catch (Exception localException)
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("parse json failed:");
              ((StringBuilder)localObject2).append(localException.toString());
              QLog.e("SSOHttpUtils", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      if (q == null) {
        q = new String[0];
      }
      if (r == null) {
        r = new String[0];
      }
    }
    String[] arrayOfString;
    if (paramInt == 1)
    {
      arrayOfString = q;
      if ((arrayOfString != null) && (arrayOfString.length != 0) && (!TextUtils.isEmpty(paramString)))
      {
        paramInt = 0;
        for (;;)
        {
          arrayOfString = q;
          if (paramInt >= arrayOfString.length) {
            break;
          }
          if (paramString.endsWith(arrayOfString[paramInt]))
          {
            if (QLog.isColorLevel()) {
              QLog.i("SSOHttpUtils", 2, "login report found current uin banned!");
            }
            return false;
          }
          paramInt += 1;
        }
      }
    }
    else if (paramInt == 2)
    {
      arrayOfString = r;
      if ((arrayOfString != null) && (arrayOfString.length != 0) && (!TextUtils.isEmpty(paramString)))
      {
        paramInt = 0;
        for (;;)
        {
          arrayOfString = r;
          if (paramInt >= arrayOfString.length) {
            break;
          }
          if (paramString.endsWith(arrayOfString[paramInt]))
          {
            if (QLog.isColorLevel()) {
              QLog.i("SSOHttpUtils", 2, "timmer report found current uin banned!");
            }
            return false;
          }
          paramInt += 1;
        }
      }
    }
    return true;
  }
  
  public static long b()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(11, 23);
    localCalendar.set(12, 59);
    localCalendar.set(13, 59);
    return localCalendar.getTimeInMillis();
  }
  
  public static void b(int paramInt, String paramString)
  {
    String str2 = "";
    String str1;
    if (paramString == null) {
      str1 = "";
    } else {
      str1 = paramString;
    }
    int i1 = NetworkUtil.getNetworkType(MobileQQ.context);
    if (i1 != -1) {
      if (i1 != 0) {
        if (i1 != 1) {
          if (i1 != 2) {
            if (i1 != 3) {
              if (i1 != 4) {
                paramString = str2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      paramString = "4g";
      continue;
      paramString = "3g";
      continue;
      paramString = "2g";
      continue;
      paramString = "wifi";
      continue;
      paramString = "no_network";
      continue;
      paramString = "unknown";
    }
    ReportController.b(null, "P_CliOper", "HealthStepReport", "", "ReportResult", paramString, paramInt, 1, h, String.valueOf(g), String.valueOf(f), str1, Build.MODEL);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    QLog.i("SSOHttpUtils", 1, "requestRedPack");
    if (paramAppRuntime == null) {
      return;
    }
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("reqtype", 1);
      localObject3 = (TicketManager)paramAppRuntime.getManager(2);
      localObject1 = null;
      if (localObject3 != null) {
        localObject1 = ((TicketManager)localObject3).getSkey(paramAppRuntime.getCurrentAccountUin());
      }
      ((JSONObject)localObject2).put("skey", localObject1);
      ((JSONObject)localObject2).put("platform", 2);
      ((JSONObject)localObject2).put("version", "8.8.17");
    }
    catch (Exception localException)
    {
      Object localObject3;
      Object localObject1;
      label86:
      break label86;
    }
    localObject3 = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.8.17");
    localObject1 = new WebSSOAgent.UniSsoServerReq();
    ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject3);
    ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parameter:");
      ((StringBuilder)localObject3).append(((JSONObject)localObject2).toString());
      QLog.i("SSOHttpUtils", 2, ((StringBuilder)localObject3).toString());
    }
    localObject2 = new NewIntent(paramAppRuntime.getApplication().getApplicationContext(), WebSSOAgentServlet.class);
    ((NewIntent)localObject2).putExtra("extra_cmd", "SportsAioTips.RedpkgTips");
    ((NewIntent)localObject2).putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new SSOHttpUtils.2(paramAppRuntime));
    paramAppRuntime.startServlet((NewIntent)localObject2);
  }
  
  public static long c()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(5, localCalendar.get(5) - 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  /* Error */
  public static String d()
  {
    // Byte code:
    //   0: getstatic 84	com/tencent/mobileqq/vashealth/SSOHttpUtils:n	Z
    //   3: ifeq +77 -> 80
    //   6: new 780	com/tencent/qphone/base/util/Cryptor
    //   9: dup
    //   10: invokespecial 781	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   13: astore_3
    //   14: new 783	java/io/RandomAccessFile
    //   17: dup
    //   18: getstatic 69	com/tencent/mobileqq/vashealth/SSOHttpUtils:i	Ljava/lang/String;
    //   21: ldc_w 784
    //   24: invokespecial 787	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 790	java/io/RandomAccessFile:length	()J
    //   34: l2i
    //   35: newarray byte
    //   37: astore 4
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: aload 4
    //   44: invokevirtual 794	java/io/RandomAccessFile:read	([B)I
    //   47: pop
    //   48: aload_2
    //   49: astore_1
    //   50: new 86	java/lang/String
    //   53: dup
    //   54: aload_3
    //   55: aload 4
    //   57: ldc_w 796
    //   60: invokevirtual 799	java/lang/String:getBytes	()[B
    //   63: invokevirtual 803	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   66: invokespecial 806	java/lang/String:<init>	([B)V
    //   69: astore_3
    //   70: aload_2
    //   71: invokevirtual 809	java/io/RandomAccessFile:close	()V
    //   74: aload_3
    //   75: areturn
    //   76: astore_3
    //   77: goto +81 -> 158
    //   80: new 55	java/io/File
    //   83: dup
    //   84: getstatic 82	com/tencent/mobileqq/vashealth/SSOHttpUtils:m	Ljava/lang/String;
    //   87: invokespecial 810	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore_2
    //   91: new 55	java/io/File
    //   94: dup
    //   95: getstatic 69	com/tencent/mobileqq/vashealth/SSOHttpUtils:i	Ljava/lang/String;
    //   98: invokespecial 810	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore_1
    //   102: aload_2
    //   103: invokevirtual 690	java/io/File:exists	()Z
    //   106: ifeq +41 -> 147
    //   109: aload_1
    //   110: invokevirtual 690	java/io/File:exists	()Z
    //   113: ifne +5 -> 118
    //   116: aconst_null
    //   117: areturn
    //   118: aload_2
    //   119: invokestatic 815	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   122: astore_2
    //   123: aload_1
    //   124: invokestatic 815	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +95 -> 224
    //   132: aload_1
    //   133: aload_2
    //   134: ldc_w 817
    //   137: invokestatic 821	com/tencent/mobileqq/msf/sdk/utils/SignUtils:verifyData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   140: istore_0
    //   141: iload_0
    //   142: ifeq +82 -> 224
    //   145: aload_1
    //   146: areturn
    //   147: aconst_null
    //   148: areturn
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_2
    //   152: goto +79 -> 231
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_2
    //   159: astore_1
    //   160: new 36	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   167: astore 4
    //   169: aload_2
    //   170: astore_1
    //   171: aload 4
    //   173: ldc_w 823
    //   176: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_2
    //   181: astore_1
    //   182: aload 4
    //   184: getstatic 84	com/tencent/mobileqq/vashealth/SSOHttpUtils:n	Z
    //   187: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: astore_1
    //   193: aload 4
    //   195: ldc_w 825
    //   198: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_2
    //   203: astore_1
    //   204: ldc 195
    //   206: iconst_1
    //   207: aload 4
    //   209: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: aload_3
    //   213: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 809	java/io/RandomAccessFile:close	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_3
    //   227: aload_1
    //   228: astore_2
    //   229: aload_3
    //   230: astore_1
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 809	java/io/RandomAccessFile:close	()V
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: aload_3
    //   243: areturn
    //   244: astore_1
    //   245: aconst_null
    //   246: areturn
    //   247: astore_2
    //   248: goto -9 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   140	2	0	bool	boolean
    //   29	117	1	localObject1	Object
    //   149	1	1	localObject2	Object
    //   159	81	1	localObject3	Object
    //   241	1	1	localIOException1	java.io.IOException
    //   244	1	1	localIOException2	java.io.IOException
    //   27	209	2	localObject4	Object
    //   247	1	2	localIOException3	java.io.IOException
    //   13	62	3	localObject5	Object
    //   76	1	3	localException1	Exception
    //   155	58	3	localException2	Exception
    //   226	17	3	str	String
    //   37	171	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   30	39	76	java/lang/Exception
    //   41	48	76	java/lang/Exception
    //   50	70	76	java/lang/Exception
    //   0	28	149	finally
    //   80	116	149	finally
    //   118	128	149	finally
    //   132	141	149	finally
    //   0	28	155	java/lang/Exception
    //   80	116	155	java/lang/Exception
    //   118	128	155	java/lang/Exception
    //   132	141	155	java/lang/Exception
    //   30	39	226	finally
    //   41	48	226	finally
    //   50	70	226	finally
    //   160	169	226	finally
    //   171	180	226	finally
    //   182	191	226	finally
    //   193	202	226	finally
    //   204	216	226	finally
    //   70	74	241	java/io/IOException
    //   220	224	244	java/io/IOException
    //   235	239	247	java/io/IOException
  }
  
  /* Error */
  public static int[] e()
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray int
    //   3: astore 13
    //   5: aload 13
    //   7: dup
    //   8: iconst_0
    //   9: iconst_0
    //   10: iastore
    //   11: dup
    //   12: iconst_1
    //   13: iconst_0
    //   14: iastore
    //   15: pop
    //   16: aconst_null
    //   17: astore 11
    //   19: aconst_null
    //   20: astore 12
    //   22: aconst_null
    //   23: astore 10
    //   25: aload 10
    //   27: astore 9
    //   29: aload 11
    //   31: astore 8
    //   33: aload 12
    //   35: astore 7
    //   37: invokestatic 829	com/tencent/mobileqq/util/SystemUtil:d	()Z
    //   40: ifeq +408 -> 448
    //   43: aload 11
    //   45: astore 8
    //   47: aload 12
    //   49: astore 7
    //   51: ldc_w 831
    //   54: invokestatic 837	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   57: astore 14
    //   59: aload 11
    //   61: astore 8
    //   63: aload 12
    //   65: astore 7
    //   67: aload 14
    //   69: invokevirtual 840	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   72: astore 9
    //   74: aload 11
    //   76: astore 8
    //   78: aload 12
    //   80: astore 7
    //   82: aload 14
    //   84: ldc_w 841
    //   87: iconst_2
    //   88: anewarray 833	java/lang/Class
    //   91: dup
    //   92: iconst_0
    //   93: ldc 86
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: getstatic 847	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   101: aastore
    //   102: invokevirtual 851	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   105: astore 14
    //   107: aload 11
    //   109: astore 8
    //   111: aload 12
    //   113: astore 7
    //   115: aload 14
    //   117: iconst_1
    //   118: invokevirtual 856	java/lang/reflect/Method:setAccessible	(Z)V
    //   121: aload 11
    //   123: astore 8
    //   125: aload 12
    //   127: astore 7
    //   129: aload 14
    //   131: aload 9
    //   133: iconst_2
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: ldc_w 858
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: iconst_0
    //   146: invokestatic 861	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   149: aastore
    //   150: invokevirtual 865	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore 14
    //   155: aload 10
    //   157: astore 9
    //   159: aload 11
    //   161: astore 8
    //   163: aload 12
    //   165: astore 7
    //   167: aload 14
    //   169: instanceof 843
    //   172: ifeq +276 -> 448
    //   175: aload 10
    //   177: astore 9
    //   179: aload 11
    //   181: astore 8
    //   183: aload 12
    //   185: astore 7
    //   187: aload 14
    //   189: checkcast 843	java/lang/Boolean
    //   192: invokevirtual 868	java/lang/Boolean:booleanValue	()Z
    //   195: ifeq +253 -> 448
    //   198: aload 11
    //   200: astore 8
    //   202: aload 12
    //   204: astore 7
    //   206: invokestatic 45	mqq/app/MobileQQ:getMobileQQ	()Lmqq/app/MobileQQ;
    //   209: invokevirtual 872	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   212: astore 14
    //   214: aload 10
    //   216: astore 9
    //   218: aload 14
    //   220: ifnull +228 -> 448
    //   223: aload 11
    //   225: astore 8
    //   227: aload 12
    //   229: astore 7
    //   231: invokestatic 441	com/tencent/mobileqq/vashealth/SSOHttpUtils:c	()J
    //   234: lstore_0
    //   235: aload 11
    //   237: astore 8
    //   239: aload 12
    //   241: astore 7
    //   243: invokestatic 874	com/tencent/mobileqq/vashealth/SSOHttpUtils:b	()J
    //   246: lstore_2
    //   247: aload 11
    //   249: astore 8
    //   251: aload 12
    //   253: astore 7
    //   255: invokestatic 274	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   258: lstore 4
    //   260: aload 11
    //   262: astore 8
    //   264: aload 12
    //   266: astore 7
    //   268: aload 14
    //   270: getstatic 108	com/tencent/mobileqq/vashealth/SSOHttpUtils:p	Landroid/net/Uri;
    //   273: getstatic 98	com/tencent/mobileqq/vashealth/SSOHttpUtils:o	[Ljava/lang/String;
    //   276: ldc_w 876
    //   279: iconst_2
    //   280: anewarray 86	java/lang/String
    //   283: dup
    //   284: iconst_0
    //   285: lload_0
    //   286: invokestatic 413	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   289: aastore
    //   290: dup
    //   291: iconst_1
    //   292: lload_2
    //   293: invokestatic 413	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   296: aastore
    //   297: ldc_w 878
    //   300: invokevirtual 884	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   303: astore 10
    //   305: aload 10
    //   307: astore 9
    //   309: aload 10
    //   311: ifnull +137 -> 448
    //   314: aload 10
    //   316: astore 9
    //   318: aload 10
    //   320: astore 8
    //   322: aload 10
    //   324: astore 7
    //   326: aload 10
    //   328: invokeinterface 889 1 0
    //   333: ifeq +115 -> 448
    //   336: aload 10
    //   338: astore 8
    //   340: aload 10
    //   342: astore 7
    //   344: aload 10
    //   346: iconst_2
    //   347: invokeinterface 892 2 0
    //   352: lload 4
    //   354: lcmp
    //   355: ifge +31 -> 386
    //   358: aload 10
    //   360: astore 8
    //   362: aload 10
    //   364: astore 7
    //   366: aload 13
    //   368: iconst_0
    //   369: aload 13
    //   371: iconst_0
    //   372: iaload
    //   373: aload 10
    //   375: iconst_4
    //   376: invokeinterface 894 2 0
    //   381: iadd
    //   382: iastore
    //   383: goto +28 -> 411
    //   386: aload 10
    //   388: astore 8
    //   390: aload 10
    //   392: astore 7
    //   394: aload 13
    //   396: iconst_1
    //   397: aload 13
    //   399: iconst_1
    //   400: iaload
    //   401: aload 10
    //   403: iconst_4
    //   404: invokeinterface 894 2 0
    //   409: iadd
    //   410: iastore
    //   411: aload 10
    //   413: astore 8
    //   415: aload 10
    //   417: astore 7
    //   419: aload 10
    //   421: invokeinterface 897 1 0
    //   426: istore 6
    //   428: iload 6
    //   430: ifne -94 -> 336
    //   433: aload 10
    //   435: ifnull +10 -> 445
    //   438: aload 10
    //   440: invokeinterface 898 1 0
    //   445: aload 13
    //   447: areturn
    //   448: aload 9
    //   450: ifnull +57 -> 507
    //   453: aload 9
    //   455: astore 7
    //   457: aload 7
    //   459: invokeinterface 898 1 0
    //   464: goto +43 -> 507
    //   467: astore 7
    //   469: goto +50 -> 519
    //   472: astore 9
    //   474: aload 7
    //   476: astore 8
    //   478: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +18 -> 499
    //   484: aload 7
    //   486: astore 8
    //   488: ldc 195
    //   490: iconst_2
    //   491: ldc_w 900
    //   494: aload 9
    //   496: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   499: aload 7
    //   501: ifnull +6 -> 507
    //   504: goto -47 -> 457
    //   507: iconst_2
    //   508: newarray int
    //   510: dup
    //   511: iconst_0
    //   512: iconst_m1
    //   513: iastore
    //   514: dup
    //   515: iconst_1
    //   516: iconst_m1
    //   517: iastore
    //   518: areturn
    //   519: aload 8
    //   521: ifnull +10 -> 531
    //   524: aload 8
    //   526: invokeinterface 898 1 0
    //   531: goto +6 -> 537
    //   534: aload 7
    //   536: athrow
    //   537: goto -3 -> 534
    // Local variable table:
    //   start	length	slot	name	signature
    //   234	52	0	l1	long
    //   246	47	2	l2	long
    //   258	95	4	l3	long
    //   426	3	6	bool	boolean
    //   35	423	7	localObject1	Object
    //   467	68	7	localObject2	Object
    //   31	494	8	localObject3	Object
    //   27	427	9	localObject4	Object
    //   472	23	9	localException	Exception
    //   23	416	10	localCursor	android.database.Cursor
    //   17	244	11	localObject5	Object
    //   20	245	12	localObject6	Object
    //   3	443	13	arrayOfInt	int[]
    //   57	212	14	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	467	finally
    //   51	59	467	finally
    //   67	74	467	finally
    //   82	107	467	finally
    //   115	121	467	finally
    //   129	155	467	finally
    //   167	175	467	finally
    //   187	198	467	finally
    //   206	214	467	finally
    //   231	235	467	finally
    //   243	247	467	finally
    //   255	260	467	finally
    //   268	305	467	finally
    //   326	336	467	finally
    //   344	358	467	finally
    //   366	383	467	finally
    //   394	411	467	finally
    //   419	428	467	finally
    //   478	484	467	finally
    //   488	499	467	finally
    //   37	43	472	java/lang/Exception
    //   51	59	472	java/lang/Exception
    //   67	74	472	java/lang/Exception
    //   82	107	472	java/lang/Exception
    //   115	121	472	java/lang/Exception
    //   129	155	472	java/lang/Exception
    //   167	175	472	java/lang/Exception
    //   187	198	472	java/lang/Exception
    //   206	214	472	java/lang/Exception
    //   231	235	472	java/lang/Exception
    //   243	247	472	java/lang/Exception
    //   255	260	472	java/lang/Exception
    //   268	305	472	java/lang/Exception
    //   326	336	472	java/lang/Exception
    //   344	358	472	java/lang/Exception
    //   366	383	472	java/lang/Exception
    //   394	411	472	java/lang/Exception
    //   419	428	472	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SSOHttpUtils
 * JD-Core Version:    0.7.0.1
 */