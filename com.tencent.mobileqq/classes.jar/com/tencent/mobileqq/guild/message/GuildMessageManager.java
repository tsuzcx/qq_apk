package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseMessageManager.Callback;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.adder.IAddMessageHandler;
import com.tencent.imcore.message.aiolist.IAioMsgHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IMessageRecordForGuildWelcome;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageManagerCallback;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.navigatebar.BaseInfoManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class GuildMessageManager
  extends BaseGuildMessageManager
{
  protected static AbsGuildMessageManagerCallback f;
  private GuildRandomGetMessageLoader g = null;
  
  public GuildMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
  }
  
  private int a(long paramLong, List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return 0;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((MessageRecord)paramList.get(i)).uniseq == paramLong) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private int a(List<MessageRecord> paramList, int paramInt)
  {
    int i = paramInt;
    while (paramInt < paramList.size() - 1)
    {
      long l = ((MessageRecord)paramList.get(paramInt)).shmsgseq;
      int j = paramInt + 1;
      if (l != ((MessageRecord)paramList.get(j)).shmsgseq) {
        break;
      }
      int k = i + 1;
      i = k;
      paramInt = j;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(k);
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
        i = k;
        paramInt = j;
      }
    }
    return i;
  }
  
  private long a(String paramString, int paramInt, List<MessageRecord> paramList, long paramLong)
  {
    if (!paramList.isEmpty())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.shmsgseq == ((MessageRecord)paramList.get(0)).shmsgseq)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          StringBuilder localStringBuilder1;
          if (localMessageRecord.getId() > 0L)
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("id&");
            paramLong = localMessageRecord.getId();
          }
          else
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("uniseq&");
            paramLong = localMessageRecord.uniseq;
          }
          localStringBuilder1.append(paramLong);
          localStringBuilder2.append(localStringBuilder1.toString());
          localStringBuilder2.append("&");
          localStringBuilder2.append(localMessageRecord.shmsgseq);
          localHashMap.put(localStringBuilder2.toString(), localMessageRecord);
        }
      }
      paramList.addAll(0, a(paramInt).a(paramString, paramInt, ((MessageRecord)paramList.get(0)).shmsgseq, localHashMap));
      return ((MessageRecord)paramList.get(0)).shmsgseq - 1L;
    }
    return paramLong;
  }
  
  private HashMap<String, MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      long l = f(paramList);
      MessageRecord localMessageRecord1 = a(paramInt).b(paramString, paramInt, l);
      if (localMessageRecord1 != null)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh find msg in cache id = ");
          paramString.append(localMessageRecord1.getId());
          paramString.append(", msg = ");
          paramString.append(localMessageRecord1.getLogColorContent());
          paramString.append(", uniseq = ");
          paramString.append(localMessageRecord1.uniseq);
          paramString.append(" , msgtime = ");
          paramString.append(localMessageRecord1.time);
          paramString.append(" , shMsgSeq = ");
          paramString.append(localMessageRecord1.shmsgseq);
          paramString.append(" , extra = ");
          paramString.append(localMessageRecord1.extraflag);
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramString.toString());
        }
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MessageRecord localMessageRecord2 = (MessageRecord)paramList.next();
            if (localMessageRecord2.shmsgseq == localMessageRecord1.shmsgseq)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (localMessageRecord2.getId() > 0L)
              {
                paramString = new StringBuilder();
                paramString.append("id&");
                l = localMessageRecord2.getId();
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append("uniseq&");
                l = localMessageRecord2.uniseq;
              }
              paramString.append(l);
              localStringBuilder.append(paramString.toString());
              localStringBuilder.append("&");
              localStringBuilder.append(localMessageRecord2.shmsgseq);
              localHashMap.put(localStringBuilder.toString(), localMessageRecord2);
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refresh can't find msg in cache !!");
      }
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    }
    return localHashMap;
  }
  
  public static void a(IGuildMessageCallback paramIGuildMessageCallback)
  {
    if ((paramIGuildMessageCallback instanceof AbsGuildMessageManagerCallback)) {
      f = (AbsGuildMessageManagerCallback)paramIGuildMessageCallback;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, long paramLong1, MessageRecord paramMessageRecord, int paramInt3, List<MessageRecord> paramList, long paramLong2, boolean paramBoolean, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      int i;
      if (paramList == null) {
        i = -1;
      } else {
        i = paramList.size();
      }
      QLog.i("Q.msg.BaseMessageManager.GuildMessageManager", 2, String.format("refresh roam doRefreshMsgFromDB() uin=%s type=%s count=%s headseq=%s endSeq=%s roamSuc=%s roamResCode=%s locallist=%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt4), Integer.valueOf(i) }));
    }
    if (((paramList.isEmpty()) && (paramLong2 > 0L)) || ((!paramBoolean) && (paramList.size() < paramInt2)) || ((paramBoolean) && (paramInt4 != 0) && (paramList.size() < paramInt2)))
    {
      paramLong2 = a(paramString, paramInt1, paramList, paramLong2);
      BaseMsgProxy localBaseMsgProxy = a(paramInt1);
      if (paramMessageRecord == null) {
        paramLong1 = 0L;
      } else {
        paramLong1 = paramMessageRecord.getId();
      }
      paramString = localBaseMsgProxy.a(paramString, paramInt1, paramLong1, paramInt3, paramLong2, paramInt2 - paramList.size(), null);
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("refresh roam fail step 0 , size = ");
        paramMessageRecord.append(paramString.size());
        paramMessageRecord.append(",seq = ");
        paramMessageRecord.append(paramLong2);
        paramMessageRecord.append(" , timestamp = ");
        paramMessageRecord.append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramMessageRecord.toString());
      }
      if (paramString.isEmpty()) {
        paramRefreshMessageContext.c = true;
      } else {
        paramList.addAll(0, paramString);
      }
      paramRefreshMessageContext.e = true;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRefreshMessageContext = new StringBuilder();
      paramRefreshMessageContext.append("refresh roam addRoamMsgToList uniseq = ");
      paramRefreshMessageContext.append(paramLong1);
      paramRefreshMessageContext.append(" , locallist = ");
      paramRefreshMessageContext.append(paramList.size());
      paramRefreshMessageContext.append(" , timestamp = ");
      paramRefreshMessageContext.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramRefreshMessageContext.toString());
    }
    a(paramInt1).a(paramString, paramInt1, paramLong1, paramList);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, HashMap<String, MessageRecord> paramHashMap, List<MessageRecord> paramList1, int paramInt3, List<MessageRecord> paramList2)
  {
    long l2 = ((MessageRecord)paramList1.get(0)).shmsgseq;
    int i = d(paramList1) + 1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh read cache and DB step 0, sameSeq = ");
      localStringBuilder.append(l2);
      localStringBuilder.append(",itemListStartPoint = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", timestamp = ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
    }
    if (i > paramInt3) {
      paramList2.addAll(a(paramInt1).a(paramString, paramInt1, l2, paramHashMap));
    } else {
      paramList2.addAll(paramList1.subList(i, paramInt3));
    }
    paramInt3 = paramList2.size();
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("refresh read cache and DB step 1, size = ");
      paramHashMap.append(paramList2.size());
      paramHashMap.append(", timestamp = ");
      paramHashMap.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramHashMap.toString());
    }
    long l1 = l2 - (paramInt2 - paramInt3);
    if (l1 < 0L) {
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("getLocalListRefreshReadCacheAndDB() called with: beginSeq = [");
      paramHashMap.append(l1);
      paramHashMap.append("],endSeq=[");
      paramHashMap.append(l2);
      paramHashMap.append("]");
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramHashMap.toString());
    }
    paramList2.addAll(0, a(paramInt1).c(paramString, paramInt1, l1, l2));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("refresh read cache and DB step 2, size = ");
      paramString.append(paramList2.size());
      paramString.append(", timestamp = ");
      paramString.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramString.toString());
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, HashMap<String, MessageRecord> paramHashMap, List<MessageRecord> paramList1, int paramInt3, List<MessageRecord> paramList2, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh read cache step 1, timestamp = ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
    }
    int i = paramInt3 - paramInt2;
    long l = ((MessageRecord)paramList1.get(i)).shmsgseq;
    int j = b(paramList1, i);
    if (j == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh read cache step 2, timestamp = ");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
      }
      i = a(paramList1, i) + 1;
      if (i > paramInt3)
      {
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("refresh read cache step 3, size = ");
          paramList1.append(paramList2.size());
          paramList1.append(", timestamp = ");
          paramList1.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramList1.toString());
        }
        paramList2.addAll(a(paramInt1).a(paramString, paramInt1, paramLong, paramHashMap));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh read cache step 4, size = ");
          paramString.append(paramList2.size());
          paramString.append(", timestamp = ");
          paramString.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramString.toString());
        }
      }
      else
      {
        paramList2.addAll(paramList1.subList(i, paramInt3));
        paramInt3 = paramList2.size();
        if (QLog.isColorLevel())
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("refresh read cache step 5, size = ");
          paramHashMap.append(paramList2.size());
          paramHashMap.append(", timestamp = ");
          paramHashMap.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramHashMap.toString());
        }
        paramHashMap = a(paramInt1);
        paramLong = l - (paramInt2 - paramInt3);
        if (paramLong < 0L) {
          paramLong = 0L;
        }
        paramList2.addAll(0, paramHashMap.c(paramString, paramInt1, paramLong, l));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("refresh read cache step 6, size = ");
          paramString.append(paramList2.size());
          paramString.append(", timestamp = ");
          paramString.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramString.toString());
        }
      }
    }
    else
    {
      paramList2.addAll(paramList1.subList(j, paramInt3));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("refresh read cache step 7, size = ");
        paramString.append(paramList2.size());
        paramString.append(", timestamp = ");
        paramString.append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramString.toString());
      }
    }
  }
  
  private void a(Map<String, MessageRecord> paramMap, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Iterator localIterator = this.b.getRegistry().p().iterator();
    while (localIterator.hasNext()) {
      ((IAddMessageHandler)localIterator.next()).a(this.a, this, paramMessageRecord, paramBoolean1, paramBoolean2, paramBoolean3, paramMap, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    }
  }
  
  private boolean a(int paramInt, RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
    }
    paramRefreshMessageContext.b = null;
    a(paramRefreshMessageContext, paramInt);
    return true;
  }
  
  private int b(List<MessageRecord> paramList, int paramInt)
  {
    while ((paramInt > 0) && (((MessageRecord)paramList.get(paramInt - 1)).shmsgseq == ((MessageRecord)paramList.get(paramInt)).shmsgseq))
    {
      int i = paramInt - 1;
      paramInt = i;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(i);
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
        paramInt = i;
      }
    }
    return paramInt;
  }
  
  public static AbsGuildMessageManagerCallback c()
  {
    return f;
  }
  
  private int d(List<MessageRecord> paramList)
  {
    int j = 0;
    int i = 0;
    while (j < paramList.size() - 1)
    {
      long l = ((MessageRecord)paramList.get(j)).shmsgseq;
      int k = j + 1;
      if (l != ((MessageRecord)paramList.get(k)).shmsgseq) {
        break;
      }
      int m = i + 1;
      j = k;
      i = m;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh same seq  itemListStartPoint= ");
        localStringBuilder.append(m);
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
        j = k;
        i = m;
      }
    }
    return i;
  }
  
  private GuildRandomGetMessageLoader d()
  {
    if (this.g == null) {
      this.g = new GuildRandomGetMessageLoader(this.a, this);
    }
    return this.g;
  }
  
  private boolean e(List<MessageRecord> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((MessageRecord)paramList.next()).shmsgseq > 0L) {
        return true;
      }
    }
    return false;
  }
  
  private long f(List<MessageRecord> paramList)
  {
    paramList = paramList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      boolean bool = paramList.hasNext();
      l = 0L;
      if (!bool) {
        break;
      }
      localMessageRecord = (MessageRecord)paramList.next();
    } while ((((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(localMessageRecord)) || (localMessageRecord.shmsgseq <= 0L));
    long l = localMessageRecord.uniseq;
    return l;
  }
  
  private void k(MessageRecord paramMessageRecord)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.mMessageInfo = paramMessageRecord.mMessageInfo;
    this.b.decodeMsg(localMessage);
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = f.a(paramMessageRecord);
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        localMessage.msg = paramMessageRecord;
      }
    }
    this.b.setIncomingMsg(localMessage);
  }
  
  private boolean l(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.c();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    if ((paramMessageRecord.isSendFromLocal()) && (paramMessageRecord.extraflag == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addMessage set sendmsg extra ");
        ((StringBuilder)localObject).append(paramMessageRecord.getBaseInfoString());
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject).toString());
      }
      paramMessageRecord.setExtraFlag(32772);
      paramMessageRecord.setSendFailCode(0);
    }
    Object localObject = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    if (((IGuildMessageUtilsApi)localObject).getGuildIdFromMR(paramMessageRecord) == 0L)
    {
      String str = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildIdOf(paramMessageRecord.frienduin);
      if (!TextUtils.isEmpty(str))
      {
        ((IGuildMessageUtilsApi)localObject).saveGuildIdToMR(paramMessageRecord, str);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "addMessageRecord, invalid guild id");
        }
        return false;
      }
    }
    return true;
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    return 0;
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.shmsgseq;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2;
    long l1;
    Object localObject4;
    Object localObject3;
    int i;
    if (paramInt2 > 0)
    {
      System.currentTimeMillis();
      localObject2 = a(paramInt1).g(paramString, paramInt1);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        l1 = f((List)localObject2);
        localObject4 = a(paramInt1).b(paramString, paramInt1, l1);
        localObject2 = a(paramString, paramInt1, (List)localObject2);
        localObject3 = a(paramInt1).c(paramString, paramInt1);
        i = a(l1, (List)localObject3);
      }
    }
    label426:
    label429:
    label451:
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (localObject4 == null) {
          l1 = 0L;
        } else {
          l1 = ((MessageRecord)localObject4).shmsgseq;
        }
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("refresh cache miss step 0, timestamp = ");
            ((StringBuilder)localObject3).append(System.currentTimeMillis());
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject3).toString());
          }
          localObject3 = a(paramInt1);
          l2 = l1 - paramInt2;
          if (l2 < 0L) {
            break label426;
          }
          break label429;
          Object localObject1;
          localArrayList.addAll(((BaseMsgProxy)localObject3).c(paramString, paramInt1, l2, localObject1));
          localArrayList.addAll(a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject2));
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("refresh cache miss step 1, timestamp = ");
            paramString.append(System.currentTimeMillis());
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramString.toString());
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label451;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("refresh read cache step 0, cacheIndex = ");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append(" timestamp = ");
          ((StringBuilder)localObject4).append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject4).toString());
          if (i >= paramInt2) {
            a(paramString, paramInt1, paramInt2, (HashMap)localObject2, (List)localObject3, i, localArrayList, l1);
          } else {
            a(paramString, paramInt1, paramInt2, (HashMap)localObject2, (List)localObject3, i, localArrayList);
          }
        }
        return localArrayList;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return new ArrayList();
      throw new IllegalArgumentException("COUNT MUST > 0 !");
      long l2 = 0L;
      long l3 = l1 - 1L;
      if (l3 < 0L) {
        l3 = 0L;
      }
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (paramLong >= 0L) {
      localObject1 = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
    } else if (((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isGuest(paramString)) {
      localObject1 = a(paramInt1).a(paramString, paramInt1, paramInt2, false);
    } else {
      localObject1 = a(paramInt1).a(paramString, paramInt1, paramInt2, true);
    }
    if (localObject1 == null) {
      return new ArrayList();
    }
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    e.a(this, this.a, paramInt1, paramString, (List)localObject2, null, false, true);
    e.a(paramInt1, (List)localObject2, this.a);
    MsgProxyUtils.a(paramString, paramInt1, (List)localObject2, (MessageCache)this.a.getMsgCache());
    e.a(this.b, paramString, paramInt1, (List)localObject2, this);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("newAIOCursor clone ");
      ((StringBuilder)localObject1).append(Integer.valueOf(((List)localObject2).size()));
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = ((List)localObject2).iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (MessageRecord)localIterator1.next();
      Iterator localIterator2 = this.b.getRegistry().r().iterator();
      while (localIterator2.hasNext())
      {
        Object[] arrayOfObject = ((IAioMsgHandler)localIterator2.next()).a(this.a, paramString, paramInt1, paramBoolean, localArrayList2, (List)localObject1, localArrayList1, (MessageRecord)localObject2);
        localObject2 = (MessageRecord)arrayOfObject[0];
        if (((Boolean)arrayOfObject[1]).booleanValue()) {
          break;
        }
      }
    }
    if (!paramBoolean) {
      e.a(this.a, (List)localObject1, localArrayList1);
    }
    return localArrayList2;
  }
  
  public void a(int paramInt, String paramString, long paramLong, List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg((MessageRecord)localObject2))
          {
            l1 = ((ChatMessage)localObject2).shmsgseq;
            break label84;
          }
        }
      }
      long l1 = 0L;
      label84:
      if ((l1 <= paramLong) && (paramLong != 0L) && (l1 != 0L))
      {
        long l2 = MessageCache.c();
        localObject1 = paramList.iterator();
        do
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (((ChatMessage)localObject2).shmsgseq != paramLong);
        l1 = ((ChatMessage)localObject2).time;
        localObject2 = this.a.getCurrentAccountUin();
        localObject1 = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        MessageRecord localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-4009);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = localObject2;
        }
        localMessageRecord.init((String)localObject2, paramString, (String)localObject1, "", l1, -4009, paramInt, 0L);
        localMessageRecord.shmsgseq = paramLong;
        paramString = new ArrayList();
        paramString.add(localMessageRecord);
        this.b.addMessage(paramString, (String)localObject2, false, false);
        paramString = new ArrayList();
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramString.add((ChatMessage)((Iterator)localObject1).next());
        }
        MsgProxyUtils.a(paramString, localMessageRecord, false);
        paramList.clear();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          paramList.add((ChatMessage)paramString.next());
        }
      }
    }
  }
  
  protected void a(RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.p;
    List localList = a(paramInt).g(str, paramInt);
    if ((paramRefreshMessageContext.n < 3) && (UinTypeUtil.a(localList)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
      }
      paramRefreshMessageContext.n += 1;
      b(str, paramInt, 30, paramRefreshMessageContext);
      return;
    }
    if ((UinTypeUtil.a(str, paramInt, localList)) && (paramRefreshMessageContext.f) && (paramRefreshMessageContext.m < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshHeadComplete : pull more long msg");
      }
      paramRefreshMessageContext.m += 1;
      b(str, paramInt, 30, paramRefreshMessageContext);
      return;
    }
    super.a(paramRefreshMessageContext, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (!l(paramMessageRecord)) {
      return;
    }
    long l = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(paramMessageRecord);
    a(paramAddMessageContext.h, paramMessageRecord, paramBoolean1, paramBoolean2, paramBoolean4);
    BaseInfoManager localBaseInfoManager = f.a(paramAddMessageContext);
    paramAddMessageContext = null;
    paramEntityManager = paramAddMessageContext;
    if (localBaseInfoManager != null)
    {
      paramEntityManager = localBaseInfoManager.a(paramMessageRecord.frienduin);
      if (paramEntityManager != null) {
        if (paramEntityManager.b() != paramMessageRecord.shmsgseq)
        {
          paramEntityManager = paramAddMessageContext;
        }
        else if (paramMessageRecord.isread)
        {
          localBaseInfoManager.b(paramMessageRecord.frienduin);
          paramEntityManager = paramAddMessageContext;
        }
      }
    }
    if (paramEntityManager != null) {
      f.a(this.a, paramMessageRecord.frienduin, paramEntityManager, paramMessageRecord, true);
    }
    k(paramMessageRecord);
    if (QLog.isColorLevel())
    {
      paramAddMessageContext = new StringBuilder();
      paramAddMessageContext.append("addMessageRecord, messageInfo = ");
      paramAddMessageContext.append(paramEntityManager);
      paramAddMessageContext.append(" key = ");
      paramAddMessageContext.append(String.valueOf(l));
      paramAddMessageContext.append("mr.frienduin");
      paramAddMessageContext.append(paramMessageRecord.frienduin);
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramAddMessageContext.toString());
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    if (paramInt == 10014)
    {
      f.a(this.a, paramString, paramLong1, paramLong2, true, paramBundle, 0);
      return;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.h = false;
    paramRefreshMessageContext.f = true;
    paramRefreshMessageContext.p = paramString;
    paramRefreshMessageContext.q = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager.GuildMessageManager", 2, String.format("refreshUnreadMessage() channelId=%s [%d,%d]", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
    if ((!paramRefreshMessageContext.s) && (this.b.getRefreshActionMap().containsKey(UinTypeUtil.a(paramString, paramInt))))
    {
      this.b.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
    this.b.getRefreshActionMap().put(UinTypeUtil.a(paramString, paramInt), Boolean.valueOf(true));
    ThreadManager.executeOnNetWorkThread(new GuildMessageManager.1(this, paramRefreshMessageContext, paramString, paramInt, paramLong2, paramLong1, paramBoolean));
  }
  
  public void a(String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, RefreshMessageContext paramRefreshMessageContext, int paramInt2, boolean paramBoolean2)
  {
    d().a(paramString, paramInt1, paramLong1, paramLong2, paramBoolean1, paramRefreshMessageContext, paramInt2, paramBoolean2);
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2) {}
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle) {}
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {}
  
  public void a(List<MessageRecord> paramList1, long paramLong, List<MessageRecord> paramList2)
  {
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      StringBuilder localStringBuilder;
      if (localMessageRecord.shmsgseq < paramLong)
      {
        paramList2.add(localMessageRecord);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh breakpoint invalid: id = ");
          localStringBuilder.append(localMessageRecord.getId());
          localStringBuilder.append(", msg = ");
          localStringBuilder.append(localMessageRecord.getLogColorContent());
          localStringBuilder.append(" , msgtime = ");
          localStringBuilder.append(localMessageRecord.time);
          localStringBuilder.append(" , shMsgSeq = ");
          localStringBuilder.append(localMessageRecord.shmsgseq);
          localStringBuilder.append(" , extra = ");
          localStringBuilder.append(localMessageRecord.extraflag);
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh breakpoint valid: id = ");
        localStringBuilder.append(localMessageRecord.getId());
        localStringBuilder.append(", msg = ");
        localStringBuilder.append(localMessageRecord.getLogColorContent());
        localStringBuilder.append(" , msgtime = ");
        localStringBuilder.append(localMessageRecord.time);
        localStringBuilder.append(" , shMsgSeq = ");
        localStringBuilder.append(localMessageRecord.shmsgseq);
        localStringBuilder.append(" , extra = ");
        localStringBuilder.append(localMessageRecord.extraflag);
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
      }
    }
    paramList1.removeAll(paramList2);
    paramList2.clear();
    if (QLog.isColorLevel())
    {
      paramList2 = new StringBuilder();
      paramList2.append("refresh breakpoint step 1, size = ");
      paramList2.append(paramList1.size());
      paramList2.append(", timestamp = ");
      paramList2.append(System.currentTimeMillis());
      QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, paramList2.toString());
    }
  }
  
  public boolean a(int paramInt, RefreshMessageContext paramRefreshMessageContext, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager.GuildMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    }
    paramRefreshMessageContext.b = null;
    a(paramRefreshMessageContext, paramInt);
    return true;
  }
  
  public boolean a(RefreshMessageContext paramRefreshMessageContext, long paramLong, boolean paramBoolean)
  {
    if (paramLong <= 0L)
    {
      paramRefreshMessageContext.c = true;
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    return false;
  }
  
  public void b(Message paramMessage)
  {
    String str = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    if ((!TextUtils.isEmpty(str)) && (str.equals(paramMessage.senderuin)))
    {
      paramMessage.nickName = HardCodeUtil.a(2131890521);
    }
    else
    {
      str = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildUserNick(paramMessage.senderuin);
      if (TextUtils.isEmpty(str)) {
        paramMessage.nickName = paramMessage.getExtInfoFromExtStr("GUILD_MSG_FROM_NICK");
      } else {
        paramMessage.nickName = str;
      }
    }
    if (TextUtils.isEmpty(paramMessage.nickName)) {
      paramMessage.nickName = paramMessage.senderuin;
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramInt2 > 0)
    {
      Object localObject1 = a(paramInt1).g(paramString, paramInt1);
      if (a(paramInt1, paramRefreshMessageContext, (List)localObject1)) {
        return;
      }
      long l1 = f((List)localObject1);
      long l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (!((List)localObject1).isEmpty())
        {
          l1 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq + 1L;
          l2 = l1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doRefreshMessageListHead() called set tail headMsgUniseq = [");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append("]");
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject2).toString());
            l2 = l1;
          }
        }
      }
      boolean bool1 = e((List)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doRefreshMessageListHead() called with: uin = [");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("], type = [");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("], count = [");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append("], context = [");
        ((StringBuilder)localObject1).append(paramRefreshMessageContext);
        ((StringBuilder)localObject1).append("], aio head msg headMsgUniseq = [");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("]");
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (a(paramInt1, paramRefreshMessageContext, bool1)) {
        return;
      }
      Object localObject2 = a(paramInt1).b(paramString, paramInt1, l2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doRefreshMessageListHead() called with: aio head msg = [");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append("]");
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject1).toString());
      }
      long l3;
      if (localObject2 == null) {
        l3 = 0L;
      } else {
        l3 = ((MessageRecord)localObject2).shmsgseq;
      }
      l1 = l3;
      if (l3 == 0L) {
        l1 = l2;
      }
      int j;
      if (localObject2 == null) {
        j = 3;
      } else {
        j = ((MessageRecord)localObject2).versionCode;
      }
      localObject1 = a(paramString, paramInt1, paramInt2);
      Object localObject3;
      StringBuilder localStringBuilder;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        i = ((List)localObject1).size();
        l3 = l1;
        k = i - 1;
        i = 0;
        while (k >= 0)
        {
          localObject3 = (MessageRecord)((List)localObject1).get(k);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doRefreshMessageListHead() called with: messageRecord = [");
            localStringBuilder.append(localObject3);
            localStringBuilder.append("]");
            QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
          }
          if (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg((MessageRecord)localObject3))
          {
            if (l3 - ((MessageRecord)localObject3).shmsgseq > 1L) {
              break;
            }
            l3 = ((MessageRecord)localObject3).shmsgseq;
            i += 1;
          }
          k -= 1;
        }
      }
      else
      {
        l3 = l1;
        i = 0;
      }
      long l5 = l3 - 1L;
      int k = paramInt2 - i;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doRefreshMessageListHead() called with: localContinuesSize = [");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("], lastContinuedSeq = [");
        ((StringBuilder)localObject3).append(l3);
        ((StringBuilder)localObject3).append("], needSize = [");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append("], count = [");
        ((StringBuilder)localObject3).append(paramInt2);
        ((StringBuilder)localObject3).append("], localSize = [");
        if (localObject1 == null) {
          i = 0;
        } else {
          i = ((List)localObject1).size();
        }
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("]");
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject3).toString());
      }
      int i = k;
      if (k < 0) {
        i = 0;
      }
      long l4 = l5 - i + 1L;
      long l6 = ((MessageCache)this.a.getMsgCache()).b(paramString, paramInt1);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doRefreshMessageListHead() refresh breakpoint step 0, delSeq = ");
        ((StringBuilder)localObject3).append(l6);
        ((StringBuilder)localObject3).append(", endSeq = ");
        ((StringBuilder)localObject3).append(l5);
        ((StringBuilder)localObject3).append(",beginSeq = ");
        ((StringBuilder)localObject3).append(l4);
        ((StringBuilder)localObject3).append(",lastContinuedSeq = ");
        ((StringBuilder)localObject3).append(l3);
        ((StringBuilder)localObject3).append(",localSeqEnd = ");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(", timestamp = ");
        ((StringBuilder)localObject3).append(System.currentTimeMillis());
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject3).toString());
      }
      boolean bool2 = a(paramRefreshMessageContext, l5, true);
      if (l5 <= l6)
      {
        paramRefreshMessageContext.c = true;
        bool1 = false;
        l1 = l4;
      }
      else
      {
        l1 = l4;
        bool1 = bool2;
        if (l4 <= l6)
        {
          l1 = l6 + 1L;
          bool1 = bool2;
        }
      }
      if (l1 < 0L) {
        l1 = 0L;
      }
      a((List)localObject1, l1, new ArrayList());
      if ((!paramRefreshMessageContext.e) && (l5 >= l1) && (l5 > 0L) && (bool1))
      {
        localObject3 = new Bundle();
        i = this.b.getPullCounter().addAndGet(1);
        ((Bundle)localObject3).putInt("counter", i);
        ((Bundle)localObject3).putBoolean("success", false);
        this.b.getPullCache().put(Integer.valueOf(i), localObject1);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doRefreshMessageListHead() refresh roam step 0 , timestamp = ");
          localStringBuilder.append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, localStringBuilder.toString());
        }
        a(paramString, paramInt1, l1, l5, (Bundle)localObject3);
        this.b.getAutoPullCache().put(UinTypeUtil.a(paramString, paramInt1), Boolean.valueOf(false));
        c((List)localObject1);
        bool1 = ((Bundle)localObject3).getBoolean("success");
        i = ((Bundle)localObject3).getInt("resCode", 0);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("doRefreshMessageListHead() refresh roam step 4 , size = ");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          ((StringBuilder)localObject3).append(" , timestamp = ");
          ((StringBuilder)localObject3).append(System.currentTimeMillis());
          QLog.d("Q.msg.BaseMessageManager.GuildMessageManager", 2, ((StringBuilder)localObject3).toString());
        }
        if ((this.b.getAutoPullCache().containsKey(UinTypeUtil.a(paramString, paramInt1))) && (((Boolean)this.b.getAutoPullCache().get(UinTypeUtil.a(paramString, paramInt1))).booleanValue()))
        {
          paramString = this.b;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(", timestamp = ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          paramString.qLogColor("doRefreshMessageListHead() get auto pull msg when pull refresh !", ((StringBuilder)localObject1).toString());
          paramRefreshMessageContext.b = null;
          a(paramRefreshMessageContext, paramInt1);
          return;
        }
      }
      else
      {
        i = 0;
        bool1 = true;
      }
      if ((bool1) && ((i == 65534) || (i == 65535)) && (paramRefreshMessageContext.o < 1))
      {
        paramRefreshMessageContext.b = null;
        paramRefreshMessageContext.o += 1;
      }
      else
      {
        a(paramString, paramInt1, paramInt2, paramRefreshMessageContext, l2, (MessageRecord)localObject2, j, (List)localObject1, l5, bool1, i);
        a((List)localObject1);
        paramInt2 = paramInt1;
        a(paramInt2).b(paramString, paramInt2, (List)localObject1);
        paramString = paramRefreshMessageContext;
        paramString.b = ((List)localObject1);
        paramString.o = 0;
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          bool1 = ((List)localObject1).get(((List)localObject1).size() - 1) instanceof IMessageRecordForGuildWelcome;
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("context.isLocalOnly = ");
        paramString.append(paramRefreshMessageContext.e);
        paramString.append(", context.retryIndexOfServerError = ");
        paramString.append(paramRefreshMessageContext.o);
        QLog.d("Q.msg.BaseMessageManager.GuildMessageManager.trooptroop_pull_msg", 2, paramString.toString());
      }
      paramString = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doRefreshMessageListHead() refresh finish , context = ");
      ((StringBuilder)localObject2).append(paramRefreshMessageContext);
      ((StringBuilder)localObject2).append(" , size = ");
      if (localObject1 == null) {
        paramInt2 = -1;
      } else {
        paramInt2 = ((List)localObject1).size();
      }
      ((StringBuilder)localObject2).append(paramInt2);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(", timestamp = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      paramString.qLogColor((String)localObject1, ((StringBuilder)localObject2).toString());
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    paramString = new IllegalArgumentException("COUNT MUST > 0 !");
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong) {}
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean) {}
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (localChatMessage.msgtype == -4009)
        {
          localArrayList.add(localChatMessage);
          this.b.removeMsgByMessageRecord(localChatMessage, true);
        }
      }
      paramList.removeAll(localArrayList);
    }
  }
  
  public void c(Message paramMessage)
  {
    b(paramMessage);
  }
  
  /* Error */
  public void c(List<MessageRecord> paramList)
  {
    // Byte code:
    //   0: invokestatic 869	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokestatic 875	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6: ifeq +31 -> 37
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_1
    //   12: ldc2_w 876
    //   15: invokevirtual 881	java/lang/Object:wait	(J)V
    //   18: goto +12 -> 30
    //   21: astore_2
    //   22: goto +11 -> 33
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 884	java/lang/InterruptedException:printStackTrace	()V
    //   30: aload_1
    //   31: monitorexit
    //   32: return
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    //   37: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	GuildMessageManager
    //   0	38	1	paramList	List<MessageRecord>
    //   21	1	2	localObject	Object
    //   25	11	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   11	18	21	finally
    //   26	30	21	finally
    //   30	32	21	finally
    //   33	35	21	finally
    //   11	18	25	java/lang/InterruptedException
  }
  
  protected void d(String paramString, int paramInt) {}
  
  public boolean e(String paramString, int paramInt)
  {
    return this.b.getRefreshActionMap().containsKey(UinTypeUtil.a(paramString, paramInt));
  }
  
  public void f(MessageRecord paramMessageRecord) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildMessageManager
 * JD-Core Version:    0.7.0.1
 */