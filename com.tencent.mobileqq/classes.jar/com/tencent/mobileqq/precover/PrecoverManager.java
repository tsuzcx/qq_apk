package com.tencent.mobileqq.precover;

import agnb;
import agnc;
import agnd;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PrecoverConfig;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.data.PrecoverResourceBusiness;
import com.tencent.mobileqq.data.PrecoverRetryInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class PrecoverManager
  implements PrecoverListener, Manager
{
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private PrecoverControl jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl;
  private PrecoverReporter jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter;
  private PrecoverResDownloader jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private PrecoverBusiConfigHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqPrecoverPrecoverBusiConfigHandler = new PrecoverBusiConfigHandler[jdField_a_of_type_JavaUtilSet.size()];
  private final HashMap b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
  }
  
  public PrecoverManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader = new PrecoverResDownloader(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl = PrecoverControl.a();
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter = new PrecoverReporter(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new agnb(this), 10, null, false);
      return;
    }
    b();
  }
  
  private PrecoverRetryInfo a(PrecoverResource paramPrecoverResource)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "getRetryInfo, res=" + paramPrecoverResource);
    }
    if (paramPrecoverResource == null) {
      return null;
    }
    try
    {
      paramPrecoverResource = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PrecoverRetryInfo.class, false, "pk = ?", new String[] { paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5 }, null, null, null, null);
      if ((paramPrecoverResource != null) && (paramPrecoverResource.size() > 0))
      {
        paramPrecoverResource = (PrecoverRetryInfo)paramPrecoverResource.get(0);
        return paramPrecoverResource;
      }
    }
    catch (Exception paramPrecoverResource)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverManager", 2, new Object[] { "getRetryInfo, exception=", paramPrecoverResource.getMessage() });
          paramPrecoverResource.printStackTrace();
        }
        paramPrecoverResource = null;
        continue;
        paramPrecoverResource = null;
      }
    }
  }
  
  private static String a(PrecoverResource paramPrecoverResource)
  {
    return paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5;
  }
  
  private void a(PrecoverRetryInfo paramPrecoverRetryInfo)
  {
    if (QLog.isColorLevel()) {
      if (paramPrecoverRetryInfo != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = "null";; localObject = paramPrecoverRetryInfo)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "updateRetryInfo, retryInfo=", localObject });
      if (paramPrecoverRetryInfo != null) {
        break;
      }
      return;
    }
    a(paramPrecoverRetryInfo);
  }
  
  private void a(Entity paramEntity)
  {
    if (QLog.isColorLevel()) {
      if (paramEntity != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = "null";; localObject = paramEntity)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity=", localObject });
      if (paramEntity != null) {
        break;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity.Name=", paramEntity.getClass().getSimpleName() });
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      ((EntityTransaction)localObject).c();
      return;
    }
    catch (Exception paramEntity)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, exception=", paramEntity.getMessage() });
        paramEntity.printStackTrace();
      }
      return;
    }
    finally
    {
      ((EntityTransaction)localObject).b();
    }
  }
  
  private boolean a(Class paramClass)
  {
    return a("delete_all", paramClass);
  }
  
  /* Error */
  private boolean a(String paramString, Class paramClass)
  {
    // Byte code:
    //   0: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: aload_1
    //   7: ifnonnull +72 -> 79
    //   10: ldc 208
    //   12: astore_3
    //   13: ldc 137
    //   15: iconst_2
    //   16: iconst_4
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: ldc 252
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_3
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc 254
    //   33: aastore
    //   34: dup
    //   35: iconst_3
    //   36: aload_2
    //   37: invokevirtual 226	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   40: aastore
    //   41: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: aload_1
    //   45: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne +29 -> 77
    //   51: aload_2
    //   52: ldc 165
    //   54: if_acmpeq +30 -> 84
    //   57: aload_2
    //   58: ldc_w 262
    //   61: if_acmpeq +23 -> 84
    //   64: aload_2
    //   65: ldc 159
    //   67: if_acmpeq +17 -> 84
    //   70: aload_2
    //   71: ldc_w 264
    //   74: if_acmpeq +10 -> 84
    //   77: iconst_0
    //   78: ireturn
    //   79: aload_1
    //   80: astore_3
    //   81: goto -68 -> 13
    //   84: aload_0
    //   85: getfield 78	com/tencent/mobileqq/precover/PrecoverManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   91: astore_3
    //   92: aload_3
    //   93: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   96: aload_2
    //   97: invokevirtual 226	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   100: astore_2
    //   101: aload_1
    //   102: ldc 247
    //   104: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +63 -> 170
    //   110: ldc_w 269
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_2
    //   120: aastore
    //   121: invokestatic 273	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: astore_1
    //   125: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +23 -> 151
    //   131: ldc 137
    //   133: iconst_2
    //   134: iconst_2
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: ldc_w 275
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload_1
    //   147: aastore
    //   148: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 78	com/tencent/mobileqq/precover/PrecoverManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   155: aload_1
    //   156: invokevirtual 278	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   159: pop
    //   160: aload_3
    //   161: invokevirtual 238	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   164: aload_3
    //   165: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   168: iconst_1
    //   169: ireturn
    //   170: ldc_w 280
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_2
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: aload_1
    //   184: aastore
    //   185: invokestatic 273	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   188: astore_1
    //   189: goto -64 -> 125
    //   192: astore_1
    //   193: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +30 -> 226
    //   199: ldc 137
    //   201: iconst_2
    //   202: iconst_2
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: ldc_w 282
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: aload_1
    //   215: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   222: aload_1
    //   223: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   226: aload_3
    //   227: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   230: iconst_0
    //   231: ireturn
    //   232: astore_1
    //   233: aload_3
    //   234: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   237: aload_1
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	PrecoverManager
    //   0	239	1	paramString	String
    //   0	239	2	paramClass	Class
    //   12	222	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   92	125	192	java/lang/Exception
    //   125	151	192	java/lang/Exception
    //   151	164	192	java/lang/Exception
    //   170	189	192	java/lang/Exception
    //   92	125	232	finally
    //   125	151	232	finally
    //   151	164	232	finally
    //   170	189	232	finally
    //   193	226	232	finally
  }
  
  private void b()
  {
    Object localObject5;
    Object localObject6;
    List localList;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "initCache");
      }
      Object localObject1 = a(null, null, PrecoverResource.class);
      localObject5 = a(null, null, PrecoverResourceBusiness.class);
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.b.clear();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject6 = ((List)localObject1).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            PrecoverResource localPrecoverResource = (PrecoverResource)((Iterator)localObject6).next();
            if (localPrecoverResource.isValid())
            {
              localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(localPrecoverResource.businessId);
              localObject1 = localList;
              if (localList == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localPrecoverResource);
              this.jdField_a_of_type_JavaUtilHashMap.put(localPrecoverResource.businessId, localObject1);
              this.b.put(a(localPrecoverResource), localPrecoverResource);
            }
          }
        }
      }
      if (localObject5 == null) {
        break label315;
      }
    }
    finally {}
    if (((List)localObject5).size() > 0)
    {
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (PrecoverResource)((Iterator)localObject5).next();
        if (((PrecoverResource)localObject6).isValid())
        {
          localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(((PrecoverResource)localObject6).businessId);
          Object localObject4 = localList;
          if (localList == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(localObject6);
          this.jdField_a_of_type_JavaUtilHashMap.put(((PrecoverResource)localObject6).businessId, localObject4);
          this.b.put(a((PrecoverResource)localObject6), localObject6);
        }
      }
    }
    label315:
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "isNetworkCanDown");
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl.a;
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "isNetworkCanDown, return true, param == 2");
      }
      return true;
    }
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    boolean bool;
    if (i == 0) {
      if (j == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "isNetworkCanDown, param=", Integer.valueOf(i), ", netType=", Integer.valueOf(j), ", result=", Boolean.valueOf(bool) });
      }
      return bool;
      bool = false;
      continue;
      if (i == 1)
      {
        if ((j == 1) || (j == 4) || (j == 3)) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else if (i == 3)
      {
        if ((j == 1) || (j == 4)) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl.a;
    }
    return 0;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public PrecoverResource a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    return (PrecoverResource)this.b.get(paramString1 + "_" + paramString2);
  }
  
  public PrecoverControl a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl;
  }
  
  public PrecoverReporter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter;
  }
  
  public PrecoverResDownloader a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader;
  }
  
  protected HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  protected List a(String paramString, String[] paramArrayOfString, Class paramClass)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramString != null) {
        break label110;
      }
      str = "null";
      if (paramArrayOfString != null) {
        break label116;
      }
    }
    label110:
    label116:
    for (Object localObject = "null";; localObject = paramArrayOfString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "queryAll, selction=", str, ", selectionArgs=", localObject, ", clz=", paramClass.getSimpleName() });
      if ((paramClass == PrecoverResource.class) || (paramClass == PrecoverResourceBusiness.class) || (paramClass == PrecoverRetryInfo.class) || (paramClass == PrecoverConfig.class)) {
        break label122;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "queryAll, clz not valid");
      }
      return null;
      str = paramString;
      break;
    }
    try
    {
      label122:
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramClass, false, paramString, paramArrayOfString, null, null, null, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "queryAll, exception=", paramString.getMessage() });
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      a(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString, PrecoverResource paramPrecoverResource, Object paramObject)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilHashSet == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "onDownloadFinish, needReport, mReportSet.size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashSet.size()), ", res=", paramPrecoverResource });
      }
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramPrecoverResource);
    } while (this.jdField_a_of_type_JavaUtilHashSet.size() != 0);
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "onDownloadFinish, download finish, doing report");
    }
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader.b(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = null;
    ThreadManager.post(new agnd(this), 5, null, false);
  }
  
  protected void a(PrecoverResource paramPrecoverResource)
  {
    if (paramPrecoverResource == null) {}
    PrecoverRetryInfo localPrecoverRetryInfo;
    do
    {
      return;
      localPrecoverRetryInfo = a(paramPrecoverResource);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "deleteRertyInfo, info=" + localPrecoverRetryInfo);
      }
    } while (localPrecoverRetryInfo == null);
    paramPrecoverResource = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      paramPrecoverResource.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPrecoverRetryInfo);
      paramPrecoverResource.c();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "deleteRertyInfo, exception=", localException.getMessage() });
        localException.printStackTrace();
      }
      return;
    }
    finally
    {
      paramPrecoverResource.b();
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, Object paramObject, long paramLong1, long paramLong2) {}
  
  protected void a(String paramString)
  {
    if (paramString == null) {}
    for (String str = "null";; str = paramString)
    {
      QLog.d("PrecoverManager", 1, new Object[] { "startDownload, businessId=", str });
      ThreadManager.post(new agnc(this, paramString), 5, null, false);
      return;
    }
  }
  
  public void a(List arg1)
  {
    Object localObject1;
    if (??? == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Object localObject3;
      Object localObject5;
      try
      {
        QLog.d("PrecoverManager", 1, new Object[] { "onHandleConfigs, configList.size=", localObject1 });
        if ((??? == null) || (???.size() == 0))
        {
          a(PrecoverConfig.class);
          a(PrecoverResource.class);
          return;
          localObject1 = Integer.valueOf(???.size());
          continue;
        }
        a(PrecoverConfig.class);
        localObject3 = new HashMap();
        localObject1 = new HashMap();
        ??? = ???.iterator();
        Object localObject4;
        if (???.hasNext())
        {
          localObject4 = (Pair)???.next();
          if ((localObject4 == null) || (TextUtils.isEmpty((CharSequence)((Pair)localObject4).second))) {
            continue;
          }
          int i = ((Integer)((Pair)localObject4).first).intValue();
          localObject5 = PrecoverUtils.a((String)((Pair)localObject4).second);
          if ((localObject5 == null) || (((Pair)localObject5).first == null) || (((Pair)localObject5).second == null)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, new Object[] { "onHandleConfigs, businessid=", ((PrecoverBusinessInfo)((Pair)localObject5).first).a, ", name=", ((PrecoverBusinessInfo)((Pair)localObject5).first).b, ", list.size=", Integer.valueOf(((List)((Pair)localObject5).second).size()) });
          }
          if (TextUtils.isEmpty(((PrecoverBusinessInfo)((Pair)localObject5).first).a)) {
            continue;
          }
          String str = ((PrecoverBusinessInfo)((Pair)localObject5).first).a;
          if ((((HashMap)localObject3).containsKey(str)) && (((Integer)((HashMap)localObject3).get(str)).intValue() >= i)) {
            continue;
          }
          ((HashMap)localObject3).put(str, Integer.valueOf(i));
          ((HashMap)localObject1).put(str, ((Pair)localObject5).second);
          a(new PrecoverConfig(str, (String)((Pair)localObject4).second, i));
          continue;
        }
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          a(PrecoverResource.class);
          localObject3 = ((HashMap)localObject1).keySet().iterator();
          do
          {
            while (!((Iterator)localObject4).hasNext())
            {
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = (List)((HashMap)localObject1).get((String)((Iterator)localObject3).next());
              } while ((localObject4 == null) || (((List)localObject4).size() <= 0));
              localObject4 = ((List)localObject4).iterator();
            }
            localObject5 = (PrecoverResource)((Iterator)localObject4).next();
            if (!((PrecoverResource)localObject5).isValid()) {
              break;
            }
            a((Entity)localObject5);
          } while (!QLog.isColorLevel());
          QLog.d("PrecoverManager", 2, "onHandleConfigs, insert res:" + localObject5);
        }
      }
      finally {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "onHandleConfigs, res invalid:" + localObject5);
        }
      }
      ??? = new StringBuilder();
      if (localObject2.size() > 0)
      {
        ???.append(" WHERE businessId NOT IN (");
        Iterator localIterator = localObject2.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          ???.append("'").append((String)localObject3).append("',");
        }
        ???.setCharAt(???.length() - 1, ')');
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "onHandleConfigs, selection of sql=" + ???.toString());
      }
      a("DELETE FROM " + PrecoverResourceBusiness.class.getSimpleName() + ???.toString());
      a("DELETE FROM " + PrecoverRetryInfo.class.getSimpleName() + ???.toString());
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_config_cover");
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "checkReportConfigCover, succ=", Boolean.valueOf(paramBoolean), ", need=", Boolean.valueOf(bool) });
    }
    if (bool)
    {
      PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_config_cover");
      this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "get_config_time");
    int j = PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", 0);
    if (bool)
    {
      PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "get_config_time");
      PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", 1);
      return true;
    }
    if (a() != null) {}
    for (int i = a().f; j >= i; i = 5) {
      return false;
    }
    PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", j + 1);
    return true;
  }
  
  protected boolean a(PrecoverResource paramPrecoverResource)
  {
    if ((paramPrecoverResource == null) || (!paramPrecoverResource.isValid())) {}
    do
    {
      PrecoverRetryInfo localPrecoverRetryInfo;
      long l;
      do
      {
        do
        {
          return false;
          if (b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("PrecoverManager", 2, "canDownload, networkRight, return false");
        return false;
        localPrecoverRetryInfo = a(paramPrecoverResource);
        l = System.currentTimeMillis();
        if (localPrecoverRetryInfo == null)
        {
          localPrecoverRetryInfo = new PrecoverRetryInfo();
          localPrecoverRetryInfo.businessId = paramPrecoverResource.businessId;
          localPrecoverRetryInfo.md5 = paramPrecoverResource.md5;
          localPrecoverRetryInfo.itemRetryCount = 1;
          localPrecoverRetryInfo.totalRetryCount = 1;
          localPrecoverRetryInfo.retryUpdateTime = l;
          a(localPrecoverRetryInfo);
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, "canDownload, info == null, return true");
          }
          return true;
        }
        if (localPrecoverRetryInfo.totalRetryCount <= this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl.c) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PrecoverManager", 2, "canDownload, info.totalRetryCount > mControl.totalRetry, return false");
      return false;
      if (Math.abs(l - localPrecoverRetryInfo.retryUpdateTime) > 86400000L)
      {
        localPrecoverRetryInfo.itemRetryCount = 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, daily count expire, return true");
        }
        return true;
      }
      if (localPrecoverRetryInfo.itemRetryCount < this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl.b)
      {
        localPrecoverRetryInfo.itemRetryCount += 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, info.itemRetryCount < mControl.itemRetry, return true");
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PrecoverManager", 2, "canDownload, return false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      if (paramString != null) {
        break label64;
      }
    }
    for (localObject = "null";; localObject = paramString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "execSql, businessId=", localObject });
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        ((EntityTransaction)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
        ((EntityTransaction)localObject).c();
        return true;
      }
      catch (Exception paramString)
      {
        label64:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PrecoverManager", 2, new Object[] { "execSql, exception=", paramString.getMessage() });
        paramString.printStackTrace();
        return false;
      }
      finally
      {
        ((EntityTransaction)localObject).b();
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverManager
 * JD-Core Version:    0.7.0.1
 */