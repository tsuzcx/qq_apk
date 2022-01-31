package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.BaseMessageManager.AddMessageContext;
import com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TroopMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public static long b;
  public int a;
  public long a;
  private HashMap a;
  public boolean a;
  public int b;
  public int c;
  
  public TroopMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0)
    {
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type)) && (!localHotChatManager.b(paramConversationInfo.uin))) {
          return ConversationFacade.a(paramConversationInfo);
        }
        return 0;
      }
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  public MessageForGrayTips a(QQAppInterface paramQQAppInterface, String paramString, TroopTipsEntity paramTroopTipsEntity)
  {
    if ((paramString == null) || (paramTroopTipsEntity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addTroopTipsMessage parm null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "addTroopTipsMessage troopTipsEntity.optShowLatest:" + paramTroopTipsEntity.optShowLatest);
    }
    if (((paramQQAppInterface.a().a() == 1) && (paramString.equals(paramQQAppInterface.a().a()))) || (paramTroopTipsEntity.need2InsertIntoMsgListRightNow()))
    {
      paramTroopTipsEntity.read = true;
      paramQQAppInterface = (TroopTipsMsgMgr)paramQQAppInterface.getManager(80);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.b(paramTroopTipsEntity);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "saveTroopTips");
      }
      paramString = (TroopTipsMsgMgr)paramQQAppInterface.getManager(80);
      if (paramString != null) {
        paramString.a(paramQQAppInterface, paramTroopTipsEntity);
      }
    }
    return null;
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1)) {}
    for (paramString2 = "我"; paramString2 == null; paramString2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1)) {
      return paramString1;
    }
    return paramString2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "addTroopNotificationMessage");
    }
    paramString1 = paramQQAppInterface.a(1).e(String.valueOf(paramString2), 1);
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramInt1 == 23))
    {
      paramString1 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)localIterator.next();
        localTroopNotificationCache.read = true;
        localTroopNotificationCache.currentUin = paramQQAppInterface.getCurrentAccountUin();
        paramString1.a(localTroopNotificationCache);
      }
      paramString1.a();
    }
    TroopNotificationHelper.a(paramQQAppInterface, paramString2, paramArrayList, paramInt2, paramInt3);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap1 = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Map localMap2 = paramAddMessageContext.b;
    Map localMap3 = paramAddMessageContext.c;
    Object localObject2 = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager;
    Object localObject1 = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int j = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((RecentUserProxy)localObject1).a(str1, paramMessageRecord.istroop);
    if (localObject2 != null)
    {
      localObject1 = ((TroopInfoManager)localObject2).a(str1);
      if (localObject1 != null) {
        if (((MessageInfo)localObject1).b() != paramMessageRecord.shmsgseq) {
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str1);
      if (j == 1)
      {
        if ((localRecentUser.msgType == 20) || (localObject1 == null) || (((MessageInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) != 20)) {
          break label799;
        }
        if ((i != 1) && (i != 4)) {
          break label742;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_norm", 0, 0, localRecentUser.uin, "", "", "");
        label246:
        if ((!paramMessageRecord.isSend()) && (localObject1 != null) && (((MessageInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) == 14) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(str1)) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8D", "0X8005C8D", 0, 0, "", "", "", "");
        }
        if (MessageForQQWalletMsg.isCommandRedPacketMsg(paramMessageRecord))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "group command red packet, UI_BUSY");
          }
          mqq.app.MainService.sPwdPacketTime = System.currentTimeMillis();
          ThreadPriorityManager.a(true);
        }
      }
      int k;
      if ((localObject1 != null) && (((MessageInfo)localObject1).a()))
      {
        k = ((MessageInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.troop.special_msg.special_attention", 2, "addMessageRecord, bizType" + k + "|ru.msgType:" + localRecentUser.msgType);
        }
        if (MessageInfo.a(k, localRecentUser.msgType))
        {
          localRecentUser.msgType = k;
          localRecentUser.msg = MessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, (MessageInfo)localObject1, localRecentUser.msg, paramMessageRecord, true);
          localMap1.put(MsgProxyUtils.a(str1, j), localRecentUser);
          if ((j == 1) || (j == 3000))
          {
            if (k != 8) {
              break label1335;
            }
            localObject2 = "";
            if (i != 2) {
              break label1321;
            }
            localObject2 = "msg_assist";
            label542:
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", (String)localObject2, 0, 0, str1, "", "", "");
          }
        }
      }
      label576:
      if (localMap1.containsKey(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type))) {}
      for (localObject2 = (RecentUser)localMap1.get(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type));; localObject2 = localRecentUser)
      {
        if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(str1)) {
          if ((!localMap3.containsKey(MsgProxyUtils.a(str1, j))) || (((MessageRecord)localMap3.get(MsgProxyUtils.a(str1, j))).time <= paramMessageRecord.time)) {
            localMap3.put(MsgProxyUtils.a(str1, j), paramMessageRecord);
          }
        }
        for (;;)
        {
          super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
          return;
          if (!paramMessageRecord.isread) {
            break label1973;
          }
          ((TroopInfoManager)localObject2).b(str1);
          localObject1 = null;
          break;
          label742:
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localRecentUser.uin) != 2) {
            break label246;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
          break label246;
          label799:
          boolean bool;
          if ((localRecentUser.msgType != 14) && (localRecentUser.msgType != 19) && (localRecentUser.msgType != 20) && (localObject1 != null) && (((MessageInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) == 14))
          {
            bool = paramMessageRecord instanceof MessageForQQWalletMsg;
            if ((i == 3) || (i == 4))
            {
              if (bool)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_allscreen", 0, 0, localRecentUser.uin, "", "", "");
                break label246;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_allscreen", 0, 0, localRecentUser.uin, "", "", "");
              break label246;
            }
            if (i == 2)
            {
              if (bool)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
                break label246;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
              break label246;
            }
            if (i != 1) {
              break label246;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_norm", 0, 0, localRecentUser.uin, "", "", "");
            break label246;
          }
          if ((localRecentUser.msgType == 14) || (localRecentUser.msgType == 19) || (localRecentUser.msgType == 20) || (localRecentUser.msgType == 12) || (localObject1 == null) || (((MessageInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) != 12)) {
            break label246;
          }
          if ((i == 3) || (i == 4)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_allscreen", 0, 0, localRecentUser.uin, "", "", "");
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label1319;
            }
            QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, "addMessageRecord");
            break;
            if (i == 2) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_grphelper", 0, 0, localRecentUser.uin, "", "", "");
            } else if (i == 1) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_norm", 0, 0, localRecentUser.uin, "", "", "");
            }
          }
          label1319:
          break label246;
          label1321:
          if (i != 1) {
            break label542;
          }
          localObject2 = "msg_public";
          break label542;
          label1335:
          if (k != 19) {
            break label576;
          }
          if (j == 3000) {}
          for (localObject2 = "Grp_Dis_replyMsg";; localObject2 = "Grp_replyMsg")
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign", 0, 0, localRecentUser.troopUin, "" + i, "", "");
            if ((i != 3) && (i != 4)) {
              break label1470;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_allscreen", 0, 0, localRecentUser.troopUin, "", "", "");
            break;
          }
          label1470:
          if (i != 2) {
            break label576;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_grphelper", 0, 0, localRecentUser.troopUin, "", "", "");
          break label576;
          if ((!MsgProxyUtils.g(paramMessageRecord.msgtype)) && (!MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)))
          {
            if ((j == 1) && (i != 1) && (i != 4))
            {
              if (localObject1 == null) {}
              for (i = 0;; i = ((MessageInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1))
              {
                if ((i == 14) || (i == 20) || (i == 12) || (i == 5) || (i == 23) || (i == 15) || (i == 19) || (i == 13) || (i == 4))
                {
                  ((RecentUser)localObject2).uin = str1;
                  if ((j == 1000) || (j == 1020) || (j == 1004)) {
                    ((RecentUser)localObject2).troopUin = str2;
                  }
                  ((RecentUser)localObject2).type = j;
                  if (l > ((RecentUser)localObject2).lastmsgtime) {
                    ((RecentUser)localObject2).lastmsgtime = l;
                  }
                  localMap1.put(MsgProxyUtils.a(str1, j), localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, "addMessageRecord, MsgBizType:" + i + "uin:" + ((RecentUser)localObject2).uin);
                  }
                }
                if ((!TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1)) || ((localMap2.containsKey(MsgProxyUtils.a(str1, j))) && (((MessageRecord)localMap2.get(MsgProxyUtils.a(str1, j))).time > paramMessageRecord.time))) {
                  break;
                }
                localMap2.put(MsgProxyUtils.a(str1, j), paramMessageRecord);
                break;
              }
            }
            if ((paramMessageRecord.isLongMsg()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord)))
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
              }
            }
            else
            {
              ((RecentUser)localObject2).uin = str1;
              ((RecentUser)localObject2).type = j;
              bool = true;
              if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
                bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
              }
              if ((l > ((RecentUser)localObject2).lastmsgtime) && (bool)) {
                ((RecentUser)localObject2).lastmsgtime = l;
              }
              localMap1.put(MsgProxyUtils.a(str1, j), localObject2);
            }
          }
        }
      }
      label1973:
      continue;
      localObject1 = null;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RecentUser localRecentUser = localProxyManager.a().a(paramString, paramInt);
    if ((localRecentUser.shouldShowInRecentList()) || (localRecentUser.msgType == 10))
    {
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localProxyManager.a().a(localRecentUser);
    }
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
      if ((paramInt != 1) && (paramInt != 4))
      {
        RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
      }
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    c(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    super.a(paramString, paramInt, paramLong, paramBoolean);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString1);
    if ((paramInt == 1) && (i != 1) && (i != 4))
    {
      if (i == 2) {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      try
      {
        TroopAssistantManager.a().a(paramString1, paramLong, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramString2.a();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(null);
        return;
      }
      finally
      {
        paramString2.a();
      }
    }
    super.a(paramString1, paramInt, paramString2, paramString3, paramLong);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramString, paramInt, paramBoolean1, paramBoolean2);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    super.a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramString);
    }
  }
  
  /* Error */
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 88	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   9: lload_2
    //   10: invokevirtual 524	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13: ldc_w 285
    //   16: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload 4
    //   21: invokevirtual 524	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 26	com/tencent/mobileqq/troop/data/TroopMessageManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   33: aload_1
    //   34: invokevirtual 525	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   37: ifeq +23 -> 60
    //   40: aload_0
    //   41: getfield 26	com/tencent/mobileqq/troop/data/TroopMessageManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   44: aload_1
    //   45: invokevirtual 526	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 528	java/util/HashSet
    //   51: aload 6
    //   53: invokevirtual 531	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: new 528	java/util/HashSet
    //   63: dup
    //   64: invokespecial 532	java/util/HashSet:<init>	()V
    //   67: astore 7
    //   69: aload 7
    //   71: aload 6
    //   73: invokevirtual 531	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   76: pop
    //   77: aload_0
    //   78: getfield 26	com/tencent/mobileqq/troop/data/TroopMessageManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: goto -31 -> 57
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	TroopMessageManager
    //   0	96	1	paramString	String
    //   0	96	2	paramLong1	long
    //   0	96	4	paramLong2	long
    //   27	45	6	str	String
    //   67	16	7	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   2	57	91	finally
    //   60	88	91	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/mobileqq/troop/data/TroopMessageManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 525	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +9 -> 21
    //   15: iconst_0
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_1
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	TroopMessageManager
    //   0	31	1	paramString	String
    //   10	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt));
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0) {
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
        HashSet localHashSet = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localHashSet.remove(paramLong1 + "" + paramLong2);
        if (localHashSet.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          setChanged();
          notifyObservers();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "并发拉取完成，troopUin:" + paramString);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageManager
 * JD-Core Version:    0.7.0.1
 */