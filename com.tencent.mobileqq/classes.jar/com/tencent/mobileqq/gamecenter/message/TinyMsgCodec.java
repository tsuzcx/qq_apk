package com.tencent.mobileqq.gamecenter.message;

import PushNotifyPack.C2CMsgReadedNotify;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.helper.GameMsgSayHiHelper;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.json.JSONObject;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34.GameSession;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class TinyMsgCodec
{
  public static long a(long paramLong, msg_comm.UinPairMsg paramUinPairMsg, AppInterface paramAppInterface)
  {
    if (paramUinPairMsg != null) {
      try
      {
        if ((paramUinPairMsg.service_type.has()) && (paramUinPairMsg.service_type.get() == 164))
        {
          if (paramUinPairMsg.uint64_to_tiny_id.has())
          {
            paramUinPairMsg = String.valueOf(paramUinPairMsg.uint64_to_tiny_id.get());
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("convertTinyToUin is called, fromTinyId: ");
              localStringBuilder.append(paramLong);
              localStringBuilder.append("toTinyId :");
              localStringBuilder.append(paramUinPairMsg);
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, localStringBuilder.toString());
            }
            return Long.parseLong(((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a(String.valueOf(paramLong), paramUinPairMsg));
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, but toTinyId is not contained.");
            return paramLong;
          }
        }
      }
      catch (Exception paramUinPairMsg)
      {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 1, "convertTinyToUin is called", paramUinPairMsg);
      }
    }
    return paramLong;
  }
  
  private static String a(AppInterface paramAppInterface, TinyInfo paramTinyInfo, MessageRecord paramMessageRecord)
  {
    try
    {
      paramAppInterface = ((IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getRedDotConfig(paramTinyInfo.toRoleId);
      paramTinyInfo = paramMessageRecord.getExtInfoFromExtStr(GameMsgSayHiHelper.a);
      if (TextUtils.isEmpty(paramTinyInfo)) {
        return paramAppInterface;
      }
      int i = Integer.valueOf(paramTinyInfo).intValue();
      if (TextUtils.isEmpty(paramAppInterface)) {
        paramAppInterface = new JSONObject();
      } else {
        paramAppInterface = new JSONObject(paramAppInterface);
      }
      paramAppInterface.put("g", i);
      paramAppInterface = paramAppInterface.toString();
      return paramAppInterface;
    }
    catch (Throwable paramAppInterface)
    {
      paramTinyInfo = new StringBuilder();
      paramTinyInfo.append("generateExtData error:");
      paramTinyInfo.append(paramAppInterface);
      QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, paramTinyInfo.toString());
    }
    return "";
  }
  
  public static String a(msg_comm.UinPairMsg paramUinPairMsg, AppInterface paramAppInterface, int paramInt)
  {
    long l = paramUinPairMsg.peer_uin.get();
    if ((paramInt == 10007) && (paramAppInterface != null)) {
      return String.valueOf(a(l, paramUinPairMsg, paramAppInterface));
    }
    return String.valueOf(l);
  }
  
  private static void a(AppInterface paramAppInterface, String paramString)
  {
    ((IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSingleGameDetail(paramString);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlePushReadNotify is called peerUin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", cr.uint64_to_tiny_id = ");
        localStringBuilder.append(paramC2CMsgReadedNotify.uint64_to_tiny_id);
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, localStringBuilder.toString());
      }
      paramString = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a(paramString, String.valueOf(paramC2CMsgReadedNotify.uint64_to_tiny_id));
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setReadFrom(paramString, 10007, paramC2CMsgReadedNotify.lLastReadTime);
      if (paramC2CMsgReadedNotify.lLastReadTime >= 0L)
      {
        ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).removeNotification(paramString, 10007);
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "handlePushReadNotify error", paramAppInterface);
    }
  }
  
  public static void a(AppInterface paramAppInterface, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, long paramLong, ConversationInfo paramConversationInfo)
  {
    if ((paramLong != 0L) && (paramConversationInfo != null))
    {
      if (paramAppInterface == null) {
        return;
      }
      paramConversationInfo = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().b(paramConversationInfo.uin);
      try
      {
        long l1 = Long.valueOf((String)paramConversationInfo.first).longValue();
        long l2 = Long.valueOf((String)paramConversationInfo.second).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called");
        }
        if (paramAppInterface.getCurrentAccountUin() == null) {
          return;
        }
        if ((l1 != 0L) && (l2 != 0L))
        {
          paramAppInterface = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          paramAppInterface.peer_uin.set(l1);
          paramAppInterface.last_read_time.set((int)paramLong);
          paramAppInterface.aio_type.set(3);
          paramAppInterface.uint64_to_tiny_id.set(l2);
          paramPbC2CReadedReportReq.pair_info.add(paramAppInterface);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("msgReadedReportUin : ");
            paramAppInterface.append(l1);
            paramAppInterface.append(", toIinyId = ");
            paramAppInterface.append(l2);
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, paramAppInterface.toString());
          }
          return;
        }
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
        return;
      }
      catch (NumberFormatException paramAppInterface)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, String paramString, long paramLong)
  {
    if (paramLong != 0L)
    {
      if (paramAppInterface == null) {
        return;
      }
      Object localObject = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().b(paramString);
      if (localObject == null) {
        return;
      }
      try
      {
        long l1 = Long.parseLong((String)((Pair)localObject).first);
        long l2 = Long.parseLong((String)((Pair)localObject).second);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createMsgReadConfirm is called curFriendUin = ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, ((StringBuilder)localObject).toString());
        }
        if (paramAppInterface.getCurrentAccountUin() == null) {
          return;
        }
        if ((l1 != 0L) && (l2 != 0L))
        {
          localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l1);
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramLong);
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).aio_type.set(3);
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).uint64_to_tiny_id.set(l2);
          paramString = new msg_svc.PbC2CReadedReportReq();
          paramString.pair_info.add((MessageMicro)localObject);
          paramAppInterface = ((MessageCache)paramAppInterface.getMsgCache()).e();
          if (paramAppInterface != null) {
            paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramAppInterface));
          }
          paramAppInterface = paramPbMsgReadedReportReq;
          if (paramPbMsgReadedReportReq == null) {
            paramAppInterface = new msg_svc.PbMsgReadedReportReq();
          }
          paramAppInterface.c2c_read_report.set(paramString);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("msgReadedReportUin : ");
            paramAppInterface.append(l1);
            paramAppInterface.append(", toIinyId = ");
            paramAppInterface.append(l2);
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, paramAppInterface.toString());
          }
          return;
        }
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
        return;
      }
      catch (NumberFormatException paramAppInterface)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramAppInterface, new Object[0]);
      }
    }
  }
  
  private static void a(msg_comm.Msg paramMsg, AppInterface paramAppInterface, DecodeProtoPkgContext paramDecodeProtoPkgContext, String paramString1, String paramString2)
  {
    if (paramMsg.msg_head.has())
    {
      paramMsg = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
      if ((!paramDecodeProtoPkgContext.j) && (paramMsg.sig.has()))
      {
        paramMsg = paramMsg.sig.get().toByteArray();
        ((MessageCache)paramAppInterface.getMsgCache()).c(paramString1, paramString2, paramMsg);
        if (QLog.isDevelopLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("saveTokenSig tempHead.sig.get()----> sig:");
          paramAppInterface.append(HexUtil.bytes2HexStr(paramMsg));
          paramAppInterface.append(",length:");
          paramAppInterface.append(paramMsg.length);
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 4, paramAppInterface.toString());
        }
      }
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, List<MessageRecord> paramList, AppInterface paramAppInterface, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject3 = paramAppInterface;
    String str4;
    if ((paramElem != null) && (paramList != null) && (localObject3 != null))
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "decodePBMsgElems_GameInterComm");
      }
      str4 = paramAppInterface.getCurrentAccountUin();
    }
    label1027:
    label1034:
    label1041:
    label1047:
    label1054:
    label1060:
    label1066:
    label1072:
    for (;;)
    {
      try
      {
        if ((34 == paramElem.common_elem.uint32_service_type.get()) && (paramElem.common_elem.uint32_business_type.get() == 1) && (paramElem.common_elem.bytes_pb_elem.has()))
        {
          localObject1 = new hummer_commelem.MsgElemInfo_servtype34();
          ((hummer_commelem.MsgElemInfo_servtype34)localObject1).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
          boolean bool = ((hummer_commelem.MsgElemInfo_servtype34)localObject1).from_nickname.has();
          if (!bool) {
            break label1014;
          }
          str1 = ((hummer_commelem.MsgElemInfo_servtype34)localObject1).from_nickname.get().toStringUtf8();
          if (!((hummer_commelem.MsgElemInfo_servtype34)localObject1).push_window_flag.has()) {
            break label1021;
          }
          k = ((hummer_commelem.MsgElemInfo_servtype34)localObject1).push_window_flag.get();
          str2 = ((hummer_commelem.MsgElemInfo_servtype34)localObject1).bytes_ext.get().toStringUtf8();
          Object localObject2 = null;
          int i;
          try
          {
            paramElem = (IGameMsgManagerService)((AppInterface)localObject3).getRuntimeService(IGameMsgManagerService.class, "");
            if (!TextUtils.isEmpty(str2))
            {
              JSONObject localJSONObject = new JSONObject(str2);
              i = localJSONObject.optInt("r");
              try
              {
                paramElem.onGameMsgRRecv(i);
                if (localJSONObject.has("g")) {
                  paramElem = Integer.valueOf(localJSONObject.optInt("g"));
                } else {
                  paramElem = null;
                }
              }
              catch (Throwable localThrowable1)
              {
                paramElem = null;
                continue;
              }
            }
            else
            {
              paramElem = null;
              i = 0;
            }
            im_msg_body.Elem localElem1 = paramElem;
            j = i;
            try
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, new Object[] { "game pubAcc redPoint,ext = ", str2, ",windowFlag:", Integer.valueOf(k) });
              localElem1 = paramElem;
              j = i;
            }
            catch (Throwable localThrowable2) {}
            QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, localThrowable3, new Object[0]);
          }
          catch (Throwable localThrowable3)
          {
            paramElem = null;
            i = 0;
          }
          int j = i;
          im_msg_body.Elem localElem2 = paramElem;
          if (((hummer_commelem.MsgElemInfo_servtype34)localObject1).game_session.has()) {
            localObject2 = (hummer_commelem.MsgElemInfo_servtype34.GameSession)((hummer_commelem.MsgElemInfo_servtype34)localObject1).game_session.get();
          }
          if (localObject2 != null)
          {
            if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_role_id.has()) {
              break label1027;
            }
            localObject1 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_role_id.get().toStringUtf8();
            if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_open_id.has()) {
              break label1034;
            }
            str2 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_open_id.get().toStringUtf8();
            if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_role_id.has()) {
              break label1041;
            }
            paramElem = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_role_id.get().toStringUtf8();
            if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_open_id.has()) {
              break label1047;
            }
            str3 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_open_id.get().toStringUtf8();
            if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).game_appid.has()) {
              break label1054;
            }
            l3 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).game_appid.get();
            if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_tiny_id.has()) {
              break label1060;
            }
            l1 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).from_tiny_id.get();
            if (!((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_tiny_id.has()) {
              break label1066;
            }
            l2 = ((hummer_commelem.MsgElemInfo_servtype34.GameSession)localObject2).to_tiny_id.get();
            if (((IGameMsgBoxManager)((AppInterface)localObject3).getRuntimeService(IGameMsgBoxManager.class, "")).isGameInGameBox(String.valueOf(l3))) {
              ((IGameMsgManagerService)((AppInterface)localObject3).getRuntimeService(IGameMsgManagerService.class, "")).onGameMsgRRecv(1);
            }
            if (localElem2 != null) {
              ((IGameMsgManagerService)((AppInterface)localObject3).getRuntimeService(IGameMsgManagerService.class, "")).notifyReceiveGameMsgSayHiMessage((String)localObject1, paramElem);
            }
            localObject2 = paramList.iterator();
            paramList = paramAppInterface;
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              long l4 = l1;
              String str5 = TinyInfo.toJsonStr((String)localObject1, str2, paramElem, str3, l3, l4, l2, k, str1, j);
              a(paramList, (String)localObject1);
              ((MessageRecord)localObject3).saveExtInfoToExtStr("ext_key_game_msg_info", str5);
              if (localElem2 != null) {
                ((MessageRecord)localObject3).saveExtInfoToExtStr(GameMsgSayHiHelper.a, String.valueOf(localElem2.intValue()));
              }
              if (!paramDecodeProtoPkgContext.o)
              {
                ((MessageRecord)localObject3).frienduin = ((IMessageFacade)paramList.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a(String.valueOf(l2), String.valueOf(l4));
                a(paramMsg, paramList, paramDecodeProtoPkgContext, ((MessageRecord)localObject3).frienduin, str4);
                paramDecodeProtoPkgContext.x = Long.parseLong(((MessageRecord)localObject3).frienduin);
              }
              else
              {
                paramDecodeProtoPkgContext.b = paramDecodeProtoPkgContext.x;
              }
              if (!QLog.isColorLevel()) {
                break label1072;
              }
              paramList = new StringBuilder();
              paramList.append("toTinyId = ");
              paramList.append(l2);
              paramList.append(", fromTinyId = ");
              paramList.append(l4);
              paramList.append(", ctx.senderUin = ");
              paramList.append(paramDecodeProtoPkgContext.b);
              paramList.append(", ctx.friendUin = ");
              paramList.append(paramDecodeProtoPkgContext.x);
              paramList.append(", mr = ");
              paramList.append(((MessageRecord)localObject3).getBaseInfoString());
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodecdecodePBMsgGameInterCommElem", 2, paramList.toString());
              break label1072;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, String.format("decodePBMsgGameInterCommElem fromNickName:%s windowFlag:%d", new Object[] { str1, Integer.valueOf(k) }));
            }
          }
          else
          {
            try
            {
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 1, "decodePBMsgGameInterCommElem error gameSession is null!");
              return;
            }
            catch (Exception paramMsg) {}catch (InvalidProtocolBufferMicroException paramMsg) {}
            QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "decodePBMsgGameInterCommElem error", paramMsg);
          }
        }
      }
      catch (Exception paramMsg)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "decodePBMsgGameInterCommElem error", paramMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramMsg) {}
      return;
      label1014:
      String str1 = "";
      continue;
      label1021:
      int k = 0;
      continue;
      Object localObject1 = "";
      continue;
      String str2 = "";
      continue;
      paramElem = "";
      continue;
      String str3 = "";
      continue;
      long l3 = 0L;
      continue;
      long l1 = 0L;
      continue;
      long l2 = 0L;
    }
  }
  
  public static void a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      RoleIdUtil.a(paramAppInterface, paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    }
    TinyInfo localTinyInfo = new TinyInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localTinyInfo.parseFromJson((String)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindTinyInfoElem is called, info: ");
      ((StringBuilder)localObject).append(localTinyInfo);
      QLog.d("Q.tiny_msg.decoder.TinyMsgCodecbindTinyInfoElem", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new hummer_commelem.MsgElemInfo_servtype34();
    hummer_commelem.MsgElemInfo_servtype34.GameSession localGameSession = new hummer_commelem.MsgElemInfo_servtype34.GameSession();
    if (!TextUtils.isEmpty(localTinyInfo.fromRoleId))
    {
      if (TextUtils.isEmpty(localTinyInfo.toRoleId)) {
        return;
      }
      localGameSession.from_open_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.fromOpenId));
      localGameSession.from_role_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.fromRoleId));
      localGameSession.to_role_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.toRoleId));
      localGameSession.to_open_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.toOpenId));
      localGameSession.game_appid.set(localTinyInfo.gameAppId);
      localGameSession.from_tiny_id.set(localTinyInfo.fromTinyId);
      localGameSession.to_tiny_id.set(localTinyInfo.toTinyId);
      ((hummer_commelem.MsgElemInfo_servtype34)localObject).game_session.set(localGameSession);
      try
      {
        paramMessageRecord = a(paramAppInterface, localTinyInfo, paramMessageRecord);
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("rStr:");
          paramAppInterface.append(paramMessageRecord);
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, paramAppInterface.toString());
        }
        ((hummer_commelem.MsgElemInfo_servtype34)localObject).bytes_ext.set(ByteStringMicro.copyFromUtf8(paramMessageRecord));
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, paramMessageRecord, new Object[0]);
      }
      paramMessageRecord = new im_msg_body.CommonElem();
      paramMessageRecord.uint32_service_type.set(34);
      paramMessageRecord.uint32_business_type.set(1);
      paramMessageRecord.bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype34)localObject).toByteArray()));
      paramElem.common_elem.set(paramMessageRecord);
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i == 10007)
    {
      if ((((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab()) && (StudyModeManager.h())) {
        return false;
      }
      Object localObject = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramMessageRecord = new TinyInfo();
        paramMessageRecord.parseFromJson((String)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isNeedTips windowflag = ");
          ((StringBuilder)localObject).append(paramMessageRecord.windowFlag);
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, ((StringBuilder)localObject).toString());
        }
        if ((paramMessageRecord.windowFlag & 1L) == 1L) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.TinyMsgCodec
 * JD-Core Version:    0.7.0.1
 */