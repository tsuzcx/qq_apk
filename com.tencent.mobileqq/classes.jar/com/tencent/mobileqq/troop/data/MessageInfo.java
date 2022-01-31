package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.msg.ArkInfoMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopCalendarMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopDingdongAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopEffectPicMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopGamePartyMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHasGiftMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHomeworkPraiseMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNewFileMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopPubAccountMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReplyMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.TroopHomeworkSpecialMsg;

public class MessageInfo
{
  public int a;
  public MessageNavInfo a;
  public String a;
  public MessageNavInfo b = new MessageNavInfo();
  public MessageNavInfo c = new MessageNavInfo();
  public MessageNavInfo d = new MessageNavInfo();
  public MessageNavInfo e = new MessageNavInfo();
  public MessageNavInfo f = new MessageNavInfo();
  public MessageNavInfo g = new MessageNavInfo();
  public MessageNavInfo h = new MessageNavInfo();
  public MessageNavInfo i = new MessageNavInfo();
  public MessageNavInfo j = new MessageNavInfo();
  public MessageNavInfo k = new MessageNavInfo();
  public MessageNavInfo l = new MessageNavInfo();
  public MessageNavInfo m = new MessageNavInfo();
  public MessageNavInfo n = new MessageNavInfo();
  public MessageNavInfo o = new MessageNavInfo();
  public MessageNavInfo p = new MessageNavInfo();
  public MessageNavInfo q = new MessageNavInfo();
  public MessageNavInfo r = new MessageNavInfo();
  public MessageNavInfo s = new MessageNavInfo();
  public MessageNavInfo t = new MessageNavInfo();
  
