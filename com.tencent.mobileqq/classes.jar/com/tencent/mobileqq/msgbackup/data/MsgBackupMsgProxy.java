package com.tencent.mobileqq.msgbackup.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.imcore.message.DecodeC2CMsgPkgBubbleID;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgPackageHandle;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupPbCache;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.codec.decoder.GrpDisPTTDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.PTTDecoder;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class MsgBackupMsgProxy
  extends BaseProxy
{
  public MsgBackupMsgProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong2;
    if (paramLong2 == paramLong1) {
      l = paramLong3;
    }
    return l;
  }
  
  private static long a(@NonNull QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, int paramInt, MessageInfo paramMessageInfo, long paramLong3, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (((MessageUtils.c(paramInt)) || (paramInt == 208) || (paramInt == 529)) && (paramMsgHead.c2c_cmd.has()))
    {
      paramLong1 = a(paramQQAppInterface.getLongAccountUin(), paramLong1, paramLong2);
      a(paramQQAppInterface, paramMsg, paramMessageInfo, paramMsgHead, paramInt, paramMessageHandler, paramArrayList);
      if (paramInt == 208) {
        new PTTDecoder().a(paramMessageHandler, paramMsg, paramArrayList, null);
      }
      return paramLong1;
    }
    if (((paramInt == 82) || (paramInt == 43)) && (paramMsgHead.group_info.has()))
    {
      paramLong1 = paramMsgHead.group_info.group_code.get();
      a(paramQQAppInterface, paramMsg, paramMessageHandler, paramArrayList, paramMessageInfo);
      return paramLong1;
    }
    if (((paramInt == 83) || (paramInt == 42)) && (paramMsgHead.discuss_info.has()))
    {
      paramLong1 = paramMsgHead.discuss_info.discuss_uin.get();
      a(paramQQAppInterface, paramMsg, paramMessageInfo, paramMessageHandler, paramArrayList);
      return paramLong1;
    }
    return paramLong3;
  }
  
  public static MessageRecord a(@NonNull QQAppInterface paramQQAppInterface, @NonNull byte[] paramArrayOfByte)
  {
    Object localObject1 = new msg_comm.Msg();
    for (;;)
    {
      int m;
      try
      {
        ((msg_comm.Msg)localObject1).mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("transToMessageRecord, no msg_body or rich_text, msg_body.has():");
          paramArrayOfByte.append(((msg_comm.Msg)localObject1).msg_body.has());
          QLog.d("MsgBackup_msgproxy", 2, paramArrayOfByte.toString());
        }
        Object localObject2 = (msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get();
        long l7 = ((msg_comm.MsgHead)localObject2).from_uin.get();
        long l8 = ((msg_comm.MsgHead)localObject2).to_uin.get();
        long l3 = ((msg_comm.MsgHead)localObject2).msg_seq.get();
        long l4 = ((msg_comm.MsgHead)localObject2).msg_time.get();
        long l2 = ((msg_comm.MsgHead)localObject2).msg_uid.get();
        m = ((msg_comm.MsgHead)localObject2).msg_type.get();
        boolean bool = ((msg_comm.MsgHead)localObject2).is_src_msg.get();
        MessageInfo localMessageInfo = new MessageInfo();
        MessageHandler localMessageHandler = paramQQAppInterface.getMsgHandler();
        long l1 = DecodeC2CMsgPkgBubbleID.a(localMessageHandler, (msg_comm.Msg)localObject1, String.valueOf(l8), String.valueOf(l7));
        paramArrayOfByte = new ArrayList();
        long l6 = a(paramQQAppInterface, (msg_comm.Msg)localObject1, (msg_comm.MsgHead)localObject2, l7, l8, m, localMessageInfo, 0L, localMessageHandler, paramArrayOfByte);
        int i1 = DecodeC2CMsgPkgBubbleID.a((msg_comm.Msg)localObject1);
        if (((msg_comm.Msg)localObject1).content_head.has())
        {
          localObject1 = (msg_comm.ContentHead)((msg_comm.Msg)localObject1).content_head.get();
          k = ((msg_comm.ContentHead)localObject1).div_seq.get();
          j = ((msg_comm.ContentHead)localObject1).pkg_num.get();
          i = ((msg_comm.ContentHead)localObject1).pkg_index.get();
          localObject1 = paramArrayOfByte.iterator();
          long l5 = l1;
          l1 = l6;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            ((MessageRecord)localObject2).isReplySource = bool;
            ((MessageRecord)localObject2).time = l4;
            ((MessageRecord)localObject2).shmsgseq = l3;
            ((MessageRecord)localObject2).msgUid = l2;
            ((MessageRecord)localObject2).selfuin = paramQQAppInterface.getCurrentAccountUin();
            ((MessageRecord)localObject2).senderuin = String.valueOf(l7);
            ((MessageRecord)localObject2).frienduin = String.valueOf(l1);
            ((MessageRecord)localObject2).vipBubbleDiyTextId = i1;
            n = (int)l5;
            ((MessageRecord)localObject2).vipBubbleID = SVIPHandlerConstants.a(n, i1);
            ((MessageRecord)localObject2).isread = true;
            if (j > 1)
            {
              ((MessageRecord)localObject2).longMsgCount = j;
              ((MessageRecord)localObject2).longMsgId = k;
              ((MessageRecord)localObject2).longMsgIndex = i;
            }
            if (l7 != paramQQAppInterface.getLongAccountUin()) {
              break label671;
            }
            n = 2;
            ((MessageRecord)localObject2).issend = n;
            if (m != 82)
            {
              if (m != 43) {
                break label677;
              }
              continue;
              if (AppConstants.DATALINE_PC_UIN.equals(Long.valueOf(l8))) {
                ((MessageRecord)localObject2).istroop = 6000;
              } else if (AppConstants.DATALINE_IPAD_UIN.equals(Long.valueOf(l8))) {
                ((MessageRecord)localObject2).istroop = 6003;
              } else {
                ((MessageRecord)localObject2).istroop = 0;
              }
              ((MessageRecord)localObject2).msgseq = l3;
              continue;
              ((MessageRecord)localObject2).istroop = 3000;
              ((MessageRecord)localObject2).shmsgseq = l3;
              continue;
            }
            ((MessageRecord)localObject2).istroop = 1;
            ((MessageRecord)localObject2).shmsgseq = l3;
            if ((((MessageRecord)localObject2).msgData == null) && (((MessageRecord)localObject2).msg != null)) {
              ((MessageRecord)localObject2).msgData = ((MessageRecord)localObject2).msg.getBytes();
            }
            ((MessageRecord)localObject2).msgBackupMsgSeq = l3;
            ((MessageRecord)localObject2).msgBackupMsgRandom = MessageUtils.b(l2);
            continue;
          }
          BaseMessageHandlerUtils.a(paramArrayOfByte);
          paramQQAppInterface = (MessageRecord)paramArrayOfByte.get(0);
          return paramQQAppInterface;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("transToMessageRecord, error happens :");
          paramArrayOfByte.append(paramQQAppInterface);
          QLog.d("MsgBackup_msgproxy", 2, paramArrayOfByte.toString());
        }
        return null;
      }
      int i = 0;
      int k = 0;
      int j = 0;
      continue;
      label671:
      int n = 0;
      continue;
      label677:
      if (m != 83) {
        if (m != 42) {}
      }
    }
  }
  
  public static msg_comm.MsgHead a(MessageRecord paramMessageRecord, long paramLong)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    Object localObject = MsgProxyUtils.a(paramMessageRecord);
    try
    {
      long l1 = Long.valueOf((String)localObject).longValue();
      long l2 = Long.valueOf(paramMessageRecord.frienduin).longValue();
      localMsgHead.from_uin.set(l1);
      localMsgHead.to_uin.set(l2);
      localMsgHead.is_src_msg.set(paramMessageRecord.isReplySource);
      localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
      localMsgHead.msg_time.set((int)paramMessageRecord.time);
      localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
      if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 6003) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004) && (paramMessageRecord.istroop != 1022))
      {
        if (paramMessageRecord.istroop == 3000)
        {
          localMsgHead.msg_type.set(83);
          localObject = new msg_comm.DiscussInfo();
          ((msg_comm.DiscussInfo)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
          localMsgHead.discuss_info.set((MessageMicro)localObject);
          return localMsgHead;
        }
        if (paramMessageRecord.istroop == 1)
        {
          localMsgHead.msg_type.set(82);
          localObject = new msg_comm.GroupInfo();
          ((msg_comm.GroupInfo)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
          localMsgHead.group_info.set((MessageMicro)localObject);
          return localMsgHead;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup_msgproxy", 2, "getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
          return null;
        }
      }
      else
      {
        paramLong = b(paramLong, l1, l2);
        localMsgHead.to_uin.set(paramLong);
        if ((paramMessageRecord instanceof MessageForPtt)) {
          localMsgHead.msg_type.set(208);
        } else if ((paramMessageRecord instanceof MessageForFile)) {
          localMsgHead.msg_type.set(529);
        } else {
          localMsgHead.msg_type.set(9);
        }
        if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing)))
        {
          if ((paramMessageRecord instanceof MessageForFile))
          {
            localMsgHead.c2c_cmd.set(4);
            return localMsgHead;
          }
          localMsgHead.c2c_cmd.set(175);
          return localMsgHead;
        }
        localMsgHead.c2c_cmd.set(11);
        return localMsgHead;
      }
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("MsgBackup_msgproxy", 1, paramMessageRecord, new Object[0]);
      return null;
    }
    return null;
  }
  
  public static im_msg_body.MsgBody a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    int i = paramMessageRecord.msgtype;
    im_msg_body.Elem localElem = null;
    if ((i != -1000) && (paramMessageRecord.msgtype != -10000) && (paramMessageRecord.msgtype != -7014))
    {
      if (paramMessageRecord.msgtype == -1049)
      {
        paramQQAppInterface = MessageProtoCodec.a((MessageForReplyText)paramMessageRecord);
      }
      else
      {
        if (paramMessageRecord.msgtype == -2005) {
          return paramQQAppInterface.getFileManagerEngine().a().a(2, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2017) {
          return paramQQAppInterface.getFileManagerEngine().a().a(2, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2052)
        {
          paramQQAppInterface = MessageProtoCodec.a((MessageForQQStoryComment)paramMessageRecord);
        }
        else if (paramMessageRecord.msgtype == -2000)
        {
          paramQQAppInterface = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
        }
        else if (paramMessageRecord.msgtype == -5008)
        {
          paramQQAppInterface = MessageProtoCodec.a((MessageForArkApp)paramMessageRecord, true);
        }
        else if (paramMessageRecord.msgtype == -5016)
        {
          paramQQAppInterface = MessageProtoCodec.c((MessageForArkBabyqReply)paramMessageRecord, true);
        }
        else if (paramMessageRecord.msgtype == -5017)
        {
          paramQQAppInterface = MessageProtoCodec.b((MessageForArkApp)paramMessageRecord, true);
        }
        else if (paramMessageRecord.msgtype == -5013)
        {
          paramQQAppInterface = MessageProtoCodec.c((MessageForArkFlashChat)paramMessageRecord);
        }
        else if (paramMessageRecord.msgtype == -5014)
        {
          paramQQAppInterface = MessageProtoCodec.d((MessageForHiBoom)paramMessageRecord);
        }
        else if (paramMessageRecord.msgtype == -2011)
        {
          paramQQAppInterface = MessageProtoCodec.a((MessageForStructing)paramMessageRecord);
          if (paramQQAppInterface == null) {
            return null;
          }
        }
        else if (paramMessageRecord.msgtype == -1035)
        {
          paramQQAppInterface = MessageProtoCodec.a((MessageForMixedMsg)paramMessageRecord);
        }
        else if (paramMessageRecord.msgtype == -1051)
        {
          paramQQAppInterface = MessageProtoCodec.a((MessageForLongTextMsg)paramMessageRecord, false);
        }
        else if (paramMessageRecord.msgtype == -2022)
        {
          paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
        }
        else if (paramMessageRecord.msgtype == -2002)
        {
          paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
        }
        else if (paramMessageRecord.msgtype == -2007)
        {
          paramQQAppInterface = MessageProtoCodec.a((MessageForMarketFace)paramMessageRecord);
        }
        else
        {
          paramQQAppInterface = localElem;
          if (paramMessageRecord.msgtype == -2059)
          {
            paramQQAppInterface = localElem;
            if (!TextUtils.isEmpty(paramMessageRecord.msg))
            {
              paramQQAppInterface = new im_msg_body.RichText();
              localElem = new im_msg_body.Elem();
              im_msg_body.Text localText = new im_msg_body.Text();
              localText.str.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.msg));
              localElem.text.set(localText);
              paramQQAppInterface.elems.add(localElem);
            }
          }
        }
      }
    }
    else {
      paramQQAppInterface = a(paramMessageRecord, paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"));
    }
    a(paramMessageRecord, paramQQAppInterface);
    b(paramMessageRecord, paramQQAppInterface);
    paramMessageRecord = new im_msg_body.MsgBody();
    paramMessageRecord.rich_text.set(paramQQAppInterface);
    return paramMessageRecord;
  }
  
  private static im_msg_body.RichText a(MessageRecord paramMessageRecord, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return MessageProtoCodec.a(paramMessageRecord);
    }
    return MessageProtoCodec.a((MessageForText)paramMessageRecord);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo)
  {
    if (!paramQQAppInterface.getFileManagerEngine().a().a(paramArrayList, paramMsg)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, false, false, paramMessageInfo);
    }
    paramQQAppInterface = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    if (paramQQAppInterface.rich_text.has())
    {
      im_msg_body.RichText localRichText = (im_msg_body.RichText)paramQQAppInterface.rich_text.get();
      if (localRichText.elems.has())
      {
        paramQQAppInterface = localRichText.elems.get();
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.iterator();
          while (paramQQAppInterface.hasNext())
          {
            paramMessageInfo = (im_msg_body.Elem)paramQQAppInterface.next();
            if (paramMessageInfo.anon_group_msg.has())
            {
              paramMessageInfo = (im_msg_body.AnonymousGroupMsg)paramMessageInfo.anon_group_msg.get();
              int i = paramMessageInfo.uint32_flags.get();
              paramQQAppInterface = paramMessageInfo.str_anon_id.get().toByteArray();
              byte[] arrayOfByte = paramMessageInfo.str_anon_nick.get().toByteArray();
              int j = paramMessageInfo.uint32_head_portrait.get();
              int k = paramMessageInfo.uint32_expire_time.get();
              String str = paramMessageInfo.str_rank_color.get().toStringUtf8();
              if (paramQQAppInterface != null) {
                try
                {
                  paramQQAppInterface = new String(paramQQAppInterface, "ISO-8859-1");
                }
                catch (UnsupportedEncodingException paramQQAppInterface)
                {
                  paramQQAppInterface.printStackTrace();
                }
              } else {
                paramQQAppInterface = "";
              }
              Iterator localIterator = paramArrayList.iterator();
              while (localIterator.hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                if (arrayOfByte == null) {
                  paramMessageInfo = "";
                } else {
                  paramMessageInfo = new String(arrayOfByte);
                }
                localMessageRecord.saveExtInfoToExtStr("anonymous", AnonymousChatHelper.a(i, paramQQAppInterface, paramMessageInfo, j, k, str));
                localMessageRecord.extLong |= 0x3;
              }
              if (QLog.isColorLevel())
              {
                paramQQAppInterface = new StringBuilder();
                paramQQAppInterface.append("anonymous_flags has = ");
                paramQQAppInterface.append(i);
                QLog.d("anonymous_decode", 2, paramQQAppInterface.toString());
              }
            }
          }
        }
        if (localRichText.ptt.has()) {
          new GrpDisPTTDecoder().a(paramMessageHandler, paramMsg, paramArrayList, null);
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (!paramQQAppInterface.getFileManagerEngine().a().b(paramArrayList, paramMsg)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, false, false, paramMessageInfo);
    }
    paramQQAppInterface = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    if ((paramQQAppInterface.rich_text.has()) && (((im_msg_body.RichText)paramQQAppInterface.rich_text.get()).ptt.has())) {
      new GrpDisPTTDecoder().a(paramMessageHandler, paramMsg, paramArrayList, null);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, msg_comm.MsgHead paramMsgHead, int paramInt, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    int i = paramMsgHead.c2c_cmd.get();
    if ((paramInt == 529) && (i == 4))
    {
      paramQQAppInterface.getFileManagerEngine().a().a(paramArrayList, ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get());
      return;
    }
    if ((i == 175) || (i == 11)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, true, false, paramMessageInfo);
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (paramRichText != null)
    {
      im_msg_body.ElemFlags2 localElemFlags2 = new im_msg_body.ElemFlags2();
      localElemFlags2.uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
      paramMessageRecord = new im_msg_body.Elem();
      paramMessageRecord.elem_flags2.set(localElemFlags2);
      paramRichText.elems.add(paramMessageRecord);
    }
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    msg_comm.Msg localMsg = new msg_comm.Msg();
    msg_comm.MsgHead localMsgHead = a(paramMessageRecord, paramQQAppInterface.getLongAccountUin());
    try
    {
      paramQQAppInterface = a(paramMessageRecord, paramQQAppInterface);
    }
    catch (Throwable paramQQAppInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transToBackupEntity,getMsgBody error mr = ");
      localStringBuilder.append(paramMessageRecord.getClass().getSimpleName());
      QLog.e("MsgBackup_msgproxy", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MsgBackup_msgproxy,mr = ");
      localStringBuilder.append(paramMessageRecord.getClass().getSimpleName());
      CaughtExceptionReport.a(paramQQAppInterface, localStringBuilder.toString());
      paramQQAppInterface = null;
    }
    if (localMsgHead != null)
    {
      if (paramQQAppInterface == null) {
        return null;
      }
      if (localMsgHead != null) {
        localMsg.msg_head.set(localMsgHead);
      }
      if (paramQQAppInterface != null) {
        localMsg.msg_body.set(paramQQAppInterface);
      }
      return localMsg.toByteArray();
    }
    return null;
  }
  
  public static long b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == paramLong2) {
      return paramLong1;
    }
    return paramLong3;
  }
  
  private static void b(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if ((paramRichText != null) && (AnonymousChatHelper.a(paramMessageRecord)))
    {
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      im_msg_body.AnonymousGroupMsg localAnonymousGroupMsg = new im_msg_body.AnonymousGroupMsg();
      AnonymousChatHelper.AnonymousExtInfo localAnonymousExtInfo = AnonymousChatHelper.a(paramMessageRecord);
      localAnonymousGroupMsg.uint32_flags.set(localAnonymousExtInfo.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(localAnonymousExtInfo.jdField_a_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_anon_id.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.jdField_a_of_type_JavaLangString.getBytes()));
      }
      if (!TextUtils.isEmpty(localAnonymousExtInfo.jdField_b_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_anon_nick.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.jdField_b_of_type_JavaLangString.getBytes()));
      }
      localAnonymousGroupMsg.uint32_head_portrait.set(localAnonymousExtInfo.jdField_b_of_type_Int);
      localAnonymousGroupMsg.uint32_expire_time.set(localAnonymousExtInfo.jdField_c_of_type_Int);
      if (!TextUtils.isEmpty(localAnonymousExtInfo.jdField_c_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_rank_color.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.jdField_c_of_type_JavaLangString.getBytes()));
      }
      localAnonymousGroupMsg.uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
      localElem.anon_group_msg.set(localAnonymousGroupMsg);
      if (QLog.isColorLevel()) {
        QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
      }
      paramRichText.elems.add(localElem);
    }
  }
  
  public MessageRecord a(@NonNull Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return null;
    }
    MsgBackupMsgEntity localMsgBackupMsgEntity = (MsgBackupMsgEntity)paramObject;
    paramObject = localObject;
    if (localMsgBackupMsgEntity.extensionData != null) {
      paramObject = a((QQAppInterface)this.app, localMsgBackupMsgEntity.extensionData);
    }
    return paramObject;
  }
  
  public MsgBackupMsgEntity a(@NonNull MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    Object localObject1;
    if ((paramMessageRecord.istroop == 1) && (paramMessageRecord.shmsgseq == 0L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("troopMsg msgshseq = 0,mr  == ");
      ((StringBuilder)localObject1).append(paramMessageRecord.toString());
      QLog.e("MsgBackup_msgproxy", 1, ((StringBuilder)localObject1).toString());
    }
    msg_comm.Msg localMsg = new msg_comm.Msg();
    if (paramMessageRecord.isLongMsg())
    {
      localObject1 = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject1).pkg_num.set(paramMessageRecord.longMsgCount);
      ((msg_comm.ContentHead)localObject1).div_seq.set(paramMessageRecord.longMsgId);
      ((msg_comm.ContentHead)localObject1).pkg_index.set(paramMessageRecord.longMsgIndex);
      localMsg.content_head.set((MessageMicro)localObject1);
    }
    msg_comm.MsgHead localMsgHead = a(paramMessageRecord, this.app.getLongAccountUin());
    Object localObject2;
    try
    {
      localObject1 = a(paramMessageRecord, (QQAppInterface)this.app);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transToBackupEntity,getMsgBody error mr = ");
      localStringBuilder.append(paramMessageRecord.getClass().getSimpleName());
      QLog.e("MsgBackup_msgproxy", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MsgBackup_msgproxy,mr = ");
      localStringBuilder.append(paramMessageRecord.getClass().getSimpleName());
      CaughtExceptionReport.a(localThrowable, localStringBuilder.toString());
      localObject2 = null;
    }
    if ((localMsgHead != null) && (localObject2 != null))
    {
      localMsg.msg_head.set(localMsgHead);
      localMsg.msg_body.set((MessageMicro)localObject2);
      localObject2 = new MsgBackupMsgEntity();
      ((MsgBackupMsgEntity)localObject2).chatUin = paramMessageRecord.frienduin;
      ((MsgBackupMsgEntity)localObject2).chatType = MsgBackupUtil.b(paramMessageRecord.istroop);
      ((MsgBackupMsgEntity)localObject2).msgType = MsgBackupUtil.a(paramMessageRecord.msgtype);
      ((MsgBackupMsgEntity)localObject2).msgTime = paramMessageRecord.time;
      ((MsgBackupMsgEntity)localObject2).msgSeq = paramMessageRecord.msgseq;
      int i;
      if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))
      {
        i = MessageUtils.b(paramMessageRecord.msgUid);
        ((MsgBackupMsgEntity)localObject2).msgSeq = ((short)(int)paramMessageRecord.shmsgseq & 0xFFFF);
        ((MsgBackupMsgEntity)localObject2).msgRandom = i;
      }
      else
      {
        ((MsgBackupMsgEntity)localObject2).msgSeq = paramMessageRecord.shmsgseq;
      }
      if (MsgBackupUtil.d)
      {
        i = localMsg.getSerializedSize();
        paramMessageRecord = MsgBackupPbCache.a(i);
        if (paramMessageRecord == null)
        {
          paramMessageRecord = localMsg.toByteArray();
          MsgBackupPbCache.a(paramMessageRecord);
        }
        else
        {
          localMsg.toByteArray(paramMessageRecord, 0, i);
        }
        ((MsgBackupMsgEntity)localObject2).extensionData = paramMessageRecord;
        return localObject2;
      }
      ((MsgBackupMsgEntity)localObject2).extensionData = localMsg.toByteArray();
      return localObject2;
    }
    MsgBackupUtil.a("transBackupEntity error,mr = %s ", paramMessageRecord.toString(), new Object[0]);
    return null;
  }
  
  public void destroy() {}
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupMsgProxy
 * JD-Core Version:    0.7.0.1
 */