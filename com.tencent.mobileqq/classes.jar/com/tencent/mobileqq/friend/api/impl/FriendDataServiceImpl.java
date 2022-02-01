package com.tencent.mobileqq.friend.api.impl;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.callback.GetGroupListCallback;
import com.tencent.mobileqq.friend.cache.FriendCache;
import com.tencent.mobileqq.friend.cache.GroupCache;
import com.tencent.mobileqq.friend.utils.FriendSorter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FriendDataServiceImpl
  implements IFriendDataService
{
  private static final String TAG = "IMCore.friend.FriendDataServiceImpl";
  private EntityManager mEntityManager;
  private FriendCache mFriendCache;
  private GroupCache mGroupCache;
  
  public static FriendDataServiceImpl getService(AppRuntime paramAppRuntime)
  {
    return (FriendDataServiceImpl)paramAppRuntime.getRuntimeService(IFriendDataService.class, "all");
  }
  
  public List<Groups> asyncGetGroupList(GetGroupListCallback paramGetGroupListCallback)
  {
    return this.mGroupCache.a(paramGetGroupListCallback);
  }
  
  /* Error */
  public Friends deleteFriend(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_1
    //   10: istore_3
    //   11: aload_0
    //   12: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   18: astore 5
    //   20: aload 6
    //   22: astore 4
    //   24: aload 5
    //   26: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   29: aload 6
    //   31: astore 4
    //   33: aload_0
    //   34: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   37: aload_1
    //   38: invokevirtual 65	com/tencent/mobileqq/friend/cache/FriendCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   41: pop
    //   42: aload 6
    //   44: astore 4
    //   46: aload_0
    //   47: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   50: aload_1
    //   51: invokevirtual 68	com/tencent/mobileqq/friend/cache/FriendCache:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnull +51 -> 109
    //   61: aload 6
    //   63: astore 4
    //   65: aload_0
    //   66: aload 6
    //   68: getfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   71: iconst_1
    //   72: invokevirtual 78	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getGroup	(IZ)Lcom/tencent/mobileqq/data/Groups;
    //   75: astore 7
    //   77: aload 7
    //   79: ifnull +30 -> 109
    //   82: aload 6
    //   84: astore 4
    //   86: aload 7
    //   88: aload 7
    //   90: getfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   93: iconst_1
    //   94: isub
    //   95: putfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   98: aload 6
    //   100: astore 4
    //   102: aload_0
    //   103: aload 7
    //   105: invokevirtual 87	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveGroup	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   108: pop
    //   109: aload 6
    //   111: astore 4
    //   113: aload 5
    //   115: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   118: aload 6
    //   120: astore 4
    //   122: iload_3
    //   123: istore_2
    //   124: aload 5
    //   126: ifnull +77 -> 203
    //   129: aload 5
    //   131: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: aload 6
    //   136: astore 4
    //   138: iload_3
    //   139: istore_2
    //   140: goto +63 -> 203
    //   143: astore_1
    //   144: goto +118 -> 262
    //   147: astore 7
    //   149: aload 4
    //   151: astore 6
    //   153: goto +20 -> 173
    //   156: astore_1
    //   157: aload 4
    //   159: astore 5
    //   161: goto +101 -> 262
    //   164: astore 7
    //   166: aconst_null
    //   167: astore 6
    //   169: aload 8
    //   171: astore 5
    //   173: aload 5
    //   175: astore 4
    //   177: ldc 10
    //   179: iconst_1
    //   180: ldc 94
    //   182: aload 7
    //   184: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload 5
    //   189: ifnull +8 -> 197
    //   192: aload 5
    //   194: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   197: iconst_0
    //   198: istore_2
    //   199: aload 6
    //   201: astore 4
    //   203: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +53 -> 259
    //   209: new 106	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   216: astore 5
    //   218: aload 5
    //   220: ldc 109
    //   222: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 5
    //   228: aload_1
    //   229: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 5
    //   235: ldc 115
    //   237: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 5
    //   243: iload_2
    //   244: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: ldc 10
    //   250: iconst_2
    //   251: aload 5
    //   253: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload 4
    //   261: areturn
    //   262: aload 5
    //   264: ifnull +8 -> 272
    //   267: aload 5
    //   269: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   272: aload_1
    //   273: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	FriendDataServiceImpl
    //   0	274	1	paramString	String
    //   123	121	2	bool1	boolean
    //   10	129	3	bool2	boolean
    //   1	259	4	localObject1	Object
    //   18	250	5	localObject2	Object
    //   7	193	6	localObject3	Object
    //   75	29	7	localGroups	Groups
    //   147	1	7	localException1	java.lang.Exception
    //   164	19	7	localException2	java.lang.Exception
    //   4	166	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   24	29	143	finally
    //   33	42	143	finally
    //   46	56	143	finally
    //   65	77	143	finally
    //   86	98	143	finally
    //   102	109	143	finally
    //   113	118	143	finally
    //   24	29	147	java/lang/Exception
    //   33	42	147	java/lang/Exception
    //   46	56	147	java/lang/Exception
    //   65	77	147	java/lang/Exception
    //   86	98	147	java/lang/Exception
    //   102	109	147	java/lang/Exception
    //   113	118	147	java/lang/Exception
    //   11	20	156	finally
    //   177	187	156	finally
    //   11	20	164	java/lang/Exception
  }
  
  public List<Friends> getAllFriends()
  {
    return getAllFriends(false);
  }
  
  public List<Friends> getAllFriends(boolean paramBoolean)
  {
    List localList = this.mFriendCache.d();
    int i = localList.size();
    Iterator localIterator = localList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      if ((!localFriends.isFriend()) || ((paramBoolean) && (localFriends.gathtertype == 1)))
      {
        localIterator.remove();
        localArrayList.add(localFriends.uin);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, String.format("getAllFriends| excludeGather: %s, [%s / %s], filterUinList: ", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(localList.size()), Integer.valueOf(i), localArrayList }));
    }
    return localList;
  }
  
  public Friends getFriend(String paramString)
  {
    return getFriend(paramString, false);
  }
  
  public Friends getFriend(String paramString, boolean paramBoolean)
  {
    return getFriend(paramString, paramBoolean, false);
  }
  
  public Friends getFriend(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return getFriend(paramString, paramBoolean1, paramBoolean2, false);
  }
  
  public Friends getFriend(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2 = this.mFriendCache.b(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      boolean bool = this.mFriendCache.a();
      if (!paramBoolean2)
      {
        localObject1 = localObject2;
        if (!bool)
        {
          localObject1 = localObject2;
          if (!paramBoolean1) {}
        }
      }
      else
      {
        localObject2 = this.mFriendCache.d(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getFriendFromDB is null| uin: ");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(", isInit: ");
            ((StringBuilder)localObject1).append(bool);
            QLog.d("IMCore.friend.FriendDataServiceImpl", 1, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (paramBoolean3)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).uin = paramString;
        this.mFriendCache.a((Friends)localObject2);
      }
    }
    return localObject2;
  }
  
  public int getFriendCount()
  {
    int i = this.mFriendCache.a(false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFriendCount| friendCount: ");
      localStringBuilder.append(i);
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public List<Friends> getFriendList(int paramInt)
  {
    Object localObject = getAllFriends();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        if (localFriends.groupid == paramInt) {
          localArrayList.add(localFriends);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGroupFriends| groupId: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", size: ");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public Groups getGroup(int paramInt)
  {
    return getGroup(paramInt, false);
  }
  
  public Groups getGroup(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.mGroupCache.b(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mGroupCache.d(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getGroup| groupId: ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", queryDBIfNotExist: ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", group: ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public List<Groups> getGroupList()
  {
    List localList = this.mGroupCache.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGroupList| getGroupList: ");
      localStringBuilder.append(localList);
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, localStringBuilder.toString());
    }
    return localList;
  }
  
  public void initFriendCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "initFriendCache");
    }
    this.mFriendCache.b();
  }
  
  public void initGroupCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "initGroupCache");
    }
    this.mGroupCache.a();
  }
  
  public boolean isFriend(String paramString)
  {
    return isFriend(paramString, true);
  }
  
  public boolean isFriend(String paramString, boolean paramBoolean)
  {
    paramString = getFriend(paramString, paramBoolean);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  /* Error */
  public void moveFriendToNewGroup(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 276	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 7
    //   14: iconst_m1
    //   15: istore 4
    //   17: iload 4
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   27: astore 8
    //   29: aload 8
    //   31: astore 7
    //   33: aload 8
    //   35: astore 6
    //   37: iload 4
    //   39: istore_3
    //   40: aload 8
    //   42: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   45: aload 8
    //   47: astore 7
    //   49: aload 8
    //   51: astore 6
    //   53: iload 4
    //   55: istore_3
    //   56: aload_0
    //   57: aload_1
    //   58: iconst_1
    //   59: iconst_1
    //   60: iconst_1
    //   61: invokevirtual 202	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getFriend	(Ljava/lang/String;ZZZ)Lcom/tencent/mobileqq/data/Friends;
    //   64: astore 9
    //   66: aload 8
    //   68: astore 7
    //   70: aload 8
    //   72: astore 6
    //   74: iload 4
    //   76: istore_3
    //   77: aload 9
    //   79: getfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   82: istore 4
    //   84: aload 8
    //   86: astore 7
    //   88: aload 8
    //   90: astore 6
    //   92: iload 4
    //   94: istore_3
    //   95: aload_0
    //   96: iload 4
    //   98: invokevirtual 278	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getGroup	(I)Lcom/tencent/mobileqq/data/Groups;
    //   101: astore 10
    //   103: aload 10
    //   105: ifnull +29 -> 134
    //   108: aload 8
    //   110: astore 7
    //   112: aload 8
    //   114: astore 6
    //   116: iload 4
    //   118: istore_3
    //   119: aload 10
    //   121: aload 10
    //   123: getfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   126: iconst_1
    //   127: isub
    //   128: putfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   131: goto +23 -> 154
    //   134: aload 8
    //   136: astore 7
    //   138: aload 8
    //   140: astore 6
    //   142: iload 4
    //   144: istore_3
    //   145: ldc 10
    //   147: iconst_1
    //   148: ldc_w 280
    //   151: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload 8
    //   156: astore 7
    //   158: aload 8
    //   160: astore 6
    //   162: iload 4
    //   164: istore_3
    //   165: aload_0
    //   166: aload 10
    //   168: invokevirtual 87	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveGroup	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   171: pop
    //   172: aload 8
    //   174: astore 7
    //   176: aload 8
    //   178: astore 6
    //   180: iload 4
    //   182: istore_3
    //   183: aload 9
    //   185: iload_2
    //   186: putfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   189: aload 8
    //   191: astore 7
    //   193: aload 8
    //   195: astore 6
    //   197: iload 4
    //   199: istore_3
    //   200: aload_0
    //   201: aload 9
    //   203: invokevirtual 287	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveFriend	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   206: pop
    //   207: aload 8
    //   209: astore 7
    //   211: aload 8
    //   213: astore 6
    //   215: iload 4
    //   217: istore_3
    //   218: aload_0
    //   219: iload_2
    //   220: invokevirtual 278	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getGroup	(I)Lcom/tencent/mobileqq/data/Groups;
    //   223: astore 9
    //   225: aload 9
    //   227: ifnull +47 -> 274
    //   230: aload 8
    //   232: astore 7
    //   234: aload 8
    //   236: astore 6
    //   238: iload 4
    //   240: istore_3
    //   241: aload 9
    //   243: aload 9
    //   245: getfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   248: iconst_1
    //   249: iadd
    //   250: putfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   253: aload 8
    //   255: astore 7
    //   257: aload 8
    //   259: astore 6
    //   261: iload 4
    //   263: istore_3
    //   264: aload_0
    //   265: aload 9
    //   267: invokevirtual 87	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveGroup	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   270: pop
    //   271: goto +23 -> 294
    //   274: aload 8
    //   276: astore 7
    //   278: aload 8
    //   280: astore 6
    //   282: iload 4
    //   284: istore_3
    //   285: ldc 10
    //   287: iconst_1
    //   288: ldc_w 289
    //   291: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload 8
    //   296: astore 7
    //   298: aload 8
    //   300: astore 6
    //   302: iload 4
    //   304: istore_3
    //   305: aload 8
    //   307: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   310: iload 4
    //   312: istore 5
    //   314: aload 8
    //   316: ifnull +52 -> 368
    //   319: iload 4
    //   321: istore_3
    //   322: aload 8
    //   324: astore 6
    //   326: aload 6
    //   328: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   331: iload_3
    //   332: istore 5
    //   334: goto +34 -> 368
    //   337: astore_1
    //   338: goto +106 -> 444
    //   341: astore 8
    //   343: aload 6
    //   345: astore 7
    //   347: ldc 10
    //   349: iconst_1
    //   350: ldc 94
    //   352: aload 8
    //   354: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   357: iload_3
    //   358: istore 5
    //   360: aload 6
    //   362: ifnull +6 -> 368
    //   365: goto -39 -> 326
    //   368: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +72 -> 443
    //   374: new 106	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   381: astore 6
    //   383: aload 6
    //   385: ldc_w 291
    //   388: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 6
    //   394: aload_1
    //   395: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 6
    //   401: ldc_w 293
    //   404: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 6
    //   410: iload 5
    //   412: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 6
    //   418: ldc_w 295
    //   421: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 6
    //   427: iload_2
    //   428: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 10
    //   434: iconst_2
    //   435: aload 6
    //   437: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: return
    //   444: aload 7
    //   446: ifnull +8 -> 454
    //   449: aload 7
    //   451: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   454: goto +5 -> 459
    //   457: aload_1
    //   458: athrow
    //   459: goto -2 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	FriendDataServiceImpl
    //   0	462	1	paramString	String
    //   0	462	2	paramInt	int
    //   19	339	3	i	int
    //   15	305	4	j	int
    //   312	99	5	k	int
    //   9	427	6	localObject1	Object
    //   12	438	7	localObject2	Object
    //   27	296	8	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   341	12	8	localException	java.lang.Exception
    //   64	202	9	localObject3	Object
    //   101	66	10	localGroups	Groups
    // Exception table:
    //   from	to	target	type
    //   20	29	337	finally
    //   40	45	337	finally
    //   56	66	337	finally
    //   77	84	337	finally
    //   95	103	337	finally
    //   119	131	337	finally
    //   145	154	337	finally
    //   165	172	337	finally
    //   183	189	337	finally
    //   200	207	337	finally
    //   218	225	337	finally
    //   241	253	337	finally
    //   264	271	337	finally
    //   285	294	337	finally
    //   305	310	337	finally
    //   347	357	337	finally
    //   20	29	341	java/lang/Exception
    //   40	45	341	java/lang/Exception
    //   56	66	341	java/lang/Exception
    //   77	84	341	java/lang/Exception
    //   95	103	341	java/lang/Exception
    //   119	131	341	java/lang/Exception
    //   145	154	341	java/lang/Exception
    //   165	172	341	java/lang/Exception
    //   183	189	341	java/lang/Exception
    //   200	207	341	java/lang/Exception
    //   218	225	341	java/lang/Exception
    //   241	253	341	java/lang/Exception
    //   264	271	341	java/lang/Exception
    //   285	294	341	java/lang/Exception
    //   305	310	341	java/lang/Exception
  }
  
  /* Error */
  public void moveGroup(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iload_1
    //   4: iload_2
    //   5: if_icmpne +13 -> 18
    //   8: ldc 10
    //   10: iconst_1
    //   11: ldc_w 299
    //   14: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: return
    //   18: aload_0
    //   19: getfield 35	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mGroupCache	Lcom/tencent/mobileqq/friend/cache/GroupCache;
    //   22: iload_2
    //   23: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokevirtual 239	com/tencent/mobileqq/friend/cache/GroupCache:b	(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/Groups;
    //   29: ifnonnull +48 -> 77
    //   32: new 106	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   39: astore 5
    //   41: aload 5
    //   43: ldc_w 301
    //   46: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: iload_2
    //   53: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: ldc_w 303
    //   62: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 10
    //   68: iconst_1
    //   69: aload 5
    //   71: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   81: iload_1
    //   82: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 306	com/tencent/mobileqq/friend/cache/FriendCache:a	(Ljava/lang/Integer;)Ljava/util/List;
    //   88: astore 8
    //   90: aconst_null
    //   91: astore 6
    //   93: aconst_null
    //   94: astore 5
    //   96: aload_0
    //   97: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   100: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   103: astore 7
    //   105: aload 7
    //   107: astore 5
    //   109: aload 7
    //   111: astore 6
    //   113: aload 7
    //   115: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   118: aload 8
    //   120: ifnull +93 -> 213
    //   123: aload 7
    //   125: astore 5
    //   127: aload 7
    //   129: astore 6
    //   131: aload 8
    //   133: invokeinterface 143 1 0
    //   138: astore 9
    //   140: aload 7
    //   142: astore 5
    //   144: aload 7
    //   146: astore 6
    //   148: aload 9
    //   150: invokeinterface 151 1 0
    //   155: ifeq +58 -> 213
    //   158: aload 7
    //   160: astore 5
    //   162: aload 7
    //   164: astore 6
    //   166: aload 9
    //   168: invokeinterface 155 1 0
    //   173: checkcast 70	com/tencent/mobileqq/data/Friends
    //   176: astore 10
    //   178: aload 7
    //   180: astore 5
    //   182: aload 7
    //   184: astore 6
    //   186: aload 10
    //   188: iload_2
    //   189: putfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   192: aload 7
    //   194: astore 5
    //   196: aload 7
    //   198: astore 6
    //   200: aload_0
    //   201: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   204: aload 10
    //   206: invokevirtual 308	com/tencent/mobileqq/friend/cache/FriendCache:b	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   209: pop
    //   210: goto -70 -> 140
    //   213: aload 7
    //   215: astore 5
    //   217: aload 7
    //   219: astore 6
    //   221: aload_0
    //   222: getfield 35	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mGroupCache	Lcom/tencent/mobileqq/friend/cache/GroupCache;
    //   225: iload_1
    //   226: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: invokevirtual 310	com/tencent/mobileqq/friend/cache/GroupCache:c	(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/Groups;
    //   232: pop
    //   233: aload 7
    //   235: astore 5
    //   237: aload 7
    //   239: astore 6
    //   241: aload 7
    //   243: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   246: iload 4
    //   248: istore_3
    //   249: aload 7
    //   251: ifnull +48 -> 299
    //   254: aload 7
    //   256: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   259: iload 4
    //   261: istore_3
    //   262: goto +37 -> 299
    //   265: astore 6
    //   267: goto +161 -> 428
    //   270: astore 7
    //   272: aload 6
    //   274: astore 5
    //   276: ldc 10
    //   278: iconst_1
    //   279: ldc_w 311
    //   282: aload 7
    //   284: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload 6
    //   289: ifnull +8 -> 297
    //   292: aload 6
    //   294: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   297: iconst_0
    //   298: istore_3
    //   299: aload 8
    //   301: invokeinterface 143 1 0
    //   306: astore 5
    //   308: aload 5
    //   310: invokeinterface 151 1 0
    //   315: ifeq +27 -> 342
    //   318: aload 5
    //   320: invokeinterface 155 1 0
    //   325: checkcast 70	com/tencent/mobileqq/data/Friends
    //   328: astore 6
    //   330: aload_0
    //   331: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   334: aload 6
    //   336: invokevirtual 217	com/tencent/mobileqq/friend/cache/FriendCache:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   339: goto -31 -> 308
    //   342: aload_0
    //   343: getfield 35	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mGroupCache	Lcom/tencent/mobileqq/friend/cache/GroupCache;
    //   346: iload_1
    //   347: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: invokevirtual 313	com/tencent/mobileqq/friend/cache/GroupCache:a	(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/Groups;
    //   353: pop
    //   354: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +70 -> 427
    //   360: new 106	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   367: astore 5
    //   369: aload 5
    //   371: ldc_w 315
    //   374: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 5
    //   380: iload_1
    //   381: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 5
    //   387: ldc_w 317
    //   390: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 5
    //   396: iload_2
    //   397: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 5
    //   403: ldc 115
    //   405: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 5
    //   411: iload_3
    //   412: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: ldc 10
    //   418: iconst_2
    //   419: aload 5
    //   421: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: return
    //   428: aload 5
    //   430: ifnull +8 -> 438
    //   433: aload 5
    //   435: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   438: goto +6 -> 444
    //   441: aload 6
    //   443: athrow
    //   444: goto -3 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	FriendDataServiceImpl
    //   0	447	1	paramInt1	int
    //   0	447	2	paramInt2	int
    //   248	164	3	bool1	boolean
    //   1	259	4	bool2	boolean
    //   39	395	5	localObject1	Object
    //   91	149	6	localObject2	Object
    //   265	28	6	localObject3	Object
    //   328	114	6	localFriends1	Friends
    //   103	152	7	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   270	13	7	localException	java.lang.Exception
    //   88	212	8	localList	List
    //   138	29	9	localIterator	Iterator
    //   176	29	10	localFriends2	Friends
    // Exception table:
    //   from	to	target	type
    //   96	105	265	finally
    //   113	118	265	finally
    //   131	140	265	finally
    //   148	158	265	finally
    //   166	178	265	finally
    //   186	192	265	finally
    //   200	210	265	finally
    //   221	233	265	finally
    //   241	246	265	finally
    //   276	287	265	finally
    //   96	105	270	java/lang/Exception
    //   113	118	270	java/lang/Exception
    //   131	140	270	java/lang/Exception
    //   148	158	270	java/lang/Exception
    //   166	178	270	java/lang/Exception
    //   186	192	270	java/lang/Exception
    //   200	210	270	java/lang/Exception
    //   221	233	270	java/lang/Exception
    //   241	246	270	java/lang/Exception
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mEntityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    this.mGroupCache = new GroupCache(this.mEntityManager);
    this.mFriendCache = new FriendCache(this.mEntityManager);
  }
  
  public void onDestroy()
  {
    this.mFriendCache.c();
    this.mGroupCache.b();
  }
  
  public List<Friends> preloadPartFriendCache(List<String> paramList)
  {
    return this.mFriendCache.a(paramList);
  }
  
  public boolean saveFriend(Friends paramFriends)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFriend: ");
      localStringBuilder.append(paramFriends);
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, localStringBuilder.toString());
    }
    if (paramFriends == null) {
      return false;
    }
    if ((paramFriends.mCompareSpell == null) || (paramFriends.mCompareSpell.length() == 0)) {
      FriendSorter.b(paramFriends);
    }
    this.mFriendCache.a(paramFriends);
    return this.mFriendCache.b(paramFriends);
  }
  
  public void saveFriendCache(Friends paramFriends)
  {
    if (paramFriends == null) {
      return;
    }
    if ((paramFriends.mCompareSpell == null) || (paramFriends.mCompareSpell.length() == 0)) {
      FriendSorter.b(paramFriends);
    }
    this.mFriendCache.a(paramFriends);
  }
  
  public boolean saveFriendList(List<Friends> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        if (localFriends == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "saveFriendList, friend == null");
          }
        }
        else
        {
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            FriendSorter.b(localFriends);
          }
          this.mFriendCache.a(localFriends);
        }
      }
      boolean bool = this.mFriendCache.b(paramList);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveFriendList| isSuccess = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", size = ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.d("IMCore.friend.FriendDataServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    QLog.e("IMCore.friend.FriendDataServiceImpl", 1, "saveFriendList| friendList is empty!");
    return false;
  }
  
  /* Error */
  public boolean saveFriendList(List<Friends> paramList, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 375	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: iconst_0
    //   6: istore 6
    //   8: aload_1
    //   9: ifnull +548 -> 557
    //   12: aload_1
    //   13: invokeinterface 139 1 0
    //   18: ifne +6 -> 24
    //   21: goto +536 -> 557
    //   24: aconst_null
    //   25: astore 12
    //   27: aconst_null
    //   28: astore 11
    //   30: aload_0
    //   31: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   34: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   37: astore 13
    //   39: aload 13
    //   41: astore 11
    //   43: aload 13
    //   45: astore 12
    //   47: aload 13
    //   49: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   52: aload 13
    //   54: astore 11
    //   56: aload 13
    //   58: astore 12
    //   60: aload_1
    //   61: invokeinterface 143 1 0
    //   66: astore 14
    //   68: aload 13
    //   70: astore 11
    //   72: aload 13
    //   74: astore 12
    //   76: aload 14
    //   78: invokeinterface 151 1 0
    //   83: ifeq +148 -> 231
    //   86: aload 13
    //   88: astore 11
    //   90: aload 13
    //   92: astore 12
    //   94: aload 14
    //   96: invokeinterface 155 1 0
    //   101: checkcast 70	com/tencent/mobileqq/data/Friends
    //   104: astore 15
    //   106: aload 15
    //   108: ifnonnull +37 -> 145
    //   111: aload 13
    //   113: astore 11
    //   115: aload 13
    //   117: astore 12
    //   119: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -54 -> 68
    //   125: aload 13
    //   127: astore 11
    //   129: aload 13
    //   131: astore 12
    //   133: ldc 10
    //   135: iconst_2
    //   136: ldc_w 359
    //   139: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: goto -74 -> 68
    //   145: aload 13
    //   147: astore 11
    //   149: aload 13
    //   151: astore 12
    //   153: aload 15
    //   155: getfield 347	com/tencent/mobileqq/data/Friends:mCompareSpell	Ljava/lang/String;
    //   158: ifnull +22 -> 180
    //   161: aload 13
    //   163: astore 11
    //   165: aload 13
    //   167: astore 12
    //   169: aload 15
    //   171: getfield 347	com/tencent/mobileqq/data/Friends:mCompareSpell	Ljava/lang/String;
    //   174: invokevirtual 350	java/lang/String:length	()I
    //   177: ifne +16 -> 193
    //   180: aload 13
    //   182: astore 11
    //   184: aload 13
    //   186: astore 12
    //   188: aload 15
    //   190: invokestatic 354	com/tencent/mobileqq/friend/utils/FriendSorter:b	(Lcom/tencent/mobileqq/data/Friends;)V
    //   193: aload 13
    //   195: astore 11
    //   197: aload 13
    //   199: astore 12
    //   201: aload_0
    //   202: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   205: aload 15
    //   207: invokevirtual 217	com/tencent/mobileqq/friend/cache/FriendCache:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   210: aload 13
    //   212: astore 11
    //   214: aload 13
    //   216: astore 12
    //   218: aload_0
    //   219: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   222: aload 15
    //   224: invokevirtual 308	com/tencent/mobileqq/friend/cache/FriendCache:b	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   227: pop
    //   228: goto -160 -> 68
    //   231: iload_2
    //   232: ifeq +139 -> 371
    //   235: aload 13
    //   237: astore 11
    //   239: aload 13
    //   241: astore 12
    //   243: aload_0
    //   244: invokevirtual 230	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getAllFriends	()Ljava/util/List;
    //   247: invokeinterface 143 1 0
    //   252: astore 14
    //   254: aload 13
    //   256: astore 11
    //   258: aload 13
    //   260: astore 12
    //   262: aload 14
    //   264: invokeinterface 151 1 0
    //   269: ifeq +102 -> 371
    //   272: aload 13
    //   274: astore 11
    //   276: aload 13
    //   278: astore 12
    //   280: aload 14
    //   282: invokeinterface 155 1 0
    //   287: checkcast 70	com/tencent/mobileqq/data/Friends
    //   290: astore 15
    //   292: aload 13
    //   294: astore 11
    //   296: aload 13
    //   298: astore 12
    //   300: aload 15
    //   302: getfield 379	com/tencent/mobileqq/data/Friends:datetime	J
    //   305: lload_3
    //   306: lcmp
    //   307: ifge -53 -> 254
    //   310: aload 13
    //   312: astore 11
    //   314: aload 13
    //   316: astore 12
    //   318: aload 15
    //   320: invokevirtual 158	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   323: ifeq -69 -> 254
    //   326: aload 13
    //   328: astore 11
    //   330: aload 13
    //   332: astore 12
    //   334: aload_0
    //   335: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   338: aload 15
    //   340: getfield 168	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   343: invokevirtual 65	com/tencent/mobileqq/friend/cache/FriendCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   346: pop
    //   347: aload 13
    //   349: astore 11
    //   351: aload 13
    //   353: astore 12
    //   355: aload_0
    //   356: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   359: aload 15
    //   361: getfield 168	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   364: invokevirtual 68	com/tencent/mobileqq/friend/cache/FriendCache:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   367: pop
    //   368: goto -114 -> 254
    //   371: aload 13
    //   373: astore 11
    //   375: aload 13
    //   377: astore 12
    //   379: aload 13
    //   381: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   384: aload 13
    //   386: ifnull +8 -> 394
    //   389: aload 13
    //   391: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   394: iconst_1
    //   395: istore 5
    //   397: goto +41 -> 438
    //   400: astore_1
    //   401: goto +144 -> 545
    //   404: astore 13
    //   406: aload 12
    //   408: astore 11
    //   410: ldc 10
    //   412: iconst_1
    //   413: ldc 94
    //   415: aload 13
    //   417: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: iload 6
    //   422: istore 5
    //   424: aload 12
    //   426: ifnull +12 -> 438
    //   429: aload 12
    //   431: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   434: iload 6
    //   436: istore 5
    //   438: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +101 -> 542
    //   444: invokestatic 375	java/lang/System:currentTimeMillis	()J
    //   447: lstore 9
    //   449: new 106	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   456: astore 11
    //   458: aload 11
    //   460: ldc_w 381
    //   463: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 11
    //   469: aload_1
    //   470: invokeinterface 139 1 0
    //   475: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 11
    //   481: ldc_w 383
    //   484: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 11
    //   490: iload_2
    //   491: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 11
    //   497: ldc_w 385
    //   500: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 11
    //   506: lload_3
    //   507: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 11
    //   513: ldc_w 390
    //   516: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 11
    //   522: lload 9
    //   524: lload 7
    //   526: lsub
    //   527: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: ldc 10
    //   533: iconst_2
    //   534: aload 11
    //   536: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: iload 5
    //   544: ireturn
    //   545: aload 11
    //   547: ifnull +8 -> 555
    //   550: aload 11
    //   552: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   555: aload_1
    //   556: athrow
    //   557: ldc 10
    //   559: iconst_1
    //   560: ldc_w 367
    //   563: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: iconst_0
    //   567: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	FriendDataServiceImpl
    //   0	568	1	paramList	List<Friends>
    //   0	568	2	paramBoolean	boolean
    //   0	568	3	paramLong	long
    //   395	148	5	bool1	boolean
    //   6	429	6	bool2	boolean
    //   3	522	7	l1	long
    //   447	76	9	l2	long
    //   28	523	11	localObject1	Object
    //   25	405	12	localObject2	Object
    //   37	353	13	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   404	12	13	localException	java.lang.Exception
    //   66	215	14	localIterator	Iterator
    //   104	256	15	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   30	39	400	finally
    //   47	52	400	finally
    //   60	68	400	finally
    //   76	86	400	finally
    //   94	106	400	finally
    //   119	125	400	finally
    //   133	142	400	finally
    //   153	161	400	finally
    //   169	180	400	finally
    //   188	193	400	finally
    //   201	210	400	finally
    //   218	228	400	finally
    //   243	254	400	finally
    //   262	272	400	finally
    //   280	292	400	finally
    //   300	310	400	finally
    //   318	326	400	finally
    //   334	347	400	finally
    //   355	368	400	finally
    //   379	384	400	finally
    //   410	420	400	finally
    //   30	39	404	java/lang/Exception
    //   47	52	404	java/lang/Exception
    //   60	68	404	java/lang/Exception
    //   76	86	404	java/lang/Exception
    //   94	106	404	java/lang/Exception
    //   119	125	404	java/lang/Exception
    //   133	142	404	java/lang/Exception
    //   153	161	404	java/lang/Exception
    //   169	180	404	java/lang/Exception
    //   188	193	404	java/lang/Exception
    //   201	210	404	java/lang/Exception
    //   218	228	404	java/lang/Exception
    //   243	254	404	java/lang/Exception
    //   262	272	404	java/lang/Exception
    //   280	292	404	java/lang/Exception
    //   300	310	404	java/lang/Exception
    //   318	326	404	java/lang/Exception
    //   334	347	404	java/lang/Exception
    //   355	368	404	java/lang/Exception
    //   379	384	404	java/lang/Exception
  }
  
  public boolean saveGroup(Groups paramGroups)
  {
    if (paramGroups == null) {
      return false;
    }
    boolean bool = this.mGroupCache.b(paramGroups);
    if (bool) {
      this.mGroupCache.a(paramGroups);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateGroup| isSuccess: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", group: ");
      localStringBuilder.append(paramGroups);
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean saveGroupList(List<Groups> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      boolean bool = this.mGroupCache.a(paramList);
      if (bool) {
        this.mGroupCache.b(paramList);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateGroupList| isSuccess: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", groupList: ");
        localStringBuilder.append(paramList);
        QLog.d("IMCore.friend.FriendDataServiceImpl", 2, localStringBuilder.toString());
      }
      return bool;
    }
    QLog.d("IMCore.friend.FriendDataServiceImpl", 1, "updateGroupList| groupList == null");
    return false;
  }
  
  /* Error */
  public void updateGroupSortIds(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +391 -> 392
    //   4: aload_2
    //   5: ifnull +387 -> 392
    //   8: aload_1
    //   9: arraylength
    //   10: aload_2
    //   11: arraylength
    //   12: if_icmpeq +6 -> 18
    //   15: goto +377 -> 392
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 6
    //   24: aload_0
    //   25: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   28: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   31: astore 7
    //   33: aload 7
    //   35: astore 6
    //   37: aload 7
    //   39: astore 5
    //   41: aload 7
    //   43: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   46: aload 7
    //   48: astore 6
    //   50: aload 7
    //   52: astore 5
    //   54: new 145	java/util/ArrayList
    //   57: dup
    //   58: invokespecial 146	java/util/ArrayList:<init>	()V
    //   61: astore 8
    //   63: iconst_0
    //   64: istore_3
    //   65: aload 7
    //   67: astore 6
    //   69: aload 7
    //   71: astore 5
    //   73: iload_3
    //   74: aload_1
    //   75: arraylength
    //   76: if_icmpge +173 -> 249
    //   79: aload_1
    //   80: iload_3
    //   81: baload
    //   82: istore 4
    //   84: aload 7
    //   86: astore 6
    //   88: aload 7
    //   90: astore 5
    //   92: aload_0
    //   93: iload 4
    //   95: iconst_1
    //   96: invokevirtual 78	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getGroup	(IZ)Lcom/tencent/mobileqq/data/Groups;
    //   99: astore 9
    //   101: aload 9
    //   103: ifnull +74 -> 177
    //   106: aload 7
    //   108: astore 6
    //   110: aload 7
    //   112: astore 5
    //   114: aload 9
    //   116: getfield 418	com/tencent/mobileqq/data/Groups:seqid	B
    //   119: aload_2
    //   120: iload_3
    //   121: baload
    //   122: if_icmpeq +19 -> 141
    //   125: aload 7
    //   127: astore 6
    //   129: aload 7
    //   131: astore 5
    //   133: aload 9
    //   135: aload_2
    //   136: iload_3
    //   137: baload
    //   138: putfield 418	com/tencent/mobileqq/data/Groups:seqid	B
    //   141: aload 7
    //   143: astore 6
    //   145: aload 7
    //   147: astore 5
    //   149: aload_0
    //   150: aload 9
    //   152: invokevirtual 87	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveGroup	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   155: pop
    //   156: aload 7
    //   158: astore 6
    //   160: aload 7
    //   162: astore 5
    //   164: aload 8
    //   166: aload 9
    //   168: invokeinterface 172 2 0
    //   173: pop
    //   174: goto +228 -> 402
    //   177: aload 7
    //   179: astore 6
    //   181: aload 7
    //   183: astore 5
    //   185: new 106	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   192: astore 9
    //   194: aload 7
    //   196: astore 6
    //   198: aload 7
    //   200: astore 5
    //   202: aload 9
    //   204: ldc_w 420
    //   207: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 7
    //   213: astore 6
    //   215: aload 7
    //   217: astore 5
    //   219: aload 9
    //   221: iload 4
    //   223: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 7
    //   229: astore 6
    //   231: aload 7
    //   233: astore 5
    //   235: ldc 10
    //   237: iconst_1
    //   238: aload 9
    //   240: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: goto +156 -> 402
    //   249: aload 7
    //   251: astore 6
    //   253: aload 7
    //   255: astore 5
    //   257: aload_0
    //   258: getfield 35	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mGroupCache	Lcom/tencent/mobileqq/friend/cache/GroupCache;
    //   261: aload 8
    //   263: invokevirtual 406	com/tencent/mobileqq/friend/cache/GroupCache:b	(Ljava/util/List;)V
    //   266: aload 7
    //   268: astore 6
    //   270: aload 7
    //   272: astore 5
    //   274: aload 7
    //   276: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   279: aload 7
    //   281: ifnull +40 -> 321
    //   284: aload 7
    //   286: astore 5
    //   288: goto +28 -> 316
    //   291: astore_1
    //   292: goto +88 -> 380
    //   295: astore 7
    //   297: aload 5
    //   299: astore 6
    //   301: ldc 10
    //   303: iconst_1
    //   304: ldc 94
    //   306: aload 7
    //   308: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload 5
    //   313: ifnull +8 -> 321
    //   316: aload 5
    //   318: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   321: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +55 -> 379
    //   327: new 106	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   334: astore 5
    //   336: aload 5
    //   338: ldc_w 422
    //   341: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 5
    //   347: aload_1
    //   348: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 5
    //   354: ldc_w 424
    //   357: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 5
    //   363: aload_2
    //   364: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: ldc 10
    //   370: iconst_2
    //   371: aload 5
    //   373: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: return
    //   380: aload 6
    //   382: ifnull +8 -> 390
    //   385: aload 6
    //   387: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   390: aload_1
    //   391: athrow
    //   392: ldc 10
    //   394: iconst_1
    //   395: ldc_w 426
    //   398: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: return
    //   402: iload_3
    //   403: iconst_1
    //   404: iadd
    //   405: istore_3
    //   406: goto -341 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	FriendDataServiceImpl
    //   0	409	1	paramArrayOfByte1	byte[]
    //   0	409	2	paramArrayOfByte2	byte[]
    //   64	342	3	i	int
    //   82	140	4	j	int
    //   19	353	5	localObject1	Object
    //   22	364	6	localObject2	Object
    //   31	254	7	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   295	12	7	localException	java.lang.Exception
    //   61	201	8	localArrayList	ArrayList
    //   99	140	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	33	291	finally
    //   41	46	291	finally
    //   54	63	291	finally
    //   73	79	291	finally
    //   92	101	291	finally
    //   114	125	291	finally
    //   133	141	291	finally
    //   149	156	291	finally
    //   164	174	291	finally
    //   185	194	291	finally
    //   202	211	291	finally
    //   219	227	291	finally
    //   235	246	291	finally
    //   257	266	291	finally
    //   274	279	291	finally
    //   301	311	291	finally
    //   24	33	295	java/lang/Exception
    //   41	46	295	java/lang/Exception
    //   54	63	295	java/lang/Exception
    //   73	79	295	java/lang/Exception
    //   92	101	295	java/lang/Exception
    //   114	125	295	java/lang/Exception
    //   133	141	295	java/lang/Exception
    //   149	156	295	java/lang/Exception
    //   164	174	295	java/lang/Exception
    //   185	194	295	java/lang/Exception
    //   202	211	295	java/lang/Exception
    //   219	227	295	java/lang/Exception
    //   235	246	295	java/lang/Exception
    //   257	266	295	java/lang/Exception
    //   274	279	295	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */