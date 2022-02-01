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
  protected MessageObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  protected ITroopEssenceHandler a;
  protected TroopEssenceMsgObserver a;
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
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver = new TroopEssenceMsgManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopEssenceMsgManager.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopEssenceApiITroopEssenceHandler = ((ITroopEssenceHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER));
  }
  
  private BaseChatPie a(long paramLong)
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      Object localObject = (ChatFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof BaseTroopChatPie)) && (((BaseChatPie)localObject).d() >= 2))
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
    if (localBaseChatPie != null) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopEssenceMsgManager", 2, "refreshAio");
        }
        localBaseChatPie.e(131072);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    if (a(paramLong) == null) {
      return;
    }
    if (paramInt != 0)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = BaseApplicationImpl.getContext().getResources().getString(2131719840);
      }
      if ((paramInt != 11002) && (paramInt != 11007))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, str, 0).a();
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str, 0).a();
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
    if ((paramTroopBatchEssenceMsgPushItem != null) && (paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList != null))
    {
      if (paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        return;
      }
      a(paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_Long, new TroopEssenceMsgManager.8(this, paramTroopBatchEssenceMsgPushItem));
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
  
  private void a(TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    a(paramTroopEssenceMsgItem.troopUin, new TroopEssenceMsgManager.10(this, paramTroopEssenceMsgItem));
  }
  
  private void a(boolean paramBoolean, long paramLong, Object paramObject1, Object paramObject2, int paramInt)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && ((paramObject1 instanceof List)) && ((paramObject2 instanceof oidb_0xeac.BatchRspBody))) {}
    label659:
    label662:
    label681:
    for (;;)
    {
      int i;
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
          i = paramObject2.error_code.get();
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          boolean bool2 = false;
          if (i != 0) {
            break label631;
          }
          bool1 = true;
          TroopEssenceReportUtil.a((QQAppInterface)localObject1, paramLong, bool1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          bool1 = bool2;
          if (i == 0) {
            bool1 = true;
          }
          TroopEssenceReportUtil.b((QQAppInterface)localObject1, paramLong, bool1);
          localObject1 = paramObject2.wording.get();
          if (!QLog.isColorLevel()) {
            break label637;
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleBatchSetTroopEssenceMsg isSuccess:");
          ((StringBuilder)localObject2).append(paramBoolean);
          ((StringBuilder)localObject2).append(" oidbErrCode:");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" errCode:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" wording:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("TroopEssenceMsgManager", 1, ((StringBuilder)localObject2).toString());
          break label637;
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
            i = localMsgProcessInfo.error_code.get();
            if ((i != 0) && (i != 11002)) {
              if (i != 11007) {
                break label659;
              }
            }
            TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)((HashMap)localObject1).get(new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramLong, localMsgProcessInfo.msg.msg_seq.get(), localMsgProcessInfo.msg.msg_random.get()));
            if (localTroopEssenceMsgItem == null) {
              break label681;
            }
            localTroopEssenceMsgItem.opTime = 0L;
            if (!paramObject2.digest_time.has()) {
              break label662;
            }
            localTroopEssenceMsgItem.opTime = paramObject2.digest_time.get();
            break label662;
            if (localMsgProcessInfo.digest_uin.has()) {
              localTroopEssenceMsgItem.opUin = String.valueOf(localMsgProcessInfo.digest_uin.get());
            }
            ((ArrayList)localObject2).add(localTroopEssenceMsgItem);
            break label681;
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
      label631:
      boolean bool1 = false;
      continue;
      label637:
      if ((i == 0) && (!paramBoolean))
      {
        paramInt = -1;
      }
      else
      {
        paramInt = i;
        continue;
        break label681;
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
      int i = paramObject2.error_code.get();
      if (paramObject1.opType == 1)
      {
        boolean bool2 = false;
        long l;
        boolean bool1;
        if (paramInt2 == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l = paramObject1.troopUin;
          paramInt2 = paramObject1.msgType;
          if (i == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          TroopEssenceReportUtil.a((QQAppInterface)localObject, l, paramInt2, bool1, 1);
        }
        else if (paramInt2 == 2)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l = paramObject1.troopUin;
          paramInt2 = paramObject1.msgType;
          if (i == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          TroopEssenceReportUtil.a((QQAppInterface)localObject, l, paramInt2, bool1);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l = paramObject1.troopUin;
          paramInt2 = paramObject1.msgType;
          bool1 = bool2;
          if (i == 0) {
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
      localStringBuilder.append(i);
      localStringBuilder.append(" wording:");
      localStringBuilder.append((String)localObject);
      QLog.i("TroopEssenceMsgManager", 1, localStringBuilder.toString());
      paramInt1 = i;
      if (i == 0)
      {
        paramInt1 = i;
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
        b(paramObject1);
      }
    }
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
      }
    }
    return false;
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
      if (QLog.isColorLevel())
      {
        paramQQGroupDigestMsg = new StringBuilder();
        paramQQGroupDigestMsg.append("handleEssenceMsgGroupPushMain, ext_info: ");
        paramQQGroupDigestMsg.append(i);
        QLog.i("TroopEssenceMsgManager", 1, paramQQGroupDigestMsg.toString());
      }
      if (i == 3) {
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
      Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramTroopEssenceMsgPushItem.jdField_a_of_type_Long));
      if (localObject != null)
      {
        localObject = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)((HashMap)localObject).get(paramTroopEssenceMsgPushItem);
        if ((localObject != null) && (((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).b != 0L)) {
          b(paramTroopEssenceMsgPushItem.jdField_a_of_type_Long, ((TroopEssenceMsgItem.TroopEssenceMsgItemValue)localObject).b);
        }
      }
    }
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleEssenceMsgGroupPushMain holdMsg:");
      localStringBuilder.append(paramQQGroupDigestMsg.toString());
      QLog.i("TroopEssenceMsgManager", 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQGroupDigestMsg);
        ThreadManager.getUIHandler().postDelayed(new TroopEssenceMsgManager.5(this), 5000L);
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQQGroupDigestMsg);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleEssenceMsgGroupPushMain msgItem:");
    localStringBuilder.append(paramQQGroupDigestMsg.toString());
    QLog.i("TroopEssenceMsgManager", 1, localStringBuilder.toString());
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
  
  /* Error */
  protected HashMap<TroopEssenceMsgItem.TroopEssenceMsgItemKey, TroopEssenceMsgItem.TroopEssenceMsgItemValue> a(long paramLong)
  {
    // Byte code:
    //   0: new 27	java/util/HashMap
    //   3: dup
    //   4: invokespecial 28	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 53	com/tencent/mobileqq/troop/essencemsg/TroopEssenceMsgManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: ldc 233
    //   15: iconst_0
    //   16: ldc_w 570
    //   19: iconst_1
    //   20: anewarray 130	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: lload_1
    //   26: invokestatic 134	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 574	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   37: astore_3
    //   38: aload_3
    //   39: ifnull +139 -> 178
    //   42: aload_3
    //   43: invokeinterface 340 1 0
    //   48: astore_3
    //   49: aload_3
    //   50: invokeinterface 345 1 0
    //   55: ifeq +123 -> 178
    //   58: aload_3
    //   59: invokeinterface 349 1 0
    //   64: checkcast 233	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem
    //   67: astore 5
    //   69: aload 4
    //   71: new 351	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemKey
    //   74: dup
    //   75: aload 5
    //   77: getfield 236	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:troopUin	J
    //   80: aload 5
    //   82: getfield 354	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:msgSeq	J
    //   85: aload 5
    //   87: getfield 358	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:msgRandom	I
    //   90: invokespecial 361	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemKey:<init>	(JJI)V
    //   93: new 477	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemValue
    //   96: dup
    //   97: aload 5
    //   99: getfield 432	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:opType	I
    //   102: aload 5
    //   104: getfield 577	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:msgSenderUin	Ljava/lang/String;
    //   107: aload 5
    //   109: getfield 417	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:opUin	Ljava/lang/String;
    //   112: aload 5
    //   114: getfield 400	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:opTime	J
    //   117: aload 5
    //   119: getfield 580	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem:graytipuniseq	J
    //   122: invokespecial 583	com/tencent/mobileqq/troop/essence/data/TroopEssenceMsgItem$TroopEssenceMsgItemValue:<init>	(ILjava/lang/String;Ljava/lang/String;JJ)V
    //   125: invokevirtual 365	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: goto -80 -> 49
    //   132: astore_3
    //   133: goto +5 -> 138
    //   136: astore 5
    //   138: new 307	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   145: astore 5
    //   147: aload 5
    //   149: ldc_w 585
    //   152: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: aload_3
    //   159: invokevirtual 588	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 152
    //   168: iconst_1
    //   169: aload 5
    //   171: invokevirtual 329	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: aload_3
    //   175: invokestatic 591	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: aload 4
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	TroopEssenceMsgManager
    //   0	181	1	paramLong	long
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopEssenceApiITroopEssenceHandler;
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
    if (this.jdField_a_of_type_JavaUtilHashSet == null) {
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(new TroopEssenceMsgManager.WaittingEssenceMsgItem(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = MultiMsgManager.a().a();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
      {
        a(0L, -1, BaseApplicationImpl.getContext().getResources().getString(2131692183));
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
          int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
          localTroopEssenceMsgItem.msgType = i;
          localArrayList.add(localTroopEssenceMsgItem);
          TroopEssenceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, i);
          TroopEssenceReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, i);
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
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqTroopEssenceApiITroopEssenceHandler;
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
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long));
    boolean bool1 = bool2;
    if (localHashMap != null)
    {
      paramTroopEssenceMsgItemKey = (TroopEssenceMsgItem.TroopEssenceMsgItemValue)localHashMap.get(paramTroopEssenceMsgItemKey);
      if (paramTroopEssenceMsgItemKey == null) {
        return false;
      }
      bool1 = bool2;
      if (paramTroopEssenceMsgItemKey.jdField_a_of_type_Int == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long b(long paramLong)
  {
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
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
        if ((localTroopEssenceMsgItemValue.jdField_a_of_type_Int == 1) && (localTroopEssenceMsgItemValue.jdField_a_of_type_Long > paramLong)) {
          paramLong = localTroopEssenceMsgItemValue.jdField_a_of_type_Long;
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
    if ((HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long)) == null)
    {
      a(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long, new TroopEssenceMsgManager.3(this, paramTroopEssenceMsgItemKey));
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.b.clear();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager
 * JD-Core Version:    0.7.0.1
 */