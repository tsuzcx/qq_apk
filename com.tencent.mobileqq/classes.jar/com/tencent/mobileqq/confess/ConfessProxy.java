package com.tencent.mobileqq.confess;

import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConfessProxy
  extends BaseProxy
{
  private QQConcurrentHashMap jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap = new QQConcurrentHashMap(1005, 0, 100);
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public ConfessProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  /* Error */
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 55	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +33 -> 43
    //   13: aload_0
    //   14: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 59	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +22 -> 43
    //   24: aload_0
    //   25: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 63	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 65	com/tencent/mobileqq/confess/ConfessConvInfo
    //   35: getfield 69	com/tencent/mobileqq/confess/ConfessConvInfo:unreadCount	I
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_2
    //   45: goto -6 -> 39
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	ConfessProxy
    //   0	53	1	paramString	String
    //   0	53	2	paramInt1	int
    //   0	53	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	9	48	finally
    //   13	39	48	finally
  }
  
  /* Error */
  public long a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 55	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +35 -> 45
    //   13: aload_0
    //   14: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 59	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +24 -> 45
    //   24: aload_0
    //   25: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 63	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 65	com/tencent/mobileqq/confess/ConfessConvInfo
    //   35: getfield 74	com/tencent/mobileqq/confess/ConfessConvInfo:lastread	J
    //   38: lstore 4
    //   40: aload_0
    //   41: monitorexit
    //   42: lload 4
    //   44: lreturn
    //   45: lconst_0
    //   46: lstore 4
    //   48: goto -8 -> 40
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ConfessProxy
    //   0	56	1	paramString	String
    //   0	56	2	paramInt1	int
    //   0	56	3	paramInt2	int
    //   38	9	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	9	51	finally
    //   13	40	51	finally
  }
  
  /* Error */
  public ConfessConvInfo a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 55	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +30 -> 40
    //   13: aload_0
    //   14: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 59	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +19 -> 40
    //   24: aload_0
    //   25: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 63	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 65	com/tencent/mobileqq/confess/ConfessConvInfo
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aconst_null
    //   41: astore_1
    //   42: goto -6 -> 36
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ConfessProxy
    //   0	50	1	paramString	String
    //   0	50	2	paramInt1	int
    //   0	50	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	9	45	finally
    //   13	36	45	finally
  }
  
  public Set a()
  {
    try
    {
      HashSet localHashSet1 = new HashSet(this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values());
      return localHashSet1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.confess.unread.ConfessProxy", 2, "cloneConfessConvInfoSet OOM!", localOutOfMemoryError);
        }
        HashSet localHashSet2 = new HashSet();
      }
    }
    finally {}
  }
  
  protected void a() {}
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: iload_3
    //   5: invokestatic 55	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   8: astore 5
    //   10: aload_0
    //   11: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   14: aload 5
    //   16: invokevirtual 59	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   19: ifeq +52 -> 71
    //   22: aload_0
    //   23: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   26: aload 5
    //   28: invokevirtual 63	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: ifnull +40 -> 71
    //   34: aload_0
    //   35: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   38: aload 5
    //   40: invokevirtual 63	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 65	com/tencent/mobileqq/confess/ConfessConvInfo
    //   46: astore 5
    //   48: aload_0
    //   49: aload_1
    //   50: iload_2
    //   51: iload_3
    //   52: aload 5
    //   54: getfield 74	com/tencent/mobileqq/confess/ConfessConvInfo:lastread	J
    //   57: aload 5
    //   59: getfield 69	com/tencent/mobileqq/confess/ConfessConvInfo:unreadCount	I
    //   62: iload 4
    //   64: iadd
    //   65: invokevirtual 105	com/tencent/mobileqq/confess/ConfessProxy:a	(Ljava/lang/String;IIJI)V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: aload_0
    //   72: aload_1
    //   73: iload_2
    //   74: iload_3
    //   75: lconst_0
    //   76: iload 4
    //   78: invokevirtual 105	com/tencent/mobileqq/confess/ConfessProxy:a	(Ljava/lang/String;IIJI)V
    //   81: goto -13 -> 68
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ConfessProxy
    //   0	89	1	paramString	String
    //   0	89	2	paramInt1	int
    //   0	89	3	paramInt2	int
    //   0	89	4	paramInt3	int
    //   8	50	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	68	84	finally
    //   71	81	84	finally
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = ConfessMsgUtil.a(paramString, paramInt1, paramInt2);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if ((((ConfessConvInfo)localObject).lastread != paramLong) || (((ConfessConvInfo)localObject).unreadCount != paramInt3))
          {
            ((ConfessConvInfo)localObject).lastread = paramLong;
            ((ConfessConvInfo)localObject).unreadCount = Math.max(0, paramInt3);
            QLog.d("Q.confess.unread.ConfessProxy", 1, "insertOrUpdateUnread update=" + localObject.toString());
            a(paramString, paramInt1, (ConfessConvInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.confess.unread.ConfessProxy", 2, "insertOrUpdateUnread nochange=" + localObject.toString());
          continue;
        }
        localConfessConvInfo = new ConfessConvInfo(paramString, paramInt1, paramInt2, paramLong, Math.max(0, paramInt3));
      }
      finally {}
      ConfessConvInfo localConfessConvInfo;
      QLog.d("Q.confess.unread.ConfessProxy", 1, "insertOrUpdateUnread insert=" + localConfessConvInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConfessConvInfo);
      b(paramString, paramInt1, localConfessConvInfo);
    }
  }
  
  protected void a(String paramString, int paramInt, ConfessConvInfo paramConfessConvInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConfessConvInfo.getConversationInfoTableName(), paramConfessConvInfo, 4, null);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
  
  protected void b(String paramString, int paramInt, ConfessConvInfo paramConfessConvInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConfessConvInfo.getConversationInfoTableName(), paramConfessConvInfo, 3, null);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   6: invokevirtual 159	com/tencent/commonsdk/cache/QQConcurrentHashMap:clear	()V
    //   9: aload_0
    //   10: invokespecial 166	com/tencent/mobileqq/confess/ConfessProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: ldc 65
    //   15: invokestatic 151	com/tencent/mobileqq/confess/ConfessConvInfo:getConversationInfoTableName	()Ljava/lang/String;
    //   18: iconst_0
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 169	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;)Ljava/util/List;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +4 -> 35
    //   34: return
    //   35: iload_2
    //   36: istore_1
    //   37: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +35 -> 75
    //   43: ldc 94
    //   45: iconst_2
    //   46: new 113	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   53: ldc 171
    //   55: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokeinterface 177 1 0
    //   64: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: iload_2
    //   74: istore_1
    //   75: iload_1
    //   76: aload_3
    //   77: invokeinterface 177 1 0
    //   82: if_icmpge -48 -> 34
    //   85: aload_0
    //   86: getfield 28	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   89: aload_3
    //   90: iload_1
    //   91: invokeinterface 183 2 0
    //   96: checkcast 65	com/tencent/mobileqq/confess/ConfessConvInfo
    //   99: getfield 187	com/tencent/mobileqq/confess/ConfessConvInfo:uin	Ljava/lang/String;
    //   102: aload_3
    //   103: iload_1
    //   104: invokeinterface 183 2 0
    //   109: checkcast 65	com/tencent/mobileqq/confess/ConfessConvInfo
    //   112: getfield 190	com/tencent/mobileqq/confess/ConfessConvInfo:type	I
    //   115: aload_3
    //   116: iload_1
    //   117: invokeinterface 183 2 0
    //   122: checkcast 65	com/tencent/mobileqq/confess/ConfessConvInfo
    //   125: getfield 193	com/tencent/mobileqq/confess/ConfessConvInfo:topicId	I
    //   128: invokestatic 55	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   131: aload_3
    //   132: iload_1
    //   133: invokeinterface 183 2 0
    //   138: invokevirtual 142	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: pop
    //   142: iload_1
    //   143: iconst_1
    //   144: iadd
    //   145: istore_1
    //   146: goto -71 -> 75
    //   149: astore_3
    //   150: aload_3
    //   151: athrow
    //   152: astore_3
    //   153: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	ConfessProxy
    //   36	110	1	i	int
    //   1	73	2	j	int
    //   29	103	3	localList	java.util.List
    //   149	2	3	localObject	Object
    //   152	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   75	142	149	finally
    //   75	142	152	java/lang/Exception
  }
  
  public void d()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          ConfessConvInfo localConfessConvInfo = (ConfessConvInfo)localIterator.next();
          if (localConfessConvInfo.unreadCount > 0)
          {
            localConfessConvInfo.unreadCount = 0;
            a(localConfessConvInfo.uin, localConfessConvInfo.type, localConfessConvInfo);
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessProxy
 * JD-Core Version:    0.7.0.1
 */