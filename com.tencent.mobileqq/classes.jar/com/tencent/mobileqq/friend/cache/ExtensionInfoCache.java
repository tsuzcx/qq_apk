package com.tencent.mobileqq.friend.cache;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ExtensionInfoCache
  implements ICache<String, ExtensionInfo>
{
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, ExtensionInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public ExtensionInfoCache(AppRuntime paramAppRuntime, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public ExtensionInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ExtensionInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List<ExtensionInfo> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.d("IMCore.friend.ExtensionInfoCache", 1, "init extension info| had init!");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      long l1 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.ExtensionInfoCache", 2, "initExtensionCache begin");
      }
      Object localObject7 = FriendDataServiceImpl.getService(this.jdField_a_of_type_MqqAppAppRuntime).getAllFriends();
      Object localObject1 = null;
      if (localObject7 != null)
      {
        Object localObject6;
        if (((List)localObject7).size() < 100)
        {
          localObject4 = new StringBuilder(((List)localObject7).size() * 20);
          localObject6 = new ArrayList(((List)localObject7).size());
          localObject1 = ((List)localObject7).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject7 = (Friends)((Iterator)localObject1).next();
            if (((Friends)localObject7).isFriend())
            {
              ((StringBuilder)localObject4).append("uin=? or ");
              ((List)localObject6).add(((Friends)localObject7).uin);
            }
          }
          localObject1 = localObject4;
          if (((StringBuilder)localObject4).length() > 4) {
            localObject1 = ((StringBuilder)localObject4).delete(((StringBuilder)localObject4).length() - 4, ((StringBuilder)localObject4).length());
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ExtensionInfo.class, true, ((StringBuilder)localObject1).toString(), (String[])((List)localObject6).toArray(new String[((List)localObject6).size()]), null, null, null, null);
        }
        Object localObject4 = localObject1;
        if (localObject1 == null) {
          try
          {
            localObject4 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ExtensionInfo.class);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localObject4 = new ArrayList(0);
            QLog.e("IMCore.friend.ExtensionInfoCache", 1, "initExtensionInfoCache error OOM", localOutOfMemoryError);
          }
        }
        if (localObject4 != null) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject6 = (ExtensionInfo)((Iterator)localObject4).next();
              if (!TextUtils.isEmpty(((ExtensionInfo)localObject6).uin)) {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ExtensionInfo)localObject6).uin, localObject6);
              } else {
                QLog.e("IMCore.friend.ExtensionInfoCache", 1, "initExtensionCache| uin is null");
              }
            }
          }
        }
      }
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("initExtensionCache, size: ");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        ((StringBuilder)???).append(", cost: ");
        ((StringBuilder)???).append(l2 - l1);
        QLog.d("IMCore.friend.ExtensionInfoCache", 2, ((StringBuilder)???).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramExtensionInfo.uin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramExtensionInfo.uin, paramExtensionInfo);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(ExtensionInfo paramExtensionInfo)
  {
    boolean bool = false;
    if (paramExtensionInfo == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveToDB begin| friendUin: ");
      localStringBuilder.append(paramExtensionInfo.uin);
      QLog.d("IMCore.friend.ExtensionInfoCache", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())
    {
      if (paramExtensionInfo.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramExtensionInfo);
        if (paramExtensionInfo.getStatus() == 1001) {
          bool = true;
        }
      }
      else if ((paramExtensionInfo.getStatus() == 1001) || (paramExtensionInfo.getStatus() == 1002))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramExtensionInfo);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveToDB| em closed uin = ");
      localStringBuilder.append(paramExtensionInfo.uin);
      QLog.d("IMCore.friend.ExtensionInfoCache", 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveToDB begin| friendUin: ");
      localStringBuilder.append(paramExtensionInfo.uin);
      localStringBuilder.append(", isSuccess: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", cost: ");
      localStringBuilder.append(l2 - l1);
      QLog.d("IMCore.friend.ExtensionInfoCache", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  /* Error */
  public boolean a(List<ExtensionInfo> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull +218 -> 221
    //   6: aload_1
    //   7: invokeinterface 101 1 0
    //   12: ifne +6 -> 18
    //   15: goto +206 -> 221
    //   18: invokestatic 202	java/lang/System:currentTimeMillis	()J
    //   21: lstore 4
    //   23: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 64
    //   31: iconst_2
    //   32: ldc 230
    //   34: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 34	com/tencent/mobileqq/friend/cache/ExtensionInfoCache:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   44: astore 8
    //   46: aload 8
    //   48: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   51: aload_1
    //   52: invokeinterface 109 1 0
    //   57: astore 9
    //   59: iconst_1
    //   60: istore_2
    //   61: aload 9
    //   63: invokeinterface 114 1 0
    //   68: ifeq +23 -> 91
    //   71: iload_2
    //   72: aload_0
    //   73: aload 9
    //   75: invokeinterface 118 1 0
    //   80: checkcast 48	com/tencent/mobileqq/data/ExtensionInfo
    //   83: invokevirtual 241	com/tencent/mobileqq/friend/cache/ExtensionInfoCache:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)Z
    //   86: iand
    //   87: istore_2
    //   88: goto -27 -> 61
    //   91: aload 8
    //   93: invokevirtual 244	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   96: aload 8
    //   98: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   101: goto +26 -> 127
    //   104: astore_1
    //   105: goto +109 -> 214
    //   108: astore 9
    //   110: ldc 64
    //   112: iconst_1
    //   113: ldc 249
    //   115: aload 9
    //   117: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload 8
    //   122: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   125: iload_3
    //   126: istore_2
    //   127: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +82 -> 212
    //   133: invokestatic 202	java/lang/System:currentTimeMillis	()J
    //   136: lstore 6
    //   138: new 103	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   145: astore 8
    //   147: aload 8
    //   149: ldc 251
    //   151: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 8
    //   157: aload_1
    //   158: invokeinterface 101 1 0
    //   163: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 8
    //   169: ldc 222
    //   171: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 8
    //   177: iload_2
    //   178: invokevirtual 225	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 8
    //   184: ldc 253
    //   186: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 8
    //   192: lload 6
    //   194: lload 4
    //   196: lsub
    //   197: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 64
    //   203: iconst_2
    //   204: aload 8
    //   206: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: iload_2
    //   213: ireturn
    //   214: aload 8
    //   216: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   219: aload_1
    //   220: athrow
    //   221: ldc 64
    //   223: iconst_1
    //   224: ldc 255
    //   226: invokestatic 183	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iconst_0
    //   230: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	ExtensionInfoCache
    //   0	231	1	paramList	List<ExtensionInfo>
    //   60	153	2	bool1	boolean
    //   1	125	3	bool2	boolean
    //   21	174	4	l1	long
    //   136	57	6	l2	long
    //   44	171	8	localObject	Object
    //   57	17	9	localIterator	Iterator
    //   108	8	9	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   51	59	104	finally
    //   61	88	104	finally
    //   91	96	104	finally
    //   110	120	104	finally
    //   51	59	108	java/lang/Exception
    //   61	88	108	java/lang/Exception
    //   91	96	108	java/lang/Exception
  }
  
  public ExtensionInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExtensionInfo.class, paramString);
    a(localExtensionInfo);
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryFromDB end | friendUin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", cost: ");
      localStringBuilder.append(l2 - l1);
      QLog.d("IMCore.friend.ExtensionInfoCache", 2, localStringBuilder.toString());
    }
    return localExtensionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.cache.ExtensionInfoCache
 * JD-Core Version:    0.7.0.1
 */