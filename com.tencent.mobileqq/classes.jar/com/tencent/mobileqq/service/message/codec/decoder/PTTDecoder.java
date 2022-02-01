package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class PTTDecoder
  implements Decoder<MessageHandler>
{
  @Nullable
  private MessageForPtt a(msg_comm.Msg paramMsg, MessageForPtt paramMessageForPtt)
  {
    Object localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<---decodePBMsgElems: elems: ");
      if (localObject1 == null) {
        paramMsg = null;
      } else {
        paramMsg = Integer.valueOf(((List)localObject1).size());
      }
      ((StringBuilder)localObject2).append(paramMsg);
      QLog.d("PTTDecoder", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return null;
      }
      paramMsg = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (paramMsg.hasNext())
      {
        localObject2 = (im_msg_body.Elem)paramMsg.next();
        if ((!((im_msg_body.Elem)localObject2).general_flags.has()) || (!((im_msg_body.Elem)localObject2).general_flags.bytes_pb_reserve.has())) {}
      }
      else
      {
        try
        {
          localObject1 = new generalflags.ResvAttr();
          ((generalflags.ResvAttr)localObject1).mergeFrom(((im_msg_body.Elem)localObject2).general_flags.bytes_pb_reserve.get().toByteArray());
          if (!((generalflags.ResvAttr)localObject1).bytes_pb_ptt_waveform.has()) {
            continue;
          }
          localObject2 = new ptt_waveform.PttWaveform();
          ((ptt_waveform.PttWaveform)localObject2).mergeFrom(((generalflags.ResvAttr)localObject1).bytes_pb_ptt_waveform.get().toByteArray());
          paramMessageForPtt.waveformArray = PttUtils.a((ptt_waveform.PttWaveform)localObject2);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject1 = new StringBuilder();
          if (paramMessageForPtt.waveformArray != null)
          {
            localObject2 = paramMessageForPtt.waveformArray;
            int j = localObject2.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject1).append(localObject2[i]);
              ((StringBuilder)localObject1).append(";");
              i += 1;
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("decodeC2CMsgPkg_PTT, waveformArray = ");
          ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
          QLog.d("PTTDecoder", 2, ((StringBuilder)localObject2).toString());
        }
        catch (Throwable localThrowable) {}
        if ((paramMessageForPtt.waveformArray == null) || (paramMessageForPtt.waveformArray.length == 0)) {
          paramMessageForPtt.buileDefaultWaveform();
        }
        return paramMessageForPtt;
        return null;
      }
    }
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    try
    {
      if (!paramString2.contains("_")) {
        paramString2 = paramString2.substring(0, paramString2.length() - 4);
      } else {
        paramString2 = paramString2.substring(paramString2.lastIndexOf("_") + 1, paramString2.length() - 4);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" fileUuid:");
        localStringBuilder.append(paramString1);
        QLog.d("PTTDecoder", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, im_msg_body.RichText paramRichText, MessageRecord paramMessageRecord)
  {
    if (paramRichText.elems.has())
    {
      paramRichText = paramRichText.elems.get().iterator();
      while (paramRichText.hasNext())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramRichText.next();
        if ((localElem.common_elem.has()) && (21 == localElem.common_elem.uint32_service_type.get()))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramMessageRecord);
          ConfessMsgUtil.a(paramMsg, localElem, localArrayList, paramMessageHandler.n);
        }
      }
    }
  }
  
  private boolean a(im_msg_body.RichText paramRichText, im_msg_body.Ptt paramPtt)
  {
    if ((paramRichText.ptt.has()) && (paramPtt.uint32_file_type.has()) && ((paramPtt.uint32_file_type.get() == 4) || (paramPtt.uint32_file_type.get() == 6)) && (paramPtt.bytes_file_uuid.has()))
    {
      if (QLog.isColorLevel())
      {
        paramRichText = new StringBuilder();
        paramRichText.append("PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : ");
        paramRichText.append(paramPtt.uint32_file_type.get());
        QLog.d("PTTDecoder", 2, paramRichText.toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramRichText = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
      if (paramPtt == null)
      {
        paramRichText.append(" ptt is null.");
      }
      else
      {
        paramRichText.append(" HasileType:");
        paramRichText.append(paramPtt.uint32_file_type.has());
        paramRichText.append(" fileType:");
        paramRichText.append(paramPtt.uint32_file_type.get());
        paramRichText.append(" hasUUID:");
        paramRichText.append(paramPtt.bytes_file_uuid.has());
      }
      QLog.d("PTTDecoder", 2, paramRichText.toString());
    }
    return true;
  }
  
  public int a(int paramInt)
  {
    return ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getPttShowTime(paramInt);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.PTTDecoder
 * JD-Core Version:    0.7.0.1
 */