package com.tencent.mobileqq.search.searchengine;

import ahzx;
import ahzy;
import ahzz;
import aiaa;
import aiab;
import aiac;
import aiad;
import aiae;
import aiaf;
import aiag;
import aiah;
import aiai;
import aiaj;
import aiak;
import aial;
import aiam;
import aian;
import aiao;
import aiap;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import cooperation.qqfav.globalsearch.FunctionSearchEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GroupSearchEngine
  implements ISearchEngine, Observer
{
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new ahzx();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new aiah(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new aiag());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private aiao jdField_a_of_type_Aiao;
  private aiap jdField_a_of_type_Aiap;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Future jdField_a_of_type_JavaUtilConcurrentFuture;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = a();
    paramQQAppInterface.a().a().a(this);
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Int == 12)
    {
      localArrayList.add(new aiai(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new aiaj(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    if (this.jdField_a_of_type_Int == 14)
    {
      localArrayList.add(new aiak(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new aial(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    localArrayList.add(new aiam(this, new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 197437, null), "people", 20));
    localArrayList.add(new aian(this, new ApproximateSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 793, null), "people", 20));
    localArrayList.add(new ahzy(this, new FunctionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "function", 130));
    localArrayList.add(new ahzz(this, new CreateDiscussionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "create_discussion", 120));
    if ((FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      localArrayList.add(new aiaa(this, new FTSMessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "fts_message", 40));
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add FTSMessageSearchEngine");
      }
      if ((FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (SQLiteFTSUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) && ((!SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
        break label609;
      }
      localArrayList.add(new aiab(this, new MessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "message", 40));
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add MessageSearchEngine");
      }
    }
    for (;;)
    {
      localArrayList.add(new aiac(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new aiad(this, new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "favorite", 60));
      localArrayList.add(new aiae(this, new FileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "file", 100));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add FTSMessageSearchEngine");
      break;
      label609:
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add MessageSearchEngine");
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentFuture != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
      if ((this.jdField_a_of_type_JavaUtilConcurrentFuture instanceof Runnable)) {
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.remove((Runnable)this.jdField_a_of_type_JavaUtilConcurrentFuture);
      }
    }
    if (this.jdField_a_of_type_Aiao != null) {
      this.jdField_a_of_type_Aiao.a();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.cancel(true);
      if ((this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor != null) && ((this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture instanceof Runnable))) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.remove((Runnable)this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture);
      }
    }
    if (this.jdField_a_of_type_Aiap != null) {
      this.jdField_a_of_type_Aiap.b();
    }
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    return null;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    SearchConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilComparator);
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a();
        i += 1;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "GroupSearchEngine.init() cost time : " + (l2 - l1));
    }
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "GroupSearchEngineInit", true, l2 - l1, 0L, SearchUtils.a(null), "", false);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      paramSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("bSearchNet", true);
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putInt("iNumber", 11);
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", false);
    h();
    this.jdField_a_of_type_Aiao = new aiao(this, paramSearchRequest, paramISearchListener);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_Aiao);
    SearchUtils.a("all_result", "active_local", new String[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    SearchStatisticsConstants.a();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
        i += 1;
      }
      h();
      return;
    }
    finally {}
  }
  
  public void c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.c();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.d();
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/FTSDBManager;
    //   7: invokevirtual 80	com/tencent/mobileqq/app/proxy/FTSDBManager:a	()Lcom/tencent/mobileqq/app/proxy/fts/FTSMsgOperator;
    //   10: aload_0
    //   11: invokevirtual 408	com/tencent/mobileqq/app/proxy/fts/FTSMsgOperator:b	(Ljava/util/Observer;)V
    //   14: aload_0
    //   15: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: iconst_0
    //   22: istore_1
    //   23: iload_1
    //   24: aload_0
    //   25: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   28: invokevirtual 300	java/util/ArrayList:size	()I
    //   31: if_icmpge +29 -> 60
    //   34: aload_0
    //   35: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: iload_1
    //   39: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 306	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity
    //   45: getfield 309	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity:jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine	Lcom/tencent/mobileqq/search/searchengine/ISearchEngine;
    //   48: invokeinterface 410 1 0
    //   53: iload_1
    //   54: iconst_1
    //   55: iadd
    //   56: istore_1
    //   57: goto -34 -> 23
    //   60: aload_2
    //   61: monitorexit
    //   62: aload_0
    //   63: getfield 61	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_Long	J
    //   66: ldc2_w 58
    //   69: lcmp
    //   70: ifeq +209 -> 279
    //   73: new 412	java/util/HashMap
    //   76: dup
    //   77: invokespecial 413	java/util/HashMap:<init>	()V
    //   80: astore_3
    //   81: aload_0
    //   82: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: astore_2
    //   86: aload_2
    //   87: monitorenter
    //   88: iconst_0
    //   89: istore_1
    //   90: iload_1
    //   91: aload_0
    //   92: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 300	java/util/ArrayList:size	()I
    //   98: if_icmpge +106 -> 204
    //   101: aload_3
    //   102: aload_0
    //   103: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   106: iload_1
    //   107: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   110: checkcast 306	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity
    //   113: getfield 414	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   120: iload_1
    //   121: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   124: checkcast 306	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity
    //   127: getfield 415	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity:jdField_a_of_type_Long	J
    //   130: invokestatic 419	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   133: invokevirtual 423	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload_3
    //   138: new 312	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: iload_1
    //   150: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   153: checkcast 306	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity
    //   156: getfield 414	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 425
    //   165: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aload_0
    //   172: getfield 70	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   175: iload_1
    //   176: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   179: checkcast 306	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity
    //   182: getfield 426	com/tencent/mobileqq/search/searchengine/GroupSearchEngine$SearchEngineEntity:jdField_a_of_type_Int	I
    //   185: invokestatic 429	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   188: invokevirtual 423	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: iload_1
    //   193: iconst_1
    //   194: iadd
    //   195: istore_1
    //   196: goto -106 -> 90
    //   199: astore_3
    //   200: aload_2
    //   201: monitorexit
    //   202: aload_3
    //   203: athrow
    //   204: aload_2
    //   205: monitorexit
    //   206: aload_0
    //   207: getfield 96	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: ifnonnull +75 -> 285
    //   213: ldc_w 349
    //   216: astore_2
    //   217: aload_3
    //   218: ldc_w 431
    //   221: aload_2
    //   222: invokevirtual 423	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: pop
    //   226: aload_0
    //   227: getfield 96	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: ifnonnull +63 -> 293
    //   233: ldc_w 433
    //   236: astore_2
    //   237: aload_3
    //   238: ldc_w 435
    //   241: aload_2
    //   242: invokevirtual 423	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: invokestatic 332	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   249: invokestatic 337	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   252: aload_0
    //   253: getfield 63	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   256: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   259: ldc_w 437
    //   262: iconst_1
    //   263: aload_0
    //   264: getfield 61	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_Long	J
    //   267: lconst_0
    //   268: aload_3
    //   269: invokestatic 347	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   272: ldc_w 349
    //   275: iconst_0
    //   276: invokevirtual 352	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   279: return
    //   280: astore_3
    //   281: aload_2
    //   282: monitorexit
    //   283: aload_3
    //   284: athrow
    //   285: aload_0
    //   286: getfield 96	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   289: astore_2
    //   290: goto -73 -> 217
    //   293: aload_0
    //   294: getfield 96	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: invokevirtual 440	java/lang/String:trim	()Ljava/lang/String;
    //   300: ldc_w 442
    //   303: invokevirtual 446	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   306: arraylength
    //   307: invokestatic 450	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   310: astore_2
    //   311: goto -74 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	GroupSearchEngine
    //   22	174	1	i	int
    //   18	293	2	localObject1	Object
    //   80	58	3	localHashMap1	java.util.HashMap
    //   199	70	3	localHashMap2	java.util.HashMap
    //   280	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	53	199	finally
    //   60	62	199	finally
    //   200	202	199	finally
    //   90	192	280	finally
    //   204	206	280	finally
    //   281	283	280	finally
  }
  
  public void f()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof FTSMessageSearchEngine)) {
            ((FTSMessageSearchEngine)localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).f();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void g()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof FTSMessageSearchEngine)) {
            ((FTSMessageSearchEngine)localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).g();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((FTSDBManager.jdField_a_of_type_Boolean) && ((paramObservable instanceof FTSDBManager)))
    {
      paramObservable = this.jdField_a_of_type_JavaUtilArrayList;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          paramObject = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((paramObject.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof FTSMessageSearchEngine))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if ((paramObject.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof MessageSearchEngine))
          {
            paramObject = new FTSMessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramObject.a();
            this.jdField_a_of_type_JavaUtilArrayList.add(i, new aiaf(this, paramObject, "fts message", 40));
            if (SQLiteFTSUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
              this.jdField_a_of_type_JavaUtilArrayList.remove(i + 1);
            }
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines add FTSMessageSearchEngine");
            }
            return;
          }
        }
        finally {}
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "update() illegal");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine
 * JD-Core Version:    0.7.0.1
 */