package com.tencent.mobileqq.friend.cache;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.callback.GetGroupListCallback;
import com.tencent.mobileqq.friend.utils.FriendSorter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class GroupCache
  implements ICache<Integer, Groups>
{
  private EntityManager a;
  private volatile boolean b = false;
  private final Object c = new Object();
  private LinkedList<Groups> d = new LinkedList();
  private ConcurrentHashMap<Integer, Groups> e = new ConcurrentHashMap(16);
  
  public GroupCache(EntityManager paramEntityManager)
  {
    this.a = paramEntityManager;
  }
  
  private void d()
  {
    if (!this.b) {
      a();
    }
  }
  
  public Groups a(Integer paramInteger)
  {
    synchronized (this.c)
    {
      Groups localGroups = (Groups)this.e.remove(paramInteger);
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        if (((Groups)localIterator.next()).group_id == paramInteger.intValue()) {
          localIterator.remove();
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("removeFromCache| groupId: ");
        ((StringBuilder)???).append(paramInteger);
        ((StringBuilder)???).append(", group: ");
        ((StringBuilder)???).append(localGroups);
        QLog.d("IMCore.friend.GroupCache", 2, ((StringBuilder)???).toString());
      }
      return localGroups;
    }
    for (;;)
    {
      throw paramInteger;
    }
  }
  
  public List<Groups> a(GetGroupListCallback paramGetGroupListCallback)
  {
    if (this.b) {
      return new ArrayList(this.d);
    }
    ThreadManager.getSubThreadHandler().post(new GroupCache.1(this, paramGetGroupListCallback));
    return null;
  }
  
  public void a()
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        return;
      }
      long l1 = SystemClock.elapsedRealtime();
      this.b = true;
      List localList = this.a.query(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null);
      if ((localList != null) && (!localList.isEmpty())) {
        synchronized (this.c)
        {
          this.e.clear();
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            Groups localGroups = (Groups)localIterator.next();
            this.e.put(Integer.valueOf(localGroups.group_id), localGroups);
          }
          this.d.clear();
          this.d.addAll(localList);
        }
      }
      QLog.d("IMCore.friend.GroupCache", 1, "init| groupList is empty!");
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("init| group size: ");
        ((StringBuilder)???).append(this.d.size());
        ((StringBuilder)???).append(", cost: ");
        ((StringBuilder)???).append(l2 - l1);
        QLog.d("IMCore.friend.GroupCache", 2, ((StringBuilder)???).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(Groups paramGroups)
  {
    if (paramGroups == null) {
      return;
    }
    synchronized (this.c)
    {
      this.e.put(Integer.valueOf(paramGroups.group_id), paramGroups);
      int j = 0;
      Iterator localIterator = this.d.iterator();
      Groups localGroups;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localGroups = (Groups)localIterator.next();
      } while (localGroups.group_id != paramGroups.group_id);
      int i = 1;
      localGroups.group_name = paramGroups.group_name;
      localGroups.group_friend_count = paramGroups.group_friend_count;
      if (i == 0) {
        this.d = FriendSorter.a(this.d, paramGroups);
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("saveToCache| groupId: ");
        ((StringBuilder)???).append(paramGroups.group_id);
        QLog.d("IMCore.friend.GroupCache", 2, ((StringBuilder)???).toString());
      }
      return;
    }
    for (;;)
    {
      throw paramGroups;
    }
  }
  
  /* Error */
  public boolean a(List<Groups> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull +281 -> 284
    //   6: aload_1
    //   7: invokeinterface 211 1 0
    //   12: ifne +6 -> 18
    //   15: goto +269 -> 284
    //   18: new 113	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 212	java/util/ArrayList:<init>	()V
    //   25: astore 5
    //   27: aload_0
    //   28: getfield 42	com/tencent/mobileqq/friend/cache/GroupCache:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: invokevirtual 216	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 221	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   41: aload_1
    //   42: invokeinterface 164 1 0
    //   47: astore 6
    //   49: iconst_1
    //   50: istore_2
    //   51: aload 6
    //   53: invokeinterface 66 1 0
    //   58: ifeq +43 -> 101
    //   61: aload 6
    //   63: invokeinterface 70 1 0
    //   68: checkcast 56	com/tencent/mobileqq/data/Groups
    //   71: astore 7
    //   73: iload_2
    //   74: aload_0
    //   75: aload 7
    //   77: invokevirtual 224	com/tencent/mobileqq/friend/cache/GroupCache:b	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   80: iand
    //   81: istore_2
    //   82: aload 5
    //   84: aload 7
    //   86: getfield 74	com/tencent/mobileqq/data/Groups:group_id	I
    //   89: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: invokeinterface 228 2 0
    //   97: pop
    //   98: goto -47 -> 51
    //   101: new 113	java/util/ArrayList
    //   104: dup
    //   105: aload_0
    //   106: getfield 40	com/tencent/mobileqq/friend/cache/GroupCache:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   109: invokevirtual 232	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   112: invokespecial 116	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   115: invokeinterface 164 1 0
    //   120: astore 6
    //   122: aload 6
    //   124: invokeinterface 66 1 0
    //   129: ifeq +49 -> 178
    //   132: aload 6
    //   134: invokeinterface 70 1 0
    //   139: checkcast 56	com/tencent/mobileqq/data/Groups
    //   142: astore 7
    //   144: aload 5
    //   146: aload 7
    //   148: getfield 74	com/tencent/mobileqq/data/Groups:group_id	I
    //   151: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: invokeinterface 235 2 0
    //   159: ifne -37 -> 122
    //   162: aload_0
    //   163: aload 7
    //   165: getfield 74	com/tencent/mobileqq/data/Groups:group_id	I
    //   168: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokevirtual 237	com/tencent/mobileqq/friend/cache/GroupCache:c	(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/Groups;
    //   174: pop
    //   175: goto -53 -> 122
    //   178: aload 4
    //   180: invokevirtual 240	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   183: aload 4
    //   185: invokevirtual 243	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   188: goto +26 -> 214
    //   191: astore_1
    //   192: goto +85 -> 277
    //   195: astore 5
    //   197: ldc 103
    //   199: iconst_1
    //   200: ldc 245
    //   202: aload 5
    //   204: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload 4
    //   209: invokevirtual 243	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   212: iload_3
    //   213: istore_2
    //   214: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +58 -> 275
    //   220: new 89	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   227: astore 4
    //   229: aload 4
    //   231: ldc 250
    //   233: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 4
    //   239: aload_1
    //   240: invokeinterface 211 1 0
    //   245: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 4
    //   251: ldc 252
    //   253: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 4
    //   259: iload_2
    //   260: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 103
    //   266: iconst_2
    //   267: aload 4
    //   269: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: iload_2
    //   276: ireturn
    //   277: aload 4
    //   279: invokevirtual 243	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   282: aload_1
    //   283: athrow
    //   284: ldc 103
    //   286: iconst_1
    //   287: ldc_w 257
    //   290: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iconst_0
    //   294: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	GroupCache
    //   0	295	1	paramList	List<Groups>
    //   50	226	2	bool1	boolean
    //   1	212	3	bool2	boolean
    //   34	244	4	localObject	Object
    //   25	120	5	localArrayList	ArrayList
    //   195	8	5	localException	java.lang.Exception
    //   47	86	6	localIterator	Iterator
    //   71	93	7	localGroups	Groups
    // Exception table:
    //   from	to	target	type
    //   36	49	191	finally
    //   51	98	191	finally
    //   101	122	191	finally
    //   122	175	191	finally
    //   178	183	191	finally
    //   197	207	191	finally
    //   36	49	195	java/lang/Exception
    //   51	98	195	java/lang/Exception
    //   101	122	195	java/lang/Exception
    //   122	175	195	java/lang/Exception
    //   178	183	195	java/lang/Exception
  }
  
  public Groups b(Integer paramInteger)
  {
    d();
    return (Groups)this.e.get(paramInteger);
  }
  
  public void b() {}
  
  public void b(List<Groups> arg1)
  {
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new ArrayList();
      QLog.d("IMCore.friend.GroupCache", 1, "saveToCache| groupList == null");
    }
    synchronized (this.c)
    {
      this.d.clear();
      this.e.clear();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Groups localGroups = (Groups)localIterator.next();
        this.e.put(Integer.valueOf(localGroups.group_id), localGroups);
        this.d.add(localGroups);
      }
      Collections.sort(this.d, FriendSorter.a);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("saveToCache| groupList size: ");
        ???.append(((List)localObject1).size());
        QLog.d("IMCore.friend.GroupCache", 2, ???.toString());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean b(Groups paramGroups)
  {
    boolean bool = false;
    if (paramGroups == null) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (this.a.isOpen())
    {
      if (paramGroups.getStatus() == 1000)
      {
        this.a.persistOrReplace(paramGroups);
        if (paramGroups.getStatus() == 1001) {
          bool = true;
        }
      }
      else if ((paramGroups.getStatus() == 1001) || (paramGroups.getStatus() == 1002))
      {
        bool = this.a.update(paramGroups);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveToDB| em closed groupId = ");
      localStringBuilder.append(paramGroups.group_id);
      QLog.d("IMCore.friend.GroupCache", 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveToDB| saveGroup: ");
      localStringBuilder.append(paramGroups);
      QLog.d("IMCore.friend.GroupCache", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public Groups c(Integer paramInteger)
  {
    Groups localGroups = (Groups)this.a.find(Groups.class, String.valueOf(paramInteger));
    if (localGroups != null) {
      this.a.remove(localGroups);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFromDB| groupId: ");
      localStringBuilder.append(paramInteger);
      localStringBuilder.append(", group: ");
      localStringBuilder.append(localGroups);
      QLog.d("IMCore.friend.GroupCache", 2, localStringBuilder.toString());
    }
    return localGroups;
  }
  
  public List<Groups> c()
  {
    d();
    return new ArrayList(this.d);
  }
  
  public Groups d(Integer paramInteger)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryFromDB: ");
      localStringBuilder.append(paramInteger);
      QLog.d("IMCore.friend.GroupCache", 2, localStringBuilder.toString());
    }
    paramInteger = (Groups)this.a.find(Groups.class, String.valueOf(paramInteger));
    a(paramInteger);
    return paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.cache.GroupCache
 * JD-Core Version:    0.7.0.1
 */