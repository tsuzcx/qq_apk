package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x103.submsgtype0x103.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;

@KeepClassConstructor
public class ConfessProxy
  extends BaseProxy
{
  private QQConcurrentHashMap<String, ConfessConvInfo> jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap = new QQConcurrentHashMap(1005, 0, 100);
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public ConfessProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private EntityManager a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt1, paramInt2);
      if ((paramString != null) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(paramString)))
      {
        paramInt1 = ((ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(paramString)).unreadCount;
        return paramInt1;
      }
      return 0;
    }
    finally {}
  }
  
  public long a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt1, paramInt2);
      if ((paramString != null) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(paramString)))
      {
        long l = ((ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(paramString)).lastread;
        return l;
      }
      return 0L;
    }
    finally {}
  }
  
  public ConfessConvInfo a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = UinTypeUtil.a(paramString, paramInt1, paramInt2);
      if ((paramString != null) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(paramString)))
      {
        paramString = (ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  /* Error */
  public java.util.Set<ConfessConvInfo> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 85	java/util/HashSet
    //   5: dup
    //   6: aload_0
    //   7: getfield 31	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   10: invokevirtual 89	com/tencent/commonsdk/cache/QQConcurrentHashMap:values	()Ljava/util/Collection;
    //   13: invokespecial 92	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: astore_1
    //   22: goto +31 -> 53
    //   25: astore_1
    //   26: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +12 -> 41
    //   32: ldc 99
    //   34: iconst_2
    //   35: ldc 101
    //   37: aload_1
    //   38: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   41: new 85	java/util/HashSet
    //   44: dup
    //   45: invokespecial 106	java/util/HashSet:<init>	()V
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	ConfessProxy
    //   16	4	1	localHashSet1	java.util.HashSet
    //   21	1	1	localObject	Object
    //   25	13	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   48	8	1	localHashSet2	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   2	17	21	finally
    //   26	41	21	finally
    //   41	49	21	finally
    //   2	17	25	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   4: invokevirtual 113	com/tencent/commonsdk/cache/QQConcurrentHashMap:clear	()V
    //   7: aload_0
    //   8: invokespecial 115	com/tencent/mobileqq/confess/ConfessProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: ldc 70
    //   13: invokestatic 119	com/tencent/mobileqq/confess/ConfessConvInfo:getConversationInfoTableName	()Ljava/lang/String;
    //   16: iconst_0
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 123	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;)Ljava/util/List;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnonnull +4 -> 33
    //   32: return
    //   33: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +39 -> 75
    //   39: new 125	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   46: astore_3
    //   47: aload_3
    //   48: ldc 128
    //   50: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: aload_2
    //   56: invokeinterface 138 1 0
    //   61: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 99
    //   67: iconst_2
    //   68: aload_3
    //   69: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: aload_2
    //   79: invokeinterface 138 1 0
    //   84: if_icmpge +70 -> 154
    //   87: aload_0
    //   88: getfield 31	com/tencent/mobileqq/confess/ConfessProxy:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   91: aload_2
    //   92: iload_1
    //   93: invokeinterface 151 2 0
    //   98: checkcast 70	com/tencent/mobileqq/confess/ConfessConvInfo
    //   101: getfield 155	com/tencent/mobileqq/confess/ConfessConvInfo:uin	Ljava/lang/String;
    //   104: aload_2
    //   105: iload_1
    //   106: invokeinterface 151 2 0
    //   111: checkcast 70	com/tencent/mobileqq/confess/ConfessConvInfo
    //   114: getfield 158	com/tencent/mobileqq/confess/ConfessConvInfo:type	I
    //   117: aload_2
    //   118: iload_1
    //   119: invokeinterface 151 2 0
    //   124: checkcast 70	com/tencent/mobileqq/confess/ConfessConvInfo
    //   127: getfield 161	com/tencent/mobileqq/confess/ConfessConvInfo:topicId	I
    //   130: invokestatic 60	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   133: aload_2
    //   134: iload_1
    //   135: invokeinterface 151 2 0
    //   140: invokevirtual 165	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -71 -> 77
    //   151: astore_2
    //   152: aload_2
    //   153: athrow
    //   154: return
    //   155: astore_2
    //   156: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ConfessProxy
    //   76	72	1	i	int
    //   27	107	2	localList	java.util.List
    //   151	2	2	localObject	Object
    //   155	1	2	localException	java.lang.Exception
    //   46	23	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	144	151	finally
    //   77	144	155	java/lang/Exception
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = UinTypeUtil.a(paramString, paramInt1, paramInt2);
      if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
      {
        localObject = (ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
        a(paramString, paramInt1, paramInt2, ((ConfessConvInfo)localObject).lastread, ((ConfessConvInfo)localObject).unreadCount + paramInt3);
      }
      else
      {
        a(paramString, paramInt1, paramInt2, 0L, paramInt3);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      String str = UinTypeUtil.a(paramString, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(str))
      {
        ConfessConvInfo localConfessConvInfo = (ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str);
        if (localConfessConvInfo != null)
        {
          localConfessConvInfo.holmesTolCount = paramInt4;
          localConfessConvInfo.holmesCurCount = paramInt3;
          a(paramString, paramInt1, localConfessConvInfo);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("updateHolmesProgress key=");
            paramString.append(str);
            paramString.append(" curCount=");
            paramString.append(paramInt3);
            QLog.d("Q.confess.unread.ConfessProxy", 2, paramString.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      Object localObject1 = UinTypeUtil.a(paramString, paramInt1, paramInt2);
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject1)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject1) != null))
      {
        localObject1 = (ConfessConvInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject1);
        if ((((ConfessConvInfo)localObject1).lastread == paramLong) && (((ConfessConvInfo)localObject1).unreadCount == paramInt3))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("insertOrUpdateUnread nochange=");
            paramString.append(localObject1.toString());
            QLog.d("Q.confess.unread.ConfessProxy", 2, paramString.toString());
          }
        }
        else
        {
          ((ConfessConvInfo)localObject1).lastread = paramLong;
          ((ConfessConvInfo)localObject1).unreadCount = Math.max(0, paramInt3);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("insertOrUpdateUnread update=");
          ((StringBuilder)localObject2).append(localObject1.toString());
          QLog.d("Q.confess.unread.ConfessProxy", 1, ((StringBuilder)localObject2).toString());
          a(paramString, paramInt1, (ConfessConvInfo)localObject1);
        }
      }
      else
      {
        localObject2 = new ConfessConvInfo(paramString, paramInt1, paramInt2, paramLong, Math.max(0, paramInt3));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insertOrUpdateUnread insert=");
        localStringBuilder.append(localObject2.toString());
        QLog.d("Q.confess.unread.ConfessProxy", 1, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject1, localObject2);
        b(paramString, paramInt1, (ConfessConvInfo)localObject2);
      }
      return;
    }
    finally {}
  }
  
  protected void a(String paramString, int paramInt, ConfessConvInfo paramConfessConvInfo)
  {
    this.proxyManager.addMsgQueue(paramString, paramInt, ConfessConvInfo.getConversationInfoTableName(), paramConfessConvInfo, 4, null);
  }
  
  public void a(submsgtype0x103.MsgBody paramMsgBody)
  {
    if (!ConfessConfig.a((QQAppInterface)this.app)) {
      return;
    }
    if ((paramMsgBody != null) && (paramMsgBody.uint64_from.has()) && (paramMsgBody.uint64_to.has()) && (paramMsgBody.uint32_topic_id.has()) && (paramMsgBody.uint32_cur_count.has()) && (paramMsgBody.uint32_total_count.has()))
    {
      long l2 = paramMsgBody.uint64_from.get();
      long l3 = paramMsgBody.uint64_to.get();
      long l1;
      int i;
      if (this.app.getLongAccountUin() == l2)
      {
        l1 = l3;
        i = 1033;
      }
      else if (this.app.getLongAccountUin() == l3)
      {
        l1 = l2;
        i = 1034;
      }
      else
      {
        l1 = -1L;
        i = -1;
      }
      if (l1 > 0L)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("");
        a(((StringBuilder)localObject1).toString(), i, paramMsgBody.uint32_topic_id.get(), paramMsgBody.uint32_cur_count.get(), paramMsgBody.uint32_total_count.get());
        if ((paramMsgBody.uint32_total_count.get() > 0) && (paramMsgBody.uint32_cur_count.get() == paramMsgBody.uint32_total_count.get()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append("");
          localObject1 = UinTypeUtil.a(((StringBuilder)localObject1).toString(), i, paramMsgBody.uint32_topic_id.get());
          ConfessConfig.b((QQAppInterface)this.app, (String)localObject1, true);
          localObject1 = this.app;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramMsgBody.uint32_topic_id.get());
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(l2);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(l3);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X8009572", "0X8009572", 0, 0, (String)localObject2, "", (String)localObject3, localStringBuilder.toString());
        }
        localObject1 = (ConfessHandler)((QQAppInterface)this.app).getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER);
        if (localObject1 != null)
        {
          boolean bool = false;
          int j = paramMsgBody.uint32_topic_id.get();
          int k = paramMsgBody.uint32_cur_count.get();
          int m = paramMsgBody.uint32_total_count.get();
          if (i == 1033) {
            bool = true;
          }
          ((ConfessHandler)localObject1).notifyUI(8, true, new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        }
      }
      if (QLog.isColorLevel())
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("onReceiveHolmesProgressOnLinePush from:");
        paramMsgBody.append(l2);
        paramMsgBody.append(" to:");
        paramMsgBody.append(l3);
        QLog.d("Q.confess.unread.ConfessProxy", 2, paramMsgBody.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("Q.confess.unread.ConfessProxy", 2, "onReceiveHolmesProgressOnLinePush no msg data");
    }
  }
  
  public void a(submsgtype0x104.MsgBody paramMsgBody)
  {
    if (!ConfessConfig.a((QQAppInterface)this.app)) {
      return;
    }
    if ((paramMsgBody != null) && (paramMsgBody.uint64_from.has()) && (paramMsgBody.uint64_to.has()) && (paramMsgBody.uint32_topic_id.has()) && (paramMsgBody.bytes_wording.has()))
    {
      long l1 = paramMsgBody.uint64_from.get();
      long l2 = paramMsgBody.uint64_to.get();
      int i = -1;
      if (this.app.getLongAccountUin() == l1)
      {
        i = 1033;
        l1 = l2;
      }
      else if (this.app.getLongAccountUin() == l2)
      {
        i = 1034;
      }
      else
      {
        l1 = -1L;
      }
      if (l1 > 0L)
      {
        String str = paramMsgBody.bytes_wording.get().toStringUtf8();
        if (!TextUtils.isEmpty(str))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)this.app;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(l1);
          localStringBuilder.append("");
          ConfessMsgUtil.a(localQQAppInterface, localStringBuilder.toString(), str, i, paramMsgBody.uint32_topic_id.get());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.confess.unread.ConfessProxy", 2, "onReceiveHolmesGrayTipsOnLinePush grayTip empty");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("Q.confess.unread.ConfessProxy", 2, "onReceiveHolmesGrayTipsOnLinePush no msg data");
    }
  }
  
  public void b()
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected void b(String paramString, int paramInt, ConfessConvInfo paramConfessConvInfo)
  {
    this.proxyManager.addMsgQueue(paramString, paramInt, ConfessConvInfo.getConversationInfoTableName(), paramConfessConvInfo, 3, null);
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.clear();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessProxy
 * JD-Core Version:    0.7.0.1
 */