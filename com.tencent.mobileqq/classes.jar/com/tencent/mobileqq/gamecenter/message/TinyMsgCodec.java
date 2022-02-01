package com.tencent.mobileqq.gamecenter.message;

import PushNotifyPack.C2CMsgReadedNotify;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34.GameSession;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class TinyMsgCodec
{
  public static long a(long paramLong, msg_comm.UinPairMsg paramUinPairMsg, QQAppInterface paramQQAppInterface)
  {
    if (paramUinPairMsg != null) {
      try
      {
        if ((paramUinPairMsg.service_type.has()) && (paramUinPairMsg.service_type.get() == 164))
        {
          if (paramUinPairMsg.uint64_to_tiny_id.has())
          {
            paramUinPairMsg = String.valueOf(paramUinPairMsg.uint64_to_tiny_id.get());
            if (QLog.isColorLevel()) {
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, fromTinyId: " + paramLong + "toTinyId :" + paramUinPairMsg);
            }
            return Long.parseLong(paramQQAppInterface.getTinyIdCache().a(String.valueOf(paramLong), paramUinPairMsg));
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
  
  public static String a(msg_comm.UinPairMsg paramUinPairMsg, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l = paramUinPairMsg.peer_uin.get();
    if ((paramInt == 10007) && (paramQQAppInterface != null)) {
      return String.valueOf(a(l, paramUinPairMsg, paramQQAppInterface));
    }
    return String.valueOf(l);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null)) {}
    label119:
    do
    {
      return;
      for (;;)
      {
        try
        {
          MessageRecord localMessageRecord = GameMsgUtil.a(paramQQAppInterface, paramString);
          if (localMessageRecord == null) {
            break label119;
          }
          paramQQAppInterface = localMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
          boolean bool2 = localMessageRecord.isSend();
          if (!bool2)
          {
            bool1 = true;
            paramQQAppInterface = new TinyInfo(paramQQAppInterface, bool1);
            paramChatMessage.saveExtInfoToExtStr("ext_key_game_msg_info", paramQQAppInterface.toJsonStr());
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "bindTinyInfo is called, issend: " + bool2 + "tinyInfo :" + paramQQAppInterface);
            return;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
        boolean bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "bindTinyInfo is called, there is no last msg.");
      }
      paramQQAppInterface = GameQQPlayerUtil.a(paramQQAppInterface, paramString);
    } while (paramQQAppInterface == null);
    paramChatMessage.saveExtInfoToExtStr("ext_key_game_msg_info", paramQQAppInterface);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "handlePushReadNotify is called peerUin = " + paramString + ", cr.uint64_to_tiny_id = " + paramC2CMsgReadedNotify.uint64_to_tiny_id);
      }
      paramString = paramQQAppInterface.getTinyIdCache().a(paramString, String.valueOf(paramC2CMsgReadedNotify.uint64_to_tiny_id));
      paramQQAppInterface.getMessageFacade().a(paramString, 10007, paramC2CMsgReadedNotify.lLastReadTime);
      if (paramC2CMsgReadedNotify.lLastReadTime >= 0L) {
        paramQQAppInterface.getMessageFacade().a.a(paramString, 10007);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "handlePushReadNotify error", paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, long paramLong, ConversationInfo paramConversationInfo)
  {
    if ((paramLong == 0L) || (paramConversationInfo == null) || (paramQQAppInterface == null)) {}
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        return;
        paramConversationInfo = paramQQAppInterface.getTinyIdCache().a(paramConversationInfo.uin);
        try
        {
          l1 = Long.valueOf((String)paramConversationInfo.first).longValue();
          l2 = Long.valueOf((String)paramConversationInfo.second).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called");
          }
          if (paramQQAppInterface.getCurrentAccountUin() != null) {
            if ((l1 == 0L) || (l2 == 0L))
            {
              QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
              return;
            }
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramQQAppInterface, new Object[0]);
          return;
        }
      }
      paramQQAppInterface = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      paramQQAppInterface.peer_uin.set(l1);
      paramQQAppInterface.last_read_time.set((int)paramLong);
      paramQQAppInterface.aio_type.set(3);
      paramQQAppInterface.uint64_to_tiny_id.set(l2);
      paramPbC2CReadedReportReq.pair_info.add(paramQQAppInterface);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + l1 + ", toIinyId = " + l2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, String paramString, long paramLong)
  {
    if ((paramLong == 0L) || (paramQQAppInterface == null)) {}
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        return;
        localObject = paramQQAppInterface.getTinyIdCache().a(paramString);
        if (localObject != null) {
          try
          {
            l1 = Long.parseLong((String)((Pair)localObject).first);
            l2 = Long.parseLong((String)((Pair)localObject).second);
            if (QLog.isColorLevel()) {
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called curFriendUin = " + paramString);
            }
            if (paramQQAppInterface.getCurrentAccountUin() != null) {
              if ((l1 == 0L) || (l2 == 0L))
              {
                QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
                return;
              }
            }
          }
          catch (NumberFormatException paramQQAppInterface)
          {
            QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramQQAppInterface, new Object[0]);
            return;
          }
        }
      }
      Object localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l1);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramLong);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).aio_type.set(3);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).uint64_to_tiny_id.set(l2);
      paramString = new msg_svc.PbC2CReadedReportReq();
      paramString.pair_info.add((MessageMicro)localObject);
      paramQQAppInterface = paramQQAppInterface.getMsgHandler().a().a();
      if (paramQQAppInterface != null) {
        paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramQQAppInterface = paramPbMsgReadedReportReq;
      if (paramPbMsgReadedReportReq == null) {
        paramQQAppInterface = new msg_svc.PbMsgReadedReportReq();
      }
      paramQQAppInterface.c2c_read_report.set(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + l1 + ", toIinyId = " + l2);
  }
  
  private static void a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface, DecodeProtoPkgContext paramDecodeProtoPkgContext, String paramString1, String paramString2)
  {
    if (paramMsg.msg_head.has())
    {
      paramMsg = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
      if ((!paramDecodeProtoPkgContext.d) && (paramMsg.sig.has()))
      {
        paramMsg = paramMsg.sig.get().toByteArray();
        paramQQAppInterface.getMsgCache().d(paramString1, paramString2, paramMsg);
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 4, "saveTokenSig tempHead.sig.get()----> sig:" + HexUtil.bytes2HexStr(paramMsg) + ",length:" + paramMsg.length);
        }
      }
    }
  }
  
  /* Error */
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, java.util.List<MessageRecord> paramList, QQAppInterface paramQQAppInterface, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +20 -> 21
    //   4: aload_2
    //   5: ifnull +16 -> 21
    //   8: aload_3
    //   9: ifnull +12 -> 21
    //   12: aload_2
    //   13: invokeinterface 390 1 0
    //   18: ifgt +4 -> 22
    //   21: return
    //   22: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +12 -> 37
    //   28: ldc 52
    //   30: iconst_2
    //   31: ldc_w 392
    //   34: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_3
    //   38: invokevirtual 240	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   41: astore 20
    //   43: bipush 34
    //   45: aload_1
    //   46: getfield 398	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   49: getfield 403	tencent/im/msg/im_msg_body$CommonElem:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 29	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   55: if_icmpne -34 -> 21
    //   58: aload_1
    //   59: getfield 398	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   62: getfield 406	tencent/im/msg/im_msg_body$CommonElem:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 29	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: iconst_1
    //   69: if_icmpne -48 -> 21
    //   72: aload_1
    //   73: getfield 398	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   76: getfield 409	tencent/im/msg/im_msg_body$CommonElem:bytes_pb_elem	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   79: invokevirtual 352	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   82: ifeq -61 -> 21
    //   85: new 411	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34
    //   88: dup
    //   89: invokespecial 412	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:<init>	()V
    //   92: astore 15
    //   94: aload 15
    //   96: aload_1
    //   97: getfield 398	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   100: getfield 409	tencent/im/msg/im_msg_body$CommonElem:bytes_pb_elem	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   106: invokevirtual 358	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   109: invokevirtual 416	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   112: pop
    //   113: aload 15
    //   115: getfield 419	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:from_nickname	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   118: invokevirtual 352	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   121: ifeq +577 -> 698
    //   124: aload 15
    //   126: getfield 419	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:from_nickname	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   129: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   132: invokevirtual 422	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   135: astore_1
    //   136: aload 15
    //   138: getfield 425	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:push_window_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   141: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   144: ifeq +652 -> 796
    //   147: aload 15
    //   149: getfield 425	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:push_window_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   152: invokevirtual 29	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   155: istore 7
    //   157: aload 15
    //   159: getfield 428	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:bytes_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   162: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   165: invokevirtual 422	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   168: astore 16
    //   170: iconst_0
    //   171: istore 8
    //   173: iconst_0
    //   174: istore 6
    //   176: iload 8
    //   178: istore 5
    //   180: aload_3
    //   181: getstatic 162	com/tencent/mobileqq/app/QQManagerFactory:GAME_CENTER_MSG_MANAGER	I
    //   184: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   187: checkcast 168	com/tencent/mobileqq/gamecenter/message/GameMsgManager
    //   190: astore 17
    //   192: iload 8
    //   194: istore 5
    //   196: aload 16
    //   198: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +35 -> 236
    //   204: iload 8
    //   206: istore 5
    //   208: new 436	org/json/JSONObject
    //   211: dup
    //   212: aload 16
    //   214: invokespecial 439	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   217: ldc_w 441
    //   220: invokevirtual 445	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   223: istore 6
    //   225: iload 6
    //   227: istore 5
    //   229: aload 17
    //   231: iload 6
    //   233: invokevirtual 447	com/tencent/mobileqq/gamecenter/message/GameMsgManager:a	(I)V
    //   236: iload 6
    //   238: istore 5
    //   240: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +42 -> 285
    //   246: iload 6
    //   248: istore 5
    //   250: ldc 52
    //   252: iconst_2
    //   253: iconst_4
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: ldc_w 449
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: aload 16
    //   267: aastore
    //   268: dup
    //   269: iconst_2
    //   270: ldc_w 451
    //   273: aastore
    //   274: dup
    //   275: iconst_3
    //   276: iload 7
    //   278: invokestatic 456	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   285: aload 15
    //   287: getfield 463	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:game_session	Ltencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession;
    //   290: invokevirtual 466	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:has	()Z
    //   293: ifeq +509 -> 802
    //   296: aload 15
    //   298: getfield 463	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:game_session	Ltencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession;
    //   301: invokevirtual 467	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   304: checkcast 465	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession
    //   307: astore 16
    //   309: aload 16
    //   311: ifnull +475 -> 786
    //   314: aload 16
    //   316: getfield 470	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   319: invokevirtual 352	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   322: ifeq +486 -> 808
    //   325: aload 16
    //   327: getfield 470	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   330: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   333: invokevirtual 422	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   336: astore 15
    //   338: aload 16
    //   340: getfield 473	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   343: invokevirtual 352	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   346: ifeq +470 -> 816
    //   349: aload 16
    //   351: getfield 473	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   354: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   357: invokevirtual 422	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   360: astore 17
    //   362: aload 16
    //   364: getfield 476	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   367: invokevirtual 352	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   370: ifeq +454 -> 824
    //   373: aload 16
    //   375: getfield 476	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   378: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   381: invokevirtual 422	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   384: astore 18
    //   386: aload 16
    //   388: getfield 479	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   391: invokevirtual 352	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   394: ifeq +438 -> 832
    //   397: aload 16
    //   399: getfield 479	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   402: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   405: invokevirtual 422	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   408: astore 19
    //   410: aload 16
    //   412: getfield 482	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   415: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   418: ifeq +422 -> 840
    //   421: aload 16
    //   423: getfield 482	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   426: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   429: lstore 9
    //   431: aload 16
    //   433: getfield 485	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   436: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   439: ifeq +407 -> 846
    //   442: aload 16
    //   444: getfield 485	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   447: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   450: lstore 11
    //   452: aload 16
    //   454: getfield 488	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   457: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   460: ifeq +392 -> 852
    //   463: aload 16
    //   465: getfield 488	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   468: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   471: lstore 13
    //   473: aload_2
    //   474: invokeinterface 492 1 0
    //   479: astore_2
    //   480: aload_2
    //   481: invokeinterface 497 1 0
    //   486: ifeq +265 -> 751
    //   489: aload_2
    //   490: invokeinterface 501 1 0
    //   495: checkcast 114	com/tencent/mobileqq/data/MessageRecord
    //   498: astore 16
    //   500: aload 15
    //   502: aload 17
    //   504: aload 18
    //   506: aload 19
    //   508: lload 9
    //   510: lload 11
    //   512: lload 13
    //   514: iload 7
    //   516: aload_1
    //   517: iload 6
    //   519: invokestatic 504	com/tencent/mobileqq/gamecenter/message/TinyInfo:toJsonStr	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJILjava/lang/String;I)Ljava/lang/String;
    //   522: astore 21
    //   524: aload_3
    //   525: aload 15
    //   527: invokestatic 506	com/tencent/mobileqq/gamecenter/message/TinyMsgCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   530: aload 16
    //   532: ldc 112
    //   534: aload 21
    //   536: invokevirtual 507	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload 4
    //   541: getfield 510	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:i	Z
    //   544: ifne +182 -> 726
    //   547: aload 16
    //   549: aload_3
    //   550: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getTinyIdCache	()Lcom/tencent/mobileqq/gamecenter/message/TinyIdCache;
    //   553: lload 13
    //   555: invokestatic 45	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   558: lload 11
    //   560: invokestatic 45	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   563: invokevirtual 85	com/tencent/mobileqq/gamecenter/message/TinyIdCache:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   566: putfield 513	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   569: aload_0
    //   570: aload_3
    //   571: aload 4
    //   573: aload 16
    //   575: getfield 513	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   578: aload 20
    //   580: invokestatic 515	com/tencent/mobileqq/gamecenter/message/TinyMsgCodec:a	(Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/service/message/DecodeProtoPkgContext;Ljava/lang/String;Ljava/lang/String;)V
    //   583: aload 4
    //   585: aload 16
    //   587: getfield 513	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   590: invokestatic 91	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   593: putfield 517	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   596: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   599: ifeq -119 -> 480
    //   602: ldc_w 519
    //   605: iconst_2
    //   606: new 54	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   613: ldc_w 521
    //   616: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: lload 13
    //   621: invokevirtual 64	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   624: ldc_w 523
    //   627: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: lload 11
    //   632: invokevirtual 64	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   635: ldc_w 525
    //   638: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload 4
    //   643: getfield 528	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:b	J
    //   646: invokevirtual 64	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   649: ldc_w 530
    //   652: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload 4
    //   657: getfield 517	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   660: invokevirtual 64	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   663: ldc_w 532
    //   666: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload 16
    //   671: invokevirtual 535	com/tencent/mobileqq/data/MessageRecord:getBaseInfoString	()Ljava/lang/String;
    //   674: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: goto -203 -> 480
    //   686: astore_0
    //   687: ldc 52
    //   689: iconst_1
    //   690: ldc_w 537
    //   693: aload_0
    //   694: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   697: return
    //   698: ldc_w 539
    //   701: astore_1
    //   702: goto -566 -> 136
    //   705: astore 16
    //   707: ldc 52
    //   709: iconst_1
    //   710: aload 16
    //   712: iconst_0
    //   713: anewarray 4	java/lang/Object
    //   716: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   719: iload 5
    //   721: istore 6
    //   723: goto -438 -> 285
    //   726: aload 4
    //   728: aload 4
    //   730: getfield 517	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   733: putfield 528	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:b	J
    //   736: goto -140 -> 596
    //   739: astore_0
    //   740: ldc 52
    //   742: iconst_1
    //   743: ldc_w 537
    //   746: aload_0
    //   747: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   750: return
    //   751: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq -733 -> 21
    //   757: ldc 52
    //   759: iconst_2
    //   760: ldc_w 541
    //   763: iconst_2
    //   764: anewarray 4	java/lang/Object
    //   767: dup
    //   768: iconst_0
    //   769: aload_1
    //   770: aastore
    //   771: dup
    //   772: iconst_1
    //   773: iload 7
    //   775: invokestatic 456	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   778: aastore
    //   779: invokestatic 545	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   782: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: return
    //   786: ldc 52
    //   788: iconst_1
    //   789: ldc_w 547
    //   792: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: return
    //   796: iconst_0
    //   797: istore 7
    //   799: goto -642 -> 157
    //   802: aconst_null
    //   803: astore 16
    //   805: goto -496 -> 309
    //   808: ldc_w 539
    //   811: astore 15
    //   813: goto -475 -> 338
    //   816: ldc_w 539
    //   819: astore 17
    //   821: goto -459 -> 362
    //   824: ldc_w 539
    //   827: astore 18
    //   829: goto -443 -> 386
    //   832: ldc_w 539
    //   835: astore 19
    //   837: goto -427 -> 410
    //   840: lconst_0
    //   841: lstore 9
    //   843: goto -412 -> 431
    //   846: lconst_0
    //   847: lstore 11
    //   849: goto -397 -> 452
    //   852: lconst_0
    //   853: lstore 13
    //   855: goto -382 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	paramMsg	msg_comm.Msg
    //   0	858	1	paramElem	im_msg_body.Elem
    //   0	858	2	paramList	java.util.List<MessageRecord>
    //   0	858	3	paramQQAppInterface	QQAppInterface
    //   0	858	4	paramDecodeProtoPkgContext	DecodeProtoPkgContext
    //   178	542	5	i	int
    //   174	548	6	j	int
    //   155	643	7	k	int
    //   171	34	8	m	int
    //   429	413	9	l1	long
    //   450	398	11	l2	long
    //   471	383	13	l3	long
    //   92	720	15	localObject1	Object
    //   168	502	16	localObject2	Object
    //   705	6	16	localThrowable	Throwable
    //   803	1	16	localObject3	Object
    //   190	630	17	localObject4	Object
    //   384	444	18	str1	String
    //   408	428	19	str2	String
    //   41	538	20	str3	String
    //   522	13	21	str4	String
    // Exception table:
    //   from	to	target	type
    //   43	136	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	157	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   157	170	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   180	192	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   196	204	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   208	225	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   229	236	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   240	246	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   250	285	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   285	309	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   314	338	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   338	362	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   362	386	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   386	410	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   410	431	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   431	452	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   452	473	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   473	480	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   480	596	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   596	683	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   707	719	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   726	736	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   751	785	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   786	795	686	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   180	192	705	java/lang/Throwable
    //   196	204	705	java/lang/Throwable
    //   208	225	705	java/lang/Throwable
    //   229	236	705	java/lang/Throwable
    //   240	246	705	java/lang/Throwable
    //   250	285	705	java/lang/Throwable
    //   43	136	739	java/lang/Exception
    //   136	157	739	java/lang/Exception
    //   157	170	739	java/lang/Exception
    //   180	192	739	java/lang/Exception
    //   196	204	739	java/lang/Exception
    //   208	225	739	java/lang/Exception
    //   229	236	739	java/lang/Exception
    //   240	246	739	java/lang/Exception
    //   250	285	739	java/lang/Exception
    //   285	309	739	java/lang/Exception
    //   314	338	739	java/lang/Exception
    //   338	362	739	java/lang/Exception
    //   362	386	739	java/lang/Exception
    //   386	410	739	java/lang/Exception
    //   410	431	739	java/lang/Exception
    //   431	452	739	java/lang/Exception
    //   452	473	739	java/lang/Exception
    //   473	480	739	java/lang/Exception
    //   480	596	739	java/lang/Exception
    //   596	683	739	java/lang/Exception
    //   707	719	739	java/lang/Exception
    //   726	736	739	java/lang/Exception
    //   751	785	739	java/lang/Exception
    //   786	795	739	java/lang/Exception
  }
  
  public static void a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
    TinyInfo localTinyInfo = new TinyInfo();
    if (!TextUtils.isEmpty(paramMessageRecord)) {
      localTinyInfo.parseFromJson(paramMessageRecord);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.decoder.TinyMsgCodecbindTinyInfoElem", 2, "bindTinyInfoElem is called, info: " + localTinyInfo);
    }
    paramMessageRecord = new hummer_commelem.MsgElemInfo_servtype34();
    hummer_commelem.MsgElemInfo_servtype34.GameSession localGameSession = new hummer_commelem.MsgElemInfo_servtype34.GameSession();
    if ((TextUtils.isEmpty(localTinyInfo.fromRoleId)) || (TextUtils.isEmpty(localTinyInfo.toRoleId))) {
      return;
    }
    localGameSession.from_open_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.fromOpenId));
    localGameSession.from_role_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.fromRoleId));
    localGameSession.to_role_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.toRoleId));
    localGameSession.to_open_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.toOpenId));
    localGameSession.game_appid.set(localTinyInfo.gameAppId);
    localGameSession.from_tiny_id.set(localTinyInfo.fromTinyId);
    localGameSession.to_tiny_id.set(localTinyInfo.toTinyId);
    paramMessageRecord.game_session.set(localGameSession);
    try
    {
      paramQQAppInterface = ((GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(localTinyInfo.toRoleId);
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "rStr:" + paramQQAppInterface);
      }
      paramMessageRecord.bytes_ext.set(ByteStringMicro.copyFromUtf8(paramQQAppInterface));
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, paramQQAppInterface, new Object[0]);
      }
    }
    paramQQAppInterface = new im_msg_body.CommonElem();
    paramQQAppInterface.uint32_service_type.set(34);
    paramQQAppInterface.uint32_business_type.set(1);
    paramQQAppInterface.bytes_pb_elem.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
    paramElem.common_elem.set(paramQQAppInterface);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo;
    if (paramMessageRecord.istroop == 10007)
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        localTinyInfo = new TinyInfo();
        localTinyInfo.parseFromJson(paramMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "isNeedTips windowflag = " + localTinyInfo.windowFlag);
        }
      }
    }
    return (localTinyInfo.windowFlag & 1L) == 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.TinyMsgCodec
 * JD-Core Version:    0.7.0.1
 */