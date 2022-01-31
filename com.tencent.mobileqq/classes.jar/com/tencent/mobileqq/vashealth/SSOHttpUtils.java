package com.tencent.mobileqq.vashealth;

import akka;
import akkb;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class SSOHttpUtils
{
  public static float a;
  public static volatile int a;
  public static volatile long a;
  public static String a;
  public static boolean a;
  private static String[] a;
  public static volatile int b;
  static long jdField_b_of_type_Long;
  static String jdField_b_of_type_JavaLangString;
  public static boolean b;
  private static String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static volatile int c;
  public static final String c;
  static String d;
  static String e;
  static String f;
  static final String g = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "stepSign.info";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "step.info";
  }
  
  public static int a()
  {
    int j = 0;
    try
    {
      Object localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return 0;
      }
      localObject = new JSONObject((String)localObject);
      if (!((JSONObject)localObject).getBoolean("isStepCounterEnable"))
      {
        QLog.i("SSOHttpUtils", 1, "step counter off.");
        a(-2, "step counter off");
        return 0;
      }
    }
    catch (Exception localException)
    {
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("SSOHttpUtils", 2, "reportStepCounts decrypt Exception:" + localException.toString());
        return 0;
        String str = String.valueOf(a());
        i = j;
        if (localException.has(str + "_total"))
        {
          i = j;
          if (localException.has(str + "_init"))
          {
            i = localException.getInt(str + "_total");
            int k = localException.getInt(str + "_init");
            int m = localException.getInt(str + "_offset");
            i = m + (i - k);
          }
        }
      }
      return i;
    }
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
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 171	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_b_of_type_Boolean	Z
    //   5: ifeq +79 -> 84
    //   8: new 173	com/tencent/qphone/base/util/Cryptor
    //   11: dup
    //   12: invokespecial 174	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   15: astore_3
    //   16: new 176	java/io/RandomAccessFile
    //   19: dup
    //   20: getstatic 58	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   23: ldc 178
    //   25: invokespecial 181	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual 184	java/io/RandomAccessFile:length	()J
    //   35: l2i
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_2
    //   41: astore_1
    //   42: aload_2
    //   43: aload 4
    //   45: invokevirtual 188	java/io/RandomAccessFile:read	([B)I
    //   48: pop
    //   49: aload_2
    //   50: astore_1
    //   51: new 120	java/lang/String
    //   54: dup
    //   55: aload_3
    //   56: aload 4
    //   58: ldc 190
    //   60: invokevirtual 194	java/lang/String:getBytes	()[B
    //   63: invokevirtual 198	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   66: invokespecial 201	java/lang/String:<init>	([B)V
    //   69: astore_3
    //   70: aload_3
    //   71: astore_1
    //   72: aload_2
    //   73: ifnull +9 -> 82
    //   76: aload_2
    //   77: invokevirtual 204	java/io/RandomAccessFile:close	()V
    //   80: aload_3
    //   81: astore_1
    //   82: aload_1
    //   83: areturn
    //   84: new 44	java/io/File
    //   87: dup
    //   88: getstatic 69	com/tencent/mobileqq/vashealth/SSOHttpUtils:g	Ljava/lang/String;
    //   91: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore_3
    //   95: new 44	java/io/File
    //   98: dup
    //   99: getstatic 58	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_2
    //   106: aload_3
    //   107: invokevirtual 208	java/io/File:exists	()Z
    //   110: ifeq +12 -> 122
    //   113: aload_2
    //   114: invokevirtual 208	java/io/File:exists	()Z
    //   117: istore_0
    //   118: iload_0
    //   119: ifne +17 -> 136
    //   122: iconst_0
    //   123: ifeq +11 -> 134
    //   126: new 210	java/lang/NullPointerException
    //   129: dup
    //   130: invokespecial 211	java/lang/NullPointerException:<init>	()V
    //   133: athrow
    //   134: aconst_null
    //   135: areturn
    //   136: aload_3
    //   137: invokestatic 217	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   140: astore_3
    //   141: aload_2
    //   142: invokestatic 217	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   145: astore_2
    //   146: aload_2
    //   147: ifnull +32 -> 179
    //   150: aload_2
    //   151: aload_3
    //   152: ldc 219
    //   154: invokestatic 223	com/tencent/mobileqq/msf/sdk/utils/SignUtils:verifyData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   157: istore_0
    //   158: iload_0
    //   159: ifeq +20 -> 179
    //   162: aload_2
    //   163: astore_1
    //   164: iconst_0
    //   165: ifeq -83 -> 82
    //   168: new 210	java/lang/NullPointerException
    //   171: dup
    //   172: invokespecial 211	java/lang/NullPointerException:<init>	()V
    //   175: athrow
    //   176: astore_1
    //   177: aload_2
    //   178: areturn
    //   179: iconst_0
    //   180: ifeq +11 -> 191
    //   183: new 210	java/lang/NullPointerException
    //   186: dup
    //   187: invokespecial 211	java/lang/NullPointerException:<init>	()V
    //   190: athrow
    //   191: aconst_null
    //   192: areturn
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: ldc 95
    //   200: iconst_1
    //   201: new 25	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   208: ldc 225
    //   210: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: getstatic 171	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_b_of_type_Boolean	Z
    //   216: invokevirtual 228	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   219: ldc 230
    //   221: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: aload_3
    //   228: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: ifnull -41 -> 191
    //   235: aload_2
    //   236: invokevirtual 204	java/io/RandomAccessFile:close	()V
    //   239: goto -48 -> 191
    //   242: astore_1
    //   243: goto -52 -> 191
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload_3
    //   250: astore_1
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 204	java/io/RandomAccessFile:close	()V
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload_3
    //   263: areturn
    //   264: astore_1
    //   265: goto -131 -> 134
    //   268: astore_1
    //   269: goto -78 -> 191
    //   272: astore_2
    //   273: goto -14 -> 259
    //   276: astore_3
    //   277: aload_1
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: goto -30 -> 251
    //   284: astore_3
    //   285: goto -89 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   117	42	0	bool	boolean
    //   1	163	1	localObject1	Object
    //   176	1	1	localIOException1	java.io.IOException
    //   197	1	1	localObject2	Object
    //   242	6	1	localIOException2	java.io.IOException
    //   250	10	1	localObject3	Object
    //   261	1	1	localIOException3	java.io.IOException
    //   264	1	1	localIOException4	java.io.IOException
    //   268	10	1	localIOException5	java.io.IOException
    //   280	1	1	localObject4	Object
    //   28	228	2	localObject5	Object
    //   272	1	2	localIOException6	java.io.IOException
    //   278	1	2	localIOException7	java.io.IOException
    //   15	137	3	localObject6	Object
    //   193	35	3	localException1	Exception
    //   246	17	3	str	String
    //   276	4	3	localObject7	Object
    //   284	1	3	localException2	Exception
    //   38	19	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   168	176	176	java/io/IOException
    //   2	29	193	java/lang/Exception
    //   84	118	193	java/lang/Exception
    //   136	146	193	java/lang/Exception
    //   150	158	193	java/lang/Exception
    //   235	239	242	java/io/IOException
    //   2	29	246	finally
    //   84	118	246	finally
    //   136	146	246	finally
    //   150	158	246	finally
    //   76	80	261	java/io/IOException
    //   126	134	264	java/io/IOException
    //   183	191	268	java/io/IOException
    //   255	259	272	java/io/IOException
    //   31	40	276	finally
    //   42	49	276	finally
    //   51	70	276	finally
    //   198	231	276	finally
    //   31	40	284	java/lang/Exception
    //   42	49	284	java/lang/Exception
    //   51	70	284	java/lang/Exception
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      int i = NetworkUtil.a(BaseApplicationImpl.getApplication());
      paramString = "";
      switch (i)
      {
      }
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "HealthStepReport", "", "ReportResult", paramString, paramInt, 1, jdField_c_of_type_Int, String.valueOf(jdField_b_of_type_Int), String.valueOf(jdField_a_of_type_Int), str, Build.MODEL);
        return;
        paramString = "no_network";
        continue;
        paramString = "wifi";
        continue;
        paramString = "2g";
        continue;
        paramString = "3g";
        continue;
        paramString = "4g";
        continue;
        paramString = "unknown";
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (System.currentTimeMillis() - jdField_b_of_type_Long < 1000L) {}
    Object localObject1;
    long l2;
    Object localObject2;
    do
    {
      do
      {
        return;
        jdField_b_of_type_Long = System.currentTimeMillis();
      } while ((NetConnInfoCenter.getServerTimeMillis() - jdField_a_of_type_Long < 60000L) || (TextUtils.isEmpty(paramString)));
      jdField_a_of_type_Boolean = false;
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.getBoolean("isStepCounterEnable"))
        {
          SportManager.jdField_a_of_type_Boolean = false;
          QLog.i("SSOHttpUtils", 1, "step counter off.");
          a(-2, "step counter off");
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("SSOHttpUtils", 1, "report step count Exception:" + paramString);
        return;
      }
      SportManager.jdField_a_of_type_Boolean = true;
      localObject1 = new HashMap();
      l2 = a();
      localObject2 = String.valueOf(l2);
    } while ((!paramString.has((String)localObject2 + "_total")) || (!paramString.has((String)localObject2 + "_init")));
    jdField_a_of_type_Int = paramString.getInt((String)localObject2 + "_total");
    jdField_b_of_type_Int = paramString.getInt((String)localObject2 + "_init");
    jdField_c_of_type_Int = paramString.getInt((String)localObject2 + "_offset");
    int k = jdField_a_of_type_Int - jdField_b_of_type_Int + jdField_c_of_type_Int;
    QLog.i("SSOHttpUtils", 1, "file contains cur_init:" + jdField_b_of_type_Int + ",cur_total:" + jdField_a_of_type_Int + ",cur_offset:" + jdField_c_of_type_Int);
    if (k > 0) {
      ((Map)localObject1).put(Long.valueOf(NetConnInfoCenter.getServerTime() * 1000L), Integer.valueOf(k));
    }
    long l1;
    if (paramString.has("last_report_time"))
    {
      l1 = paramString.getLong("last_report_time");
      localObject2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
      ((Calendar)localObject2).setTimeInMillis(l1);
      ((Calendar)localObject2).set(11, 0);
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      ((Calendar)localObject2).set(14, 0);
      l1 = ((Calendar)localObject2).getTimeInMillis();
      if (l2 - l1 <= 604800000L) {
        break label1003;
      }
      ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      ((Calendar)localObject2).set(11, 0);
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      ((Calendar)localObject2).set(14, 0);
      ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) - 6);
      l1 = ((Calendar)localObject2).getTimeInMillis();
    }
    label1003:
    for (;;)
    {
      Object localObject3;
      if (l1 < l2)
      {
        localObject3 = String.valueOf(l1);
        if ((!paramString.has((String)localObject3 + "_init")) || (!paramString.has((String)localObject3 + "_total")))
        {
          ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) + 1);
          l1 = ((Calendar)localObject2).getTimeInMillis();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("SSOHttpUtils", 2, "report yesterday~");
          }
          int j = paramString.getInt((String)localObject3 + "_total") - paramString.getInt((String)localObject3 + "_init");
          localObject3 = (String)localObject3 + "_offset";
          int i = j;
          if (paramString.has((String)localObject3))
          {
            jdField_a_of_type_Boolean = true;
            i = j + paramString.getInt((String)localObject3);
          }
          if ((i > 0) && (!((Map)localObject1).containsKey(Long.valueOf(86399000L + l1)))) {
            ((Map)localObject1).put(Long.valueOf(l1 + 86399000L), Integer.valueOf(i));
          }
          ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) + 1);
          l1 = ((Calendar)localObject2).getTimeInMillis();
        }
      }
      else
      {
        if (((Map)localObject1).isEmpty())
        {
          a(-3, "parameter is Empty.");
          return;
        }
        if ((k == jdField_a_of_type_Float) && (k > 0) && (((Map)localObject1).size() == 1))
        {
          localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(jdField_a_of_type_JavaLangString)))
          {
            QLog.i("SSOHttpUtils", 1, "steps duplicate , return.");
            return;
          }
        }
        localObject2 = new JSONArray();
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("type", 1);
          localJSONObject.put("time", ((Long)((Map.Entry)localObject3).getKey()).longValue() / 1000L);
          localJSONObject.put("steps", ((Integer)((Map.Entry)localObject3).getValue()).longValue());
          ((JSONArray)localObject2).put(localJSONObject);
        }
        a((JSONArray)localObject2, paramString.optBoolean("isRestart", false));
        return;
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, boolean paramBoolean)
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (paramJSONArray == null)) {
      return;
    }
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("oauth_consumer_key", 1002);
        ((JSONObject)localObject1).put("data", paramJSONArray);
        ((JSONObject)localObject1).put("version", "7.6.3");
        if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
          jdField_b_of_type_JavaLangString = URLEncoder.encode(Build.MODEL, "utf-8");
        }
        ((JSONObject)localObject1).put("model", jdField_b_of_type_JavaLangString);
        if (TextUtils.isEmpty(d))
        {
          paramJSONArray = TimeZone.getDefault();
          d = paramJSONArray.getDisplayName(false, 0) + " " + paramJSONArray.getID();
        }
        ((JSONObject)localObject1).put("zone", String.valueOf(d));
        if (TextUtils.isEmpty(e)) {
          e = ((TelephonyManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("phone")).getDeviceId();
        }
        ((JSONObject)localObject1).put("imei", String.valueOf(e));
        if (f == null) {
          f = DeviceInfoUtil.d(BaseApplicationImpl.getApplication().getApplicationContext());
        }
        ((JSONObject)localObject1).put("mac", String.valueOf(f));
        paramJSONArray = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 0);
        long l1 = paramJSONArray.getLong("search_lbs_timestamp", 0L);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 > 3600000L) {
          SosoInterface.a(new akka(0, true, true, 0L, false, false, "SSOHttpUtils", paramJSONArray, l2));
        }
        double d1 = paramJSONArray.getFloat("search_lbs_logitude", 0.0F);
        double d2 = paramJSONArray.getFloat("search_lbs_latitude", 0.0F);
        if ((d1 != 0.0D) && (d2 != 0.0D))
        {
          ((JSONObject)localObject1).put("latitude", String.valueOf(d2));
          ((JSONObject)localObject1).put("longitude", String.valueOf(d1));
        }
        if (paramBoolean)
        {
          QLog.i("SSOHttpUtils", 1, "report with exception_0");
          ((JSONObject)localObject1).put("exception_0", 1);
        }
        if (!jdField_b_of_type_Boolean) {
          continue;
        }
        i = 0;
        ((JSONObject)localObject1).put("mode", i);
      }
      catch (Exception paramJSONArray)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SSOHttpUtils", 2, "Exception:" + paramJSONArray.toString());
        continue;
      }
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("7.6.3");
      paramJSONArray = new WebSSOAgent.UniSsoServerReq();
      paramJSONArray.comm.set((MessageMicro)localObject2);
      paramJSONArray.reqdata.set(((JSONObject)localObject1).toString());
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "parameter:" + ((JSONObject)localObject1).toString());
      }
      localObject1 = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), WebSSOAgentServlet.class);
      ((NewIntent)localObject1).putExtra("extra_cmd", "yundong_report.steps");
      ((NewIntent)localObject1).putExtra("extra_data", paramJSONArray.toByteArray());
      ((NewIntent)localObject1).setObserver(new akkb());
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject1);
      return;
      i = 1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject1;
    if ((jdField_a_of_type_ArrayOfJavaLangString == null) || (jdField_b_of_type_ArrayOfJavaLangString == null))
    {
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("login_report");
      localObject2 = ((JSONObject)localObject2).optString("timmer_report");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        jdField_a_of_type_ArrayOfJavaLangString = ((String)localObject1).split(",");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject2).split(",");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("SSOHttpUtils", 2, "parse json failed:" + localException.toString());
          continue;
          paramInt += 1;
        }
      }
      if ((paramInt != 2) || (jdField_b_of_type_ArrayOfJavaLangString == null) || (jdField_b_of_type_ArrayOfJavaLangString.length == 0)) {
        break label341;
      }
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (TextUtils.isEmpty(str)) {
        break label341;
      }
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= jdField_b_of_type_ArrayOfJavaLangString.length) {
          break label341;
        }
        if (str.endsWith(jdField_b_of_type_ArrayOfJavaLangString[paramInt]))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SSOHttpUtils", 2, "timmer report found current uin banned!");
          return false;
        }
        paramInt += 1;
      }
    }
    if (jdField_a_of_type_ArrayOfJavaLangString == null) {
      jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    }
    if (jdField_b_of_type_ArrayOfJavaLangString == null) {
      jdField_b_of_type_ArrayOfJavaLangString = new String[0];
    }
    if (paramInt == 1)
    {
      if ((jdField_a_of_type_ArrayOfJavaLangString == null) || (jdField_a_of_type_ArrayOfJavaLangString.length == 0)) {
        break label341;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label341;
      }
      paramInt = 0;
      if (paramInt >= jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label341;
      }
      if (((String)localObject1).endsWith(jdField_a_of_type_ArrayOfJavaLangString[paramInt]))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SSOHttpUtils", 2, "login report found current uin banned!");
        }
        return false;
      }
    }
    label341:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SSOHttpUtils
 * JD-Core Version:    0.7.0.1
 */