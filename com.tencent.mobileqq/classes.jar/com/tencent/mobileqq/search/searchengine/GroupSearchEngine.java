package com.tencent.mobileqq.search.searchengine;

import akep;
import akex;
import android.os.Bundle;
import avmg;
import avom;
import avtu;
import avtz;
import avug;
import avuh;
import avui;
import avuj;
import avuk;
import avul;
import avum;
import avun;
import avuo;
import avup;
import avuq;
import avur;
import avus;
import avut;
import avuu;
import avuv;
import avuw;
import avux;
import avuy;
import avuz;
import avva;
import avvb;
import avvn;
import avwe;
import avwf;
import awrn;
import bakq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
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
  implements avuz<avom>, Observer
{
  private static final Comparator<avuy> jdField_a_of_type_JavaUtilComparator = new avuh();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new avur(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new avuq());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GroupSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable;
  private GroupSearchEngine.TroopMemberSearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<avuy> jdField_a_of_type_JavaUtilArrayList;
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
  
  private ArrayList<avuy> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Int == 12)
    {
      localArrayList.add(new avus(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new avut(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    if (this.jdField_a_of_type_Int == 14)
    {
      localArrayList.add(new avuu(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new avuv(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    localArrayList.add(new avuw(this, new avtz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 197437, null), "people", 20));
    localArrayList.add(new avux(this, new MiniProgramSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "", 0));
    localArrayList.add(new avui(this, new avtu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 793, null), "people", 20));
    localArrayList.add(new avuj(this, new FunctionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "function", 130));
    localArrayList.add(new avuk(this, new avug(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "create_discussion", 120));
    if ((akep.jdField_a_of_type_Boolean) && (bakq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (bakq.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      localArrayList.add(new avul(this, new avmg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "fts_message", 40));
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add FTSMessageSearchEngine");
      }
      if ((akep.jdField_a_of_type_Boolean) && (bakq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (bakq.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) && ((!bakq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (bakq.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
        break label612;
      }
      localArrayList.add(new avum(this, new avvb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "message", 40));
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add MessageSearchEngine");
      }
    }
    for (;;)
    {
      localArrayList.add(new avun(this, new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "favorite", 60));
      localArrayList.add(new avuo(this, new FileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "file", 100));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add FTSMessageSearchEngine");
      break;
      label612:
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable.a();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.cancel(true);
      if ((this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor != null) && ((this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture instanceof Runnable))) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.remove((Runnable)this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable.b();
    }
  }
  
  public List<avom> a(avvn paramavvn)
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
        ((avuy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Avuz.a();
        i += 1;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "GroupSearchEngine.init() cost time : " + (l2 - l1));
    }
    awrn.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "GroupSearchEngineInit", true, l2 - l1, 0L, avwf.a(null), "", false);
  }
  
  public void a(avvn paramavvn, avva<avom> paramavva)
  {
    this.jdField_a_of_type_JavaLangString = paramavvn.jdField_a_of_type_JavaLangString;
    if (paramavvn.jdField_a_of_type_AndroidOsBundle == null) {
      paramavvn.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramavvn.jdField_a_of_type_AndroidOsBundle.putBoolean("bSearchNet", true);
    paramavvn.jdField_a_of_type_AndroidOsBundle.putInt("iNumber", 11);
    paramavvn.jdField_a_of_type_AndroidOsBundle.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    paramavvn.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", false);
    h();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable = new GroupSearchEngine.SearchRunnable(this, paramavvn, paramavva);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable);
    avwf.a("all_result", "active_local", new String[] { this.jdField_a_of_type_JavaLangString });
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
    avwe.a();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((avuy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Avuz.b();
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
        ((avuy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Avuz.c();
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
        ((avuy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Avuz.d();
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
    //   1: getfield 66	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 78	com/tencent/mobileqq/app/QQAppInterface:a	()Lakep;
    //   7: invokevirtual 83	akep:a	()Lakex;
    //   10: aload_0
    //   11: invokevirtual 418	akex:b	(Ljava/util/Observer;)V
    //   14: aload_0
    //   15: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: iconst_0
    //   22: istore_1
    //   23: iload_1
    //   24: aload_0
    //   25: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   28: invokevirtual 311	java/util/ArrayList:size	()I
    //   31: if_icmpge +29 -> 60
    //   34: aload_0
    //   35: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: iload_1
    //   39: invokevirtual 315	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 317	avuy
    //   45: getfield 320	avuy:jdField_a_of_type_Avuz	Lavuz;
    //   48: invokeinterface 420 1 0
    //   53: iload_1
    //   54: iconst_1
    //   55: iadd
    //   56: istore_1
    //   57: goto -34 -> 23
    //   60: aload_2
    //   61: monitorexit
    //   62: aload_0
    //   63: getfield 64	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_Long	J
    //   66: ldc2_w 61
    //   69: lcmp
    //   70: ifeq +207 -> 277
    //   73: new 422	java/util/HashMap
    //   76: dup
    //   77: invokespecial 423	java/util/HashMap:<init>	()V
    //   80: astore_3
    //   81: aload_0
    //   82: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: astore_2
    //   86: aload_2
    //   87: monitorenter
    //   88: iconst_0
    //   89: istore_1
    //   90: iload_1
    //   91: aload_0
    //   92: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 311	java/util/ArrayList:size	()I
    //   98: if_icmpge +106 -> 204
    //   101: aload_3
    //   102: aload_0
    //   103: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   106: iload_1
    //   107: invokevirtual 315	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   110: checkcast 317	avuy
    //   113: getfield 424	avuy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   120: iload_1
    //   121: invokevirtual 315	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   124: checkcast 317	avuy
    //   127: getfield 425	avuy:jdField_a_of_type_Long	J
    //   130: invokestatic 429	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   133: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload_3
    //   138: new 323	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: iload_1
    //   150: invokevirtual 315	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   153: checkcast 317	avuy
    //   156: getfield 424	avuy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 435
    //   165: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aload_0
    //   172: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   175: iload_1
    //   176: invokevirtual 315	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   179: checkcast 317	avuy
    //   182: getfield 436	avuy:jdField_a_of_type_Int	I
    //   185: invokestatic 439	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   188: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   207: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: ifnonnull +73 -> 283
    //   213: ldc 157
    //   215: astore_2
    //   216: aload_3
    //   217: ldc_w 441
    //   220: aload_2
    //   221: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: aload_0
    //   226: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: ifnonnull +62 -> 291
    //   232: ldc_w 443
    //   235: astore_2
    //   236: aload_3
    //   237: ldc_w 445
    //   240: aload_2
    //   241: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   248: invokestatic 348	awrn:a	(Landroid/content/Context;)Lawrn;
    //   251: aload_0
    //   252: getfield 66	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   255: invokevirtual 351	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   258: ldc_w 447
    //   261: iconst_1
    //   262: aload_0
    //   263: getfield 64	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_Long	J
    //   266: lconst_0
    //   267: aload_3
    //   268: invokestatic 358	avwf:a	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   271: ldc 157
    //   273: iconst_0
    //   274: invokevirtual 361	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   277: return
    //   278: astore_3
    //   279: aload_2
    //   280: monitorexit
    //   281: aload_3
    //   282: athrow
    //   283: aload_0
    //   284: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   287: astore_2
    //   288: goto -72 -> 216
    //   291: aload_0
    //   292: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokevirtual 450	java/lang/String:trim	()Ljava/lang/String;
    //   298: ldc_w 452
    //   301: invokevirtual 456	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   304: arraylength
    //   305: invokestatic 460	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   308: astore_2
    //   309: goto -73 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	GroupSearchEngine
    //   22	174	1	i	int
    //   18	291	2	localObject1	Object
    //   80	58	3	localHashMap1	java.util.HashMap
    //   199	69	3	localHashMap2	java.util.HashMap
    //   278	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	53	199	finally
    //   60	62	199	finally
    //   200	202	199	finally
    //   90	192	278	finally
    //   204	206	278	finally
    //   279	281	278	finally
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
          avuy localavuy = (avuy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localavuy.jdField_a_of_type_Avuz instanceof avmg)) {
            ((avmg)localavuy.jdField_a_of_type_Avuz).f();
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
          avuy localavuy = (avuy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localavuy.jdField_a_of_type_Avuz instanceof avmg)) {
            ((avmg)localavuy.jdField_a_of_type_Avuz).g();
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
    if ((akep.jdField_a_of_type_Boolean) && ((paramObservable instanceof akep)))
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
          paramObject = (avuy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((paramObject.jdField_a_of_type_Avuz instanceof avmg))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if ((paramObject.jdField_a_of_type_Avuz instanceof avvb))
          {
            paramObject = new avmg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramObject.a();
            this.jdField_a_of_type_JavaUtilArrayList.add(i, new avup(this, paramObject, "fts message", 40));
            if (bakq.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
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