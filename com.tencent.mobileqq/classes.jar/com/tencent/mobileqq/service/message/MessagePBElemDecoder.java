package com.tencent.mobileqq.service.message;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.TextElemDecoder;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.ecshop.view.api.IEcshopRainViewApi;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.hiboom_type.Hiboom_Type;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.service.message.codec.decoder.TempSessionDecoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.IAnimationMessage;
import com.tencent.mobileqq.troop.utils.TroopFileDataManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.nicknamemessage.NickNameManager;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.RichMsg.PicRec;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ActivityGiftInfo;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.InteractGift;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ResvAttr;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype15;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype5;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype8;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TipsInfo;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;

public class MessagePBElemDecoder
  extends QMessagePBElemDecoder
{
  protected MessageHandler a;
  protected QQAppInterface a;
  
  public MessagePBElemDecoder()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
  }
  
  private int a(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!paramList.hasNext()) {
        break;
      }
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      i = j;
      if (localElem.text.has())
      {
        i = j;
        if (localElem.text.bytes_pb_reserve.has()) {
          try
          {
            TextMsgExtPb.ResvAttr localResvAttr = new TextMsgExtPb.ResvAttr();
            localResvAttr.mergeFrom(localElem.text.bytes_pb_reserve.get().toByteArray());
            i = j;
            if (localResvAttr.text_analysis_result.has()) {
              i = localResvAttr.text_analysis_result.get();
            }
          }
          catch (Exception localException)
          {
            QLog.e("DecodeMsg", 1, "parse TextMsgExtPb.ResvAttr error, ", localException);
            i = j;
          }
        }
      }
    }
    return j;
  }
  
  private int a(im_msg_body.CommonElem paramCommonElem)
  {
    if (paramCommonElem.uint32_business_type.has()) {
      return paramCommonElem.uint32_business_type.get();
    }
    return 0;
  }
  
  private long a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong, MessageForStructing paramMessageForStructing)
  {
    if (QLog.isColorLevel()) {
      QLog.d(NearbyFlowerManager.class.getSimpleName(), 2, "Received flower message");
    }
    Object localObject = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).getFlowerMsgVersion(paramMessageForStructing);
    long l2;
    if ((!"1".equals(localObject)) && (!"2".equals(localObject)))
    {
      l2 = paramLong;
      if (!"3".equals(localObject)) {}
    }
    else
    {
      localObject = (msg_comm.GroupInfo)paramMsg.msg_head.group_info.get();
      long l3 = 0L;
      long l1;
      if (localObject != null) {
        l1 = ((msg_comm.GroupInfo)localObject).group_code.get();
      } else {
        l1 = 0L;
      }
      if (QLog.isColorLevel())
      {
        localObject = NearbyFlowerManager.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodePBMsgElems, groupCode:");
        localStringBuilder.append(l1);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      l2 = paramLong;
      if (l1 <= 0L)
      {
        if (paramMsg.msg_head.from_uin.has()) {
          paramLong = paramMsg.msg_head.from_uin.get();
        } else {
          paramLong = 0L;
        }
        l1 = l3;
        if (paramMsg.msg_head.to_uin.has()) {
          l1 = paramMsg.msg_head.to_uin.get();
        }
        paramList.add(((NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_FLOWER_MANAGER)).a(Long.toString(paramLong), Long.toString(l1), paramMessageForStructing.istroop, paramMessageForStructing.structingMsg));
        l2 = paramLong;
      }
    }
    return l2;
  }
  
  private MessageForDeliverGiftTips a(String paramString1, String paramString2, im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:GiftMsg;\n");
    }
    paramStringBuilder = a(paramDeliverGiftMsg);
    paramStringBuilder.senderName = paramString1;
    paramStringBuilder.grayTipContent = paramDeliverGiftMsg.bytes_gray_tip_content.get().toStringUtf8();
    paramStringBuilder.animationPackageId = paramDeliverGiftMsg.uint32_animation_package_id.get();
    paramStringBuilder.animationPackageUrl = paramDeliverGiftMsg.bytes_animation_package_url_a.get().toStringUtf8();
    paramStringBuilder.remindBrief = paramDeliverGiftMsg.bytes_remind_brief.get().toStringUtf8();
    paramStringBuilder.giftId = paramDeliverGiftMsg.uint32_gift_id.get();
    paramStringBuilder.giftCount = paramDeliverGiftMsg.uint32_gift_count.get();
    paramStringBuilder.animationBrief = paramDeliverGiftMsg.bytes_animation_brief.get().toStringUtf8();
    paramStringBuilder.senderUin = paramDeliverGiftMsg.uint64_sender_uin.get();
    paramStringBuilder.receiverUin = paramDeliverGiftMsg.uint64_receiver_uin.get();
    d(paramDeliverGiftMsg, paramStringBuilder);
    c(paramDeliverGiftMsg, paramStringBuilder);
    e(paramDeliverGiftMsg, paramStringBuilder);
    paramStringBuilder.rcvName = paramString2;
    b(paramDeliverGiftMsg, paramStringBuilder);
    a(paramDeliverGiftMsg, paramList, paramMsg, paramStringBuilder);
    a(paramDeliverGiftMsg, paramStringBuilder);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("MessageProtoCodec.decodePBMsgElems  decode send gift gray tips");
      paramString1.append(paramStringBuilder.msg);
      QLog.i(".troop.send_gift", 2, paramString1.toString());
    }
    a(paramStringBuilder);
    return paramStringBuilder;
  }
  
  @NonNull
  private MessageForDeliverGiftTips a(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg)
  {
    int i = paramDeliverGiftMsg.uint32_animation_package_id.get();
    int j = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
    if ((i == 0) && ((j < 1000) || (j > 2000)))
    {
      paramDeliverGiftMsg = (MessageForDeliverGiftTips)MessageRecordFactory.a(-2035);
      paramDeliverGiftMsg.msgtype = -2035;
      return paramDeliverGiftMsg;
    }
    paramDeliverGiftMsg = (MessageForTroopGift)MessageRecordFactory.a(-2038);
    paramDeliverGiftMsg.msgtype = -2038;
    return paramDeliverGiftMsg;
  }
  
  @NonNull
  private MessageForPic a(msg_comm.Msg paramMsg, boolean paramBoolean, CustomFaceExtPb.ResvAttr paramResvAttr)
  {
    if (paramBoolean)
    {
      MessageForPic localMessageForPic = (MessageForPic)MessageRecordFactory.a(-5015);
      localMessageForPic.msgtype = -5015;
      ((MessageForTroopEffectPic)localMessageForPic).effectId = ((CustomFaceExtPb.AnimationImageShow)paramResvAttr.msg_image_show.get()).int32_effect_id.get();
      localMessageForPic.frienduin = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.group_code.get());
      localMessageForPic.istroop = 1;
      paramResvAttr = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      paramMsg = localMessageForPic;
      if (paramResvAttr != null)
      {
        paramResvAttr.a((AIOAnimationControlManager.IAnimationMessage)localMessageForPic, false);
        return localMessageForPic;
      }
    }
    else
    {
      paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
      paramMsg.msgtype = -2000;
    }
    return paramMsg;
  }
  
  @NonNull
  private MessageForPubAccount a(String paramString, PAMessage paramPAMessage)
  {
    MessageForPubAccount localMessageForPubAccount = (MessageForPubAccount)MessageRecordFactory.a(-3006);
    localMessageForPubAccount.msgtype = -3006;
    localMessageForPubAccount.msg = paramString;
    localMessageForPubAccount.mPAMessage = paramPAMessage;
    try
    {
      localMessageForPubAccount.msgData = ((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(paramPAMessage);
      return localMessageForPubAccount;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localMessageForPubAccount;
  }
  
  @Nullable
  private MessageForReplyText a(AtTroopMemberInfo paramAtTroopMemberInfo, List<MessageRecord> paramList, ResultBox paramResultBox, MessageInfo paramMessageInfo, MessageForReplyText paramMessageForReplyText)
  {
    Object localObject1 = paramMessageForReplyText;
    if (TextUtils.isEmpty(paramMessageForReplyText.mSourceMsgInfo.mAnonymousNickName))
    {
      if (paramAtTroopMemberInfo == null) {
        return paramMessageForReplyText;
      }
      int i = paramList.size();
      localObject1 = "";
      if (i <= 0)
      {
        localObject1 = paramMessageForReplyText;
        if (QLog.isColorLevel())
        {
          QLog.w("zivonchen", 2, "");
          return paramMessageForReplyText;
        }
      }
      else
      {
        Object localObject2 = (MessageRecord)paramList.get(0);
        if (!(localObject2 instanceof MessageForText))
        {
          localObject1 = paramMessageForReplyText;
          if (QLog.isColorLevel())
          {
            QLog.w("zivonchen", 2, "replytext 内容为空，有回复消息，但第一个消息体不是文本消息");
            return paramMessageForReplyText;
          }
        }
        else
        {
          MessageForReplyText localMessageForReplyText = (MessageForReplyText)MessageRecordFactory.a(-1049);
          MessageRecord.copyMessageRecordBaseField(localMessageForReplyText, (MessageRecord)localObject2);
          MessageRecord.copyMessageRecordStatusField(localMessageForReplyText, (MessageRecord)localObject2);
          localMessageForReplyText.atInfoList = paramMessageForReplyText.atInfoList;
          localMessageForReplyText.msg = ((MessageRecord)localObject2).msg;
          localMessageForReplyText.mSourceMsgInfo = paramMessageForReplyText.mSourceMsgInfo;
          localMessageForReplyText.msgtype = -1049;
          if ((!TextUtils.isEmpty(localMessageForReplyText.msg)) && (localMessageForReplyText.msg.length() >= paramAtTroopMemberInfo.textLen + paramAtTroopMemberInfo.startPos))
          {
            localObject2 = localMessageForReplyText.msg;
            localMessageForReplyText.msg = "";
            if (paramAtTroopMemberInfo.startPos > 0) {
              localMessageForReplyText.msg = ((String)localObject2).substring(0, paramAtTroopMemberInfo.startPos);
            }
            i = paramAtTroopMemberInfo.startPos + paramAtTroopMemberInfo.textLen;
            int j = i + 1;
            paramMessageForReplyText = (MessageForReplyText)localObject1;
            if (j < ((String)localObject2).length()) {
              paramMessageForReplyText = ((String)localObject2).substring(i, j);
            }
            if (paramMessageForReplyText.equals(" "))
            {
              paramMessageForReplyText = new StringBuilder();
              paramMessageForReplyText.append(localMessageForReplyText.msg);
              paramMessageForReplyText.append(((String)localObject2).substring(j));
              localMessageForReplyText.msg = paramMessageForReplyText.toString();
            }
            else
            {
              paramMessageForReplyText = new StringBuilder();
              paramMessageForReplyText.append(localMessageForReplyText.msg);
              paramMessageForReplyText.append(((String)localObject2).substring(i));
              localMessageForReplyText.msg = paramMessageForReplyText.toString();
            }
            if ((paramAtTroopMemberInfo.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) && (paramResultBox.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo == null)) {
              paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b(24, -1L);
            }
          }
          paramList.remove(0);
          paramList.add(0, localMessageForReplyText);
          localObject1 = null;
        }
      }
    }
    return localObject1;
  }
  
  public static MessageForVIPDonate a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DecodeMsg", 1, "content is empty ");
      return null;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createVIPDonateMsg: msg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("DecodeMsg", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        MessageForVIPDonate localMessageForVIPDonate = (MessageForVIPDonate)MessageRecordFactory.a(-2047);
        localMessageForVIPDonate.msgtype = -2047;
        VIPDonateMsg localVIPDonateMsg = new VIPDonateMsg();
        if (localJSONObject.has("title"))
        {
          localObject = localJSONObject.getString("title");
          localVIPDonateMsg.title = ((String)localObject);
          if (!localJSONObject.has("footer")) {
            break label442;
          }
          localObject = localJSONObject.getString("footer");
          localVIPDonateMsg.footer = ((String)localObject);
          if (paramBoolean)
          {
            if (!localJSONObject.has("sendsubtitle")) {
              break label447;
            }
            localObject = localJSONObject.getString("sendsubtitle");
            localVIPDonateMsg.subTitle = ((String)localObject);
            if (!localJSONObject.has("sendurl")) {
              break label452;
            }
            localObject = localJSONObject.getString("sendurl");
            localVIPDonateMsg.jumpUrl = ((String)localObject);
            if (!localJSONObject.has("sendbrief")) {
              break label457;
            }
            localObject = localJSONObject.getString("sendbrief");
            localVIPDonateMsg.brief = ((String)localObject);
          }
          else
          {
            if (!localJSONObject.has("recvsubtitle")) {
              break label462;
            }
            localObject = localJSONObject.getString("recvsubtitle");
            localVIPDonateMsg.subTitle = ((String)localObject);
            if (!localJSONObject.has("recvurl")) {
              break label467;
            }
            localObject = localJSONObject.getString("recvurl");
            localVIPDonateMsg.jumpUrl = ((String)localObject);
            if (!localJSONObject.has("recvbrief")) {
              break label472;
            }
            localObject = localJSONObject.getString("recvbrief");
            localVIPDonateMsg.brief = ((String)localObject);
          }
          localMessageForVIPDonate.donateMsg = localVIPDonateMsg;
          localMessageForVIPDonate.msg = localMessageForVIPDonate.getSummaryMsg();
          localMessageForVIPDonate.msgData = MessagePkgUtils.a(localVIPDonateMsg);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("donateMsg = ");
            ((StringBuilder)localObject).append(localMessageForVIPDonate.donateMsg);
            QLog.d("vipdonateMsgparse", 2, ((StringBuilder)localObject).toString());
          }
          return localMessageForVIPDonate;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("vipdonate json error :json = ");
        localStringBuilder.append(paramString);
        QLog.e("DecodeMsg", 1, localStringBuilder.toString());
        return null;
      }
      StringBuilder localStringBuilder = null;
      continue;
      label442:
      localStringBuilder = null;
      continue;
      label447:
      localStringBuilder = null;
      continue;
      label452:
      localStringBuilder = null;
      continue;
      label457:
      localStringBuilder = null;
      continue;
      label462:
      localStringBuilder = null;
      continue;
      label467:
      localStringBuilder = null;
      continue;
      label472:
      localStringBuilder = null;
    }
  }
  
  private static PAMessage a(String paramString)
  {
    return (PAMessage)((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).fromXML(paramString);
  }
  
  @Nullable
  private PAMessage a(List<im_msg_body.Elem> paramList, String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.has())) {
        paramString.mMsgId = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.get();
      }
    }
    return paramString;
  }
  
  private Boolean a(List<im_msg_body.Elem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
        if ((localElem.market_trans.has()) || (localElem.rich_msg.has())) {
          return Boolean.valueOf(true);
        }
      }
    }
    return Boolean.valueOf(false);
  }
  
  @NotNull
  private String a(MessageForStructing paramMessageForStructing)
  {
    boolean bool = TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgUrl);
    Object localObject = "";
    if (!bool)
    {
      paramMessageForStructing = Uri.parse(paramMessageForStructing.structingMsg.mMsgUrl);
      try
      {
        paramMessageForStructing = paramMessageForStructing.getQueryParameter("article_id");
      }
      catch (Exception paramMessageForStructing)
      {
        paramMessageForStructing.printStackTrace();
        paramMessageForStructing = "";
      }
      if (paramMessageForStructing == null) {
        return "";
      }
      localObject = paramMessageForStructing;
    }
    return localObject;
  }
  
  @NonNull
  private String a(ByteStringMicro paramByteStringMicro)
  {
    if (paramByteStringMicro != null) {
      return paramByteStringMicro.toStringUtf8();
    }
    return "";
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 2;
        if (k < paramString.length())
        {
          int j = i + 1;
          k = (paramString.charAt(j) - 'A') * 128 + paramString.charAt(k) - 65;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("faceIndex:");
            localStringBuilder2.append(k);
            QLog.d("DecodeMsg", 2, localStringBuilder2.toString());
          }
          k = QQSysFaceUtil.convertToLocal(k);
          if (k >= 0)
          {
            localStringBuilder1.append(paramString.charAt(i));
            localStringBuilder1.append((char)k);
          }
          i = j + 1;
          break label155;
        }
      }
      localStringBuilder1.append(paramString.charAt(i));
      label155:
      i += 1;
    }
    return localStringBuilder1.toString();
  }
  
  @NonNull
  private CustomFaceExtPb.ResvAttr a(im_msg_body.CustomFace paramCustomFace)
  {
    CustomFaceExtPb.ResvAttr localResvAttr = new CustomFaceExtPb.ResvAttr();
    try
    {
      localResvAttr.mergeFrom(paramCustomFace.bytes_pb_reserve.get().toByteArray());
      return localResvAttr;
    }
    catch (InvalidProtocolBufferMicroException paramCustomFace)
    {
      paramCustomFace.printStackTrace();
    }
    return localResvAttr;
  }
  
  @Nullable
  private im_msg_body.CommonElem a(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.common_elem.has()) {
        paramList = (im_msg_body.CommonElem)localElem.common_elem.get();
      }
    }
    return paramList;
  }
  
  @Nullable
  private im_msg_body.CustomFace a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, boolean paramBoolean)
  {
    if (paramCustomFace != null) {
      return paramCustomFace;
    }
    if (paramElem != null)
    {
      if (paramBoolean) {
        return (im_msg_body.CustomFace)paramElem.hc_flash_pic.get();
      }
      return (im_msg_body.CustomFace)paramElem.custom_face.get();
    }
    return null;
  }
  
  @Nullable
  private im_msg_body.GroupPubAccountInfo a(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    label9:
    im_msg_body.Elem localElem;
    for (paramList = null; localIterator.hasNext(); paramList = (im_msg_body.GroupPubAccountInfo)localElem.group_pub_acc_info.get())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if ((!localElem.group_pub_acc_info.has()) || (!localElem.group_pub_acc_info.uint64_pub_account.has())) {
        break label9;
      }
    }
    return paramList;
  }
  
  @Nullable
  private im_msg_body.TransElem a(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.trans_elem_info.has()) {
        paramList = (im_msg_body.TransElem)localElem.trans_elem_info.get();
      }
    }
    return paramList;
  }
  
  private void a(int paramInt, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof RecommendCommonMessage)) {
      paramChatMessage.saveExtInfoToExtStr("ark_text_analysis_flag", String.valueOf(paramInt));
    }
  }
  
  private void a(long paramLong, MessageForStructing paramMessageForStructing)
  {
    if (((2171946401L == paramLong) || (2173223560L == paramLong) || (2062433139L == paramLong) || (3434959637L == paramLong)) && ((paramMessageForStructing.structingMsg instanceof AbsShareMsg)))
    {
      if (2171946401L == paramLong) {
        ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).newKanDianOidbReport(paramMessageForStructing, 11);
      }
      ((AbsShareMsg)paramMessageForStructing.structingMsg).clearItems();
      paramMessageForStructing.extInt = 1;
      paramMessageForStructing.extLong = 1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode structMsg form XIN_KANDIAN, items = ");
        localStringBuilder.append(((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists().size());
        QLog.d("DecodeMsg", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      ((ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).preProcessMessageMoreDetail(paramChatMessage);
    }
  }
  
  private void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((paramMessageForDeliverGiftTips.summary != null) && (paramMessageForDeliverGiftTips.rcvName != null))
    {
      if (paramMessageForDeliverGiftTips.rcvName.length() <= 0) {
        return;
      }
      Pattern localPattern = Pattern.compile(HardCodeUtil.a(2131706682));
      Object localObject2 = paramMessageForDeliverGiftTips.msg;
      Object localObject1 = localObject2;
      if (!paramMessageForDeliverGiftTips.isToAll())
      {
        localObject1 = localObject2;
        if (paramMessageForDeliverGiftTips.msg.startsWith("["))
        {
          i = paramMessageForDeliverGiftTips.msg.indexOf("]");
          localObject1 = localObject2;
          if (i != -1)
          {
            localObject1 = localObject2;
            if (i < paramMessageForDeliverGiftTips.msg.length()) {
              localObject1 = paramMessageForDeliverGiftTips.msg.substring(i + 1);
            }
          }
        }
      }
      localObject2 = localPattern.matcher((CharSequence)localObject1);
      if (!((Matcher)localObject2).find()) {
        return;
      }
      localObject2 = ((Matcher)localObject2).group();
      int i = ((String)localObject1).indexOf((String)localObject2);
      int j = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i > 0)
      {
        if (j != i) {
          return;
        }
        paramMessageForDeliverGiftTips.senderName = ((String)localObject1).substring(0, i);
      }
    }
  }
  
  private void a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageForReplyText paramMessageForReplyText)
  {
    try
    {
      paramMessageForReplyText.extLong |= 0x1;
      paramMessageForReplyText.mSourceMsgInfo = paramSourceMsgInfo;
      if (paramSourceMsgInfo.getSourceMsg() != null)
      {
        paramMessageForReplyText.setSourceMessageRecord(paramSourceMsgInfo.unPackSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if ((paramMessageForReplyText.getSourceMessage() != null) && (FileManagerUtil.a(paramMessageForReplyText.getSourceMessage())))
        {
          Object localObject = paramMessageForReplyText.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
          ChatMessage localChatMessage = FileManagerUtil.a((ChatMessage)paramMessageForReplyText.getSourceMessage());
          QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, paramMessageForReplyText.getSourceMessage());
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localChatMessage != null))
          {
            int i = Integer.parseInt((String)localObject);
            if ((i == 1) || (i == 2))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("decode mix inner reply file msg, msg uniseq[");
              ((StringBuilder)localObject).append(localChatMessage.uniseq);
              ((StringBuilder)localObject).append("]");
              QLog.i("DecodeMsg<QFile>", 1, ((StringBuilder)localObject).toString());
              FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)paramMessageForReplyText.getSourceMessage());
            }
          }
        }
      }
      paramMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(paramSourceMsgInfo)));
      return;
    }
    catch (Exception paramSourceMsgInfo)
    {
      if (QLog.isColorLevel())
      {
        paramMessageForReplyText = new StringBuilder();
        paramMessageForReplyText.append("Save sourceMsgInfo exception:");
        paramMessageForReplyText.append(paramSourceMsgInfo.getMessage());
        QLog.d("SendMsgBtn", 2, paramMessageForReplyText.toString());
      }
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      paramMessageForStructing = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      String str = paramMessageForStructing.animResId;
      RobotResourcesManager.a().a(str, null);
      RobotResourcesManager.a().a(paramMessageForStructing.atMembers);
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramChatMessage.saveExtInfoToExtStr("small_description", paramString);
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    String str = BaseApplication.getContext().getString(2131694606);
    MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
    localMessageForText.msgtype = -1000;
    localMessageForText.msg = str;
    paramList.add(localMessageForText);
  }
  
  private void a(List<im_msg_body.Elem> paramList, MessageForStructing paramMessageForStructing)
  {
    paramList = paramList.iterator();
    while ((paramList.hasNext()) && (!a(paramMessageForStructing, (im_msg_body.Elem)paramList.next()))) {}
  }
  
  private void a(List<im_msg_body.Elem> paramList, PAMessage paramPAMessage)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.has())) {
        paramPAMessage.mMsgId = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.get();
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, String paramString, int paramInt, hiboom_type.Hiboom_Type paramHiboom_Type)
  {
    if (!paramHiboom_Type.uint32_hiboom_type.has())
    {
      QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no type");
      return;
    }
    int i = paramHiboom_Type.uint32_hiboom_type.get();
    if (!HiBoomConstants.a(i))
    {
      paramList = new StringBuilder();
      paramList.append("decodePBMsgElems_Hiboom type not support: type = ");
      paramList.append(i);
      QLog.i("HiBoomFont", 1, paramList.toString());
      return;
    }
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt;
    localHiBoomMessage.text = paramString;
    localHiBoomMessage.type = i;
    paramHiboom_Type = (MessageForHiBoom)MessageRecordFactory.a(-5014);
    paramHiboom_Type.mHiBoomMessage = localHiBoomMessage;
    paramHiboom_Type.msgtype = -5014;
    paramHiboom_Type.msg = paramString;
    try
    {
      paramHiboom_Type.msgData = MessagePkgUtils.a(localHiBoomMessage);
    }
    catch (Exception localException)
    {
      QLog.e("HiBoomFont.MessagePBElemDecoder", 1, "getBytesFromObject error, ", localException);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive hiboom message id = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("message = ");
      localStringBuilder.append(paramString.charAt(0));
      QLog.d("HiBoomFont.MessagePBElemDecoder", 2, localStringBuilder.toString());
    }
    paramList.add(paramHiboom_Type);
  }
  
  private void a(List<MessageRecord> paramList, String paramString, hummer_commelem.MsgElemInfo_servtype14 paramMsgElemInfo_servtype14)
  {
    if (!paramMsgElemInfo_servtype14.uint32_id.has()) {
      return;
    }
    int i = paramMsgElemInfo_servtype14.uint32_id.get();
    if (!paramMsgElemInfo_servtype14.reserve_Info.has())
    {
      QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no reserve_info");
      return;
    }
    paramMsgElemInfo_servtype14 = paramMsgElemInfo_servtype14.reserve_Info.get().toByteArray();
    hiboom_type.Hiboom_Type localHiboom_Type = new hiboom_type.Hiboom_Type();
    localHiboom_Type.mergeFrom(paramMsgElemInfo_servtype14);
    a(paramList, paramString, i, localHiboom_Type);
  }
  
  private void a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, AtTroopMemberInfo paramAtTroopMemberInfo, List<MessageRecord> paramList1, ResultBox paramResultBox, MessageInfo paramMessageInfo)
  {
    paramList = a(paramList, paramStringBuilder);
    if (paramList == null) {
      return;
    }
    paramStringBuilder = (MessageForReplyText)MessageRecordFactory.a(-1049);
    a(paramList, paramStringBuilder);
    paramList = a(paramAtTroopMemberInfo, paramList1, paramResultBox, paramMessageInfo, paramStringBuilder);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "sb.length == 0");
    }
    if (paramList != null) {
      paramList1.add(0, paramList);
    }
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, String paramString, int paramInt, hummer_commelem.MsgElemInfo_servtype14 paramMsgElemInfo_servtype14)
  {
    if (paramInt == 0)
    {
      a(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo, paramString, paramMsgElemInfo_servtype14);
      return;
    }
    if (paramInt == 1)
    {
      a(paramList1, paramString, paramMsgElemInfo_servtype14);
      return;
    }
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, String paramString, hummer_commelem.MsgElemInfo_servtype14 paramMsgElemInfo_servtype14)
  {
    if (!((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a())
    {
      i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
      return;
    }
    if (!ArkUtil.isDeviceSupportArkMsg())
    {
      QLog.i("FlashChat", 1, "decodePBMsgElems_FlashChat is false, ignore msg.");
      return;
    }
    int j;
    String str;
    if (paramMsgElemInfo_servtype14.uint32_id.has())
    {
      if (!paramMsgElemInfo_servtype14.reserve_Info.has()) {
        return;
      }
      j = paramMsgElemInfo_servtype14.uint32_id.get();
      str = paramMsgElemInfo_servtype14.reserve_Info.get().toStringUtf8();
      if (!paramMsgElemInfo_servtype14.reserve_Info.has())
      {
        QLog.i("flashchat", 1, "ecodePBMsgElems_FlashChat, reserve_Info not exist.");
        return;
      }
      localObject = paramMsgElemInfo_servtype14.reserve_Info.get().toByteArray();
      if (localObject.length <= 0)
      {
        QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat, reserve_Info empty.");
        return;
      }
      paramMsgElemInfo_servtype14 = null;
      localObject = StructMsgUtils.a((byte[])localObject, -1);
      if ((localObject == null) || (localObject.length <= 0)) {}
    }
    try
    {
      localObject = new String((byte[])localObject, "UTF-8");
      paramMsgElemInfo_servtype14 = (hummer_commelem.MsgElemInfo_servtype14)localObject;
    }
    catch (Exception localException)
    {
      label189:
      int i;
      break label189;
    }
    QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat convert failed");
    break label212;
    QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat empty.");
    label212:
    Object localObject = new ArkFlashChatMessage();
    ((ArkFlashChatMessage)localObject).fromAppXml(paramMsgElemInfo_servtype14);
    ((ArkFlashChatMessage)localObject).appResId = j;
    ((ArkFlashChatMessage)localObject).promptText = paramString;
    paramString = (MessageForArkFlashChat)MessageRecordFactory.a(-5013);
    paramString.msgtype = -5013;
    paramString.msgData = ((ArkFlashChatMessage)localObject).toBytes();
    paramString.parse();
    i = 0;
    if ((!TextUtils.isEmpty(paramString.ark_app_message.appName)) && (!TextUtils.isEmpty(paramString.ark_app_message.appView)))
    {
      paramList1.add(paramString);
      i = 1;
    }
    else
    {
      QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat not valid..");
    }
    paramString = new StringBuilder();
    paramString.append("decodePBMsgElems_FlashChat id = ");
    paramString.append(j);
    paramString.append(", reserveInfo = ");
    paramString.append(str);
    paramString.append(", arkData = ");
    paramString.append(paramMsgElemInfo_servtype14);
    QLog.d("flashchat", 2, paramString.toString());
    if (i == 0) {
      i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, msg_comm.Msg paramMsg, im_msg_body.GeneralFlags paramGeneralFlags, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] != 1) {
      return;
    }
    int j = PkgTools.getShortData(paramArrayOfByte, 1);
    int i = paramArrayOfByte[3];
    j -= 1;
    Object localObject = new byte[j];
    PkgTools.copyData((byte[])localObject, 0, paramArrayOfByte, 4, j);
    paramArrayOfByte = (byte[])localObject;
    if (i == 1) {
      paramArrayOfByte = a((byte[])localObject);
    }
    localObject = null;
    if (paramArrayOfByte != null)
    {
      try
      {
        if (paramArrayOfByte.length <= 0) {
          break label142;
        }
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        try
        {
          paramList = a(paramList, paramArrayOfByte);
          localObject = paramList;
          paramList = paramArrayOfByte;
          paramArrayOfByte = (byte[])localObject;
        }
        catch (Exception localException)
        {
          paramList = paramArrayOfByte;
          paramArrayOfByte = localException;
        }
        paramArrayOfByte.printStackTrace();
      }
      catch (Exception paramArrayOfByte)
      {
        paramList = "";
      }
      paramArrayOfByte = (byte[])localObject;
      break label150;
    }
    label142:
    paramList = "";
    paramArrayOfByte = (byte[])localObject;
    label150:
    if (paramMsg.msg_head.from_uin.has())
    {
      long l = paramMsg.msg_head.from_uin.get();
      paramMsg = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("");
      if (paramMsg.isWeatherPA(((StringBuilder)localObject).toString())) {
        return;
      }
    }
    if (paramArrayOfByte == null) {
      return;
    }
    paramList = a(paramList, paramArrayOfByte);
    a(paramGeneralFlags, paramList);
    paramList1.add(paramList);
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, msg_comm.Msg paramMsg, im_msg_body.TransElem paramTransElem, im_msg_body.GeneralFlags paramGeneralFlags, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt != 3)
    {
      if (paramInt != 16)
      {
        if (paramInt != 24) {
          return;
        }
        a(paramList1, paramMsg, paramTransElem, paramArrayOfByte);
        return;
      }
      a(paramList, paramList1, paramMsg, paramGeneralFlags, paramArrayOfByte);
      return;
    }
    a(paramList1);
  }
  
  private void a(List<MessageRecord> paramList1, msg_comm.Msg paramMsg, List<MessageRecord> paramList2, byte[] paramArrayOfByte, MessageInfo paramMessageInfo, AtTroopMemberInfo paramAtTroopMemberInfo)
  {
    int i = paramList1.size();
    int n = 0;
    Object localObject1;
    int j;
    Object localObject2;
    if (i > 1)
    {
      localObject1 = paramList1.iterator();
      int m = 0;
      j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        int k;
        if (((((MessageRecord)localObject2).msgtype == -1000) || (((MessageRecord)localObject2).msgtype == -1049)) && (j == 0))
        {
          i = m + 1;
          k = 1;
        }
        else
        {
          i = m;
          k = j;
          if (((MessageRecord)localObject2).msgtype == -2000)
          {
            i = m + 1;
            k = j;
          }
        }
        m = i;
        j = k;
        if (i >= 2)
        {
          i = 1;
          break label144;
        }
      }
    }
    i = 0;
    label144:
    if (paramMsg.msg_head.from_uin.has())
    {
      long l = paramMsg.msg_head.from_uin.get();
      j = n;
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), Long.toString(l))) {
        j = 1;
      }
    }
    else
    {
      j = n;
    }
    if (i != 0)
    {
      localObject1 = new ArrayList();
      localObject2 = paramList1.iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        paramMsg = null;
        paramList1 = null;
        if (!bool) {
          break;
        }
        paramMsg = (MessageRecord)((Iterator)localObject2).next();
        if ((paramMsg.msgtype != -1000) && (paramMsg.msgtype != -1049) && (paramMsg.msgtype != -2000))
        {
          if (((List)localObject1).size() > 0)
          {
            if (j == 0) {
              paramList1 = paramArrayOfByte;
            }
            paramList2.add(MessageProtoCodec.a((List)localObject1, paramList1, paramMessageInfo));
            ((List)localObject1).clear();
          }
          paramList2.add(paramMsg);
        }
        else
        {
          ((List)localObject1).add(paramMsg);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        if (j != 0) {
          paramArrayOfByte = paramMsg;
        }
        paramList1 = MessageProtoCodec.a((List)localObject1, paramArrayOfByte, paramMessageInfo);
        paramList2.add(paramList1);
        ((MessageForMixedMsg)paramList1).mAtInfo = paramAtTroopMemberInfo;
        ((List)localObject1).clear();
      }
    }
    else
    {
      if (paramArrayOfByte == null)
      {
        paramList2.addAll(paramList1);
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramMsg = (MessageRecord)paramList1.next();
        if (((paramMsg instanceof MessageForText)) && (j == 0)) {
          paramMsg.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(paramArrayOfByte));
        }
        paramList2.add(paramMsg);
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.TransElem paramTransElem, byte[] paramArrayOfByte)
  {
    int k = paramTransElem.elem_value.get().size();
    int i = 0;
    int j = 0;
    while (k > 3)
    {
      if (j > 100) {
        return;
      }
      int n = paramArrayOfByte[i];
      int i1 = PkgTools.getShortData(paramArrayOfByte, i + 1);
      int m = i1 + 3;
      k -= m;
      Object localObject;
      if (n == 1)
      {
        paramTransElem = new byte[i1];
        PkgTools.copyData(paramTransElem, 0, paramArrayOfByte, i + 3, i1);
        localObject = new obj_msg.ObjMsg();
      }
      try
      {
        paramTransElem = (obj_msg.ObjMsg)((obj_msg.ObjMsg)localObject).mergeFrom(paramTransElem);
        if (paramTransElem.uint32_msg_type.get() == 6L)
        {
          localObject = new TroopFileData();
          ((TroopFileData)localObject).fileUrl = new String(((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
          ((TroopFileData)localObject).bisID = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
          ((TroopFileData)localObject).fileName = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.str_file_name.get();
          ((TroopFileData)localObject).lfileSize = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.uint64_file_size.get();
          ((TroopFileData)localObject).lastTime = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.int64_dead_time.get();
          ((TroopFileData)localObject).sha1 = new String(((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
          ((TroopFileData)localObject).md5 = new String(((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_file_md5.get().toByteArray());
          ((TroopFileData)localObject).uuid = UUID.nameUUIDFromBytes(((TroopFileData)localObject).fileUrl.getBytes()).toString();
          if (((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
            paramArrayOfByte = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
          }
        }
      }
      catch (Exception paramTransElem)
      {
        label500:
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder1;
        break label895;
      }
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        ((TroopFileData)localObject).width = paramArrayOfByte.optInt("width");
        ((TroopFileData)localObject).height = paramArrayOfByte.optInt("height");
        ((TroopFileData)localObject).duration = paramArrayOfByte.optInt("duration");
        ((TroopFileData)localObject).yybApkPackageName = paramArrayOfByte.optString("yyb_apk_package_name_key");
        ((TroopFileData)localObject).yybApkName = paramArrayOfByte.optString("yyb_apk_name_key");
        ((TroopFileData)localObject).yybApkIconUrl = paramArrayOfByte.optString("yyb_apk_icon_url_key");
      }
      catch (Exception paramArrayOfByte)
      {
        break label500;
      }
      ((TroopFileData)localObject).dspFileName = new String(paramTransElem.bytes_title.get().toByteArray());
      ((TroopFileData)localObject).dspFileName = FileManagerUtil.a(((TroopFileData)localObject).dspFileName);
      ((TroopFileData)localObject).dspFileSize = new String(((ByteStringMicro)paramTransElem.rpt_bytes_abstact.get(0)).toByteArray());
      TroopFileDataManager.a(paramMsg.msg_head.group_info.group_code.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopFileData)localObject).fileUrl, (TroopFileData)localObject);
      localStringBuilder2 = new StringBuilder("decodePBMshElems==>");
      localStringBuilder2.append(((TroopFileData)localObject).toString());
      paramArrayOfByte = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsg.msg_head.group_info.group_code.get()).a(((TroopFileData)localObject).fileUrl);
      paramTransElem = null;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramArrayOfByte.e);
        paramTransElem = paramArrayOfByte;
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.lastTime = ((TroopFileData)localObject).lastTime;
          paramTransElem = paramArrayOfByte;
        }
      }
      paramArrayOfByte = (MessageForTroopFile)MessageRecordFactory.a(-2017);
      paramArrayOfByte.msgtype = -2017;
      paramArrayOfByte.msg = HardCodeUtil.a(2131706685);
      try
      {
        paramArrayOfByte.msgData = MessagePkgUtils.a((Serializable)localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      paramArrayOfByte.parse();
      paramList.add(paramArrayOfByte);
      if (paramTransElem != null)
      {
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramMsg.msg_head.group_info.group_code.get());
        localStringBuilder1.append("");
        paramList.a(localStringBuilder1.toString(), 1, paramTransElem.structMsgSeq, paramArrayOfByte.msgData);
        localStringBuilder2.append("|updateMsgContentByUniseq, msgSeq:");
        localStringBuilder2.append(paramTransElem.structMsgSeq);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramList = new StringBuilder();
      paramList.append("<TroopFile> ");
      paramList.append(localStringBuilder2.toString());
      QLog.d("DecodeMsg", 2, paramList.toString());
      return;
      label895:
      j += 1;
      i = m + i;
    }
  }
  
  private void a(List<MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2, StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder.length() > 0) && (!paramBoolean1) && (!paramBoolean2))
    {
      MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
      localMessageForText.msgtype = -1000;
      localMessageForText.msg = paramStringBuilder.toString();
      paramList.add(localMessageForText);
      paramStringBuilder.delete(0, paramStringBuilder.length());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (!paramMsg.msg_head.group_info.has()) {
      return;
    }
    long l = paramMsg.msg_head.group_info.group_code.get();
    paramMsg = localTroopManager.b(String.valueOf(l));
    if (paramMsg == null) {
      return;
    }
    paramMsg.associatePubAccount = paramLong;
    localTroopManager.b(paramMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER).notifyUI(TroopOnlinePushObserver.TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL, true, new Object[] { Long.valueOf(l) });
  }
  
  private void a(msg_comm.Msg paramMsg, byte[] paramArrayOfByte, MessageForStructing paramMessageForStructing, String paramString, boolean paramBoolean, TempSessionInfo paramTempSessionInfo)
  {
    if ((paramTempSessionInfo.jdField_a_of_type_Int == 1008) && (QLog.isColorLevel()))
    {
      paramTempSessionInfo = new StringBuilder();
      paramTempSessionInfo.append("msgId=uniseq:");
      paramTempSessionInfo.append(paramMessageForStructing.uniseq);
      paramTempSessionInfo.append(", serviceType(Pa-129,140,142):");
      paramTempSessionInfo.append(((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.get());
      paramTempSessionInfo.append(", xmlContentLength:");
      int i;
      if (paramArrayOfByte == null) {
        i = 0;
      } else {
        i = paramArrayOfByte.length;
      }
      paramTempSessionInfo.append(i);
      paramTempSessionInfo.append(", longMsgResId:");
      paramTempSessionInfo.append(paramString);
      paramTempSessionInfo.append(", isPaNewLongMsg:");
      paramTempSessionInfo.append(paramBoolean);
      QLog.d("PaOldLongMsg", 2, paramTempSessionInfo.toString());
    }
  }
  
  private void a(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!(paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
      return;
    }
    paramMessageForDeliverGiftTips = (MessageForTroopGift)paramMessageForDeliverGiftTips;
    paramMessageForDeliverGiftTips.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
    paramMessageForDeliverGiftTips.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
    paramMessageForDeliverGiftTips.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
    paramMessageForDeliverGiftTips.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
    paramMessageForDeliverGiftTips.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
    paramMessageForDeliverGiftTips.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
    paramMessageForDeliverGiftTips.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
    if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
      paramMessageForDeliverGiftTips.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
    }
    paramMessageForDeliverGiftTips.prewrite();
  }
  
  private void a(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, List<MessageRecord> paramList, msg_comm.Msg paramMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    TroopTipsMsgMgr localTroopTipsMsgMgr = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (localTroopTipsMsgMgr == null) {
      return;
    }
    paramMessageForDeliverGiftTips.grayTipsEntity = new TroopTipsEntity();
    paramMessageForDeliverGiftTips.grayTipsEntity.isSupportImage = true;
    paramMessageForDeliverGiftTips.grayTipsEntity.troopUin = String.valueOf(paramMsg.msg_head.group_info.group_code.get());
    paramMessageForDeliverGiftTips.grayTipsEntity.optContent = paramMessageForDeliverGiftTips.grayTipContent;
    localTroopTipsMsgMgr.a(paramMessageForDeliverGiftTips.grayTipsEntity);
    paramMessageForDeliverGiftTips.msg = paramMessageForDeliverGiftTips.grayTipsEntity.optContent;
    boolean bool = paramMessageForDeliverGiftTips instanceof MessageForTroopGift;
    if (bool)
    {
      paramMsg = (MessageForTroopGift)paramMessageForDeliverGiftTips;
      paramMsg.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
      paramMsg.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
      paramMsg.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
      paramMsg.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
      paramMsg.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
      paramMsg.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
      paramMsg.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
      if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
        paramMsg.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
      }
    }
    if (TextUtils.isEmpty(paramMessageForDeliverGiftTips.summary)) {
      paramMessageForDeliverGiftTips.summary = paramMessageForDeliverGiftTips.msg;
    }
    if (paramMessageForDeliverGiftTips.grayTipsEntity.highlightNum != 0) {
      TroopTipsMsgMgr.a(paramMessageForDeliverGiftTips, paramMessageForDeliverGiftTips.grayTipsEntity.highlightItems);
    }
    if (bool) {
      ((MessageForTroopGift)paramMessageForDeliverGiftTips).prewrite();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      paramDeliverGiftMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramMsg = new StringBuilder();
      paramMsg.append(paramMessageForDeliverGiftTips.receiverUin);
      paramMsg.append("");
      if (paramDeliverGiftMsg.equals(paramMsg.toString()))
      {
        if (paramMessageForDeliverGiftTips.remindBrief == null) {
          break label435;
        }
        paramMessageForDeliverGiftTips.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramMessageForDeliverGiftTips.remindBrief.split("#")[0]);
        break label435;
      }
    }
    if ((paramMessageForDeliverGiftTips.remindBrief != null) && (paramMessageForDeliverGiftTips.remindBrief.split("#").length > 1)) {
      paramMessageForDeliverGiftTips.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramMessageForDeliverGiftTips.remindBrief.split("#")[1]);
    }
    label435:
    paramList.add(paramMessageForDeliverGiftTips);
  }
  
  private void a(im_msg_body.Elem paramElem, im_msg_body.NotOnlineImage paramNotOnlineImage, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    BaseApplication.getContext().getString(2131694606);
    boolean bool;
    if (paramNotOnlineImage != null)
    {
      paramElem = paramNotOnlineImage;
      bool = true;
    }
    else if (paramElem != null)
    {
      paramElem = (im_msg_body.NotOnlineImage)paramElem.not_online_image.get();
      bool = false;
    }
    else
    {
      bool = false;
      paramElem = null;
    }
    if (QLog.isColorLevel())
    {
      paramNotOnlineImage = new StringBuilder();
      paramNotOnlineImage.append("parsePBMsgElems_OfflineMsg hasComFlashPic=");
      paramNotOnlineImage.append(bool);
      QLog.d("flash", 2, paramNotOnlineImage.toString());
    }
    if (QLog.isColorLevel())
    {
      paramNotOnlineImage = new StringBuilder();
      paramNotOnlineImage.append("elemType:NotOnlineImage;\n hasComFlashPic=");
      paramNotOnlineImage.append(bool);
      paramStringBuilder.append(paramNotOnlineImage.toString());
    }
    if (paramElem == null)
    {
      QLog.d("flash", 2, "offlineImg null");
      return;
    }
    int j;
    int i;
    if (paramElem != null)
    {
      j = paramElem.file_len.get();
      i = paramElem.img_type.get();
    }
    else
    {
      j = 0;
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramNotOnlineImage = new StringBuilder();
      paramNotOnlineImage.append("[NotOnlineImage] file_len=");
      paramNotOnlineImage.append(j);
      QLog.d("DecodeMsg", 2, paramNotOnlineImage.toString());
      paramNotOnlineImage = new StringBuilder();
      paramNotOnlineImage.append("[NotOnlineImage] imgType=");
      paramNotOnlineImage.append(i);
      QLog.d("DecodeMsg", 2, paramNotOnlineImage.toString());
    }
    paramElem.flag.get().toByteArray();
    String str1 = paramElem.str_thumb_url.get();
    String str2 = paramElem.str_400_url.get();
    int i2 = paramElem.uint32_thumb_width.get();
    int i3 = paramElem.uint32_thumb_height.get();
    if (QLog.isColorLevel())
    {
      paramNotOnlineImage = new StringBuilder();
      paramNotOnlineImage.append("[NotOnlineImage] ThumbWidth=");
      paramNotOnlineImage.append(i2);
      paramNotOnlineImage.append(",ThumbHeight=");
      paramNotOnlineImage.append(i3);
      QLog.d("DecodeMsg", 2, paramNotOnlineImage.toString());
    }
    int k;
    if (paramElem.uint32_file_id.has()) {
      k = paramElem.uint32_file_id.get();
    } else {
      k = 0;
    }
    String str3 = paramElem.str_big_url.get();
    String str4 = paramElem.str_orig_url.get();
    int i4 = paramElem.pic_width.get();
    int i5 = paramElem.pic_height.get();
    int n = paramElem.uint32_show_len.get();
    int m = paramElem.uint32_download_len.get();
    if (QLog.isDevelopLevel())
    {
      paramNotOnlineImage = new StringBuilder();
      paramNotOnlineImage.append("MessageProtoCodec.decodePBMsgElems(): showLen ");
      paramNotOnlineImage.append(n);
      paramNotOnlineImage.append(", downloadLen ");
      paramNotOnlineImage.append(m);
      paramNotOnlineImage.append(", fileLen ");
      paramNotOnlineImage.append(j);
      QLog.d("peak_pgjpeg", 4, paramNotOnlineImage.toString());
    }
    int i1 = paramElem.original.get();
    if (paramElem.res_id.has()) {
      paramNotOnlineImage = paramElem.res_id.get().toStringUtf8();
    }
    for (;;)
    {
      break;
      if (paramElem.download_path.has()) {
        paramNotOnlineImage = paramElem.download_path.get().toStringUtf8();
      } else {
        paramNotOnlineImage = null;
      }
    }
    if ((paramNotOnlineImage != null) && (!paramNotOnlineImage.equals("")))
    {
      if (paramElem.pic_md5.has())
      {
        paramMsg = paramElem.pic_md5.get().toByteArray();
        if ((paramMsg != null) && (paramMsg.length > 0))
        {
          paramMsg = HexUtil.bytes2HexStr(paramMsg);
          break label619;
        }
      }
      paramMsg = "";
      label619:
      l1 = j;
      String str5 = TransfileUtile.makeTransFileProtocolData(paramNotOnlineImage, l1, 1, false, paramNotOnlineImage, paramMsg, "picplatform", str1, str2, str3, str4, i1, 0);
      RichMsg.PicRec localPicRec = new RichMsg.PicRec();
      localPicRec.localPath.set(paramNotOnlineImage);
      localPicRec.size.set(l1);
      localPicRec.type.set(1);
      localPicRec.isRead.set(false);
      localPicRec.uuid.set(paramNotOnlineImage);
      localPicRec.md5.set(paramMsg);
      localPicRec.serverStorageSource.set("picplatform");
      localPicRec.thumbMsgUrl.set(str1);
      localPicRec.bigthumbMsgUrl.set(str2);
      localPicRec.uint32_thumb_width.set(i2);
      localPicRec.uint32_thumb_height.set(i3);
      localPicRec.uint32_width.set(i4);
      localPicRec.uint32_height.set(i5);
      if (paramElem.uint32_file_id.has()) {
        localPicRec.groupFileID.set(k);
      }
      localPicRec.bigMsgUrl.set(str3);
      localPicRec.rawMsgUrl.set(str4);
      localPicRec.fileSizeFlag.set(i1);
      localPicRec.uiOperatorFlag.set(0);
      localPicRec.version.set(5);
      localPicRec.isReport.set(0);
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("content:");
        paramStringBuilder.append(str5);
        paramStringBuilder.append("\n");
      }
      if (i1 == 1)
      {
        if (QLog.isColorLevel())
        {
          paramNotOnlineImage = new StringBuilder();
          paramNotOnlineImage.append("[NotOnlineImage] showLen =");
          paramNotOnlineImage.append(n);
          paramNotOnlineImage.append(",downloadLen = ");
          paramNotOnlineImage.append(m);
          paramNotOnlineImage.append(",raw photo msg,clear progressjpg info!");
          QLog.d("DecodeMsg", 2, paramNotOnlineImage.toString());
        }
        m = 0;
        j = 0;
      }
      else
      {
        j = n;
      }
      localPicRec.uint32_show_len.set(j);
      localPicRec.uint32_download_len.set(m);
      localPicRec.uint32_image_type.set(i);
      if (paramElem.bytes_pb_reserve.has()) {
        localPicRec.bytes_pb_reserved.set(paramElem.bytes_pb_reserve.get());
      }
      paramElem = (MessageForPic)MessageRecordFactory.a(-2000);
      if (bool) {
        ((IPicFlash)QRoute.api(IPicFlash.class)).setFlashPicFlag(paramElem, false);
      }
      paramElem.msgtype = -2000;
      paramElem.msgData = localPicRec.toByteArray();
      paramElem.parse();
      paramList.add(paramElem);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramElem = new StringBuilder();
      paramElem.append("serverPath is null or empty string : ");
      paramElem.append(paramNotOnlineImage);
      paramStringBuilder.append(paramElem.toString());
    }
    paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramElem.msg_seq.get();
    long l2 = paramElem.msg_uid.get();
    long l3 = paramElem.msg_time.get();
    long l4 = paramElem.from_uin.get();
    long l5 = paramElem.to_uin.get();
    paramElem = new HashMap();
    paramElem.put("param_FailCode", String.valueOf(10002));
    paramElem.put("fromUin", String.valueOf(l4));
    paramElem.put("toUin", String.valueOf(l5));
    paramElem.put("msgSeq", String.valueOf(l1));
    paramElem.put("msgUid", String.valueOf(l2));
    paramElem.put("msgtime", String.valueOf(l3));
    paramNotOnlineImage = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramNotOnlineImage, "actMessageEvent", false, 0L, 0L, paramElem, "");
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, ChatMessage paramChatMessage)
  {
    Object localObject2 = null;
    int j = 0;
    Object localObject1 = localObject2;
    int i = j;
    if (paramGeneralFlags != null)
    {
      localObject1 = localObject2;
      i = j;
      if (paramGeneralFlags.bytes_pb_reserve.has()) {
        try
        {
          generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
          localResvAttr.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
          localObject1 = localObject2;
          i = j;
          if (localResvAttr.bytes_kpl_info.has())
          {
            localObject1 = localResvAttr.bytes_kpl_info.get().toStringUtf8();
            i = 1;
          }
        }
        catch (Exception paramGeneralFlags)
        {
          if (QLog.isColorLevel()) {
            QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
          }
          paramGeneralFlags.printStackTrace();
          i = j;
          localObject1 = localObject2;
        }
      }
    }
    if (i != 0)
    {
      paramChatMessage.saveExtInfoToExtStr("msg_ext_key", "Y");
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "resv a kpl text message !");
      }
      KplHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, MessageForPubAccount paramMessageForPubAccount)
  {
    if (paramGeneralFlags != null)
    {
      if (!paramGeneralFlags.bytes_pb_reserve.has()) {
        return;
      }
      try
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        localResvAttr.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if (localResvAttr.bytes_oac_msg_extend.has())
        {
          paramMessageForPubAccount.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", localResvAttr.bytes_oac_msg_extend.get().toStringUtf8());
          return;
        }
      }
      catch (Throwable paramGeneralFlags)
      {
        paramMessageForPubAccount = new StringBuilder();
        paramMessageForPubAccount.append("decodePBMsgElems_TransElemInfo()-MessageForPubAccount: parse generalflags error! ");
        paramMessageForPubAccount.append(QLog.getStackTraceString(paramGeneralFlags));
        QLog.e("DecodeMsg", 2, paramMessageForPubAccount.toString());
      }
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, MessageForStructing paramMessageForStructing)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {
      try
      {
        byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
        String str = Utils.a(arrayOfByte);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodePBMsgElems_RichMsg, guideMsgCookie: ");
          localStringBuilder.append(str);
          localStringBuilder.append(" ,byte: ");
          localStringBuilder.append(Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          QLog.d("DecodeMsg", 2, localStringBuilder.toString());
        }
        paramMessageForStructing.saveExtInfoToExtStr("guide_msg_cookie", str);
        ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(arrayOfByte);
        return;
      }
      catch (Exception paramGeneralFlags)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "get richmsg guideMsgCookie error!", paramGeneralFlags);
        }
      }
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, MessageForStructing paramMessageForStructing, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramMessageForStructing.structingMsg.sourceAccoutType != 0))
    {
      paramMessageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
      if ((TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgBrief)) || (paramMessageForStructing.structingMsg.mEmptyMsgBriefModified)) {
        paramMessageForStructing.structingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
      }
      ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handlePubTailMsg(paramGeneralFlags, paramMessageForStructing);
      ((IEcshopRainViewApi)QRoute.api(IEcshopRainViewApi.class)).handlePreload(paramMessageForStructing);
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, List<MessageRecord> paramList)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {
      try
      {
        if (paramList.size() > 0)
        {
          paramList = (MessageRecord)paramList.get(0);
          byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
          String str = Utils.a(arrayOfByte);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodePBMsgElems_Pic, guideMsgCookie: ");
            localStringBuilder.append(str);
            localStringBuilder.append(" ,byte: ");
            localStringBuilder.append(Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
            QLog.d("DecodeMsg", 2, localStringBuilder.toString());
          }
          paramList.saveExtInfoToExtStr("guide_msg_cookie", str);
          ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(arrayOfByte);
          return;
        }
      }
      catch (Exception paramGeneralFlags)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "get pic msg guideMsgCookie error!", paramGeneralFlags);
        }
      }
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, boolean paramBoolean, String paramString, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject = a(paramList, paramList1, false);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)MessageRecordFactory.a(-5008);
    localMessageForArkApp.msgtype = -5008;
    if (localObject != null) {
      localMessageForArkApp.compatibleMsg = ((String)localObject);
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {
      try
      {
        localObject = new generalflags.ResvAttr();
        ((generalflags.ResvAttr)localObject).mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if (((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.has()) {
          localMessageForArkApp.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", ((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.get().toStringUtf8());
        }
        if (((generalflags.ResvAttr)localObject).uint32_service_msg_type.has())
        {
          paramGeneralFlags = new JSONObject(paramString).optString("appid");
          if (!TextUtils.isEmpty(paramGeneralFlags)) {
            localMessageForArkApp.saveExtInfoToExtStr("appid", paramGeneralFlags);
          }
        }
      }
      catch (Throwable paramGeneralFlags)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodePBMsgElems_ArkApp() parse generalflags error! ");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(paramGeneralFlags));
        QLog.e("DecodeMsg", 2, ((StringBuilder)localObject).toString());
      }
    }
    paramGeneralFlags = new ArkAppMessage();
    paramGeneralFlags.fromAppXml(paramString);
    localMessageForArkApp.msgData = paramGeneralFlags.toBytes();
    localMessageForArkApp.parse();
    boolean bool2 = TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appName);
    boolean bool1 = true;
    if ((!bool2) && (!TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appView)))
    {
      paramList1.add(localMessageForArkApp);
      paramBoolean = bool1;
    }
    else
    {
      QLog.i("DecodeMsg", 1, "decode msg, ark message is not valid..");
    }
    if (!paramBoolean) {
      i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
    ((IEcshopRainViewApi)QRoute.api(IEcshopRainViewApi.class)).handlePreload(localMessageForArkApp);
  }
  
  private void a(boolean paramBoolean, int paramInt, ChatMessage paramChatMessage)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodePBMsgElems, isBlessMsg: true ,updateFlag: ");
        localStringBuilder.append(paramInt);
        QLog.d("DecodeMsg", 2, localStringBuilder.toString());
      }
      paramBoolean = true;
      paramChatMessage.isBlessMsg = true;
      if (paramInt > -1)
      {
        if ((paramInt & 0x1) != 1) {
          paramBoolean = false;
        }
        paramChatMessage.needUpdateMsgTag = paramBoolean;
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForPic paramMessageForPic)
  {
    if (paramBoolean1) {
      HotChatHelper.a(paramMessageForPic, false);
    }
    if (paramBoolean2) {
      ((IPicFlash)QRoute.api(IPicFlash.class)).setFlashPicFlag(paramMessageForPic, false);
    }
  }
  
  private boolean a(MessageForStructing paramMessageForStructing, im_msg_body.Elem paramElem)
  {
    Object localObject;
    if (paramElem.not_online_image.has())
    {
      localObject = (im_msg_body.NotOnlineImage)paramElem.not_online_image.get();
      paramMessageForStructing = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing.thumbHeight = ((im_msg_body.NotOnlineImage)localObject).uint32_thumb_height.get();
      paramMessageForStructing.thumbWidth = ((im_msg_body.NotOnlineImage)localObject).uint32_thumb_width.get();
      paramMessageForStructing.width = ((im_msg_body.NotOnlineImage)localObject).pic_width.get();
      paramMessageForStructing.height = ((im_msg_body.NotOnlineImage)localObject).pic_height.get();
      paramMessageForStructing.thumbUrl = ((im_msg_body.NotOnlineImage)localObject).str_thumb_url.get();
      paramMessageForStructing.bigUrl = ((im_msg_body.NotOnlineImage)localObject).str_big_url.get();
      paramMessageForStructing.rawUrl = ((im_msg_body.NotOnlineImage)localObject).str_orig_url.get();
      if (paramElem.not_online_image.bytes_pb_reserve.has()) {
        try
        {
          localObject = new NotOnlineImageExtPb.ResvAttr();
          ((NotOnlineImageExtPb.ResvAttr)localObject).mergeFrom(paramElem.not_online_image.bytes_pb_reserve.get().toByteArray());
          paramMessageForStructing.mImageBizType = ((NotOnlineImageExtPb.ResvAttr)localObject).uint32_image_biz_type.get();
          return true;
        }
        catch (InvalidProtocolBufferMicroException paramMessageForStructing)
        {
          paramMessageForStructing.printStackTrace();
        }
      }
      return true;
    }
    if (paramElem.custom_face.has())
    {
      localObject = (im_msg_body.CustomFace)paramElem.custom_face.get();
      paramMessageForStructing = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing.thumbHeight = ((im_msg_body.CustomFace)localObject).uint32_thumb_height.get();
      paramMessageForStructing.thumbWidth = ((im_msg_body.CustomFace)localObject).uint32_thumb_width.get();
      paramMessageForStructing.width = ((im_msg_body.CustomFace)localObject).uint32_width.get();
      paramMessageForStructing.height = ((im_msg_body.CustomFace)localObject).uint32_height.get();
      paramMessageForStructing.rawUrl = ((im_msg_body.CustomFace)localObject).str_orig_url.get();
      paramMessageForStructing.thumbUrl = ((im_msg_body.CustomFace)localObject).str_thumb_url.get();
      paramMessageForStructing.bigUrl = ((im_msg_body.CustomFace)localObject).str_big_url.get();
      paramMessageForStructing.rawUrl = ((im_msg_body.CustomFace)localObject).str_orig_url.get();
      if (paramElem.custom_face.bytes_pb_reserve.has()) {
        try
        {
          localObject = new CustomFaceExtPb.ResvAttr();
          ((CustomFaceExtPb.ResvAttr)localObject).mergeFrom(paramElem.custom_face.bytes_pb_reserve.get().toByteArray());
          paramMessageForStructing.mImageBizType = ((CustomFaceExtPb.ResvAttr)localObject).uint32_image_biz_type.get();
          return true;
        }
        catch (InvalidProtocolBufferMicroException paramMessageForStructing)
        {
          paramMessageForStructing.printStackTrace();
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean a(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    for (boolean bool = false; paramList.hasNext(); bool = true)
    {
      label9:
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((!localElem.bless_msg.has()) || (localElem.bless_msg.uint32_msg_type.get() != 1)) {
        break label9;
      }
    }
    return bool;
  }
  
  private boolean a(List<MessageRecord> paramList, long paramLong, MessageForStructing paramMessageForStructing)
  {
    if (!(paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
      return false;
    }
    Object localObject = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mWarningTips;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject);
    }
    if (((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).isPayMessage()) {
      paramMessageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
    }
    localObject = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mPARedPacket;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = MessageForQQWalletMsg.createQQWalletMsg((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject != null)
      {
        paramList.add(localObject);
        return true;
      }
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 74)
    {
      paramMessageForStructing = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mVipDonateStr;
      if (!TextUtils.isEmpty(paramMessageForStructing))
      {
        paramMessageForStructing = a(paramMessageForStructing, String.valueOf(paramLong).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        if (paramMessageForStructing != null)
        {
          paramList.add(paramMessageForStructing);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList, MessageForStructing paramMessageForStructing)
  {
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)MessageRecordFactory.a(-2054);
    localMessageForTroopSign.msgtype = -2054;
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
    localMessageForTroopSign.structingMsg = localStructMsgForGeneralShare;
    localMessageForTroopSign.msg = localStructMsgForGeneralShare.mMsgBrief;
    localMessageForTroopSign.doPrewrite();
    paramList.add(localMessageForTroopSign);
    paramMessageForStructing.structingMsg = null;
    return true;
  }
  
  private boolean a(List<im_msg_body.Elem> paramList, MessageForStructing paramMessageForStructing, String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, new Object[] { "decodePBMsgElems_RichMsg longMsgResId=", paramString });
      }
      paramList = paramList.iterator();
      String str;
      do
      {
        boolean bool = paramList.hasNext();
        str = "";
        if (!bool) {
          break;
        }
        localObject = (im_msg_body.Elem)paramList.next();
      } while (!((im_msg_body.Elem)localObject).pub_acc_info.has());
      if (((im_msg_body.Elem)localObject).pub_acc_info.string_long_msg_url.get() != null) {
        paramList = ((im_msg_body.Elem)localObject).pub_acc_info.string_long_msg_url.get();
      } else {
        paramList = "";
      }
      ByteStringMicro localByteStringMicro = ((im_msg_body.Elem)localObject).pub_acc_info.bytes_download_key.get();
      Object localObject = paramList;
      if (localByteStringMicro != null)
      {
        str = StructLongMessageDownloadProcessor.bytesToHexString(localByteStringMicro.toByteArray());
        localObject = paramList;
        break label155;
        localObject = "";
      }
      label155:
      if ((!StringUtil.a((String)localObject)) && (!StringUtil.a(str)) && (!StringUtil.a(paramString)))
      {
        paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject);
        paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", str);
        paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", paramString);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList, im_msg_body.GeneralFlags paramGeneralFlags, im_msg_body.Text paramText, MessageForStructing paramMessageForStructing, long paramLong)
  {
    MessageForTroopPobing localMessageForTroopPobing = (MessageForTroopPobing)MessageRecordFactory.a(-2059);
    localMessageForTroopPobing.msgtype = -2059;
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
    if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText)) && (paramText != null) && (paramText.str.has())) {
      localStructMsgForGeneralShare.mCompatibleText = paramText.str.get().toStringUtf8();
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {
      try
      {
        paramText = new generalflags.ResvAttr();
        paramText.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if ((paramText.uint32_troop_pobing_template.has()) && (paramText.uint32_troop_pobing_template.get() > 0)) {
          localStructMsgForGeneralShare.pobingTemplateId = paramText.uint32_troop_pobing_template.get();
        }
      }
      catch (InvalidProtocolBufferMicroException paramGeneralFlags)
      {
        QLog.e("DecodeMsg", 1, "decode uint32_troop_pobing_template fail: ", paramGeneralFlags);
      }
    }
    if (QLog.isColorLevel())
    {
      paramGeneralFlags = new StringBuilder();
      paramGeneralFlags.append("uint32_troop_pobing_template: ");
      paramGeneralFlags.append(localStructMsgForGeneralShare.pobingTemplateId);
      QLog.d("DecodeMsg", 2, paramGeneralFlags.toString());
    }
    localMessageForTroopPobing.structingMsg = localStructMsgForGeneralShare;
    localMessageForTroopPobing.doPrewrite();
    localMessageForTroopPobing.doParse();
    if (TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText))
    {
      localMessageForTroopPobing.doParse();
      localStructMsgForGeneralShare.mCompatibleText = MessageForTroopPobing.buildCompatibleText();
      localMessageForTroopPobing.doPrewrite();
      if (QLog.isColorLevel())
      {
        paramGeneralFlags = new StringBuilder();
        paramGeneralFlags.append("recv storyMsg, mCompatibleText isEmpty, rebuild:");
        paramGeneralFlags.append(localStructMsgForGeneralShare.mCompatibleText);
        QLog.d("Q.qqstory.share", 2, paramGeneralFlags.toString());
      }
    }
    paramList.add(localMessageForTroopPobing);
    paramMessageForStructing.structingMsg = null;
    paramList = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_obj");
    paramGeneralFlags = new StringBuilder();
    paramGeneralFlags.append(paramLong);
    paramGeneralFlags.append("");
    paramList.a(new String[] { paramGeneralFlags.toString() }).a();
    paramList = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_welcome");
    paramGeneralFlags = new StringBuilder();
    paramGeneralFlags.append(paramLong);
    paramGeneralFlags.append("");
    paramGeneralFlags = paramGeneralFlags.toString();
    paramText = new StringBuilder();
    paramText.append("");
    paramText.append(TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong)));
    paramList.a(new String[] { paramGeneralFlags, "", paramText.toString() }).a();
    return true;
  }
  
  private boolean a(List<MessageRecord> paramList, im_msg_body.Text paramText, MessageForStructing paramMessageForStructing)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)MessageRecordFactory.a(-7002);
    localMessageForTribeShortVideo.msgtype = -7002;
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
    if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText)) && (paramText != null) && (paramText.str.has())) {
      localStructMsgForGeneralShare.mCompatibleText = paramText.str.get().toStringUtf8();
    }
    localMessageForTribeShortVideo.structingMsg = localStructMsgForGeneralShare;
    localMessageForTribeShortVideo.doPrewrite();
    if (TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText))
    {
      localMessageForTribeShortVideo.doParse();
      localStructMsgForGeneralShare.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
      localMessageForTribeShortVideo.doPrewrite();
      if (QLog.isColorLevel())
      {
        paramText = new StringBuilder();
        paramText.append("recv shortVideoMsg, mCompatibleText isEmpty, rebuild:");
        paramText.append(localStructMsgForGeneralShare.mCompatibleText);
        QLog.d("DecodeMsg", 2, paramText.toString());
      }
    }
    paramList.add(localMessageForTribeShortVideo);
    paramMessageForStructing.structingMsg = null;
    return true;
  }
  
  private boolean a(List<MessageRecord> paramList, byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    paramArrayOfByte = MessageForStarLeague.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong, paramArrayOfByte, -1);
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.msgData = paramArrayOfByte.getBytes();
      paramArrayOfByte.msg = paramArrayOfByte.getSummaryMsg();
      paramList.add(paramArrayOfByte);
    }
    return true;
  }
  
  private boolean a(List<MessageRecord> paramList, byte[] paramArrayOfByte, MessageForStructing paramMessageForStructing, long paramLong, int paramInt)
  {
    MessageForTroopFee localMessageForTroopFee = (MessageForTroopFee)MessageRecordFactory.a(-2036);
    paramArrayOfByte = MessageForTroopFee.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong, paramArrayOfByte, -1);
    if (paramArrayOfByte != null) {
      localMessageForTroopFee.copyFrom(paramArrayOfByte);
    }
    localMessageForTroopFee.msgtype = -2036;
    localMessageForTroopFee.msg = localMessageForTroopFee.getSummaryMsg();
    localMessageForTroopFee.msgData = localMessageForTroopFee.getBytes();
    paramList.add(localMessageForTroopFee);
    paramMessageForStructing.structingMsg = null;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("Troop Fee has decode suceess");
      paramList.append(localMessageForTroopFee.getSummaryMsg());
      QLog.d(".troop.troop_fee", 2, paramList.toString());
    }
    return true;
  }
  
  private boolean a(msg_comm.Msg paramMsg)
  {
    if (paramMsg.msg_head.c2c_tmp_msg_head.service_type.has())
    {
      int i = paramMsg.msg_head.c2c_tmp_msg_head.service_type.get();
      if ((i == 129) || (i == 140) || (i == 142)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(msg_comm.Msg paramMsg, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    if (!paramBoolean) {
      return false;
    }
    paramStringBuilder.append(BaseApplication.getContext().getString(2131694606));
    paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramMsg.msg_seq.get();
    long l2 = paramMsg.msg_uid.get();
    long l3 = paramMsg.msg_time.get();
    long l4 = paramMsg.from_uin.get();
    long l5 = paramMsg.to_uin.get();
    paramMsg = new HashMap();
    paramMsg.put("param_FailCode", String.valueOf(10001));
    paramMsg.put("fromUin", String.valueOf(l4));
    paramMsg.put("toUin", String.valueOf(l5));
    paramMsg.put("msgSeq", String.valueOf(l1));
    paramMsg.put("msgUid", String.valueOf(l2));
    paramMsg.put("msgtime", String.valueOf(l3));
    paramStringBuilder = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramStringBuilder, "actMessageEvent", false, 0L, 0L, paramMsg, "");
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "parsePBMsgElemsCustomFace isC2C");
    }
    return true;
  }
  
  private boolean a(im_msg_body.CustomFace paramCustomFace)
  {
    return paramCustomFace != null;
  }
  
  private boolean a(im_msg_body.Elem paramElem)
  {
    if (paramElem != null) {
      return paramElem.hc_flash_pic.has();
    }
    return false;
  }
  
  private boolean a(im_msg_body.GeneralFlags paramGeneralFlags)
  {
    boolean bool = true;
    if ((paramGeneralFlags != null) && ((paramGeneralFlags.long_text_flag.get() == 2) || (paramGeneralFlags.long_text_flag.get() == 1)))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, longTextFlag: true");
        return true;
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  private byte[] a(im_msg_body.GeneralFlags paramGeneralFlags, byte[] paramArrayOfByte, MessageForStructing paramMessageForStructing, long paramLong, int paramInt, String paramString, boolean paramBoolean, TempSessionInfo paramTempSessionInfo)
  {
    Object localObject = paramArrayOfByte;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "begin getEmptyGeneralStructMsg");
      }
      paramMessageForStructing.structingMsg = ((StructMsgForGeneralShare)StructMsgFactory.a());
      return localObject;
    }
    if ((localObject != null) && (localObject.length != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, new Object[] { "begin getStructMsgFromXmlBuff: type=", Integer.valueOf(paramInt), ", code=", Long.valueOf(paramLong) });
      }
      paramGeneralFlags = NickNameManager.a(paramArrayOfByte, paramGeneralFlags, -1);
      int i;
      if (paramGeneralFlags != null)
      {
        i = 0;
        localObject = paramGeneralFlags;
      }
      else
      {
        i = -1;
      }
      paramMessageForStructing.structingMsg = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong, (byte[])localObject, i);
      paramGeneralFlags = (im_msg_body.GeneralFlags)localObject;
      if (QLog.isColorLevel())
      {
        paramGeneralFlags = new StringBuilder();
        paramGeneralFlags.append("StructMsg = ");
        paramGeneralFlags.append(paramMessageForStructing.structingMsg);
        QLog.d("StructMsg", 2, paramGeneralFlags.toString());
        return localObject;
      }
    }
    else
    {
      paramGeneralFlags = (im_msg_body.GeneralFlags)localObject;
      if (paramTempSessionInfo.jdField_a_of_type_Int == 1008)
      {
        paramGeneralFlags = (im_msg_body.GeneralFlags)localObject;
        if (!TextUtils.isEmpty(paramString))
        {
          if (QLog.isColorLevel())
          {
            paramGeneralFlags = new StringBuilder();
            paramGeneralFlags.append("msgId=uniseq:");
            paramGeneralFlags.append(paramMessageForStructing.uniseq);
            paramGeneralFlags.append(", begin getEmptyGeneralStructMsg for PA oldLongMsg!");
            QLog.d("PaOldLongMsg", 2, paramGeneralFlags.toString());
          }
          paramMessageForStructing.structingMsg = ((StructMsgForGeneralShare)StructMsgFactory.a());
          paramMessageForStructing.saveExtInfoToExtStr("pub_old_long_msg", "1");
          paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", paramString);
          paramMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
          paramGeneralFlags = (im_msg_body.GeneralFlags)localObject;
        }
      }
    }
    return paramGeneralFlags;
  }
  
  private byte[] a(im_msg_body.RichMsg paramRichMsg)
  {
    if (paramRichMsg.bytes_template_1.has()) {
      return paramRichMsg.bytes_template_1.get().toByteArray();
    }
    return null;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 2242	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 2243	java/util/zip/Inflater:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 2246	java/util/zip/Inflater:reset	()V
    //   12: aload_3
    //   13: aload_0
    //   14: invokevirtual 2249	java/util/zip/Inflater:setInput	([B)V
    //   17: new 2251	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: aload_0
    //   22: arraylength
    //   23: invokespecial 2253	java/io/ByteArrayOutputStream:<init>	(I)V
    //   26: astore 4
    //   28: sipush 1024
    //   31: newarray byte
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 2256	java/util/zip/Inflater:finished	()Z
    //   38: ifne +18 -> 56
    //   41: aload 4
    //   43: aload_1
    //   44: iconst_0
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 2260	java/util/zip/Inflater:inflate	([B)I
    //   50: invokevirtual 2264	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -19 -> 34
    //   56: aload 4
    //   58: invokevirtual 2265	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload 4
    //   66: invokevirtual 2268	java/io/ByteArrayOutputStream:close	()V
    //   69: aload_2
    //   70: astore_0
    //   71: goto +29 -> 100
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 2269	java/io/IOException:printStackTrace	()V
    //   79: aload_1
    //   80: astore_0
    //   81: goto +19 -> 100
    //   84: astore_0
    //   85: goto +21 -> 106
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   93: aload_0
    //   94: astore_1
    //   95: aload 4
    //   97: invokevirtual 2268	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_3
    //   101: invokevirtual 2272	java/util/zip/Inflater:end	()V
    //   104: aload_0
    //   105: areturn
    //   106: aload 4
    //   108: invokevirtual 2268	java/io/ByteArrayOutputStream:close	()V
    //   111: goto +8 -> 119
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 2269	java/io/IOException:printStackTrace	()V
    //   119: goto +5 -> 124
    //   122: aload_0
    //   123: athrow
    //   124: goto -2 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramArrayOfByte	byte[]
    //   33	47	1	localObject	Object
    //   88	2	1	localException	Exception
    //   94	1	1	arrayOfByte1	byte[]
    //   114	2	1	localIOException	java.io.IOException
    //   61	9	2	arrayOfByte2	byte[]
    //   7	94	3	localInflater	java.util.zip.Inflater
    //   26	81	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   64	69	74	java/io/IOException
    //   95	100	74	java/io/IOException
    //   28	34	84	finally
    //   34	53	84	finally
    //   56	62	84	finally
    //   89	93	84	finally
    //   28	34	88	java/lang/Exception
    //   34	53	88	java/lang/Exception
    //   56	62	88	java/lang/Exception
    //   106	111	114	java/io/IOException
  }
  
  private int b(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    label9:
    im_msg_body.Elem localElem;
    for (int i = 0; paramList.hasNext(); i = localElem.elem_flags2.uint32_msg_rpt_cnt.get())
    {
      localElem = (im_msg_body.Elem)paramList.next();
      if ((!localElem.elem_flags2.has()) || (!localElem.elem_flags2.uint32_msg_rpt_cnt.has())) {
        break label9;
      }
    }
    return i;
  }
  
  @Nullable
  private String b(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if ((localElem.text.has()) && (localElem.text.str.has()))
      {
        paramList = localElem.text.str.get().toStringUtf8();
        if ((paramList.startsWith("[")) && (paramList.endsWith("]"))) {
          paramList = HexUtil.bytes2HexStr(localElem.text.str.get().toByteArray());
        } else {
          paramList = "";
        }
      }
    }
    return paramList;
  }
  
  @Nullable
  private im_msg_body.GeneralFlags b(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.general_flags.has()) {
        paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      }
    }
    return paramList;
  }
  
  private void b(int paramInt, ChatMessage paramChatMessage)
  {
    if (paramInt > 0)
    {
      paramChatMessage.setRepeatCount(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MessageForText ====> repeatCount = ");
        localStringBuilder.append(paramChatMessage.getRepeatCount());
        QLog.d("DecodeMsg", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    String str = a(paramMessageForStructing);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007238", "0X8007238", 0, 0, str, "", "", "");
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007238", "", str, "", "", "");
    paramMessageForStructing.structingMsg.mMsgActionData = a(paramMessageForStructing.structingMsg.mMsgActionData);
  }
  
  private void b(List<im_msg_body.Elem> paramList, MessageForStructing paramMessageForStructing)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.life_online.has()) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint64_unique_id.has())) {
        paramMessageForStructing.structingMsg.msgId = ((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint64_unique_id.get();
      }
    }
  }
  
  private void b(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!paramDeliverGiftMsg.bytes_comefrom_link.has()) {
      return;
    }
    paramMessageForDeliverGiftTips.jumpUrl = paramDeliverGiftMsg.bytes_comefrom_link.get().toStringUtf8();
  }
  
  private void b(im_msg_body.GeneralFlags paramGeneralFlags, ChatMessage paramChatMessage)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {
      try
      {
        byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
        String str = Utils.a(arrayOfByte);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodePBMsgElems_Text, guideMsgCookie: ");
          localStringBuilder.append(str);
          localStringBuilder.append(",bytes: ");
          localStringBuilder.append(Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          QLog.d("DecodeMsg", 2, localStringBuilder.toString());
        }
        paramChatMessage.saveExtInfoToExtStr("guide_msg_cookie", str);
        ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(arrayOfByte);
        return;
      }
      catch (Exception paramGeneralFlags)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "get text guideMsgCookie error!", paramGeneralFlags);
        }
      }
    }
  }
  
  private void b(im_msg_body.GeneralFlags paramGeneralFlags, List<MessageRecord> paramList)
  {
    Object localObject2 = null;
    int j = 0;
    Object localObject1 = localObject2;
    int i = j;
    if (paramGeneralFlags != null)
    {
      localObject1 = localObject2;
      i = j;
      if (paramGeneralFlags.bytes_pb_reserve.has()) {
        try
        {
          generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
          localResvAttr.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
          localObject1 = localObject2;
          i = j;
          if (localResvAttr.bytes_kpl_info.has())
          {
            localObject1 = localObject2;
            i = j;
            if (localResvAttr.bytes_kpl_info.has())
            {
              localObject1 = localResvAttr.bytes_kpl_info.get().toStringUtf8();
              i = 1;
            }
          }
        }
        catch (Exception paramGeneralFlags)
        {
          if (QLog.isColorLevel()) {
            QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
          }
          paramGeneralFlags.printStackTrace();
          i = j;
          localObject1 = localObject2;
        }
      }
    }
    if (i != 0)
    {
      paramGeneralFlags = paramList.iterator();
      while (paramGeneralFlags.hasNext()) {
        ((MessageRecord)paramGeneralFlags.next()).saveExtInfoToExtStr("msg_ext_key", "Y");
      }
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "resv a kpl pic message !");
      }
      KplHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
    }
  }
  
  private boolean b(List<MessageRecord> paramList, im_msg_body.Text paramText, MessageForStructing paramMessageForStructing)
  {
    if (QQStoryManager.i())
    {
      MessageForQQStory localMessageForQQStory = (MessageForQQStory)MessageRecordFactory.a(-2051);
      localMessageForQQStory.msgtype = -2051;
      StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText)) && (paramText != null) && (paramText.str.has())) {
        localStructMsgForGeneralShare.mCompatibleText = paramText.str.get().toStringUtf8();
      }
      localMessageForQQStory.structingMsg = localStructMsgForGeneralShare;
      localMessageForQQStory.doPrewrite();
      if (TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText))
      {
        localMessageForQQStory.doParse();
        localStructMsgForGeneralShare.mCompatibleText = MessageForQQStory.buildCompatibleText(localMessageForQQStory.authorName, localMessageForQQStory.brief, localMessageForQQStory.srcName);
        localMessageForQQStory.doPrewrite();
        if (QLog.isColorLevel())
        {
          paramText = new StringBuilder();
          paramText.append("recv storyMsg, mCompatibleText isEmpty, rebuild:");
          paramText.append(localStructMsgForGeneralShare.mCompatibleText);
          QLog.d("Q.qqstory.share", 2, paramText.toString());
        }
      }
      paramList.add(localMessageForQQStory);
      paramMessageForStructing.structingMsg = null;
      return true;
    }
    paramMessageForStructing.structingMsg = null;
    if (paramText != null)
    {
      paramText.str.set(ByteStringMicro.copyFromUtf8(QQStoryManager.a()));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "recv storyMsg, isSDKAPISupportStory==false, txtMsg==null");
    }
    return false;
  }
  
  private int c(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    label9:
    im_msg_body.Elem localElem;
    for (int i = -1; paramList.hasNext(); i = localElem.bless_msg.uint32_ex_flag.get())
    {
      localElem = (im_msg_body.Elem)paramList.next();
      if ((!localElem.bless_msg.has()) || (localElem.bless_msg.uint32_msg_type.get() != 1) || (!localElem.bless_msg.uint32_ex_flag.has())) {
        break label9;
      }
    }
    return i;
  }
  
  @Nullable
  private im_msg_body.GeneralFlags c(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.general_flags.has()) {
        paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      }
    }
    return paramList;
  }
  
  private void c(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (paramDeliverGiftMsg.bytes_receiver_pic.has()) {
      paramMessageForDeliverGiftTips.receiverHead = paramDeliverGiftMsg.bytes_receiver_pic.get().toStringUtf8();
    }
  }
  
  private void d(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!paramDeliverGiftMsg.bytes_receiver_name.has()) {
      return;
    }
    paramMessageForDeliverGiftTips.receiverName = paramDeliverGiftMsg.bytes_receiver_name.get().toStringUtf8();
  }
  
  private void e(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!paramDeliverGiftMsg.bytes_pb_reserve.has()) {
      return;
    }
    ResvAttrForGiftMsg.ResvAttr localResvAttr = new ResvAttrForGiftMsg.ResvAttr();
    try
    {
      localResvAttr.mergeFrom(paramDeliverGiftMsg.bytes_pb_reserve.get().toByteArray());
      paramMessageForDeliverGiftTips.sendScore = localResvAttr.int32_send_score.get();
      paramMessageForDeliverGiftTips.recvScore = localResvAttr.int32_recv_score.get();
      if (localResvAttr.bytes_charm_heroism.has()) {
        paramMessageForDeliverGiftTips.charmHeroism = localResvAttr.bytes_charm_heroism.get().toStringUtf8();
      }
      paramMessageForDeliverGiftTips.btFlag = localResvAttr.uint32_button_flag.get();
      paramMessageForDeliverGiftTips.objColor = localResvAttr.uint32_obj_color.get();
      if (localResvAttr.activity_gift_info.has())
      {
        paramDeliverGiftMsg = (ResvAttrForGiftMsg.ActivityGiftInfo)localResvAttr.activity_gift_info.get();
        paramMessageForDeliverGiftTips.is_activity_gift = paramDeliverGiftMsg.is_activity_gift.get();
        paramMessageForDeliverGiftTips.activity_text_color = paramDeliverGiftMsg.text_color.get();
        paramMessageForDeliverGiftTips.activity_text = paramDeliverGiftMsg.text.get();
        paramMessageForDeliverGiftTips.activity_url = paramDeliverGiftMsg.url.get();
      }
      else
      {
        paramMessageForDeliverGiftTips.is_activity_gift = 0;
      }
      paramMessageForDeliverGiftTips.animationType = localResvAttr.uint32_animation_type.get();
      if (localResvAttr.msg_interact_gift.has())
      {
        paramMessageForDeliverGiftTips.interactId = localResvAttr.msg_interact_gift.bytes_interact_id.get().toStringUtf8();
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramDeliverGiftMsg)
    {
      paramDeliverGiftMsg.printStackTrace();
    }
  }
  
  /* Error */
  protected ChatMessage a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, ArrayList<Object> paramArrayList, MessageInfo paramMessageInfo, ArrayList<AtTroopMemberInfo> paramArrayList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 2473	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ljava/util/List;)Ltencent/im/msg/im_msg_body$GeneralFlags;
    //   5: astore 25
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 2475	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ljava/util/List;)Z
    //   12: istore 13
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 2477	com/tencent/mobileqq/service/message/MessagePBElemDecoder:c	(Ljava/util/List;)I
    //   19: istore 8
    //   21: aload_0
    //   22: aload_1
    //   23: invokespecial 2479	com/tencent/mobileqq/service/message/MessagePBElemDecoder:b	(Ljava/util/List;)I
    //   26: istore 9
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 2481	com/tencent/mobileqq/service/message/MessagePBElemDecoder:b	(Ljava/util/List;)Ljava/lang/String;
    //   33: astore 26
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 2483	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ljava/util/List;)I
    //   40: istore 10
    //   42: aload_3
    //   43: ifnull +35 -> 78
    //   46: aload_3
    //   47: invokevirtual 2484	java/util/ArrayList:size	()I
    //   50: iconst_2
    //   51: if_icmpne +27 -> 78
    //   54: aload_3
    //   55: iconst_1
    //   56: invokevirtual 2485	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   59: ifnull +19 -> 78
    //   62: aload_3
    //   63: iconst_1
    //   64: invokevirtual 2485	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   67: checkcast 2486	[B
    //   70: checkcast 2486	[B
    //   73: astore 22
    //   75: goto +6 -> 81
    //   78: aconst_null
    //   79: astore 22
    //   81: aload 25
    //   83: ifnull +520 -> 603
    //   86: aload 25
    //   88: getfield 1807	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   91: invokevirtual 69	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   94: ifeq +208 -> 302
    //   97: new 1809	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   100: dup
    //   101: invokespecial 1810	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   104: astore 21
    //   106: aload 21
    //   108: aload 25
    //   110: getfield 1807	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: invokevirtual 82	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   119: invokevirtual 1811	tencent/im/msg/hummer/resv/generalflags$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   122: pop
    //   123: aload 21
    //   125: getfield 2489	tencent/im/msg/hummer/resv/generalflags$ResvAttr:redbag_msg_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   128: invokevirtual 204	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   131: istore 11
    //   133: iload 11
    //   135: ifeq +34 -> 169
    //   138: aload 21
    //   140: getfield 2489	tencent/im/msg/hummer/resv/generalflags$ResvAttr:redbag_msg_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   143: invokevirtual 182	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   146: lstore 15
    //   148: iconst_1
    //   149: istore 6
    //   151: goto +24 -> 175
    //   154: astore 21
    //   156: lconst_0
    //   157: lstore 17
    //   159: lload 17
    //   161: lstore 15
    //   163: iconst_1
    //   164: istore 6
    //   166: goto +118 -> 284
    //   169: lconst_0
    //   170: lstore 15
    //   172: iconst_0
    //   173: istore 6
    //   175: aload 21
    //   177: getfield 2492	tencent/im/msg/hummer/resv/generalflags$ResvAttr:want_gift_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   180: invokevirtual 204	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   183: ifeq +16 -> 199
    //   186: aload 21
    //   188: getfield 2492	tencent/im/msg/hummer/resv/generalflags$ResvAttr:want_gift_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   191: invokevirtual 182	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   194: lstore 19
    //   196: goto +6 -> 202
    //   199: lconst_0
    //   200: lstore 19
    //   202: aload 21
    //   204: getfield 1834	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   207: invokevirtual 69	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   210: ifeq +19 -> 229
    //   213: aload 21
    //   215: getfield 1834	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   221: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   224: astore 21
    //   226: goto +6 -> 232
    //   229: aconst_null
    //   230: astore 21
    //   232: lload 15
    //   234: lstore 17
    //   236: lload 19
    //   238: lstore 15
    //   240: goto +75 -> 315
    //   243: astore 21
    //   245: lload 15
    //   247: lstore 17
    //   249: lload 19
    //   251: lstore 15
    //   253: goto +31 -> 284
    //   256: astore 21
    //   258: lconst_0
    //   259: lstore 19
    //   261: lload 15
    //   263: lstore 17
    //   265: lload 19
    //   267: lstore 15
    //   269: goto +15 -> 284
    //   272: astore 21
    //   274: lconst_0
    //   275: lstore 17
    //   277: lload 17
    //   279: lstore 15
    //   281: iconst_0
    //   282: istore 6
    //   284: ldc_w 2494
    //   287: iconst_1
    //   288: ldc_w 2496
    //   291: aload 21
    //   293: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: aconst_null
    //   297: astore 21
    //   299: goto +16 -> 315
    //   302: lconst_0
    //   303: lstore 17
    //   305: lload 17
    //   307: lstore 15
    //   309: aconst_null
    //   310: astore 21
    //   312: iconst_0
    //   313: istore 6
    //   315: iload 6
    //   317: istore 7
    //   319: lload 17
    //   321: lstore 19
    //   323: iload 6
    //   325: ifne +51 -> 376
    //   328: iload 6
    //   330: istore 7
    //   332: lload 17
    //   334: lstore 19
    //   336: aload 25
    //   338: getfield 2499	tencent/im/msg/im_msg_body$GeneralFlags:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   341: invokevirtual 204	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   344: ifeq +32 -> 376
    //   347: aload 25
    //   349: getfield 2499	tencent/im/msg/im_msg_body$GeneralFlags:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   352: invokevirtual 182	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   355: lstore 19
    //   357: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +13 -> 373
    //   363: ldc_w 2494
    //   366: iconst_2
    //   367: ldc_w 2501
    //   370: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: iconst_1
    //   374: istore 7
    //   376: iload 7
    //   378: ifeq +218 -> 596
    //   381: aload 25
    //   383: getfield 2504	tencent/im/msg/im_msg_body$GeneralFlags:uint32_prp_fold	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   386: invokevirtual 96	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   389: iconst_1
    //   390: if_icmpne +9 -> 399
    //   393: iconst_1
    //   394: istore 11
    //   396: goto +6 -> 402
    //   399: iconst_0
    //   400: istore 11
    //   402: aload 25
    //   404: getfield 2507	tencent/im/msg/im_msg_body$GeneralFlags:bytes_rp_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   407: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   410: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   413: astore 23
    //   415: aload 25
    //   417: getfield 2510	tencent/im/msg/im_msg_body$GeneralFlags:bytes_rp_index	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   420: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   423: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   426: astore 24
    //   428: aload_0
    //   429: getfield 25	com/tencent/mobileqq/service/message/MessagePBElemDecoder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: invokestatic 2515	com/tencent/mobileqq/managers/PasswdRedBagFoldManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   435: istore 12
    //   437: aload_0
    //   438: getfield 31	com/tencent/mobileqq/service/message/MessagePBElemDecoder:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   441: getfield 210	com/tencent/mobileqq/app/MessageHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   444: invokestatic 2517	com/tencent/mobileqq/managers/PasswdRedBagFoldManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   447: ifeq +33 -> 480
    //   450: aload 23
    //   452: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   455: ifne +9 -> 464
    //   458: iconst_1
    //   459: istore 12
    //   461: goto +22 -> 483
    //   464: aload 24
    //   466: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   469: ifne +11 -> 480
    //   472: iload 12
    //   474: ifeq +6 -> 480
    //   477: goto -19 -> 458
    //   480: iconst_0
    //   481: istore 12
    //   483: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +71 -> 557
    //   489: ldc_w 2494
    //   492: iconst_2
    //   493: ldc_w 2519
    //   496: bipush 6
    //   498: anewarray 1431	java/lang/Object
    //   501: dup
    //   502: iconst_0
    //   503: lload 19
    //   505: invokestatic 1434	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   508: aastore
    //   509: dup
    //   510: iconst_1
    //   511: iload 11
    //   513: invokestatic 650	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   516: aastore
    //   517: dup
    //   518: iconst_2
    //   519: aload 23
    //   521: aastore
    //   522: dup
    //   523: iconst_3
    //   524: aload 24
    //   526: aastore
    //   527: dup
    //   528: iconst_4
    //   529: aload_0
    //   530: getfield 25	com/tencent/mobileqq/service/message/MessagePBElemDecoder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   533: invokestatic 2517	com/tencent/mobileqq/managers/PasswdRedBagFoldManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   536: invokestatic 650	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   539: aastore
    //   540: dup
    //   541: iconst_5
    //   542: iload 12
    //   544: invokestatic 650	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   547: aastore
    //   548: invokestatic 2523	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   551: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: goto +3 -> 557
    //   557: aload_2
    //   558: getfield 162	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   561: getfield 203	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   564: invokevirtual 182	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   567: invokestatic 387	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   570: aload_0
    //   571: getfield 25	com/tencent/mobileqq/service/message/MessagePBElemDecoder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   574: invokevirtual 1149	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   577: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   580: ifeq +9 -> 589
    //   583: iconst_0
    //   584: istore 11
    //   586: goto +3 -> 589
    //   589: lload 19
    //   591: lstore 17
    //   593: goto +32 -> 625
    //   596: lload 19
    //   598: lstore 17
    //   600: goto +13 -> 613
    //   603: lconst_0
    //   604: lstore 15
    //   606: lload 15
    //   608: lstore 17
    //   610: aconst_null
    //   611: astore 21
    //   613: iconst_0
    //   614: istore 12
    //   616: iconst_0
    //   617: istore 11
    //   619: aconst_null
    //   620: astore 23
    //   622: aconst_null
    //   623: astore 24
    //   625: aload_0
    //   626: aload 25
    //   628: invokespecial 2525	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ltencent/im/msg/im_msg_body$GeneralFlags;)Z
    //   631: istore 14
    //   633: iload 12
    //   635: ifeq +30 -> 665
    //   638: new 2527	com/tencent/mobileqq/data/MessageForFoldMsg
    //   641: dup
    //   642: invokespecial 2528	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   645: astore_1
    //   646: aload_1
    //   647: checkcast 2527	com/tencent/mobileqq/data/MessageForFoldMsg
    //   650: iload 11
    //   652: aload 23
    //   654: aload 24
    //   656: lload 17
    //   658: iconst_1
    //   659: invokevirtual 2532	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;Ljava/lang/String;JZ)V
    //   662: goto +166 -> 828
    //   665: iload 14
    //   667: ifeq +32 -> 699
    //   670: sipush -1051
    //   673: invokestatic 352	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   676: checkcast 746	com/tencent/mobileqq/data/ChatMessage
    //   679: astore_1
    //   680: aload_1
    //   681: ldc_w 2534
    //   684: ldc 146
    //   686: invokevirtual 750	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: aload_1
    //   690: ldc_w 2536
    //   693: invokevirtual 2539	com/tencent/mobileqq/data/ChatMessage:removeExtInfoToExtStr	(Ljava/lang/String;)V
    //   696: goto +132 -> 828
    //   699: lload 15
    //   701: lconst_0
    //   702: lcmp
    //   703: ifeq +74 -> 777
    //   706: new 2541	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   709: dup
    //   710: invokespecial 2542	com/tencent/mobileqq/data/MessageForWantGiftMsg:<init>	()V
    //   713: astore_1
    //   714: aload_1
    //   715: checkcast 2541	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   718: astore_3
    //   719: aload_3
    //   720: lload 15
    //   722: putfield 2545	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   725: getstatic 2548	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   728: astore 4
    //   730: new 184	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   737: astore 5
    //   739: aload 5
    //   741: lload 15
    //   743: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 5
    //   749: ldc_w 446
    //   752: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload_3
    //   757: aload 4
    //   759: aload 5
    //   761: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokevirtual 2549	com/tencent/mobileqq/data/MessageForWantGiftMsg:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: aload_3
    //   768: sipush -2056
    //   771: putfield 2550	com/tencent/mobileqq/data/MessageForWantGiftMsg:msgtype	I
    //   774: goto +54 -> 828
    //   777: aload_0
    //   778: aload_1
    //   779: aload_2
    //   780: aload_3
    //   781: aload 4
    //   783: aload 5
    //   785: invokespecial 2552	com/tencent/mobileqq/service/message/QMessagePBElemDecoder:a	(Ljava/util/List;Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;Lcom/tencent/mobileqq/troop/data/MessageInfo;Ljava/util/ArrayList;)Lcom/tencent/mobileqq/data/ChatMessage;
    //   788: astore_3
    //   789: aload 4
    //   791: ifnull +19 -> 810
    //   794: aload 5
    //   796: ifnull +14 -> 810
    //   799: aload 4
    //   801: getfield 2553	com/tencent/mobileqq/troop/data/MessageInfo:jdField_a_of_type_Int	I
    //   804: aload 5
    //   806: aload_3
    //   807: invokestatic 2558	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   810: aload_3
    //   811: astore_1
    //   812: aload 21
    //   814: ifnull +14 -> 828
    //   817: aload_3
    //   818: ldc_w 1836
    //   821: aload 21
    //   823: invokevirtual 750	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: aload_3
    //   827: astore_1
    //   828: aload_0
    //   829: aload_1
    //   830: invokespecial 2560	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   833: aload_0
    //   834: aload_2
    //   835: aload 22
    //   837: aload_1
    //   838: invokevirtual 2563	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Lmsf/msgcomm/msg_comm$Msg;[BLcom/tencent/mobileqq/data/MessageRecord;)V
    //   841: aload_0
    //   842: aload 25
    //   844: aload_1
    //   845: invokespecial 2565	com/tencent/mobileqq/service/message/MessagePBElemDecoder:b	(Ltencent/im/msg/im_msg_body$GeneralFlags;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   848: aload_0
    //   849: iload 13
    //   851: iload 8
    //   853: aload_1
    //   854: invokespecial 2567	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(ZILcom/tencent/mobileqq/data/ChatMessage;)V
    //   857: aload_0
    //   858: iload 9
    //   860: aload_1
    //   861: invokespecial 2569	com/tencent/mobileqq/service/message/MessagePBElemDecoder:b	(ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   864: aload_0
    //   865: aload 25
    //   867: aload_1
    //   868: invokespecial 2571	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ltencent/im/msg/im_msg_body$GeneralFlags;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   871: aload_0
    //   872: aload 26
    //   874: aload_1
    //   875: invokespecial 2573	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   878: aload_0
    //   879: iload 10
    //   881: aload_1
    //   882: invokespecial 2575	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   885: aload_1
    //   886: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	MessagePBElemDecoder
    //   0	887	1	paramList	List<im_msg_body.Elem>
    //   0	887	2	paramMsg	msg_comm.Msg
    //   0	887	3	paramArrayList	ArrayList<Object>
    //   0	887	4	paramMessageInfo	MessageInfo
    //   0	887	5	paramArrayList1	ArrayList<AtTroopMemberInfo>
    //   149	180	6	i	int
    //   317	60	7	j	int
    //   19	833	8	k	int
    //   26	833	9	m	int
    //   40	840	10	n	int
    //   131	520	11	bool1	boolean
    //   435	199	12	bool2	boolean
    //   12	838	13	bool3	boolean
    //   631	35	14	bool4	boolean
    //   146	596	15	l1	long
    //   157	500	17	l2	long
    //   194	403	19	l3	long
    //   104	35	21	localResvAttr	generalflags.ResvAttr
    //   154	60	21	localException1	Exception
    //   224	7	21	str1	String
    //   243	1	21	localException2	Exception
    //   256	1	21	localException3	Exception
    //   272	20	21	localException4	Exception
    //   297	525	21	str2	String
    //   73	763	22	arrayOfByte	byte[]
    //   413	240	23	str3	String
    //   426	229	24	str4	String
    //   5	861	25	localGeneralFlags	im_msg_body.GeneralFlags
    //   33	840	26	str5	String
    // Exception table:
    //   from	to	target	type
    //   138	148	154	java/lang/Exception
    //   202	226	243	java/lang/Exception
    //   175	196	256	java/lang/Exception
    //   97	133	272	java/lang/Exception
  }
  
  public MarkFaceMessage a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, StringBuilder paramStringBuilder, long paramLong)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    im_msg_body.MarketFace localMarketFace = (im_msg_body.MarketFace)paramElem.market_face.get();
    MarketFaceExtPb.ResvAttr localResvAttr;
    if (localMarketFace != null)
    {
      paramElem = new MarkFaceMessage();
      paramElem.cFaceInfo = localMarketFace.uint32_face_info.get();
      paramElem.index = 0L;
      paramElem.cSubType = localMarketFace.uint32_sub_type.get();
      paramElem.dwMSGItemType = localMarketFace.uint32_item_type.get();
      paramElem.dwTabID = localMarketFace.uint32_tab_id.get();
      paramElem.sbfKey = localMarketFace.bytes_key.get().toByteArray();
      paramElem.sbufID = localMarketFace.bytes_face_id.get().toByteArray();
      paramElem.mediaType = localMarketFace.uint32_media_type.get();
      paramElem.imageWidth = 200;
      paramElem.imageHeight = 200;
      paramElem.mobileparam = localMarketFace.bytes_mobileparam.get().toByteArray();
      if (localMarketFace.bytes_pb_reserve.has())
      {
        paramElem.resvAttr = localMarketFace.bytes_pb_reserve.get().toByteArray();
        localResvAttr = new MarketFaceExtPb.ResvAttr();
      }
    }
    for (;;)
    {
      try
      {
        localResvAttr.mergeFrom(paramElem.resvAttr);
        paramElem.copywritingType = localResvAttr.uint32_source_type.get();
        paramElem.copywritingContent = localResvAttr.str_source_name.get();
        paramElem.jumpUrl = localResvAttr.str_source_jump_url.get();
        paramElem.beginTime = localResvAttr.uint32_start_time.get();
        paramElem.endTime = localResvAttr.uint32_end_time.get();
        paramElem.from = localResvAttr.str_source_type_name.get();
        if (localResvAttr.uint32_emoji_type.get() != 2) {
          break label674;
        }
        bool = true;
        paramElem.isAPNG = bool;
        if (localResvAttr.uint32_has_ip_product.get() != 1) {
          break label680;
        }
        bool = true;
        paramElem.hasIpProduct = bool;
        if (localResvAttr.uint32_voice_item_height_arr.has()) {
          paramElem.voicePrintItems = localResvAttr.uint32_voice_item_height_arr.get();
        }
        if (localResvAttr.str_back_color.has()) {
          paramElem.backColor = localResvAttr.str_back_color.get();
        }
        if (localResvAttr.str_volume_color.has()) {
          paramElem.volumeColor = localResvAttr.str_volume_color.get();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mergeFrom resvAttr error e = ");
        localStringBuilder.append(localInvalidProtocolBufferMicroException);
        QLog.e("DecodeMsg", 1, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append(" mediaType = ");
        paramStringBuilder.append(paramElem.mediaType);
        paramStringBuilder.append("\n");
      }
      if (localMarketFace.bytes_face_name.has())
      {
        paramStringBuilder = localMarketFace.bytes_face_name.get().toStringUtf8();
        if ((!TextUtils.isEmpty(paramStringBuilder)) && (paramStringBuilder.length() > 1) && (paramStringBuilder.charAt(0) == '[') && (paramStringBuilder.charAt(paramStringBuilder.length() - 1) == ']')) {
          paramElem.faceName = paramStringBuilder.substring(1, paramStringBuilder.length() - 1);
        } else {
          paramElem.faceName = paramStringBuilder;
        }
      }
      paramStringBuilder = (MessageForMarketFace)MessageRecordFactory.a(-2007);
      paramStringBuilder.msgtype = -2007;
      paramStringBuilder.msg = "it is marketface";
      paramStringBuilder.mMarkFaceMessage = paramElem;
      if ((paramElem.mobileparam != null) && (paramElem.mobileparam.length > 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
      }
      try
      {
        paramStringBuilder.msgData = MessagePkgUtils.a(paramElem);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      paramList.add(paramStringBuilder);
      return paramElem;
      return null;
      label674:
      boolean bool = false;
      continue;
      label680:
      bool = false;
    }
  }
  
  public MessageForReplyText.SourceMsgInfo a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder)
  {
    Object localObject2 = paramList.iterator();
    paramList = null;
    Object localObject1;
    do
    {
      do
      {
        localObject1 = paramList;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (im_msg_body.Elem)((Iterator)localObject2).next();
      } while (!((im_msg_body.Elem)localObject1).src_msg.has());
      localObject1 = (im_msg_body.SourceMsg)((im_msg_body.Elem)localObject1).src_msg.get();
      paramList = (List<im_msg_body.Elem>)localObject1;
    } while (!((im_msg_body.SourceMsg)localObject1).bytes_src_msg.has());
    if ((localObject1 != null) && (((im_msg_body.SourceMsg)localObject1).elems.has()))
    {
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:SrcMsg;\n");
      }
      paramList = ((im_msg_body.SourceMsg)localObject1).elems.get();
      paramStringBuilder = new MessageForReplyText.SourceMsgInfo();
      paramStringBuilder.mSourceMsgSeq = ((Integer)((im_msg_body.SourceMsg)localObject1).uint32_orig_seqs.get(0)).intValue();
      paramStringBuilder.mSourceMsgText = a(paramList);
      paramStringBuilder.mSourceMsgTime = ((im_msg_body.SourceMsg)localObject1).uint32_time.get();
      paramStringBuilder.mSourceMsgSenderUin = ((im_msg_body.SourceMsg)localObject1).uint64_sender_uin.get();
      if (((im_msg_body.SourceMsg)localObject1).bytes_troop_name.has()) {
        paramStringBuilder.mSourceMsgTroopName = ((im_msg_body.SourceMsg)localObject1).bytes_troop_name.get().toStringUtf8();
      } else {
        paramStringBuilder.mSourceMsgTroopName = null;
      }
      paramStringBuilder.mSourceMsgToUin = ((im_msg_body.SourceMsg)localObject1).uint64_to_uin.get();
      paramStringBuilder.mSourceSummaryFlag = ((im_msg_body.SourceMsg)localObject1).uint32_flag.get();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (im_msg_body.Elem)paramList.next();
        if (((im_msg_body.Elem)localObject2).anon_group_msg.has()) {
          paramStringBuilder.mAnonymousNickName = ((im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject2).anon_group_msg.get()).str_anon_nick.get().toStringUtf8();
        }
      }
      if (((im_msg_body.SourceMsg)localObject1).uint32_type.has()) {
        paramStringBuilder.mType = ((im_msg_body.SourceMsg)localObject1).uint32_type.get();
      }
      if (((im_msg_body.SourceMsg)localObject1).bytes_richMsg.has()) {
        paramStringBuilder.mRichMsg = ((im_msg_body.SourceMsg)localObject1).bytes_richMsg.get().toStringUtf8();
      }
      if (((im_msg_body.SourceMsg)localObject1).bytes_pb_reserve.has())
      {
        paramList = new source_msg.ResvAttr();
        try
        {
          paramList.mergeFrom(((im_msg_body.SourceMsg)localObject1).bytes_pb_reserve.get().toByteArray());
          if (paramList.uint32_ori_msgtype.has()) {
            paramStringBuilder.oriMsgType = paramList.uint32_ori_msgtype.get();
          }
          if ((paramList.uint64_orig_uids.has()) && (!paramList.uint64_orig_uids.isEmpty())) {
            paramStringBuilder.origUid = ((Long)paramList.uint64_orig_uids.get(0)).longValue();
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
        }
      }
      paramList = paramStringBuilder;
      if (((im_msg_body.SourceMsg)localObject1).bytes_src_msg.has())
      {
        paramStringBuilder.setSourceMsgByte(((im_msg_body.SourceMsg)localObject1).bytes_src_msg.get().toByteArray());
        return paramStringBuilder;
      }
    }
    else
    {
      paramList = null;
    }
    return paramList;
  }
  
  public MessagePBElemDecoder.DecodeSrcMsgContext a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, long paramLong, MessageInfo paramMessageInfo)
  {
    MessagePBElemDecoder.DecodeSrcMsgContext localDecodeSrcMsgContext = new MessagePBElemDecoder.DecodeSrcMsgContext(this);
    localDecodeSrcMsgContext.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = a(paramList, paramStringBuilder);
    ResultBox localResultBox = new ResultBox();
    ArrayList localArrayList = localResultBox.jdField_a_of_type_JavaUtilArrayList;
    StringBuilder localStringBuilder = a(null, paramList, paramStringBuilder, paramLong, paramMessageInfo, localResultBox, null);
    String str = null;
    paramList = null;
    paramStringBuilder = str;
    if (localArrayList != null)
    {
      paramStringBuilder = str;
      if (localArrayList.size() == 2)
      {
        if (localArrayList.get(0) != null) {
          paramList = (AtTroopMemberInfo)localArrayList.get(0);
        }
        paramStringBuilder = paramList;
        if (localArrayList.get(1) != null)
        {
          localDecodeSrcMsgContext.jdField_a_of_type_ArrayOfByte = ((byte[])localArrayList.get(1));
          paramStringBuilder = paramList;
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (localDecodeSrcMsgContext.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null))
    {
      localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      if ((TextUtils.isEmpty(localDecodeSrcMsgContext.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)) && (paramStringBuilder != null) && (!TextUtils.isEmpty(localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString)) && (localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString.length() >= paramStringBuilder.textLen + paramStringBuilder.startPos))
      {
        localDecodeSrcMsgContext.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo = paramStringBuilder;
        str = localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString;
        paramList = "";
        localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString = "";
        if (paramStringBuilder.startPos > 0) {
          localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString = str.substring(0, paramStringBuilder.startPos);
        }
        int i = paramStringBuilder.startPos + paramStringBuilder.textLen;
        int j = i + 1;
        if (j < str.length()) {
          paramList = str.substring(i, j);
        }
        if (paramList.equals(" "))
        {
          paramList = new StringBuilder();
          paramList.append(localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString);
          paramList.append(str.substring(j));
          localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString = paramList.toString();
        }
        else
        {
          paramList = new StringBuilder();
          paramList.append(localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString);
          paramList.append(str.substring(i));
          localDecodeSrcMsgContext.jdField_a_of_type_JavaLangString = paramList.toString();
        }
        localDecodeSrcMsgContext.b = str.substring(paramStringBuilder.startPos, paramStringBuilder.startPos + paramStringBuilder.textLen);
        if ((paramStringBuilder.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) && (localResultBox.jdField_a_of_type_ComTencentMobileqqDataAtTroopMemberInfo == null)) {
          paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b(24, -1L);
        }
      }
    }
    return localDecodeSrcMsgContext;
  }
  
  protected MsgDecoderWrapper a(im_msg_body.RichMsg paramRichMsg, List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    String str = a(paramRichMsg.bytes_msg_resid.get());
    long l = paramMsg.msg_head.to_uin.get();
    int i = paramMsg.msg_head.msg_type.get();
    MessageForStructing localMessageForStructing = new MessageForStructing();
    paramRichMsg = a(paramRichMsg);
    localMessageForStructing.msgtype = -2011;
    boolean bool = a(paramList, localMessageForStructing, str);
    paramList = TempSessionDecoder.a(paramMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMsg, paramRichMsg, localMessageForStructing, str, bool, paramList);
    a(paramGeneralFlags, localMessageForStructing);
    return new MsgDecoderWrapper(localMessageForStructing, a(paramGeneralFlags, paramRichMsg, localMessageForStructing, l, i, str, bool, paramList));
  }
  
  protected QParsePBMsgElemsDefaultTextElem a(StringBuilder paramStringBuilder1, long paramLong, MessageInfo paramMessageInfo, ArrayList<AtTroopMemberInfo> paramArrayList, AtTroopMemberInfo paramAtTroopMemberInfo1, AtTroopMemberInfo paramAtTroopMemberInfo2, byte[] paramArrayOfByte, StringBuilder paramStringBuilder2, boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    return new MessagePBElemDecoder.ParsePBMsgElemsDefaultTextElem(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStringBuilder1, paramLong, paramMessageInfo, paramArrayList, paramAtTroopMemberInfo1, paramAtTroopMemberInfo2, paramArrayOfByte, paramStringBuilder2, paramBoolean, paramElem);
  }
  
  public String a(List<im_msg_body.Elem> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    StringBuilder localStringBuilder2 = new StringBuilder("<---decodePbElems:");
    int m = paramList.size();
    int k = 0;
    int i;
    for (int j = 0; k < m; j = i)
    {
      Object localObject2 = (im_msg_body.Elem)paramList.get(k);
      if (((im_msg_body.Elem)localObject2).text.has()) {
        if (j != 0) {
          i = 0;
        }
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:Text;\n");
        }
        localStringBuilder1.length();
        Object localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject2).text.get();
        i = j;
        if (((im_msg_body.Text)localObject1).str.has())
        {
          localStringBuilder1.append(MessageUtils.a(((im_msg_body.Text)localObject1).str.get().toStringUtf8(), false));
          i = j;
          continue;
          if (((im_msg_body.Elem)localObject2).face.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder2.append("elemType:Face;\n");
            }
            i = j;
            if (((im_msg_body.Face)((im_msg_body.Elem)localObject2).face.get()).index.has())
            {
              int n = QQSysFaceUtil.convertToLocal(((im_msg_body.Face)((im_msg_body.Elem)localObject2).face.get()).index.get());
              i = j;
              if (n >= 0)
              {
                localStringBuilder1.append('\024');
                localStringBuilder1.append((char)n);
                i = j;
              }
            }
          }
          else if (((im_msg_body.Elem)localObject2).small_emoji.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder2.append("elemType:small_emoji;\n");
            }
            i = j;
            if (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.has())
            {
              i = (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
              j = ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.get() & 0xFFFF;
              localObject1 = EmosmUtils.b(i, j);
              if ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).imageType.get() & 0xFFFF) == 2))
              {
                localObject1[3] = 511;
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("get apng epid = ");
                  ((StringBuilder)localObject2).append(i);
                  ((StringBuilder)localObject2).append(" eid = ");
                  ((StringBuilder)localObject2).append(j);
                  QLog.d("DecodeMsg", 2, ((StringBuilder)localObject2).toString());
                }
              }
              localStringBuilder1.append('\024');
              localStringBuilder1.append(localObject1[3]);
              localStringBuilder1.append(localObject1[2]);
              localStringBuilder1.append(localObject1[1]);
              localStringBuilder1.append(localObject1[0]);
              i = 1;
            }
          }
          else
          {
            i = j;
            if (((im_msg_body.Elem)localObject2).common_elem.has())
            {
              i = j;
              if (33 == ((im_msg_body.Elem)localObject2).common_elem.uint32_service_type.get())
              {
                if (QLog.isColorLevel()) {
                  localStringBuilder2.append("elemType:NewSysFaceMsg;\n");
                }
                localStringBuilder1.append(a((im_msg_body.CommonElem)((im_msg_body.Elem)localObject2).common_elem.get()));
                i = j;
              }
            }
          }
        }
      }
      k += 1;
    }
    return localStringBuilder1.toString();
  }
  
  public String a(im_msg_body.CommonElem paramCommonElem)
  {
    if ((paramCommonElem != null) && (paramCommonElem.bytes_pb_elem.has())) {
      try
      {
        hummer_commelem.MsgElemInfo_servtype33 localMsgElemInfo_servtype33 = new hummer_commelem.MsgElemInfo_servtype33();
        localMsgElemInfo_servtype33.mergeFrom(paramCommonElem.bytes_pb_elem.get().toByteArray());
        if (localMsgElemInfo_servtype33.bytes_text.has()) {
          localMsgElemInfo_servtype33.bytes_text.get().toStringUtf8();
        }
        int i = QQSysFaceUtil.convertToLocal(localMsgElemInfo_servtype33.uint32_index.get());
        if (i >= 0)
        {
          paramCommonElem = QQSysFaceUtil.getFaceString(i);
          return paramCommonElem;
        }
      }
      catch (InvalidProtocolBufferMicroException paramCommonElem)
      {
        paramCommonElem.printStackTrace();
      }
    }
    return "";
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject2 = paramList.iterator();
    Object localObject1 = null;
    while (((Iterator)localObject2).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (localElem.market_trans.has()) {
        localObject1 = (im_msg_body.MarketTrans)localElem.market_trans.get();
      }
    }
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketTrans;\n");
    }
    int i = ((im_msg_body.MarketTrans)localObject1).int32_flag.get();
    localObject1 = StructMsgFactory.a(((im_msg_body.MarketTrans)localObject1).bytes_xml.get().toByteArray(), i);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
      }
      a(paramList, paramList1, true);
      return;
    }
    paramStringBuilder = paramList.iterator();
    while (paramStringBuilder.hasNext())
    {
      localObject2 = (im_msg_body.Elem)paramStringBuilder.next();
      if ((((im_msg_body.Elem)localObject2).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.has())) {
        ((AbsStructMsg)localObject1).msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.get();
      }
    }
    paramList = a(paramList, paramList1, false);
    if (paramList != null) {
      ((AbsStructMsg)localObject1).mCompatibleText = paramList;
    }
    paramList = (MessageForStructing)MessageRecordFactory.a(-2011);
    paramList.msgtype = -2011;
    paramList.msg = "MarketTrans";
    paramList.structingMsg = ((AbsStructMsg)localObject1);
    paramList.msgData = paramList.structingMsg.getBytes();
    paramList1.add(paramList);
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    im_msg_body.TransElem localTransElem = a(paramList);
    im_msg_body.GeneralFlags localGeneralFlags = c(paramList);
    if (localTransElem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:TransElemInfo;\n");
    }
    int i = localTransElem.elem_type.get();
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("transElemType:");
      paramStringBuilder.append(i);
      paramStringBuilder.append(";\n");
    }
    byte[] arrayOfByte = localTransElem.elem_value.get().toByteArray();
    if (arrayOfByte.length == 0)
    {
      paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
      return;
    }
    a(paramList, paramList1, paramMsg, localTransElem, localGeneralFlags, i, arrayOfByte);
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    im_msg_body.CommonElem localCommonElem = a(paramList);
    String str = a(paramList);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodePBMsgElems_FlashChat  common_lem");
      ((StringBuilder)localObject).append(localCommonElem);
      ((StringBuilder)localObject).append(", text ");
      ((StringBuilder)localObject).append(str);
      QLog.d("DecodeMsg", 2, ((StringBuilder)localObject).toString());
    }
    if (localCommonElem == null) {
      return;
    }
    int i = a(localCommonElem);
    Object localObject = new hummer_commelem.MsgElemInfo_servtype14();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype14)localObject).mergeFrom(localCommonElem.bytes_pb_elem.get().toByteArray());
      a(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo, str, i, (hummer_commelem.MsgElemInfo_servtype14)localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  protected void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, im_msg_body.GeneralFlags paramGeneralFlags, boolean paramBoolean, MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      return;
    }
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if (paramMessageRecord.structingMsg == null)
    {
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
      }
      h(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
      return;
    }
    paramStringBuilder = null;
    int j = 0;
    paramList = paramStringBuilder;
    int i = j;
    if (paramGeneralFlags != null)
    {
      paramList = paramStringBuilder;
      i = j;
      if (!paramGeneralFlags.bytes_pb_reserve.has()) {}
    }
    for (;;)
    {
      try
      {
        paramMsg = new generalflags.ResvAttr();
        paramMsg.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if ((!paramMsg.bytes_kpl_info.has()) || (!paramMsg.bytes_kpl_info.has())) {
          break label533;
        }
        i = 1;
        paramList = paramMsg.bytes_kpl_info.get().toStringUtf8();
        if (paramMsg.bytes_oac_msg_extend.has()) {
          paramMessageRecord.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", paramMsg.bytes_oac_msg_extend.get().toStringUtf8());
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
        }
        paramList.printStackTrace();
        i = j;
        paramList = paramStringBuilder;
      }
      if (i != 0)
      {
        paramMessageRecord.saveExtInfoToExtStr("msg_ext_key", "Y");
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "resv a kpl struct message !");
        }
        KplHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
      }
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg need to pull longtextmsg!");
        }
        try
        {
          if ((paramMessageRecord.structingMsg instanceof AbsShareMsg))
          {
            paramList = (ChatMessage)MessageRecordFactory.a(-1051);
            paramList.saveExtInfoToExtStr("long_text_recv_state", "3");
            paramList.saveExtInfoToExtStr("long_text_msg_resid", paramMessageRecord.structingMsg.mResid);
            paramStringBuilder = ((AbsShareMsg)paramMessageRecord.structingMsg).getStructMsgItemLists();
            if (paramStringBuilder != null)
            {
              paramStringBuilder = paramStringBuilder.iterator();
              for (;;)
              {
                if (!paramStringBuilder.hasNext()) {
                  break label479;
                }
                paramMsg = (AbsStructMsgElement)paramStringBuilder.next();
                if ((paramMsg instanceof AbsStructMsgItem))
                {
                  paramMsg = ((AbsStructMsgItem)paramMsg).jdField_a_of_type_JavaUtilArrayList;
                  if (paramMsg != null)
                  {
                    paramMsg = paramMsg.iterator();
                    if (paramMsg.hasNext())
                    {
                      paramMessageInfo = (AbsStructMsgElement)paramMsg.next();
                      if (!(paramMessageInfo instanceof StructMsgItemTitle)) {
                        break;
                      }
                      paramList.msg = ((StructMsgItemTitle)paramMessageInfo).b();
                      if (QLog.isDevelopLevel())
                      {
                        paramMsg = new StringBuilder();
                        paramMsg.append("longtextmsg getMsg from structMsg msg:");
                        paramMsg.append(paramList.msg);
                        QLog.d("DecodeMsg", 2, paramMsg.toString());
                      }
                    }
                  }
                }
              }
            }
            label479:
            paramList1.add(paramList);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "absShareMsg is null");
          }
        }
        catch (Exception paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "failed to pull longtextmsg exception!", paramList);
          }
        }
      }
      paramList1.add(paramMessageRecord);
      return;
      label533:
      paramList = null;
      i = 0;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    Iterator localIterator = paramList.iterator();
    Object localObject = null;
    int i = 0;
    paramList = localObject;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label370;
      }
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.market_face.has())
      {
        if (!localArrayList.isEmpty())
        {
          b(localArrayList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo, paramBoolean);
          localArrayList.clear();
        }
        paramList = a(localElem, paramList1, paramStringBuilder, ((im_msg_body.Attr)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).attr.get()).time.get());
        i = 1;
      }
      else
      {
        if ((i != 0) && (localElem.text.has()) && (paramList != null))
        {
          paramList.faceName = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
          if ((paramList.faceName.charAt(0) == '[') && (paramList.faceName.charAt(paramList.faceName.length() - 1) == ']')) {
            paramList.faceName = paramList.faceName.substring(1, paramList.faceName.length() - 1);
          }
          try
          {
            i = paramList1.size();
            try
            {
              ((MessageRecord)paramList1.get(i - 1)).msgData = MessagePkgUtils.a(paramList);
            }
            catch (Exception localException1) {}
            QLog.e("MessageForMarketFace", 1, "decodePBMsgElems_MarketFace: ", localException2);
          }
          catch (Exception localException2) {}
          List<im_msg_body.Elem> localList = paramList;
          if (!QLog.isColorLevel()) {
            break;
          }
          paramStringBuilder.append("filter the text expalin:");
          paramStringBuilder.append(((im_msg_body.Text)localElem.text.get()).str.get());
          paramStringBuilder.append("\n");
          localList = paramList;
          break;
        }
        localArrayList.add(localElem);
      }
    }
    label370:
    if (!localArrayList.isEmpty())
    {
      b(localArrayList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo, paramBoolean);
      localArrayList.clear();
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (im_msg_body.Elem)localIterator.next();
      if (paramList.hc_flash_pic.has()) {
        break label44;
      }
    }
    paramList = null;
    label44:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:FlashPic;\n");
    }
    a(paramList, null, paramList1, paramStringBuilder, paramMsg, paramBoolean);
  }
  
  public void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
      if (paramStringBuilder.common_elem.has())
      {
        paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();
        break label52;
      }
    }
    paramList = null;
    label52:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "QQ 18 Parse msg found common_lem elemType = UpdateStrangerAvatar;\n");
    }
    paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype13();
    try
    {
      paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      if ((paramStringBuilder.uint32_sys_head_id.has()) && (paramStringBuilder.uint32_head_flag.has()))
      {
        int i = paramStringBuilder.uint32_sys_head_id.get();
        int j = paramStringBuilder.uint32_head_flag.get();
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("QQ 18 elemType:UpdateStrangerAvatar system id = ");
          paramList.append(i);
          paramList.append(", headType = ");
          paramList.append(j);
          QLog.d("DecodeMsg", 2, paramList.toString());
        }
        long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        paramList = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
        if ((paramList != null) && (paramList.a()))
        {
          paramList.a(String.valueOf(l), i, j);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    a(paramElem, paramCustomFace, paramList, paramStringBuilder, paramMsg, paramBoolean, null);
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    boolean bool1 = a(paramElem);
    boolean bool2 = a(paramCustomFace);
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("elemType:CustomFace: isC2C:");
      paramStringBuilder.append(paramBoolean);
      paramStringBuilder.append(";\n");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (a(paramMsg, paramBoolean, localStringBuilder)) {
      return;
    }
    a(paramList, bool1, bool2, localStringBuilder);
    im_msg_body.CustomFace localCustomFace = a(paramElem, paramCustomFace, bool1);
    if (QLog.isColorLevel())
    {
      paramElem = new StringBuilder();
      paramElem.append("parsePBMsgElemsCustomFace hasComFlashPic=");
      paramElem.append(bool2);
      QLog.d("flash", 2, paramElem.toString());
    }
    if (localCustomFace == null)
    {
      QLog.d("DecodeMsg", 2, "parsePBMsgElemsCustomFace customface is null");
      return;
    }
    String str1 = localCustomFace.str_file_path.get();
    paramCustomFace = localCustomFace.str_big_url.get();
    String str2 = localCustomFace.str_orig_url.get();
    paramElem = localCustomFace.str_thumb_url.get();
    String str3 = localCustomFace.str_400_url.get();
    int m = localCustomFace.uint32_thumb_width.get();
    int n = localCustomFace.uint32_thumb_height.get();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[CustomFace] ThumbWidth=");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(",ThumbHeight=");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append("downURLBigThum400=");
      ((StringBuilder)localObject1).append(str3);
      QLog.d("DecodeMsg", 2, ((StringBuilder)localObject1).toString());
    }
    int j = localCustomFace.uint32_show_len.get();
    int i = localCustomFace.uint32_download_len.get();
    long l1 = localCustomFace.uint32_file_id.get();
    long l2 = localCustomFace.uint32_size.get() & 0xFFFFFFFF;
    int k = localCustomFace.image_type.get();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[CustomFace] uint32_size=");
      ((StringBuilder)localObject1).append(l2);
      QLog.d("DecodeMsg", 2, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[CustomFace] imgType=");
      ((StringBuilder)localObject1).append(k);
      QLog.d("DecodeMsg", 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MessageProtoCodec.decodePBMsgElems(): showLen ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", downloadLen ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", fileLen ");
      ((StringBuilder)localObject1).append(l2);
      QLog.d("peak_pgjpeg", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = localCustomFace.bytes_md5.get().toByteArray();
    Object localObject1 = localCustomFace.bytes_signature.get().toByteArray();
    Object localObject3 = localCustomFace.bytes_flag.get().toByteArray();
    int i1 = (int)(localCustomFace.uint32_width.get() & 0xFFFFFFFF);
    int i2 = (int)(localCustomFace.uint32_height.get() & 0xFFFFFFFF);
    localObject2 = HexUtil.bytes2HexStr((byte[])localObject2);
    HexUtil.bytes2HexStr((byte[])localObject1);
    HexUtil.bytes2HexStr((byte[])localObject3);
    int i3 = localCustomFace.uint32_origin.get();
    localObject3 = TransfileUtile.makeTransFileProtocolData(str1, 0L, 1, false, str1, (String)localObject2, "picplatform", paramElem, str3, paramCustomFace, str2, i3, 0);
    localObject1 = new RichMsg.PicRec();
    ((RichMsg.PicRec)localObject1).localPath.set(str1);
    ((RichMsg.PicRec)localObject1).size.set(l2);
    PBUInt32Field localPBUInt32Field = ((RichMsg.PicRec)localObject1).type;
    paramBoolean = true;
    localPBUInt32Field.set(1);
    ((RichMsg.PicRec)localObject1).isRead.set(false);
    ((RichMsg.PicRec)localObject1).uuid.set(str1);
    ((RichMsg.PicRec)localObject1).groupFileID.set(l1 & 0xFFFFFFFF);
    if (localObject2 != null) {
      ((RichMsg.PicRec)localObject1).md5.set((String)localObject2);
    }
    ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
    ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(paramElem);
    ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str3);
    ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(m);
    ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(n);
    ((RichMsg.PicRec)localObject1).uint32_width.set(i1);
    ((RichMsg.PicRec)localObject1).uint32_height.set(i2);
    ((RichMsg.PicRec)localObject1).bigMsgUrl.set(paramCustomFace);
    ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str2);
    ((RichMsg.PicRec)localObject1).fileSizeFlag.set(0);
    ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
    ((RichMsg.PicRec)localObject1).version.set(5);
    ((RichMsg.PicRec)localObject1).isReport.set(0);
    ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i3);
    if (i3 == 1)
    {
      if (QLog.isColorLevel())
      {
        paramElem = new StringBuilder();
        paramElem.append("[customFace] showLen =");
        paramElem.append(j);
        paramElem.append(",downloadLen = ");
        paramElem.append(i);
        paramElem.append(",raw photo msg,clear progressjpg info!");
        QLog.d("DecodeMsg", 2, paramElem.toString());
      }
      j = 0;
      i = 0;
    }
    ((RichMsg.PicRec)localObject1).uint32_show_len.set(j);
    ((RichMsg.PicRec)localObject1).uint32_download_len.set(i);
    ((RichMsg.PicRec)localObject1).enableEnc.set(true);
    ((RichMsg.PicRec)localObject1).uint32_image_type.set(k);
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("protocolStr:");
      paramStringBuilder.append((String)localObject3);
      paramStringBuilder.append("\n");
    }
    if (localCustomFace.bytes_pb_reserve.has()) {
      ((RichMsg.PicRec)localObject1).bytes_pb_reserved.set(localCustomFace.bytes_pb_reserve.get());
    }
    paramElem = null;
    if (localCustomFace.bytes_pb_reserve.has())
    {
      paramCustomFace = a(localCustomFace);
      paramElem = paramCustomFace;
      if (paramCustomFace.msg_image_show.has())
      {
        paramElem = paramCustomFace;
        break label1079;
      }
    }
    paramBoolean = false;
    label1079:
    paramCustomFace = this;
    paramElem = paramCustomFace.a(paramMsg, paramBoolean, paramElem);
    paramCustomFace.a(bool1, bool2, paramElem);
    if (paramMessageInfo != null) {
      paramElem.istroop = paramMessageInfo.jdField_a_of_type_Int;
    }
    paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
    paramElem.parse();
    paramList.add(paramElem);
    localStringBuilder.delete(0, localStringBuilder.length());
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject3 = null;
    Object localObject1 = null;
    paramList = localObject1;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject3;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject4 = (im_msg_body.Elem)localIterator.next();
      if (((im_msg_body.Elem)localObject4).deliver_gift_msg.has())
      {
        localObject2 = localObject4;
        break;
      }
      localObject2 = localObject1;
      if (((im_msg_body.Elem)localObject4).pub_group.has()) {
        localObject2 = ((im_msg_body.Elem)localObject4).pub_group.bytes_nickname.get().toStringUtf8();
      }
      localObject1 = localObject2;
      if (((im_msg_body.Elem)localObject4).text.has())
      {
        localObject4 = ((im_msg_body.Text)((im_msg_body.Elem)localObject4).text.get()).str.get().toStringUtf8();
        localObject1 = localObject2;
        if (((String)localObject4).startsWith("@"))
        {
          paramList = ((String)localObject4).substring(1);
          localObject1 = localObject2;
        }
      }
    }
    if (localObject2 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:GiftMsg;\n");
    }
    paramList = a(localObject1, paramList, ((im_msg_body.Elem)localObject2).deliver_gift_msg, paramList1, paramStringBuilder, paramMsg);
    paramList1 = new Intent("tencent.video.q2v.VideoSendGift");
    paramList1.putExtra("data", ((im_msg_body.Elem)localObject2).deliver_gift_msg.toByteArray());
    paramList1.putExtra("troopUin", paramList.grayTipsEntity.troopUin);
    paramList1.putExtra("shmsgSeq", paramMsg.msg_head.msg_seq.get());
    paramList1.putExtra("senderName", paramList.senderName);
    paramList1.putExtra("rcvName", paramList.rcvName);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramList1);
    return true;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() == paramMsg.msg_head.to_uin.get())
      {
        paramMessageInfo = new StringBuilder();
        paramMessageInfo.append(paramMsg.msg_head.from_uin.get());
        paramMessageInfo.append("");
        paramMessageInfo = paramMessageInfo.toString();
      }
      else
      {
        paramMessageInfo = new StringBuilder();
        paramMessageInfo.append(paramMsg.msg_head.to_uin.get());
        paramMessageInfo.append("");
        paramMessageInfo = paramMessageInfo.toString();
      }
    }
    else if (paramMessageInfo != null)
    {
      paramMessageInfo = paramMessageInfo.jdField_a_of_type_JavaLangString;
    }
    else
    {
      paramMessageInfo = new StringBuilder();
      paramMessageInfo.append(paramMsg.msg_head.to_uin.get());
      paramMessageInfo.append("");
      paramMessageInfo = paramMessageInfo.toString();
    }
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      localObject2 = localObject3;
      if (localElem.pub_group.has()) {
        localObject2 = localElem.pub_group.bytes_nickname.get().toStringUtf8();
      }
      Object localObject4 = localObject1;
      if (localElem.text.has())
      {
        localObject3 = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
        localObject4 = localObject1;
        if (localObject3 != null)
        {
          localObject4 = localObject1;
          if (((String)localObject3).startsWith("@")) {
            localObject4 = ((String)localObject3).substring(1);
          }
        }
      }
      localObject3 = localObject2;
      localObject1 = localObject4;
      if (localElem.common_elem.has())
      {
        paramList = localElem.common_elem;
        localObject3 = localObject2;
        localObject1 = localObject4;
      }
    }
    if (paramList == null) {
      return false;
    }
    Object localObject2 = new hummer_commelem.MsgElemInfo_servtype8();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype8)localObject2).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GiftMsg;\n");
      }
      paramList = a((String)localObject3, localObject1, ((hummer_commelem.MsgElemInfo_servtype8)localObject2).wifi_deliver_gift_msg, paramList1, paramStringBuilder, paramMsg);
      paramList.frienduin = paramMessageInfo;
      paramList.isFromNearby = true;
      paramList1 = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (paramList1 != null) {
        paramList1.b(paramList);
      }
      return true;
    }
    catch (InvalidProtocolBufferMicroException paramList) {}
    return false;
  }
  
  protected boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, msg_comm.Msg paramMsg, im_msg_body.GeneralFlags paramGeneralFlags, im_msg_body.Text paramText, byte[] paramArrayOfByte, long paramLong1, MessageRecord paramMessageRecord, long paramLong2, int paramInt)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      return false;
    }
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if (paramMessageRecord.structingMsg == null) {
      return false;
    }
    long l = paramLong1;
    if (a(paramList1, l, paramMessageRecord)) {
      return true;
    }
    a(paramGeneralFlags, paramMessageRecord, a(paramMsg));
    b(paramList, paramMessageRecord);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodePBMsgElems_RichMsg serviceId");
      localStringBuilder.append(paramMessageRecord.structingMsg.mMsgServiceID);
      QLog.d("DecodeMsg", 2, localStringBuilder.toString());
    }
    if (paramMessageRecord.structingMsg.mMsgServiceID == 37) {
      return true;
    }
    if (paramMessageRecord.structingMsg.mMsgServiceID == 499) {
      return a(paramList1, paramArrayOfByte, paramMessageRecord, paramLong2, paramInt);
    }
    if (paramMessageRecord.structingMsg.mMsgServiceID == 52)
    {
      l = a(paramList1, paramMsg, paramLong1, paramMessageRecord);
    }
    else if ((paramMessageRecord.structingMsg.mMsgServiceID == 80) && ((paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare)))
    {
      if (b(paramList1, paramText, paramMessageRecord)) {
        return true;
      }
    }
    else
    {
      if ((paramMessageRecord.structingMsg.mMsgServiceID == 118) && ((paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare))) {
        return a(paramList1, paramText, paramMessageRecord);
      }
      if ((paramMessageRecord.structingMsg.mMsgServiceID == 104) && ((paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare))) {
        return a(paramList1, paramGeneralFlags, paramText, paramMessageRecord, paramLong2);
      }
      if ((paramMessageRecord.structingMsg.mMsgServiceID == 90) && ((paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare))) {
        return a(paramList1, paramMessageRecord);
      }
      if (((paramMessageRecord.structingMsg.mMsgServiceID == 83) || (paramMessageRecord.structingMsg.mMsgServiceID == 108) || (paramMessageRecord.structingMsg.mMsgServiceID == 114) || (paramMessageRecord.structingMsg.mMsgServiceID == 116)) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mMsgActionData))) {
        b(paramMessageRecord);
      } else if (((paramMessageRecord.structingMsg.mMsgServiceID == 5) || (paramMessageRecord.structingMsg.mMsgServiceID == 137)) && ((paramMessageRecord.structingMsg instanceof StructMsgForImageShare))) {
        a(paramList, paramMessageRecord);
      } else if (paramMessageRecord.structingMsg.mMsgServiceID == 106) {
        a(paramMessageRecord);
      } else if (paramMessageRecord.structingMsg.mMsgServiceID == 126) {
        return a(paramList1, paramArrayOfByte, paramLong2, paramInt);
      }
    }
    a(l, paramMessageRecord);
    if (paramMessageRecord.structingMsg != null)
    {
      paramMessageRecord.structingMsg.mCompatibleText = a(paramList, paramList1, false);
      paramMessageRecord.msgData = paramMessageRecord.structingMsg.getBytes();
    }
    return false;
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (im_msg_body.Elem)paramList.next();
      if (((im_msg_body.Elem)localObject).tips_info.has())
      {
        paramList = (im_msg_body.TipsInfo)((im_msg_body.Elem)localObject).tips_info.get();
        break label55;
      }
    }
    paramList = null;
    label55:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:TipsInfo;\n");
    }
    Object localObject = (MessageForIncompatibleGrayTips)MessageRecordFactory.a(-5002);
    if (((MessageForIncompatibleGrayTips)localObject).parseTextXML(paramList.text.get()).booleanValue())
    {
      paramList1.add(localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("TipsInfo parse failed;\n");
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject3 = paramList.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (((im_msg_body.Elem)localObject4).common_elem.has()) {
        localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject4).common_elem.get();
      }
    }
    a(paramList);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("decodePBMsgElems_ArkBabyqReply  common_lem");
      ((StringBuilder)localObject3).append(localObject1);
      QLog.d("ArkBabyq", 2, ((StringBuilder)localObject3).toString());
    }
    if (localObject1 == null) {
      return;
    }
    localObject3 = new hummer_commelem.MsgElemInfo_servtype19();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype19)localObject3).mergeFrom(((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray());
      if (!ArkUtil.isDeviceSupportArkMsg())
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply is false, ignore msg.");
        return;
      }
      if (((hummer_commelem.MsgElemInfo_servtype19)localObject3).bytes_data.has())
      {
        ((hummer_commelem.MsgElemInfo_servtype19)localObject3).bytes_data.get().toStringUtf8();
        localObject3 = ((hummer_commelem.MsgElemInfo_servtype19)localObject3).bytes_data.get().toByteArray();
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          localObject3 = StructMsgUtils.a((byte[])localObject3, -1);
          if (localObject3 != null)
          {
            int i = localObject3.length;
            if (i <= 0) {}
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      label256:
      label279:
      boolean bool2;
      label348:
      paramList.printStackTrace();
    }
    try
    {
      localObject3 = new String((byte[])localObject3, "UTF-8");
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      break label256;
      bool1 = false;
      break label348;
    }
    QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply convert failed");
    break label279;
    QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply empty.");
    bool2 = false;
    localObject3 = a(paramList, paramList1, false);
    Object localObject4 = (MessageForArkBabyqReply)MessageRecordFactory.a(-5016);
    ((MessageForArkBabyqReply)localObject4).msgtype = -5016;
    if (localObject3 != null) {
      ((MessageForArkBabyqReply)localObject4).compatibleMsg = ((String)localObject3);
    }
    ((MessageForArkBabyqReply)localObject4).fromAppXml(localObject2);
    if (((im_msg_body.CommonElem)localObject1).uint32_business_type.get() != 2)
    {
      bool1 = true;
      ((MessageForArkBabyqReply)localObject4).showAsBabyq = bool1;
      ((MessageForArkBabyqReply)localObject4).msgData = ((MessageForArkBabyqReply)localObject4).toBytes();
      ((MessageForArkBabyqReply)localObject4).parse();
      if ((TextUtils.isEmpty(((MessageForArkBabyqReply)localObject4).babyqReplyText)) && (!((MessageForArkBabyqReply)localObject4).isFailed) && ((((MessageForArkBabyqReply)localObject4).mArkBabyqReplyCardList == null) || (((MessageForArkBabyqReply)localObject4).mArkBabyqReplyCardList.size() <= 0)))
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply not valid..");
        bool1 = bool2;
      }
      else
      {
        paramList1.add(localObject4);
        bool1 = true;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decodePBMsgElems_ArkBabyqReply hasArkBabyQMsg = ");
        ((StringBuilder)localObject1).append(bool1);
        QLog.d("ArkBabyq", 2, ((StringBuilder)localObject1).toString());
      }
      if (!bool1)
      {
        i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
        return;
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data empty.");
        return;
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data not exist.");
        return;
      }
      return;
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, boolean paramBoolean)
  {
    Object localObject2 = new StringBuilder("");
    ResultBox localResultBox = new ResultBox();
    ArrayList localArrayList = new ArrayList();
    int k = 2;
    Object localObject1 = new ArrayList(2);
    Iterator localIterator = paramList.iterator();
    int j = 0;
    im_msg_body.GeneralFlags localGeneralFlags = null;
    int i = 0;
    Object localObject3;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label445;
      }
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.custom_face.has())
      {
        localObject3 = localObject1;
        if (((StringBuilder)localObject2).length() > 0)
        {
          MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
          localMessageForText.msgtype = -1000;
          localMessageForText.msg = ((StringBuilder)localObject2).toString();
          localMessageForText.atInfoList = ((ArrayList)localObject1);
          localObject3 = new ArrayList(k);
          localArrayList.add(localMessageForText);
          ((StringBuilder)localObject2).delete(j, ((StringBuilder)localObject2).length());
        }
        a(localElem, null, localArrayList, paramStringBuilder, paramMsg, paramBoolean, paramMessageInfo);
        localObject1 = localObject3;
      }
      for (;;)
      {
        break label436;
        if (localElem.not_online_image.has())
        {
          if (((StringBuilder)localObject2).length() > 0)
          {
            localObject3 = (MessageForText)MessageRecordFactory.a(-1000);
            ((MessageForText)localObject3).msgtype = -1000;
            ((MessageForText)localObject3).msg = ((StringBuilder)localObject2).toString();
            ((MessageForText)localObject3).atInfoList = ((ArrayList)localObject1);
            localObject1 = new ArrayList(k);
            localArrayList.add(localObject3);
            ((StringBuilder)localObject2).delete(j, ((StringBuilder)localObject2).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg);
        }
        else
        {
          if (TextElemDecoder.a(localElem).booleanValue())
          {
            if (i != 0) {
              break;
            }
            if (localElem.small_emoji.has()) {
              i = 1;
            }
            localObject3 = new ArrayList();
            ((List)localObject3).add(localElem);
            localObject3 = a((StringBuilder)localObject2, (List)localObject3, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), paramMessageInfo, localResultBox, (ArrayList)localObject1);
            j = i;
            break label428;
          }
          localObject3 = localObject2;
          j = i;
          if (localElem.general_flags.has())
          {
            localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
          }
          else
          {
            label428:
            i = j;
            localObject2 = localObject3;
          }
        }
      }
      label436:
      j = 0;
      k = 2;
    }
    label445:
    if (((StringBuilder)localObject2).length() > 0)
    {
      localObject3 = (MessageForText)MessageRecordFactory.a(-1000);
      ((MessageForText)localObject3).msgtype = -1000;
      ((MessageForText)localObject3).msg = ((StringBuilder)localObject2).toString();
      ((MessageForText)localObject3).atInfoList = ((ArrayList)localObject1);
      if (paramMessageInfo != null) {
        AtTroopMemberSpan.a(paramMessageInfo.jdField_a_of_type_Int, (ArrayList)localObject1, (ChatMessage)localObject3);
      }
      localArrayList.add(localObject3);
      ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
    }
    localObject2 = localResultBox.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() == 2))
    {
      if (((ArrayList)localObject2).get(0) != null) {
        localObject1 = (AtTroopMemberInfo)((ArrayList)localObject2).get(0);
      } else {
        localObject1 = null;
      }
      if (((ArrayList)localObject2).get(1) != null)
      {
        localObject3 = (byte[])((ArrayList)localObject2).get(1);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        localObject2 = localObject1;
        localObject1 = null;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
    }
    a(paramList, paramStringBuilder, (AtTroopMemberInfo)localObject2, localArrayList, localResultBox, paramMessageInfo);
    a(localGeneralFlags, localArrayList);
    b(localGeneralFlags, localArrayList);
    a(localArrayList, paramMsg, paramList1, (byte[])localObject1, paramMessageInfo, (AtTroopMemberInfo)localObject2);
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (im_msg_body.Elem)paramList.next();
      if (((im_msg_body.Elem)localObject).common_elem.has())
      {
        paramList = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();
        break label55;
      }
    }
    paramList = null;
    label55:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodePBMsgElems_FlashPicCommen isC2C=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("flash", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("ELEM_FlashPicCommen;\n");
    }
    Object localObject = new hummer_commelem.MsgElemInfo_servtype3();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype3)localObject).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      if (!paramBoolean)
      {
        if (((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.has()) {
          a(null, (im_msg_body.CustomFace)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.get(), paramList1, paramStringBuilder, paramMsg, paramBoolean);
        }
      }
      else if (((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.has())
      {
        a(null, (im_msg_body.NotOnlineImage)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.get(), paramList1, paramStringBuilder, paramMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if (localElem.common_elem.has())
      {
        paramList = (im_msg_body.CommonElem)localElem.common_elem.get();
        break label55;
      }
    }
    paramList = null;
    label55:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:QQStoryComment;\n");
    }
    paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype5();
    try
    {
      paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      paramList = (MessageForQQStoryComment)MessageRecordFactory.a(-2052);
      paramList.vid = paramStringBuilder.vid.get().toStringUtf8();
      paramList.comment = paramStringBuilder.comment_content.get().toStringUtf8();
      paramList.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
      paramList.title = paramStringBuilder.title.get().toStringUtf8();
      paramList.summary = paramStringBuilder.summary.get().toStringUtf8();
      paramList.createTime = paramStringBuilder.createTime.get();
      paramList.author = paramStringBuilder.author.get();
      paramList.prewrite();
      paramList1.add(paramList);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    Object localObject2 = localObject1;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      Object localObject3 = localObject4;
      if (localElem.ark_app.has()) {
        localObject3 = (im_msg_body.ArkAppElem)localElem.ark_app.get();
      }
      Object localObject5 = localObject1;
      if (localElem.light_app.has()) {
        localObject5 = (im_msg_body.LightAppElem)localElem.light_app.get();
      }
      localObject4 = localObject3;
      localObject1 = localObject5;
      if (localElem.general_flags.has())
      {
        localObject2 = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        localObject4 = localObject3;
        localObject1 = localObject5;
      }
    }
    paramStringBuilder.append("elemType:ArkApp/LightApp;\n");
    if (!ArkUtil.isDeviceSupportArkMsg())
    {
      QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isDeviceSupportArkMsg is false, ignore msg.");
      if (a(paramList).booleanValue())
      {
        i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
        return;
      }
      paramList = (MessageForText)MessageRecordFactory.a(-1000);
      paramList.msgtype = -1000;
      paramList.msg = BaseApplication.getContext().getString(2131693632);
      paramList1.add(paramList);
      return;
    }
    if (((IArkConfig)QRoute.api(IArkConfig.class)).isPANonShow())
    {
      QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isPANonShow is true, ignore msg.");
      return;
    }
    if (localObject4 != null)
    {
      if (!localObject4.bytes_data.has())
      {
        QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data not exist.");
        return;
      }
      localObject1 = localObject4.bytes_data.get().toByteArray();
    }
    else if (localObject1 != null)
    {
      if (!((im_msg_body.LightAppElem)localObject1).bytes_data.has())
      {
        QLog.i("ArkApp", 1, "decode msg, light_app.bytes_data not exist.");
        return;
      }
      localObject1 = ((im_msg_body.LightAppElem)localObject1).bytes_data.get().toByteArray();
    }
    else
    {
      localObject1 = null;
    }
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = StructMsgUtils.a((byte[])localObject1, -1);
      if ((localObject1 == null) || (localObject1.length <= 0)) {}
    }
    try
    {
      localObject1 = new String((byte[])localObject1, "UTF-8");
    }
    catch (Exception localException)
    {
      label396:
      break label396;
    }
    QLog.i("ArkApp", 1, "decode msg, raw data cannot convert to string.");
    localObject1 = localObject6;
    break label427;
    QLog.i("ArkApp", 1, "decode msg, raw data is empty.");
    localObject1 = localObject6;
    label427:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.i("ArkApp", 1, "decode msg, ark data is empty.");
      return;
    }
    a((im_msg_body.GeneralFlags)localObject2, false, (String)localObject1, paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    return;
    QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data is empty.");
  }
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if (localElem.common_elem.has())
      {
        paramList = (im_msg_body.CommonElem)localElem.common_elem.get();
        break label55;
      }
    }
    paramList = null;
    label55:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:TroopStoryComment;\n");
    }
    paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype15();
    try
    {
      paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      paramList = (MessageForQQStoryComment)MessageRecordFactory.a(-2052);
      paramList.vid = paramStringBuilder.vid.get().toStringUtf8();
      paramList.comment = paramStringBuilder.comment_content.get().toStringUtf8();
      paramList.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
      paramList.title = paramStringBuilder.title.get().toStringUtf8();
      paramList.summary = paramStringBuilder.summary.get().toStringUtf8();
      paramList.createTime = paramStringBuilder.createTime.get();
      paramList.author = paramStringBuilder.author.get();
      paramList.ctrVersion = paramStringBuilder.ctr_version.get();
      if (paramList.ctrVersion <= 1)
      {
        paramList.prewrite();
        paramList1.add(paramList);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  /* Error */
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 41 1 0
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 7
    //   14: aload 9
    //   16: invokeinterface 47 1 0
    //   21: ifeq +42 -> 63
    //   24: aload 9
    //   26: invokeinterface 51 1 0
    //   31: checkcast 53	tencent/im/msg/im_msg_body$Elem
    //   34: astore 10
    //   36: aload 10
    //   38: getfield 702	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   41: invokevirtual 703	tencent/im/msg/im_msg_body$CommonElem:has	()Z
    //   44: ifeq -30 -> 14
    //   47: aload 10
    //   49: getfield 702	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   52: invokevirtual 704	tencent/im/msg/im_msg_body$CommonElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   55: checkcast 111	tencent/im/msg/im_msg_body$CommonElem
    //   58: astore 7
    //   60: goto -46 -> 14
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 2786	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ljava/util/List;)Ljava/lang/String;
    //   68: pop
    //   69: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +41 -> 113
    //   75: new 184	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   82: astore 9
    //   84: aload 9
    //   86: ldc_w 3534
    //   89: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 9
    //   95: aload 7
    //   97: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc_w 3536
    //   104: iconst_2
    //   105: aload 9
    //   107: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload 7
    //   115: ifnonnull +4 -> 119
    //   118: return
    //   119: new 3538	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype20
    //   122: dup
    //   123: invokespecial 3539	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype20:<init>	()V
    //   126: astore 9
    //   128: aload 9
    //   130: aload 7
    //   132: getfield 2986	tencent/im/msg/im_msg_body$CommonElem:bytes_pb_elem	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   135: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   138: invokevirtual 82	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   141: invokevirtual 3540	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype20:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   144: pop
    //   145: invokestatic 1042	com/tencent/ark/open/ArkUtil:isDeviceSupportArkMsg	()Z
    //   148: ifne +14 -> 162
    //   151: ldc_w 3536
    //   154: iconst_1
    //   155: ldc_w 3542
    //   158: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: return
    //   162: aload 9
    //   164: getfield 3543	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype20:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   167: invokevirtual 69	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   170: ifeq +287 -> 457
    //   173: aload 9
    //   175: getfield 3543	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype20:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   178: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   181: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   184: pop
    //   185: aload 9
    //   187: getfield 3543	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype20:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   190: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   193: invokevirtual 82	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   196: astore 9
    //   198: aload 9
    //   200: ifnull +246 -> 446
    //   203: aload 9
    //   205: arraylength
    //   206: ifgt +6 -> 212
    //   209: goto +237 -> 446
    //   212: aload 9
    //   214: iconst_m1
    //   215: invokestatic 1057	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   218: astore 9
    //   220: aload 9
    //   222: ifnull +47 -> 269
    //   225: aload 9
    //   227: arraylength
    //   228: istore 6
    //   230: iload 6
    //   232: ifle +37 -> 269
    //   235: new 148	java/lang/String
    //   238: dup
    //   239: aload 9
    //   241: ldc_w 1059
    //   244: invokespecial 1062	java/lang/String:<init>	([BLjava/lang/String;)V
    //   247: astore 9
    //   249: aload 9
    //   251: astore 8
    //   253: goto +26 -> 279
    //   256: ldc_w 3536
    //   259: iconst_1
    //   260: ldc_w 3545
    //   263: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: goto +13 -> 279
    //   269: ldc_w 3536
    //   272: iconst_1
    //   273: ldc_w 3547
    //   276: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: iconst_0
    //   280: istore 6
    //   282: aload_0
    //   283: aload_1
    //   284: aload_2
    //   285: iconst_0
    //   286: invokevirtual 1912	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ljava/util/List;Ljava/util/List;Z)Ljava/lang/String;
    //   289: astore 10
    //   291: sipush -5017
    //   294: invokestatic 352	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   297: checkcast 1914	com/tencent/mobileqq/data/MessageForArkApp
    //   300: astore 9
    //   302: aload 9
    //   304: sipush -5017
    //   307: putfield 1915	com/tencent/mobileqq/data/MessageForArkApp:msgtype	I
    //   310: aload 7
    //   312: getfield 114	tencent/im/msg/im_msg_body$CommonElem:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   315: invokevirtual 96	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   318: iconst_1
    //   319: if_icmpne +13 -> 332
    //   322: aload 9
    //   324: getstatic 3551	com/tencent/mobileqq/service/message/MessageConstants:e	Ljava/lang/String;
    //   327: ldc 146
    //   329: invokevirtual 1919	com/tencent/mobileqq/data/MessageForArkApp:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload 10
    //   334: ifnull +10 -> 344
    //   337: aload 9
    //   339: aload 10
    //   341: putfield 1918	com/tencent/mobileqq/data/MessageForArkApp:compatibleMsg	Ljava/lang/String;
    //   344: new 1928	com/tencent/mobileqq/data/ArkAppMessage
    //   347: dup
    //   348: invokespecial 1929	com/tencent/mobileqq/data/ArkAppMessage:<init>	()V
    //   351: astore 7
    //   353: aload 7
    //   355: aload 8
    //   357: invokevirtual 1930	com/tencent/mobileqq/data/ArkAppMessage:fromAppXml	(Ljava/lang/String;)Z
    //   360: pop
    //   361: aload 9
    //   363: aload 7
    //   365: invokevirtual 1931	com/tencent/mobileqq/data/ArkAppMessage:toBytes	()[B
    //   368: putfield 1932	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   371: aload 9
    //   373: invokevirtual 1933	com/tencent/mobileqq/data/MessageForArkApp:parse	()V
    //   376: aload 9
    //   378: getfield 1936	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   381: getfield 1937	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   384: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifne +32 -> 419
    //   390: aload 9
    //   392: getfield 1936	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   395: getfield 1938	com/tencent/mobileqq/data/ArkAppMessage:appView	Ljava/lang/String;
    //   398: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifne +18 -> 419
    //   404: aload_2
    //   405: aload 9
    //   407: invokeinterface 240 2 0
    //   412: pop
    //   413: iconst_1
    //   414: istore 6
    //   416: goto +13 -> 429
    //   419: ldc_w 3553
    //   422: iconst_1
    //   423: ldc_w 1940
    //   426: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iload 6
    //   431: ifne +42 -> 473
    //   434: aload_0
    //   435: aload_1
    //   436: aload_2
    //   437: aload_3
    //   438: aload 4
    //   440: aload 5
    //   442: invokevirtual 1037	com/tencent/mobileqq/service/message/MessagePBElemDecoder:i	(Ljava/util/List;Ljava/util/List;Ljava/lang/StringBuilder;Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/troop/data/MessageInfo;)V
    //   445: return
    //   446: ldc_w 3536
    //   449: iconst_1
    //   450: ldc_w 3555
    //   453: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: return
    //   457: ldc_w 3536
    //   460: iconst_1
    //   461: ldc_w 3557
    //   464: invokestatic 200	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: return
    //   468: astore_1
    //   469: aload_1
    //   470: invokevirtual 697	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   473: return
    //   474: astore 9
    //   476: goto -220 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	MessagePBElemDecoder
    //   0	479	1	paramList	List<im_msg_body.Elem>
    //   0	479	2	paramList1	List<MessageRecord>
    //   0	479	3	paramStringBuilder	StringBuilder
    //   0	479	4	paramMsg	msg_comm.Msg
    //   0	479	5	paramMessageInfo	MessageInfo
    //   228	202	6	i	int
    //   12	352	7	localObject1	Object
    //   9	347	8	localObject2	Object
    //   6	400	9	localObject3	Object
    //   474	1	9	localException	Exception
    //   34	306	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   128	161	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   162	198	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	209	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   212	220	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   225	230	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   235	249	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   256	266	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   269	279	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   282	332	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   337	344	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   344	413	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   419	429	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   434	445	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   446	456	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   457	467	468	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   235	249	474	java/lang/Exception
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    paramList = null;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          localObject2 = localObject1;
          localObject3 = paramList;
          if (!localIterator.hasNext()) {
            break label116;
          }
          localObject2 = (im_msg_body.Elem)localIterator.next();
          if (!((im_msg_body.Elem)localObject2).common_elem.has()) {
            break;
          }
          localObject3 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject2).common_elem.get();
          paramList = (List<im_msg_body.Elem>)localObject3;
        } while (localObject1 == null);
        localObject2 = localObject1;
        break;
      } while (!((im_msg_body.Elem)localObject2).text.has());
      localObject2 = (im_msg_body.Text)((im_msg_body.Elem)localObject2).text.get();
      localObject1 = localObject2;
    } while (paramList == null);
    Object localObject3 = paramList;
    label116:
    if (localObject3 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:TroopStory;\n");
    }
    paramList = new hummer_commelem.MsgElemInfo_servtype16();
    try
    {
      paramList.mergeFrom(((im_msg_body.CommonElem)localObject3).bytes_pb_elem.get().toByteArray());
      int i = paramList.ctr_version.get();
      if (i > 1) {
        return;
      }
      paramStringBuilder = (MessageForTroopStory)MessageRecordFactory.a(-2057);
      paramStringBuilder.uid = paramList.uid.get();
      paramStringBuilder.unionId = paramList.unionID.get().toStringUtf8();
      paramStringBuilder.storyId = paramList.storyID.get().toStringUtf8();
      paramStringBuilder.md5 = paramList.md5.get().toStringUtf8();
      paramStringBuilder.thumbUrl = paramList.thumbUrl.get().toStringUtf8();
      paramStringBuilder.doodleUrl = paramList.doodleUrl.get().toStringUtf8();
      paramStringBuilder.videoWidth = paramList.videoWidth.get();
      paramStringBuilder.videoHeight = paramList.videoHeight.get();
      paramStringBuilder.sourceName = paramList.sourceName.get().toStringUtf8();
      paramStringBuilder.sourceActionType = paramList.sourceActionType.get().toStringUtf8();
      paramStringBuilder.sourceActionData = paramList.sourceActionData.get().toStringUtf8();
      if (localObject2 == null) {
        paramList = "";
      } else {
        paramList = ((im_msg_body.Text)localObject2).str.get().toStringUtf8();
      }
      paramStringBuilder.compatibleText = paramList;
      paramStringBuilder.ctrVersion = i;
      paramStringBuilder.msg = MessageForTroopStory.MSG_CONTENT;
      paramStringBuilder.serial();
      paramList1.add(paramStringBuilder);
      if (QLog.isDevelopLevel())
      {
        QLog.d("TroopStory", 4, paramStringBuilder.toDebugString());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    MessageForQQWalletMsg.decodePBMsgElemWalletMsg(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
  }
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeEmoMsg;\n");
    }
    paramStringBuilder = null;
    Object localObject = paramList.iterator();
    do
    {
      paramList = paramStringBuilder;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList.common_elem.has());
    paramList = (im_msg_body.CommonElem)paramList.common_elem.get();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeEmoMsg null commomElem!");
      }
      return;
    }
    paramStringBuilder = new MessageForPokeEmo();
    paramStringBuilder.msgtype = -5018;
    if (paramList.bytes_pb_elem.has())
    {
      localObject = new hummer_commelem.MsgElemInfo_servtype23();
      try
      {
        ((hummer_commelem.MsgElemInfo_servtype23)localObject).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        paramStringBuilder.pokeemoId = ((hummer_commelem.MsgElemInfo_servtype23)localObject).uint32_face_type.get();
        paramStringBuilder.pokeemoPressCount = ((hummer_commelem.MsgElemInfo_servtype23)localObject).uint32_face_bubble_count.get();
        paramStringBuilder.summary = ((hummer_commelem.MsgElemInfo_servtype23)localObject).bytes_face_summary.get().toStringUtf8();
        if (((hummer_commelem.MsgElemInfo_servtype23)localObject).msg_yellow_face.has())
        {
          paramStringBuilder.emoIndex = ((hummer_commelem.MsgElemInfo_servtype33)((hummer_commelem.MsgElemInfo_servtype23)localObject).msg_yellow_face.get()).uint32_index.get();
          paramList = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(paramStringBuilder.emoIndex)));
          paramStringBuilder.emoString = paramList;
          paramStringBuilder.emoCompat = paramList;
        }
        paramStringBuilder.initMsg();
      }
      catch (Exception paramList)
      {
        QLog.d("PokeEmoMsg", 1, "decodePBMsgElems_PokeEmoMsg exception!", paramList);
      }
    }
    paramList1.add(paramStringBuilder);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("decodePbElems, common_elem type 23, pokeemoId:");
      paramList.append(paramStringBuilder.pokeemoId);
      paramList.append(" ,pokeemoPressCount:");
      paramList.append(paramStringBuilder.pokeemoPressCount);
      QLog.d("PokeEmoMsg", 2, paramList.toString());
    }
  }
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = a(paramList);
    im_msg_body.GeneralFlags localGeneralFlags = b(paramList);
    if (localObject1 == null) {
      return;
    }
    long l = ((im_msg_body.GroupPubAccountInfo)localObject1).uint64_pub_account.get();
    localObject1 = null;
    MessageForPubAccount localMessageForPubAccount = (MessageForPubAccount)MessageRecordFactory.a(-3006);
    localMessageForPubAccount.msgtype = -3006;
    localMessageForPubAccount.associatePubAccUin = l;
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject2 = (im_msg_body.Elem)localIterator.next();
      Object localObject3;
      if ((((im_msg_body.Elem)localObject2).text.has()) && (((im_msg_body.Elem)localObject2).text.str.has()))
      {
        localMessageForPubAccount.msg = localStringBuilder.toString();
        localObject1 = new PAMessage();
        ((PAMessage)localObject1).msg = localStringBuilder.toString();
        localMessageForPubAccount.msgData = ((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(localObject1);
      }
      else if (((im_msg_body.Elem)localObject2).trans_elem_info.has())
      {
        localObject2 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject2).trans_elem_info.get();
        int i = ((im_msg_body.TransElem)localObject2).elem_type.get();
        localObject3 = ((im_msg_body.TransElem)localObject2).elem_value.get().toByteArray();
        if (i != 16)
        {
          paramStringBuilder.append("PubAccount Message type is not 16.\n");
        }
        else if ((localObject3 != null) && (localObject3.length != 0))
        {
          localObject2 = localObject1;
          if (localObject3[0] == 1)
          {
            int j = PkgTools.getShortData((byte[])localObject3, 1);
            i = localObject3[3];
            j -= 1;
            localObject2 = new byte[j];
            PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject3, 4, j);
            localObject3 = localObject2;
            if (i == 1) {
              localObject3 = a((byte[])localObject2);
            }
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject1;
            }
          }
        }
      }
      try
      {
        if (localObject3.length <= 0) {
          break label390;
        }
        localObject2 = new String((byte[])localObject3, "utf-8");
        localStringBuilder.append((String)localObject2);
        localObject2 = a((String)localObject2);
      }
      catch (Exception localException)
      {
        label378:
        break label378;
      }
      paramStringBuilder.append("PubAccount Message parse decodeContext.mPamag exception.\n");
      localObject2 = localObject1;
      label390:
      bool = true;
      a(localGeneralFlags, localMessageForPubAccount);
      localObject1 = localObject2;
      continue;
      paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
    }
    if (localObject1 != null)
    {
      a(paramList, (PAMessage)localObject1);
      localMessageForPubAccount.mPAMessage = ((PAMessage)localObject1);
      localMessageForPubAccount.msgData = ((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(localObject1);
    }
    a(paramMsg, l, bool);
    paramList1.add(localMessageForPubAccount);
    if (!bool) {
      i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
  }
  
  public void g(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    paramStringBuilder = a(paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), paramMessageInfo);
    paramMessageInfo = paramStringBuilder.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if (paramStringBuilder.jdField_a_of_type_JavaLangString != null)
    {
      paramList = (ChatMessage)MessageRecordFactory.a(-1049);
      paramList.msg = paramStringBuilder.jdField_a_of_type_JavaLangString;
      paramMsg = (MessageForReplyText)paramList;
      try
      {
        paramMsg.extLong |= 0x1;
        if (paramMessageInfo.getSourceMsg() != null)
        {
          paramMsg.setSourceMessageRecord(paramMessageInfo.unPackSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          if ((paramMsg.getSourceMessage() != null) && (FileManagerUtil.a(paramMsg.getSourceMessage())))
          {
            Object localObject2 = paramMsg.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
            localObject1 = FileManagerUtil.a((ChatMessage)paramMsg.getSourceMessage());
            QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, paramMsg.getSourceMessage());
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (localObject1 != null))
            {
              int i = Integer.parseInt((String)localObject2);
              if ((i == 1) || (i == 2))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("decode reply file msg, msg uniseq[");
                ((StringBuilder)localObject2).append(((MessageRecord)localObject1).uniseq);
                ((StringBuilder)localObject2).append("]");
                QLog.i("DecodeMsg<QFile>", 1, ((StringBuilder)localObject2).toString());
                FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, (ChatMessage)paramMsg.getSourceMessage());
              }
            }
          }
        }
        Object localObject1 = HexUtil.bytes2HexStr(MessagePkgUtils.a(paramMessageInfo));
        paramMsg.mSourceMsgInfo = paramMessageInfo;
        paramMsg.saveExtInfoToExtStr("sens_msg_source_msg_info", (String)localObject1);
        if (QLog.isColorLevel())
        {
          paramMessageInfo = new StringBuilder();
          paramMessageInfo.append("reply:");
          paramMessageInfo.append(paramMsg);
          paramMessageInfo.append(" sourceMsg=");
          paramMessageInfo.append(paramMsg.getSourceMessage());
          QLog.d("SendMsgBtn", 2, paramMessageInfo.toString());
        }
      }
      catch (Exception paramMsg)
      {
        if (QLog.isColorLevel())
        {
          paramMessageInfo = new StringBuilder();
          paramMessageInfo.append("Save sourceMsgInfo exception:");
          paramMessageInfo.append(paramMsg.getMessage());
          QLog.d("SendMsgBtn", 2, paramMessageInfo.toString());
        }
      }
      if (paramStringBuilder.jdField_a_of_type_ArrayOfByte != null) {
        paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(paramStringBuilder.jdField_a_of_type_ArrayOfByte));
      }
      paramList1.add(paramList);
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("reply msgRand = ");
        paramList1.append(MessageUtils.a(paramList.msgUid));
        paramList1.append(", msgUid = ");
        paramList1.append(paramList.msgUid);
        QLog.d("DecodeMsg", 2, paramList1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessagePBElemDecoder
 * JD-Core Version:    0.7.0.1
 */