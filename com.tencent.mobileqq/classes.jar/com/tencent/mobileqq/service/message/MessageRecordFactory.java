package com.tencent.mobileqq.service.message;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.imcore.message.core.CreateMessageRecordCallbackGenerator;
import com.tencent.imcore.message.core.CreateMessageRecordCallbackGeneratorImpl;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDLFile;
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
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

public class MessageRecordFactory
{
  private static CreateMessageRecordCallbackGenerator a = new CreateMessageRecordCallbackGeneratorImpl();
  
  public static CreateMessageRecordCallbackGenerator a()
  {
    return a;
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
    }
    catch (Exception paramHiBoomMessage)
    {
      QLog.e("HiBoomFont.MessageRecordFactory", 1, "createSendMsg_HiBoom error: ", paramHiBoomMessage);
    }
    a(paramQQAppInterface, localMessageForHiBoom, paramString1, paramString2, paramInt);
    localMessageForHiBoom.longMsgCount = 1;
    localMessageForHiBoom.longMsgIndex = 0;
    localMessageForHiBoom.longMsgId = ((short)(int)localMessageForHiBoom.shmsgseq);
    return localMessageForHiBoom;
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
  
  public static MessageForPic a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.msgtype = -2000;
    a(paramAppInterface, localMessageForPic, paramString1, paramString2, paramInt);
    localMessageForPic.longMsgCount = 1;
    localMessageForPic.longMsgIndex = 0;
    localMessageForPic.longMsgId = ((short)(int)localMessageForPic.shmsgseq);
    return localMessageForPic;
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
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
      }
    }
    if (paramAbsStructMsg.sourceAccoutType != 0) {
      paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
    }
    return paramString1;
  }
  
  public static MessageForReplyText a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (paramSourceMsgInfo == null) {
      return null;
    }
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
    paramString1 = paramQQAppInterface.getMessageFacade().o(localMessageForReplyText.senderuin, paramInt);
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      localMessageForReplyText.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
    } else {
      localMessageForReplyText.shmsgseq = Math.abs(new Random().nextInt());
    }
    localMessageForReplyText.time = MessageCache.c();
    localMessageForReplyText.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramSourceMsgInfo);
    localMessageForReplyText.sb = paramString2;
    try
    {
      localMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo)));
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageRecordFactory", 2, QLog.getStackTraceString(paramString1));
      }
    }
    if (localMessageForReplyText.isSend()) {
      ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForReplyText);
    }
    return localMessageForReplyText;
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
  
  public static MessageForText a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, byte paramByte1, byte paramByte2, short paramShort, String paramString4)
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
    }
    catch (UnsupportedEncodingException paramString4)
    {
      paramString4.printStackTrace();
    }
    a(paramAppInterface, paramString1, paramString2, paramString3, paramInt);
    paramString1.parse();
    return paramString1;
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
    if (((paramInt1 == -1000) || (paramInt1 == -2006)) && (paramInt3 == 1) && ((paramInt2 & 0x1) == 1)) {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString);
          if ((paramString.has("redbag_fold_msg")) && (paramString.getString("redbag_fold_msg").equals("true")))
          {
            paramString = new MessageForFoldMsg();
            return paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("msgFold", 2, paramString.getMessage(), paramString);
        }
      }
    }
    return paramMessageRecord;
  }
  
  private static MessageRecord a(int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord;
    if (paramMessageRecord == null)
    {
      localObject = paramMessageRecord;
      if (MessageUtils.b(paramInt))
      {
        if (paramInt == -1002) {
          return new MessageForSafeGrayTips();
        }
        if ((paramInt != -5000) && (paramInt != -5001) && (paramInt != -2037))
        {
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
        localObject = new MessageForNewGrayTips();
      }
    }
    return localObject;
  }
  
  private static MessageRecord a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    if (paramInt == -2058) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("Emoji_Sticker_Info"))
        {
          paramInt = new JSONObject(paramString.getString("Emoji_Sticker_Info")).optInt("msgType", 0);
          if (paramInt != 0)
          {
            paramString = b(paramInt);
            return paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageRecordFactory", 2, "", paramString);
        }
      }
    }
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
    else
    {
      localMessageRecord1 = localMessageRecord2;
      if (paramArrayOfByte != null) {
        localMessageRecord1 = a(paramArrayOfByte, localMessageRecord2);
      }
    }
    a(paramString, localMessageRecord1);
    paramString = a(paramInt1, paramString, a(paramInt1, paramInt2, paramString, paramInt3, localMessageRecord1));
    paramArrayOfByte = paramString;
    if (paramString == null)
    {
      paramArrayOfByte = new MessageForText();
      paramArrayOfByte.msgtype = paramInt1;
    }
    return paramArrayOfByte;
  }
  
  public static MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.msgtype);
    localMessageRecord.msgtype = paramMessageRecord.msgtype;
    a(localMessageRecord, paramMessageRecord);
    if (paramMessageRecord.msgData != null) {
      localMessageRecord.msgData = paramMessageRecord.msgData;
    }
    if (paramMessageRecord.msg != null) {
      localMessageRecord.msg = paramMessageRecord.msg;
    }
    if ((localMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)localMessageRecord).parse();
    }
    return localMessageRecord;
  }
  
  private static MessageRecord a(byte[] paramArrayOfByte, MessageRecord paramMessageRecord)
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
            int i = Integer.parseInt(localObject[2]);
            if (i == 3)
            {
              localObject = new MessageForGrayTips();
              paramArrayOfByte = (byte[])localObject;
              try
              {
                ((MessageRecord)localObject).msgtype = -1001;
                return localObject;
              }
              catch (Exception localException1)
              {
                paramMessageRecord = paramArrayOfByte;
              }
            }
            else
            {
              if (i != 2)
              {
                paramArrayOfByte = paramMessageRecord;
                if (i != 8) {
                  return paramArrayOfByte;
                }
              }
              MessageForPtt localMessageForPtt = new MessageForPtt();
              paramArrayOfByte = localMessageForPtt;
              localMessageForPtt.msgtype = -2002;
              return localMessageForPtt;
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      paramArrayOfByte = paramMessageRecord;
    }
    return paramArrayOfByte;
  }
  
  public static void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    String str1 = paramString2;
    int i = MessageUtils.a();
    int j = (int)MessageCache.c();
    int k = MobileQQService.seq;
    MobileQQService.seq = k + 1;
    long l = k;
    String str2 = paramAppInterface.getCurrentAccountUin();
    Object localObject;
    if ((paramInt != 1000) && (paramInt != 1020) && (paramInt != 1004))
    {
      if (paramInt == 1006)
      {
        paramString2 = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
        if (paramString2 != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2.nationCode);
          ((StringBuilder)localObject).append(paramString2.mobileNo);
          localObject = ((StringBuilder)localObject).toString();
          if ((localObject != null) && (((String)localObject).length() > 0)) {
            break label257;
          }
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("createPicMessageToShow : error selfPhoneNum:");
            paramString2.append((String)localObject);
            QLog.e("MessageRecordFactory", 2, paramString2.toString());
          }
        }
      }
      paramString2 = str2;
      break label260;
    }
    else if (str1 != null)
    {
      localObject = str1;
      if (paramString2.length() != 0) {}
    }
    else
    {
      localObject = str1;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("createPicMessageToShow : error groupUin:");
        paramString2.append(str1);
        QLog.e("MessageRecordFactory", 2, paramString2.toString());
        localObject = str1;
      }
    }
    label257:
    paramString2 = (String)localObject;
    label260:
    if (paramInt == 10014) {
      ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(paramMessageRecord, ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildIdOf(paramString1));
    }
    if ((!(paramMessageRecord instanceof MessageForPoke)) && (paramInt == 0))
    {
      PokeItemAnimationManager.c().a(paramAppInterface, paramString1, -1, 0, -1);
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "send unPokeMsg strength:-1");
      }
    }
    paramMessageRecord.frienduin = paramString1;
    paramMessageRecord.istroop = paramInt;
    paramMessageRecord.selfuin = str2;
    paramMessageRecord.senderuin = paramString2;
    paramMessageRecord.isread = true;
    paramMessageRecord.time = j;
    paramMessageRecord.msgseq = l;
    paramMessageRecord.msgUid = MessageUtils.a(i);
    paramMessageRecord.shmsgseq = MessageUtils.a(l, paramInt);
    paramMessageRecord.issend = 1;
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
    if (AnonymousChatHelper.c(paramMessageRecord2)) {
      paramMessageRecord1.vipBubbleID = paramMessageRecord2.vipBubbleID;
    }
    paramMessageRecord1.time = ((int)MessageCache.c());
  }
  
  /* Error */
  private static void a(String paramString, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +127 -> 128
    //   4: aload_1
    //   5: getfield 364	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   8: sipush -2056
    //   11: if_icmpne +117 -> 128
    //   14: new 372	org/json/JSONObject
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 375	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: getstatic 585	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   27: invokevirtual 381	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   30: ifeq +98 -> 128
    //   33: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +38 -> 74
    //   39: new 495	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 496	java/lang/StringBuilder:<init>	()V
    //   46: astore_2
    //   47: aload_2
    //   48: ldc_w 587
    //   51: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: getstatic 585	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   59: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc_w 589
    //   66: iconst_2
    //   67: aload_2
    //   68: invokevirtual 511	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 515	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: checkcast 582	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   78: aload_0
    //   79: getstatic 585	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   82: invokevirtual 385	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 594	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   88: invokevirtual 597	java/lang/Long:longValue	()J
    //   91: putfield 600	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   94: aload_1
    //   95: getstatic 585	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   98: aload_0
    //   99: getstatic 585	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   102: invokevirtual 385	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokevirtual 601	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: return
    //   109: astore_0
    //   110: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +15 -> 128
    //   116: ldc_w 589
    //   119: iconst_2
    //   120: aload_0
    //   121: invokevirtual 174	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: aload_0
    //   125: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: return
    //   129: astore_2
    //   130: goto -36 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   0	133	1	paramMessageRecord	MessageRecord
    //   46	22	2	localStringBuilder	StringBuilder
    //   129	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   14	74	109	java/lang/Exception
    //   94	108	109	java/lang/Exception
    //   74	94	129	java/lang/Exception
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
  
  public static MessageForTribeShortVideo b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForTribeShortVideo)a(-7002);
    paramString1.msgtype = -7002;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = false;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
      }
    }
    if (paramAbsStructMsg.sourceAccoutType != 0) {
      paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
    }
    return paramString1;
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
    MessageForDevShortVideo localMessageForDevShortVideo = new MessageForDevShortVideo();
    localMessageForDevShortVideo.msgtype = -4503;
    a(paramQQAppInterface, localMessageForDevShortVideo, paramString1, paramString2, paramInt);
    localMessageForDevShortVideo.longMsgCount = 1;
    localMessageForDevShortVideo.longMsgIndex = 0;
    localMessageForDevShortVideo.longMsgId = ((short)(int)localMessageForDevShortVideo.shmsgseq);
    return localMessageForDevShortVideo;
  }
  
  public static MessageForStructing c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForStructing)a(-2011);
    paramString1.msgtype = -2011;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = true;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
      }
    }
    if (paramAbsStructMsg.sourceAccoutType != 0) {
      paramString1.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
    }
    return paramString1;
  }
  
  private static MessageRecord c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return d(paramInt);
    case -2002: 
    case -1031: 
      return new MessageForPtt();
    case -2007: 
      return new MessageForMarketFace();
    case -2008: 
    case -1003: 
    case -1000: 
      return new MessageForText();
    case -2011: 
      return new MessageForStructing();
    case -2014: 
    case -2005: 
      return new MessageForFile();
    case -2021: 
      return new MessageForTroopNotification();
    case -2056: 
      return new MessageForWantGiftMsg();
    case -5004: 
    case -3006: 
      return new MessageForPubAccount();
    case -8018: 
      return new MessageForAniSticker();
    }
    return new MessageForPic();
  }
  
  public static MessageForDevLittleVideo d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = new MessageForDevLittleVideo();
    localMessageForDevLittleVideo.msgtype = -4509;
    a(paramQQAppInterface, localMessageForDevLittleVideo, paramString1, paramString2, paramInt);
    localMessageForDevLittleVideo.longMsgCount = 1;
    localMessageForDevLittleVideo.longMsgIndex = 0;
    localMessageForDevLittleVideo.longMsgId = ((short)(int)localMessageForDevLittleVideo.shmsgseq);
    return localMessageForDevLittleVideo;
  }
  
  private static MessageRecord d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return e(paramInt);
    case -1034: 
      return new MessageForRichState();
    case -1035: 
      return new MessageForMixedMsg();
    case -1042: 
      return new MessageForDateFeed();
    case -2015: 
      return new MessageForQzoneFeed();
    case -2017: 
      return new MessageForTroopFile();
    case -2020: 
      MessageForShakeWindow localMessageForShakeWindow = new MessageForShakeWindow();
      localMessageForShakeWindow.msgtype = -2020;
      return localMessageForShakeWindow;
    case -2022: 
      return new MessageForShortVideo();
    case -2046: 
    case -2026: 
    case -2016: 
    case -2009: 
      return new MessageForVideo();
    case -2050: 
    case -2018: 
      return new MessageForSystemMsg();
    case -2076: 
      return new MessageForLocationShare();
    case -4002: 
      return new MessageForActivity();
    case -4003: 
      return new MessageForEnterTroop();
    case -4004: 
      return new MessageForMyEnterTroop();
    case -4009: 
      return new MessageForTroopUnreadTips();
    case -4012: 
      return new MessageForSplitLineTips();
    }
    return new MessageForAutoReply();
  }
  
  public static MessageForPtt e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.msgtype = -2002;
    a(paramQQAppInterface, localMessageForPtt, paramString1, paramString2, paramInt);
    localMessageForPtt.longMsgCount = 1;
    localMessageForPtt.longMsgIndex = 0;
    localMessageForPtt.longMsgId = ((short)(int)localMessageForPtt.shmsgseq);
    return localMessageForPtt;
  }
  
  private static MessageRecord e(int paramInt)
  {
    if (paramInt != -7090)
    {
      if (paramInt != -5003)
      {
        if (paramInt != -3012)
        {
          if ((paramInt != -2049) && (paramInt != -2043) && (paramInt != -2041))
          {
            if (paramInt != -2038) {
              if (paramInt != -2033) {
                if (paramInt != -2029) {
                  if (paramInt != -2025) {
                    if (paramInt != -2036) {
                      if (paramInt == -2035) {}
                    }
                  }
                }
              }
            }
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return f(paramInt);
              case -4500: 
                return new MessageForDeviceFile();
              case -4501: 
                return new MessageForDevPtt();
              case -4502: 
                return new MessageForDeviceSingleStruct();
              }
              return new MessageForDevShortVideo();
            case -4508: 
              return new MessageForDeviceText();
            case -4509: 
              return new MessageForDevLittleVideo();
              return new MessageForDeliverGiftTips();
              return new MessageForTroopFee();
              return new MessageForQQWalletMsg();
              return new MessageForQQWalletTips();
              return ((IHotChatApi)QRoute.api(IHotChatApi.class)).getShareHotChatGrayTips();
              return new MessageForTroopGift();
            }
          }
          return new MessageForGrayTips();
        }
        return new MessageForColorRing();
      }
      return new MessageForActivateFriends();
    }
    return new MessageForReminder();
  }
  
  public static MessageForPtt f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForDevPtt localMessageForDevPtt = new MessageForDevPtt();
    localMessageForDevPtt.msgtype = -4501;
    a(paramQQAppInterface, localMessageForDevPtt, paramString1, paramString2, paramInt);
    localMessageForDevPtt.longMsgCount = 1;
    localMessageForDevPtt.longMsgIndex = 0;
    localMessageForDevPtt.longMsgId = ((short)(int)localMessageForDevPtt.shmsgseq);
    return localMessageForDevPtt;
  }
  
  private static MessageRecord f(int paramInt)
  {
    if (paramInt != -5018)
    {
      if ((paramInt != -5017) && (paramInt != -5008))
      {
        if (paramInt != -2045)
        {
          if (paramInt != -1051)
          {
            if (paramInt != -1049)
            {
              if (paramInt != -2048)
              {
                if (paramInt != -2047)
                {
                  if (paramInt != -2040)
                  {
                    if (paramInt != -2039)
                    {
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          return g(paramInt);
                        }
                      case -5011: 
                        return new MessageForFoldMsgGrayTips();
                      case -5012: 
                        return new MessageForPoke();
                      case -5013: 
                        return new MessageForArkFlashChat();
                      }
                      return new MessageForHiBoom();
                    }
                    return ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).createApolloMsgRecord();
                  }
                  return new MessageForApproval();
                }
                return new MessageForVIPDonate();
              }
              return new MessageForTroopReward();
            }
            return new MessageForReplyText();
          }
          return new MessageForLongTextMsg();
        }
        return new MessageForVideoVip();
      }
      return new MessageForArkApp();
    }
    return new MessageForPokeEmo();
  }
  
  public static MessageForMixedMsg g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForMixedMsg localMessageForMixedMsg = new MessageForMixedMsg();
    localMessageForMixedMsg.msgtype = -1035;
    a(paramQQAppInterface, localMessageForMixedMsg, paramString1, paramString2, paramInt);
    localMessageForMixedMsg.longMsgCount = 1;
    localMessageForMixedMsg.longMsgIndex = 0;
    localMessageForMixedMsg.longMsgId = ((short)(int)localMessageForMixedMsg.shmsgseq);
    return localMessageForMixedMsg;
  }
  
  private static MessageRecord g(int paramInt)
  {
    if (paramInt != -7001)
    {
      if (paramInt != -5040)
      {
        if (paramInt != -5015) {
          if (paramInt != -2062) {
            if (paramInt != -2057) {
              if (paramInt != -2023) {
                if (paramInt != -2060) {
                  if (paramInt == -2059) {}
                }
              }
            }
          }
        }
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return h(paramInt);
            case -2051: 
              return new MessageForQQStory();
            case -2052: 
              return new MessageForQQStoryComment();
            case -2053: 
              return new MessageForNearbyLiveTip();
            case -2054: 
              return new MessageForTroopSign();
            }
            return new MessageForInteractAndFollow();
          case -2065: 
            return new MessageForConfessNews();
          case -2066: 
            return new MessageForConfessCard();
          }
          return new MessageForTroopConfess();
          return new MessageForTroopPobing();
          return new MessageForPLNews();
          return new MessageForCommonHobbyForAIOShow();
          return new MessageForTroopStory();
          return new MessageForMedalNews();
          return new MessageForTroopEffectPic();
        }
      }
      return new MessageForUniteGrayTip();
    }
    return new MessageForScribble();
  }
  
  private static MessageRecord h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return i(paramInt);
    case -2061: 
      return new MessageForQQStoryFeed();
    case -2068: 
      return new MessageForDarenAssistant();
    case -2069: 
      return new MessageForStarLeague();
    case -2070: 
      return new MessageForYanZhi();
    case -2072: 
      return new MessageForFuDai();
    case -2074: 
      return new MessageForAIOStoryVideo();
    case -2077: 
      return new MessageForQCircleFeed();
    case -3017: 
      return new MessageForDLFile();
    case -4024: 
    case -4023: 
      return new MessageForLimitChatTopic();
    case -4028: 
      return ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getNewMessageRecordForGuildWelcome();
    case -5016: 
      return new MessageForArkBabyqReply();
    case -7002: 
      return new MessageForTribeShortVideo();
    case -7005: 
      return new MessageForLimitChatConfirm();
    case -7007: 
      return new MessageForBirthdayNotice();
    }
    return new MessageForAniSticker();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageRecordFactory
 * JD-Core Version:    0.7.0.1
 */