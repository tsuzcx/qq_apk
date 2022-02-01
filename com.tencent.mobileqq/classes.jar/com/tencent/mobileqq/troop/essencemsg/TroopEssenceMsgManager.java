package com.tencent.mobileqq.troop.essencemsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceHandler;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsg;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsgSummary;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.BatchRspBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.MsgInfo;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.MsgProcessInfo;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.RspBody;

public class TroopEssenceMsgManager
  implements Manager
{
  protected ITroopEssenceHandler a;
  protected TroopEssenceMsgObserver b;
  protected MessageObserver c;
  protected HashMap<Long, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue>> d = new HashMap();
  protected HashMap<Long, ArrayList<TroopEssenceMsgManager.callbackInMainThread>> e = new HashMap();
  protected ArrayList<TroopEssenceMsgItem.TroopEssenceMsgPushItem> f = new ArrayList();
  protected HashSet<TroopEssenceMsgManager.WaittingEssenceMsgItem> g;
  private QQAppInterface h;
  private EntityManager i;
  
  public TroopEssenceMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.h = paramQQAppInterface;
    this.i = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.b = new TroopEssenceMsgManager.1(this);
    this.c = new TroopEssenceMsgManager.2(this);
    this.h.addObserver(this.b);
    this.h.addObserver(this.c);
    this.a = ((ITroopEssenceHandler)this.h.getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER));
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    if (e(paramLong) == null) {
      return;
    }
    if (paramInt != 0)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = BaseApplicationImpl.getContext().getResources().getString(2131917445);
      }
      if ((paramInt != 11002) && (paramInt != 11007))
      {
        QQToast.makeText(this.h.getApp(), 1, str, 0).show();
        return;
      }
      QQToast.makeText(this.h.getApp(), str, 0).show();
    }
  }
  
  private void a(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      a(paramLong, new TroopEssenceMsgManager.12(this, paramArrayList));
    }
  }
  
  private void a(TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem paramTroopBatchEssenceMsgPushItem)
  {
    if ((paramTroopBatchEssenceMsgPushItem != null) && (paramTroopBatchEssenceMsgPushItem.b != null))
    {
      if (paramTroopBatchEssenceMsgPushItem.b.isEmpty()) {
        return;
      }
      a(paramTroopBatchEssenceMsgPushItem.a, new TroopEssenceMsgManager.8(this, paramTroopBatchEssenceMsgPushItem));
    }
  }
  
  private void a(TroopEssenceMsgItem.TroopEssenceMsgPushItem paramTroopEssenceMsgPushItem)
  {
    if (paramTroopEssenceMsgPushItem != null)
    {
      if (paramTroopEssenceMsgPushItem.a == null) {
        return;
      }
      a(paramTroopEssenceMsgPushItem.a.troopUin, new TroopEssenceMsgManager.7(this, paramTroopEssenceMsgPushItem));
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && ((paramObject1 instanceof List)) && ((paramObject2 instanceof oidb_0xeac.BatchRspBody))) {}
    label660:
    label663:
    label682:
    for (;;)
    {
      int j;
      try
      {
        paramObject2 = (oidb_0xeac.BatchRspBody)paramObject2;
        paramObject1 = (List)paramObject1;
        if (paramObject1 != null)
        {
          if (paramObject1.isEmpty()) {
            return;
          }
          new HashSet(paramObject1);
          j = paramObject2.error_code.get();
          Object localObject1 = this.h;
          boolean bool2 = false;
          if (j != 0) {
            break label632;
          }
          bool1 = true;
          TroopEssenceReportUtil.a((QQAppInterface)localObject1, paramLong, bool1);
          localObject1 = this.h;
          bool1 = bool2;
          if (j == 0) {
            bool1 = true;
          }
          TroopEssenceReportUtil.b((QQAppInterface)localObject1, paramLong, bool1);
          localObject1 = paramObject2.wording.get();
          if (!QLog.isColorLevel()) {
            break label638;
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleBatchSetTroopEssenceMsg isSuccess:");
          ((StringBuilder)localObject2).append(paramBoolean);
          ((StringBuilder)localObject2).append(" oidbErrCode:");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" errCode:");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(" wording:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("TroopEssenceMsgManager", 1, ((StringBuilder)localObject2).toString());
          break label638;
          a(paramLong, paramInt, (String)localObject1);
          localObject1 = new HashMap(paramObject1.size());
          paramObject1 = paramObject1.iterator();
          if (paramObject1.hasNext())
          {
            localObject2 = (TroopEssenceMsgItem)paramObject1.next();
            if (localObject2 == null) {
              continue;
            }
            ((HashMap)localObject1).put(new TroopEssenceMsgItem.TroopEssenceMsgItemKey(((TroopEssenceMsgItem)localObject2).troopUin, ((TroopEssenceMsgItem)localObject2).msgSeq, ((TroopEssenceMsgItem)localObject2).msgRandom), localObject2);
            continue;
          }
          localObject2 = new ArrayList(((HashMap)localObject1).size());
          paramObject1 = paramObject2.msg_proc_infos.get().iterator();
          if (paramObject1.hasNext())
          {
            oidb_0xeac.MsgProcessInfo localMsgProcessInfo = (oidb_0xeac.MsgProcessInfo)paramObject1.next();
            if ((localMsgProcessInfo == null) || (!localMsgProcessInfo.msg.has())) {
              continue;
            }
            j = localMsgProcessInfo.error_code.get();
            if ((j != 0) && (j != 11002)) {
              if (j != 11007) {
                break label660;
              }
            }
            TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)((HashMap)localObject1).get(new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramLong, localMsgProcessInfo.msg.msg_seq.get(), localMsgProcessInfo.msg.msg_random.get()));
            if (localTroopEssenceMsgItem == null) {
              break label682;
            }
            localTroopEssenceMsgItem.opTime = 0L;
            if (!paramObject2.digest_time.has()) {
              break label663;
            }
            localTroopEssenceMsgItem.opTime = paramObject2.digest_time.get();
            break label663;
            if (localMsgProcessInfo.digest_uin.has()) {
              localTroopEssenceMsgItem.opUin = String.valueOf(localMsgProcessInfo.digest_uin.get());
            }
            ((ArrayList)localObject2).add(localTroopEssenceMsgItem);
            break label682;
          }
          if (!((ArrayList)localObject2).isEmpty()) {
            a(paramLong, (ArrayList)localObject2);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramObject1)
      {
        paramObject1.printStackTrace();
        paramObject2 = new StringBuilder();
        paramObject2.append("handleBatchSetTroopEssenceMsg exception:");
        paramObject2.append(paramObject1);
        QLog.i("TroopEssenceMsgManager", 1, paramObject2.toString());
      }
      return;
      a(paramLong, -1, null);
      return;
      label632:
      boolean bool1 = false;
      continue;
      label638:
      if ((j == 0) && (!paramBoolean))
      {
        paramInt = -1;
      }
      else
      {
        paramInt = j;
        continue;
        break label682;
        if (paramInt != 11002) {
          if (paramInt == 11007) {}
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && ((paramObject2 instanceof oidb_0xeac.RspBody)))
    {
      if (!(paramObject1 instanceof TroopEssenceMsgItem)) {
        return;
      }
      paramObject2 = (oidb_0xeac.RspBody)paramObject2;
      paramObject1 = (TroopEssenceMsgItem)paramObject1;
      int j = paramObject2.error_code.get();
      if (paramObject1.opType == 1)
      {
        boolean bool2 = false;
        long l;
        boolean bool1;
        if (paramInt2 == 1)
        {
          localObject = this.h;
          l = paramObject1.troopUin;
          paramInt2 = paramObject1.msgType;
          if (j == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          TroopEssenceReportUtil.a((QQAppInterface)localObject, l, paramInt2, bool1, 1);
        }
        else if (paramInt2 == 2)
        {
          localObject = this.h;
          l = paramObject1.troopUin;
          paramInt2 = paramObject1.msgType;
          if (j == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          TroopEssenceReportUtil.a((QQAppInterface)localObject, l, paramInt2, bool1);
          localObject = this.h;
          l = paramObject1.troopUin;
          paramInt2 = paramObject1.msgType;
          bool1 = bool2;
          if (j == 0) {
            bool1 = true;
          }
          TroopEssenceReportUtil.b((QQAppInterface)localObject, l, paramInt2, bool1);
        }
      }
      Object localObject = paramObject2.wording.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlerSetTroopEssenceMsg isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" oidbErrCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(j);
      localStringBuilder.append(" wording:");
      localStringBuilder.append((String)localObject);
      QLog.i("TroopEssenceMsgManager", 1, localStringBuilder.toString());
      paramInt1 = j;
      if (j == 0)
      {
        paramInt1 = j;
        if (!paramBoolean) {
          paramInt1 = -1;
        }
      }
      a(paramObject1.troopUin, paramInt1, (String)localObject);
      if ((paramInt1 == 0) || (paramInt1 == 11002) || (paramInt1 == 11007))
      {
        paramObject1.opTime = 0L;
        if ((paramInt1 == 11002) || (paramInt1 == 11007))
        {
          if (paramObject2.digest_uin.has()) {
            paramObject1.opUin = String.valueOf(paramObject2.digest_uin.get());
          }
          if (paramObject2.digest_time.has()) {
            paramObject1.opTime = paramObject2.digest_time.get();
          }
        }
        c(paramObject1);
      }
    }
  }
  
  private boolean a(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    if (paramTroopEssenceMsgItem == null) {
      return false;
    }
    Object localObject = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramTroopEssenceMsgItem.troopUin, paramTroopEssenceMsgItem.msgSeq, paramTroopEssenceMsgItem.msgRandom);
    HashMap localHashMap = (HashMap)this.d.get(Long.valueOf(((TroopEssenceMsgItem.TroopEssenceMsgItemKey)localObject).a));
    if (localHashMap != null)
    {
      localObject = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localHashMap.get(localObject);
      return (localObject == null) || (((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).d < paramTroopEssenceMsgItem.opTime);
    }
    return false;
  }
  
  private boolean a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg)
  {
    if (paramQQGroupDigestMsg.ext_info.has())
    {
      int j = paramQQGroupDigestMsg.ext_info.get();
      if (QLog.isColorLevel())
      {
        paramQQGroupDigestMsg = new StringBuilder();
        paramQQGroupDigestMsg.append("handleEssenceMsgGroupPushMain, ext_info: ");
        paramQQGroupDigestMsg.append(j);
        QLog.i("TroopEssenceMsgManager", 1, paramQQGroupDigestMsg.toString());
      }
      if (j == 3) {
        return true;
      }
    }
    return false;
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delEssenceMsgGrayTip troopUin:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" graytipuniseq:");
    localStringBuilder.append(paramLong2);
    QLog.i("TroopEssenceMsgManager", 2, localStringBuilder.toString());
    ThreadManager.excute(new TroopEssenceMsgManager.9(this, paramLong1, paramLong2), 32, null, true);
  }
  
  private void b(TroopEssenceMsgItem.TroopEssenceMsgPushItem paramTroopEssenceMsgPushItem)
  {
    if (paramTroopEssenceMsgPushItem != null)
    {
      if (paramTroopEssenceMsgPushItem.a == null) {
        return;
      }
      paramTroopEssenceMsgPushItem = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramTroopEssenceMsgPushItem.a.troopUin, paramTroopEssenceMsgPushItem.a.msgSeq, paramTroopEssenceMsgPushItem.a.msgRandom);
      Object localObject = (HashMap)this.d.get(Long.valueOf(paramTroopEssenceMsgPushItem.a));
      if (localObject != null)
      {
        localObject = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)((HashMap)localObject).get(paramTroopEssenceMsgPushItem);
        if ((localObject != null) && (((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).e != 0L)) {
          b(paramTroopEssenceMsgPushItem.a, ((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).e);
        }
      }
    }
  }
  
  private void b(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new TroopEssenceMsgManager.10(this, paramTroopEssenceMsgItem));
  }
  
  private void b(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg, boolean paramBoolean)
  {
    if (a(paramQQGroupDigestMsg)) {
      return;
    }
    paramQQGroupDigestMsg = TroopEssenceUtil.a(paramQQGroupDigestMsg);
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleEssenceMsgGroupPushMain holdMsg:");
      localStringBuilder.append(paramQQGroupDigestMsg.toString());
      QLog.i("TroopEssenceMsgManager", 1, localStringBuilder.toString());
      if (this.f.size() == 0)
      {
        this.f.add(paramQQGroupDigestMsg);
        ThreadManager.getUIHandler().postDelayed(new TroopEssenceMsgManager.5(this), 5000L);
        return;
      }
      this.f.add(paramQQGroupDigestMsg);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleEssenceMsgGroupPushMain msgItem:");
    localStringBuilder.append(paramQQGroupDigestMsg.toString());
    QLog.i("TroopEssenceMsgManager", 1, localStringBuilder.toString());
    a(paramQQGroupDigestMsg);
  }
  
  private boolean b(Entity paramEntity)
  {
    boolean bool2 = this.i.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.i.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.i.update(paramEntity);
      }
    }
    return false;
  }
  
  private void c(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new TroopEssenceMsgManager.11(this, paramTroopEssenceMsgItem));
  }
  
  private void d(long paramLong)
  {
    BaseChatPie localBaseChatPie = e(paramLong);
    if (localBaseChatPie != null) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopEssenceMsgManager", 2, "refreshAio");
        }
        localBaseChatPie.j(131072);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private BaseChatPie e(long paramLong)
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      Object localObject = (ChatFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if ((localObject != null) && ((localObject instanceof BaseTroopChatPie)) && (((BaseChatPie)localObject).bb() >= 2))
        {
          String str = ((BaseChatPie)localObject).ae();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramLong)))) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public long a(long paramLong)
  {
    return this.h.getApp().getSharedPreferences("essenceMsgShortBarLatestClickTime", 0).getLong(String.valueOf(paramLong), 0L);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a(paramLong1) > paramLong2) {
      return;
    }
    this.h.getApp().getSharedPreferences("essenceMsgShortBarLatestClickTime", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
  }
  
  public void a(long paramLong, TroopEssenceMsgManager.callbackInMainThread paramcallbackInMainThread)
  {
    if (paramcallbackInMainThread == null) {
      return;
    }
    if (this.d.containsKey(Long.valueOf(paramLong)))
    {
      paramcallbackInMainThread.a(paramLong, (HashMap)this.d.get(Long.valueOf(paramLong)));
      return;
    }
    if (!this.e.containsKey(Long.valueOf(paramLong)))
    {
      this.e.put(Long.valueOf(paramLong), new ArrayList(Arrays.asList(new TroopEssenceMsgManager.callbackInMainThread[] { paramcallbackInMainThread })));
      ThreadManager.excute(new TroopEssenceMsgManager.13(this, paramLong), 32, null, true);
      return;
    }
    ((ArrayList)this.e.get(Long.valueOf(paramLong))).add(paramcallbackInMainThread);
  }
  
  public void a(long paramLong, TroopTips0x857.QQGroupDigestMsgSummary paramQQGroupDigestMsgSummary, boolean paramBoolean)
  {
    if (paramQQGroupDigestMsgSummary == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.6(this, paramLong, paramQQGroupDigestMsgSummary, paramBoolean));
  }
  
  protected void a(Entity paramEntity)
  {
    ThreadManager.excute(new TroopEssenceMsgManager.14(this, paramEntity), 32, null, true);
  }
  
  public void a(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt)
  {
    if (paramTroopEssenceMsgItem == null) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ITroopEssenceHandler)localObject).a(paramTroopEssenceMsgItem, paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reqSetTroopEssenceMsg:");
    ((StringBuilder)localObject).append(paramTroopEssenceMsgItem.toString());
    QLog.i("TroopEssenceMsgManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.g == null) {
      this.g = new HashSet();
    }
    this.g.add(new TroopEssenceMsgManager.WaittingEssenceMsgItem(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = MultiMsgManager.a().i();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (!NetworkUtil.isNetSupport(this.h.getApp()))
      {
        a(0L, -1, BaseApplicationImpl.getContext().getResources().getString(2131889169));
        return;
      }
      long l;
      try
      {
        l = Long.parseLong(paramString1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l = 0L;
      }
      if (l == 0L) {
        return;
      }
      ArrayList localArrayList = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (localChatMessage != null)
        {
          TroopEssenceMsgItem localTroopEssenceMsgItem = new TroopEssenceMsgItem();
          localTroopEssenceMsgItem.troopUin = l;
          localTroopEssenceMsgItem.msgSeq = localChatMessage.shmsgseq;
          localTroopEssenceMsgItem.msgRandom = MessageUtils.b(localChatMessage.msgUid);
          localTroopEssenceMsgItem.opUin = paramString2;
          localTroopEssenceMsgItem.msgSenderUin = localChatMessage.senderuin;
          localTroopEssenceMsgItem.opType = 1;
          int j = TroopEssenceUtil.a(this.h, localChatMessage);
          localTroopEssenceMsgItem.msgType = j;
          localArrayList.add(localTroopEssenceMsgItem);
          TroopEssenceReportUtil.a(this.h, paramString1, j);
          TroopEssenceReportUtil.b(this.h, paramString1, j);
        }
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("reqBatchSetTroopEssenceMsg");
        paramString1.append(localArrayList.toString());
        QLog.i("TroopEssenceMsgManager", 1, paramString1.toString());
      }
      if (!localArrayList.isEmpty())
      {
        paramString1 = this.a;
        if (paramString1 == null) {
          return;
        }
        paramString1.a(l, localArrayList);
      }
    }
  }
  
  public void a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg, boolean paramBoolean)
  {
    if (paramQQGroupDigestMsg == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.4(this, paramQQGroupDigestMsg, paramBoolean));
  }
  
  public boolean a(TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey)
  {
    boolean bool2 = false;
    if (paramTroopEssenceMsgItemKey == null) {
      return false;
    }
    if (b(paramTroopEssenceMsgItemKey)) {
      return false;
    }
    HashMap localHashMap = (HashMap)this.d.get(Long.valueOf(paramTroopEssenceMsgItemKey.a));
    boolean bool1 = bool2;
    if (localHashMap != null)
    {
      paramTroopEssenceMsgItemKey = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localHashMap.get(paramTroopEssenceMsgItemKey);
      if (paramTroopEssenceMsgItemKey == null) {
        return false;
      }
      bool1 = bool2;
      if (paramTroopEssenceMsgItemKey.a == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long b(long paramLong)
  {
    Object localObject = (HashMap)this.d.get(Long.valueOf(paramLong));
    paramLong = 0L;
    long l = paramLong;
    if (localObject != null)
    {
      if (((HashMap)localObject).isEmpty()) {
        return 0L;
      }
      localObject = ((HashMap)localObject).entrySet().iterator();
      for (;;)
      {
        l = paramLong;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localTroopEssenceMsgItemValue.a == 1) && (localTroopEssenceMsgItemValue.d > paramLong)) {
          paramLong = localTroopEssenceMsgItemValue.d;
        }
      }
    }
    return l;
  }
  
  public void b(long paramLong, TroopTips0x857.QQGroupDigestMsgSummary paramQQGroupDigestMsgSummary, boolean paramBoolean)
  {
    a(TroopEssenceUtil.a(paramLong, paramQQGroupDigestMsgSummary));
  }
  
  public boolean b(TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey)
  {
    if ((HashMap)this.d.get(Long.valueOf(paramTroopEssenceMsgItemKey.a)) == null)
    {
      a(paramTroopEssenceMsgItemKey.a, new TroopEssenceMsgManager.3(this, paramTroopEssenceMsgItemKey));
      return true;
    }
    return false;
  }
  
  public TroopEssenceMsgItem.TroopEssenceMsgItemValue c(TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey)
  {
    if (paramTroopEssenceMsgItemKey == null) {
      return null;
    }
    HashMap localHashMap = (HashMap)this.d.get(Long.valueOf(paramTroopEssenceMsgItemKey.a));
    if (localHashMap == null) {
      return null;
    }
    return (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localHashMap.get(paramTroopEssenceMsgItemKey);
  }
  
  /* Error */
  protected HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> c(long paramLong)
  {
    // Byte code:
    //   0: new 34	java/util/HashMap
    //   3: dup
    //   4: invokespecial 35	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 60	com/tencent/mobileqq/troop/essencemsg/TroopEssenceMsgManager:i	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: ldc 172
    //   15: iconst_0
    //   16: ldc_w 730
    //   19: iconst_1
    //   20: anewarray 361	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: lload_1
    //   26: invokestatic 365	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 734	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   37: astore_3
    //   38: aload_3
    //   39: ifnull +140 -> 179
    //   42: aload_3
    //   43: invokeinterface 285 1 0
    //   48: astore_3
    //   49: aload_3
    //   50: invokeinterface 290 1 0
    //   55: ifeq +124 -> 179
    //   58: aload_3
    //   59: invokeinterface 294 1 0
    //   64: checkcast 172	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem
    //   67: astore 5
    //   69: aload 4
    //   71: new 296	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemKey
    //   74: dup
    //   75: aload 5
    //   77: getfield 175	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:troopUin	J
    //   80: aload 5
    //   82: getfield 299	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:msgSeq	J
    //   85: aload 5
    //   87: getfield 303	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:msgRandom	I
    //   90: invokespecial 306	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemKey:<init>	(JJI)V
    //   93: new 414	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemValue
    //   96: dup
    //   97: aload 5
    //   99: getfield 386	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:opType	I
    //   102: aload 5
    //   104: getfield 682	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:msgSenderUin	Ljava/lang/String;
    //   107: aload 5
    //   109: getfield 368	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:opUin	Ljava/lang/String;
    //   112: aload 5
    //   114: getfield 345	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:opTime	J
    //   117: aload 5
    //   119: getfield 737	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:graytipuniseq	J
    //   122: invokespecial 740	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemValue:<init>	(ILjava/lang/String;Ljava/lang/String;JJ)V
    //   125: invokevirtual 310	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: goto -80 -> 49
    //   132: astore_3
    //   133: goto +5 -> 138
    //   136: astore 5
    //   138: new 246	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   145: astore 5
    //   147: aload 5
    //   149: ldc_w 742
    //   152: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: aload_3
    //   159: invokevirtual 745	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc_w 267
    //   169: iconst_1
    //   170: aload 5
    //   172: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: aload_3
    //   176: invokestatic 748	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload 4
    //   181: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	TroopEssenceMsgManager
    //   0	182	1	paramLong	long
    //   37	22	3	localObject	Object
    //   132	1	3	localException	Exception
    //   7	63	4	localHashMap	HashMap
    //   67	51	5	localTroopEssenceMsgItem	TroopEssenceMsgItem
    // Exception table:
    //   from	to	target	type
    //   9	38	132	java/lang/Exception
    //   42	49	132	java/lang/Exception
    //   49	129	132	java/lang/Exception
  }
  
  public void onDestroy()
  {
    this.h.removeObserver(this.b);
    this.h.removeObserver(this.c);
    this.h.getMessageFacade();
    this.d.clear();
    this.e.clear();
    EntityManager localEntityManager = this.i;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager
 * JD-Core Version:    0.7.0.1
 */