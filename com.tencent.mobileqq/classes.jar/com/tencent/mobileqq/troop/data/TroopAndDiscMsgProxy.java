package com.tencent.mobileqq.troop.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.BaseMsgProxy.Callback;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxy;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
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
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
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

public class TroopAndDiscMsgProxy
  extends MsgProxy
{
  private PasswdRedBagManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private Comparator jdField_a_of_type_JavaUtilComparator = new TroopAndDiscMsgProxy.1(this);
  
  public TroopAndDiscMsgProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramBaseProxyManager, paramMsgPool);
  }
  
  @Nullable
  private List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (List)a().a().get(a(paramString, paramInt));
    Object localObject2;
    Object localObject3;
    MessageRecord localMessageRecord;
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      if (paramBoolean)
      {
        localObject2 = h(paramString, paramInt);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          if ((QLog.isColorLevel()) && (StartupTrackerForAio.a()))
          {
            localObject1 = new StringBuilder(((List)localObject2).size() * 48 + 28);
            ((StringBuilder)localObject1).append("getAIOMsgList, msgInfoList: ");
            localObject3 = ((List)localObject2).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
              ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
            }
            QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject1).toString());
          }
          new ArrayList();
          localObject1 = MsgProxyUtils.a((List)localObject2, false);
          if ((!UinTypeUtil.a(paramString, paramInt, (List)localObject1)) && (MsgProxyUtils.a((List)localObject1)) && (!UinTypeUtil.a((List)localObject1))) {
            break label644;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList : pull more long msg");
          }
          localObject1 = MsgProxyUtils.a((List)localObject2, false, 30);
        }
      }
    }
    label644:
    for (;;)
    {
      if ((!a((List)localObject1)) && (localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject2 = b((List)localObject2, ((MessageRecord)((List)localObject1).get(0)).shmsgseq);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label329:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "continuedList :" + ((List)localObject2).size());
        }
        a((List)localObject2);
        a().a().put(a(paramString, paramInt), localObject2);
        for (;;)
        {
          paramString = (List)a().a().get(a(paramString, paramInt));
          a(paramString);
          return paramString;
          localObject3 = e(paramString, paramInt, 15);
          if (QLog.isColorLevel())
          {
            localObject2 = ((List)localObject3).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from DB query valid msg " + localMessageRecord.getBaseInfoString());
            }
          }
          localObject2 = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject2 = localObject1;
          if (((List)localObject3).isEmpty()) {
            break;
          }
          localObject2 = MsgProxyUtils.a((List)localObject3, true);
          break;
          localObject1 = d(paramString, paramInt, 15);
          break label329;
          a().a().remove(a(paramString, paramInt));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAioMsgPool().remove :");
          }
          return null;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from aiopool size = " + ((List)localObject1).size());
          }
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((!paramMessageRecord.isSendFromLocal()) && ((!MsgProxyUtils.a(paramMessageRecord)) || (paramMessageRecord.msgtype == -4012) || (paramMessageRecord.msgtype == -4009) || (paramMessageRecord.msgtype == -5001) || (paramMessageRecord.msgtype == -5021)) && (!MsgProxyUtils.d(paramMessageRecord))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((MsgProxyUtils.d(paramMessageRecord.msgtype)) && (paramMessageRecord.shmsgseq > 0L));
        if ((paramMessageRecord.msgtype != -2016) || (paramMessageRecord.shmsgseq == 0L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList av offline msg " + paramMessageRecord.getBaseInfoString());
      return;
    } while (paramMessageRecord.msgtype == -1012);
    if ((paramList != null) && (!paramList.isEmpty())) {}
    for (long l1 = ((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 < 0L) {
        l2 = 0L;
      }
      QLog.i("Q.msg.TroopMsgProxy", 1, "insertToListUpdateMsgSeq from [" + paramMessageRecord.shmsgseq + "] to [" + l2 + "]" + paramMessageRecord.getBaseInfoString());
      paramMessageRecord.shmsgseq = l2;
      return;
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      return;
    }
    catch (IllegalArgumentException paramList)
    {
      QLog.e("Q.msg.TroopMsgProxy", 1, "sortMsg: ", paramList);
    }
  }
  
  public static boolean a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.extraflag == 32772) {}
    for (paramMessageRecord = a(paramMessageRecord, false); paramMessageRecord == null; paramMessageRecord = a(paramMessageRecord, -2006)) {
      return -1;
    }
    if (paramMessageRecord.isread) {
      return 1;
    }
    return 2;
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    String str = MessageRecord.getTableName(paramString, paramInt);
    str = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, "shmsgseq", Long.valueOf(paramLong), str, "shmsgseq", Long.valueOf(paramLong), "shmsgseq desc , _id desc" });
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramString = a().rawQuery(Message.class, str, null);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = i;
      if (!paramString.isEmpty()) {
        paramInt = ((Message)paramString.get(0)).unReadNum;
      }
    }
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    paramString = MessageRecord.getTableName(paramString, paramInt);
    EntityManager localEntityManager = a();
    String str = "( msgtype " + UinTypeUtil.a() + " and isValid=1 ) and shmsgseq <= ?";
    long l = paramMessageRecord.shmsgseq;
    paramString = localEntityManager.query(false, paramString, new String[] { "_id" }, str, new String[] { String.valueOf(l) }, null, null, null, null);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
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
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    int j = 0;
    if (localMessageRecord != null) {
      if (localMessageRecord.shmsgseq > 0L) {
        break label189;
      }
    }
    label189:
    for (int i = 1;; i = 0)
    {
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
      f(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.TroopMsgProxy", 2, "update msgSeq set msg =" + localMessageRecord.getBaseInfoString());
        j = i;
      }
      if ((localMessageRecord == null) || (!localMessageRecord.isSendFromLocal()) || (j == 0)) {
        break;
      }
      a(paramString, paramInt, localMessageRecord, null);
      return localMessageRecord;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shmsgseq", Long.valueOf(paramLong2));
    localContentValues.put("time", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      localContentValues.put("msgtype", Integer.valueOf(localMessageRecord.msgtype));
      localContentValues.put("isValid", Boolean.valueOf(localMessageRecord.isValid));
      if (localMessageRecord.extraflag == 0)
      {
        localContentValues.put("extraflag", Integer.valueOf(0));
        localContentValues.put("sendFailCode", Integer.valueOf(0));
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList = b(paramString, paramInt);
    Object localObject = a(paramString, paramInt, paramMessageRecord, localList);
    if ((localObject == null) && (((QQAppInterface)this.app).getMsgCache().a != null))
    {
      localList.clear();
      localObject = ((QQAppInterface)this.app).getMsgCache().a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
          localList.add(localMessageRecord);
        }
      }
      paramString = a(paramString, paramInt, paramMessageRecord, localList);
      if (paramString != null) {
        QLog.d("Q.msg.TroopMsgProxy", 1, "getSendingTroopMsgItem in send cache;");
      }
      return paramString;
    }
    return localObject;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((paramMessageRecord == null) || (paramList == null) || (paramList.isEmpty()) || (paramMessageRecord.msgtype == -2006))
    {
      paramMessageRecord = null;
      return paramMessageRecord;
    }
    paramInt = paramList.size() - 1;
    label43:
    if (paramInt >= 0) {
      if (MsgProxyUtils.a((MessageRecord)paramList.get(paramInt), paramMessageRecord, true, true)) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
    }
    for (;;)
    {
      paramMessageRecord = paramString;
      if (paramString == null) {
        break;
      }
      paramMessageRecord = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.TroopMsgProxy", 2, "getSendingTroopMsgItem: find msg =" + paramString.getLogColorContent() + " , mr.seq = " + paramString.shmsgseq + " , mr.time = " + paramString.time + " , mr.msgtype = " + paramString.msgtype + " , extra = " + paramString.extraflag);
      return paramString;
      if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2011) && (paramMessageRecord.msgtype == -2011))
      {
        if (paramMessageRecord.msgUid == ((MessageRecord)paramList.get(paramInt)).msgUid) {
          paramString = (MessageRecord)paramList.get(paramInt);
        }
      }
      else if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2048) && (paramMessageRecord.msgtype == -2048))
      {
        paramString = (MessageForTroopReward)paramList.get(paramInt);
        MessageForTroopReward localMessageForTroopReward = (MessageForTroopReward)paramMessageRecord;
        if (paramString.rewardSeq == localMessageForTroopReward.rewardSeq)
        {
          paramString = (MessageRecord)paramList.get(paramInt);
          continue;
        }
      }
      paramInt -= 1;
      break label43;
      paramString = null;
    }
  }
  
  public String a(Cursor paramCursor, int paramInt, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt1 + " , autoInit = " + paramBoolean);
    }
    Lock localLock = a().a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = a(paramString, paramInt1, paramBoolean);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", endSeq " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    if (a(paramString, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase(paramString, paramInt1);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(" ) ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt1), MessageRecord.getTableName(paramString, paramInt1), paramLong1, paramInt2, paramLong2, (String)localObject1, paramInt3, b());
    if (paramString == null) {
      paramString = new ArrayList();
    }
    do
    {
      return paramString;
      paramString = paramString.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables " + paramString);
      }
      paramArrayOfInt = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, null, this);
      paramString = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (a(paramString1, paramInt1, true)) {
      this.proxyManager.transSaveToDatabase();
    }
    if (MessageDBUtils.a(MessageRecord.getTableName(paramString1, paramInt1), b()))
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
    if ((paramLong1 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = c(paramString, paramInt);
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
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str1 = String.valueOf(paramLong);
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    if ((UinTypeUtil.e(paramInt)) && (UinTypeUtil.d() != null))
    {
      a(paramString, paramInt, str2, localContentValues, String.format("isread=? and %s<=? and " + UinTypeUtil.d(), new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
      return;
    }
    a(paramString, paramInt, str2, localContentValues, String.format("isread=? and %s<=?", new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    if (paramMessageRecord.shmsgseq <= 0L)
    {
      if (paramMessageRecord.shmsgseq < 0L) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 1: peerUin = [" + paramString + "], type = [" + paramInt + "], mr = [" + paramMessageRecord + "]");
        }
      }
      do
      {
        return;
        if (MsgProxyUtils.a(paramMessageRecord)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 2: peerUin = [" + paramString + "], type = [" + paramInt + "], mr = [" + paramMessageRecord + "]");
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Lock localLock;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
      localLock = a().a(paramString, paramInt);
      localLock.lock();
    }
    label533:
    label545:
    label551:
    label557:
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = h(paramString, paramInt);
        String str = a(paramString, paramInt);
        a(paramString, paramInt, str, (List)localObject);
        a(paramMessageRecord, (List)localObject);
        MsgProxyUtils.a((List)localObject, paramMessageRecord, true);
        if ((localObject != null) && (((List)localObject).size() > 40) && (!UinTypeUtil.a(paramString))) {
          ((List)localObject).remove(0);
        }
        if ((a().a().containsKey(str)) && (paramBoolean))
        {
          localObject = (List)a().a().get(str);
          if (localObject != null) {
            continue;
          }
          localObject = new ArrayList();
          if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.b != 3211265)) {
            break label551;
          }
          i = 1;
          if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.b != 655392)) {
            break label545;
          }
          j = 1;
          if ((paramMessageRecord.msgtype != -4009) && (paramMessageRecord.msgtype != -4012) && (i == 0) && (j == 0)) {
            continue;
          }
          MsgProxyUtils.a((List)localObject, paramMessageRecord, true);
          if ((paramMessageRecord.msgtype == -2006) && (PasswdRedBagManager.a((QQAppInterface)this.app, paramInt, paramString)) && ((paramMessageRecord instanceof MessageForFoldMsg)) && (!paramMessageRecord.isSend()))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a((List)localObject, (MessageForFoldMsg)paramMessageRecord);
          }
        }
        return;
        QLog.d("Q.msg.TroopMsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
        break;
        if ((((List)localObject).size() <= 200) || (paramMessageRecord.istroop != 1)) {
          break label557;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER));
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.g(paramString)) {
          break label557;
        }
        QLog.d("yellowye", 2, "list.remove(0)");
        ((List)localObject).remove(0);
        break label557;
        if (paramMessageRecord.msgtype == -4021)
        {
          MsgProxyUtils.b((List)localObject, paramMessageRecord, true);
          continue;
        }
        if (!(paramMessageRecord instanceof MessageForConfessNews)) {
          break label533;
        }
      }
      finally
      {
        localLock.unlock();
      }
      if ((paramMessageRecord.msgtype == -2065) && (paramMessageRecord.istroop == 1))
      {
        MsgProxyUtils.a((List)localObject, paramMessageRecord, false);
      }
      else
      {
        ((List)localObject).add(paramMessageRecord);
        continue;
        j = 0;
        continue;
        i = 0;
      }
    }
  }
  
  public void a(String paramString, int paramInt, Set<String> paramSet)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 1026: 
      paramString = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      localIterator = paramString.iterator();
      while (localIterator.hasNext()) {
        paramSet.add(((TroopMemberInfo)localIterator.next()).memberuin);
      }
      paramString.clear();
      return;
    }
    paramString = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext()) {
      paramSet.add(((DiscussionMemberInfo)localIterator.next()).memberUin);
    }
    paramString.clear();
  }
  
  protected List<MessageRecord> b(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.shmsgseq >= paramLong) {}
      label130:
      for (;;)
      {
        i -= 1;
        break;
        if ((localMessageRecord.isValid) && ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg)))) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label130;
          }
          long l = localMessageRecord.shmsgseq;
          localArrayList.add(0, localMessageRecord);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public String c(String paramString, int paramInt)
  {
    return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where _id in (select _id from " + MessageRecord.getTableName(paramString, paramInt) + " order by shmsgseq desc limit " + 40 + ") order by shmsgseq desc, _id desc";
  }
  
  public void c()
  {
    this.proxyManager.transSaveToDatabase();
    this.proxyManager.clearMsgQueue();
    EntityTransaction localEntityTransaction = a().getTransaction();
    SQLiteDatabase localSQLiteDatabase = a();
    String[] arrayOfString = localSQLiteDatabase.getAllTableNameFromCache();
    if (arrayOfString == null) {
      return;
    }
    QSlowTableManager localQSlowTableManager = (QSlowTableManager)this.app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    int i = 0;
    label59:
    String str1;
    if (i < arrayOfString.length)
    {
      str1 = arrayOfString[i];
      if ((!str1.startsWith("mr_discusssion")) && (!str1.startsWith("mr_troop"))) {
        break label421;
      }
    }
    label330:
    Object localObject3;
    label421:
    for (Object localObject1 = "select frienduin, istroop, shmsgseq as tmpseq, issend from " + str1 + " where shmsgseq=(select max(shmsgseq) from " + str1 + ")";; localObject3 = null)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "sql zsw =" + (String)localObject1);
        }
        localObject1 = localSQLiteDatabase.rawQuery((String)localObject1, null);
        if (localObject1 == null) {}
      }
      try
      {
        if (((Cursor)localObject1).getCount() > 0)
        {
          ((Cursor)localObject1).moveToFirst();
          long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("tmpseq"));
          String str2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("frienduin"));
          int j = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("istroop"));
          ((QQAppInterface)this.app).getMsgCache().a(str2, j, l);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        if (localEntityTransaction == null) {}
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      try
      {
        localEntityTransaction.begin();
        localSQLiteDatabase.delete(str1, null, null);
        if (localEntityTransaction != null) {
          localEntityTransaction.commit();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.TroopMsgProxy", 2, "clearAllHistoryFromDB: ", localException);
        if (localObject4 == null) {
          break label330;
        }
        localObject4.end();
        break label330;
      }
      finally
      {
        if (localObject4 == null) {
          continue;
        }
        localObject4.end();
      }
      if (localQSlowTableManager != null) {
        localQSlowTableManager.a(str1, null, null);
      }
      i += 1;
      break label59;
      break;
    }
  }
  
  public void e(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    super.e(paramString, paramInt, paramList);
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
    }
    finally
    {
      paramString.unlock();
    }
  }
  
  public List<MessageRecord> f(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + FileManagerUtil.e(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong1 + "] msgUid[" + paramLong2 + "]");
    }
    if ((paramLong1 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.proxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
    paramString = jdField_a_of_type_ComTencentImcoreMessageBaseMsgProxy$Callback.a(paramString, new String[] { String.valueOf(paramLong1) }, this);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> h(String paramString, int paramInt)
  {
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = super.h(paramString, paramInt);
      a(paramString);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy
 * JD-Core Version:    0.7.0.1
 */