package com.tencent.mobileqq.statistics;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.ProcessUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.GifSoLoader;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import mqq.app.MobileQQ;
import mqq.os.MqqMessage;
import mqq.os.MqqMessageQueue;
import org.json.JSONObject;

public class BusinessCrashHandleListener
  implements CrashHandleListener
{
  private StatisticCollector a;
  
  public BusinessCrashHandleListener(StatisticCollector paramStatisticCollector)
  {
    this.a = paramStatisticCollector;
  }
  
  @TargetApi(21)
  private static String a()
  {
    int i1 = 0;
    int m = 0;
    int i2 = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = i1;
    int k = i2;
    for (;;)
    {
      try
      {
        Object localObject1 = new File("/proc/self/fd");
        j = i1;
        int n = m;
        k = i2;
        if (((File)localObject1).exists())
        {
          j = i1;
          n = m;
          k = i2;
          if (((File)localObject1).isDirectory())
          {
            j = i1;
            k = i2;
            if (Build.VERSION.SDK_INT < 21) {
              break label336;
            }
            m = 1;
            j = i1;
            k = i2;
            File[] arrayOfFile = ((File)localObject1).listFiles();
            j = i1;
            k = i2;
            i2 = arrayOfFile.length;
            i1 = 0;
            n = i;
            if (i1 < i2)
            {
              localObject1 = arrayOfFile[i1];
              if (m != 0) {
                k = i;
              }
              try
              {
                localObject1 = Os.readlink(((File)localObject1).getPath());
                k = i;
                localStringBuilder.append((String)localObject1 + "\n");
                i += 1;
              }
              catch (Throwable localThrowable1)
              {
                j = i;
                k = i;
                QLog.e("BusinessCrashHandleListener", 1, "readlink failed", localThrowable1);
              }
              k = i;
              localObject1 = ((File)localObject1).getCanonicalPath();
              continue;
            }
          }
        }
        localStringBuilder.append("Total FD Count = " + k);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2 = localThrowable2;
        try
        {
          QLog.e("BusinessCrashHandleListener", 1, "get fd info failed !!!", localThrowable2);
          localStringBuilder.append("Total FD Count = " + j);
          return localStringBuilder.toString();
        }
        finally
        {
          for (;;)
          {
            k = j;
          }
        }
        localStringBuilder.append("Total FD Count = " + n);
        return localStringBuilder.toString();
      }
      finally {}
      return localStringBuilder.toString();
      i1 += 1;
      continue;
      label336:
      m = 0;
    }
  }
  
  private String a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (paramMessage.getTarget() != null) {
      if (paramMessage.getCallback() != null)
      {
        localStringBuilder.append(" callback=");
        localStringBuilder.append(paramMessage.getCallback().getClass().getName());
        if (paramMessage.arg1 != 0)
        {
          localStringBuilder.append(" arg1=");
          localStringBuilder.append(paramMessage.arg1);
        }
        if (paramMessage.arg2 != 0)
        {
          localStringBuilder.append(" arg2=");
          localStringBuilder.append(paramMessage.arg2);
        }
        if (paramMessage.obj != null)
        {
          localStringBuilder.append(" obj=");
          localStringBuilder.append(paramMessage.obj);
        }
        localStringBuilder.append(" target=");
        localStringBuilder.append(paramMessage.getTarget().getClass().getName());
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(" what=");
      localStringBuilder.append(paramMessage.what);
      break;
      localStringBuilder.append(" barrier=");
      localStringBuilder.append(paramMessage.arg1);
    }
  }
  
  private HashMap<String, Integer> a(HashMap<String, Integer> paramHashMap)
  {
    Object localObject = new LinkedList(paramHashMap.entrySet());
    Collections.sort((List)localObject, new BusinessCrashHandleListener.1(this));
    paramHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramHashMap;
  }
  
  private void a(Context paramContext, String paramString)
  {
    QLog.d("BusinessCrashHandleListener", 1, "stopServiceOnCrash");
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      QLog.d("BusinessCrashHandleListener", 1, "stopServiceOnCrash,context == null");
    }
    for (;;)
    {
      return;
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(200);
      if ((localObject == null) || (((List)localObject).size() <= 0))
      {
        QLog.d("BusinessCrashHandleListener", 1, "stopServiceOnCrash,list == null");
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
        if (paramString.equals(localRunningServiceInfo.process))
        {
          Intent localIntent = new Intent();
          localIntent.setComponent(localRunningServiceInfo.service);
          QLog.d("BusinessCrashHandleListener", 1, "Stop service: " + localRunningServiceInfo.service + ", clientCount: " + localRunningServiceInfo.clientCount + ", clientPackage: " + localRunningServiceInfo.clientPackage + ", crashCount: " + localRunningServiceInfo.crashCount);
          paramContext.stopService(localIntent);
        }
      }
    }
  }
  
  private void a(Context paramContext, StringBuilder paramStringBuilder)
  {
    Object localObject1 = ReflecterHelper.a("android.app.ActivityThread", "currentActivityThread", new Object[0], new Class[0]);
    paramContext = paramContext.getPackageName();
    paramContext = (Map)ReflecterHelper.a("android.app.LoadedApk", ((WeakReference)((Map)ReflecterHelper.a("android.app.ActivityThread", localObject1, "mPackages")).get(paramContext)).get(), "mReceivers");
    localObject1 = paramContext.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Iterator localIterator = ((Map)paramContext.get(localObject2)).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        paramStringBuilder.append("\n");
        localObject3 = (BroadcastReceiver)localObject3;
        paramStringBuilder.append(localObject3.getClass().getName() + ":" + localObject3);
        paramStringBuilder.append(" in ");
        paramStringBuilder.append(localObject2.getClass().getName() + ":" + localObject2);
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = new HashMap();
      localObject1 = MqqMessageQueue.getSubMainThreadQueue();
      Object localObject4 = Class.forName("mqq.os.MqqMessageQueue").getDeclaredField("mMessages");
      ((Field)localObject4).setAccessible(true);
      Object localObject3 = Class.forName("mqq.os.MqqMessage");
      Field localField = ((Class)localObject3).getDeclaredField("wrappedMsg");
      localField.setAccessible(true);
      localObject3 = ((Class)localObject3).getDeclaredField("next");
      ((Field)localObject3).setAccessible(true);
      localObject1 = (MqqMessage)((Field)localObject4).get(localObject1);
      i = 0;
      if ((localObject1 != null) && (i <= 100000))
      {
        localObject4 = a((Message)localField.get(localObject1));
        if (((HashMap)localObject2).containsKey(localObject4)) {
          ((HashMap)localObject2).put(localObject4, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject4)).intValue() + 1));
        }
        for (;;)
        {
          localObject1 = (MqqMessage)((Field)localObject3).get(localObject1);
          i += 1;
          break;
          ((HashMap)localObject2).put(localObject4, Integer.valueOf(1));
        }
        return;
      }
    }
    catch (Throwable paramStringBuilder)
    {
      QLog.e("BusinessCrashHandleListener", 1, "Fetch MqqMessageQueue's Messages faild", paramStringBuilder);
    }
    label365:
    for (;;)
    {
      localObject1 = a((HashMap)localObject2);
      paramStringBuilder.append("MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("BusinessCrashHandleListener", 1, "MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:");
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label365;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("BusinessCrashHandleListener", 1, (String)localObject2);
        i += 1;
      }
    }
  }
  
  private boolean a()
  {
    if (Build.VERSION.SDK_INT == 27) {}
    for (int i = 1; (i != 0) && (Build.MODEL.contains("OPPO R11")); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((1 != MobileQQ.sProcessId) && (7 != MobileQQ.sProcessId)) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    } while ((!((SharedPreferences)localObject1).getBoolean("key_not_exit_enable", false)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
    for (;;)
    {
      int i;
      int m;
      try
      {
        Object localObject2 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_type", null);
        localObject1 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_stack", null);
        if ((localObject2 == null) || (TextUtils.isEmpty(paramString1))) {
          break label309;
        }
        localObject2 = ((String)localObject2).split("\\|");
        k = localObject2.length;
        j = 0;
        i = 0;
        if (j >= k) {
          break label324;
        }
        Object localObject3 = localObject2[j];
        if (!paramString1.equals(localObject3)) {
          break label315;
        }
        QLog.e("BusinessCrashHandleListener", 1, new Object[] { "crashType = ", paramString1, ",crash = ", localObject3 });
        i = 1;
      }
      catch (Throwable paramString1)
      {
        int k;
        int n;
        QLog.e("BusinessCrashHandleListener", 1, "isNotExitSafeMode has some error", paramString1);
        return false;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString1 = ((String)localObject1).split("\\|");
        n = paramString1.length;
        k = 0;
        i = 0;
        m = i;
        if (k < n)
        {
          localObject1 = paramString1[k];
          if (paramString2.contains((CharSequence)localObject1))
          {
            QLog.e("BusinessCrashHandleListener", 1, new Object[] { "crashStack = ", paramString2, ",crash = ", localObject1 });
            i = 1;
          }
          k += 1;
          continue;
        }
      }
      else
      {
        m = 0;
      }
      if ((m != 0) && (j != 0)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      label309:
      int j = 0;
      continue;
      label315:
      j += 1;
      continue;
      label324:
      j = i;
    }
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    int j = 0;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new HashMap();
        localObject1 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
        ((Field)localObject1).setAccessible(true);
        Object localObject3 = Class.forName("android.os.Looper").getMethod("getQueue", new Class[0]);
        ((Method)localObject3).setAccessible(true);
        localObject1 = (Message)((Field)localObject1).get((MessageQueue)((Method)localObject3).invoke(Looper.getMainLooper(), new Object[0]));
        if (localObject1 == null) {
          break label463;
        }
        localObject3 = a((Message)localObject1);
        String str;
        if (((HashMap)localObject2).containsKey(localObject3))
        {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject3)).intValue() + 1));
          i = 1;
          localObject3 = Class.forName("android.os.Message").getDeclaredField("next");
          ((Field)localObject3).setAccessible(true);
          localObject1 = (Message)((Field)localObject3).get(localObject1);
          if ((localObject1 == null) || (i > 100000)) {
            break label282;
          }
          str = a((Message)localObject1);
          if (((HashMap)localObject2).containsKey(str))
          {
            ((HashMap)localObject2).put(str, Integer.valueOf(((Integer)((HashMap)localObject2).get(str)).intValue() + 1));
            localObject1 = (Message)((Field)localObject3).get(localObject1);
            i += 1;
            continue;
          }
        }
        else
        {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(1));
          i = 1;
          continue;
        }
        ((HashMap)localObject2).put(str, Integer.valueOf(1));
        continue;
        localObject1 = a((HashMap)localObject2);
      }
      catch (Throwable paramStringBuilder)
      {
        QLog.e("BusinessCrashHandleListener", 1, "Fetch Main Thread's Messages faild", paramStringBuilder);
        return;
      }
      label282:
      paramStringBuilder.append("Main Thread has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("BusinessCrashHandleListener", 1, "Main Thread has " + i + " Messages, and it's Top 50 Messages:");
      Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
      int i = j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label461;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("BusinessCrashHandleListener", 1, (String)localObject2);
        i += 1;
      }
      label461:
      continue;
      label463:
      i = 0;
    }
  }
  
  private void c()
  {
    CacheHelper.fileCache().clear();
  }
  
  /* Error */
  private void c(StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 24	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 494
    //   10: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 499	android/os/Process:myPid	()I
    //   16: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 501
    //   22: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 11
    //   30: aload_1
    //   31: ldc_w 503
    //   34: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 505
    //   40: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 9
    //   50: aconst_null
    //   51: astore 5
    //   53: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   56: lstore_3
    //   57: aload 8
    //   59: astore 7
    //   61: aload 9
    //   63: astore 6
    //   65: new 27	java/io/File
    //   68: dup
    //   69: aload 11
    //   71: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 515	java/io/File:list	()[Ljava/lang/String;
    //   77: astore 10
    //   79: aload 8
    //   81: astore 7
    //   83: aload 9
    //   85: astore 6
    //   87: new 146	java/util/HashMap
    //   90: dup
    //   91: invokespecial 321	java/util/HashMap:<init>	()V
    //   94: astore 8
    //   96: iconst_0
    //   97: istore_2
    //   98: aload 5
    //   100: astore 7
    //   102: aload 5
    //   104: astore 6
    //   106: iload_2
    //   107: aload 10
    //   109: arraylength
    //   110: if_icmpge +119 -> 229
    //   113: aload 5
    //   115: astore 7
    //   117: aload 5
    //   119: astore 6
    //   121: new 27	java/io/File
    //   124: dup
    //   125: new 24	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   132: aload 11
    //   134: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 517
    //   140: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 10
    //   145: iload_2
    //   146: aaload
    //   147: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 519
    //   153: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 9
    //   164: aload 5
    //   166: astore 7
    //   168: aload 5
    //   170: astore 6
    //   172: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   175: lload_3
    //   176: lsub
    //   177: ldc2_w 520
    //   180: lcmp
    //   181: ifle +186 -> 367
    //   184: aload 5
    //   186: astore 7
    //   188: aload 5
    //   190: astore 6
    //   192: invokestatic 524	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +34 -> 229
    //   198: aload 5
    //   200: astore 7
    //   202: aload 5
    //   204: astore 6
    //   206: ldc 72
    //   208: iconst_2
    //   209: iconst_2
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: ldc_w 526
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: aload_1
    //   222: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 528	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   229: aload 5
    //   231: astore 7
    //   233: aload 5
    //   235: astore 6
    //   237: aload 8
    //   239: invokevirtual 150	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   242: invokeinterface 313 1 0
    //   247: astore 8
    //   249: aload 5
    //   251: astore 7
    //   253: aload 5
    //   255: astore 6
    //   257: aload 8
    //   259: invokeinterface 178 1 0
    //   264: ifeq +272 -> 536
    //   267: aload 5
    //   269: astore 7
    //   271: aload 5
    //   273: astore 6
    //   275: aload 8
    //   277: invokeinterface 182 1 0
    //   282: checkcast 184	java/util/Map$Entry
    //   285: astore 9
    //   287: aload 5
    //   289: astore 7
    //   291: aload 5
    //   293: astore 6
    //   295: aload_1
    //   296: aload 9
    //   298: invokeinterface 187 1 0
    //   303: checkcast 239	java/lang/String
    //   306: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 530
    //   312: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 9
    //   317: invokeinterface 190 1 0
    //   322: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: ldc_w 532
    //   328: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc_w 534
    //   334: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: goto -89 -> 249
    //   341: astore_1
    //   342: aload 7
    //   344: astore 6
    //   346: ldc 72
    //   348: iconst_2
    //   349: ldc_w 536
    //   352: aload_1
    //   353: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   356: aload 7
    //   358: ifnull +8 -> 366
    //   361: aload 7
    //   363: invokevirtual 541	java/io/BufferedReader:close	()V
    //   366: return
    //   367: aload 5
    //   369: astore 7
    //   371: aload 5
    //   373: astore 6
    //   375: aload 9
    //   377: invokevirtual 36	java/io/File:exists	()Z
    //   380: ifeq +359 -> 739
    //   383: aload 5
    //   385: astore 7
    //   387: aload 5
    //   389: astore 6
    //   391: new 538	java/io/BufferedReader
    //   394: dup
    //   395: new 543	java/io/FileReader
    //   398: dup
    //   399: aload 9
    //   401: invokespecial 546	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   404: bipush 64
    //   406: invokespecial 549	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   409: astore 5
    //   411: aload 5
    //   413: invokevirtual 552	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   416: astore 6
    //   418: aload 6
    //   420: ifnull +322 -> 742
    //   423: aload 6
    //   425: ldc_w 554
    //   428: invokevirtual 558	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   431: ifeq -20 -> 411
    //   434: aload 6
    //   436: ldc_w 317
    //   439: invokevirtual 433	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   442: iconst_1
    //   443: aaload
    //   444: invokevirtual 561	java/lang/String:trim	()Ljava/lang/String;
    //   447: astore 6
    //   449: aload 8
    //   451: aload 6
    //   453: invokevirtual 359	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   456: ifeq +49 -> 505
    //   459: aload 8
    //   461: aload 6
    //   463: aload 8
    //   465: aload 6
    //   467: invokevirtual 360	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   470: checkcast 362	java/lang/Integer
    //   473: invokevirtual 365	java/lang/Integer:intValue	()I
    //   476: iconst_1
    //   477: iadd
    //   478: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   481: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload 5
    //   487: ifnull +46 -> 533
    //   490: aload 5
    //   492: invokevirtual 541	java/io/BufferedReader:close	()V
    //   495: aconst_null
    //   496: astore 5
    //   498: iload_2
    //   499: iconst_1
    //   500: iadd
    //   501: istore_2
    //   502: goto -404 -> 98
    //   505: aload 8
    //   507: aload 6
    //   509: iconst_1
    //   510: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: goto -32 -> 485
    //   520: astore 6
    //   522: ldc 72
    //   524: iconst_2
    //   525: ldc_w 536
    //   528: aload 6
    //   530: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: goto -35 -> 498
    //   536: aload 5
    //   538: astore 7
    //   540: aload 5
    //   542: astore 6
    //   544: aload_1
    //   545: ldc_w 563
    //   548: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 10
    //   553: arraylength
    //   554: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 5
    //   560: astore 7
    //   562: aload 5
    //   564: astore 6
    //   566: invokestatic 568	com/tencent/mobileqq/app/ThreadLog:needRecordJob	()Z
    //   569: ifeq +36 -> 605
    //   572: aload 5
    //   574: astore 7
    //   576: aload 5
    //   578: astore 6
    //   580: aload 10
    //   582: arraylength
    //   583: sipush 200
    //   586: if_icmple +19 -> 605
    //   589: aload 5
    //   591: astore 7
    //   593: aload 5
    //   595: astore 6
    //   597: aload_1
    //   598: invokestatic 573	com/tencent/mobileqq/app/ThreadManager:reportCurrentState	()Ljava/lang/String;
    //   601: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 5
    //   607: astore 7
    //   609: aload 5
    //   611: astore 6
    //   613: invokestatic 524	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +51 -> 667
    //   619: aload 5
    //   621: astore 7
    //   623: aload 5
    //   625: astore 6
    //   627: ldc 72
    //   629: iconst_2
    //   630: iconst_4
    //   631: anewarray 4	java/lang/Object
    //   634: dup
    //   635: iconst_0
    //   636: ldc_w 575
    //   639: aastore
    //   640: dup
    //   641: iconst_1
    //   642: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   645: lload_3
    //   646: lsub
    //   647: invokestatic 580	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   650: aastore
    //   651: dup
    //   652: iconst_2
    //   653: ldc_w 582
    //   656: aastore
    //   657: dup
    //   658: iconst_3
    //   659: aload_1
    //   660: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: aastore
    //   664: invokestatic 528	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   667: aload 5
    //   669: ifnull -303 -> 366
    //   672: aload 5
    //   674: invokevirtual 541	java/io/BufferedReader:close	()V
    //   677: return
    //   678: astore_1
    //   679: ldc 72
    //   681: iconst_2
    //   682: ldc_w 536
    //   685: aload_1
    //   686: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   689: return
    //   690: astore_1
    //   691: ldc 72
    //   693: iconst_2
    //   694: ldc_w 536
    //   697: aload_1
    //   698: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   701: return
    //   702: astore_1
    //   703: aload 6
    //   705: ifnull +8 -> 713
    //   708: aload 6
    //   710: invokevirtual 541	java/io/BufferedReader:close	()V
    //   713: aload_1
    //   714: athrow
    //   715: astore 5
    //   717: ldc 72
    //   719: iconst_2
    //   720: ldc_w 536
    //   723: aload 5
    //   725: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   728: goto -15 -> 713
    //   731: astore_1
    //   732: aload 5
    //   734: astore 6
    //   736: goto -33 -> 703
    //   739: goto -241 -> 498
    //   742: aconst_null
    //   743: astore 6
    //   745: goto -296 -> 449
    //   748: astore_1
    //   749: aload 5
    //   751: astore 7
    //   753: goto -411 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	this	BusinessCrashHandleListener
    //   0	756	1	paramStringBuilder	StringBuilder
    //   97	405	2	i	int
    //   56	590	3	l	long
    //   51	622	5	localBufferedReader	java.io.BufferedReader
    //   715	35	5	localIOException1	java.io.IOException
    //   63	445	6	localObject1	Object
    //   520	9	6	localIOException2	java.io.IOException
    //   542	202	6	localObject2	Object
    //   59	693	7	localObject3	Object
    //   45	461	8	localObject4	Object
    //   48	352	9	localObject5	Object
    //   77	504	10	arrayOfString	String[]
    //   28	105	11	str	String
    // Exception table:
    //   from	to	target	type
    //   65	79	341	java/lang/Exception
    //   87	96	341	java/lang/Exception
    //   106	113	341	java/lang/Exception
    //   121	164	341	java/lang/Exception
    //   172	184	341	java/lang/Exception
    //   192	198	341	java/lang/Exception
    //   206	229	341	java/lang/Exception
    //   237	249	341	java/lang/Exception
    //   257	267	341	java/lang/Exception
    //   275	287	341	java/lang/Exception
    //   295	338	341	java/lang/Exception
    //   375	383	341	java/lang/Exception
    //   391	411	341	java/lang/Exception
    //   544	558	341	java/lang/Exception
    //   566	572	341	java/lang/Exception
    //   580	589	341	java/lang/Exception
    //   597	605	341	java/lang/Exception
    //   613	619	341	java/lang/Exception
    //   627	667	341	java/lang/Exception
    //   490	495	520	java/io/IOException
    //   672	677	678	java/io/IOException
    //   361	366	690	java/io/IOException
    //   65	79	702	finally
    //   87	96	702	finally
    //   106	113	702	finally
    //   121	164	702	finally
    //   172	184	702	finally
    //   192	198	702	finally
    //   206	229	702	finally
    //   237	249	702	finally
    //   257	267	702	finally
    //   275	287	702	finally
    //   295	338	702	finally
    //   346	356	702	finally
    //   375	383	702	finally
    //   391	411	702	finally
    //   544	558	702	finally
    //   566	572	702	finally
    //   580	589	702	finally
    //   597	605	702	finally
    //   613	619	702	finally
    //   627	667	702	finally
    //   708	713	715	java/io/IOException
    //   411	418	731	finally
    //   423	449	731	finally
    //   449	485	731	finally
    //   490	495	731	finally
    //   505	517	731	finally
    //   522	533	731	finally
    //   411	418	748	java/lang/Exception
    //   423	449	748	java/lang/Exception
    //   449	485	748	java/lang/Exception
    //   490	495	748	java/lang/Exception
    //   505	517	748	java/lang/Exception
    //   522	533	748	java/lang/Exception
  }
  
  void a()
  {
    StatisticCollector.CrashControl localCrashControl = this.a.crashControl;
    if (!localCrashControl.controlSwitch) {
      QLog.d("BusinessCrashHandleListener", 1, "updateLocalCrashData crash control is off..");
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().startComponentInfo;
      if ((localCrashControl.controlLevel == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
      {
        QLog.d("BusinessCrashHandleListener", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
        return;
      }
      localObject = StatisticCollector.ctx.getSharedPreferences("crashcontrol", 0);
    } while (localObject == null);
    long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
    int i = ((SharedPreferences)localObject).getInt("crashcount", 0);
    long l2 = System.currentTimeMillis();
    this.a.dpcExtraInfo.append("updateLocalCrashData startTime=").append(StatisticCollector.simpleDateFormat.format(new Date(l1))).append(",currenttime=").append(StatisticCollector.simpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",mCurUin=").append(this.a.mCurUin).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > localCrashControl.controlWindow * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > localCrashControl.controlFreq)
      {
        this.a.shouldStopMsf = true;
        if (a()) {
          ((SharedPreferences)localObject).edit().putBoolean("crashFrequentLast", true).commit();
        }
      }
      this.a.dpcExtraInfo.append("updateLocalCrashData shouldStopMsf=").append(this.a.shouldStopMsf).append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("shouldStopMsf", this.a.shouldStopMsf).commit();
      return;
      i += 1;
    }
  }
  
  void a(String paramString)
  {
    boolean bool1 = true;
    if (!this.a.crashControl.controlSwitch) {
      QLog.d("BusinessCrashHandleListener", 1, "updatePreloadCrashData crash control is off..");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = StatisticCollector.ctx.getSharedPreferences("CrashControl_" + paramString, 4);
    } while (localSharedPreferences == null);
    long l1 = localSharedPreferences.getLong("starttime", 0L);
    int i = localSharedPreferences.getInt("crashcount", 0);
    boolean bool2 = localSharedPreferences.getBoolean("allowpreload", true);
    long l2 = System.currentTimeMillis();
    this.a.dpcExtraInfo.append("updatePreloadCrashData process=").append(paramString).append(",startTime=").append(StatisticCollector.simpleDateFormat.format(new Date(l1))).append(",currenttime=").append(StatisticCollector.simpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",allowPreload=").append(bool2).append(",mCurUin=").append(this.a.mCurUin).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.a.crashControl.controlWindow * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.a.crashControl.controlFreq) {
        bool1 = false;
      }
      this.a.dpcExtraInfo.append("updatePreloadCrashData update allowPreload=").append(bool1).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowpreload", bool1).putInt("controlwindow", this.a.crashControl.controlWindow).commit();
      return;
      i += 1;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      long l1;
      int j;
      boolean bool3;
      boolean bool2;
      int i;
      long l2;
      try
      {
        SharedPreferences localSharedPreferences = StatisticCollector.ctx.getSharedPreferences("not_restart_control_file", 4);
        if ((localSharedPreferences == null) || (paramString1 == null) || (paramString2 == null)) {
          break;
        }
        l1 = localSharedPreferences.getLong("starttime", 0L);
        int k = localSharedPreferences.getInt("crashcount", 0);
        j = localSharedPreferences.getInt("key_not_restart_max_crash", 2147483647);
        bool3 = localSharedPreferences.getBoolean("key_not_restart_enable", false);
        String str1 = localSharedPreferences.getString("key_not_restart_crash_type", "notValid");
        String str2 = localSharedPreferences.getString("key_not_restart_crash_stack", "notValid");
        if (paramString1.isEmpty())
        {
          bool1 = false;
          if (paramString2.isEmpty())
          {
            bool2 = false;
            break label309;
            if (i == 0) {
              break;
            }
            l2 = System.currentTimeMillis();
            if ((l1 <= 0L) || (l2 <= l1) || (k < 0)) {
              break label329;
            }
            if (l2 - l1 <= 86400000L) {
              continue;
            }
            break label329;
            QLog.e("BusinessCrashHandleListener", 1, "crashCount = " + i + ",allowAutoRestart = " + bool1);
            localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowAutoRestart", bool1).commit();
          }
        }
        else
        {
          bool1 = paramString1.equalsIgnoreCase(str1);
          continue;
        }
        bool2 = paramString2.contains(str2);
        break label309;
        i = 0;
        continue;
        i = k + 1;
      }
      catch (Throwable paramString1)
      {
        QLog.e("BusinessCrashHandleListener", 1, "updateNotRestartData error", paramString1);
        return;
      }
      boolean bool1 = true;
      continue;
      label309:
      if ((bool3) && (bool1) && (bool2))
      {
        i = 1;
        continue;
        label329:
        i = 1;
        l1 = l2;
        if (i > j) {
          bool1 = false;
        }
      }
    }
  }
  
  void b()
  {
    StatisticCollector.CrashControl localCrashControl = this.a.crashControl;
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      localCrashControl.controlSwitch = ((JSONObject)localObject).getBoolean("control_switch");
      localCrashControl.controlLevel = ((JSONObject)localObject).getInt("control_level");
      localCrashControl.controlWindow = ((JSONObject)localObject).getInt("control_window");
      localCrashControl.controlFreq = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.a.dpcExtraInfo.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(localCrashControl.controlSwitch);
      ((StringBuilder)localObject).append(",level=").append(localCrashControl.controlLevel);
      ((StringBuilder)localObject).append(",window=").append(localCrashControl.controlWindow);
      ((StringBuilder)localObject).append(",Freq=").append(localCrashControl.controlFreq);
      this.a.dpcExtraInfo.append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localCrashControl.reset();
        QLog.d("BusinessCrashHandleListener", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: getstatic 614	com/tencent/mobileqq/statistics/StatisticCollector:ctx	Landroid/content/Context;
    //   3: astore 13
    //   5: ldc 72
    //   7: iconst_1
    //   8: new 24	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 805
    //   15: invokespecial 806	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   22: ldc_w 808
    //   25: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 810
    //   35: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 812
    //   45: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 814
    //   56: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload 5
    //   61: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 816
    //   67: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: getstatic 639	com/tencent/mobileqq/statistics/StatisticCollector:simpleDateFormat	Ljava/text/SimpleDateFormat;
    //   73: new 641	java/util/Date
    //   76: dup
    //   77: lload 6
    //   79: invokespecial 644	java/util/Date:<init>	(J)V
    //   82: invokevirtual 650	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   85: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_2
    //   95: putstatic 819	com/tencent/mobileqq/statistics/StatisticCollector:sCrashType	Ljava/lang/String;
    //   98: aload 4
    //   100: putstatic 822	com/tencent/mobileqq/statistics/StatisticCollector:sCrashStack	Ljava/lang/String;
    //   103: iconst_1
    //   104: getstatic 823	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   107: if_icmpne +40 -> 147
    //   110: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   113: getstatic 827	com/tencent/mobileqq/statistics/StatisticCollector:sRdmInitTime	J
    //   116: lsub
    //   117: ldc2_w 828
    //   120: lcmp
    //   121: ifgt +26 -> 147
    //   124: aload 13
    //   126: new 24	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   133: aload_2
    //   134: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_3
    //   138: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 833	com/tencent/common/app/SafeModeUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   147: iconst_1
    //   148: getstatic 823	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   151: if_icmpne +47 -> 198
    //   154: aload 4
    //   156: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +39 -> 198
    //   162: iload_1
    //   163: ifeq +14 -> 177
    //   166: aload 4
    //   168: ldc_w 835
    //   171: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   174: ifne +18 -> 192
    //   177: iload_1
    //   178: ifne +20 -> 198
    //   181: aload 4
    //   183: ldc_w 837
    //   186: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   189: ifeq +9 -> 198
    //   192: invokestatic 842	com/tencent/qqperf/opt/suspendthread/SuspendThreadManager:a	()Lcom/tencent/qqperf/opt/suspendthread/SuspendThreadManager;
    //   195: invokevirtual 844	com/tencent/qqperf/opt/suspendthread/SuspendThreadManager:b	()V
    //   198: getstatic 848	com/tencent/mobileqq/statistics/StatisticCollector:sFdDetectCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   201: ifnull +43 -> 244
    //   204: iload_1
    //   205: ifne +39 -> 244
    //   208: ldc_w 850
    //   211: aload_2
    //   212: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +29 -> 244
    //   218: aload_3
    //   219: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne +22 -> 244
    //   225: aload_3
    //   226: ldc_w 852
    //   229: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   232: ifeq +12 -> 244
    //   235: getstatic 848	com/tencent/mobileqq/statistics/StatisticCollector:sFdDetectCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   238: aload_2
    //   239: invokeinterface 857 2 0
    //   244: getstatic 860	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   247: ldc_w 862
    //   250: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   253: ifeq +31 -> 284
    //   256: new 24	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 867
    //   266: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_2
    //   270: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 4
    //   275: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 871	com/tencent/mobileqq/activity/qwallet/utils/QWalletCrashUtils:a	(Ljava/lang/String;)V
    //   284: aload 4
    //   286: ifnull +17 -> 303
    //   289: aload 4
    //   291: ldc_w 873
    //   294: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   297: ifeq +6 -> 303
    //   300: invokestatic 876	com/tencent/mobileqq/statistics/natmem/NatMemAPI:b	()V
    //   303: aload 4
    //   305: ifnull +119 -> 424
    //   308: aload 4
    //   310: ldc_w 878
    //   313: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   316: ifne +25 -> 341
    //   319: aload 4
    //   321: ldc_w 880
    //   324: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   327: ifne +14 -> 341
    //   330: aload 4
    //   332: ldc_w 882
    //   335: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   338: ifeq +86 -> 424
    //   341: iconst_0
    //   342: iconst_0
    //   343: invokestatic 887	com/tencent/mobileqq/statistics/FDNative:a	(ZZ)V
    //   346: new 146	java/util/HashMap
    //   349: dup
    //   350: invokespecial 321	java/util/HashMap:<init>	()V
    //   353: astore 11
    //   355: iload_1
    //   356: ifeq +2321 -> 2677
    //   359: ldc_w 889
    //   362: astore 10
    //   364: aload 11
    //   366: ldc_w 891
    //   369: aload 10
    //   371: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: aload 11
    //   377: ldc_w 893
    //   380: aload_2
    //   381: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: aload 11
    //   387: ldc_w 895
    //   390: getstatic 860	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   393: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   396: pop
    //   397: aload 13
    //   399: invokestatic 899	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   402: aload_0
    //   403: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   406: getfield 659	com/tencent/mobileqq/statistics/StatisticCollector:mCurUin	Ljava/lang/String;
    //   409: ldc_w 901
    //   412: iconst_1
    //   413: lconst_0
    //   414: lconst_0
    //   415: aload 11
    //   417: ldc_w 903
    //   420: iconst_0
    //   421: invokevirtual 907	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   424: ldc_w 909
    //   427: invokestatic 754	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   430: checkcast 909	com/tencent/mobileqq/apollo/api/uitls/IApolloUtil
    //   433: astore 10
    //   435: aload 10
    //   437: ifnull +14 -> 451
    //   440: aload 10
    //   442: iload_1
    //   443: aload_2
    //   444: aload 4
    //   446: invokeinterface 913 4 0
    //   451: aload 4
    //   453: ifnull +103 -> 556
    //   456: aload 4
    //   458: ldc_w 915
    //   461: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   464: ifne +14 -> 478
    //   467: aload 4
    //   469: ldc_w 917
    //   472: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   475: ifeq +81 -> 556
    //   478: new 146	java/util/HashMap
    //   481: dup
    //   482: invokespecial 321	java/util/HashMap:<init>	()V
    //   485: astore 11
    //   487: iload_1
    //   488: ifeq +2197 -> 2685
    //   491: ldc_w 889
    //   494: astore 10
    //   496: aload 11
    //   498: ldc_w 891
    //   501: aload 10
    //   503: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload 11
    //   509: ldc_w 893
    //   512: aload_2
    //   513: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: aload 11
    //   519: ldc_w 895
    //   522: getstatic 860	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   525: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   528: pop
    //   529: aload 13
    //   531: invokestatic 899	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   534: aload_0
    //   535: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   538: getfield 659	com/tencent/mobileqq/statistics/StatisticCollector:mCurUin	Ljava/lang/String;
    //   541: ldc_w 919
    //   544: iconst_1
    //   545: lconst_0
    //   546: lconst_0
    //   547: aload 11
    //   549: ldc_w 903
    //   552: iconst_0
    //   553: invokevirtual 907	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   556: ldc_w 921
    //   559: invokestatic 754	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   562: checkcast 921	com/tencent/mobileqq/soload/api/ISoloadCrashService
    //   565: astore 10
    //   567: aload 10
    //   569: ifnull +19 -> 588
    //   572: aload 10
    //   574: iload_1
    //   575: aload_2
    //   576: aload_3
    //   577: aload 4
    //   579: iload 5
    //   581: lload 6
    //   583: invokeinterface 925 8 0
    //   588: getstatic 931	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   591: ldc_w 933
    //   594: invokevirtual 937	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   597: ifeq +55 -> 652
    //   600: new 245	android/content/Intent
    //   603: dup
    //   604: invokespecial 246	android/content/Intent:<init>	()V
    //   607: astore 10
    //   609: aload 10
    //   611: ldc_w 939
    //   614: invokevirtual 943	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   617: pop
    //   618: aload 10
    //   620: invokestatic 944	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   623: invokevirtual 945	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   626: invokevirtual 948	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   629: pop
    //   630: aload 13
    //   632: aload 10
    //   634: invokevirtual 952	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   637: invokestatic 524	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq +12 -> 652
    //   643: ldc 72
    //   645: iconst_2
    //   646: ldc_w 954
    //   649: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: getstatic 860	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   655: ldc_w 956
    //   658: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   661: ifeq +31 -> 692
    //   664: new 24	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 867
    //   674: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_2
    //   678: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 4
    //   683: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 960	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   692: aload 4
    //   694: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   697: ifne +139 -> 836
    //   700: aload 4
    //   702: ldc_w 962
    //   705: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   708: ifeq +128 -> 836
    //   711: new 768	org/json/JSONObject
    //   714: dup
    //   715: invokespecial 963	org/json/JSONObject:<init>	()V
    //   718: astore 10
    //   720: aload 10
    //   722: ldc_w 965
    //   725: iload_1
    //   726: invokevirtual 968	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   729: pop
    //   730: aload 10
    //   732: ldc_w 970
    //   735: aload_2
    //   736: invokevirtual 973	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   739: pop
    //   740: aload 10
    //   742: ldc_w 975
    //   745: aload_3
    //   746: invokevirtual 973	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload 10
    //   752: ldc_w 977
    //   755: aload 4
    //   757: invokevirtual 973	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   760: pop
    //   761: aload 10
    //   763: ldc_w 979
    //   766: iload 5
    //   768: invokevirtual 982	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   771: pop
    //   772: aload 10
    //   774: ldc_w 984
    //   777: lload 6
    //   779: invokevirtual 987	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   782: pop
    //   783: getstatic 991	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   786: invokevirtual 995	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   789: astore 11
    //   791: aload 11
    //   793: ifnull +43 -> 836
    //   796: aload 11
    //   798: ldc_w 997
    //   801: invokevirtual 1002	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   804: ldc_w 1003
    //   807: iconst_1
    //   808: anewarray 110	java/lang/Class
    //   811: dup
    //   812: iconst_0
    //   813: ldc 239
    //   815: aastore
    //   816: invokevirtual 455	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   819: aconst_null
    //   820: iconst_1
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload 10
    //   828: invokevirtual 1004	org/json/JSONObject:toString	()Ljava/lang/String;
    //   831: aastore
    //   832: invokevirtual 468	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   835: pop
    //   836: aconst_null
    //   837: astore 11
    //   839: new 27	java/io/File
    //   842: dup
    //   843: ldc_w 1006
    //   846: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   849: astore 10
    //   851: aload 10
    //   853: ifnull +17 -> 870
    //   856: aload 10
    //   858: invokevirtual 36	java/io/File:exists	()Z
    //   861: ifne +9 -> 870
    //   864: aload 10
    //   866: invokevirtual 1009	java/io/File:mkdirs	()Z
    //   869: pop
    //   870: new 1011	java/io/FileWriter
    //   873: dup
    //   874: new 24	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   881: ldc_w 1006
    //   884: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: lload 6
    //   889: invokevirtual 1014	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   892: ldc_w 1016
    //   895: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokespecial 1017	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   904: astore 10
    //   906: new 24	java/lang/StringBuilder
    //   909: dup
    //   910: sipush 128
    //   913: invokespecial 92	java/lang/StringBuilder:<init>	(I)V
    //   916: astore 11
    //   918: aload 11
    //   920: getstatic 639	com/tencent/mobileqq/statistics/StatisticCollector:simpleDateFormat	Ljava/text/SimpleDateFormat;
    //   923: new 641	java/util/Date
    //   926: dup
    //   927: lload 6
    //   929: invokespecial 644	java/util/Date:<init>	(J)V
    //   932: invokevirtual 650	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   935: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: ldc 64
    //   940: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: aload_2
    //   944: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: ldc 64
    //   949: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload 4
    //   954: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload 10
    //   960: aload 11
    //   962: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: invokevirtual 1020	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   968: aload 10
    //   970: invokevirtual 1023	java/io/FileWriter:flush	()V
    //   973: aload 10
    //   975: ifnull +8 -> 983
    //   978: aload 10
    //   980: invokevirtual 1024	java/io/FileWriter:close	()V
    //   983: aload_2
    //   984: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   987: ifne +47 -> 1034
    //   990: aload_2
    //   991: ldc_w 1026
    //   994: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   997: ifeq +37 -> 1034
    //   1000: invokestatic 1031	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1003: invokevirtual 1033	com/tencent/qqperf/monitor/memory/MemoryManager:a	()V
    //   1006: aload 4
    //   1008: ldc_w 1035
    //   1011: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1014: ifne +20 -> 1034
    //   1017: aload 4
    //   1019: ldc_w 1037
    //   1022: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1025: ifne +9 -> 1034
    //   1028: invokestatic 1042	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:a	()Lcom/tencent/qqperf/opt/clearmemory/MemoryClearManager;
    //   1031: invokevirtual 1043	com/tencent/qqperf/opt/clearmemory/MemoryClearManager:b	()V
    //   1034: getstatic 860	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   1037: astore 14
    //   1039: iload_1
    //   1040: ifeq +39 -> 1079
    //   1043: aload 14
    //   1045: ldc_w 1045
    //   1048: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1051: ifne +14 -> 1065
    //   1054: aload 14
    //   1056: ldc_w 1047
    //   1059: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1062: ifeq +17 -> 1079
    //   1065: ldc_w 1049
    //   1068: iconst_1
    //   1069: aload 4
    //   1071: invokestatic 739	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: aload 4
    //   1076: invokestatic 1054	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   1079: aload 13
    //   1081: invokestatic 1059	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   1084: new 24	java/lang/StringBuilder
    //   1087: dup
    //   1088: sipush 128
    //   1091: invokespecial 92	java/lang/StringBuilder:<init>	(I)V
    //   1094: astore 12
    //   1096: aload 13
    //   1098: ldc_w 1061
    //   1101: invokestatic 1066	com/tencent/hotpatch/config/PatchConfigManager:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/hotpatch/config/PatchConfig;
    //   1104: astore 10
    //   1106: aload 12
    //   1108: ldc_w 1068
    //   1111: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload 12
    //   1117: ldc_w 1070
    //   1120: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: pop
    //   1124: aload 12
    //   1126: ldc_w 1072
    //   1129: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: getstatic 1075	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1135: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: pop
    //   1139: aload 12
    //   1141: ldc_w 1077
    //   1144: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: getstatic 1080	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1150: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: pop
    //   1154: aload 12
    //   1156: ldc_w 1082
    //   1159: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: getstatic 1085	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1165: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 12
    //   1171: ldc_w 1087
    //   1174: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: getstatic 1090	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1180: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload 12
    //   1186: ldc_w 1092
    //   1189: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: getstatic 1096	com/tencent/mobileqq/startup/director/StartupDirector:b	I
    //   1195: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload 12
    //   1201: ldc_w 1098
    //   1204: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: astore 11
    //   1209: aload 10
    //   1211: ifnull +1538 -> 2749
    //   1214: aload 10
    //   1216: invokevirtual 1101	com/tencent/hotpatch/config/PatchConfig:a	()Z
    //   1219: ifeq +1530 -> 2749
    //   1222: iconst_1
    //   1223: istore 9
    //   1225: aload 11
    //   1227: iload 9
    //   1229: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1232: ldc_w 1103
    //   1235: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: getstatic 1107	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_Int	I
    //   1241: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: ldc_w 1109
    //   1247: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: getstatic 1112	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1253: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1256: ldc_w 1114
    //   1259: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: getstatic 1116	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1265: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: aload 12
    //   1271: ldc_w 1118
    //   1274: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokestatic 1124	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1280: invokevirtual 1127	java/lang/Runtime:maxMemory	()J
    //   1283: invokevirtual 1014	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1286: ldc_w 1129
    //   1289: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: invokestatic 1124	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1295: invokevirtual 1132	java/lang/Runtime:totalMemory	()J
    //   1298: invokestatic 1124	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1301: invokevirtual 1135	java/lang/Runtime:freeMemory	()J
    //   1304: lsub
    //   1305: invokevirtual 1014	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1308: pop
    //   1309: aload 12
    //   1311: ldc_w 1137
    //   1314: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: invokestatic 1031	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1320: invokevirtual 1139	com/tencent/qqperf/monitor/memory/MemoryManager:a	()I
    //   1323: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1326: ldc_w 1141
    //   1329: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokestatic 1031	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1335: invokevirtual 1143	com/tencent/qqperf/monitor/memory/MemoryManager:b	()I
    //   1338: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1341: ldc_w 1145
    //   1344: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: invokestatic 1031	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   1350: invokevirtual 1147	com/tencent/qqperf/monitor/memory/MemoryManager:c	()I
    //   1353: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: aload 12
    //   1359: ldc_w 1149
    //   1362: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: invokestatic 1154	com/tencent/qqperf/tools/SceneTracker:a	()Lcom/tencent/qqperf/tools/SceneTracker;
    //   1368: invokevirtual 1156	com/tencent/qqperf/tools/SceneTracker:a	()Ljava/lang/String;
    //   1371: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: pop
    //   1375: getstatic 1161	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1378: ifnull +21 -> 1399
    //   1381: aload 12
    //   1383: ldc_w 1163
    //   1386: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: getstatic 1161	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   1392: invokevirtual 1166	android/support/v4/util/MQLruCache:size	()I
    //   1395: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: invokestatic 1124	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1402: invokevirtual 1127	java/lang/Runtime:maxMemory	()J
    //   1405: invokestatic 1124	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1408: invokevirtual 1132	java/lang/Runtime:totalMemory	()J
    //   1411: lsub
    //   1412: l2f
    //   1413: fconst_1
    //   1414: fmul
    //   1415: invokestatic 1124	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1418: invokevirtual 1127	java/lang/Runtime:maxMemory	()J
    //   1421: l2f
    //   1422: fdiv
    //   1423: f2d
    //   1424: ldc2_w 1167
    //   1427: dcmpl
    //   1428: iflt +26 -> 1454
    //   1431: aload_2
    //   1432: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1435: ifne +19 -> 1454
    //   1438: aload_2
    //   1439: ldc_w 1026
    //   1442: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1445: ifeq +9 -> 1454
    //   1448: aload_0
    //   1449: aload 12
    //   1451: invokespecial 1170	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:c	(Ljava/lang/StringBuilder;)V
    //   1454: aload 12
    //   1456: ldc_w 503
    //   1459: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: getstatic 1175	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1465: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: getstatic 1180	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1472: astore 10
    //   1474: aload 10
    //   1476: ifnull +56 -> 1532
    //   1479: aload 10
    //   1481: arraylength
    //   1482: iconst_3
    //   1483: if_icmplt +49 -> 1532
    //   1486: aload 12
    //   1488: ldc_w 1182
    //   1491: iconst_3
    //   1492: anewarray 4	java/lang/Object
    //   1495: dup
    //   1496: iconst_0
    //   1497: aload 10
    //   1499: iconst_0
    //   1500: iaload
    //   1501: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1504: aastore
    //   1505: dup
    //   1506: iconst_1
    //   1507: aload 10
    //   1509: iconst_1
    //   1510: iaload
    //   1511: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1514: aastore
    //   1515: dup
    //   1516: iconst_2
    //   1517: aload 10
    //   1519: iconst_2
    //   1520: iaload
    //   1521: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1524: aastore
    //   1525: invokestatic 1185	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1528: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: aload 12
    //   1534: ldc 64
    //   1536: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: pop
    //   1540: invokestatic 1190	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   1543: invokevirtual 1193	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/monitor/base/IAPMModuleCelling;
    //   1546: invokeinterface 1197 1 0
    //   1551: astore 11
    //   1553: invokestatic 1202	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()[J
    //   1556: astore 15
    //   1558: aload 12
    //   1560: invokestatic 1205	com/tencent/mobileqq/utils/DeviceInfoUtil:l	()Ljava/lang/String;
    //   1563: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: ldc 64
    //   1568: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: pop
    //   1572: aload 11
    //   1574: astore 10
    //   1576: aload 11
    //   1578: ifnonnull +8 -> 1586
    //   1581: ldc_w 1207
    //   1584: astore 10
    //   1586: aload 12
    //   1588: aload 10
    //   1590: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: ldc 64
    //   1595: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: pop
    //   1599: aload 12
    //   1601: ldc_w 1209
    //   1604: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: aload 15
    //   1609: iconst_0
    //   1610: laload
    //   1611: invokevirtual 1014	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1614: ldc_w 1211
    //   1617: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: aload 15
    //   1622: iconst_1
    //   1623: laload
    //   1624: invokevirtual 1014	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1627: ldc_w 1213
    //   1630: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: pop
    //   1634: aload_0
    //   1635: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1638: getfield 1216	com/tencent/mobileqq/statistics/StatisticCollector:activityExtraInfo	Ljava/lang/String;
    //   1641: ifnonnull +1114 -> 2755
    //   1644: ldc_w 1207
    //   1647: astore 10
    //   1649: aload 12
    //   1651: aload 10
    //   1653: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: ldc 64
    //   1658: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: pop
    //   1662: aload 12
    //   1664: new 24	java/lang/StringBuilder
    //   1667: dup
    //   1668: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1671: ldc_w 1218
    //   1674: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1677: invokestatic 1223	mqq/app/Foreground:getResumeActivityCount	()I
    //   1680: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1683: ldc 64
    //   1685: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: pop
    //   1695: aload 12
    //   1697: ldc_w 1225
    //   1700: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: getstatic 1230	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   1706: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1709: ldc 64
    //   1711: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: pop
    //   1715: getstatic 1234	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1718: astore 10
    //   1720: aload 10
    //   1722: instanceof 1227
    //   1725: ifeq +32 -> 1757
    //   1728: aload 10
    //   1730: checkcast 1227	com/tencent/mobileqq/activity/SplashActivity
    //   1733: astore 10
    //   1735: aload 12
    //   1737: ldc_w 1236
    //   1740: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: aload 10
    //   1745: invokevirtual 1239	com/tencent/mobileqq/activity/SplashActivity:getCurrentTab	()I
    //   1748: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1751: ldc 64
    //   1753: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: pop
    //   1757: getstatic 1242	com/tencent/mobileqq/activity/CrashReportConstant:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1760: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1763: ifne +23 -> 1786
    //   1766: aload 12
    //   1768: ldc_w 1244
    //   1771: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: getstatic 1242	com/tencent/mobileqq/activity/CrashReportConstant:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1777: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: ldc 64
    //   1782: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: pop
    //   1786: getstatic 1247	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1789: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1792: ifne +23 -> 1815
    //   1795: aload 12
    //   1797: ldc_w 1249
    //   1800: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: getstatic 1247	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1806: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: ldc 64
    //   1811: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: pop
    //   1815: getstatic 1252	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1818: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1821: ifne +23 -> 1844
    //   1824: aload 12
    //   1826: ldc_w 1254
    //   1829: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: getstatic 1252	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1835: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: ldc 64
    //   1840: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: pop
    //   1844: aload 12
    //   1846: new 24	java/lang/StringBuilder
    //   1849: dup
    //   1850: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1853: ldc_w 1256
    //   1856: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1859: invokestatic 1261	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1862: ldc_w 1263
    //   1865: ldc_w 1265
    //   1868: iconst_1
    //   1869: invokevirtual 1269	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   1872: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1875: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1878: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: new 24	java/lang/StringBuilder
    //   1884: dup
    //   1885: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1888: ldc_w 1271
    //   1891: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: invokestatic 1261	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1897: ldc_w 1263
    //   1900: ldc_w 1273
    //   1903: iconst_0
    //   1904: invokevirtual 1276	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1907: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1910: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1913: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: new 24	java/lang/StringBuilder
    //   1919: dup
    //   1920: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1923: ldc_w 1278
    //   1926: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: invokestatic 1261	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1932: ldc_w 1263
    //   1935: ldc_w 1280
    //   1938: iconst_0
    //   1939: invokevirtual 1276	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1942: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1945: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1948: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1951: ldc 64
    //   1953: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: pop
    //   1957: invokestatic 403	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1960: invokestatic 1285	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   1963: invokevirtual 1288	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   1966: astore 10
    //   1968: aload 10
    //   1970: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1973: ifne +11 -> 1984
    //   1976: aload 12
    //   1978: aload 10
    //   1980: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: pop
    //   1984: aload 12
    //   1986: aload_0
    //   1987: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1990: getfield 633	com/tencent/mobileqq/statistics/StatisticCollector:dpcExtraInfo	Ljava/lang/StringBuilder;
    //   1993: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1996: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1999: pop
    //   2000: aload 12
    //   2002: aload_0
    //   2003: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2006: getfield 1291	com/tencent/mobileqq/statistics/StatisticCollector:threadInfo	Ljava/lang/StringBuilder;
    //   2009: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2012: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: pop
    //   2016: getstatic 1294	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2019: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2022: ifne +51 -> 2073
    //   2025: getstatic 45	android/os/Build$VERSION:SDK_INT	I
    //   2028: bipush 8
    //   2030: if_icmplt +43 -> 2073
    //   2033: aload 12
    //   2035: new 24	java/lang/StringBuilder
    //   2038: dup
    //   2039: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   2042: ldc_w 1296
    //   2045: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2048: getstatic 1294	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2051: invokevirtual 1300	java/lang/String:getBytes	()[B
    //   2054: iconst_0
    //   2055: invokestatic 1306	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   2058: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2061: ldc 64
    //   2063: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2069: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: pop
    //   2073: aload 12
    //   2075: invokestatic 1311	cooperation/qzone/RDMEtraMsgCollector:getInstance	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   2078: invokevirtual 1314	cooperation/qzone/RDMEtraMsgCollector:getEtraMsg	()Ljava/lang/String;
    //   2081: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: pop
    //   2085: aload 12
    //   2087: ldc 64
    //   2089: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: pop
    //   2093: aload_0
    //   2094: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2097: getfield 1318	com/tencent/mobileqq/statistics/StatisticCollector:listContextLog	Ljava/util/LinkedList;
    //   2100: invokevirtual 1319	java/util/LinkedList:size	()I
    //   2103: ifle +30 -> 2133
    //   2106: aload 12
    //   2108: aload_0
    //   2109: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2112: getfield 1318	com/tencent/mobileqq/statistics/StatisticCollector:listContextLog	Ljava/util/LinkedList;
    //   2115: invokevirtual 1322	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   2118: checkcast 1324	com/tencent/mobileqq/statistics/StatisticCollector$ContextLog
    //   2121: invokevirtual 1325	com/tencent/mobileqq/statistics/StatisticCollector$ContextLog:toString	()Ljava/lang/String;
    //   2124: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: pop
    //   2128: goto -35 -> 2093
    //   2131: astore 10
    //   2133: aload 13
    //   2135: invokestatic 1331	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   2138: istore 5
    //   2140: aload 13
    //   2142: invokestatic 1336	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   2145: istore 8
    //   2147: aload 12
    //   2149: bipush 10
    //   2151: invokevirtual 1339	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2154: ldc_w 1341
    //   2157: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2160: astore 11
    //   2162: iload 8
    //   2164: ifne +603 -> 2767
    //   2167: ldc_w 1343
    //   2170: astore 10
    //   2172: aload 11
    //   2174: aload 10
    //   2176: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: ldc_w 1345
    //   2182: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: iload 5
    //   2187: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2190: ldc_w 1347
    //   2193: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: iload 8
    //   2198: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2201: pop
    //   2202: aload 12
    //   2204: ldc_w 1349
    //   2207: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2210: aload 13
    //   2212: invokestatic 1352	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   2215: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: pop
    //   2219: aload 12
    //   2221: ldc_w 1354
    //   2224: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: getstatic 639	com/tencent/mobileqq/statistics/StatisticCollector:simpleDateFormat	Ljava/text/SimpleDateFormat;
    //   2230: new 641	java/util/Date
    //   2233: dup
    //   2234: getstatic 1356	com/tencent/common/app/SafeModeUtil:a	J
    //   2237: invokespecial 644	java/util/Date:<init>	(J)V
    //   2240: invokevirtual 650	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2243: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: pop
    //   2247: aload 12
    //   2249: ldc_w 1358
    //   2252: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: getstatic 639	com/tencent/mobileqq/statistics/StatisticCollector:simpleDateFormat	Ljava/text/SimpleDateFormat;
    //   2258: new 641	java/util/Date
    //   2261: dup
    //   2262: getstatic 1360	com/tencent/common/app/SafeModeUtil:b	J
    //   2265: invokespecial 644	java/util/Date:<init>	(J)V
    //   2268: invokevirtual 650	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2271: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: ldc 64
    //   2276: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: pop
    //   2280: iload_1
    //   2281: ifeq +103 -> 2384
    //   2284: aload 14
    //   2286: ldc_w 1045
    //   2289: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2292: ifne +25 -> 2317
    //   2295: aload 14
    //   2297: ldc_w 1047
    //   2300: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2303: ifne +14 -> 2317
    //   2306: aload 14
    //   2308: ldc_w 862
    //   2311: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2314: ifeq +70 -> 2384
    //   2317: aload 13
    //   2319: ldc_w 1362
    //   2322: iconst_4
    //   2323: invokevirtual 617	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2326: ldc_w 1364
    //   2329: aconst_null
    //   2330: invokeinterface 425 3 0
    //   2335: astore 10
    //   2337: aload 12
    //   2339: ldc_w 1366
    //   2342: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2345: aload 10
    //   2347: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: pop
    //   2351: invokestatic 524	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2354: ifeq +30 -> 2384
    //   2357: ldc 72
    //   2359: iconst_2
    //   2360: new 24	java/lang/StringBuilder
    //   2363: dup
    //   2364: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   2367: ldc_w 1368
    //   2370: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: aload 10
    //   2375: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2381: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2384: aload 14
    //   2386: ldc_w 1370
    //   2389: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2392: ifne +80 -> 2472
    //   2395: aload 14
    //   2397: ldc_w 1372
    //   2400: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2403: ifne +69 -> 2472
    //   2406: aload 14
    //   2408: ldc_w 1374
    //   2411: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2414: ifne +58 -> 2472
    //   2417: aload 14
    //   2419: ldc_w 1376
    //   2422: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2425: ifne +47 -> 2472
    //   2428: aload 14
    //   2430: ldc_w 1378
    //   2433: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2436: ifne +36 -> 2472
    //   2439: aload 14
    //   2441: ldc_w 1380
    //   2444: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2447: ifne +25 -> 2472
    //   2450: aload 14
    //   2452: ldc_w 1382
    //   2455: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2458: ifne +14 -> 2472
    //   2461: aload 14
    //   2463: ldc_w 1384
    //   2466: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2469: ifeq +71 -> 2540
    //   2472: ldc_w 1386
    //   2475: invokestatic 754	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2478: checkcast 1386	com/tencent/mobileqq/mini/api/report/IMiniReport
    //   2481: invokeinterface 1389 1 0
    //   2486: astore 10
    //   2488: aload 10
    //   2490: ifnull +50 -> 2540
    //   2493: aload 12
    //   2495: ldc_w 1391
    //   2498: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2501: aload 10
    //   2503: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2506: pop
    //   2507: invokestatic 524	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2510: ifeq +30 -> 2540
    //   2513: ldc 72
    //   2515: iconst_2
    //   2516: new 24	java/lang/StringBuilder
    //   2519: dup
    //   2520: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   2523: ldc_w 1393
    //   2526: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2529: aload 10
    //   2531: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2537: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2540: aload 12
    //   2542: ldc_w 1395
    //   2545: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2551: getfield 603	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2554: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: pop
    //   2558: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2561: getfield 1399	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2564: ifnull +233 -> 2797
    //   2567: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2570: getfield 1399	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2573: invokeinterface 1402 1 0
    //   2578: ifne +219 -> 2797
    //   2581: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2584: getfield 1399	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2587: invokeinterface 1403 1 0
    //   2592: astore 10
    //   2594: aload 10
    //   2596: invokeinterface 178 1 0
    //   2601: ifeq +196 -> 2797
    //   2604: aload 10
    //   2606: invokeinterface 182 1 0
    //   2611: checkcast 1405	android/util/Pair
    //   2614: astore 11
    //   2616: aload 11
    //   2618: ifnull -24 -> 2594
    //   2621: aload 12
    //   2623: ldc_w 1407
    //   2626: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: getstatic 639	com/tencent/mobileqq/statistics/StatisticCollector:simpleDateFormat	Ljava/text/SimpleDateFormat;
    //   2632: new 641	java/util/Date
    //   2635: dup
    //   2636: aload 11
    //   2638: getfield 1410	android/util/Pair:first	Ljava/lang/Object;
    //   2641: checkcast 577	java/lang/Long
    //   2644: invokevirtual 1413	java/lang/Long:longValue	()J
    //   2647: invokespecial 644	java/util/Date:<init>	(J)V
    //   2650: invokevirtual 650	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2653: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2656: ldc_w 1415
    //   2659: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2662: aload 11
    //   2664: getfield 1418	android/util/Pair:second	Ljava/lang/Object;
    //   2667: checkcast 239	java/lang/String
    //   2670: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2673: pop
    //   2674: goto -80 -> 2594
    //   2677: ldc_w 1420
    //   2680: astore 10
    //   2682: goto -2318 -> 364
    //   2685: ldc_w 1420
    //   2688: astore 10
    //   2690: goto -2194 -> 496
    //   2693: astore 10
    //   2695: aload 10
    //   2697: invokevirtual 1423	java/lang/Throwable:printStackTrace	()V
    //   2700: goto -1864 -> 836
    //   2703: astore 12
    //   2705: aload 11
    //   2707: astore 10
    //   2709: aload 12
    //   2711: astore 11
    //   2713: aload 11
    //   2715: invokevirtual 1424	java/lang/Exception:printStackTrace	()V
    //   2718: aload 10
    //   2720: ifnull -1737 -> 983
    //   2723: aload 10
    //   2725: invokevirtual 1024	java/io/FileWriter:close	()V
    //   2728: goto -1745 -> 983
    //   2731: astore 10
    //   2733: goto -1750 -> 983
    //   2736: astore_2
    //   2737: aconst_null
    //   2738: astore_3
    //   2739: aload_3
    //   2740: ifnull +7 -> 2747
    //   2743: aload_3
    //   2744: invokevirtual 1024	java/io/FileWriter:close	()V
    //   2747: aload_2
    //   2748: athrow
    //   2749: iconst_0
    //   2750: istore 9
    //   2752: goto -1527 -> 1225
    //   2755: aload_0
    //   2756: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2759: getfield 1216	com/tencent/mobileqq/statistics/StatisticCollector:activityExtraInfo	Ljava/lang/String;
    //   2762: astore 10
    //   2764: goto -1115 -> 1649
    //   2767: ldc_w 1426
    //   2770: astore 10
    //   2772: goto -600 -> 2172
    //   2775: astore 10
    //   2777: invokestatic 524	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2780: ifeq -240 -> 2540
    //   2783: ldc 72
    //   2785: iconst_2
    //   2786: ldc_w 1428
    //   2789: aload 10
    //   2791: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2794: goto -254 -> 2540
    //   2797: getstatic 1431	com/tencent/qbar/QbarCrashCollector:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2800: astore 10
    //   2802: aload 10
    //   2804: ifnull +25 -> 2829
    //   2807: aload 10
    //   2809: invokevirtual 1434	java/lang/String:length	()I
    //   2812: ifle +17 -> 2829
    //   2815: aload 12
    //   2817: ldc_w 1436
    //   2820: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2823: aload 10
    //   2825: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2828: pop
    //   2829: aload_2
    //   2830: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2833: ifne +50 -> 2883
    //   2836: aload_2
    //   2837: ldc_w 1438
    //   2840: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2843: ifeq +40 -> 2883
    //   2846: aload 4
    //   2848: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2851: ifne +32 -> 2883
    //   2854: aload 4
    //   2856: ldc_w 1440
    //   2859: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2862: ifeq +21 -> 2883
    //   2865: aload 12
    //   2867: ldc_w 1442
    //   2870: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: pop
    //   2874: aload_0
    //   2875: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2878: aload 12
    //   2880: invokespecial 1444	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   2883: ldc_w 1446
    //   2886: aload_2
    //   2887: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2890: ifeq +22 -> 2912
    //   2893: aload 4
    //   2895: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2898: ifne +14 -> 2912
    //   2901: aload 4
    //   2903: ldc_w 1448
    //   2906: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2909: ifne +32 -> 2941
    //   2912: ldc_w 1450
    //   2915: aload_2
    //   2916: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2919: ifeq +40 -> 2959
    //   2922: aload 4
    //   2924: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2927: ifne +32 -> 2959
    //   2930: aload 4
    //   2932: ldc_w 1452
    //   2935: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2938: ifeq +21 -> 2959
    //   2941: aload 12
    //   2943: ldc_w 1454
    //   2946: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2949: ldc_w 1456
    //   2952: invokestatic 1460	com/tencent/mobileqq/util/SystemUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2955: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2958: pop
    //   2959: ldc_w 1462
    //   2962: aload_2
    //   2963: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2966: ifne +66 -> 3032
    //   2969: ldc_w 850
    //   2972: aload_2
    //   2973: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2976: ifeq +14 -> 2990
    //   2979: aload 4
    //   2981: ldc_w 1464
    //   2984: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2987: ifne +45 -> 3032
    //   2990: ldc_w 1466
    //   2993: aload_2
    //   2994: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2997: ifeq +14 -> 3011
    //   3000: aload 4
    //   3002: ldc_w 1468
    //   3005: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3008: ifne +24 -> 3032
    //   3011: ldc_w 850
    //   3014: aload_2
    //   3015: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3018: ifeq +94 -> 3112
    //   3021: aload 4
    //   3023: ldc_w 1470
    //   3026: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3029: ifeq +83 -> 3112
    //   3032: getstatic 639	com/tencent/mobileqq/statistics/StatisticCollector:simpleDateFormat	Ljava/text/SimpleDateFormat;
    //   3035: new 641	java/util/Date
    //   3038: dup
    //   3039: getstatic 1473	com/tencent/mobileqq/statistics/StatisticCollector:FDMillisLastChecked	J
    //   3042: invokespecial 644	java/util/Date:<init>	(J)V
    //   3045: invokevirtual 650	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3048: astore 10
    //   3050: aload 12
    //   3052: ldc_w 1475
    //   3055: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3058: getstatic 1478	com/tencent/mobileqq/statistics/StatisticCollector:FDCountLastChecked	I
    //   3061: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3064: ldc_w 1480
    //   3067: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3070: aload 10
    //   3072: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3075: pop
    //   3076: aload 12
    //   3078: ldc_w 1482
    //   3081: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3084: pop
    //   3085: aload 12
    //   3087: invokestatic 1483	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	()Ljava/lang/String;
    //   3090: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3093: pop
    //   3094: aload 12
    //   3096: ldc_w 1485
    //   3099: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: pop
    //   3103: aload 12
    //   3105: invokestatic 1490	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   3108: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3111: pop
    //   3112: iconst_1
    //   3113: getstatic 823	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   3116: if_icmpne +49 -> 3165
    //   3119: aload_3
    //   3120: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3123: ifne +42 -> 3165
    //   3126: aload_2
    //   3127: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3130: ifne +35 -> 3165
    //   3133: aload_2
    //   3134: ldc_w 1492
    //   3137: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3140: ifeq +25 -> 3165
    //   3143: aload_3
    //   3144: ldc_w 1494
    //   3147: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3150: ifeq +15 -> 3165
    //   3153: aload_0
    //   3154: aload 12
    //   3156: invokespecial 1496	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:b	(Ljava/lang/StringBuilder;)V
    //   3159: aload_0
    //   3160: aload 12
    //   3162: invokespecial 1498	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	(Ljava/lang/StringBuilder;)V
    //   3165: iload_1
    //   3166: ifeq +39 -> 3205
    //   3169: aload 4
    //   3171: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3174: ifne +31 -> 3205
    //   3177: aload 4
    //   3179: ldc_w 1500
    //   3182: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3185: ifeq +20 -> 3205
    //   3188: aload_2
    //   3189: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3192: ifne +13 -> 3205
    //   3195: aload_2
    //   3196: ldc_w 1502
    //   3199: invokevirtual 744	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3202: ifne +20 -> 3222
    //   3205: aload_2
    //   3206: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3209: ifne +61 -> 3270
    //   3212: aload_2
    //   3213: ldc_w 1026
    //   3216: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3219: ifeq +51 -> 3270
    //   3222: aload 12
    //   3224: ldc_w 1504
    //   3227: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3230: ldc_w 1506
    //   3233: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3236: pop
    //   3237: aload 12
    //   3239: invokestatic 1509	com/tencent/mobileqq/statistics/crash/MemoryInfoTools:a	()Ljava/lang/String;
    //   3242: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3245: pop
    //   3246: aload 12
    //   3248: ldc_w 1504
    //   3251: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3254: ldc_w 1511
    //   3257: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3260: pop
    //   3261: aload 12
    //   3263: invokestatic 1514	com/tencent/mobileqq/statistics/crash/ObjectInfoTools:a	()Ljava/lang/String;
    //   3266: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3269: pop
    //   3270: aload 12
    //   3272: new 24	java/lang/StringBuilder
    //   3275: dup
    //   3276: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   3279: ldc_w 1516
    //   3282: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3285: invokestatic 403	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3288: ldc_w 1518
    //   3291: invokestatic 1523	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3294: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3297: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3300: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3303: pop
    //   3304: aload 12
    //   3306: new 24	java/lang/StringBuilder
    //   3309: dup
    //   3310: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   3313: ldc_w 1525
    //   3316: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3319: invokestatic 1528	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	()I
    //   3322: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3325: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3328: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: pop
    //   3332: ldc 72
    //   3334: iconst_1
    //   3335: new 24	java/lang/StringBuilder
    //   3338: dup
    //   3339: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   3342: ldc_w 1530
    //   3345: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3348: aload 12
    //   3350: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3353: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3356: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3359: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3362: aload 12
    //   3364: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3367: areturn
    //   3368: astore_2
    //   3369: ldc 72
    //   3371: iconst_1
    //   3372: ldc_w 1532
    //   3375: aload_2
    //   3376: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3379: goto -109 -> 3270
    //   3382: astore_2
    //   3383: aload 12
    //   3385: ldc_w 1534
    //   3388: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3391: pop
    //   3392: goto -60 -> 3332
    //   3395: astore 10
    //   3397: goto -2414 -> 983
    //   3400: astore_3
    //   3401: goto -654 -> 2747
    //   3404: astore 10
    //   3406: goto -447 -> 2959
    //   3409: astore 10
    //   3411: goto -582 -> 2829
    //   3414: astore 10
    //   3416: goto -1136 -> 2280
    //   3419: astore 10
    //   3421: goto -1202 -> 2219
    //   3424: astore 10
    //   3426: goto -1333 -> 2093
    //   3429: astore_2
    //   3430: aload 10
    //   3432: astore_3
    //   3433: goto -694 -> 2739
    //   3436: astore_2
    //   3437: aload 10
    //   3439: astore_3
    //   3440: goto -701 -> 2739
    //   3443: astore 11
    //   3445: goto -732 -> 2713
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3448	0	this	BusinessCrashHandleListener
    //   0	3448	1	paramBoolean	boolean
    //   0	3448	2	paramString1	String
    //   0	3448	3	paramString2	String
    //   0	3448	4	paramString3	String
    //   0	3448	5	paramInt	int
    //   0	3448	6	paramLong	long
    //   2145	52	8	i	int
    //   1223	1528	9	bool	boolean
    //   362	1617	10	localObject1	Object
    //   2131	1	10	localThrowable1	Throwable
    //   2170	519	10	localObject2	Object
    //   2693	3	10	localThrowable2	Throwable
    //   2707	17	10	localObject3	Object
    //   2731	1	10	localException1	java.lang.Exception
    //   2762	9	10	str1	String
    //   2775	15	10	localThrowable3	Throwable
    //   2800	271	10	str2	String
    //   3395	1	10	localException2	java.lang.Exception
    //   3404	1	10	localThrowable4	Throwable
    //   3409	1	10	localThrowable5	Throwable
    //   3414	1	10	localThrowable6	Throwable
    //   3419	1	10	localThrowable7	Throwable
    //   3424	14	10	localThrowable8	Throwable
    //   353	2361	11	localObject4	Object
    //   3443	1	11	localException3	java.lang.Exception
    //   1094	1528	12	localStringBuilder	StringBuilder
    //   2703	681	12	localException4	java.lang.Exception
    //   3	2315	13	localContext	Context
    //   1037	1425	14	str3	String
    //   1556	65	15	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   2093	2128	2131	java/lang/Throwable
    //   711	791	2693	java/lang/Throwable
    //   796	836	2693	java/lang/Throwable
    //   839	851	2703	java/lang/Exception
    //   856	870	2703	java/lang/Exception
    //   870	906	2703	java/lang/Exception
    //   2723	2728	2731	java/lang/Exception
    //   839	851	2736	finally
    //   856	870	2736	finally
    //   870	906	2736	finally
    //   2384	2472	2775	java/lang/Throwable
    //   2472	2488	2775	java/lang/Throwable
    //   2493	2540	2775	java/lang/Throwable
    //   3169	3205	3368	java/lang/Throwable
    //   3205	3222	3368	java/lang/Throwable
    //   3222	3270	3368	java/lang/Throwable
    //   3270	3332	3382	java/lang/Throwable
    //   978	983	3395	java/lang/Exception
    //   2743	2747	3400	java/lang/Exception
    //   2829	2883	3404	java/lang/Throwable
    //   2883	2912	3404	java/lang/Throwable
    //   2912	2941	3404	java/lang/Throwable
    //   2941	2959	3404	java/lang/Throwable
    //   2797	2802	3409	java/lang/Throwable
    //   2807	2829	3409	java/lang/Throwable
    //   2219	2280	3414	java/lang/Throwable
    //   2133	2162	3419	java/lang/Throwable
    //   2172	2219	3419	java/lang/Throwable
    //   1096	1209	3424	java/lang/Throwable
    //   1214	1222	3424	java/lang/Throwable
    //   1225	1399	3424	java/lang/Throwable
    //   1399	1454	3424	java/lang/Throwable
    //   1454	1474	3424	java/lang/Throwable
    //   1479	1532	3424	java/lang/Throwable
    //   1532	1572	3424	java/lang/Throwable
    //   1586	1644	3424	java/lang/Throwable
    //   1649	1757	3424	java/lang/Throwable
    //   1757	1786	3424	java/lang/Throwable
    //   1786	1815	3424	java/lang/Throwable
    //   1815	1844	3424	java/lang/Throwable
    //   1844	1984	3424	java/lang/Throwable
    //   1984	2073	3424	java/lang/Throwable
    //   2073	2093	3424	java/lang/Throwable
    //   2755	2764	3424	java/lang/Throwable
    //   906	973	3429	finally
    //   2713	2718	3436	finally
    //   906	973	3443	java/lang/Exception
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 72
    //   2: iconst_1
    //   3: new 24	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 1538
    //   10: invokespecial 806	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 1540
    //   20: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 1543	com/tencent/mobileqq/statistics/StatisticCollector:sIsFinalizeTimeoutException	Z
    //   26: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: getstatic 1543	com/tencent/mobileqq/statistics/StatisticCollector:sIsFinalizeTimeoutException	Z
    //   38: ifeq +9 -> 47
    //   41: iconst_0
    //   42: putstatic 1543	com/tencent/mobileqq/statistics/StatisticCollector:sIsFinalizeTimeoutException	Z
    //   45: iconst_1
    //   46: ireturn
    //   47: getstatic 614	com/tencent/mobileqq/statistics/StatisticCollector:ctx	Landroid/content/Context;
    //   50: astore_3
    //   51: iload_1
    //   52: ifeq +31 -> 83
    //   55: aload_3
    //   56: ldc_w 1362
    //   59: iconst_4
    //   60: invokevirtual 617	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   63: invokeinterface 674 1 0
    //   68: ldc_w 1545
    //   71: iconst_1
    //   72: invokeinterface 682 3 0
    //   77: invokeinterface 685 1 0
    //   82: pop
    //   83: iload_1
    //   84: ifne +22 -> 106
    //   87: aload_0
    //   88: getstatic 819	com/tencent/mobileqq/statistics/StatisticCollector:sCrashType	Ljava/lang/String;
    //   91: getstatic 822	com/tencent/mobileqq/statistics/StatisticCollector:sCrashStack	Ljava/lang/String;
    //   94: invokespecial 1547	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   97: ifeq +9 -> 106
    //   100: iconst_1
    //   101: putstatic 1550	com/tencent/mobileqq/statistics/StatisticCollector:sCatchedNotExit	Z
    //   104: iconst_1
    //   105: ireturn
    //   106: getstatic 860	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   109: astore 4
    //   111: aload_0
    //   112: invokespecial 1552	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:c	()V
    //   115: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   118: invokevirtual 1555	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   121: aload_0
    //   122: aload_3
    //   123: aload 4
    //   125: invokespecial 1556	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   128: aload 4
    //   130: ldc_w 1558
    //   133: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: ifeq +21 -> 157
    //   139: aload_0
    //   140: invokevirtual 1559	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:b	()V
    //   143: aload_0
    //   144: invokevirtual 1560	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	()V
    //   147: aload_0
    //   148: getstatic 819	com/tencent/mobileqq/statistics/StatisticCollector:sCrashType	Ljava/lang/String;
    //   151: getstatic 822	com/tencent/mobileqq/statistics/StatisticCollector:sCrashStack	Ljava/lang/String;
    //   154: invokevirtual 1562	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 4
    //   159: ldc_w 1045
    //   162: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   165: ifne +25 -> 190
    //   168: aload 4
    //   170: ldc_w 862
    //   173: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   176: ifne +14 -> 190
    //   179: aload 4
    //   181: ldc_w 1564
    //   184: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   187: ifeq +13 -> 200
    //   190: aload_0
    //   191: invokevirtual 1559	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:b	()V
    //   194: aload_0
    //   195: aload 4
    //   197: invokevirtual 1565	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	(Ljava/lang/String;)V
    //   200: aload 4
    //   202: ldc_w 1045
    //   205: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   208: ifne +47 -> 255
    //   211: aload 4
    //   213: ldc_w 862
    //   216: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   219: ifne +36 -> 255
    //   222: aload 4
    //   224: ldc_w 1564
    //   227: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   230: ifne +25 -> 255
    //   233: aload 4
    //   235: ldc_w 1567
    //   238: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   241: ifne +14 -> 255
    //   244: aload 4
    //   246: ldc_w 1047
    //   249: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   252: ifeq +88 -> 340
    //   255: ldc_w 1569
    //   258: iconst_0
    //   259: invokestatic 1574	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   262: ifeq +78 -> 340
    //   265: ldc 72
    //   267: iconst_1
    //   268: new 24	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 1576
    //   278: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   284: ldc2_w 1577
    //   287: ldiv
    //   288: invokevirtual 1014	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: new 24	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 1580
    //   307: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   314: getfield 659	com/tencent/mobileqq/statistics/StatisticCollector:mCurUin	Ljava/lang/String;
    //   317: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 511	java/lang/System:currentTimeMillis	()J
    //   326: ldc2_w 1577
    //   329: ldiv
    //   330: invokestatic 1583	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   333: ldc_w 1569
    //   336: iconst_0
    //   337: invokestatic 1587	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   340: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   343: invokevirtual 1590	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   346: aload 4
    //   348: ldc_w 1558
    //   351: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: ifeq +362 -> 716
    //   357: new 245	android/content/Intent
    //   360: dup
    //   361: ldc_w 1592
    //   364: invokespecial 1593	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   367: astore 5
    //   369: aload_3
    //   370: ldc 213
    //   372: invokevirtual 219	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   375: checkcast 221	android/app/ActivityManager
    //   378: invokevirtual 1597	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   381: astore 7
    //   383: new 935	java/util/ArrayList
    //   386: dup
    //   387: invokespecial 1598	java/util/ArrayList:<init>	()V
    //   390: astore 6
    //   392: aload 7
    //   394: ifnull +287 -> 681
    //   397: aload 7
    //   399: invokeinterface 229 1 0
    //   404: ifle +277 -> 681
    //   407: aload 7
    //   409: invokeinterface 173 1 0
    //   414: astore 7
    //   416: aload 7
    //   418: invokeinterface 178 1 0
    //   423: ifeq +258 -> 681
    //   426: aload 7
    //   428: invokeinterface 182 1 0
    //   433: checkcast 1600	android/app/ActivityManager$RunningAppProcessInfo
    //   436: getfield 1601	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   439: astore 8
    //   441: aload 8
    //   443: ifnull -27 -> 416
    //   446: aload 8
    //   448: ldc_w 1603
    //   451: invokevirtual 558	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   454: ifeq -38 -> 416
    //   457: aload 8
    //   459: ldc_w 1605
    //   462: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   465: ifne -49 -> 416
    //   468: aload 6
    //   470: aload 8
    //   472: invokevirtual 1608	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   475: pop
    //   476: goto -60 -> 416
    //   479: astore 5
    //   481: aload 5
    //   483: invokevirtual 1423	java/lang/Throwable:printStackTrace	()V
    //   486: aload 4
    //   488: ldc_w 1558
    //   491: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   494: ifeq +393 -> 887
    //   497: aload_0
    //   498: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   501: getfield 668	com/tencent/mobileqq/statistics/StatisticCollector:shouldStopMsf	Z
    //   504: ifeq +374 -> 878
    //   507: ldc 72
    //   509: iconst_1
    //   510: new 24	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   517: ldc_w 1610
    //   520: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_0
    //   524: getfield 15	com/tencent/mobileqq/statistics/BusinessCrashHandleListener:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   527: getfield 668	com/tencent/mobileqq/statistics/StatisticCollector:shouldStopMsf	Z
    //   530: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: ldc_w 1612
    //   536: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: aload_3
    //   546: ldc 213
    //   548: invokevirtual 219	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   551: checkcast 221	android/app/ActivityManager
    //   554: invokevirtual 1597	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   557: astore 4
    //   559: aload 4
    //   561: ifnull +261 -> 822
    //   564: aload 4
    //   566: invokeinterface 229 1 0
    //   571: ifle +251 -> 822
    //   574: aload 4
    //   576: invokeinterface 173 1 0
    //   581: astore 4
    //   583: aload 4
    //   585: invokeinterface 178 1 0
    //   590: ifeq +232 -> 822
    //   593: aload 4
    //   595: invokeinterface 182 1 0
    //   600: checkcast 1600	android/app/ActivityManager$RunningAppProcessInfo
    //   603: astore 5
    //   605: aload 5
    //   607: getfield 1601	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   610: astore 6
    //   612: aload 6
    //   614: ifnull -31 -> 583
    //   617: aload 6
    //   619: ldc_w 1603
    //   622: invokevirtual 558	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   625: ifeq -42 -> 583
    //   628: aload 6
    //   630: ldc_w 1605
    //   633: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   636: ifne -53 -> 583
    //   639: aload 5
    //   641: getfield 1615	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   644: invokestatic 1618	android/os/Process:killProcess	(I)V
    //   647: goto -64 -> 583
    //   650: astore_3
    //   651: aload_3
    //   652: invokevirtual 1423	java/lang/Throwable:printStackTrace	()V
    //   655: iconst_1
    //   656: ireturn
    //   657: astore 5
    //   659: aload 5
    //   661: invokevirtual 1423	java/lang/Throwable:printStackTrace	()V
    //   664: goto -536 -> 128
    //   667: astore 5
    //   669: ldc 72
    //   671: iconst_1
    //   672: ldc_w 1620
    //   675: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: goto -338 -> 340
    //   681: aload 5
    //   683: ldc_w 1622
    //   686: aload 6
    //   688: invokevirtual 1626	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   691: pop
    //   692: aload 5
    //   694: ldc_w 1628
    //   697: aload 6
    //   699: iconst_0
    //   700: invokestatic 1632	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   703: invokevirtual 1636	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   706: pop
    //   707: aload_3
    //   708: aload 5
    //   710: invokevirtual 952	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   713: goto -227 -> 486
    //   716: aload 4
    //   718: ldc_w 1045
    //   721: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   724: ifeq +69 -> 793
    //   727: aload_3
    //   728: ldc 213
    //   730: invokevirtual 219	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   733: checkcast 221	android/app/ActivityManager
    //   736: invokevirtual 1597	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   739: invokeinterface 173 1 0
    //   744: astore 5
    //   746: aload 5
    //   748: invokeinterface 178 1 0
    //   753: ifeq -267 -> 486
    //   756: aload 5
    //   758: invokeinterface 182 1 0
    //   763: checkcast 1600	android/app/ActivityManager$RunningAppProcessInfo
    //   766: astore 6
    //   768: aload 6
    //   770: getfield 1601	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   773: ldc_w 1638
    //   776: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   779: ifeq -33 -> 746
    //   782: aload 6
    //   784: getfield 1615	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   787: invokestatic 1618	android/os/Process:killProcess	(I)V
    //   790: goto -44 -> 746
    //   793: aload 4
    //   795: ldc_w 1640
    //   798: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   801: ifne -315 -> 486
    //   804: aload 4
    //   806: ldc_w 1642
    //   809: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   812: ifeq -326 -> 486
    //   815: aload_3
    //   816: invokestatic 1647	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   819: goto -333 -> 486
    //   822: aload_3
    //   823: ldc_w 616
    //   826: iconst_0
    //   827: invokevirtual 617	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   830: astore_3
    //   831: aload_3
    //   832: ldc_w 1649
    //   835: iconst_0
    //   836: invokeinterface 629 3 0
    //   841: istore_2
    //   842: aload_3
    //   843: invokeinterface 674 1 0
    //   848: ldc_w 1649
    //   851: iload_2
    //   852: iconst_1
    //   853: iadd
    //   854: invokeinterface 698 3 0
    //   859: invokeinterface 685 1 0
    //   864: pop
    //   865: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   868: iconst_1
    //   869: invokevirtual 1652	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   872: invokestatic 499	android/os/Process:myPid	()I
    //   875: invokestatic 1618	android/os/Process:killProcess	(I)V
    //   878: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   881: iconst_1
    //   882: invokevirtual 1655	com/tencent/common/app/BaseApplicationImpl:qqProcessExit	(Z)V
    //   885: iconst_1
    //   886: ireturn
    //   887: aload 4
    //   889: ldc_w 1045
    //   892: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   895: ifne +48 -> 943
    //   898: aload 4
    //   900: ldc_w 1657
    //   903: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   906: ifne +37 -> 943
    //   909: aload 4
    //   911: ldc_w 1640
    //   914: invokevirtual 865	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   917: ifne +26 -> 943
    //   920: aload 4
    //   922: ldc_w 1370
    //   925: invokevirtual 391	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   928: ifeq +6 -> 934
    //   931: goto +12 -> 943
    //   934: invokestatic 600	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   937: iconst_0
    //   938: invokevirtual 1660	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   941: iconst_1
    //   942: ireturn
    //   943: iload_1
    //   944: ifeq -899 -> 45
    //   947: goto -13 -> 934
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	950	0	this	BusinessCrashHandleListener
    //   0	950	1	paramBoolean	boolean
    //   841	13	2	i	int
    //   50	496	3	localContext	Context
    //   650	173	3	localThrowable1	Throwable
    //   830	13	3	localSharedPreferences	SharedPreferences
    //   109	812	4	localObject1	Object
    //   367	1	5	localIntent	Intent
    //   479	3	5	localThrowable2	Throwable
    //   603	37	5	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   657	3	5	localThrowable3	Throwable
    //   667	42	5	localThrowable4	Throwable
    //   744	13	5	localIterator	Iterator
    //   390	393	6	localObject2	Object
    //   381	46	7	localObject3	Object
    //   439	32	8	str	String
    // Exception table:
    //   from	to	target	type
    //   340	392	479	java/lang/Throwable
    //   397	416	479	java/lang/Throwable
    //   416	441	479	java/lang/Throwable
    //   446	476	479	java/lang/Throwable
    //   681	713	479	java/lang/Throwable
    //   716	746	479	java/lang/Throwable
    //   746	790	479	java/lang/Throwable
    //   793	819	479	java/lang/Throwable
    //   486	559	650	java/lang/Throwable
    //   564	583	650	java/lang/Throwable
    //   583	612	650	java/lang/Throwable
    //   617	647	650	java/lang/Throwable
    //   822	878	650	java/lang/Throwable
    //   878	885	650	java/lang/Throwable
    //   887	931	650	java/lang/Throwable
    //   934	941	650	java/lang/Throwable
    //   111	128	657	java/lang/Throwable
    //   128	157	667	java/lang/Throwable
    //   157	190	667	java/lang/Throwable
    //   190	200	667	java/lang/Throwable
    //   200	255	667	java/lang/Throwable
    //   255	340	667	java/lang/Throwable
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("BusinessCrashHandleListener", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + StatisticCollector.sHasCrashed + ", sIsFinalizeTimeoutException=" + StatisticCollector.sIsFinalizeTimeoutException);
    if ((StatisticCollector.sHasCrashed) && (!StatisticCollector.sIsFinalizeTimeoutException) && (!a(StatisticCollector.sCrashType, StatisticCollector.sCrashStack))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + ProcessUtil.a();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = this.a.stack.size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)this.a.stack.pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            StatisticCollector.sHasCrashed = true;
            break;
          }
        }
        this.a.stack.clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(this.a.mapEvent.toString());
        this.a.activityExtraInfo = localStringBuilder1.toString();
        this.a.threadInfo.append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    QLog.d("BusinessCrashHandleListener", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + StatisticCollector.simpleDateFormat.format(new Date(paramLong)) + ", curTime=" + StatisticCollector.simpleDateFormat.format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      StatisticCollector.sIsFinalizeTimeoutException = paramBoolean;
      if (!StatisticCollector.sIsFinalizeTimeoutException) {
        break;
      }
      return false;
    }
    try
    {
      if (a(paramString1, paramString3))
      {
        paramString2 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4).getString("key_not_exit_crash_stack", null);
        QLog.e("BusinessCrashHandleListener", 1, "CrashReport.setCrashFilter: " + paramString2);
        CrashReport.setCrashFilter(paramString2);
      }
      if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
        return false;
      }
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        QLog.e("BusinessCrashHandleListener", 1, "CrashReport.setCrashFilter Failed");
      }
      WebpSoLoader.a(paramString3);
      GifSoLoader.a(paramString3);
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).checkExceptionWhetherCauseByQCircle(paramString3);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.BusinessCrashHandleListener
 * JD-Core Version:    0.7.0.1
 */