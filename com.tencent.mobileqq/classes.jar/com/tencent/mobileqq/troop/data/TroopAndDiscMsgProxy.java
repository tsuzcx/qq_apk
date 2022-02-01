package com.tencent.mobileqq.troop.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMsgProxy.Callback;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxy;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

public class TroopAndDiscMsgProxy
  extends MsgProxy
{
  TroopManager d;
  private Comparator e = new TroopAndDiscMsgProxy.1(this);
  
  public TroopAndDiscMsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  private void a(MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((!paramMessageRecord.isSendFromLocal()) && ((!MsgProxyUtils.a(paramMessageRecord)) || (paramMessageRecord.msgtype == -4012) || (paramMessageRecord.msgtype == -4009) || (paramMessageRecord.msgtype == -5001) || (paramMessageRecord.msgtype == -5021)) && (!MsgProxyUtils.e(paramMessageRecord))) {
      return;
    }
    boolean bool = MsgProxyUtils.d(paramMessageRecord.msgtype);
    long l2 = 0L;
    if ((bool) && (paramMessageRecord.shmsgseq > 0L)) {
      return;
    }
    if ((paramMessageRecord.msgtype == -2016) && (paramMessageRecord.shmsgseq != 0L))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("insertToList av offline msg ");
        paramList.append(paramMessageRecord.getBaseInfoString());
        QLog.d("Q.msg.TroopMsgProxy", 2, paramList.toString());
      }
      return;
    }
    if (paramMessageRecord.msgtype == -1012) {
      return;
    }
    long l1;
    if ((paramList != null) && (!paramList.isEmpty())) {
      l1 = ((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq;
    } else {
      l1 = 0L;
    }
    if (l1 < 0L) {
      l1 = l2;
    }
    paramList = new StringBuilder();
    paramList.append("insertToListUpdateMsgSeq from [");
    paramList.append(paramMessageRecord.shmsgseq);
    paramList.append("] to [");
    paramList.append(l1);
    paramList.append("]");
    paramList.append(paramMessageRecord.getBaseInfoString());
    QLog.i("Q.msg.TroopMsgProxy", 1, paramList.toString());
    paramMessageRecord.shmsgseq = l1;
  }
  
  @Nullable
  private List<MessageRecord> c(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (List)a().c().get(j(paramString, paramInt));
    Object localObject2;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAIOMsgList from aiopool size = ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      if (!paramBoolean) {
        break label669;
      }
      List localList = n(paramString, paramInt);
      if ((localList != null) && (!localList.isEmpty()))
      {
        MessageRecord localMessageRecord;
        if ((QLog.isColorLevel()) && (StartupTrackerForAio.a()))
        {
          localObject1 = new StringBuilder(localList.size() * 48 + 28);
          ((StringBuilder)localObject1).append("getAIOMsgList, msgInfoList: ");
          localObject2 = localList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(localMessageRecord.time);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(localMessageRecord.shmsgseq);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(localMessageRecord.msgtype);
            ((StringBuilder)localObject1).append(") ");
          }
          QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject1).toString());
        }
        new ArrayList();
        localObject1 = MsgProxyUtils.a(localList, false);
        if ((!UinTypeUtil.a(paramString, paramInt, (List)localObject1)) && (MsgProxyUtils.a((List)localObject1)))
        {
          localObject2 = localObject1;
          if (!UinTypeUtil.a((List)localObject1)) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList : pull more long msg");
          }
          localObject2 = MsgProxyUtils.a(localList, false, 30);
        }
        localObject1 = localObject2;
        if (!c((List)localObject2))
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((List)localObject2).isEmpty())
            {
              localObject1 = b(localList, ((MessageRecord)((List)localObject2).get(0)).shmsgseq);
              if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
                for (;;)
                {
                  localList = g(paramString, paramInt, 15);
                  if (QLog.isColorLevel())
                  {
                    localObject1 = localList.iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("getAIOMsgList from DB query valid msg ");
                      localStringBuilder.append(localMessageRecord.getBaseInfoString());
                      QLog.d("Q.msg.TroopMsgProxy", 2, localStringBuilder.toString());
                    }
                  }
                  localObject1 = localObject2;
                  if (localList == null) {
                    break;
                  }
                  localObject1 = localObject2;
                  if (localList.isEmpty()) {
                    break;
                  }
                  localObject1 = MsgProxyUtils.a(localList, true);
                }
              }
            }
          }
        }
      }
      else
      {
        localObject1 = f(paramString, paramInt, 15);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("continuedList :");
        ((StringBuilder)localObject1).append(((List)localObject2).size());
        QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject1).toString());
      }
      d((List)localObject2);
      a().c().put(j(paramString, paramInt), localObject2);
    }
    paramString = (List)a().c().get(j(paramString, paramInt));
    d(paramString);
    return paramString;
    label669:
    a().c().remove(j(paramString, paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "getAioMsgPool().remove :");
    }
    return null;
  }
  
  public static boolean c(List<MessageRecord> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      int j = paramList.size();
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          return bool1;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg))) {
          break;
        }
        i += 1;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  private void d(List<MessageRecord> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      Collections.sort(paramList, this.e);
      return;
    }
    catch (IllegalArgumentException paramList)
    {
      QLog.e("Q.msg.TroopMsgProxy", 1, "sortMsg: ", paramList);
    }
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.extraflag == 32772) {
      paramMessageRecord = b(paramMessageRecord, false);
    } else {
      paramMessageRecord = a(paramMessageRecord, -2006);
    }
    if (paramMessageRecord == null) {
      return -1;
    }
    if (paramMessageRecord.isread) {
      return 1;
    }
    return 2;
  }
  
  public int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return -1;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      a((MessageRecord)localIterator.next(), paramBoolean);
    }
    return paramList.size();
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong1);
    Integer localInteger = Integer.valueOf(0);
    int j;
    if (localMessageRecord != null)
    {
      int i;
      if (localMessageRecord.shmsgseq <= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      localMessageRecord.shmsgseq = paramLong2;
      localMessageRecord.time = paramLong3;
      localObject = localMessageRecord.getExtInfoFromExtStr("key_troop_sending_message_success");
      if ((localMessageRecord.extraflag == 32772) || (localMessageRecord.extraflag == 32768) || (TextUtils.equals((CharSequence)localObject, "1")))
      {
        localMessageRecord.setExtraFlag(0);
        localMessageRecord.setSendFailCode(0);
        if (!localMessageRecord.isValid)
        {
          localMessageRecord.msgtype = -2006;
          localMessageRecord.isValid = true;
        }
      }
      h(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
      j = i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update msgSeq set msg =");
        ((StringBuilder)localObject).append(localMessageRecord.getBaseInfoString());
        QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject).toString());
        j = i;
      }
    }
    else
    {
      j = 0;
    }
    if ((localMessageRecord != null) && (localMessageRecord.isSendFromLocal()) && (j != 0))
    {
      a(paramString, paramInt, localMessageRecord, null);
      return localMessageRecord;
    }
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("shmsgseq", Long.valueOf(paramLong2));
    ((ContentValues)localObject).put("time", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      ((ContentValues)localObject).put("msgtype", Integer.valueOf(localMessageRecord.msgtype));
      ((ContentValues)localObject).put("isValid", Boolean.valueOf(localMessageRecord.isValid));
      if (localMessageRecord.extraflag == 0)
      {
        ((ContentValues)localObject).put("extraflag", localInteger);
        ((ContentValues)localObject).put("sendFailCode", localInteger);
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    paramString = null;
    Object localObject2 = null;
    Object localObject1 = paramString;
    if (paramMessageRecord != null)
    {
      localObject1 = paramString;
      if (paramList != null)
      {
        localObject1 = paramString;
        if (!paramList.isEmpty())
        {
          if (paramMessageRecord.msgtype == -2006) {
            return null;
          }
          paramInt = paramList.size() - 1;
          for (;;)
          {
            paramString = localObject2;
            if (paramInt < 0) {
              break;
            }
            if (MsgProxyUtils.a((MessageRecord)paramList.get(paramInt), paramMessageRecord, true, true))
            {
              paramString = (MessageRecord)paramList.get(paramInt);
              break;
            }
            if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2011) && (paramMessageRecord.msgtype == -2011))
            {
              if (paramMessageRecord.msgUid == ((MessageRecord)paramList.get(paramInt)).msgUid)
              {
                paramString = (MessageRecord)paramList.get(paramInt);
                break;
              }
            }
            else if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2048) && (paramMessageRecord.msgtype == -2048))
            {
              paramString = (MessageForTroopReward)paramList.get(paramInt);
              localObject1 = (MessageForTroopReward)paramMessageRecord;
              if (paramString.rewardSeq == ((MessageForTroopReward)localObject1).rewardSeq)
              {
                paramString = (MessageRecord)paramList.get(paramInt);
                break;
              }
            }
            paramInt -= 1;
          }
          localObject1 = paramString;
          if (paramString != null)
          {
            localObject1 = paramString;
            if (QLog.isColorLevel())
            {
              paramMessageRecord = new StringBuilder();
              paramMessageRecord.append("getSendingMsgItem: find msg =");
              paramMessageRecord.append(paramString.getLogColorContent());
              paramMessageRecord.append(" , mr.seq = ");
              paramMessageRecord.append(paramString.shmsgseq);
              paramMessageRecord.append(" , mr.time = ");
              paramMessageRecord.append(paramString.time);
              paramMessageRecord.append(" , mr.msgtype = ");
              paramMessageRecord.append(paramString.msgtype);
              paramMessageRecord.append(" , extra = ");
              paramMessageRecord.append(paramString.extraflag);
              QLog.d("Q.msg.TroopMsgProxy", 2, paramMessageRecord.toString());
              localObject1 = paramString;
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  protected String a(Cursor paramCursor, int paramInt, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAIOMsgList peerUin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" type: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" , autoInit = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a().a(paramString, paramInt1);
    ((Lock)localObject).lock();
    try
    {
      paramString = c(paramString, paramInt1, paramBoolean);
      return paramString;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryTroopMessageFromDB_UnionTables, peerUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",_id = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",versionCode = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", endSeq ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",count = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",customTypes = ");
      localStringBuilder.append(Arrays.toString(paramArrayOfInt));
      QLog.d("Q.msg.TroopMsgProxy", 2, localStringBuilder.toString());
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(paramString, paramInt1);
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      localStringBuilder = new StringBuilder(" and msgtype in ( ");
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        localStringBuilder.append(paramArrayOfInt[i]);
        if (i < paramArrayOfInt.length - 1) {
          localStringBuilder.append(" , ");
        }
        i += 1;
      }
      localStringBuilder.append(" ) ");
      paramArrayOfInt = localStringBuilder.toString();
    }
    else
    {
      paramArrayOfInt = null;
    }
    paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt1), MessageRecord.getTableName(paramString, paramInt1), paramLong1, paramInt2, paramLong2, paramArrayOfInt, paramInt3, m());
    if (paramString == null) {
      return new ArrayList();
    }
    paramString = paramString.toString();
    if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("queryTroopMessageFromDB_UnionTables ");
      paramArrayOfInt.append(paramString);
      QLog.d("Q.msg.TroopMsgProxy", 2, paramArrayOfInt.toString());
    }
    paramArrayOfInt = c.a(paramString, null, this);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessageByTimeOrSeq:uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",seq=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",count=");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.msg.TroopMsgProxy", 2, localStringBuilder.toString());
    }
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    if (MessageDBUtils.a(MessageRecord.getTableName(paramString1, paramInt1), m()))
    {
      paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 != 0L) && (paramString != null) && (paramString.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = d(paramString, paramInt);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.shmsgseq == paramLong1) && ((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!MsgProxyUtils.a(localMessageRecord))) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
      if (localArrayList.isEmpty())
      {
        paramString = f(paramString, paramInt, paramLong1, paramLong2);
        if ((paramString != null) && (!paramString.isEmpty())) {
          localArrayList.addAll(paramString);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    if (paramMessageRecord.shmsgseq <= 0L)
    {
      if (paramMessageRecord.shmsgseq < 0L)
      {
        if (QLog.isColorLevel())
        {
          paramProxyListener = new StringBuilder();
          paramProxyListener.append("addMessage() msg discard !!! 1: peerUin = [");
          paramProxyListener.append(paramString);
          paramProxyListener.append("], type = [");
          paramProxyListener.append(paramInt);
          paramProxyListener.append("], mr = [");
          paramProxyListener.append(paramMessageRecord);
          paramProxyListener.append("]");
          QLog.d("Q.msg.TroopMsgProxy", 2, paramProxyListener.toString());
        }
        return;
      }
      if (!MsgProxyUtils.a(paramMessageRecord))
      {
        if (QLog.isColorLevel())
        {
          paramProxyListener = new StringBuilder();
          paramProxyListener.append("addMessage() msg discard !!! 2: peerUin = [");
          paramProxyListener.append(paramString);
          paramProxyListener.append("], type = [");
          paramProxyListener.append(paramInt);
          paramProxyListener.append("], mr = [");
          paramProxyListener.append(paramMessageRecord);
          paramProxyListener.append("]");
          QLog.d("Q.msg.TroopMsgProxy", 2, paramProxyListener.toString());
        }
        return;
      }
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("insertToList ");
      ((StringBuilder)localObject1).append(paramMessageRecord.getBaseInfoString());
      QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("insertToList ");
      ((StringBuilder)localObject1).append(paramMessageRecord.getUserLogString());
      QLog.d("Q.msg.TroopMsgProxy", 1, ((StringBuilder)localObject1).toString());
    }
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    for (;;)
    {
      try
      {
        localObject1 = n(paramString, paramInt);
        Object localObject2 = j(paramString, paramInt);
        a(paramString, paramInt, (String)localObject2, (List)localObject1);
        a(paramMessageRecord, (List)localObject1);
        MsgProxyUtils.a((List)localObject1, paramMessageRecord, true);
        if ((localObject1 != null) && (((List)localObject1).size() > 40) && (!UinTypeUtil.a(paramString))) {
          ((List)localObject1).remove(0);
        }
        if ((a().c().containsKey(localObject2)) && (paramBoolean))
        {
          localObject2 = (List)a().c().get(localObject2);
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
          }
          else
          {
            localObject1 = localObject2;
            if (((List)localObject2).size() > 200)
            {
              localObject1 = localObject2;
              if (paramMessageRecord.istroop == 1) {
                if (this.d == null)
                {
                  this.d = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER));
                  localObject1 = localObject2;
                }
                else
                {
                  localObject1 = localObject2;
                  if (!this.d.B(paramString))
                  {
                    QLog.d("yellowye", 2, "list.remove(0)");
                    ((List)localObject2).remove(0);
                    localObject1 = localObject2;
                  }
                }
              }
            }
          }
          if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.i != 3211265)) {
            break label516;
          }
          paramInt = 1;
          if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.i != 655392)) {
            break label521;
          }
          i = 1;
          if ((paramMessageRecord.msgtype != -4009) && (paramMessageRecord.msgtype != -4012) && (paramInt == 0) && (i == 0))
          {
            if (paramMessageRecord.msgtype == -4021) {
              MsgProxyUtils.b((List)localObject1, paramMessageRecord, true);
            } else if (((paramMessageRecord instanceof MessageForConfessNews)) && (paramMessageRecord.msgtype == -2065) && (paramMessageRecord.istroop == 1)) {
              MsgProxyUtils.a((List)localObject1, paramMessageRecord, false);
            } else {
              ((List)localObject1).add(paramMessageRecord);
            }
          }
          else {
            MsgProxyUtils.a((List)localObject1, paramMessageRecord, true);
          }
        }
        return;
      }
      finally
      {
        localLock.unlock();
      }
      label516:
      paramInt = 0;
      continue;
      label521:
      int i = 0;
    }
  }
  
  protected void a(String paramString, int paramInt, Set<String> paramSet)
  {
    if ((paramInt != 1) && (paramInt != 1026))
    {
      if (paramInt != 3000) {
        return;
      }
      paramString = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
      localIterator = paramString.iterator();
      while (localIterator.hasNext()) {
        paramSet.add(((DiscussionMemberInfo)localIterator.next()).memberUin);
      }
      paramString.clear();
      return;
    }
    paramString = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).w(paramString);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext()) {
      paramSet.add(((TroopMemberInfo)localIterator.next()).memberuin);
    }
    paramString.clear();
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryTroopMessageFromDB_UnionTables, peerUin = ");
      localStringBuilder.append(LogUtil.wrapLogUin(paramString));
      localStringBuilder.append(", type ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",_id = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",versionCode = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", endSeq ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",count = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",customTypes = ");
      localStringBuilder.append(Arrays.toString(paramArrayOfInt));
      QLog.d("Q.msg.TroopMsgProxy", 2, localStringBuilder.toString());
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(paramString, paramInt1);
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      localStringBuilder = new StringBuilder(" and msgtype in ( ");
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        localStringBuilder.append(paramArrayOfInt[i]);
        if (i < paramArrayOfInt.length - 1) {
          localStringBuilder.append(" , ");
        }
        i += 1;
      }
      localStringBuilder.append(" ) ");
      paramArrayOfInt = localStringBuilder.toString();
    }
    else
    {
      paramArrayOfInt = null;
    }
    paramString = MessageDBUtils.a(MessageRecord.getTableName(paramString, paramInt1), paramLong1, paramInt2, paramLong2, paramArrayOfInt, paramInt3, m());
    if (paramString == null) {
      return new ArrayList();
    }
    paramString = paramString.toString();
    if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("queryTroopMessageFromDB_UnionTables ");
      paramArrayOfInt.append(paramString);
      QLog.d("Q.msg.TroopMsgProxy", 2, paramArrayOfInt.toString());
    }
    paramArrayOfInt = c.a(paramString, null, this);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  protected List<MessageRecord> b(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if (localMessageRecord.shmsgseq < paramLong)
        {
          int j;
          if ((localMessageRecord.isValid) && ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg)))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            long l = localMessageRecord.shmsgseq;
            localArrayList.add(0, localMessageRecord);
          }
        }
        i -= 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public int c(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    paramString = MessageRecord.getTableName(paramString, paramInt);
    EntityManager localEntityManager = d();
    paramInt = 0;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("( msgtype ");
    ((StringBuilder)localObject).append(UinTypeUtil.a());
    ((StringBuilder)localObject).append(" and isValid=1 ) and shmsgseq <= ?");
    localObject = ((StringBuilder)localObject).toString();
    long l = paramMessageRecord.shmsgseq;
    paramString = localEntityManager.query(false, paramString, new String[] { "_id" }, (String)localObject, new String[] { String.valueOf(l) }, null, null, null, null);
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  public MessageRecord d(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList = c(paramString, paramInt);
    MessageRecord localMessageRecord = a(paramString, paramInt, paramMessageRecord, localList);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      localObject = localMessageRecord;
      if (((QQAppInterface)this.app).getMsgCache().m != null)
      {
        localList.clear();
        localObject = ((QQAppInterface)this.app).getMsgCache().m.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
            localList.add(localMessageRecord);
          }
        }
        paramString = a(paramString, paramInt, paramMessageRecord, localList);
        localObject = paramString;
        if (paramString != null)
        {
          QLog.d("Q.msg.TroopMsgProxy", 1, "getSendingMsgItem in send cache;");
          localObject = paramString;
        }
      }
    }
    return localObject;
  }
  
  public int f(String paramString, int paramInt, long paramLong)
  {
    String str = MessageRecord.getTableName(paramString, paramInt);
    str = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, "shmsgseq", Long.valueOf(paramLong), str, "shmsgseq", Long.valueOf(paramLong), "shmsgseq desc , _id desc" });
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(d());
    }
    paramString = d().rawQuery(Message.class, str, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return ((Message)paramString.get(0)).unReadNum;
    }
    return 0;
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessagesByShmsgseqFromDB, peerUin[");
      localStringBuilder.append(FileManagerUtil.k(paramString));
      localStringBuilder.append("] type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] shmsgseq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("] msgUid[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("]");
      QLog.d("Q.msg.TroopMsgProxy", 2, localStringBuilder.toString());
    }
    if ((paramLong1 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(d());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(MessageRecord.getTableName(paramString, paramInt));
    localStringBuilder.append(" where shmsgseq=?");
    paramString = localStringBuilder.toString();
    paramString = c.a(paramString, new String[] { String.valueOf(paramLong1) }, this);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 436	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:proxyManager	Lcom/tencent/mobileqq/app/proxy/BaseProxyManager;
    //   4: invokevirtual 488	com/tencent/mobileqq/app/proxy/BaseProxyManager:transSaveToDatabase	()V
    //   7: aload_0
    //   8: getfield 436	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:proxyManager	Lcom/tencent/mobileqq/app/proxy/BaseProxyManager;
    //   11: invokevirtual 730	com/tencent/mobileqq/app/proxy/BaseProxyManager:clearMsgQueue	()V
    //   14: aload_0
    //   15: invokevirtual 638	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:d	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 734	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 6
    //   23: aload_0
    //   24: invokevirtual 737	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:l	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   27: astore 7
    //   29: aload 7
    //   31: invokevirtual 743	com/tencent/mobileqq/app/SQLiteDatabase:getAllTableNameFromCache	()[Ljava/lang/String;
    //   34: astore 8
    //   36: aload 8
    //   38: ifnonnull +4 -> 42
    //   41: return
    //   42: aload_0
    //   43: getfield 26	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:app	Lmqq/app/AppRuntime;
    //   46: getstatic 746	com/tencent/mobileqq/app/QQManagerFactory:SLOW_TABLE_MANAGER	I
    //   49: invokevirtual 566	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   52: checkcast 748	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager
    //   55: astore 9
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: aload 8
    //   62: arraylength
    //   63: if_icmpge +403 -> 466
    //   66: aload 8
    //   68: iload_1
    //   69: aaload
    //   70: astore 10
    //   72: aload 10
    //   74: ldc_w 750
    //   77: invokevirtual 753	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   80: ifne +23 -> 103
    //   83: aload 10
    //   85: ldc_w 755
    //   88: invokevirtual 753	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   91: ifeq +6 -> 97
    //   94: goto +9 -> 103
    //   97: aconst_null
    //   98: astore 5
    //   100: goto +62 -> 162
    //   103: new 58	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   110: astore 5
    //   112: aload 5
    //   114: ldc_w 757
    //   117: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 5
    //   123: aload 10
    //   125: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 5
    //   131: ldc_w 759
    //   134: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: aload 10
    //   142: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 5
    //   148: ldc_w 761
    //   151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 5
    //   157: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore 5
    //   162: aload 5
    //   164: ifnull +295 -> 459
    //   167: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +41 -> 211
    //   173: new 58	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   180: astore 11
    //   182: aload 11
    //   184: ldc_w 763
    //   187: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 11
    //   193: aload 5
    //   195: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: ldc_w 765
    //   202: iconst_2
    //   203: aload 11
    //   205: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 7
    //   213: aload 5
    //   215: aconst_null
    //   216: invokevirtual 768	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   219: astore 5
    //   221: aload 5
    //   223: ifnull +113 -> 336
    //   226: aload 5
    //   228: invokeinterface 655 1 0
    //   233: ifle +103 -> 336
    //   236: aload 5
    //   238: invokeinterface 771 1 0
    //   243: pop
    //   244: aload 5
    //   246: aload 5
    //   248: ldc_w 773
    //   251: invokeinterface 776 2 0
    //   256: invokeinterface 780 2 0
    //   261: lstore_3
    //   262: aload 5
    //   264: aload 5
    //   266: ldc_w 781
    //   269: invokeinterface 776 2 0
    //   274: invokeinterface 385 2 0
    //   279: astore 11
    //   281: aload 5
    //   283: aload 5
    //   285: ldc_w 782
    //   288: invokeinterface 776 2 0
    //   293: invokeinterface 786 2 0
    //   298: istore_2
    //   299: aload_0
    //   300: getfield 26	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:app	Lmqq/app/AppRuntime;
    //   303: checkcast 665	com/tencent/mobileqq/app/QQAppInterface
    //   306: invokevirtual 669	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   309: aload 11
    //   311: iload_2
    //   312: lload_3
    //   313: invokevirtual 789	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;IJ)V
    //   316: goto +20 -> 336
    //   319: astore 6
    //   321: aload 5
    //   323: ifnull +10 -> 333
    //   326: aload 5
    //   328: invokeinterface 658 1 0
    //   333: aload 6
    //   335: athrow
    //   336: aload 5
    //   338: ifnull +10 -> 348
    //   341: aload 5
    //   343: invokeinterface 658 1 0
    //   348: aload 6
    //   350: ifnull +8 -> 358
    //   353: aload 6
    //   355: invokevirtual 794	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   358: aload 7
    //   360: aload 10
    //   362: aconst_null
    //   363: aconst_null
    //   364: invokevirtual 798	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   367: pop
    //   368: aload 6
    //   370: ifnull +8 -> 378
    //   373: aload 6
    //   375: invokevirtual 801	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   378: aload 6
    //   380: ifnull +48 -> 428
    //   383: aload 6
    //   385: invokevirtual 804	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   388: goto +40 -> 428
    //   391: astore 5
    //   393: goto +53 -> 446
    //   396: astore 5
    //   398: aload 5
    //   400: invokevirtual 807	java/lang/Exception:printStackTrace	()V
    //   403: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +14 -> 420
    //   409: ldc 73
    //   411: iconst_2
    //   412: ldc_w 809
    //   415: aload 5
    //   417: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload 6
    //   422: ifnull +6 -> 428
    //   425: goto -42 -> 383
    //   428: aload 9
    //   430: ifnull +29 -> 459
    //   433: aload 9
    //   435: aload 10
    //   437: aconst_null
    //   438: aconst_null
    //   439: invokevirtual 811	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   442: pop
    //   443: goto +16 -> 459
    //   446: aload 6
    //   448: ifnull +8 -> 456
    //   451: aload 6
    //   453: invokevirtual 804	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   456: aload 5
    //   458: athrow
    //   459: iload_1
    //   460: iconst_1
    //   461: iadd
    //   462: istore_1
    //   463: goto -404 -> 59
    //   466: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	TroopAndDiscMsgProxy
    //   58	405	1	i	int
    //   298	14	2	j	int
    //   261	52	3	l	long
    //   98	244	5	localObject1	Object
    //   391	1	5	localObject2	Object
    //   396	61	5	localException	java.lang.Exception
    //   21	1	6	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   319	133	6	localObject3	Object
    //   27	332	7	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   34	33	8	arrayOfString	String[]
    //   55	379	9	localQSlowTableManager	com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager
    //   70	366	10	str	String
    //   180	130	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   226	316	319	finally
    //   353	358	391	finally
    //   358	368	391	finally
    //   373	378	391	finally
    //   398	420	391	finally
    //   353	358	396	java/lang/Exception
    //   358	368	396	java/lang/Exception
    //   373	378	396	java/lang/Exception
  }
  
  protected void i(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    super.i(paramString, paramInt, paramList);
    paramString = a().a(paramString, paramInt);
    paramString.lock();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.msgtype == -4004) {
          ((QQAppInterface)this.app).getMessageFacade().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
      paramString.unlock();
      return;
    }
    finally
    {
      paramString.unlock();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void j(String paramString, int paramInt, long paramLong)
  {
    q(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str1 = String.valueOf(paramLong);
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    if ((UinTypeUtil.f(paramInt)) && (UinTypeUtil.d() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isread=? and %s<=? and ");
      localStringBuilder.append(UinTypeUtil.d());
      a(paramString, paramInt, str2, localContentValues, String.format(localStringBuilder.toString(), new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
      return;
    }
    a(paramString, paramInt, str2, localContentValues, String.format("isread=? and %s<=?", new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
  }
  
  public List<MessageRecord> n(String paramString, int paramInt)
  {
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = super.n(paramString, paramInt);
      d(paramString);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected String o(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(MessageRecord.getTableName(paramString, paramInt));
    localStringBuilder.append(" where _id in (select _id from ");
    localStringBuilder.append(MessageRecord.getTableName(paramString, paramInt));
    localStringBuilder.append(" order by shmsgseq desc limit ");
    localStringBuilder.append(40);
    localStringBuilder.append(") order by shmsgseq desc, _id desc");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy
 * JD-Core Version:    0.7.0.1
 */