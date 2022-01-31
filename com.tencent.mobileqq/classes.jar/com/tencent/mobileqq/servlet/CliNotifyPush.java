package com.tencent.mobileqq.servlet;

import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import ahxt;
import ahxu;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.servlet.model.SinglePushMsg;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import com.tencent.upload.common.UploadConfiguration;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.push.MsgNotification;
import cooperation.qzone.push.QzNotificationStruct;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class CliNotifyPush
  extends MSFServlet
  implements WebEventListener
{
  public static int a;
  public static volatile HashMap a;
  public static volatile List a;
  public static volatile boolean a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone" };
  public static int b;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ahxu(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ahxt(this);
  private volatile ArrayList jdField_a_of_type_JavaUtilArrayList;
  private volatile ArrayList b;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    if (paramContext != null) {
      return paramContext.versionCode;
    }
    return -1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0);
      paramQQAppInterface = paramQQAppInterface.getAccount();
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramQQAppInterface.length() > 0) {
          l1 = localSharedPreferences.getLong(paramQQAppInterface + ":" + paramInt, 0L);
        }
      }
    }
    return l1;
  }
  
  private static PackageInfo a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private String a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      SinglePushMsg localSinglePushMsg;
      JSONObject localJSONObject;
      if (paramArrayList.hasNext())
      {
        localSinglePushMsg = (SinglePushMsg)paramArrayList.next();
        if ((localSinglePushMsg != null) && (localSinglePushMsg.jdField_a_of_type_JavaUtilMap != null)) {
          localJSONObject = new JSONObject();
        }
      }
      else
      {
        try
        {
          localJSONObject.put("addTime", localSinglePushMsg.jdField_a_of_type_Long);
          localJSONObject.put("opUin", localSinglePushMsg.jdField_b_of_type_Long);
          Iterator localIterator = localSinglePushMsg.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, localSinglePushMsg.jdField_a_of_type_JavaUtilMap.get(str));
          }
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException) {}
        return localJSONArray.toString();
      }
    }
  }
  
  private void a()
  {
    QLog.e("CliNotifyPush", 1, "show()");
    ArrayList localArrayList;
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    for (;;)
    {
      Iterator localIterator;
      if (jdField_a_of_type_Boolean)
      {
        QLog.e("CliNotifyPush", 1, "call qzone timeout, show in qq");
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            b((SinglePushMsg)localIterator.next());
          }
        }
        if (localArrayList != null)
        {
          localIterator = localArrayList.iterator();
          while (localIterator.hasNext()) {
            b((SinglePushMsg)localIterator.next());
          }
        }
        this.c = 2010;
        jdField_b_of_type_Int += 1;
      }
      for (;;)
      {
        a(this.c);
        jdField_a_of_type_Boolean = false;
        if (((this.c == 0) || (this.c == 10000)) && (localArrayList != null)) {
          a(localArrayList, (QQAppInterface)getAppRuntime());
        }
        return;
        if ((this.c == 0) || (this.c == 10000))
        {
          QLog.e("CliNotifyPush", 1, "call qzone success, show in qzone");
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              SinglePushMsg localSinglePushMsg = (SinglePushMsg)localIterator.next();
              a(localSinglePushMsg, (QQAppInterface)getAppRuntime(), 2L);
              a(localSinglePushMsg, true);
              a(localSinglePushMsg);
            }
          }
        }
        else
        {
          QLog.e("CliNotifyPush", 1, "call qzone failed, show in qq");
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              b((SinglePushMsg)localIterator.next());
            }
          }
          if (localArrayList != null)
          {
            localIterator = localArrayList.iterator();
            while (localIterator.hasNext()) {
              b((SinglePushMsg)localIterator.next());
            }
          }
        }
      }
      localArrayList = null;
    }
  }
  
  private void a(int paramInt)
  {
    QLog.e("CliNotifyPush", 1, "report resultCode:" + paramInt);
    b(paramInt);
    QZoneHelper.a((QQAppInterface)getAppRuntime(), "qzonenewservice.callqzonev2", paramInt, "CliNotifyPush", 1, System.currentTimeMillis());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        localEditor.putLong(paramQQAppInterface + ":" + paramInt, paramLong);
      }
      localEditor.commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    a(paramQQAppInterface, 0, paramLong);
  }
  
  private void a(SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "dispathQzonePushMsg()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {}
    while ((paramSinglePushMsg == null) || (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    Object localObject;
    if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) && (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("utime") != null) && (LocalMultiProcConfig.getInt4Uin("qzone_preget_passive_open", 0, localQQAppInterface.getLongAccountUin()) == 1))
    {
      localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("utime");
      if (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", localQQAppInterface.getLongAccountUin()).equals(localObject))
      {
        paramSinglePushMsg.jdField_a_of_type_Boolean = true;
        int i = RemoteHandleManager.a().a().a(localQQAppInterface.getLongAccountUin());
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramSinglePushMsg);
      }
    }
    if (a(localQQAppInterface, paramSinglePushMsg))
    {
      if (jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(paramSinglePushMsg);
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramSinglePushMsg);
      a((ArrayList)localObject, localQQAppInterface);
      return;
    }
    b(paramSinglePushMsg);
  }
  
  public static void a(SinglePushMsg paramSinglePushMsg, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramSinglePushMsg == null) {
      return;
    }
    if (paramQQAppInterface != null) {}
    for (long l1 = Long.parseLong(paramQQAppInterface.getAccount());; l1 = 0L)
    {
      long l2 = paramLong;
      NewIntent localNewIntent;
      if (paramSinglePushMsg.jdField_a_of_type_Long != 0L)
      {
        l2 = paramLong;
        if (l1 != 0L)
        {
          localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZonePushAckServlet.class);
          localNewIntent.putExtra("timestamp", paramSinglePushMsg.jdField_a_of_type_Long);
          localNewIntent.putExtra("hostuin", l1);
          if (!paramSinglePushMsg.jdField_b_of_type_Boolean) {
            break label175;
          }
        }
      }
      label175:
      for (paramLong = 1L | paramLong;; paramLong = 0xFFFFFFFE & paramLong)
      {
        localNewIntent.putExtra("mark", paramSinglePushMsg.jdField_a_of_type_JavaLangString);
        localNewIntent.putExtra("flag", paramLong);
        paramQQAppInterface.startServlet(localNewIntent);
        l2 = paramLong;
        QLog.e("CliNotifyPush", 1, "sentQzoneMsfPushAck: localTimeStamp=" + paramSinglePushMsg.jdField_a_of_type_Long + " uin=" + l1 + " flag=" + l2);
        return;
      }
    }
  }
  
  /* Error */
  private void a(SinglePushMsg paramSinglePushMsg, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   8: ifnonnull +13 -> 21
    //   11: ldc 194
    //   13: iconst_1
    //   14: ldc_w 394
    //   17: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aload_0
    //   22: invokevirtual 228	com/tencent/mobileqq/servlet/CliNotifyPush:getAppRuntime	()Lmqq/app/AppRuntime;
    //   25: checkcast 69	com/tencent/mobileqq/app/QQAppInterface
    //   28: astore 11
    //   30: aload 11
    //   32: ifnonnull +13 -> 45
    //   35: ldc 194
    //   37: iconst_1
    //   38: ldc_w 396
    //   41: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: return
    //   45: aload 11
    //   47: bipush 9
    //   49: invokevirtual 400	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   52: checkcast 402	com/tencent/mobileqq/servlet/QZoneManagerImp
    //   55: astore 10
    //   57: aload 10
    //   59: ifnull -39 -> 20
    //   62: aload_1
    //   63: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   66: ldc_w 404
    //   69: invokeinterface 185 2 0
    //   74: checkcast 21	java/lang/String
    //   77: invokestatic 408	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore 5
    //   82: ldc 194
    //   84: iconst_1
    //   85: new 91	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 410
    //   95: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload 5
    //   100: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: ldc_w 412
    //   106: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: getfield 172	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_b_of_type_Long	J
    //   113: invokevirtual 386	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: ldc_w 414
    //   119: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 11
    //   124: getfield 417	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   127: invokevirtual 420	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   130: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 423	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: iload 5
    //   138: iconst_1
    //   139: if_icmpeq +19 -> 158
    //   142: iload 5
    //   144: sipush 300
    //   147: if_icmpeq +11 -> 158
    //   150: iload 5
    //   152: sipush 302
    //   155: if_icmpne -135 -> 20
    //   158: aload_1
    //   159: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   162: ldc_w 425
    //   165: invokeinterface 185 2 0
    //   170: checkcast 21	java/lang/String
    //   173: astore 11
    //   175: aload_1
    //   176: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   179: ldc_w 427
    //   182: invokeinterface 185 2 0
    //   187: checkcast 21	java/lang/String
    //   190: invokestatic 408	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   193: istore 6
    //   195: aload_1
    //   196: getfield 172	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_b_of_type_Long	J
    //   199: lstore 8
    //   201: iconst_0
    //   202: istore_3
    //   203: aload_1
    //   204: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   207: ldc_w 429
    //   210: invokeinterface 432 2 0
    //   215: istore 7
    //   217: iload 7
    //   219: ifeq +244 -> 463
    //   222: iconst_1
    //   223: istore_3
    //   224: aload_1
    //   225: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   228: ldc_w 429
    //   231: invokeinterface 185 2 0
    //   236: checkcast 21	java/lang/String
    //   239: invokestatic 408	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   242: istore 4
    //   244: iconst_1
    //   245: istore_3
    //   246: new 131	java/util/ArrayList
    //   249: dup
    //   250: invokespecial 337	java/util/ArrayList:<init>	()V
    //   253: astore 12
    //   255: new 434	cooperation/qzone/UndealCount/QZoneCountUserInfo
    //   258: dup
    //   259: invokespecial 435	cooperation/qzone/UndealCount/QZoneCountUserInfo:<init>	()V
    //   262: astore 13
    //   264: aload 13
    //   266: lload 8
    //   268: putfield 436	cooperation/qzone/UndealCount/QZoneCountUserInfo:jdField_a_of_type_Long	J
    //   271: aload 13
    //   273: iload 4
    //   275: putfield 437	cooperation/qzone/UndealCount/QZoneCountUserInfo:jdField_b_of_type_Int	I
    //   278: aload 13
    //   280: iload_3
    //   281: putfield 439	cooperation/qzone/UndealCount/QZoneCountUserInfo:jdField_a_of_type_Int	I
    //   284: aload_1
    //   285: aload_1
    //   286: getfield 442	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_ArrayOfByte	[B
    //   289: invokestatic 447	cooperation/qzone/util/JceUtils:a	([B)[B
    //   292: putfield 442	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_ArrayOfByte	[B
    //   295: aload_1
    //   296: getfield 442	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_ArrayOfByte	[B
    //   299: ifnull +52 -> 351
    //   302: ldc_w 449
    //   305: aload_1
    //   306: getfield 442	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_ArrayOfByte	[B
    //   309: invokestatic 452	cooperation/qzone/util/JceUtils:a	(Ljava/lang/Class;[B)Lcom/qq/taf/jce/JceStruct;
    //   312: checkcast 449	NS_QMALL_COVER/PassiveFeedsPush
    //   315: astore 14
    //   317: aload 14
    //   319: ifnull +32 -> 351
    //   322: aload 14
    //   324: getfield 456	NS_QMALL_COVER/PassiveFeedsPush:stBubbleSkin	LNS_QMALL_COVER/QzmallCustomBubbleSkin;
    //   327: ifnull +24 -> 351
    //   330: aload 14
    //   332: getfield 456	NS_QMALL_COVER/PassiveFeedsPush:stBubbleSkin	LNS_QMALL_COVER/QzmallCustomBubbleSkin;
    //   335: getfield 461	NS_QMALL_COVER/QzmallCustomBubbleSkin:lUin	J
    //   338: lload 8
    //   340: lcmp
    //   341: ifne +10 -> 351
    //   344: aload 13
    //   346: aload 14
    //   348: putfield 464	cooperation/qzone/UndealCount/QZoneCountUserInfo:jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush	LNS_QMALL_COVER/PassiveFeedsPush;
    //   351: aload 12
    //   353: aload 13
    //   355: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   358: pop
    //   359: aload_1
    //   360: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   363: ldc_w 466
    //   366: invokeinterface 185 2 0
    //   371: checkcast 21	java/lang/String
    //   374: astore_1
    //   375: iload 5
    //   377: sipush 302
    //   380: if_icmpne +58 -> 438
    //   383: aload_1
    //   384: invokestatic 472	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifne +51 -> 438
    //   390: aload 10
    //   392: iconst_1
    //   393: iload 6
    //   395: i2l
    //   396: aload 12
    //   398: aload 11
    //   400: iload_2
    //   401: iconst_1
    //   402: aload_1
    //   403: invokevirtual 475	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(IJLjava/util/ArrayList;Ljava/lang/String;ZZLjava/lang/String;)Z
    //   406: pop
    //   407: return
    //   408: astore_1
    //   409: ldc 194
    //   411: iconst_1
    //   412: ldc_w 477
    //   415: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: return
    //   419: astore 12
    //   421: iconst_0
    //   422: istore_3
    //   423: ldc 194
    //   425: iconst_2
    //   426: ldc_w 479
    //   429: invokestatic 423	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: iconst_0
    //   433: istore 4
    //   435: goto -189 -> 246
    //   438: aload 10
    //   440: iconst_1
    //   441: iload 6
    //   443: i2l
    //   444: aload 12
    //   446: aload 11
    //   448: iload_2
    //   449: iconst_1
    //   450: ldc_w 302
    //   453: invokevirtual 475	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(IJLjava/util/ArrayList;Ljava/lang/String;ZZLjava/lang/String;)Z
    //   456: pop
    //   457: return
    //   458: astore 12
    //   460: goto -37 -> 423
    //   463: iconst_0
    //   464: istore 4
    //   466: goto -220 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	CliNotifyPush
    //   0	469	1	paramSinglePushMsg	SinglePushMsg
    //   0	469	2	paramBoolean	boolean
    //   202	221	3	i	int
    //   242	223	4	j	int
    //   80	301	5	k	int
    //   193	249	6	m	int
    //   215	3	7	bool	boolean
    //   199	140	8	l	long
    //   55	384	10	localQZoneManagerImp	QZoneManagerImp
    //   28	419	11	localObject	Object
    //   253	144	12	localArrayList	ArrayList
    //   419	26	12	localException1	Exception
    //   458	1	12	localException2	Exception
    //   262	92	13	localQZoneCountUserInfo	cooperation.qzone.UndealCount.QZoneCountUserInfo
    //   315	32	14	localPassiveFeedsPush	NS_QMALL_COVER.PassiveFeedsPush
    // Exception table:
    //   from	to	target	type
    //   62	136	408	java/lang/Exception
    //   158	201	408	java/lang/Exception
    //   246	317	408	java/lang/Exception
    //   322	351	408	java/lang/Exception
    //   351	375	408	java/lang/Exception
    //   383	407	408	java/lang/Exception
    //   423	432	408	java/lang/Exception
    //   438	457	408	java/lang/Exception
    //   203	217	419	java/lang/Exception
    //   224	244	458	java/lang/Exception
  }
  
  private void a(ArrayList paramArrayList, QQAppInterface paramQQAppInterface)
  {
    QLog.e("CliNotifyPush", 1, "callQZone()");
    String str = a(paramArrayList);
    if (TextUtils.isEmpty(str))
    {
      QLog.e("CliNotifyPush", 1, "call qzone param error");
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((SinglePushMsg)paramArrayList.next());
      }
    }
    try
    {
      jdField_a_of_type_Boolean = true;
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        ((SinglePushMsg)localIterator.next()).a(true);
      }
      return;
    }
    catch (Exception localException)
    {
      jdField_a_of_type_Boolean = false;
      paramQQAppInterface.getHandler(CliNotifyPush.class).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      QLog.e("CliNotifyPush", 1, localException, new Object[] { "call qzone param error" });
      a(2009);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((SinglePushMsg)paramArrayList.next());
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      paramQQAppInterface.getHandler(CliNotifyPush.class).postDelayed(this.jdField_a_of_type_JavaLangRunnable, QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushTimeout", 20000));
      UploadConfiguration.checkVaildConnection(paramQQAppInterface.getApp(), Long.valueOf(paramQQAppInterface.getLongAccountUin()), localException);
      QLog.e("CliNotifyPush", 1, "calling qzone, the msg is: " + localException);
      a(2007);
    }
  }
  
  private void a(Map paramMap)
  {
    Intent localIntent = new Intent("com.qzone.live.MicLogic.processMicMsg");
    if ((paramMap != null) && ((paramMap instanceof HashMap))) {
      localIntent.putExtra("mic_msg", (HashMap)paramMap);
    }
    BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  private void a(Map paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    try
    {
      QZoneDistributedAppCtrl.Control localControl = new QZoneDistributedAppCtrl.Control();
      localControl.jdField_a_of_type_Int = Integer.parseInt((String)paramMap.get("key_ctrl_cmd"));
      localControl.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
      QZoneDistributedAppCtrl.a(paramString).a(localControl);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 10000) {}
    do
    {
      return false;
      if ((8 == paramInt) || (4 == paramInt)) {
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
    } while ((paramInt != 1) && (paramInt != 300));
    return LocalMultiProcConfig.getBool(paramQQAppInterface.getApp().getApplicationContext().getString(2131434207) + paramQQAppInterface.getAccount(), true);
  }
  
  private boolean a(SinglePushMsg paramSinglePushMsg)
  {
    boolean bool = false;
    int i = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    Object localObject;
    QzNotificationStruct localQzNotificationStruct2;
    if (i == 301) {
      if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("live_roomid");
        if (localObject != null)
        {
          localQzNotificationStruct2 = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
          if ((localQzNotificationStruct2 == null) || (!((String)localObject).equals(localQzNotificationStruct2.jdField_a_of_type_JavaLangString))) {
            break label262;
          }
          jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct2);
          if (jdField_a_of_type_JavaUtilList.size() != 0) {
            break label196;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new QNotificationManager(localQQAppInterface.getApplication());
        if (localObject != null) {
          ((QNotificationManager)localObject).cancel("CliNotifyPush.clearLivePush", 141);
        }
      }
      catch (Exception localException)
      {
        QLog.e("CliNotifyPush", 1, "NotificationManager cancel exception");
        continue;
      }
      a(paramSinglePushMsg, localQQAppInterface, 16L);
      bool = true;
      return bool;
      label196:
      QzNotificationStruct localQzNotificationStruct1 = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (localQzNotificationStruct1 != null)
      {
        MsgNotification.a().a(localQQAppInterface, 0, localQzNotificationStruct1.b, localQzNotificationStruct1.jdField_a_of_type_Boolean, localQzNotificationStruct1.jdField_a_of_type_Int, localQzNotificationStruct1.c, localQzNotificationStruct1.d, false);
        continue;
        label262:
        if (jdField_a_of_type_JavaUtilList.size() > 1)
        {
          i = 0;
          while (i < jdField_a_of_type_JavaUtilList.size() - 1)
          {
            localQzNotificationStruct2 = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(i);
            if ((localQzNotificationStruct2 != null) && (localQzNotificationStruct1.equals(localQzNotificationStruct2.jdField_a_of_type_JavaLangString))) {
              jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct2);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultcode", String.valueOf(paramInt));
    localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
    StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface.getAccount(), "callqzonefrompushv2", true, 0L, 0L, localHashMap, null, true);
  }
  
  private void b(SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "showPush()");
    if ((paramSinglePushMsg.jdField_a_of_type_Boolean) && (paramSinglePushMsg.jdField_a_of_type_Int == 0)) {
      paramSinglePushMsg.jdField_a_of_type_Int += 1;
    }
    QQAppInterface localQQAppInterface;
    int k;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      k = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      QLog.e("CliNotifyPush", 1, "pushType:" + k);
      if (k == 10000)
      {
        a(paramSinglePushMsg.jdField_a_of_type_JavaUtilMap, localQQAppInterface.getAccount());
        a(paramSinglePushMsg, localQQAppInterface, 16L);
        return;
      }
      if (k == 350)
      {
        a(paramSinglePushMsg, localQQAppInterface, 16L);
        c(paramSinglePushMsg);
        return;
      }
    } while (a(paramSinglePushMsg));
    if (k == 100)
    {
      d(paramSinglePushMsg);
      a(paramSinglePushMsg, localQQAppInterface, 16L);
      return;
    }
    String str1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
    String str2 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
    String str3 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
    long l = paramSinglePushMsg.jdField_b_of_type_Long;
    if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count") != null) {
      QLog.i("CliNotifyPush", 1, "showPush receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + ",unreadCount=" + 1 + ",uin=" + l + ",type=" + k);
    }
    for (;;)
    {
      int j;
      boolean bool;
      try
      {
        j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count"));
        i = j;
        if (j < 1) {
          i = 1;
        }
        if (((List)localObject).size() <= 0) {
          break label858;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("CtrlFlag"));
          if (QLog.isColorLevel())
          {
            QLog.i("CliNotifyPush", 2, "qzone redtypeinfo:receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + "=unreadCount=" + i + "=uin=" + l + "=type=" + k + "=CtrlFlag=" + j + "=message=" + str1);
            if (j != 1) {
              continue;
            }
            bool = true;
            a(paramSinglePushMsg, bool);
            if (!localQQAppInterface.isBackground_Pause) {
              break label845;
            }
            if (a(localQQAppInterface, k)) {
              continue;
            }
            a(paramSinglePushMsg, localQQAppInterface, 16L);
            return;
            localException1 = localException1;
            i = 1;
          }
        }
        catch (Exception localException2)
        {
          j = 0;
          continue;
          QLog.i("CliNotifyPush", 1, "qzone redtypeinfo:receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + "=unreadCount=" + i + "=uin=" + l + "=type=" + k + "=CtrlFlag=" + j);
          continue;
          bool = false;
          continue;
          if (j == 1)
          {
            QLog.e("CliNotifyPush", 1, "not show push, existDL = " + j);
            a(paramSinglePushMsg, localQQAppInterface, 128L);
            return;
          }
          localObject = ((ActivityManager)localQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
          if (localObject == null) {
            break label858;
          }
        }
      }
      Object localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (("cooperation.qzone.QzoneGPUPluginProxyActivity".equals(localObject)) || ("cooperation.qzone.QzonePluginProxyActivity".equals(localObject)) || ("cooperation.qzone.QzoneFeedsPluginProxyActivity".equals(localObject))) {
        j = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          a(paramSinglePushMsg, localQQAppInterface, 64L);
          return;
          j = 0;
        }
        else
        {
          if (str1 != null)
          {
            bool = localQQAppInterface.f();
            if (bool) {
              break label855;
            }
            str1 = localQQAppInterface.getApp().getApplicationContext().getString(2131434690) + i + localQQAppInterface.getApp().getApplicationContext().getString(2131434691);
          }
          label845:
          label855:
          for (;;)
          {
            MsgNotification.a().a(localQQAppInterface, 1, str1, bool, k, str3, str2, true);
            a(paramSinglePushMsg, localQQAppInterface, 4L);
            QLog.e("CliNotifyPush", 1, "show push: XXX");
            return;
            a(paramSinglePushMsg, localQQAppInterface, 256L);
            return;
            a(paramSinglePushMsg, localQQAppInterface, 32L);
            return;
          }
          label858:
          j = 0;
        }
      }
      int i = 1;
    }
  }
  
  private void c(SinglePushMsg paramSinglePushMsg)
  {
    if (paramSinglePushMsg == null) {
      return;
    }
    QLog.e("CliNotifyPush", 1, "recv Qzone Push: Feed实时更新Push");
    Intent localIntent = new Intent("com.qzone.push_feed_update");
    if ((paramSinglePushMsg.jdField_a_of_type_ArrayOfByte != null) && (paramSinglePushMsg.jdField_a_of_type_ArrayOfByte.length > 0)) {
      localIntent.putExtra("update_feeds_buffer", paramSinglePushMsg.jdField_a_of_type_ArrayOfByte);
    }
    for (;;)
    {
      BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
      if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) && ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap instanceof HashMap))) {
        localIntent.putExtra("update_feeds", (HashMap)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap);
      }
    }
  }
  
  /* Error */
  private void d(SinglePushMsg paramSinglePushMsg)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   18: ldc_w 760
    //   21: invokeinterface 185 2 0
    //   26: checkcast 21	java/lang/String
    //   29: astore 6
    //   31: aload_1
    //   32: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   35: ldc_w 762
    //   38: invokeinterface 185 2 0
    //   43: checkcast 21	java/lang/String
    //   46: astore 7
    //   48: aload 6
    //   50: invokestatic 472	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +11 -> 64
    //   56: aload 7
    //   58: invokestatic 472	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifeq +83 -> 144
    //   64: ldc 194
    //   66: ldc_w 764
    //   69: invokestatic 769	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_1
    //   73: istore_2
    //   74: aload_0
    //   75: invokevirtual 228	com/tencent/mobileqq/servlet/CliNotifyPush:getAppRuntime	()Lmqq/app/AppRuntime;
    //   78: checkcast 69	com/tencent/mobileqq/app/QQAppInterface
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull -72 -> 13
    //   88: new 31	java/util/HashMap
    //   91: dup
    //   92: invokespecial 34	java/util/HashMap:<init>	()V
    //   95: astore 7
    //   97: aload 7
    //   99: aload_1
    //   100: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   103: invokevirtual 770	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   106: aload 7
    //   108: ldc_w 772
    //   111: iload_2
    //   112: invokestatic 644	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   115: invokevirtual 333	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: invokestatic 548	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   122: invokestatic 654	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   125: aload 6
    //   127: invokevirtual 85	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   130: ldc_w 774
    //   133: iconst_1
    //   134: lconst_0
    //   135: lconst_0
    //   136: aload 7
    //   138: aconst_null
    //   139: iconst_1
    //   140: invokevirtual 659	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   143: return
    //   144: invokestatic 548	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   147: aload 6
    //   149: invokestatic 776	com/tencent/mobileqq/servlet/CliNotifyPush:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   152: istore 5
    //   154: iload 5
    //   156: ifeq +212 -> 368
    //   159: aload_1
    //   160: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   163: ldc_w 778
    //   166: invokeinterface 185 2 0
    //   171: checkcast 21	java/lang/String
    //   174: astore 8
    //   176: aload 8
    //   178: invokestatic 472	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +214 -> 395
    //   184: aload 8
    //   186: invokestatic 408	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   189: istore_2
    //   190: iload_2
    //   191: istore_3
    //   192: aload_1
    //   193: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   196: ldc_w 780
    //   199: invokeinterface 185 2 0
    //   204: checkcast 21	java/lang/String
    //   207: astore 8
    //   209: aload 8
    //   211: invokestatic 472	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne +97 -> 311
    //   217: aload 8
    //   219: invokestatic 408	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   222: istore_2
    //   223: invokestatic 548	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   226: aload 6
    //   228: invokestatic 782	com/tencent/mobileqq/servlet/CliNotifyPush:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   231: istore 4
    //   233: iload 4
    //   235: iload_3
    //   236: if_icmplt +101 -> 337
    //   239: iload 4
    //   241: iload_2
    //   242: if_icmpgt +95 -> 337
    //   245: aload_0
    //   246: aload_1
    //   247: getfield 156	com/tencent/mobileqq/servlet/model/SinglePushMsg:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   250: aload 6
    //   252: aload 7
    //   254: invokevirtual 785	com/tencent/mobileqq/servlet/CliNotifyPush:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   257: iconst_0
    //   258: istore_2
    //   259: goto +133 -> 392
    //   262: astore 8
    //   264: ldc 194
    //   266: ldc_w 787
    //   269: aload 8
    //   271: invokestatic 790	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   274: goto -82 -> 192
    //   277: astore 6
    //   279: invokestatic 791	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   282: ifeq +24 -> 306
    //   285: ldc 194
    //   287: iconst_2
    //   288: iconst_2
    //   289: anewarray 500	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: ldc_w 793
    //   297: aastore
    //   298: dup
    //   299: iconst_1
    //   300: aload 6
    //   302: aastore
    //   303: invokestatic 796	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   306: iconst_4
    //   307: istore_2
    //   308: goto -234 -> 74
    //   311: ldc_w 797
    //   314: istore_2
    //   315: goto -92 -> 223
    //   318: astore 8
    //   320: ldc 194
    //   322: ldc_w 799
    //   325: aload 8
    //   327: invokestatic 790	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: ldc_w 797
    //   333: istore_2
    //   334: goto -111 -> 223
    //   337: iconst_3
    //   338: istore_3
    //   339: iload_3
    //   340: istore_2
    //   341: invokestatic 791	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   344: ifeq +48 -> 392
    //   347: ldc 194
    //   349: iconst_2
    //   350: iconst_1
    //   351: anewarray 500	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc_w 801
    //   359: aastore
    //   360: invokestatic 796	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   363: iload_3
    //   364: istore_2
    //   365: goto +27 -> 392
    //   368: invokestatic 791	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   371: ifeq +19 -> 390
    //   374: ldc 194
    //   376: iconst_2
    //   377: iconst_1
    //   378: anewarray 500	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: ldc_w 803
    //   386: aastore
    //   387: invokestatic 796	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   390: iconst_2
    //   391: istore_2
    //   392: goto -318 -> 74
    //   395: iconst_m1
    //   396: istore_2
    //   397: goto -207 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	CliNotifyPush
    //   0	400	1	paramSinglePushMsg	SinglePushMsg
    //   73	324	2	i	int
    //   1	363	3	j	int
    //   231	12	4	k	int
    //   152	3	5	bool	boolean
    //   29	222	6	localObject1	Object
    //   277	24	6	localException1	Exception
    //   46	207	7	localObject2	Object
    //   174	44	8	str	String
    //   262	8	8	localException2	Exception
    //   318	8	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   159	190	262	java/lang/Exception
    //   144	154	277	java/lang/Exception
    //   223	233	277	java/lang/Exception
    //   245	257	277	java/lang/Exception
    //   264	274	277	java/lang/Exception
    //   320	330	277	java/lang/Exception
    //   341	363	277	java/lang/Exception
    //   368	390	277	java/lang/Exception
    //   192	223	318	java/lang/Exception
  }
  
  public Map a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.e("CliNotifyPush", 1, "decodeQzonePushMsgs()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    Object localObject1 = paramFromServiceMsg.getWupBuffer();
    System.arraycopy(localObject1, 4, localObject1, 0, localObject1.length - 4);
    paramFromServiceMsg = new PushInfo();
    localObject1 = new JceInputStream((byte[])localObject1);
    ((JceInputStream)localObject1).setServerEncoding("utf-8");
    paramFromServiceMsg.readFrom((JceInputStream)localObject1);
    Object localObject2 = paramFromServiceMsg.vecMsg;
    localObject1 = new HashMap();
    long l3 = a(localQQAppInterface);
    localObject2 = ((ArrayList)localObject2).iterator();
    long l1 = l3;
    SingleMsg localSingleMsg;
    int i;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localSingleMsg = (SingleMsg)((Iterator)localObject2).next();
        if (localSingleMsg != null) {
          if (localSingleMsg.data.containsKey("pushtype")) {
            i = Integer.parseInt((String)localSingleMsg.data.get("pushtype"));
          }
        }
      }
    }
    for (;;)
    {
      long l2;
      if ((i == 1) || (i == 2) || (i == 4) || (i == 301) || (i == 8) || (i == 300) || (i == 10000) || (i == 302) || (i == 350) || (i == 100))
      {
        l2 = a(localQQAppInterface, i);
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PushDeduplication", 1) == 1)
        {
          if (localSingleMsg.addTime > l2) {
            break label542;
          }
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
          a(2014);
          break;
          if (!localSingleMsg.data.containsKey("type")) {
            break label971;
          }
          i = Integer.parseInt((String)localSingleMsg.data.get("type"));
          continue;
        }
        if (localSingleMsg.addTime < l2)
        {
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
          a(2014);
          break;
        }
        label542:
        if (((Map)localObject1).containsKey(Integer.valueOf(i)))
        {
          SinglePushMsg localSinglePushMsg = (SinglePushMsg)((Map)localObject1).get(Integer.valueOf(i));
          if ((localSinglePushMsg != null) && (localSinglePushMsg.jdField_a_of_type_Long < localSingleMsg.addTime))
          {
            ((Map)localObject1).put(Integer.valueOf(i), new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer));
            QLog.e("CliNotifyPush", 1, "PushDeduplication: msg localTimeStap:" + localSingleMsg.addTime + " sm newTimeStap:" + localSinglePushMsg.jdField_a_of_type_Long + " msg:" + (String)localSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent"));
            a(localSinglePushMsg, localQQAppInterface, 8L);
            label713:
            a(localQQAppInterface, i, localSingleMsg.addTime);
            l2 = l1;
            if (l1 < localSingleMsg.addTime) {
              l2 = localSingleMsg.addTime;
            }
            l1 = l2;
          }
        }
      }
      for (;;)
      {
        break;
        QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
        a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
        break;
        ((Map)localObject1).put(Integer.valueOf(i), new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer));
        break label713;
        if (i == 7066) {
          a(localSingleMsg.data);
        } else {
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 256L);
        }
      }
      if (l3 < l1) {
        a(localQQAppInterface, l1);
      }
      return localObject1;
      label971:
      i = 0;
    }
  }
  
  public void a(Map paramMap, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramString1, paramString2);
    paramString1 = paramMap.keySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      if (!TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra(paramString2, (String)paramMap.get(paramString2));
      }
    }
    BaseApplication.getContext().startService(localIntent);
    if (QZLog.isColorLevel()) {
      QZLog.d("CliNotifyPush", 2, "arouseThirdApp success");
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "supportJumpToQzone()");
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushReport", 0) == 1) {
      a(2000);
    }
    try
    {
      if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.containsKey("CtrlFlag")) && (Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("CtrlFlag")) == 1))
      {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushCtrlFlag2", 1) == 1)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("param_scene", 11);
          localIntent.setClassName("com.qzone", "com.tencent.wns.export.EmptyService");
          paramQQAppInterface.getApp().startService(localIntent);
          QLog.e("CliNotifyPush", 1, "call qzone empty, CtrlFlag = 1");
          a(2012);
          return false;
        }
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushCtrlFlag", 1) == 1)
        {
          QLog.e("CliNotifyPush", 1, "not call qzone, CtrlFlag = 1");
          a(2002);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, localException, new Object[0]);
      int j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      if ((j != 1) && (j != 2) && (j != 4) && (j != 301))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone, pushType = " + j);
        a(2001);
        return false;
      }
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPush", 0) != 1)
      {
        QLog.e("CliNotifyPush", 1, "not call qzone, CALL_QZONE_WNS_FROM_PUSH = 0");
        a(2003);
        return false;
      }
      if (jdField_a_of_type_Int >= QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushFailCnt", 1000))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  mCntCallQzoneFailure = " + jdField_a_of_type_Int);
        a(2004);
        return false;
      }
      if (jdField_b_of_type_Int >= QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushTimeoutCnt", 3))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  mCntCallQzoneTimeout = " + jdField_b_of_type_Int);
        a(2011);
        return false;
      }
      if (a(paramQQAppInterface.getApp(), "com.qzone"))
      {
        int k = QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushVersion", 87);
        int m = QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromLivePushVersion", 89);
        int i;
        try
        {
          paramQQAppInterface = paramQQAppInterface.getApp().getPackageManager().getApplicationInfo("com.qzone", 128);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.metaData == null)) {
            break label557;
          }
          i = paramQQAppInterface.metaData.getInt("com.qzone.versioncode");
        }
        catch (PackageManager.NameNotFoundException paramQQAppInterface)
        {
          for (;;)
          {
            paramQQAppInterface.printStackTrace();
            i = 0;
          }
          if (j == 4) {
            break label576;
          }
        }
        if (i < k)
        {
          QLog.e("CliNotifyPush", 1, "not call qzone, versionCode = " + i);
          a(2006);
          return false;
        }
        label557:
        label576:
        if ((j == 301) && (i < m))
        {
          QLog.e("CliNotifyPush", 1, "specialpush not call qzone, versionCode = " + i);
          a(2006);
          return false;
        }
      }
      else
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  qzone not installed");
        a(2005);
        return false;
      }
    }
    QLog.e("CliNotifyPush", 1, "call qzone");
    a(2008);
    return true;
  }
  
  public String[] getPreferSSOCommands()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.a().a(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qzone.ACTION_CALL_QZONE_WNS");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface != null) {}
    try
    {
      localQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, "registerreceiver fail:" + localException);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.a().b(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface != null) {}
    try
    {
      localQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, "unregisterreceiver fail:" + localException);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush")) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
      }
      paramIntent = (byte[])paramFromServiceMsg.attributes.get("pushMsgs");
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).a(0)).a(null, paramFromServiceMsg, localSvcMsgPush);
    }
    for (;;)
    {
      return;
      if ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) || (!paramFromServiceMsg.isSuccess())) {
        break;
      }
      QLog.e("CliNotifyPush", 1, "get qzone push begin");
      paramIntent = a(paramFromServiceMsg);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.values().iterator();
        while (paramIntent.hasNext()) {
          a((SinglePushMsg)paramIntent.next());
        }
      }
    }
    QLog.e("CliNotifyPush", 1, "get qzone push error");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramString = paramBundle.getBundle("data");
      i = paramString.getInt("param.preget_seqid");
      paramString = Long.valueOf(paramString.getLong("param.preget_undealcount", -1L));
    } while (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) == null);
    paramBundle = (SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    if (paramString.longValue() != -1L) {
      paramBundle.jdField_a_of_type_JavaUtilMap.put("count", paramString + "");
    }
    QLog.e("CliNotifyPush", 1, "onWebEvent showPush count:" + paramString);
    b((SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.CliNotifyPush
 * JD-Core Version:    0.7.0.1
 */