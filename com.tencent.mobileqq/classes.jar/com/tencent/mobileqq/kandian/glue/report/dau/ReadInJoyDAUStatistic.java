package com.tencent.mobileqq.kandian.glue.report.dau;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mobileqq.statistics.UEC.IReporter;
import com.tencent.mobileqq.statistics.UEC.UECItem;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ReadInJoyDAUStatistic
  implements Handler.Callback, UEC.IReporter, Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private HashMap<String, ReadInJoyActivityDAUInfo> jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public ReadInJoyDAUStatistic(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private String a()
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
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
  
  public void a(ArrayList<UEC.UECItem> paramArrayList)
  {
    if (SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramArrayList;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 146	android/os/Message:what	I
    //   4: ifne +395 -> 399
    //   7: aload_1
    //   8: getfield 150	android/os/Message:obj	Ljava/lang/Object;
    //   11: checkcast 161	java/util/ArrayList
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +328 -> 344
    //   19: aload_1
    //   20: invokevirtual 165	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 170 1 0
    //   30: ifeq +314 -> 344
    //   33: aload_1
    //   34: invokeinterface 174 1 0
    //   39: checkcast 176	com/tencent/mobileqq/statistics/UEC$UECItem
    //   42: astore_3
    //   43: aload_3
    //   44: getfield 179	com/tencent/mobileqq/statistics/UEC$UECItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: aload_2
    //   53: invokevirtual 183	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   56: ifeq +88 -> 144
    //   59: aload_0
    //   60: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   63: aload_2
    //   64: invokevirtual 187	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 189	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo
    //   70: astore 4
    //   72: aload 4
    //   74: aload 4
    //   76: getfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   79: iconst_1
    //   80: iadd
    //   81: putfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   84: aload 4
    //   86: aload 4
    //   88: getfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   91: aload_3
    //   92: getfield 198	com/tencent/mobileqq/statistics/UEC$UECItem:jdField_a_of_type_Long	J
    //   95: ladd
    //   96: putfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   99: aload 4
    //   101: aload 4
    //   103: getfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   106: aload_3
    //   107: getfield 204	com/tencent/mobileqq/statistics/UEC$UECItem:jdField_b_of_type_Int	I
    //   110: iadd
    //   111: putfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   114: aload 4
    //   116: aload_0
    //   117: aload 4
    //   119: getfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   122: aload_3
    //   123: getfield 209	com/tencent/mobileqq/statistics/UEC$UECItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   126: invokevirtual 211	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   132: aload 4
    //   134: aload_0
    //   135: invokespecial 213	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:a	()Ljava/lang/String;
    //   138: putfield 216	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   141: goto +71 -> 212
    //   144: new 189	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo
    //   147: dup
    //   148: invokespecial 217	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:<init>	()V
    //   151: astore 4
    //   153: aload 4
    //   155: iconst_1
    //   156: putfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   159: aload 4
    //   161: aload_2
    //   162: putfield 220	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   165: aload 4
    //   167: aload_3
    //   168: getfield 198	com/tencent/mobileqq/statistics/UEC$UECItem:jdField_a_of_type_Long	J
    //   171: putfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   174: aload 4
    //   176: aload_3
    //   177: getfield 204	com/tencent/mobileqq/statistics/UEC$UECItem:jdField_b_of_type_Int	I
    //   180: putfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   183: aload 4
    //   185: aload_3
    //   186: getfield 209	com/tencent/mobileqq/statistics/UEC$UECItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   189: putfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   192: aload 4
    //   194: aload_0
    //   195: invokespecial 213	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:a	()Ljava/lang/String;
    //   198: putfield 216	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   205: aload_2
    //   206: aload 4
    //   208: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq -191 -> 24
    //   218: aload_0
    //   219: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   222: aload_2
    //   223: invokevirtual 187	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   226: checkcast 189	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull -207 -> 24
    //   234: new 108	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   241: astore 4
    //   243: aload 4
    //   245: ldc 226
    //   247: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: aload_2
    //   254: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 4
    //   260: ldc 228
    //   262: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: aload_3
    //   269: getfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   272: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 4
    //   278: ldc 233
    //   280: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 4
    //   286: aload_3
    //   287: getfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   290: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 4
    //   296: ldc 238
    //   298: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 4
    //   304: aload_3
    //   305: getfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   308: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 4
    //   314: ldc 240
    //   316: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 4
    //   322: aload_3
    //   323: getfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   326: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: ldc 120
    //   332: iconst_2
    //   333: aload 4
    //   335: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -317 -> 24
    //   344: aload_0
    //   345: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   348: invokevirtual 243	java/util/HashMap:size	()I
    //   351: iconst_4
    //   352: if_icmplt +22 -> 374
    //   355: aload_0
    //   356: getfield 43	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   359: iconst_1
    //   360: invokevirtual 246	mqq/os/MqqHandler:removeMessages	(I)V
    //   363: aload_0
    //   364: getfield 43	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   367: iconst_1
    //   368: invokevirtual 250	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   371: pop
    //   372: iconst_0
    //   373: ireturn
    //   374: aload_0
    //   375: getfield 43	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   378: iconst_1
    //   379: invokevirtual 253	mqq/os/MqqHandler:hasMessages	(I)Z
    //   382: ifne +416 -> 798
    //   385: aload_0
    //   386: getfield 43	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   389: iconst_1
    //   390: ldc2_w 254
    //   393: invokevirtual 259	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   396: pop
    //   397: iconst_0
    //   398: ireturn
    //   399: aload_1
    //   400: getfield 146	android/os/Message:what	I
    //   403: iconst_1
    //   404: if_icmpne +394 -> 798
    //   407: ldc 189
    //   409: monitorenter
    //   410: aload_0
    //   411: getfield 261	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   414: ifnonnull +32 -> 446
    //   417: aload_0
    //   418: getfield 23	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   421: invokevirtual 264	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   424: ifne +8 -> 432
    //   427: ldc 189
    //   429: monitorexit
    //   430: iconst_0
    //   431: ireturn
    //   432: aload_0
    //   433: aload_0
    //   434: getfield 23	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   437: invokevirtual 268	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   440: invokevirtual 274	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   443: putfield 261	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   446: aload_0
    //   447: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   450: invokevirtual 278	java/util/HashMap:keySet	()Ljava/util/Set;
    //   453: astore_1
    //   454: aload_0
    //   455: getfield 261	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   458: invokevirtual 284	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   461: astore_2
    //   462: aload_2
    //   463: invokevirtual 289	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   466: aload_1
    //   467: invokeinterface 292 1 0
    //   472: astore_3
    //   473: aload_3
    //   474: invokeinterface 170 1 0
    //   479: ifeq +228 -> 707
    //   482: aload_3
    //   483: invokeinterface 174 1 0
    //   488: checkcast 66	java/lang/String
    //   491: astore 4
    //   493: aload_0
    //   494: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   497: aload 4
    //   499: invokevirtual 187	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   502: checkcast 189	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo
    //   505: astore 5
    //   507: aload_0
    //   508: getfield 261	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   511: ldc 189
    //   513: aload 4
    //   515: invokevirtual 296	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   518: checkcast 189	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo
    //   521: astore_1
    //   522: aload_1
    //   523: ifnonnull +64 -> 587
    //   526: new 189	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo
    //   529: dup
    //   530: invokespecial 217	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:<init>	()V
    //   533: astore_1
    //   534: aload_1
    //   535: aload 4
    //   537: putfield 220	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   540: aload_1
    //   541: aload 5
    //   543: getfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   546: putfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   549: aload_1
    //   550: aload 5
    //   552: getfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   555: putfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   558: aload_1
    //   559: aload 5
    //   561: getfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   564: putfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   567: aload_1
    //   568: aload 5
    //   570: getfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   573: putfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   576: aload_1
    //   577: aload_0
    //   578: invokespecial 213	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:a	()Ljava/lang/String;
    //   581: putfield 216	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   584: goto +70 -> 654
    //   587: aload_1
    //   588: aload_1
    //   589: getfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   592: aload 5
    //   594: getfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   597: iadd
    //   598: putfield 192	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:count	I
    //   601: aload_1
    //   602: aload_1
    //   603: getfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   606: aload 5
    //   608: getfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   611: ladd
    //   612: putfield 196	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:showTime	J
    //   615: aload_1
    //   616: aload_1
    //   617: getfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   620: aload 5
    //   622: getfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   625: iadd
    //   626: putfield 201	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:displayCount	I
    //   629: aload_1
    //   630: aload_0
    //   631: aload_1
    //   632: getfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   635: aload 5
    //   637: getfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   640: invokevirtual 211	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   643: putfield 207	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   646: aload_1
    //   647: aload_0
    //   648: invokespecial 213	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:a	()Ljava/lang/String;
    //   651: putfield 216	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   654: aload_1
    //   655: invokevirtual 299	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:getStatus	()I
    //   658: sipush 1000
    //   661: if_icmpne +14 -> 675
    //   664: aload_0
    //   665: getfield 261	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   668: aload_1
    //   669: invokevirtual 303	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   672: goto -199 -> 473
    //   675: aload_1
    //   676: invokevirtual 299	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:getStatus	()I
    //   679: sipush 1001
    //   682: if_icmpeq +13 -> 695
    //   685: aload_1
    //   686: invokevirtual 299	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyActivityDAUInfo:getStatus	()I
    //   689: sipush 1002
    //   692: if_icmpne -219 -> 473
    //   695: aload_0
    //   696: getfield 261	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   699: aload_1
    //   700: invokevirtual 307	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   703: pop
    //   704: goto -231 -> 473
    //   707: aload_2
    //   708: invokevirtual 310	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   711: aload_2
    //   712: invokevirtual 313	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   715: goto +15 -> 730
    //   718: astore_1
    //   719: goto +67 -> 786
    //   722: astore_1
    //   723: aload_1
    //   724: invokevirtual 316	java/lang/Exception:printStackTrace	()V
    //   727: goto -16 -> 711
    //   730: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   733: ifeq +41 -> 774
    //   736: new 108	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   743: astore_1
    //   744: aload_1
    //   745: ldc_w 318
    //   748: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload_1
    //   753: aload_0
    //   754: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   757: invokevirtual 243	java/util/HashMap:size	()I
    //   760: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: ldc 120
    //   766: iconst_2
    //   767: aload_1
    //   768: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: aload_0
    //   775: getfield 30	com/tencent/mobileqq/kandian/glue/report/dau/ReadInJoyDAUStatistic:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   778: invokevirtual 321	java/util/HashMap:clear	()V
    //   781: ldc 189
    //   783: monitorexit
    //   784: iconst_0
    //   785: ireturn
    //   786: aload_2
    //   787: invokevirtual 313	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   790: aload_1
    //   791: athrow
    //   792: astore_1
    //   793: ldc 189
    //   795: monitorexit
    //   796: aload_1
    //   797: athrow
    //   798: iconst_0
    //   799: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	ReadInJoyDAUStatistic
    //   0	800	1	paramMessage	Message
    //   47	740	2	localObject1	Object
    //   42	441	3	localObject2	Object
    //   70	466	4	localObject3	Object
    //   505	131	5	localReadInJoyActivityDAUInfo	ReadInJoyActivityDAUInfo
    // Exception table:
    //   from	to	target	type
    //   462	473	718	finally
    //   473	522	718	finally
    //   526	584	718	finally
    //   587	654	718	finally
    //   654	672	718	finally
    //   675	695	718	finally
    //   695	704	718	finally
    //   707	711	718	finally
    //   723	727	718	finally
    //   462	473	722	java/lang/Exception
    //   473	522	722	java/lang/Exception
    //   526	584	722	java/lang/Exception
    //   587	654	722	java/lang/Exception
    //   654	672	722	java/lang/Exception
    //   675	695	722	java/lang/Exception
    //   695	704	722	java/lang/Exception
    //   707	711	722	java/lang/Exception
    //   410	430	792	finally
    //   432	446	792	finally
    //   446	462	792	finally
    //   711	715	792	finally
    //   730	774	792	finally
    //   774	784	792	finally
    //   786	792	792	finally
    //   793	796	792	finally
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.dau.ReadInJoyDAUStatistic
 * JD-Core Version:    0.7.0.1
 */