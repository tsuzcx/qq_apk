package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import aoxx;
import aoyc;
import bcdc;
import bcfi;
import bckr;
import bckw;
import bcld;
import bcle;
import bclf;
import bclg;
import bclh;
import bcli;
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
import bcmk;
import bcmz;
import bcnb;
import bcnc;
import bdvn;
import bhkf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
  implements bclw<bcfi>, Observer
{
  private static final Comparator<bclv> jdField_a_of_type_JavaUtilComparator = new bcle();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new bclo(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new bcln());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GroupSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable;
  private GroupSearchEngine.TroopMemberSearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<bclv> jdField_a_of_type_JavaUtilArrayList;
  private Future jdField_a_of_type_JavaUtilConcurrentFuture;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = a();
    paramQQAppInterface.getFTSDBManager().a().a(this);
  }
  
  private ArrayList<bclv> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Int == 12)
    {
      localArrayList.add(new bclp(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new bclq(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    if (this.jdField_a_of_type_Int == 14)
    {
      localArrayList.add(new bclr(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new bcls(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    localArrayList.add(new bclt(this, new bckw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 197437, null), "people", 20));
    if (bdvn.a()) {
      d(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
      a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      b(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      c(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      d(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      e(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    }
  }
  
  private void a(ArrayList<bclv> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    paramArrayList.add(new bclk(this, new FavoriteSearchEngine(paramQQAppInterface), "favorite", 60));
  }
  
  private void a(ArrayList<bclv> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new bclu(this, new MiniProgramSearchEngine(paramQQAppInterface, paramInt), "", 0, paramInt));
  }
  
  private void b(ArrayList<bclv> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new bclf(this, new bckr(paramQQAppInterface, paramInt, 793, null), "people", 20, paramInt));
  }
  
  private void c(ArrayList<bclv> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new bclg(this, new FunctionSearchEngine(paramQQAppInterface, paramInt), "function", 130, paramInt));
  }
  
  private void d(ArrayList<bclv> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool1 = bcmz.f();
    boolean bool2 = bcmz.e();
    if (bool1)
    {
      paramArrayList.add(new bclh(this, new bcld(paramQQAppInterface, paramInt), "create_discussion", 120, paramInt));
      if ((bool2) && (aoxx.jdField_a_of_type_Boolean) && (bhkf.a(paramQQAppInterface)) && (paramQQAppInterface.getFTSDBManager().a()) && (bhkf.d(paramQQAppInterface)))
      {
        paramArrayList.add(new bcli(this, new bcdc(paramQQAppInterface), "fts_message", 40, paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add FTSMessageSearchEngine");
        }
        if ((bool2) && (aoxx.jdField_a_of_type_Boolean) && (bhkf.a(paramQQAppInterface)) && (paramQQAppInterface.getFTSDBManager().a()) && (bhkf.e(paramQQAppInterface) != 1) && ((!bhkf.a(paramQQAppInterface)) || (bhkf.d(paramQQAppInterface)))) {
          break label270;
        }
        paramArrayList.add(new bclj(this, new bcly(paramQQAppInterface), "message", 40));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add MessageSearchEngine");
        }
      }
    }
    for (;;)
    {
      QLog.d("GroupSearchEngine", 2, "bShowMsgSearchResult : " + bool1 + "bEnableFtsSearch: " + bool2);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add FTSMessageSearchEngine");
      break;
      label270:
      if (QLog.isColorLevel())
      {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add MessageSearchEngine");
        continue;
        QLog.e("GroupSearchEngine", 2, "not show message search! ");
      }
    }
  }
  
  private void e(ArrayList<bclv> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new bcll(this, new FileManagerSearchEngine(paramQQAppInterface, paramInt), "file", 100, paramInt));
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
  
  public List<bcfi> a(bcmk parambcmk)
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
        ((bclv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bclw.a();
        i += 1;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "GroupSearchEngine.init() cost time : " + (l2 - l1));
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "GroupSearchEngineInit", true, l2 - l1, 0L, bcnc.a(null), "", false);
  }
  
  public void a(bcmk parambcmk, bclx<bcfi> parambclx)
  {
    this.jdField_a_of_type_JavaLangString = parambcmk.jdField_a_of_type_JavaLangString;
    if (parambcmk.jdField_a_of_type_AndroidOsBundle == null) {
      parambcmk.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("bSearchNet", true);
    parambcmk.jdField_a_of_type_AndroidOsBundle.putInt("iNumber", 11);
    parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", false);
    h();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable = new GroupSearchEngine.SearchRunnable(this, parambcmk, parambclx);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable);
    bcnc.a("all_result", "active_local", new String[] { this.jdField_a_of_type_JavaLangString });
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
    bcnb.a();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bclv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bclw.b();
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
        ((bclv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bclw.c();
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
        ((bclv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Bclw.d();
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
    //   4: invokevirtual 79	com/tencent/mobileqq/app/QQAppInterface:getFTSDBManager	()Laoxx;
    //   7: invokevirtual 84	aoxx:a	()Laoyc;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +8 -> 20
    //   15: aload_2
    //   16: aload_0
    //   17: invokevirtual 460	aoyc:b	(Ljava/util/Observer;)V
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
    //   34: invokevirtual 363	java/util/ArrayList:size	()I
    //   37: if_icmpge +29 -> 66
    //   40: aload_0
    //   41: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   44: iload_1
    //   45: invokevirtual 367	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 369	bclv
    //   51: getfield 372	bclv:jdField_a_of_type_Bclw	Lbclw;
    //   54: invokeinterface 462 1 0
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
    //   79: new 464	java/util/HashMap
    //   82: dup
    //   83: invokespecial 465	java/util/HashMap:<init>	()V
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
    //   101: invokevirtual 363	java/util/ArrayList:size	()I
    //   104: if_icmpge +106 -> 210
    //   107: aload_3
    //   108: aload_0
    //   109: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   112: iload_1
    //   113: invokevirtual 367	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   116: checkcast 369	bclv
    //   119: getfield 466	bclv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   126: iload_1
    //   127: invokevirtual 367	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   130: checkcast 369	bclv
    //   133: getfield 467	bclv:jdField_a_of_type_Long	J
    //   136: invokestatic 471	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   139: invokevirtual 475	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_3
    //   144: new 282	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   151: aload_0
    //   152: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   155: iload_1
    //   156: invokevirtual 367	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   159: checkcast 369	bclv
    //   162: getfield 466	bclv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 477
    //   171: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload_0
    //   178: getfield 73	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   181: iload_1
    //   182: invokevirtual 367	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   185: checkcast 369	bclv
    //   188: getfield 479	bclv:b	I
    //   191: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: invokevirtual 475	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   213: getfield 100	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   216: ifnonnull +73 -> 289
    //   219: ldc 202
    //   221: astore_2
    //   222: aload_3
    //   223: ldc_w 484
    //   226: aload_2
    //   227: invokevirtual 475	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload_0
    //   232: getfield 100	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   235: ifnonnull +62 -> 297
    //   238: ldc_w 486
    //   241: astore_2
    //   242: aload_3
    //   243: ldc_w 488
    //   246: aload_2
    //   247: invokevirtual 475	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: invokestatic 384	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   254: invokestatic 390	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   257: aload_0
    //   258: getfield 66	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   261: invokevirtual 393	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   264: ldc_w 490
    //   267: iconst_1
    //   268: aload_0
    //   269: getfield 64	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_Long	J
    //   272: lconst_0
    //   273: aload_3
    //   274: invokestatic 400	bcnc:a	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   277: ldc 202
    //   279: iconst_0
    //   280: invokevirtual 404	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   283: return
    //   284: astore_3
    //   285: aload_2
    //   286: monitorexit
    //   287: aload_3
    //   288: athrow
    //   289: aload_0
    //   290: getfield 100	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: astore_2
    //   294: goto -72 -> 222
    //   297: aload_0
    //   298: getfield 100	com/tencent/mobileqq/search/searchengine/GroupSearchEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: invokevirtual 493	java/lang/String:trim	()Ljava/lang/String;
    //   304: ldc_w 495
    //   307: invokevirtual 499	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   310: arraylength
    //   311: invokestatic 503	java/lang/Integer:toString	(I)Ljava/lang/String;
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
          bclv localbclv = (bclv)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localbclv.jdField_a_of_type_Bclw instanceof bcdc)) {
            ((bcdc)localbclv.jdField_a_of_type_Bclw).f();
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
          bclv localbclv = (bclv)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localbclv.jdField_a_of_type_Bclw instanceof bcdc)) {
            ((bcdc)localbclv.jdField_a_of_type_Bclw).g();
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
    if ((aoxx.jdField_a_of_type_Boolean) && ((paramObservable instanceof aoxx)))
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
          paramObject = (bclv)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((paramObject.jdField_a_of_type_Bclw instanceof bcdc))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if ((paramObject.jdField_a_of_type_Bclw instanceof bcly))
          {
            paramObject = new bcdc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramObject.a();
            this.jdField_a_of_type_JavaUtilArrayList.add(i, new bclm(this, paramObject, "fts message", 40));
            if (bhkf.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine
 * JD-Core Version:    0.7.0.1
 */