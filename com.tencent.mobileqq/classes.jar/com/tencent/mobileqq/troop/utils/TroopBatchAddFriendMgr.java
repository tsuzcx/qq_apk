package com.tencent.mobileqq.troop.utils;

import ajoi;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopBatchAddFriendMgr
{
  public static boolean a;
  public QQAppInterface a;
  TroopObserver a;
  public ConcurrentHashMap a;
  public ConcurrentHashMap b = new ConcurrentHashMap();
  public ConcurrentHashMap c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public TroopBatchAddFriendMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ajoi(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    long l1 = paramToServiceMsg.extraData.getLong("reqTs", 0L);
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isLastBatch", false);
    String str1 = paramToServiceMsg.extraData.getString("fromUin");
    String str2 = paramToServiceMsg.extraData.getString("troopUin");
    int j = paramToServiceMsg.extraData.getInt("nextStartIndex");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("increment", false);
    HashMap localHashMap = new HashMap(50);
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
        a(str2, localHashMap);
        short s = paramToServiceMsg.getShort();
        if (!QLog.isColorLevel()) {
          break label305;
        }
        QLog.i("TroopBatchAddFriendMgr", 2, String.format("handleGetTroopBatchAddFrds sucNum:%d, failNum:%d", new Object[] { paramFromServiceMsg, Short.valueOf(s) }));
        label305:
        localTroopHandler.a(101, true, new Object[] { str2, str1, Boolean.valueOf(bool1), Long.valueOf(l1), Integer.valueOf(j), Boolean.valueOf(bool2), localHashMap });
        return;
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        paramToServiceMsg.uint32_result.get();
        paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg.getInt();
        paramFromServiceMsg = Short.valueOf(paramToServiceMsg.getShort());
        i = 0;
        while (i < paramFromServiceMsg.shortValue())
        {
          long l2 = paramToServiceMsg.getInt();
          s = paramToServiceMsg.getShort();
          localHashMap.put(Long.toString(l2 & 0xFFFFFFFF), Integer.valueOf(Short.valueOf(s).shortValue()));
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        if (paramToServiceMsg != null) {
          break label464;
        }
      }
      label464:
      for (int i = -1;; i = paramToServiceMsg.uint32_result.get())
      {
        QLog.i("TroopBatchAddFriendMgr", 2, String.format("handleGetTroopBatchAddFrds result:%d", new Object[] { Integer.valueOf(i) }));
        localTroopHandler.a(101, false, new Object[] { str2, str1, Boolean.valueOf(bool1), Long.valueOf(l1), Integer.valueOf(j), Boolean.valueOf(bool2), null });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopBatchAddFriendMgr", 2, String.format("handleGetTroopBatchAddFrds result2:%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
    }
    localTroopHandler.a(101, false, new Object[] { str2, str1, Boolean.valueOf(bool1), Long.valueOf(l1), Integer.valueOf(j), Boolean.valueOf(bool2), null });
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = ((EntityManager)localObject).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
    ((EntityManager)localObject).a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getTroopMemberCommonFrdBAF queryDB, troopUin=").append(paramString).append(",");
      if (localList != null) {
        break label98;
      }
    }
    label98:
    for (int i = 0;; i = localList.size())
    {
      QLog.d("TroopBatchAddFriendMgr", 2, i);
      if (localList != null) {
        break;
      }
      return;
    }
    localObject = new ArrayList(localList.size());
    i = 0;
    if (i < localList.size())
    {
      if ((((TroopMemberInfo)localList.get(i)).memberuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (((TroopMemberInfo)localList.get(i)).memberuin.equals("0"))) {}
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject).add(((TroopMemberInfo)localList.get(i)).memberuin);
      }
    }
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        this.c.put(paramString, localObject);
        this.b.put(paramString, Long.valueOf(l));
        if (50 <= ((List)localObject).size()) {
          break label324;
        }
        i = ((List)localObject).size();
        localList = ((List)localObject).subList(0, i);
        if (i == ((List)localObject).size())
        {
          bool = true;
          a(paramString, localList, i, Long.valueOf(l), bool, false);
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label324:
      i = 50;
    }
  }
  
  void a(String paramString, HashMap paramHashMap)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    try
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label224;
        }
        String str = (String)localIterator.next();
        i = ((Integer)paramHashMap.get(str)).intValue();
        List localList = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str }, null, null, null, null);
        Object localObject2 = null;
        localObject1 = localObject2;
        if (localList != null)
        {
          localObject1 = localObject2;
          if (localList.size() > 0) {
            localObject1 = (TroopMemberInfo)localList.get(0);
          }
        }
        if (localObject1 != null) {
          break;
        }
        localObject1 = new TroopMemberInfo();
        ((TroopMemberInfo)localObject1).troopuin = paramString;
        ((TroopMemberInfo)localObject1).memberuin = str;
        ((TroopMemberInfo)localObject1).commonFrdCnt = i;
        localEntityManager.a((Entity)localObject1);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        Object localObject1;
        return;
        ((TroopMemberInfo)localObject1).commonFrdCnt = i;
        localEntityManager.a((Entity)localObject1);
      }
    }
    finally
    {
      localEntityManager.a();
      localEntityTransaction.b();
    }
    label224:
    localEntityTransaction.c();
    localEntityManager.a();
    localEntityTransaction.b();
  }
  
  public void a(String paramString, List paramList, int paramInt, Long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    int i;
    String str;
    if (QLog.isColorLevel())
    {
      i = paramList.size();
      if (!paramBoolean1) {
        break label157;
      }
      str = "true";
    }
    for (;;)
    {
      QLog.i("TroopBatchAddFriendMgr", 2, String.format("batchReqMemberCmnFrds uin.size:%d isLastBatch:%s", new Object[] { Integer.valueOf(i), str }));
      int j = paramList.size();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      try
      {
        Object localObject = ByteBuffer.allocate(j * 4 + 6);
        ((ByteBuffer)localObject).putInt((int)Long.parseLong(str));
        ((ByteBuffer)localObject).putShort((short)j);
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            ((ByteBuffer)localObject).putInt((int)Long.parseLong((String)paramList.get(i)));
            i += 1;
            continue;
            label157:
            str = "false";
            break;
          }
        }
        paramList = new oidb_sso.OIDBSSOPkg();
        paramList.uint32_command.set(1069);
        paramList.uint32_result.set(0);
        paramList.uint32_service_type.set(4);
        paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
        localObject = localTroopHandler.a("OidbSvc.0x42d_4");
        ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
        ((ToServiceMsg)localObject).extraData.putLong("reqTs", paramLong.longValue());
        ((ToServiceMsg)localObject).extraData.putBoolean("isLastBatch", paramBoolean1);
        ((ToServiceMsg)localObject).extraData.putString("fromUin", str);
        ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
        ((ToServiceMsg)localObject).extraData.putInt("nextStartIndex", paramInt);
        ((ToServiceMsg)localObject).extraData.putBoolean("increment", paramBoolean2);
        localTroopHandler.b((ToServiceMsg)localObject);
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("TroopBatchAddFriendMgr", 2, String.format("batchReqMemberCmnFrds exception:%s", new Object[] { paramString.getMessage() }));
      }
    }
  }
  
  public void a(String paramString, List paramList, long paramLong)
  {
    int i = 50;
    boolean bool = false;
    try
    {
      this.c.put(paramString, paramList);
      this.b.put(paramString, Long.valueOf(paramLong));
      if (50 > paramList.size()) {
        i = paramList.size();
      }
      List localList = paramList.subList(0, i);
      if (i == paramList.size()) {
        bool = true;
      }
      a(paramString, localList, i, Long.valueOf(paramLong), bool, true);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/troop/utils/TroopBatchAddFriendMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   7: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 306	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 309	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   20: new 267	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 434	java/util/ArrayList:<init>	()V
    //   27: astore 4
    //   29: aload_2
    //   30: ldc 231
    //   32: iconst_0
    //   33: ldc_w 436
    //   36: iconst_1
    //   37: anewarray 195	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 238	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   51: invokeinterface 437 1 0
    //   56: astore 5
    //   58: aload 5
    //   60: invokeinterface 324 1 0
    //   65: ifeq +91 -> 156
    //   68: aload 5
    //   70: invokeinterface 328 1 0
    //   75: checkcast 231	com/tencent/mobileqq/data/TroopMemberInfo
    //   78: astore 6
    //   80: aload 6
    //   82: getfield 275	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   85: invokestatic 443	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne -30 -> 58
    //   91: ldc_w 284
    //   94: aload 6
    //   96: getfield 275	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   99: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne -44 -> 58
    //   105: aload 4
    //   107: aload 6
    //   109: getfield 275	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   112: invokevirtual 444	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   115: pop
    //   116: goto -58 -> 58
    //   119: astore 5
    //   121: aload_2
    //   122: invokevirtual 240	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   125: aload_3
    //   126: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   129: aload 4
    //   131: invokevirtual 445	java/util/ArrayList:size	()I
    //   134: ifle +21 -> 155
    //   137: aload_0
    //   138: getfield 44	com/tencent/mobileqq/troop/utils/TroopBatchAddFriendMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: bipush 20
    //   143: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   146: checkcast 56	com/tencent/mobileqq/app/TroopHandler
    //   149: aload_1
    //   150: aload 4
    //   152: invokevirtual 448	com/tencent/mobileqq/app/TroopHandler:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   155: return
    //   156: aload_3
    //   157: invokevirtual 354	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   160: aload_2
    //   161: invokevirtual 240	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   164: aload_3
    //   165: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   168: goto -39 -> 129
    //   171: astore_1
    //   172: aload_2
    //   173: invokevirtual 240	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   176: aload_3
    //   177: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	TroopBatchAddFriendMgr
    //   0	182	1	paramString	String
    //   10	163	2	localEntityManager	EntityManager
    //   15	162	3	localEntityTransaction	EntityTransaction
    //   27	124	4	localArrayList	ArrayList
    //   56	13	5	localIterator	Iterator
    //   119	1	5	localException	Exception
    //   78	30	6	localTroopMemberInfo	TroopMemberInfo
    // Exception table:
    //   from	to	target	type
    //   29	58	119	java/lang/Exception
    //   58	116	119	java/lang/Exception
    //   156	160	119	java/lang/Exception
    //   29	58	171	finally
    //   58	116	171	finally
    //   156	160	171	finally
  }
  
  public void b(String paramString, HashMap paramHashMap)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    try
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label213;
        }
        String str1 = (String)localIterator.next();
        str2 = (String)paramHashMap.get(str1);
        List localList = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str1 }, null, null, null, null);
        Object localObject2 = null;
        localObject1 = localObject2;
        if (localList != null)
        {
          localObject1 = localObject2;
          if (localList.size() > 0) {
            localObject1 = (TroopMemberInfo)localList.get(0);
          }
        }
        if (localObject1 != null) {
          break;
        }
        localObject1 = new TroopMemberInfo();
        ((TroopMemberInfo)localObject1).troopuin = paramString;
        ((TroopMemberInfo)localObject1).memberuin = str1;
        ((TroopMemberInfo)localObject1).recommendRemark = str2;
        localEntityManager.a((Entity)localObject1);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        String str2;
        Object localObject1;
        return;
        ((TroopMemberInfo)localObject1).recommendRemark = str2;
        localEntityManager.a((Entity)localObject1);
      }
    }
    finally
    {
      localEntityManager.a();
      localEntityTransaction.b();
    }
    label213:
    localEntityTransaction.c();
    localEntityManager.a();
    localEntityTransaction.b();
  }
  
  public void c(String paramString)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject1 = (TroopManager)((QQAppInterface)localObject2).getManager(51);
    if ((paramString != null) && (paramString.length() > 0))
    {
      TroopInfo localTroopInfo = ((TroopManager)localObject1).a(paramString);
      localObject1 = "0";
      if (localTroopInfo != null) {
        localObject1 = localTroopInfo.troopcode;
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        if (NetworkUtil.d(BaseApplication.getContext())) {
          break label97;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopBatchAddFriendMgr", 2, "getTroopMemberInfoBAF return. net connect err");
        }
      }
    }
    return;
    label97:
    if (QLog.isColorLevel()) {
      QLog.d("TroopBatchAddFriendMgr", 2, "getTroopMemberInfoBAF, troopUin: " + paramString + " troopCode: " + (String)localObject1);
    }
    localObject2 = (TroopHandler)((QQAppInterface)localObject2).a(20);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l));
    ((TroopHandler)localObject2).a(true, paramString, (String)localObject1, true, 7, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr
 * JD-Core Version:    0.7.0.1
 */