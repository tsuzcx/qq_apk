package com.tencent.mobileqq.config.operation;

import android.text.TextUtils;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQOperateManager
{
  private static QQOperateManager b;
  private static Object i = new Object();
  private static String j;
  int a;
  private CopyOnWriteArrayList<QQOperationViopTipTask> c = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<QQOperationTaskRecord> d = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<QQOperationVoipTipsTaskExcuteRecord> e = new CopyOnWriteArrayList();
  private ArrayList<QQOperateTipNativeShowInfo> f = new ArrayList();
  private ArrayList<QQOperationViopTipTask> g = new ArrayList();
  private long h = System.currentTimeMillis();
  
  public static QQOperateManager a(QQAppInterface paramQQAppInterface)
  {
    synchronized (i)
    {
      if ((b == null) || (!b.a()) || (!paramQQAppInterface.getCurrentAccountUin().equals(j)))
      {
        b = new QQOperateManager();
        j = paramQQAppInterface.getCurrentAccountUin();
        b.b(paramQQAppInterface);
      }
      paramQQAppInterface = b;
      return paramQQAppInterface;
    }
  }
  
  public static boolean a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    localCalendar1.setTimeInMillis(paramLong);
    return localCalendar2.get(5) == localCalendar1.get(5);
  }
  
  /* Error */
  private void b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: invokevirtual 102	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   7: aload_0
    //   8: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:d	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   11: invokevirtual 102	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   14: aload_0
    //   15: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   18: invokevirtual 102	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   21: aload_0
    //   22: getfield 50	com/tencent/mobileqq/config/operation/QQOperateManager:g	Ljava/util/ArrayList;
    //   25: invokevirtual 103	java/util/ArrayList:clear	()V
    //   28: aload_0
    //   29: getfield 48	com/tencent/mobileqq/config/operation/QQOperateManager:f	Ljava/util/ArrayList;
    //   32: invokevirtual 103	java/util/ArrayList:clear	()V
    //   35: getstatic 72	com/tencent/mobileqq/config/operation/QQOperateManager:j	Ljava/lang/String;
    //   38: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +4 -> 45
    //   44: return
    //   45: invokestatic 115	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   48: invokestatic 121	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   51: astore 5
    //   53: new 123	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   60: astore 6
    //   62: aload 6
    //   64: getstatic 72	com/tencent/mobileqq/config/operation/QQOperateManager:j	Ljava/lang/String;
    //   67: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: ldc 130
    //   75: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: aload 5
    //   82: aload 6
    //   84: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: iconst_0
    //   88: invokeinterface 139 3 0
    //   93: putfield 141	com/tencent/mobileqq/config/operation/QQOperateManager:a	I
    //   96: new 123	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   103: astore 6
    //   105: aload 6
    //   107: getstatic 72	com/tencent/mobileqq/config/operation/QQOperateManager:j	Ljava/lang/String;
    //   110: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 6
    //   116: ldc 143
    //   118: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 5
    //   124: aload 6
    //   126: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: lconst_0
    //   130: invokeinterface 147 4 0
    //   135: lstore_3
    //   136: aload_0
    //   137: getfield 141	com/tencent/mobileqq/config/operation/QQOperateManager:a	I
    //   140: ifeq +16 -> 156
    //   143: lload_3
    //   144: lconst_0
    //   145: lcmp
    //   146: ifeq +10 -> 156
    //   149: lload_3
    //   150: invokestatic 149	com/tencent/mobileqq/config/operation/QQOperateManager:a	(J)Z
    //   153: ifne +105 -> 258
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 141	com/tencent/mobileqq/config/operation/QQOperateManager:a	I
    //   161: aload 5
    //   163: invokeinterface 153 1 0
    //   168: astore 5
    //   170: new 123	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   177: astore 6
    //   179: aload 6
    //   181: getstatic 72	com/tencent/mobileqq/config/operation/QQOperateManager:j	Ljava/lang/String;
    //   184: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 6
    //   190: ldc 130
    //   192: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 5
    //   198: aload 6
    //   200: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: iconst_0
    //   204: invokeinterface 159 3 0
    //   209: astore 5
    //   211: new 123	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   218: astore 6
    //   220: aload 6
    //   222: getstatic 72	com/tencent/mobileqq/config/operation/QQOperateManager:j	Ljava/lang/String;
    //   225: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 6
    //   231: ldc 143
    //   233: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 5
    //   239: aload 6
    //   241: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   247: invokeinterface 163 4 0
    //   252: invokeinterface 166 1 0
    //   257: pop
    //   258: aload_1
    //   259: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   262: invokevirtual 176	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   265: astore_1
    //   266: aload_1
    //   267: ldc 178
    //   269: new 178	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   272: dup
    //   273: invokespecial 179	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   276: invokevirtual 182	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getTableName	()Ljava/lang/String;
    //   279: iconst_0
    //   280: aconst_null
    //   281: aconst_null
    //   282: aconst_null
    //   283: aconst_null
    //   284: aconst_null
    //   285: aconst_null
    //   286: invokevirtual 188	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   289: astore 5
    //   291: aload 5
    //   293: ifnull +187 -> 480
    //   296: aload 5
    //   298: invokeinterface 194 1 0
    //   303: ifle +177 -> 480
    //   306: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   309: ifeq +44 -> 353
    //   312: new 123	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   319: astore 6
    //   321: aload 6
    //   323: ldc 201
    //   325: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 6
    //   331: aload 5
    //   333: invokeinterface 194 1 0
    //   338: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: ldc 206
    //   344: iconst_4
    //   345: aload 6
    //   347: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload_0
    //   354: getfield 39	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   357: aload 5
    //   359: checkcast 45	java/util/ArrayList
    //   362: invokevirtual 213	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   365: pop
    //   366: aload_0
    //   367: getfield 39	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   370: invokevirtual 217	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   373: astore 5
    //   375: aload 5
    //   377: invokeinterface 222 1 0
    //   382: ifeq +98 -> 480
    //   385: aload 5
    //   387: invokeinterface 226 1 0
    //   392: checkcast 178	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   395: astore 6
    //   397: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   400: lstore_3
    //   401: aload 6
    //   403: invokevirtual 230	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getEndDate	()Ljava/util/Date;
    //   406: astore 7
    //   408: aload 6
    //   410: invokevirtual 233	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getBeginDate	()Ljava/util/Date;
    //   413: astore 8
    //   415: aload 7
    //   417: ifnull +13 -> 430
    //   420: lload_3
    //   421: aload 7
    //   423: invokevirtual 238	java/util/Date:getTime	()J
    //   426: lcmp
    //   427: ifgt +18 -> 445
    //   430: aload 8
    //   432: ifnull -57 -> 375
    //   435: lload_3
    //   436: aload 8
    //   438: invokevirtual 238	java/util/Date:getTime	()J
    //   441: lcmp
    //   442: ifge -67 -> 375
    //   445: aload_0
    //   446: getfield 39	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   449: aload 6
    //   451: invokevirtual 241	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   454: pop
    //   455: aload 7
    //   457: ifnull -82 -> 375
    //   460: lload_3
    //   461: aload 7
    //   463: invokevirtual 238	java/util/Date:getTime	()J
    //   466: lcmp
    //   467: ifle -92 -> 375
    //   470: aload_1
    //   471: aload 6
    //   473: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   476: pop
    //   477: goto -102 -> 375
    //   480: aload_1
    //   481: ldc 246
    //   483: new 246	com/tencent/mobileqq/config/operation/QQOperationTaskRecord
    //   486: dup
    //   487: invokespecial 247	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:<init>	()V
    //   490: invokevirtual 248	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:getTableName	()Ljava/lang/String;
    //   493: iconst_0
    //   494: aconst_null
    //   495: aconst_null
    //   496: aconst_null
    //   497: aconst_null
    //   498: aconst_null
    //   499: aconst_null
    //   500: invokevirtual 188	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   503: astore 5
    //   505: aload 5
    //   507: ifnull +163 -> 670
    //   510: aload 5
    //   512: invokeinterface 194 1 0
    //   517: ifle +153 -> 670
    //   520: aload_0
    //   521: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:d	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   524: aload 5
    //   526: checkcast 45	java/util/ArrayList
    //   529: invokevirtual 213	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   532: pop
    //   533: aload_0
    //   534: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:d	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   537: invokevirtual 217	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   540: astore 5
    //   542: aload 5
    //   544: invokeinterface 222 1 0
    //   549: ifeq +121 -> 670
    //   552: aload 5
    //   554: invokeinterface 226 1 0
    //   559: checkcast 246	com/tencent/mobileqq/config/operation/QQOperationTaskRecord
    //   562: astore 6
    //   564: aload_0
    //   565: getfield 39	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   568: invokevirtual 217	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   571: astore 7
    //   573: aload 7
    //   575: invokeinterface 222 1 0
    //   580: ifeq +809 -> 1389
    //   583: aload 7
    //   585: invokeinterface 226 1 0
    //   590: checkcast 178	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   593: astore 8
    //   595: aload 6
    //   597: getfield 251	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:taskid	I
    //   600: aload 8
    //   602: getfield 252	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   605: if_icmpne -32 -> 573
    //   608: iconst_1
    //   609: istore_2
    //   610: goto +3 -> 613
    //   613: iload_2
    //   614: ifne +20 -> 634
    //   617: aload_0
    //   618: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:d	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   621: aload 6
    //   623: invokevirtual 241	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   626: pop
    //   627: aload_1
    //   628: aload 6
    //   630: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   633: pop
    //   634: aload 6
    //   636: getfield 255	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:recordTime	J
    //   639: invokestatic 149	com/tencent/mobileqq/config/operation/QQOperateManager:a	(J)Z
    //   642: ifne -100 -> 542
    //   645: aload 6
    //   647: ldc_w 257
    //   650: putfield 260	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:hasShowedUins	Ljava/lang/String;
    //   653: aload 6
    //   655: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   658: putfield 255	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:recordTime	J
    //   661: aload_1
    //   662: aload 6
    //   664: invokevirtual 264	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   667: goto -125 -> 542
    //   670: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   673: ifeq +45 -> 718
    //   676: new 123	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   683: astore 5
    //   685: aload 5
    //   687: ldc_w 266
    //   690: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 5
    //   696: aload_0
    //   697: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:d	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   700: invokevirtual 267	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   703: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: ldc 206
    //   709: iconst_4
    //   710: aload 5
    //   712: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload_1
    //   719: ldc_w 269
    //   722: new 269	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord
    //   725: dup
    //   726: invokespecial 270	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:<init>	()V
    //   729: invokevirtual 271	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:getTableName	()Ljava/lang/String;
    //   732: iconst_0
    //   733: aconst_null
    //   734: aconst_null
    //   735: aconst_null
    //   736: aconst_null
    //   737: aconst_null
    //   738: aconst_null
    //   739: invokevirtual 188	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   742: astore 5
    //   744: aload 5
    //   746: ifnull +88 -> 834
    //   749: aload 5
    //   751: invokeinterface 194 1 0
    //   756: ifle +78 -> 834
    //   759: aload_0
    //   760: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   763: aload 5
    //   765: checkcast 45	java/util/ArrayList
    //   768: invokevirtual 213	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   771: pop
    //   772: aload_0
    //   773: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   776: invokevirtual 217	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   779: astore 5
    //   781: aload 5
    //   783: invokeinterface 222 1 0
    //   788: ifeq +46 -> 834
    //   791: aload 5
    //   793: invokeinterface 226 1 0
    //   798: checkcast 269	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord
    //   801: astore 6
    //   803: aload 6
    //   805: getfield 274	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:time	J
    //   808: invokestatic 149	com/tencent/mobileqq/config/operation/QQOperateManager:a	(J)Z
    //   811: ifne -30 -> 781
    //   814: aload_0
    //   815: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   818: aload 6
    //   820: invokevirtual 241	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   823: pop
    //   824: aload_1
    //   825: aload 6
    //   827: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   830: pop
    //   831: goto -50 -> 781
    //   834: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   837: ifeq +45 -> 882
    //   840: new 123	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   847: astore 5
    //   849: aload 5
    //   851: ldc_w 276
    //   854: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload 5
    //   860: aload_0
    //   861: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   864: invokevirtual 267	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   867: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: ldc 206
    //   873: iconst_4
    //   874: aload 5
    //   876: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   882: aload_0
    //   883: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   886: invokevirtual 217	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   889: astore 5
    //   891: aload 5
    //   893: invokeinterface 222 1 0
    //   898: ifeq +257 -> 1155
    //   901: aload 5
    //   903: invokeinterface 226 1 0
    //   908: checkcast 269	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord
    //   911: astore 6
    //   913: aload 6
    //   915: getfield 277	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:taskid	I
    //   918: iconst_m1
    //   919: if_icmpeq +80 -> 999
    //   922: aload_0
    //   923: aload 6
    //   925: getfield 277	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:taskid	I
    //   928: invokevirtual 280	com/tencent/mobileqq/config/operation/QQOperateManager:a	(I)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   931: astore 6
    //   933: aload 6
    //   935: ifnull +13 -> 948
    //   938: aload_0
    //   939: getfield 50	com/tencent/mobileqq/config/operation/QQOperateManager:g	Ljava/util/ArrayList;
    //   942: aload 6
    //   944: invokevirtual 283	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   947: pop
    //   948: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   951: ifeq -60 -> 891
    //   954: new 123	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   961: astore 6
    //   963: aload 6
    //   965: ldc_w 285
    //   968: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload 6
    //   974: aload_0
    //   975: getfield 50	com/tencent/mobileqq/config/operation/QQOperateManager:g	Ljava/util/ArrayList;
    //   978: invokevirtual 286	java/util/ArrayList:size	()I
    //   981: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: ldc 206
    //   987: iconst_4
    //   988: aload 6
    //   990: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: goto -105 -> 891
    //   999: aload_0
    //   1000: getfield 48	com/tencent/mobileqq/config/operation/QQOperateManager:f	Ljava/util/ArrayList;
    //   1003: invokevirtual 287	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1006: astore 7
    //   1008: aload 7
    //   1010: invokeinterface 222 1 0
    //   1015: ifeq +379 -> 1394
    //   1018: aload 7
    //   1020: invokeinterface 226 1 0
    //   1025: checkcast 289	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo
    //   1028: astore 8
    //   1030: aload 8
    //   1032: getfield 291	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:b	I
    //   1035: aload 6
    //   1037: getfield 294	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:uinType	I
    //   1040: if_icmpne -32 -> 1008
    //   1043: aload 8
    //   1045: getfield 295	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:a	I
    //   1048: aload 6
    //   1050: getfield 298	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:tipType	I
    //   1053: if_icmpne -45 -> 1008
    //   1056: iconst_1
    //   1057: istore_2
    //   1058: goto +3 -> 1061
    //   1061: iload_2
    //   1062: ifne +42 -> 1104
    //   1065: new 289	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo
    //   1068: dup
    //   1069: invokespecial 299	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:<init>	()V
    //   1072: astore 7
    //   1074: aload 7
    //   1076: aload 6
    //   1078: getfield 294	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:uinType	I
    //   1081: putfield 291	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:b	I
    //   1084: aload 7
    //   1086: aload 6
    //   1088: getfield 298	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:tipType	I
    //   1091: putfield 295	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:a	I
    //   1094: aload_0
    //   1095: getfield 48	com/tencent/mobileqq/config/operation/QQOperateManager:f	Ljava/util/ArrayList;
    //   1098: aload 7
    //   1100: invokevirtual 283	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1103: pop
    //   1104: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1107: ifeq -216 -> 891
    //   1110: new 123	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1117: astore 6
    //   1119: aload 6
    //   1121: ldc_w 301
    //   1124: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload 6
    //   1130: aload_0
    //   1131: getfield 48	com/tencent/mobileqq/config/operation/QQOperateManager:f	Ljava/util/ArrayList;
    //   1134: invokevirtual 286	java/util/ArrayList:size	()I
    //   1137: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: ldc 206
    //   1143: iconst_4
    //   1144: aload 6
    //   1146: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1152: goto -261 -> 891
    //   1155: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1158: ifeq +213 -> 1371
    //   1161: new 123	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1168: astore 5
    //   1170: aload 5
    //   1172: ldc_w 303
    //   1175: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 5
    //   1181: aload_0
    //   1182: getfield 39	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1185: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: ldc 206
    //   1191: iconst_4
    //   1192: aload 5
    //   1194: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1197: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1200: new 123	java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1207: astore 5
    //   1209: aload 5
    //   1211: ldc_w 308
    //   1214: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: aload 5
    //   1220: aload_0
    //   1221: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:d	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1224: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1227: pop
    //   1228: ldc 206
    //   1230: iconst_4
    //   1231: aload 5
    //   1233: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1239: new 123	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1246: astore 5
    //   1248: aload 5
    //   1250: ldc_w 310
    //   1253: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: aload 5
    //   1259: aload_0
    //   1260: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1263: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: ldc 206
    //   1269: iconst_4
    //   1270: aload 5
    //   1272: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1278: new 123	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1285: astore 5
    //   1287: aload 5
    //   1289: ldc_w 312
    //   1292: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: aload 5
    //   1298: aload_0
    //   1299: getfield 50	com/tencent/mobileqq/config/operation/QQOperateManager:g	Ljava/util/ArrayList;
    //   1302: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: ldc 206
    //   1308: iconst_4
    //   1309: aload 5
    //   1311: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1314: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1317: new 123	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   1324: astore 5
    //   1326: aload 5
    //   1328: ldc_w 314
    //   1331: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: aload 5
    //   1337: aload_0
    //   1338: getfield 48	com/tencent/mobileqq/config/operation/QQOperateManager:f	Ljava/util/ArrayList;
    //   1341: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1344: pop
    //   1345: ldc 206
    //   1347: iconst_4
    //   1348: aload 5
    //   1350: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1353: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1356: goto +15 -> 1371
    //   1359: astore 5
    //   1361: goto +15 -> 1376
    //   1364: astore 5
    //   1366: aload 5
    //   1368: invokevirtual 317	java/lang/Exception:printStackTrace	()V
    //   1371: aload_1
    //   1372: invokevirtual 320	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1375: return
    //   1376: aload_1
    //   1377: invokevirtual 320	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1380: goto +6 -> 1386
    //   1383: aload 5
    //   1385: athrow
    //   1386: goto -3 -> 1383
    //   1389: iconst_0
    //   1390: istore_2
    //   1391: goto -778 -> 613
    //   1394: iconst_0
    //   1395: istore_2
    //   1396: goto -335 -> 1061
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1399	0	this	QQOperateManager
    //   0	1399	1	paramQQAppInterface	QQAppInterface
    //   609	787	2	k	int
    //   135	326	3	l	long
    //   51	1298	5	localObject1	Object
    //   1359	1	5	localObject2	Object
    //   1364	20	5	localException	java.lang.Exception
    //   60	1085	6	localObject3	Object
    //   406	693	7	localObject4	Object
    //   413	631	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   266	291	1359	finally
    //   296	353	1359	finally
    //   353	375	1359	finally
    //   375	415	1359	finally
    //   420	430	1359	finally
    //   435	445	1359	finally
    //   445	455	1359	finally
    //   460	477	1359	finally
    //   480	505	1359	finally
    //   510	542	1359	finally
    //   542	573	1359	finally
    //   573	608	1359	finally
    //   617	634	1359	finally
    //   634	667	1359	finally
    //   670	718	1359	finally
    //   718	744	1359	finally
    //   749	781	1359	finally
    //   781	831	1359	finally
    //   834	882	1359	finally
    //   882	891	1359	finally
    //   891	933	1359	finally
    //   938	948	1359	finally
    //   948	996	1359	finally
    //   999	1008	1359	finally
    //   1008	1056	1359	finally
    //   1065	1104	1359	finally
    //   1104	1152	1359	finally
    //   1155	1356	1359	finally
    //   1366	1371	1359	finally
    //   266	291	1364	java/lang/Exception
    //   296	353	1364	java/lang/Exception
    //   353	375	1364	java/lang/Exception
    //   375	415	1364	java/lang/Exception
    //   420	430	1364	java/lang/Exception
    //   435	445	1364	java/lang/Exception
    //   445	455	1364	java/lang/Exception
    //   460	477	1364	java/lang/Exception
    //   480	505	1364	java/lang/Exception
    //   510	542	1364	java/lang/Exception
    //   542	573	1364	java/lang/Exception
    //   573	608	1364	java/lang/Exception
    //   617	634	1364	java/lang/Exception
    //   634	667	1364	java/lang/Exception
    //   670	718	1364	java/lang/Exception
    //   718	744	1364	java/lang/Exception
    //   749	781	1364	java/lang/Exception
    //   781	831	1364	java/lang/Exception
    //   834	882	1364	java/lang/Exception
    //   882	891	1364	java/lang/Exception
    //   891	933	1364	java/lang/Exception
    //   938	948	1364	java/lang/Exception
    //   948	996	1364	java/lang/Exception
    //   999	1008	1364	java/lang/Exception
    //   1008	1056	1364	java/lang/Exception
    //   1065	1104	1364	java/lang/Exception
    //   1104	1152	1364	java/lang/Exception
    //   1155	1356	1364	java/lang/Exception
  }
  
  public static void c()
  {
    if (b == null) {
      return;
    }
    synchronized (i)
    {
      b.b();
      b = null;
      return;
    }
  }
  
  public int a(int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = this.e.iterator();
    QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord;
    do
    {
      boolean bool = localIterator.hasNext();
      k = 0;
      if (!bool) {
        break;
      }
      localQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localIterator.next();
    } while ((localQQOperationVoipTipsTaskExcuteRecord.taskid != paramInt1) || (!localQQOperationVoipTipsTaskExcuteRecord.uin.equals(paramString)) || (localQQOperationVoipTipsTaskExcuteRecord.uinType != paramInt2));
    int k = 0 + localQQOperationVoipTipsTaskExcuteRecord.count;
    return k;
  }
  
  public QQOperationRequestInfo a(String paramString, int paramInt1, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, boolean paramBoolean, int paramInt2)
  {
    label303:
    synchronized (i)
    {
      long l = System.currentTimeMillis();
      Object localObject2 = new ArrayList();
      boolean bool = a(paramString, paramInt1, 1, paramQQAppInterface, paramList, (ArrayList)localObject2, paramBoolean, paramInt2);
      paramBoolean = a(paramString, paramInt1, 2, paramQQAppInterface, paramList, (ArrayList)localObject2, paramBoolean, paramInt2);
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder();
        paramString.append("voip_request_panduan_time = ");
        paramString.append(System.currentTimeMillis() - l);
        QLog.d("QQOperateVoIP", 4, paramString.toString());
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("voip_request_isNeed  blue = ");
        paramString.append(bool);
        paramString.append(" gray = ");
        paramString.append(paramBoolean);
        QLog.d("QQOperateVoIP", 2, paramString.toString());
      }
      paramString = new QQOperationRequestInfo();
      if (!bool) {
        if (paramBoolean)
        {
          break label303;
          paramString.a = paramBoolean;
          paramString.b = ((ArrayList)localObject2);
          if (QLog.isDevelopLevel())
          {
            paramQQAppInterface = ((ArrayList)localObject2).iterator();
            while (paramQQAppInterface.hasNext())
            {
              paramList = (QQOperationRequestTaskInfo)paramQQAppInterface.next();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("isNeedRequestForTips2 ..request taskid = .... ");
              ((StringBuilder)localObject2).append(paramList.a);
              QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject2).toString());
            }
          }
          if (paramString.a) {
            this.a += 1;
          }
          return paramString;
        }
      }
    }
  }
  
  public QQOperationViopTipTask a(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if (localQQOperationViopTipTask.taskid == paramInt) {
        return localQQOperationViopTipTask;
      }
    }
    return null;
  }
  
  public QQOperationVoipTipsTaskExcuteRecord a(QQOperationVoipTipsTaskExcuteRecord paramQQOperationVoipTipsTaskExcuteRecord)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localIterator.next();
      if ((localQQOperationVoipTipsTaskExcuteRecord != null) && (localQQOperationVoipTipsTaskExcuteRecord.taskid == paramQQOperationVoipTipsTaskExcuteRecord.taskid) && (localQQOperationVoipTipsTaskExcuteRecord.tipType == paramQQOperationVoipTipsTaskExcuteRecord.tipType) && (localQQOperationVoipTipsTaskExcuteRecord.uin != null) && (localQQOperationVoipTipsTaskExcuteRecord.uin.equals(paramQQOperationVoipTipsTaskExcuteRecord.uin)) && (localQQOperationVoipTipsTaskExcuteRecord.uinType == paramQQOperationVoipTipsTaskExcuteRecord.uinType)) {
        return localQQOperationVoipTipsTaskExcuteRecord;
      }
    }
    return null;
  }
  
  public ArrayList<String> a(String paramString, int paramInt, QQOperationViopTipTask paramQQOperationViopTipTask, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    paramString = paramQQOperationViopTipTask.getKeywordList();
    paramQQOperationViopTipTask = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramQQAppInterface = paramList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramList = (ChatMessage)paramQQAppInterface.next();
        if ((paramList.msgtype == -1000) && (!TextUtils.isEmpty(paramList.msg)))
        {
          Iterator localIterator = paramString.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!TextUtils.isEmpty(str)) && (paramList.msg.contains(str)) && (!paramQQOperationViopTipTask.contains(str))) {
              paramQQOperationViopTipTask.add(str);
            }
          }
        }
      }
    }
    return paramQQOperationViopTipTask;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
    localQQOperationVoipTipsTaskExcuteRecord.taskid = -1;
    localQQOperationVoipTipsTaskExcuteRecord.uinType = paramInt1;
    localQQOperationVoipTipsTaskExcuteRecord.tipType = paramInt2;
    localQQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
    localQQOperationVoipTipsTaskExcuteRecord.uin = "0";
    a(paramQQAppInterface, localQQOperationVoipTipsTaskExcuteRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, QQOperationVoipTipsTaskExcuteRecord paramQQOperationVoipTipsTaskExcuteRecord)
  {
    if (paramQQOperationVoipTipsTaskExcuteRecord == null) {
      return;
    }
    Object localObject1;
    int k;
    label804:
    label809:
    synchronized (i)
    {
      localObject1 = a(paramQQOperationVoipTipsTaskExcuteRecord);
      k = 1;
      if (localObject1 == null)
      {
        this.e.add(paramQQOperationVoipTipsTaskExcuteRecord);
      }
      else
      {
        ((QQOperationVoipTipsTaskExcuteRecord)localObject1).count += 1;
        paramQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localObject1;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addVoipTipTaskExcuteRecord record.taskid = ");
        ((StringBuilder)localObject1).append(paramQQOperationVoipTipsTaskExcuteRecord.taskid);
        ((StringBuilder)localObject1).append(" TodayRecord : ");
        ((StringBuilder)localObject1).append(this.e);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject1).toString());
      }
      EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      int n = paramQQOperationVoipTipsTaskExcuteRecord.taskid;
      int m = 0;
      if (n == -1)
      {
        paramQQAppInterface = this.f.iterator();
        for (;;)
        {
          if (!paramQQAppInterface.hasNext()) {
            break label804;
          }
          localObject1 = (QQOperateTipNativeShowInfo)paramQQAppInterface.next();
          if ((((QQOperateTipNativeShowInfo)localObject1).b == paramQQOperationVoipTipsTaskExcuteRecord.uinType) && (((QQOperateTipNativeShowInfo)localObject1).a == paramQQOperationVoipTipsTaskExcuteRecord.tipType)) {
            break;
          }
        }
        if (k == 0)
        {
          paramQQAppInterface = new QQOperateTipNativeShowInfo();
          paramQQAppInterface.b = paramQQOperationVoipTipsTaskExcuteRecord.uinType;
          paramQQAppInterface.a = paramQQOperationVoipTipsTaskExcuteRecord.tipType;
          this.f.add(paramQQAppInterface);
        }
        if (QLog.isDevelopLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("Update TodayNativeShow :");
          paramQQAppInterface.append(this.f);
          QLog.d("QQOperateVoIP", 4, paramQQAppInterface.toString());
        }
      }
      else
      {
        paramQQAppInterface = this.g.iterator();
        do
        {
          k = m;
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
        } while (((QQOperationViopTipTask)paramQQAppInterface.next()).taskid != paramQQOperationVoipTipsTaskExcuteRecord.taskid);
        k = 1;
        if (k == 0)
        {
          paramQQAppInterface = a(paramQQOperationVoipTipsTaskExcuteRecord.taskid);
          this.g.add(paramQQAppInterface);
        }
        if (QLog.isDevelopLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("Update TodayNetShow :");
          paramQQAppInterface.append(this.g);
          QLog.d("QQOperateVoIP", 4, paramQQAppInterface.toString());
        }
        paramQQAppInterface = null;
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (QQOperationTaskRecord)localIterator.next();
          if (((QQOperationTaskRecord)localObject1).taskid == paramQQOperationVoipTipsTaskExcuteRecord.taskid)
          {
            ((QQOperationTaskRecord)localObject1).addUinShowCount(paramQQOperationVoipTipsTaskExcuteRecord.uin);
            paramQQAppInterface = ((QQOperationTaskRecord)localObject1).hasShowedUins;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramQQOperationVoipTipsTaskExcuteRecord.uin);
            localStringBuilder.append("_");
            localStringBuilder.append(paramQQOperationVoipTipsTaskExcuteRecord.uinType);
            if (!paramQQAppInterface.contains(localStringBuilder.toString()))
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(((QQOperationTaskRecord)localObject1).hasShowedUins);
              paramQQAppInterface.append(paramQQOperationVoipTipsTaskExcuteRecord.uin);
              paramQQAppInterface.append("_");
              paramQQAppInterface.append(paramQQOperationVoipTipsTaskExcuteRecord.uinType);
              paramQQAppInterface.append("|");
              ((QQOperationTaskRecord)localObject1).hasShowedUins = paramQQAppInterface.toString();
              ((QQOperationTaskRecord)localObject1).aioCount += 1;
            }
            if (!QLog.isDevelopLevel()) {
              break label809;
            }
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("QQOperationTaskRecord record.taskid = ");
            paramQQAppInterface.append(((QQOperationTaskRecord)localObject1).taskid);
            paramQQAppInterface.append(" existTaskRecord.showCount = ");
            paramQQAppInterface.append(((QQOperationTaskRecord)localObject1).showCount);
            paramQQAppInterface.append(" existTaskRecord.aioCount = ");
            paramQQAppInterface.append(((QQOperationTaskRecord)localObject1).aioCount);
            QLog.d("QQOperateVoIP", 4, paramQQAppInterface.toString());
            break label809;
          }
        }
        localObject1 = paramQQAppInterface;
        if (paramQQAppInterface == null)
        {
          localObject1 = new QQOperationTaskRecord();
          ((QQOperationTaskRecord)localObject1).taskid = paramQQOperationVoipTipsTaskExcuteRecord.taskid;
          ((QQOperationTaskRecord)localObject1).aioCount = 1;
          ((QQOperationTaskRecord)localObject1).addUinShowCount(paramQQOperationVoipTipsTaskExcuteRecord.uin);
          ((QQOperationTaskRecord)localObject1).recordTime = System.currentTimeMillis();
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(paramQQOperationVoipTipsTaskExcuteRecord.uin);
          paramQQAppInterface.append("_");
          paramQQAppInterface.append(paramQQOperationVoipTipsTaskExcuteRecord.uinType);
          paramQQAppInterface.append("|");
          ((QQOperationTaskRecord)localObject1).hasShowedUins = paramQQAppInterface.toString();
          this.d.add(localObject1);
        }
        ((QQOperationTaskRecord)localObject1).setStatus(1000);
        localEntityManager.persistOrReplace((Entity)localObject1);
      }
      paramQQOperationVoipTipsTaskExcuteRecord.setStatus(1000);
      localEntityManager.persistOrReplace(paramQQOperationVoipTipsTaskExcuteRecord);
      localEntityManager.close();
      return;
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    // Byte code:
    //   0: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +35 -> 38
    //   6: new 123	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 429
    //   18: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_2
    //   24: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 206
    //   30: iconst_4
    //   31: aload_3
    //   32: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_2
    //   39: ifnull +148 -> 187
    //   42: aload_2
    //   43: invokevirtual 286	java/util/ArrayList:size	()I
    //   46: ifne +4 -> 50
    //   49: return
    //   50: aload_1
    //   51: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   54: invokevirtual 176	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 433	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 438	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   67: aload_3
    //   68: ldc 178
    //   70: invokevirtual 442	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   73: pop
    //   74: aload_2
    //   75: invokevirtual 287	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   78: astore 4
    //   80: aload 4
    //   82: invokeinterface 222 1 0
    //   87: ifeq +20 -> 107
    //   90: aload_3
    //   91: aload 4
    //   93: invokeinterface 226 1 0
    //   98: checkcast 178	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   101: invokevirtual 264	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   104: goto -24 -> 80
    //   107: invokestatic 199	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   110: ifeq +42 -> 152
    //   113: new 123	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   120: astore 4
    //   122: aload 4
    //   124: ldc_w 444
    //   127: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 4
    //   133: aload_2
    //   134: invokevirtual 286	java/util/ArrayList:size	()I
    //   137: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 206
    //   143: iconst_4
    //   144: aload 4
    //   146: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_1
    //   153: invokevirtual 446	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   156: goto +12 -> 168
    //   159: astore_2
    //   160: goto +21 -> 181
    //   163: astore_2
    //   164: aload_2
    //   165: invokevirtual 317	java/lang/Exception:printStackTrace	()V
    //   168: aload_1
    //   169: invokevirtual 449	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   172: aload_3
    //   173: invokevirtual 320	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   176: aload_0
    //   177: invokevirtual 322	com/tencent/mobileqq/config/operation/QQOperateManager:b	()V
    //   180: return
    //   181: aload_1
    //   182: invokevirtual 449	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   185: aload_2
    //   186: athrow
    //   187: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	QQOperateManager
    //   0	188	1	paramQQAppInterface	QQAppInterface
    //   0	188	2	paramArrayList	ArrayList<QQOperationViopTipTask>
    //   13	160	3	localObject1	Object
    //   78	67	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	80	159	finally
    //   80	104	159	finally
    //   107	152	159	finally
    //   152	156	159	finally
    //   164	168	159	finally
    //   63	80	163	java/lang/Exception
    //   80	104	163	java/lang/Exception
    //   107	152	163	java/lang/Exception
    //   152	156	163	java/lang/Exception
  }
  
  public void a(String paramString, int paramInt, ArrayList<QQOperationRequestTaskInfo> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    ((ConfigHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(paramString, paramInt, paramArrayList, false);
  }
  
  public boolean a()
  {
    return a(this.h);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      QQOperateTipNativeShowInfo localQQOperateTipNativeShowInfo = (QQOperateTipNativeShowInfo)localIterator.next();
      if ((paramInt1 == localQQOperateTipNativeShowInfo.b) && (paramInt2 == localQQOperateTipNativeShowInfo.a)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, ArrayList<QQOperationRequestTaskInfo> paramArrayList, boolean paramBoolean, int paramInt3)
  {
    Object localObject2 = paramString;
    Object localObject1 = paramList;
    if (this.a >= 100)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..requestCount >100 ...... ");
      }
      return false;
    }
    if (a(paramInt1, paramInt2)) {
      return false;
    }
    if (!d(paramInt1, paramInt2)) {
      return false;
    }
    boolean bool = b(paramInt1, paramInt2);
    Object localObject3 = " request from open aio ,firstUnreadMsgIndex = ";
    Object localObject5;
    int k;
    if (bool)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..server has xiafa guo ...... ");
      }
      localObject3 = c(paramInt1, paramInt2);
      if (localObject3 == null) {
        return false;
      }
      localObject4 = b(((QQOperationViopTipTask)localObject3).taskid);
      if ((localObject4 != null) && (QLog.isDevelopLevel()))
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("isNeedRequestForTips2 ..");
        ((StringBuilder)localObject5).append(localObject4);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject5).toString());
      }
      if (localObject4 != null) {
        paramInt2 = ((QQOperationTaskRecord)localObject4).aioCount;
      } else {
        paramInt2 = 0;
      }
      if (localObject4 != null) {
        k = ((QQOperationTaskRecord)localObject4).getUinTotalShowCount((String)localObject2);
      } else {
        k = 0;
      }
      int m = c(((QQOperationViopTipTask)localObject3).taskid);
      int n = a(((QQOperationViopTipTask)localObject3).taskid, (String)localObject2, paramInt1);
      if (QLog.isDevelopLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(" judge showLimit, thisTaskAIOShowedCount = ");
        ((StringBuilder)localObject5).append(paramInt2);
        ((StringBuilder)localObject5).append(",thisTaskTotalShowedCount = ");
        ((StringBuilder)localObject5).append(k);
        ((StringBuilder)localObject5).append(",thisTaskTodayAIOShowCount = ");
        ((StringBuilder)localObject5).append(m);
        ((StringBuilder)localObject5).append(",thisUinTodayShowedCount");
        ((StringBuilder)localObject5).append(n);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject5).toString());
      }
      if ((localObject3 != null) && ((paramInt2 < ((QQOperationViopTipTask)localObject3).limitTotalAIOCount) || ((paramInt2 == ((QQOperationViopTipTask)localObject3).limitTotalAIOCount) && (localObject4 != null) && (((QQOperationTaskRecord)localObject4).hasShowedUins != null) && (((QQOperationTaskRecord)localObject4).hasShowedUins.contains((CharSequence)localObject2)))) && (k < ((QQOperationViopTipTask)localObject3).limitTotalShowCount) && ((m < ((QQOperationViopTipTask)localObject3).limitDayAIOCount) || ((n > 0) && (m == ((QQOperationViopTipTask)localObject3).limitDayAIOCount))) && (n < ((QQOperationViopTipTask)localObject3).limitDayAIOShowCount))
      {
        if (paramBoolean)
        {
          if (localObject1 != null) {
            paramInt2 = paramList.size();
          } else {
            paramInt2 = 0;
          }
          if (paramInt2 > 0)
          {
            if ((paramInt3 > -1) && (paramInt3 < paramList.size()))
            {
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).addAll(((List)localObject1).subList(paramInt3, paramList.size()));
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = null;
            }
            if (QLog.isDevelopLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(" request from open aio ,firstUnreadMsgIndex = ");
              ((StringBuilder)localObject2).append(paramInt3);
              ((StringBuilder)localObject2).append("unreadMsgList size = ");
              if (localObject1 == null) {
                paramInt2 = 0;
              } else {
                paramInt2 = ((ArrayList)localObject1).size();
              }
              ((StringBuilder)localObject2).append(paramInt2);
              QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            localObject1 = null;
          }
          localObject1 = a(paramString, paramInt1, (QQOperationViopTipTask)localObject3, paramQQAppInterface, (List)localObject1);
          paramInt1 = b(paramString, paramInt1, (QQOperationViopTipTask)localObject3, paramQQAppInterface, paramList);
          paramString = (String)localObject1;
        }
        else
        {
          paramString = a(paramString, paramInt1, (QQOperationViopTipTask)localObject3, paramQQAppInterface, paramList);
          if (paramString.size() == 0) {
            return false;
          }
          paramInt1 = 0;
        }
        if (QLog.isDevelopLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(" judge taskid = ");
          paramQQAppInterface.append(((QQOperationViopTipTask)localObject3).taskid);
          paramQQAppInterface.append(", matchKeyWords = ");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(",pinfanNum = ");
          paramQQAppInterface.append(paramInt1);
          QLog.d("QQOperateVoIP", 4, paramQQAppInterface.toString());
        }
        if ((TextUtils.isEmpty(((QQOperationViopTipTask)localObject3).keywordString)) && (((QQOperationViopTipTask)localObject3).frequencyTime == 0)) {}
        while ((TextUtils.isEmpty(((QQOperationViopTipTask)localObject3).keywordString)) && (((QQOperationViopTipTask)localObject3).frequencyTime != 0) ? paramInt1 > 0 : (!TextUtils.isEmpty(((QQOperationViopTipTask)localObject3).keywordString)) && (((QQOperationViopTipTask)localObject3).frequencyTime == 0) ? paramString.size() > 0 : (paramString.size() > 0) && (paramInt1 > 0))
        {
          paramInt2 = 1;
          break;
        }
        paramInt2 = 0;
        if (paramInt2 != 0)
        {
          paramQQAppInterface = paramArrayList.iterator();
          while (paramQQAppInterface.hasNext()) {
            if (((QQOperationRequestTaskInfo)paramQQAppInterface.next()).a == ((QQOperationViopTipTask)localObject3).taskid)
            {
              paramInt2 = 1;
              break label859;
            }
          }
          paramInt2 = 0;
          label859:
          if (paramInt2 == 0)
          {
            paramQQAppInterface = new QQOperationRequestTaskInfo();
            paramQQAppInterface.a = ((QQOperationViopTipTask)localObject3).taskid;
            paramQQAppInterface.b = paramInt1;
            paramQQAppInterface.c = paramString;
            paramArrayList.add(paramQQAppInterface);
          }
          return true;
        }
        return false;
      }
      return false;
    }
    localObject1 = ",pinfanNum = ";
    Object localObject4 = e(paramInt1, paramInt2);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..server has not xiafa guo  ...... ");
    }
    localObject2 = " judge taskid = ";
    if ((localObject4 != null) && (((ArrayList)localObject4).size() >= 1))
    {
      Iterator localIterator = ((ArrayList)localObject4).iterator();
      bool = false;
      for (;;)
      {
        Object localObject6 = paramList;
        String str = paramString;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject5 = (QQOperationViopTipTask)localIterator.next();
        QQOperationTaskRecord localQQOperationTaskRecord = b(((QQOperationViopTipTask)localObject5).taskid);
        if (localQQOperationTaskRecord != null) {
          paramInt2 = localQQOperationTaskRecord.aioCount;
        } else {
          paramInt2 = 0;
        }
        if (localQQOperationTaskRecord != null) {
          k = localQQOperationTaskRecord.getUinTotalShowCount(str);
        } else {
          k = 0;
        }
        localObject4 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" judge showLimit, thisTaskAIOShowedCount = ");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(",thisTaskTotalShowedCount = ");
          ((StringBuilder)localObject1).append(k);
          QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject1).toString());
        }
        if (((paramInt2 < ((QQOperationViopTipTask)localObject5).limitTotalAIOCount) || ((paramInt2 == ((QQOperationViopTipTask)localObject5).limitTotalAIOCount) && (localQQOperationTaskRecord != null) && (localQQOperationTaskRecord.hasShowedUins != null) && (localQQOperationTaskRecord.hasShowedUins.contains(str)))) && (k < ((QQOperationViopTipTask)localObject5).limitTotalShowCount))
        {
          if (paramBoolean)
          {
            if (localObject6 != null) {
              paramInt2 = paramList.size();
            } else {
              paramInt2 = 0;
            }
            if (paramInt2 > 0)
            {
              if ((paramInt3 > -1) && (paramInt3 < paramList.size()))
              {
                localObject1 = new ArrayList();
                ((ArrayList)localObject1).addAll(((List)localObject6).subList(paramInt3, paramList.size()));
              }
              else
              {
                localObject1 = null;
              }
              if (QLog.isDevelopLevel())
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append((String)localObject3);
                ((StringBuilder)localObject6).append(paramInt3);
                ((StringBuilder)localObject6).append("unreadMsgList size = ");
                if (localObject1 == null) {
                  paramInt2 = 0;
                } else {
                  paramInt2 = ((ArrayList)localObject1).size();
                }
                ((StringBuilder)localObject6).append(paramInt2);
                QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject6).toString());
              }
            }
            else
            {
              localObject1 = null;
            }
            localObject1 = a(paramString, paramInt1, (QQOperationViopTipTask)localObject5, paramQQAppInterface, (List)localObject1);
            paramInt2 = b(paramString, paramInt1, (QQOperationViopTipTask)localObject5, paramQQAppInterface, paramList);
          }
          else
          {
            localObject1 = a(paramString, paramInt1, (QQOperationViopTipTask)localObject5, paramQQAppInterface, paramList);
            if (((ArrayList)localObject1).size() == 0) {
              break label1668;
            }
            paramInt2 = 0;
          }
          if (QLog.isDevelopLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append((String)localObject2);
            ((StringBuilder)localObject6).append(((QQOperationViopTipTask)localObject5).taskid);
            ((StringBuilder)localObject6).append(", matchKeyWords = ");
            ((StringBuilder)localObject6).append(localObject1);
            ((StringBuilder)localObject6).append((String)localObject4);
            ((StringBuilder)localObject6).append(paramInt2);
            QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject6).toString());
          }
          if ((TextUtils.isEmpty(((QQOperationViopTipTask)localObject5).keywordString)) && (((QQOperationViopTipTask)localObject5).frequencyTime == 0)) {}
          while ((TextUtils.isEmpty(((QQOperationViopTipTask)localObject5).keywordString)) && (((QQOperationViopTipTask)localObject5).frequencyTime != 0) ? paramInt2 > 0 : (!TextUtils.isEmpty(((QQOperationViopTipTask)localObject5).keywordString)) && (((QQOperationViopTipTask)localObject5).frequencyTime == 0) ? ((ArrayList)localObject1).size() > 0 : (((ArrayList)localObject1).size() > 0) && (paramInt2 > 0))
          {
            k = 1;
            break;
          }
          k = 0;
          if (k != 0)
          {
            localObject6 = paramArrayList.iterator();
            while (((Iterator)localObject6).hasNext()) {
              if (((QQOperationRequestTaskInfo)((Iterator)localObject6).next()).a == ((QQOperationViopTipTask)localObject5).taskid)
              {
                k = 1;
                break label1617;
              }
            }
            k = 0;
            label1617:
            if (k == 0)
            {
              localObject6 = new QQOperationRequestTaskInfo();
              ((QQOperationRequestTaskInfo)localObject6).a = ((QQOperationViopTipTask)localObject5).taskid;
              ((QQOperationRequestTaskInfo)localObject6).b = paramInt2;
              ((QQOperationRequestTaskInfo)localObject6).c = ((ArrayList)localObject1);
              paramArrayList.add(localObject6);
            }
            bool = true;
          }
        }
        label1668:
        localObject1 = localObject4;
      }
      return bool;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..this type no valid task  ...... ");
    }
    return false;
  }
  
  public int b(String paramString, int paramInt, QQOperationViopTipTask paramQQOperationViopTipTask, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    int i4 = 0;
    if (paramList == null) {
      return 0;
    }
    paramInt = paramList.size();
    int i5 = 1;
    if (paramInt == 1) {
      return 0;
    }
    long l1 = MessageCache.c();
    long l2 = paramQQOperationViopTipTask.frequencyTime * 60 * 1000;
    int i6 = paramQQOperationViopTipTask.frequencyMessage;
    l1 = (l1 * 1000L - l2) / 1000L;
    int n = paramList.size() - 1;
    paramInt = 0;
    int m = 0;
    int i1;
    for (int k = 0; n >= 0; k = i1)
    {
      paramString = (ChatMessage)paramList.get(n);
      if (paramString.time < l1) {
        break;
      }
      int i3 = paramInt;
      int i2 = m;
      i1 = k;
      if (MsgProxyUtils.h(paramString.msgtype))
      {
        i3 = paramInt;
        i2 = m;
        i1 = k;
        if (paramString.extraflag == 0)
        {
          if (!paramString.isSend()) {
            m = 1;
          } else {
            k = 1;
          }
          i3 = paramInt + 1;
          i1 = k;
          i2 = m;
        }
      }
      n -= 1;
      paramInt = i3;
      m = i2;
    }
    if ((paramInt >= i6) && (m != 0) && (k != 0)) {
      k = i5;
    } else {
      k = 0;
    }
    m = i4;
    if (k != 0) {
      m = paramInt;
    }
    return m;
  }
  
  public QQOperationTaskRecord b(int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      QQOperationTaskRecord localQQOperationTaskRecord = (QQOperationTaskRecord)localIterator.next();
      if (paramInt == localQQOperationTaskRecord.taskid) {
        return localQQOperationTaskRecord;
      }
    }
    return null;
  }
  
  public void b()
  {
    ThreadManager.post(new QQOperateManager.1(this, this.a), 8, null, true);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((paramInt1 == localQQOperationViopTipTask.uinType) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        return true;
      }
    }
    return false;
  }
  
  public int c(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    int k = 0;
    while (localIterator.hasNext()) {
      if (((QQOperationVoipTipsTaskExcuteRecord)localIterator.next()).taskid == paramInt) {
        k += 1;
      }
    }
    return k;
  }
  
  public QQOperationViopTipTask c(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((paramInt1 == localQQOperationViopTipTask.uinType) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        return localQQOperationViopTipTask;
      }
    }
    return null;
  }
  
  public boolean d(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((localQQOperationViopTipTask.tipType == paramInt2) || (localQQOperationViopTipTask.uinType == paramInt1)) {
        return true;
      }
    }
    return false;
  }
  
  public ArrayList<QQOperationViopTipTask> e(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((localQQOperationViopTipTask.uinType == paramInt1) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        localArrayList.add(localQQOperationViopTipTask);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperateManager
 * JD-Core Version:    0.7.0.1
 */