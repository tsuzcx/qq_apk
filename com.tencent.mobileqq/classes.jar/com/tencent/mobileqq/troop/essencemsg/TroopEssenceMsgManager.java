package com.tencent.mobileqq.troop.essencemsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.troop.api.essence.ITroopEssenceService;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.mobileqq.troop.observer.TroopApiObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
  protected MessageObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  protected ITroopEssenceService a;
  protected TroopApiObserver a;
  protected ArrayList<TroopEssenceMsgItem.TroopEssenceMsgPushItem> a;
  protected HashMap<Long, HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue>> a;
  protected HashSet<TroopEssenceMsgManager.WaittingEssenceMsgItem> a;
  protected HashMap<Long, ArrayList<TroopEssenceMsgManager.callbackInMainThread>> b = new HashMap();
  
  public TroopEssenceMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver = new TroopEssenceMsgManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopEssenceMsgManager.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceITroopEssenceService = ((ITroopEssenceService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopEssenceService.class, ""));
  }
  
  private BaseChatPie a(long paramLong)
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof BaseTroopChatPie)) && (((BaseChatPie)localObject).h() >= 2))
        {
          String str = ((BaseChatPie)localObject).b();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramLong)))) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  private void a(long paramLong)
  {
    BaseChatPie localBaseChatPie = a(paramLong);
    if (localBaseChatPie != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 2, "refreshAio");
      }
      localBaseChatPie.g(131072);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    if (a(paramLong) == null) {}
    while (paramInt == 0) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131720108);
    }
    if ((paramInt == 11002) || (paramInt == 11007))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, str, 0).a();
  }
  
  private void a(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    a(paramLong, new TroopEssenceMsgManager.12(this, paramArrayList));
  }
  
  private void a(TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem paramTroopBatchEssenceMsgPushItem)
  {
    if ((paramTroopBatchEssenceMsgPushItem == null) || (paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    a(paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_Long, new TroopEssenceMsgManager.8(this, paramTroopBatchEssenceMsgPushItem));
  }
  
  private void a(TroopEssenceMsgItem.TroopEssenceMsgPushItem paramTroopEssenceMsgPushItem)
  {
    if ((paramTroopEssenceMsgPushItem == null) || (paramTroopEssenceMsgPushItem.a == null)) {
      return;
    }
    a(paramTroopEssenceMsgPushItem.a.troopUin, new TroopEssenceMsgManager.7(this, paramTroopEssenceMsgPushItem));
  }
  
  private void a(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new TroopEssenceMsgManager.10(this, paramTroopEssenceMsgItem));
  }
  
  private void a(boolean paramBoolean, long paramLong, Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((paramObject1 == null) || (paramObject2 == null) || (!(paramObject1 instanceof List)) || (!(paramObject2 instanceof oidb_0xeac.BatchRspBody)))
    {
      a(paramLong, -1, null);
      return;
    }
    int i;
    for (;;)
    {
      boolean bool;
      try
      {
        paramObject2 = (oidb_0xeac.BatchRspBody)paramObject2;
        localObject1 = (List)paramObject1;
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break;
        }
        new HashSet((Collection)localObject1);
        i = paramObject2.error_code.get();
        paramObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (i != 0) {
          break label334;
        }
        bool = true;
        TroopEssenceReportUtil.a(paramObject1, paramLong, bool);
        paramObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (i != 0) {
          break label340;
        }
        bool = true;
        TroopEssenceReportUtil.b(paramObject1, paramLong, bool);
        paramObject1 = paramObject2.wording.get();
        if (!QLog.isColorLevel()) {
          break label585;
        }
        QLog.i("TroopEssenceMsgManager", 1, "handleBatchSetTroopEssenceMsg isSuccess:" + paramBoolean + " oidbErrCode:" + paramInt + " errCode:" + i + " wording:" + paramObject1);
      }
      catch (Exception paramObject1)
      {
        label205:
        paramObject1.printStackTrace();
        QLog.i("TroopEssenceMsgManager", 1, "handleBatchSetTroopEssenceMsg exception:" + paramObject1);
        return;
      }
      a(paramLong, paramInt, paramObject1);
      paramObject1 = new HashMap(((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label346;
      }
      localObject2 = (TroopEssenceMsgItem)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        paramObject1.put(new TroopEssenceMsgItem.TroopEssenceMsgItemKey(((TroopEssenceMsgItem)localObject2).troopUin, ((TroopEssenceMsgItem)localObject2).msgSeq, ((TroopEssenceMsgItem)localObject2).msgRandom), localObject2);
        continue;
        label334:
        bool = false;
        continue;
        label340:
        bool = false;
      }
    }
    label346:
    Object localObject1 = new ArrayList(paramObject1.size());
    Object localObject2 = paramObject2.msg_proc_infos.get().iterator();
    label375:
    oidb_0xeac.MsgProcessInfo localMsgProcessInfo;
    TroopEssenceMsgItem localTroopEssenceMsgItem;
    while (((Iterator)localObject2).hasNext())
    {
      localMsgProcessInfo = (oidb_0xeac.MsgProcessInfo)((Iterator)localObject2).next();
      if ((localMsgProcessInfo != null) && (localMsgProcessInfo.msg.has()))
      {
        i = localMsgProcessInfo.error_code.get();
        if ((i == 0) || (i == 11002) || (i == 11007))
        {
          localTroopEssenceMsgItem = (TroopEssenceMsgItem)paramObject1.get(new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramLong, localMsgProcessInfo.msg.msg_seq.get(), localMsgProcessInfo.msg.msg_random.get()));
          if (localTroopEssenceMsgItem != null)
          {
            localTroopEssenceMsgItem.opTime = 0L;
            if (!paramObject2.digest_time.has()) {
              break label600;
            }
            localTroopEssenceMsgItem.opTime = paramObject2.digest_time.get();
            break label600;
          }
        }
      }
    }
    for (;;)
    {
      label524:
      if (localMsgProcessInfo.digest_uin.has()) {
        localTroopEssenceMsgItem.opUin = String.valueOf(localMsgProcessInfo.digest_uin.get());
      }
      label585:
      label600:
      do
      {
        ((ArrayList)localObject1).add(localTroopEssenceMsgItem);
        break label375;
        if (((ArrayList)localObject1).isEmpty()) {
          break;
        }
        a(paramLong, (ArrayList)localObject1);
        return;
        do
        {
          paramInt = i;
          break;
        } while ((i != 0) || (paramBoolean));
        paramInt = -1;
        break label205;
        if (paramInt == 11002) {
          break label524;
        }
      } while (paramInt != 11007);
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramObject1 == null) || (paramObject2 == null) || (!(paramObject2 instanceof oidb_0xeac.RspBody)) || (!(paramObject1 instanceof TroopEssenceMsgItem))) {
      return;
    }
    paramObject2 = (oidb_0xeac.RspBody)paramObject2;
    paramObject1 = (TroopEssenceMsgItem)paramObject1;
    int i = paramObject2.error_code.get();
    Object localObject;
    long l;
    if (paramObject1.opType == 1)
    {
      if (paramInt2 == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l = paramObject1.troopUin;
        paramInt2 = paramObject1.msgType;
        if (i == 0) {
          bool1 = true;
        }
        TroopEssenceReportUtil.a((QQAppInterface)localObject, l, paramInt2, bool1, 1);
      }
    }
    else
    {
      label100:
      localObject = paramObject2.wording.get();
      QLog.i("TroopEssenceMsgManager", 1, "handlerSetTroopEssenceMsg isSuccess:" + paramBoolean + " oidbErrCode:" + paramInt1 + " errCode:" + i + " wording:" + (String)localObject);
      if ((i != 0) || (paramBoolean)) {
        break label379;
      }
    }
    label379:
    for (paramInt1 = -1;; paramInt1 = i)
    {
      a(paramObject1.troopUin, paramInt1, (String)localObject);
      if ((paramInt1 != 0) && (paramInt1 != 11002) && (paramInt1 != 11007)) {
        break;
      }
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
      b(paramObject1);
      return;
      if (paramInt2 != 2) {
        break label100;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l = paramObject1.troopUin;
      paramInt2 = paramObject1.msgType;
      if (i == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        TroopEssenceReportUtil.a((QQAppInterface)localObject, l, paramInt2, bool1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l = paramObject1.troopUin;
        paramInt2 = paramObject1.msgType;
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
        TroopEssenceReportUtil.b((QQAppInterface)localObject, l, paramInt2, bool1);
        break;
      }
    }
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  private boolean a(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    if (paramTroopEssenceMsgItem == null) {
      return false;
    }
    Object localObject = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramTroopEssenceMsgItem.troopUin, paramTroopEssenceMsgItem.msgSeq, paramTroopEssenceMsgItem.msgRandom);
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((TroopEssenceMsgItem.TroopEssenceMsgItemKey)localObject).jdField_a_of_type_Long));
    if (localHashMap != null)
    {
      localObject = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localHashMap.get(localObject);
      return (localObject == null) || (((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).jdField_a_of_type_Long < paramTroopEssenceMsgItem.opTime);
    }
    return false;
  }
  
  private boolean a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg)
  {
    if (paramQQGroupDigestMsg.ext_info.has())
    {
      int i = paramQQGroupDigestMsg.ext_info.get();
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain, ext_info: " + i);
      }
      if (i == 3) {
        return true;
      }
    }
    return false;
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    QLog.i("TroopEssenceMsgManager", 2, "delEssenceMsgGrayTip troopUin:" + paramLong1 + " graytipuniseq:" + paramLong2);
    ThreadManager.excute(new TroopEssenceMsgManager.9(this, paramLong1, paramLong2), 32, null, true);
  }
  
  private void b(TroopEssenceMsgItem.TroopEssenceMsgPushItem paramTroopEssenceMsgPushItem)
  {
    if ((paramTroopEssenceMsgPushItem == null) || (paramTroopEssenceMsgPushItem.a == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        paramTroopEssenceMsgPushItem = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramTroopEssenceMsgPushItem.a.troopUin, paramTroopEssenceMsgPushItem.a.msgSeq, paramTroopEssenceMsgPushItem.a.msgRandom);
        localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramTroopEssenceMsgPushItem.jdField_a_of_type_Long));
      } while (localObject == null);
      localObject = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)((HashMap)localObject).get(paramTroopEssenceMsgPushItem);
    } while ((localObject == null) || (((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).b == 0L));
    b(paramTroopEssenceMsgPushItem.jdField_a_of_type_Long, ((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).b);
  }
  
  private void b(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new TroopEssenceMsgManager.11(this, paramTroopEssenceMsgItem));
  }
  
  private void b(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg, boolean paramBoolean)
  {
    if (a(paramQQGroupDigestMsg)) {
      return;
    }
    paramQQGroupDigestMsg = TroopEssenceUtil.a(paramQQGroupDigestMsg);
    if (paramBoolean)
    {
      QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain holdMsg:" + paramQQGroupDigestMsg.toString());
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQGroupDigestMsg);
        ThreadManager.getUIHandler().postDelayed(new TroopEssenceMsgManager.5(this), 5000L);
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQQGroupDigestMsg);
      return;
    }
    QLog.i("TroopEssenceMsgManager", 1, "handleEssenceMsgGroupPushMain msgItem:" + paramQQGroupDigestMsg.toString());
    a(paramQQGroupDigestMsg);
  }
  
  public long a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("essenceMsgShortBarLatestClickTime", 0).getLong(String.valueOf(paramLong), 0L);
  }
  
  public TroopEssenceMsgItem.TroopEssenceMsgItemValue a(TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey)
  {
    if (paramTroopEssenceMsgItemKey == null) {
      return null;
    }
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long));
    if (localHashMap == null) {
      return null;
    }
    return (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localHashMap.get(paramTroopEssenceMsgItemKey);
  }
  
  protected HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> a(long paramLong)
  {
    localHashMap = new HashMap();
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TroopEssenceMsgItem.class, false, "troopUin=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)((Iterator)localObject).next();
          localHashMap.put(new TroopEssenceMsgItem.TroopEssenceMsgItemKey(localTroopEssenceMsgItem.troopUin, localTroopEssenceMsgItem.msgSeq, localTroopEssenceMsgItem.msgRandom), new TroopEssenceMsgItem.TroopEssenceMsgItemValue(localTroopEssenceMsgItem.opType, localTroopEssenceMsgItem.msgSenderUin, localTroopEssenceMsgItem.opUin, localTroopEssenceMsgItem.opTime, localTroopEssenceMsgItem.graytipuniseq));
        }
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      QLog.e("TroopEssenceMsgManager", 1, "readEntity exception + " + localException.getMessage(), localException);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a(paramLong1) > paramLong2) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("essenceMsgShortBarLatestClickTime", 0).edit().putLong(String.valueOf(paramLong1), paramLong2).commit();
  }
  
  public void a(long paramLong, TroopEssenceMsgManager.callbackInMainThread paramcallbackInMainThread)
  {
    if (paramcallbackInMainThread == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      paramcallbackInMainThread.a(paramLong, (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      return;
    }
    if (!this.b.containsKey(Long.valueOf(paramLong)))
    {
      this.b.put(Long.valueOf(paramLong), new ArrayList(Arrays.asList(new TroopEssenceMsgManager.callbackInMainThread[] { paramcallbackInMainThread })));
      ThreadManager.excute(new TroopEssenceMsgManager.13(this, paramLong), 32, null, true);
      return;
    }
    ((ArrayList)this.b.get(Long.valueOf(paramLong))).add(paramcallbackInMainThread);
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceITroopEssenceService != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceITroopEssenceService.reqSetTroopEssenceMsg(paramTroopEssenceMsgItem, paramInt);
    }
    QLog.i("TroopEssenceMsgManager", 1, "reqSetTroopEssenceMsg:" + paramTroopEssenceMsgItem.toString());
  }
  
  public void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashSet == null) {
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(new TroopEssenceMsgManager.WaittingEssenceMsgItem(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = MultiMsgManager.a().a();
    if ((localObject == null) || (((List)localObject).size() == 0) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    do
    {
      for (;;)
      {
        return;
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
        {
          a(0L, -1, BaseApplicationImpl.getContext().getResources().getString(2131692257));
          return;
        }
        try
        {
          l = Long.parseLong(paramString1);
          if (l != 0L)
          {
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
                int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
                localTroopEssenceMsgItem.msgType = i;
                localArrayList.add(localTroopEssenceMsgItem);
                TroopEssenceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, i);
                TroopEssenceReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, i);
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            l = 0L;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopEssenceMsgManager", 1, "reqBatchSetTroopEssenceMsg" + localException.toString());
          }
        }
      }
    } while ((localException == null) || (localException.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceITroopEssenceService == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceITroopEssenceService.batchReqSetTroopEssenceMsg(l, localException);
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
    if (paramTroopEssenceMsgItemKey == null) {}
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return false;
        } while (b(paramTroopEssenceMsgItemKey));
        localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long));
      } while (localHashMap == null);
      paramTroopEssenceMsgItemKey = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localHashMap.get(paramTroopEssenceMsgItemKey);
    } while (paramTroopEssenceMsgItemKey == null);
    if (paramTroopEssenceMsgItemKey.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public long b(long paramLong)
  {
    long l1 = 0L;
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    long l2 = l1;
    if (localObject != null)
    {
      if (((HashMap)localObject).isEmpty()) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    localObject = ((HashMap)localObject).entrySet().iterator();
    paramLong = l1;
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue;
    do
    {
      l2 = paramLong;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localTroopEssenceMsgItemValue = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)((Map.Entry)((Iterator)localObject).next()).getValue();
    } while (localTroopEssenceMsgItemValue.jdField_a_of_type_Int != 1);
    if (localTroopEssenceMsgItemValue.jdField_a_of_type_Long > paramLong) {
      paramLong = localTroopEssenceMsgItemValue.jdField_a_of_type_Long;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void b(long paramLong, TroopTips0x857.QQGroupDigestMsgSummary paramQQGroupDigestMsgSummary, boolean paramBoolean)
  {
    a(TroopEssenceUtil.a(paramLong, paramQQGroupDigestMsgSummary));
  }
  
  public boolean b(TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey)
  {
    if ((HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long)) == null)
    {
      a(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long, new TroopEssenceMsgManager.3(this, paramTroopEssenceMsgItemKey));
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {}
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.b.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager
 * JD-Core Version:    0.7.0.1
 */