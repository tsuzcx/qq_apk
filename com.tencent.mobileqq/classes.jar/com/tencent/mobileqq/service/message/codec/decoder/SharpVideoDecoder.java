package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.av.SharpReport_OffLine;
import com.tencent.av.VideoController;
import com.tencent.av.VideoPackageUtils;
import com.tencent.av.core.AVMsgUtil;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.hd_video_2.CmdS2CInviteReqBody;
import com.tencent.av.hd_video_2.InviteTempSessionData;
import com.tencent.av.hd_video_2.MsgBody;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class SharpVideoDecoder
  implements Decoder<MessageHandler>
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    String str;
    hd_video_2.MsgBody localMsgBody;
    int m;
    int i1;
    int i2;
    int i;
    int k;
    int j;
    if (paramBoolean)
    {
      str = String.valueOf(paramLong1);
      localMsgBody = new hd_video_2.MsgBody();
      m = -1;
      i1 = 0;
      i2 = 0;
      i = 0;
      k = i2;
      j = m;
    }
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        k = i2;
        j = m;
        n = localMsgBody.msg_invite_body.uint32_new_business_flag.get();
        k = i2;
        j = n;
        if (!localMsgBody.msg_invite_body.msg_temp_session.has()) {
          continue;
        }
        m = i1;
        k = i2;
        j = n;
        if (localMsgBody.msg_invite_body.msg_temp_session.uint32_relationship_type.has())
        {
          k = i2;
          j = n;
          i1 = VideoController.a(localMsgBody.msg_invite_body.msg_temp_session.uint32_relationship_type.get(), false, 1);
          if (i1 != -1) {
            i = i1;
          }
          m = i;
          k = i;
          j = n;
          if (QLog.isColorLevel())
          {
            k = i;
            j = n;
            QLog.d("shanezhaiSHARP", 2, "uinType" + i + " translateType:" + i1);
            m = i;
          }
        }
        j = n;
      }
      catch (Exception paramArrayOfByte)
      {
        int n;
        paramArrayOfByte.printStackTrace();
        m = k;
        continue;
      }
      if (-1 != j) {
        break label366;
      }
      VideoMsgTools.a(paramMessageHandler.a, 0, 6, true, str, String.valueOf(paramLong2), false, null, false, new Object[] { paramMsg });
      SharpReport_OffLine.a(paramLong2, paramLong1, 208);
      if (QLog.isColorLevel()) {
        QLog.d("shanezhaiSHARP", 2, "Discard video message because of time out " + paramLong3 + " s");
      }
      return;
      m = i1;
      k = i2;
      j = n;
      if (QLog.isColorLevel())
      {
        k = i2;
        j = n;
        QLog.d("shanezhaiSHARP", 2, "msg_temp_session not include");
        m = i1;
      }
    }
    label366:
    if (j == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      VideoMsgTools.a(paramMessageHandler.a, m, 6, paramBoolean, str, String.valueOf(paramLong1), false, null, false, new Object[] { paramMsg });
      break;
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("SharpVideoDecoder", 2, "<---decodeC2CMsgPkg_SharpVideo return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    long l1;
    long l4;
    long l2;
    long l5;
    byte[] arrayOfByte2;
    boolean bool;
    do
    {
      long l3;
      do
      {
        byte[] arrayOfByte1;
        int i;
        int j;
        do
        {
          do
          {
            return;
            l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
            l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
            l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
            l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
            ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
            paramList = l4 + "-" + l3;
            if (QLog.isColorLevel()) {
              QLog.d("shanezhaiSHARP", 2, "<---decodeC2CMsgPkg_SharpVideo :  key:" + paramList);
            }
            if (!paramMessageHandler.a.getMsgCache().a(l2, paramList)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("shanezhaiSHARP", 2, "msg has been pulled");
          return;
          l3 = MessageCache.a();
          l4 = Long.valueOf(paramMessageHandler.a.getCurrentAccountUin()).longValue();
          arrayOfByte1 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          l5 = l3 - l1;
          arrayOfByte2 = new byte[4];
          byte[] arrayOfByte3 = new byte[4];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
          System.arraycopy(arrayOfByte1, 4, arrayOfByte3, 0, 4);
          i = VideoPackageUtils.a(arrayOfByte2, 4);
          j = arrayOfByte1.length - 8 - i;
        } while (j < 0);
        arrayOfByte2 = new byte[j];
        System.arraycopy(arrayOfByte1, i + 8, arrayOfByte2, 0, j);
        bool = AVMsgUtil.a(arrayOfByte2);
        if (((paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) || (paramDecodeProtoPkgContext.f)) && ((paramDecodeProtoPkgContext.jdField_a_of_type_Long == paramDecodeProtoPkgContext.b) && ((paramDecodeProtoPkgContext.jdField_a_of_type_Long != paramDecodeProtoPkgContext.b) || (bool)))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SharpVideoDecoder", 2, "<---decodeC2CMsgPkg_SharpVideo return null:,isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f + ",isSharpRequest" + bool);
      return;
      if (bool)
      {
        paramMessageHandler.a.getMsgCache().a(l2, paramList, l3);
        SharpReport_OffLine.a(l4, l2, 215);
      }
      if (VcSystemInfo.isSupportSharpAudio()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("shanezhaiSHARP", 2, "Discard video message cause device not support");
      }
    } while (!bool);
    SharpReport_OffLine.a(l4, l2, 212);
    return;
    if (l5 >= 60L)
    {
      a(paramMessageHandler, paramMsg, l2, l4, l5, arrayOfByte2, bool);
      return;
    }
    if (bool) {
      SharpReport_OffLine.a(l4, l2, 211);
    }
    if (QLog.isColorLevel()) {
      QLog.d("shanezhaiSHARP", 2, "===========handleSharpVideoMessageResp 1234========");
    }
    paramMessageHandler.a(l4, arrayOfByte2, l2, (int)l1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.SharpVideoDecoder
 * JD-Core Version:    0.7.0.1
 */