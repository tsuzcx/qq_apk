package com.tencent.mobileqq.model;

import aeiv;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class TroopInfoManager
  extends Observable
  implements Manager
{
  protected LruCache a;
  protected QQAppInterface a;
  protected EntityManager a;
  private HashMap a;
  protected List a;
  protected ConcurrentHashMap a;
  protected boolean a;
  protected ConcurrentHashMap b;
  protected ConcurrentHashMap c;
  protected ConcurrentHashMap d;
  protected ConcurrentHashMap e;
  protected ConcurrentHashMap f;
  protected ConcurrentHashMap g;
  
  /* Error */
  public TroopInfoManager(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: new 27	java/util/HashMap
    //   8: dup
    //   9: invokespecial 28	java/util/HashMap:<init>	()V
    //   12: putfield 30	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   15: aload_0
    //   16: new 32	java/util/concurrent/ConcurrentHashMap
    //   19: dup
    //   20: invokespecial 33	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   23: putfield 35	com/tencent/mobileqq/model/TroopInfoManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: aload_0
    //   27: aload_1
    //   28: putfield 37	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 43	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   36: invokevirtual 49	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: putfield 51	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: aload_0
    //   43: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   46: ifnonnull +25 -> 71
    //   49: aload_0
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   55: ifnonnull +14 -> 69
    //   58: aload_0
    //   59: new 32	java/util/concurrent/ConcurrentHashMap
    //   62: dup
    //   63: invokespecial 33	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   66: putfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_0
    //   72: getfield 55	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: ifnonnull +25 -> 100
    //   78: aload_0
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 55	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   84: ifnonnull +14 -> 98
    //   87: aload_0
    //   88: new 32	java/util/concurrent/ConcurrentHashMap
    //   91: dup
    //   92: invokespecial 33	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   95: putfield 55	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: getfield 57	com/tencent/mobileqq/model/TroopInfoManager:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   104: ifnonnull +25 -> 129
    //   107: aload_0
    //   108: monitorenter
    //   109: aload_0
    //   110: getfield 57	com/tencent/mobileqq/model/TroopInfoManager:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: ifnonnull +14 -> 127
    //   116: aload_0
    //   117: new 32	java/util/concurrent/ConcurrentHashMap
    //   120: dup
    //   121: invokespecial 33	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   124: putfield 57	com/tencent/mobileqq/model/TroopInfoManager:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_0
    //   130: getfield 59	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   133: ifnonnull +27 -> 160
    //   136: aload_0
    //   137: monitorenter
    //   138: aload_0
    //   139: getfield 59	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   142: ifnonnull +16 -> 158
    //   145: aload_0
    //   146: new 61	android/support/v4/util/LruCache
    //   149: dup
    //   150: bipush 10
    //   152: invokespecial 64	android/support/v4/util/LruCache:<init>	(I)V
    //   155: putfield 59	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_0
    //   161: invokevirtual 66	com/tencent/mobileqq/model/TroopInfoManager:b	()V
    //   164: return
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	TroopInfoManager
    //   0	185	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   51	69	165	finally
    //   69	71	165	finally
    //   166	168	165	finally
    //   80	98	170	finally
    //   98	100	170	finally
    //   171	173	170	finally
    //   109	127	175	finally
    //   127	129	175	finally
    //   176	178	175	finally
    //   138	158	180	finally
    //   158	160	180	finally
    //   181	183	180	finally
  }
  
  private void c()
  {
    for (;;)
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo;
      Object localObject4;
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        Object localObject1;
        Iterator localIterator;
        if (bool == true) {}else
        {
          this.jdField_a_of_type_Boolean = true;
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
          if (localObject1 == null) {
            continue;
          }
          localIterator = ((ArrayList)localObject1).iterator();
        }
        if (!localIterator.hasNext()) {
          continue;
        }
        localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator.next();
        if ((localTroopMessageNavigateInfo == null) || (TextUtils.isEmpty(localTroopMessageNavigateInfo.troopCode))) {
          continue;
        }
        localObject4 = (List)this.c.get(localTroopMessageNavigateInfo.troopCode);
        if (this.c.containsKey(localTroopMessageNavigateInfo.troopCode))
        {
          localObject1 = ((List)localObject4).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (TroopMessageNavigateInfo)((Iterator)localObject1).next();
            if ((localObject4 == null) || (((TroopMessageNavigateInfo)localObject4).status != TroopMessageNavigateInfo.STATUS_ADD)) {
              continue;
            }
            ((TroopMessageNavigateInfo)localObject4).status = TroopMessageNavigateInfo.STATUS_MODIFY;
            continue;
          }
          continue;
        }
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_NORMAL;
      }
      finally {}
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      ((List)localObject3).add(localTroopMessageNavigateInfo);
      e(localTroopMessageNavigateInfo.troopCode);
      this.c.put(localTroopMessageNavigateInfo.troopCode, localObject3);
    }
  }
  
  private void d()
  {
    for (;;)
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo;
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          c();
        }
        Iterator localIterator = this.c.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = localIterator.next();
        if (!(localObject2 instanceof List)) {
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)((Iterator)localObject2).next();
          if (localTroopMessageNavigateInfo == null) {
            continue;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
          }
        }
        else
        {
          continue;
        }
        if (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_MODIFY) {
          break label157;
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
      continue;
      label157:
      if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE)
      {
        this.c.remove(localTroopMessageNavigateInfo.troopCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
      }
    }
  }
  
  /* Error */
  private void e(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +16 -> 22
    //   9: aload_0
    //   10: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_1
    //   14: invokevirtual 117	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: aload_1
    //   30: invokevirtual 111	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 113	java/util/List
    //   36: new 169	com/tencent/mobileqq/model/TroopInfoManager$NavigationMsgComparator
    //   39: dup
    //   40: invokespecial 170	com/tencent/mobileqq/model/TroopInfoManager$NavigationMsgComparator:<init>	()V
    //   43: invokestatic 176	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   46: goto -24 -> 22
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	TroopInfoManager
    //   0	54	1	paramString	String
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	49	finally
    //   25	46	49	finally
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_Boolean	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokespecial 70	com/tencent/mobileqq/model/TroopInfoManager:c	()V
    //   13: aload_0
    //   14: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: ifnull +102 -> 119
    //   20: aload_0
    //   21: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_1
    //   25: invokevirtual 117	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifeq +91 -> 119
    //   31: aload_0
    //   32: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 111	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 113	java/util/List
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +16 -> 60
    //   47: aload_1
    //   48: invokeinterface 179 1 0
    //   53: istore 4
    //   55: iload 4
    //   57: ifeq +9 -> 66
    //   60: iconst_m1
    //   61: istore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: iload_2
    //   65: ireturn
    //   66: aload_1
    //   67: invokeinterface 183 1 0
    //   72: istore_3
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: iload_3
    //   77: if_icmpge +42 -> 119
    //   80: aload_1
    //   81: iload_2
    //   82: invokeinterface 186 2 0
    //   87: checkcast 74	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   90: astore 5
    //   92: aload 5
    //   94: getfield 122	com/tencent/mobileqq/data/TroopMessageNavigateInfo:status	I
    //   97: getstatic 164	com/tencent/mobileqq/data/TroopMessageNavigateInfo:STATUS_DELETE	I
    //   100: if_icmpne +10 -> 110
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -32 -> 75
    //   110: aload 5
    //   112: getfield 189	com/tencent/mobileqq/data/TroopMessageNavigateInfo:type	I
    //   115: istore_2
    //   116: goto -54 -> 62
    //   119: iconst_m1
    //   120: istore_2
    //   121: goto -59 -> 62
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	TroopInfoManager
    //   0	129	1	paramString	String
    //   61	60	2	i	int
    //   72	6	3	j	int
    //   53	3	4	bool	boolean
    //   90	21	5	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    // Exception table:
    //   from	to	target	type
    //   2	13	124	finally
    //   13	43	124	finally
    //   47	55	124	finally
    //   66	73	124	finally
    //   80	103	124	finally
    //   110	116	124	finally
  }
  
  /* Error */
  public long a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 191	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 30	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 194	java/lang/Long
    //   24: invokevirtual 198	java/lang/Long:longValue	()J
    //   27: lstore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: lload_2
    //   31: lreturn
    //   32: ldc2_w 199
    //   35: lstore_2
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	TroopInfoManager
    //   0	44	1	paramString	String
    //   27	9	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	28	39	finally
  }
  
  public MessageInfo a(String paramString)
  {
    return (MessageInfo)this.g.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update__:" + paramString + " " + paramMessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramString) + " " + paramMessageInfo.a() + " " + paramMessageInfo.b());
    }
    MessageInfo localMessageInfo2 = (MessageInfo)this.g.get(paramString);
    MessageInfo localMessageInfo1 = localMessageInfo2;
    if (paramMessageInfo != null)
    {
      if (paramMessageInfo.a()) {
        break label105;
      }
      localMessageInfo1 = localMessageInfo2;
    }
    label105:
    do
    {
      do
      {
        return localMessageInfo1;
        if (localMessageInfo2 != null) {
          break;
        }
        paramMessageInfo = new MessageInfo(paramMessageInfo);
        this.g.put(paramString, paramMessageInfo);
        localMessageInfo1 = paramMessageInfo;
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: put:" + paramString);
      return paramMessageInfo;
      localMessageInfo2.a(paramMessageInfo);
      localMessageInfo1 = localMessageInfo2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update:" + paramString);
    return localMessageInfo2;
  }
  
  public TroopFeedsDataManager a(Long paramLong, boolean paramBoolean)
  {
    if (this.f == null) {
      this.f = new ConcurrentHashMap();
    }
    TroopFeedsDataManager localTroopFeedsDataManager2 = (TroopFeedsDataManager)this.f.get(paramLong);
    TroopFeedsDataManager localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
    if (localTroopFeedsDataManager2 == null)
    {
      localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
      if (paramBoolean)
      {
        localTroopFeedsDataManager1 = new TroopFeedsDataManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.f.put(paramLong, localTroopFeedsDataManager1);
      }
    }
    return localTroopFeedsDataManager1;
  }
  
  public ArrayList a(String paramString)
  {
    return (ArrayList)this.b.get(paramString);
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List a(String paramString, int paramInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localArrayList = new ArrayList();
        if (!this.jdField_a_of_type_Boolean) {
          c();
        }
        localStringBuilder = new StringBuilder("getMultiNatigateSeqList, troopUin:");
        localStringBuilder.append(paramString).append("| type:").append(paramInt).append("| seqList:");
        if ((this.c != null) && (this.c.containsKey(paramString)))
        {
          paramString = (List)this.c.get(paramString);
          if (paramString != null)
          {
            boolean bool = paramString.isEmpty();
            if (!bool) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
          int j = paramString.size();
          i = 0;
          if (i < j)
          {
            TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i);
            if ((localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE) || (localTroopMessageNavigateInfo.type != paramInt)) {
              break label226;
            }
            localArrayList.add(Long.valueOf(localTroopMessageNavigateInfo.msgseq));
            localStringBuilder.append(localTroopMessageNavigateInfo.msgseq).append(",");
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("TroopInfoManager.troop.special_msg.special_attention", 2, localStringBuilder.toString());
      }
      paramString = localArrayList;
      continue;
      label226:
      i += 1;
    }
  }
  
  public ConcurrentHashMap a()
  {
    if (this.e == null) {
      return null;
    }
    return this.e;
  }
  
  public void a()
  {
    if (this.e == null) {
      return;
    }
    this.e.clear();
  }
  
  public void a(Long paramLong)
  {
    if (this.f == null) {
      return;
    }
    this.f.remove(paramLong);
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopAppInfo);
  }
  
  public void a(String paramString)
  {
    if (this.d == null) {}
    try
    {
      if (this.d == null) {
        this.d = new ConcurrentHashMap();
      }
      this.d.put(paramString, Boolean.valueOf(true));
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      List localList;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopInfoManager.troop.special_msg", 2, "clearTroopMsgNavigateInfo, troopCode:" + paramString + "|type:" + paramInt);
        }
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if ((this.c == null) || (!this.c.containsKey(paramString))) {
          continue;
        }
        localList = (List)this.c.get(paramString);
        if ((localList == null) || (localList.isEmpty())) {
          continue;
        }
        i = localList.size() - 1;
        if (i >= 0)
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localList.get(i);
          if ((paramInt != localTroopMessageNavigateInfo.type) && (paramInt != 0)) {
            break label206;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD) {
            localList.remove(i);
          } else {
            localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
          }
        }
      }
      finally {}
      if (localList.isEmpty())
      {
        this.c.remove(paramString);
        continue;
        label206:
        i -= 1;
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2)
  {
    Object localObject = null;
    if (paramInt1 <= 0) {
      return;
    }
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    List localList;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopInfoManager", 2, "addTroopMsgNavigateInfo,type:" + paramInt1 + "|seq:" + paramLong + "|summary:" + paramString2 + "|troopCode:" + paramString1);
        }
        localTroopMessageNavigateInfo = new TroopMessageNavigateInfo();
        localTroopMessageNavigateInfo.type = paramInt1;
        localTroopMessageNavigateInfo.troopCode = paramString1;
        localTroopMessageNavigateInfo.msgseq = paramLong;
        localTroopMessageNavigateInfo.summary = paramString2;
        if (!this.c.containsKey(paramString1)) {
          break label437;
        }
        localList = (List)this.c.get(paramString1);
        if ((localList == null) || (localList.size() == 0)) {
          break;
        }
        if ((paramInt1 == 15) || (paramInt1 == 21))
        {
          paramString2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (paramString2 == null)
          {
            paramString2 = null;
            if ((paramString2 != null) && (paramString2.hasOrgs()))
            {
              i = localList.size() - 1;
              label207:
              if (i >= 0)
              {
                paramString2 = (TroopMessageNavigateInfo)localList.get(i);
                if (paramInt1 == paramString2.type) {
                  break label494;
                }
                paramString2.status = TroopMessageNavigateInfo.STATUS_DELETE;
                break label494;
              }
            }
          }
          else
          {
            paramString2 = paramString2.a(paramString1);
            continue;
          }
        }
        if (paramInt1 == 15)
        {
          localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
          label271:
          localList.add(localTroopMessageNavigateInfo);
          e(paramString1);
          break;
        }
      }
      finally {}
      if (paramInt1 != 10) {
        break label311;
      }
      localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
    }
    label311:
    int i = localList.size() - 1;
    paramString2 = localObject;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramInt1 == ((TroopMessageNavigateInfo)localList.get(i)).type)
        {
          paramString2 = (TroopMessageNavigateInfo)localList.remove(i);
          break label503;
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.status == TroopMessageNavigateInfo.STATUS_DELETE))
        {
          localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
          if (paramInt1 != 24) {
            break label271;
          }
          localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
          break label271;
        }
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
        if (paramInt1 != 24) {
          break label271;
        }
        paramString2.receivedFlowserCount += paramInt2;
        break label271;
        label437:
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
        if (paramInt1 == 24) {
          localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
        }
        paramString2 = new ArrayList();
        paramString2.add(localTroopMessageNavigateInfo);
        this.c.put(paramString1, paramString2);
        break;
      }
      break label503;
      label494:
      i -= 1;
      break label207;
      label503:
      i -= 1;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (this.e == null) {}
    try
    {
      if (this.e == null) {
        this.e = new ConcurrentHashMap();
      }
      this.e.put(paramString, paramObject);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    this.b.put(paramString, paramArrayList);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Base64Util.encodeToString(paramArrayOfByte, 2));
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (this.d == null) {}
    while (!this.d.containsKey(paramString)) {
      return false;
    }
    return ((Boolean)this.d.get(paramString)).booleanValue();
  }
  
  public byte[] a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  public long b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_Boolean	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokespecial 70	com/tencent/mobileqq/model/TroopInfoManager:c	()V
    //   13: aload_0
    //   14: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: ifnull +105 -> 122
    //   20: aload_0
    //   21: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_1
    //   25: invokevirtual 117	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifeq +94 -> 122
    //   31: aload_0
    //   32: getfield 53	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 111	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 113	java/util/List
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +16 -> 60
    //   47: aload_1
    //   48: invokeinterface 179 1 0
    //   53: istore 4
    //   55: iload 4
    //   57: ifeq +11 -> 68
    //   60: lconst_0
    //   61: lstore 5
    //   63: aload_0
    //   64: monitorexit
    //   65: lload 5
    //   67: lreturn
    //   68: aload_1
    //   69: invokeinterface 183 1 0
    //   74: istore_3
    //   75: iconst_0
    //   76: istore_2
    //   77: iload_2
    //   78: iload_3
    //   79: if_icmpge +43 -> 122
    //   82: aload_1
    //   83: iload_2
    //   84: invokeinterface 186 2 0
    //   89: checkcast 74	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   92: astore 7
    //   94: aload 7
    //   96: getfield 122	com/tencent/mobileqq/data/TroopMessageNavigateInfo:status	I
    //   99: getstatic 164	com/tencent/mobileqq/data/TroopMessageNavigateInfo:STATUS_DELETE	I
    //   102: if_icmpne +10 -> 112
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -32 -> 77
    //   112: aload 7
    //   114: getfield 280	com/tencent/mobileqq/data/TroopMessageNavigateInfo:msgseq	J
    //   117: lstore 5
    //   119: goto -56 -> 63
    //   122: lconst_0
    //   123: lstore 5
    //   125: goto -62 -> 63
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	TroopInfoManager
    //   0	133	1	paramString	String
    //   76	33	2	i	int
    //   74	6	3	j	int
    //   53	3	4	bool	boolean
    //   61	63	5	l	long
    //   92	21	7	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    // Exception table:
    //   from	to	target	type
    //   2	13	128	finally
    //   13	43	128	finally
    //   47	55	128	finally
    //   68	75	128	finally
    //   82	105	128	finally
    //   112	119	128	finally
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.g.remove(paramString);
  }
  
  protected void b()
  {
    ThreadManager.post(new aeiv(this), 8, null, false);
  }
  
  public void b(String paramString)
  {
    if (this.d == null) {
      return;
    }
    this.d.remove(paramString);
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramString == null)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str != null) && (str.equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
  }
  
  public void onDestroy()
  {
    d();
    if (this.f != null)
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFeedsDataManager localTroopFeedsDataManager = (TroopFeedsDataManager)localIterator.next();
        if (localTroopFeedsDataManager != null) {
          localTroopFeedsDataManager.deleteObservers();
        }
      }
      this.f.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.TroopInfoManager
 * JD-Core Version:    0.7.0.1
 */