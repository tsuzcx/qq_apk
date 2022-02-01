package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.troop.api.ITroopAioKeywordService;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Map;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class TroopAioKeywordTipManager
  implements Manager
{
  protected QQAppInterface a;
  protected final List<String> b = new ArrayList();
  protected final Map<String, TroopAioKeywordInfo> c = new HashMap();
  protected final SparseArray<TroopAioKeywordRuleInfo> d = new SparseArray();
  protected final SparseArray<TroopAioKeywordTipInfo> e = new SparseArray();
  protected final List<String> f = new ArrayList();
  protected boolean g = false;
  protected boolean h = false;
  
  public TroopAioKeywordTipManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    int i = 2147483647;
    Object localObject2;
    int j;
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (String)localIterator.next();
        j = paramString.indexOf((String)localObject2);
      } while ((j < 0) || (j >= i));
      if (j == 0) {
        return localObject2;
      }
    }
  }
  
  private List<Integer> a(MessageRecord arg1)
  {
    Object localObject1 = ???.getExtInfoFromExtStr("key_aio_keyword");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      synchronized (this.c)
      {
        localObject1 = (TroopAioKeywordInfo)this.c.get(localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((TroopAioKeywordInfo)localObject1).b;
          return localObject1;
        }
      }
    }
    return null;
  }
  
  private void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo, TroopAioKeywordTipManager.Callback paramCallback)
  {
    if (paramCallback != null) {
      ThreadManager.getUIHandler().post(new TroopAioKeywordTipManager.5(this, paramCallback, paramMessageRecord, paramTroopAioKeywordTipInfo));
    }
  }
  
  private void a(Integer paramInteger, MessageRecord paramMessageRecord, TroopAioKeywordTipManager.Callback paramCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramInteger);
    ((ITroopAioKeywordService)this.a.getRuntimeService(ITroopAioKeywordService.class, "")).getTroopAioKeywordTipInfo(localArrayList, new TroopAioKeywordTipManager.4(this, paramMessageRecord, paramCallback));
  }
  
  private boolean a(Integer paramInteger, int paramInt, MessageRecord paramMessageRecord)
  {
    synchronized (this.d)
    {
      Object localObject1 = (TroopAioKeywordRuleInfo)this.d.get(paramInteger.intValue());
      if (localObject1 == null) {
        return false;
      }
      synchronized (this.f)
      {
        if (!this.h)
        {
          this.f.addAll(TroopAioKeywordHelper.a(this.a));
          this.h = true;
        }
        paramInteger = b(this.a.getCurrentAccountUin(), paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword"), paramInteger);
        if ((!paramMessageRecord.isSend()) && (this.f.contains(paramInteger)))
        {
          if (QLog.isColorLevel())
          {
            paramMessageRecord = new StringBuilder();
            paramMessageRecord.append("isSupportedRuleId, blackUinKeyRuleId=");
            paramMessageRecord.append(paramInteger);
            QLog.i("TroopAioKeywordTipManager", 2, paramMessageRecord.toString());
          }
          return false;
        }
        if ((((TroopAioKeywordRuleInfo)localObject1).b <= NetConnInfoCenter.getServerTime()) && (((TroopAioKeywordRuleInfo)localObject1).c >= NetConnInfoCenter.getServerTime()))
        {
          if ((((TroopAioKeywordRuleInfo)localObject1).d & paramInt) == 0)
          {
            if (QLog.isColorLevel())
            {
              paramInteger = new StringBuilder();
              paramInteger.append("isSupportedRuleId, not support positionFlag, ruleInfo.positionFlag=");
              paramInteger.append(((TroopAioKeywordRuleInfo)localObject1).d);
              paramInteger.append(", curInvokeType=");
              paramInteger.append(paramInt);
              QLog.i("TroopAioKeywordTipManager", 2, paramInteger.toString());
            }
            return false;
          }
          if ((((TroopAioKeywordRuleInfo)localObject1).e != null) && (((TroopAioKeywordRuleInfo)localObject1).e.size() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, ruleInfo.troopTypes == null");
            }
            paramInteger = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramMessageRecord.frienduin);
            if (!((TroopAioKeywordRuleInfo)localObject1).e.contains(Integer.valueOf((int)paramInteger.dwGroupClassExt)))
            {
              if (QLog.isColorLevel())
              {
                paramMessageRecord = new StringBuilder();
                paramMessageRecord.append("[");
                localObject1 = ((TroopAioKeywordRuleInfo)localObject1).e.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  paramMessageRecord.append(((Integer)((Iterator)localObject1).next()).intValue());
                  paramMessageRecord.append(",");
                }
                paramMessageRecord.append("]");
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("isSupportedRuleId, not support troopType, troopTypes=");
                ((StringBuilder)localObject1).append(paramMessageRecord.toString());
                ((StringBuilder)localObject1).append(",mCurType=");
                ((StringBuilder)localObject1).append(paramInteger.dwGroupClassExt);
                QLog.i("TroopAioKeywordTipManager", 2, ((StringBuilder)localObject1).toString());
              }
              return false;
            }
          }
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramInteger = new StringBuilder();
          paramInteger.append("isSupportedRuleId, not support timelimit, currentTime=");
          paramInteger.append(NetConnInfoCenter.getServerTime());
          paramInteger.append(",ruleInfo.startTime =");
          paramInteger.append(((TroopAioKeywordRuleInfo)localObject1).b);
          paramInteger.append(",ruleInfo.endTime=");
          paramInteger.append(((TroopAioKeywordRuleInfo)localObject1).c);
          QLog.i("TroopAioKeywordTipManager", 2, paramInteger.toString());
        }
        return false;
      }
    }
    for (;;)
    {
      throw paramInteger;
    }
  }
  
  private String b(String paramString1, String paramString2, Integer paramInteger)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInteger);
    return localStringBuilder.toString();
  }
  
  private void b(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ThreadManager.post(new TroopAioKeywordTipManager.2(this, paramList), 8, null, true);
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    a();
    synchronized (this.b)
    {
      if (this.b.size() == 0) {
        return false;
      }
      if (TextUtils.equals(paramMessageRecord.getExtInfoFromExtStr("key_is_checked_aio_keyword"), "1")) {
        return TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword")) ^ true;
      }
      Object localObject2 = c(paramMessageRecord);
      ??? = null;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = a((String)localIterator.next());
        ??? = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramMessageRecord.saveExtInfoToExtStr("key_aio_keyword", (String)localObject2);
          ??? = localObject2;
        }
      }
      paramMessageRecord.saveExtInfoToExtStr("key_is_checked_aio_keyword", "1");
      this.a.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
      return TextUtils.isEmpty((CharSequence)???) ^ true;
    }
    for (;;)
    {
      throw paramMessageRecord;
    }
  }
  
  private List<String> c(MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord.msgtype != -1000) && (paramMessageRecord.msgtype != -1051))
    {
      if (paramMessageRecord.msgtype == -2011)
      {
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        if (paramMessageRecord.structingMsg == null) {
          paramMessageRecord.parse();
        }
        if ((paramMessageRecord.structingMsg instanceof AbsShareMsg))
        {
          paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
          if (!TextUtils.isEmpty(paramMessageRecord.mContentTitle)) {
            localArrayList.add(paramMessageRecord.mContentTitle.toLowerCase());
          }
          if (!TextUtils.isEmpty(paramMessageRecord.mContentSummary)) {
            localArrayList.add(paramMessageRecord.mContentSummary.toLowerCase());
          }
          if (!TextUtils.isEmpty(paramMessageRecord.mMsgUrl))
          {
            localArrayList.add(paramMessageRecord.mMsgUrl.toLowerCase());
            return localArrayList;
          }
        }
      }
    }
    else
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      if (paramMessageRecord.sb == null) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord.sb != null) {
        localArrayList.add(paramMessageRecord.sb.toString().toLowerCase());
      }
    }
    return localArrayList;
  }
  
  public Pair<MessageRecord, Integer> a(List<MessageRecord> paramList, List<String> paramList1, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    paramList = null;
    Object localObject2;
    Object localObject3;
    label205:
    do
    {
      MessageRecord localMessageRecord;
      do
      {
        localObject2 = localObject1;
        localObject3 = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
      } while (!b(localMessageRecord));
      Object localObject4 = a(localMessageRecord);
      localObject2 = localObject1;
      localObject3 = paramList;
      if (localObject4 != null)
      {
        localObject2 = localObject1;
        localObject3 = paramList;
        if (((List)localObject4).size() > 0)
        {
          localObject4 = ((List)localObject4).iterator();
          do
          {
            do
            {
              localObject2 = localObject1;
              localObject3 = paramList;
              if (!((Iterator)localObject4).hasNext()) {
                break label205;
              }
              localObject2 = (Integer)((Iterator)localObject4).next();
              if (paramList1 == null) {
                break;
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(localMessageRecord.getExtInfoFromExtStr("key_aio_keyword"));
              ((StringBuilder)localObject3).append("_");
              ((StringBuilder)localObject3).append(localObject2);
            } while (paramList1.contains(((StringBuilder)localObject3).toString()));
          } while (!a((Integer)localObject2, paramInt, localMessageRecord));
          localObject3 = localMessageRecord;
        }
      }
      localObject1 = localObject2;
      paramList = (List<MessageRecord>)localObject3;
    } while (localObject2 == null);
    return new Pair(localObject3, localObject2);
  }
  
  public void a()
  {
    try
    {
      if (!this.g)
      {
        oidb_0x496.AioKeyword localAioKeyword = TroopAioKeywordHelper.a();
        a(TroopAioKeywordHelper.a(localAioKeyword), TroopAioKeywordHelper.b(localAioKeyword));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString1, String paramString2, Integer paramInteger)
  {
    ThreadManager.post(new TroopAioKeywordTipManager.6(this, paramString1, paramString2, paramInteger), 8, null, true);
  }
  
  public void a(List<? extends MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ThreadManager.post(new TroopAioKeywordTipManager.1(this, paramList), 5, null, true);
    }
  }
  
  public void a(List<TroopAioKeywordInfo> arg1, List<TroopAioKeywordRuleInfo> paramList1)
  {
    if (??? != null) {}
    try
    {
      synchronized (this.b)
      {
        this.b.clear();
        Object localObject2 = ???.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TroopAioKeywordInfo localTroopAioKeywordInfo = (TroopAioKeywordInfo)((Iterator)localObject2).next();
          this.b.add(localTroopAioKeywordInfo.a.toLowerCase());
        }
        synchronized (this.c)
        {
          this.c.clear();
          ??? = ???.iterator();
          if (???.hasNext())
          {
            localObject2 = (TroopAioKeywordInfo)???.next();
            this.c.put(((TroopAioKeywordInfo)localObject2).a.toLowerCase(), localObject2);
          }
        }
      }
      if (paramList1 != null) {
        synchronized (this.d)
        {
          this.d.clear();
          paramList1 = paramList1.iterator();
          if (paramList1.hasNext())
          {
            ??? = (TroopAioKeywordRuleInfo)paramList1.next();
            this.d.put(((TroopAioKeywordRuleInfo)???).a, ???);
          }
        }
      }
      this.g = true;
      return;
    }
    finally
    {
      label233:
      break label233;
    }
    for (;;)
    {
      throw ???;
    }
  }
  
  public void a(List<MessageRecord> paramList, List<String> paramList1, int paramInt, TroopAioKeywordTipManager.Callback paramCallback)
  {
    ThreadManager.post(new TroopAioKeywordTipManager.3(this, paramList, paramList1, paramInt, paramCallback), 8, null, true);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager
 * JD-Core Version:    0.7.0.1
 */