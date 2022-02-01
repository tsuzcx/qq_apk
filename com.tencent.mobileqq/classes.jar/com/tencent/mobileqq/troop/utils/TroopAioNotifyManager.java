package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.mobileqq.troop.troopnotification.api.ITroopAioNotifyHandler;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TroopAioNotifyManager
{
  /* Error */
  public static List<TroopAIONotifyItem> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 15	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 16	java/util/ArrayList:<init>	()V
    //   10: astore_3
    //   11: aload_0
    //   12: invokevirtual 22	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   15: invokevirtual 28	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: astore_0
    //   19: iconst_0
    //   20: istore_2
    //   21: aload_0
    //   22: ldc 30
    //   24: iconst_0
    //   25: ldc 32
    //   27: iconst_1
    //   28: anewarray 34	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 43	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   47: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +48 -> 98
    //   53: new 51	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   60: astore_0
    //   61: aload_0
    //   62: ldc 54
    //   64: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: ifnonnull +6 -> 75
    //   72: goto +10 -> 82
    //   75: aload_1
    //   76: invokeinterface 64 1 0
    //   81: istore_2
    //   82: aload_0
    //   83: iload_2
    //   84: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 69
    //   90: iconst_2
    //   91: aload_0
    //   92: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_1
    //   99: ifnull +49 -> 148
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_1
    //   106: areturn
    //   107: astore_0
    //   108: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +37 -> 148
    //   114: new 51	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   121: astore_1
    //   122: aload_1
    //   123: ldc 79
    //   125: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_1
    //   130: aload_0
    //   131: invokevirtual 80	java/lang/Exception:toString	()Ljava/lang/String;
    //   134: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: ldc 69
    //   140: iconst_2
    //   141: aload_1
    //   142: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: ldc 2
    //   150: monitorexit
    //   151: aload_3
    //   152: areturn
    //   153: astore_0
    //   154: ldc 2
    //   156: monitorexit
    //   157: aload_0
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramQQAppInterface	QQAppInterface
    //   0	159	1	paramString	String
    //   20	64	2	i	int
    //   10	142	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   11	19	107	java/lang/Exception
    //   21	68	107	java/lang/Exception
    //   75	82	107	java/lang/Exception
    //   82	98	107	java/lang/Exception
    //   3	11	153	finally
    //   11	19	153	finally
    //   21	68	153	finally
    //   75	82	153	finally
    //   82	98	153	finally
    //   108	148	153	finally
  }
  
  public static List<TroopAIONotifyItem> a(QQAppInterface paramQQAppInterface, List<TroopAIONotifyItem> paramList1, List<TroopAIONotifyItem> paramList2)
  {
    try
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      j = 0;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        int j;
        Object localObject1;
        Object localObject2;
        long l;
        boolean bool2;
        TroopAIONotifyItem localTroopAIONotifyItem;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramQQAppInterface;
        }
        int k = 1;
        label789:
        j += 1;
        int i = k;
        continue;
        label801:
        boolean bool1 = false;
        label804:
        if ((!bool2) && (!bool1))
        {
          label817:
          j -= 1;
          continue;
          label826:
          j += 1;
        }
      }
    }
    if (j < paramList1.size())
    {
      localObject1 = (TroopAIONotifyItem)paramList1.get(j);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mergeItemList, fromServer=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i(".troop.notify_feeds.data.detail", 2, ((StringBuilder)localObject2).toString());
      }
      if (((TroopAIONotifyItem)localObject1).type == 1)
      {
        if (localArrayList1.size() == 0) {
          localArrayList1.add(localObject1);
        }
      }
      else
      {
        k = i;
        if (((TroopAIONotifyItem)localObject1).type != 2) {
          break label789;
        }
        localArrayList2.add(localObject1);
        k = i;
        break label789;
      }
    }
    else
    {
      l = NetConnInfoCenter.getServerTime();
      paramList1 = new ArrayList();
      j = paramList2.size() - 1;
      if (j >= 0)
      {
        localObject1 = (TroopAIONotifyItem)paramList2.get(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mergeItemList, fromDb=");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.i(".troop.notify_feeds.data.detail", 2, ((StringBuilder)localObject2).toString());
        }
        if (((TroopAIONotifyItem)localObject1).type == 1)
        {
          if (i == 0) {
            break label817;
          }
          paramList2.remove(j);
          paramList1.add(localObject1);
          if (!QLog.isColorLevel()) {
            break label817;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mergeItemList, hasNewAppNotify removeLocalAppItem, id=");
          ((StringBuilder)localObject2).append(((TroopAIONotifyItem)localObject1).id);
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(((TroopAIONotifyItem)localObject1).title);
          QLog.i(".troop.notify_feeds.data", 2, ((StringBuilder)localObject2).toString());
          break label817;
        }
        if (((TroopAIONotifyItem)localObject1).type != 2) {
          break label817;
        }
        bool2 = localArrayList2.contains(localObject1);
        if (((TroopAIONotifyItem)localObject1).expireTime >= l) {
          break label801;
        }
        bool1 = true;
        break label804;
        paramList2.remove(j);
        paramList1.add(localObject1);
        if (!QLog.isColorLevel()) {
          break label817;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mergeItemList, removeLocalPushItem, hasUpdate=");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append(", isExpired=");
        ((StringBuilder)localObject2).append(bool1);
        ((StringBuilder)localObject2).append(", id=");
        ((StringBuilder)localObject2).append(((TroopAIONotifyItem)localObject1).id);
        ((StringBuilder)localObject2).append(", ");
        ((StringBuilder)localObject2).append(((TroopAIONotifyItem)localObject1).title);
        QLog.i(".troop.notify_feeds.data", 2, ((StringBuilder)localObject2).toString());
        break label817;
      }
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      j = 0;
      if (j < paramList2.size())
      {
        localTroopAIONotifyItem = (TroopAIONotifyItem)paramList2.get(j);
        if (localTroopAIONotifyItem.type == 1)
        {
          if (i != 0) {
            break label826;
          }
          if (((List)localObject1).size() == 0)
          {
            ((List)localObject1).add(localTroopAIONotifyItem);
            break label826;
          }
          paramList1.add(localTroopAIONotifyItem);
          if (!QLog.isColorLevel()) {
            break label826;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mergeItemList, moreThanOne removeLocalAppItem, id=");
          localStringBuilder.append(localTroopAIONotifyItem.id);
          localStringBuilder.append(", ");
          localStringBuilder.append(localTroopAIONotifyItem.title);
          QLog.i(".troop.notify_feeds.data", 2, localStringBuilder.toString());
          break label826;
        }
        if (localTroopAIONotifyItem.type != 2) {
          break label826;
        }
        ((List)localObject2).add(localTroopAIONotifyItem);
        break label826;
      }
      b(paramQQAppInterface, paramList1);
      paramList1 = new ArrayList();
      paramList1.addAll(localArrayList1);
      paramList1.addAll(localArrayList2);
      a(paramQQAppInterface, paramList1);
      paramList1.clear();
      if (i != 0)
      {
        paramList1.addAll(localArrayList1);
        paramList1.addAll(localArrayList2);
        paramList1.addAll((Collection)localObject2);
      }
      else
      {
        paramList1.addAll((Collection)localObject1);
        paramList1.addAll(localArrayList2);
        paramList1.addAll((Collection)localObject2);
      }
      return paramList1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopAIONotifyItem paramTroopAIONotifyItem)
  {
    if (paramTroopAIONotifyItem == null) {
      return;
    }
    ThreadManager.post(new TroopAioNotifyManager.2(paramQQAppInterface, paramTroopAIONotifyItem), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ITroopAioNotifyHandler localITroopAioNotifyHandler = (ITroopAioNotifyHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_AIO_NOTIFY_HANDLER);
    Object localObject = ChatActivityUtils.a(paramString, paramQQAppInterface.getCurrentAccountUin());
    boolean bool;
    if ((localObject != null) && (((Integer)localObject).intValue() == -1)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqNotifyItems, troopUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", hasNewNotify=");
      ((StringBuilder)localObject).append(bool);
      QLog.d(".troop.notify_feeds.data", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localITroopAioNotifyHandler.a(Long.valueOf(paramString).longValue());
      ((ITroopRedDotHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(paramString, 1102858908);
      ChatActivityUtils.a(paramQQAppInterface, paramString, Integer.valueOf(0));
      return;
    }
    ThreadManager.post(new TroopAioNotifyManager.1(paramQQAppInterface, paramString, localITroopAioNotifyHandler), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<TroopAIONotifyItem> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = paramList.size();
        if (j != 0)
        {
          try
          {
            paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
            i = 0;
            if (i < j)
            {
              TroopAIONotifyItem localTroopAIONotifyItem = (TroopAIONotifyItem)paramList.get(i);
              if (localTroopAIONotifyItem.getStatus() == 1000)
              {
                paramQQAppInterface.persistOrReplace(localTroopAIONotifyItem);
                break label177;
              }
              paramQQAppInterface.update(localTroopAIONotifyItem);
              break label177;
            }
            paramQQAppInterface.close();
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("saveNotifyItems, size=");
              paramQQAppInterface.append(j);
              QLog.d(".troop.notify_feeds.data", 2, paramQQAppInterface.toString());
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel())
            {
              paramList = new StringBuilder();
              paramList.append("saveNotifyItems, exp:");
              paramList.append(paramQQAppInterface.toString());
              QLog.e(".troop.notify_feeds.data", 2, paramList.toString());
            }
          }
          return;
        }
      }
      finally {}
      return;
      label177:
      i += 1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<TroopAIONotifyItem> paramList)
  {
    if (paramList != null) {
      try
      {
        int j = paramList.size();
        if (j != 0)
        {
          try
          {
            paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
            int i = 0;
            while (i < j)
            {
              paramQQAppInterface.remove((Entity)paramList.get(i));
              i += 1;
            }
            paramQQAppInterface.close();
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("delLocalNotifyItems, size:");
              paramQQAppInterface.append(j);
              QLog.d(".troop.notify_feeds.data", 2, paramQQAppInterface.toString());
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel())
            {
              paramList = new StringBuilder();
              paramList.append("delLocalNotifyItems, exp:");
              paramList.append(paramQQAppInterface.toString());
              QLog.e(".troop.notify_feeds.data", 2, paramList.toString());
            }
          }
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager
 * JD-Core Version:    0.7.0.1
 */