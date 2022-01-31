package com.tencent.mobileqq.service.message;

import ahjj;
import ahjk;
import ahjl;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.biz.bmqq.protocol.Crm.GrayMsg;
import com.tencent.biz.bmqq.protocol.Crm.QidianGroupMsg;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
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
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.IAnimationMessage;
import com.tencent.mobileqq.troop.utils.TroopFileDataManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.GroupPostElemInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.util.QidianUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.Notification;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.WorkflowChangeNotification;
import com.trunk.Qworkflow.Qworkflow.WorkflowState;
import cooperation.dingdong.DingdongPluginManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.VideoFile;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.InteractGift;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ResvAttr;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype15;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype5;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype8;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.GroupPostElem;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletMsg;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TipsInfo;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.im_msg_body.VideoFile;
import tencent.im.msg.im_msg_body.WorkflowNotifyMsg;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;

public class MessagePBElemDecoder
{
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  
  public static MessageForQQWalletMsg a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 != null)
      {
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)MessageRecordFactory.a(-2025);
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.messageType = paramString1.getInt("msgType");
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = a(paramString1, paramString2);
        if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
          return null;
        }
        localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
        localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
        return localMessageForQQWalletMsg;
      }
    }
    catch (Exception paramString1)
    {
      return null;
    }
    return null;
  }
  
  public static MessageForVIPDonate a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DecodeMsg", 1, "content is empty ");
      localObject = null;
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "createVIPDonateMsg: msg = " + paramString);
    }
    JSONObject localJSONObject;
    VIPDonateMsg localVIPDonateMsg;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject == null) {
          break label423;
        }
        MessageForVIPDonate localMessageForVIPDonate = (MessageForVIPDonate)MessageRecordFactory.a(-2047);
        localMessageForVIPDonate.msgtype = -2047;
        localVIPDonateMsg = new VIPDonateMsg();
        if (localJSONObject.has("title"))
        {
          localObject = localJSONObject.getString("title");
          localVIPDonateMsg.title = ((String)localObject);
          if (!localJSONObject.has("footer")) {
            break label313;
          }
          localObject = localJSONObject.getString("footer");
          localVIPDonateMsg.footer = ((String)localObject);
          if (!paramBoolean) {
            break label333;
          }
          if (!localJSONObject.has("sendsubtitle")) {
            break label318;
          }
          localObject = localJSONObject.getString("sendsubtitle");
          localVIPDonateMsg.subTitle = ((String)localObject);
          if (!localJSONObject.has("sendurl")) {
            break label323;
          }
          localObject = localJSONObject.getString("sendurl");
          localVIPDonateMsg.jumpUrl = ((String)localObject);
          if (!localJSONObject.has("sendbrief")) {
            break label328;
          }
          localObject = localJSONObject.getString("sendbrief");
          localVIPDonateMsg.brief = ((String)localObject);
          localMessageForVIPDonate.donateMsg = localVIPDonateMsg;
          localMessageForVIPDonate.msg = localMessageForVIPDonate.getSummaryMsg();
          localMessageForVIPDonate.msgData = MessagePkgUtils.a(localVIPDonateMsg);
          localObject = localMessageForVIPDonate;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("vipdonateMsgparse", 2, "donateMsg = " + localMessageForVIPDonate.donateMsg);
          return localMessageForVIPDonate;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("DecodeMsg", 1, "vipdonate json error :json = " + paramString);
        return null;
      }
      str = null;
      continue;
      label313:
      str = null;
      continue;
      label318:
      str = null;
      continue;
      label323:
      str = null;
      continue;
      label328:
      str = null;
    }
    label333:
    if (localJSONObject.has("recvsubtitle"))
    {
      str = localJSONObject.getString("recvsubtitle");
      label351:
      localVIPDonateMsg.subTitle = str;
      if (!localJSONObject.has("recvurl")) {
        break label413;
      }
      str = localJSONObject.getString("recvurl");
      label375:
      localVIPDonateMsg.jumpUrl = str;
      if (!localJSONObject.has("recvbrief")) {
        break label418;
      }
    }
    label413:
    label418:
    for (String str = localJSONObject.getString("recvbrief");; str = null)
    {
      localVIPDonateMsg.brief = str;
      break;
      str = null;
      break label351;
      str = null;
      break label375;
    }
    label423:
    return null;
  }
  
  private static PAMessage a(String paramString)
  {
    paramString = PAMessageUtil.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static QQWalletRedPacketMsg a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      try
      {
        im_msg_body.QQWalletAioBody localQQWalletAioBody = new im_msg_body.QQWalletAioBody();
        localQQWalletAioBody.sint32_channelid.set(paramJSONObject.getInt("channelid"));
        localQQWalletAioBody.sint32_templateid.set(paramJSONObject.getInt("templateid"));
        localQQWalletAioBody.uint32_resend.set(paramJSONObject.getInt("resend"));
        localQQWalletAioBody.sint32_redtype.set(paramJSONObject.getInt("redtype"));
        localQQWalletAioBody.sint32_envelopeid.set(-1);
        paramString = new QQWalletRedPacketMsg(localQQWalletAioBody, paramString);
        paramString.redPacketId = paramJSONObject.getString("billno");
        paramString.authkey = paramJSONObject.getString("authkey");
        if (paramString.redPacketId.equals("")) {
          return null;
        }
        paramString.elem = a(paramJSONObject);
        paramJSONObject = paramString.elem;
        if (paramJSONObject != null) {
          return paramString;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  public static QQWalletTransferMsgElem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        QQWalletTransferMsgElem localQQWalletTransferMsgElem = new QQWalletTransferMsgElem();
        paramJSONObject = paramJSONObject.getJSONObject("receiver");
        if (paramJSONObject == null) {
          return null;
        }
        localQQWalletTransferMsgElem.nativeAndroid = paramJSONObject.getString("nativeAndroid");
        if (!localQQWalletTransferMsgElem.nativeAndroid.equals(""))
        {
          localQQWalletTransferMsgElem.background = paramJSONObject.getInt("background");
          localQQWalletTransferMsgElem.icon = paramJSONObject.getInt("icon");
          localQQWalletTransferMsgElem.title = paramJSONObject.getString("title");
          localQQWalletTransferMsgElem.subTitle = paramJSONObject.getString("subtitle");
          localQQWalletTransferMsgElem.content = paramJSONObject.getString("content");
          localQQWalletTransferMsgElem.linkUrl = paramJSONObject.getString("linkurl");
          localQQWalletTransferMsgElem.blackStripe = paramJSONObject.getString("blackstripe");
          localQQWalletTransferMsgElem.notice = paramJSONObject.getString("notice");
          localQQWalletTransferMsgElem.titleColor = paramJSONObject.getInt("titleColor");
          localQQWalletTransferMsgElem.subtitleColor = paramJSONObject.getInt("subtitleColor");
          localQQWalletTransferMsgElem.actionsPriority = paramJSONObject.getString("actionsPriority");
          localQQWalletTransferMsgElem.jumpUrl = paramJSONObject.getString("jumpUrl");
          localQQWalletTransferMsgElem.iconUrl = paramJSONObject.getString("iconurl");
          localQQWalletTransferMsgElem.contentColor = -1;
          localQQWalletTransferMsgElem.contentBgColor = -1;
          localQQWalletTransferMsgElem.aioImageLeft = "";
          localQQWalletTransferMsgElem.aioImageRight = "";
          localQQWalletTransferMsgElem.cftImage = "";
          return localQQWalletTransferMsgElem;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  private Boolean a(List paramList)
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
  
  protected static Boolean a(im_msg_body.Elem paramElem)
  {
    if ((paramElem.text.has()) || (paramElem.face.has()) || (paramElem.small_emoji.has()) || (paramElem.online_image.has()) || (paramElem.bankcode_ctrl_info.has())) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 2 < paramString.length()))
      {
        int j = (paramString.charAt(i + 1) - 'A') * 128 + paramString.charAt(i + 2) - 65;
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "faceIndex:" + j);
        }
        if ((j >= 0) && (j < MessageUtils.b.length))
        {
          j = MessageUtils.b[j];
          if (j >= 0)
          {
            localStringBuilder.append(paramString.charAt(i));
            localStringBuilder.append((char)j);
          }
        }
        i = i + 1 + 1;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  private String a(List paramList1, List paramList2, boolean paramBoolean)
  {
    String str = null;
    Object localObject = paramList1.iterator();
    paramList1 = null;
    if (((Iterator)localObject).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject).next();
      if (!localElem.text.has()) {
        break label160;
      }
      paramList1 = (im_msg_body.Text)localElem.text.get();
    }
    label160:
    for (;;)
    {
      break;
      localObject = str;
      if (paramList1 != null)
      {
        localObject = str;
        if (paramList1.str.has())
        {
          paramList1 = paramList1.str.get().toStringUtf8();
          localObject = paramList1;
          if (paramBoolean)
          {
            str = MessageUtils.a(paramList1, false);
            localObject = paramList1;
            if (str.length() > 0)
            {
              localObject = (MessageForText)MessageRecordFactory.a(-1000);
              ((MessageForText)localObject).msgtype = -1000;
              ((MessageForText)localObject).msg = str;
              paramList2.add(localObject);
              localObject = paramList1;
            }
          }
        }
      }
      return localObject;
    }
  }
  
  private void a(im_msg_body.Elem paramElem, List paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo)
  {
    paramElem = (im_msg_body.CrmElem)paramElem.crm_elem.get();
    if (paramElem != null)
    {
      i = paramElem.uint32_qidian_flag.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has uint32_qidian_flag:").append(i).append(";");
      }
      if (i == 1)
      {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("crmelem_qidian_flag", i + "");
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin();
        paramStringBuilder = String.valueOf(paramMsg.msg_head.from_uin.get());
        if (!((String)localObject).equals(paramStringBuilder))
        {
          localObject = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(164);
          if (!((QidianManager)localObject).a.containsKey(paramStringBuilder)) {
            ((QidianManager)localObject).a(new BmqqAccountType(paramStringBuilder, 1));
          }
        }
        if ((paramTempSessionInfo != null) && (paramTempSessionInfo.jdField_a_of_type_Int == 1024)) {
          paramTempSessionInfo.jdField_a_of_type_Int = 1025;
        }
      }
      if (paramElem.crm_buf.has()) {
        paramStringBuilder = new Crm.CrmCCNotify();
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramStringBuilder.mergeFrom(paramElem.crm_buf.get().toByteArray());
        int i = paramStringBuilder.crm_flag.get();
        long l1;
        if ((i == 8) && (paramStringBuilder.qidian_group_msg.has()))
        {
          paramElem = (Crm.QidianGroupMsg)paramStringBuilder.qidian_group_msg.get();
          int j = paramElem.uint32_group_task_id.get();
          int k = paramElem.uint32_group_msg_type.get();
          l1 = paramElem.uint64_kfuin.get();
          int m = paramElem.uint32_show_tip.get();
          paramElem = paramElem.str_tip_text.get();
          paramList = (MessageRecord)paramList.get(0);
          if (paramList != null)
          {
            paramList.mQidianTaskId = j;
            paramList.mQidianMasterUin = l1;
            paramList.mIsShowQidianTips = m;
            paramList.mQidianTipText = paramElem;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, String.format("received qidian bulk message taskId: %d, msgType: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
          }
          l1 = paramMsg.msg_head.from_uin.get();
          k = paramMsg.msg_head.msg_seq.get();
          long l2 = paramMsg.msg_head.msg_uid.get();
          m = paramMsg.msg_head.msg_type.get();
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, k, l2, m);
          if (j != 0)
          {
            paramElem = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
            paramList = new JSONObject();
            paramList.put("action", "receive");
            paramList.put("fromUin", String.valueOf(paramMsg.msg_head.from_uin.get()));
            paramList.put("toUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            paramList.put("taskID", String.valueOf(j));
            paramList.put("clickURL", "");
            paramList.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
            paramElem.a(paramList.toString(), String.valueOf(paramMsg.msg_head.from_uin.get()), "", 10009, 0);
          }
        }
        if ((i == 11) && (paramStringBuilder.msg_gray_msg.has()))
        {
          paramElem = (Crm.GrayMsg)paramStringBuilder.msg_gray_msg.get();
          i = paramElem.uint32_type.get();
          paramList = paramElem.str_text.get();
          l1 = paramElem.uint64_from_uin.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, String.format("received qidian gray msg type: %d, tips: %s, fromUin: %d", new Object[] { Integer.valueOf(i), paramList, Long.valueOf(l1) }));
          }
          QidianUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), paramList, 1024);
        }
        return;
      }
      catch (Exception paramElem)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("DecodeMsg", 2, "receive ccNotify but throw exception " + paramElem.getMessage());
        return;
      }
    }
    paramStringBuilder.append("has crmElem, but crmElem is null");
  }
  
  private void a(im_msg_body.Elem paramElem, im_msg_body.NotOnlineImage paramNotOnlineImage, List paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    BaseApplication.getContext().getString(2131436281);
    boolean bool;
    if (paramNotOnlineImage != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("flash", 2, "parsePBMsgElems_OfflineMsg hasComFlashPic=" + bool);
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:NotOnlineImage;\n hasComFlashPic=" + bool);
      }
      int i = 0;
      if (paramNotOnlineImage == null)
      {
        QLog.d("flash", 2, "offlineImg null");
        return;
        if (paramElem != null)
        {
          paramNotOnlineImage = (im_msg_body.NotOnlineImage)paramElem.not_online_image.get();
          bool = false;
        }
      }
      else
      {
        int j;
        if (paramNotOnlineImage != null)
        {
          j = paramNotOnlineImage.file_len.get();
          i = paramNotOnlineImage.img_type.get();
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] file_len=" + j);
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] imgType=" + i);
          }
          paramNotOnlineImage.flag.get().toByteArray();
          String str1 = paramNotOnlineImage.str_thumb_url.get();
          String str2 = paramNotOnlineImage.str_400_url.get();
          int i1 = paramNotOnlineImage.uint32_thumb_width.get();
          int i2 = paramNotOnlineImage.uint32_thumb_height.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] ThumbWidth=" + i1 + ",ThumbHeight=" + i2);
          }
          if (paramNotOnlineImage.uint32_file_id.has()) {}
          for (int k = paramNotOnlineImage.uint32_file_id.get();; k = 0)
          {
            String str3 = paramNotOnlineImage.str_big_url.get();
            String str4 = paramNotOnlineImage.str_orig_url.get();
            int i3 = paramNotOnlineImage.pic_width.get();
            int i4 = paramNotOnlineImage.pic_height.get();
            int m = paramNotOnlineImage.uint32_show_len.get();
            int n = paramNotOnlineImage.uint32_download_len.get();
            if (QLog.isDevelopLevel()) {
              QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + m + ", downloadLen " + n + ", fileLen " + j);
            }
            int i5 = paramNotOnlineImage.original.get();
            if (paramNotOnlineImage.res_id.has()) {
              paramElem = paramNotOnlineImage.res_id.get().toStringUtf8();
            }
            for (;;)
            {
              Object localObject1;
              if ((paramElem != null) && (!paramElem.equals("")))
              {
                localObject1 = "";
                paramMsg = (msg_comm.Msg)localObject1;
                if (paramNotOnlineImage.pic_md5.has())
                {
                  localObject2 = paramNotOnlineImage.pic_md5.get().toByteArray();
                  paramMsg = (msg_comm.Msg)localObject1;
                  if (localObject2 != null)
                  {
                    paramMsg = (msg_comm.Msg)localObject1;
                    if (localObject2.length > 0) {
                      paramMsg = HexUtil.a((byte[])localObject2);
                    }
                  }
                }
                Object localObject2 = TransfileUtile.a(paramElem, j, 1, false, paramElem, paramMsg, "picplatform", str1, str2, str3, str4, i5, 0);
                localObject1 = new RichMsg.PicRec();
                ((RichMsg.PicRec)localObject1).localPath.set(paramElem);
                ((RichMsg.PicRec)localObject1).size.set(j);
                ((RichMsg.PicRec)localObject1).type.set(1);
                ((RichMsg.PicRec)localObject1).isRead.set(false);
                ((RichMsg.PicRec)localObject1).uuid.set(paramElem);
                ((RichMsg.PicRec)localObject1).md5.set(paramMsg);
                ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
                ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(str1);
                ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str2);
                ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(i1);
                ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(i2);
                ((RichMsg.PicRec)localObject1).uint32_width.set(i3);
                ((RichMsg.PicRec)localObject1).uint32_height.set(i4);
                if (paramNotOnlineImage.uint32_file_id.has()) {
                  ((RichMsg.PicRec)localObject1).groupFileID.set(k);
                }
                ((RichMsg.PicRec)localObject1).bigMsgUrl.set(str3);
                ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str4);
                ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i5);
                ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
                ((RichMsg.PicRec)localObject1).version.set(5);
                ((RichMsg.PicRec)localObject1).isReport.set(0);
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("content:").append((String)localObject2).append("\n");
                }
                if (i5 != 1) {
                  break label1192;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, "[NotOnlineImage] showLen =" + m + ",downloadLen = " + n + ",raw photo msg,clear progressjpg info!");
                }
                k = 0;
                j = 0;
              }
              for (;;)
              {
                ((RichMsg.PicRec)localObject1).uint32_show_len.set(k);
                ((RichMsg.PicRec)localObject1).uint32_download_len.set(j);
                ((RichMsg.PicRec)localObject1).uint32_image_type.set(i);
                if (paramNotOnlineImage.bytes_pb_reserve.has()) {
                  ((RichMsg.PicRec)localObject1).bytes_pb_reserved.set(paramNotOnlineImage.bytes_pb_reserve.get());
                }
                paramElem = (MessageForPic)MessageRecordFactory.a(-2000);
                if (bool) {
                  FlashPicHelper.a(paramElem, false);
                }
                paramElem.msgtype = -2000;
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                return;
                if (!paramNotOnlineImage.download_path.has()) {
                  break label1203;
                }
                paramElem = paramNotOnlineImage.download_path.get().toStringUtf8();
                break;
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("serverPath is null or empty string : " + paramElem);
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
                paramNotOnlineImage = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin();
                StatisticCollector.a(BaseApplication.getContext()).a(paramNotOnlineImage, "actMessageEvent", false, 0L, 0L, paramElem, "");
                return;
                label1192:
                j = n;
                k = m;
              }
              label1203:
              paramElem = null;
            }
          }
          j = 0;
        }
      }
      paramNotOnlineImage = null;
      bool = false;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte1 = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localInflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public Pair a(List paramList, StringBuilder paramStringBuilder)
  {
    Object localObject4 = null;
    Object localObject3 = paramList.iterator();
    paramList = null;
    Object localObject1 = null;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject5 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (((im_msg_body.Elem)localObject5).src_msg.has()) {
        localObject1 = (im_msg_body.SourceMsg)((im_msg_body.Elem)localObject5).src_msg.get();
      }
      if (!((im_msg_body.Elem)localObject5).group_post_elem.has()) {
        break label544;
      }
      paramList = (im_msg_body.GroupPostElem)((im_msg_body.Elem)localObject5).group_post_elem.get();
    }
    label544:
    for (;;)
    {
      break;
      if ((localObject1 != null) && (((im_msg_body.SourceMsg)localObject1).elems.has()))
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:SrcMsg;\n");
        }
        localObject5 = ((im_msg_body.SourceMsg)localObject1).elems.get();
        localObject3 = new MessageForReplyText.SourceMsgInfo();
        ((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgSeq = ((Integer)((im_msg_body.SourceMsg)localObject1).uint32_orig_seqs.get(0)).intValue();
        ((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgText = a((List)localObject5);
        ((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgTime = ((im_msg_body.SourceMsg)localObject1).uint32_time.get();
        ((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgSenderUin = ((im_msg_body.SourceMsg)localObject1).uint64_sender_uin.get();
        ((MessageForReplyText.SourceMsgInfo)localObject3).mSourceSummaryFlag = ((im_msg_body.SourceMsg)localObject1).uint32_flag.get();
        localObject5 = ((List)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject5).next();
          if (localElem.anon_group_msg.has()) {
            ((MessageForReplyText.SourceMsgInfo)localObject3).mAnonymousNickName = ((im_msg_body.AnonymousGroupMsg)localElem.anon_group_msg.get()).str_anon_nick.get().toStringUtf8();
          }
        }
        if (((im_msg_body.SourceMsg)localObject1).uint32_type.has()) {
          ((MessageForReplyText.SourceMsgInfo)localObject3).mType = ((im_msg_body.SourceMsg)localObject1).uint32_type.get();
        }
        if (((im_msg_body.SourceMsg)localObject1).bytes_richMsg.has()) {
          ((MessageForReplyText.SourceMsgInfo)localObject3).mRichMsg = ((im_msg_body.SourceMsg)localObject1).bytes_richMsg.get().toStringUtf8();
        }
        if (((im_msg_body.SourceMsg)localObject1).bytes_pb_reserve.has()) {
          localObject5 = new source_msg.ResvAttr();
        }
      }
      for (;;)
      {
        try
        {
          ((source_msg.ResvAttr)localObject5).mergeFrom(((im_msg_body.SourceMsg)localObject1).bytes_pb_reserve.get().toByteArray());
          if (((source_msg.ResvAttr)localObject5).bytes_richMsg2.has()) {
            ((MessageForReplyText.SourceMsgInfo)localObject3).mRichMsg2 = ((source_msg.ResvAttr)localObject5).bytes_richMsg2.get().toStringUtf8();
          }
          localObject1 = localObject3;
          localObject3 = localObject4;
          if (paramList != null)
          {
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:GroupPostElem;\n");
            }
            int i = paramList.uint32_trans_type.get();
            paramList = paramList.bytes_trans_msg.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("zivonchen", 2, "group_post_elem transType = " + i + ", transMsg = " + paramList);
            }
            localObject3 = localObject4;
            if (i == 1)
            {
              localObject3 = localObject4;
              if (!TextUtils.isEmpty(paramList)) {
                localObject3 = new TroopTopicMgr.GroupPostElemInfo(i, paramList);
              }
            }
          }
          return new Pair(localObject1, localObject3);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        Object localObject2 = localObject3;
        continue;
        localObject2 = null;
      }
    }
  }
  
  public MarkFaceMessage a(im_msg_body.Elem paramElem, List paramList, StringBuilder paramStringBuilder, long paramLong)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    im_msg_body.MarketFace localMarketFace = (im_msg_body.MarketFace)paramElem.market_face.get();
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
      MarketFaceExtPb.ResvAttr localResvAttr;
      if (localMarketFace.bytes_pb_reserve.has())
      {
        paramElem.resvAttr = localMarketFace.bytes_pb_reserve.get().toByteArray();
        localResvAttr = new MarketFaceExtPb.ResvAttr();
      }
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
          break label524;
        }
        bool = true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        try
        {
          for (;;)
          {
            paramStringBuilder.msgData = MessagePkgUtils.a(paramElem);
            paramList.add(paramStringBuilder);
            return paramElem;
            boolean bool = false;
            continue;
            bool = false;
            continue;
            localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
            QLog.e("DecodeMsg", 1, "mergeFrom resvAttr error e = " + localInvalidProtocolBufferMicroException);
          }
          paramElem.faceName = paramStringBuilder;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      paramElem.isAPNG = bool;
      if (localResvAttr.uint32_has_ip_product.get() == 1)
      {
        bool = true;
        paramElem.hasIpProduct = bool;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" mediaType = ").append(paramElem.mediaType).append("\n");
        }
        if (localMarketFace.bytes_face_name.has())
        {
          paramStringBuilder = localMarketFace.bytes_face_name.get().toStringUtf8();
          if ((TextUtils.isEmpty(paramStringBuilder)) || (paramStringBuilder.length() <= 1) || (paramStringBuilder.charAt(0) != '[') || (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ']')) {
            break label568;
          }
          paramElem.faceName = paramStringBuilder.substring(1, paramStringBuilder.length() - 1);
        }
        paramStringBuilder = (MessageForMarketFace)MessageRecordFactory.a(-2007);
        paramStringBuilder.msgtype = -2007;
        paramStringBuilder.msg = "it is marketface";
        paramStringBuilder.mMarkFaceMessage = paramElem;
        if ((paramElem.mobileparam != null) && (paramElem.mobileparam.length > 0)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
        }
      }
    }
    label524:
    label568:
    return null;
  }
  
  public MessageForDeliverGiftTips a(String paramString1, String paramString2, im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, List paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:GiftMsg;\n");
    }
    int i = paramDeliverGiftMsg.uint32_animation_package_id.get();
    int j = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
    if ((i == 0) && ((j < 1000) || (j > 2000))) {
      paramStringBuilder = (MessageForDeliverGiftTips)MessageRecordFactory.a(-2035);
    }
    for (paramStringBuilder.msgtype = -2035;; paramStringBuilder.msgtype = -2038)
    {
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
      if (paramDeliverGiftMsg.bytes_pb_reserve.has()) {
        paramString1 = new ResvAttrForGiftMsg.ResvAttr();
      }
      try
      {
        paramString1.mergeFrom(paramDeliverGiftMsg.bytes_pb_reserve.get().toByteArray());
        paramStringBuilder.sendScore = paramString1.int32_send_score.get();
        paramStringBuilder.recvScore = paramString1.int32_recv_score.get();
        if (paramString1.bytes_charm_heroism.has()) {
          paramStringBuilder.charmHeroism = paramString1.bytes_charm_heroism.get().toStringUtf8();
        }
        paramStringBuilder.btFlag = paramString1.uint32_button_flag.get();
        paramStringBuilder.objColor = paramString1.uint32_obj_color.get();
        paramStringBuilder.animationType = paramString1.uint32_animation_type.get();
        if (paramString1.msg_interact_gift.has()) {
          paramStringBuilder.interactId = paramString1.msg_interact_gift.bytes_interact_id.get().toStringUtf8();
        }
      }
      catch (InvalidProtocolBufferMicroException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          continue;
          if ((paramStringBuilder.remindBrief != null) && (paramStringBuilder.remindBrief.split("#").length > 1)) {
            paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[1]);
          }
        }
      }
      paramStringBuilder.rcvName = paramString2;
      if (paramDeliverGiftMsg.bytes_comefrom_link.has()) {
        paramStringBuilder.jumpUrl = paramDeliverGiftMsg.bytes_comefrom_link.get().toStringUtf8();
      }
      paramString1 = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(80);
      if (paramString1 != null)
      {
        paramStringBuilder.grayTipsEntity = new TroopTipsEntity();
        paramStringBuilder.grayTipsEntity.isSupportImage = true;
        paramStringBuilder.grayTipsEntity.troopUin = String.valueOf(paramMsg.msg_head.group_info.group_code.get());
        paramStringBuilder.grayTipsEntity.optContent = paramStringBuilder.grayTipContent;
        paramString1.a(paramStringBuilder.grayTipsEntity);
        paramStringBuilder.msg = paramStringBuilder.grayTipsEntity.optContent;
        if ((paramStringBuilder instanceof MessageForTroopGift))
        {
          paramString1 = (MessageForTroopGift)paramStringBuilder;
          paramString1.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
          paramString1.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
          paramString1.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
          paramString1.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
          paramString1.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
          paramString1.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
          paramString1.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
        }
        if (TextUtils.isEmpty(paramStringBuilder.summary)) {
          paramStringBuilder.summary = paramStringBuilder.msg;
        }
        if (paramStringBuilder.grayTipsEntity.highlightNum != 0) {
          TroopTipsMsgMgr.a(paramStringBuilder, paramStringBuilder.grayTipsEntity.highlightItems);
        }
        if ((paramStringBuilder instanceof MessageForTroopGift)) {
          ((MessageForTroopGift)paramStringBuilder).prewrite();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin() == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin().equals(paramStringBuilder.receiverUin + ""))) {
          break;
        }
        if (paramStringBuilder.remindBrief != null) {
          paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[0]);
        }
        paramList.add(paramStringBuilder);
      }
      if ((paramStringBuilder instanceof MessageForTroopGift))
      {
        paramString1 = (MessageForTroopGift)paramStringBuilder;
        paramString1.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
        paramString1.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
        paramString1.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
        paramString1.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
        paramString1.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
        paramString1.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
        paramString1.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
        ((MessageForTroopGift)paramStringBuilder).prewrite();
      }
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "MessageProtoCodec.decodePBMsgElems  decode send gift gray tips" + paramStringBuilder.msg);
      }
      if ((paramStringBuilder.summary != null) && (paramStringBuilder.rcvName != null) && (paramStringBuilder.rcvName.length() > 0))
      {
        paramDeliverGiftMsg = Pattern.compile("(送.*给)");
        paramString2 = paramStringBuilder.msg;
        paramString1 = paramString2;
        if (!paramStringBuilder.isToAll())
        {
          paramString1 = paramString2;
          if (paramStringBuilder.msg.startsWith("["))
          {
            i = paramStringBuilder.msg.indexOf("]");
            paramString1 = paramString2;
            if (i != -1)
            {
              paramString1 = paramString2;
              if (i < paramStringBuilder.msg.length()) {
                paramString1 = paramStringBuilder.msg.substring(i + 1);
              }
            }
          }
        }
        paramString2 = paramDeliverGiftMsg.matcher(paramString1);
        if (paramString2.find())
        {
          paramString2 = paramString2.group();
          i = paramString1.indexOf(paramString2);
          j = paramString1.lastIndexOf(paramString2);
          if ((i > 0) && (j == i)) {
            paramStringBuilder.senderName = paramString1.substring(0, i);
          }
        }
      }
      return paramStringBuilder;
      paramStringBuilder = (MessageForTroopGift)MessageRecordFactory.a(-2038);
    }
  }
  
  public String a(List paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    StringBuilder localStringBuilder2 = new StringBuilder("<---decodePbElems:");
    int i = 0;
    int k = paramList.size();
    int j = 0;
    Object localObject;
    if (j < k)
    {
      localObject = (im_msg_body.Elem)paramList.get(j);
      if (((im_msg_body.Elem)localObject).text.has()) {
        if (i != 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (QLog.isColorLevel()) {
        localStringBuilder2.append("elemType:Text;\n");
      }
      localStringBuilder1.length();
      localObject = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (((im_msg_body.Text)localObject).str.has()) {
        localStringBuilder1.append(MessageUtils.a(((im_msg_body.Text)localObject).str.get().toStringUtf8(), false));
      }
      continue;
      int m;
      if (((im_msg_body.Elem)localObject).face.has())
      {
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:Face;\n");
        }
        if (((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.has())
        {
          m = ((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.get();
          if (m < MessageUtils.b.length)
          {
            m = MessageUtils.b[m];
            if (m >= 0)
            {
              localStringBuilder1.append('\024');
              localStringBuilder1.append((char)m);
            }
          }
        }
      }
      else if (((im_msg_body.Elem)localObject).small_emoji.has())
      {
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:small_emoji;\n");
        }
        if (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.has())
        {
          i = (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
          m = 0xFFFF & ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get();
          char[] arrayOfChar = EmosmUtils.a(i, m);
          if ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).imageType.get() & 0xFFFF) == 2))
          {
            arrayOfChar[3] = 'ǿ';
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "get apng epid = " + i + " eid = " + m);
            }
          }
          localStringBuilder1.append('\024');
          localStringBuilder1.append(arrayOfChar[3]);
          localStringBuilder1.append(arrayOfChar[2]);
          localStringBuilder1.append(arrayOfChar[1]);
          localStringBuilder1.append(arrayOfChar[0]);
          i = 1;
          continue;
          return localStringBuilder1.toString();
        }
      }
    }
  }
  
  public StringBuilder a(StringBuilder paramStringBuilder1, List paramList1, List paramList2, StringBuilder paramStringBuilder2, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = null;
    paramList2 = null;
    if (paramStringBuilder1 != null) {}
    long l;
    int i;
    for (StringBuilder localStringBuilder = new StringBuilder(paramStringBuilder1);; localStringBuilder = new StringBuilder(""))
    {
      l = paramMsg.msg_head.msg_seq.get();
      i = 0;
      Iterator localIterator = paramList1.iterator();
      paramStringBuilder1 = localAtTroopMemberInfo;
      paramList1 = paramList2;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1107;
        }
        paramList2 = (im_msg_body.Elem)localIterator.next();
        if (!paramList2.text.has()) {
          break label558;
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder2.append("elemType:Text;\n");
        }
        if (i == 0) {
          break;
        }
        i = 0;
      }
    }
    paramList2 = (im_msg_body.Text)paramList2.text.get();
    int i1 = localStringBuilder.length();
    if (paramList2.str.has()) {
      localStringBuilder.append(MessageUtils.a(paramList2.str.get().toStringUtf8(), false));
    }
    label196:
    int m;
    int k;
    int j;
    if (paramList2.attr_6_buf.has())
    {
      paramList2 = paramList2.attr_6_buf.get();
      if (paramList2 != null)
      {
        paramMsg = paramList2.toByteArray();
        if ((paramMessageInfo != null) && ((paramMessageInfo.jdField_a_of_type_Int == 3000) || (paramMessageInfo.jdField_a_of_type_Int == 1)) && (paramArrayList2 != null) && (paramMsg != null) && (paramMsg.length != 0))
        {
          m = PkgTools.a(paramMsg, 0);
          k = 2;
          j = 0;
          label251:
          if ((j < m) && (k < 2048))
          {
            paramList2 = new MessageForText.AtTroopMemberInfo();
            if (paramList2.readFrom(paramMsg, k)) {
              break label420;
            }
          }
        }
        if ((paramMessageInfo == null) || ((!paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(l)) && (!paramMessageInfo.c.a(l))) || (paramMsg == null) || (paramMsg.length == 0)) {
          break label1241;
        }
        int i2 = PkgTools.a(paramMsg, 0);
        j = 2;
        k = 0;
        paramList2 = paramStringBuilder1;
        label343:
        paramStringBuilder1 = paramList2;
        if (k < i2)
        {
          paramStringBuilder1 = paramList2;
          if (j < 2048)
          {
            localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
            paramStringBuilder1 = paramList2;
            if (k == 0)
            {
              paramStringBuilder1 = paramList2;
              if (paramList2 == null) {
                paramStringBuilder1 = localAtTroopMemberInfo;
              }
            }
            if (localAtTroopMemberInfo.readFrom(paramMsg, j)) {
              break label458;
            }
          }
        }
      }
    }
    label420:
    label458:
    label1107:
    label1241:
    for (;;)
    {
      paramList2 = paramList1;
      paramList1 = paramStringBuilder1;
      paramStringBuilder1 = paramList2;
      for (;;)
      {
        paramList2 = paramList1;
        paramList1 = paramStringBuilder1;
        paramStringBuilder1 = paramList2;
        break;
        paramMsg = null;
        break label196;
        k += paramList2.length();
        paramList2.startPos = ((short)(paramList2.startPos + i1));
        j = (short)(j + 1);
        paramArrayList2.add(paramList2);
        break label251;
        m = j + localAtTroopMemberInfo.length();
        localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + i1));
        int n = (short)(k + 1);
        if (localAtTroopMemberInfo.isIncludingAll()) {
          paramMessageInfo.c.a = l;
        }
        paramList2 = paramStringBuilder1;
        k = n;
        j = m;
        if (!localAtTroopMemberInfo.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin())) {
          break label343;
        }
        paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = l;
        paramList2 = paramStringBuilder1;
        k = n;
        j = m;
        break label343;
        if (paramList2.face.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:Face;\n");
          }
          if (((im_msg_body.Face)paramList2.face.get()).index.has())
          {
            j = ((im_msg_body.Face)paramList2.face.get()).index.get();
            if (j < MessageUtils.b.length)
            {
              j = MessageUtils.b[j];
              if (j >= 0)
              {
                localStringBuilder.append('\024');
                localStringBuilder.append((char)j);
              }
            }
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
          }
        }
        else if (paramList2.small_emoji.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:small_emoji;\n");
          }
          if (((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).packIdSum.has())
          {
            i = (((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
            j = 0xFFFF & ((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).packIdSum.get();
            paramMsg = EmosmUtils.a(i, j);
            if ((((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)paramList2.small_emoji.get()).imageType.get() & 0xFFFF) == 2))
            {
              paramMsg[3] = 511;
              if (QLog.isColorLevel()) {
                QLog.d("DecodeMsg", 2, "get apng epid = " + i + " eid = " + j);
              }
            }
            localStringBuilder.append('\024');
            localStringBuilder.append(paramMsg[3]);
            localStringBuilder.append(paramMsg[2]);
            localStringBuilder.append(paramMsg[1]);
            localStringBuilder.append(paramMsg[0]);
            i = 1;
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
          }
        }
        else
        {
          if (paramList2.online_image.has())
          {
            if (QLog.isColorLevel()) {
              paramStringBuilder2.append("elemType:OnlineImage;\n");
            }
            localStringBuilder.append(BaseApplication.getContext().getString(2131436281));
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
            continue;
          }
          if (paramList2.bankcode_ctrl_info.has())
          {
            if (QLog.isColorLevel()) {
              paramStringBuilder2.append("elemType: bankcode_ctrlinfo;\n");
            }
            paramList2 = paramList2.bankcode_ctrl_info.get().toByteArray();
            j = paramList2[0];
            k = paramList2[(paramList2.length - 1)];
            if ((j != 40) || (k != 41))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              paramStringBuilder2.append("elemType: bankcode_ctrlinfo buffer error;\n");
              break;
            }
            if (ByteBuffer.wrap(paramList2, 2, 2).getShort() != 29786) {
              break;
            }
            j = ByteBuffer.wrap(paramList2, 4, 2).getShort();
            if (j <= 0) {
              break;
            }
            paramList1 = new byte[j];
            System.arraycopy(paramList2, 6, paramList1, 0, j);
            paramList2 = paramStringBuilder1;
            paramStringBuilder1 = paramList1;
            paramList1 = paramList2;
            continue;
            if ((paramArrayList1 != null) && ((paramStringBuilder1 != null) || (paramList1 != null)))
            {
              if (!paramArrayList1.isEmpty()) {
                break label1145;
              }
              paramArrayList1.add(paramStringBuilder1);
              paramArrayList1.add(paramList1);
            }
            label1145:
            while ((paramArrayList1.size() != 2) || ((paramArrayList1.get(0) != null) && (paramArrayList1.get(1) != null))) {
              return localStringBuilder;
            }
            if (paramArrayList1.get(0) == null) {
              if (paramArrayList1.get(1) != null) {
                break label1222;
              }
            }
            for (;;)
            {
              paramArrayList1.clear();
              paramArrayList1.add(paramStringBuilder1);
              paramArrayList1.add(paramList1);
              return localStringBuilder;
              paramStringBuilder1 = paramArrayList1.get(0);
              break;
              paramList1 = paramArrayList1.get(1);
            }
          }
        }
        paramList2 = paramStringBuilder1;
        paramStringBuilder1 = paramList1;
        paramList1 = paramList2;
      }
    }
  }
  
  public StringBuilder a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, ArrayList paramArrayList)
  {
    return a(null, paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, paramArrayList, null);
  }
  
  public void a(ArrayList paramArrayList, List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo)
  {
    if (paramArrayList.contains("lifeOnline")) {
      a(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
    }
    if (paramArrayList.contains("updateAvatar")) {
      a(paramList1, paramMsg, paramStringBuilder);
    }
    paramArrayList = paramList1.iterator();
    int i;
    long l;
    int k;
    int n;
    int m;
    int j;
    if (paramArrayList.hasNext())
    {
      paramList1 = (im_msg_body.Elem)paramArrayList.next();
      if ((paramList1.near_by_msg.has()) && (paramList1.near_by_msg.uint32_identify_type.has()) && (paramList1.near_by_msg.uint32_identify_type.get() == 1))
      {
        ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("identify_flag", "true");
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType: near_by_msg has identify;\n");
        }
      }
      if ((paramList1.general_flags.has()) && (((im_msg_body.GeneralFlags)paramList1.general_flags.get()).uint32_olympic_torch.has()))
      {
        i = paramList1.general_flags.uint32_olympic_torch.get();
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("has olympicTorch:").append(i).append(";");
        }
        if (i > 0) {
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("olympic_torch_flg", i + "");
        }
      }
      if (paramList1.crm_elem.has()) {
        a(paramList1, paramList2, paramStringBuilder, paramMsg, paramTempSessionInfo);
      }
      if (paramList1.general_flags.has())
      {
        if (paramList1.general_flags.uint64_pendant_id.has())
        {
          l = paramList1.general_flags.uint64_pendant_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "vip_pendant_id = " + l);
          }
          if (l >= 0L) {
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("vip_pendant_id", String.valueOf(l));
          }
        }
        k = 0;
        n = 0;
        m = 0;
        if (paramList1.general_flags.bytes_pb_reserve.has())
        {
          paramMessageInfo = new generalflags.ResvAttr();
          j = n;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramMessageInfo.mergeFrom(paramList1.general_flags.bytes_pb_reserve.get().toByteArray());
        j = n;
        if (paramMessageInfo.float_sticker_x.has())
        {
          j = n;
          EmojiStickerManager.StickerInfo localStickerInfo = new EmojiStickerManager.StickerInfo();
          j = n;
          localStickerInfo.x = paramMessageInfo.float_sticker_x.get();
          j = n;
          if (!paramMessageInfo.float_sticker_y.has()) {
            continue;
          }
          j = n;
          f = paramMessageInfo.float_sticker_y.get();
          j = n;
          localStickerInfo.y = f;
          j = n;
          if (!paramMessageInfo.float_sticker_width.has()) {
            continue;
          }
          j = n;
          f = paramMessageInfo.float_sticker_width.get();
          j = n;
          localStickerInfo.width = f;
          j = n;
          if (!paramMessageInfo.float_sticker_height.has()) {
            continue;
          }
          j = n;
          f = paramMessageInfo.float_sticker_height.get();
          j = n;
          localStickerInfo.height = f;
          j = n;
          if (!paramMessageInfo.uint32_sticker_rotate.has()) {
            continue;
          }
          j = n;
          i = paramMessageInfo.uint32_sticker_rotate.get();
          j = n;
          localStickerInfo.rotate = i;
          j = n;
          if (!paramMessageInfo.uint64_sticker_host_msgseq.has()) {
            continue;
          }
          j = n;
          l = paramMessageInfo.uint64_sticker_host_msgseq.get();
          j = n;
          localStickerInfo.hostMsgSeq = l;
          j = n;
          if (!paramMessageInfo.uint64_sticker_host_msguid.has()) {
            continue;
          }
          j = n;
          l = paramMessageInfo.uint64_sticker_host_msguid.get();
          j = n;
          localStickerInfo.hostMsgUid = l;
          j = n;
          if (!paramMessageInfo.uint64_sticker_host_time.has()) {
            continue;
          }
          j = n;
          l = paramMessageInfo.uint64_sticker_host_time.get();
          j = n;
          localStickerInfo.hostMsgTime = l;
          j = n;
          if (QLog.isColorLevel())
          {
            j = n;
            QLog.d("DecodeMsg", 2, "decodeC2CMsgPkg_EmojSticker->" + localStickerInfo.toString());
          }
          j = n;
          MessageRecord localMessageRecord = (MessageRecord)paramList2.get(0);
          if (localMessageRecord != null)
          {
            j = n;
            localMessageRecord.saveExtInfoToExtStr("sticker_info", localStickerInfo.toJsonString());
            j = n;
            EmojiStickerManager.a(localMessageRecord, localStickerInfo);
            j = n;
            localMessageRecord.saveExtInfoToExtStr("message_is_sticker", "true");
          }
        }
        j = n;
        if (!paramMessageInfo.uint32_mobile_custom_font.has()) {
          continue;
        }
        j = n;
        l = paramMessageInfo.uint32_mobile_custom_font.get() & 0xFFFFFFFF;
        j = n;
        ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
        j = n;
        if (!QLog.isColorLevel()) {
          break label1805;
        }
        j = n;
        QLog.d("DecodeMsg", 2, "vip_font_id = " + l + " fontId = " + FontManager.a(l) + " type = " + FontManager.b(l));
      }
      catch (InvalidProtocolBufferMicroException paramMessageInfo)
      {
        float f;
        paramMessageInfo.printStackTrace();
        k = j;
        continue;
        j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        j = i;
        QLog.d("VasFont", 2, "diy_font_timestamp not in message");
        continue;
      }
      j = i;
      if (paramMessageInfo.uint32_diy_font_timestamp.has())
      {
        j = i;
        l = paramMessageInfo.uint32_diy_font_timestamp.get();
        j = i;
        ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("diy_timestamp", String.valueOf(l));
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("VasFont", 2, "diy_font_timestamp = " + l);
        }
        j = i;
        if (paramMessageInfo.uint32_tail_key.has())
        {
          j = i;
          if (2 == paramMessageInfo.uint32_tail_key.get())
          {
            j = i;
            if (paramMessageInfo.uint32_show_tail_flag.has())
            {
              j = i;
              if (1 != paramMessageInfo.uint32_show_tail_flag.get())
              {
                j = i;
                paramMessageInfo.uint32_tail_key.clear();
                j = i;
                if (QLog.isColorLevel())
                {
                  j = i;
                  QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_show_tail_flag != 1, uint32_tail_key been cleaned ");
                }
              }
            }
          }
        }
        j = i;
        if (paramMessageInfo.uint32_tail_key.has())
        {
          j = i;
          k = paramMessageInfo.uint32_tail_key.get();
          j = i;
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("app_tail_id", String.valueOf(k));
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_tail_key = " + k);
          }
        }
        j = i;
        if (paramMessageInfo.uint32_bot_message_class_id.has())
        {
          j = i;
          k = paramMessageInfo.uint32_bot_message_class_id.get();
          j = i;
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("robot_news_class_id", String.valueOf(k));
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_bot_message_class_id = " + k);
          }
        }
        k = i;
        j = i;
        if (paramMessageInfo.uint32_holiday_flag.has())
        {
          j = i;
          m = paramMessageInfo.uint32_holiday_flag.get();
          if (m == 1)
          {
            j = i;
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr(MessageConstants.c, String.valueOf(m));
          }
          k = i;
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_holiday_flag = " + m);
            k = i;
          }
        }
        if (k == 0)
        {
          l = MessageProtoCodec.a(paramMsg);
          if (l >= 0L)
          {
            ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "old vip_font_id = " + l + " fontId = " + FontManager.a(l) + " type = " + FontManager.b(l));
            }
          }
        }
        if ((!paramList1.common_elem.has()) || (!paramList1.common_elem.bytes_pb_elem.has()) || (paramList2.get(0) == null) || (18 != paramList1.common_elem.uint32_service_type.get())) {
          break label1762;
        }
        GoldMsgChatHelper.a(paramList1, (MessageRecord)paramList2.get(0));
        break;
        f = 0.0F;
        continue;
        f = 0.0F;
        continue;
        f = 0.0F;
        continue;
        i = 0;
        continue;
        l = 0L;
        continue;
        l = 0L;
        continue;
        l = 0L;
        continue;
        i = m;
        j = n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        j = n;
        QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags vip_font not has");
        i = m;
        continue;
      }
      label1762:
      if ((!paramList1.common_elem.has()) || (21 != paramList1.common_elem.uint32_service_type.get())) {
        break;
      }
      ConfessMsgUtil.a(paramMsg, paramList1, paramList2, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b);
      break;
      return;
      label1805:
      i = 1;
    }
  }
  
  public void a(List paramList1, List paramList2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList1.next();
      if ((localElem.general_flags.has()) && (localElem.general_flags.bytes_pb_reserve.has()))
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        try
        {
          localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
          if (localResvAttr.uint32_tail_key.has())
          {
            int i = localResvAttr.uint32_tail_key.get();
            if (2 == i) {
              ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("app_qim_tail_id", String.valueOf(i));
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    Object localObject1 = null;
    Object localObject3 = paramList1.iterator();
    int j = 0;
    Object localObject2 = null;
    int i = -1;
    paramList1 = (List)localObject1;
    localObject1 = localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (!((im_msg_body.Elem)localObject2).video_file.has()) {
        break label1292;
      }
      localObject1 = (im_msg_body.VideoFile)((im_msg_body.Elem)localObject2).video_file.get();
    }
    label1292:
    for (;;)
    {
      int k = j;
      if (((im_msg_body.Elem)localObject2).bless_msg.has())
      {
        k = j;
        if (((im_msg_body.Elem)localObject2).bless_msg.uint32_msg_type.get() == 1)
        {
          k = 1;
          if (((im_msg_body.Elem)localObject2).bless_msg.uint32_ex_flag.has()) {
            i = ((im_msg_body.Elem)localObject2).bless_msg.uint32_ex_flag.get();
          }
        }
      }
      for (j = 1;; j = k)
      {
        if (((im_msg_body.Elem)localObject2).general_flags.has()) {
          paramList1 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject2).general_flags.get();
        }
        label1245:
        label1276:
        for (;;)
        {
          break;
          if (localObject1 == null) {}
          for (;;)
          {
            return;
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:video_file;\n");
            }
            localObject2 = new RichMsg.VideoFile();
            ((RichMsg.VideoFile)localObject2).setHasFlag(true);
            ((RichMsg.VideoFile)localObject2).bytes_file_name.set(((im_msg_body.VideoFile)localObject1).bytes_file_name.get());
            ((RichMsg.VideoFile)localObject2).bytes_file_md5.set(((im_msg_body.VideoFile)localObject1).bytes_file_md5.get());
            ((RichMsg.VideoFile)localObject2).bytes_file_uuid.set(((im_msg_body.VideoFile)localObject1).bytes_file_uuid.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_format.set(((im_msg_body.VideoFile)localObject1).uint32_file_format.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_size.set(((im_msg_body.VideoFile)localObject1).uint32_file_size.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_time.set(((im_msg_body.VideoFile)localObject1).uint32_file_time.get());
            ((RichMsg.VideoFile)localObject2).uint32_thumb_width.set(((im_msg_body.VideoFile)localObject1).uint32_thumb_width.get());
            ((RichMsg.VideoFile)localObject2).uint32_thumb_height.set(((im_msg_body.VideoFile)localObject1).uint32_thumb_height.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_status.set(2008);
            ((RichMsg.VideoFile)localObject2).uint32_file_progress.set(0);
            ((RichMsg.VideoFile)localObject2).bytes_thumb_file_md5.set(((im_msg_body.VideoFile)localObject1).bytes_thumb_file_md5.get());
            ((RichMsg.VideoFile)localObject2).bytes_source.set(((im_msg_body.VideoFile)localObject1).bytes_source.get());
            ((RichMsg.VideoFile)localObject2).uint32_thumb_file_size.set(((im_msg_body.VideoFile)localObject1).uint32_thumb_file_size.get());
            ((RichMsg.VideoFile)localObject2).uint32_busi_type.set(((im_msg_body.VideoFile)localObject1).uint32_busi_type.get());
            ((RichMsg.VideoFile)localObject2).uin32_from_chat_type.set(((im_msg_body.VideoFile)localObject1).uint32_from_chat_type.get());
            ((RichMsg.VideoFile)localObject2).uin32_to_chat_type.set(((im_msg_body.VideoFile)localObject1).uint32_to_chat_type.get());
            ((RichMsg.VideoFile)localObject2).bool_support_progressive.set(((im_msg_body.VideoFile)localObject1).bool_support_progressive.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_width.set(((im_msg_body.VideoFile)localObject1).uint32_file_width.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_height.set(((im_msg_body.VideoFile)localObject1).uint32_file_height.get());
            ((RichMsg.VideoFile)localObject2).uint32_sub_busi_type.set(((im_msg_body.VideoFile)localObject1).uint32_sub_busi_type.get());
            ((RichMsg.VideoFile)localObject2).uint32_video_attr.set(((im_msg_body.VideoFile)localObject1).uint32_video_attr.get());
            if (((im_msg_body.VideoFile)localObject1).bytes_pb_reserve.has()) {
              localObject3 = new videoFile.ResvAttr();
            }
            try
            {
              ((videoFile.ResvAttr)localObject3).mergeFrom(((im_msg_body.VideoFile)localObject1).bytes_pb_reserve.get().toByteArray());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_icon.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon.get());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_icon_sub.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon_sub.get());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_title.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_title.get());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_url.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_url.get());
              ((RichMsg.VideoFile)localObject2).uint32_special_video_type.set(((videoFile.ResvAttr)localObject3).uint32_special_video_type.get());
              ((RichMsg.VideoFile)localObject2).uint32_msg_tail_type.set(((videoFile.ResvAttr)localObject3).uint32_msg_tail_type.get());
              if ((paramList1 != null) && (paramList1.bytes_pb_reserve.has())) {
                localObject1 = new generalflags.ResvAttr();
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              try
              {
                do
                {
                  ((generalflags.ResvAttr)localObject1).mergeFrom(paramList1.bytes_pb_reserve.get().toByteArray());
                  ((RichMsg.VideoFile)localObject2).uint32_red_envelope_type.set(((generalflags.ResvAttr)localObject1).uint32_red_envelope_type.get());
                  ((RichMsg.VideoFile)localObject2).bytes_shortVideoId.set(((generalflags.ResvAttr)localObject1).bytes_shortVideoId.get());
                  localObject1 = (MessageForShortVideo)MessageRecordFactory.a(-2022);
                  ((MessageForShortVideo)localObject1).msgtype = -2022;
                  ((MessageForShortVideo)localObject1).msgData = ((RichMsg.VideoFile)localObject2).toByteArray();
                  if (((RichMsg.VideoFile)localObject2).uint32_busi_type.get() != 2) {
                    break label1245;
                  }
                  ((MessageForShortVideo)localObject1).msg = "[视频对讲]";
                  if ((paramList1 != null) && (paramList1.babyq_guide_msg_cookie.has())) {}
                  try
                  {
                    babyq_cookie.BabyQCookie localBabyQCookie = new babyq_cookie.BabyQCookie();
                    localObject3 = paramList1.babyq_guide_msg_cookie.get().toByteArray();
                    localBabyQCookie = (babyq_cookie.BabyQCookie)localBabyQCookie.mergeFrom((byte[])localObject3);
                    if ((localBabyQCookie.uint32_need_not_report.has()) && (localBabyQCookie.uint32_need_not_report.get() == 0))
                    {
                      String str = Utils.a((byte[])localObject3);
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "decodePBMsgElems_VideoFile, guideMsgCookie: " + str + ",bytes: " + Arrays.toString(paramList1.babyq_guide_msg_cookie.get().toByteArray()));
                      }
                      ((MessageForShortVideo)localObject1).saveExtInfoToExtStr("guide_msg_cookie", str);
                    }
                    if (localBabyQCookie.uint32_video_type.has())
                    {
                      k = localBabyQCookie.uint32_video_type.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "decodePBMsgElems_VideoFile, video_type: " + k);
                      }
                      ((MessageForShortVideo)localObject1).saveExtInfoToExtStr("guide_video_type", String.valueOf(k));
                    }
                    ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a((byte[])localObject3);
                  }
                  catch (Exception paramList1)
                  {
                    for (;;)
                    {
                      boolean bool;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("DecodeMsg", 2, "get video guideMsgCookie error!", paramList1);
                        continue;
                        bool = false;
                      }
                    }
                  }
                  ((MessageForShortVideo)localObject1).parse();
                  if (((MessageForShortVideo)localObject1).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "VideoRedbag, decodePBMsgElems_VideoFile");
                    }
                    RedBagVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
                    if (VideoRedbagData.queryRewardStat(((MessageForShortVideo)localObject1).shortVideoId))
                    {
                      ((MessageForShortVideo)localObject1).redBagStat = 1;
                      ((RichMsg.VideoFile)localObject2).red_envelope_pay_stat.set(1);
                    }
                  }
                  paramList2.add(localObject1);
                  if (j != 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + i);
                    }
                    ((MessageForShortVideo)localObject1).isBlessMsg = true;
                    if (i > -1)
                    {
                      if ((i & 0x1) != 1) {
                        break label1276;
                      }
                      bool = true;
                      ((MessageForShortVideo)localObject1).needUpdateMsgTag = bool;
                    }
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  paramStringBuilder.append("ShortVideo.msg: ").append(((MessageForShortVideo)localObject1).toString() + "\n" + ((MessageForShortVideo)localObject1).toLogString()).append("\n");
                  return;
                  localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
                } while (!QLog.isColorLevel());
                QLog.d("DecodeMsg", 2, "ShortVideo doParse error!", localInvalidProtocolBufferMicroException);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.d("DecodeMsg", 2, "ShortVideo doParse generalFlag error!", localException);
                    continue;
                    localException.msg = "[视频]";
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Object localObject = null;
    Iterator localIterator = paramList1.iterator();
    do
    {
      paramList1 = (List)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)localIterator.next();
    } while (!paramList1.group_file.has());
    paramList1 = (im_msg_body.GroupFile)paramList1.group_file.get();
    if (paramList1 == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GroupFile;\n");
      }
      long l1 = 0L;
      paramStringBuilder = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (paramStringBuilder.discuss_info.has()) {
        l1 = ((msg_comm.DiscussInfo)paramStringBuilder.discuss_info.get()).discuss_uin.get();
      }
      long l4 = paramStringBuilder.from_uin.get();
      long l6 = paramStringBuilder.msg_time.get();
      long l7 = paramStringBuilder.msg_seq.get();
      long l5 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin();
      if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, 3000, String.valueOf(l1), String.valueOf(l4), l6, l7)) {
        continue;
      }
      paramStringBuilder = "";
      try
      {
        localObject = new String(paramList1.bytes_filename.get().toByteArray(), "UTF-8");
        paramStringBuilder = (StringBuilder)localObject;
        long l3 = 0L;
        l2 = l3;
        if (paramMsg.msg_body.has())
        {
          paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
          l2 = l3;
          if (paramMsg.rich_text.attr.has()) {
            l2 = MessageUtils.a(((im_msg_body.Attr)paramMsg.rich_text.attr.get()).random.get());
          }
        }
        paramMsg = (MessageForFile)MessageRecordFactory.a(-2005);
        paramMsg.msgtype = -2005;
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (paramList1.bytes_pb_reserve.has()) {
          localObject = new hummer_resv_21.ResvAttr();
        }
      }
      catch (UnsupportedEncodingException localInvalidProtocolBufferMicroException)
      {
        try
        {
          long l2;
          int k;
          int m;
          ((hummer_resv_21.ResvAttr)localObject).mergeFrom(paramList1.bytes_pb_reserve.get().toByteArray());
          int j = m;
          int i = k;
          if (((hummer_resv_21.ResvAttr)localObject).file_image_info.has())
          {
            i = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_height.get();
            j = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_width.get();
            paramMsg.saveExtInfoToExtStr("file_pic_width", String.valueOf(j));
            paramMsg.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(i));
          }
          paramMsg.uniseq = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().a(paramMsg.uniseq, l1, l4, l7, l2, l6, paramList1, j, i);
          l1 = paramList1.uint64_file_size.get();
          if (l4 == l5)
          {
            bool = true;
            paramMsg.msg = TransfileUtile.a(paramStringBuilder, l1, 0, bool);
            paramMsg.doParse();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          try
          {
            for (;;)
            {
              paramMsg.fileName = FileManagerUtil.a(new String(paramList1.bytes_filename.get().toByteArray(), "UTF-8"));
              paramList2.add(paramMsg);
              ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(271)).a(paramMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DecodeMsg", 2, "GroupDiscFile.msg: " + paramList1.bytes_filename.get() + ";");
              return;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              localUnsupportedEncodingException.printStackTrace();
              continue;
              localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
            boolean bool = false;
          }
          catch (UnsupportedEncodingException paramStringBuilder)
          {
            for (;;)
            {
              paramStringBuilder.printStackTrace();
              QLog.e("DecodeMsg", 1, "internalDiscOfflineFile: Exception is " + paramStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    paramStringBuilder = paramList1.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramStringBuilder.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramStringBuilder.next();
    } while (!localElem.life_online.has());
    for (;;)
    {
      if (localElem == null) {
        return;
      }
      long l1;
      label111:
      long l2;
      label139:
      long l3;
      label166:
      long l4;
      label193:
      int j;
      int i3;
      int i4;
      Object localObject3;
      String str;
      label268:
      boolean bool;
      label303:
      int m;
      label342:
      int n;
      label381:
      int i1;
      label420:
      int i5;
      int i6;
      int i;
      label506:
      int k;
      label545:
      label584:
      label613:
      Object localObject1;
      label643:
      label673:
      Object localObject2;
      int i2;
      if ((localElem.life_online.has()) && (localElem.life_online.uint32_ack.has()) && (localElem.life_online.uint32_ack.get() == 1))
      {
        if (localElem.life_online.uint64_unique_id.has())
        {
          l1 = localElem.life_online.uint64_unique_id.get();
          if (!localElem.life_online.uint32_op.has()) {
            break label1297;
          }
          l2 = localElem.life_online.uint32_op.get();
          if (!paramMsg.msg_head.from_uin.has()) {
            break label1303;
          }
          l3 = paramMsg.msg_head.from_uin.get();
          if (!paramMsg.msg_head.to_uin.has()) {
            break label1309;
          }
          l4 = paramMsg.msg_head.to_uin.get();
          PublicAccountManager.a().a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, l1, l2, l3, l4, 1, null);
        }
      }
      else
      {
        j = 0;
        i3 = 0;
        i4 = 0;
        paramMessageInfo = "";
        localObject3 = "";
        str = "";
        if (!localElem.life_online.uint64_unique_id.has()) {
          break label1315;
        }
        l1 = localElem.life_online.uint64_unique_id.get();
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1327;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 1L) != 1L) {
          break label1321;
        }
        bool = true;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1339;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x4) != 4L) {
          break label1333;
        }
        m = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1351;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x40) != 64L) {
          break label1345;
        }
        n = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1363;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x800) != 2048L) {
          break label1357;
        }
        i1 = 1;
        i5 = (int)((localElem.life_online.uint64_bitmap.get() & 0x180) >> 7);
        i6 = (int)((localElem.life_online.uint64_bitmap.get() & 0x600) >> 9);
        if (m == 0) {
          break label1425;
        }
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1375;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x8) != 8L) {
          break label1369;
        }
        i = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1387;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x10) != 16L) {
          break label1381;
        }
        j = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1399;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x20) != 32L) {
          break label1393;
        }
        k = 1;
        if (!localElem.life_online.gdt_imp_data.has()) {
          break label1405;
        }
        paramStringBuilder = localElem.life_online.gdt_imp_data.get().toStringUtf8();
        if (!localElem.life_online.gdt_cli_data.has()) {
          break label1411;
        }
        paramMessageInfo = localElem.life_online.gdt_cli_data.get().toStringUtf8();
        if (!localElem.life_online.view_id.has()) {
          break label1418;
        }
        localObject1 = localElem.life_online.view_id.get().toStringUtf8();
        localObject2 = paramStringBuilder;
        if (paramStringBuilder.length() > 100) {
          localObject2 = paramStringBuilder.substring(0, 100);
        }
        if (paramMessageInfo.length() <= 100) {
          break label1696;
        }
        paramStringBuilder = paramMessageInfo.substring(0, 100);
        i2 = j;
      }
      for (;;)
      {
        label717:
        if (localElem.life_online.uint64_bitmap.has()) {
          if ((localElem.life_online.uint64_bitmap.get() & 0x1000) == 4096L)
          {
            j = 1;
            label756:
            if ((j != 0) || ((paramMsg.msg_head.from_uin.has()) && (paramMsg.msg_head.from_uin.get() == 1579646438L))) {
              ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("kandian_replace_subscribe_msg", "1");
            }
            if (i1 != 0)
            {
              ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("recent_list_advertisement_message", "1");
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("isRecentAd, uint64_bitmap value is: ");
                if (!localElem.life_online.uint64_bitmap.has()) {
                  break label1558;
                }
                paramMessageInfo = Long.valueOf(localElem.life_online.uint64_bitmap.get());
                label887:
                QLog.d("DecodeMsg", 2, paramMessageInfo);
              }
              ThreadManager.getSubThreadHandler().postDelayed(new ahjj(this), 1000L);
            }
            if (!paramList2.isEmpty())
            {
              paramMessageInfo = (MessageRecord)paramList2.get(0);
              paramMessageInfo.extLong |= 0x1;
              ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("pa_msgHasRead", "false");
              ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("pa_msgId", String.valueOf(l1));
              ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("pa_should_report", String.valueOf(bool));
              if (m != 0)
              {
                ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("isAdMsg", "1");
                ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("ad_msgHasRead", "false");
                ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("gdt_msgClick", paramStringBuilder);
                ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("gdt_msgImp", (String)localObject2);
                paramMessageInfo = (MessageRecord)paramList2.get(0);
                if (i == 0) {
                  break label1566;
                }
                paramStringBuilder = "1";
                label1114:
                paramMessageInfo.saveExtInfoToExtStr("gdt_singleAd", paramStringBuilder);
                paramMessageInfo = (MessageRecord)paramList2.get(0);
                if (i2 == 0) {
                  break label1573;
                }
                paramStringBuilder = "1";
                label1144:
                paramMessageInfo.saveExtInfoToExtStr("gdt_mulAd", paramStringBuilder);
                paramMessageInfo = (MessageRecord)paramList2.get(0);
                if (k == 0) {
                  break label1580;
                }
                paramStringBuilder = "1";
                paramMessageInfo.saveExtInfoToExtStr("gdt_followAd", paramStringBuilder);
                ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
                ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("gdt_view_id", (String)localObject1);
              }
            }
            if ((n == 0) || (paramList2.isEmpty())) {
              break label1641;
            }
            paramList1 = paramList1.iterator();
            i = 0;
            label1244:
            if (!paramList1.hasNext()) {
              break label1587;
            }
            paramStringBuilder = (im_msg_body.Elem)paramList1.next();
            if (!paramStringBuilder.pub_acc_info.uint32_is_inter_num.has()) {
              break label1693;
            }
            i = paramStringBuilder.pub_acc_info.uint32_is_inter_num.get();
          }
        }
        label1174:
        label1303:
        label1309:
        label1693:
        for (;;)
        {
          break label1244;
          l1 = 0L;
          break label111;
          l2 = 0L;
          break label139;
          l3 = 0L;
          break label166;
          l4 = 0L;
          break label193;
          label1315:
          l1 = 0L;
          break label268;
          label1321:
          bool = false;
          break label303;
          label1327:
          bool = false;
          break label303;
          label1333:
          m = 0;
          break label342;
          label1339:
          m = 0;
          break label342;
          label1345:
          n = 0;
          break label381;
          label1351:
          n = 0;
          break label381;
          label1357:
          i1 = 0;
          break label420;
          label1363:
          i1 = 0;
          break label420;
          label1369:
          i = 0;
          break label506;
          label1375:
          i = 0;
          break label506;
          label1381:
          j = 0;
          break label545;
          label1387:
          j = 0;
          break label545;
          label1393:
          k = 0;
          break label584;
          label1399:
          k = 0;
          break label584;
          label1405:
          paramStringBuilder = "";
          break label613;
          paramMessageInfo = "";
          break label643;
          localObject1 = "";
          break label673;
          i2 = i3;
          k = i4;
          localObject2 = localObject3;
          paramStringBuilder = paramMessageInfo;
          localObject1 = str;
          i = j;
          if (!QLog.isColorLevel()) {
            break label717;
          }
          localObject1 = new StringBuilder().append("isAdArriveMsg is false, uint64_bitmap value is: ");
          if (localElem.life_online.uint64_bitmap.has()) {}
          for (paramStringBuilder = Long.valueOf(localElem.life_online.uint64_bitmap.get());; paramStringBuilder = "null")
          {
            QLog.d("DecodeMsg", 2, paramStringBuilder);
            i2 = i3;
            k = i4;
            localObject2 = localObject3;
            paramStringBuilder = paramMessageInfo;
            localObject1 = str;
            i = j;
            break;
          }
          j = 0;
          break label756;
          j = 0;
          break label756;
          paramMessageInfo = "null";
          break label887;
          label1566:
          paramStringBuilder = "0";
          break label1114;
          label1573:
          paramStringBuilder = "0";
          break label1144;
          label1580:
          paramStringBuilder = "0";
          break label1174;
          label1587:
          paramList1 = (MessageRecord)paramList2.get(0);
          paramList1.saveExtInfoToExtStr("welcome_msg", "true");
          if ((i != 2) && (((paramList1 instanceof MessageForText)) || ((paramList1 instanceof MessageForLongMsg)))) {
            ThreadManager.executeOnSubThread(new ahjk(this, paramMsg));
          }
          label1641:
          if (paramList2.isEmpty()) {
            break;
          }
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i5));
          ((MessageRecord)paramList2.get(0)).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i6));
          return;
        }
        label1297:
        label1558:
        label1696:
        i2 = j;
        label1411:
        label1418:
        label1425:
        paramStringBuilder = paramMessageInfo;
      }
      localElem = null;
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, boolean paramBoolean)
  {
    int i = 0;
    im_msg_body.Elem localElem = null;
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    Iterator localIterator = paramList1.iterator();
    paramList1 = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.market_face.has())
      {
        if (!localArrayList.isEmpty())
        {
          b(localArrayList, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, paramBoolean);
          localArrayList.clear();
        }
        paramList1 = a(localElem, paramList2, paramStringBuilder, ((im_msg_body.Attr)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).attr.get()).time.get());
        i = 1;
      }
      for (;;)
      {
        break;
        if ((i != 0) && (localElem.text.has()) && (paramList1 != null))
        {
          paramList1.faceName = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
          if ((paramList1.faceName.charAt(0) == '[') && (paramList1.faceName.charAt(paramList1.faceName.length() - 1) == ']')) {
            paramList1.faceName = paramList1.faceName.substring(1, paramList1.faceName.length() - 1);
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("filter the text expalin:").append(((im_msg_body.Text)localElem.text.get()).str.get()).append("\n");
          }
          i = 0;
          break;
        }
        localArrayList.add(localElem);
      }
    }
    if (!localArrayList.isEmpty())
    {
      b(localArrayList, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, paramBoolean);
      localArrayList.clear();
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    Iterator localIterator = paramList1.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)localIterator.next();
    } while (!paramList1.hc_flash_pic.has());
    for (;;)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:FlashPic;\n");
      }
      a(paramList1, null, paramList2, paramStringBuilder, paramMsg, paramBoolean);
      return;
      paramList1 = null;
    }
  }
  
  public void a(List paramList1, List paramList2, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Object localObject = paramList1.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList1.shake_window.has());
    for (;;)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:ShakeWindow;\n");
      }
      paramList1 = (im_msg_body.ShakeWindow)paramList1.shake_window.get();
      localObject = (MessageForShakeWindow)MessageRecordFactory.a(-2020);
      ((MessageForShakeWindow)localObject).msgtype = -2020;
      ((MessageForShakeWindow)localObject).msg = "[Shake Window]";
      ShakeWindowMsg localShakeWindowMsg = new ShakeWindowMsg();
      localShakeWindowMsg.mType = paramList1.uint32_type.get();
      localShakeWindowMsg.mReserve = paramList1.uint32_reserve.get();
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        localShakeWindowMsg.onlineFlag = i;
        localShakeWindowMsg.shake = true;
        ((MessageForShakeWindow)localObject).msgData = localShakeWindowMsg.getBytes();
        if (((MessageForShakeWindow)localObject).msgData != null) {
          break label189;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
        return;
      }
      label189:
      paramList2.add(localObject);
      return;
      paramList1 = null;
    }
  }
  
  public void a(List paramList, msg_comm.Msg paramMsg, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList = null)
    {
      if (paramList == null) {}
      for (;;)
      {
        return;
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
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "QQ 18 elemType:UpdateStrangerAvatar system id = " + i + ", headType = " + j);
            }
            long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
            paramList = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
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
          return;
        }
      }
    }
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (paramElem != null) {}
    for (boolean bool1 = paramElem.hc_flash_pic.has();; bool1 = false)
    {
      if (paramCustomFace != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:CustomFace: isC2C:").append(paramBoolean).append(";\n");
        }
        StringBuilder localStringBuilder = new StringBuilder("");
        if (paramBoolean)
        {
          localStringBuilder.append(BaseApplication.getContext().getString(2131436281));
          paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
          l1 = paramElem.msg_seq.get();
          l2 = paramElem.msg_uid.get();
          long l3 = paramElem.msg_time.get();
          long l4 = paramElem.from_uin.get();
          long l5 = paramElem.to_uin.get();
          paramElem = new HashMap();
          paramElem.put("param_FailCode", String.valueOf(10001));
          paramElem.put("fromUin", String.valueOf(l4));
          paramElem.put("toUin", String.valueOf(l5));
          paramElem.put("msgSeq", String.valueOf(l1));
          paramElem.put("msgUid", String.valueOf(l2));
          paramElem.put("msgtime", String.valueOf(l3));
          paramCustomFace = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin();
          StatisticCollector.a(BaseApplication.getContext()).a(paramCustomFace, "actMessageEvent", false, 0L, 0L, paramElem, "");
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace isC2C");
          }
          return;
        }
        if ((localStringBuilder.length() > 0) && (!bool1) && (!bool2))
        {
          localObject1 = (MessageForText)MessageRecordFactory.a(-1000);
          ((MessageForText)localObject1).msgtype = -1000;
          ((MessageForText)localObject1).msg = localStringBuilder.toString();
          paramList.add(localObject1);
          localStringBuilder.delete(0, localStringBuilder.length());
        }
        Object localObject1 = null;
        if (paramCustomFace != null) {}
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace hasComFlashPic=" + bool2);
          }
          if (paramCustomFace != null) {
            break;
          }
          QLog.d("DecodeMsg", 2, "parsePBMsgElems_CustomFace customface is null");
          return;
          paramCustomFace = (im_msg_body.CustomFace)localObject1;
          if (paramElem != null) {
            if (bool1) {
              paramCustomFace = (im_msg_body.CustomFace)paramElem.hc_flash_pic.get();
            } else {
              paramCustomFace = (im_msg_body.CustomFace)paramElem.custom_face.get();
            }
          }
        }
        paramElem = paramCustomFace.str_file_path.get();
        paramCustomFace.str_shortcut.get();
        String str1 = paramCustomFace.str_big_url.get();
        String str2 = paramCustomFace.str_orig_url.get();
        String str3 = paramCustomFace.str_thumb_url.get();
        String str4 = paramCustomFace.str_400_url.get();
        int m = paramCustomFace.uint32_thumb_width.get();
        int n = paramCustomFace.uint32_thumb_height.get();
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "[CustomFace] ThumbWidth=" + m + ",ThumbHeight=" + n + "downURLBigThum400=" + str4);
        }
        int j = paramCustomFace.uint32_show_len.get();
        int i = paramCustomFace.uint32_download_len.get();
        long l1 = paramCustomFace.uint32_file_id.get();
        long l2 = paramCustomFace.uint32_file_type.get();
        l2 = paramCustomFace.uint32_server_ip.get();
        l2 = paramCustomFace.uint32_server_port.get();
        l2 = paramCustomFace.uint32_useful.get();
        l2 = paramCustomFace.uint32_size.get() & 0xFFFFFFFF;
        int k = paramCustomFace.image_type.get();
        if (QLog.isColorLevel())
        {
          QLog.d("DecodeMsg", 2, "[CustomFace] uint32_size=" + l2);
          QLog.d("DecodeMsg", 2, "[CustomFace] imgType=" + k);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + j + ", downloadLen " + i + ", fileLen " + l2);
        }
        Object localObject2 = paramCustomFace.bytes_md5.get().toByteArray();
        localObject1 = paramCustomFace.bytes_signature.get().toByteArray();
        paramCustomFace.bytes_buffer.get().toByteArray();
        Object localObject3 = paramCustomFace.bytes_flag.get().toByteArray();
        int i1 = (int)(paramCustomFace.uint32_width.get() & 0xFFFFFFFF);
        int i2 = (int)(paramCustomFace.uint32_height.get() & 0xFFFFFFFF);
        localObject2 = HexUtil.a((byte[])localObject2);
        HexUtil.a((byte[])localObject1);
        HexUtil.a((byte[])localObject3);
        int i3 = paramCustomFace.uint32_origin.get();
        localObject3 = TranDbRecord.PicDbRecord.a(paramElem, 0L, 1, false, paramElem, (String)localObject2, "picplatform", str3, str4, str1, str2, i3, 0);
        localObject1 = new RichMsg.PicRec();
        ((RichMsg.PicRec)localObject1).localPath.set(paramElem);
        ((RichMsg.PicRec)localObject1).size.set(l2);
        ((RichMsg.PicRec)localObject1).type.set(1);
        ((RichMsg.PicRec)localObject1).isRead.set(false);
        ((RichMsg.PicRec)localObject1).uuid.set(paramElem);
        ((RichMsg.PicRec)localObject1).groupFileID.set(l1 & 0xFFFFFFFF);
        if (localObject2 != null) {
          ((RichMsg.PicRec)localObject1).md5.set((String)localObject2);
        }
        ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
        ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(str3);
        ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str4);
        ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(m);
        ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(n);
        ((RichMsg.PicRec)localObject1).uint32_width.set(i1);
        ((RichMsg.PicRec)localObject1).uint32_height.set(i2);
        ((RichMsg.PicRec)localObject1).bigMsgUrl.set(str1);
        ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str2);
        ((RichMsg.PicRec)localObject1).fileSizeFlag.set(0);
        ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
        ((RichMsg.PicRec)localObject1).version.set(5);
        ((RichMsg.PicRec)localObject1).isReport.set(0);
        ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i3);
        if (i3 == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "[customFace] showLen =" + j + ",downloadLen = " + i + ",raw photo msg,clear progressjpg info!");
          }
          j = 0;
          i = 0;
        }
        for (;;)
        {
          ((RichMsg.PicRec)localObject1).uint32_show_len.set(j);
          ((RichMsg.PicRec)localObject1).uint32_download_len.set(i);
          ((RichMsg.PicRec)localObject1).enableEnc.set(true);
          ((RichMsg.PicRec)localObject1).uint32_image_type.set(k);
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("protocolStr:").append((String)localObject3).append("\n");
          }
          if (paramCustomFace.bytes_pb_reserve.has()) {
            ((RichMsg.PicRec)localObject1).bytes_pb_reserved.set(paramCustomFace.bytes_pb_reserve.get());
          }
          i = 0;
          if (paramCustomFace.bytes_pb_reserve.has()) {
            paramStringBuilder = new CustomFaceExtPb.ResvAttr();
          }
          for (;;)
          {
            try
            {
              paramStringBuilder.mergeFrom(paramCustomFace.bytes_pb_reserve.get().toByteArray());
              if (paramStringBuilder.msg_image_show.has())
              {
                paramElem = (MessageForPic)MessageRecordFactory.a(-5015);
                paramElem.msgtype = -5015;
                ((MessageForTroopEffectPic)paramElem).effectId = ((CustomFaceExtPb.AnimationImageShow)paramStringBuilder.msg_image_show.get()).int32_effect_id.get();
                paramElem.frienduin = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.group_code.get());
                paramElem.istroop = 1;
                paramCustomFace = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
                if (paramCustomFace != null) {
                  paramCustomFace.a((AIOAnimationControlManager.IAnimationMessage)paramElem, false);
                }
                i = 1;
                if (i == 0)
                {
                  paramElem = (MessageForPic)MessageRecordFactory.a(-2000);
                  paramElem.msgtype = -2000;
                }
                if (bool1) {
                  HotChatHelper.a(paramElem, false);
                }
                if (bool2) {
                  FlashPicHelper.a(paramElem, false);
                }
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                localStringBuilder.delete(0, localStringBuilder.length());
                return;
              }
            }
            catch (InvalidProtocolBufferMicroException paramElem)
            {
              paramElem.printStackTrace();
              continue;
            }
            paramElem = null;
          }
        }
      }
    }
  }
  
  public boolean a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Iterator localIterator = paramList1.iterator();
    paramList1 = null;
    Object localObject1 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (im_msg_body.Elem)localIterator.next();
      if (!((im_msg_body.Elem)localObject3).deliver_gift_msg.has()) {}
    }
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        return false;
        localObject2 = localObject1;
        if (((im_msg_body.Elem)localObject3).pub_group.has()) {
          localObject2 = ((im_msg_body.Elem)localObject3).pub_group.bytes_nickname.get().toStringUtf8();
        }
        localObject1 = localObject2;
        if (!((im_msg_body.Elem)localObject3).text.has()) {
          break;
        }
        localObject3 = ((im_msg_body.Text)((im_msg_body.Elem)localObject3).text.get()).str.get().toStringUtf8();
        localObject1 = localObject2;
        if (localObject3 == null) {
          break;
        }
        localObject1 = localObject2;
        if (!((String)localObject3).startsWith("@")) {
          break;
        }
        paramList1 = ((String)localObject3).substring(1);
        localObject1 = localObject2;
        break;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GiftMsg;\n");
      }
      paramList1 = a(localObject1, paramList1, ((im_msg_body.Elem)localObject2).deliver_gift_msg, paramList2, paramStringBuilder, paramMsg);
      paramList2 = new Intent("tencent.video.q2v.VideoSendGift");
      paramList2.putExtra("data", ((im_msg_body.Elem)localObject2).deliver_gift_msg.toByteArray());
      paramList2.putExtra("troopUin", paramList1.grayTipsEntity.troopUin);
      paramList2.putExtra("shmsgSeq", paramMsg.msg_head.msg_seq.get());
      paramList2.putExtra("senderName", paramList1.senderName);
      paramList2.putExtra("rcvName", paramList1.rcvName);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramList2);
      return true;
    }
  }
  
  public boolean a(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, String paramString)
  {
    Object localObject1 = null;
    Iterator localIterator = paramList1.iterator();
    String str1 = null;
    paramList1 = null;
    im_msg_body.Elem localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.pub_group.has()) {
        break label264;
      }
      str1 = localElem.pub_group.bytes_nickname.get().toStringUtf8();
    }
    label264:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localElem.text.has())
      {
        String str2 = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
        localObject2 = localObject1;
        if (str2 != null)
        {
          localObject2 = localObject1;
          if (str2.startsWith("@")) {
            localObject2 = str2.substring(1);
          }
        }
      }
      if (localElem.common_elem.has()) {
        paramList1 = localElem.common_elem;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        if (paramList1 == null) {
          return false;
        }
        localObject2 = new hummer_commelem.MsgElemInfo_servtype8();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype8)localObject2).mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:GiftMsg;\n");
          }
          paramList1 = a(str1, localObject1, ((hummer_commelem.MsgElemInfo_servtype8)localObject2).wifi_deliver_gift_msg, paramList2, paramStringBuilder, paramMsg);
          paramList1.frienduin = paramString;
          paramList1.isFromNearby = true;
          paramList2 = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
          if (paramList2 != null) {
            paramList2.b(paramList1);
          }
          return true;
        }
        catch (InvalidProtocolBufferMicroException paramList1)
        {
          return false;
        }
      }
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!localElem.market_trans.has()) {
        break label328;
      }
      localObject1 = (im_msg_body.MarketTrans)localElem.market_trans.get();
    }
    label328:
    for (;;)
    {
      break;
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
        a(paramList1, paramList2, true);
        return;
      }
      paramStringBuilder = paramList1.iterator();
      while (paramStringBuilder.hasNext())
      {
        localObject2 = (im_msg_body.Elem)paramStringBuilder.next();
        if ((((im_msg_body.Elem)localObject2).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.has())) {
          ((AbsStructMsg)localObject1).msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.get();
        }
      }
      paramList1 = a(paramList1, paramList2, false);
      if (paramList1 != null) {
        ((AbsStructMsg)localObject1).mCompatibleText = paramList1;
      }
      paramList1 = (MessageForStructing)MessageRecordFactory.a(-2011);
      paramList1.msgtype = -2011;
      paramList1.msg = "MarketTrans";
      paramList1.structingMsg = ((AbsStructMsg)localObject1);
      paramList1.msgData = paramList1.structingMsg.getBytes();
      paramList2.add(paramList1);
      return;
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    DingdongPluginManager localDingdongPluginManager = null;
    Object localObject = paramList1.iterator();
    do
    {
      paramList1 = localDingdongPluginManager;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList1.msg_workflow_notify.has());
    paramList1 = (im_msg_body.WorkflowNotifyMsg)paramList1.msg_workflow_notify.get();
    if (paramList1 == null) {}
    for (;;)
    {
      return;
      long l1 = paramMsg.msg_head.from_uin.get();
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("elemType: dingdong_msg;\n");
        QLog.i("Approval", 1, "recv Dingdong Msg from[" + l1 + "]");
      }
      try
      {
        localObject = new Qworkflow.Notification();
        ((Qworkflow.Notification)localObject).mergeFrom(paramList1.bytes_ext_msg.get().toByteArray());
        if (((Qworkflow.Notification)localObject).msg_workflow_change.has()) {}
        for (paramList1 = (Qworkflow.WorkflowChangeNotification)((Qworkflow.Notification)localObject).msg_workflow_change.get();; paramList1 = null)
        {
          l1 = ((Qworkflow.Notification)localObject).msg_appid.uint64_appid.get();
          localDingdongPluginManager = (DingdongPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(114);
          if (l1 == 1800000001L)
          {
            paramMsg = paramList1.bytes_workflow_id.get().toStringUtf8();
            i = paramList1.uint32_sub_type.get();
            long l2 = paramList1.uint64_author_uin.get();
            j = paramList1.enum_change_type.get();
            if (QLog.isColorLevel())
            {
              int k = paramList1.uint32_main_type.get();
              localObject = paramList1.bytes_title.get().toStringUtf8();
              String str = paramList1.msg_summary.bytes_content.get().toStringUtf8();
              int m = paramList1.enum_change_type.get();
              int n = paramList1.msg_current_state.uint32_state_num.get();
              paramStringBuilder.append("appid[").append(l1).append("]");
              paramStringBuilder.append("workId[").append(paramMsg).append("]");
              paramStringBuilder.append("mainType[").append(k).append("]");
              paramStringBuilder.append("subType[").append(i).append("]");
              paramStringBuilder.append("creator[").append(l2).append("]");
              paramStringBuilder.append("title[").append((String)localObject).append("]");
              paramStringBuilder.append("summary[").append(str).append("]");
              paramStringBuilder.append("notifyType[").append(m).append("]");
              paramStringBuilder.append("status[").append(n).append("]").append("\n");
            }
            if ((j >= 4) && (j <= 8))
            {
              paramStringBuilder = (MessageForApproval)MessageRecordFactory.a(-2040);
              paramStringBuilder.msgtype = -2040;
              paramStringBuilder.msgData = paramList1.toByteArray();
              paramStringBuilder.parse();
              paramList2.add(paramStringBuilder);
              if (j == 7) {
                localDingdongPluginManager.a(paramMsg);
              }
            }
            for (;;)
            {
              localDingdongPluginManager.a(paramMsg, i, l2);
              return;
              if (j == 8)
              {
                localDingdongPluginManager.b(paramMsg);
                continue;
                if ((j == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(l2))))
                {
                  paramStringBuilder = (MessageForGrayTips)MessageRecordFactory.a(-2041);
                  paramStringBuilder.saveExtInfoToExtStr("approval_workid", paramMsg);
                  paramStringBuilder.saveExtInfoToExtStr("approval_subtype", String.valueOf(i));
                  paramStringBuilder.msgtype = -2041;
                  paramStringBuilder.isread = true;
                  paramStringBuilder.issend = 0;
                  paramStringBuilder.msgData = paramList1.toByteArray();
                  paramList2.add(paramStringBuilder);
                }
                else if (j == 1)
                {
                  localDingdongPluginManager.c(paramMsg);
                }
              }
            }
          }
          if ((l1 != 1800000002L) || (!((Qworkflow.Notification)localObject).msg_schedule_change.has())) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DingdongScheduleMessage", 2, "A Schedule message");
          }
          ThreadManager.post(new ahjl(this), 5, null, true);
          int i = ((Qworkflow.Notification)localObject).msg_schedule_change.uint32_main_type.get();
          int j = ((Qworkflow.Notification)localObject).msg_schedule_change.uint32_sub_type.get();
          if ((i != 100) || (j != 1)) {
            break;
          }
          paramList1 = (MessageForDingdongSchedule)MessageRecordFactory.a(-5010);
          paramList1.msgData = ((Qworkflow.ScheduleChangeNotification)((Qworkflow.Notification)localObject).msg_schedule_change.get()).toByteArray();
          paramList1.parse();
          paramList1.scheduleC2CdataReport();
          ((DingdongPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(114)).a(paramList1, paramMsg.msg_head.msg_time.get());
          if (!paramList1.canShowInAIO()) {
            break;
          }
          paramList2.add(paramList1);
          return;
        }
        return;
      }
      catch (Exception paramList1) {}
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).common_elem.has()) {
        break label751;
      }
      localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject3).common_elem.get();
    }
    label572:
    label589:
    label751:
    for (;;)
    {
      break;
      localObject3 = a(paramList1);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems_FlashChat  common_lem" + localObject1 + ", text " + (String)localObject3);
      }
      if (localObject1 == null) {
        return;
      }
      if (((im_msg_body.CommonElem)localObject1).uint32_business_type.has()) {}
      for (int i = ((im_msg_body.CommonElem)localObject1).uint32_business_type.get();; i = 0)
      {
        localObject2 = new hummer_commelem.MsgElemInfo_servtype14();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype14)localObject2).mergeFrom(((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray());
          if (i != 0) {
            break label589;
          }
          if (!((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).b())
          {
            g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList1)
        {
          paramList1.printStackTrace();
          return;
        }
        if (!ArkAppCenter.b())
        {
          QLog.i("FlashChat", 1, "decodePBMsgElems_FlashChat is false, ignore msg.");
          return;
        }
        if ((!((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.has()) || (!((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.has())) {
          break;
        }
        int k = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.get();
        String str = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.get().toStringUtf8();
        if (!((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.has())
        {
          QLog.i("flashchat", 1, "ecodePBMsgElems_FlashChat, reserve_Info not exist.");
          return;
        }
        localObject2 = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.get().toByteArray();
        if ((localObject2 == null) || (localObject2.length <= 0))
        {
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat, reserve_Info empty.");
          return;
        }
        localObject1 = null;
        localObject2 = StructMsgUtils.a((byte[])localObject2, -1);
        if (localObject2 != null)
        {
          i = localObject2.length;
          if (i > 0)
          {
            try
            {
              localObject2 = new String((byte[])localObject2, "UTF-8");
              localObject1 = localObject2;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                label372:
                QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat convert failed");
              }
            }
            localObject2 = new ArkFlashChatMessage();
            ((ArkFlashChatMessage)localObject2).fromAppXml((String)localObject1);
            ((ArkFlashChatMessage)localObject2).appResId = k;
            ((ArkFlashChatMessage)localObject2).promptText = ((String)localObject3);
            localObject3 = (MessageForArkFlashChat)MessageRecordFactory.a(-5013);
            ((MessageForArkFlashChat)localObject3).msgtype = -5013;
            ((MessageForArkFlashChat)localObject3).msgData = ((ArkFlashChatMessage)localObject2).toBytes();
            ((MessageForArkFlashChat)localObject3).parse();
            if ((TextUtils.isEmpty(((MessageForArkFlashChat)localObject3).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkFlashChat)localObject3).ark_app_message.appView))) {
              break label572;
            }
            paramList2.add(localObject3);
          }
        }
        for (i = 1;; i = j)
        {
          QLog.d("flashchat", 2, "decodePBMsgElems_FlashChat id = " + k + ", reserveInfo = " + str + ", arkData = " + (String)localObject1);
          if (i != 0) {
            break;
          }
          g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
          return;
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat empty.");
          break label372;
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat not valid..");
        }
        if ((i != 1) || (!localException.uint32_id.has())) {
          break;
        }
        i = localException.uint32_id.get();
        paramStringBuilder = new HiBoomMessage();
        paramStringBuilder.id = i;
        paramStringBuilder.text = ((String)localObject3);
        paramList1 = (MessageForHiBoom)MessageRecordFactory.a(-5014);
        paramList1.mHiBoomMessage = paramStringBuilder;
        paramList1.msgtype = -5014;
        paramList1.msg = ((String)localObject3);
        try
        {
          paramList1.msgData = MessagePkgUtils.a(paramStringBuilder);
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.MessagePBElemDecoder", 2, "receive hiboom message id = " + i + "message = " + ((String)localObject3).charAt(0));
          }
          paramList2.add(paramList1);
          return;
        }
        catch (Exception paramStringBuilder)
        {
          for (;;)
          {
            QLog.e("HiBoomFont.MessagePBElemDecoder", 1, "getBytesFromObject error, ", paramStringBuilder);
          }
        }
      }
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, boolean paramBoolean)
  {
    Object localObject2 = new StringBuilder("");
    String str = null;
    int i = 0;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = new ArrayList(2);
    Object localObject1 = null;
    Iterator localIterator = paramList1.iterator();
    im_msg_body.Elem localElem;
    Object localObject4;
    MessageForText localMessageForText;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.custom_face.has())
      {
        localObject4 = localObject3;
        if (((StringBuilder)localObject2).length() > 0)
        {
          localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
          localMessageForText.msgtype = -1000;
          localMessageForText.msg = ((StringBuilder)localObject2).toString();
          localMessageForText.atInfoList = ((ArrayList)localObject3);
          localObject4 = new ArrayList(2);
          localArrayList1.add(localMessageForText);
          ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        }
        a(localElem, null, localArrayList1, paramStringBuilder, paramMsg, paramBoolean);
        localObject3 = localObject4;
      }
    }
    for (;;)
    {
      break;
      if (localElem.not_online_image.has())
      {
        localObject4 = localObject3;
        if (((StringBuilder)localObject2).length() > 0)
        {
          localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
          localMessageForText.msgtype = -1000;
          localMessageForText.msg = ((StringBuilder)localObject2).toString();
          localMessageForText.atInfoList = ((ArrayList)localObject3);
          localObject4 = new ArrayList(2);
          localArrayList1.add(localMessageForText);
          ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        }
        a(localElem, null, localArrayList1, paramStringBuilder, paramMsg);
        localObject3 = localObject4;
      }
      else
      {
        if (a(localElem).booleanValue())
        {
          if (i != 0)
          {
            i = 0;
            break;
          }
          if (localElem.small_emoji.has()) {
            i = 1;
          }
          localObject4 = new ArrayList();
          ((List)localObject4).add(localElem);
          localObject2 = a((StringBuilder)localObject2, (List)localObject4, localArrayList1, paramStringBuilder, paramMsg, paramMessageInfo, localArrayList2, (ArrayList)localObject3);
          continue;
        }
        if (localElem.general_flags.has())
        {
          localObject1 = (im_msg_body.GeneralFlags)localElem.general_flags.get();
          continue;
          if (((StringBuilder)localObject2).length() > 0)
          {
            localObject4 = (MessageForText)MessageRecordFactory.a(-1000);
            ((MessageForText)localObject4).msgtype = -1000;
            ((MessageForText)localObject4).msg = ((StringBuilder)localObject2).toString();
            ((MessageForText)localObject4).atInfoList = ((ArrayList)localObject3);
            if (paramMessageInfo != null) {
              AtTroopMemberSpan.a(paramMessageInfo.jdField_a_of_type_Int, (ArrayList)localObject3, (ChatMessage)localObject4);
            }
            localArrayList1.add(localObject4);
            ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
          }
          if ((localArrayList2 != null) && (localArrayList2.size() == 2)) {
            if (localArrayList2.get(0) != null)
            {
              localObject2 = (MessageForText.AtTroopMemberInfo)localArrayList2.get(0);
              if (localArrayList2.get(1) != null)
              {
                localObject4 = (byte[])localArrayList2.get(1);
                localObject3 = localObject2;
                localObject2 = localObject4;
              }
            }
          }
          for (;;)
          {
            paramStringBuilder = a(paramList1, paramStringBuilder);
            paramList1 = (MessageForReplyText.SourceMsgInfo)paramStringBuilder.first;
            localObject4 = (TroopTopicMgr.GroupPostElemInfo)paramStringBuilder.second;
            if (paramList1 != null) {
              paramStringBuilder = (MessageForReplyText)MessageRecordFactory.a(-1049);
            }
            try
            {
              str = HexUtil.a(MessagePkgUtils.a(paramList1));
              paramStringBuilder.mSourceMsgInfo = paramList1;
              paramStringBuilder.saveExtInfoToExtStr("sens_msg_source_msg_info", str);
              if (localObject4 != null)
              {
                paramList1 = HexUtil.a(MessagePkgUtils.a((Serializable)localObject4));
                paramStringBuilder.mGroupPostElemInfo = ((TroopTopicMgr.GroupPostElemInfo)localObject4);
                paramStringBuilder.saveExtInfoToExtStr("sens_msg_source_msg_troop_topic_info", paramList1);
              }
              paramStringBuilder.extLong |= 0x1;
            }
            catch (Exception paramList1)
            {
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramList1.getMessage());
                  continue;
                  paramList1 = paramStringBuilder;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("zivonchen", 2, "replytext 内容为空，有回复消息，但第一个消息体不是文本消息");
                    paramList1 = paramStringBuilder;
                    continue;
                    paramList1 = paramStringBuilder;
                    if (QLog.isColorLevel())
                    {
                      QLog.w("zivonchen", 2, "");
                      paramList1 = paramStringBuilder;
                    }
                  }
                }
              }
            }
            paramList1 = paramStringBuilder;
            if (TextUtils.isEmpty(paramStringBuilder.mSourceMsgInfo.mAnonymousNickName))
            {
              paramList1 = paramStringBuilder;
              if (localObject3 != null)
              {
                if (localArrayList1.size() <= 0) {
                  break label1376;
                }
                paramList1 = (MessageRecord)localArrayList1.get(0);
                if (!(paramList1 instanceof MessageForText)) {
                  break label1353;
                }
                localObject4 = (MessageForReplyText)MessageRecordFactory.a(-1049);
                MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject4, paramList1);
                MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject4, paramList1);
                ((MessageForReplyText)localObject4).atInfoList = paramStringBuilder.atInfoList;
                ((MessageForReplyText)localObject4).msg = paramList1.msg;
                ((MessageForReplyText)localObject4).mGroupPostElemInfo = paramStringBuilder.mGroupPostElemInfo;
                ((MessageForReplyText)localObject4).mSourceMsgInfo = paramStringBuilder.mSourceMsgInfo;
                ((MessageForReplyText)localObject4).msgtype = -1049;
                if ((!TextUtils.isEmpty(((MessageForReplyText)localObject4).msg)) && (((MessageForReplyText)localObject4).msg.length() >= ((MessageForText.AtTroopMemberInfo)localObject3).textLen + 1))
                {
                  ((MessageForReplyText)localObject4).msg = ((MessageForReplyText)localObject4).msg.substring(((MessageForText.AtTroopMemberInfo)localObject3).textLen + 1);
                  if (((MessageForText.AtTroopMemberInfo)localObject3).isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin())) {
                    paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = -1L;
                  }
                }
                localArrayList1.remove(0);
                localArrayList1.add(0, localObject4);
                paramList1 = null;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("zivonchen", 2, "sb.length == 0");
            }
            if (paramList1 != null) {
              localArrayList1.add(0, paramList1);
            }
            if ((localObject1 != null) && (((im_msg_body.GeneralFlags)localObject1).babyq_guide_msg_cookie.has())) {}
            try
            {
              if (localArrayList1.size() > 0)
              {
                paramList1 = (MessageRecord)localArrayList1.get(0);
                paramStringBuilder = ((im_msg_body.GeneralFlags)localObject1).babyq_guide_msg_cookie.get().toByteArray();
                localObject4 = Utils.a(paramStringBuilder);
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, "decodePBMsgElems_Pic, guideMsgCookie: " + (String)localObject4 + " ,byte: " + Arrays.toString(((im_msg_body.GeneralFlags)localObject1).babyq_guide_msg_cookie.get().toByteArray()));
                }
                paramList1.saveExtInfoToExtStr("guide_msg_cookie", (String)localObject4);
                ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramStringBuilder);
              }
            }
            catch (Exception paramList1)
            {
              for (;;)
              {
                int j;
                long l;
                int k;
                int m;
                if (QLog.isColorLevel())
                {
                  QLog.d("DecodeMsg", 2, "get pic msg guideMsgCookie error!", paramList1);
                  continue;
                  if (paramStringBuilder.msgtype == -2000)
                  {
                    j += 1;
                    continue;
                    continue;
                    if (j != 0)
                    {
                      paramStringBuilder = new ArrayList();
                      paramMsg = localArrayList1.iterator();
                      while (paramMsg.hasNext())
                      {
                        localObject1 = (MessageRecord)paramMsg.next();
                        if ((((MessageRecord)localObject1).msgtype != -1000) && (((MessageRecord)localObject1).msgtype != -1049) && (((MessageRecord)localObject1).msgtype != -2000))
                        {
                          if (paramStringBuilder.size() > 0) {
                            if (k == 0) {
                              break label1618;
                            }
                          }
                          for (paramList1 = null;; paramList1 = (List)localObject2)
                          {
                            paramList2.add(MessageProtoCodec.a(paramStringBuilder, paramList1, paramMessageInfo));
                            paramStringBuilder.clear();
                            paramList2.add(localObject1);
                            break;
                          }
                        }
                        paramStringBuilder.add(localObject1);
                      }
                      if (paramStringBuilder.size() > 0)
                      {
                        if (k != 0) {
                          localObject2 = null;
                        }
                        paramList1 = MessageProtoCodec.a(paramStringBuilder, (byte[])localObject2, paramMessageInfo);
                        paramList2.add(paramList1);
                        ((MessageForMixedMsg)paramList1).mAtInfo = ((MessageForText.AtTroopMemberInfo)localObject3);
                        paramStringBuilder.clear();
                      }
                    }
                    for (;;)
                    {
                      return;
                      if (localObject2 == null)
                      {
                        paramList2.addAll(localArrayList1);
                        return;
                      }
                      paramList1 = localArrayList1.iterator();
                      while (paramList1.hasNext())
                      {
                        paramStringBuilder = (MessageRecord)paramList1.next();
                        if (((paramStringBuilder instanceof MessageForText)) && (k == 0)) {
                          paramStringBuilder.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a((byte[])localObject2));
                        }
                        paramList2.add(paramStringBuilder);
                      }
                    }
                    i = 0;
                    paramList1 = null;
                    continue;
                    k = 0;
                  }
                  else
                  {
                    continue;
                    j = 0;
                  }
                }
              }
            }
            if (localArrayList1.size() > 1)
            {
              paramList1 = localArrayList1.iterator();
              j = 0;
              i = 0;
              if (paramList1.hasNext())
              {
                paramStringBuilder = (MessageRecord)paramList1.next();
                if (((paramStringBuilder.msgtype == -1000) || (paramStringBuilder.msgtype == -1049)) && (i == 0))
                {
                  i = 1;
                  j += 1;
                  if (j < 2) {
                    break label1437;
                  }
                  j = 1;
                  if (!paramMsg.msg_head.from_uin.has()) {
                    break label1771;
                  }
                  l = paramMsg.msg_head.from_uin.get();
                  if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin(), Long.toString(l))) {
                    break label1771;
                  }
                  k = 1;
                  m = 0;
                  paramStringBuilder = null;
                  if ((localObject1 == null) || (!((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.has())) {
                    break label1763;
                  }
                }
                try
                {
                  paramMsg = new generalflags.ResvAttr();
                  paramMsg.mergeFrom(((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.get().toByteArray());
                  paramList1 = paramStringBuilder;
                  i = m;
                  if (paramMsg.bytes_kpl_info.has())
                  {
                    paramList1 = paramStringBuilder;
                    i = m;
                    if (paramMsg.bytes_kpl_info.has())
                    {
                      i = 1;
                      paramList1 = paramMsg.bytes_kpl_info.get().toStringUtf8();
                    }
                  }
                }
                catch (Exception paramList1)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
                    }
                    paramList1.printStackTrace();
                    i = 0;
                    paramList1 = null;
                  }
                  if (!QLog.isColorLevel()) {
                    break label1485;
                  }
                  QLog.d("KplMessage", 2, "resv a kpl pic message !");
                  KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList1);
                }
                if (i != 0)
                {
                  paramStringBuilder = localArrayList1.iterator();
                  while (paramStringBuilder.hasNext()) {
                    ((MessageRecord)paramStringBuilder.next()).saveExtInfoToExtStr("msg_ext_key", "Y");
                  }
                }
              }
            }
            label1353:
            label1376:
            label1763:
            label1771:
            localObject4 = null;
            label1437:
            label1485:
            label1618:
            localObject3 = localObject2;
            localObject2 = localObject4;
            continue;
            localObject2 = null;
            break;
            localObject2 = null;
            localObject3 = str;
          }
        }
      }
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList1 = paramList1.iterator();
    Object localObject;
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)paramList1.next();
    } while (!((im_msg_body.Elem)localObject).common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {}
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "decodePBMsgElems_FlashPicCommen isC2C=" + paramBoolean);
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("ELEM_FlashPicCommen;\n");
          }
          localObject = new hummer_commelem.MsgElemInfo_servtype3();
          try
          {
            ((hummer_commelem.MsgElemInfo_servtype3)localObject).mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
            if (!paramBoolean)
            {
              if (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.has()) {
                continue;
              }
              a(null, (im_msg_body.CustomFace)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.get(), paramList2, paramStringBuilder, paramMsg, paramBoolean);
            }
          }
          catch (InvalidProtocolBufferMicroException paramList1)
          {
            paramList1.printStackTrace();
            return;
          }
        }
      } while (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.has());
      a(null, (im_msg_body.NotOnlineImage)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.get(), paramList2, paramStringBuilder, paramMsg);
      return;
    }
  }
  
  public void b(List paramList1, List paramList2, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    int i = 0;
    if (i < paramList1.size()) {
      if (!((im_msg_body.Elem)paramList1.get(i)).apollo_msg.has()) {}
    }
    for (im_msg_body.ApolloActMsg localApolloActMsg = (im_msg_body.ApolloActMsg)((im_msg_body.Elem)paramList1.get(i)).apollo_msg.get();; localApolloActMsg = null)
    {
      if (localApolloActMsg == null) {}
      int i3;
      float f2;
      int i1;
      int i2;
      int i4;
      long l1;
      Object localObject1;
      Object localObject5;
      List localList;
      ApolloMsgExtend.AuthReserve localAuthReserve;
      long l4;
      label2066:
      do
      {
        do
        {
          return;
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:Apollo...\n");
          }
        } while (localApolloActMsg == null);
        try
        {
          ApolloMessage localApolloMessage = new ApolloMessage();
          localApolloMessage.id = localApolloActMsg.uint32_action_id.get();
          localApolloMessage.name = localApolloActMsg.bytes_action_name.get().toByteArray();
          if ((!paramBoolean) && (localApolloActMsg.bytes_action_text.has())) {
            localApolloMessage.text = localApolloActMsg.bytes_action_text.get().toByteArray();
          }
          i3 = -1;
          f2 = 0.0F;
          long l5 = 0L;
          i1 = -1;
          i2 = 0;
          i = 0;
          i4 = 0;
          l1 = 0L;
          ArrayList localArrayList = new ArrayList();
          Object localObject6 = null;
          paramStringBuilder = null;
          localObject1 = null;
          localObject5 = null;
          Iterator localIterator = null;
          localList = null;
          localAuthReserve = new ApolloMsgExtend.AuthReserve();
          localObject2 = localIterator;
          localObject3 = localObject5;
          localObject4 = localObject6;
          m = i4;
          l2 = l1;
          k = i2;
          j = i1;
          l3 = l5;
          f1 = f2;
          n = i3;
          try
          {
            localAuthReserve.mergeFrom(localApolloActMsg.bytes_pb_reserve.get().toByteArray());
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l1;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            i3 = localAuthReserve.diy_voice_id.get();
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l1;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            f2 = (float)localAuthReserve.diy_voice_begin_ts.get();
            f1 = 1000.0F;
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l1;
            k = i2;
            j = i1;
            l3 = l5;
            n = i3;
            f2 /= 1000.0F;
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l1;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            i1 = localAuthReserve.sub_type.get();
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l1;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            i2 = localAuthReserve.game_id.get();
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l1;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            l4 = localAuthReserve.room_id.get();
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            localAuthReserve.img_type.get();
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            if (localAuthReserve.game_text.has())
            {
              localObject2 = localIterator;
              localObject3 = localObject5;
              localObject4 = localObject6;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l5;
              f1 = f2;
              n = i3;
              if (localAuthReserve.game_text.get() != null)
              {
                localObject2 = localIterator;
                localObject3 = localObject5;
                localObject4 = localObject6;
                m = i4;
                l2 = l4;
                k = i2;
                j = i1;
                l3 = l5;
                f1 = f2;
                n = i3;
                new String(localAuthReserve.game_text.get().toByteArray());
              }
            }
            paramList1 = paramStringBuilder;
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = localObject6;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            if (localAuthReserve.game_name.has())
            {
              paramList1 = paramStringBuilder;
              localObject2 = localIterator;
              localObject3 = localObject5;
              localObject4 = localObject6;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l5;
              f1 = f2;
              n = i3;
              if (localAuthReserve.game_name.get() != null)
              {
                localObject2 = localIterator;
                localObject3 = localObject5;
                localObject4 = localObject6;
                m = i4;
                l2 = l4;
                k = i2;
                j = i1;
                l3 = l5;
                f1 = f2;
                n = i3;
                paramList1 = new String(localAuthReserve.game_name.get().toByteArray());
              }
            }
            paramStringBuilder = localList;
            localObject2 = localIterator;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            if (localAuthReserve.game_share_ark_json.has())
            {
              paramStringBuilder = localList;
              localObject2 = localIterator;
              localObject3 = localObject5;
              localObject4 = paramList1;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l5;
              f1 = f2;
              n = i3;
              if (localAuthReserve.game_share_ark_json.get() != null)
              {
                localObject2 = localIterator;
                localObject3 = localObject5;
                localObject4 = paramList1;
                m = i4;
                l2 = l4;
                k = i2;
                j = i1;
                l3 = l5;
                f1 = f2;
                n = i3;
                paramStringBuilder = new String(localAuthReserve.game_share_ark_json.get().toByteArray());
              }
            }
            l1 = l5;
            localObject2 = paramStringBuilder;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l5;
            f1 = f2;
            n = i3;
            if (localAuthReserve.sign_ts.has())
            {
              localObject2 = paramStringBuilder;
              localObject3 = localObject5;
              localObject4 = paramList1;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l5;
              f1 = f2;
              n = i3;
              l1 = localAuthReserve.sign_ts.get();
            }
            localObject2 = paramStringBuilder;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l1;
            f1 = f2;
            n = i3;
            if (localAuthReserve.game_ver_735.has())
            {
              localObject2 = paramStringBuilder;
              localObject3 = localObject5;
              localObject4 = paramList1;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l1;
              f1 = f2;
              n = i3;
              l5 = localAuthReserve.game_ver_735.get();
              if (l5 != 0L)
              {
                localObject2 = paramStringBuilder;
                localObject3 = localObject5;
                localObject4 = paramList1;
                m = i4;
                l2 = l4;
                k = i2;
                j = i1;
                l3 = l1;
                f1 = f2;
                n = i3;
                if (l5 > ApolloUtil.a(2))
                {
                  localObject2 = paramStringBuilder;
                  localObject3 = localObject5;
                  localObject4 = paramList1;
                  m = i4;
                  l2 = l4;
                  k = i2;
                  j = i1;
                  l3 = l1;
                  f1 = f2;
                  n = i3;
                  ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
                }
              }
            }
            localObject2 = paramStringBuilder;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l1;
            f1 = f2;
            n = i3;
            if (localAuthReserve.action_ver.has())
            {
              localObject2 = paramStringBuilder;
              localObject3 = localObject5;
              localObject4 = paramList1;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l1;
              f1 = f2;
              n = i3;
              l5 = localAuthReserve.action_ver.get();
              if (l5 != 0L)
              {
                localObject2 = paramStringBuilder;
                localObject3 = localObject5;
                localObject4 = paramList1;
                m = i4;
                l2 = l4;
                k = i2;
                j = i1;
                l3 = l1;
                f1 = f2;
                n = i3;
                if (l5 > ApolloUtil.a(1))
                {
                  localObject2 = paramStringBuilder;
                  localObject3 = localObject5;
                  localObject4 = paramList1;
                  m = i4;
                  l2 = l4;
                  k = i2;
                  j = i1;
                  l3 = l1;
                  f1 = f2;
                  n = i3;
                  ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
                }
              }
            }
            localObject2 = paramStringBuilder;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l1;
            f1 = f2;
            n = i3;
            if (localAuthReserve.slave_action_id.has())
            {
              localObject2 = paramStringBuilder;
              localObject3 = localObject5;
              localObject4 = paramList1;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l1;
              f1 = f2;
              n = i3;
              localAuthReserve.slave_action_id.get();
            }
            localObject2 = paramStringBuilder;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l1;
            f1 = f2;
            n = i3;
            if (!localAuthReserve.slave_uin_list.has()) {
              break label2553;
            }
            localObject2 = paramStringBuilder;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l1;
            f1 = f2;
            n = i3;
            localList = localAuthReserve.slave_uin_list.get();
            if (localList == null) {
              break label2553;
            }
            localObject2 = paramStringBuilder;
            localObject3 = localObject5;
            localObject4 = paramList1;
            m = i4;
            l2 = l4;
            k = i2;
            j = i1;
            l3 = l1;
            f1 = f2;
            n = i3;
            localIterator = localList.iterator();
            for (;;)
            {
              localObject2 = paramStringBuilder;
              localObject3 = localObject5;
              localObject4 = paramList1;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l1;
              f1 = f2;
              n = i3;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = paramStringBuilder;
              localObject3 = localObject5;
              localObject4 = paramList1;
              m = i4;
              l2 = l4;
              k = i2;
              j = i1;
              l3 = l1;
              f1 = f2;
              n = i3;
              localArrayList.add(Long.valueOf(Utils.a(((Integer)localIterator.next()).intValue())));
            }
            localObject3 = new JSONObject();
          }
          catch (InvalidProtocolBufferMicroException paramList1)
          {
            paramList1.printStackTrace();
            i1 = 0;
            paramList1 = (List)localObject4;
            i = k;
            l1 = l3;
            i3 = n;
            k = j;
            j = i;
            i = i1;
            localObject1 = localObject3;
            paramStringBuilder = (StringBuilder)localObject2;
          }
          if (!localApolloActMsg.input_text.has()) {
            break label2885;
          }
          localObject2 = new String(localApolloActMsg.input_text.get().toByteArray());
          ((JSONObject)localObject3).put("inputText", localObject2);
          if (i3 > 0)
          {
            ((JSONObject)localObject3).put("audioID", i3);
            ((JSONObject)localObject3).put("audioStartTime", f1);
          }
          if (ApolloGameUtil.a(k))
          {
            ((JSONObject)localObject3).put("gameId", j);
            ((JSONObject)localObject3).put("gameMode", m);
            ((JSONObject)localObject3).put("roomid", l2);
            ((JSONObject)localObject3).put("msgTyep", k);
            ((JSONObject)localObject3).put("gameName", paramList1);
            ((JSONObject)localObject3).put("gameExtendJson", paramStringBuilder);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((JSONObject)localObject3).put("extendJson", localObject1);
          }
          ((JSONObject)localObject3).put("actionType", i);
          localApolloMessage.extStr = ((JSONObject)localObject3).toString();
          localApolloMessage.flag = localApolloActMsg.uint32_flag.get();
          localApolloMessage.peer_uin = Utils.a(localApolloActMsg.uint32_peer_uin.get());
          localApolloMessage.sender_ts = Utils.a(localApolloActMsg.uint32_sender_ts.get());
          localApolloMessage.peer_ts = Utils.a(localApolloActMsg.uint32_peer_ts.get());
          localApolloMessage.sender_status = localApolloActMsg.int32_sender_status.get();
          localApolloMessage.peer_status = localApolloActMsg.int32_peer_status.get();
          localObject3 = (MessageForApollo)MessageRecordFactory.a(-2039);
          ((MessageForApollo)localObject3).msgtype = -2039;
          ((MessageForApollo)localObject3).mApolloMessage = localApolloMessage;
          ((MessageForApollo)localObject3).msgData = MessagePkgUtils.a(localApolloMessage);
          ((MessageForApollo)localObject3).inputText = ((String)localObject2);
          ((MessageForApollo)localObject3).audioId = i3;
          ((MessageForApollo)localObject3).audioStartTime = f1;
          ((MessageForApollo)localObject3).msgType = k;
          ((MessageForApollo)localObject3).gameId = j;
          ((MessageForApollo)localObject3).mGameMode = m;
          ((MessageForApollo)localObject3).roomId = l2;
          ((MessageForApollo)localObject3).signTs = l1;
          ((MessageForApollo)localObject3).gameName = paramList1;
          ((MessageForApollo)localObject3).actionType = i;
          ((MessageForApollo)localObject3).extendJson = ((String)localObject1);
          ((MessageForApollo)localObject3).gameExtendJson = paramStringBuilder;
          paramList2.add(localObject3);
          return;
        }
        catch (Throwable paramList1) {}
      } while (!QLog.isColorLevel());
      QLog.e("DecodeMsg", 2, "decode apollo msg failed", paramList1);
      return;
      Object localObject2 = paramStringBuilder;
      Object localObject3 = localObject5;
      Object localObject4 = paramList1;
      int m = i4;
      long l2 = l4;
      int k = i2;
      int j = i1;
      long l3 = l1;
      float f1 = f2;
      int n = i3;
      if (QLog.isColorLevel())
      {
        localObject2 = paramStringBuilder;
        localObject3 = localObject5;
        localObject4 = paramList1;
        m = i4;
        l2 = l4;
        k = i2;
        j = i1;
        l3 = l1;
        f1 = f2;
        n = i3;
        QLog.d("DecodeMsg", 2, "slave size:" + localList.size());
      }
      label2553:
      localObject2 = paramStringBuilder;
      localObject3 = localObject5;
      localObject4 = paramList1;
      m = i4;
      l2 = l4;
      k = i2;
      j = i1;
      l3 = l1;
      f1 = f2;
      n = i3;
      if (localAuthReserve.game_mode.has())
      {
        localObject2 = paramStringBuilder;
        localObject3 = localObject5;
        localObject4 = paramList1;
        m = i4;
        l2 = l4;
        k = i2;
        j = i1;
        l3 = l1;
        f1 = f2;
        n = i3;
        i = localAuthReserve.game_mode.get();
      }
      localObject2 = paramStringBuilder;
      localObject3 = localObject5;
      localObject4 = paramList1;
      m = i;
      l2 = l4;
      k = i2;
      j = i1;
      l3 = l1;
      f1 = f2;
      n = i3;
      if (localAuthReserve.extend_json.has())
      {
        localObject2 = paramStringBuilder;
        localObject3 = localObject5;
        localObject4 = paramList1;
        m = i;
        l2 = l4;
        k = i2;
        j = i1;
        l3 = l1;
        f1 = f2;
        n = i3;
        localObject1 = new String(localAuthReserve.extend_json.get().toByteArray());
      }
      localObject2 = paramStringBuilder;
      localObject3 = localObject1;
      localObject4 = paramList1;
      m = i;
      l2 = l4;
      k = i2;
      j = i1;
      l3 = l1;
      f1 = f2;
      n = i3;
      if (localAuthReserve.action_type.has())
      {
        localObject2 = paramStringBuilder;
        localObject3 = localObject1;
        localObject4 = paramList1;
        m = i;
        l2 = l4;
        k = i2;
        j = i1;
        l3 = l1;
        f1 = f2;
        n = i3;
        i4 = localAuthReserve.action_type.get();
      }
      for (j = i4;; j = 0)
      {
        m = i;
        f1 = f2;
        k = i1;
        i = j;
        l2 = l4;
        j = i2;
        break;
        label2885:
        localObject2 = null;
        break label2066;
      }
    }
  }
  
  public void c(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    MessageForIncompatibleGrayTips localMessageForIncompatibleGrayTips = null;
    Iterator localIterator = paramList1.iterator();
    do
    {
      paramList1 = localMessageForIncompatibleGrayTips;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList1 = (im_msg_body.Elem)localIterator.next();
    } while (!paramList1.tips_info.has());
    paramList1 = (im_msg_body.TipsInfo)paramList1.tips_info.get();
    if (paramList1 == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TipsInfo;\n");
      }
      localMessageForIncompatibleGrayTips = (MessageForIncompatibleGrayTips)MessageRecordFactory.a(-5002);
      if (localMessageForIncompatibleGrayTips.parseTextXML(paramList1.text.get()).booleanValue())
      {
        paramList2.add(localMessageForIncompatibleGrayTips);
        return;
      }
    } while (!QLog.isColorLevel());
    paramStringBuilder.append("TipsInfo parse failed;\n");
  }
  
  public void c(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!localElem.trans_elem_info.has()) {
        break label1378;
      }
      localObject1 = (im_msg_body.TransElem)localElem.trans_elem_info.get();
    }
    label416:
    label721:
    label723:
    label1370:
    label1378:
    for (;;)
    {
      break;
      if (localObject1 == null) {}
      int i;
      int j;
      Object localObject3;
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:TransElemInfo;\n");
            }
            i = ((im_msg_body.TransElem)localObject1).elem_type.get();
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("transElemType:").append(i).append(";\n");
            }
            localObject2 = ((im_msg_body.TransElem)localObject1).elem_value.get().toByteArray();
            if ((localObject2 == null) || (localObject2.length == 0))
            {
              paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
              return;
            }
            switch (i)
            {
            default: 
              return;
            case 3: 
              paramList1 = BaseApplication.getContext().getString(2131436281);
              paramStringBuilder = (MessageForText)MessageRecordFactory.a(-1000);
              paramStringBuilder.msgtype = -1000;
              paramStringBuilder.msg = paramList1;
              paramList2.add(paramStringBuilder);
              return;
            }
          } while (localObject2[0] != 1);
          i = PkgTools.a((byte[])localObject2, 1);
          j = localObject2[3];
          localObject1 = new byte[i - 1];
          PkgTools.a((byte[])localObject1, 0, (byte[])localObject2, 4, i - 1);
          paramStringBuilder = (StringBuilder)localObject1;
          if (j == 1) {
            paramStringBuilder = a((byte[])localObject1);
          }
          if (paramStringBuilder == null) {
            break label1370;
          }
          try
          {
            if (paramStringBuilder.length <= 0) {
              break label1370;
            }
            paramStringBuilder = new String(paramStringBuilder, "utf-8");
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              long l;
              paramList1 = "";
              paramStringBuilder = null;
            }
          }
          try
          {
            localObject1 = a(paramStringBuilder);
            if (localObject1 == null) {
              break label531;
            }
            try
            {
              paramList1 = paramList1.iterator();
              while (paramList1.hasNext())
              {
                localObject2 = (im_msg_body.Elem)paramList1.next();
                if ((((im_msg_body.Elem)localObject2).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.has())) {
                  ((PAMessage)localObject1).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.get();
                }
              }
              ((Exception)localObject1).printStackTrace();
            }
            catch (Exception localException4)
            {
              paramList1 = (List)localObject1;
              localObject1 = localException4;
              localObject3 = paramStringBuilder;
              paramStringBuilder = paramList1;
              paramList1 = (List)localObject3;
            }
          }
          catch (Exception localException3)
          {
            localObject3 = null;
            paramList1 = paramStringBuilder;
            paramStringBuilder = (StringBuilder)localObject3;
            break label416;
            paramList1 = null;
            break label1181;
          }
          if (!paramMsg.msg_head.from_uin.has()) {
            break;
          }
          l = paramMsg.msg_head.from_uin.get();
        } while (PAWeatherItemBuilder.a(l + ""));
      } while (paramStringBuilder == null);
      paramMsg = (MessageForPubAccount)MessageRecordFactory.a(-3006);
      paramMsg.msgtype = -3006;
      paramMsg.msg = paramList1.toString();
      paramMsg.mPAMessage = paramStringBuilder;
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramMsg.msgData = PAMessageUtil.a(paramStringBuilder);
            paramList2.add(paramMsg);
            return;
            paramList1 = paramStringBuilder;
            paramStringBuilder = (StringBuilder)localObject1;
          }
          catch (Exception paramList1)
          {
            paramList1.printStackTrace();
            continue;
          }
          int k = ((im_msg_body.TransElem)localObject1).elem_value.get().size();
          j = 0;
          i = 0;
          for (;;)
          {
            if (k <= 3) {
              break label721;
            }
            int m = j + 1;
            if (j > 100) {
              break;
            }
            int n = localObject3[i];
            int i1 = PkgTools.a((byte[])localObject3, i + 1);
            j = k - (i1 + 3);
            k = i1 + 3 + i;
            if (n != 1)
            {
              i = k;
              k = j;
              j = m;
            }
            else
            {
              paramList1 = new byte[i1];
              PkgTools.a(paramList1, 0, (byte[])localObject3, i + 3, i1);
              paramStringBuilder = new obj_msg.ObjMsg();
              try
              {
                paramList1 = (obj_msg.ObjMsg)paramStringBuilder.mergeFrom(paramList1);
                if (paramList1.uint32_msg_type.get() == 6L) {
                  break label723;
                }
                i = k;
                k = j;
                j = m;
              }
              catch (Exception paramList1)
              {
                i = k;
                k = j;
                j = m;
              }
            }
          }
          break;
          paramStringBuilder = new TroopFileData();
          paramStringBuilder.fileUrl = new String(((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
          paramStringBuilder.bisID = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
          paramStringBuilder.fileName = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.str_file_name.get();
          paramStringBuilder.lfileSize = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.uint64_file_size.get();
          paramStringBuilder.lastTime = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.int64_dead_time.get();
          paramStringBuilder.sha1 = new String(((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
          paramStringBuilder.uuid = UUID.nameUUIDFromBytes(paramStringBuilder.fileUrl.getBytes()).toString();
          if (((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
            localObject1 = ((obj_msg.MsgContentInfo)paramList1.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
          }
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            paramStringBuilder.width = ((JSONObject)localObject1).optInt("width");
            paramStringBuilder.height = ((JSONObject)localObject1).optInt("height");
            paramStringBuilder.duration = ((JSONObject)localObject1).optInt("duration");
            paramStringBuilder.dspFileName = new String(paramList1.bytes_title.get().toByteArray());
            paramStringBuilder.dspFileName = FileManagerUtil.a(paramStringBuilder.dspFileName);
            paramStringBuilder.dspFileSize = new String(((ByteStringMicro)paramList1.rpt_bytes_abstact.get(0)).toByteArray());
            TroopFileDataManager.a(paramMsg.msg_head.group_info.group_code.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, paramStringBuilder.fileUrl, paramStringBuilder);
            localObject1 = new StringBuilder("decodePBMshElems==>").append(paramStringBuilder.toString());
            paramList1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, paramMsg.msg_head.group_info.group_code.get()).a(paramStringBuilder.fileUrl);
            if (paramList1 != null)
            {
              paramList1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().a(paramList1.d);
              if (paramList1 != null) {
                paramList1.lastTime = paramStringBuilder.lastTime;
              }
              localObject3 = (MessageForTroopFile)MessageRecordFactory.a(-2017);
              ((MessageForTroopFile)localObject3).msgtype = -2017;
              ((MessageForTroopFile)localObject3).msg = "[群文件]";
            }
          }
          catch (Exception localException1)
          {
            try
            {
              ((MessageForTroopFile)localObject3).msgData = MessagePkgUtils.a(paramStringBuilder);
              ((MessageForTroopFile)localObject3).parse();
              paramList2.add(localObject3);
              if (paramList1 != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().a(paramMsg.msg_head.group_info.group_code.get() + "", 1, paramList1.structMsgSeq, ((MessageForTroopFile)localObject3).msgData);
                ((StringBuilder)localObject1).append("|updateMsgContentByUniseq, msgSeq:").append(paramList1.structMsgSeq);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DecodeMsg", 2, ((StringBuilder)localObject1).toString());
              return;
              localException1 = localException1;
              localException1.printStackTrace();
            }
            catch (Exception paramStringBuilder)
            {
              for (;;)
              {
                paramStringBuilder.printStackTrace();
              }
            }
          }
        }
        paramList1 = "";
        paramStringBuilder = null;
      }
    }
  }
  
  public void c(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    Object localObject3;
    for (im_msg_body.CommonElem localCommonElem = null; ((Iterator)localObject2).hasNext(); localCommonElem = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject3).common_elem.get())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).common_elem.has()) {
        break label498;
      }
    }
    a(paramList1);
    if (QLog.isColorLevel()) {
      QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply  common_lem" + localCommonElem);
    }
    if (localCommonElem == null) {
      return;
    }
    localObject2 = new hummer_commelem.MsgElemInfo_servtype19();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype19)localObject2).mergeFrom(localCommonElem.bytes_pb_elem.get().toByteArray());
      if (!ArkAppCenter.b())
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply is false, ignore msg.");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramList1)
    {
      paramList1.printStackTrace();
      return;
    }
    if (((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.has())
    {
      ((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.get().toStringUtf8();
      localObject2 = ((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0))
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data empty.");
        return;
      }
      localObject2 = StructMsgUtils.a((byte[])localObject2, -1);
      if (localObject2 != null)
      {
        int i = localObject2.length;
        if (i > 0)
        {
          try
          {
            localObject2 = new String((byte[])localObject2, "UTF-8");
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              label257:
              QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply convert failed");
            }
          }
          localObject2 = a(paramList1, paramList2, false);
          localObject3 = (MessageForArkBabyqReply)MessageRecordFactory.a(-5016);
          ((MessageForArkBabyqReply)localObject3).msgtype = -5016;
          if (localObject2 != null) {
            ((MessageForArkBabyqReply)localObject3).compatibleMsg = ((String)localObject2);
          }
          ((MessageForArkBabyqReply)localObject3).fromAppXml(localObject1);
          if (localCommonElem.uint32_business_type.get() == 2) {
            break label501;
          }
        }
      }
    }
    label498:
    label501:
    for (boolean bool = true;; bool = false)
    {
      ((MessageForArkBabyqReply)localObject3).showAsBabyq = bool;
      ((MessageForArkBabyqReply)localObject3).msgData = ((MessageForArkBabyqReply)localObject3).toBytes();
      ((MessageForArkBabyqReply)localObject3).parse();
      if ((TextUtils.isEmpty(((MessageForArkBabyqReply)localObject3).babyqReplyText)) && (!((MessageForArkBabyqReply)localObject3).isFailed) && ((((MessageForArkBabyqReply)localObject3).mArkBabyqReplyCardList == null) || (((MessageForArkBabyqReply)localObject3).mArkBabyqReplyCardList.size() <= 0))) {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply not valid..");
      }
      for (bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply hasArkBabyQMsg = " + bool);
        }
        if (bool) {
          break;
        }
        g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
        return;
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply empty.");
        break label257;
        paramList2.add(localObject3);
      }
      QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data not exist.");
      return;
      break;
    }
  }
  
  public void d(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    paramList1 = paramList1.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList1.next();
    } while (!localElem.common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:QQStoryComment;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype5();
      try
      {
        paramStringBuilder.mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
        paramList1 = (MessageForQQStoryComment)MessageRecordFactory.a(-2052);
        paramList1.vid = paramStringBuilder.vid.get().toStringUtf8();
        paramList1.comment = paramStringBuilder.comment_content.get().toStringUtf8();
        paramList1.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
        paramList1.title = paramStringBuilder.title.get().toStringUtf8();
        paramList1.summary = paramStringBuilder.summary.get().toStringUtf8();
        paramList1.createTime = paramStringBuilder.createTime.get();
        paramList1.author = paramStringBuilder.author.get();
        paramList1.prewrite();
        paramList2.add(paramList1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
    }
  }
  
  public void d(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    paramList1 = paramList1.iterator();
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      paramMsg = (im_msg_body.Elem)paramList1.next();
    } while (!paramMsg.common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)paramMsg.common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("decodePBMsgElems_ScribbleMsg;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype11();
      try
      {
        paramStringBuilder.mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
        paramList1 = (MessageForScribble)MessageRecordFactory.a(-7001);
        paramList1.msgtype = -7001;
        if (paramStringBuilder.bytes_Doodle_md5.has()) {
          paramList1.combineFileMd5 = new String(paramStringBuilder.bytes_Doodle_md5.get().toByteArray());
        }
        if (paramStringBuilder.bytes_Doodle_url.has()) {
          paramList1.combineFileUrl = new String(paramStringBuilder.bytes_Doodle_url.get().toByteArray());
        }
        if (paramStringBuilder.uint32_doodleData_offset.has()) {
          paramList1.offSet = paramStringBuilder.uint32_doodleData_offset.get();
        }
        if (paramStringBuilder.uint32_doodle_gif_id.has()) {
          paramList1.gifId = paramStringBuilder.uint32_doodle_gif_id.get();
        }
        if (QLog.isColorLevel()) {
          QLog.i("DecodeMsgscribble msg", 1, " decodePBMsgElems_ScribbleMsg " + paramList1.combineFileMd5 + " " + paramList1.combineFileUrl);
        }
        paramList1.prewrite();
        paramList2.add(paramList1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramList1)
      {
        paramList1.printStackTrace();
        QLog.e("DecodeMsgscribble msg", 1, paramList1, new Object[0]);
        return;
      }
    }
  }
  
  public void d(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject4 = null;
    Iterator localIterator = paramList1.iterator();
    Object localObject1 = null;
    Object localObject3 = null;
    if (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.ark_app.has()) {
        localObject3 = (im_msg_body.ArkAppElem)localElem.ark_app.get();
      }
      if (!localElem.light_app.has()) {
        break label543;
      }
      localObject1 = (im_msg_body.LightAppElem)localElem.light_app.get();
    }
    label543:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:ArkApp/LightApp;\n");
      }
      if (!ArkAppCenter.b())
      {
        QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isDeviceSupportArkMsg is false, ignore msg.");
        if (a(paramList1).booleanValue())
        {
          g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
          return;
        }
        paramList1 = (MessageForText)MessageRecordFactory.a(-1000);
        paramList1.msgtype = -1000;
        paramList1.msg = BaseApplication.getContext().getString(2131436160);
        paramList2.add(paramList1);
        return;
      }
      if (ArkAppCenter.c())
      {
        QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isPANonShow is true, ignore msg.");
        return;
      }
      if (localObject3 != null)
      {
        if (!((im_msg_body.ArkAppElem)localObject3).bytes_data.has())
        {
          QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data not exist.");
          return;
        }
        localObject1 = ((im_msg_body.ArkAppElem)localObject3).bytes_data.get().toByteArray();
      }
      for (;;)
      {
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data is empty.");
          return;
          if (localObject1 != null)
          {
            if (!((im_msg_body.LightAppElem)localObject1).bytes_data.has())
            {
              QLog.i("ArkApp", 1, "decode msg, light_app.bytes_data not exist.");
              return;
            }
            localObject1 = ((im_msg_body.LightAppElem)localObject1).bytes_data.get().toByteArray();
          }
        }
        else
        {
          localObject1 = StructMsgUtils.a((byte[])localObject1, -1);
          if ((localObject1 != null) && (localObject1.length > 0)) {}
          for (;;)
          {
            try
            {
              localObject1 = new String((byte[])localObject1, "UTF-8");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              QLog.i("ArkApp", 1, "decode msg, ark data is empty.");
              return;
            }
            catch (Exception localException)
            {
              QLog.i("ArkApp", 1, "decode msg, raw data cannot convert to string.");
              localObject2 = localObject4;
              continue;
            }
            QLog.i("ArkApp", 1, "decode msg, raw data is empty.");
            localObject2 = localObject4;
          }
          localObject4 = a(paramList1, paramList2, false);
          localObject3 = (MessageForArkApp)MessageRecordFactory.a(-5008);
          ((MessageForArkApp)localObject3).msgtype = -5008;
          if (localObject4 != null) {
            ((MessageForArkApp)localObject3).compatibleMsg = ((String)localObject4);
          }
          localObject4 = new ArkAppMessage();
          ((ArkAppMessage)localObject4).fromAppXml(localObject2);
          ((MessageForArkApp)localObject3).msgData = ((ArkAppMessage)localObject4).toBytes();
          ((MessageForArkApp)localObject3).parse();
          if ((!TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appName)) && (!TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appView))) {
            paramList2.add(localObject3);
          }
          for (int i = 1; i == 0; i = 0)
          {
            g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
            return;
            QLog.i("ArkApp", 1, "decode msg, ark message is not valid..");
          }
          break;
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void e(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    paramList1 = paramList1.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList1.next();
    } while (!localElem.common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:TroopStoryComment;\n");
        }
        paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype15();
        try
        {
          paramStringBuilder.mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
          paramList1 = (MessageForQQStoryComment)MessageRecordFactory.a(-2052);
          paramList1.vid = paramStringBuilder.vid.get().toStringUtf8();
          paramList1.comment = paramStringBuilder.comment_content.get().toStringUtf8();
          paramList1.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
          paramList1.title = paramStringBuilder.title.get().toStringUtf8();
          paramList1.summary = paramStringBuilder.summary.get().toStringUtf8();
          paramList1.createTime = paramStringBuilder.createTime.get();
          paramList1.author = paramStringBuilder.author.get();
          paramList1.ctrVersion = paramStringBuilder.ctr_version.get();
          if (paramList1.ctrVersion <= 1)
          {
            paramList1.prewrite();
            paramList2.add(paramList1);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList1)
        {
          paramList1.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void e(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject2 = null;
    Object localObject3 = paramList1.iterator();
    Object localObject1 = null;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (!((im_msg_body.Elem)localObject4).common_elem.has()) {
        break label464;
      }
      localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject4).common_elem.get();
    }
    label437:
    label451:
    label464:
    for (;;)
    {
      break;
      a(paramList1);
      if (QLog.isColorLevel()) {
        QLog.d("ArkSdkShare", 2, "decodePBMsgElems_ArkSdkApp  common_lem" + localObject1);
      }
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        localObject3 = new hummer_commelem.MsgElemInfo_servtype20();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype20)localObject3).mergeFrom(((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray());
          if (!ArkAppCenter.b())
          {
            QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp is false, ignore msg.");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList1)
        {
          paramList1.printStackTrace();
          return;
        }
        if (!((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.has()) {
          break;
        }
        ((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.get().toStringUtf8();
        localObject3 = ((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.get().toByteArray();
        if ((localObject3 == null) || (localObject3.length <= 0))
        {
          QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data empty.");
          return;
        }
        localObject3 = StructMsgUtils.a((byte[])localObject3, -1);
        if (localObject3 != null)
        {
          i = localObject3.length;
          if (i > 0)
          {
            try
            {
              localObject3 = new String((byte[])localObject3, "UTF-8");
              localObject2 = localObject3;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp convert failed");
              }
            }
            localObject4 = a(paramList1, paramList2, false);
            localObject3 = (MessageForArkApp)MessageRecordFactory.a(-5017);
            ((MessageForArkApp)localObject3).msgtype = -5017;
            if (((im_msg_body.CommonElem)localObject1).uint32_business_type.get() == 1) {
              ((MessageForArkApp)localObject3).saveExtInfoToExtStr(MessageConstants.e, "1");
            }
            if (localObject4 != null) {
              ((MessageForArkApp)localObject3).compatibleMsg = ((String)localObject4);
            }
            localObject1 = new ArkAppMessage();
            ((ArkAppMessage)localObject1).fromAppXml(localObject2);
            ((MessageForArkApp)localObject3).msgData = ((ArkAppMessage)localObject1).toBytes();
            ((MessageForArkApp)localObject3).parse();
            if ((TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appView))) {
              break label437;
            }
            paramList2.add(localObject3);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label451;
          }
          g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
          return;
          QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp empty.");
          break;
          QLog.i("arksdk", 1, "decode msg, ark message is not valid..");
        }
      }
      QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data not exist.");
      return;
    }
  }
  
  public void f(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    Object localObject = null;
    Iterator localIterator = paramList1.iterator();
    im_msg_body.CommonElem localCommonElem1 = null;
    paramList1 = (List)localObject;
    localObject = paramList1;
    im_msg_body.CommonElem localCommonElem2 = localCommonElem1;
    if (localIterator.hasNext())
    {
      localObject = (im_msg_body.Elem)localIterator.next();
      if (!((im_msg_body.Elem)localObject).common_elem.has()) {
        break label87;
      }
      localCommonElem1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();
      if (paramList1 == null) {
        break label416;
      }
      localCommonElem2 = localCommonElem1;
      localObject = paramList1;
    }
    for (;;)
    {
      if (localCommonElem2 != null) {
        break label128;
      }
      return;
      label87:
      if (!((im_msg_body.Elem)localObject).text.has()) {
        break label413;
      }
      paramList1 = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (localCommonElem1 == null) {
        break;
      }
      localObject = paramList1;
      localCommonElem2 = localCommonElem1;
    }
    label128:
    label413:
    label416:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TroopStory;\n");
      }
      for (paramList1 = new hummer_commelem.MsgElemInfo_servtype16();; paramList1 = ((im_msg_body.Text)localObject).str.get().toStringUtf8()) {
        try
        {
          paramList1.mergeFrom(localCommonElem2.bytes_pb_elem.get().toByteArray());
          int i = paramList1.ctr_version.get();
          if (i > 1) {
            break;
          }
          paramStringBuilder = (MessageForTroopStory)MessageRecordFactory.a(-2057);
          paramStringBuilder.uid = paramList1.uid.get();
          paramStringBuilder.unionId = paramList1.unionID.get().toStringUtf8();
          paramStringBuilder.storyId = paramList1.storyID.get().toStringUtf8();
          paramStringBuilder.md5 = paramList1.md5.get().toStringUtf8();
          paramStringBuilder.thumbUrl = paramList1.thumbUrl.get().toStringUtf8();
          paramStringBuilder.doodleUrl = paramList1.doodleUrl.get().toStringUtf8();
          paramStringBuilder.videoWidth = paramList1.videoWidth.get();
          paramStringBuilder.videoHeight = paramList1.videoHeight.get();
          paramStringBuilder.sourceName = paramList1.sourceName.get().toStringUtf8();
          paramStringBuilder.sourceActionType = paramList1.sourceActionType.get().toStringUtf8();
          paramStringBuilder.sourceActionData = paramList1.sourceActionData.get().toStringUtf8();
          if (localObject == null)
          {
            paramList1 = "";
            paramStringBuilder.compatibleText = paramList1;
            paramStringBuilder.ctrVersion = i;
            paramStringBuilder.msg = "[小视频]";
            paramStringBuilder.serial();
            paramList2.add(paramStringBuilder);
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.d("TroopStory", 4, paramStringBuilder.toDebugString());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList1)
        {
          paramList1.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void f(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = paramList1.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
    } while (!((im_msg_body.Elem)localObject2).qqwallet_msg.has());
    for (localObject1 = (im_msg_body.QQWalletMsg)((im_msg_body.Elem)localObject2).qqwallet_msg.get();; localObject1 = null)
    {
      if (localObject1 == null) {}
      int k;
      int n;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:QQWalletMsg;\n");
          }
        } while (!((im_msg_body.QQWalletMsg)localObject1).aio_body.has());
        k = 0;
        n = ((im_msg_body.QQWalletMsg)localObject1).aio_body.sint32_msgtype.get();
      } while (n > 3000);
      int j;
      label121:
      MessageForQQWalletMsg localMessageForQQWalletMsg;
      boolean bool;
      label240:
      Object localObject3;
      if (n > 2000)
      {
        j = k;
        if (j != 0) {
          break label1280;
        }
        localMessageForQQWalletMsg = (MessageForQQWalletMsg)MessageRecordFactory.a(-2025);
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.messageType = n;
        if (!((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get()).sint32_redtype.has()) {
          break label797;
        }
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin());
        if ((localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null) && ((n == 4) || (n == 5)))
        {
          if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom != 1) {
            break label690;
          }
          bool = true;
          localMessageForQQWalletMsg.isBlessMsg = bool;
          if (QLog.isColorLevel()) {
            QLog.d("BlessManagerHB", 2, "decode msgFrom=" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom);
          }
        }
        if ((n == 7) || (n == 8))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_grap_uin.get().iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!((String)localObject2).equals(String.valueOf((Long)((Iterator)localObject3).next())));
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (paramMessageInfo != null) && (paramMessageInfo.b != null))
        {
          paramMessageInfo.b.a(paramMsg.msg_head.msg_seq.get(), localMessageForQQWalletMsg.msgseq);
          localMessageForQQWalletMsg.mMessageInfo = paramMessageInfo;
        }
        if ((n == 6) || (n == 13) || (n == 15))
        {
          i = paramMsg.msg_head.msg_type.get();
          if ((i != 82) && (i != 43)) {
            break label696;
          }
          i = 1;
        }
        for (long l = paramMsg.msg_head.group_info.group_code.get();; l = paramMsg.msg_head.discuss_info.discuss_uin.get())
        {
          j = 0;
          if ((n == 13) || (n == 15)) {
            j = 1;
          }
          ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(124)).a((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get(), i, l, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_time.get(), j);
          label566:
          localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
          localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
          if ((localMessageForQQWalletMsg != null) && (!localMessageForQQWalletMsg.isMsgEmpty())) {
            break label1146;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          paramStringBuilder.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
          return;
          j = k;
          if (n > 1000) {
            break label121;
          }
          int m = 0;
          localObject2 = MessageForQQWalletMsg.mMsgType;
          int i1 = localObject2.length;
          j = 0;
          for (;;)
          {
            i = m;
            if (j < i1)
            {
              if (localObject2[j] == n) {
                i = 1;
              }
            }
            else
            {
              j = k;
              if (i != 0) {
                break;
              }
              j = 1;
              break;
            }
            j += 1;
          }
          label690:
          bool = false;
          break label240;
          label696:
          if ((i != 83) && (i != 42)) {
            break label732;
          }
          i = 2;
        }
        label732:
        i = 3;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {}
        for (l = paramMsg.msg_head.from_uin.get();; l = paramMsg.msg_head.to_uin.get()) {
          break;
        }
        label797:
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = null;
        localMessageForQQWalletMsg.mQQWalletTransferMsg = new QQWalletTransferMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin());
        l = 0L;
        if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.has()) {
          l = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.get();
        }
        for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin();; localObject2 = "")
        {
          if ((n == 10) && (localMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null) && (!TextUtils.isEmpty(localMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid)))
          {
            localObject3 = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid.split("\\?");
            if (localObject3.length > 1) {}
            for (localObject3 = localMessageForQQWalletMsg.parseUrlParams(localObject3[1]);; localObject3 = new HashMap())
            {
              QWalletCommonManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)((HashMap)localObject3).get("tokenid"), ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.get());
              if ((l == 0L) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).compareTo("" + l) == 0)) {
                break;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.payaio.buyershow", 0, 0, "", "", "", "");
              break;
            }
          }
          if ((n != 9) || (l == 0L) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).compareTo("" + l) == 0)) {
            break label566;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershow", 0, 0, "", "", "", "");
          break label566;
          label1146:
          if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.has()) {}
          for (i = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.get(); i >= 3; i = 10)
          {
            paramList2.add(localMessageForQQWalletMsg);
            return;
          }
          if (i >= 2)
          {
            g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
            if (!paramList2.isEmpty()) {
              break;
            }
            paramList2.add(localMessageForQQWalletMsg);
            return;
          }
          if (i < 1) {
            break;
          }
          g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
          if (paramList2.isEmpty())
          {
            j(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
            return;
          }
          paramList2.add(localMessageForQQWalletMsg);
          return;
          label1280:
          j(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
          return;
        }
      }
    }
  }
  
  public void g(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
    }
    paramList1 = paramList1.iterator();
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList1.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
        }
        return;
      }
      paramStringBuilder = new MessageForPoke();
      paramStringBuilder.msgtype = -5012;
      if (paramList1.uint32_business_type.has()) {
        paramStringBuilder.interactType = paramList1.uint32_business_type.get();
      }
      hummer_commelem.MsgElemInfo_servtype2 localMsgElemInfo_servtype2;
      if (paramList1.bytes_pb_elem.has()) {
        localMsgElemInfo_servtype2 = new hummer_commelem.MsgElemInfo_servtype2();
      }
      for (;;)
      {
        try
        {
          localMsgElemInfo_servtype2.mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
          paramStringBuilder.msg = localMsgElemInfo_servtype2.bytes_poke_summary.get().toStringUtf8();
          paramStringBuilder.doubleHitState = localMsgElemInfo_servtype2.uint32_double_hit.get();
          if (!localMsgElemInfo_servtype2.uint32_vaspoke_id.has()) {
            continue;
          }
          i = localMsgElemInfo_servtype2.uint32_vaspoke_id.get();
          paramStringBuilder.subId = i;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_name.has()) {
            continue;
          }
          paramList1 = localMsgElemInfo_servtype2.bytes_vaspoke_name.get().toStringUtf8();
          paramStringBuilder.name = paramList1;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_minver.has()) {
            continue;
          }
          paramList1 = localMsgElemInfo_servtype2.bytes_vaspoke_minver.get().toStringUtf8();
          paramStringBuilder.minVersion = paramList1;
          paramStringBuilder.strength = localMsgElemInfo_servtype2.uint32_poke_strength.get();
          if (paramStringBuilder.interactType == 126) {
            VasWebviewUtil.reportCommercialDrainage("", "poke", "receive", "", 0, 0, 0, "", String.valueOf(paramStringBuilder.subId), "none", "", "", "", "", 0, 0, 0, 0);
          }
        }
        catch (Exception paramList1)
        {
          int i;
          QLog.d("PokeMsg", 1, "decodePBMsgElems_PokeMsg exception!", paramList1);
          continue;
        }
        paramList2.add(paramStringBuilder);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PokeMsg", 2, "decodePbElems, common_elem type 2, interactType:" + paramStringBuilder.interactType + " ,doubleHitState:" + paramStringBuilder.doubleHitState);
        return;
        i = -1;
        continue;
        paramList1 = "戳一戳";
        continue;
        paramList1 = "";
      }
    }
  }
  
  public void g(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "begin decodePBMsgElems_RichMsg");
    }
    Object localObject3 = null;
    Object localObject4 = paramList1.iterator();
    im_msg_body.GeneralFlags localGeneralFlags = null;
    Object localObject1 = null;
    Object localObject6;
    if (((Iterator)localObject4).hasNext())
    {
      localObject6 = (im_msg_body.Elem)((Iterator)localObject4).next();
      if (!((im_msg_body.Elem)localObject6).rich_msg.has()) {
        break label4479;
      }
      localObject1 = (im_msg_body.RichMsg)((im_msg_body.Elem)localObject6).rich_msg.get();
    }
    label1034:
    label1064:
    label1348:
    label1372:
    label1509:
    label3560:
    label4459:
    label4466:
    label4479:
    for (;;)
    {
      if (((im_msg_body.Elem)localObject6).general_flags.has()) {
        localGeneralFlags = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject6).general_flags.get();
      }
      for (;;)
      {
        if (((im_msg_body.Elem)localObject6).text.has()) {
          localObject3 = (im_msg_body.Text)((im_msg_body.Elem)localObject6).text.get();
        }
        for (;;)
        {
          break;
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "richMsg is null");
            }
            return;
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:RichMsg;\n");
          }
          int i = 0;
          int j = i;
          if (localGeneralFlags != null)
          {
            j = i;
            if (localGeneralFlags.long_text_flag.get() == 1)
            {
              i = 1;
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, longTextFlag: true");
                j = i;
              }
            }
          }
          localObject6 = null;
          if (((im_msg_body.RichMsg)localObject1).bytes_template_1.has()) {
            localObject6 = ((im_msg_body.RichMsg)localObject1).bytes_template_1.get().toByteArray();
          }
          long l1;
          MessageForStructing localMessageForStructing;
          int m;
          long l2;
          if (paramMsg.msg_head.from_uin.has())
          {
            l1 = paramMsg.msg_head.from_uin.get();
            localMessageForStructing = new MessageForStructing();
            localMessageForStructing.msgtype = -2011;
            long l3 = paramMsg.msg_head.to_uin.get();
            m = paramMsg.msg_head.msg_type.get();
            if (m != 82)
            {
              l2 = l3;
              if (m != 43) {}
            }
            else
            {
              l2 = l3;
              if (paramMsg.msg_head.group_info != null)
              {
                l2 = l3;
                if (paramMsg.msg_head.group_info.group_code.has()) {
                  l2 = paramMsg.msg_head.group_info.group_code.get();
                }
              }
            }
            localObject1 = ((im_msg_body.RichMsg)localObject1).bytes_msg_resid.get();
            if (localObject1 == null) {
              break label4466;
            }
          }
          for (String str = ((ByteStringMicro)localObject1).toStringUtf8();; str = "")
          {
            Object localObject7;
            if (!StringUtil.a(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d("DecodeMsg", 2, new Object[] { "decodePBMsgElems_RichMsg longMsgResId=", str });
              }
              localObject1 = "";
              localObject7 = paramList1.iterator();
              do
              {
                localObject4 = localObject1;
                if (!((Iterator)localObject7).hasNext()) {
                  break;
                }
                localObject4 = (im_msg_body.Elem)((Iterator)localObject7).next();
              } while (!((im_msg_body.Elem)localObject4).pub_acc_info.has());
              if (((im_msg_body.Elem)localObject4).pub_acc_info.string_long_msg_url.get() != null) {
                localObject1 = ((im_msg_body.Elem)localObject4).pub_acc_info.string_long_msg_url.get();
              }
              localObject7 = ((im_msg_body.Elem)localObject4).pub_acc_info.bytes_download_key.get();
              localObject4 = localObject1;
              if (localObject7 == null) {
                break label4459;
              }
              localObject7 = StructLongMessageDownloadProcessor.a(((ByteStringMicro)localObject7).toByteArray());
              localObject4 = localObject1;
            }
            Object localObject2;
            for (localObject1 = localObject7;; localObject2 = "")
            {
              if ((!StringUtil.a((String)localObject4)) && (!StringUtil.a((String)localObject1)) && (!StringUtil.a(str)))
              {
                localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject4);
                localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", (String)localObject1);
                localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", str);
              }
              for (boolean bool = true;; bool = false)
              {
                localObject1 = MessageProtoCodec.a(paramMsg);
                if ((((TempSessionInfo)localObject1).jdField_a_of_type_Int == 1008) && (QLog.isColorLevel()))
                {
                  localObject4 = new StringBuilder().append("msgId=").append(localMessageForStructing.uniseq).append(", serviceType(Pa-129,140,142):").append(((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.get()).append(", xmlContentLength:");
                  if (localObject6 != null) {
                    break label1034;
                  }
                }
                for (i = 0;; i = localObject6.length)
                {
                  QLog.d("PaOldLongMsg", 2, i + ", longMsgResId:" + str + ", isPaNewLongMsg:" + bool);
                  if ((localGeneralFlags != null) && (localGeneralFlags.babyq_guide_msg_cookie.has())) {}
                  try
                  {
                    localObject4 = localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
                    localObject7 = Utils.a((byte[])localObject4);
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, guideMsgCookie: " + (String)localObject7 + " ,byte: " + Arrays.toString(localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
                    }
                    localMessageForStructing.saveExtInfoToExtStr("guide_msg_cookie", (String)localObject7);
                    ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a((byte[])localObject4);
                  }
                  catch (Exception localException2)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel())
                      {
                        QLog.d("DecodeMsg", 2, "get richmsg guideMsgCookie error!", localException2);
                        continue;
                        if ((localObject6 == null) || (localObject6.length == 0))
                        {
                          if ((((TempSessionInfo)localObject1).jdField_a_of_type_Int == 1008) && (!TextUtils.isEmpty(str)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("PaOldLongMsg", 2, "msgId=" + localMessageForStructing.uniseq + ", begin getEmptyGeneralStructMsg for PA oldLongMsg!");
                            }
                            localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)StructMsgFactory.a());
                            localMessageForStructing.saveExtInfoToExtStr("pub_old_long_msg", "1");
                            localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", str);
                            localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                          }
                        }
                        else
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("DecodeMsg", 2, new Object[] { "begin getStructMsgFromXmlBuff: type=", Integer.valueOf(m), ", code=", Long.valueOf(l2) });
                          }
                          localMessageForStructing.structingMsg = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, m, l2, (byte[])localObject6, -1);
                          if (QLog.isColorLevel()) {
                            QLog.d("StructMsg", 2, "StructMsg = " + localMessageForStructing.structingMsg);
                          }
                        }
                      }
                    }
                    if (localMessageForStructing.structingMsg.mMsgServiceID != 74) {
                      break label1372;
                    }
                    localObject1 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mVipDonateStr;
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label1372;
                    }
                    bool = false;
                    if (!String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                      break label1348;
                    }
                    bool = true;
                    localObject1 = a((String)localObject1, bool);
                    if (localObject1 == null) {
                      break label1372;
                    }
                    paramList2.add(localObject1);
                    return;
                    k = 0;
                    i = k;
                    if (!paramMsg.msg_head.c2c_tmp_msg_head.service_type.has()) {
                      break label1443;
                    }
                    int n = paramMsg.msg_head.c2c_tmp_msg_head.service_type.get();
                    if ((n == 129) || (n == 140)) {
                      break label1440;
                    }
                    i = k;
                    if (n != 142) {
                      break label1443;
                    }
                    i = 1;
                    if ((i == 0) && (localMessageForStructing.structingMsg.sourceAccoutType == 0)) {
                      break label1509;
                    }
                    localMessageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
                    if ((!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgBrief)) && (!localMessageForStructing.structingMsg.mEmptyMsgBriefModified)) {
                      break label1509;
                    }
                    localMessageForStructing.structingMsg.mMsgBrief = "你有新消息";
                    localObject1 = paramList1.iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      localObject5 = (im_msg_body.Elem)((Iterator)localObject1).next();
                      if ((((im_msg_body.Elem)localObject5).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject5).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject5).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject5).life_online.get()).uint64_unique_id.has())) {
                        localMessageForStructing.structingMsg.msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject5).life_online.get()).uint64_unique_id.get();
                      }
                    }
                    if (!QLog.isColorLevel()) {
                      break label1678;
                    }
                    QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg serviceId" + localMessageForStructing.structingMsg.mMsgServiceID);
                  }
                  if (!bool) {
                    break label1064;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("DecodeMsg", 2, "begin getEmptyGeneralStructMsg");
                  }
                  localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)StructMsgFactory.a());
                  if (localMessageForStructing.structingMsg == null) {
                    break label2090;
                  }
                  if (!(localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
                    break label1372;
                  }
                  localObject1 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mWarningTips;
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject1);
                  }
                  if (((StructMsgForGeneralShare)localMessageForStructing.structingMsg).isPayMessage()) {
                    localMessageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
                  }
                  localObject1 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mPARedPacket;
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label1290;
                  }
                  localObject1 = a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin());
                  if (localObject1 == null) {
                    break label1290;
                  }
                  paramList2.add(localObject1);
                  return;
                  l1 = 0L;
                  break;
                }
                int k;
                Object localObject5;
                if (localMessageForStructing.structingMsg.mMsgServiceID == 37) {
                  break;
                }
                if (localMessageForStructing.structingMsg.mMsgServiceID == 499)
                {
                  paramList1 = (MessageForTroopFee)MessageRecordFactory.a(-2036);
                  paramStringBuilder = MessageForTroopFee.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b, m, l2, (byte[])localObject6, -1);
                  if (paramStringBuilder != null) {
                    paramList1.copyFrom(paramStringBuilder);
                  }
                  paramList1.msgtype = -2036;
                  paramList1.msg = paramList1.getSummaryMsg();
                  paramList1.msgData = paramList1.getBytes();
                  paramList2.add(paramList1);
                  localMessageForStructing.structingMsg = null;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d(".troop.troop_fee", 2, "Troop Fee has decode suceess" + paramList1.getSummaryMsg());
                  return;
                }
                if (localMessageForStructing.structingMsg.mMsgServiceID == 52)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(NearbyFlowerManager.class.getSimpleName(), 2, "Received flower message");
                  }
                  localObject1 = NearbyFlowerMessage.getFlowerMsgVersion(localMessageForStructing);
                  if (("1".equals(localObject1)) || ("2".equals(localObject1)) || ("3".equals(localObject1)))
                  {
                    localObject1 = (msg_comm.GroupInfo)paramMsg.msg_head.group_info.get();
                    if (localObject1 == null) {
                      break label4447;
                    }
                  }
                }
                for (l1 = ((msg_comm.GroupInfo)localObject1).group_code.get();; l1 = 0L)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i(NearbyFlowerManager.class.getSimpleName(), 2, "decodePBMsgElems, groupCode:" + l1);
                  }
                  if (l1 <= 0L)
                  {
                    if (!paramMsg.msg_head.from_uin.has()) {
                      break label2132;
                    }
                    l1 = paramMsg.msg_head.from_uin.get();
                    if (!paramMsg.msg_head.to_uin.has()) {
                      break label2138;
                    }
                    l2 = paramMsg.msg_head.to_uin.get();
                    paramList2.add(((NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(123)).a(Long.toString(l1), Long.toString(l2), localMessageForStructing.istroop, localMessageForStructing.structingMsg));
                    break label3560;
                    break label3160;
                  }
                  for (;;)
                  {
                    localMessageForStructing.structingMsg.mCompatibleText = a(paramList1, paramList2, false);
                    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
                    localMessageForStructing.msg = "richMsg";
                    if (localMessageForStructing.structingMsg != null) {
                      break label3995;
                    }
                    if (QLog.isColorLevel()) {
                      paramStringBuilder.append("c2cMsgContent.data:null;\n");
                    }
                    j(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
                    return;
                    l1 = 0L;
                    break label1990;
                    l2 = 0L;
                    break label2017;
                    if ((localMessageForStructing.structingMsg.mMsgServiceID == 70) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                    {
                      paramList1 = (MessageForTroopTopic)MessageRecordFactory.a(-2044);
                      paramList1.msgtype = -2044;
                      paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                      paramList1.structingMsg = paramStringBuilder;
                      paramList1.bid = paramStringBuilder.bid;
                      paramList1.pid = paramStringBuilder.pid;
                      paramList1.pVersion = paramStringBuilder.pVersion;
                      paramList1.prewrite();
                      paramList1.msg = paramList1.getSummaryMsg();
                      paramList2.add(paramList1);
                      localMessageForStructing.structingMsg = null;
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(".troop.troop_topic", 2, "MessageForTroopTopic has decode suceess" + paramList1.getSummaryMsg());
                      return;
                    }
                    if ((localMessageForStructing.structingMsg.mMsgServiceID == 80) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                    {
                      if (QQStoryManager.j())
                      {
                        paramList1 = (MessageForQQStory)MessageRecordFactory.a(-2051);
                        paramList1.msgtype = -2051;
                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject3 != null) && (((im_msg_body.Text)localObject3).str.has())) {
                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject3).str.get().toStringUtf8();
                        }
                        paramList1.structingMsg = paramStringBuilder;
                        paramList1.doPrewrite();
                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                        {
                          paramList1.doParse();
                          paramStringBuilder.mCompatibleText = MessageForQQStory.buildCompatibleText(paramList1.authorName, paramList1.brief, paramList1.srcName);
                          paramList1.doPrewrite();
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                          }
                        }
                        paramList2.add(paramList1);
                        localMessageForStructing.structingMsg = null;
                        return;
                      }
                      localMessageForStructing.structingMsg = null;
                      if (localObject3 != null)
                      {
                        ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(QQStoryManager.a()));
                        return;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.qqstory.share", 2, "recv storyMsg, isSDKAPISupportStory==false, txtMsg==null");
                      }
                    }
                    else
                    {
                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 118) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                      {
                        paramList1 = (MessageForTribeShortVideo)MessageRecordFactory.a(-7002);
                        paramList1.msgtype = -7002;
                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject3 != null) && (((im_msg_body.Text)localObject3).str.has())) {
                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject3).str.get().toStringUtf8();
                        }
                        paramList1.structingMsg = paramStringBuilder;
                        paramList1.doPrewrite();
                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                        {
                          paramList1.doParse();
                          paramStringBuilder.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
                          paramList1.doPrewrite();
                          if (QLog.isColorLevel()) {
                            QLog.d("DecodeMsg", 2, "recv shortVideoMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                          }
                        }
                        paramList2.add(paramList1);
                        localMessageForStructing.structingMsg = null;
                        return;
                      }
                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 104) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                      {
                        paramList1 = (MessageForTroopPobing)MessageRecordFactory.a(-2059);
                        paramList1.msgtype = -2059;
                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject3 != null) && (((im_msg_body.Text)localObject3).str.has())) {
                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject3).str.get().toStringUtf8();
                        }
                        paramList1.structingMsg = paramStringBuilder;
                        paramList1.doPrewrite();
                        paramList1.doParse();
                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                        {
                          paramList1.doParse();
                          paramStringBuilder.mCompatibleText = MessageForTroopPobing.buildCompatibleText();
                          paramList1.doPrewrite();
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                          }
                        }
                        paramList2.add(paramList1);
                        localMessageForStructing.structingMsg = null;
                        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_obj").a(new String[] { l2 + "" }).a();
                        return;
                      }
                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 90) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                      {
                        paramList1 = (MessageForTroopSign)MessageRecordFactory.a(-2054);
                        paramList1.msgtype = -2054;
                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                        paramList1.structingMsg = paramStringBuilder;
                        paramList1.msg = paramStringBuilder.mMsgBrief;
                        paramList1.doPrewrite();
                        paramList2.add(paramList1);
                        localMessageForStructing.structingMsg = null;
                        return;
                      }
                      if (localMessageForStructing.structingMsg.mMsgServiceID == 500)
                      {
                        if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
                        {
                          PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing, 11);
                          ((AbsShareMsg)localMessageForStructing.structingMsg).clearItems();
                          localMessageForStructing.extInt = 1;
                          localMessageForStructing.extLong = 1;
                          if (QLog.isColorLevel()) {
                            QLog.d("DecodeMsg", 2, "decode structMsg form XIN_KANDIAN, items = " + ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists().size());
                          }
                        }
                      }
                      else
                      {
                        if (localMessageForStructing.structingMsg.mMsgServiceID == 43)
                        {
                          localObject1 = paramList1.iterator();
                          if (!((Iterator)localObject1).hasNext()) {
                            continue;
                          }
                          localObject3 = (im_msg_body.Elem)((Iterator)localObject1).next();
                          if ((!((im_msg_body.Elem)localObject3).group_pub_acc_info.has()) || (!((im_msg_body.Elem)localObject3).group_pub_acc_info.uint64_pub_account.has())) {
                            break label2061;
                          }
                          l1 = ((im_msg_body.Elem)localObject3).group_pub_acc_info.uint64_pub_account.get();
                          localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(51);
                          if (!paramMsg.msg_head.group_info.has()) {
                            continue;
                          }
                          l2 = paramMsg.msg_head.group_info.group_code.get();
                          localObject3 = ((TroopManager)localObject1).a(String.valueOf(l2));
                          if (localObject3 == null) {
                            continue;
                          }
                          ((TroopInfo)localObject3).associatePubAccount = l1;
                          ((TroopManager)localObject1).b((TroopInfo)localObject3);
                          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(20).a(79, true, new Object[] { Long.valueOf(l2) });
                          continue;
                        }
                        if (((localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116)) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgActionData)))
                        {
                          localObject3 = "";
                          localObject1 = localObject3;
                          if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgUrl)) {
                            localObject1 = Uri.parse(localMessageForStructing.structingMsg.mMsgUrl);
                          }
                          try
                          {
                            localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
                            localObject3 = localObject1;
                          }
                          catch (Exception localException1)
                          {
                            for (;;)
                            {
                              localException1.printStackTrace();
                            }
                          }
                          localObject1 = localObject3;
                          if (localObject3 == null) {
                            localObject1 = "";
                          }
                          PublicAccountReportUtils.a(null, "", "0X8007238", "0X8007238", 0, 0, (String)localObject1, "", "", "");
                          PublicAccountReportUtils.a("0X8007238", "", (String)localObject1, "", "", "");
                          localMessageForStructing.structingMsg.mMsgActionData = a(localMessageForStructing.structingMsg.mMsgActionData);
                          continue;
                        }
                        if ((localMessageForStructing.structingMsg.mMsgServiceID == 5) && ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
                        {
                          localObject3 = paramList1.iterator();
                          if (!((Iterator)localObject3).hasNext()) {
                            continue;
                          }
                          im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject3).next();
                          if (localElem.not_online_image.has())
                          {
                            localObject5 = (im_msg_body.NotOnlineImage)localElem.not_online_image.get();
                            localObject3 = (StructMsgForImageShare)localMessageForStructing.structingMsg;
                            ((StructMsgForImageShare)localObject3).thumbHeight = ((im_msg_body.NotOnlineImage)localObject5).uint32_thumb_height.get();
                            ((StructMsgForImageShare)localObject3).thumbWidth = ((im_msg_body.NotOnlineImage)localObject5).uint32_thumb_width.get();
                            ((StructMsgForImageShare)localObject3).thumbUrl = ((im_msg_body.NotOnlineImage)localObject5).str_thumb_url.get();
                            ((StructMsgForImageShare)localObject3).bigUrl = ((im_msg_body.NotOnlineImage)localObject5).str_big_url.get();
                            ((StructMsgForImageShare)localObject3).rawUrl = ((im_msg_body.NotOnlineImage)localObject5).str_orig_url.get();
                            if (!localElem.not_online_image.bytes_pb_reserve.has()) {
                              continue;
                            }
                            try
                            {
                              localObject5 = new NotOnlineImageExtPb.ResvAttr();
                              ((NotOnlineImageExtPb.ResvAttr)localObject5).mergeFrom(localElem.not_online_image.bytes_pb_reserve.get().toByteArray());
                              ((StructMsgForImageShare)localObject3).mImageBizType = ((NotOnlineImageExtPb.ResvAttr)localObject5).uint32_image_biz_type.get();
                            }
                            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
                            {
                              localInvalidProtocolBufferMicroException1.printStackTrace();
                            }
                            continue;
                          }
                          if (!localInvalidProtocolBufferMicroException1.custom_face.has()) {
                            break label2061;
                          }
                          localObject5 = (im_msg_body.CustomFace)localInvalidProtocolBufferMicroException1.custom_face.get();
                          localObject3 = (StructMsgForImageShare)localMessageForStructing.structingMsg;
                          ((StructMsgForImageShare)localObject3).thumbHeight = ((im_msg_body.CustomFace)localObject5).uint32_thumb_height.get();
                          ((StructMsgForImageShare)localObject3).thumbWidth = ((im_msg_body.CustomFace)localObject5).uint32_thumb_width.get();
                          ((StructMsgForImageShare)localObject3).rawUrl = ((im_msg_body.CustomFace)localObject5).str_orig_url.get();
                          ((StructMsgForImageShare)localObject3).thumbUrl = ((im_msg_body.CustomFace)localObject5).str_thumb_url.get();
                          ((StructMsgForImageShare)localObject3).bigUrl = ((im_msg_body.CustomFace)localObject5).str_big_url.get();
                          ((StructMsgForImageShare)localObject3).rawUrl = ((im_msg_body.CustomFace)localObject5).str_orig_url.get();
                          if (!localInvalidProtocolBufferMicroException1.custom_face.bytes_pb_reserve.has()) {
                            continue;
                          }
                          try
                          {
                            localObject5 = new CustomFaceExtPb.ResvAttr();
                            ((CustomFaceExtPb.ResvAttr)localObject5).mergeFrom(localInvalidProtocolBufferMicroException1.custom_face.bytes_pb_reserve.get().toByteArray());
                            ((StructMsgForImageShare)localObject3).mImageBizType = ((CustomFaceExtPb.ResvAttr)localObject5).uint32_image_biz_type.get();
                          }
                          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
                          {
                            localInvalidProtocolBufferMicroException2.printStackTrace();
                          }
                          continue;
                        }
                        if ((localMessageForStructing.structingMsg.mMsgServiceID == 106) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                        {
                          localObject2 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                          localObject3 = ((StructMsgForGeneralShare)localObject2).animResId;
                          RobotResourcesManager.a().a((String)localObject3, null);
                          RobotResourcesManager.a().a(((StructMsgForGeneralShare)localObject2).atMembers);
                        }
                      }
                    }
                  }
                  k = 0;
                  paramStringBuilder = null;
                  paramList1 = paramStringBuilder;
                  i = k;
                  if (localGeneralFlags != null)
                  {
                    paramList1 = paramStringBuilder;
                    i = k;
                    if (!localGeneralFlags.bytes_pb_reserve.has()) {}
                  }
                  try
                  {
                    paramMsg = new generalflags.ResvAttr();
                    paramMsg.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
                    paramList1 = paramStringBuilder;
                    i = k;
                    if (paramMsg.bytes_kpl_info.has())
                    {
                      paramList1 = paramStringBuilder;
                      i = k;
                      if (paramMsg.bytes_kpl_info.has())
                      {
                        i = 1;
                        paramList1 = paramMsg.bytes_kpl_info.get().toStringUtf8();
                      }
                    }
                  }
                  catch (Exception paramList1)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
                      }
                      paramList1.printStackTrace();
                      i = 0;
                      paramList1 = null;
                    }
                    paramList2.add(paramList1);
                    return;
                  }
                  if (i != 0)
                  {
                    localMessageForStructing.saveExtInfoToExtStr("msg_ext_key", "Y");
                    if (QLog.isColorLevel()) {
                      QLog.d("KplMessage", 2, "resv a kpl struct message !");
                    }
                    KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList1);
                  }
                  if (j != 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg need to pull longtextmsg!");
                    }
                    try
                    {
                      if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
                      {
                        paramList1 = (ChatMessage)MessageRecordFactory.a(-1051);
                        paramList1.saveExtInfoToExtStr("long_text_recv_state", "3");
                        paramList1.saveExtInfoToExtStr("long_text_msg_resid", localMessageForStructing.structingMsg.mResid);
                        paramStringBuilder = ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists();
                        if (paramStringBuilder != null)
                        {
                          paramStringBuilder = paramStringBuilder.iterator();
                          for (;;)
                          {
                            if (paramStringBuilder.hasNext())
                            {
                              paramMsg = (AbsStructMsgElement)paramStringBuilder.next();
                              if ((paramMsg instanceof AbsStructMsgItem))
                              {
                                paramMsg = ((AbsStructMsgItem)paramMsg).a;
                                if (paramMsg != null)
                                {
                                  paramMsg = paramMsg.iterator();
                                  if (paramMsg.hasNext())
                                  {
                                    paramMessageInfo = (AbsStructMsgElement)paramMsg.next();
                                    if (!(paramMessageInfo instanceof StructMsgItemTitle)) {
                                      break;
                                    }
                                    paramList1.msg = ((StructMsgItemTitle)paramMessageInfo).b();
                                    if (QLog.isDevelopLevel())
                                    {
                                      QLog.d("DecodeMsg", 2, "longtextmsg getMsg from structMsg msg:" + paramList1.msg);
                                      continue;
                                      paramList2.add(localMessageForStructing);
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    catch (Exception paramList1)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "failed to pull longtextmsg exception!", paramList1);
                      }
                    }
                  }
                  for (;;)
                  {
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "absShareMsg is null");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void h(List paramList1, List paramList2, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
    }
    paramList1 = paramList1.iterator();
    do
    {
      if (!paramList1.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList1.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList1 = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList1 = null)
    {
      if (paramList1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
        }
      }
      for (;;)
      {
        return;
        paramStringBuilder = new MessageForPokeEmo();
        paramStringBuilder.msgtype = -5018;
        hummer_commelem.MsgElemInfo_servtype23 localMsgElemInfo_servtype23;
        if (paramList1.bytes_pb_elem.has()) {
          localMsgElemInfo_servtype23 = new hummer_commelem.MsgElemInfo_servtype23();
        }
        try
        {
          localMsgElemInfo_servtype23.mergeFrom(paramList1.bytes_pb_elem.get().toByteArray());
          paramStringBuilder.pokeemoId = localMsgElemInfo_servtype23.uint32_face_type.get();
          paramStringBuilder.pokeemoPressCount = localMsgElemInfo_servtype23.uint32_face_bubble_count.get();
          paramStringBuilder.summary = localMsgElemInfo_servtype23.bytes_face_summary.get().toStringUtf8();
          paramStringBuilder.initMsg();
          paramList2.add(paramStringBuilder);
          if (QLog.isColorLevel())
          {
            QLog.d("PokeEmoMsg", 2, "decodePbElems, common_elem type 23, pokeemoId:" + paramStringBuilder.pokeemoId + " ,pokeemoPressCount:" + paramStringBuilder.pokeemoPressCount);
            return;
          }
        }
        catch (Exception paramList1)
        {
          for (;;)
          {
            QLog.d("PokeEmoMsg", 1, "decodePBMsgElems_PokeEmoMsg exception!", paramList1);
          }
        }
      }
    }
  }
  
  public void h(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = null;
    Object localObject2 = paramList1.iterator();
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if ((!((im_msg_body.Elem)localObject4).group_pub_acc_info.has()) || (!((im_msg_body.Elem)localObject4).group_pub_acc_info.uint64_pub_account.has())) {
        break label690;
      }
      localObject1 = (im_msg_body.GroupPubAccountInfo)((im_msg_body.Elem)localObject4).group_pub_acc_info.get();
    }
    label141:
    label690:
    for (;;)
    {
      break;
      if (localObject1 == null) {
        return;
      }
      long l1 = ((im_msg_body.GroupPubAccountInfo)localObject1).uint64_pub_account.get();
      localObject1 = null;
      int i = 0;
      MessageForPubAccount localMessageForPubAccount = (MessageForPubAccount)MessageRecordFactory.a(-3006);
      localMessageForPubAccount.msgtype = -3006;
      localMessageForPubAccount.associatePubAccUin = l1;
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = paramList1.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (im_msg_body.Elem)localIterator.next();
        if ((((im_msg_body.Elem)localObject2).text.has()) && (((im_msg_body.Elem)localObject2).text.str.has()))
        {
          localMessageForPubAccount.msg = localStringBuilder.toString();
          localObject1 = new PAMessage();
          ((PAMessage)localObject1).msg = localStringBuilder.toString();
          localMessageForPubAccount.msgData = PAMessageUtil.a((PAMessage)localObject1);
        }
      }
      for (;;)
      {
        break label141;
        if (((im_msg_body.Elem)localObject2).trans_elem_info.has())
        {
          localObject2 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject2).trans_elem_info.get();
          int j = ((im_msg_body.TransElem)localObject2).elem_type.get();
          localObject2 = ((im_msg_body.TransElem)localObject2).elem_value.get().toByteArray();
          if (j != 16)
          {
            paramStringBuilder.append("PubAccount Message type is not 16.\n");
            break label141;
          }
          if ((localObject2 == null) || (localObject2.length == 0))
          {
            paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
            break label141;
          }
          if (localObject2[0] == 1)
          {
            i = PkgTools.a((byte[])localObject2, 1);
            j = localObject2[3];
            localObject4 = new byte[i - 1];
            PkgTools.a((byte[])localObject4, 0, (byte[])localObject2, 4, i - 1);
            localObject2 = localObject4;
            if (j == 1) {
              localObject2 = a((byte[])localObject4);
            }
            if (localObject2 != null) {}
            for (;;)
            {
              try
              {
                if (localObject2.length > 0)
                {
                  localObject2 = new String((byte[])localObject2, "utf-8");
                  localStringBuilder.append((String)localObject2);
                  localObject2 = a((String)localObject2);
                  localObject1 = localObject2;
                  i = 1;
                }
              }
              catch (Exception localException)
              {
                paramStringBuilder.append("PubAccount Message parse decodeContext.mPamag exception.\n");
              }
            }
            Object localObject3;
            if (localObject1 != null)
            {
              localObject3 = paramList1.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
                if ((((im_msg_body.Elem)localObject4).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject4).elem_flags2.get()).uint64_msg_id.has())) {
                  ((PAMessage)localObject1).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject4).elem_flags2.get()).uint64_msg_id.get();
                }
              }
              localMessageForPubAccount.mPAMessage = ((PAMessage)localObject1);
              localMessageForPubAccount.msgData = PAMessageUtil.a((PAMessage)localObject1);
            }
            if (i != 0)
            {
              localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getManager(51);
              if (paramMsg.msg_head.group_info.has())
              {
                long l2 = paramMsg.msg_head.group_info.group_code.get();
                localObject3 = ((TroopManager)localObject1).a(String.valueOf(l2));
                if (localObject3 != null)
                {
                  ((TroopInfo)localObject3).associatePubAccount = l1;
                  ((TroopManager)localObject1).b((TroopInfo)localObject3);
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(20).a(79, true, new Object[] { Long.valueOf(l2) });
                }
              }
            }
            paramList2.add(localMessageForPubAccount);
            if (i != 0) {
              break;
            }
            g(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo);
            return;
          }
        }
      }
    }
  }
  
  public void i(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = a(paramList1, paramStringBuilder);
    Object localObject2 = (MessageForReplyText.SourceMsgInfo)((Pair)localObject1).first;
    TroopTopicMgr.GroupPostElemInfo localGroupPostElemInfo = (TroopTopicMgr.GroupPostElemInfo)((Pair)localObject1).second;
    localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = a(paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, localArrayList);
    if ((localArrayList != null) && (localArrayList.size() == 2)) {
      if (localArrayList.get(0) != null)
      {
        paramList1 = (MessageForText.AtTroopMemberInfo)localArrayList.get(0);
        if (localArrayList.get(1) != null)
        {
          paramMsg = (byte[])localArrayList.get(1);
          paramStringBuilder = paramList1;
          paramList1 = paramMsg;
        }
      }
    }
    for (;;)
    {
      if ((((StringBuilder)localObject3).length() > 0) && (localObject2 != null))
      {
        paramMsg = (ChatMessage)MessageRecordFactory.a(-1049);
        paramMsg.msg = ((StringBuilder)localObject3).toString();
        localObject1 = (MessageForReplyText)paramMsg;
      }
      try
      {
        localObject3 = HexUtil.a(MessagePkgUtils.a((Serializable)localObject2));
        ((MessageForReplyText)localObject1).mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)localObject2);
        ((MessageForReplyText)localObject1).saveExtInfoToExtStr("sens_msg_source_msg_info", (String)localObject3);
        if (localGroupPostElemInfo != null)
        {
          localObject2 = HexUtil.a(MessagePkgUtils.a(localGroupPostElemInfo));
          ((MessageForReplyText)localObject1).mGroupPostElemInfo = localGroupPostElemInfo;
          ((MessageForReplyText)localObject1).saveExtInfoToExtStr("sens_msg_source_msg_troop_topic_info", (String)localObject2);
        }
        ((MessageForReplyText)localObject1).extLong |= 0x1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + localException.getMessage());
          }
        }
      }
      if ((TextUtils.isEmpty(((MessageForReplyText)localObject1).mSourceMsgInfo.mAnonymousNickName)) && (paramStringBuilder != null) && (!TextUtils.isEmpty(((MessageForReplyText)localObject1).msg)) && (((MessageForReplyText)localObject1).msg.length() > paramStringBuilder.textLen + 1))
      {
        ((MessageForReplyText)localObject1).msg = ((MessageForReplyText)localObject1).msg.substring(paramStringBuilder.textLen + 1);
        if (paramStringBuilder.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getLongAccountUin())) {
          paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a = -1L;
        }
      }
      if (paramList1 != null) {
        paramMsg.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a(paramList1));
      }
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "reply msgRand = " + MessageUtils.a(paramMsg.msgUid) + ", msgUid = " + paramMsg.msgUid);
      }
      paramList2.add(paramMsg);
      return;
      paramMsg = null;
      paramStringBuilder = paramList1;
      paramList1 = paramMsg;
      continue;
      paramList1 = null;
      break;
      paramList1 = null;
      paramStringBuilder = (StringBuilder)localObject1;
    }
  }
  
  public void j(List paramList1, List paramList2, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    String str = null;
    int k = 0;
    Object localObject1 = paramList1.iterator();
    int m = 0;
    int n = -1;
    int i1 = 0;
    im_msg_body.GeneralFlags localGeneralFlags = null;
    im_msg_body.Elem localElem;
    label72:
    int i;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localElem = (im_msg_body.Elem)((Iterator)localObject1).next();
      if (!localElem.general_flags.has()) {
        break label2002;
      }
      localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      i = i1;
      if (!localElem.bless_msg.has()) {
        break label1995;
      }
      i = i1;
      if (localElem.bless_msg.uint32_msg_type.get() != 1) {
        break label1995;
      }
      i = 1;
      if (!localElem.bless_msg.uint32_ex_flag.has()) {
        break label1995;
      }
      j = localElem.bless_msg.uint32_ex_flag.get();
      i = 1;
      label139:
      if ((!localElem.elem_flags2.has()) || (!localElem.elem_flags2.uint32_msg_rpt_cnt.has())) {
        break label1992;
      }
      m = localElem.elem_flags2.uint32_msg_rpt_cnt.get();
      label177:
      if ((!localElem.text.has()) || (!localElem.text.str.has())) {
        break label1989;
      }
      str = localElem.text.str.get().toStringUtf8();
      if ((str != null) && (str.startsWith("[")) && (str.endsWith("]")))
      {
        str = HexUtil.a(localElem.text.str.get().toByteArray());
        label264:
        n = k;
        if (localElem.text.has())
        {
          n = k;
          if (!localElem.text.bytes_pb_reserve.has()) {}
        }
      }
    }
    label1939:
    label1945:
    label1989:
    label1992:
    label1995:
    label2002:
    label2005:
    for (;;)
    {
      try
      {
        localObject3 = new TextMsgExtPb.ResvAttr();
        ((TextMsgExtPb.ResvAttr)localObject3).mergeFrom(localElem.text.bytes_pb_reserve.get().toByteArray());
        if (!((TextMsgExtPb.ResvAttr)localObject3).text_analysis_result.has()) {
          break label2005;
        }
        n = ((TextMsgExtPb.ResvAttr)localObject3).text_analysis_result.get();
        k = n;
        n = k;
      }
      catch (Exception localException)
      {
        QLog.e("DecodeMsg", 1, "parse TextMsgExtPb.ResvAttr error, ", localException);
        n = k;
        continue;
      }
      k = n;
      n = j;
      i1 = i;
      break;
      str = "";
      break label264;
      Object localObject2 = null;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(2);
      Object localObject3 = a(null, paramList1, paramList2, paramStringBuilder, paramMsg, paramMessageInfo, localArrayList1, localArrayList2);
      localObject1 = localObject2;
      if (localArrayList1 != null)
      {
        localObject1 = localObject2;
        if (localArrayList1.size() == 2)
        {
          localObject1 = localObject2;
          if (localArrayList1.get(1) != null) {
            localObject1 = (byte[])localArrayList1.get(1);
          }
        }
      }
      if (((StringBuilder)localObject3).length() == 0) {
        return;
      }
      long l3 = 0L;
      int i2 = 0;
      i = 0;
      j = 0;
      long l4 = 0L;
      long l2;
      if (localGeneralFlags != null)
      {
        l2 = l3;
        if (localGeneralFlags.bytes_pb_reserve.has())
        {
          i = i2;
          l2 = l3;
        }
      }
      for (;;)
      {
        boolean bool1;
        boolean bool3;
        try
        {
          paramList1 = new generalflags.ResvAttr();
          i = i2;
          l2 = l3;
          paramList1.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          l1 = l3;
          i = i2;
          l2 = l3;
          if (paramList1.redbag_msg_sender_uin.has())
          {
            i = 1;
            j = 1;
            l2 = l3;
            l1 = paramList1.redbag_msg_sender_uin.get();
          }
          l3 = l4;
          i = j;
          l2 = l1;
          if (paramList1.want_gift_sender_uin.has())
          {
            i = j;
            l2 = l1;
            l3 = paramList1.want_gift_sender_uin.get();
          }
          i = j;
          l2 = l3;
          l3 = l1;
          l1 = l2;
          j = i;
          l2 = l3;
          if (i == 0)
          {
            j = i;
            l2 = l3;
            if (localGeneralFlags.uint64_uin.has())
            {
              i = 1;
              l3 = localGeneralFlags.uint64_uin.get();
              j = i;
              l2 = l3;
              if (QLog.isColorLevel())
              {
                QLog.d("msgFold", 2, "from old version");
                l2 = l3;
                j = i;
              }
            }
          }
          if (j == 0) {
            break label1945;
          }
          if (localGeneralFlags.uint32_prp_fold.get() == 1)
          {
            bool2 = true;
            paramList1 = localGeneralFlags.bytes_rp_id.get().toStringUtf8();
            paramStringBuilder = localGeneralFlags.bytes_rp_index.get().toStringUtf8();
            bool1 = PasswdRedBagManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if ((j == 0) || (!PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b))) {
              break label1939;
            }
            if (TextUtils.isEmpty(paramList1)) {
              break label1630;
            }
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, redBagSender: %s, foldFlag: %s, redBagId: %s, index: %s, foldSwitch: %s, isValidFoldMsg: %s", new Object[] { Long.valueOf(l2), Boolean.valueOf(bool2), paramList1, paramStringBuilder, Boolean.valueOf(PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), Boolean.valueOf(bool1) }));
            }
            if (!String.valueOf(paramMsg.msg_head.from_uin.get()).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              break label1912;
            }
            bool3 = false;
            l3 = l2;
            l2 = l1;
            bool2 = bool1;
            l1 = l3;
            bool1 = bool3;
            j = 0;
            i = j;
            if (localGeneralFlags != null) {
              if (localGeneralFlags.long_text_flag.get() != 2)
              {
                i = j;
                if (localGeneralFlags.long_text_flag.get() != 1) {}
              }
              else
              {
                j = 1;
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, longTextFlag: true");
                  i = j;
                }
              }
            }
            if (!bool2) {
              break label1648;
            }
            paramMessageInfo = new MessageForFoldMsg();
            ((MessageForFoldMsg)paramMessageInfo).init(bool1, paramList1, paramStringBuilder, l1, true);
            paramList1 = paramMessageInfo;
            paramList1.msg = ((StringBuilder)localObject3).toString();
            if ((paramList1 instanceof MessageForText)) {
              TroopRobotManager.a(paramList1);
            }
            j = 0;
            i = j;
            if (paramMsg.msg_head.from_uin.has())
            {
              l1 = paramMsg.msg_head.from_uin.get();
              i = j;
              if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.getCurrentAccountUin(), Long.toString(l1))) {
                i = 1;
              }
            }
            if ((localObject1 != null) && (i == 0)) {
              paramList1.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a((byte[])localObject1));
            }
            if ((localGeneralFlags == null) || (!localGeneralFlags.babyq_guide_msg_cookie.has())) {}
          }
        }
        catch (Exception paramList1)
        {
          QLog.e("msgFold", 1, "prase ResvAttr error, ", paramList1);
        }
        try
        {
          paramStringBuilder = localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
          paramMsg = Utils.a(paramStringBuilder);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, guideMsgCookie: " + paramMsg + ",bytes: " + Arrays.toString(localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          }
          paramList1.saveExtInfoToExtStr("guide_msg_cookie", paramMsg);
          ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramStringBuilder);
        }
        catch (Exception paramStringBuilder)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DecodeMsg", 2, "get text guideMsgCookie error!", paramStringBuilder);
          continue;
          bool1 = false;
          continue;
        }
        if (i1 != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + n);
          }
          paramList1.isBlessMsg = true;
          if (n > -1)
          {
            if ((n & 0x1) != 1) {
              break label1877;
            }
            bool1 = true;
            paramList1.needUpdateMsgTag = bool1;
          }
        }
        if (m > 0)
        {
          paramList1.setRepeatCount(m);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "MessageForText ====> repeatCount = " + paramList1.getRepeatCount());
          }
        }
        j = 0;
        paramMsg = null;
        paramStringBuilder = paramMsg;
        i = j;
        if (localGeneralFlags != null)
        {
          paramStringBuilder = paramMsg;
          i = j;
          if (!localGeneralFlags.bytes_pb_reserve.has()) {}
        }
        try
        {
          paramMessageInfo = new generalflags.ResvAttr();
          paramMessageInfo.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          paramStringBuilder = paramMsg;
          i = j;
          if (paramMessageInfo.bytes_kpl_info.has())
          {
            paramStringBuilder = paramMsg;
            i = j;
            if (paramMessageInfo.bytes_kpl_info.has())
            {
              i = 1;
              paramStringBuilder = paramMessageInfo.bytes_kpl_info.get().toStringUtf8();
            }
          }
        }
        catch (Exception paramStringBuilder)
        {
          label1630:
          label1648:
          if (!QLog.isColorLevel()) {
            break label1900;
          }
          label1877:
          QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
          label1900:
          paramStringBuilder.printStackTrace();
          i = 0;
          paramStringBuilder = null;
          continue;
        }
        if (i != 0)
        {
          paramList1.saveExtInfoToExtStr("msg_ext_key", "Y");
          if (QLog.isColorLevel()) {
            QLog.d("KplMessage", 2, "resv a kpl text message !");
          }
          KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStringBuilder);
        }
        if (!TextUtils.isEmpty(str)) {
          paramList1.saveExtInfoToExtStr("small_description", str);
        }
        if ((paramList1 instanceof RecommendCommonMessage))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text save text_analysis_result=" + k);
          }
          paramList1.saveExtInfoToExtStr("ark_text_analysis_flag", String.valueOf(k));
        }
        paramList2.add(paramList1);
        return;
        long l1 = 0L;
        l3 = l2;
        continue;
        boolean bool2 = false;
        continue;
        if ((!TextUtils.isEmpty(paramStringBuilder)) && (bool1))
        {
          bool1 = true;
          continue;
          if (i != 0)
          {
            paramList1 = (ChatMessage)MessageRecordFactory.a(-1051);
            paramList1.saveExtInfoToExtStr("long_text_recv_state", "1");
            paramList1.removeExtInfoToExtStr("long_text_msg_resid");
          }
          else if (l2 != 0L)
          {
            paramList1 = new MessageForWantGiftMsg();
            ((MessageForWantGiftMsg)paramList1).wantGiftSenderUin = l2;
            ((MessageForWantGiftMsg)paramList1).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, l2 + "");
            ((MessageForWantGiftMsg)paramList1).msgtype = -2056;
          }
          else
          {
            paramList1 = (ChatMessage)MessageRecordFactory.a(-1000);
            if ((paramMessageInfo != null) && (localArrayList2 != null)) {
              AtTroopMemberSpan.a(paramMessageInfo.jdField_a_of_type_Int, localArrayList2, paramList1);
            }
            if (localArrayList1.size() > 0)
            {
              paramStringBuilder = new ArrayList(localArrayList1.size());
              paramMessageInfo = localArrayList1.iterator();
              while (paramMessageInfo.hasNext())
              {
                localObject2 = paramMessageInfo.next();
                if ((localObject2 instanceof MessageForText.AtTroopMemberInfo)) {
                  paramStringBuilder.add((MessageForText.AtTroopMemberInfo)localObject2);
                }
              }
              paramList1.atInfoTempList = paramStringBuilder;
            }
            continue;
            label1912:
            bool3 = bool1;
            bool1 = bool2;
            l3 = l1;
            l1 = l2;
            bool2 = bool3;
            l2 = l3;
          }
        }
        else
        {
          bool1 = false;
          continue;
          paramStringBuilder = null;
          bool1 = false;
          bool2 = false;
          paramList1 = null;
          l3 = l1;
          l1 = l2;
          l2 = l3;
          continue;
          paramStringBuilder = null;
          l1 = 0L;
          l2 = 0L;
          bool2 = false;
          bool1 = false;
          paramList1 = null;
        }
      }
      break label264;
      break label177;
      j = n;
      break label139;
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessagePBElemDecoder
 * JD-Core Version:    0.7.0.1
 */