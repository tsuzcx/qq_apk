package com.tencent.mobileqq.statistics;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ActivityDAUInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class DAUStatistic
  implements Handler.Callback, UEC.IReporter, Manager
{
  public static boolean a = false;
  private EntityManager b;
  private MqqHandler c;
  private HashMap<String, ActivityDAUInfo> d;
  private QQAppInterface e;
  
  public DAUStatistic(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    this.d = new HashMap(4);
    this.c = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
    a();
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      String[] arrayOfString = paramString2.split("\\|");
      paramString2 = paramString1;
      if (arrayOfString == null) {
        return paramString2;
      }
      int i = 0;
      for (;;)
      {
        paramString2 = paramString1;
        try
        {
          if (i >= arrayOfString.length) {
            return paramString2;
          }
          String str1 = arrayOfString[i];
          int j = str1.indexOf("+");
          int k = str1.indexOf(":");
          paramString2 = paramString1;
          if (j > 0)
          {
            paramString2 = paramString1;
            if (k > 0)
            {
              paramString2 = str1.substring(0, j);
              String str2 = str1.substring(j + 1, k);
              str1 = str1.substring(k + 1);
              paramString2 = UEC.a(paramString1, paramString2, Integer.valueOf(str2).intValue(), Integer.valueOf(str1).intValue());
            }
          }
          i += 1;
          paramString1 = paramString2;
        }
        catch (Exception localException1) {}
      }
      paramString2 = paramString1;
    }
    catch (Exception localException2) {}
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("saveToDB|preActivityList error:");
      paramString2.append(localException2);
      QLog.d("Q.activity_dau", 2, paramString2.toString());
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public void a()
  {
    try
    {
      String str = this.e.getCurrentUin();
      if (Long.valueOf(str).longValue() / 1000L % 1000L < 50L) {
        a = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dau uin=");
        localStringBuilder.append(str);
        localStringBuilder.append(" result=");
        localStringBuilder.append(a);
        QLog.d("UEC", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(ArrayList<UEC.UECItem> paramArrayList)
  {
    if (a)
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramArrayList;
      this.c.sendMessage(localMessage);
    }
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 161	android/os/Message:what	I
    //   4: ifne +454 -> 458
    //   7: aload_1
    //   8: getfield 165	android/os/Message:obj	Ljava/lang/Object;
    //   11: checkcast 176	java/util/ArrayList
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +387 -> 403
    //   19: aload_1
    //   20: invokevirtual 180	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 185 1 0
    //   30: ifeq +373 -> 403
    //   33: aload_1
    //   34: invokeinterface 189 1 0
    //   39: checkcast 191	com/tencent/mobileqq/statistics/UEC$UECItem
    //   42: astore_3
    //   43: aload_3
    //   44: getfield 194	com/tencent/mobileqq/statistics/UEC$UECItem:a	Ljava/lang/String;
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   52: aload_2
    //   53: invokevirtual 198	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   56: ifeq +115 -> 171
    //   59: aload_0
    //   60: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   63: aload_2
    //   64: invokevirtual 202	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 204	com/tencent/mobileqq/data/ActivityDAUInfo
    //   70: astore 4
    //   72: aload 4
    //   74: aload 4
    //   76: getfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   79: iconst_1
    //   80: iadd
    //   81: putfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   84: aload 4
    //   86: aload 4
    //   88: getfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   91: aload_3
    //   92: getfield 213	com/tencent/mobileqq/statistics/UEC$UECItem:c	J
    //   95: ladd
    //   96: putfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   99: aload 4
    //   101: aload 4
    //   103: getfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   106: aload_3
    //   107: getfield 218	com/tencent/mobileqq/statistics/UEC$UECItem:d	I
    //   110: iadd
    //   111: putfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   114: aload 4
    //   116: aload_0
    //   117: aload 4
    //   119: getfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   122: aload_3
    //   123: getfield 224	com/tencent/mobileqq/statistics/UEC$UECItem:g	Ljava/lang/String;
    //   126: invokevirtual 226	com/tencent/mobileqq/statistics/DAUStatistic:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   132: aload 4
    //   134: aload_3
    //   135: getfield 229	com/tencent/mobileqq/statistics/UEC$UECItem:h	Ljava/lang/String;
    //   138: putfield 232	com/tencent/mobileqq/data/ActivityDAUInfo:webTitle	Ljava/lang/String;
    //   141: aload 4
    //   143: aload_3
    //   144: getfield 235	com/tencent/mobileqq/statistics/UEC$UECItem:i	Ljava/lang/String;
    //   147: putfield 238	com/tencent/mobileqq/data/ActivityDAUInfo:domain	Ljava/lang/String;
    //   150: aload 4
    //   152: aload_3
    //   153: getfield 241	com/tencent/mobileqq/statistics/UEC$UECItem:j	Ljava/lang/String;
    //   156: putfield 244	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   159: aload 4
    //   161: aload_3
    //   162: getfield 247	com/tencent/mobileqq/statistics/UEC$UECItem:k	Ljava/lang/String;
    //   165: putfield 250	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   168: goto +98 -> 266
    //   171: new 204	com/tencent/mobileqq/data/ActivityDAUInfo
    //   174: dup
    //   175: invokespecial 251	com/tencent/mobileqq/data/ActivityDAUInfo:<init>	()V
    //   178: astore 4
    //   180: aload 4
    //   182: iconst_1
    //   183: putfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   186: aload 4
    //   188: aload_2
    //   189: putfield 254	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   192: aload 4
    //   194: aload_3
    //   195: getfield 213	com/tencent/mobileqq/statistics/UEC$UECItem:c	J
    //   198: putfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   201: aload 4
    //   203: aload_3
    //   204: getfield 218	com/tencent/mobileqq/statistics/UEC$UECItem:d	I
    //   207: putfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   210: aload 4
    //   212: aload_3
    //   213: getfield 224	com/tencent/mobileqq/statistics/UEC$UECItem:g	Ljava/lang/String;
    //   216: putfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   219: aload 4
    //   221: aload_3
    //   222: getfield 229	com/tencent/mobileqq/statistics/UEC$UECItem:h	Ljava/lang/String;
    //   225: putfield 232	com/tencent/mobileqq/data/ActivityDAUInfo:webTitle	Ljava/lang/String;
    //   228: aload 4
    //   230: aload_3
    //   231: getfield 235	com/tencent/mobileqq/statistics/UEC$UECItem:i	Ljava/lang/String;
    //   234: putfield 238	com/tencent/mobileqq/data/ActivityDAUInfo:domain	Ljava/lang/String;
    //   237: aload 4
    //   239: aload_3
    //   240: getfield 241	com/tencent/mobileqq/statistics/UEC$UECItem:j	Ljava/lang/String;
    //   243: putfield 244	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   246: aload 4
    //   248: aload_3
    //   249: getfield 247	com/tencent/mobileqq/statistics/UEC$UECItem:k	Ljava/lang/String;
    //   252: putfield 250	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   255: aload_0
    //   256: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   259: aload_2
    //   260: aload 4
    //   262: invokevirtual 258	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: pop
    //   266: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -245 -> 24
    //   272: aload_0
    //   273: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   276: aload_2
    //   277: invokevirtual 202	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: checkcast 204	com/tencent/mobileqq/data/ActivityDAUInfo
    //   283: astore_3
    //   284: aload_3
    //   285: ifnull -261 -> 24
    //   288: new 102	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   295: astore 4
    //   297: aload 4
    //   299: ldc_w 260
    //   302: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 4
    //   308: aload_2
    //   309: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 4
    //   315: ldc_w 262
    //   318: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 4
    //   324: aload_3
    //   325: getfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   328: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 4
    //   334: ldc_w 267
    //   337: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 4
    //   343: aload_3
    //   344: getfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   347: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 4
    //   353: ldc_w 272
    //   356: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 4
    //   362: aload_3
    //   363: getfield 244	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   366: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 4
    //   372: ldc_w 274
    //   375: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 4
    //   381: aload_3
    //   382: getfield 250	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   385: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: ldc 114
    //   391: iconst_2
    //   392: aload 4
    //   394: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: goto -376 -> 24
    //   403: aload_0
    //   404: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   407: invokevirtual 277	java/util/HashMap:size	()I
    //   410: iconst_4
    //   411: if_icmplt +22 -> 433
    //   414: aload_0
    //   415: getfield 51	com/tencent/mobileqq/statistics/DAUStatistic:c	Lmqq/os/MqqHandler;
    //   418: iconst_1
    //   419: invokevirtual 280	mqq/os/MqqHandler:removeMessages	(I)V
    //   422: aload_0
    //   423: getfield 51	com/tencent/mobileqq/statistics/DAUStatistic:c	Lmqq/os/MqqHandler;
    //   426: iconst_1
    //   427: invokevirtual 284	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   430: pop
    //   431: iconst_0
    //   432: ireturn
    //   433: aload_0
    //   434: getfield 51	com/tencent/mobileqq/statistics/DAUStatistic:c	Lmqq/os/MqqHandler;
    //   437: iconst_1
    //   438: invokevirtual 287	mqq/os/MqqHandler:hasMessages	(I)Z
    //   441: ifne +555 -> 996
    //   444: aload_0
    //   445: getfield 51	com/tencent/mobileqq/statistics/DAUStatistic:c	Lmqq/os/MqqHandler;
    //   448: iconst_1
    //   449: ldc2_w 288
    //   452: invokevirtual 293	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   455: pop
    //   456: iconst_0
    //   457: ireturn
    //   458: aload_1
    //   459: getfield 161	android/os/Message:what	I
    //   462: iconst_1
    //   463: if_icmpne +533 -> 996
    //   466: ldc 204
    //   468: monitorenter
    //   469: aload_0
    //   470: getfield 295	com/tencent/mobileqq/statistics/DAUStatistic:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   473: ifnonnull +32 -> 505
    //   476: aload_0
    //   477: getfield 31	com/tencent/mobileqq/statistics/DAUStatistic:e	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   480: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   483: ifne +8 -> 491
    //   486: ldc 204
    //   488: monitorexit
    //   489: iconst_0
    //   490: ireturn
    //   491: aload_0
    //   492: aload_0
    //   493: getfield 31	com/tencent/mobileqq/statistics/DAUStatistic:e	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokevirtual 302	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   499: invokevirtual 308	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   502: putfield 295	com/tencent/mobileqq/statistics/DAUStatistic:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   505: aload_0
    //   506: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   509: invokevirtual 312	java/util/HashMap:keySet	()Ljava/util/Set;
    //   512: astore_1
    //   513: aload_0
    //   514: getfield 295	com/tencent/mobileqq/statistics/DAUStatistic:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   517: invokevirtual 318	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   520: astore_2
    //   521: aload_2
    //   522: invokevirtual 323	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   525: aload_1
    //   526: invokeinterface 326 1 0
    //   531: astore_3
    //   532: aload_3
    //   533: invokeinterface 185 1 0
    //   538: ifeq +367 -> 905
    //   541: aload_3
    //   542: invokeinterface 189 1 0
    //   547: checkcast 60	java/lang/String
    //   550: astore 4
    //   552: aload_0
    //   553: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   556: aload 4
    //   558: invokevirtual 202	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   561: checkcast 204	com/tencent/mobileqq/data/ActivityDAUInfo
    //   564: astore 5
    //   566: aload_0
    //   567: getfield 295	com/tencent/mobileqq/statistics/DAUStatistic:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   570: ldc 204
    //   572: aload 4
    //   574: invokevirtual 330	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   577: checkcast 204	com/tencent/mobileqq/data/ActivityDAUInfo
    //   580: astore_1
    //   581: aload_1
    //   582: ifnonnull +56 -> 638
    //   585: new 204	com/tencent/mobileqq/data/ActivityDAUInfo
    //   588: dup
    //   589: invokespecial 251	com/tencent/mobileqq/data/ActivityDAUInfo:<init>	()V
    //   592: astore_1
    //   593: aload_1
    //   594: aload 4
    //   596: putfield 254	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   599: aload_1
    //   600: aload 5
    //   602: getfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   605: putfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   608: aload_1
    //   609: aload 5
    //   611: getfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   614: putfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   617: aload_1
    //   618: aload 5
    //   620: getfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   623: putfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   626: aload_1
    //   627: aload 5
    //   629: getfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   632: putfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   635: goto +62 -> 697
    //   638: aload_1
    //   639: aload_1
    //   640: getfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   643: aload 5
    //   645: getfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   648: iadd
    //   649: putfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   652: aload_1
    //   653: aload_1
    //   654: getfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   657: aload 5
    //   659: getfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   662: ladd
    //   663: putfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   666: aload_1
    //   667: aload_1
    //   668: getfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   671: aload 5
    //   673: getfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   676: iadd
    //   677: putfield 216	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   680: aload_1
    //   681: aload_0
    //   682: aload_1
    //   683: getfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   686: aload 5
    //   688: getfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   691: invokevirtual 226	com/tencent/mobileqq/statistics/DAUStatistic:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   694: putfield 221	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   697: aload_1
    //   698: aload 5
    //   700: getfield 232	com/tencent/mobileqq/data/ActivityDAUInfo:webTitle	Ljava/lang/String;
    //   703: putfield 232	com/tencent/mobileqq/data/ActivityDAUInfo:webTitle	Ljava/lang/String;
    //   706: aload_1
    //   707: aload 5
    //   709: getfield 238	com/tencent/mobileqq/data/ActivityDAUInfo:domain	Ljava/lang/String;
    //   712: putfield 238	com/tencent/mobileqq/data/ActivityDAUInfo:domain	Ljava/lang/String;
    //   715: aload_1
    //   716: aload 5
    //   718: getfield 244	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   721: putfield 244	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   724: aload_1
    //   725: aload 5
    //   727: getfield 250	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   730: putfield 250	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   733: aload_1
    //   734: invokevirtual 333	com/tencent/mobileqq/data/ActivityDAUInfo:getStatus	()I
    //   737: sipush 1000
    //   740: if_icmpne +14 -> 754
    //   743: aload_0
    //   744: getfield 295	com/tencent/mobileqq/statistics/DAUStatistic:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   747: aload_1
    //   748: invokevirtual 337	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   751: goto +32 -> 783
    //   754: aload_1
    //   755: invokevirtual 333	com/tencent/mobileqq/data/ActivityDAUInfo:getStatus	()I
    //   758: sipush 1001
    //   761: if_icmpeq +13 -> 774
    //   764: aload_1
    //   765: invokevirtual 333	com/tencent/mobileqq/data/ActivityDAUInfo:getStatus	()I
    //   768: sipush 1002
    //   771: if_icmpne +12 -> 783
    //   774: aload_0
    //   775: getfield 295	com/tencent/mobileqq/statistics/DAUStatistic:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   778: aload_1
    //   779: invokevirtual 341	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   782: pop
    //   783: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq -254 -> 532
    //   789: new 102	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   796: astore 5
    //   798: aload 5
    //   800: ldc_w 343
    //   803: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 5
    //   809: aload 4
    //   811: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 5
    //   817: ldc_w 262
    //   820: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload 5
    //   826: aload_1
    //   827: getfield 207	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   830: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 5
    //   836: ldc_w 267
    //   839: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 5
    //   845: aload_1
    //   846: getfield 211	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   849: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 5
    //   855: ldc_w 272
    //   858: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: aload 5
    //   864: aload_1
    //   865: getfield 244	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   868: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: aload 5
    //   874: ldc_w 274
    //   877: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload 5
    //   883: aload_1
    //   884: getfield 250	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   887: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: ldc 114
    //   893: iconst_2
    //   894: aload 5
    //   896: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: goto -370 -> 532
    //   905: aload_2
    //   906: invokevirtual 346	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   909: aload_2
    //   910: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   913: goto +15 -> 928
    //   916: astore_1
    //   917: goto +67 -> 984
    //   920: astore_1
    //   921: aload_1
    //   922: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   925: goto -16 -> 909
    //   928: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq +41 -> 972
    //   934: new 102	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   941: astore_1
    //   942: aload_1
    //   943: ldc_w 351
    //   946: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_1
    //   951: aload_0
    //   952: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   955: invokevirtual 277	java/util/HashMap:size	()I
    //   958: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: ldc 114
    //   964: iconst_2
    //   965: aload_1
    //   966: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   969: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   972: aload_0
    //   973: getfield 38	com/tencent/mobileqq/statistics/DAUStatistic:d	Ljava/util/HashMap;
    //   976: invokevirtual 354	java/util/HashMap:clear	()V
    //   979: ldc 204
    //   981: monitorexit
    //   982: iconst_0
    //   983: ireturn
    //   984: aload_2
    //   985: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   988: aload_1
    //   989: athrow
    //   990: astore_1
    //   991: ldc 204
    //   993: monitorexit
    //   994: aload_1
    //   995: athrow
    //   996: iconst_0
    //   997: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	998	0	this	DAUStatistic
    //   0	998	1	paramMessage	Message
    //   47	938	2	localObject1	Object
    //   42	500	3	localObject2	Object
    //   70	740	4	localObject3	Object
    //   564	331	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   521	532	916	finally
    //   532	581	916	finally
    //   585	635	916	finally
    //   638	697	916	finally
    //   697	751	916	finally
    //   754	774	916	finally
    //   774	783	916	finally
    //   783	902	916	finally
    //   905	909	916	finally
    //   921	925	916	finally
    //   521	532	920	java/lang/Exception
    //   532	581	920	java/lang/Exception
    //   585	635	920	java/lang/Exception
    //   638	697	920	java/lang/Exception
    //   697	751	920	java/lang/Exception
    //   754	774	920	java/lang/Exception
    //   774	783	920	java/lang/Exception
    //   783	902	920	java/lang/Exception
    //   905	909	920	java/lang/Exception
    //   469	489	990	finally
    //   491	505	990	finally
    //   505	521	990	finally
    //   909	913	990	finally
    //   928	972	990	finally
    //   972	982	990	finally
    //   984	990	990	finally
    //   991	994	990	finally
  }
  
  public void onDestroy()
  {
    a = false;
    EntityManager localEntityManager = this.b;
    if (localEntityManager != null) {
      try
      {
        localEntityManager.close();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DAUStatistic
 * JD-Core Version:    0.7.0.1
 */