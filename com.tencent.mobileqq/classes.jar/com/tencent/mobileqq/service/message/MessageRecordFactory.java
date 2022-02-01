package com.tencent.mobileqq.service.message;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.imcore.message.core.CreateMessageRecordCallbackGenerator;
import com.tencent.imcore.message.core.CreateMessageRecordCallbackGeneratorImpl;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForDateFeed;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageForLocationShare;
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
import com.tencent.mobileqq.data.MessageForQCircleFeed;
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
import com.tencent.mobileqq.data.MessageForStarLeague;
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
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageForVideoVip;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static CreateMessageRecordCallbackGenerator a = new CreateMessageRecordCallbackGeneratorImpl();
  
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
  
  public static CreateMessageRecordCallbackGenerator a()
  {
    return a;
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
      localMessageForApollo.msg = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloDescMsg(localMessageForApollo);
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
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)b(-5008);
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
      paramString1 = paramQQAppInterface.getMessageFacade().a(localMessageForReplyText.senderuin, paramInt);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        localMessageForReplyText.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
        localMessageForReplyText.time = MessageCache.a();
        localMessageForReplyText.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramSourceMsgInfo);
        localMessageForReplyText.sb = paramString2;
      }
      try
      {
        localMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo)));
        paramString1 = localMessageForReplyText;
        if (!localMessageForReplyText.isSend()) {
          continue;
        }
        ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForReplyText);
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
  
  private static MessageRecord a(int paramInt1, int paramInt2, String paramString, int paramInt3, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (paramInt1 != -1000)
    {
      localObject = paramMessageRecord;
      if (paramInt1 != -2006) {}
    }
    else
    {
      localObject = paramMessageRecord;
      if (paramInt3 == 1)
      {
        localObject = paramMessageRecord;
        if ((paramInt2 & 0x1) == 1) {
          localObject = paramMessageRecord;
        }
      }
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localObject = paramMessageRecord;
        if (paramString.has("redbag_fold_msg"))
        {
          localObject = paramMessageRecord;
          if (paramString.getString("redbag_fold_msg").equals("true")) {
            localObject = new MessageForFoldMsg();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      do
      {
        localObject = paramMessageRecord;
      } while (!QLog.isColorLevel());
      QLog.e("msgFold", 2, paramString.getMessage(), paramString);
    }
    return localObject;
    return paramMessageRecord;
  }
  
  private static MessageRecord a(int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord;
    if (paramMessageRecord == null)
    {
      localObject = paramMessageRecord;
      if (MessageUtils.a(paramInt))
      {
        if (paramInt != -1002) {
          break label32;
        }
        localObject = new MessageForSafeGrayTips();
      }
    }
    return localObject;
    label32:
    if ((paramInt == -5000) || (paramInt == -5001) || (paramInt == -2037)) {
      return new MessageForNewGrayTips();
    }
    if (paramInt == -5002) {
      return new MessageForIncompatibleGrayTips();
    }
    if (paramInt == -2027) {
      return new MessageForNearbyMarketGrayTips();
    }
    if (paramInt == -4011) {
      return new MessageForNearbyRecommenderTips();
    }
    return new MessageForGrayTips();
  }
  
  private static MessageRecord a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    MessageRecord localMessageRecord = paramMessageRecord;
    if (paramInt == -2058) {}
    try
    {
      paramString = new JSONObject(paramString);
      localMessageRecord = paramMessageRecord;
      if (paramString.has("Emoji_Sticker_Info"))
      {
        paramInt = new JSONObject(paramString.getString("Emoji_Sticker_Info")).optInt("msgType", 0);
        localMessageRecord = paramMessageRecord;
        if (paramInt != 0) {
          localMessageRecord = b(paramInt);
        }
      }
    }
    catch (Exception paramString)
    {
      do
      {
        localMessageRecord = paramMessageRecord;
      } while (!QLog.isColorLevel());
      QLog.e("MessageRecordFactory", 2, "", paramString);
    }
    return localMessageRecord;
    return paramMessageRecord;
  }
  
  public static MessageRecord a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3)
  {
    MessageRecord localMessageRecord2 = b(paramInt1);
    MessageRecord localMessageRecord1;
    if (localMessageRecord2 != null)
    {
      localMessageRecord2.msgtype = paramInt1;
      localMessageRecord1 = localMessageRecord2;
    }
    for (;;)
    {
      a(paramString, localMessageRecord1);
      paramString = a(paramInt1, paramString, a(paramInt1, paramInt2, paramString, paramInt3, localMessageRecord1));
      paramArrayOfByte = paramString;
      if (paramString == null)
      {
        paramArrayOfByte = new MessageForText();
        paramArrayOfByte.msgtype = paramInt1;
      }
      return paramArrayOfByte;
      localMessageRecord1 = localMessageRecord2;
      if (paramArrayOfByte != null) {
        localMessageRecord1 = a(paramArrayOfByte, localMessageRecord2);
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
  
  private static MessageRecord a(byte[] paramArrayOfByte, MessageRecord paramMessageRecord)
  {
    label78:
    do
    {
      try
      {
        Object localObject = new String(paramArrayOfByte, "UTF-8");
        paramArrayOfByte = paramMessageRecord;
        if (((String)localObject).length() > 0)
        {
          paramArrayOfByte = paramMessageRecord;
          if (((String)localObject).charAt(0) == '\026')
          {
            localObject = ((String)localObject).split("\\|");
            paramArrayOfByte = paramMessageRecord;
            if (localObject.length > 2)
            {
              i = Integer.parseInt(localObject[2]);
              if (i != 3) {
                break label78;
              }
              paramArrayOfByte = new MessageForGrayTips();
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          int i;
          paramArrayOfByte.msgtype = -2002;
          return paramArrayOfByte;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramMessageRecord = paramArrayOfByte;
            paramArrayOfByte = localException2;
          }
        }
        paramArrayOfByte = paramArrayOfByte;
      }
      try
      {
        paramArrayOfByte.msgtype = -1001;
        return paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          paramMessageRecord = paramArrayOfByte;
          paramArrayOfByte = localException1;
        }
      }
      if (i == 2) {
        break;
      }
      paramArrayOfByte = paramMessageRecord;
    } while (i != 8);
    paramArrayOfByte = new MessageForPtt();
    paramArrayOfByte.printStackTrace();
    return paramMessageRecord;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    int i = MessageUtils.a();
    int j = (int)MessageCache.a();
    int k = MobileQQService.seq;
    MobileQQService.seq = k + 1;
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
        paramString2 = ((PhoneContactManager)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
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
  
  /* Error */
  private static void a(String paramString, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +101 -> 102
    //   4: aload_1
    //   5: getfield 429	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   8: sipush -2056
    //   11: if_icmpne +91 -> 102
    //   14: new 437	org/json/JSONObject
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 440	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: getstatic 630	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   27: invokevirtual 446	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   30: ifeq +72 -> 102
    //   33: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +32 -> 68
    //   39: ldc_w 632
    //   42: iconst_2
    //   43: new 543	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 544	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 634
    //   53: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: getstatic 630	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   59: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 555	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_1
    //   69: checkcast 627	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   72: aload_0
    //   73: getstatic 630	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   76: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 639	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   82: invokevirtual 642	java/lang/Long:longValue	()J
    //   85: putfield 645	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   88: aload_1
    //   89: getstatic 630	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   92: aload_0
    //   93: getstatic 630	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   96: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokevirtual 646	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: return
    //   103: astore_0
    //   104: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -5 -> 102
    //   110: ldc_w 632
    //   113: iconst_2
    //   114: aload_0
    //   115: invokevirtual 245	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: aload_0
    //   119: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: return
    //   123: astore_2
    //   124: goto -36 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   0	127	1	paramMessageRecord	MessageRecord
    //   123	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   14	68	103	java/lang/Exception
    //   88	102	103	java/lang/Exception
    //   68	88	123	java/lang/Exception
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
    MessageRecord localMessageRecord = a(paramInt, c(paramInt));
    if (localMessageRecord != null) {
      localMessageRecord.msgtype = paramInt;
    }
    return localMessageRecord;
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
  
  private static MessageRecord c(int paramInt)
  {
    MessageRecord localMessageRecord = null;
    switch (paramInt)
    {
    default: 
      localMessageRecord = d(paramInt);
    case -2010: 
      return localMessageRecord;
    case -2056: 
      return new MessageForWantGiftMsg();
    case -2008: 
    case -1003: 
    case -1000: 
      return new MessageForText();
    case -20000: 
    case -3005: 
    case -3004: 
    case -3001: 
    case -3000: 
    case -2000: 
    case -1032: 
      return new MessageForPic();
    case -2011: 
      return new MessageForStructing();
    case -2021: 
      return new MessageForTroopNotification();
    case -2007: 
      return new MessageForMarketFace();
    case -5004: 
    case -3006: 
      return new MessageForPubAccount();
    case -2002: 
    case -1031: 
      return new MessageForPtt();
    }
    return new MessageForFile();
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
  
  private static MessageRecord d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return e(paramInt);
    case -1034: 
      return new MessageForRichState();
    case -1042: 
      return new MessageForDateFeed();
    case -2046: 
    case -2026: 
    case -2016: 
    case -2009: 
      return new MessageForVideo();
    case -2076: 
      return new MessageForLocationShare();
    case -10000: 
      return new MessageForAutoReply();
    case -4002: 
      return new MessageForActivity();
    case -4003: 
      return new MessageForEnterTroop();
    case -1035: 
      return new MessageForMixedMsg();
    case -2015: 
      return new MessageForQzoneFeed();
    case -2050: 
    case -2018: 
      return new MessageForSystemMsg();
    case -4004: 
      return new MessageForMyEnterTroop();
    case -2017: 
      return new MessageForTroopFile();
    case -2020: 
      MessageForShakeWindow localMessageForShakeWindow = new MessageForShakeWindow();
      localMessageForShakeWindow.msgtype = -2020;
      return localMessageForShakeWindow;
    case -4009: 
      return new MessageForTroopUnreadTips();
    case -4012: 
      return new MessageForSplitLineTips();
    }
    return new MessageForShortVideo();
  }
  
  private static MessageRecord e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return f(paramInt);
    case -3012: 
      return new MessageForColorRing();
    case -2025: 
      return new MessageForQQWalletMsg();
    case -5003: 
      return new MessageForActivateFriends();
    case -4500: 
      return new MessageForDeviceFile();
    case -4501: 
      return new MessageForDevPtt();
    case -4503: 
      return new MessageForDevShortVideo();
    case -4509: 
      return new MessageForDevLittleVideo();
    case -4502: 
      return new MessageForDeviceSingleStruct();
    case -4507: 
    case -4506: 
    case -4505: 
    case -2049: 
    case -2043: 
    case -2041: 
      return new MessageForGrayTips();
    case -2029: 
      return new MessageForQQWalletTips();
    case -4508: 
      return new MessageForDeviceText();
    case -2033: 
      return new ShareHotChatGrayTips();
    case -2035: 
      return new MessageForDeliverGiftTips();
    case -2038: 
      return new MessageForTroopGift();
    }
    return new MessageForTroopFee();
  }
  
  private static MessageRecord f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return g(paramInt);
    case -2039: 
      return new MessageForApollo();
    case -7004: 
      return new MessageForCmGameTips();
    case -5017: 
    case -5008: 
    case -4027: 
    case -4026: 
    case -4025: 
      return new MessageForArkApp();
    case -5013: 
      return new MessageForArkFlashChat();
    case -5014: 
      return new MessageForHiBoom();
    case -1049: 
      return new MessageForReplyText();
    case -2040: 
      return new MessageForApproval();
    case -2048: 
      return new MessageForTroopReward();
    case -2045: 
      return new MessageForVideoVip();
    case -2047: 
      return new MessageForVIPDonate();
    case -5011: 
      return new MessageForFoldMsgGrayTips();
    case -5012: 
      return new MessageForPoke();
    case -5018: 
      return new MessageForPokeEmo();
    }
    return new MessageForLongTextMsg();
  }
  
  private static MessageRecord g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return h(paramInt);
    case -5040: 
    case -5023: 
    case -5022: 
    case -5021: 
    case -5020: 
      return new MessageForUniteGrayTip();
    case -2051: 
      return new MessageForQQStory();
    case -2059: 
      return new MessageForTroopPobing();
    case -2052: 
      return new MessageForQQStoryComment();
    case -2053: 
      return new MessageForNearbyLiveTip();
    case -2054: 
      return new MessageForTroopSign();
    case -2055: 
      return new MessageForInteractAndFollow();
    case -2057: 
      return new MessageForTroopStory();
    case -7001: 
      return new MessageForScribble();
    case -2060: 
      return new MessageForPLNews();
    case -2062: 
      return new MessageForMedalNews();
    case -2023: 
      return new MessageForCommonHobbyForAIOShow();
    case -2065: 
      return new MessageForConfessNews();
    case -2066: 
      return new MessageForConfessCard();
    case -2067: 
      return new MessageForTroopConfess();
    }
    return new MessageForTroopEffectPic();
  }
  
  private static MessageRecord h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return i(paramInt);
    case -5016: 
      return new MessageForArkBabyqReply();
    case -2061: 
      return new MessageForQQStoryFeed();
    case -7002: 
      return new MessageForTribeShortVideo();
    case -2068: 
      return new MessageForDarenAssistant();
    case -4024: 
    case -4023: 
      return new MessageForLimitChatTopic();
    case -7005: 
      return new MessageForLimitChatConfirm();
    case -2069: 
      return new MessageForStarLeague();
    case -2070: 
      return new MessageForYanZhi();
    case -2072: 
      return new MessageForFuDai();
    case -7007: 
      return new MessageForBirthdayNotice();
    case -2074: 
      return new MessageForAIOStoryVideo();
    case -3017: 
      return new MessageForDLFile();
    }
    return new MessageForQCircleFeed();
  }
  
  private static MessageRecord i(int paramInt)
  {
    CreateMessageRecordCallback localCreateMessageRecordCallback = (CreateMessageRecordCallback)a.a(Integer.valueOf(paramInt));
    if (localCreateMessageRecordCallback != null) {
      return localCreateMessageRecordCallback.a(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageRecordFactory
 * JD-Core Version:    0.7.0.1
 */