package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
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
import com.tencent.mobileqq.activity.aio.AIOAssist;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
  public boolean h = false;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public long m = -1L;
  private HashMap<String, HashSet<String>> n = new HashMap();
  
  public TroopMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0)
    {
      HotChatManager localHotChatManager = (HotChatManager)this.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (paramInt == 2)
      {
        if ((!((QQAppInterface)this.a).isTroopMark(paramConversationInfo.uin, paramConversationInfo.type)) && (this.c.isUinInRecentList(paramConversationInfo.uin, paramConversationInfo.type)) && (!localHotChatManager.b(paramConversationInfo.uin))) {
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
      if (((paramQQAppInterface.getMessageFacade().m() == 1) && (paramString.equals(paramQQAppInterface.getMessageFacade().l()))) || (paramTroopTipsEntity.need2InsertIntoMsgListRightNow()))
      {
        paramString = paramQQAppInterface.getMessageProxy(1).c(paramString, 1);
        int i5 = 0;
        int i1;
        if (paramString == null) {
          i1 = 0;
        } else {
          i1 = paramString.size();
        }
        int i4 = i5;
        if (paramTroopTipsEntity.repeatInterval > 0)
        {
          i4 = i5;
          if (i1 > 0)
          {
            int i2;
            if (paramTroopTipsEntity.repeatInterval < paramString.size()) {
              i2 = paramTroopTipsEntity.repeatInterval;
            } else {
              i2 = paramString.size();
            }
            int i3 = 0;
            for (;;)
            {
              i4 = i5;
              if (i3 >= i2) {
                break;
              }
              localObject = (MessageRecord)paramString.get(i1 - i2 + i3);
              if ((((MessageRecord)localObject).msgtype == 2024) && (String.valueOf(paramTroopTipsEntity.serviceType).equals(((MessageRecord)localObject).getExtInfoFromExtStr("gray_tips_serviceType"))))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("Q.msg.BaseMessageManager", 2, String.format("processTroopTipsEntity discard seq:%s interval:%d", new Object[] { Long.valueOf(paramTroopTipsEntity.msgSeq), Integer.valueOf(paramTroopTipsEntity.repeatInterval) }));
                }
                i4 = 1;
                break;
              }
              i3 += 1;
            }
          }
        }
        paramTroopTipsEntity.read = true;
        paramQQAppInterface = (TroopTipsMsgMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
        if ((paramQQAppInterface != null) && (i4 == 0)) {
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
    if (this.a.getCurrentAccountUin().equals(paramString1)) {
      paramString2 = HardCodeUtil.a(2131912914);
    } else {
      paramString2 = ContactUtils.b((QQAppInterface)this.a, paramString2, paramString1);
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
    paramString1 = AIOAssist.a();
    if ((paramString1 != null) && (paramString1.ah != null) && (!TextUtils.isEmpty(paramString1.ag())) && (paramString1.bb() < 5) && (paramString1.ag().equals(paramString2)) && (paramInt1 == 23))
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
    Map localMap2 = paramAddMessageContext.a;
    Map localMap1 = paramAddMessageContext.b;
    Object localObject3 = paramAddMessageContext.c;
    Object localObject2 = (TroopInfoManager)paramAddMessageContext.i;
    Object localObject1 = paramAddMessageContext.k;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.c();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int i3 = paramMessageRecord.istroop;
    long l1 = paramMessageRecord.time;
    localObject1 = ((RecentUserProxy)localObject1).b(str1, paramMessageRecord.istroop);
    if (localObject2 != null)
    {
      localMessageInfo = ((TroopInfoManager)localObject2).a(str1);
      if (localMessageInfo != null)
      {
        if (localMessageInfo.b() != paramMessageRecord.shmsgseq) {
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
    int i1 = this.c.getTroopMask(str1);
    localObject2 = "Q.msg.BaseMessageManager";
    boolean bool;
    if (i3 == 1)
    {
      if ((((RecentUser)localObject1).msgType != 24) && (localMessageInfo != null) && (localMessageInfo.a() == 24))
      {
        if ((i1 != 1) && (i1 != 4))
        {
          if (this.c.getTroopMask(((RecentUser)localObject1).uin) == 2) {
            ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          }
        }
        else {
          ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_norm", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        }
      }
      else if ((((RecentUser)localObject1).msgType != 17) && (((RecentUser)localObject1).msgType != 22) && (((RecentUser)localObject1).msgType != 24) && (localMessageInfo != null) && (localMessageInfo.a() == 17))
      {
        bool = paramMessageRecord instanceof MessageForQQWalletMsg;
        if ((i1 != 3) && (i1 != 4))
        {
          if (i1 == 2)
          {
            if (bool) {
              ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
            } else {
              ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
            }
          }
          else if (i1 == 1) {
            ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_norm", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          }
        }
        else if (bool) {
          ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_allscreen", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        } else {
          ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_allscreen", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        }
      }
      else if ((((RecentUser)localObject1).msgType != 17) && (((RecentUser)localObject1).msgType != 22) && (((RecentUser)localObject1).msgType != 24) && (((RecentUser)localObject1).msgType != 13) && (localMessageInfo != null) && (localMessageInfo.a() == 13))
      {
        if ((i1 != 3) && (i1 != 4))
        {
          if (i1 == 2) {
            ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_grphelper", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          } else if (i1 == 1) {
            ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_norm", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
          }
        }
        else {
          ReportController.b(this.a, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_allscreen", 0, 0, ((RecentUser)localObject1).uin, "", "", "");
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, "addMessageRecord");
        }
      }
      if ((!paramMessageRecord.isSend()) && (localMessageInfo != null) && (localMessageInfo.a() == 17) && (((HotChatManager)this.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(str1)) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
        ReportController.b(this.a, "CliOper", "", "", "0X8005C8D", "0X8005C8D", 0, 0, "", "", "", "");
      }
      if (MessageForQQWalletMsg.isCommandRedPacketMsg(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "group command red packet, UI_BUSY");
        }
        mqq.app.MainService.sPwdPacketTime = System.currentTimeMillis();
        ThreadPriorityManager.a(true);
      }
      if (paramMessageRecord.senderuin.equals(this.a.getCurrentAccountUin())) {
        IceBreakingUtil.a((QQAppInterface)this.a, paramMessageRecord.frienduin, i3, paramMessageRecord);
      }
    }
    if ((localMessageInfo != null) && (localMessageInfo.e()))
    {
      int i2 = localMessageInfo.a();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addMessageRecord, bizType");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append("|ru.msgType:");
        ((StringBuilder)localObject2).append(((RecentUser)localObject1).msgType);
        QLog.d("Q.msg.BaseMessageManager.troop.special_msg.special_attention", 2, ((StringBuilder)localObject2).toString());
      }
      label1206:
      long l3;
      long l2;
      Object localObject4;
      Object localObject5;
      if (MessageInfo.a(i2, ((RecentUser)localObject1).msgType))
      {
        ((RecentUser)localObject1).msgType = i2;
        ((RecentUser)localObject1).msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a((QQAppInterface)this.a, str1, localMessageInfo, ((RecentUser)localObject1).msg, paramMessageRecord, true);
        if (!TroopAssistantManager.a().a((QQAppInterface)this.a, str1))
        {
          ((RecentUser)localObject1).uin = str1;
          if ((i3 != 1000) && (i3 != 1020)) {
            if (i3 != 1004) {
              break label1206;
            }
          }
          ((RecentUser)localObject1).troopUin = str2;
          ((RecentUser)localObject1).setType(i3);
          l3 = ((RecentUser)localObject1).lastmsgtime;
          l2 = l1;
          if (l2 > l3) {
            ((RecentUser)localObject1).lastmsgtime = l2;
          }
          localMap2.put(UinTypeUtil.a(str1, i3), localObject1);
        }
        if ((i3 != 1) && (i3 != 3000)) {}
        for (;;)
        {
          break;
          localObject2 = "";
          int i4 = i2;
          if (i4 == 8)
          {
            i4 = i1;
            if (i4 == 2) {
              localObject2 = "msg_assist";
            } else if (i4 == 1) {
              localObject2 = "msg_public";
            }
            ReportController.b(this.a, "P_CliOper", "Grp_public", "", "oper", (String)localObject2, 0, 0, str1, "", "", "");
          }
          else
          {
            localObject4 = localObject1;
            int i5 = i1;
            if (i4 == 22)
            {
              if (i3 == 3000) {
                localObject2 = "Grp_Dis_replyMsg";
              } else {
                localObject2 = "Grp_replyMsg";
              }
              localObject5 = this.a;
              l2 = l1;
              String str3 = ((RecentUser)localObject4).troopUin;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(i5);
              ReportController.b((AppRuntime)localObject5, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign", 0, 0, str3, localStringBuilder.toString(), "", "");
              if ((i5 != 3) && (i5 != 4))
              {
                l1 = l2;
                if (i5 == 2)
                {
                  ReportController.b(this.a, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_grphelper", 0, 0, ((RecentUser)localObject4).troopUin, "", "", "");
                  l1 = l2;
                }
              }
              else
              {
                ReportController.b(this.a, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_allscreen", 0, 0, ((RecentUser)localObject4).troopUin, "", "", "");
                l1 = l2;
              }
            }
            else {}
          }
        }
      }
      if (i3 == 1)
      {
        if ((i2 != 24) && (i2 != 22))
        {
          localObject2 = "Q.msg.BaseMessageManager";
          break label1756;
        }
        if ((!AnonymousChatHelper.c(paramMessageRecord)) && (TroopUtils.b((QQAppInterface)this.a, "atMeOrReplyMe")))
        {
          localObject2 = paramMessageRecord.frienduin;
          localObject4 = paramMessageRecord.senderuin;
          l2 = paramMessageRecord.time;
          l3 = paramMessageRecord.msgseq;
          localObject5 = ThreadManager.getSubThreadHandler();
          ((MqqHandler)localObject5).post(new TroopMessageManager.1(this, (String)localObject2, (String)localObject4, i2, l2, l3));
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
    if (((HotChatManager)this.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(str1))
    {
      if (((Map)localObject3).containsKey(UinTypeUtil.a(str1, i3))) {
        if (((MessageRecord)((Map)localObject3).get(UinTypeUtil.a(str1, i3))).time > paramMessageRecord.time) {
          break label2394;
        }
      }
      ((Map)localObject3).put(UinTypeUtil.a(str1, i3), paramMessageRecord);
    }
    else
    {
      localObject3 = paramMessageRecord;
      if ((!MsgProxyUtils.b(((MessageRecord)localObject3).msgtype)) && (!TroopManager.a((QQAppInterface)this.a, (MessageRecord)localObject3))) {
        if ((i3 == 1) && (i1 != 1) && (i1 != 4))
        {
          if (localMessageInfo == null) {
            i1 = 0;
          } else {
            i1 = localMessageInfo.a();
          }
          if ((i1 == 17) || (i1 == 24) || (i1 == 16) || (i1 == 13) || (i1 == 5) || (i1 == 26) || (i1 == 18) || (i1 == 22) || (i1 == 14) || (i1 == 4) || (i1 == 10) || (i1 == 11))
          {
            ((RecentUser)localObject1).uin = str1;
            if ((i3 == 1000) || (i3 == 1020) || (i3 == 1004)) {
              ((RecentUser)localObject1).troopUin = str2;
            }
            ((RecentUser)localObject1).setType(i3);
            if (l1 > ((RecentUser)localObject1).lastmsgtime) {
              ((RecentUser)localObject1).lastmsgtime = l1;
            }
            localMap2.put(UinTypeUtil.a(str1, i3), localObject1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("addMessageRecord, MsgBizType:");
              ((StringBuilder)localObject2).append(i1);
              ((StringBuilder)localObject2).append("uin:");
              ((StringBuilder)localObject2).append(((RecentUser)localObject1).uin);
              QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, ((StringBuilder)localObject2).toString());
            }
          }
          if ((TroopAssistantManager.a().a((QQAppInterface)this.a, str1)) && ((!localMap1.containsKey(UinTypeUtil.a(str1, i3))) || (((MessageRecord)localMap1.get(UinTypeUtil.a(str1, i3))).time <= ((MessageRecord)localObject3).time))) {
            localMap1.put(UinTypeUtil.a(str1, i3), localObject3);
          }
        }
        else if ((paramMessageRecord.isLongMsg()) && (((MessageCache)this.a.getMsgCache()).b((MessageRecord)localObject3)))
        {
          if (QLog.isColorLevel()) {
            QLog.i((String)localObject2, 2, "addMessageRecord, long msg uncompleted");
          }
        }
        else
        {
          ((RecentUser)localObject1).uin = str1;
          ((RecentUser)localObject1).setType(i3);
          if ((localObject3 instanceof MessageForUniteGrayTip)) {
            bool = ((MessageForUniteGrayTip)localObject3).tipParam.l;
          } else {
            bool = true;
          }
          if ((l1 > ((RecentUser)localObject1).lastmsgtime) && (bool)) {
            ((RecentUser)localObject1).lastmsgtime = l1;
          }
          localMap2.put(UinTypeUtil.a(str1, i3), localObject1);
        }
      }
    }
    label2394:
    super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface)this.a, paramMessageRecord);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    int i1 = this.c.getTroopMask(paramString1);
    if ((paramInt == 1) && (i1 != 1) && (i1 != 4))
    {
      if (i1 == 2) {
        paramString2 = this.a.getEntityManagerFactory().createEntityManager();
      }
      try
      {
        TroopAssistantManager.a().a(paramString1, paramLong, paramString2, (QQAppInterface)this.a);
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
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    super.a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.a.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.b(paramString);
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
      if (this.n.containsKey(paramString))
      {
        ((HashSet)this.n.get(paramString)).add(localObject);
      }
      else
      {
        HashSet localHashSet = new HashSet();
        localHashSet.add(localObject);
        this.n.put(paramString, localHashSet);
      }
      return;
    }
    finally {}
  }
  
  protected String b(String paramString1, String paramString2)
  {
    if (this.a.getCurrentAccountUin().equals(paramString1)) {
      paramString2 = HardCodeUtil.a(2131912915);
    } else {
      paramString2 = ContactUtils.b((QQAppInterface)this.a, paramString2, paramString1);
    }
    if (paramString2 == null) {
      return paramString1;
    }
    return paramString2;
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    super.b(paramString, paramInt, paramLong);
    d(paramString, paramInt, paramLong);
  }
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    super.b(paramString, paramInt, paramLong, paramBoolean);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.a.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.b(paramString);
    }
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramString, paramInt, paramBoolean1, paramBoolean2);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.a.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.b(paramString);
    }
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.n.containsKey(paramString))
      {
        Object localObject = (HashSet)this.n.get(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("");
        localStringBuilder.append(paramLong2);
        ((HashSet)localObject).remove(localStringBuilder.toString());
        if (((HashSet)localObject).isEmpty())
        {
          this.n.remove(paramString);
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
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    if (this.c.getUnreadCount(paramString, paramInt) > 0) {
      d(paramString, paramInt, paramLong);
    }
    super.c(paramString, paramInt, paramLong);
  }
  
  public boolean c(String paramString)
  {
    try
    {
      boolean bool = this.n.containsKey(paramString);
      return !bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    super.d(paramString, paramInt);
    Object localObject = ((IRecentUserProxyService)this.a.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).b(paramString, paramInt);
    d(paramString, paramInt, 9223372036854775807L);
    if ((RecentUserAppearLogic.a((QQAppInterface)this.a, localRecentUser.msgType)) || (localRecentUser.msgType == 11))
    {
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      ((RecentUserProxy)localObject).b(localRecentUser);
    }
    if (paramInt == 1)
    {
      paramInt = this.c.getTroopMask(paramString);
      if ((paramInt != 1) && (paramInt != 4))
      {
        paramString = RecentDataListManager.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRecentUser.uin);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(localRecentUser.getType());
        paramString.b(((StringBuilder)localObject).toString());
        this.b.removeRecentUser(localRecentUser);
      }
    }
  }
  
  public boolean f(String paramString, int paramInt)
  {
    return this.b.getRefreshActionMap().containsKey(UinTypeUtil.a(paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageManager
 * JD-Core Version:    0.7.0.1
 */