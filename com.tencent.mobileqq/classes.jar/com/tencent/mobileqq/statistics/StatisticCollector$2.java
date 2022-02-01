package com.tencent.mobileqq.statistics;

import amxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.text.TextUtils;
import bfql;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
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
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import mqq.os.MqqMessage;
import mqq.os.MqqMessageQueue;
import vgw;

class StatisticCollector$2
  implements CrashHandleListener
{
  StatisticCollector$2(StatisticCollector paramStatisticCollector) {}
  
  private String formatMessageString(Message paramMessage)
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
  
  private void reportMainThreadMsgs(StringBuilder paramStringBuilder)
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
          break label450;
        }
        localObject3 = formatMessageString((Message)localObject1);
        String str;
        if (((HashMap)localObject2).containsKey(localObject3))
        {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject3)).intValue() + 1));
          i = 1;
          localObject3 = Class.forName("android.os.Message").getDeclaredField("next");
          ((Field)localObject3).setAccessible(true);
          localObject1 = (Message)((Field)localObject3).get(localObject1);
          if ((localObject1 == null) || (i > 100000)) {
            break label274;
          }
          str = formatMessageString((Message)localObject1);
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
        localObject1 = sortByValue((HashMap)localObject2);
      }
      catch (Throwable paramStringBuilder)
      {
        QLog.e("StatisticCollector", 1, "Fetch Main Thread's Messages faild", paramStringBuilder);
        return;
      }
      label274:
      paramStringBuilder.append("Main Thread has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("StatisticCollector", 1, "Main Thread has " + i + " Messages, and it's Top 50 Messages:");
      Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
      int i = j;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label448;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("StatisticCollector", 1, (String)localObject2);
        i += 1;
      }
      label448:
      continue;
      label450:
      i = 0;
    }
  }
  
  private void reportMqqMessages(StringBuilder paramStringBuilder)
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
        localObject4 = formatMessageString((Message)localField.get(localObject1));
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
      QLog.e("StatisticCollector", 1, "Fetch MqqMessageQueue's Messages faild", paramStringBuilder);
    }
    label353:
    for (;;)
    {
      localObject1 = sortByValue((HashMap)localObject2);
      paramStringBuilder.append("MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:\n");
      QLog.d("StatisticCollector", 1, "MqqMessageQueeu has " + i + " Messages, and it's Top 50 Messages:");
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label353;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          break;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey() + ", Count = " + ((Map.Entry)localObject2).getValue() + "\n";
        paramStringBuilder.append((String)localObject2);
        QLog.d("StatisticCollector", 1, (String)localObject2);
        i += 1;
      }
    }
  }
  
  private HashMap<String, Integer> sortByValue(HashMap<String, Integer> paramHashMap)
  {
    Object localObject = new LinkedList(paramHashMap.entrySet());
    Collections.sort((List)localObject, new StatisticCollector.2.1(this));
    paramHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramHashMap;
  }
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 164
    //   2: iconst_1
    //   3: new 20	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 271
    //   10: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 279
    //   20: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 281
    //   30: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_3
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 283
    //   40: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 4
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 285
    //   51: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload 5
    //   56: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc_w 287
    //   62: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokestatic 293	com/tencent/mobileqq/statistics/StatisticCollector:access$000	()Ljava/text/SimpleDateFormat;
    //   68: new 295	java/util/Date
    //   71: dup
    //   72: lload 6
    //   74: invokespecial 298	java/util/Date:<init>	(J)V
    //   77: invokevirtual 304	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   80: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_2
    //   90: invokestatic 308	com/tencent/mobileqq/statistics/StatisticCollector:access$302	(Ljava/lang/String;)Ljava/lang/String;
    //   93: pop
    //   94: aload 4
    //   96: invokestatic 311	com/tencent/mobileqq/statistics/StatisticCollector:access$402	(Ljava/lang/String;)Ljava/lang/String;
    //   99: pop
    //   100: iconst_1
    //   101: getstatic 316	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   104: if_icmpne +41 -> 145
    //   107: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   110: getstatic 326	com/tencent/mobileqq/statistics/StatisticCollector:sRdmInitTime	J
    //   113: lsub
    //   114: ldc2_w 327
    //   117: lcmp
    //   118: ifgt +27 -> 145
    //   121: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   124: new 20	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 338	aafi:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   145: iconst_1
    //   146: getstatic 316	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   149: if_icmpne +47 -> 196
    //   152: aload 4
    //   154: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +39 -> 196
    //   160: iload_1
    //   161: ifeq +14 -> 175
    //   164: aload 4
    //   166: ldc_w 346
    //   169: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   172: ifne +18 -> 190
    //   175: iload_1
    //   176: ifne +20 -> 196
    //   179: aload 4
    //   181: ldc_w 351
    //   184: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   187: ifeq +9 -> 196
    //   190: invokestatic 356	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:a	()Lcom/tencent/mobileqq/statistics/thread/SuspendThreadManager;
    //   193: invokevirtual 359	com/tencent/mobileqq/statistics/thread/SuspendThreadManager:b	()V
    //   196: getstatic 363	com/tencent/mobileqq/statistics/StatisticCollector:sFdDetectCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   199: ifnull +43 -> 242
    //   202: iload_1
    //   203: ifne +39 -> 242
    //   206: ldc_w 365
    //   209: aload_2
    //   210: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +29 -> 242
    //   216: aload_3
    //   217: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +22 -> 242
    //   223: aload_3
    //   224: ldc_w 370
    //   227: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +12 -> 242
    //   233: getstatic 363	com/tencent/mobileqq/statistics/StatisticCollector:sFdDetectCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   236: aload_2
    //   237: invokeinterface 375 2 0
    //   242: getstatic 379	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   245: ldc_w 381
    //   248: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   251: ifeq +31 -> 282
    //   254: new 20	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 387
    //   264: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 4
    //   273: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 391	akga:a	(Ljava/lang/String;)V
    //   282: aload 4
    //   284: ifnull +17 -> 301
    //   287: aload 4
    //   289: ldc_w 393
    //   292: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +6 -> 301
    //   298: invokestatic 396	bcfu:b	()V
    //   301: aload 4
    //   303: ifnull +120 -> 423
    //   306: aload 4
    //   308: ldc_w 398
    //   311: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   314: ifne +25 -> 339
    //   317: aload 4
    //   319: ldc_w 400
    //   322: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   325: ifne +14 -> 339
    //   328: aload 4
    //   330: ldc_w 402
    //   333: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   336: ifeq +87 -> 423
    //   339: iconst_0
    //   340: iconst_0
    //   341: invokestatic 407	com/tencent/mobileqq/statistics/FDNative:a	(ZZ)V
    //   344: new 90	java/util/HashMap
    //   347: dup
    //   348: invokespecial 91	java/util/HashMap:<init>	()V
    //   351: astore 11
    //   353: iload_1
    //   354: ifeq +1258 -> 1612
    //   357: ldc_w 409
    //   360: astore 10
    //   362: aload 11
    //   364: ldc_w 411
    //   367: aload 10
    //   369: invokevirtual 157	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: aload 11
    //   375: ldc_w 413
    //   378: aload_2
    //   379: invokevirtual 157	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: aload 11
    //   385: ldc_w 415
    //   388: getstatic 379	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   391: invokevirtual 157	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: pop
    //   395: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   398: invokestatic 419	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   401: aload_0
    //   402: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   405: getfield 422	com/tencent/mobileqq/statistics/StatisticCollector:mCurUin	Ljava/lang/String;
    //   408: ldc_w 424
    //   411: iconst_1
    //   412: lconst_0
    //   413: lconst_0
    //   414: aload 11
    //   416: ldc_w 426
    //   419: iconst_0
    //   420: invokevirtual 430	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   423: iload_1
    //   424: aload_2
    //   425: aload 4
    //   427: invokestatic 435	amiq:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   430: aload 4
    //   432: ifnull +104 -> 536
    //   435: aload 4
    //   437: ldc_w 437
    //   440: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   443: ifne +14 -> 457
    //   446: aload 4
    //   448: ldc_w 439
    //   451: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   454: ifeq +82 -> 536
    //   457: new 90	java/util/HashMap
    //   460: dup
    //   461: invokespecial 91	java/util/HashMap:<init>	()V
    //   464: astore 11
    //   466: iload_1
    //   467: ifeq +1153 -> 1620
    //   470: ldc_w 409
    //   473: astore 10
    //   475: aload 11
    //   477: ldc_w 411
    //   480: aload 10
    //   482: invokevirtual 157	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload 11
    //   488: ldc_w 413
    //   491: aload_2
    //   492: invokevirtual 157	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   495: pop
    //   496: aload 11
    //   498: ldc_w 415
    //   501: getstatic 379	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   504: invokevirtual 157	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   511: invokestatic 419	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   514: aload_0
    //   515: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   518: getfield 422	com/tencent/mobileqq/statistics/StatisticCollector:mCurUin	Ljava/lang/String;
    //   521: ldc_w 441
    //   524: iconst_1
    //   525: lconst_0
    //   526: lconst_0
    //   527: aload 11
    //   529: ldc_w 426
    //   532: iconst_0
    //   533: invokevirtual 430	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   536: iload_1
    //   537: aload_2
    //   538: aload_3
    //   539: aload 4
    //   541: iload 5
    //   543: lload 6
    //   545: invokestatic 446	bbzm:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V
    //   548: getstatic 452	com/tencent/mobileqq/app/BaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   551: ldc_w 454
    //   554: invokevirtual 458	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   557: ifeq +56 -> 613
    //   560: new 460	android/content/Intent
    //   563: dup
    //   564: invokespecial 461	android/content/Intent:<init>	()V
    //   567: astore 10
    //   569: aload 10
    //   571: ldc_w 463
    //   574: invokevirtual 467	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   577: pop
    //   578: aload 10
    //   580: invokestatic 473	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   583: invokevirtual 476	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   586: invokevirtual 479	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   589: pop
    //   590: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   593: aload 10
    //   595: invokevirtual 485	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   598: invokestatic 488	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +12 -> 613
    //   604: ldc 164
    //   606: iconst_2
    //   607: ldc_w 490
    //   610: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: getstatic 379	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   616: ldc_w 492
    //   619: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   622: ifeq +31 -> 653
    //   625: new 20	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 387
    //   635: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_2
    //   639: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload 4
    //   644: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 497	com/tencent/mobileqq/microapp/util/MiniAppCrashUtils:reportCrash	(Ljava/lang/String;)V
    //   653: aload 4
    //   655: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   658: ifne +139 -> 797
    //   661: aload 4
    //   663: ldc_w 499
    //   666: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   669: ifeq +128 -> 797
    //   672: new 501	org/json/JSONObject
    //   675: dup
    //   676: invokespecial 502	org/json/JSONObject:<init>	()V
    //   679: astore 10
    //   681: aload 10
    //   683: ldc_w 504
    //   686: iload_1
    //   687: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   690: pop
    //   691: aload 10
    //   693: ldc_w 509
    //   696: aload_2
    //   697: invokevirtual 512	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: aload 10
    //   703: ldc_w 514
    //   706: aload_3
    //   707: invokevirtual 512	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   710: pop
    //   711: aload 10
    //   713: ldc_w 516
    //   716: aload 4
    //   718: invokevirtual 512	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   721: pop
    //   722: aload 10
    //   724: ldc_w 518
    //   727: iload 5
    //   729: invokevirtual 521	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   732: pop
    //   733: aload 10
    //   735: ldc_w 523
    //   738: lload 6
    //   740: invokevirtual 526	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   743: pop
    //   744: getstatic 530	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   747: invokevirtual 534	com/tencent/common/app/BaseApplicationImpl:getClassLoader	()Ljava/lang/ClassLoader;
    //   750: astore 11
    //   752: aload 11
    //   754: ifnull +43 -> 797
    //   757: aload 11
    //   759: ldc_w 536
    //   762: invokevirtual 541	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   765: ldc_w 542
    //   768: iconst_1
    //   769: anewarray 45	java/lang/Class
    //   772: dup
    //   773: iconst_0
    //   774: ldc 213
    //   776: aastore
    //   777: invokevirtual 117	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   780: aconst_null
    //   781: iconst_1
    //   782: anewarray 4	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: aload 10
    //   789: invokevirtual 543	org/json/JSONObject:toString	()Ljava/lang/String;
    //   792: aastore
    //   793: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   796: pop
    //   797: aconst_null
    //   798: astore 11
    //   800: new 545	java/io/File
    //   803: dup
    //   804: ldc_w 547
    //   807: invokespecial 548	java/io/File:<init>	(Ljava/lang/String;)V
    //   810: astore 10
    //   812: aload 10
    //   814: ifnull +17 -> 831
    //   817: aload 10
    //   819: invokevirtual 551	java/io/File:exists	()Z
    //   822: ifne +9 -> 831
    //   825: aload 10
    //   827: invokevirtual 554	java/io/File:mkdirs	()Z
    //   830: pop
    //   831: new 556	java/io/FileWriter
    //   834: dup
    //   835: new 20	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 547
    //   845: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: lload 6
    //   850: invokevirtual 559	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   853: ldc_w 561
    //   856: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokespecial 562	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   865: astore 10
    //   867: new 20	java/lang/StringBuilder
    //   870: dup
    //   871: sipush 128
    //   874: invokespecial 23	java/lang/StringBuilder:<init>	(I)V
    //   877: astore 11
    //   879: aload 11
    //   881: invokestatic 293	com/tencent/mobileqq/statistics/StatisticCollector:access$000	()Ljava/text/SimpleDateFormat;
    //   884: new 295	java/util/Date
    //   887: dup
    //   888: lload 6
    //   890: invokespecial 298	java/util/Date:<init>	(J)V
    //   893: invokevirtual 304	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   896: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: ldc 220
    //   901: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload_2
    //   905: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: ldc 220
    //   910: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload 4
    //   915: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: aload 10
    //   921: aload 11
    //   923: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokevirtual 565	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   929: aload 10
    //   931: invokevirtual 568	java/io/FileWriter:flush	()V
    //   934: aload 10
    //   936: ifnull +8 -> 944
    //   939: aload 10
    //   941: invokevirtual 571	java/io/FileWriter:close	()V
    //   944: aload_2
    //   945: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   948: ifne +47 -> 995
    //   951: aload_2
    //   952: ldc_w 573
    //   955: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   958: ifeq +37 -> 995
    //   961: invokestatic 578	com/tencent/mobileqq/app/MemoryManager:getInstance	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   964: invokevirtual 581	com/tencent/mobileqq/app/MemoryManager:onOOMCrash	()V
    //   967: aload 4
    //   969: ldc_w 583
    //   972: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   975: ifne +20 -> 995
    //   978: aload 4
    //   980: ldc_w 585
    //   983: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   986: ifne +9 -> 995
    //   989: invokestatic 590	aafp:a	()Laafp;
    //   992: invokevirtual 592	aafp:a	()V
    //   995: getstatic 379	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   998: astore 14
    //   1000: iload_1
    //   1001: ifeq +39 -> 1040
    //   1004: aload 14
    //   1006: ldc_w 594
    //   1009: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1012: ifne +14 -> 1026
    //   1015: aload 14
    //   1017: ldc_w 596
    //   1020: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1023: ifeq +17 -> 1040
    //   1026: ldc_w 598
    //   1029: iconst_1
    //   1030: aload 4
    //   1032: invokestatic 600	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload 4
    //   1037: invokestatic 605	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   1040: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   1043: invokestatic 610	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   1046: new 20	java/lang/StringBuilder
    //   1049: dup
    //   1050: sipush 128
    //   1053: invokespecial 23	java/lang/StringBuilder:<init>	(I)V
    //   1056: astore 13
    //   1058: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   1061: ldc_w 612
    //   1064: invokestatic 617	abvr:a	(Landroid/content/Context;Ljava/lang/String;)Labvq;
    //   1067: astore 10
    //   1069: aload 13
    //   1071: ldc_w 619
    //   1074: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload 13
    //   1080: ldc_w 621
    //   1083: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 13
    //   1089: ldc_w 623
    //   1092: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: getstatic 626	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   1098: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 13
    //   1104: ldc_w 628
    //   1107: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: getstatic 631	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   1113: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload 13
    //   1119: ldc_w 633
    //   1122: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: getstatic 636	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   1128: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: aload 13
    //   1134: ldc_w 638
    //   1137: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: getstatic 641	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   1143: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 13
    //   1149: ldc_w 643
    //   1152: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: getstatic 647	bcad:b	I
    //   1158: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 13
    //   1164: ldc_w 649
    //   1167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: astore 11
    //   1172: aload 10
    //   1174: ifnull +510 -> 1684
    //   1177: aload 10
    //   1179: invokevirtual 653	abvq:a	()Z
    //   1182: ifeq +502 -> 1684
    //   1185: iconst_1
    //   1186: istore 9
    //   1188: aload 11
    //   1190: iload 9
    //   1192: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1195: ldc_w 655
    //   1198: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: getstatic 659	abvg:jdField_a_of_type_Int	I
    //   1204: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1207: ldc_w 661
    //   1210: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: getstatic 664	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   1216: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: ldc_w 666
    //   1222: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: getstatic 668	abvg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1228: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 13
    //   1234: ldc_w 670
    //   1237: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: invokestatic 676	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1243: invokevirtual 679	java/lang/Runtime:maxMemory	()J
    //   1246: invokevirtual 559	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1249: ldc_w 681
    //   1252: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: invokestatic 676	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1258: invokevirtual 684	java/lang/Runtime:totalMemory	()J
    //   1261: invokestatic 676	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1264: invokevirtual 687	java/lang/Runtime:freeMemory	()J
    //   1267: lsub
    //   1268: invokevirtual 559	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 13
    //   1274: ldc_w 689
    //   1277: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: invokestatic 578	com/tencent/mobileqq/app/MemoryManager:getInstance	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1283: invokevirtual 692	com/tencent/mobileqq/app/MemoryManager:getActivityLeakCount	()I
    //   1286: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1289: ldc_w 694
    //   1292: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: invokestatic 578	com/tencent/mobileqq/app/MemoryManager:getInstance	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1298: invokevirtual 697	com/tencent/mobileqq/app/MemoryManager:getQQAppLeakCount	()I
    //   1301: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1304: ldc_w 699
    //   1307: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: invokestatic 578	com/tencent/mobileqq/app/MemoryManager:getInstance	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   1313: invokevirtual 702	com/tencent/mobileqq/app/MemoryManager:getOtherLeakCount	()I
    //   1316: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload 13
    //   1322: ldc_w 704
    //   1325: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: invokestatic 709	bcer:a	()Lbcer;
    //   1331: invokevirtual 711	bcer:a	()Ljava/lang/String;
    //   1334: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: getstatic 715	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1341: ifnull +21 -> 1362
    //   1344: aload 13
    //   1346: ldc_w 717
    //   1349: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: getstatic 715	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   1355: invokevirtual 722	android/support/v4/util/MQLruCache:size	()I
    //   1358: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: invokestatic 676	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1365: invokevirtual 679	java/lang/Runtime:maxMemory	()J
    //   1368: invokestatic 676	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1371: invokevirtual 684	java/lang/Runtime:totalMemory	()J
    //   1374: lsub
    //   1375: l2f
    //   1376: fconst_1
    //   1377: fmul
    //   1378: invokestatic 676	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   1381: invokevirtual 679	java/lang/Runtime:maxMemory	()J
    //   1384: l2f
    //   1385: fdiv
    //   1386: f2d
    //   1387: ldc2_w 723
    //   1390: dcmpl
    //   1391: iflt +29 -> 1420
    //   1394: aload_2
    //   1395: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1398: ifne +22 -> 1420
    //   1401: aload_2
    //   1402: ldc_w 573
    //   1405: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1408: ifeq +12 -> 1420
    //   1411: aload_0
    //   1412: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1415: aload 13
    //   1417: invokevirtual 727	com/tencent/mobileqq/statistics/StatisticCollector:dumpThreadInfo	(Ljava/lang/StringBuilder;)V
    //   1420: aload 13
    //   1422: ldc_w 729
    //   1425: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: getstatic 734	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   1431: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: getstatic 739	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   1438: astore 10
    //   1440: aload 10
    //   1442: ifnull +56 -> 1498
    //   1445: aload 10
    //   1447: arraylength
    //   1448: iconst_3
    //   1449: if_icmplt +49 -> 1498
    //   1452: aload 13
    //   1454: ldc_w 741
    //   1457: iconst_3
    //   1458: anewarray 4	java/lang/Object
    //   1461: dup
    //   1462: iconst_0
    //   1463: aload 10
    //   1465: iconst_0
    //   1466: iaload
    //   1467: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1470: aastore
    //   1471: dup
    //   1472: iconst_1
    //   1473: aload 10
    //   1475: iconst_1
    //   1476: iaload
    //   1477: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1480: aastore
    //   1481: dup
    //   1482: iconst_2
    //   1483: aload 10
    //   1485: iconst_2
    //   1486: iaload
    //   1487: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1490: aastore
    //   1491: invokestatic 744	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1494: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: aload 13
    //   1500: ldc 220
    //   1502: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: aconst_null
    //   1507: astore 11
    //   1509: new 746	java/io/BufferedReader
    //   1512: dup
    //   1513: new 748	java/io/FileReader
    //   1516: dup
    //   1517: ldc_w 750
    //   1520: invokespecial 751	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   1523: invokespecial 754	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1526: astore 10
    //   1528: aload 10
    //   1530: invokevirtual 757	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1533: astore 11
    //   1535: aload 13
    //   1537: ldc 220
    //   1539: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: aload 11
    //   1545: ifnull +145 -> 1690
    //   1548: aload 11
    //   1550: ldc_w 759
    //   1553: invokevirtual 762	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1556: ifne +14 -> 1570
    //   1559: aload 11
    //   1561: ldc_w 764
    //   1564: invokevirtual 762	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1567: ifeq +35 -> 1602
    //   1570: aload 11
    //   1572: ldc_w 766
    //   1575: ldc_w 426
    //   1578: invokevirtual 770	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1581: pop
    //   1582: aload 13
    //   1584: aload 11
    //   1586: invokevirtual 773	java/lang/String:trim	()Ljava/lang/String;
    //   1589: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload 13
    //   1595: ldc_w 775
    //   1598: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: pop
    //   1602: aload 10
    //   1604: invokevirtual 757	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1607: astore 11
    //   1609: goto -66 -> 1543
    //   1612: ldc_w 777
    //   1615: astore 10
    //   1617: goto -1255 -> 362
    //   1620: ldc_w 777
    //   1623: astore 10
    //   1625: goto -1150 -> 475
    //   1628: astore 10
    //   1630: aload 10
    //   1632: invokevirtual 780	java/lang/Throwable:printStackTrace	()V
    //   1635: goto -838 -> 797
    //   1638: astore 12
    //   1640: aload 11
    //   1642: astore 10
    //   1644: aload 12
    //   1646: astore 11
    //   1648: aload 11
    //   1650: invokevirtual 781	java/lang/Exception:printStackTrace	()V
    //   1653: aload 10
    //   1655: ifnull -711 -> 944
    //   1658: aload 10
    //   1660: invokevirtual 571	java/io/FileWriter:close	()V
    //   1663: goto -719 -> 944
    //   1666: astore 10
    //   1668: goto -724 -> 944
    //   1671: astore_2
    //   1672: aconst_null
    //   1673: astore_3
    //   1674: aload_3
    //   1675: ifnull +7 -> 1682
    //   1678: aload_3
    //   1679: invokevirtual 571	java/io/FileWriter:close	()V
    //   1682: aload_2
    //   1683: athrow
    //   1684: iconst_0
    //   1685: istore 9
    //   1687: goto -499 -> 1188
    //   1690: aload 13
    //   1692: ldc 220
    //   1694: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: pop
    //   1698: aload 10
    //   1700: ifnull +8 -> 1708
    //   1703: aload 10
    //   1705: invokevirtual 782	java/io/BufferedReader:close	()V
    //   1708: invokestatic 787	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   1711: invokevirtual 790	com/tencent/mfsdk/MagnifierSDK:a	()Lachq;
    //   1714: invokeinterface 794 1 0
    //   1719: astore 11
    //   1721: invokestatic 800	com/tencent/mobileqq/utils/DeviceInfoUtil:getRomMemroy	()[J
    //   1724: astore 12
    //   1726: aload 13
    //   1728: invokestatic 803	com/tencent/mobileqq/utils/DeviceInfoUtil:getResolutionString	()Ljava/lang/String;
    //   1731: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1734: ldc 220
    //   1736: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: pop
    //   1740: aload 11
    //   1742: astore 10
    //   1744: aload 11
    //   1746: ifnonnull +8 -> 1754
    //   1749: ldc_w 805
    //   1752: astore 10
    //   1754: aload 13
    //   1756: aload 10
    //   1758: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: ldc 220
    //   1763: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: pop
    //   1767: aload 13
    //   1769: ldc_w 807
    //   1772: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: aload 12
    //   1777: iconst_0
    //   1778: laload
    //   1779: invokevirtual 559	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1782: ldc_w 809
    //   1785: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: aload 12
    //   1790: iconst_1
    //   1791: laload
    //   1792: invokevirtual 559	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1795: ldc_w 811
    //   1798: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: pop
    //   1802: aload_0
    //   1803: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1806: invokestatic 815	com/tencent/mobileqq/statistics/StatisticCollector:access$800	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   1809: ifnonnull +1066 -> 2875
    //   1812: ldc_w 805
    //   1815: astore 10
    //   1817: aload 13
    //   1819: aload 10
    //   1821: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: ldc 220
    //   1826: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: pop
    //   1830: aload 13
    //   1832: new 20	java/lang/StringBuilder
    //   1835: dup
    //   1836: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1839: ldc_w 817
    //   1842: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: getstatic 822	mqq/app/Foreground:sCountResume	I
    //   1848: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1851: ldc 220
    //   1853: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1859: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: pop
    //   1863: aload 13
    //   1865: ldc_w 824
    //   1868: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: getstatic 827	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   1874: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1877: ldc 220
    //   1879: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: pop
    //   1883: getstatic 831	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1886: astore 10
    //   1888: aload 10
    //   1890: instanceof 826
    //   1893: ifeq +32 -> 1925
    //   1896: aload 10
    //   1898: checkcast 826	com/tencent/mobileqq/activity/SplashActivity
    //   1901: astore 10
    //   1903: aload 13
    //   1905: ldc_w 833
    //   1908: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: aload 10
    //   1913: invokevirtual 835	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   1916: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1919: ldc 220
    //   1921: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: pop
    //   1925: getstatic 838	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1928: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1931: ifne +23 -> 1954
    //   1934: aload 13
    //   1936: ldc_w 840
    //   1939: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: getstatic 838	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1945: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: ldc 220
    //   1950: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: pop
    //   1954: getstatic 843	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1957: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1960: ifne +23 -> 1983
    //   1963: aload 13
    //   1965: ldc_w 845
    //   1968: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: getstatic 843	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1974: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: ldc 220
    //   1979: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: pop
    //   1983: getstatic 848	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   1986: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1989: ifne +23 -> 2012
    //   1992: aload 13
    //   1994: ldc_w 850
    //   1997: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: getstatic 848	com/tencent/common/app/BaseApplicationImpl:ASanEscapedMsg	Ljava/lang/String;
    //   2003: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: ldc 220
    //   2008: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: pop
    //   2012: aload 13
    //   2014: new 20	java/lang/StringBuilder
    //   2017: dup
    //   2018: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2021: ldc_w 852
    //   2024: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: invokestatic 857	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2030: ldc_w 859
    //   2033: ldc_w 861
    //   2036: iconst_1
    //   2037: invokevirtual 865	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   2040: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2043: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2046: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: new 20	java/lang/StringBuilder
    //   2052: dup
    //   2053: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2056: ldc_w 867
    //   2059: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: invokestatic 857	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2065: ldc_w 859
    //   2068: ldc_w 869
    //   2071: iconst_0
    //   2072: invokevirtual 872	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2075: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2078: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2081: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: new 20	java/lang/StringBuilder
    //   2087: dup
    //   2088: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2091: ldc_w 874
    //   2094: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2097: invokestatic 857	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   2100: ldc_w 859
    //   2103: ldc_w 876
    //   2106: iconst_0
    //   2107: invokevirtual 872	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2110: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2113: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2116: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: ldc 220
    //   2121: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: pop
    //   2125: invokestatic 877	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2128: invokestatic 882	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   2131: invokevirtual 885	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getUndetachThreads	()Ljava/lang/String;
    //   2134: astore 10
    //   2136: aload 10
    //   2138: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2141: ifne +11 -> 2152
    //   2144: aload 13
    //   2146: aload 10
    //   2148: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: pop
    //   2152: aload 13
    //   2154: aload_0
    //   2155: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2158: invokestatic 889	com/tencent/mobileqq/statistics/StatisticCollector:access$1300	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   2161: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2164: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: pop
    //   2168: aload 13
    //   2170: aload_0
    //   2171: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2174: invokestatic 892	com/tencent/mobileqq/statistics/StatisticCollector:access$900	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   2177: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2180: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: pop
    //   2184: getstatic 895	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2187: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2190: ifne +51 -> 2241
    //   2193: getstatic 900	android/os/Build$VERSION:SDK_INT	I
    //   2196: bipush 8
    //   2198: if_icmplt +43 -> 2241
    //   2201: aload 13
    //   2203: new 20	java/lang/StringBuilder
    //   2206: dup
    //   2207: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2210: ldc_w 902
    //   2213: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: getstatic 895	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   2219: invokevirtual 906	java/lang/String:getBytes	()[B
    //   2222: iconst_0
    //   2223: invokestatic 912	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   2226: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: ldc 220
    //   2231: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2237: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: pop
    //   2241: aload 13
    //   2243: invokestatic 917	cooperation/qzone/RDMEtraMsgCollector:getInstance	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   2246: invokevirtual 920	cooperation/qzone/RDMEtraMsgCollector:getEtraMsg	()Ljava/lang/String;
    //   2249: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: pop
    //   2253: aload 13
    //   2255: ldc 220
    //   2257: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2260: pop
    //   2261: aload_0
    //   2262: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2265: invokestatic 924	com/tencent/mobileqq/statistics/StatisticCollector:access$1400	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   2268: invokevirtual 925	java/util/LinkedList:size	()I
    //   2271: ifle +30 -> 2301
    //   2274: aload 13
    //   2276: aload_0
    //   2277: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2280: invokestatic 924	com/tencent/mobileqq/statistics/StatisticCollector:access$1400	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   2283: invokevirtual 928	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   2286: checkcast 930	com/tencent/mobileqq/statistics/StatisticCollector$ContextLog
    //   2289: invokevirtual 931	com/tencent/mobileqq/statistics/StatisticCollector$ContextLog:toString	()Ljava/lang/String;
    //   2292: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2295: pop
    //   2296: goto -35 -> 2261
    //   2299: astore 10
    //   2301: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   2304: invokestatic 937	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   2307: istore 5
    //   2309: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   2312: invokestatic 942	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   2315: istore 8
    //   2317: aload 13
    //   2319: bipush 10
    //   2321: invokevirtual 945	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2324: ldc_w 947
    //   2327: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: astore 11
    //   2332: iload 8
    //   2334: ifne +553 -> 2887
    //   2337: ldc_w 949
    //   2340: astore 10
    //   2342: aload 11
    //   2344: aload 10
    //   2346: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2349: ldc_w 951
    //   2352: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: iload 5
    //   2357: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2360: ldc_w 953
    //   2363: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: iload 8
    //   2368: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2371: pop
    //   2372: aload 13
    //   2374: ldc_w 955
    //   2377: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   2383: invokestatic 958	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   2386: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2389: pop
    //   2390: aload 13
    //   2392: ldc_w 960
    //   2395: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: invokestatic 293	com/tencent/mobileqq/statistics/StatisticCollector:access$000	()Ljava/text/SimpleDateFormat;
    //   2401: new 295	java/util/Date
    //   2404: dup
    //   2405: getstatic 962	aafi:a	J
    //   2408: invokespecial 298	java/util/Date:<init>	(J)V
    //   2411: invokevirtual 304	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2414: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2417: pop
    //   2418: aload 13
    //   2420: ldc_w 964
    //   2423: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2426: invokestatic 293	com/tencent/mobileqq/statistics/StatisticCollector:access$000	()Ljava/text/SimpleDateFormat;
    //   2429: new 295	java/util/Date
    //   2432: dup
    //   2433: getstatic 966	aafi:b	J
    //   2436: invokespecial 298	java/util/Date:<init>	(J)V
    //   2439: invokevirtual 304	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2442: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2445: ldc 220
    //   2447: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2450: pop
    //   2451: iload_1
    //   2452: ifeq +103 -> 2555
    //   2455: aload 14
    //   2457: ldc_w 594
    //   2460: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2463: ifne +25 -> 2488
    //   2466: aload 14
    //   2468: ldc_w 596
    //   2471: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2474: ifne +14 -> 2488
    //   2477: aload 14
    //   2479: ldc_w 381
    //   2482: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2485: ifeq +70 -> 2555
    //   2488: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   2491: ldc 164
    //   2493: iconst_4
    //   2494: invokevirtual 970	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2497: ldc_w 972
    //   2500: aconst_null
    //   2501: invokeinterface 977 3 0
    //   2506: astore 10
    //   2508: aload 13
    //   2510: ldc_w 979
    //   2513: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: aload 10
    //   2518: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: pop
    //   2522: invokestatic 488	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2525: ifeq +30 -> 2555
    //   2528: ldc 164
    //   2530: iconst_2
    //   2531: new 20	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2538: ldc_w 981
    //   2541: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: aload 10
    //   2546: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2552: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2555: aload 14
    //   2557: ldc_w 983
    //   2560: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2563: ifne +80 -> 2643
    //   2566: aload 14
    //   2568: ldc_w 985
    //   2571: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2574: ifne +69 -> 2643
    //   2577: aload 14
    //   2579: ldc_w 987
    //   2582: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2585: ifne +58 -> 2643
    //   2588: aload 14
    //   2590: ldc_w 989
    //   2593: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2596: ifne +47 -> 2643
    //   2599: aload 14
    //   2601: ldc_w 991
    //   2604: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2607: ifne +36 -> 2643
    //   2610: aload 14
    //   2612: ldc_w 993
    //   2615: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2618: ifne +25 -> 2643
    //   2621: aload 14
    //   2623: ldc_w 995
    //   2626: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2629: ifne +14 -> 2643
    //   2632: aload 14
    //   2634: ldc_w 997
    //   2637: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2640: ifeq +60 -> 2700
    //   2643: invokestatic 1002	cooperation/qzone/minigame/MiniAppInfoReportManager:getMiniAppInfo	()Ljava/lang/String;
    //   2646: astore 10
    //   2648: aload 10
    //   2650: ifnull +50 -> 2700
    //   2653: aload 13
    //   2655: ldc_w 1004
    //   2658: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2661: aload 10
    //   2663: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2666: pop
    //   2667: invokestatic 488	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2670: ifeq +30 -> 2700
    //   2673: ldc 164
    //   2675: iconst_2
    //   2676: new 20	java/lang/StringBuilder
    //   2679: dup
    //   2680: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2683: ldc_w 1006
    //   2686: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: aload 10
    //   2691: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2694: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2697: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2700: aload 13
    //   2702: ldc_w 1008
    //   2705: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2708: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2711: getfield 1015	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   2714: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: pop
    //   2718: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2721: getfield 1019	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2724: ifnull +193 -> 2917
    //   2727: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2730: getfield 1019	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2733: invokeinterface 1023 1 0
    //   2738: ifne +179 -> 2917
    //   2741: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2744: getfield 1019	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   2747: invokeinterface 1024 1 0
    //   2752: astore 10
    //   2754: aload 10
    //   2756: invokeinterface 203 1 0
    //   2761: ifeq +156 -> 2917
    //   2764: aload 10
    //   2766: invokeinterface 206 1 0
    //   2771: checkcast 1026	android/util/Pair
    //   2774: astore 11
    //   2776: aload 11
    //   2778: ifnull -24 -> 2754
    //   2781: aload 13
    //   2783: ldc_w 1028
    //   2786: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2789: invokestatic 293	com/tencent/mobileqq/statistics/StatisticCollector:access$000	()Ljava/text/SimpleDateFormat;
    //   2792: new 295	java/util/Date
    //   2795: dup
    //   2796: aload 11
    //   2798: getfield 1031	android/util/Pair:first	Ljava/lang/Object;
    //   2801: checkcast 1033	java/lang/Long
    //   2804: invokevirtual 1036	java/lang/Long:longValue	()J
    //   2807: invokespecial 298	java/util/Date:<init>	(J)V
    //   2810: invokevirtual 304	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2813: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: ldc_w 1038
    //   2819: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2822: aload 11
    //   2824: getfield 1041	android/util/Pair:second	Ljava/lang/Object;
    //   2827: checkcast 213	java/lang/String
    //   2830: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2833: pop
    //   2834: goto -80 -> 2754
    //   2837: astore 10
    //   2839: aconst_null
    //   2840: astore 10
    //   2842: aload 10
    //   2844: ifnull -1136 -> 1708
    //   2847: aload 10
    //   2849: invokevirtual 782	java/io/BufferedReader:close	()V
    //   2852: goto -1144 -> 1708
    //   2855: astore 10
    //   2857: goto -1149 -> 1708
    //   2860: astore 10
    //   2862: aload 11
    //   2864: ifnull +8 -> 2872
    //   2867: aload 11
    //   2869: invokevirtual 782	java/io/BufferedReader:close	()V
    //   2872: aload 10
    //   2874: athrow
    //   2875: aload_0
    //   2876: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2879: invokestatic 815	com/tencent/mobileqq/statistics/StatisticCollector:access$800	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   2882: astore 10
    //   2884: goto -1067 -> 1817
    //   2887: ldc_w 1043
    //   2890: astore 10
    //   2892: goto -550 -> 2342
    //   2895: astore 10
    //   2897: invokestatic 488	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2900: ifeq -200 -> 2700
    //   2903: ldc 164
    //   2905: iconst_2
    //   2906: ldc_w 1045
    //   2909: aload 10
    //   2911: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2914: goto -214 -> 2700
    //   2917: getstatic 1048	bijm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2920: astore 10
    //   2922: aload 10
    //   2924: ifnull +25 -> 2949
    //   2927: aload 10
    //   2929: invokevirtual 1051	java/lang/String:length	()I
    //   2932: ifle +17 -> 2949
    //   2935: aload 13
    //   2937: ldc_w 1053
    //   2940: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2943: aload 10
    //   2945: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2948: pop
    //   2949: aload_2
    //   2950: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2953: ifne +49 -> 3002
    //   2956: aload_2
    //   2957: ldc_w 1055
    //   2960: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2963: ifeq +39 -> 3002
    //   2966: aload 4
    //   2968: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2971: ifne +31 -> 3002
    //   2974: aload 4
    //   2976: ldc_w 1057
    //   2979: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2982: ifeq +20 -> 3002
    //   2985: aload 13
    //   2987: ldc_w 1059
    //   2990: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2993: pop
    //   2994: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2997: aload 13
    //   2999: invokestatic 1063	com/tencent/mobileqq/statistics/StatisticCollector:appendReceiverInfo	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   3002: ldc_w 1065
    //   3005: aload_2
    //   3006: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3009: ifeq +22 -> 3031
    //   3012: aload 4
    //   3014: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3017: ifne +14 -> 3031
    //   3020: aload 4
    //   3022: ldc_w 1067
    //   3025: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3028: ifne +32 -> 3060
    //   3031: ldc_w 1069
    //   3034: aload_2
    //   3035: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3038: ifeq +40 -> 3078
    //   3041: aload 4
    //   3043: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3046: ifne +32 -> 3078
    //   3049: aload 4
    //   3051: ldc_w 1071
    //   3054: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3057: ifeq +21 -> 3078
    //   3060: aload 13
    //   3062: ldc_w 1073
    //   3065: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3068: ldc_w 1075
    //   3071: invokestatic 1080	com/tencent/mobileqq/util/SystemUtil:getSystemProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   3074: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3077: pop
    //   3078: ldc_w 1082
    //   3081: aload_2
    //   3082: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3085: ifne +66 -> 3151
    //   3088: ldc_w 365
    //   3091: aload_2
    //   3092: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3095: ifeq +14 -> 3109
    //   3098: aload 4
    //   3100: ldc_w 1084
    //   3103: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3106: ifne +45 -> 3151
    //   3109: ldc_w 1086
    //   3112: aload_2
    //   3113: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3116: ifeq +14 -> 3130
    //   3119: aload 4
    //   3121: ldc_w 1088
    //   3124: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3127: ifne +24 -> 3151
    //   3130: ldc_w 365
    //   3133: aload_2
    //   3134: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3137: ifeq +94 -> 3231
    //   3140: aload 4
    //   3142: ldc_w 1090
    //   3145: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3148: ifeq +83 -> 3231
    //   3151: invokestatic 293	com/tencent/mobileqq/statistics/StatisticCollector:access$000	()Ljava/text/SimpleDateFormat;
    //   3154: new 295	java/util/Date
    //   3157: dup
    //   3158: getstatic 1093	com/tencent/mobileqq/statistics/StatisticCollector:FDMillisLastChecked	J
    //   3161: invokespecial 298	java/util/Date:<init>	(J)V
    //   3164: invokevirtual 304	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3167: astore 4
    //   3169: aload 13
    //   3171: ldc_w 1095
    //   3174: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: getstatic 1098	com/tencent/mobileqq/statistics/StatisticCollector:FDCountLastChecked	I
    //   3180: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3183: ldc_w 1100
    //   3186: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3189: aload 4
    //   3191: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3194: pop
    //   3195: aload 13
    //   3197: ldc_w 1102
    //   3200: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3203: pop
    //   3204: aload 13
    //   3206: invokestatic 1105	com/tencent/mobileqq/statistics/StatisticCollector:access$1500	()Ljava/lang/String;
    //   3209: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3212: pop
    //   3213: aload 13
    //   3215: ldc_w 1107
    //   3218: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3221: pop
    //   3222: aload 13
    //   3224: invokestatic 1112	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   3227: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3230: pop
    //   3231: iconst_1
    //   3232: getstatic 316	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   3235: if_icmpne +49 -> 3284
    //   3238: aload_3
    //   3239: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3242: ifne +42 -> 3284
    //   3245: aload_2
    //   3246: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3249: ifne +35 -> 3284
    //   3252: aload_2
    //   3253: ldc_w 1114
    //   3256: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3259: ifeq +25 -> 3284
    //   3262: aload_3
    //   3263: ldc_w 1116
    //   3266: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3269: ifeq +15 -> 3284
    //   3272: aload_0
    //   3273: aload 13
    //   3275: invokespecial 1118	com/tencent/mobileqq/statistics/StatisticCollector$2:reportMainThreadMsgs	(Ljava/lang/StringBuilder;)V
    //   3278: aload_0
    //   3279: aload 13
    //   3281: invokespecial 1120	com/tencent/mobileqq/statistics/StatisticCollector$2:reportMqqMessages	(Ljava/lang/StringBuilder;)V
    //   3284: aload 13
    //   3286: new 20	java/lang/StringBuilder
    //   3289: dup
    //   3290: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3293: ldc_w 1122
    //   3296: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3299: invokestatic 877	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3302: ldc_w 1124
    //   3305: invokestatic 1129	bfwv:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   3308: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3311: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3314: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: pop
    //   3318: aload 13
    //   3320: new 20	java/lang/StringBuilder
    //   3323: dup
    //   3324: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3327: ldc_w 1131
    //   3330: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3333: invokestatic 1134	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	()I
    //   3336: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3339: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: pop
    //   3346: ldc 164
    //   3348: iconst_1
    //   3349: new 20	java/lang/StringBuilder
    //   3352: dup
    //   3353: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3356: ldc_w 1136
    //   3359: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3362: aload 13
    //   3364: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3367: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3370: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3373: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3376: aload 13
    //   3378: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3381: areturn
    //   3382: astore_2
    //   3383: aload 13
    //   3385: ldc_w 1138
    //   3388: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3391: pop
    //   3392: goto -46 -> 3346
    //   3395: astore 10
    //   3397: goto -2453 -> 944
    //   3400: astore_3
    //   3401: goto -1719 -> 1682
    //   3404: astore 10
    //   3406: goto -1698 -> 1708
    //   3409: astore 11
    //   3411: goto -539 -> 2872
    //   3414: astore 10
    //   3416: goto -338 -> 3078
    //   3419: astore 10
    //   3421: goto -472 -> 2949
    //   3424: astore 10
    //   3426: goto -975 -> 2451
    //   3429: astore 10
    //   3431: goto -1041 -> 2390
    //   3434: astore 12
    //   3436: aload 10
    //   3438: astore 11
    //   3440: aload 12
    //   3442: astore 10
    //   3444: goto -582 -> 2862
    //   3447: astore 11
    //   3449: goto -607 -> 2842
    //   3452: astore_2
    //   3453: aload 10
    //   3455: astore_3
    //   3456: goto -1782 -> 1674
    //   3459: astore_2
    //   3460: aload 10
    //   3462: astore_3
    //   3463: goto -1789 -> 1674
    //   3466: astore 11
    //   3468: goto -1820 -> 1648
    //   3471: astore 10
    //   3473: goto -1212 -> 2261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3476	0	this	2
    //   0	3476	1	paramBoolean	boolean
    //   0	3476	2	paramString1	String
    //   0	3476	3	paramString2	String
    //   0	3476	4	paramString3	String
    //   0	3476	5	paramInt	int
    //   0	3476	6	paramLong	long
    //   2315	52	8	i	int
    //   1186	500	9	bool	boolean
    //   360	1264	10	localObject1	Object
    //   1628	3	10	localThrowable1	Throwable
    //   1642	17	10	localObject2	Object
    //   1666	38	10	localException1	java.lang.Exception
    //   1742	405	10	localObject3	Object
    //   2299	1	10	localThrowable2	Throwable
    //   2340	425	10	localObject4	Object
    //   2837	1	10	localThrowable3	Throwable
    //   2840	8	10	localObject5	Object
    //   2855	1	10	localThrowable4	Throwable
    //   2860	13	10	localObject6	Object
    //   2882	9	10	str1	String
    //   2895	15	10	localThrowable5	Throwable
    //   2920	24	10	str2	String
    //   3395	1	10	localException2	java.lang.Exception
    //   3404	1	10	localThrowable6	Throwable
    //   3414	1	10	localThrowable7	Throwable
    //   3419	1	10	localThrowable8	Throwable
    //   3424	1	10	localThrowable9	Throwable
    //   3429	8	10	localThrowable10	Throwable
    //   3442	19	10	localObject7	Object
    //   3471	1	10	localThrowable11	Throwable
    //   351	2517	11	localObject8	Object
    //   3409	1	11	localThrowable12	Throwable
    //   3438	1	11	localObject9	Object
    //   3447	1	11	localThrowable13	Throwable
    //   3466	1	11	localException3	java.lang.Exception
    //   1638	7	12	localException4	java.lang.Exception
    //   1724	65	12	arrayOfLong	long[]
    //   3434	7	12	localObject10	Object
    //   1056	2328	13	localStringBuilder	StringBuilder
    //   998	1635	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   672	752	1628	java/lang/Throwable
    //   757	797	1628	java/lang/Throwable
    //   800	812	1638	java/lang/Exception
    //   817	831	1638	java/lang/Exception
    //   831	867	1638	java/lang/Exception
    //   1658	1663	1666	java/lang/Exception
    //   800	812	1671	finally
    //   817	831	1671	finally
    //   831	867	1671	finally
    //   2261	2296	2299	java/lang/Throwable
    //   1509	1528	2837	java/lang/Throwable
    //   2847	2852	2855	java/lang/Throwable
    //   1509	1528	2860	finally
    //   2555	2643	2895	java/lang/Throwable
    //   2643	2648	2895	java/lang/Throwable
    //   2653	2700	2895	java/lang/Throwable
    //   3284	3346	3382	java/lang/Throwable
    //   939	944	3395	java/lang/Exception
    //   1678	1682	3400	java/lang/Exception
    //   1703	1708	3404	java/lang/Throwable
    //   2867	2872	3409	java/lang/Throwable
    //   2949	3002	3414	java/lang/Throwable
    //   3002	3031	3414	java/lang/Throwable
    //   3031	3060	3414	java/lang/Throwable
    //   3060	3078	3414	java/lang/Throwable
    //   2917	2922	3419	java/lang/Throwable
    //   2927	2949	3419	java/lang/Throwable
    //   2390	2451	3424	java/lang/Throwable
    //   2301	2332	3429	java/lang/Throwable
    //   2342	2390	3429	java/lang/Throwable
    //   1528	1543	3434	finally
    //   1548	1570	3434	finally
    //   1570	1602	3434	finally
    //   1602	1609	3434	finally
    //   1690	1698	3434	finally
    //   1528	1543	3447	java/lang/Throwable
    //   1548	1570	3447	java/lang/Throwable
    //   1570	1602	3447	java/lang/Throwable
    //   1602	1609	3447	java/lang/Throwable
    //   1690	1698	3447	java/lang/Throwable
    //   867	934	3452	finally
    //   1648	1653	3459	finally
    //   867	934	3466	java/lang/Exception
    //   1058	1172	3471	java/lang/Throwable
    //   1177	1185	3471	java/lang/Throwable
    //   1188	1362	3471	java/lang/Throwable
    //   1362	1420	3471	java/lang/Throwable
    //   1420	1440	3471	java/lang/Throwable
    //   1445	1498	3471	java/lang/Throwable
    //   1498	1506	3471	java/lang/Throwable
    //   1708	1740	3471	java/lang/Throwable
    //   1754	1812	3471	java/lang/Throwable
    //   1817	1925	3471	java/lang/Throwable
    //   1925	1954	3471	java/lang/Throwable
    //   1954	1983	3471	java/lang/Throwable
    //   1983	2012	3471	java/lang/Throwable
    //   2012	2152	3471	java/lang/Throwable
    //   2152	2241	3471	java/lang/Throwable
    //   2241	2261	3471	java/lang/Throwable
    //   2872	2875	3471	java/lang/Throwable
    //   2875	2884	3471	java/lang/Throwable
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 164
    //   2: iconst_1
    //   3: new 20	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 1142
    //   10: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 1144
    //   20: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 1147	com/tencent/mobileqq/statistics/StatisticCollector:access$100	()Z
    //   26: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 1147	com/tencent/mobileqq/statistics/StatisticCollector:access$100	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 1150	com/tencent/mobileqq/statistics/StatisticCollector:access$102	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: iload_1
    //   49: ifeq +32 -> 81
    //   52: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   55: ldc 164
    //   57: iconst_4
    //   58: invokevirtual 970	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface 1154 1 0
    //   66: ldc_w 1156
    //   69: iconst_1
    //   70: invokeinterface 1162 3 0
    //   75: invokeinterface 1165 1 0
    //   80: pop
    //   81: iload_1
    //   82: ifne +21 -> 103
    //   85: invokestatic 1168	com/tencent/mobileqq/statistics/StatisticCollector:access$300	()Ljava/lang/String;
    //   88: invokestatic 1171	com/tencent/mobileqq/statistics/StatisticCollector:access$400	()Ljava/lang/String;
    //   91: invokestatic 1175	com/tencent/mobileqq/statistics/StatisticCollector:access$500	(Ljava/lang/String;Ljava/lang/String;)Z
    //   94: ifeq +9 -> 103
    //   97: iconst_1
    //   98: putstatic 1179	com/tencent/mobileqq/statistics/StatisticCollector:sCatchedNotExit	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: getstatic 379	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   111: invokestatic 1182	com/tencent/mobileqq/statistics/StatisticCollector:access$1100	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)V
    //   114: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   117: invokevirtual 1185	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   120: aload_0
    //   121: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   124: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   127: aload_3
    //   128: invokestatic 1189	com/tencent/mobileqq/statistics/StatisticCollector:access$1200	(Lcom/tencent/mobileqq/statistics/StatisticCollector;Landroid/content/Context;Ljava/lang/String;)V
    //   131: aload_3
    //   132: ldc_w 1191
    //   135: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +30 -> 168
    //   141: aload_0
    //   142: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   145: invokevirtual 1194	com/tencent/mobileqq/statistics/StatisticCollector:initCrashControl	()V
    //   148: aload_0
    //   149: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   152: invokevirtual 1197	com/tencent/mobileqq/statistics/StatisticCollector:updateLocalCrashData	()V
    //   155: aload_0
    //   156: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   159: invokestatic 1168	com/tencent/mobileqq/statistics/StatisticCollector:access$300	()Ljava/lang/String;
    //   162: invokestatic 1171	com/tencent/mobileqq/statistics/StatisticCollector:access$400	()Ljava/lang/String;
    //   165: invokevirtual 1201	com/tencent/mobileqq/statistics/StatisticCollector:updateNotRestartData	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_3
    //   169: ldc_w 594
    //   172: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   175: ifne +23 -> 198
    //   178: aload_3
    //   179: ldc_w 381
    //   182: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +13 -> 198
    //   188: aload_3
    //   189: ldc_w 1203
    //   192: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   195: ifeq +18 -> 213
    //   198: aload_0
    //   199: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   202: invokevirtual 1194	com/tencent/mobileqq/statistics/StatisticCollector:initCrashControl	()V
    //   205: aload_0
    //   206: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   209: aload_3
    //   210: invokevirtual 1206	com/tencent/mobileqq/statistics/StatisticCollector:updatePreloadCrashData	(Ljava/lang/String;)V
    //   213: aload_3
    //   214: ldc_w 594
    //   217: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   220: ifne +43 -> 263
    //   223: aload_3
    //   224: ldc_w 381
    //   227: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   230: ifne +33 -> 263
    //   233: aload_3
    //   234: ldc_w 1203
    //   237: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   240: ifne +23 -> 263
    //   243: aload_3
    //   244: ldc_w 1208
    //   247: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   250: ifne +13 -> 263
    //   253: aload_3
    //   254: ldc_w 596
    //   257: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   260: ifeq +88 -> 348
    //   263: ldc_w 1210
    //   266: iconst_0
    //   267: invokestatic 1216	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   270: ifeq +78 -> 348
    //   273: ldc 164
    //   275: iconst_1
    //   276: new 20	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 1218
    //   286: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   292: ldc2_w 1219
    //   295: ldiv
    //   296: invokevirtual 559	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: new 20	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 1222
    //   315: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   322: getfield 422	com/tencent/mobileqq/statistics/StatisticCollector:mCurUin	Ljava/lang/String;
    //   325: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   334: ldc2_w 1219
    //   337: ldiv
    //   338: invokestatic 1226	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   341: ldc_w 1210
    //   344: iconst_0
    //   345: invokestatic 1230	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   348: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   351: invokevirtual 1233	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   354: aload_3
    //   355: ldc_w 1191
    //   358: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +362 -> 723
    //   364: new 460	android/content/Intent
    //   367: dup
    //   368: ldc_w 1235
    //   371: invokespecial 1236	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   374: astore 4
    //   376: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   379: ldc_w 1238
    //   382: invokevirtual 1242	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   385: checkcast 1244	android/app/ActivityManager
    //   388: invokevirtual 1248	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   391: astore 6
    //   393: new 456	java/util/ArrayList
    //   396: dup
    //   397: invokespecial 1249	java/util/ArrayList:<init>	()V
    //   400: astore 5
    //   402: aload 6
    //   404: ifnull +282 -> 686
    //   407: aload 6
    //   409: invokeinterface 1250 1 0
    //   414: ifle +272 -> 686
    //   417: aload 6
    //   419: invokeinterface 261 1 0
    //   424: astore 6
    //   426: aload 6
    //   428: invokeinterface 203 1 0
    //   433: ifeq +253 -> 686
    //   436: aload 6
    //   438: invokeinterface 206 1 0
    //   443: checkcast 1252	android/app/ActivityManager$RunningAppProcessInfo
    //   446: getfield 1253	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   449: astore 7
    //   451: aload 7
    //   453: ifnull -27 -> 426
    //   456: aload 7
    //   458: ldc_w 1255
    //   461: invokevirtual 762	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   464: ifeq -38 -> 426
    //   467: aload 7
    //   469: ldc_w 1257
    //   472: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   475: ifne -49 -> 426
    //   478: aload 5
    //   480: aload 7
    //   482: invokevirtual 1260	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   485: pop
    //   486: goto -60 -> 426
    //   489: astore 4
    //   491: aload 4
    //   493: invokevirtual 780	java/lang/Throwable:printStackTrace	()V
    //   496: aload_3
    //   497: ldc_w 1191
    //   500: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifeq +395 -> 898
    //   506: aload_0
    //   507: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   510: getfield 1263	com/tencent/mobileqq/statistics/StatisticCollector:shouldStopMsf	Z
    //   513: ifeq +376 -> 889
    //   516: ldc 164
    //   518: iconst_1
    //   519: new 20	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 1265
    //   529: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_0
    //   533: getfield 12	com/tencent/mobileqq/statistics/StatisticCollector$2:this$0	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   536: getfield 1263	com/tencent/mobileqq/statistics/StatisticCollector:shouldStopMsf	Z
    //   539: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   542: ldc_w 1267
    //   545: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   557: ldc_w 1238
    //   560: invokevirtual 1242	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   563: checkcast 1244	android/app/ActivityManager
    //   566: invokevirtual 1248	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   569: astore_3
    //   570: aload_3
    //   571: ifnull +260 -> 831
    //   574: aload_3
    //   575: invokeinterface 1250 1 0
    //   580: ifle +251 -> 831
    //   583: aload_3
    //   584: invokeinterface 261 1 0
    //   589: astore_3
    //   590: aload_3
    //   591: invokeinterface 203 1 0
    //   596: ifeq +235 -> 831
    //   599: aload_3
    //   600: invokeinterface 206 1 0
    //   605: checkcast 1252	android/app/ActivityManager$RunningAppProcessInfo
    //   608: astore 4
    //   610: aload 4
    //   612: getfield 1253	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   615: astore 5
    //   617: aload 5
    //   619: ifnull -29 -> 590
    //   622: aload 5
    //   624: ldc_w 1255
    //   627: invokevirtual 762	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   630: ifeq -40 -> 590
    //   633: aload 5
    //   635: ldc_w 1257
    //   638: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   641: ifne -51 -> 590
    //   644: aload 4
    //   646: getfield 1270	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   649: invokestatic 1275	android/os/Process:killProcess	(I)V
    //   652: goto -62 -> 590
    //   655: astore_3
    //   656: aload_3
    //   657: invokevirtual 780	java/lang/Throwable:printStackTrace	()V
    //   660: iconst_1
    //   661: ireturn
    //   662: astore 4
    //   664: aload 4
    //   666: invokevirtual 780	java/lang/Throwable:printStackTrace	()V
    //   669: goto -538 -> 131
    //   672: astore 4
    //   674: ldc 164
    //   676: iconst_1
    //   677: ldc_w 1277
    //   680: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: goto -335 -> 348
    //   686: aload 4
    //   688: ldc_w 1279
    //   691: aload 5
    //   693: invokevirtual 1283	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   696: pop
    //   697: aload 4
    //   699: ldc_w 1285
    //   702: aload 5
    //   704: iconst_0
    //   705: invokestatic 1289	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   708: invokevirtual 1293	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   711: pop
    //   712: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   715: aload 4
    //   717: invokevirtual 485	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   720: goto -224 -> 496
    //   723: aload_3
    //   724: ldc_w 594
    //   727: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   730: ifeq +72 -> 802
    //   733: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   736: ldc_w 1238
    //   739: invokevirtual 1242	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   742: checkcast 1244	android/app/ActivityManager
    //   745: invokevirtual 1248	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   748: invokeinterface 261 1 0
    //   753: astore 4
    //   755: aload 4
    //   757: invokeinterface 203 1 0
    //   762: ifeq -266 -> 496
    //   765: aload 4
    //   767: invokeinterface 206 1 0
    //   772: checkcast 1252	android/app/ActivityManager$RunningAppProcessInfo
    //   775: astore 5
    //   777: aload 5
    //   779: getfield 1253	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   782: ldc_w 1295
    //   785: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq -33 -> 755
    //   791: aload 5
    //   793: getfield 1270	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   796: invokestatic 1275	android/os/Process:killProcess	(I)V
    //   799: goto -44 -> 755
    //   802: aload_3
    //   803: ldc_w 1297
    //   806: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   809: ifne -313 -> 496
    //   812: aload_3
    //   813: ldc_w 1299
    //   816: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   819: ifeq -323 -> 496
    //   822: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   825: invokestatic 1304	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   828: goto -332 -> 496
    //   831: invokestatic 332	com/tencent/mobileqq/statistics/StatisticCollector:access$1000	()Landroid/content/Context;
    //   834: ldc_w 1306
    //   837: iconst_0
    //   838: invokevirtual 970	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   841: astore_3
    //   842: aload_3
    //   843: ldc_w 1308
    //   846: iconst_0
    //   847: invokeinterface 1312 3 0
    //   852: istore_2
    //   853: aload_3
    //   854: invokeinterface 1154 1 0
    //   859: ldc_w 1308
    //   862: iload_2
    //   863: iconst_1
    //   864: iadd
    //   865: invokeinterface 1316 3 0
    //   870: invokeinterface 1165 1 0
    //   875: pop
    //   876: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   879: iconst_1
    //   880: invokevirtual 1319	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   883: invokestatic 1322	android/os/Process:myPid	()I
    //   886: invokestatic 1275	android/os/Process:killProcess	(I)V
    //   889: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   892: iconst_1
    //   893: invokevirtual 1325	com/tencent/common/app/BaseApplicationImpl:qqProcessExit	(Z)V
    //   896: iconst_1
    //   897: ireturn
    //   898: aload_3
    //   899: ldc_w 594
    //   902: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   905: ifne +45 -> 950
    //   908: aload_3
    //   909: ldc_w 1327
    //   912: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   915: ifne +35 -> 950
    //   918: aload_3
    //   919: ldc_w 1297
    //   922: invokevirtual 385	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   925: ifne +25 -> 950
    //   928: aload_3
    //   929: ldc_w 983
    //   932: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   935: ifeq +6 -> 941
    //   938: goto +12 -> 950
    //   941: invokestatic 1012	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   944: iconst_0
    //   945: invokevirtual 1330	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   948: iconst_1
    //   949: ireturn
    //   950: iload_1
    //   951: ifeq -905 -> 46
    //   954: goto -13 -> 941
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	this	2
    //   0	957	1	paramBoolean	boolean
    //   852	13	2	i	int
    //   106	494	3	localObject1	Object
    //   655	158	3	localThrowable1	Throwable
    //   841	88	3	localSharedPreferences	android.content.SharedPreferences
    //   374	1	4	localIntent	android.content.Intent
    //   489	3	4	localThrowable2	Throwable
    //   608	37	4	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   662	3	4	localThrowable3	Throwable
    //   672	44	4	localThrowable4	Throwable
    //   753	13	4	localIterator	Iterator
    //   400	392	5	localObject2	Object
    //   391	46	6	localObject3	Object
    //   449	32	7	str	String
    // Exception table:
    //   from	to	target	type
    //   348	402	489	java/lang/Throwable
    //   407	426	489	java/lang/Throwable
    //   426	451	489	java/lang/Throwable
    //   456	486	489	java/lang/Throwable
    //   686	720	489	java/lang/Throwable
    //   723	755	489	java/lang/Throwable
    //   755	799	489	java/lang/Throwable
    //   802	828	489	java/lang/Throwable
    //   496	570	655	java/lang/Throwable
    //   574	590	655	java/lang/Throwable
    //   590	617	655	java/lang/Throwable
    //   622	652	655	java/lang/Throwable
    //   831	889	655	java/lang/Throwable
    //   889	896	655	java/lang/Throwable
    //   898	938	655	java/lang/Throwable
    //   941	948	655	java/lang/Throwable
    //   107	131	662	java/lang/Throwable
    //   131	168	672	java/lang/Throwable
    //   168	198	672	java/lang/Throwable
    //   198	213	672	java/lang/Throwable
    //   213	263	672	java/lang/Throwable
    //   263	348	672	java/lang/Throwable
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", sHasCrashed=" + StatisticCollector.access$200() + ", sIsFinalizeTimeoutException=" + StatisticCollector.access$100());
    if ((StatisticCollector.access$200()) && (!StatisticCollector.access$100()) && (!StatisticCollector.access$500(StatisticCollector.access$300(), StatisticCollector.access$400()))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      SharedPreferencesProxyManager.getInstance().onCrashStart();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(128);
        String str1 = "topActivity:" + amxy.a();
        StringBuilder localStringBuilder2 = new StringBuilder(128);
        int j = StatisticCollector.access$600(this.this$0).size();
        int i = Math.min(j, 5);
        for (;;)
        {
          if (i > 0)
          {
            String str2 = (String)StatisticCollector.access$600(this.this$0).pop();
            if (localStringBuilder2.length() > 0) {
              localStringBuilder2.append("\n--->");
            }
            localStringBuilder2.append(str2);
            i -= 1;
            continue;
            StatisticCollector.access$202(true);
            break;
          }
        }
        StatisticCollector.access$600(this.this$0).clear();
        localStringBuilder1.append(str1).append("\n");
        localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
        localStringBuilder1.append(localStringBuilder2).append("\n");
        localStringBuilder1.append("Current mapEvent content is:\n");
        localStringBuilder1.append(StatisticCollector.access$700(this.this$0).toString());
        StatisticCollector.access$802(this.this$0, localStringBuilder1.toString());
        StatisticCollector.access$900(this.this$0).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
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
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + StatisticCollector.access$000().format(new Date(paramLong)) + ", curTime=" + StatisticCollector.access$000().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      StatisticCollector.access$102(paramBoolean);
      if (!StatisticCollector.access$100()) {
        break;
      }
      return false;
    }
    if ((22 == Build.VERSION.SDK_INT) && ("vivo".equalsIgnoreCase(Build.BRAND)) && ("android.app.RemoteServiceException".equalsIgnoreCase(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("android.app.ActivityThread$H.handleMessage"))) {
      return false;
    }
    WebpSoLoader.a(paramString3);
    bfql.a(paramString3);
    vgw.a().a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.2
 * JD-Core Version:    0.7.0.1
 */