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
  public static volatile int a = 0;
  public static volatile long a = 0L;
  static final Uri jdField_a_of_type_AndroidNetUri = Uri.parse("content://com.miui.providers.steps/item");
  public static String a = "";
  static boolean jdField_a_of_type_Boolean;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static volatile int b;
  static long jdField_b_of_type_Long;
  static String jdField_b_of_type_JavaLangString;
  public static boolean b;
  private static String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static volatile int c;
  public static final String c;
  private static String[] c;
  static String d;
  static String e;
  static final String f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getMobileQQ().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("step.info");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Boolean = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("stepSign.info");
    f = localStringBuilder.toString();
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
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
    //   0: getstatic 75	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_b_of_type_Boolean	Z
    //   3: ifeq +75 -> 78
    //   6: new 138	com/tencent/qphone/base/util/Cryptor
    //   9: dup
    //   10: invokespecial 139	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   13: astore_3
    //   14: new 141	java/io/RandomAccessFile
    //   17: dup
    //   18: getstatic 60	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   21: ldc 143
    //   23: invokespecial 146	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: invokevirtual 149	java/io/RandomAccessFile:length	()J
    //   33: l2i
    //   34: newarray byte
    //   36: astore 4
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: aload 4
    //   43: invokevirtual 153	java/io/RandomAccessFile:read	([B)I
    //   46: pop
    //   47: aload_2
    //   48: astore_1
    //   49: new 77	java/lang/String
    //   52: dup
    //   53: aload_3
    //   54: aload 4
    //   56: ldc 155
    //   58: invokevirtual 159	java/lang/String:getBytes	()[B
    //   61: invokevirtual 163	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   64: invokespecial 166	java/lang/String:<init>	([B)V
    //   67: astore_3
    //   68: aload_2
    //   69: invokevirtual 169	java/io/RandomAccessFile:close	()V
    //   72: aload_3
    //   73: areturn
    //   74: astore_3
    //   75: goto +80 -> 155
    //   78: new 46	java/io/File
    //   81: dup
    //   82: getstatic 73	com/tencent/mobileqq/vashealth/SSOHttpUtils:f	Ljava/lang/String;
    //   85: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: new 46	java/io/File
    //   92: dup
    //   93: getstatic 60	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore_1
    //   100: aload_2
    //   101: invokevirtual 176	java/io/File:exists	()Z
    //   104: ifeq +40 -> 144
    //   107: aload_1
    //   108: invokevirtual 176	java/io/File:exists	()Z
    //   111: ifne +5 -> 116
    //   114: aconst_null
    //   115: areturn
    //   116: aload_2
    //   117: invokestatic 182	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   120: astore_2
    //   121: aload_1
    //   122: invokestatic 182	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +92 -> 219
    //   130: aload_1
    //   131: aload_2
    //   132: ldc 184
    //   134: invokestatic 188	com/tencent/mobileqq/msf/sdk/utils/SignUtils:verifyData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   137: istore_0
    //   138: iload_0
    //   139: ifeq +80 -> 219
    //   142: aload_1
    //   143: areturn
    //   144: aconst_null
    //   145: areturn
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_2
    //   149: goto +77 -> 226
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: astore_1
    //   157: new 27	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   164: astore 4
    //   166: aload_2
    //   167: astore_1
    //   168: aload 4
    //   170: ldc 190
    //   172: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_2
    //   177: astore_1
    //   178: aload 4
    //   180: getstatic 75	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_b_of_type_Boolean	Z
    //   183: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_2
    //   188: astore_1
    //   189: aload 4
    //   191: ldc 195
    //   193: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_2
    //   198: astore_1
    //   199: ldc 197
    //   201: iconst_1
    //   202: aload 4
    //   204: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: aload_3
    //   208: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 169	java/io/RandomAccessFile:close	()V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_3
    //   222: aload_1
    //   223: astore_2
    //   224: aload_3
    //   225: astore_1
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 169	java/io/RandomAccessFile:close	()V
    //   234: aload_1
    //   235: athrow
    //   236: astore_1
    //   237: aload_3
    //   238: areturn
    //   239: astore_1
    //   240: aconst_null
    //   241: areturn
    //   242: astore_2
    //   243: goto -9 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   137	2	0	bool	boolean
    //   28	115	1	localObject1	Object
    //   146	1	1	localObject2	Object
    //   156	79	1	localObject3	Object
    //   236	1	1	localIOException1	java.io.IOException
    //   239	1	1	localIOException2	java.io.IOException
    //   26	205	2	localObject4	Object
    //   242	1	2	localIOException3	java.io.IOException
    //   13	60	3	localObject5	Object
    //   74	1	3	localException1	Exception
    //   152	56	3	localException2	Exception
    //   221	17	3	str	String
    //   36	167	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   29	38	74	java/lang/Exception
    //   40	47	74	java/lang/Exception
    //   49	68	74	java/lang/Exception
    //   0	27	146	finally
    //   78	114	146	finally
    //   116	126	146	finally
    //   130	138	146	finally
    //   0	27	152	java/lang/Exception
    //   78	114	152	java/lang/Exception
    //   116	126	152	java/lang/Exception
    //   130	138	152	java/lang/Exception
    //   29	38	221	finally
    //   40	47	221	finally
    //   49	68	221	finally
    //   157	166	221	finally
    //   168	176	221	finally
    //   178	187	221	finally
    //   189	197	221	finally
    //   199	211	221	finally
    //   68	72	236	java/io/IOException
    //   215	219	239	java/io/IOException
    //   230	234	242	java/io/IOException
  }
  
  public static void a(int paramInt, String paramString)
  {
    String str2 = "";
    String str1;
    if (paramString == null) {
      str1 = "";
    } else {
      str1 = paramString;
    }
    int i = NetworkUtil.getNetworkType(MobileQQ.context);
    if (i != -1) {
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
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
    ReportController.b(null, "P_CliOper", "HealthStepReport", "", "ReportResult", paramString, paramInt, 1, jdField_c_of_type_Int, String.valueOf(jdField_b_of_type_Int), String.valueOf(jdField_a_of_type_Int), str1, Build.MODEL);
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
      int[] arrayOfInt = a();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      int j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        long l3 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
        int m = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        int k = m;
        int i = j;
        if (l2 == l3)
        {
          k = m;
          i = j;
          if (arrayOfInt[1] != -1)
          {
            k = m;
            i = j;
            if (arrayOfInt[1] > m)
            {
              k = arrayOfInt[1];
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("get step from manufacturer: ");
                ((StringBuilder)localObject2).append(arrayOfInt[1]);
                ((StringBuilder)localObject2).append(" , sensor value:");
                ((StringBuilder)localObject2).append(k);
                QLog.d("SSOHttpUtils", 2, ((StringBuilder)localObject2).toString());
              }
              i = 1;
            }
          }
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("type", 1);
          ((JSONObject)localObject2).put("time", l3);
          ((JSONObject)localObject2).put("steps", k);
          paramBundle.put(localObject2);
          j = i;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("SSOHttpUtils", 1, "error read step count from step history", localJSONException);
          j = i;
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
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" , lastRecordTime:");
        ((StringBuilder)localObject1).append(l1);
        QLog.d("SSOHttpUtils", 2, ((StringBuilder)localObject1).toString());
      }
      a(paramAppRuntime, paramBundle, bool, j, l1);
      return;
    }
    QLog.w("SSOHttpUtils", 1, "step count history is null or empty, no data to report");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if (System.currentTimeMillis() - jdField_b_of_type_Long < 1000L) {
      return;
    }
    jdField_b_of_type_Long = System.currentTimeMillis();
    if (NetConnInfoCenter.getServerTimeMillis() - jdField_a_of_type_Long < 60000L) {
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
    jdField_a_of_type_Boolean = false;
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
          a(-2, "step counter off");
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
          jdField_a_of_type_Int = paramString.getInt(((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("_init");
          jdField_b_of_type_Int = paramString.getInt(((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("_offset");
          jdField_c_of_type_Int = paramString.getInt(((StringBuilder)localObject3).toString());
          int j = jdField_a_of_type_Int - jdField_b_of_type_Int + jdField_c_of_type_Int;
          localObject2 = a();
          if ((localObject2[1] == -1) || (localObject2[1] <= j)) {
            break label1387;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("use device step :");
          ((StringBuilder)localObject3).append(localObject2[1]);
          ((StringBuilder)localObject3).append(" instead of sensor:");
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append(", yesterday: ");
          ((StringBuilder)localObject3).append(localObject2[0]);
          QLog.e("SSOHttpUtils", 1, ((StringBuilder)localObject3).toString());
          j = localObject2[1];
          if ((!jdField_a_of_type_Boolean) && (localObject2[0] > 0))
          {
            ((Map)localObject1).put(Long.valueOf(c() + 86399000L), Integer.valueOf(localObject2[0]));
            jdField_a_of_type_Boolean = true;
            break label1382;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("file contains cur_init:");
            ((StringBuilder)localObject2).append(jdField_b_of_type_Int);
            ((StringBuilder)localObject2).append(",cur_total:");
            ((StringBuilder)localObject2).append(jdField_a_of_type_Int);
            ((StringBuilder)localObject2).append(",cur_offset:");
            ((StringBuilder)localObject2).append(jdField_c_of_type_Int);
            QLog.i("SSOHttpUtils", 1, ((StringBuilder)localObject2).toString());
            if (j > 0) {
              ((Map)localObject1).put(Long.valueOf(NetConnInfoCenter.getServerTime() * 1000L), Integer.valueOf(j));
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
                int k = paramString.getInt(((StringBuilder)localObject4).toString());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append((String)localObject2);
                ((StringBuilder)localObject4).append("_init");
                int m = k - paramString.getInt(((StringBuilder)localObject4).toString());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append((String)localObject2);
                ((StringBuilder)localObject4).append("_offset");
                localObject2 = ((StringBuilder)localObject4).toString();
                k = m;
                if (paramString.has((String)localObject2))
                {
                  jdField_a_of_type_Boolean = true;
                  k = m + paramString.getInt((String)localObject2);
                }
                if (k <= 0) {
                  break label1395;
                }
                l1 += 86399000L;
                localObject2 = localObject1;
                if (!((Map)localObject2).containsKey(Long.valueOf(l1))) {
                  ((Map)localObject2).put(Long.valueOf(l1), Integer.valueOf(k));
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
              a(-3, "parameter is Empty.");
              return;
            }
            if ((j == jdField_a_of_type_Float) && (j > 0) && (((Map)localObject1).size() == 1))
            {
              localObject2 = paramAppRuntime.getAccount();
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(jdField_a_of_type_JavaLangString)))
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
            a(paramAppRuntime, (JSONArray)localObject2, paramString.optBoolean("isRestart", false), i, l1);
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
      int i = 1;
      continue;
      label1387:
      i = 0;
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
        ((JSONObject)localObject1).put("version", "8.7.0");
        ((JSONObject)localObject1).put("lastRecordTime", paramLong / 1000L);
        if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
          jdField_b_of_type_JavaLangString = URLEncoder.encode(Build.MODEL, "utf-8");
        }
        ((JSONObject)localObject1).put("model", jdField_b_of_type_JavaLangString);
        if (TextUtils.isEmpty(d))
        {
          paramJSONArray = TimeZone.getDefault();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramJSONArray.getDisplayName(false, 0));
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(paramJSONArray.getID());
          d = ((StringBuilder)localObject2).toString();
        }
        ((JSONObject)localObject1).put("zone", String.valueOf(d));
        if (TextUtils.isEmpty(e)) {
          e = MobileInfoUtil.getImei();
        }
        ((JSONObject)localObject1).put("imei", String.valueOf(e));
        ((JSONObject)localObject1).put("adcode", ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode());
        int i = 1;
        if ((paramInt == 0) && (paramBoolean))
        {
          QLog.i("SSOHttpUtils", 1, "report with exception_0");
          ((JSONObject)localObject1).put("exception_0", 1);
        }
        if (jdField_b_of_type_Boolean) {
          i = 0;
        }
        ((JSONObject)localObject1).put("mode", i);
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0");
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
    if ((jdField_b_of_type_ArrayOfJavaLangString == null) || (jdField_c_of_type_ArrayOfJavaLangString == null))
    {
      Object localObject1 = new File(MobileQQ.getMobileQQ().getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
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
              jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject1).split(",");
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              jdField_c_of_type_ArrayOfJavaLangString = ((String)localObject2).split(",");
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
      if (jdField_b_of_type_ArrayOfJavaLangString == null) {
        jdField_b_of_type_ArrayOfJavaLangString = new String[0];
      }
      if (jdField_c_of_type_ArrayOfJavaLangString == null) {
        jdField_c_of_type_ArrayOfJavaLangString = new String[0];
      }
    }
    String[] arrayOfString;
    if (paramInt == 1)
    {
      arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
      if ((arrayOfString != null) && (arrayOfString.length != 0) && (!TextUtils.isEmpty(paramString)))
      {
        paramInt = 0;
        for (;;)
        {
          arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
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
      arrayOfString = jdField_c_of_type_ArrayOfJavaLangString;
      if ((arrayOfString != null) && (arrayOfString.length != 0) && (!TextUtils.isEmpty(paramString)))
      {
        paramInt = 0;
        for (;;)
        {
          arrayOfString = jdField_c_of_type_ArrayOfJavaLangString;
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
  
  /* Error */
  public static int[] a()
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
    //   37: invokestatic 800	com/tencent/mobileqq/util/SystemUtil:b	()Z
    //   40: ifeq +408 -> 448
    //   43: aload 11
    //   45: astore 8
    //   47: aload 12
    //   49: astore 7
    //   51: ldc_w 802
    //   54: invokestatic 808	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   57: astore 14
    //   59: aload 11
    //   61: astore 8
    //   63: aload 12
    //   65: astore 7
    //   67: aload 14
    //   69: invokevirtual 811	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   72: astore 9
    //   74: aload 11
    //   76: astore 8
    //   78: aload 12
    //   80: astore 7
    //   82: aload 14
    //   84: ldc_w 812
    //   87: iconst_2
    //   88: anewarray 804	java/lang/Class
    //   91: dup
    //   92: iconst_0
    //   93: ldc 77
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: getstatic 818	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   101: aastore
    //   102: invokevirtual 822	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   105: astore 14
    //   107: aload 11
    //   109: astore 8
    //   111: aload 12
    //   113: astore 7
    //   115: aload 14
    //   117: iconst_1
    //   118: invokevirtual 827	java/lang/reflect/Method:setAccessible	(Z)V
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
    //   139: ldc_w 829
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: iconst_0
    //   146: invokestatic 832	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   149: aastore
    //   150: invokevirtual 836	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore 14
    //   155: aload 10
    //   157: astore 9
    //   159: aload 11
    //   161: astore 8
    //   163: aload 12
    //   165: astore 7
    //   167: aload 14
    //   169: instanceof 814
    //   172: ifeq +276 -> 448
    //   175: aload 10
    //   177: astore 9
    //   179: aload 11
    //   181: astore 8
    //   183: aload 12
    //   185: astore 7
    //   187: aload 14
    //   189: checkcast 814	java/lang/Boolean
    //   192: invokevirtual 839	java/lang/Boolean:booleanValue	()Z
    //   195: ifeq +253 -> 448
    //   198: aload 11
    //   200: astore 8
    //   202: aload 12
    //   204: astore 7
    //   206: invokestatic 36	mqq/app/MobileQQ:getMobileQQ	()Lmqq/app/MobileQQ;
    //   209: invokevirtual 843	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   212: astore 14
    //   214: aload 10
    //   216: astore 9
    //   218: aload 14
    //   220: ifnull +228 -> 448
    //   223: aload 11
    //   225: astore 8
    //   227: aload 12
    //   229: astore 7
    //   231: invokestatic 529	com/tencent/mobileqq/vashealth/SSOHttpUtils:c	()J
    //   234: lstore_0
    //   235: aload 11
    //   237: astore 8
    //   239: aload 12
    //   241: astore 7
    //   243: invokestatic 845	com/tencent/mobileqq/vashealth/SSOHttpUtils:b	()J
    //   246: lstore_2
    //   247: aload 11
    //   249: astore 8
    //   251: aload 12
    //   253: astore 7
    //   255: invokestatic 375	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   258: lstore 4
    //   260: aload 11
    //   262: astore 8
    //   264: aload 12
    //   266: astore 7
    //   268: aload 14
    //   270: getstatic 99	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   273: getstatic 89	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   276: ldc_w 847
    //   279: iconst_2
    //   280: anewarray 77	java/lang/String
    //   283: dup
    //   284: iconst_0
    //   285: lload_0
    //   286: invokestatic 507	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   289: aastore
    //   290: dup
    //   291: iconst_1
    //   292: lload_2
    //   293: invokestatic 507	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   296: aastore
    //   297: ldc_w 849
    //   300: invokevirtual 855	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   328: invokeinterface 860 1 0
    //   333: ifeq +115 -> 448
    //   336: aload 10
    //   338: astore 8
    //   340: aload 10
    //   342: astore 7
    //   344: aload 10
    //   346: iconst_2
    //   347: invokeinterface 863 2 0
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
    //   376: invokeinterface 865 2 0
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
    //   404: invokeinterface 865 2 0
    //   409: iadd
    //   410: iastore
    //   411: aload 10
    //   413: astore 8
    //   415: aload 10
    //   417: astore 7
    //   419: aload 10
    //   421: invokeinterface 868 1 0
    //   426: istore 6
    //   428: iload 6
    //   430: ifne -94 -> 336
    //   433: aload 10
    //   435: ifnull +10 -> 445
    //   438: aload 10
    //   440: invokeinterface 869 1 0
    //   445: aload 13
    //   447: areturn
    //   448: aload 9
    //   450: ifnull +57 -> 507
    //   453: aload 9
    //   455: astore 7
    //   457: aload 7
    //   459: invokeinterface 869 1 0
    //   464: goto +43 -> 507
    //   467: astore 7
    //   469: goto +50 -> 519
    //   472: astore 9
    //   474: aload 7
    //   476: astore 8
    //   478: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +18 -> 499
    //   484: aload 7
    //   486: astore 8
    //   488: ldc 197
    //   490: iconst_2
    //   491: ldc_w 871
    //   494: aload 9
    //   496: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   526: invokeinterface 869 1 0
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
  
  public static long b()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(11, 23);
    localCalendar.set(12, 59);
    localCalendar.set(13, 59);
    return localCalendar.getTimeInMillis();
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
      ((JSONObject)localObject2).put("version", "8.7.0");
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
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.7.0");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SSOHttpUtils
 * JD-Core Version:    0.7.0.1
 */