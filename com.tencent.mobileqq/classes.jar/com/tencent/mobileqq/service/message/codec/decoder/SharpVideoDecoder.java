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
    if (paramBoolean)
    {
      String str = String.valueOf(paramLong1);
      hd_video_2.MsgBody localMsgBody = new hd_video_2.MsgBody();
      int j;
      int i;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        j = localMsgBody.msg_invite_body.uint32_new_business_flag.get();
        try
        {
          if (localMsgBody.msg_invite_body.msg_temp_session.has())
          {
            if (localMsgBody.msg_invite_body.msg_temp_session.uint32_relationship_type.has())
            {
              int n = VideoController.a(localMsgBody.msg_invite_body.msg_temp_session.uint32_relationship_type.get(), false, 1);
              if (n != -1) {
                i = n;
              } else {
                i = 0;
              }
              m = j;
              k = i;
              try
              {
                if (!QLog.isColorLevel()) {
                  break label241;
                }
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append("uinType");
                paramArrayOfByte.append(i);
                paramArrayOfByte.append(" translateType:");
                paramArrayOfByte.append(n);
                QLog.d("shanezhaiSHARP", 2, paramArrayOfByte.toString());
                m = j;
                k = i;
              }
              catch (Exception paramArrayOfByte)
              {
                break label228;
              }
            }
          }
          else if (QLog.isColorLevel()) {
            QLog.d("shanezhaiSHARP", 2, "msg_temp_session not include");
          }
          k = 0;
          m = j;
        }
        catch (Exception paramArrayOfByte) {}
        i = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        j = -1;
      }
      label228:
      paramArrayOfByte.printStackTrace();
      int k = i;
      int m = j;
      label241:
      if (-1 == m)
      {
        VideoMsgTools.a(paramMessageHandler.n, 0, 6, true, str, String.valueOf(paramLong2), false, null, false, new Object[] { paramMsg });
      }
      else
      {
        if (m == 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        VideoMsgTools.a(paramMessageHandler.n, k, 6, paramBoolean, str, String.valueOf(paramLong1), false, null, false, new Object[] { paramMsg });
      }
      SharpReport_OffLine.a(paramLong2, paramLong1, 208);
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("Discard video message because of time out ");
      paramMessageHandler.append(paramLong3);
      paramMessageHandler.append(" s");
      QLog.d("shanezhaiSHARP", 2, paramMessageHandler.toString());
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
      ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
      paramList = new StringBuilder();
      paramList.append(l4);
      paramList.append("-");
      paramList.append(l2);
      paramList = paramList.toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<---decodeC2CMsgPkg_SharpVideo :  key:");
        ((StringBuilder)localObject).append(paramList);
        QLog.d("shanezhaiSHARP", 2, ((StringBuilder)localObject).toString());
      }
      if (paramMessageHandler.n.getMsgCache().a(l1, paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("shanezhaiSHARP", 2, "msg has been pulled");
        }
        return;
      }
      long l6 = MessageCache.c();
      l4 = Long.valueOf(paramMessageHandler.n.getCurrentAccountUin()).longValue();
      Object localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      long l5 = l6 - l3;
      byte[] arrayOfByte1 = new byte[4];
      byte[] arrayOfByte2 = new byte[4];
      System.arraycopy(localObject, 0, arrayOfByte1, 0, 4);
      System.arraycopy(localObject, 4, arrayOfByte2, 0, 4);
      int i = VideoPackageUtils.b(arrayOfByte1, 4);
      int j = localObject.length - 8 - i;
      if (j < 0) {
        return;
      }
      arrayOfByte1 = new byte[j];
      System.arraycopy(localObject, 8 + i, arrayOfByte1, 0, j);
      boolean bool = AVMsgUtil.b(arrayOfByte1);
      if (((!paramDecodeProtoPkgContext.g) && (!paramDecodeProtoPkgContext.l)) || ((paramDecodeProtoPkgContext.a == paramDecodeProtoPkgContext.b) && ((paramDecodeProtoPkgContext.a != paramDecodeProtoPkgContext.b) || (bool))))
      {
        if (bool)
        {
          paramDecodeProtoPkgContext = paramMessageHandler.n.getMsgCache();
          l2 = l1;
          paramDecodeProtoPkgContext.a(l2, paramList, l6);
          SharpReport_OffLine.a(l4, l2, 215);
        }
        if (!VcSystemInfo.isSupportSharpAudio())
        {
          if (QLog.isColorLevel()) {
            QLog.d("shanezhaiSHARP", 2, "Discard video message cause device not support");
          }
          if (bool) {
            SharpReport_OffLine.a(l4, l1, 212);
          }
        }
        else
        {
          if (l5 >= 60L)
          {
            a(paramMessageHandler, paramMsg, l1, l4, l5, arrayOfByte1, bool);
            return;
          }
          if (bool) {
            SharpReport_OffLine.a(l4, l1, 211);
          }
          if (QLog.isColorLevel()) {
            QLog.d("shanezhaiSHARP", 2, "===========handleSharpVideoMessageResp 1234========");
          }
          paramMessageHandler.a(l4, arrayOfByte1, l1, (int)l3, bool);
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("<---decodeC2CMsgPkg_SharpVideo return null:,isReaded:");
        paramMessageHandler.append(paramDecodeProtoPkgContext.g);
        paramMessageHandler.append("syncOther:");
        paramMessageHandler.append(paramDecodeProtoPkgContext.l);
        paramMessageHandler.append(",isSharpRequest");
        paramMessageHandler.append(bool);
        QLog.e("SharpVideoDecoder", 2, paramMessageHandler.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("<---decodeC2CMsgPkg_SharpVideo return null:hasBody:");
      paramMessageHandler.append(paramMsg.msg_body.has());
      paramMessageHandler.append(",hasMsgContent");
      paramMessageHandler.append(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      QLog.e("SharpVideoDecoder", 2, paramMessageHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.SharpVideoDecoder
 * JD-Core Version:    0.7.0.1
 */