  public MessageInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    a();
  }
  
  public MessageInfo(MessageInfo paramMessageInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    if (paramMessageInfo != null)
    {
      this.c.a(paramMessageInfo.c);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      this.b.a(paramMessageInfo.b);
      this.d.a(paramMessageInfo.d);
      this.e.a(paramMessageInfo.e);
      this.f.a(paramMessageInfo.f);
      this.g.a(paramMessageInfo.g);
      this.h.a(paramMessageInfo.h);
      this.i.a(paramMessageInfo.i);
      this.j.a(paramMessageInfo.j);
      this.k.a(paramMessageInfo.k);
      this.l.a(paramMessageInfo.l);
      this.m.a(paramMessageInfo.m);
      this.n.a(paramMessageInfo.n);
      this.o.a(paramMessageInfo.o);
      this.p.a(paramMessageInfo.p);
      this.q.a(paramMessageInfo.q);
      this.r.a(paramMessageInfo.r);
      this.s.a(paramMessageInfo.s);
      this.t.a(paramMessageInfo.t);
      return;
    }
    a();
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)paramQQAppInterface.getManager(36);
    if (paramBoolean) {
      switch (paramMessageInfo.a(paramQQAppInterface, paramBoolean, paramString))
      {
      case 21: 
      case 22: 
      case 24: 
      default: 
        paramQQAppInterface = null;
      case 14: 
      case 10: 
      case 20: 
      case 13: 
      case 23: 
      case 12: 
      case 9: 
      case 5: 
      case 7: 
      case 8: 
      case 15: 
      case 19: 
      case 3: 
      case 2: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return paramQQAppInterface;
                    if ((paramObject instanceof TroopSpecialAttentionMsg))
                    {
                      paramQQAppInterface = (TroopSpecialAttentionMsg)paramObject;
                      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.b);
                      localTroopInfoManager.a(paramString, 15, paramMessageInfo.b.a, "", 0);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new TroopSpecialAttentionMsg(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.b);
                    localTroopInfoManager.a(paramString, 15, paramMessageInfo.b.a, "", 0);
                    return paramQQAppInterface;
                    return new TroopNotificationMsg(BaseApplication.getContext());
                    if (!(paramObject instanceof TroopAtMeMsg)) {
                      break;
                    }
                    paramObject = (TroopAtMeMsg)paramObject;
                    paramQQAppInterface = paramObject;
                  } while (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo));
                  localTroopInfoManager.a(paramString, 21, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
                  return paramObject;
                  paramQQAppInterface = new TroopAtMeMsg(BaseApplication.getContext());
                  paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
                  localTroopInfoManager.a(paramString, 21, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
                  return paramQQAppInterface;
                  if (paramMessageRecord == null) {
                    return null;
                  }
                  paramBoolean = NearbyFlowerUtil.a(paramMessageRecord);
                  if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                    return null;
                  }
                  int i1;
                  if (paramBoolean)
                  {
                    i1 = NearbyFlowerUtil.a((MessageForStructing)paramMessageRecord);
                    if ((paramObject instanceof TroopReceivedFlowsersMsg))
                    {
                      paramQQAppInterface = (TroopReceivedFlowsersMsg)paramObject;
                      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.e);
                      localTroopInfoManager.a(paramString, 24, paramMessageInfo.e.b, "", i1);
                      return paramQQAppInterface;
                    }
                    paramQQAppInterface = new TroopReceivedFlowsersMsg(BaseApplication.getContext());
                    paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.e);
                    localTroopInfoManager.a(paramString, 24, paramMessageInfo.e.b, "", i1);
                    return paramQQAppInterface;
                  }
                  if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                  {
                    paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                    i1 = 1;
                    i2 = 1;
                    if (!(paramObject instanceof TroopReceivedFlowsersMsg)) {
                      break label689;
                    }
                    paramQQAppInterface = (TroopReceivedFlowsersMsg)paramObject;
                    i1 = i2;
                    if (paramQQAppInterface.jdField_a_of_type_Boolean)
                    {
                      i1 = i2;
                      if (!paramMessageRecord.isToAll()) {
                        i1 = 0;
                      }
                    }
                    i2 = i1;
                    paramObject = paramQQAppInterface;
                    if (!paramQQAppInterface.jdField_a_of_type_Boolean)
                    {
                      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.e);
                      localTroopInfoManager.a(paramString, 24, paramMessageInfo.e.b, "", paramMessageRecord.giftCount);
                      paramObject = paramQQAppInterface;
                    }
                  }
                  for (int i2 = i1;; i2 = i1)
                  {
                    paramQQAppInterface = paramObject;
                    if (i2 == 0) {
                      break;
                    }
                    paramQQAppInterface = paramObject;
                    if (TextUtils.isEmpty(paramMessageRecord.remindBrief)) {
                      break;
                    }
                    paramQQAppInterface = paramMessageRecord.remindBrief.split("#");
                    paramObject.jdField_a_of_type_JavaLangString = ("[" + paramQQAppInterface[0] + "]");
                    return paramObject;
                    ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                    return null;
                    paramObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext(), paramMessageRecord.isToAll());
                    paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.e);
                    localTroopInfoManager.a(paramString, 24, paramMessageInfo.e.b, "", paramMessageRecord.giftCount);
                  }
                  if ((paramObject instanceof TroopAtAllMsg))
                  {
                    paramQQAppInterface = (TroopAtAllMsg)paramObject;
                    paramObject = paramQQAppInterface;
                    if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.c))
                    {
                      localTroopInfoManager.a(paramString, 13, paramMessageInfo.c.b, "", 0);
                      paramObject = paramQQAppInterface;
                    }
                  }
                  for (;;)
                  {
                    paramQQAppInterface = paramObject;
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d(MessageInfo.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
                    return paramObject;
                    paramObject = new TroopAtAllMsg(BaseApplication.getContext());
                    paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.c);
                    localTroopInfoManager.a(paramString, 13, paramMessageInfo.c.b, "", 0);
                  }
                  return null;
                  if (!(paramObject instanceof TroopHomeworkSpecialMsg)) {
                    break;
                  }
                  paramObject = (TroopHomeworkSpecialMsg)paramObject;
                  paramQQAppInterface = paramObject;
                } while (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.d));
                localTroopInfoManager.a(paramString, 6, paramMessageInfo.d.b, "", 0);
                return paramObject;
                paramQQAppInterface = new TroopHomeworkSpecialMsg(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.d);
                localTroopInfoManager.a(paramString, 6, paramMessageInfo.d.b, "", 0);
                return paramQQAppInterface;
                if (paramMessageRecord == null) {
                  return null;
                }
                paramBoolean = NearbyFlowerUtil.a(paramMessageRecord);
                if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!paramBoolean)) {
                  return null;
                }
                if (paramBoolean)
                {
                  if ((paramObject instanceof TroopHasGiftMsg))
                  {
                    paramQQAppInterface = (TroopHasGiftMsg)paramObject;
                    paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.f);
                    return paramQQAppInterface;
                  }
                  paramQQAppInterface = new TroopHasGiftMsg(BaseApplication.getContext());
                  paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.f);
                  return paramQQAppInterface;
                }
                if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
                {
                  paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
                  if (!(paramObject instanceof TroopHasGiftMsg)) {
                    break label1229;
                  }
                  paramString = (TroopHasGiftMsg)paramObject;
                  paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.f);
                }
                for (;;)
                {
                  if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
                  {
                    paramMessageInfo = paramMessageRecord.remindBrief.split("#");
                    if (paramMessageInfo.length > 1) {
                      paramString.jdField_a_of_type_JavaLangString = ("[" + paramMessageInfo[1] + "]");
                    }
                  }
                  paramQQAppInterface = (AIOAnimationControlManager)paramQQAppInterface.getManager(222);
                  if (!paramQQAppInterface.a(false)) {
                    break;
                  }
                  return null;
                  ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
                  return null;
                  paramString = new TroopHasGiftMsg(BaseApplication.getContext());
                  paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.f);
                }
                paramQQAppInterface.jdField_a_of_type_Int = 1;
                return paramString;
                if ((paramObject instanceof TroopPubAccountMsg))
                {
                  paramQQAppInterface = (TroopPubAccountMsg)paramObject;
                  paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.g);
                  return paramQQAppInterface;
                }
                paramQQAppInterface = new TroopPubAccountMsg(BaseApplication.getContext());
                paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.g);
                return paramQQAppInterface;
                if (!(paramObject instanceof TroopDingdongAtMeMsg)) {
                  break;
                }
                paramObject = (TroopDingdongAtMeMsg)paramObject;
                paramQQAppInterface = paramObject;
              } while (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.h));
              localTroopInfoManager.a(paramString, 16, paramMessageInfo.h.b, "", 0);
              return paramObject;
              paramQQAppInterface = new TroopDingdongAtMeMsg(BaseApplication.getContext());
              paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.h);
              localTroopInfoManager.a(paramString, 16, paramMessageInfo.h.b, "", 0);
              return paramQQAppInterface;
              if (!(paramObject instanceof TroopReplyMsg)) {
                break;
              }
              paramObject = (TroopReplyMsg)paramObject;
              paramQQAppInterface = paramObject;
            } while (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.i));
            localTroopInfoManager.a(paramString, 20, paramMessageInfo.i.b, "", 0);
            return paramObject;
            paramQQAppInterface = new TroopReplyMsg(BaseApplication.getContext());
            paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.i);
            localTroopInfoManager.a(paramString, 20, paramMessageInfo.i.b, "", 0);
            return paramQQAppInterface;
            if ((!(paramObject instanceof TroopNewFileMsg)) || (((TroopNewFileMsg)paramObject).c != 1)) {
              break;
            }
            paramObject = (TroopNewFileMsg)paramObject;
            paramQQAppInterface = paramObject;
          } while (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.k));
          localTroopInfoManager.a(paramString, 4, paramMessageInfo.k.b, "", 0);
          return paramObject;
          paramQQAppInterface = new TroopNewFileMsg(BaseApplication.getContext(), 1);
          paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.k);
          localTroopInfoManager.a(paramString, 4, paramMessageInfo.k.b, "", 0);
          return paramQQAppInterface;
          if ((!(paramObject instanceof TroopNewFileMsg)) || (((TroopNewFileMsg)paramObject).c != 0)) {
            break;
          }
          paramObject = (TroopNewFileMsg)paramObject;
          paramQQAppInterface = paramObject;
        } while (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.l));
        localTroopInfoManager.a(paramString, 3, paramMessageInfo.l.b, "", 0);
        return paramObject;
        paramQQAppInterface = new TroopNewFileMsg(BaseApplication.getContext(), 0);
        paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.l);
        localTroopInfoManager.a(paramString, 3, paramMessageInfo.l.b, "", 0);
        return paramQQAppInterface;
      case 18: 
        label689:
        label1229:
        if ((StructMsgForGeneralShare)StructMsgFactory.a(paramMessageRecord.msgData) == null)
        {
          if (!QLog.isColorLevel()) {
            break label3221;
          }
          QLog.d("MessageInfo", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
          paramMessageRecord = "";
        }
        break;
      }
    }
    for (;;)
    {
      label1748:
      if ((paramObject instanceof TroopCalendarMsg))
      {
        paramQQAppInterface = (TroopCalendarMsg)paramObject;
        paramObject = paramQQAppInterface;
        if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.j))
        {
          localTroopInfoManager.a(paramString, 19, paramMessageInfo.j.b, "", 0);
          paramObject = paramQQAppInterface;
        }
      }
      for (;;)
      {
        paramQQAppInterface = paramObject;
        if (TextUtils.isEmpty(paramMessageRecord)) {
          break;
        }
        paramObject.jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        return paramObject;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break label1748;
        paramObject = new TroopCalendarMsg(BaseApplication.getContext());
        paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.j);
        localTroopInfoManager.a(paramString, 19, paramMessageInfo.j.b, "", 0);
      }
      paramQQAppInterface = new TroopNotificationMsg(BaseApplication.getContext());
      paramQQAppInterface.c = 1;
      return paramQQAppInterface;
      if ((paramObject instanceof TroopHomeworkPraiseMsg))
      {
        paramObject = (TroopHomeworkPraiseMsg)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.o)) {
          break;
        }
        localTroopInfoManager.a(paramString, 5, paramMessageInfo.o.b, "", 0);
        return paramObject;
      }
      paramQQAppInterface = new TroopHomeworkPraiseMsg(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.o);
      localTroopInfoManager.a(paramString, 5, paramMessageInfo.o.b, "", 0);
      return paramQQAppInterface;
      if ((paramObject instanceof TroopGamePartyMsg))
      {
        paramObject = (TroopGamePartyMsg)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.p)) {
          break;
        }
        localTroopInfoManager.a(paramString, 17, paramMessageInfo.p.b, "", 0);
        return paramObject;
      }
      paramQQAppInterface = new TroopGamePartyMsg(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.p);
      localTroopInfoManager.a(paramString, 17, paramMessageInfo.p.b, "", 0);
      return paramQQAppInterface;
      if ((paramObject instanceof TroopReceiptMsg))
      {
        paramObject = (TroopReceiptMsg)paramObject;
        paramQQAppInterface = paramObject;
        if (!paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.r)) {
          break;
        }
        localTroopInfoManager.a(paramString, 12, paramMessageInfo.r.b, "", 0);
        return paramObject;
      }
      paramQQAppInterface = new TroopReceiptMsg(BaseApplication.getContext());
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.r);
      localTroopInfoManager.a(paramString, 12, paramMessageInfo.r.b, "", 0);
      return paramQQAppInterface;
      return new TroopEffectPicMsg(BaseApplication.getContext());
      paramQQAppInterface = null;
      if ((paramMessageRecord instanceof MessageForArkApp)) {
        paramQQAppInterface = ArkTipsManager.a((MessageForArkApp)paramMessageRecord);
      }
      long l1;
      long l2;
      if ((paramObject instanceof ArkInfoMsg))
      {
        paramObject = (ArkInfoMsg)paramObject;
        if (paramQQAppInterface != null) {
          paramObject.a(paramQQAppInterface);
        }
        if (paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.t))
        {
          localTroopInfoManager.a(paramString, 18, paramMessageInfo.t.b, "", 0);
          return paramObject;
        }
        paramQQAppInterface = paramObject;
        if (paramMessageInfo.t == null) {
          break;
        }
        l1 = paramMessageInfo.t.a;
        l2 = paramMessageInfo.t.b;
        if (l1 != -1L)
        {
          paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = l1;
          paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b = l2;
        }
        localTroopInfoManager.a(paramString, 18, paramMessageInfo.t.b, "", 0);
        return paramObject;
      }
      paramObject = BaseApplication.getContext();
      if (paramQQAppInterface != null) {}
      for (;;)
      {
        paramQQAppInterface = new ArkInfoMsg(paramObject, paramQQAppInterface);
        paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.t);
        localTroopInfoManager.a(paramString, 18, paramMessageInfo.t.b, "", 0);
        return paramQQAppInterface;
        paramQQAppInterface = "";
      }
      String str2 = paramString + "&" + 3000;
      String str1 = "0";
      switch (paramMessageInfo.a())
      {
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 18: 
      default: 
        paramString = null;
        paramObject = str1;
      }
      for (;;)
      {
        paramQQAppInterface = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MessageInfo_At_Me_DISC", 2, "MessageInfo update:" + paramObject);
        return paramString;
        if ((paramObject instanceof TroopAtAllMsg))
        {
          paramQQAppInterface = (TroopAtAllMsg)paramObject;
          paramObject = str1;
          paramString = paramQQAppInterface;
          if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.c))
          {
            localTroopInfoManager.a(str2, 13, paramMessageInfo.c.b, "", 0);
            paramObject = "AT_ALL_update";
            paramString = paramQQAppInterface;
          }
        }
        else
        {
          paramString = new TroopAtAllMsg(BaseApplication.getContext());
          paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.c);
          localTroopInfoManager.a(str2, 13, paramMessageInfo.c.b, "", 0);
          paramObject = "AT_ALL_add";
          continue;
          if ((paramObject instanceof TroopAtMeMsg))
          {
            paramQQAppInterface = (TroopAtMeMsg)paramObject;
            paramObject = str1;
            paramString = paramQQAppInterface;
            if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo))
            {
              localTroopInfoManager.a(str2, 21, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
              paramObject = "AT_ME_update";
              paramString = paramQQAppInterface;
            }
          }
          else
          {
            paramString = new TroopAtMeMsg(BaseApplication.getContext());
            paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
            localTroopInfoManager.a(str2, 21, paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b, "", 0);
            paramObject = "AT_ME_ADD";
            continue;
            if ((paramObject instanceof TroopReceiptMsg))
            {
              paramQQAppInterface = (TroopReceiptMsg)paramObject;
              paramObject = str1;
              paramString = paramQQAppInterface;
              if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.r))
              {
                localTroopInfoManager.a(str2, 12, paramMessageInfo.r.b, "", 0);
                paramObject = "receipt_update";
                paramString = paramQQAppInterface;
              }
            }
            else
            {
              paramString = new TroopReceiptMsg(BaseApplication.getContext());
              paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.r);
              localTroopInfoManager.a(str2, 12, paramMessageInfo.r.b, "", 0);
              paramObject = "receipt_add";
              continue;
              paramQQAppInterface = null;
              if ((paramMessageRecord instanceof MessageForArkApp)) {
                paramQQAppInterface = ArkTipsManager.a((MessageForArkApp)paramMessageRecord);
              }
              if ((paramObject instanceof ArkInfoMsg))
              {
                paramMessageRecord = (ArkInfoMsg)paramObject;
                if (paramQQAppInterface != null) {
                  paramMessageRecord.a(paramQQAppInterface);
                }
                if (paramMessageRecord.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.t))
                {
                  localTroopInfoManager.a(str2, 18, paramMessageInfo.t.b, "", 0);
                  paramObject = str1;
                  paramString = paramMessageRecord;
                }
                else
                {
                  paramObject = str1;
                  paramString = paramMessageRecord;
                  if (paramMessageInfo.t != null)
                  {
                    l1 = paramMessageInfo.t.a;
                    l2 = paramMessageInfo.t.b;
                    if (l1 != -1L)
                    {
                      paramMessageRecord.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = l1;
                      paramMessageRecord.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b = l2;
                    }
                    localTroopInfoManager.a(str2, 18, paramMessageInfo.t.b, "", 0);
                    paramObject = str1;
                    paramString = paramMessageRecord;
                  }
                }
              }
              else
              {
                paramString = BaseApplication.getContext();
                if (paramQQAppInterface != null) {}
                for (;;)
                {
                  paramString = new ArkInfoMsg(paramString, paramQQAppInterface);
                  paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.t);
                  localTroopInfoManager.a(str2, 18, paramMessageInfo.t.b, "", 0);
                  paramObject = str1;
                  break;
                  paramQQAppInterface = "";
                }
                if ((paramObject instanceof TroopReplyMsg))
                {
                  paramQQAppInterface = (TroopReplyMsg)paramObject;
                  paramObject = str1;
                  paramString = paramQQAppInterface;
                  if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.i))
                  {
                    localTroopInfoManager.a(str2, 20, paramMessageInfo.i.b, "", 0);
                    paramObject = str1;
                    paramString = paramQQAppInterface;
                  }
                }
                else
                {
                  paramString = new TroopReplyMsg(BaseApplication.getContext());
                  paramString.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.i);
                  localTroopInfoManager.a(str2, 20, paramMessageInfo.i.b, "", 0);
                  paramObject = str1;
                }
              }
            }
          }
        }
      }
      label3221:
      paramMessageRecord = "";
    }
  }
  
  public static final boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 20) && (paramInt1 - 1 > paramInt2)) || ((paramInt1 == 2) && (paramInt1 + 1 >= paramInt2)) || ((paramInt1 != 20) && (paramInt1 >= paramInt2));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return 20;
    }
    if (this.c.a()) {
      return 12;
    }
    if (this.r.a()) {
      return 11;
    }
    if (this.t.a()) {
      return 17;
    }
    if (this.i.a()) {
      return 19;
    }
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    int i1 = 0;
    if ((paramQQAppInterface != null) && (paramBoolean))
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).b(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramBoolean = paramQQAppInterface.hasOrgs();; paramBoolean = false)
    {
      if (this.e.a()) {
        if (paramBoolean) {
          i1 = 13;
        }
      }
      do
      {
        return i1;
        return 23;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
          return 20;
        }
        if (this.h.a()) {
          return 15;
        }
        if (this.i.a()) {
          return 19;
        }
        if (this.j.a()) {
          return 18;
        }
        if (this.b.a()) {
          return 14;
        }
        if (this.c.a()) {
          return 12;
        }
        if (this.g.a()) {
          return 8;
        }
        if (this.k.a()) {
          return 3;
        }
        if (this.l.a()) {
          return 2;
        }
        if (this.d.a()) {
          return 5;
        }
        if (this.f.a()) {
          return 7;
        }
        if (this.m.a()) {
          return 25;
        }
        if (this.n.a()) {
          return 10;
        }
        if (this.o.a()) {
          return 4;
        }
        if (this.p.a()) {
          return 16;
        }
        if (this.q.a()) {
          return 9;
        }
        if (this.r.a()) {
          return 11;
        }
        if (this.s.a()) {
          return 6;
        }
      } while (!this.t.a());
      return 17;
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a;
    }
    if (this.c.a()) {
      return this.c.a;
    }
    if (this.r.a()) {
      return this.r.a;
    }
    if (this.t.a()) {
      return this.t.a;
    }
    if (this.i.a()) {
      return this.i.a;
    }
    return -1L;
  }
  
  public MessageInfo a(MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo != null)
    {
      this.c.a(paramMessageInfo.c);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      this.b.a(paramMessageInfo.b);
      this.d.a(paramMessageInfo.d);
      this.e.a(paramMessageInfo.e);
      this.f.a(paramMessageInfo.f);
      this.g.a(paramMessageInfo.g);
      this.h.a(paramMessageInfo.h);
      this.i.a(paramMessageInfo.i);
      this.j.a(paramMessageInfo.j);
      this.k.a(paramMessageInfo.k);
      this.l.a(paramMessageInfo.l);
      this.m.a(paramMessageInfo.m);
      this.n.a(paramMessageInfo.n);
      this.o.a(paramMessageInfo.o);
      this.p.a(paramMessageInfo.p);
      this.q.a(paramMessageInfo.q);
      this.r.a(paramMessageInfo.r);
      this.s.a(paramMessageInfo.s);
      this.t.a(paramMessageInfo.t);
    }
    return this;
  }
  
  public void a()
  {
    this.c.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a();
    this.b.a();
    this.d.a();
    this.e.a();
    this.f.a();
    this.g.a();
    this.h.a();
    this.i.a();
    this.j.a();
    this.k.a();
    this.l.a();
    this.m.a();
    this.n.a();
    this.o.a();
    this.p.a();
    this.q.a();
    this.r.a();
    this.s.a();
    this.t.a();
  }
  
  public boolean a()
  {
    return (this.c.a()) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) || (this.b.a()) || (this.d.a()) || (this.e.a()) || (this.f.a()) || (this.h.a()) || (this.g.a()) || (this.i.a()) || (this.l.a()) || (this.k.a()) || (this.j.a()) || (this.m.a()) || (this.n.a()) || (this.o.a()) || (this.p.a()) || (this.q.a()) || (this.s.a()) || (this.r.a()) || (this.t.a());
  }
  
  public long b()
  {
    if (this.e.a()) {
      return this.e.a;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a;
    }
    if (this.h.a()) {
      return this.h.a;
    }
    if (this.b.a()) {
      return this.b.a;
    }
    if (this.c.a()) {
      return this.c.a;
    }
    if (this.g.a()) {
      return this.g.a;
    }
    if (this.d.a()) {
      return this.d.a;
    }
    if (this.f.a()) {
      return this.f.a;
    }
    if (this.i.a()) {
      return this.i.a;
    }
    if (this.j.a()) {
      return this.j.a;
    }
    if (this.k.a()) {
      return this.k.a;
    }
    if (this.l.a()) {
      return this.l.a;
    }
    if (this.m.a()) {
      return this.m.a;
    }
    if (this.n.a()) {
      return this.n.a;
    }
    if (this.o.a()) {
      return this.o.a;
    }
    if (this.p.a()) {
      return this.p.a;
    }
    if (this.q.a()) {
      return this.q.a;
    }
    if (this.r.a()) {
      return this.r.a;
    }
    if (this.s.a()) {
      return this.s.a;
    }
    if (this.t.a()) {
      return this.t.a;
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MessageInfo
 * JD-Core Version:    0.7.0.1
 */