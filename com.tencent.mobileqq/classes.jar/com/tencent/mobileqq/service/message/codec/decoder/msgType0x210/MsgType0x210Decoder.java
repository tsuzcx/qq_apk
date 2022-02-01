package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.qqproxy.GdtAppPreOrderDecoder;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb3;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc5;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xee;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xf9;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xfd;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactHandler;
import com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.dating.DarenAssistantHelper;
import com.tencent.mobileqq.dating.YanZhiHelper;
import com.tencent.mobileqq.gamecenter.message.GameMsgOfflineDecoder;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherPushHelper;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherParser;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.jetbrains.annotations.Nullable;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef.UinTypeUserDef;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.MsgInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.WithDrawWordingInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x141.SubMsgType0x141.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;

public class MsgType0x210Decoder
  implements Decoder<MessageHandler>
{
  private MapClassGenerator<Integer, SubTypeDecoder> a = new MapClassGeneratorImpl();
  
  public MsgType0x210Decoder()
  {
    a();
  }
  
  private MessageRecord a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    SubMsgType0xcb.MsgBody localMsgBody = new SubMsgType0xcb.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
      int i = localMsgBody.uint32_anchor_status.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramArrayOfByte.isLiving = bool;
      paramArrayOfByte.jumpingUrl = localMsgBody.bytes_jump_schema.get().toStringUtf8();
      paramArrayOfByte.msg = localMsgBody.bytes_live_wording.get().toStringUtf8();
      paramArrayOfByte.headUrl = localMsgBody.bytes_anchor_head_url.get().toStringUtf8();
      paramArrayOfByte.nickName = localMsgBody.bytes_anchor_nickname.get().toStringUtf8();
      paramArrayOfByte.liveEndWording = localMsgBody.bytes_live_end_wording.get().toStringUtf8();
      paramArrayOfByte.c2cMsgWording = localMsgBody.bytes_c2c_msg_wording.get().toStringUtf8();
      paramArrayOfByte.startLiveWordingType = localMsgBody.uint32_live_wording_type.get();
      paramArrayOfByte.endLiveWordingType = localMsgBody.uint32_end_wording_type.get();
      long l1 = paramMsg.msg_head.from_uin.get();
      i = paramMsg.msg_head.msg_seq.get();
      long l2 = paramMsg.msg_head.msg_uid.get();
      int j = paramMsg.msg_head.msg_type.get();
      paramArrayOfByte.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      paramArrayOfByte.msgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      paramArrayOfByte.shmsgseq = i;
      paramArrayOfByte.msgUid = l2;
      paramArrayOfByte.selfuin = paramMessageHandler.a.getCurrentAccountUin();
      paramArrayOfByte.istroop = 1001;
      paramArrayOfByte.senderuin = String.valueOf(AppConstants.NOW_LIVE_TIP_UIN_BASE + l1);
      paramArrayOfByte.frienduin = String.valueOf(AppConstants.NOW_LIVE_TIP_UIN_BASE + l1);
      paramArrayOfByte.getBytes();
      MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a());
      if (QLog.isColorLevel())
      {
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("status=");
        paramMessageHandler.append(paramArrayOfByte.isLiving);
        paramMessageHandler.append("jumpingUrl=");
        paramMessageHandler.append(paramArrayOfByte.jumpingUrl);
        paramMessageHandler.append("liveWording=");
        paramMessageHandler.append(paramArrayOfByte.msg);
        paramMessageHandler.append("headUrl");
        paramMessageHandler.append(paramArrayOfByte.headUrl);
        paramMessageHandler.append("nickName");
        paramMessageHandler.append(paramArrayOfByte.nickName);
        paramMessageHandler.append("startLiveWordingType=");
        paramMessageHandler.append(localMsgBody.uint32_live_wording_type.get());
        paramMessageHandler.append("endLiveWordingType=");
        paramMessageHandler.append(localMsgBody.uint32_end_wording_type.get());
        QLog.i("MsgType0x210Decoder", 2, paramMessageHandler.toString());
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "msg_box", "view_live_message", 0, 0, "", "", "", "");
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("decodeNearbyLiveTipMsg decode failed");
        paramArrayOfByte.append(paramMessageHandler.toString());
        QLog.i("MsgType0x210Decoder", 2, paramArrayOfByte.toString());
      }
    }
    return null;
  }
  
  @Nullable
  static msg_comm.MsgType0x210 a(msg_comm.Msg paramMsg)
  {
    Object localObject = new msg_comm.MsgType0x210();
    try
    {
      paramMsg = (msg_comm.MsgType0x210)((msg_comm.MsgType0x210)localObject).mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
    }
    catch (Exception paramMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", paramMsg);
      }
      paramMsg = null;
    }
    if (paramMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
      }
      return null;
    }
    if ((paramMsg.sub_msg_type.has()) && (paramMsg.msg_content.has())) {
      return paramMsg;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:");
      ((StringBuilder)localObject).append(paramMsg.sub_msg_type.has());
      ((StringBuilder)localObject).append(",hasMsgContent:");
      ((StringBuilder)localObject).append(paramMsg.msg_content.has());
      QLog.e("MsgType0x210Decoder", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210_0x102 offline ");
    }
    b(paramMessageHandler, paramMsg);
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x133");
    }
    try
    {
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      Face2FaceAddContactHandler localFace2FaceAddContactHandler = (Face2FaceAddContactHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.FACE2FACE_ADD_FRIEND_HANDLER);
      if (localFace2FaceAddContactHandler != null) {
        localFace2FaceAddContactHandler.a(paramMsgType0x210);
      }
      b(paramMessageHandler, paramMsg);
      return;
    }
    catch (Exception paramMessageHandler)
    {
      paramMsg = new StringBuilder();
      paramMsg.append("[msg0x210.uSubMsgType == 0x133], errInfo->");
      paramMsg.append(paramMessageHandler.getMessage());
      QLog.e("MsgType0x210Decoder", 1, paramMsg.toString());
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 321: 
      a(paramMessageHandler, paramMsgType0x210);
      return;
    case 307: 
      a(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 297: 
      f(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 290: 
    case 291: 
      b(paramMessageHandler, paramMsg, paramMsgType0x210, paramInt);
      return;
    case 287: 
      g(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 286: 
      h(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 281: 
      b(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 278: 
      if (QLog.isColorLevel())
      {
        QLog.d("MsgType0x210Decoder", 2, "submsgtype0x116 decodeC2CMsgPkg_MsgType0x210 receive 0x116 push message");
        return;
      }
      break;
    case 273: 
      i(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 264: 
      c(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 260: 
      d(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 256: 
      e(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 251: 
      j(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 244: 
      k(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 232: 
      b(paramMessageHandler, paramMsgType0x210);
      return;
    case 220: 
      l(paramMessageHandler, paramMsg, paramMsgType0x210);
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean, msg_comm.MsgType0x210 paramMsgType0x210, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      a(paramMessageHandler, paramMsg, paramMsgType0x210, paramInt);
      return;
    case 258: 
      a(paramMessageHandler, paramMsg);
      return;
    case 254: 
      n(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 253: 
      q(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 249: 
      r(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 238: 
      s(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 215: 
      m(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 203: 
      o(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 199: 
      p(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 197: 
      t(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 179: 
      c(paramMessageHandler, paramMsgType0x210);
      return;
    case 174: 
      u(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 170: 
      v(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 155: 
      w(paramMessageHandler, paramMsg, paramMsgType0x210);
      return;
    case 138: 
    case 139: 
      a(paramMessageHandler, paramBoolean, paramMsgType0x210);
      return;
    case 135: 
      d(paramMessageHandler, paramMsgType0x210);
    }
    b(paramMessageHandler, paramMsg);
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "PaiYiPai Revoke offLinePush receive submsgtype0x141 decodeC2CMsgPkg_MsgType0x210 receive 0x141 push message");
    }
    for (;;)
    {
      try
      {
        SubMsgType0x141.MsgBody localMsgBody = new SubMsgType0x141.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210);
        boolean bool = localMsgBody.uint64_aio_uin.has();
        String str2 = "";
        if (bool)
        {
          paramMsgType0x210 = String.valueOf(localMsgBody.uint64_aio_uin.get());
          if (!localMsgBody.uint64_busi_id.has()) {
            break label189;
          }
          str1 = String.valueOf(localMsgBody.uint64_busi_id.get());
          if (localMsgBody.uint64_tips_seq_id.has()) {
            str2 = String.valueOf(localMsgBody.uint64_tips_seq_id.get());
          }
          paramMessageHandler.a.getMessageFacade().a().a(paramMsgType0x210, str1, str2, 0, false);
          return;
        }
      }
      catch (Exception paramMessageHandler)
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("PaiYiPai Revoke offLinePush receive submsgtype0x141 decodeC2CMsgPkg_MsgType0x210 receive 0x141 push message, errInfo->");
        paramMsgType0x210.append(paramMessageHandler.getMessage());
        QLog.e("MsgType0x210Decoder", 1, paramMsgType0x210.toString());
        return;
      }
      paramMsgType0x210 = "";
      continue;
      label189:
      String str1 = "";
    }
  }
  
  private void a(MessageHandler paramMessageHandler, boolean paramBoolean, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (paramBoolean) {
      return;
    }
    Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
    try
    {
      localReqBody.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      a(paramMessageHandler.a, localReqBody, 0L, false);
      return;
    }
    catch (Exception paramMessageHandler)
    {
      label42:
      break label42;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b offline msg, prase reqBody error");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Submsgtype0x8a.ReqBody paramReqBody, long paramLong, boolean paramBoolean)
  {
    Object localObject1 = (ArrayList)paramReqBody.msg_info.get();
    Object localObject2 = new msgrevoke_userdef.UinTypeUserDef();
    try
    {
      ((msgrevoke_userdef.UinTypeUserDef)localObject2).mergeFrom(paramReqBody.bytes_reserved.get().toByteArray());
      int i = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint32_from_uin_type.get();
      long l;
      if (i == 1)
      {
        i = 1000;
        l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
      }
      else if (i == 2)
      {
        i = 1004;
        l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
      }
      else
      {
        l = 0L;
        i = 0;
      }
      localObject2 = new ArrayList();
      paramReqBody = ((ArrayList)localObject1).iterator();
      while (paramReqBody.hasNext())
      {
        localObject3 = (Submsgtype0x8a.MsgInfo)paramReqBody.next();
        localObject1 = new RevokeMsgInfo();
        ((RevokeMsgInfo)localObject1).jdField_a_of_type_Int = i;
        ((RevokeMsgInfo)localObject1).jdField_b_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject3).uint64_from_uin.get());
        ((RevokeMsgInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject3).uint64_to_uin.get());
        ((RevokeMsgInfo)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(l);
        ((RevokeMsgInfo)localObject1).jdField_a_of_type_Long = ((short)((Submsgtype0x8a.MsgInfo)localObject3).uint32_msg_seq.get());
        ((RevokeMsgInfo)localObject1).jdField_b_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject3).uint64_msg_uid.get();
        ((RevokeMsgInfo)localObject1).jdField_c_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject3).uint64_msg_time.get();
        ((RevokeMsgInfo)localObject1).jdField_b_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject3).uint32_div_seq.get();
        ((RevokeMsgInfo)localObject1).jdField_c_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject3).uint32_pkg_num.get();
        ((RevokeMsgInfo)localObject1).jdField_d_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject3).uint32_pkg_index.get();
        boolean bool;
        if ((((Submsgtype0x8a.MsgInfo)localObject3).uint32_flag.get() & 0x8) == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((RevokeMsgInfo)localObject1).jdField_a_of_type_Boolean = bool;
        if (((Submsgtype0x8a.MsgInfo)localObject3).msg_wording_info.has())
        {
          ((RevokeMsgInfo)localObject1).g = ((Submsgtype0x8a.MsgInfo)localObject3).msg_wording_info.int32_item_id.get();
          ((RevokeMsgInfo)localObject1).f = ((Submsgtype0x8a.MsgInfo)localObject3).msg_wording_info.string_item_name.get();
        }
        ((ArrayList)localObject2).add(localObject1);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("recv 0x210_0x8a_8b msg,");
          ((StringBuilder)localObject3).append(((RevokeMsgInfo)localObject1).toString());
          QLog.d("revokeMsg", 2, ((StringBuilder)localObject3).toString());
        }
      }
      if (!paramBoolean)
      {
        paramQQAppInterface.getMessageFacade().a((ArrayList)localObject2, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b subaccount msg");
      }
      if (((ArrayList)localObject2).isEmpty()) {
        return;
      }
      paramReqBody = Long.toString(paramLong);
      localObject1 = paramQQAppInterface.getCurrentAccountUin();
      ISubAccountService localISubAccountService = (ISubAccountService)paramQQAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localISubAccountService == null) {
        return;
      }
      Object localObject6 = localISubAccountService.getAllMessage(paramReqBody);
      Iterator localIterator1 = ((ArrayList)localObject2).iterator();
      localObject2 = null;
      String str = "";
      Object localObject3 = null;
      Object localObject4;
      Object localObject5;
      while (localIterator1.hasNext())
      {
        localObject4 = (RevokeMsgInfo)localIterator1.next();
        Iterator localIterator2 = ((List)localObject6).iterator();
        while (localIterator2.hasNext())
        {
          localObject5 = (SubAccountMessage)localIterator2.next();
          if ((((RevokeMsgInfo)localObject4).jdField_a_of_type_Long == ((SubAccountMessage)localObject5).shmsgseq) && (((RevokeMsgInfo)localObject4).jdField_b_of_type_Long == ((SubAccountMessage)localObject5).msgUid))
          {
            str = ((RevokeMsgInfo)localObject4).f;
            localObject2 = localObject4;
            localObject3 = localObject5;
            break;
          }
        }
      }
      if (localObject2 != null)
      {
        localObject5 = HardCodeUtil.a(2131706690);
        localObject4 = (SubAccountMessage)((SubAccountMessage)localObject3).deepCopyByReflect();
        ((SubAccountMessage)localObject4).msg = ((String)localObject5).concat(BaseApplicationImpl.getApplication().getString(2131694325));
        if (!TextUtils.isEmpty(str))
        {
          localObject5 = ((SubAccountMessage)localObject4).msg;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("，");
          ((StringBuilder)localObject6).append(str);
          ((SubAccountMessage)localObject4).msg = ((String)localObject5).concat(((StringBuilder)localObject6).toString());
        }
        ((SubAccountMessage)localObject4).unreadNum = Math.max(0, ((SubAccountMessage)localObject3).unreadNum - 1);
        ((SubAccountMessage)localObject4).time = ((RevokeMsgInfo)localObject2).jdField_c_of_type_Long;
        ((SubAccountMessage)localObject4).needNotify = paramQQAppInterface.isBackgroundPause;
        ((SubAccountMessage)localObject4).mTimeString = TimeFormatterUtils.a(((SubAccountMessage)localObject4).time * 1000L, true, ((ISubAccountControlService)paramQQAppInterface.getRuntimeService(ISubAccountControlService.class, "")).getDateFormate());
        ((SubAccountMessage)localObject4).mEmoRecentMsg = new QQText(((SubAccountMessage)localObject4).msg, 0);
        if (localISubAccountService != null) {
          localISubAccountService.addNewMessage((SubAccountMessage)localObject4);
        }
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(paramQQAppInterface, paramReqBody, 6);
        localObject2 = ((SubAccountMessage)localObject4).convertToMessageRecord();
        ((MessageRecord)localObject2).istroop = 7000;
        ((MessageRecord)localObject2).frienduin = paramReqBody;
        paramQQAppInterface.getConversationFacade().d(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, -1);
        if (localISubAccountService != null) {
          localISubAccountService.updateAnotherSubAccountUnreadMsg(paramReqBody);
        }
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject2);
        paramQQAppInterface.getMessageFacade().a((ArrayList)localObject3, (String)localObject1, false, false, true);
        if (paramQQAppInterface.isLogin()) {
          ((IAppBadgeService)paramQQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
        localObject2 = new SubAccountBackProtocData();
        ((SubAccountBackProtocData)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
        ((SubAccountBackProtocData)localObject2).jdField_c_of_type_JavaLangString = paramReqBody;
        ((SubAccountBackProtocData)localObject2).jdField_c_of_type_Boolean = true;
        ((SubAccountBackProtocData)localObject2).d = true;
        ((SubAccountBackProtocData)localObject2).jdField_a_of_type_Int = 0;
        paramQQAppInterface.getMsgHandler().a().a(8003, true, localObject2);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      label991:
      break label991;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg, prase uintypeUserdef error");
    }
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg)
  {
    MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.a());
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message");
    }
    try
    {
      SubMsgType0x119.MsgBody localMsgBody = new SubMsgType0x119.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210);
      if (!((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isPushMessageDuplicated(paramMsg.msg_head.msg_seq.get()))
      {
        ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).insertTroopFormGrayTips(paramMessageHandler.a, localMsgBody);
        QLog.d("MsgType0x210Decoder", 1, "troopFormLog isPushMessageDuplicated ");
      }
      b(paramMessageHandler, paramMsg);
      return;
    }
    catch (Exception paramMessageHandler)
    {
      paramMsg = new StringBuilder();
      paramMsg.append("troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message, errInfo->");
      paramMsg.append(paramMessageHandler.getMessage());
      QLog.e("MsgType0x210Decoder", 1, paramMsg.toString());
    }
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleC2COfflinePushMsgGrayTip subType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MsgType0x210Decoder", 2, ((StringBuilder)localObject).toString());
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    Object localObject = new MsgInfo();
    ((MsgInfo)localObject).lFromUin = paramMsg.msg_head.from_uin.get();
    ((MsgInfo)localObject).shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
    ((MsgInfo)localObject).uMsgTime = paramMsg.msg_head.msg_time.get();
    ((MsgInfo)localObject).uRealMsgTime = paramMsg.msg_head.msg_time.get();
    ((MsgInfo)localObject).lMsgUid = paramMsg.msg_head.msg_uid.get();
    ((MsgInfo)localObject).shMsgType = ((short)paramMsg.msg_head.msg_type.get());
    paramMessageHandler = paramMessageHandler.a;
    boolean bool;
    if (paramInt == 290) {
      bool = true;
    } else {
      bool = false;
    }
    UniteGrayTipUtil.a(paramMessageHandler, paramMsgType0x210, (MsgInfo)localObject, bool);
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.offline]");
    try
    {
      submsgtype0xe8.MsgBody localMsgBody = new submsgtype0xe8.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      if (localMsgBody.msg_item.has())
      {
        paramMsgType0x210 = (apollo_push_msgInfo.STPushMsgElem)localMsgBody.msg_item.get();
        if (paramMessageHandler.a != null)
        {
          paramMessageHandler = (IApolloPushManager)paramMessageHandler.a.getRuntimeService(IApolloPushManager.class, "all");
          paramMessageHandler.onRecvActionPush(0, paramMsgType0x210);
          paramMessageHandler.onReceiveDrawerHirePush(paramMsgType0x210);
          paramMessageHandler.onReceiveAioPush(paramMsgType0x210);
          return;
        }
      }
    }
    catch (Exception paramMessageHandler)
    {
      paramMessageHandler.printStackTrace();
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("[msg0x210.uSubMsgType == 0xe8], errInfo->");
      paramMsgType0x210.append(paramMessageHandler.getMessage());
      QLog.e("ApolloPushManager", 1, paramMsgType0x210.toString());
    }
  }
  
  private void c(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x108");
    }
    if (paramMessageHandler.a == null) {
      return;
    }
    paramMsgType0x210 = YanZhiHelper.a(paramMessageHandler.a, paramMsgType0x210.msg_content.get().toByteArray(), paramMsg);
    paramMessageHandler.a.getMessageFacade().a(paramMsgType0x210, paramMessageHandler.a.getCurrentAccountUin());
    b(paramMessageHandler, paramMsg);
  }
  
  private void c(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xb3 receive 0xaa push message");
    }
    paramMsgType0x210 = SubType0xb3.a(paramMessageHandler.a, paramMsgType0x210.msg_content.get().toByteArray());
    if (!TextUtils.isEmpty(paramMsgType0x210))
    {
      boolean bool = ((FriendsManager)paramMessageHandler.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramMsgType0x210);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMsgType0x210SubMsgType0xb3 isFriend=");
        localStringBuilder.append(bool);
        localStringBuilder.append(", uin=");
        localStringBuilder.append(paramMsgType0x210);
        QLog.d("MsgType0x210Decoder", 2, localStringBuilder.toString());
      }
      if (!bool)
      {
        QLog.d("MsgType0x210Decoder", 1, "handleMsgType0x210SubMsgType0xb3 not friend, getDetail");
        ((FriendListHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendDetailInfo(paramMsgType0x210);
      }
    }
  }
  
  private void d(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0x104  push message");
    }
    try
    {
      long l1 = paramMsg.msg_head.from_uin.get();
      int i = paramMsg.msg_head.msg_seq.get();
      long l2 = paramMsg.msg_head.msg_uid.get();
      int j = paramMsg.msg_head.msg_type.get();
      paramMsg = new submsgtype0x104.MsgBody();
      paramMsg.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      paramMessageHandler.a.getProxyManager().a().a(paramMsg);
      MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a());
      return;
    }
    catch (Exception paramMessageHandler)
    {
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("onLinePush receive 0x210_0x104 wrong:");
        paramMsg.append(paramMessageHandler.toString());
        QLog.i("MsgType0x210Decoder", 2, paramMsg.toString());
      }
    }
  }
  
  private void d(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    try
    {
      SubMsgType0x87.MsgBody localMsgBody = new SubMsgType0x87.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      if (localMsgBody.rpt_msg_msg_notify.has())
      {
        CloneFriendPushHelper.a(paramMessageHandler.a, localMsgBody);
        return;
      }
    }
    catch (Exception paramMessageHandler)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x210Decoder", 2, "offline push parse 0x210 subtype 0x87 msg error", paramMessageHandler);
      }
    }
  }
  
  private void e(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x100");
    }
    if (paramMessageHandler.a == null) {
      return;
    }
    paramMsgType0x210 = DarenAssistantHelper.a(paramMessageHandler.a, paramMsgType0x210.msg_content.get().toByteArray(), paramMsg);
    paramMessageHandler.a.getMessageFacade().a(paramMsgType0x210, paramMessageHandler.a.getCurrentAccountUin());
    b(paramMessageHandler, paramMsg);
  }
  
  private void f(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x127 invoked, info: 0x127");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    TogetherParser localTogetherParser = ((TogetherControlManager)paramMessageHandler.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4);
    if (localTogetherParser != null) {
      localTogetherParser.a(paramMessageHandler.a, paramMsgType0x210, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
    }
    b(paramMessageHandler, paramMsg);
  }
  
  private void g(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked, info: 0x11f");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    ListenTogetherPushHelper.a(paramMessageHandler.a, paramMsgType0x210, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
    b(paramMessageHandler, paramMsg);
  }
  
  private void h(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x11e");
    }
    try
    {
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      FriendListHandler localFriendListHandler = (FriendListHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (localFriendListHandler != null) {
        localFriendListHandler.decodePush0x210_0x11e(paramMsgType0x210);
      }
      b(paramMessageHandler, paramMsg);
      return;
    }
    catch (Exception paramMessageHandler)
    {
      paramMsg = new StringBuilder();
      paramMsg.append("[msg0x210.uSubMsgType == 0x11e], errInfo->");
      paramMsg.append(paramMessageHandler.getMessage());
      QLog.e("MsgType0x210Decoder", 1, paramMsg.toString());
    }
  }
  
  private void i(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x111");
    }
    try
    {
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      MayknowRecommendManager.a(paramMessageHandler.a, paramMsgType0x210);
      b(paramMessageHandler, paramMsg);
      return;
    }
    catch (Exception paramMessageHandler)
    {
      paramMsg = new StringBuilder();
      paramMsg.append("[msg0x210.uSubMsgType == 0x111], errInfo->");
      paramMsg.append(paramMessageHandler.getMessage());
      QLog.e("MsgType0x210Decoder", 1, paramMsg.toString());
    }
  }
  
  private void j(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0xfb");
    }
    try
    {
      Object localObject = new NowPushMsgList.MsgBody();
      ((NowPushMsgList.MsgBody)localObject).mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      paramMsgType0x210 = ((NowPushMsgList.MsgBody)localObject).rpt_now_push_msg.get().iterator();
      while (paramMsgType0x210.hasNext())
      {
        localObject = (NowPushMsgList.NowPushMsg)paramMsgType0x210.next();
        if (paramMessageHandler.a != null) {
          ((NowHongbaoPushManager)paramMessageHandler.a.getManager(QQManagerFactory.NOW_HONG_BAO_PUSH_MANAGER)).b((NowPushMsgList.NowPushMsg)localObject);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeC2CMsgPkg_MsgType0x210 0xfb ");
          localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint32_switch.get());
          localStringBuilder.append("  uint32_task_id ");
          localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint32_task_id.get());
          localStringBuilder.append("  uint32_type ");
          localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint32_type.get());
          localStringBuilder.append("  uint64_start_time ");
          localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint64_start_time.get());
          localStringBuilder.append("  uint64_end_time ");
          localStringBuilder.append(((NowPushMsgList.NowPushMsg)localObject).uint64_end_time.get());
          localStringBuilder.append(" app=");
          localStringBuilder.append(paramMessageHandler.a);
          QLog.d("MsgType0x210Decoder", 2, localStringBuilder.toString());
        }
      }
      b(paramMessageHandler, paramMsg);
      return;
    }
    catch (Exception paramMessageHandler)
    {
      paramMsg = new StringBuilder();
      paramMsg.append("[msg0x210.uSubMsgType == 0xfb], errInfo->");
      paramMsg.append(paramMessageHandler.getMessage());
      QLog.e("MsgType0x210Decoder", 1, paramMsg.toString());
    }
  }
  
  private void k(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: AIO Feed offline messageRecord: 0xf4");
    }
    long l = paramMsg.msg_head.from_uin.get();
    paramMsg = paramMsgType0x210.msg_content.get().toByteArray();
    paramMessageHandler = (QQStoryFeedManager)paramMessageHandler.a.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER);
    paramMessageHandler.a(paramMessageHandler.a(paramMsg, String.valueOf(l)));
  }
  
  private void l(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xdc push message");
    }
    if (paramMessageHandler.a != null)
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramMessageHandler.a.getRuntimeService(IApolloManagerService.class, "all");
      if (localIApolloManagerService != null) {
        localIApolloManagerService.decodeApolloBubblePushData(paramMsgType0x210.msg_content.get().toByteArray());
      }
    }
    b(paramMessageHandler, paramMsg);
  }
  
  private void m(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xd7 push message");
    }
    long l1 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l2 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    ((MsgBoxInterFollowManager)paramMessageHandler.a.getManager(QQManagerFactory.MSG_BOX_INTERACT_MANAGER)).decode0xd7InteractAndFollowMsg(paramMsgType0x210.msg_content.get().toByteArray());
    MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a());
  }
  
  private void n(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xfe push message");
    }
    long l1 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l2 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    ((MsgBoxInterFollowManager)paramMessageHandler.a.getManager(QQManagerFactory.MSG_BOX_INTERACT_MANAGER)).decode0xfeInteractAndFollowMsg(paramMsgType0x210.msg_content.get().toByteArray());
    MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a());
  }
  
  private void o(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tag_nearby_live_tip", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0xcb push message");
    }
    paramMsgType0x210 = a(paramMessageHandler, paramMsgType0x210.msg_content.get().toByteArray(), paramMsg);
    if ((paramMsgType0x210 != null) && (!MessageHandlerUtils.a(paramMessageHandler.a, paramMsgType0x210, true)) && (paramMsgType0x210.msgtype == -2053))
    {
      paramMsg = (MessageForNearbyLiveTip)paramMsgType0x210;
      if ((MessageForNearbyLiveTip.isHuayangTip(paramMsg.jumpingUrl)) && (!MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramMsg.jumpingUrl)))
      {
        if (QLog.isColorLevel())
        {
          paramMessageHandler = new StringBuilder();
          paramMessageHandler.append("decodeC2CMsgPkg_MsgType0x210 discard a not support huayang tips message, jumpUrl=");
          paramMessageHandler.append(paramMsg.jumpingUrl);
          QLog.i("Q.nearby.tag_nearby_live_tip", 2, paramMessageHandler.toString());
        }
        return;
      }
      if (paramMsg.isLiving)
      {
        paramMessageHandler.a.getMessageFacade().a(paramMsgType0x210, paramMessageHandler.a.getCurrentAccountUin());
        return;
      }
      Message localMessage = paramMessageHandler.a.getMessageFacade().getLastMessage(paramMsg.frienduin, paramMsg.istroop);
      if (localMessage != null)
      {
        paramMessageHandler.a.getMessageFacade().a(paramMsg.frienduin, paramMsg.istroop, localMessage.uniseq, paramMsg.msgData);
        paramMsgType0x210 = new ArrayList();
        paramMsgType0x210.add(paramMsg);
        paramMessageHandler.a.getMessageFacade().b(paramMsgType0x210);
        return;
      }
      paramMessageHandler.a.getMessageFacade().a(paramMsgType0x210, paramMessageHandler.a.getCurrentAccountUin());
    }
  }
  
  private void p(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7  push message");
    }
    long l1 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l2 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    int k = paramMsg.msg_head.msg_time.get();
    paramMsg = new PushMsg0x210C7Info(l1, i, l2, j, k, false);
    ((OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor")).a(paramMsgType0x210.msg_content.get().toByteArray(), paramMsg);
    MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a());
  }
  
  private void q(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    OnLinePushMessageProcessor localOnLinePushMessageProcessor = (OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor");
    MsgInfo localMsgInfo = new MsgInfo();
    localMsgInfo.lFromUin = paramMsg.msg_head.from_uin.get();
    localMsgInfo.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
    localMsgInfo.uMsgTime = paramMsg.msg_head.msg_time.get();
    localMsgInfo.uRealMsgTime = paramMsg.msg_head.msg_time.get();
    localMsgInfo.lMsgUid = paramMsg.msg_head.msg_uid.get();
    localMsgInfo.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
    SubType0xfd.a((QQAppInterface)localOnLinePushMessageProcessor.a(), paramMsgType0x210.msg_content.get().toByteArray(), 2);
    MessageProtoCodec.a(localMsgInfo.lFromUin, localMsgInfo.shMsgSeq, localMsgInfo.lMsgUid, localMsgInfo.shMsgType, paramMessageHandler.a());
  }
  
  private void r(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    OnLinePushMessageProcessor localOnLinePushMessageProcessor = (OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor");
    MsgInfo localMsgInfo = new MsgInfo();
    localMsgInfo.lFromUin = paramMsg.msg_head.from_uin.get();
    localMsgInfo.shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
    localMsgInfo.uMsgTime = paramMsg.msg_head.msg_time.get();
    localMsgInfo.uRealMsgTime = paramMsg.msg_head.msg_time.get();
    localMsgInfo.lMsgUid = paramMsg.msg_head.msg_uid.get();
    localMsgInfo.shMsgType = ((short)paramMsg.msg_head.msg_type.get());
    SubType0xf9.a((QQAppInterface)localOnLinePushMessageProcessor.a(), paramMsgType0x210.msg_content.get().toByteArray(), 2, localMsgInfo);
    MessageProtoCodec.a(localMsgInfo.lFromUin, localMsgInfo.shMsgSeq, localMsgInfo.lMsgUid, localMsgInfo.shMsgType, paramMessageHandler.a());
  }
  
  private void s(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xee receive 0xee push message");
    }
    SubType0xee.a(paramMessageHandler.a, paramMsgType0x210.msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
    b(paramMessageHandler, paramMsg);
  }
  
  private void t(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xc5 receive 0xc5 push message");
    }
    SubType0xc5.a((OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor"), paramMsgType0x210.msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
    b(paramMessageHandler, paramMsg);
  }
  
  private void u(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xae receive 0xae push message");
    }
    Object localObject = new SubMsgType0xae.MsgBody();
    try
    {
      ((SubMsgType0xae.MsgBody)localObject).mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      if ((!((SubMsgType0xae.MsgBody)localObject).uint32_type.has()) || (((SubMsgType0xae.MsgBody)localObject).uint32_type.get() != 2)) {
        break label631;
      }
      long l = ((SubMsgType0xae.MsgBody)localObject).msg_persons_may_know.fixed32_timestamp.get();
      if (QLog.isColorLevel())
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("handlePushRecommend receive push time=");
        paramMsgType0x210.append(l);
        QLog.d("MsgType0x210Decoder", 2, paramMsgType0x210.toString());
      }
      localObject = ((SubMsgType0xae.MsgBody)localObject).msg_persons_may_know.rpt_msg_friend_list.get();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label631;
      }
      paramMsgType0x210 = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SubMsgType0xae.PersonMayKnow localPersonMayKnow = (SubMsgType0xae.PersonMayKnow)((Iterator)localObject).next();
        PushRecommend localPushRecommend = new PushRecommend();
        if (localPersonMayKnow.uint64_uin.has()) {
          localPushRecommend.uin = Long.toString(localPersonMayKnow.uint64_uin.get());
        }
        if (localPersonMayKnow.bytes_name.has()) {
          localPushRecommend.nick = new String(localPersonMayKnow.bytes_name.get().toByteArray());
        }
        if (localPersonMayKnow.uint32_age.has()) {
          localPushRecommend.age = ((short)localPersonMayKnow.uint32_age.get());
        }
        if (localPersonMayKnow.uint32_sex.has()) {
          localPushRecommend.gender = ((short)localPersonMayKnow.uint32_sex.get());
        }
        if (localPersonMayKnow.bytes_main_reason.has()) {
          localPushRecommend.recommendReason = new String(localPersonMayKnow.bytes_main_reason.get().toByteArray());
        }
        if (localPersonMayKnow.bytes_alghrithm.has()) {
          localPushRecommend.algBuffer = localPersonMayKnow.bytes_alghrithm.get().toByteArray();
        }
        if (localPersonMayKnow.bytes_soure_reason.has()) {
          localPushRecommend.sourceReason = new String(localPersonMayKnow.bytes_soure_reason.get().toByteArray());
        }
        if (localPersonMayKnow.uint32_source.has()) {
          localPushRecommend.fromSource = localPersonMayKnow.uint32_source.get();
        }
        if (localPersonMayKnow.msg_android_source.has())
        {
          SubMsgType0xae.AddFriendSource localAddFriendSource = (SubMsgType0xae.AddFriendSource)localPersonMayKnow.msg_android_source.get();
          if (localAddFriendSource != null)
          {
            if (localAddFriendSource.uint32_source.has()) {
              localPushRecommend.sourceId = localAddFriendSource.uint32_source.get();
            }
            if (localAddFriendSource.uint32_sub_source.has()) {
              localPushRecommend.subSourceId = localAddFriendSource.uint32_sub_source.get();
            }
          }
        }
        if (localPersonMayKnow.bytes_msg.has()) {
          localPushRecommend.wzryVerifyStr = new String(localPersonMayKnow.bytes_msg.get().toByteArray());
        }
        if (localPersonMayKnow.uint32_game_source.has()) {
          localPushRecommend.wzrySourceId = localPersonMayKnow.uint32_game_source.get();
        }
        if (localPersonMayKnow.bytes_role_name.has()) {
          localPushRecommend.wzryGameNick = new String(localPersonMayKnow.bytes_role_name.get().toByteArray());
        }
        localPushRecommend.timestamp = l;
        paramMsgType0x210.add(localPushRecommend);
      }
    }
    catch (Exception paramMsgType0x210)
    {
      label615:
      label631:
      break label615;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "recv 0x210_0xae, prase msgBody error");
    }
    b(paramMessageHandler, paramMsg);
  }
  
  private void v(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xaa receive 0xaa push message");
    }
    SubMsgType0xaa.MsgBody localMsgBody = new SubMsgType0xaa.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
    }
    catch (Exception paramMsgType0x210)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xaa, prase msgBody error");
    }
    ((GamePartyManager)paramMessageHandler.a.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(localMsgBody, true);
    b(paramMessageHandler, paramMsg);
  }
  
  private void w(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0x9b.MsgBody localMsgBody = new SubMsgType0x9b.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      b(paramMessageHandler, paramMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      paramMessageHandler.printStackTrace();
    }
  }
  
  protected void a()
  {
    this.a.a(Integer.valueOf(0), DataLineDecoder.class);
    this.a.a(Integer.valueOf(38), TroopNewsDecoder.class);
    this.a.a(Integer.valueOf(48), ShieldListDecoder.class);
    this.a.a(Integer.valueOf(61), SttResultDecoder.class);
    this.a.a(Integer.valueOf(63), PublicAccountDecoder.class);
    this.a.a(Integer.valueOf(78), TroopAnnouncementDecoder.class);
    this.a.a(Integer.valueOf(81), DevLockQuickLoginDecoder.class);
    this.a.a(Integer.valueOf(102), PCWalletPayDecoder.class);
    this.a.a(Integer.valueOf(103), NearbyTroopDecoder.class);
    this.a.a(Integer.valueOf(107), PCActiveNoticeDecoder.class);
    this.a.a(Integer.valueOf(110), RecommendTroopDecoder.class);
    this.a.a(Integer.valueOf(111), TurnBrandTipsDecoder.class);
    this.a.a(Integer.valueOf(114), QPayReminderDecoder.class);
    this.a.a(Integer.valueOf(118), ActivateFriendsDecoder.class);
    this.a.a(Integer.valueOf(124), SecSpyFileDecoder.class);
    this.a.a(Integer.valueOf(177), TroopInviteVideoDecoder.class);
    this.a.a(Integer.valueOf(296), ExtendFriendDecoder.class);
    this.a.a(Integer.valueOf(311), ExtendFriendDecoder.class);
    this.a.a(Integer.valueOf(314), ReminderDecoder.class);
    this.a.a(Integer.valueOf(315), FilterMsgDecoder.class);
    this.a.a(Integer.valueOf(316), GdtAppPreOrderDecoder.class);
    this.a.a(Integer.valueOf(284), GameMsgOfflineDecoder.class);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (paramDecodeProtoPkgContext.d) {
      return;
    }
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) {
        return;
      }
      boolean bool = paramDecodeProtoPkgContext.d;
      msg_comm.MsgType0x210 localMsgType0x210 = a(paramMsg);
      if (localMsgType0x210 == null) {
        return;
      }
      int i = localMsgType0x210.sub_msg_type.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:");
        ((StringBuilder)localObject).append(i);
        QLog.d("MsgType0x210Decoder", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (SubTypeDecoder)this.a.a(Integer.valueOf(i));
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("subType=");
          localStringBuilder.append(i);
          localStringBuilder.append(", decoder=");
          localStringBuilder.append(localObject);
          QLog.d("MsgType0x210Decoder", 2, localStringBuilder.toString());
        }
        ((SubTypeDecoder)localObject).a(localMsgType0x210, paramMsg, paramList, paramDecodeProtoPkgContext, paramMessageHandler);
      }
      a(paramMessageHandler, paramMsg, bool, localMsgType0x210, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder
 * JD-Core Version:    0.7.0.1
 */