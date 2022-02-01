package com.tencent.mobileqq.multimsg;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiMsgUtil
{
  public static boolean a = true;
  public static boolean b = true;
  
  public static int a(ChatMessage paramChatMessage)
  {
    if (a(paramChatMessage))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ("viewMultiMsg".equals(paramChatMessage.structingMsg.mMsgAction)))
      {
        i = paramChatMessage.structingMsg.mTSum;
        break label47;
      }
    }
    int i = 0;
    label47:
    return i + 1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if (paramQQAppInterface == null) {
        return null;
      }
      String str1 = paramMessageRecord.getExtInfoFromExtStr("outest_uin");
      String str2 = paramMessageRecord.getExtInfoFromExtStr("outest_uintype");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("outest_uniseq");
      try
      {
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(str1, Integer.parseInt(str2), Long.parseLong(paramMessageRecord));
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("MultiMsg_TAG", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramQQAppInterface != null)
    {
      if (paramMessageRecord == null) {
        return null;
      }
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)paramMessageRecord;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 128)) {
          return HardCodeUtil.a(2131707046);
        }
      }
      Object localObject = new Message();
      MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramMessageRecord);
      ((Message)localObject).emoRecentMsg = null;
      ((Message)localObject).fileType = -1;
      paramQQAppInterface.getMessageFacade().a((Message)localObject);
      paramMessageRecord = new MsgSummary();
      MsgUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface, (Message)localObject, ((Message)localObject).istroop, paramMessageRecord, null, false, false);
      try
      {
        paramQQAppInterface = paramMessageRecord.a(paramQQAppInterface.getApp()).toString();
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("MultiMsg_TAG.Nest", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static ArrayList<ChatMessage> a(QQAppInterface paramQQAppInterface, ArrayList<ChatMessage> paramArrayList)
  {
    if ((paramQQAppInterface != null) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return paramArrayList;
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramArrayList.next();
        if (a(paramQQAppInterface, localChatMessage))
        {
          localArrayList.add(localChatMessage);
        }
        else
        {
          String str = a(paramQQAppInterface, localChatMessage);
          localChatMessage = (ChatMessage)paramQQAppInterface.getMultiMessageProxy().a(localChatMessage, str, false);
          if (localChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
            ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localChatMessage);
          }
          localChatMessage.setStatus(1000);
          localChatMessage.msgData = localChatMessage.msg.getBytes();
          localArrayList.add(localChatMessage);
        }
      }
      return localArrayList;
    }
    return paramArrayList;
  }
  
  public static void a(MessageRecord paramMessageRecord1, String paramString, MessageRecord paramMessageRecord2)
  {
    a("step.fillExtraInfo.nickName = %s", new Object[] { paramString });
    if ((paramMessageRecord1 != null) && (paramMessageRecord2 != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramMessageRecord1.saveExtInfoToExtStr("outest_uin", paramMessageRecord2.frienduin);
      paramMessageRecord1.saveExtInfoToExtStr("outest_uintype", String.valueOf(paramMessageRecord2.istroop));
      paramMessageRecord1.saveExtInfoToExtStr("outest_uniseq", String.valueOf(paramMessageRecord2.uniseq));
      paramMessageRecord1.saveExtInfoToExtStr("self_nickname", paramString);
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (!a) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 4, String.format(paramString, paramVarArgs));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    boolean bool1 = MessageForShortVideo.class.isInstance(paramChatMessage);
    boolean bool2 = false;
    if ((bool1) && (((MessageForShortVideo)paramChatMessage).busiType == 2)) {
      return false;
    }
    if ((MessageForLongTextMsg.class.isInstance(paramChatMessage)) && ((paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3")))) {
      return false;
    }
    if (!MessageForArkApp.isAllowedArkForward(false, paramChatMessage)) {
      return false;
    }
    if (MessageForTroopConfess.class.isInstance(paramChatMessage)) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForFuDai)) {
      return false;
    }
    if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage)) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForPic)) && (ZhituManager.a((MessageForPic)paramChatMessage))) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForWriteTogether)) {
      return true;
    }
    int i;
    switch (paramChatMessage.msgtype)
    {
    default: 
      return false;
    case -2005: 
      bool1 = bool2;
      if (!(paramChatMessage instanceof MessageForFile)) {
        return bool1;
      }
      if (!paramChatMessage.isMultiMsg)
      {
        i = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramChatMessage).getCloudType();
        bool1 = bool2;
        if (i == 0) {
          return bool1;
        }
        if (i == 11) {
          return false;
        }
      }
      break;
    case -2011: 
      paramQQAppInterface = (MessageForStructing)paramChatMessage;
      if (paramQQAppInterface.structingMsg == null) {
        return false;
      }
      i = paramQQAppInterface.structingMsg.mMsgServiceID;
      bool1 = bool2;
      if (i == 107) {
        return bool1;
      }
      bool1 = bool2;
      if (i == 82) {
        return bool1;
      }
      bool1 = bool2;
      if (i == 128) {
        return bool1;
      }
      if (i == 104) {
        return false;
      }
      if ((paramQQAppInterface.structingMsg.hasFlag(1)) && (i != 35)) {
        return false;
      }
      break;
    case -3017: 
      paramChatMessage = (MessageForDLFile)paramChatMessage;
      i = paramChatMessage.deviceType;
      long l = paramChatMessage.associatedId;
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(i).a(l);
      bool1 = bool2;
      if (paramQQAppInterface == null) {
        return bool1;
      }
      bool1 = bool2;
      if (!FileUtil.a(paramQQAppInterface.path)) {
        return bool1;
      }
      break;
    case -5016: 
      paramQQAppInterface = (MessageForArkBabyqReply)paramChatMessage;
      bool1 = bool2;
      if (paramQQAppInterface.mArkBabyqReplyCardList == null) {
        return bool1;
      }
      if (paramQQAppInterface.mArkBabyqReplyCardList.size() <= 0) {
        return false;
      }
      break;
    }
    bool1 = true;
    return bool1;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ("viewMultiMsg".equals(paramChatMessage.structingMsg.mMsgAction))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 2, String.format(paramString, paramVarArgs));
    }
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    return ((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForReplyText)) || ((paramChatMessage instanceof MessageForPic)) || ((paramChatMessage instanceof MessageForStructing)) || ((paramChatMessage instanceof MessageForShortVideo)) || ((paramChatMessage instanceof MessageForArkApp)) || ((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForMixedMsg)) || ((paramChatMessage instanceof MessageForTroopFile));
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    boolean bool;
    if ((!(paramChatMessage instanceof MessageForGrayTips)) && (!(paramChatMessage instanceof MessageForUniteGrayTip)) && (!(paramChatMessage instanceof MessageForIncompatibleGrayTips)) && (!(paramChatMessage instanceof MessageForNewGrayTips)) && (!(paramChatMessage instanceof MessageForSafeGrayTips)) && (!(paramChatMessage instanceof MessageForFoldMsgGrayTips)) && (!(paramChatMessage instanceof MessageForNearbyMarketGrayTips)) && (!(paramChatMessage instanceof MessageForQQWalletTips)) && (!(paramChatMessage instanceof MessageForSplitLineTips))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramChatMessage instanceof MessageForTroopGift)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgUtil
 * JD-Core Version:    0.7.0.1
 */