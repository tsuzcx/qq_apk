package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.av.VideoPackageUtils;
import com.tencent.av.core.AVMsgUtil;
import com.tencent.av.service.QavWrapper;
import com.tencent.common.app.BaseApplicationImpl;
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
import tencent.im.cs.head.ContentHead;
import tencent.im.cs.head.Head;
import tencent.im.cs.head.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class VideoQCallDecoder
  implements Decoder<MessageHandler>
{
  private void a(MessageHandler paramMessageHandler, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      new QavWrapper(BaseApplicationImpl.getContext()).a(new VideoQCallDecoder.1(this, paramArrayOfByte, paramString, paramLong3, paramMessageHandler, paramLong2, paramLong1, paramInt, paramBoolean));
      return;
    }
    catch (Exception paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(paramString, 2, "exception when process qcall offline msg", paramMessageHandler);
    }
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new head.Head();
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      ((head.Head)localObject).mergeFrom(arrayOfByte);
      int i = ((head.Head)localObject).msg_msg_head.msg_content_head.uint32_type.get();
      int j = ((head.Head)localObject).msg_msg_head.msg_content_head.uint32_subtype.get();
      if ((i == 562) && (j == 17))
      {
        localObject = new im_msg_body.MsgBody();
        arrayOfByte = new byte[paramInt3];
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2, arrayOfByte, 0, paramInt3);
        ((im_msg_body.MsgBody)localObject).mergeFrom(arrayOfByte);
        return ((im_msg_body.MsgBody)localObject).msg_content.get().toByteArray();
      }
      if (QLog.isColorLevel())
      {
        QLog.d(paramString, 2, "error msgType:" + i + ", or subType:" + j);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString, 2, "error when process qcall offline msg", paramArrayOfByte);
      }
    }
    return null;
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoQCallDecoder", 2, "<---decodeC2CMsgPkg_QCall return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    long l1;
    long l3;
    long l4;
    long l2;
    boolean bool;
    do
    {
      do
      {
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
              QLog.d("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall :  key:" + paramList);
            }
            if (!paramMessageHandler.a.getMsgCache().a(l2, paramList)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("decodeC2CMsgPkg_QCall", 2, "msg has been pulled");
          return;
          l3 = MessageCache.a();
          l4 = Long.valueOf(paramMessageHandler.a.getCurrentAccountUin()).longValue();
          paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          paramList = new byte[4];
          byte[] arrayOfByte = new byte[4];
          System.arraycopy(paramMsg, 0, paramList, 0, 4);
          System.arraycopy(paramMsg, 4, arrayOfByte, 0, 4);
          i = VideoPackageUtils.a(paramList, 4);
          j = VideoPackageUtils.a(arrayOfByte, 4);
          if ((i > 0) && (j > 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("decodeC2CMsgPkg_QCall", 2, "invalid head length:" + i + " or body length:" + j);
        return;
        paramMsg = a("decodeC2CMsgPkg_QCall", paramMsg, 8, i, j);
        if (paramMsg != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("decodeC2CMsgPkg_QCall", 2, "msg sharp content null, return;");
      return;
      bool = AVMsgUtil.a(paramMsg);
      if (((paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) || (paramDecodeProtoPkgContext.f)) && ((paramDecodeProtoPkgContext.jdField_a_of_type_Long == paramDecodeProtoPkgContext.b) && ((paramDecodeProtoPkgContext.jdField_a_of_type_Long != paramDecodeProtoPkgContext.b) || (bool)))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall return null:,isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f + ",isSharpRequest" + bool);
    return;
    a(paramMessageHandler, "decodeC2CMsgPkg_QCall", (int)l1, l2, l4, l3 - l1, paramMsg, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.VideoQCallDecoder
 * JD-Core Version:    0.7.0.1
 */