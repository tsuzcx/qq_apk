package com.tencent.mobileqq.service.message;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForDateFeed;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageForVideoVip;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

public class MessageRecordFactory
{
  public static MessageForDevLittleVideo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = new MessageForDevLittleVideo();
    localMessageForDevLittleVideo.msgtype = -4509;
    a(paramQQAppInterface, localMessageForDevLittleVideo, paramString1, paramString2, paramInt);
    localMessageForDevLittleVideo.longMsgCount = 1;
    localMessageForDevLittleVideo.longMsgIndex = 0;
    localMessageForDevLittleVideo.longMsgId = ((short)(int)localMessageForDevLittleVideo.shmsgseq);
    return localMessageForDevLittleVideo;
  }
  
  public static MessageForApollo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ApolloMessage paramApolloMessage)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)a(-2039);
    localMessageForApollo.msgtype = -2039;
    localMessageForApollo.mApolloMessage = paramApolloMessage;
    localMessageForApollo.mIsParsed = true;
    a(paramQQAppInterface, localMessageForApollo, paramString1, paramString2, paramInt);
    try
    {
      localMessageForApollo.msg = ApolloUtil.a(localMessageForApollo);
      localMessageForApollo.msgData = MessagePkgUtils.a(paramApolloMessage);
      return localMessageForApollo;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localMessageForApollo;
  }
  
  public static MessageForArkApp a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return null;
    }
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.msgtype = -5008;
    localMessageForArkApp.ark_app_message = paramArkAppMessage;
    localMessageForArkApp.msg = paramArkAppMessage.getSummery();
    localMessageForArkApp.msgData = localMessageForArkApp.ark_app_message.toBytes();
    a(paramQQAppInterface, localMessageForArkApp, paramString1, paramString2, paramInt);
    localMessageForArkApp.longMsgCount = 1;
    localMessageForArkApp.longMsgIndex = 0;
    localMessageForArkApp.longMsgId = ((short)(int)localMessageForArkApp.shmsgseq);
    return localMessageForArkApp;
  }
  
  public static MessageForArkBabyqReply a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, MessageForArkBabyqReply paramMessageForArkBabyqReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessageForArkBabyqReply == null) {
      return null;
    }
    MessageForArkBabyqReply localMessageForArkBabyqReply = paramMessageForArkBabyqReply;
    if (!paramBoolean1)
    {
      localMessageForArkBabyqReply = new MessageForArkBabyqReply();
      localMessageForArkBabyqReply.fromAppXml(paramMessageForArkBabyqReply.toAppXml());
    }
    localMessageForArkBabyqReply.msgtype = -5016;
    localMessageForArkBabyqReply.showAsBabyq = paramBoolean2;
    localMessageForArkBabyqReply.msg = localMessageForArkBabyqReply.getSummery();
    localMessageForArkBabyqReply.msgData = localMessageForArkBabyqReply.toBytes();
    a(paramQQAppInterface, localMessageForArkBabyqReply, paramString1, paramString2, paramInt);
    localMessageForArkBabyqReply.longMsgCount = 1;
    localMessageForArkBabyqReply.longMsgIndex = 0;
    localMessageForArkBabyqReply.longMsgId = ((short)(int)localMessageForArkBabyqReply.shmsgseq);
    return localMessageForArkBabyqReply;
  }
  
  public static MessageForArkFlashChat a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArkFlashChatMessage paramArkFlashChatMessage)
  {
    if (paramArkFlashChatMessage == null) {
      return null;
    }
    MessageForArkFlashChat localMessageForArkFlashChat = new MessageForArkFlashChat();
    localMessageForArkFlashChat.msgtype = -5013;
    localMessageForArkFlashChat.ark_app_message = paramArkFlashChatMessage;
    localMessageForArkFlashChat.msg = paramArkFlashChatMessage.getSummery();
    localMessageForArkFlashChat.msgData = localMessageForArkFlashChat.ark_app_message.toBytes();
    a(paramQQAppInterface, localMessageForArkFlashChat, paramString1, paramString2, paramInt);
    localMessageForArkFlashChat.longMsgCount = 1;
    localMessageForArkFlashChat.longMsgIndex = 0;
    localMessageForArkFlashChat.longMsgId = ((short)(int)localMessageForArkFlashChat.shmsgseq);
    return localMessageForArkFlashChat;
  }
  
  public static MessageForHiBoom a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, HiBoomMessage paramHiBoomMessage)
  {
    if (paramHiBoomMessage == null) {
      return null;
    }
    MessageForHiBoom localMessageForHiBoom = new MessageForHiBoom();
    localMessageForHiBoom.mHiBoomMessage = paramHiBoomMessage;
    localMessageForHiBoom.msg = paramHiBoomMessage.text;
    localMessageForHiBoom.msgtype = -5014;
    try
    {
      localMessageForHiBoom.msgData = MessagePkgUtils.a(paramHiBoomMessage);
      a(paramQQAppInterface, localMessageForHiBoom, paramString1, paramString2, paramInt);
      localMessageForHiBoom.longMsgCount = 1;
      localMessageForHiBoom.longMsgIndex = 0;
      localMessageForHiBoom.longMsgId = ((short)(int)localMessageForHiBoom.shmsgseq);
      return localMessageForHiBoom;
    }
    catch (Exception paramHiBoomMessage)
    {
      for (;;)
      {
        QLog.e("HiBoomFont.MessageRecordFactory", 1, "createSendMsg_HiBoom error: ", paramHiBoomMessage);
      }
    }
  }
  
  public static MessageForMarketFace a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, MarkFaceMessage paramMarkFaceMessage)
  {
    MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)a(-2007);
    localMessageForMarketFace.msgtype = -2007;
    localMessageForMarketFace.mMarkFaceMessage = paramMarkFaceMessage;
    localMessageForMarketFace.mIsParsed = true;
    a(paramQQAppInterface, localMessageForMarketFace, paramString1, paramString2, paramInt);
    try
    {
      localMessageForMarketFace.msgData = MessagePkgUtils.a(paramMarkFaceMessage);
      return localMessageForMarketFace;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MessageForMarketFace", 1, "createSendMsg_MarketFace: ", paramQQAppInterface);
    }
    return localMessageForMarketFace;
  }
  
  public static MessageForMixedMsg a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForMixedMsg localMessageForMixedMsg = new MessageForMixedMsg();
    localMessageForMixedMsg.msgtype = -1035;
    a(paramQQAppInterface, localMessageForMixedMsg, paramString1, paramString2, paramInt);
    localMessageForMixedMsg.longMsgCount = 1;
    localMessageForMixedMsg.longMsgIndex = 0;
    localMessageForMixedMsg.longMsgId = ((short)(int)localMessageForMixedMsg.shmsgseq);
    return localMessageForMixedMsg;
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.msgtype = -2000;
    a(paramQQAppInterface, localMessageForPic, paramString1, paramString2, paramInt);
    localMessageForPic.longMsgCount = 1;
    localMessageForPic.longMsgIndex = 0;
    localMessageForPic.longMsgId = ((short)(int)localMessageForPic.shmsgseq);
    return localMessageForPic;
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.msgtype = -2002;
    a(paramQQAppInterface, localMessageForPtt, paramString1, paramString2, paramInt);
    localMessageForPtt.longMsgCount = 1;
    localMessageForPtt.longMsgIndex = 0;
    localMessageForPtt.longMsgId = ((short)(int)localMessageForPtt.shmsgseq);
    return localMessageForPtt;
  }
  
  public static MessageForQQStory a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForQQStory)a(-2051);
    paramString1.msgtype = -2051;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = false;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
      if (paramAbsStructMsg.sourceAccoutType != 0) {
        paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
      }
      return paramString1;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
        }
      }
    }
  }
  
  public static MessageForReplyText a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (paramSourceMsgInfo == null) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)a(-1049);
      localMessageForReplyText.selfuin = paramQQAppInterface.getCurrentAccountUin();
      localMessageForReplyText.frienduin = paramString1;
      localMessageForReplyText.senderuin = paramQQAppInterface.getCurrentAccountUin();
      localMessageForReplyText.msg = paramString2;
      localMessageForReplyText.msgtype = -1049;
      localMessageForReplyText.isread = true;
      localMessageForReplyText.issend = 1;
      localMessageForReplyText.istroop = paramInt;
      localMessageForReplyText.msgUid = MessageUtils.a(MessageUtils.a());
      paramString1 = paramQQAppInterface.a().a(localMessageForReplyText.senderuin, paramInt);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        localMessageForReplyText.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
        localMessageForReplyText.time = MessageCache.a();
        localMessageForReplyText.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramSourceMsgInfo);
        localMessageForReplyText.mSourceMsgInfo.mSourceSummaryFlag = 1;
        localMessageForReplyText.sb = paramString2;
      }
      try
      {
        localMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.a(MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo)));
        paramString1 = localMessageForReplyText;
        if (!localMessageForReplyText.isSend()) {
          continue;
        }
        ((SVIPHandler)paramQQAppInterface.a(13)).a(localMessageForReplyText);
        return localMessageForReplyText;
        localMessageForReplyText.shmsgseq = Math.abs(new Random().nextInt());
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessageRecordFactory", 2, QLog.getStackTraceString(paramString1));
          }
        }
      }
    }
  }
  
  public static MessageForShakeWindow a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    int i = MessageUtils.a();
    int j = (int)MessageCache.a();
    paramString1 = new MessageForShakeWindow(Long.valueOf(paramString1).longValue(), Long.valueOf(paramString2).longValue(), Long.valueOf(paramString3).longValue(), j, paramInt, paramLong);
    paramString2 = new ShakeWindowMsg();
    paramString2.shake = true;
    paramString2.onlineFlag = 1;
    paramString2.mType = 0;
    paramString2.mReserve = 0;
    paramString1.msgData = paramString2.getBytes();
    paramString1.mShakeWindowMsg = paramString2;
    paramString1.mIsParsed = true;
    paramString1.issend = 1;
    paramString1.isread = true;
    paramString1.msgUid = MessageUtils.a(i);
    paramString1.shmsgseq = MessageUtils.a(paramLong, paramInt);
    paramString1.longMsgCount = 1;
    paramString1.longMsgIndex = 0;
    paramString1.longMsgId = ((short)(int)paramLong);
    return paramString1;
  }
  
  public static MessageForShortVideo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForShortVideo localMessageForShortVideo = new MessageForShortVideo();
    localMessageForShortVideo.msgtype = -2022;
    a(paramQQAppInterface, localMessageForShortVideo, paramString1, paramString2, paramInt);
    localMessageForShortVideo.longMsgCount = 1;
    localMessageForShortVideo.longMsgIndex = 0;
    localMessageForShortVideo.longMsgId = ((short)(int)localMessageForShortVideo.shmsgseq);
    return localMessageForShortVideo;
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForStructing)a(-2011);
    paramString1.msgtype = -2011;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = true;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
      if (paramAbsStructMsg.sourceAccoutType != 0) {
        paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
      }
      return paramString1;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
        }
      }
    }
  }
  
  public static MessageForText a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, byte paramByte1, byte paramByte2, short paramShort, String paramString4)
  {
    paramString1 = (MessageForText)a(-1000);
    paramString1.msgtype = -1000;
    paramString1.longMsgCount = paramByte1;
    paramString1.longMsgIndex = paramByte2;
    paramString1.longMsgId = paramShort;
    paramString1.msg = paramString4;
    try
    {
      paramString1.msgData = paramString4.getBytes("utf-8");
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
      paramString1.parse();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString4)
    {
      for (;;)
      {
        paramString4.printStackTrace();
      }
    }
  }
  
  public static MessageForTribeShortVideo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForTribeShortVideo)a(-7002);
    paramString1.msgtype = -7002;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = false;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
      if (paramAbsStructMsg.sourceAccoutType != 0) {
        paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
      }
      return paramString1;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
        }
      }
    }
  }
  
  public static MessageRecord a(int paramInt)
  {
    MessageRecord localMessageRecord = b(paramInt);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      localObject = new MessageForText();
      ((MessageRecord)localObject).msgtype = paramInt;
    }
    return localObject;
  }
  
  public static MessageRecord a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3)
  {
    Object localObject2 = b(paramInt1);
    if (localObject2 != null)
    {
      ((MessageRecord)localObject2).msgtype = paramInt1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      if ((localObject1 != null) && (((MessageRecord)localObject1).msgtype == -2056)) {}
      try
      {
        paramArrayOfByte = new JSONObject(paramString);
        if (paramArrayOfByte.has(MessageForWantGiftMsg.GIFT_SENDER_UIN)) {
          if (QLog.isColorLevel()) {
            QLog.e("MessageForWantGiftMsg.GIFT_SENDER_UIN", 2, " MessageForWantGiftMsg.GIFT_SENDER_UIN  " + MessageForWantGiftMsg.GIFT_SENDER_UIN);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          ((MessageForWantGiftMsg)localObject1).wantGiftSenderUin = Long.valueOf(paramArrayOfByte.getString(MessageForWantGiftMsg.GIFT_SENDER_UIN)).longValue();
          label112:
          ((MessageForWantGiftMsg)localObject1).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramArrayOfByte.getString(MessageForWantGiftMsg.GIFT_SENDER_UIN));
          label130:
          if ((paramInt1 == -1000) || (paramInt1 == -2006))
          {
            paramArrayOfByte = (byte[])localObject1;
            if (paramInt3 == 1)
            {
              paramArrayOfByte = (byte[])localObject1;
              if ((paramInt2 & 0x1) != 1) {}
            }
          }
          for (paramArrayOfByte = (byte[])localObject1;; paramArrayOfByte = (byte[])localObject1)
          {
            try
            {
              if (!TextUtils.isEmpty(paramString))
              {
                localObject2 = new JSONObject(paramString);
                paramArrayOfByte = (byte[])localObject1;
                if (((JSONObject)localObject2).has("redbag_fold_msg"))
                {
                  paramArrayOfByte = (byte[])localObject1;
                  if (((JSONObject)localObject2).getString("redbag_fold_msg").equals("true")) {
                    paramArrayOfByte = new MessageForFoldMsg();
                  }
                }
              }
              localObject1 = paramArrayOfByte;
              if (paramInt1 != -2058) {}
            }
            catch (Exception paramArrayOfByte)
            {
              label301:
              if (QLog.isColorLevel()) {
                QLog.e("msgFold", 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
              }
            }
            try
            {
              paramString = new JSONObject(paramString);
              localObject1 = paramArrayOfByte;
              if (paramString.has("Emoji_Sticker_Info"))
              {
                paramString = new JSONObject(paramString.getString("Emoji_Sticker_Info"));
                localObject1 = paramArrayOfByte;
                if (paramString != null)
                {
                  paramInt2 = paramString.optInt("msgType", 0);
                  localObject1 = paramArrayOfByte;
                  if (paramInt2 != 0) {
                    localObject1 = b(paramInt2);
                  }
                }
              }
            }
            catch (Exception paramString)
            {
              localObject1 = paramArrayOfByte;
              if (!QLog.isColorLevel()) {
                break label301;
              }
              QLog.e("MessageRecordFactory", 2, "", paramString);
              localObject1 = paramArrayOfByte;
              break label301;
            }
            paramArrayOfByte = (byte[])localObject1;
            if (localObject1 == null)
            {
              paramArrayOfByte = new MessageForText();
              paramArrayOfByte.msgtype = paramInt1;
            }
            return paramArrayOfByte;
            localObject1 = localObject2;
            if (paramArrayOfByte == null) {
              break;
            }
            for (;;)
            {
              for (;;)
              {
                try
                {
                  paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
                  if ((paramArrayOfByte == null) || (paramArrayOfByte.length() <= 0) || (paramArrayOfByte.charAt(0) != '\026')) {
                    continue;
                  }
                  paramArrayOfByte = paramArrayOfByte.split("\\|");
                  if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {
                    continue;
                  }
                  i = Integer.parseInt(paramArrayOfByte[2]);
                  if (i == 3) {
                    paramArrayOfByte = new MessageForGrayTips();
                  }
                }
                catch (Exception paramArrayOfByte)
                {
                  int i;
                  localObject1 = localException2;
                  continue;
                  paramArrayOfByte = localException3;
                  continue;
                }
                try
                {
                  paramArrayOfByte.msgtype = -1001;
                  localObject1 = paramArrayOfByte;
                }
                catch (Exception localException3)
                {
                  localObject1 = paramArrayOfByte;
                  paramArrayOfByte = localException3;
                }
              }
              if ((i != 2) && (i != 8)) {
                continue;
              }
              paramArrayOfByte = new MessageForPtt();
              try
              {
                paramArrayOfByte.msgtype = -2002;
              }
              catch (Exception localException1)
              {
                localObject1 = paramArrayOfByte;
                paramArrayOfByte = localException1;
              }
            }
            paramArrayOfByte.printStackTrace();
            break;
            paramArrayOfByte = paramArrayOfByte;
            if (!QLog.isColorLevel()) {
              break label130;
            }
            QLog.e("MessageForWantGiftMsg.GIFT_SENDER_UIN", 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
            break label130;
          }
        }
        catch (Exception localException2)
        {
          break label112;
        }
      }
    }
  }
  
  public static MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      paramMessageRecord = null;
    }
    MessageRecord localMessageRecord;
    do
    {
      return paramMessageRecord;
      localMessageRecord = a(paramMessageRecord.msgtype);
      localMessageRecord.msgtype = paramMessageRecord.msgtype;
      a(localMessageRecord, paramMessageRecord);
      if (paramMessageRecord.msgData != null) {
        localMessageRecord.msgData = paramMessageRecord.msgData;
      }
      if (paramMessageRecord.msg != null) {
        localMessageRecord.msg = paramMessageRecord.msg;
      }
      paramMessageRecord = localMessageRecord;
    } while (!(localMessageRecord instanceof ChatMessage));
    ((ChatMessage)localMessageRecord).parse();
    return localMessageRecord;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    int i = MessageUtils.a();
    int j = (int)MessageCache.a();
    int k = MobileQQService.a;
    MobileQQService.a = k + 1;
    long l = k;
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    String str1;
    if ((paramInt == 1000) || (paramInt == 1020) || (paramInt == 1004)) {
      if (paramString2 != null)
      {
        str1 = paramString2;
        if (paramString2.length() != 0) {}
      }
      else
      {
        str1 = paramString2;
        if (QLog.isColorLevel())
        {
          QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error groupUin:" + paramString2);
          str1 = paramString2;
        }
      }
    }
    for (;;)
    {
      if ((!(paramMessageRecord instanceof MessageForPoke)) && (paramInt == 0))
      {
        PokeItemAnimationManager.a().a(paramQQAppInterface, paramString1, -1, 0, -1);
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "send unPokeMsg strength:-1");
        }
      }
      paramMessageRecord.frienduin = paramString1;
      paramMessageRecord.istroop = paramInt;
      paramMessageRecord.selfuin = str2;
      paramMessageRecord.senderuin = str1;
      paramMessageRecord.isread = true;
      paramMessageRecord.time = j;
      paramMessageRecord.msgseq = l;
      paramMessageRecord.msgUid = MessageUtils.a(i);
      paramMessageRecord.shmsgseq = MessageUtils.a(l, paramInt);
      paramMessageRecord.issend = 1;
      return;
      if (paramInt == 1006)
      {
        paramString2 = ((PhoneContactManager)paramQQAppInterface.getManager(10)).a();
        if (paramString2 != null)
        {
          paramString2 = paramString2.nationCode + paramString2.mobileNo;
          if (paramString2 != null)
          {
            str1 = paramString2;
            if (paramString2.length() > 0) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error selfPhoneNum:" + paramString2);
          }
        }
      }
      str1 = str2;
    }
  }
  
  private static void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramMessageRecord1.selfuin = paramMessageRecord2.selfuin;
    paramMessageRecord1.frienduin = paramMessageRecord2.frienduin;
    paramMessageRecord1.senderuin = paramMessageRecord2.senderuin;
    paramMessageRecord1.istroop = paramMessageRecord2.istroop;
    paramMessageRecord1.longMsgCount = paramMessageRecord2.longMsgCount;
    paramMessageRecord1.longMsgId = paramMessageRecord2.longMsgId;
    paramMessageRecord1.longMsgIndex = paramMessageRecord2.longMsgIndex;
    paramMessageRecord1.isread = true;
    paramMessageRecord1.issend = 1;
    paramMessageRecord1.msgseq = paramMessageRecord2.msgseq;
    paramMessageRecord1.shmsgseq = paramMessageRecord2.shmsgseq;
    paramMessageRecord1.msgUid = paramMessageRecord2.msgUid;
    paramMessageRecord1.extStr = paramMessageRecord2.extStr;
    paramMessageRecord1.extLong = paramMessageRecord2.extLong;
    if (AnonymousChatHelper.a(paramMessageRecord2)) {
      paramMessageRecord1.vipBubbleID = paramMessageRecord2.vipBubbleID;
    }
    paramMessageRecord1.time = ((int)MessageCache.a());
  }
  
  public static MessageForArkApp b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return null;
    }
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.ark_app_message = paramArkAppMessage;
    localMessageForArkApp.ark_app_message.fromAppXml(paramArkAppMessage.toAppXml());
    localMessageForArkApp.msgtype = -5017;
    localMessageForArkApp.msg = paramArkAppMessage.getSummery();
    localMessageForArkApp.msgData = paramArkAppMessage.toBytes();
    a(paramQQAppInterface, localMessageForArkApp, paramString1, paramString2, paramInt);
    localMessageForArkApp.longMsgCount = 1;
    localMessageForArkApp.longMsgIndex = 0;
    localMessageForArkApp.longMsgId = ((short)(int)localMessageForArkApp.shmsgseq);
    return localMessageForArkApp;
  }
  
  public static MessageForPtt b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevPtt localMessageForDevPtt = new MessageForDevPtt();
    localMessageForDevPtt.msgtype = -4501;
    a(paramQQAppInterface, localMessageForDevPtt, paramString1, paramString2, paramInt);
    localMessageForDevPtt.longMsgCount = 1;
    localMessageForDevPtt.longMsgIndex = 0;
    localMessageForDevPtt.longMsgId = ((short)(int)localMessageForDevPtt.shmsgseq);
    return localMessageForDevPtt;
  }
  
  public static MessageForShortVideo b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForBlessPTV localMessageForBlessPTV = new MessageForBlessPTV();
    localMessageForBlessPTV.msgtype = -2022;
    a(paramQQAppInterface, localMessageForBlessPTV, paramString1, paramString2, paramInt);
    localMessageForBlessPTV.longMsgCount = 1;
    localMessageForBlessPTV.longMsgIndex = 0;
    localMessageForBlessPTV.longMsgId = ((short)(int)localMessageForBlessPTV.shmsgseq);
    return localMessageForBlessPTV;
  }
  
  private static MessageRecord b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    case -2010: 
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (MessageUtils.a(paramInt))
        {
          if (paramInt != -1002) {
            break label1719;
          }
          localObject2 = new MessageForSafeGrayTips();
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject2 != null) {
        ((MessageRecord)localObject2).msgtype = paramInt;
      }
      return localObject2;
      localObject1 = new MessageForWantGiftMsg();
      break;
      localObject1 = new MessageForText();
      break;
      localObject1 = new MessageForPic();
      break;
      localObject1 = new MessageForStructing();
      break;
      localObject1 = new MessageForTroopTopic();
      break;
      localObject1 = new MessageForTroopNotification();
      break;
      localObject1 = new MessageForMarketFace();
      break;
      localObject1 = new MessageForPubAccount();
      break;
      localObject1 = new MessageForPtt();
      break;
      localObject1 = new MessageForFile();
      break;
      localObject1 = new MessageForRichState();
      break;
      localObject1 = new MessageForDateFeed();
      break;
      localObject1 = new MessageForVideo();
      break;
      localObject1 = new MessageForActivity();
      break;
      localObject1 = new MessageForEnterTroop();
      break;
      localObject1 = new MessageForMixedMsg();
      break;
      localObject1 = new MessageForQzoneFeed();
      break;
      localObject1 = new MessageForSystemMsg();
      break;
      localObject1 = new MessageForMyEnterTroop();
      break;
      localObject1 = new MessageForTroopFile();
      break;
      localObject1 = new MessageForShakeWindow();
      ((MessageRecord)localObject1).msgtype = -2020;
      break;
      localObject1 = new MessageForTroopUnreadTips();
      break;
      localObject1 = new MessageForSplitLineTips();
      break;
      localObject1 = new MessageForText();
      break;
      localObject1 = new MessageForShortVideo();
      break;
      localObject1 = new MessageForColorRing();
      break;
      localObject1 = new MessageForQQWalletMsg();
      break;
      localObject1 = new MessageForActivateFriends();
      break;
      localObject1 = new MessageForDeviceFile();
      break;
      localObject1 = new MessageForDevPtt();
      break;
      localObject1 = new MessageForDevShortVideo();
      break;
      localObject1 = new MessageForDevLittleVideo();
      break;
      localObject1 = new MessageForDeviceSingleStruct();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForQQWalletTips();
      break;
      localObject1 = new MessageForDeviceText();
      break;
      localObject1 = new ShareHotChatGrayTips();
      break;
      localObject1 = new MessageForDeliverGiftTips();
      break;
      localObject1 = new MessageForTroopGift();
      break;
      localObject1 = new MessageForTroopFee();
      break;
      localObject1 = new MessageForApollo();
      break;
      localObject1 = new MessageForArkApp();
      break;
      localObject1 = new MessageForArkFlashChat();
      break;
      localObject1 = new MessageForHiBoom();
      break;
      localObject1 = new MessageForReplyText();
      break;
      localObject1 = new MessageForApproval();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForTroopReward();
      break;
      localObject1 = new MessageForDingdongSchedule();
      break;
      localObject1 = new MessageForVideoVip();
      break;
      localObject1 = new MessageForVIPDonate();
      break;
      localObject1 = new MessageForFoldMsgGrayTips();
      break;
      localObject1 = new MessageForGrayTips();
      break;
      localObject1 = new MessageForPoke();
      break;
      localObject1 = new MessageForPokeEmo();
      break;
      localObject1 = new MessageForLongTextMsg();
      break;
      localObject1 = new MessageForUniteGrayTip();
      break;
      localObject1 = new MessageForQQStory();
      break;
      localObject1 = new MessageForTroopPobing();
      break;
      localObject1 = new MessageForQQStoryComment();
      break;
      localObject1 = new MessageForNearbyLiveTip();
      break;
      localObject1 = new MessageForTroopSign();
      break;
      localObject1 = new MessageForInteractAndFollow();
      break;
      localObject1 = new MessageForTroopStory();
      break;
      localObject1 = new MessageForScribble();
      break;
      localObject1 = new MessageForPLNews();
      break;
      localObject1 = new MessageForMedalNews();
      break;
      localObject1 = new MessageForCommonHobbyForAIOShow();
      break;
      localObject1 = new MessageForConfessNews();
      break;
      localObject1 = new MessageForConfessCard();
      break;
      localObject1 = new MessageForTroopConfess();
      break;
      localObject1 = new MessageForTroopEffectPic();
      break;
      localObject1 = new MessageForArkBabyqReply();
      break;
      localObject1 = new MessageForQQStoryFeed();
      break;
      localObject1 = new MessageForArkApp();
      break;
      localObject1 = new MessageForTribeShortVideo();
      break;
      label1719:
      if ((paramInt == -5000) || (paramInt == -5001) || (paramInt == -2037)) {
        localObject2 = new MessageForNewGrayTips();
      } else if (paramInt == -5002) {
        localObject2 = new MessageForIncompatibleGrayTips();
      } else if (paramInt == -2027) {
        localObject2 = new MessageForNearbyMarketGrayTips();
      } else if (paramInt == -4011) {
        localObject2 = new MessageForNearbyRecommenderTips();
      } else {
        localObject2 = new MessageForGrayTips();
      }
    }
  }
  
  public static MessageForShortVideo c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDanceMachine localMessageForDanceMachine = new MessageForDanceMachine();
    localMessageForDanceMachine.msgtype = -2022;
    a(paramQQAppInterface, localMessageForDanceMachine, paramString1, paramString2, paramInt);
    localMessageForDanceMachine.longMsgCount = 1;
    localMessageForDanceMachine.longMsgIndex = 0;
    localMessageForDanceMachine.longMsgId = ((short)(int)localMessageForDanceMachine.shmsgseq);
    return localMessageForDanceMachine;
  }
  
  public static MessageForShortVideo d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevShortVideo localMessageForDevShortVideo = new MessageForDevShortVideo();
    localMessageForDevShortVideo.msgtype = -4503;
    a(paramQQAppInterface, localMessageForDevShortVideo, paramString1, paramString2, paramInt);
    localMessageForDevShortVideo.longMsgCount = 1;
    localMessageForDevShortVideo.longMsgIndex = 0;
    localMessageForDevShortVideo.longMsgId = ((short)(int)localMessageForDevShortVideo.shmsgseq);
    return localMessageForDevShortVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageRecordFactory
 * JD-Core Version:    0.7.0.1
 */