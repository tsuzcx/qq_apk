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
import com.tencent.mobileqq.persistence.EntityTransaction;
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
    //   1: astore 5
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   12: astore 4
    //   14: aload 4
    //   16: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_0
    //   20: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   23: aload_1
    //   24: invokevirtual 65	com/tencent/mobileqq/friend/cache/FriendCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   27: pop
    //   28: aload_0
    //   29: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   32: aload_1
    //   33: invokevirtual 68	com/tencent/mobileqq/friend/cache/FriendCache:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnull +39 -> 79
    //   43: aload_0
    //   44: aload 5
    //   46: getfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   49: iconst_1
    //   50: invokevirtual 78	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getGroup	(IZ)Lcom/tencent/mobileqq/data/Groups;
    //   53: astore 6
    //   55: aload 6
    //   57: ifnull +22 -> 79
    //   60: aload 6
    //   62: aload 6
    //   64: getfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   67: iconst_1
    //   68: isub
    //   69: putfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   72: aload_0
    //   73: aload 6
    //   75: invokevirtual 87	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveGroup	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   78: pop
    //   79: aload 4
    //   81: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   84: aload 5
    //   86: astore 6
    //   88: iload_3
    //   89: istore_2
    //   90: aload 4
    //   92: ifnull +14 -> 106
    //   95: aload 4
    //   97: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   100: iload_3
    //   101: istore_2
    //   102: aload 5
    //   104: astore 6
    //   106: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +37 -> 146
    //   112: ldc 10
    //   114: iconst_2
    //   115: new 101	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   122: ldc 104
    //   124: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_1
    //   128: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 110
    //   133: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload 6
    //   148: areturn
    //   149: astore 6
    //   151: aconst_null
    //   152: astore 4
    //   154: ldc 10
    //   156: iconst_1
    //   157: ldc 122
    //   159: aload 6
    //   161: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload 5
    //   166: ifnull +78 -> 244
    //   169: aload 5
    //   171: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   174: iconst_0
    //   175: istore_2
    //   176: aload 4
    //   178: astore 6
    //   180: goto -74 -> 106
    //   183: astore_1
    //   184: aconst_null
    //   185: astore 4
    //   187: aload 4
    //   189: ifnull +8 -> 197
    //   192: aload 4
    //   194: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: goto -13 -> 187
    //   203: astore_1
    //   204: aload 5
    //   206: astore 4
    //   208: goto -21 -> 187
    //   211: astore 6
    //   213: aconst_null
    //   214: astore 7
    //   216: aload 4
    //   218: astore 5
    //   220: aload 7
    //   222: astore 4
    //   224: goto -70 -> 154
    //   227: astore 6
    //   229: aload 4
    //   231: astore 7
    //   233: aload 5
    //   235: astore 4
    //   237: aload 7
    //   239: astore 5
    //   241: goto -87 -> 154
    //   244: iconst_0
    //   245: istore_2
    //   246: aload 4
    //   248: astore 6
    //   250: goto -144 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	FriendDataServiceImpl
    //   0	253	1	paramString	String
    //   89	157	2	bool1	boolean
    //   4	97	3	bool2	boolean
    //   12	235	4	localObject1	Object
    //   1	239	5	localObject2	Object
    //   53	94	6	localObject3	Object
    //   149	11	6	localException1	Exception
    //   178	1	6	localObject4	Object
    //   211	1	6	localException2	Exception
    //   227	1	6	localException3	Exception
    //   248	1	6	localObject5	Object
    //   214	24	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   5	14	149	java/lang/Exception
    //   5	14	183	finally
    //   14	38	199	finally
    //   43	55	199	finally
    //   60	79	199	finally
    //   79	84	199	finally
    //   154	164	203	finally
    //   14	38	211	java/lang/Exception
    //   43	55	227	java/lang/Exception
    //   60	79	227	java/lang/Exception
    //   79	84	227	java/lang/Exception
  }
  
  public List<Friends> getAllFriends()
  {
    return getAllFriends(false);
  }
  
  public List<Friends> getAllFriends(boolean paramBoolean)
  {
    List localList = this.mFriendCache.a();
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
            QLog.d("IMCore.friend.FriendDataServiceImpl", 1, "getFriendFromDB is null| uin: " + paramString + ", isInit: " + bool);
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
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "getFriendCount| friendCount: " + i);
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
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "getGroupFriends| groupId: " + paramInt + ", size: " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public Groups getGroup(int paramInt)
  {
    return getGroup(paramInt, false);
  }
  
  public Groups getGroup(int paramInt, boolean paramBoolean)
  {
    Groups localGroups2 = this.mGroupCache.b(Integer.valueOf(paramInt));
    Groups localGroups1 = localGroups2;
    if (localGroups2 == null) {
      localGroups1 = this.mGroupCache.d(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "getGroup| groupId: " + paramInt + ", queryDBIfNotExist: " + paramBoolean + ", group: " + localGroups1);
    }
    return localGroups1;
  }
  
  public List<Groups> getGroupList()
  {
    List localList = this.mGroupCache.a();
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "getGroupList| getGroupList: " + localList);
    }
    return localList;
  }
  
  public void initFriendCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "initFriendCache");
    }
    this.mFriendCache.a();
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
    //   1: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_0
    //   15: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 6
    //   23: aload 6
    //   25: astore 5
    //   27: aload 6
    //   29: astore 7
    //   31: aload 6
    //   33: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   36: aload 6
    //   38: astore 5
    //   40: aload 6
    //   42: astore 7
    //   44: aload_0
    //   45: aload_1
    //   46: iconst_1
    //   47: iconst_1
    //   48: iconst_1
    //   49: invokevirtual 202	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getFriend	(Ljava/lang/String;ZZZ)Lcom/tencent/mobileqq/data/Friends;
    //   52: astore 8
    //   54: aload 6
    //   56: astore 5
    //   58: aload 6
    //   60: astore 7
    //   62: aload 8
    //   64: getfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   67: istore_3
    //   68: aload 6
    //   70: astore 5
    //   72: aload_0
    //   73: iload_3
    //   74: invokevirtual 276	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getGroup	(I)Lcom/tencent/mobileqq/data/Groups;
    //   77: astore 7
    //   79: aload 7
    //   81: ifnull +173 -> 254
    //   84: aload 6
    //   86: astore 5
    //   88: aload 7
    //   90: aload 7
    //   92: getfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   95: iconst_1
    //   96: isub
    //   97: putfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   100: aload 6
    //   102: astore 5
    //   104: aload_0
    //   105: aload 7
    //   107: invokevirtual 87	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveGroup	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   110: pop
    //   111: aload 6
    //   113: astore 5
    //   115: aload 8
    //   117: iload_2
    //   118: putfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   121: aload 6
    //   123: astore 5
    //   125: aload_0
    //   126: aload 8
    //   128: invokevirtual 280	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveFriend	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   131: pop
    //   132: aload 6
    //   134: astore 5
    //   136: aload_0
    //   137: iload_2
    //   138: invokevirtual 276	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getGroup	(I)Lcom/tencent/mobileqq/data/Groups;
    //   141: astore 7
    //   143: aload 7
    //   145: ifnull +160 -> 305
    //   148: aload 6
    //   150: astore 5
    //   152: aload 7
    //   154: aload 7
    //   156: getfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   159: iconst_1
    //   160: iadd
    //   161: putfield 83	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   164: aload 6
    //   166: astore 5
    //   168: aload_0
    //   169: aload 7
    //   171: invokevirtual 87	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:saveGroup	(Lcom/tencent/mobileqq/data/Groups;)Z
    //   174: pop
    //   175: aload 6
    //   177: astore 5
    //   179: aload 6
    //   181: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   184: iload_3
    //   185: istore 4
    //   187: aload 6
    //   189: ifnull +11 -> 200
    //   192: aload 6
    //   194: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   197: iload_3
    //   198: istore 4
    //   200: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq -196 -> 7
    //   206: ldc 10
    //   208: iconst_2
    //   209: new 101	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 282
    //   219: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 284
    //   229: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 4
    //   234: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: ldc_w 286
    //   240: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload_2
    //   244: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: aload 6
    //   256: astore 5
    //   258: ldc 10
    //   260: iconst_1
    //   261: ldc_w 288
    //   264: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: goto -167 -> 100
    //   270: astore 8
    //   272: aload 6
    //   274: astore 5
    //   276: ldc 10
    //   278: iconst_1
    //   279: ldc 122
    //   281: aload 8
    //   283: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   286: iload_3
    //   287: istore 4
    //   289: aload 6
    //   291: ifnull -91 -> 200
    //   294: aload 6
    //   296: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   299: iload_3
    //   300: istore 4
    //   302: goto -102 -> 200
    //   305: aload 6
    //   307: astore 5
    //   309: ldc 10
    //   311: iconst_1
    //   312: ldc_w 293
    //   315: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: goto -143 -> 175
    //   321: astore_1
    //   322: aload 5
    //   324: ifnull +8 -> 332
    //   327: aload 5
    //   329: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   332: aload_1
    //   333: athrow
    //   334: astore 8
    //   336: iconst_m1
    //   337: istore_3
    //   338: aload 7
    //   340: astore 6
    //   342: goto -70 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	FriendDataServiceImpl
    //   0	345	1	paramString	String
    //   0	345	2	paramInt	int
    //   67	271	3	i	int
    //   185	116	4	j	int
    //   12	316	5	localObject1	Object
    //   21	320	6	localObject2	Object
    //   9	330	7	localObject3	Object
    //   52	75	8	localFriends	Friends
    //   270	12	8	localException1	Exception
    //   334	1	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   72	79	270	java/lang/Exception
    //   88	100	270	java/lang/Exception
    //   104	111	270	java/lang/Exception
    //   115	121	270	java/lang/Exception
    //   125	132	270	java/lang/Exception
    //   136	143	270	java/lang/Exception
    //   152	164	270	java/lang/Exception
    //   168	175	270	java/lang/Exception
    //   179	184	270	java/lang/Exception
    //   258	267	270	java/lang/Exception
    //   309	318	270	java/lang/Exception
    //   14	23	321	finally
    //   31	36	321	finally
    //   44	54	321	finally
    //   62	68	321	finally
    //   72	79	321	finally
    //   88	100	321	finally
    //   104	111	321	finally
    //   115	121	321	finally
    //   125	132	321	finally
    //   136	143	321	finally
    //   152	164	321	finally
    //   168	175	321	finally
    //   179	184	321	finally
    //   258	267	321	finally
    //   276	286	321	finally
    //   309	318	321	finally
    //   14	23	334	java/lang/Exception
    //   31	36	334	java/lang/Exception
    //   44	54	334	java/lang/Exception
    //   62	68	334	java/lang/Exception
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
    //   11: ldc_w 297
    //   14: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: return
    //   18: aload_0
    //   19: getfield 35	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mGroupCache	Lcom/tencent/mobileqq/friend/cache/GroupCache;
    //   22: iload_2
    //   23: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokevirtual 239	com/tencent/mobileqq/friend/cache/GroupCache:b	(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/Groups;
    //   29: ifnonnull +35 -> 64
    //   32: ldc 10
    //   34: iconst_1
    //   35: new 101	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 299
    //   45: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_2
    //   49: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc_w 301
    //   55: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   68: iload_1
    //   69: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: invokevirtual 304	com/tencent/mobileqq/friend/cache/FriendCache:a	(Ljava/lang/Integer;)Ljava/util/List;
    //   75: astore 8
    //   77: aconst_null
    //   78: astore 5
    //   80: aload_0
    //   81: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   84: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   87: astore 6
    //   89: aload 6
    //   91: astore 5
    //   93: aload 6
    //   95: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   98: aload 8
    //   100: ifnull +149 -> 249
    //   103: aload 6
    //   105: astore 5
    //   107: aload 8
    //   109: invokeinterface 143 1 0
    //   114: astore 7
    //   116: aload 6
    //   118: astore 5
    //   120: aload 7
    //   122: invokeinterface 151 1 0
    //   127: ifeq +122 -> 249
    //   130: aload 6
    //   132: astore 5
    //   134: aload 7
    //   136: invokeinterface 155 1 0
    //   141: checkcast 70	com/tencent/mobileqq/data/Friends
    //   144: astore 9
    //   146: aload 6
    //   148: astore 5
    //   150: aload 9
    //   152: iload_2
    //   153: putfield 74	com/tencent/mobileqq/data/Friends:groupid	I
    //   156: aload 6
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   164: aload 9
    //   166: invokevirtual 306	com/tencent/mobileqq/friend/cache/FriendCache:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   169: pop
    //   170: goto -54 -> 116
    //   173: astore 7
    //   175: aload 6
    //   177: astore 5
    //   179: aload 7
    //   181: astore 6
    //   183: ldc 10
    //   185: iconst_1
    //   186: ldc_w 307
    //   189: aload 6
    //   191: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: aload 5
    //   196: ifnull +205 -> 401
    //   199: aload 5
    //   201: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   204: iconst_0
    //   205: istore_3
    //   206: aload 8
    //   208: invokeinterface 143 1 0
    //   213: astore 5
    //   215: aload 5
    //   217: invokeinterface 151 1 0
    //   222: ifeq +94 -> 316
    //   225: aload 5
    //   227: invokeinterface 155 1 0
    //   232: checkcast 70	com/tencent/mobileqq/data/Friends
    //   235: astore 6
    //   237: aload_0
    //   238: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   241: aload 6
    //   243: invokevirtual 217	com/tencent/mobileqq/friend/cache/FriendCache:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   246: goto -31 -> 215
    //   249: aload 6
    //   251: astore 5
    //   253: aload_0
    //   254: getfield 35	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mGroupCache	Lcom/tencent/mobileqq/friend/cache/GroupCache;
    //   257: iload_1
    //   258: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: invokevirtual 309	com/tencent/mobileqq/friend/cache/GroupCache:c	(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/Groups;
    //   264: pop
    //   265: aload 6
    //   267: astore 5
    //   269: aload 6
    //   271: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   274: iload 4
    //   276: istore_3
    //   277: aload 6
    //   279: ifnull -73 -> 206
    //   282: aload 6
    //   284: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   287: iload 4
    //   289: istore_3
    //   290: goto -84 -> 206
    //   293: astore 7
    //   295: aload 5
    //   297: astore 6
    //   299: aload 7
    //   301: astore 5
    //   303: aload 6
    //   305: ifnull +8 -> 313
    //   308: aload 6
    //   310: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   313: aload 5
    //   315: athrow
    //   316: aload_0
    //   317: getfield 35	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mGroupCache	Lcom/tencent/mobileqq/friend/cache/GroupCache;
    //   320: iload_1
    //   321: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: invokevirtual 311	com/tencent/mobileqq/friend/cache/GroupCache:a	(Ljava/lang/Integer;)Lcom/tencent/mobileqq/data/Groups;
    //   327: pop
    //   328: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq -314 -> 17
    //   334: ldc 10
    //   336: iconst_2
    //   337: new 101	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 313
    //   347: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload_1
    //   351: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: ldc_w 315
    //   357: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: iload_2
    //   361: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: ldc 110
    //   366: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: iload_3
    //   370: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   373: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: return
    //   380: astore 7
    //   382: aload 5
    //   384: astore 6
    //   386: aload 7
    //   388: astore 5
    //   390: goto -87 -> 303
    //   393: astore 6
    //   395: aconst_null
    //   396: astore 5
    //   398: goto -215 -> 183
    //   401: iconst_0
    //   402: istore_3
    //   403: goto -197 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	FriendDataServiceImpl
    //   0	406	1	paramInt1	int
    //   0	406	2	paramInt2	int
    //   205	198	3	bool1	boolean
    //   1	287	4	bool2	boolean
    //   78	319	5	localObject1	Object
    //   87	298	6	localObject2	Object
    //   393	1	6	localException1	Exception
    //   114	21	7	localIterator	Iterator
    //   173	7	7	localException2	Exception
    //   293	7	7	localObject3	Object
    //   380	7	7	localObject4	Object
    //   75	132	8	localList	List
    //   144	21	9	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   93	98	173	java/lang/Exception
    //   107	116	173	java/lang/Exception
    //   120	130	173	java/lang/Exception
    //   134	146	173	java/lang/Exception
    //   150	156	173	java/lang/Exception
    //   160	170	173	java/lang/Exception
    //   253	265	173	java/lang/Exception
    //   269	274	173	java/lang/Exception
    //   80	89	293	finally
    //   93	98	293	finally
    //   107	116	293	finally
    //   120	130	293	finally
    //   134	146	293	finally
    //   150	156	293	finally
    //   160	170	293	finally
    //   253	265	293	finally
    //   269	274	293	finally
    //   183	194	380	finally
    //   80	89	393	java/lang/Exception
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mEntityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    this.mGroupCache = new GroupCache(this.mEntityManager);
    this.mFriendCache = new FriendCache(this.mEntityManager);
  }
  
  public void onDestroy()
  {
    this.mFriendCache.b();
    this.mGroupCache.b();
  }
  
  public List<Friends> preloadPartFriendCache(List<String> paramList)
  {
    return this.mFriendCache.a(paramList);
  }
  
  public boolean saveFriend(Friends paramFriends)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "saveFriend: " + paramFriends);
    }
    if (paramFriends == null) {
      return false;
    }
    if ((paramFriends.mCompareSpell == null) || (paramFriends.mCompareSpell.length() == 0)) {
      FriendSorter.a(paramFriends);
    }
    this.mFriendCache.a(paramFriends);
    return this.mFriendCache.a(paramFriends);
  }
  
  public void saveFriendCache(Friends paramFriends)
  {
    if (paramFriends == null) {
      return;
    }
    if ((paramFriends.mCompareSpell == null) || (paramFriends.mCompareSpell.length() == 0)) {
      FriendSorter.a(paramFriends);
    }
    this.mFriendCache.a(paramFriends);
  }
  
  public boolean saveFriendList(List<Friends> paramList)
  {
    boolean bool1;
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("IMCore.friend.FriendDataServiceImpl", 1, "saveFriendList| friendList is empty!");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Friends localFriends = (Friends)localIterator.next();
        if (localFriends == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "saveFriendList, friend == null");
          }
        }
        else
        {
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            FriendSorter.a(localFriends);
          }
          this.mFriendCache.a(localFriends);
        }
      }
      bool2 = this.mFriendCache.a(paramList);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "saveFriendList| isSuccess = " + bool2 + ", size = " + paramList.size());
    return bool2;
  }
  
  /* Error */
  public boolean saveFriendList(List<Friends> paramList, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: aload_1
    //   6: ifnull +12 -> 18
    //   9: aload_1
    //   10: invokeinterface 139 1 0
    //   15: ifne +18 -> 33
    //   18: ldc 10
    //   20: iconst_1
    //   21: ldc_w 356
    //   24: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: iconst_0
    //   28: istore 6
    //   30: iload 6
    //   32: ireturn
    //   33: aconst_null
    //   34: astore 11
    //   36: aload_0
    //   37: getfield 48	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: invokevirtual 54	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   43: astore 12
    //   45: aload 12
    //   47: astore 11
    //   49: aload 12
    //   51: invokevirtual 59	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   54: aload 12
    //   56: astore 11
    //   58: aload_1
    //   59: invokeinterface 143 1 0
    //   64: astore 13
    //   66: aload 12
    //   68: astore 11
    //   70: aload 13
    //   72: invokeinterface 151 1 0
    //   77: ifeq +245 -> 322
    //   80: aload 12
    //   82: astore 11
    //   84: aload 13
    //   86: invokeinterface 155 1 0
    //   91: checkcast 70	com/tencent/mobileqq/data/Friends
    //   94: astore 14
    //   96: aload 14
    //   98: ifnonnull +145 -> 243
    //   101: aload 12
    //   103: astore 11
    //   105: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq -42 -> 66
    //   111: aload 12
    //   113: astore 11
    //   115: ldc 10
    //   117: iconst_2
    //   118: ldc_w 358
    //   121: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: goto -58 -> 66
    //   127: astore 13
    //   129: aload 12
    //   131: astore 11
    //   133: aload 13
    //   135: astore 12
    //   137: ldc 10
    //   139: iconst_1
    //   140: ldc 122
    //   142: aload 12
    //   144: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload 11
    //   149: ifnull +322 -> 471
    //   152: aload 11
    //   154: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   157: iconst_0
    //   158: istore 5
    //   160: iload 5
    //   162: istore 6
    //   164: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq -137 -> 30
    //   170: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   173: lstore 9
    //   175: ldc 10
    //   177: iconst_2
    //   178: new 101	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 374
    //   188: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: invokeinterface 139 1 0
    //   197: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc_w 376
    //   203: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload_2
    //   207: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   210: ldc_w 378
    //   213: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: lload_3
    //   217: invokevirtual 381	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   220: ldc_w 383
    //   223: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: lload 9
    //   228: lload 7
    //   230: lsub
    //   231: invokevirtual 381	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   234: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: iload 5
    //   242: ireturn
    //   243: aload 12
    //   245: astore 11
    //   247: aload 14
    //   249: getfield 345	com/tencent/mobileqq/data/Friends:mCompareSpell	Ljava/lang/String;
    //   252: ifnull +18 -> 270
    //   255: aload 12
    //   257: astore 11
    //   259: aload 14
    //   261: getfield 345	com/tencent/mobileqq/data/Friends:mCompareSpell	Ljava/lang/String;
    //   264: invokevirtual 348	java/lang/String:length	()I
    //   267: ifne +12 -> 279
    //   270: aload 12
    //   272: astore 11
    //   274: aload 14
    //   276: invokestatic 351	com/tencent/mobileqq/friend/utils/FriendSorter:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   279: aload 12
    //   281: astore 11
    //   283: aload_0
    //   284: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   287: aload 14
    //   289: invokevirtual 217	com/tencent/mobileqq/friend/cache/FriendCache:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   292: aload 12
    //   294: astore 11
    //   296: aload_0
    //   297: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   300: aload 14
    //   302: invokevirtual 306	com/tencent/mobileqq/friend/cache/FriendCache:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   305: pop
    //   306: goto -240 -> 66
    //   309: astore_1
    //   310: aload 11
    //   312: ifnull +8 -> 320
    //   315: aload 11
    //   317: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   320: aload_1
    //   321: athrow
    //   322: iload_2
    //   323: ifeq +111 -> 434
    //   326: aload 12
    //   328: astore 11
    //   330: aload_0
    //   331: invokevirtual 230	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:getAllFriends	()Ljava/util/List;
    //   334: invokeinterface 143 1 0
    //   339: astore 13
    //   341: aload 12
    //   343: astore 11
    //   345: aload 13
    //   347: invokeinterface 151 1 0
    //   352: ifeq +82 -> 434
    //   355: aload 12
    //   357: astore 11
    //   359: aload 13
    //   361: invokeinterface 155 1 0
    //   366: checkcast 70	com/tencent/mobileqq/data/Friends
    //   369: astore 14
    //   371: aload 12
    //   373: astore 11
    //   375: aload 14
    //   377: getfield 387	com/tencent/mobileqq/data/Friends:datetime	J
    //   380: lload_3
    //   381: lcmp
    //   382: ifge -41 -> 341
    //   385: aload 12
    //   387: astore 11
    //   389: aload 14
    //   391: invokevirtual 158	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   394: ifeq -53 -> 341
    //   397: aload 12
    //   399: astore 11
    //   401: aload_0
    //   402: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   405: aload 14
    //   407: getfield 168	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   410: invokevirtual 65	com/tencent/mobileqq/friend/cache/FriendCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   413: pop
    //   414: aload 12
    //   416: astore 11
    //   418: aload_0
    //   419: getfield 61	com/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl:mFriendCache	Lcom/tencent/mobileqq/friend/cache/FriendCache;
    //   422: aload 14
    //   424: getfield 168	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   427: invokevirtual 68	com/tencent/mobileqq/friend/cache/FriendCache:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   430: pop
    //   431: goto -90 -> 341
    //   434: aload 12
    //   436: astore 11
    //   438: aload 12
    //   440: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   443: aload 12
    //   445: ifnull +32 -> 477
    //   448: aload 12
    //   450: invokevirtual 93	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   453: iconst_1
    //   454: istore 5
    //   456: goto -296 -> 160
    //   459: astore_1
    //   460: goto -150 -> 310
    //   463: astore 12
    //   465: aconst_null
    //   466: astore 11
    //   468: goto -331 -> 137
    //   471: iconst_0
    //   472: istore 5
    //   474: goto -314 -> 160
    //   477: iconst_1
    //   478: istore 5
    //   480: goto -320 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	FriendDataServiceImpl
    //   0	483	1	paramList	List<Friends>
    //   0	483	2	paramBoolean	boolean
    //   0	483	3	paramLong	long
    //   158	321	5	bool1	boolean
    //   28	135	6	bool2	boolean
    //   3	226	7	l1	long
    //   173	54	9	l2	long
    //   34	433	11	localObject1	Object
    //   43	406	12	localObject2	Object
    //   463	1	12	localException1	Exception
    //   64	21	13	localIterator1	Iterator
    //   127	7	13	localException2	Exception
    //   339	21	13	localIterator2	Iterator
    //   94	329	14	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   49	54	127	java/lang/Exception
    //   58	66	127	java/lang/Exception
    //   70	80	127	java/lang/Exception
    //   84	96	127	java/lang/Exception
    //   105	111	127	java/lang/Exception
    //   115	124	127	java/lang/Exception
    //   247	255	127	java/lang/Exception
    //   259	270	127	java/lang/Exception
    //   274	279	127	java/lang/Exception
    //   283	292	127	java/lang/Exception
    //   296	306	127	java/lang/Exception
    //   330	341	127	java/lang/Exception
    //   345	355	127	java/lang/Exception
    //   359	371	127	java/lang/Exception
    //   375	385	127	java/lang/Exception
    //   389	397	127	java/lang/Exception
    //   401	414	127	java/lang/Exception
    //   418	431	127	java/lang/Exception
    //   438	443	127	java/lang/Exception
    //   36	45	309	finally
    //   49	54	309	finally
    //   58	66	309	finally
    //   70	80	309	finally
    //   84	96	309	finally
    //   105	111	309	finally
    //   115	124	309	finally
    //   247	255	309	finally
    //   259	270	309	finally
    //   274	279	309	finally
    //   283	292	309	finally
    //   296	306	309	finally
    //   330	341	309	finally
    //   345	355	309	finally
    //   359	371	309	finally
    //   375	385	309	finally
    //   389	397	309	finally
    //   401	414	309	finally
    //   418	431	309	finally
    //   438	443	309	finally
    //   137	147	459	finally
    //   36	45	463	java/lang/Exception
  }
  
  public boolean saveGroup(Groups paramGroups)
  {
    boolean bool1;
    if (paramGroups == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.mGroupCache.a(paramGroups);
      if (bool2) {
        this.mGroupCache.a(paramGroups);
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "updateGroup| isSuccess: " + bool2 + ", group: " + paramGroups);
    return bool2;
  }
  
  public boolean saveGroupList(List<Groups> paramList)
  {
    boolean bool1;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.d("IMCore.friend.FriendDataServiceImpl", 1, "updateGroupList| groupList == null");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.mGroupCache.a(paramList);
      if (bool2) {
        this.mGroupCache.a(paramList);
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "updateGroupList| isSuccess: " + bool2 + ", groupList: " + paramList);
    return bool2;
  }
  
  public void updateGroupSortIds(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length != paramArrayOfByte2.length))
    {
      QLog.e("IMCore.friend.FriendDataServiceImpl", 1, "updateGroupSortIds| params error!");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      int i;
      try
      {
        EntityTransaction localEntityTransaction = this.mEntityManager.getTransaction();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.begin();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localArrayList = new ArrayList();
        i = 0;
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (i < paramArrayOfByte1.length)
        {
          int j = paramArrayOfByte1[i];
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          Groups localGroups = getGroup(j, true);
          if (localGroups != null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            if (localGroups.seqid != paramArrayOfByte2[i])
            {
              localObject1 = localEntityTransaction;
              localObject2 = localEntityTransaction;
              localGroups.seqid = paramArrayOfByte2[i];
            }
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            saveGroup(localGroups);
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localArrayList.add(localGroups);
          }
          else
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            QLog.d("IMCore.friend.FriendDataServiceImpl", 1, "updateGroupSortIds| group not exist, groupId: " + j);
          }
        }
      }
      catch (Exception localException)
      {
        ArrayList localArrayList;
        localObject2 = localObject1;
        QLog.d("IMCore.friend.FriendDataServiceImpl", 1, "deleteFriend", localException);
        if (localObject1 != null) {
          localObject1.end();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IMCore.friend.FriendDataServiceImpl", 2, "updateGroupSortIds| groupIds: " + paramArrayOfByte1 + ", sortIds: " + paramArrayOfByte2);
        return;
        localObject1 = localException;
        localObject2 = localException;
        this.mGroupCache.a(localArrayList);
        localObject1 = localException;
        localObject2 = localException;
        localException.commit();
        if (localException == null) {
          continue;
        }
        localException.end();
        continue;
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.end();
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */