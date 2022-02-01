package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import apau;
import apaz;
import bcdk;
import bcfq;
import bckx;
import bclc;
import bclj;
import bclk;
import bcll;
import bclm;
import bcln;
import bclo;
import bclp;
import bclq;
import bclr;
import bcls;
import bclt;
import bclu;
import bclv;
import bclw;
import bclx;
import bcly;
import bclz;
import bcma;
import bcmb;
import bcmc;
import bcmd;
import bcme;
import bcmq;
import bcnf;
import bcnh;
import bcni;
import bdmc;
import bhut;
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
  implements bcmc<bcfq>, Observer
{
  private static final Comparator<bcmb> jdField_a_of_type_JavaUtilComparator = new bclk();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new bclu(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new bclt());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GroupSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable;
  private GroupSearchEngine.TroopMemberSearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<bcmb> jdField_a_of_type_JavaUtilArrayList;
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
  
  private ArrayList<bcmb> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Int == 12)
    {
      localArrayList.add(new bclv(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new bclw(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    if (this.jdField_a_of_type_Int == 14)
    {
      localArrayList.add(new bclx(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new bcly(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    localArrayList.add(new bclz(this, new bclc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 197437, null), "people", 20));
    localArrayList.add(new bcma(this, new MiniProgramSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "", 0));
    localArrayList.add(new bcll(this, new bckx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 793, null), "people", 20));
    localArrayList.add(new bclm(this, new FunctionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "function", 130));
    boolean bool1 = bcnf.f();
    boolean bool2 = bcnf.e();
    if (bool1)
    {
      localArrayList.add(new bcln(this, new bclj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "create_discussion", 120));
      if ((bool2) && (apau.jdField_a_of_type_Boolean) && (bhut.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (bhut.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        localArrayList.add(new bclo(this, new bcdk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "fts_message", 40));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add FTSMessageSearchEngine");
        }
        if ((bool2) && (apau.jdField_a_of_type_Boolean) && (bhut.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (bhut.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) && ((!bhut.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (bhut.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
          break label669;
        }
        localArrayList.add(new bclp(this, new bcme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "message", 40));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add MessageSearchEngine");
        }
      }
    }
    for (;;)
    {
      QLog.d("GroupSearchEngine", 2, "bShowMsgSearchResult : " + bool1 + "bEnableFtsSearch: " + bool2);
      localArrayList.add(new bclq(this, new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "favorite", 60));
      localArrayList.add(new bclr(this, new FileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "file", 100));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add FTSMessageSearchEngine");
      break;
      label669:
      if (QLog.isColorLevel())
      {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add MessageSearchEngine");
        continue;
        QLog.e("GroupSearchEngine", 2, "not show message search! ");
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
  
  public List<bcfq> a(bcmq parambcmq)
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
        ((bcmb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bcmc.a();
        i += 1;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "GroupSearchEngine.init() cost time : " + (l2 - l1));
    }
    bdmc.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "GroupSearchEngineInit", true, l2 - l1, 0L, bcni.a(null), "", false);
  }
  
  public void a(bcmq parambcmq, bcmd<bcfq> parambcmd)
  {
    this.jdField_a_of_type_JavaLangString = parambcmq.jdField_a_of_type_JavaLangString;
    if (parambcmq.jdField_a_of_type_AndroidOsBundle == null) {
      parambcmq.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    parambcmq.jdField_a_of_type_AndroidOsBundle.putBoolean("bSearchNet", true);
    parambcmq.jdField_a_of_type_AndroidOsBundle.putInt("iNumber", 11);
    parambcmq.jdField_a_of_type_AndroidOsBundle.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    parambcmq.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", false);
    h();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable = new GroupSearchEngine.SearchRunnable(this, parambcmq, parambcmd);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable);
    bcni.a("all_result", "active_local", new String[] { this.jdField_a_of_type_JavaLangString });
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
    bcnh.a();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bcmb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bcmc.b();
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
        ((bcmb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bcmc.c();
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
        ((bcmb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bcmc.d();
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
    //   4: invokevirtual 78	com/tencent/mobileqq/app/QQAppInterface:a	()Lapau;
    //   7: invokevirtual 83	apau:a	()Lapaz;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +8 -> 20
    //   15: aload_2
    //   16: aload_0
    //   17: invokevirtual 436	apaz:b	(Ljava/util/Observer;)V
    //   20: aload_0
    //   21: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   24: astore_2
    //   25: aload_2
    //   26: monitorenter
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: aload_0
    //   31: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   34: invokevirtual 340	java/util/ArrayList:size	()I
    //   37: if_icmpge +29 -> 66
    //   40: aload_0
    //   41: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   44: iload_1
    //   45: invokevirtual 344	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 346	bcmb
    //   51: getfield 349	bcmb:jdField_a_of_type_Bcmc	Lbcmc;
    //   54: invokeinterface 438 1 0
    //   59: iload_1
    //   60: iconst_1
    //   61: iadd
    //   62: istore_1
    //   63: goto -34 -> 29
    //   66: aload_2
    //   67: monitorexit
    //   68: aload_0
    //   69: getfield 64	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_Long	J
    //   72: ldc2_w 61
    //   75: lcmp
    //   76: ifeq +207 -> 283
    //   79: new 440	java/util/HashMap
    //   82: dup
    //   83: invokespecial 441	java/util/HashMap:<init>	()V
    //   86: astore_3
    //   87: aload_0
    //   88: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   91: astore_2
    //   92: aload_2
    //   93: monitorenter
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: aload_0
    //   98: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   101: invokevirtual 340	java/util/ArrayList:size	()I
    //   104: if_icmpge +106 -> 210
    //   107: aload_3
    //   108: aload_0
    //   109: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   112: iload_1
    //   113: invokevirtual 344	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   116: checkcast 346	bcmb
    //   119: getfield 442	bcmb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   126: iload_1
    //   127: invokevirtual 344	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   130: checkcast 346	bcmb
    //   133: getfield 443	bcmb:jdField_a_of_type_Long	J
    //   136: invokestatic 447	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   139: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_3
    //   144: new 238	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   151: aload_0
    //   152: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   155: iload_1
    //   156: invokevirtual 344	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   159: checkcast 346	bcmb
    //   162: getfield 442	bcmb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 453
    //   171: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload_0
    //   178: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   181: iload_1
    //   182: invokevirtual 344	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   185: checkcast 346	bcmb
    //   188: getfield 454	bcmb:jdField_a_of_type_Int	I
    //   191: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: iload_1
    //   199: iconst_1
    //   200: iadd
    //   201: istore_1
    //   202: goto -106 -> 96
    //   205: astore_3
    //   206: aload_2
    //   207: monitorexit
    //   208: aload_3
    //   209: athrow
    //   210: aload_2
    //   211: monitorexit
    //   212: aload_0
    //   213: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   216: ifnonnull +73 -> 289
    //   219: ldc 157
    //   221: astore_2
    //   222: aload_3
    //   223: ldc_w 459
    //   226: aload_2
    //   227: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload_0
    //   232: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   235: ifnonnull +62 -> 297
    //   238: ldc_w 461
    //   241: astore_2
    //   242: aload_3
    //   243: ldc_w 463
    //   246: aload_2
    //   247: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: invokestatic 361	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   254: invokestatic 366	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   257: aload_0
    //   258: getfield 66	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   261: invokevirtual 369	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   264: ldc_w 465
    //   267: iconst_1
    //   268: aload_0
    //   269: getfield 64	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_Long	J
    //   272: lconst_0
    //   273: aload_3
    //   274: invokestatic 376	bcni:a	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   277: ldc 157
    //   279: iconst_0
    //   280: invokevirtual 379	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   283: return
    //   284: astore_3
    //   285: aload_2
    //   286: monitorexit
    //   287: aload_3
    //   288: athrow
    //   289: aload_0
    //   290: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: astore_2
    //   294: goto -72 -> 222
    //   297: aload_0
    //   298: getfield 99	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   304: ldc_w 470
    //   307: invokevirtual 474	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   310: arraylength
    //   311: invokestatic 478	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   314: astore_2
    //   315: goto -73 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	GroupSearchEngine
    //   28	174	1	i	int
    //   10	305	2	localObject1	Object
    //   86	58	3	localHashMap1	java.util.HashMap
    //   205	69	3	localHashMap2	java.util.HashMap
    //   284	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	59	205	finally
    //   66	68	205	finally
    //   206	208	205	finally
    //   96	198	284	finally
    //   210	212	284	finally
    //   285	287	284	finally
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
          bcmb localbcmb = (bcmb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localbcmb.jdField_a_of_type_Bcmc instanceof bcdk)) {
            ((bcdk)localbcmb.jdField_a_of_type_Bcmc).f();
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
          bcmb localbcmb = (bcmb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localbcmb.jdField_a_of_type_Bcmc instanceof bcdk)) {
            ((bcdk)localbcmb.jdField_a_of_type_Bcmc).g();
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
    if ((apau.jdField_a_of_type_Boolean) && ((paramObservable instanceof apau)))
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
          paramObject = (bcmb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((paramObject.jdField_a_of_type_Bcmc instanceof bcdk))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if ((paramObject.jdField_a_of_type_Bcmc instanceof bcme))
          {
            paramObject = new bcdk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramObject.a();
            this.jdField_a_of_type_JavaUtilArrayList.add(i, new bcls(this, paramObject, "fts message", 40));
            if (bhut.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine
 * JD-Core Version:    0.7.0.1
 */