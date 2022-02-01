package com.tencent.mobileqq.guild.message.db;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMsgProxy.Callback;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxy;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

public class GuildMsgProxy
  extends MsgProxy
{
  private final Comparator d = new GuildMsgProxy.1(this);
  
  public GuildMsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  private Message a(String paramString, EntityManager paramEntityManager, int paramInt1, int paramInt2)
  {
    if (a(paramString, true)) {
      this.proxyManager.transSaveToDatabase(paramEntityManager);
    }
    boolean bool = paramString.endsWith("_New");
    paramEntityManager = new StringBuilder();
    paramEntityManager.append("select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype ");
    paramEntityManager.append(UinTypeUtil.b());
    paramEntityManager.append(" and m.longMsgId='%d' and m.issend='%d' order by %s limit 1");
    String str = paramEntityManager.toString();
    if (bool) {
      paramEntityManager = "longMsgIndex asc , shmsgseq desc , _id desc";
    } else {
      paramEntityManager = "_id desc";
    }
    paramString = String.format(str, new Object[] { paramString, paramString, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramEntityManager });
    paramString = d().rawQuery(Message.class, paramString, null);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (Message)paramString.get(0);
    }
    return null;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    paramMessageRecord.msgtype = -2006;
    paramMessageRecord.msg = "";
    paramMessageRecord.msg2 = "";
    paramMessageRecord.msgData = "".getBytes();
    MessageRecord localMessageRecord = b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    if (localMessageRecord != null)
    {
      localMessageRecord.msgtype = -2006;
      localMessageRecord.msg = "";
      localMessageRecord.msg2 = "";
      localMessageRecord.msgData = "".getBytes();
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("Q.msg.GuildMsgProxy", 2, "update : updateMessageType : set fail !");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgtype", Integer.valueOf(-2006));
    localContentValues.putNull("msgData");
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L) {
        a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, paramProxyListener);
      } else {
        a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, paramProxyListener);
      }
    }
    else if (paramMessageRecord.getId() > 0L) {
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, paramProxyListener);
    }
    this.proxyManager.transSaveToDatabase(this.b);
    return localMessageRecord;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1 == null) {
      return paramMessageRecord2;
    }
    if (UinTypeUtil.a(paramMessageRecord1, paramMessageRecord2))
    {
      localMessageRecord = paramMessageRecord1;
      if (paramMessageRecord1.longMsgIndex > paramMessageRecord2.longMsgIndex) {
        localMessageRecord = paramMessageRecord2;
      }
      return localMessageRecord;
    }
    MessageRecord localMessageRecord = paramMessageRecord1;
    if (paramMessageRecord2.shmsgseq > paramMessageRecord1.shmsgseq) {
      localMessageRecord = paramMessageRecord2;
    }
    return localMessageRecord;
  }
  
  private StringBuilder a(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, int paramInt2, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramInt1 <= 0) {
      return null;
    }
    if (paramString2 != null)
    {
      paramSQLiteDatabase = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramSQLiteDatabase = "";
    }
    paramString2 = new StringBuilder("select * from ( select ");
    paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
    paramString2.append(" , shmsgseq as _index from ");
    paramString2.append(paramString1);
    paramString2.append(" where shmsgseq<=");
    paramString2.append(paramLong2);
    paramString2.append(paramSQLiteDatabase);
    paramString2.append(" order by shmsgseq desc , _id desc limit ");
    paramString2.append(paramInt2);
    paramString2.append(") ");
    paramString2.append(" order by shmsgseq asc , _id asc");
    return paramString2;
  }
  
  private void a(MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((!paramMessageRecord.isSendFromLocal()) && ((!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(paramMessageRecord)) || (paramMessageRecord.msgtype == -4012) || (paramMessageRecord.msgtype == -4009) || (paramMessageRecord.msgtype == -4028) || (paramMessageRecord.msgtype == -5001) || (paramMessageRecord.msgtype == -5021))) {
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
        QLog.d("Q.msg.GuildMsgProxy", 2, paramList.toString());
      }
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
    QLog.i("Q.msg.GuildMsgProxy", 1, paramList.toString());
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
        QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject2 = null;
      if (!paramBoolean) {
        break label659;
      }
      Object localObject3 = n(paramString, paramInt);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!((List)localObject3).isEmpty())
        {
          MessageRecord localMessageRecord;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder(((List)localObject3).size() * 48 + 28);
            ((StringBuilder)localObject1).append("getAIOMsgList, msgInfoList: ");
            localObject2 = ((List)localObject3).iterator();
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
            QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject1).toString());
          }
          new ArrayList();
          localObject2 = MsgProxyUtils.a((List)localObject3, false, 30);
          if ((!UinTypeUtil.a(paramString, paramInt, (List)localObject2)) && (d((List)localObject2)))
          {
            localObject1 = localObject2;
            if (!UinTypeUtil.a((List)localObject2)) {}
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.GuildMsgProxy", 2, "getAIOMsgList : pull more long msg");
            }
            localObject1 = MsgProxyUtils.a((List)localObject3, false, 60);
          }
          if ((!c((List)localObject1)) && (localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject2 = b((List)localObject3, ((MessageRecord)((List)localObject1).get(0)).shmsgseq);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = g(paramString, paramInt, 30);
              if (QLog.isColorLevel())
              {
                localObject3 = ((List)localObject2).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("getAIOMsgList from DB query valid msg ");
                  localStringBuilder.append(localMessageRecord.getBaseInfoString());
                  QLog.d("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
                }
              }
              if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                localObject1 = MsgProxyUtils.a((List)localObject2, true);
              }
            }
          }
        }
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
        QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject1).toString());
      }
      e((List)localObject2);
      a().c().put(j(paramString, paramInt), localObject2);
    }
    paramString = (List)a().c().get(j(paramString, paramInt));
    e(paramString);
    return paramString;
    label659:
    a().c().remove(j(paramString, paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.GuildMsgProxy", 2, "getAioMsgPool().remove :");
    }
    return null;
  }
  
  public static boolean c(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        if (((MessageRecord)paramList.get(i)).msgtype != -2006) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void e(List<MessageRecord> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      Collections.sort(paramList, this.d);
      return;
    }
    catch (IllegalArgumentException paramList)
    {
      QLog.e("Q.msg.GuildMsgProxy", 1, "sortMsg: ", paramList);
    }
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.extraflag == 32772) {
      paramMessageRecord = b(paramMessageRecord, false);
    } else {
      paramMessageRecord = a(paramMessageRecord, null);
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
  
  public Message a(String paramString, EntityManager paramEntityManager, int paramInt)
  {
    Object localObject1;
    int i;
    label495:
    label504:
    synchronized (c.b(this.app))
    {
      if (a(paramString, false)) {
        this.proxyManager.transSaveToDatabase(paramEntityManager);
      }
      boolean bool = paramString.endsWith("_New");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype ");
      ((StringBuilder)localObject1).append(UinTypeUtil.b());
      ((StringBuilder)localObject1).append(" order by %s limit 1");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      if (bool)
      {
        localObject1 = "shmsgseq desc , _id desc";
        localObject1 = String.format((String)localObject2, new Object[] { paramString, paramString, paramString, localObject1 });
        localObject2 = null;
        Object localObject3 = null;
        List localList = d().rawQuery(Message.class, (String)localObject1, new String[0]);
        localObject1 = localObject2;
        if (localList != null)
        {
          localObject1 = localObject2;
          if (!localList.isEmpty())
          {
            i = localList.size() - 1;
            localObject2 = localObject3;
            if (i >= 0)
            {
              if (paramInt != 0) {
                if (((Message)localList.get(i)).getConfessTopicId() != paramInt) {
                  break label495;
                }
              }
              localObject2 = (Message)localList.get(i);
            }
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((Message)localObject2).isLongMsg())
              {
                localObject1 = localObject2;
                if (((Message)localObject2).longMsgIndex > 0) {
                  localObject1 = a(paramString, paramEntityManager, ((Message)localObject2).longMsgId, ((Message)localObject2).issend);
                }
              }
            }
          }
        }
        paramEntityManager = c(paramString);
        if ((paramEntityManager != null) && (paramEntityManager.size() > 0))
        {
          i = paramEntityManager.size() - 1;
          if (i >= 0)
          {
            if ((paramInt <= 0) || (((MessageRecord)paramEntityManager.get(i)).getConfessTopicId() == paramInt)) {
              break label504;
            }
            paramEntityManager.remove(i);
            break label504;
          }
        }
        paramString = (String)localObject1;
        if (paramEntityManager != null)
        {
          paramString = (String)localObject1;
          if (paramEntityManager.size() > 0)
          {
            if (localObject1 == null) {
              paramInt = 0;
            } else {
              paramInt = ((Message)localObject1).unReadNum;
            }
            paramString = paramEntityManager.iterator();
            for (paramEntityManager = (EntityManager)localObject1; paramString.hasNext(); paramEntityManager = a(paramEntityManager, (MessageRecord)localObject2))
            {
              localObject2 = (MessageRecord)paramString.next();
              if (!((MessageRecord)localObject2).isread) {
                break label513;
              }
              i = 0;
              paramInt += i;
            }
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = new Message();
            }
            MessageRecord.copyMessageRecordBaseField(paramString, paramEntityManager);
            paramString.unReadNum = paramInt;
          }
        }
        return paramString;
      }
    }
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
      if ((localMessageRecord.extraflag == 32772) || (localMessageRecord.extraflag == 32768))
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
        QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject).toString());
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
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryLastMsgForMessageTabFromDB, peerUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", type ");
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
    }
    if (a(paramString1, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(d());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(l(paramString1, paramInt));
    localStringBuilder.append(" where isValid=1 and msgtype ");
    localStringBuilder.append(UinTypeUtil.b());
    localStringBuilder.append(" ");
    if (paramString2 != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("and ");
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = "";
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" order by shmsgseq desc , _id desc limit 1");
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("queryLastTABSupportMessageFromDB : sqlStr:");
      paramString2.append(paramString1);
      QLog.d("Q.msg.GuildMsgProxy", 2, paramString2.toString());
    }
    paramString1 = c.a(paramString1, null, this);
    if (paramString1 != null)
    {
      if (paramString1.size() < 1) {
        return null;
      }
      return (MessageRecord)paramString1.get(0);
    }
    return null;
  }
  
  public MessageRecord a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    String str = null;
    Object localObject;
    if ((paramMessageRecord != null) && (!paramList.isEmpty()) && (paramMessageRecord.msgtype != -2006))
    {
      int i = paramList.size() - 1;
      for (;;)
      {
        localObject = str;
        if (i < 0) {
          break;
        }
        if (((IGuildMsgProxyUtilsApi)QRoute.api(IGuildMsgProxyUtilsApi.class)).compGuildMsgContent(this.app, (MessageRecord)paramList.get(i), paramMessageRecord, true, true))
        {
          localObject = (MessageRecord)paramList.get(i);
          break;
        }
        if ((((MessageRecord)paramList.get(i)).msgtype == -2011) && (paramMessageRecord.msgtype == -2011) && (paramMessageRecord.msgUid == ((MessageRecord)paramList.get(i)).msgUid))
        {
          localObject = (MessageRecord)paramList.get(i);
          break;
        }
        i -= 1;
      }
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        paramList = new StringBuilder();
        paramList.append("findMsgItemInCache: find msg =");
        paramList.append(((MessageRecord)localObject).getLogColorContent());
        paramList.append(" , mr.seq = ");
        paramList.append(((MessageRecord)localObject).shmsgseq);
        paramList.append(" , mr.time = ");
        paramList.append(((MessageRecord)localObject).time);
        paramList.append(" , mr.msgtype = ");
        paramList.append(((MessageRecord)localObject).msgtype);
        paramList.append(" , extra = ");
        paramList.append(((MessageRecord)localObject).extraflag);
        QLog.d("Q.msg.GuildMsgProxy", 2, paramList.toString());
      }
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error in findSendingMsgItemInList: newMr = ");
    str = "null";
    if (paramMessageRecord == null) {
      localObject = "null";
    } else {
      localObject = "not null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", newMr type = ");
    if (paramMessageRecord == null) {
      paramMessageRecord = str;
    } else {
      paramMessageRecord = Integer.valueOf(paramMessageRecord.msgtype);
    }
    localStringBuilder.append(paramMessageRecord);
    localStringBuilder.append(", msgList.isEmpty = ");
    localStringBuilder.append(paramList.isEmpty());
    QLog.e("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
    return null;
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
      QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject).toString());
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
      localStringBuilder.append("queryGuildMessageFromDB_UnionTables, peerUin = ");
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
      QLog.d("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
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
    paramString = a(MessageRecord.getTableName(paramString, paramInt1), paramLong1, paramInt2, paramLong2, paramArrayOfInt, paramInt3, m());
    if (paramString == null) {
      return new ArrayList();
    }
    paramString = paramString.toString();
    if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("queryTroopMessageFromDB_UnionTables ");
      paramArrayOfInt.append(paramString);
      QLog.d("Q.msg.GuildMsgProxy", 2, paramArrayOfInt.toString());
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
      QLog.d("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
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
          IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
          if ((localMessageRecord.shmsgseq == paramLong1) && (!localIGuildMessageUtilsApi.isLocalOnlyMsg(localMessageRecord))) {
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
          QLog.d("Q.msg.GuildMsgProxy", 2, paramProxyListener.toString());
        }
        return;
      }
      if (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(paramMessageRecord))
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
          QLog.d("Q.msg.GuildMsgProxy", 2, paramProxyListener.toString());
        }
        return;
      }
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertToList ");
      ((StringBuilder)localObject).append(paramMessageRecord.getBaseInfoString());
      QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertToList ");
      ((StringBuilder)localObject).append(paramMessageRecord.getUserLogString());
      QLog.d("Q.msg.GuildMsgProxy", 1, ((StringBuilder)localObject).toString());
    }
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    for (;;)
    {
      try
      {
        localObject = n(paramString, paramInt);
        String str = j(paramString, paramInt);
        a(paramString, paramInt, str, (List)localObject);
        a(paramMessageRecord, (List)localObject);
        MsgProxyUtils.a((List)localObject, paramMessageRecord, true);
        int j = 0;
        if ((localObject != null) && (((List)localObject).size() > 40) && (!UinTypeUtil.a(paramString))) {
          ((List)localObject).remove(0);
        }
        if ((a().c().containsKey(str)) && (paramBoolean))
        {
          localObject = (List)a().c().get(str);
          if (localObject == null)
          {
            paramString = new ArrayList();
          }
          else
          {
            paramString = (String)localObject;
            if (((List)localObject).size() > 200)
            {
              paramString = (String)localObject;
              if (paramMessageRecord.istroop == 10014)
              {
                QLog.d("yellowye", 2, "list.remove(0)");
                ((List)localObject).remove(0);
                paramString = (String)localObject;
              }
            }
          }
          if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.i != 3211265)) {
            break label438;
          }
          paramInt = 1;
          int i = j;
          if ((paramMessageRecord instanceof MessageForUniteGrayTip))
          {
            i = j;
            if (((MessageForUniteGrayTip)paramMessageRecord).tipParam.i == 655392) {
              i = 1;
            }
          }
          if ((paramMessageRecord.msgtype != -4009) && (paramMessageRecord.msgtype != -4012) && (paramInt == 0) && (i == 0))
          {
            if (paramMessageRecord.msgtype == -4021) {
              MsgProxyUtils.b(paramString, paramMessageRecord, true);
            } else {
              paramString.add(paramMessageRecord);
            }
          }
          else {
            MsgProxyUtils.a(paramString, paramMessageRecord, true);
          }
        }
        return;
      }
      finally
      {
        localLock.unlock();
      }
      label438:
      paramInt = 0;
    }
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(a(paramString, paramInt1, paramInt2, paramBoolean));
    Collections.reverse(localArrayList);
    return GuildMsgDBUtils.a.a(localArrayList);
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
      QLog.d("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
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
      paramArrayOfInt.append("queryMessageFromDBASC, sqlStr = ");
      paramArrayOfInt.append(paramString);
      QLog.d("Q.msg.GuildMsgProxy", 2, paramArrayOfInt.toString());
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
          if ((localMessageRecord.isValid) && (localMessageRecord.msgtype != -2006)) {
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
  
  public void b(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    localLock = q(paramString, paramInt);
    localLock.lock();
    try
    {
      localList = (List)j().get(j(paramString, paramInt));
      if (localList == null) {
        break label352;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        List localList;
        int j;
        Object localObject1;
        Object localObject2;
        label352:
        label360:
        localLock.unlock();
        for (;;)
        {
          throw paramString;
        }
        i += 1;
        continue;
        int i = 0;
      }
    }
    j = localList.size();
    if (i < j)
    {
      localObject1 = (MessageRecord)localList.get(i);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("find cache ");
        ((StringBuilder)localObject2).append(((MessageRecord)localObject1).getBaseInfoString());
        QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject2).toString());
      }
      if (((MessageRecord)localObject1).uniseq == paramLong)
      {
        if ((i > 0) && (i < localList.size()))
        {
          localObject1 = new ArrayList();
          j = 0;
          while (j < i)
          {
            localObject2 = (MessageRecord)localList.get(j);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("removeList ");
              localStringBuilder.append(((MessageRecord)localObject2).getBaseInfoString());
              QLog.d("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
            }
            ((List)localObject1).add(localObject2);
            j += 1;
          }
          localList.removeAll((Collection)localObject1);
          ((List)localObject1).clear();
          localList.addAll(0, paramList);
        }
        else if (i == 0)
        {
          localList.addAll(0, paramList);
        }
        if (localList.size() > 40)
        {
          i = localList.size() - 40;
          while (i > 0)
          {
            localList.remove(0);
            i -= 1;
          }
        }
        e(paramString, paramInt, localList);
        break label360;
        e(paramString, paramInt, paramList);
        localLock.unlock();
        return;
      }
    }
  }
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2) {}
  
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
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong != 0L) && (paramString != null) && (paramString.length() != 0))
    {
      Object localObject = d(paramString, paramInt);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
          if ((localMessageRecord.shmsgseq == paramLong) && (!localIGuildMessageUtilsApi.isLocalOnlyMsg(localMessageRecord))) {
            return localMessageRecord;
          }
        }
      }
      return o(paramString, paramInt, paramLong);
    }
    return null;
  }
  
  public MessageRecord d(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList1 = c(paramString, paramInt);
    if (localList1 == null) {
      QLog.e("Q.msg.GuildMsgProxy", 2, "Error in getSendingMsgItem. msgList is NULL!");
    }
    MessageRecord localMessageRecord = a(localList1, paramMessageRecord);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      localObject = localMessageRecord;
      if ((this.app instanceof AppInterface))
      {
        List localList2 = ((IGuildSendMessageHandler)((AppInterface)this.app).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).a();
        localObject = localMessageRecord;
        if (localList2 != null)
        {
          localList1.clear();
          localObject = localList2.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
              localList1.add(localMessageRecord);
            }
          }
          paramString = a(localList1, paramMessageRecord);
          localObject = paramString;
          if (paramString != null)
          {
            QLog.d("Q.msg.GuildMsgProxy", 1, "getSendingMsgItem in send cache;");
            localObject = paramString;
          }
        }
      }
    }
    if ((localObject != null) && (QLog.isColorLevel()))
    {
      paramString = new StringBuilder();
      paramString.append("getSendingMsgItem: find msg =");
      paramString.append(((MessageRecord)localObject).getLogColorContent());
      paramString.append(" , mr.seq = ");
      paramString.append(((MessageRecord)localObject).shmsgseq);
      paramString.append(" , mr.time = ");
      paramString.append(((MessageRecord)localObject).time);
      paramString.append(" , mr.msgtype = ");
      paramString.append(((MessageRecord)localObject).msgtype);
      paramString.append(" , extra = ");
      paramString.append(((MessageRecord)localObject).extraflag);
      QLog.d("Q.msg.GuildMsgProxy", 2, paramString.toString());
    }
    return localObject;
  }
  
  public boolean d(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if ((!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(localMessageRecord)) && (localMessageRecord.msgtype != -2006)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessagesByShmsgseqFromDB, peerUin[");
      localStringBuilder.append(QQFileManagerUtil.a(paramString));
      localStringBuilder.append("] type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] shmsgseq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("] msgUid[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("]");
      QLog.d("Q.msg.GuildMsgProxy", 2, localStringBuilder.toString());
    }
    if ((paramLong1 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.GuildMsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0");
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
      e(paramString);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected MessageRecord o(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryMessagesByShmsgseqFromDB, peerUin[");
      ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(paramString));
      ((StringBuilder)localObject1).append("] type[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("] shmsgseq[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("]");
      QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.GuildMsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(d());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ");
    ((StringBuilder)localObject1).append(l(paramString, paramInt));
    ((StringBuilder)localObject1).append(" where shmsgseq=?");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = c;
    int i = 0;
    localObject1 = ((BaseMsgProxy.Callback)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong) }, this);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("queryMessagesByShmsgseqFromDB, peerUin[");
      ((StringBuilder)localObject2).append(MsfSdkUtils.getShortUin(paramString));
      ((StringBuilder)localObject2).append("] type[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("] shmsgseq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], list.size():");
      if (localObject1 == null) {
        paramInt = i;
      } else {
        paramInt = ((List)localObject1).size();
      }
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d("Q.msg.GuildMsgProxy", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (MessageRecord)paramString.next();
        if (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg((MessageRecord)localObject1)) {
          return localObject1;
        }
      }
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.db.GuildMsgProxy
 * JD-Core Version:    0.7.0.1
 */