package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class SettingCloneUtil
{
  private static final String KEY_FILE = "set_sp";
  private static final String KEY_FILE_MULTI_PROCESS = "set_sp_mp";
  private static final HashSet MULTIPROCESS_KEYS;
  private static Object locker = new Object();
  private static volatile boolean mHasInit = false;
  private static final HashMap mapKv = new HashMap();
  private static final HashMap tmpMapKv = new HashMap();
  
  static
  {
    MULTIPROCESS_KEYS = new HashSet(6);
    MULTIPROCESS_KEYS.add("qqsetting_screenshot_key");
    MULTIPROCESS_KEYS.add("qqsetting_notify_blncontrol_key");
    MULTIPROCESS_KEYS.add("qqsetting_lock_screen_whenexit_key");
    MULTIPROCESS_KEYS.add("qqsetting_avcall_notify_key");
    MULTIPROCESS_KEYS.add("qqsetting_qrlogin_set_mute");
    MULTIPROCESS_KEYS.add("qqsetting_locale_id");
    MULTIPROCESS_KEYS.add("new_msg_notification_key");
  }
  
  public static boolean firstInit(String paramString1, String paramString2, String paramString3)
  {
    localObject = locker;
    boolean bool1 = false;
    StringBuilder localStringBuilder;
    try
    {
      if (mapKv.containsKey(paramString1))
      {
        paramString2 = (String)mapKv.get(paramString1);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("containsKey is true, key=");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" v=");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" tag=");
          localStringBuilder.append(paramString3);
          QLog.d("set_sp", 2, localStringBuilder.toString());
        }
      }
    }
    finally {}
    try
    {
      bool2 = Boolean.parseBoolean(paramString2);
      bool1 = bool2;
    }
    catch (Exception paramString2)
    {
      break label207;
    }
    if (paramString1 != null) {
      mapKv.put(paramString1, paramString2);
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key is new, key=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" v=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" tag=");
      localStringBuilder.append(paramString3);
      QLog.d("set_sp", 2, localStringBuilder.toString());
    }
    boolean bool2 = Boolean.parseBoolean(paramString2);
    bool1 = bool2;
    label207:
    if (MULTIPROCESS_KEYS.contains(paramString1)) {
      getSharedPreferences().edit().putBoolean(paramString1, bool1).commit();
    }
    return bool1;
  }
  
  public static int firstInitForInt(String paramString1, String paramString2, String paramString3)
  {
    localObject = locker;
    int i = -1;
    StringBuilder localStringBuilder;
    label203:
    try
    {
      if (mapKv.containsKey(paramString1))
      {
        paramString2 = (String)mapKv.get(paramString1);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("containsKey is true, key=");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" v=");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" tag=");
          localStringBuilder.append(paramString3);
          QLog.d("set_sp", 2, localStringBuilder.toString());
        }
      }
    }
    finally {}
    try
    {
      j = Integer.parseInt(paramString2);
      i = j;
    }
    catch (Exception paramString1)
    {
      break label203;
    }
    mapKv.put(paramString1, paramString2);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key is new, key=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" v=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" tag=");
      localStringBuilder.append(paramString3);
      QLog.d("set_sp", 2, localStringBuilder.toString());
    }
    int j = Integer.parseInt(paramString2);
    i = j;
    return i;
  }
  
  public static String get(String paramString)
  {
    for (;;)
    {
      synchronized (locker)
      {
        if (mapKv.containsKey(paramString))
        {
          localObject1 = (String)mapKv.get(paramString);
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (tmpMapKv.containsKey(paramString)) {
              localObject2 = (String)tmpMapKv.get(paramString);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("get k=");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(" v=");
            ((StringBuilder)localObject1).append((String)localObject2);
            QLog.d("set_sp", 2, ((StringBuilder)localObject1).toString());
          }
          return localObject2;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    return SharedPreferencesProxyManager.getInstance().getProxy("set_sp_mp", 4);
  }
  
  /* Error */
  public static boolean isContainValue(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: ifnonnull +19 -> 23
    //   7: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 8
    //   15: iconst_2
    //   16: ldc 163
    //   18: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_3
    //   24: astore 7
    //   26: aload_1
    //   27: ifnull +43 -> 70
    //   30: aload_3
    //   31: astore 7
    //   33: aload_1
    //   34: invokevirtual 167	java/lang/String:length	()I
    //   37: ifle +33 -> 70
    //   40: new 83	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   47: astore 6
    //   49: aload 6
    //   51: aload_3
    //   52: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 6
    //   58: aload_1
    //   59: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 6
    //   65: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 7
    //   70: aload_0
    //   71: invokestatic 171	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isKeyFileExists	(Landroid/content/Context;)Z
    //   74: ifeq +433 -> 507
    //   77: aconst_null
    //   78: astore 9
    //   80: aconst_null
    //   81: astore 8
    //   83: aload 8
    //   85: astore_3
    //   86: aload 9
    //   88: astore 6
    //   90: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +18 -> 111
    //   96: aload 8
    //   98: astore_3
    //   99: aload 9
    //   101: astore 6
    //   103: ldc 8
    //   105: iconst_2
    //   106: ldc 173
    //   108: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 8
    //   113: astore_3
    //   114: aload 9
    //   116: astore 6
    //   118: aload_0
    //   119: ldc 8
    //   121: invokevirtual 179	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   124: astore 8
    //   126: aload 8
    //   128: astore_3
    //   129: aload 8
    //   131: astore 6
    //   133: new 181	java/util/Properties
    //   136: dup
    //   137: invokespecial 182	java/util/Properties:<init>	()V
    //   140: astore 9
    //   142: aload 8
    //   144: astore_3
    //   145: aload 8
    //   147: astore 6
    //   149: aload 9
    //   151: aload 8
    //   153: invokevirtual 186	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   156: aload 8
    //   158: astore_3
    //   159: aload 8
    //   161: astore 6
    //   163: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +18 -> 184
    //   169: aload 8
    //   171: astore_3
    //   172: aload 8
    //   174: astore 6
    //   176: ldc 8
    //   178: iconst_2
    //   179: ldc 188
    //   181: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 8
    //   186: astore_3
    //   187: aload 8
    //   189: astore 6
    //   191: aload 9
    //   193: aload 7
    //   195: invokevirtual 189	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   198: istore 5
    //   200: iload 5
    //   202: ifeq +62 -> 264
    //   205: aload 8
    //   207: ifnull +55 -> 262
    //   210: aload 8
    //   212: invokevirtual 194	java/io/FileInputStream:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_0
    //   218: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +37 -> 258
    //   224: new 83	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   231: astore_1
    //   232: aload_1
    //   233: ldc 196
    //   235: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: aload_0
    //   241: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   244: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: ldc 8
    //   250: iconst_2
    //   251: aload_1
    //   252: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload_0
    //   259: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   262: iconst_1
    //   263: ireturn
    //   264: aload 8
    //   266: ifnull +241 -> 507
    //   269: aload 8
    //   271: invokevirtual 194	java/io/FileInputStream:close	()V
    //   274: goto +233 -> 507
    //   277: astore 6
    //   279: aload 6
    //   281: astore_3
    //   282: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +44 -> 329
    //   288: new 83	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   295: astore 7
    //   297: aload 6
    //   299: astore_3
    //   300: aload 7
    //   302: ldc 196
    //   304: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 7
    //   310: aload_3
    //   311: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   314: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: ldc 8
    //   320: iconst_2
    //   321: aload 7
    //   323: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_3
    //   330: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   333: goto +174 -> 507
    //   336: astore_0
    //   337: goto +112 -> 449
    //   340: astore 7
    //   342: aload 6
    //   344: astore_3
    //   345: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +54 -> 402
    //   351: aload 6
    //   353: astore_3
    //   354: new 83	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   361: astore 8
    //   363: aload 6
    //   365: astore_3
    //   366: aload 8
    //   368: ldc 205
    //   370: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 6
    //   376: astore_3
    //   377: aload 8
    //   379: aload 7
    //   381: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   384: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 6
    //   390: astore_3
    //   391: ldc 8
    //   393: iconst_2
    //   394: aload 8
    //   396: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload 6
    //   404: astore_3
    //   405: aload 7
    //   407: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   410: aload 6
    //   412: ifnull +95 -> 507
    //   415: aload 6
    //   417: invokevirtual 194	java/io/FileInputStream:close	()V
    //   420: goto +87 -> 507
    //   423: astore 6
    //   425: aload 6
    //   427: astore_3
    //   428: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq -102 -> 329
    //   434: new 83	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   441: astore 7
    //   443: aload 6
    //   445: astore_3
    //   446: goto -146 -> 300
    //   449: aload_3
    //   450: ifnull +55 -> 505
    //   453: aload_3
    //   454: invokevirtual 194	java/io/FileInputStream:close	()V
    //   457: goto +48 -> 505
    //   460: astore_1
    //   461: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq +37 -> 501
    //   467: new 83	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   474: astore_2
    //   475: aload_2
    //   476: ldc 196
    //   478: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_2
    //   483: aload_1
    //   484: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   487: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: ldc 8
    //   493: iconst_2
    //   494: aload_2
    //   495: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   501: aload_1
    //   502: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   505: aload_0
    //   506: athrow
    //   507: aload_2
    //   508: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   511: ifne +103 -> 614
    //   514: aload_0
    //   515: invokestatic 217	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   518: astore_3
    //   519: aload_2
    //   520: astore_0
    //   521: aload_1
    //   522: ifnull +37 -> 559
    //   525: aload_2
    //   526: astore_0
    //   527: aload_1
    //   528: invokevirtual 167	java/lang/String:length	()I
    //   531: ifle +28 -> 559
    //   534: new 83	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   541: astore_0
    //   542: aload_0
    //   543: aload_2
    //   544: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload_0
    //   549: aload_1
    //   550: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload_0
    //   555: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: astore_0
    //   559: aload_3
    //   560: aload_0
    //   561: invokeinterface 219 2 0
    //   566: istore 5
    //   568: iload 5
    //   570: istore 4
    //   572: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +39 -> 614
    //   578: new 83	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   585: astore_0
    //   586: aload_0
    //   587: ldc 221
    //   589: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_0
    //   594: iload 5
    //   596: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: ldc 8
    //   602: iconst_2
    //   603: aload_0
    //   604: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: iload 5
    //   612: istore 4
    //   614: iload 4
    //   616: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramContext	Context
    //   0	617	1	paramString1	String
    //   0	617	2	paramString2	String
    //   0	617	3	paramString3	String
    //   1	614	4	bool1	boolean
    //   198	413	5	bool2	boolean
    //   47	143	6	localObject1	Object
    //   277	139	6	localThrowable1	java.lang.Throwable
    //   423	21	6	localThrowable2	java.lang.Throwable
    //   24	298	7	localObject2	Object
    //   340	66	7	localThrowable3	java.lang.Throwable
    //   441	1	7	localStringBuilder	StringBuilder
    //   81	314	8	localObject3	Object
    //   78	114	9	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   210	215	217	java/lang/Throwable
    //   269	274	277	java/lang/Throwable
    //   90	96	336	finally
    //   103	111	336	finally
    //   118	126	336	finally
    //   133	142	336	finally
    //   149	156	336	finally
    //   163	169	336	finally
    //   176	184	336	finally
    //   191	200	336	finally
    //   345	351	336	finally
    //   354	363	336	finally
    //   366	374	336	finally
    //   377	388	336	finally
    //   391	402	336	finally
    //   405	410	336	finally
    //   90	96	340	java/lang/Throwable
    //   103	111	340	java/lang/Throwable
    //   118	126	340	java/lang/Throwable
    //   133	142	340	java/lang/Throwable
    //   149	156	340	java/lang/Throwable
    //   163	169	340	java/lang/Throwable
    //   176	184	340	java/lang/Throwable
    //   191	200	340	java/lang/Throwable
    //   415	420	423	java/lang/Throwable
    //   453	457	460	java/lang/Throwable
  }
  
  private static boolean isKeyFileExists(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getFileStreamPath("set_sp") != null)
      {
        bool1 = bool2;
        if (paramContext.getFileStreamPath("set_sp").exists()) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("file exist:");
      paramContext.append(bool1);
      QLog.d("set_sp", 2, paramContext.toString());
    }
    return bool1;
  }
  
  public static boolean put(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("put k=");
        ((StringBuilder)???).append(paramString1);
        ((StringBuilder)???).append(" v=");
        ((StringBuilder)???).append(paramString2);
        QLog.d("set_sp", 2, ((StringBuilder)???).toString());
      }
      synchronized (locker)
      {
        String str = (String)mapKv.get(paramString1);
        if ((str != null) && (str.equals(paramString2))) {
          return false;
        }
        mapKv.put(paramString1, paramString2);
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static String readFromFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 29	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mHasInit	Z
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore_3
    //   9: iload_2
    //   10: ifne +345 -> 355
    //   13: aload_0
    //   14: invokestatic 171	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isKeyFileExists	(Landroid/content/Context;)Z
    //   17: ifeq +338 -> 355
    //   20: new 245	java/io/BufferedInputStream
    //   23: dup
    //   24: aload_0
    //   25: ldc 8
    //   27: invokevirtual 179	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   30: invokespecial 247	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore 4
    //   35: aload 4
    //   37: astore_0
    //   38: new 181	java/util/Properties
    //   41: dup
    //   42: invokespecial 182	java/util/Properties:<init>	()V
    //   45: astore 6
    //   47: aload 4
    //   49: astore_0
    //   50: aload 6
    //   52: aload 4
    //   54: invokevirtual 186	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   57: aload 4
    //   59: astore_0
    //   60: aload_1
    //   61: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifeq +181 -> 245
    //   67: aload 4
    //   69: astore_0
    //   70: aload 6
    //   72: invokevirtual 251	java/util/Properties:keySet	()Ljava/util/Set;
    //   75: invokeinterface 257 1 0
    //   80: astore_1
    //   81: aload 4
    //   83: astore_0
    //   84: aload_1
    //   85: invokeinterface 262 1 0
    //   90: ifeq +145 -> 235
    //   93: aload 4
    //   95: astore_0
    //   96: aload_1
    //   97: invokeinterface 266 1 0
    //   102: astore 7
    //   104: aload 4
    //   106: astore_0
    //   107: aload 7
    //   109: instanceof 75
    //   112: ifeq -31 -> 81
    //   115: aload 4
    //   117: astore_0
    //   118: aload 7
    //   120: checkcast 75	java/lang/String
    //   123: astore 7
    //   125: aload 4
    //   127: astore_0
    //   128: aload 6
    //   130: aload 7
    //   132: invokevirtual 269	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 8
    //   137: aload 4
    //   139: astore_0
    //   140: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +75 -> 218
    //   146: aload 4
    //   148: astore_0
    //   149: new 83	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   156: astore 9
    //   158: aload 4
    //   160: astore_0
    //   161: aload 9
    //   163: ldc_w 271
    //   166: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 4
    //   172: astore_0
    //   173: aload 9
    //   175: aload 7
    //   177: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: astore_0
    //   184: aload 9
    //   186: ldc_w 273
    //   189: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 4
    //   195: astore_0
    //   196: aload 9
    //   198: aload 8
    //   200: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: astore_0
    //   207: ldc 8
    //   209: iconst_2
    //   210: aload 9
    //   212: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload 4
    //   220: astore_0
    //   221: getstatic 59	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mapKv	Ljava/util/HashMap;
    //   224: aload 7
    //   226: aload 8
    //   228: invokevirtual 112	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: goto -151 -> 81
    //   235: aload 4
    //   237: astore_0
    //   238: iconst_1
    //   239: putstatic 29	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mHasInit	Z
    //   242: goto +25 -> 267
    //   245: aload 4
    //   247: astore_0
    //   248: aload 6
    //   250: aload_1
    //   251: invokevirtual 189	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   254: ifeq +13 -> 267
    //   257: aload 4
    //   259: astore_0
    //   260: aload 6
    //   262: aload_1
    //   263: invokevirtual 269	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore_3
    //   267: aload_3
    //   268: astore_0
    //   269: aload 4
    //   271: invokevirtual 274	java/io/BufferedInputStream:close	()V
    //   274: aload_3
    //   275: areturn
    //   276: astore_1
    //   277: ldc 8
    //   279: iconst_1
    //   280: ldc_w 276
    //   283: aload_1
    //   284: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload_0
    //   288: areturn
    //   289: astore_3
    //   290: aload 4
    //   292: astore_1
    //   293: goto +12 -> 305
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_0
    //   299: goto +32 -> 331
    //   302: astore_3
    //   303: aconst_null
    //   304: astore_1
    //   305: aload_1
    //   306: astore_0
    //   307: ldc 8
    //   309: iconst_1
    //   310: ldc_w 276
    //   313: aload_3
    //   314: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: aload_1
    //   318: ifnull +37 -> 355
    //   321: aload 5
    //   323: astore_0
    //   324: aload_1
    //   325: invokevirtual 274	java/io/BufferedInputStream:close	()V
    //   328: aconst_null
    //   329: areturn
    //   330: astore_1
    //   331: aload_0
    //   332: ifnull +21 -> 353
    //   335: aload_0
    //   336: invokevirtual 274	java/io/BufferedInputStream:close	()V
    //   339: goto +14 -> 353
    //   342: astore_0
    //   343: ldc 8
    //   345: iconst_1
    //   346: ldc_w 276
    //   349: aload_0
    //   350: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_1
    //   354: athrow
    //   355: aconst_null
    //   356: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramContext	Context
    //   0	357	1	paramString	String
    //   3	7	2	bool	boolean
    //   8	267	3	str1	String
    //   289	1	3	localThrowable1	java.lang.Throwable
    //   302	12	3	localThrowable2	java.lang.Throwable
    //   33	258	4	localBufferedInputStream	java.io.BufferedInputStream
    //   5	317	5	localObject1	Object
    //   45	216	6	localProperties	Properties
    //   102	123	7	localObject2	Object
    //   135	92	8	str2	String
    //   156	55	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   269	274	276	java/lang/Throwable
    //   324	328	276	java/lang/Throwable
    //   38	47	289	java/lang/Throwable
    //   50	57	289	java/lang/Throwable
    //   60	67	289	java/lang/Throwable
    //   70	81	289	java/lang/Throwable
    //   84	93	289	java/lang/Throwable
    //   96	104	289	java/lang/Throwable
    //   107	115	289	java/lang/Throwable
    //   118	125	289	java/lang/Throwable
    //   128	137	289	java/lang/Throwable
    //   140	146	289	java/lang/Throwable
    //   149	158	289	java/lang/Throwable
    //   161	170	289	java/lang/Throwable
    //   173	181	289	java/lang/Throwable
    //   184	193	289	java/lang/Throwable
    //   196	204	289	java/lang/Throwable
    //   207	218	289	java/lang/Throwable
    //   221	232	289	java/lang/Throwable
    //   238	242	289	java/lang/Throwable
    //   248	257	289	java/lang/Throwable
    //   260	267	289	java/lang/Throwable
    //   20	35	296	finally
    //   20	35	302	java/lang/Throwable
    //   38	47	330	finally
    //   50	57	330	finally
    //   60	67	330	finally
    //   70	81	330	finally
    //   84	93	330	finally
    //   96	104	330	finally
    //   107	115	330	finally
    //   118	125	330	finally
    //   128	137	330	finally
    //   140	146	330	finally
    //   149	158	330	finally
    //   161	170	330	finally
    //   173	181	330	finally
    //   184	193	330	finally
    //   196	204	330	finally
    //   207	218	330	finally
    //   221	232	330	finally
    //   238	242	330	finally
    //   248	257	330	finally
    //   260	267	330	finally
    //   307	317	330	finally
    //   335	339	342	java/lang/Throwable
  }
  
  public static String readValue(Context paramContext, String paramString1, String arg2, String paramString3, String paramString4)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("read String. ctx is null.defV=");
        paramContext.append(paramString4);
        QLog.d("set_sp", 2, paramContext.toString());
      }
      return paramString4;
    }
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      ??? = new StringBuilder();
      ???.append(paramString3);
      ???.append(paramString1);
      paramString1 = ???.toString();
    }
    else
    {
      paramString1 = paramString3;
    }
    if ((MULTIPROCESS_KEYS.contains(paramString3)) && (getSharedPreferences().contains(paramString1))) {
      return getSharedPreferences().getString(paramString1, paramString4);
    }
    ??? = get(paramString1);
    if (??? != null)
    {
      if (MULTIPROCESS_KEYS.contains(paramString1)) {
        getSharedPreferences().edit().putString(paramString1, ???).commit();
      }
      return ???;
    }
    if (paramString1 != null) {
      synchronized (locker)
      {
        readFromFile(paramContext, null);
        paramContext = get(paramString1);
        if (paramContext != null)
        {
          if (MULTIPROCESS_KEYS.contains(paramString1)) {
            getSharedPreferences().edit().putString(paramString1, paramContext).commit();
          }
          return paramContext;
        }
      }
    }
    return paramString4;
  }
  
  public static boolean readValue(Context paramContext, String arg1, String paramString2, String arg3, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("read boolean. ctx is null.defV=");
        paramContext.append(paramBoolean);
        QLog.d("set_sp", 2, paramContext.toString());
      }
      return paramBoolean;
    }
    Object localObject;
    if ((??? != null) && (???.length() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(???);
      ((StringBuilder)localObject).append(???);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = ???;
    }
    if ((MULTIPROCESS_KEYS.contains(???)) && (getSharedPreferences().contains((String)localObject))) {
      return getSharedPreferences().getBoolean((String)localObject, paramBoolean);
    }
    ??? = get((String)localObject);
    if (??? != null)
    {
      paramBoolean = Boolean.parseBoolean(???);
      if (MULTIPROCESS_KEYS.contains(localObject)) {
        getSharedPreferences().edit().putBoolean((String)localObject, paramBoolean).commit();
      }
      return paramBoolean;
    }
    if (localObject != null) {
      synchronized (locker)
      {
        readFromFile(paramContext, null);
        ??? = get((String)localObject);
        if (??? != null)
        {
          paramBoolean = Boolean.parseBoolean(???);
          if (MULTIPROCESS_KEYS.contains(localObject)) {
            getSharedPreferences().edit().putBoolean((String)localObject, paramBoolean).commit();
          }
          return paramBoolean;
        }
      }
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      ??? = PreferenceManager.getDefaultSharedPreferences(paramContext);
      paramContext = paramString2;
      if (??? != null)
      {
        paramContext = paramString2;
        if (???.length() > 0)
        {
          paramContext = new StringBuilder();
          paramContext.append(paramString2);
          paramContext.append(???);
          paramContext = paramContext.toString();
        }
      }
      if (!???.contains(paramContext)) {
        synchronized (locker)
        {
          tmpMapKv.put(paramContext, Boolean.toString(paramBoolean));
          return paramBoolean;
        }
      }
      paramBoolean = ???.getBoolean(paramContext, paramBoolean);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("read boolean. sp ok, k=");
        ???.append(paramContext);
        ???.append(" v=");
        ???.append(paramBoolean);
        QLog.d("set_sp", 2, ???.toString());
      }
      return firstInit((String)localObject, Boolean.toString(paramBoolean), "sp");
    }
    return paramBoolean;
  }
  
  public static int readValueForInt(Context paramContext, String paramString1, String paramString2, String arg3, int paramInt)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("read int.ctx is null.defV=");
        paramContext.append(paramInt);
        QLog.d("set_sp", 2, paramContext.toString());
      }
      return paramInt;
    }
    Object localObject;
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(???);
      ((StringBuilder)localObject).append(paramString1);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = ???;
    }
    if ((MULTIPROCESS_KEYS.contains(???)) && (getSharedPreferences().contains((String)localObject))) {
      return getSharedPreferences().getInt((String)localObject, paramInt);
    }
    ??? = get((String)localObject);
    int i;
    StringBuilder localStringBuilder;
    if (??? != null) {
      try
      {
        i = Integer.parseInt(???);
        if (MULTIPROCESS_KEYS.contains(localObject)) {
          getSharedPreferences().edit().putInt((String)localObject, i).commit();
        }
        return i;
      }
      catch (Exception ???)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("read int.parse int exception =");
          localStringBuilder.append(String.valueOf(???));
          QLog.d("set_sp", 2, localStringBuilder.toString());
        }
      }
    }
    synchronized (locker)
    {
      readFromFile(paramContext, null);
      ??? = get((String)localObject);
      if (??? != null) {
        try
        {
          i = Integer.parseInt(???);
          if (MULTIPROCESS_KEYS.contains(localObject)) {
            getSharedPreferences().edit().putInt((String)localObject, i).commit();
          }
          return i;
        }
        catch (NumberFormatException ???)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("read int.parse int exception =");
            localStringBuilder.append(String.valueOf(???));
            QLog.d("set_sp", 2, localStringBuilder.toString());
          }
        }
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        ??? = PreferenceManager.getDefaultSharedPreferences(paramContext);
        paramContext = paramString2;
        if (paramString1 != null)
        {
          paramContext = paramString2;
          if (paramString1.length() > 0)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramString2);
            paramContext.append(paramString1);
            paramContext = paramContext.toString();
          }
        }
        paramInt = ???.getInt(paramContext, paramInt);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("read int.read sp ok, k=");
          paramString1.append(paramContext);
          paramString1.append(" v=");
          paramString1.append(paramInt);
          QLog.d("set_sp", 2, paramString1.toString());
        }
        return firstInitForInt((String)localObject, Integer.toString(paramInt), "sp");
      }
      return paramInt;
    }
  }
  
  private static Properties updateProperties()
  {
    Properties localProperties = new Properties();
    Object localObject = mapKv;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localProperties.setProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localProperties;
  }
  
  /* Error */
  public static void writeValue(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 8
    //   12: iconst_2
    //   13: ldc_w 359
    //   16: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: return
    //   20: aload_1
    //   21: ifnull +38 -> 59
    //   24: aload_1
    //   25: invokevirtual 167	java/lang/String:length	()I
    //   28: ifle +31 -> 59
    //   31: new 83	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: aload_3
    //   41: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: aload_1
    //   47: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: goto +5 -> 61
    //   59: aload_3
    //   60: astore_1
    //   61: getstatic 36	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:MULTIPROCESS_KEYS	Ljava/util/HashSet;
    //   64: aload_3
    //   65: invokevirtual 117	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   68: ifeq +26 -> 94
    //   71: invokestatic 121	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   74: invokeinterface 127 1 0
    //   79: aload_1
    //   80: aload 4
    //   82: invokeinterface 294 3 0
    //   87: invokeinterface 136 1 0
    //   92: pop
    //   93: return
    //   94: getstatic 27	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:locker	Ljava/lang/Object;
    //   97: astore_2
    //   98: aload_2
    //   99: monitorenter
    //   100: aload_1
    //   101: aload 4
    //   103: invokestatic 361	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:put	(Ljava/lang/String;Ljava/lang/String;)Z
    //   106: ifne +6 -> 112
    //   109: aload_2
    //   110: monitorexit
    //   111: return
    //   112: invokestatic 363	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:updateProperties	()Ljava/util/Properties;
    //   115: astore_3
    //   116: aload_3
    //   117: aload_0
    //   118: ldc 8
    //   120: iconst_0
    //   121: invokevirtual 367	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   124: aconst_null
    //   125: invokevirtual 371	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   128: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +49 -> 180
    //   134: new 83	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   141: astore_0
    //   142: aload_0
    //   143: ldc_w 373
    //   146: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_0
    //   151: aload_1
    //   152: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_0
    //   157: ldc 92
    //   159: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_0
    //   164: aload 4
    //   166: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: ldc 8
    //   172: iconst_2
    //   173: aload_0
    //   174: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +74 -> 257
    //   186: ldc 8
    //   188: iconst_2
    //   189: ldc_w 375
    //   192: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: goto +62 -> 257
    //   198: astore_0
    //   199: goto +61 -> 260
    //   202: astore_0
    //   203: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +38 -> 244
    //   209: new 83	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   216: astore_1
    //   217: aload_1
    //   218: ldc_w 377
    //   221: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_1
    //   226: aload_0
    //   227: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   230: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: ldc 8
    //   236: iconst_2
    //   237: aload_1
    //   238: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aload_0
    //   245: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   248: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +6 -> 257
    //   254: goto -68 -> 186
    //   257: aload_2
    //   258: monitorexit
    //   259: return
    //   260: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +12 -> 275
    //   266: ldc 8
    //   268: iconst_2
    //   269: ldc_w 375
    //   272: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_0
    //   276: athrow
    //   277: astore_0
    //   278: aload_2
    //   279: monitorexit
    //   280: goto +5 -> 285
    //   283: aload_0
    //   284: athrow
    //   285: goto -2 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramContext	Context
    //   0	288	1	paramString1	String
    //   0	288	2	paramString2	String
    //   0	288	3	paramString3	String
    //   0	288	4	paramString4	String
    // Exception table:
    //   from	to	target	type
    //   116	180	198	finally
    //   203	244	198	finally
    //   244	248	198	finally
    //   116	180	202	java/lang/Throwable
    //   100	111	277	finally
    //   112	116	277	finally
    //   180	186	277	finally
    //   186	195	277	finally
    //   248	254	277	finally
    //   257	259	277	finally
    //   260	275	277	finally
    //   275	277	277	finally
    //   278	280	277	finally
  }
  
  /* Error */
  public static void writeValue(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 8
    //   12: iconst_2
    //   13: ldc_w 380
    //   16: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: return
    //   20: aload_1
    //   21: ifnull +43 -> 64
    //   24: aload_1
    //   25: invokevirtual 167	java/lang/String:length	()I
    //   28: ifle +36 -> 64
    //   31: new 83	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   38: astore 5
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: aload_1
    //   50: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 6
    //   61: goto +6 -> 67
    //   64: aload_3
    //   65: astore 6
    //   67: getstatic 36	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:MULTIPROCESS_KEYS	Ljava/util/HashSet;
    //   70: aload_3
    //   71: invokevirtual 117	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   74: ifeq +27 -> 101
    //   77: invokestatic 121	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   80: invokeinterface 127 1 0
    //   85: aload 6
    //   87: iload 4
    //   89: invokeinterface 133 3 0
    //   94: invokeinterface 136 1 0
    //   99: pop
    //   100: return
    //   101: getstatic 27	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:locker	Ljava/lang/Object;
    //   104: astore 8
    //   106: aload 8
    //   108: monitorenter
    //   109: aload 6
    //   111: iload 4
    //   113: invokestatic 306	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   116: invokestatic 361	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:put	(Ljava/lang/String;Ljava/lang/String;)Z
    //   119: ifne +7 -> 126
    //   122: aload 8
    //   124: monitorexit
    //   125: return
    //   126: invokestatic 363	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:updateProperties	()Ljava/util/Properties;
    //   129: astore 9
    //   131: aconst_null
    //   132: astore 7
    //   134: aconst_null
    //   135: astore 5
    //   137: aload_0
    //   138: ldc 8
    //   140: iconst_0
    //   141: invokevirtual 367	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   144: astore_3
    //   145: aload 9
    //   147: aload_3
    //   148: aconst_null
    //   149: invokevirtual 371	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   152: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +56 -> 211
    //   158: new 83	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   165: astore 5
    //   167: aload 5
    //   169: ldc_w 382
    //   172: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: aload 6
    //   180: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 5
    //   186: ldc 92
    //   188: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: iload 4
    //   196: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: ldc 8
    //   202: iconst_2
    //   203: aload 5
    //   205: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload_2
    //   212: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +128 -> 343
    //   218: aload_2
    //   219: astore 5
    //   221: aload_1
    //   222: ifnull +43 -> 265
    //   225: aload_2
    //   226: astore 5
    //   228: aload_1
    //   229: invokevirtual 167	java/lang/String:length	()I
    //   232: ifle +33 -> 265
    //   235: new 83	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   242: astore 5
    //   244: aload 5
    //   246: aload_2
    //   247: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 5
    //   253: aload_1
    //   254: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 5
    //   260: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 5
    //   265: aload_0
    //   266: invokestatic 217	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   269: astore_0
    //   270: aload_0
    //   271: aload 5
    //   273: invokeinterface 219 2 0
    //   278: ifeq +65 -> 343
    //   281: aload_0
    //   282: invokeinterface 127 1 0
    //   287: astore_0
    //   288: aload_0
    //   289: aload 5
    //   291: invokeinterface 386 2 0
    //   296: pop
    //   297: aload_0
    //   298: invokeinterface 136 1 0
    //   303: pop
    //   304: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +36 -> 343
    //   310: new 83	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   317: astore_0
    //   318: aload_0
    //   319: ldc_w 388
    //   322: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_0
    //   327: aload 5
    //   329: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 8
    //   335: iconst_2
    //   336: aload_0
    //   337: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_3
    //   344: ifnull +349 -> 693
    //   347: aload_3
    //   348: invokevirtual 391	java/io/FileOutputStream:close	()V
    //   351: goto +342 -> 693
    //   354: astore_1
    //   355: aload_1
    //   356: astore_0
    //   357: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +40 -> 400
    //   363: new 83	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   370: astore_0
    //   371: aload_0
    //   372: ldc_w 393
    //   375: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_0
    //   380: aload_1
    //   381: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   384: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: ldc 8
    //   390: iconst_2
    //   391: aload_0
    //   392: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_1
    //   399: astore_0
    //   400: aload_0
    //   401: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   404: goto +289 -> 693
    //   407: astore 6
    //   409: aload_3
    //   410: astore 5
    //   412: aload 6
    //   414: astore_3
    //   415: goto +282 -> 697
    //   418: astore 6
    //   420: goto +12 -> 432
    //   423: astore_3
    //   424: goto +273 -> 697
    //   427: astore 6
    //   429: aload 7
    //   431: astore_3
    //   432: aload_3
    //   433: astore 5
    //   435: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +55 -> 493
    //   441: aload_3
    //   442: astore 5
    //   444: new 83	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   451: astore 7
    //   453: aload_3
    //   454: astore 5
    //   456: aload 7
    //   458: ldc_w 396
    //   461: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload_3
    //   466: astore 5
    //   468: aload 7
    //   470: aload 6
    //   472: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   475: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_3
    //   480: astore 5
    //   482: ldc 8
    //   484: iconst_2
    //   485: aload 7
    //   487: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: aload_3
    //   494: astore 5
    //   496: aload 6
    //   498: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   501: aload_2
    //   502: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   505: ifne +128 -> 633
    //   508: aload_2
    //   509: astore 5
    //   511: aload_1
    //   512: ifnull +43 -> 555
    //   515: aload_2
    //   516: astore 5
    //   518: aload_1
    //   519: invokevirtual 167	java/lang/String:length	()I
    //   522: ifle +33 -> 555
    //   525: new 83	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   532: astore 5
    //   534: aload 5
    //   536: aload_2
    //   537: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 5
    //   543: aload_1
    //   544: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 5
    //   550: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: astore 5
    //   555: aload_0
    //   556: invokestatic 217	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   559: astore_0
    //   560: aload_0
    //   561: aload 5
    //   563: invokeinterface 219 2 0
    //   568: ifeq +65 -> 633
    //   571: aload_0
    //   572: invokeinterface 127 1 0
    //   577: astore_0
    //   578: aload_0
    //   579: aload 5
    //   581: invokeinterface 386 2 0
    //   586: pop
    //   587: aload_0
    //   588: invokeinterface 136 1 0
    //   593: pop
    //   594: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +36 -> 633
    //   600: new 83	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   607: astore_0
    //   608: aload_0
    //   609: ldc_w 388
    //   612: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload_0
    //   617: aload 5
    //   619: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: ldc 8
    //   625: iconst_2
    //   626: aload_0
    //   627: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload_3
    //   634: ifnull +59 -> 693
    //   637: aload_3
    //   638: invokevirtual 391	java/io/FileOutputStream:close	()V
    //   641: goto +52 -> 693
    //   644: astore_1
    //   645: aload_1
    //   646: astore_0
    //   647: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq -250 -> 400
    //   653: new 83	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   660: astore_0
    //   661: aload_0
    //   662: ldc_w 393
    //   665: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload_0
    //   670: aload_1
    //   671: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   674: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: ldc 8
    //   680: iconst_2
    //   681: aload_0
    //   682: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   688: aload_1
    //   689: astore_0
    //   690: goto -290 -> 400
    //   693: aload 8
    //   695: monitorexit
    //   696: return
    //   697: aload_2
    //   698: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   701: ifne +128 -> 829
    //   704: aload_2
    //   705: astore 6
    //   707: aload_1
    //   708: ifnull +43 -> 751
    //   711: aload_2
    //   712: astore 6
    //   714: aload_1
    //   715: invokevirtual 167	java/lang/String:length	()I
    //   718: ifle +33 -> 751
    //   721: new 83	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   728: astore 6
    //   730: aload 6
    //   732: aload_2
    //   733: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 6
    //   739: aload_1
    //   740: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 6
    //   746: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: astore 6
    //   751: aload_0
    //   752: invokestatic 217	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   755: astore_0
    //   756: aload_0
    //   757: aload 6
    //   759: invokeinterface 219 2 0
    //   764: ifeq +65 -> 829
    //   767: aload_0
    //   768: invokeinterface 127 1 0
    //   773: astore_0
    //   774: aload_0
    //   775: aload 6
    //   777: invokeinterface 386 2 0
    //   782: pop
    //   783: aload_0
    //   784: invokeinterface 136 1 0
    //   789: pop
    //   790: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   793: ifeq +36 -> 829
    //   796: new 83	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   803: astore_0
    //   804: aload_0
    //   805: ldc_w 388
    //   808: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload_0
    //   813: aload 6
    //   815: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: ldc 8
    //   821: iconst_2
    //   822: aload_0
    //   823: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: aload 5
    //   831: ifnull +57 -> 888
    //   834: aload 5
    //   836: invokevirtual 391	java/io/FileOutputStream:close	()V
    //   839: goto +49 -> 888
    //   842: astore_0
    //   843: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +38 -> 884
    //   849: new 83	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   856: astore_1
    //   857: aload_1
    //   858: ldc_w 393
    //   861: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload_1
    //   866: aload_0
    //   867: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   870: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: ldc 8
    //   876: iconst_2
    //   877: aload_1
    //   878: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   884: aload_0
    //   885: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   888: aload_3
    //   889: athrow
    //   890: astore_0
    //   891: aload 8
    //   893: monitorexit
    //   894: goto +5 -> 899
    //   897: aload_0
    //   898: athrow
    //   899: goto -2 -> 897
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	902	0	paramContext	Context
    //   0	902	1	paramString1	String
    //   0	902	2	paramString2	String
    //   0	902	3	paramString3	String
    //   0	902	4	paramBoolean	boolean
    //   38	797	5	localObject1	Object
    //   59	120	6	str	String
    //   407	6	6	localObject2	Object
    //   418	1	6	localThrowable1	java.lang.Throwable
    //   427	70	6	localThrowable2	java.lang.Throwable
    //   705	109	6	localObject3	Object
    //   132	354	7	localStringBuilder	StringBuilder
    //   104	788	8	localObject4	Object
    //   129	17	9	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   211	218	354	java/lang/Exception
    //   228	265	354	java/lang/Exception
    //   265	343	354	java/lang/Exception
    //   347	351	354	java/lang/Exception
    //   145	211	407	finally
    //   145	211	418	java/lang/Throwable
    //   137	145	423	finally
    //   435	441	423	finally
    //   444	453	423	finally
    //   456	465	423	finally
    //   468	479	423	finally
    //   482	493	423	finally
    //   496	501	423	finally
    //   137	145	427	java/lang/Throwable
    //   501	508	644	java/lang/Exception
    //   518	555	644	java/lang/Exception
    //   555	633	644	java/lang/Exception
    //   637	641	644	java/lang/Exception
    //   697	704	842	java/lang/Exception
    //   714	751	842	java/lang/Exception
    //   751	829	842	java/lang/Exception
    //   834	839	842	java/lang/Exception
    //   109	125	890	finally
    //   126	131	890	finally
    //   211	218	890	finally
    //   228	265	890	finally
    //   265	343	890	finally
    //   347	351	890	finally
    //   357	398	890	finally
    //   400	404	890	finally
    //   501	508	890	finally
    //   518	555	890	finally
    //   555	633	890	finally
    //   637	641	890	finally
    //   647	688	890	finally
    //   693	696	890	finally
    //   697	704	890	finally
    //   714	751	890	finally
    //   751	829	890	finally
    //   834	839	890	finally
    //   843	884	890	finally
    //   884	888	890	finally
    //   888	890	890	finally
    //   891	894	890	finally
  }
  
  /* Error */
  public static void writeValueForInt(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 8
    //   12: iconst_2
    //   13: ldc_w 400
    //   16: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: return
    //   20: aload_1
    //   21: ifnull +43 -> 64
    //   24: aload_1
    //   25: invokevirtual 167	java/lang/String:length	()I
    //   28: ifle +36 -> 64
    //   31: new 83	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   38: astore 5
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 5
    //   49: aload_1
    //   50: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 6
    //   61: goto +6 -> 67
    //   64: aload_3
    //   65: astore 6
    //   67: getstatic 36	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:MULTIPROCESS_KEYS	Ljava/util/HashSet;
    //   70: aload_3
    //   71: invokevirtual 117	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   74: ifeq +27 -> 101
    //   77: invokestatic 121	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   80: invokeinterface 127 1 0
    //   85: aload 6
    //   87: iload 4
    //   89: invokeinterface 329 3 0
    //   94: invokeinterface 136 1 0
    //   99: pop
    //   100: return
    //   101: getstatic 27	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:locker	Ljava/lang/Object;
    //   104: astore 8
    //   106: aload 8
    //   108: monitorenter
    //   109: aload 6
    //   111: iload 4
    //   113: invokestatic 336	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   116: invokestatic 361	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:put	(Ljava/lang/String;Ljava/lang/String;)Z
    //   119: ifne +7 -> 126
    //   122: aload 8
    //   124: monitorexit
    //   125: return
    //   126: invokestatic 363	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:updateProperties	()Ljava/util/Properties;
    //   129: astore 9
    //   131: aconst_null
    //   132: astore 7
    //   134: aconst_null
    //   135: astore 5
    //   137: aload_0
    //   138: ldc 8
    //   140: iconst_0
    //   141: invokevirtual 367	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   144: astore_3
    //   145: aload 9
    //   147: aload_3
    //   148: aconst_null
    //   149: invokevirtual 371	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   152: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +56 -> 211
    //   158: new 83	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   165: astore 5
    //   167: aload 5
    //   169: ldc_w 402
    //   172: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: aload 6
    //   180: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 5
    //   186: ldc 92
    //   188: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: iload 4
    //   196: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: ldc 8
    //   202: iconst_2
    //   203: aload 5
    //   205: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload_2
    //   212: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +128 -> 343
    //   218: aload_2
    //   219: astore 5
    //   221: aload_1
    //   222: ifnull +43 -> 265
    //   225: aload_2
    //   226: astore 5
    //   228: aload_1
    //   229: invokevirtual 167	java/lang/String:length	()I
    //   232: ifle +33 -> 265
    //   235: new 83	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   242: astore 5
    //   244: aload 5
    //   246: aload_2
    //   247: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 5
    //   253: aload_1
    //   254: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 5
    //   260: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 5
    //   265: aload_0
    //   266: invokestatic 217	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   269: astore_0
    //   270: aload_0
    //   271: aload 5
    //   273: invokeinterface 219 2 0
    //   278: ifeq +65 -> 343
    //   281: aload_0
    //   282: invokeinterface 127 1 0
    //   287: astore_0
    //   288: aload_0
    //   289: aload 5
    //   291: invokeinterface 386 2 0
    //   296: pop
    //   297: aload_0
    //   298: invokeinterface 136 1 0
    //   303: pop
    //   304: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +36 -> 343
    //   310: new 83	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   317: astore_0
    //   318: aload_0
    //   319: ldc_w 388
    //   322: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_0
    //   327: aload 5
    //   329: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 8
    //   335: iconst_2
    //   336: aload_0
    //   337: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload_3
    //   344: ifnull +349 -> 693
    //   347: aload_3
    //   348: invokevirtual 391	java/io/FileOutputStream:close	()V
    //   351: goto +342 -> 693
    //   354: astore_1
    //   355: aload_1
    //   356: astore_0
    //   357: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +40 -> 400
    //   363: new 83	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   370: astore_0
    //   371: aload_0
    //   372: ldc_w 404
    //   375: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_0
    //   380: aload_1
    //   381: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   384: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: ldc 8
    //   390: iconst_2
    //   391: aload_0
    //   392: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_1
    //   399: astore_0
    //   400: aload_0
    //   401: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   404: goto +289 -> 693
    //   407: astore 6
    //   409: aload_3
    //   410: astore 5
    //   412: aload 6
    //   414: astore_3
    //   415: goto +282 -> 697
    //   418: astore 6
    //   420: goto +12 -> 432
    //   423: astore_3
    //   424: goto +273 -> 697
    //   427: astore 6
    //   429: aload 7
    //   431: astore_3
    //   432: aload_3
    //   433: astore 5
    //   435: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +55 -> 493
    //   441: aload_3
    //   442: astore 5
    //   444: new 83	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   451: astore 7
    //   453: aload_3
    //   454: astore 5
    //   456: aload 7
    //   458: ldc_w 406
    //   461: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload_3
    //   466: astore 5
    //   468: aload 7
    //   470: aload 6
    //   472: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   475: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_3
    //   480: astore 5
    //   482: ldc 8
    //   484: iconst_2
    //   485: aload 7
    //   487: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: aload_3
    //   494: astore 5
    //   496: aload 6
    //   498: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   501: aload_2
    //   502: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   505: ifne +128 -> 633
    //   508: aload_2
    //   509: astore 5
    //   511: aload_1
    //   512: ifnull +43 -> 555
    //   515: aload_2
    //   516: astore 5
    //   518: aload_1
    //   519: invokevirtual 167	java/lang/String:length	()I
    //   522: ifle +33 -> 555
    //   525: new 83	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   532: astore 5
    //   534: aload 5
    //   536: aload_2
    //   537: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 5
    //   543: aload_1
    //   544: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 5
    //   550: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: astore 5
    //   555: aload_0
    //   556: invokestatic 217	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   559: astore_0
    //   560: aload_0
    //   561: aload 5
    //   563: invokeinterface 219 2 0
    //   568: ifeq +65 -> 633
    //   571: aload_0
    //   572: invokeinterface 127 1 0
    //   577: astore_0
    //   578: aload_0
    //   579: aload 5
    //   581: invokeinterface 386 2 0
    //   586: pop
    //   587: aload_0
    //   588: invokeinterface 136 1 0
    //   593: pop
    //   594: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +36 -> 633
    //   600: new 83	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   607: astore_0
    //   608: aload_0
    //   609: ldc_w 388
    //   612: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload_0
    //   617: aload 5
    //   619: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: ldc 8
    //   625: iconst_2
    //   626: aload_0
    //   627: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload_3
    //   634: ifnull +59 -> 693
    //   637: aload_3
    //   638: invokevirtual 391	java/io/FileOutputStream:close	()V
    //   641: goto +52 -> 693
    //   644: astore_1
    //   645: aload_1
    //   646: astore_0
    //   647: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq -250 -> 400
    //   653: new 83	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   660: astore_0
    //   661: aload_0
    //   662: ldc_w 404
    //   665: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload_0
    //   670: aload_1
    //   671: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   674: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: ldc 8
    //   680: iconst_2
    //   681: aload_0
    //   682: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   688: aload_1
    //   689: astore_0
    //   690: goto -290 -> 400
    //   693: aload 8
    //   695: monitorexit
    //   696: return
    //   697: aload_2
    //   698: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   701: ifne +128 -> 829
    //   704: aload_2
    //   705: astore 6
    //   707: aload_1
    //   708: ifnull +43 -> 751
    //   711: aload_2
    //   712: astore 6
    //   714: aload_1
    //   715: invokevirtual 167	java/lang/String:length	()I
    //   718: ifle +33 -> 751
    //   721: new 83	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   728: astore 6
    //   730: aload 6
    //   732: aload_2
    //   733: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 6
    //   739: aload_1
    //   740: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 6
    //   746: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: astore 6
    //   751: aload_0
    //   752: invokestatic 217	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   755: astore_0
    //   756: aload_0
    //   757: aload 6
    //   759: invokeinterface 219 2 0
    //   764: ifeq +65 -> 829
    //   767: aload_0
    //   768: invokeinterface 127 1 0
    //   773: astore_0
    //   774: aload_0
    //   775: aload 6
    //   777: invokeinterface 386 2 0
    //   782: pop
    //   783: aload_0
    //   784: invokeinterface 136 1 0
    //   789: pop
    //   790: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   793: ifeq +36 -> 829
    //   796: new 83	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   803: astore_0
    //   804: aload_0
    //   805: ldc_w 388
    //   808: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload_0
    //   813: aload 6
    //   815: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: ldc 8
    //   821: iconst_2
    //   822: aload_0
    //   823: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: aload 5
    //   831: ifnull +57 -> 888
    //   834: aload 5
    //   836: invokevirtual 391	java/io/FileOutputStream:close	()V
    //   839: goto +49 -> 888
    //   842: astore_0
    //   843: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +38 -> 884
    //   849: new 83	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   856: astore_1
    //   857: aload_1
    //   858: ldc_w 404
    //   861: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload_1
    //   866: aload_0
    //   867: invokestatic 200	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   870: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: ldc 8
    //   876: iconst_2
    //   877: aload_1
    //   878: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   884: aload_0
    //   885: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   888: aload_3
    //   889: athrow
    //   890: astore_0
    //   891: aload 8
    //   893: monitorexit
    //   894: goto +5 -> 899
    //   897: aload_0
    //   898: athrow
    //   899: goto -2 -> 897
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	902	0	paramContext	Context
    //   0	902	1	paramString1	String
    //   0	902	2	paramString2	String
    //   0	902	3	paramString3	String
    //   0	902	4	paramInt	int
    //   38	797	5	localObject1	Object
    //   59	120	6	str	String
    //   407	6	6	localObject2	Object
    //   418	1	6	localThrowable1	java.lang.Throwable
    //   427	70	6	localThrowable2	java.lang.Throwable
    //   705	109	6	localObject3	Object
    //   132	354	7	localStringBuilder	StringBuilder
    //   104	788	8	localObject4	Object
    //   129	17	9	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   211	218	354	java/lang/Exception
    //   228	265	354	java/lang/Exception
    //   265	343	354	java/lang/Exception
    //   347	351	354	java/lang/Exception
    //   145	211	407	finally
    //   145	211	418	java/lang/Throwable
    //   137	145	423	finally
    //   435	441	423	finally
    //   444	453	423	finally
    //   456	465	423	finally
    //   468	479	423	finally
    //   482	493	423	finally
    //   496	501	423	finally
    //   137	145	427	java/lang/Throwable
    //   501	508	644	java/lang/Exception
    //   518	555	644	java/lang/Exception
    //   555	633	644	java/lang/Exception
    //   637	641	644	java/lang/Exception
    //   697	704	842	java/lang/Exception
    //   714	751	842	java/lang/Exception
    //   751	829	842	java/lang/Exception
    //   834	839	842	java/lang/Exception
    //   109	125	890	finally
    //   126	131	890	finally
    //   211	218	890	finally
    //   228	265	890	finally
    //   265	343	890	finally
    //   347	351	890	finally
    //   357	398	890	finally
    //   400	404	890	finally
    //   501	508	890	finally
    //   518	555	890	finally
    //   555	633	890	finally
    //   637	641	890	finally
    //   647	688	890	finally
    //   693	696	890	finally
    //   697	704	890	finally
    //   714	751	890	finally
    //   751	829	890	finally
    //   834	839	890	finally
    //   843	884	890	finally
    //   884	888	890	finally
    //   888	890	890	finally
    //   891	894	890	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.SettingCloneUtil
 * JD-Core Version:    0.7.0.1
 */