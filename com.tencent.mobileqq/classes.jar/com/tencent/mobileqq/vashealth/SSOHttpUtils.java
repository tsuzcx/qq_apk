package com.tencent.mobileqq.vashealth;

import akrp;
import akrq;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
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
  static final Uri jdField_a_of_type_AndroidNetUri = Uri.parse("content://com.miui.providers.steps/item");
  public static String a;
  public static boolean a;
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
  static String f;
  static final String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "step.info";
    g = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "stepSign.info";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
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
    //   2: invokestatic 195	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()[I
    //   5: astore 4
    //   7: aload 4
    //   9: iconst_1
    //   10: iaload
    //   11: iconst_m1
    //   12: if_icmpeq +117 -> 129
    //   15: new 109	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 196	org/json/JSONObject:<init>	()V
    //   22: astore_3
    //   23: invokestatic 143	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   26: invokestatic 147	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: new 26	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 149
    //   44: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: iconst_0
    //   51: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload_3
    //   56: new 26	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   63: aload_2
    //   64: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 154
    //   69: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: iconst_0
    //   76: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_3
    //   81: new 26	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   88: aload_2
    //   89: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 160
    //   94: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: aload 4
    //   102: iconst_1
    //   103: iaload
    //   104: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   107: pop
    //   108: aload_3
    //   109: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: iconst_0
    //   116: ifeq +11 -> 127
    //   119: new 203	java/lang/NullPointerException
    //   122: dup
    //   123: invokespecial 204	java/lang/NullPointerException:<init>	()V
    //   126: athrow
    //   127: aload_1
    //   128: areturn
    //   129: getstatic 206	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_b_of_type_Boolean	Z
    //   132: ifeq +80 -> 212
    //   135: new 208	com/tencent/qphone/base/util/Cryptor
    //   138: dup
    //   139: invokespecial 209	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   142: astore_3
    //   143: new 211	java/io/RandomAccessFile
    //   146: dup
    //   147: getstatic 59	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   150: ldc 213
    //   152: invokespecial 216	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: astore_2
    //   156: aload_2
    //   157: astore_1
    //   158: aload_2
    //   159: invokevirtual 219	java/io/RandomAccessFile:length	()J
    //   162: l2i
    //   163: newarray byte
    //   165: astore 4
    //   167: aload_2
    //   168: astore_1
    //   169: aload_2
    //   170: aload 4
    //   172: invokevirtual 223	java/io/RandomAccessFile:read	([B)I
    //   175: pop
    //   176: aload_2
    //   177: astore_1
    //   178: new 72	java/lang/String
    //   181: dup
    //   182: aload_3
    //   183: aload 4
    //   185: ldc 225
    //   187: invokevirtual 229	java/lang/String:getBytes	()[B
    //   190: invokevirtual 233	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   193: invokespecial 236	java/lang/String:<init>	([B)V
    //   196: astore_3
    //   197: aload_3
    //   198: astore_1
    //   199: aload_2
    //   200: ifnull -73 -> 127
    //   203: aload_2
    //   204: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   207: aload_3
    //   208: areturn
    //   209: astore_1
    //   210: aload_3
    //   211: areturn
    //   212: new 45	java/io/File
    //   215: dup
    //   216: getstatic 70	com/tencent/mobileqq/vashealth/SSOHttpUtils:g	Ljava/lang/String;
    //   219: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore_3
    //   223: new 45	java/io/File
    //   226: dup
    //   227: getstatic 59	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   230: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   233: astore_2
    //   234: aload_3
    //   235: invokevirtual 243	java/io/File:exists	()Z
    //   238: ifeq +12 -> 250
    //   241: aload_2
    //   242: invokevirtual 243	java/io/File:exists	()Z
    //   245: istore_0
    //   246: iload_0
    //   247: ifne +17 -> 264
    //   250: iconst_0
    //   251: ifeq +11 -> 262
    //   254: new 203	java/lang/NullPointerException
    //   257: dup
    //   258: invokespecial 204	java/lang/NullPointerException:<init>	()V
    //   261: athrow
    //   262: aconst_null
    //   263: areturn
    //   264: aload_3
    //   265: invokestatic 249	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   268: astore_3
    //   269: aload_2
    //   270: invokestatic 249	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   273: astore_2
    //   274: aload_2
    //   275: ifnull +32 -> 307
    //   278: aload_2
    //   279: aload_3
    //   280: ldc 251
    //   282: invokestatic 255	com/tencent/mobileqq/msf/sdk/utils/SignUtils:verifyData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   285: istore_0
    //   286: iload_0
    //   287: ifeq +20 -> 307
    //   290: aload_2
    //   291: astore_1
    //   292: iconst_0
    //   293: ifeq -166 -> 127
    //   296: new 203	java/lang/NullPointerException
    //   299: dup
    //   300: invokespecial 204	java/lang/NullPointerException:<init>	()V
    //   303: athrow
    //   304: astore_1
    //   305: aload_2
    //   306: areturn
    //   307: iconst_0
    //   308: ifeq +11 -> 319
    //   311: new 203	java/lang/NullPointerException
    //   314: dup
    //   315: invokespecial 204	java/lang/NullPointerException:<init>	()V
    //   318: athrow
    //   319: aconst_null
    //   320: areturn
    //   321: astore_3
    //   322: aconst_null
    //   323: astore_2
    //   324: aload_2
    //   325: astore_1
    //   326: ldc 120
    //   328: iconst_1
    //   329: new 26	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 257
    //   339: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 206	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_b_of_type_Boolean	Z
    //   345: invokevirtual 260	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   348: ldc_w 262
    //   351: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload_3
    //   358: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: aload_2
    //   362: ifnull -43 -> 319
    //   365: aload_2
    //   366: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   369: goto -50 -> 319
    //   372: astore_1
    //   373: goto -54 -> 319
    //   376: astore_3
    //   377: aload_1
    //   378: astore_2
    //   379: aload_3
    //   380: astore_1
    //   381: aload_2
    //   382: ifnull +7 -> 389
    //   385: aload_2
    //   386: invokevirtual 239	java/io/RandomAccessFile:close	()V
    //   389: aload_1
    //   390: athrow
    //   391: astore_1
    //   392: aload_2
    //   393: areturn
    //   394: astore_1
    //   395: goto -133 -> 262
    //   398: astore_1
    //   399: goto -80 -> 319
    //   402: astore_2
    //   403: goto -14 -> 389
    //   406: astore_3
    //   407: aload_1
    //   408: astore_2
    //   409: aload_3
    //   410: astore_1
    //   411: goto -30 -> 381
    //   414: astore_3
    //   415: goto -91 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   245	42	0	bool	boolean
    //   1	198	1	localObject1	Object
    //   209	1	1	localIOException1	java.io.IOException
    //   291	1	1	localObject2	Object
    //   304	1	1	localIOException2	java.io.IOException
    //   325	1	1	localObject3	Object
    //   372	6	1	localIOException3	java.io.IOException
    //   380	10	1	localObject4	Object
    //   391	1	1	localIOException4	java.io.IOException
    //   394	1	1	localIOException5	java.io.IOException
    //   398	10	1	localIOException6	java.io.IOException
    //   410	1	1	localObject5	Object
    //   29	364	2	localObject6	Object
    //   402	1	2	localIOException7	java.io.IOException
    //   408	1	2	localIOException8	java.io.IOException
    //   22	258	3	localObject7	Object
    //   321	37	3	localException1	Exception
    //   376	4	3	localObject8	Object
    //   406	4	3	localObject9	Object
    //   414	1	3	localException2	Exception
    //   5	179	4	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   203	207	209	java/io/IOException
    //   296	304	304	java/io/IOException
    //   2	7	321	java/lang/Exception
    //   15	113	321	java/lang/Exception
    //   129	156	321	java/lang/Exception
    //   212	246	321	java/lang/Exception
    //   264	274	321	java/lang/Exception
    //   278	286	321	java/lang/Exception
    //   365	369	372	java/io/IOException
    //   2	7	376	finally
    //   15	113	376	finally
    //   129	156	376	finally
    //   212	246	376	finally
    //   264	274	376	finally
    //   278	286	376	finally
    //   119	127	391	java/io/IOException
    //   254	262	394	java/io/IOException
    //   311	319	398	java/io/IOException
    //   385	389	402	java/io/IOException
    //   158	167	406	finally
    //   169	176	406	finally
    //   178	197	406	finally
    //   326	361	406	finally
    //   158	167	414	java/lang/Exception
    //   169	176	414	java/lang/Exception
    //   178	197	414	java/lang/Exception
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
    int j = jdField_a_of_type_Int - jdField_b_of_type_Int + jdField_c_of_type_Int;
    Object localObject2 = a();
    int i = j;
    if (localObject2[1] != -1)
    {
      i = j;
      if (localObject2[1] != j)
      {
        QLog.e("SSOHttpUtils", 1, "use device step :" + localObject2[1] + " instead of :" + j);
        ((Map)localObject1).put(Long.valueOf(c() + 86399000L), Integer.valueOf(localObject2[0]));
        i = localObject2[1];
        jdField_a_of_type_Boolean = true;
      }
    }
    QLog.i("SSOHttpUtils", 1, "file contains cur_init:" + jdField_b_of_type_Int + ",cur_total:" + jdField_a_of_type_Int + ",cur_offset:" + jdField_c_of_type_Int);
    if (i > 0) {
      ((Map)localObject1).put(Long.valueOf(NetConnInfoCenter.getServerTime() * 1000L), Integer.valueOf(i));
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
        break label1101;
      }
      ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      ((Calendar)localObject2).set(11, 0);
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      ((Calendar)localObject2).set(14, 0);
      ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) - 6);
      l1 = ((Calendar)localObject2).getTimeInMillis();
    }
    label1101:
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
          int k = paramString.getInt((String)localObject3 + "_total") - paramString.getInt((String)localObject3 + "_init");
          localObject3 = (String)localObject3 + "_offset";
          j = k;
          if (paramString.has((String)localObject3))
          {
            jdField_a_of_type_Boolean = true;
            j = k + paramString.getInt((String)localObject3);
          }
          if ((j > 0) && (!((Map)localObject1).containsKey(Long.valueOf(86399000L + l1)))) {
            ((Map)localObject1).put(Long.valueOf(l1 + 86399000L), Integer.valueOf(j));
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
        if ((i == jdField_a_of_type_Float) && (i > 0) && (((Map)localObject1).size() == 1))
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
        ((JSONObject)localObject1).put("version", "7.6.8");
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
          SosoInterface.a(new akrp(0, true, true, 0L, false, false, "SSOHttpUtils", paramJSONArray, l2));
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("7.6.8");
      paramJSONArray = new WebSSOAgent.UniSsoServerReq();
      paramJSONArray.comm.set((MessageMicro)localObject2);
      paramJSONArray.reqdata.set(((JSONObject)localObject1).toString());
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "parameter:" + ((JSONObject)localObject1).toString());
      }
      localObject1 = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), WebSSOAgentServlet.class);
      ((NewIntent)localObject1).putExtra("extra_cmd", "yundong_report.steps");
      ((NewIntent)localObject1).putExtra("extra_data", paramJSONArray.toByteArray());
      ((NewIntent)localObject1).setObserver(new akrq());
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject1);
      return;
      i = 1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject1;
    if ((jdField_b_of_type_ArrayOfJavaLangString == null) || (jdField_c_of_type_ArrayOfJavaLangString == null))
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
        jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject1).split(",");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        jdField_c_of_type_ArrayOfJavaLangString = ((String)localObject2).split(",");
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
      if ((paramInt != 2) || (jdField_c_of_type_ArrayOfJavaLangString == null) || (jdField_c_of_type_ArrayOfJavaLangString.length == 0)) {
        break label341;
      }
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (TextUtils.isEmpty(str)) {
        break label341;
      }
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= jdField_c_of_type_ArrayOfJavaLangString.length) {
          break label341;
        }
        if (str.endsWith(jdField_c_of_type_ArrayOfJavaLangString[paramInt]))
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
    if (jdField_b_of_type_ArrayOfJavaLangString == null) {
      jdField_b_of_type_ArrayOfJavaLangString = new String[0];
    }
    if (jdField_c_of_type_ArrayOfJavaLangString == null) {
      jdField_c_of_type_ArrayOfJavaLangString = new String[0];
    }
    if (paramInt == 1)
    {
      if ((jdField_b_of_type_ArrayOfJavaLangString == null) || (jdField_b_of_type_ArrayOfJavaLangString.length == 0)) {
        break label341;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label341;
      }
      paramInt = 0;
      if (paramInt >= jdField_b_of_type_ArrayOfJavaLangString.length) {
        break label341;
      }
      if (((String)localObject1).endsWith(jdField_b_of_type_ArrayOfJavaLangString[paramInt]))
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
  
  /* Error */
  public static int[] a()
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray int
    //   3: astore 10
    //   5: aload 10
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
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 9
    //   22: aload 9
    //   24: astore 7
    //   26: invokestatic 707	com/tencent/mobileqq/util/SystemUtil:b	()Z
    //   29: ifeq +335 -> 364
    //   32: ldc_w 709
    //   35: invokestatic 715	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore 11
    //   40: aload 11
    //   42: invokevirtual 718	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   45: astore 7
    //   47: aload 11
    //   49: ldc_w 719
    //   52: iconst_2
    //   53: anewarray 711	java/lang/Class
    //   56: dup
    //   57: iconst_0
    //   58: ldc 72
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: getstatic 725	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   66: aastore
    //   67: invokevirtual 729	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   70: astore 11
    //   72: aload 11
    //   74: iconst_1
    //   75: invokevirtual 735	java/lang/reflect/Method:setAccessible	(Z)V
    //   78: aload 11
    //   80: aload 7
    //   82: iconst_2
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: ldc_w 737
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokestatic 740	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: invokevirtual 744	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore 11
    //   104: aload 9
    //   106: astore 7
    //   108: aload 11
    //   110: instanceof 721
    //   113: ifeq +251 -> 364
    //   116: aload 9
    //   118: astore 7
    //   120: aload 11
    //   122: checkcast 721	java/lang/Boolean
    //   125: invokevirtual 747	java/lang/Boolean:booleanValue	()Z
    //   128: ifeq +236 -> 364
    //   131: invokestatic 35	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   134: invokevirtual 751	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   137: astore 11
    //   139: aload 9
    //   141: astore 7
    //   143: aload 11
    //   145: ifnull +219 -> 364
    //   148: invokestatic 341	com/tencent/mobileqq/vashealth/SSOHttpUtils:c	()J
    //   151: lstore_0
    //   152: invokestatic 753	com/tencent/mobileqq/vashealth/SSOHttpUtils:b	()J
    //   155: lstore_2
    //   156: invokestatic 143	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   159: lstore 4
    //   161: aload 11
    //   163: getstatic 94	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   166: getstatic 84	com/tencent/mobileqq/vashealth/SSOHttpUtils:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   169: ldc_w 755
    //   172: iconst_2
    //   173: anewarray 72	java/lang/String
    //   176: dup
    //   177: iconst_0
    //   178: lload_0
    //   179: invokestatic 147	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: lload_2
    //   186: invokestatic 147	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   189: aastore
    //   190: ldc_w 757
    //   193: invokevirtual 763	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   196: astore 7
    //   198: aload 7
    //   200: ifnull +164 -> 364
    //   203: aload 7
    //   205: astore 8
    //   207: aload 7
    //   209: invokeinterface 768 1 0
    //   214: ifeq +150 -> 364
    //   217: aload 7
    //   219: astore 8
    //   221: aload 7
    //   223: iconst_2
    //   224: invokeinterface 771 2 0
    //   229: lload 4
    //   231: lcmp
    //   232: ifge +57 -> 289
    //   235: aload 7
    //   237: astore 8
    //   239: aload 10
    //   241: iconst_0
    //   242: aload 10
    //   244: iconst_0
    //   245: iaload
    //   246: aload 7
    //   248: iconst_4
    //   249: invokeinterface 773 2 0
    //   254: iadd
    //   255: iastore
    //   256: aload 7
    //   258: astore 8
    //   260: aload 7
    //   262: invokeinterface 776 1 0
    //   267: istore 6
    //   269: iload 6
    //   271: ifne -54 -> 217
    //   274: aload 7
    //   276: ifnull +10 -> 286
    //   279: aload 7
    //   281: invokeinterface 777 1 0
    //   286: aload 10
    //   288: areturn
    //   289: aload 7
    //   291: astore 8
    //   293: aload 10
    //   295: iconst_1
    //   296: aload 10
    //   298: iconst_1
    //   299: iaload
    //   300: aload 7
    //   302: iconst_4
    //   303: invokeinterface 773 2 0
    //   308: iadd
    //   309: iastore
    //   310: goto -54 -> 256
    //   313: astore 9
    //   315: aload 7
    //   317: astore 8
    //   319: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +18 -> 340
    //   325: aload 7
    //   327: astore 8
    //   329: ldc 120
    //   331: iconst_2
    //   332: ldc_w 779
    //   335: aload 9
    //   337: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload 7
    //   342: ifnull +10 -> 352
    //   345: aload 7
    //   347: invokeinterface 777 1 0
    //   352: iconst_2
    //   353: newarray int
    //   355: dup
    //   356: iconst_0
    //   357: iconst_m1
    //   358: iastore
    //   359: dup
    //   360: iconst_1
    //   361: iconst_m1
    //   362: iastore
    //   363: areturn
    //   364: aload 7
    //   366: ifnull -14 -> 352
    //   369: aload 7
    //   371: invokeinterface 777 1 0
    //   376: goto -24 -> 352
    //   379: astore 7
    //   381: aload 8
    //   383: ifnull +10 -> 393
    //   386: aload 8
    //   388: invokeinterface 777 1 0
    //   393: aload 7
    //   395: athrow
    //   396: astore 7
    //   398: goto -17 -> 381
    //   401: astore 9
    //   403: aconst_null
    //   404: astore 7
    //   406: goto -91 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   151	28	0	l1	long
    //   155	31	2	l2	long
    //   159	71	4	l3	long
    //   267	3	6	bool	boolean
    //   24	346	7	localObject1	Object
    //   379	15	7	localObject2	Object
    //   396	1	7	localObject3	Object
    //   404	1	7	localObject4	Object
    //   17	370	8	localObject5	Object
    //   20	120	9	localObject6	Object
    //   313	23	9	localException1	Exception
    //   401	1	9	localException2	Exception
    //   3	294	10	arrayOfInt	int[]
    //   38	124	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   207	217	313	java/lang/Exception
    //   221	235	313	java/lang/Exception
    //   239	256	313	java/lang/Exception
    //   260	269	313	java/lang/Exception
    //   293	310	313	java/lang/Exception
    //   26	104	379	finally
    //   108	116	379	finally
    //   120	139	379	finally
    //   148	198	379	finally
    //   207	217	396	finally
    //   221	235	396	finally
    //   239	256	396	finally
    //   260	269	396	finally
    //   293	310	396	finally
    //   319	325	396	finally
    //   329	340	396	finally
    //   26	104	401	java/lang/Exception
    //   108	116	401	java/lang/Exception
    //   120	139	401	java/lang/Exception
    //   148	198	401	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SSOHttpUtils
 * JD-Core Version:    0.7.0.1
 */