package com.tencent.mobileqq.troop.data;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TroopMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public int a;
  private HashMap<String, HashSet<String>> a;
  public boolean a;
  public int b;
  public long b;
  public int c = 0;
  public int d = 0;
  
  public TroopMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0)
    {
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (paramInt == 2)
      {
        if ((!((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).isTroopMark(paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type)) && (!localHotChatManager.b(paramConversationInfo.uin))) {
          return ConversationFacade.a(paramConversationInfo);
        }
        return 0;
      }
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  public MessageForGrayTips a(QQAppInterface paramQQAppInterface, String paramString, TroopTipsEntity paramTroopTipsEntity)
  {
    if ((paramString != null) && (paramTroopTipsEntity != null))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addTroopTipsMessage troopTipsEntity.optShowLatest:");
        ((StringBuilder)localObject).append(paramTroopTipsEntity.optShowLatest);
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
      }
      if (((paramQQAppInterface.getMessageFacade().a() == 1) && (paramString.equals(paramQQAppInterface.getMessageFacade().a()))) || (paramTroopTipsEntity.need2InsertIntoMsgListRightNow()))
      {
        paramString = paramQQAppInterface.getMessageProxy(1).b(paramString, 1);
        int n = 0;
        int i;
        if (paramString == null) {
          i = 0;
        } else {
          i = paramString.size();
        }
        int m = n;
        if (paramTroopTipsEntity.repeatInterval > 0)
        {
          m = n;
          if (i > 0)
          {
            int j;
            if (paramTroopTipsEntity.repeatInterval < paramString.size()) {
              j = paramTroopTipsEntity.repeatInterval;
            } else {
              j = paramString.size();
            }
            int k = 0;
            for (;;)
            {
              m = n;
              if (k >= j) {
                break;
              }
              localObject = (MessageRecord)paramString.get(i - j + k);
              if ((((MessageRecord)localObject).msgtype == 2024) && (String.valueOf(paramTroopTipsEntity.serviceType).equals(((MessageRecord)localObject).getExtInfoFromExtStr("gray_tips_serviceType"))))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("Q.msg.BaseMessageManager", 2, String.format("processTroopTipsEntity discard seq:%s interval:%d", new Object[] { Long.valueOf(paramTroopTipsEntity.msgSeq), Integer.valueOf(paramTroopTipsEntity.repeatInterval) }));
                }
                m = 1;
                break;
              }
              k += 1;
            }
          }
        }
        paramTroopTipsEntity.read = true;
        paramQQAppInterface = (TroopTipsMsgMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
        if ((paramQQAppInterface != null) && (m == 0)) {
          return paramQQAppInterface.b(paramTroopTipsEntity);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "saveTroopTips");
        }
        paramString = (TroopTipsMsgMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
        if (paramString != null) {
          paramString.a(paramQQAppInterface, paramTroopTipsEntity);
        }
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "addTroopTipsMessage parm null");
    }
    return null;
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin().equals(paramString1)) {
      paramString2 = HardCodeUtil.a(2131715436);
    } else {
      paramString2 = ContactUtils.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramString2, paramString1);
    }
    if (paramString2 == null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<TroopNotificationCache> paramArrayList, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "addTroopNotificationMessage");
    }
    paramString1 = paramQQAppInterface.getMessageProxy(1).d(String.valueOf(paramString2), 1);
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramInt1 == 23))
    {
      paramString1 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)localIterator.next();
        localTroopNotificationCache.read = true;
        localTroopNotificationCache.currentUin = paramQQAppInterface.getCurrentAccountUin();
        paramString1.persist(localTroopNotificationCache);
      }
      paramString1.close();
    }
    TroopNotificationHelper.a(paramQQAppInterface, paramString2, paramArrayList, paramInt2, paramInt3, paramString3);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap2 = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Map localMap1 = paramAddMessageContext.b;
    Object localObject3 = paramAddMessageContext.c;
    Object localObject2 = (TroopInfoManager)paramAddMessageContext.jdField_a_of_type_MqqManagerManager;
    Object localObject1 = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int k = paramMessageRecord.istroop;
    long l1 = paramMessageRecord.time;
    localObject1 = ((RecentUserProxy)localObject1).a(str1, paramMessageRecord.istroop);
    if (localObject2 != null)
    {
      localMessageInfo = ((TroopInfoManager)localObject2).a(str1);
      if (localMessageInfo != null)
      {
        if (localMessageInfo.a() != paramMessageRecord.shmsgseq) {
          break label173;
        }
        if (paramMessageRecord.isread)
        {
          ((TroopInfoManager)localObject2).b(str1);
          break label173;
        }
      }
      break label176;
    }
    label173:
    MessageInfo localMessageInfo = null;
    label176:
    int i = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getTroopMask(str1);
    localObject2 = "Q.msg.BaseMessageManager";
    boolean bool;
    if (k == 1)
    {
      if ((((RecentUser)localObject1).msgType != 24) && (localMessageInfo != null) && (localMessageInfo.a() == 24))
      {
        if ((i != 1) && (i != 4))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getTroopMask(((RecentUser)localObject1).uin) == 2) {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          }
        }
        else {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_norm", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        }
      }
      else if ((((RecentUser)localObject1).msgType != 17) && (((RecentUser)localObject1).msgType != 22) && (((RecentUser)localObject1).msgType != 24) && (localMessageInfo != null) && (localMessageInfo.a() == 17))
      {
        bool = paramMessageRecord instanceof MessageForQQWalletMsg;
        if ((i != 3) && (i != 4))
        {
          if (i == 2)
          {
            if (bool) {
              ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
            } else {
              ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
            }
          }
          else if (i == 1) {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_norm", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          }
        }
        else if (bool) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_allscreen", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_allscreen", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        }
      }
      else if ((((RecentUser)localObject1).msgType != 17) && (((RecentUser)localObject1).msgType != 22) && (((RecentUser)localObject1).msgType != 24) && (((RecentUser)localObject1).msgType != 13) && (localMessageInfo != null) && (localMessageInfo.a() == 13))
      {
        if ((i != 3) && (i != 4))
        {
          if (i == 2) {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          } else if (i == 1) {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_norm", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          }
        }
        else {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_allscreen", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, "addMessageRecord");
        }
      }
      if ((!paramMessageRecord.isSend()) && (localMessageInfo != null) && (localMessageInfo.a() == 17) && (((HotChatManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(str1)) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8005C8D", "0X8005C8D", 0, 0, "", "", "", "");
      }
      if (MessageForQQWalletMsg.isCommandRedPacketMsg(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "group command red packet, UI_BUSY");
        }
        mqq.app.MainService.sPwdPacketTime = System.currentTimeMillis();
        ThreadPriorityManager.a(true);
      }
      if (paramMessageRecord.senderuin.equals(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin())) {
        IceBreakingUtil.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord.frienduin, k, paramMessageRecord);
      }
    }
    if ((localMessageInfo != null) && (localMessageInfo.a()))
    {
      int j = localMessageInfo.a();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addMessageRecord, bizType");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("|ru.msgType:");
        ((StringBuilder)localObject2).append(((RecentUser)localObject1).msgType);
        QLog.d("Q.msg.BaseMessageManager.troop.special_msg.special_attention", 2, ((StringBuilder)localObject2).toString());
      }
      label1206:
      long l3;
      long l2;
      Object localObject4;
      Object localObject5;
      if (MessageInfo.a(j, ((RecentUser)localObject1).msgType))
      {
        ((RecentUser)localObject1).msgType = j;
        ((RecentUser)localObject1).msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, str1, localMessageInfo, ((RecentUser)localObject1).msg, paramMessageRecord, true);
        if (!TroopAssistantManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, str1))
        {
          ((RecentUser)localObject1).uin = str1;
          if ((k != 1000) && (k != 1020)) {
            if (k != 1004) {
              break label1206;
            }
          }
          ((RecentUser)localObject1).troopUin = str2;
          ((RecentUser)localObject1).setType(k);
          l3 = ((RecentUser)localObject1).lastmsgtime;
          l2 = l1;
          if (l2 > l3) {
            ((RecentUser)localObject1).lastmsgtime = l2;
          }
          localMap2.put(UinTypeUtil.a(str1, k), localObject1);
        }
        if ((k != 1) && (k != 3000)) {}
        for (;;)
        {
          break;
          localObject2 = "";
          int m = j;
          if (m == 8)
          {
            m = i;
            if (m == 2) {
              localObject2 = "msg_assist";
            } else if (m == 1) {
              localObject2 = "msg_public";
            }
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_public", "", "oper", (String)localObject2, 0, 0, str1, "", "", "");
          }
          else
          {
            localObject4 = localObject1;
            int n = i;
            if (m == 22)
            {
              if (k == 3000) {
                localObject2 = "Grp_Dis_replyMsg";
              } else {
                localObject2 = "Grp_replyMsg";
              }
              localObject5 = this.jdField_a_of_type_MqqAppAppRuntime;
              l2 = l1;
              String str3 = ((RecentUser)localObject4).troopUin;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(n);
              ReportController.b((AppRuntime)localObject5, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign", 0, 0, str3, localStringBuilder.toString(), "", "");
              if ((n != 3) && (n != 4))
              {
                l1 = l2;
                if (n == 2)
                {
                  ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_grphelper", 0, 0, ((RecentUser)localObject4).troopUin, "", "", "");
                  l1 = l2;
                }
              }
              else
              {
                ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_allscreen", 0, 0, ((RecentUser)localObject4).troopUin, "", "", "");
                l1 = l2;
              }
            }
            else {}
          }
        }
      }
      if (k == 1)
      {
        if ((j != 24) && (j != 22))
        {
          localObject2 = "Q.msg.BaseMessageManager";
          break label1756;
        }
        if ((!AnonymousChatHelper.a(paramMessageRecord)) && (TroopUtils.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "atMeOrReplyMe")))
        {
          localObject2 = paramMessageRecord.frienduin;
          localObject4 = paramMessageRecord.senderuin;
          l2 = paramMessageRecord.time;
          l3 = paramMessageRecord.msgseq;
          localObject5 = ThreadManager.getSubThreadHandler();
          ((MqqHandler)localObject5).post(new TroopMessageManager.1(this, (String)localObject2, (String)localObject4, j, l2, l3));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("markAtOrReplyMeMsgInTroop|");
            ((StringBuilder)localObject2).append(l3);
            QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = "Q.msg.BaseMessageManager";
          break label1756;
        }
      }
      localObject2 = "Q.msg.BaseMessageManager";
    }
    label1756:
    if (localMap2.containsKey(UinTypeUtil.a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType()))) {
      localObject1 = (RecentUser)localMap2.get(UinTypeUtil.a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType()));
    }
    if (((HotChatManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(str1))
    {
      if (((Map)localObject3).containsKey(UinTypeUtil.a(str1, k))) {
        if (((MessageRecord)((Map)localObject3).get(UinTypeUtil.a(str1, k))).time > paramMessageRecord.time) {
          break label2394;
        }
      }
      ((Map)localObject3).put(UinTypeUtil.a(str1, k), paramMessageRecord);
    }
    else
    {
      localObject3 = paramMessageRecord;
      if ((!MsgProxyUtils.b(((MessageRecord)localObject3).msgtype)) && (!TroopManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, (MessageRecord)localObject3))) {
        if ((k == 1) && (i != 1) && (i != 4))
        {
          if (localMessageInfo == null) {
            i = 0;
          } else {
            i = localMessageInfo.a();
          }
          if ((i == 17) || (i == 24) || (i == 16) || (i == 13) || (i == 5) || (i == 26) || (i == 18) || (i == 22) || (i == 14) || (i == 4) || (i == 10) || (i == 11))
          {
            ((RecentUser)localObject1).uin = str1;
            if ((k == 1000) || (k == 1020) || (k == 1004)) {
              ((RecentUser)localObject1).troopUin = str2;
            }
            ((RecentUser)localObject1).setType(k);
            if (l1 > ((RecentUser)localObject1).lastmsgtime) {
              ((RecentUser)localObject1).lastmsgtime = l1;
            }
            localMap2.put(UinTypeUtil.a(str1, k), localObject1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("addMessageRecord, MsgBizType:");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append("uin:");
              ((StringBuilder)localObject2).append(((RecentUser)localObject1).uin);
              QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, ((StringBuilder)localObject2).toString());
            }
          }
          if ((TroopAssistantManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, str1)) && ((!localMap1.containsKey(UinTypeUtil.a(str1, k))) || (((MessageRecord)localMap1.get(UinTypeUtil.a(str1, k))).time <= ((MessageRecord)localObject3).time))) {
            localMap1.put(UinTypeUtil.a(str1, k), localObject3);
          }
        }
        else if ((paramMessageRecord.isLongMsg()) && (((MessageCache)this.jdField_a_of_type_MqqAppAppRuntime.getMsgCache()).a((MessageRecord)localObject3)))
        {
          if (QLog.isColorLevel()) {
            QLog.i((String)localObject2, 2, "addMessageRecord, long msg uncompleted");
          }
        }
        else
        {
          ((RecentUser)localObject1).uin = str1;
          ((RecentUser)localObject1).setType(k);
          if ((localObject3 instanceof MessageForUniteGrayTip)) {
            bool = ((MessageForUniteGrayTip)localObject3).tipParam.d;
          } else {
            bool = true;
          }
          if ((l1 > ((RecentUser)localObject1).lastmsgtime) && (bool)) {
            ((RecentUser)localObject1).lastmsgtime = l1;
          }
          localMap2.put(UinTypeUtil.a(str1, k), localObject1);
        }
      }
    }
    label2394:
    super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramMessageRecord);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    c(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    super.a(paramString, paramInt, paramLong, paramBoolean);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getTroopMask(paramString1);
    if ((paramInt == 1) && (i != 1) && (i != 4))
    {
      if (i == 2) {
        paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
      }
      try
      {
        TroopAssistantManager.a().a(paramString1, paramLong, paramString2, (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
        paramString2.close();
      }
      finally
      {
        paramString2.close();
      }
      return;
    }
    super.a(paramString1, paramInt, paramString2, paramString3, paramLong);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramString, paramInt, paramBoolean1, paramBoolean2);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    super.a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramString);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramLong2);
      localObject = ((StringBuilder)localObject).toString();
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        ((HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).add(localObject);
      }
      else
      {
        HashSet localHashSet = new HashSet();
        localHashSet.add(localObject);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localHashSet);
      }
      return;
    }
    finally {}
  }
  
  protected String b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin().equals(paramString1)) {
      paramString2 = HardCodeUtil.a(2131715437);
    } else {
      paramString2 = ContactUtils.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramString2, paramString1);
    }
    if (paramString2 == null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    Object localObject = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(paramString, paramInt);
    c(paramString, paramInt, 9223372036854775807L);
    if ((RecentUserAppearLogic.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localRecentUser.msgType)) || (localRecentUser.msgType == 11))
    {
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      ((RecentUserProxy)localObject).b(localRecentUser);
    }
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getTroopMask(paramString);
      if ((paramInt != 1) && (paramInt != 4))
      {
        paramString = RecentDataListManager.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRecentUser.uin);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(localRecentUser.getType());
        paramString.a(((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.removeRecentUser(localRecentUser);
      }
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade.getUnreadCount(paramString, paramInt) > 0) {
      c(paramString, paramInt, paramLong);
    }
    super.b(paramString, paramInt, paramLong);
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        Object localObject = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("");
        localStringBuilder.append(paramLong2);
        ((HashSet)localObject).remove(localStringBuilder.toString());
        if (((HashSet)localObject).isEmpty())
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          setChanged();
          notifyObservers();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("并发拉取完成，troopUin:");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getRefreshActionMap().containsKey(UinTypeUtil.a(paramString, paramInt));
  }
  
  public boolean c(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
      return !bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageManager
 * JD-Core Version:    0.7.0.1
 */