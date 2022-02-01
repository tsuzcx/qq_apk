package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.IGrpDisPTTDecoder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
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
  implements IGrpDisPTTDecoder<BaseMessageHandler>
{
  private int a(msg_comm.Msg paramMsg)
  {
    boolean bool = paramMsg.msg_body.has();
    int j = 0;
    int i = j;
    if (bool)
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        return 0;
      }
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        i = j;
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.elem_flags2.has()) || (!((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.has()));
      int k = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.get();
      if (k == 1) {
        return 1;
      }
      i = j;
      if (k == 2) {
        i = 2;
      }
    }
    return i;
  }
  
  @NotNull
  private MessageRecord a(BaseMessageHandler paramBaseMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, im_msg_body.Ptt paramPtt, String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(BaseMessageHandler paramBaseMessageHandler, msg_comm.Msg paramMsg, MessageRecord paramMessageRecord, List<im_msg_body.Elem> paramList)
  {
    int i = 0;
    int j;
    while (i < paramList.size())
    {
      Object localObject = (im_msg_body.Elem)paramList.get(i);
      if (((im_msg_body.Elem)localObject).general_flags.bytes_pb_reserve.has())
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        try
        {
          localResvAttr.mergeFrom(((im_msg_body.Elem)localObject).general_flags.bytes_pb_reserve.get().toByteArray());
          if (localResvAttr.uint32_robot_msg_flag.has())
          {
            j = localResvAttr.uint32_robot_msg_flag.get();
            paramMessageRecord.mRobotFlag = j;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("handleGeneralSettingFlags uint32_robot_msg_flag = ");
              ((StringBuilder)localObject).append(j);
              QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
      i += 1;
    }
    boolean bool = ((ITroopRobotService)paramBaseMessageHandler.b().getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    if ((paramMessageRecord.mRobotFlag == 1) || (paramMessageRecord.mRobotFlag == 2) || (bool))
    {
      paramMsg = paramList.iterator();
      label404:
      while (paramMsg.hasNext())
      {
        paramBaseMessageHandler = (im_msg_body.Elem)paramMsg.next();
        if (paramBaseMessageHandler.text.has())
        {
          paramBaseMessageHandler = (im_msg_body.Text)paramBaseMessageHandler.text.get();
          if (paramBaseMessageHandler.attr_6_buf.has())
          {
            paramBaseMessageHandler = paramBaseMessageHandler.attr_6_buf.get();
            if (paramBaseMessageHandler != null) {
              paramBaseMessageHandler = paramBaseMessageHandler.toByteArray();
            } else {
              paramBaseMessageHandler = null;
            }
            if ((paramBaseMessageHandler != null) && (paramBaseMessageHandler.length != 0))
            {
              int k = PkgTools.getShortData(paramBaseMessageHandler, 0);
              i = 0;
              j = 2;
              for (;;)
              {
                if ((i >= k) || (j >= 2048)) {
                  break label404;
                }
                paramList = new AtTroopMemberInfo();
                if (!paramList.readFrom(paramBaseMessageHandler, j)) {
                  break;
                }
                j += paramList.length();
                i = (short)(i + 1);
                if (paramMessageRecord.atInfoList == null) {
                  paramMessageRecord.atInfoList = new ArrayList();
                }
                paramMessageRecord.atInfoList.add(paramList);
              }
            }
          }
        }
      }
      ((MessageForPtt)paramMessageRecord).parse();
    }
  }
  
  private void a(MessageRecord paramMessageRecord, im_msg_body.Elem paramElem)
  {
    if ((paramElem.general_flags.has()) && (paramElem.general_flags.bytes_pb_reserve.has()))
    {
      Object localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
        boolean bool = ((generalflags.ResvAttr)localObject).uint32_holiday_flag.has();
        if (bool)
        {
          i = ((generalflags.ResvAttr)localObject).uint32_holiday_flag.get();
          if (i == 1) {
            paramMessageRecord.saveExtInfoToExtStr(MessageConstants.c, String.valueOf(i));
          }
          if (QLog.isColorLevel())
          {
            paramElem = new StringBuilder();
            paramElem.append("decodeGrpDisMsgPkg_PTT uint32_holiday_flag = ");
            paramElem.append(i);
            QLog.i("GrpDisPTTDecoder", 2, paramElem.toString());
          }
        }
        bool = ((generalflags.ResvAttr)localObject).bytes_pb_ptt_waveform.has();
        if (!bool) {}
      }
      catch (Exception paramMessageRecord)
      {
        int i;
        label283:
        paramMessageRecord.printStackTrace();
      }
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeGrpDisMsgPkg_PTT, waveformArray = ");
        ((StringBuilder)localObject).append(paramElem.toString());
        QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject).toString());
      }
    }
    catch (Throwable paramElem)
    {
      break label283;
    }
    if ((((MessageForPtt)paramMessageRecord).waveformArray == null) || (((MessageForPtt)paramMessageRecord).waveformArray.length == 0))
    {
      ((MessageForPtt)paramMessageRecord).buileDefaultWaveform();
      return;
    }
  }
  
  private void a(msg_comm.Msg paramMsg, MessageRecord paramMessageRecord, List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder)
  {
    int i = 0;
    while (i < paramList.size())
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
      else
      {
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
          if (QLog.isColorLevel())
          {
            paramStringBuilder.append("has olympicTorch:");
            paramStringBuilder.append(j);
            paramStringBuilder.append(";");
          }
          if (j > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append("");
            paramMessageRecord.saveExtInfoToExtStr("olympic_torch_flg", ((StringBuilder)localObject).toString());
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
      a(paramMessageRecord, localElem);
      i += 1;
    }
  }
  
  public long a(int paramInt)
  {
    return ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getPttShowTime(paramInt);
  }
  
  public void a(BaseMessageHandler paramBaseMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramDecodeProtoPkgContext = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    Object localObject = paramDecodeProtoPkgContext.bytes_file_name.get().toStringUtf8();
    if (((String)localObject).endsWith(".amr")) {
      paramList = a(paramBaseMessageHandler, paramMsg, paramList, paramDecodeProtoPkgContext, (String)localObject, "");
    } else {
      paramList = null;
    }
    if (paramList == null) {
      return;
    }
    paramDecodeProtoPkgContext = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    localObject = new StringBuilder();
    if ((paramDecodeProtoPkgContext != null) && (paramDecodeProtoPkgContext.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        ((StringBuilder)localObject).append("elemsSize");
        ((StringBuilder)localObject).append(paramDecodeProtoPkgContext.size());
        ((StringBuilder)localObject).append("\n");
      }
      a(paramMsg, paramList, paramDecodeProtoPkgContext, (StringBuilder)localObject);
      a(paramBaseMessageHandler, paramMsg, paramList, paramDecodeProtoPkgContext);
      ConfessMsgUtil.a(paramMsg, paramList, paramBaseMessageHandler.b());
      if (QLog.isColorLevel()) {
        QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).append("elems:null || elems.size() <= 0");
      QLog.d("GrpDisPTTDecoder", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.GrpDisPTTDecoder
 * JD-Core Version:    0.7.0.1
 */