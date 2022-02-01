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
  private static QQOperateManager jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private ArrayList<QQOperateTipNativeShowInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private CopyOnWriteArrayList<QQOperationViopTipTask> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private ArrayList<QQOperationViopTipTask> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private CopyOnWriteArrayList<QQOperationTaskRecord> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<QQOperationVoipTipsTaskExcuteRecord> c = new CopyOnWriteArrayList();
  
  public static QQOperateManager a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager == null) || (!jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager.a()) || (!paramQQAppInterface.getCurrentAccountUin().equals(jdField_a_of_type_JavaLangString)))
      {
        jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager = new QQOperateManager();
        jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
        jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager.a(paramQQAppInterface);
      }
      paramQQAppInterface = jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager;
      return paramQQAppInterface;
    }
  }
  
  /* Error */
  private void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: invokevirtual 80	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   7: aload_0
    //   8: getfield 34	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   11: invokevirtual 80	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   14: aload_0
    //   15: getfield 36	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   18: invokevirtual 80	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   21: aload_0
    //   22: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   25: invokevirtual 81	java/util/ArrayList:clear	()V
    //   28: aload_0
    //   29: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   32: invokevirtual 81	java/util/ArrayList:clear	()V
    //   35: getstatic 65	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +4 -> 45
    //   44: return
    //   45: invokestatic 93	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   48: invokestatic 99	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   51: astore 5
    //   53: new 101	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   60: astore 6
    //   62: aload 6
    //   64: getstatic 65	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: ldc 108
    //   75: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: aload 5
    //   82: aload 6
    //   84: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: iconst_0
    //   88: invokeinterface 117 3 0
    //   93: putfield 119	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_Int	I
    //   96: new 101	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   103: astore 6
    //   105: aload 6
    //   107: getstatic 65	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 6
    //   116: ldc 121
    //   118: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 5
    //   124: aload 6
    //   126: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: lconst_0
    //   130: invokeinterface 125 4 0
    //   135: lstore_3
    //   136: aload_0
    //   137: getfield 119	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_Int	I
    //   140: ifeq +16 -> 156
    //   143: lload_3
    //   144: lconst_0
    //   145: lcmp
    //   146: ifeq +10 -> 156
    //   149: lload_3
    //   150: invokestatic 128	com/tencent/mobileqq/config/operation/QQOperateManager:a	(J)Z
    //   153: ifne +105 -> 258
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 119	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_Int	I
    //   161: aload 5
    //   163: invokeinterface 132 1 0
    //   168: astore 5
    //   170: new 101	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   177: astore 6
    //   179: aload 6
    //   181: getstatic 65	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   184: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 6
    //   190: ldc 108
    //   192: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 5
    //   198: aload 6
    //   200: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: iconst_0
    //   204: invokeinterface 138 3 0
    //   209: astore 5
    //   211: new 101	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   218: astore 6
    //   220: aload 6
    //   222: getstatic 65	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 6
    //   231: ldc 121
    //   233: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 5
    //   239: aload 6
    //   241: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   247: invokeinterface 142 4 0
    //   252: invokeinterface 145 1 0
    //   257: pop
    //   258: aload_1
    //   259: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   262: invokevirtual 155	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   265: astore_1
    //   266: aload_1
    //   267: ldc 157
    //   269: new 157	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   272: dup
    //   273: invokespecial 158	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   276: invokevirtual 161	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getTableName	()Ljava/lang/String;
    //   279: iconst_0
    //   280: aconst_null
    //   281: aconst_null
    //   282: aconst_null
    //   283: aconst_null
    //   284: aconst_null
    //   285: aconst_null
    //   286: invokevirtual 167	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   289: astore 5
    //   291: aload 5
    //   293: ifnull +187 -> 480
    //   296: aload 5
    //   298: invokeinterface 173 1 0
    //   303: ifle +177 -> 480
    //   306: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   309: ifeq +44 -> 353
    //   312: new 101	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   319: astore 6
    //   321: aload 6
    //   323: ldc 180
    //   325: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 6
    //   331: aload 5
    //   333: invokeinterface 173 1 0
    //   338: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: ldc 185
    //   344: iconst_4
    //   345: aload 6
    //   347: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload_0
    //   354: getfield 32	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   357: aload 5
    //   359: checkcast 38	java/util/ArrayList
    //   362: invokevirtual 193	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   365: pop
    //   366: aload_0
    //   367: getfield 32	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   370: invokevirtual 197	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   373: astore 5
    //   375: aload 5
    //   377: invokeinterface 202 1 0
    //   382: ifeq +98 -> 480
    //   385: aload 5
    //   387: invokeinterface 206 1 0
    //   392: checkcast 157	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   395: astore 6
    //   397: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   400: lstore_3
    //   401: aload 6
    //   403: invokevirtual 210	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getEndDate	()Ljava/util/Date;
    //   406: astore 7
    //   408: aload 6
    //   410: invokevirtual 213	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getBeginDate	()Ljava/util/Date;
    //   413: astore 8
    //   415: aload 7
    //   417: ifnull +13 -> 430
    //   420: lload_3
    //   421: aload 7
    //   423: invokevirtual 218	java/util/Date:getTime	()J
    //   426: lcmp
    //   427: ifgt +18 -> 445
    //   430: aload 8
    //   432: ifnull -57 -> 375
    //   435: lload_3
    //   436: aload 8
    //   438: invokevirtual 218	java/util/Date:getTime	()J
    //   441: lcmp
    //   442: ifge -67 -> 375
    //   445: aload_0
    //   446: getfield 32	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   449: aload 6
    //   451: invokevirtual 221	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   454: pop
    //   455: aload 7
    //   457: ifnull -82 -> 375
    //   460: lload_3
    //   461: aload 7
    //   463: invokevirtual 218	java/util/Date:getTime	()J
    //   466: lcmp
    //   467: ifle -92 -> 375
    //   470: aload_1
    //   471: aload 6
    //   473: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   476: pop
    //   477: goto -102 -> 375
    //   480: aload_1
    //   481: ldc 226
    //   483: new 226	com/tencent/mobileqq/config/operation/QQOperationTaskRecord
    //   486: dup
    //   487: invokespecial 227	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:<init>	()V
    //   490: invokevirtual 228	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:getTableName	()Ljava/lang/String;
    //   493: iconst_0
    //   494: aconst_null
    //   495: aconst_null
    //   496: aconst_null
    //   497: aconst_null
    //   498: aconst_null
    //   499: aconst_null
    //   500: invokevirtual 167	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   503: astore 5
    //   505: aload 5
    //   507: ifnull +162 -> 669
    //   510: aload 5
    //   512: invokeinterface 173 1 0
    //   517: ifle +152 -> 669
    //   520: aload_0
    //   521: getfield 34	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   524: aload 5
    //   526: checkcast 38	java/util/ArrayList
    //   529: invokevirtual 193	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   532: pop
    //   533: aload_0
    //   534: getfield 34	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   537: invokevirtual 197	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   540: astore 5
    //   542: aload 5
    //   544: invokeinterface 202 1 0
    //   549: ifeq +120 -> 669
    //   552: aload 5
    //   554: invokeinterface 206 1 0
    //   559: checkcast 226	com/tencent/mobileqq/config/operation/QQOperationTaskRecord
    //   562: astore 6
    //   564: aload_0
    //   565: getfield 32	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   568: invokevirtual 197	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   571: astore 7
    //   573: aload 7
    //   575: invokeinterface 202 1 0
    //   580: ifeq +806 -> 1386
    //   583: aload 7
    //   585: invokeinterface 206 1 0
    //   590: checkcast 157	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   593: astore 8
    //   595: aload 6
    //   597: getfield 231	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:taskid	I
    //   600: aload 8
    //   602: getfield 232	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   605: if_icmpne -32 -> 573
    //   608: iconst_1
    //   609: istore_2
    //   610: goto +3 -> 613
    //   613: iload_2
    //   614: ifne +20 -> 634
    //   617: aload_0
    //   618: getfield 34	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   621: aload 6
    //   623: invokevirtual 221	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   626: pop
    //   627: aload_1
    //   628: aload 6
    //   630: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   633: pop
    //   634: aload 6
    //   636: getfield 235	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:recordTime	J
    //   639: invokestatic 128	com/tencent/mobileqq/config/operation/QQOperateManager:a	(J)Z
    //   642: ifne -100 -> 542
    //   645: aload 6
    //   647: ldc 237
    //   649: putfield 240	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:hasShowedUins	Ljava/lang/String;
    //   652: aload 6
    //   654: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   657: putfield 235	com/tencent/mobileqq/config/operation/QQOperationTaskRecord:recordTime	J
    //   660: aload_1
    //   661: aload 6
    //   663: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   666: goto -124 -> 542
    //   669: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   672: ifeq +44 -> 716
    //   675: new 101	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   682: astore 5
    //   684: aload 5
    //   686: ldc 246
    //   688: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload 5
    //   694: aload_0
    //   695: getfield 34	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   698: invokevirtual 247	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   701: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: ldc 185
    //   707: iconst_4
    //   708: aload 5
    //   710: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: aload_1
    //   717: ldc 249
    //   719: new 249	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord
    //   722: dup
    //   723: invokespecial 250	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:<init>	()V
    //   726: invokevirtual 251	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:getTableName	()Ljava/lang/String;
    //   729: iconst_0
    //   730: aconst_null
    //   731: aconst_null
    //   732: aconst_null
    //   733: aconst_null
    //   734: aconst_null
    //   735: aconst_null
    //   736: invokevirtual 167	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   739: astore 5
    //   741: aload 5
    //   743: ifnull +88 -> 831
    //   746: aload 5
    //   748: invokeinterface 173 1 0
    //   753: ifle +78 -> 831
    //   756: aload_0
    //   757: getfield 36	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   760: aload 5
    //   762: checkcast 38	java/util/ArrayList
    //   765: invokevirtual 193	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   768: pop
    //   769: aload_0
    //   770: getfield 36	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   773: invokevirtual 197	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   776: astore 5
    //   778: aload 5
    //   780: invokeinterface 202 1 0
    //   785: ifeq +46 -> 831
    //   788: aload 5
    //   790: invokeinterface 206 1 0
    //   795: checkcast 249	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord
    //   798: astore 6
    //   800: aload 6
    //   802: getfield 254	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:time	J
    //   805: invokestatic 128	com/tencent/mobileqq/config/operation/QQOperateManager:a	(J)Z
    //   808: ifne -30 -> 778
    //   811: aload_0
    //   812: getfield 36	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   815: aload 6
    //   817: invokevirtual 221	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   820: pop
    //   821: aload_1
    //   822: aload 6
    //   824: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   827: pop
    //   828: goto -50 -> 778
    //   831: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   834: ifeq +45 -> 879
    //   837: new 101	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   844: astore 5
    //   846: aload 5
    //   848: ldc_w 256
    //   851: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload 5
    //   857: aload_0
    //   858: getfield 36	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   861: invokevirtual 247	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   864: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: ldc 185
    //   870: iconst_4
    //   871: aload 5
    //   873: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: aload_0
    //   880: getfield 36	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   883: invokevirtual 197	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   886: astore 5
    //   888: aload 5
    //   890: invokeinterface 202 1 0
    //   895: ifeq +257 -> 1152
    //   898: aload 5
    //   900: invokeinterface 206 1 0
    //   905: checkcast 249	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord
    //   908: astore 6
    //   910: aload 6
    //   912: getfield 257	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:taskid	I
    //   915: iconst_m1
    //   916: if_icmpeq +80 -> 996
    //   919: aload_0
    //   920: aload 6
    //   922: getfield 257	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:taskid	I
    //   925: invokevirtual 260	com/tencent/mobileqq/config/operation/QQOperateManager:a	(I)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   928: astore 6
    //   930: aload 6
    //   932: ifnull +13 -> 945
    //   935: aload_0
    //   936: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   939: aload 6
    //   941: invokevirtual 263	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   944: pop
    //   945: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   948: ifeq -60 -> 888
    //   951: new 101	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   958: astore 6
    //   960: aload 6
    //   962: ldc_w 265
    //   965: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload 6
    //   971: aload_0
    //   972: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   975: invokevirtual 266	java/util/ArrayList:size	()I
    //   978: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: ldc 185
    //   984: iconst_4
    //   985: aload 6
    //   987: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   993: goto -105 -> 888
    //   996: aload_0
    //   997: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1000: invokevirtual 267	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1003: astore 7
    //   1005: aload 7
    //   1007: invokeinterface 202 1 0
    //   1012: ifeq +379 -> 1391
    //   1015: aload 7
    //   1017: invokeinterface 206 1 0
    //   1022: checkcast 269	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo
    //   1025: astore 8
    //   1027: aload 8
    //   1029: getfield 271	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:b	I
    //   1032: aload 6
    //   1034: getfield 274	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:uinType	I
    //   1037: if_icmpne -32 -> 1005
    //   1040: aload 8
    //   1042: getfield 275	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:jdField_a_of_type_Int	I
    //   1045: aload 6
    //   1047: getfield 278	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:tipType	I
    //   1050: if_icmpne -45 -> 1005
    //   1053: iconst_1
    //   1054: istore_2
    //   1055: goto +3 -> 1058
    //   1058: iload_2
    //   1059: ifne +42 -> 1101
    //   1062: new 269	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo
    //   1065: dup
    //   1066: invokespecial 279	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:<init>	()V
    //   1069: astore 7
    //   1071: aload 7
    //   1073: aload 6
    //   1075: getfield 274	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:uinType	I
    //   1078: putfield 271	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:b	I
    //   1081: aload 7
    //   1083: aload 6
    //   1085: getfield 278	com/tencent/mobileqq/config/operation/QQOperationVoipTipsTaskExcuteRecord:tipType	I
    //   1088: putfield 275	com/tencent/mobileqq/config/operation/QQOperateTipNativeShowInfo:jdField_a_of_type_Int	I
    //   1091: aload_0
    //   1092: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1095: aload 7
    //   1097: invokevirtual 263	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1100: pop
    //   1101: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1104: ifeq -216 -> 888
    //   1107: new 101	java/lang/StringBuilder
    //   1110: dup
    //   1111: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1114: astore 6
    //   1116: aload 6
    //   1118: ldc_w 281
    //   1121: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: pop
    //   1125: aload 6
    //   1127: aload_0
    //   1128: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1131: invokevirtual 266	java/util/ArrayList:size	()I
    //   1134: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: ldc 185
    //   1140: iconst_4
    //   1141: aload 6
    //   1143: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: goto -261 -> 888
    //   1152: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1155: ifeq +213 -> 1368
    //   1158: new 101	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1165: astore 5
    //   1167: aload 5
    //   1169: ldc_w 283
    //   1172: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload 5
    //   1178: aload_0
    //   1179: getfield 32	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1182: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: ldc 185
    //   1188: iconst_4
    //   1189: aload 5
    //   1191: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1197: new 101	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1204: astore 5
    //   1206: aload 5
    //   1208: ldc_w 288
    //   1211: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: pop
    //   1215: aload 5
    //   1217: aload_0
    //   1218: getfield 34	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1221: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: ldc 185
    //   1227: iconst_4
    //   1228: aload 5
    //   1230: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1233: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1236: new 101	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1243: astore 5
    //   1245: aload 5
    //   1247: ldc_w 290
    //   1250: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload 5
    //   1256: aload_0
    //   1257: getfield 36	com/tencent/mobileqq/config/operation/QQOperateManager:c	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1260: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1263: pop
    //   1264: ldc 185
    //   1266: iconst_4
    //   1267: aload 5
    //   1269: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1275: new 101	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1282: astore 5
    //   1284: aload 5
    //   1286: ldc_w 292
    //   1289: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: pop
    //   1293: aload 5
    //   1295: aload_0
    //   1296: getfield 43	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1299: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: ldc 185
    //   1305: iconst_4
    //   1306: aload 5
    //   1308: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1311: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1314: new 101	java/lang/StringBuilder
    //   1317: dup
    //   1318: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1321: astore 5
    //   1323: aload 5
    //   1325: ldc_w 294
    //   1328: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload 5
    //   1334: aload_0
    //   1335: getfield 41	com/tencent/mobileqq/config/operation/QQOperateManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1338: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: ldc 185
    //   1344: iconst_4
    //   1345: aload 5
    //   1347: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1353: goto +15 -> 1368
    //   1356: astore 5
    //   1358: goto +15 -> 1373
    //   1361: astore 5
    //   1363: aload 5
    //   1365: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   1368: aload_1
    //   1369: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1372: return
    //   1373: aload_1
    //   1374: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1377: goto +6 -> 1383
    //   1380: aload 5
    //   1382: athrow
    //   1383: goto -3 -> 1380
    //   1386: iconst_0
    //   1387: istore_2
    //   1388: goto -775 -> 613
    //   1391: iconst_0
    //   1392: istore_2
    //   1393: goto -335 -> 1058
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1396	0	this	QQOperateManager
    //   0	1396	1	paramQQAppInterface	QQAppInterface
    //   609	784	2	i	int
    //   135	326	3	l	long
    //   51	1295	5	localObject1	Object
    //   1356	1	5	localObject2	Object
    //   1361	20	5	localException	java.lang.Exception
    //   60	1082	6	localObject3	Object
    //   406	690	7	localObject4	Object
    //   413	628	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   266	291	1356	finally
    //   296	353	1356	finally
    //   353	375	1356	finally
    //   375	415	1356	finally
    //   420	430	1356	finally
    //   435	445	1356	finally
    //   445	455	1356	finally
    //   460	477	1356	finally
    //   480	505	1356	finally
    //   510	542	1356	finally
    //   542	573	1356	finally
    //   573	608	1356	finally
    //   617	634	1356	finally
    //   634	666	1356	finally
    //   669	716	1356	finally
    //   716	741	1356	finally
    //   746	778	1356	finally
    //   778	828	1356	finally
    //   831	879	1356	finally
    //   879	888	1356	finally
    //   888	930	1356	finally
    //   935	945	1356	finally
    //   945	993	1356	finally
    //   996	1005	1356	finally
    //   1005	1053	1356	finally
    //   1062	1101	1356	finally
    //   1101	1149	1356	finally
    //   1152	1353	1356	finally
    //   1363	1368	1356	finally
    //   266	291	1361	java/lang/Exception
    //   296	353	1361	java/lang/Exception
    //   353	375	1361	java/lang/Exception
    //   375	415	1361	java/lang/Exception
    //   420	430	1361	java/lang/Exception
    //   435	445	1361	java/lang/Exception
    //   445	455	1361	java/lang/Exception
    //   460	477	1361	java/lang/Exception
    //   480	505	1361	java/lang/Exception
    //   510	542	1361	java/lang/Exception
    //   542	573	1361	java/lang/Exception
    //   573	608	1361	java/lang/Exception
    //   617	634	1361	java/lang/Exception
    //   634	666	1361	java/lang/Exception
    //   669	716	1361	java/lang/Exception
    //   716	741	1361	java/lang/Exception
    //   746	778	1361	java/lang/Exception
    //   778	828	1361	java/lang/Exception
    //   831	879	1361	java/lang/Exception
    //   879	888	1361	java/lang/Exception
    //   888	930	1361	java/lang/Exception
    //   935	945	1361	java/lang/Exception
    //   945	993	1361	java/lang/Exception
    //   996	1005	1361	java/lang/Exception
    //   1005	1053	1361	java/lang/Exception
    //   1062	1101	1361	java/lang/Exception
    //   1101	1149	1361	java/lang/Exception
    //   1152	1353	1361	java/lang/Exception
  }
  
  public static boolean a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    localCalendar1.setTimeInMillis(paramLong);
    return localCalendar2.get(5) == localCalendar1.get(5);
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager.a();
      jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager = null;
      return;
    }
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((QQOperationVoipTipsTaskExcuteRecord)localIterator.next()).taskid == paramInt) {
        i += 1;
      }
    }
    return i;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord;
    do
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      localQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localIterator.next();
    } while ((localQQOperationVoipTipsTaskExcuteRecord.taskid != paramInt1) || (!localQQOperationVoipTipsTaskExcuteRecord.uin.equals(paramString)) || (localQQOperationVoipTipsTaskExcuteRecord.uinType != paramInt2));
    int i = 0 + localQQOperationVoipTipsTaskExcuteRecord.count;
    return i;
  }
  
  public int a(String paramString, int paramInt, QQOperationViopTipTask paramQQOperationViopTipTask, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    int i2 = 0;
    if (paramList == null) {
      return 0;
    }
    paramInt = paramList.size();
    int i3 = 1;
    if (paramInt == 1) {
      return 0;
    }
    long l1 = MessageCache.a();
    long l2 = paramQQOperationViopTipTask.frequencyTime * 60 * 1000;
    int i4 = paramQQOperationViopTipTask.frequencyMessage;
    l1 = (l1 * 1000L - l2) / 1000L;
    int k = paramList.size() - 1;
    paramInt = 0;
    int j = 0;
    int m;
    for (int i = 0; k >= 0; i = m)
    {
      paramString = (ChatMessage)paramList.get(k);
      if (paramString.time < l1) {
        break;
      }
      int i1 = paramInt;
      int n = j;
      m = i;
      if (MsgProxyUtils.h(paramString.msgtype))
      {
        i1 = paramInt;
        n = j;
        m = i;
        if (paramString.extraflag == 0)
        {
          if (!paramString.isSend()) {
            j = 1;
          } else {
            i = 1;
          }
          i1 = paramInt + 1;
          m = i;
          n = j;
        }
      }
      k -= 1;
      paramInt = i1;
      j = n;
    }
    if ((paramInt >= i4) && (j != 0) && (i != 0)) {
      i = i3;
    } else {
      i = 0;
    }
    j = i2;
    if (i != 0) {
      j = paramInt;
    }
    return j;
  }
  
  public QQOperationRequestInfo a(String paramString, int paramInt1, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, boolean paramBoolean, int paramInt2)
  {
    label303:
    synchronized (jdField_a_of_type_JavaLangObject)
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
          paramString.jdField_a_of_type_Boolean = paramBoolean;
          paramString.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
          if (QLog.isDevelopLevel())
          {
            paramQQAppInterface = ((ArrayList)localObject2).iterator();
            while (paramQQAppInterface.hasNext())
            {
              paramList = (QQOperationRequestTaskInfo)paramQQAppInterface.next();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("isNeedRequestForTips2 ..request taskid = .... ");
              ((StringBuilder)localObject2).append(paramList.jdField_a_of_type_Int);
              QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject2).toString());
            }
          }
          if (paramString.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Int += 1;
          }
          return paramString;
        }
      }
    }
  }
  
  public QQOperationTaskRecord a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationTaskRecord localQQOperationTaskRecord = (QQOperationTaskRecord)localIterator.next();
      if (paramInt == localQQOperationTaskRecord.taskid) {
        return localQQOperationTaskRecord;
      }
    }
    return null;
  }
  
  public QQOperationViopTipTask a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if (localQQOperationViopTipTask.taskid == paramInt) {
        return localQQOperationViopTipTask;
      }
    }
    return null;
  }
  
  public QQOperationViopTipTask a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((paramInt1 == localQQOperationViopTipTask.uinType) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        return localQQOperationViopTipTask;
      }
    }
    return null;
  }
  
  public QQOperationVoipTipsTaskExcuteRecord a(QQOperationVoipTipsTaskExcuteRecord paramQQOperationVoipTipsTaskExcuteRecord)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localIterator.next();
      if ((localQQOperationVoipTipsTaskExcuteRecord != null) && (localQQOperationVoipTipsTaskExcuteRecord.taskid == paramQQOperationVoipTipsTaskExcuteRecord.taskid) && (localQQOperationVoipTipsTaskExcuteRecord.tipType == paramQQOperationVoipTipsTaskExcuteRecord.tipType) && (localQQOperationVoipTipsTaskExcuteRecord.uin != null) && (localQQOperationVoipTipsTaskExcuteRecord.uin.equals(paramQQOperationVoipTipsTaskExcuteRecord.uin)) && (localQQOperationVoipTipsTaskExcuteRecord.uinType == paramQQOperationVoipTipsTaskExcuteRecord.uinType)) {
        return localQQOperationVoipTipsTaskExcuteRecord;
      }
    }
    return null;
  }
  
  public ArrayList<QQOperationViopTipTask> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((localQQOperationViopTipTask.uinType == paramInt1) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        localArrayList.add(localQQOperationViopTipTask);
      }
    }
    return localArrayList;
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
  
  public void a()
  {
    ThreadManager.post(new QQOperateManager.1(this, this.jdField_a_of_type_Int), 8, null, true);
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
    int i;
    label804:
    label809:
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject1 = a(paramQQOperationVoipTipsTaskExcuteRecord);
      i = 1;
      if (localObject1 == null)
      {
        this.c.add(paramQQOperationVoipTipsTaskExcuteRecord);
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
        ((StringBuilder)localObject1).append(this.c);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject1).toString());
      }
      EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      int k = paramQQOperationVoipTipsTaskExcuteRecord.taskid;
      int j = 0;
      if (k == -1)
      {
        paramQQAppInterface = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!paramQQAppInterface.hasNext()) {
            break label804;
          }
          localObject1 = (QQOperateTipNativeShowInfo)paramQQAppInterface.next();
          if ((((QQOperateTipNativeShowInfo)localObject1).b == paramQQOperationVoipTipsTaskExcuteRecord.uinType) && (((QQOperateTipNativeShowInfo)localObject1).jdField_a_of_type_Int == paramQQOperationVoipTipsTaskExcuteRecord.tipType)) {
            break;
          }
        }
        if (i == 0)
        {
          paramQQAppInterface = new QQOperateTipNativeShowInfo();
          paramQQAppInterface.b = paramQQOperationVoipTipsTaskExcuteRecord.uinType;
          paramQQAppInterface.jdField_a_of_type_Int = paramQQOperationVoipTipsTaskExcuteRecord.tipType;
          this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
        }
        if (QLog.isDevelopLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("Update TodayNativeShow :");
          paramQQAppInterface.append(this.jdField_a_of_type_JavaUtilArrayList);
          QLog.d("QQOperateVoIP", 4, paramQQAppInterface.toString());
        }
      }
      else
      {
        paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        do
        {
          i = j;
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
        } while (((QQOperationViopTipTask)paramQQAppInterface.next()).taskid != paramQQOperationVoipTipsTaskExcuteRecord.taskid);
        i = 1;
        if (i == 0)
        {
          paramQQAppInterface = a(paramQQOperationVoipTipsTaskExcuteRecord.taskid);
          this.jdField_b_of_type_JavaUtilArrayList.add(paramQQAppInterface);
        }
        if (QLog.isDevelopLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("Update TodayNetShow :");
          paramQQAppInterface.append(this.jdField_b_of_type_JavaUtilArrayList);
          QLog.d("QQOperateVoIP", 4, paramQQAppInterface.toString());
        }
        paramQQAppInterface = null;
        Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject1);
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
    //   0: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +35 -> 38
    //   6: new 101	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 469
    //   18: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_2
    //   24: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 185
    //   30: iconst_4
    //   31: aload_3
    //   32: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_2
    //   39: ifnull +148 -> 187
    //   42: aload_2
    //   43: invokevirtual 266	java/util/ArrayList:size	()I
    //   46: ifne +4 -> 50
    //   49: return
    //   50: aload_1
    //   51: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   54: invokevirtual 155	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 473	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 478	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   67: aload_3
    //   68: ldc 157
    //   70: invokevirtual 482	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   73: pop
    //   74: aload_2
    //   75: invokevirtual 267	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   78: astore 4
    //   80: aload 4
    //   82: invokeinterface 202 1 0
    //   87: ifeq +20 -> 107
    //   90: aload_3
    //   91: aload 4
    //   93: invokeinterface 206 1 0
    //   98: checkcast 157	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   101: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   104: goto -24 -> 80
    //   107: invokestatic 178	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   110: ifeq +42 -> 152
    //   113: new 101	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   120: astore 4
    //   122: aload 4
    //   124: ldc_w 484
    //   127: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 4
    //   133: aload_2
    //   134: invokevirtual 266	java/util/ArrayList:size	()I
    //   137: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 185
    //   143: iconst_4
    //   144: aload 4
    //   146: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_1
    //   153: invokevirtual 486	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   156: goto +12 -> 168
    //   159: astore_2
    //   160: goto +21 -> 181
    //   163: astore_2
    //   164: aload_2
    //   165: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   168: aload_1
    //   169: invokevirtual 489	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   172: aload_3
    //   173: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   176: aload_0
    //   177: invokevirtual 316	com/tencent/mobileqq/config/operation/QQOperateManager:a	()V
    //   180: return
    //   181: aload_1
    //   182: invokevirtual 489	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
    return a(this.jdField_a_of_type_Long);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperateTipNativeShowInfo localQQOperateTipNativeShowInfo = (QQOperateTipNativeShowInfo)localIterator.next();
      if ((paramInt1 == localQQOperateTipNativeShowInfo.b) && (paramInt2 == localQQOperateTipNativeShowInfo.jdField_a_of_type_Int)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, ArrayList<QQOperationRequestTaskInfo> paramArrayList, boolean paramBoolean, int paramInt3)
  {
    Object localObject2 = paramString;
    Object localObject1 = paramList;
    if (this.jdField_a_of_type_Int >= 100)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..requestCount >100 ...... ");
      }
      return false;
    }
    if (a(paramInt1, paramInt2)) {
      return false;
    }
    if (!c(paramInt1, paramInt2)) {
      return false;
    }
    boolean bool = b(paramInt1, paramInt2);
    Object localObject3 = " request from open aio ,firstUnreadMsgIndex = ";
    Object localObject5;
    int i;
    if (bool)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..server has xiafa guo ...... ");
      }
      localObject3 = a(paramInt1, paramInt2);
      if (localObject3 == null) {
        return false;
      }
      localObject4 = a(((QQOperationViopTipTask)localObject3).taskid);
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
        i = ((QQOperationTaskRecord)localObject4).getUinTotalShowCount((String)localObject2);
      } else {
        i = 0;
      }
      int j = a(((QQOperationViopTipTask)localObject3).taskid);
      int k = a(((QQOperationViopTipTask)localObject3).taskid, (String)localObject2, paramInt1);
      if (QLog.isDevelopLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(" judge showLimit, thisTaskAIOShowedCount = ");
        ((StringBuilder)localObject5).append(paramInt2);
        ((StringBuilder)localObject5).append(",thisTaskTotalShowedCount = ");
        ((StringBuilder)localObject5).append(i);
        ((StringBuilder)localObject5).append(",thisTaskTodayAIOShowCount = ");
        ((StringBuilder)localObject5).append(j);
        ((StringBuilder)localObject5).append(",thisUinTodayShowedCount");
        ((StringBuilder)localObject5).append(k);
        QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject5).toString());
      }
      if ((localObject3 != null) && ((paramInt2 < ((QQOperationViopTipTask)localObject3).limitTotalAIOCount) || ((paramInt2 == ((QQOperationViopTipTask)localObject3).limitTotalAIOCount) && (localObject4 != null) && (((QQOperationTaskRecord)localObject4).hasShowedUins != null) && (((QQOperationTaskRecord)localObject4).hasShowedUins.contains((CharSequence)localObject2)))) && (i < ((QQOperationViopTipTask)localObject3).limitTotalShowCount) && ((j < ((QQOperationViopTipTask)localObject3).limitDayAIOCount) || ((k > 0) && (j == ((QQOperationViopTipTask)localObject3).limitDayAIOCount))) && (k < ((QQOperationViopTipTask)localObject3).limitDayAIOShowCount))
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
          paramInt1 = a(paramString, paramInt1, (QQOperationViopTipTask)localObject3, paramQQAppInterface, paramList);
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
            if (((QQOperationRequestTaskInfo)paramQQAppInterface.next()).jdField_a_of_type_Int == ((QQOperationViopTipTask)localObject3).taskid)
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
            paramQQAppInterface.jdField_a_of_type_Int = ((QQOperationViopTipTask)localObject3).taskid;
            paramQQAppInterface.b = paramInt1;
            paramQQAppInterface.jdField_a_of_type_JavaUtilArrayList = paramString;
            paramArrayList.add(paramQQAppInterface);
          }
          return true;
        }
        return false;
      }
      return false;
    }
    localObject1 = ",pinfanNum = ";
    Object localObject4 = a(paramInt1, paramInt2);
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
        QQOperationTaskRecord localQQOperationTaskRecord = a(((QQOperationViopTipTask)localObject5).taskid);
        if (localQQOperationTaskRecord != null) {
          paramInt2 = localQQOperationTaskRecord.aioCount;
        } else {
          paramInt2 = 0;
        }
        if (localQQOperationTaskRecord != null) {
          i = localQQOperationTaskRecord.getUinTotalShowCount(str);
        } else {
          i = 0;
        }
        localObject4 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" judge showLimit, thisTaskAIOShowedCount = ");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(",thisTaskTotalShowedCount = ");
          ((StringBuilder)localObject1).append(i);
          QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject1).toString());
        }
        if (((paramInt2 < ((QQOperationViopTipTask)localObject5).limitTotalAIOCount) || ((paramInt2 == ((QQOperationViopTipTask)localObject5).limitTotalAIOCount) && (localQQOperationTaskRecord != null) && (localQQOperationTaskRecord.hasShowedUins != null) && (localQQOperationTaskRecord.hasShowedUins.contains(str)))) && (i < ((QQOperationViopTipTask)localObject5).limitTotalShowCount))
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
            paramInt2 = a(paramString, paramInt1, (QQOperationViopTipTask)localObject5, paramQQAppInterface, paramList);
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
            i = 1;
            break;
          }
          i = 0;
          if (i != 0)
          {
            localObject6 = paramArrayList.iterator();
            while (((Iterator)localObject6).hasNext()) {
              if (((QQOperationRequestTaskInfo)((Iterator)localObject6).next()).jdField_a_of_type_Int == ((QQOperationViopTipTask)localObject5).taskid)
              {
                i = 1;
                break label1617;
              }
            }
            i = 0;
            label1617:
            if (i == 0)
            {
              localObject6 = new QQOperationRequestTaskInfo();
              ((QQOperationRequestTaskInfo)localObject6).jdField_a_of_type_Int = ((QQOperationViopTipTask)localObject5).taskid;
              ((QQOperationRequestTaskInfo)localObject6).b = paramInt2;
              ((QQOperationRequestTaskInfo)localObject6).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
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
  
  public boolean b(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((paramInt1 == localQQOperationViopTipTask.uinType) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((localQQOperationViopTipTask.tipType == paramInt2) || (localQQOperationViopTipTask.uinType == paramInt1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperateManager
 * JD-Core Version:    0.7.0.1
 */