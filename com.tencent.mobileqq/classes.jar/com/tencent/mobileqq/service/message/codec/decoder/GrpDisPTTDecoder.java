package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class GrpDisPTTDecoder
  implements Decoder<MessageHandler>
{
  private int a(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.has()))
      {
        int i = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.get();
        if (i == 1) {
          return 1;
        }
        if (i == 2) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  @NotNull
  private MessageRecord a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, im_msg_body.Ptt paramPtt, String paramString1, String paramString2)
  {
    int m;
    int i4;
    int j;
    boolean bool;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    Object localObject1;
    int n;
    label144:
    int i;
    long l1;
    Object localObject2;
    if (SttManager.a(paramMessageHandler.a))
    {
      m = 1;
      i4 = a(paramMsg);
      j = paramPtt.uint32_file_type.get();
      bool = paramPtt.bool_valid.get();
      l2 = paramPtt.uint64_src_uin.get();
      l3 = paramPtt.uint32_file_size.get();
      l4 = paramPtt.uint32_file_id.get() & 0xFFFFFFFF;
      l5 = paramPtt.uint32_server_ip.get();
      l6 = paramPtt.uint32_server_port.get();
      localObject1 = paramPtt.bytes_file_uuid.get().toByteArray();
      paramMessageHandler = paramPtt.bytes_file_md5.get().toByteArray();
      if (!paramPtt.uint32_format.has()) {
        break label1123;
      }
      n = paramPtt.uint32_format.get();
      if (!paramPtt.uint32_time.has()) {
        break label1129;
      }
      i = paramPtt.uint32_time.get();
      l1 = QQRecorder.b(i);
      if (!paramPtt.bytes_down_para.has()) {
        break label1190;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , bytes_down_para has ! " + paramPtt.bytes_down_para.get());
      }
      localObject2 = paramPtt.bytes_down_para.get();
      if (localObject2 == null) {
        break label1190;
      }
    }
    label1190:
    for (String str1 = ((ByteStringMicro)localObject2).toStringUtf8();; str1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , url : " + str1 + " srcuin " + l2 + "filename" + paramString1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---decodeGrpDisMsgPkg_PTT voiceType：" + n + " voiceLengh:" + l1);
      }
      localObject1 = HexUtil.bytes2HexStr((byte[])localObject1);
      String str2 = HexUtil.bytes2HexStr(paramMessageHandler);
      if (paramPtt.bytes_group_file_key.has()) {}
      for (paramMessageHandler = paramPtt.bytes_group_file_key.get().toByteArray();; paramMessageHandler = null) {
        try
        {
          paramMessageHandler = new String(paramMessageHandler, "utf-8");
          if (str2 == null)
          {
            str2 = "";
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
              ((StringBuilder)localObject2).append(" pttType:").append(j).append(" isValid:").append(bool).append(" srcUin:").append(l2).append(" fileSize:").append(l3 & 0xFFFFFFFF).append(" fileID").append(l4).append(" serverIP:").append(l5 & 0xFFFFFFFF).append(" serverPort:").append(l6 & 0xFFFFFFFF).append(" fileName:").append(paramString1).append(" uuidStr:").append((String)localObject1).append(" md5Str:").append(str2).append(" GrpFileKey:").append(paramMessageHandler);
              QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject2).toString());
            }
            i1 = 0;
            int i2 = 0;
            int i3 = 0;
            String str3 = "";
            if (paramPtt.bytes_pb_reserve.has())
            {
              ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
              k = i3;
              j = i2;
              i = i1;
              localObject1 = paramString2;
              try
              {
                localReserveStruct.mergeFrom(paramPtt.bytes_pb_reserve.get().toByteArray());
                k = i3;
                j = i2;
                i = i1;
                localObject1 = paramString2;
                i1 = localReserveStruct.uint32_change_voice.get();
                k = i3;
                j = i2;
                i = i1;
                localObject1 = paramString2;
                i2 = localReserveStruct.uint32_redpack_type.get();
                k = i3;
                j = i2;
                i = i1;
                localObject1 = paramString2;
                i3 = localReserveStruct.uint32_autototext_voice.get();
                k = i3;
                j = i2;
                i = i1;
                localObject1 = paramString2;
                localObject2 = localReserveStruct.bytes_voice_text_abs.get().toStringUtf8();
                paramString2 = str3;
                k = i3;
                j = i2;
                i = i1;
                localObject1 = localObject2;
                if (localReserveStruct.bytes_redpack_score_id.has())
                {
                  k = i3;
                  j = i2;
                  i = i1;
                  localObject1 = localObject2;
                  paramString2 = localReserveStruct.bytes_redpack_score_id.get().toStringUtf8();
                }
                localObject1 = paramString2;
                i = i3;
                j = i2;
                k = i1;
                paramString2 = (String)localObject2;
                localObject2 = localObject1;
              }
              catch (Exception paramString2)
              {
                for (;;)
                {
                  localObject2 = "";
                  i1 = i;
                  i = k;
                  k = i1;
                  paramString2 = (String)localObject1;
                }
              }
              TransfileUtile.makeTransFileProtocolData(paramString1, 0L, 2, false, paramString1);
              localObject1 = new RichMsg.PttRec();
              ((RichMsg.PttRec)localObject1).localPath.set(paramString1);
              ((RichMsg.PttRec)localObject1).size.set(paramPtt.uint32_file_size.get());
              ((RichMsg.PttRec)localObject1).type.set(2);
              ((RichMsg.PttRec)localObject1).uuid.set(paramString1);
              ((RichMsg.PttRec)localObject1).isRead.set(false);
              ((RichMsg.PttRec)localObject1).md5.set(str2);
              ((RichMsg.PttRec)localObject1).isReport.set(0);
              ((RichMsg.PttRec)localObject1).version.set(5);
              ((RichMsg.PttRec)localObject1).groupFileID.set(l4);
              ((RichMsg.PttRec)localObject1).pttFlag.set(m);
              ((RichMsg.PttRec)localObject1).longPttVipFlag.set(i4);
              if (paramMessageHandler != null) {
                ((RichMsg.PttRec)localObject1).group_file_key.set(paramMessageHandler);
              }
              l2 = System.currentTimeMillis() / 1000L;
              l3 = paramMsg.msg_head.msg_time.get();
              ((RichMsg.PttRec)localObject1).msgRecTime.set(l2);
              ((RichMsg.PttRec)localObject1).msgTime.set(l3);
              ((RichMsg.PttRec)localObject1).voiceType.set(n);
              ((RichMsg.PttRec)localObject1).voiceLength.set(Utils.a(l1));
              ((RichMsg.PttRec)localObject1).voiceChangeFlag.set(k);
              ((RichMsg.PttRec)localObject1).directUrl.set(str1);
              ((RichMsg.PttRec)localObject1).redpack_type.set(j);
              ((RichMsg.PttRec)localObject1).autototext_voice.set(i);
              ((RichMsg.PttRec)localObject1).sttText.set(paramString2);
              paramMessageHandler = MessageRecordFactory.a(-2002);
              paramMessageHandler.msgtype = -2002;
              paramMessageHandler.msgData = ((RichMsg.PttRec)localObject1).toByteArray();
              ((MessageForPtt)paramMessageHandler).parse();
              paramList.add(paramMessageHandler);
              VoiceRedPacketHelper.b((String)localObject2, paramMessageHandler);
              return paramMessageHandler;
              m = 0;
              break;
              label1123:
              n = 0;
              break label144;
              label1129:
              i = 0;
            }
          }
        }
        catch (UnsupportedEncodingException paramMessageHandler)
        {
          for (;;)
          {
            int i1;
            paramMessageHandler = null;
            continue;
            localObject2 = "";
            i = 0;
            j = 0;
            int k = 0;
          }
        }
      }
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, MessageRecord paramMessageRecord, List<im_msg_body.Elem> paramList)
  {
    int i = 0;
    int j;
    for (;;)
    {
      if (i < paramList.size())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.get(i);
        generalflags.ResvAttr localResvAttr;
        if (localElem.general_flags.bytes_pb_reserve.has()) {
          localResvAttr = new generalflags.ResvAttr();
        }
        try
        {
          localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
          if (localResvAttr.uint32_robot_msg_flag.has())
          {
            j = localResvAttr.uint32_robot_msg_flag.get();
            paramMessageRecord.mRobotFlag = j;
            if (QLog.isColorLevel()) {
              QLog.d("GrpDisPTTDecoder", 2, "handleGeneralSettingFlags uint32_robot_msg_flag = " + j);
            }
          }
          i += 1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    boolean bool = ((TroopRobotManager)paramMessageHandler.a.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    if ((paramMessageRecord.mRobotFlag == 1) || (paramMessageRecord.mRobotFlag == 2) || (bool))
    {
      paramMsg = paramList.iterator();
      label385:
      label390:
      while (paramMsg.hasNext())
      {
        paramMessageHandler = (im_msg_body.Elem)paramMsg.next();
        if (paramMessageHandler.text.has())
        {
          paramMessageHandler = (im_msg_body.Text)paramMessageHandler.text.get();
          if (paramMessageHandler.attr_6_buf.has())
          {
            paramMessageHandler = paramMessageHandler.attr_6_buf.get();
            if (paramMessageHandler != null) {}
            for (paramMessageHandler = paramMessageHandler.toByteArray();; paramMessageHandler = null)
            {
              if ((paramMessageHandler == null) || (paramMessageHandler.length == 0)) {
                break label390;
              }
              int k = PkgTools.getShortData(paramMessageHandler, 0);
              i = 0;
              j = 2;
              for (;;)
              {
                if ((i >= k) || (j >= 2048)) {
                  break label385;
                }
                paramList = new AtTroopMemberInfo();
                if (!paramList.readFrom(paramMessageHandler, j)) {
                  break;
                }
                j += paramList.length();
                i = (short)(i + 1);
                if (paramMessageRecord.atInfoList == null) {
                  paramMessageRecord.atInfoList = new ArrayList();
                }
                paramMessageRecord.atInfoList.add(paramList);
              }
              break;
            }
          }
        }
      }
      ((MessageForPtt)paramMessageRecord).parse();
    }
  }
  
  private void a(MessageRecord paramMessageRecord, im_msg_body.Elem paramElem)
  {
    Object localObject;
    if ((paramElem.general_flags.has()) && (paramElem.general_flags.bytes_pb_reserve.has())) {
      localObject = new generalflags.ResvAttr();
    }
    try
    {
      ((generalflags.ResvAttr)localObject).mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
      if (((generalflags.ResvAttr)localObject).uint32_holiday_flag.has())
      {
        i = ((generalflags.ResvAttr)localObject).uint32_holiday_flag.get();
        if (i == 1) {
          paramMessageRecord.saveExtInfoToExtStr(MessageConstants.c, String.valueOf(i));
        }
        if (QLog.isColorLevel()) {
          QLog.i("GrpDisPTTDecoder", 2, "decodeGrpDisMsgPkg_PTT uint32_holiday_flag = " + i);
        }
      }
      boolean bool = ((generalflags.ResvAttr)localObject).bytes_pb_ptt_waveform.has();
      if (!bool) {}
    }
    catch (Exception paramMessageRecord)
    {
      int i;
      label265:
      paramMessageRecord.printStackTrace();
      return;
    }
    try
    {
      paramElem = new ptt_waveform.PttWaveform();
      paramElem.mergeFrom(((generalflags.ResvAttr)localObject).bytes_pb_ptt_waveform.get().toByteArray());
      ((MessageForPtt)paramMessageRecord).waveformArray = PttUtils.a(paramElem);
      if (QLog.isColorLevel())
      {
        paramElem = new StringBuilder();
        localObject = ((MessageForPtt)paramMessageRecord).waveformArray;
        if (localObject != null)
        {
          int j = localObject.length;
          i = 0;
          while (i < j)
          {
            paramElem.append(localObject[i]);
            paramElem.append(";");
            i += 1;
          }
        }
        QLog.d("GrpDisPTTDecoder", 2, "decodeGrpDisMsgPkg_PTT, waveformArray = " + paramElem.toString());
      }
    }
    catch (Throwable paramElem)
    {
      break label265;
    }
    if ((((MessageForPtt)paramMessageRecord).waveformArray == null) || (((MessageForPtt)paramMessageRecord).waveformArray.length == 0)) {
      ((MessageForPtt)paramMessageRecord).buileDefaultWaveform();
    }
  }
  
  private void a(msg_comm.Msg paramMsg, MessageRecord paramMessageRecord, List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder)
  {
    int i = 0;
    if (i < paramList.size())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.get(i);
      Object localObject;
      if (localElem.near_by_msg.has())
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType: near_by_msg;");
        }
        localObject = localElem.near_by_msg;
        if ((((im_msg_body.NearByMessageType)localObject).uint32_identify_type.has()) && (((im_msg_body.NearByMessageType)localObject).uint32_identify_type.get() == 1))
        {
          paramMessageRecord.saveExtInfoToExtStr("identify_flag", "true");
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("has identify;");
          }
        }
      }
      for (;;)
      {
        a(paramMessageRecord, localElem);
        i += 1;
        break;
        int j;
        if (localElem.pub_group.has())
        {
          localObject = (im_msg_body.PubGroup)localElem.pub_group.get();
          if (localObject != null)
          {
            j = ((im_msg_body.PubGroup)localObject).uint32_gender.get();
            String str = ((im_msg_body.PubGroup)localObject).bytes_nickname.get().toStringUtf8();
            paramMessageRecord.saveExtInfoToExtStr("hotchat_gender", String.valueOf(j));
            localObject = str;
            if (str == null) {
              localObject = "";
            }
            paramMessageRecord.saveExtInfoToExtStr("hotchat_nick", (String)localObject);
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("has pub_group;");
            }
          }
        }
        else if ((localElem.general_flags.has()) && (((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_olympic_torch.has()))
        {
          j = localElem.general_flags.uint32_olympic_torch.get();
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("has olympicTorch:").append(j).append(";");
          }
          if (j > 0) {
            paramMessageRecord.saveExtInfoToExtStr("olympic_torch_flg", j + "");
          }
        }
        else if ((localElem.common_elem.has()) && (13 == localElem.common_elem.uint32_service_type.get()))
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("decodeGrpDisMsgPkg_PTT decode hummer_commelem == UpdateStrangerAvatar");
          }
          new MessagePBElemDecoder().a(paramList, paramMsg, paramStringBuilder);
        }
      }
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramDecodeProtoPkgContext = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    Object localObject = paramDecodeProtoPkgContext.bytes_file_name.get().toStringUtf8();
    if (((String)localObject).endsWith(".amr")) {}
    for (paramList = a(paramMessageHandler, paramMsg, paramList, paramDecodeProtoPkgContext, (String)localObject, "");; paramList = null)
    {
      if (paramList == null) {}
      do
      {
        do
        {
          return;
          paramDecodeProtoPkgContext = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          localObject = new StringBuilder();
          if ((paramDecodeProtoPkgContext != null) && (paramDecodeProtoPkgContext.size() > 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        ((StringBuilder)localObject).append("elems:null || elems.size() <= 0");
        QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject).toString());
        return;
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject).append("elemsSize").append(paramDecodeProtoPkgContext.size()).append("\n");
        }
        a(paramMsg, paramList, paramDecodeProtoPkgContext, (StringBuilder)localObject);
        a(paramMessageHandler, paramMsg, paramList, paramDecodeProtoPkgContext);
        ConfessMsgUtil.a(paramMsg, paramList, paramMessageHandler.a);
      } while (!QLog.isColorLevel());
      QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.GrpDisPTTDecoder
 * JD-Core Version:    0.7.0.1
 */