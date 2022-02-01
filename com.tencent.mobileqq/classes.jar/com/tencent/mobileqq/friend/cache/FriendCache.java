package com.tencent.mobileqq.friend.cache;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.utils.FriendSorter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FriendCache
  implements ICache<String, Friends>
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap<String, Friends> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public FriendCache(EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public int a(boolean paramBoolean)
  {
    c();
    int k = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    int j = 0;
    int i = 0;
    Object localObject;
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (((Friends)((Iterator)localObject).next()).gathtertype == 1) {
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFriendCount| includeGather: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" friendCount: ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", gatherCount: ");
      ((StringBuilder)localObject).append(j);
      QLog.d("IMCore.friend.FriendCache", 2, ((StringBuilder)localObject).toString());
    }
    return k - j;
  }
  
  public Friends a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (Friends)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public List<Friends> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
  }
  
  public List<Friends> a(Integer paramInteger)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((Iterator)localObject).next();
      if (localFriends.groupid == paramInteger.intValue()) {
        localArrayList.add(localFriends);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGroupFriendList| groupId: ");
      ((StringBuilder)localObject).append(paramInteger);
      ((StringBuilder)localObject).append(", size: ");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("IMCore.friend.FriendCache", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public List<Friends> a(List<String> paramList)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendCache", 2, "preload begin");
    }
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    Object localObject1 = null;
    Object localObject2;
    if (i > 0)
    {
      localObject1 = new StringBuilder("uin=? ");
      int j = 1;
      while (j < paramList.size())
      {
        ((StringBuilder)localObject1).append("or uin=? ");
        j += 1;
      }
      localObject2 = (String[])paramList.toArray(new String[i]);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Friends.class, true, ((StringBuilder)localObject1).toString(), (String[])localObject2, null, null, null, null);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        Iterator localIterator = ((List)localObject2).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          a((Friends)localIterator.next());
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preload: ");
      ((StringBuilder)localObject2).append(paramList);
      ((StringBuilder)localObject2).append(", cost: ");
      ((StringBuilder)localObject2).append(l2 - l1);
      QLog.d("IMCore.friend.FriendCache", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache| had init!");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      long l1 = SystemClock.elapsedRealtime();
      QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache begin");
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      int i = 0;
      Object localObject3 = (ArrayList)((EntityManager)localObject1).query(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
      if (localObject3 != null) {
        i = ((List)localObject3).size();
      }
      localObject1 = new ArrayList();
      if (i > 0)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject3).next();
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
          {
            FriendSorter.a(localFriends);
            ((List)localObject1).add(localFriends);
          }
          a(localFriends);
        }
      }
      this.jdField_a_of_type_Boolean = true;
      long l2 = SystemClock.elapsedRealtime();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initFriendCache finish| friendCount: ");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(", cost: ");
      ((StringBuilder)localObject3).append(l2 - l1);
      QLog.d("IMCore.friend.FriendCache", 1, ((StringBuilder)localObject3).toString());
      if (((List)localObject1).size() > 0) {
        this.jdField_a_of_type_AndroidOsHandler.post(new FriendCache.1(this, (List)localObject1));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(Friends paramFriends)
  {
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.uin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Friends paramFriends)
  {
    boolean bool = false;
    if (paramFriends == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())
    {
      if (paramFriends.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramFriends);
        if (paramFriends.getStatus() == 1001) {
          bool = true;
        }
      }
      else if ((paramFriends.getStatus() == 1001) || (paramFriends.getStatus() == 1002))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramFriends);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveToDB| em closed uin = ");
      localStringBuilder.append(paramFriends.uin);
      QLog.d("IMCore.friend.FriendCache", 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveToDB| friend: ");
      localStringBuilder.append(paramFriends.uin);
      localStringBuilder.append(", isSuccess: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", cost: ");
      localStringBuilder.append(l2 - l1);
      QLog.d("IMCore.friend.FriendCache", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  /* Error */
  public boolean a(List<Friends> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull +222 -> 225
    //   6: aload_1
    //   7: invokeinterface 157 1 0
    //   12: ifne +6 -> 18
    //   15: goto +210 -> 225
    //   18: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   21: lstore 4
    //   23: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +12 -> 38
    //   29: ldc 105
    //   31: iconst_2
    //   32: ldc_w 267
    //   35: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: getfield 29	com/tencent/mobileqq/friend/cache/FriendCache:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: invokevirtual 271	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   45: astore 8
    //   47: aload 8
    //   49: invokevirtual 276	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   52: aload_1
    //   53: invokeinterface 189 1 0
    //   58: astore 9
    //   60: iconst_1
    //   61: istore_2
    //   62: aload 9
    //   64: invokeinterface 69 1 0
    //   69: ifeq +23 -> 92
    //   72: iload_2
    //   73: aload_0
    //   74: aload 9
    //   76: invokeinterface 73 1 0
    //   81: checkcast 75	com/tencent/mobileqq/data/Friends
    //   84: invokevirtual 278	com/tencent/mobileqq/friend/cache/FriendCache:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   87: iand
    //   88: istore_2
    //   89: goto -27 -> 62
    //   92: aload 8
    //   94: invokevirtual 281	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   97: aload 8
    //   99: invokevirtual 284	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   102: goto +27 -> 129
    //   105: astore_1
    //   106: goto +112 -> 218
    //   109: astore 9
    //   111: ldc 105
    //   113: iconst_1
    //   114: ldc_w 286
    //   117: aload 9
    //   119: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload 8
    //   124: invokevirtual 284	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   127: iload_3
    //   128: istore_2
    //   129: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   132: lstore 6
    //   134: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +79 -> 216
    //   140: new 86	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   147: astore 8
    //   149: aload 8
    //   151: ldc_w 292
    //   154: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 8
    //   160: aload_1
    //   161: invokeinterface 157 1 0
    //   166: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 8
    //   172: ldc 196
    //   174: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 8
    //   180: lload 6
    //   182: lload 4
    //   184: lsub
    //   185: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 8
    //   191: ldc_w 262
    //   194: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 8
    //   200: iload_2
    //   201: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 105
    //   207: iconst_2
    //   208: aload 8
    //   210: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: iload_2
    //   217: ireturn
    //   218: aload 8
    //   220: invokevirtual 284	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   223: aload_1
    //   224: athrow
    //   225: ldc 105
    //   227: iconst_1
    //   228: ldc_w 294
    //   231: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iconst_0
    //   235: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	FriendCache
    //   0	236	1	paramList	List<Friends>
    //   61	156	2	bool1	boolean
    //   1	127	3	bool2	boolean
    //   21	162	4	l1	long
    //   132	49	6	l2	long
    //   45	174	8	localObject	Object
    //   58	17	9	localIterator	Iterator
    //   109	9	9	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	60	105	finally
    //   62	89	105	finally
    //   92	97	105	finally
    //   111	122	105	finally
    //   52	60	109	java/lang/Exception
    //   62	89	109	java/lang/Exception
    //   92	97	109	java/lang/Exception
  }
  
  public Friends b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (Friends)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    QLog.d("IMCore.friend.FriendCache", 1, "destroy");
  }
  
  public Friends c(String paramString)
  {
    Friends localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Friends.class, paramString);
    if (localFriends != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localFriends);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFromDB| friendUin: ");
      localStringBuilder.append(paramString);
      QLog.d("IMCore.friend.FriendCache", 2, localStringBuilder.toString());
    }
    return localFriends;
  }
  
  public Friends d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Friends localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Friends.class, paramString);
    a(localFriends);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryFromDB end | friendUin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", friend: ");
      localStringBuilder.append(localFriends);
      QLog.d("IMCore.friend.FriendCache", 2, localStringBuilder.toString());
    }
    return localFriends;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.cache.FriendCache
 * JD-Core Version:    0.7.0.1
 */