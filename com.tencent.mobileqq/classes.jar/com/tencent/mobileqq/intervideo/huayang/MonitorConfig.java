package com.tencent.mobileqq.intervideo.huayang;

import adun;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class MonitorConfig
{
  public static Map a;
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  /* Error */
  private static JSONObject a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 32	java/io/File
    //   3: dup
    //   4: new 34	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokestatic 40	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 46
    //   24: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 57	java/io/File:exists	()Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifeq +36 -> 80
    //   47: new 59	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 62	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_0
    //   56: aload_0
    //   57: ifnonnull +49 -> 106
    //   60: aload_0
    //   61: ifnull +7 -> 68
    //   64: aload_0
    //   65: invokevirtual 67	java/io/InputStream:close	()V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   75: aconst_null
    //   76: astore_0
    //   77: goto -21 -> 56
    //   80: iconst_0
    //   81: ifeq -13 -> 68
    //   84: new 72	java/lang/NullPointerException
    //   87: dup
    //   88: invokespecial 73	java/lang/NullPointerException:<init>	()V
    //   91: athrow
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: aload_0
    //   107: invokestatic 78	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   110: astore_1
    //   111: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +28 -> 142
    //   117: ldc 85
    //   119: iconst_2
    //   120: new 34	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   127: ldc 87
    //   129: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: new 92	org/json/JSONObject
    //   145: dup
    //   146: aload_1
    //   147: invokespecial 93	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   150: astore_1
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 67	java/io/InputStream:close	()V
    //   159: aload_1
    //   160: areturn
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   166: goto -7 -> 159
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 94	org/json/JSONException:printStackTrace	()V
    //   174: aload_0
    //   175: ifnull -107 -> 68
    //   178: aload_0
    //   179: invokevirtual 67	java/io/InputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: ifnull +7 -> 202
    //   198: aload_1
    //   199: invokevirtual 67	java/io/InputStream:close	()V
    //   202: aload_0
    //   203: athrow
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   209: goto -7 -> 202
    //   212: astore_3
    //   213: aload_0
    //   214: astore_1
    //   215: aload_3
    //   216: astore_0
    //   217: goto -23 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString1	String
    //   0	220	1	paramString2	String
    //   42	2	2	bool	boolean
    //   212	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	56	70	java/io/IOException
    //   84	92	92	java/io/IOException
    //   64	68	99	java/io/IOException
    //   155	159	161	java/io/IOException
    //   142	151	169	org/json/JSONException
    //   178	182	184	java/io/IOException
    //   38	43	191	finally
    //   47	56	191	finally
    //   71	75	191	finally
    //   198	202	204	java/io/IOException
    //   106	142	212	finally
    //   142	151	212	finally
    //   170	174	212	finally
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilMap.size() > 0) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject1 = a("3136", "monitor.json");
        if (localJSONObject1 != null) {
          break label89;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MonitorConfig", 2, "pareMonitorConfig jsonObject:" + localJSONObject1);
        return;
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel())
      {
        QLog.d("MonitorConfig", 2, "pareMonitorConfig exception :" + localThrowable);
        return;
        label89:
        Iterator localIterator = localThrowable.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          JSONObject localJSONObject2 = localThrowable.getJSONObject(str);
          MonitorConfig localMonitorConfig = new MonitorConfig();
          localMonitorConfig.jdField_a_of_type_Int = localJSONObject2.optInt("startupId");
          localMonitorConfig.b = localJSONObject2.optInt("downloadSucId");
          localMonitorConfig.c = localJSONObject2.optInt("downloadFailId");
          localMonitorConfig.d = localJSONObject2.optInt("loadSucId");
          localMonitorConfig.e = localJSONObject2.optInt("loadFailId");
          localMonitorConfig.f = localJSONObject2.optInt("startSucId");
          localMonitorConfig.g = localJSONObject2.optInt("firstUserId");
          localMonitorConfig.h = localJSONObject2.optInt("exitId");
          jdField_a_of_type_JavaUtilMap.put(str, localMonitorConfig);
          if (QLog.isColorLevel()) {
            QLog.d("MonitorConfig", 2, str + localMonitorConfig);
          }
        }
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    ThreadManager.post(new adun(paramAppRuntime), 5, null, false);
  }
  
  public String toString()
  {
    return "MonitorConfig{startupId=" + this.jdField_a_of_type_Int + ", downloadSucId=" + this.b + ", downloadFailId=" + this.c + ", loadSucId=" + this.d + ", loadFailId=" + this.e + ", startSucId=" + this.f + ", firstUserId=" + this.g + ", exitId=" + this.h + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.MonitorConfig
 * JD-Core Version:    0.7.0.1
 */