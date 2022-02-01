package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkServiceManager;
import java.util.List;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.WlanRecvNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class MsgType0x211Decoder
  implements Decoder<MessageHandler>
{
  private void a(MessageHandler paramMessageHandler, DecodeProtoPkgContext paramDecodeProtoPkgContext, byte[] paramArrayOfByte)
  {
    Object localObject = new SubMsgType0x3.MsgBody();
    try
    {
      ((SubMsgType0x3.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      boolean bool = ((SubMsgType0x3.MsgBody)localObject).msg_fail_notify.has();
      int k = 0;
      int j = 0;
      int i;
      if (bool)
      {
        paramArrayOfByte = (SubMsgType0x3.FailNotify)((SubMsgType0x3.MsgBody)localObject).msg_fail_notify.get();
        if (paramArrayOfByte.uint32_sessionid.has())
        {
          k = paramArrayOfByte.uint32_sessionid.get();
          if (paramArrayOfByte.uint32_retCode.has())
          {
            i = paramArrayOfByte.uint32_retCode.get();
          }
          else
          {
            i = j;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[");
              ((StringBuilder)localObject).append(k);
              ((StringBuilder)localObject).append("], failNotify has not RetCode");
              QLog.w("MsgType0x211Decoder", 2, ((StringBuilder)localObject).toString());
              i = j;
            }
          }
          if (paramArrayOfByte.bytes_reason.has())
          {
            paramArrayOfByte = new String(paramArrayOfByte.bytes_reason.get().toStringUtf8());
          }
          else
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[");
              paramArrayOfByte.append(k);
              paramArrayOfByte.append("], failNotify has not reason");
              QLog.w("MsgType0x211Decoder", 2, paramArrayOfByte.toString());
            }
            paramArrayOfByte = "";
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[");
            ((StringBuilder)localObject).append(k);
            ((StringBuilder)localObject).append("], retCode[");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append("], reason[");
            ((StringBuilder)localObject).append(paramArrayOfByte);
            ((StringBuilder)localObject).append("]");
            QLog.d("MsgType0x211Decoder", 2, ((StringBuilder)localObject).toString());
          }
          paramMessageHandler.a.getFileTransferHandler().a(String.valueOf(paramDecodeProtoPkgContext.g), k, i, paramArrayOfByte);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
        }
      }
      else if (((SubMsgType0x3.MsgBody)localObject).msg_progress_notify.has())
      {
        paramArrayOfByte = (SubMsgType0x3.ProgressNotify)((SubMsgType0x3.MsgBody)localObject).msg_progress_notify.get();
        if (paramArrayOfByte.uint32_sessionid.has())
        {
          int m = paramArrayOfByte.uint32_sessionid.get();
          if (paramArrayOfByte.uint32_progress.has())
          {
            i = paramArrayOfByte.uint32_progress.get();
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[");
              ((StringBuilder)localObject).append(m);
              ((StringBuilder)localObject).append("], progressNotify has not Progress");
              QLog.w("MsgType0x211Decoder", 2, ((StringBuilder)localObject).toString());
            }
            i = 0;
          }
          if (paramArrayOfByte.uint32_average_speed.has())
          {
            j = paramArrayOfByte.uint32_average_speed.get();
          }
          else
          {
            j = k;
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[");
              paramArrayOfByte.append(m);
              paramArrayOfByte.append("], progressNotify has not AverageSpeed");
              QLog.w("MsgType0x211Decoder", 2, paramArrayOfByte.toString());
              j = k;
            }
          }
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[");
            paramArrayOfByte.append(m);
            paramArrayOfByte.append("], progress[");
            paramArrayOfByte.append(i);
            paramArrayOfByte.append("], speed[");
            paramArrayOfByte.append(j);
            paramArrayOfByte.append("]");
            QLog.d("MsgType0x211Decoder", 2, paramArrayOfByte.toString());
          }
          paramMessageHandler.a.getFileTransferHandler().a(String.valueOf(paramDecodeProtoPkgContext.g), m, i, j);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
      }
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) {
        return;
      }
      try
      {
        byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
        int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[");
          localStringBuilder.append(i);
          localStringBuilder.append("]");
          QLog.d("MsgType0x211Decoder", 2, localStringBuilder.toString());
        }
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 7)
            {
              if (i != 8)
              {
                if (i != 9)
                {
                  if ((i != 13) && (i != 17))
                  {
                    if (QLog.isColorLevel())
                    {
                      paramMessageHandler = new StringBuilder();
                      paramMessageHandler.append("<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[");
                      paramMessageHandler.append(i);
                      paramMessageHandler.append("] is not implemented");
                      QLog.d("MsgType0x211Decoder", 2, paramMessageHandler.toString());
                    }
                  }
                  else {
                    a(paramMessageHandler, paramMsg, arrayOfByte);
                  }
                }
                else {
                  b(paramMessageHandler, paramMsg, arrayOfByte);
                }
              }
              else {
                c(paramMessageHandler, paramMsg, arrayOfByte);
              }
            }
            else {
              a(paramMessageHandler, paramMsg, paramDecodeProtoPkgContext, arrayOfByte);
            }
          }
          else {
            a(paramMessageHandler, paramMsg, paramDecodeProtoPkgContext, paramList, arrayOfByte);
          }
        }
        else {
          a(paramMessageHandler, paramDecodeProtoPkgContext, arrayOfByte);
        }
        return;
      }
      catch (Exception paramMessageHandler)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
        }
      }
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, List<MessageRecord> paramList, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
    }
    Object localObject = new SubMsgType0x4.MsgBody();
    try
    {
      SubMsgType0x4.MsgBody localMsgBody = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (localMsgBody.msg_not_online_file.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has  NotOnlineFile");
        }
        im_msg_body.NotOnlineFile localNotOnlineFile = (im_msg_body.NotOnlineFile)localMsgBody.msg_not_online_file.get();
        if (localMsgBody.resv_attr.has()) {
          paramArrayOfByte = (hummer_resv_21.ResvAttr)localMsgBody.resv_attr.get();
        } else {
          paramArrayOfByte = new hummer_resv_21.ResvAttr();
        }
        localObject = null;
        if (localMsgBody.file_image_info.has())
        {
          localObject = (hummer_resv_21.FileImgInfo)localMsgBody.file_image_info.get();
          paramArrayOfByte.file_image_info.set((MessageMicro)localObject);
        }
        if (paramDecodeProtoPkgContext.jdField_d_of_type_Boolean)
        {
          paramMessageHandler = new MessageRecord();
          long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
          paramMessageHandler.msg = localNotOnlineFile.bytes_file_name.get().toStringUtf8();
          paramMessageHandler.senderuin = Long.toString(l2);
          paramMessageHandler.msgtype = -2005;
          paramMessageHandler.frienduin = Long.toString(paramDecodeProtoPkgContext.g);
          paramMessageHandler.time = l1;
          if (localObject != null)
          {
            paramMessageHandler.saveExtInfoToExtStr("file_pic_width", String.valueOf(((hummer_resv_21.FileImgInfo)localObject).uint32_file_width.get()));
            paramMessageHandler.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(((hummer_resv_21.FileImgInfo)localObject).uint32_file_height.get()));
            paramMsg = new StringBuilder();
            paramMsg.append("Insert ThumbSize toMsg height[");
            paramMsg.append(((hummer_resv_21.FileImgInfo)localObject).uint32_file_width.get());
            paramMsg.append("], width[");
            paramMsg.append(((hummer_resv_21.FileImgInfo)localObject).uint32_file_height.get());
            paramMsg.append("]");
            QLog.i("MsgType0x211Decoder", 1, paramMsg.toString());
          }
          paramList.add(paramMessageHandler);
          return;
        }
        paramMessageHandler.a.getFileTransferHandler().a(paramMessageHandler, paramList, paramMsg, localNotOnlineFile, String.valueOf(paramDecodeProtoPkgContext.g), paramDecodeProtoPkgContext.jdField_a_of_type_Boolean, paramDecodeProtoPkgContext.b, paramDecodeProtoPkgContext.jdField_d_of_type_Long, paramDecodeProtoPkgContext.jdField_a_of_type_Int, paramArrayOfByte);
        return;
      }
      if (localMsgBody.msg_wlan_recved_notify.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has  msg_wlan_recved_notify");
        }
        paramMessageHandler.a.getFileTransferHandler().a((SubMsgType0x4.WlanRecvNotify)localMsgBody.msg_wlan_recved_notify.get());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
      }
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<dataline> message come: cmd[0x211, 0x7]");
    }
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    try
    {
      paramArrayOfByte = (SubMsgType0x7.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
      if (!paramDecodeProtoPkgContext.jdField_d_of_type_Boolean) {
        ((DataLineHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMsg, paramArrayOfByte);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x211Decoder", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
      }
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, byte[] paramArrayOfByte)
  {
    long l1 = paramMsg.msg_head.from_uin.get();
    long l2 = paramMsg.msg_head.to_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l3 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    long l4 = paramMsg.msg_head.msg_time.get();
    ((SmartDeviceProxyMgr)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(l1, l2, i, l3, j, "im_push.msg_push", paramArrayOfByte);
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("device msg push, receive 0x11,0xd msg, fromuin2:");
      paramMessageHandler.append(l1);
      paramMessageHandler.append(",touin:");
      paramMessageHandler.append(l2);
      paramMessageHandler.append(", msg seq:");
      paramMessageHandler.append(i);
      paramMessageHandler.append(",msg_uid:");
      paramMessageHandler.append(l3);
      paramMessageHandler.append(",msg_time:");
      paramMessageHandler.append(l4);
      paramMessageHandler.append(",msgtype:");
      paramMessageHandler.append(j);
      QLog.d("MsgType0x211Decoder", 2, paramMessageHandler.toString());
    }
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    int i;
    if ((paramMsg.msg_head.c2c_cmd.get() != 6) && (!paramMsg.msg_head.c2c_tmp_msg_head.has())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      new TempSessionDecoder().a(paramMessageHandler, paramMsg, paramList, paramDecodeProtoPkgContext);
    }
    if (!paramMsg.msg_head.c2c_tmp_msg_head.has())
    {
      paramMessageHandler = (FriendsManager)paramMessageHandler.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get())))
      {
        if (!paramMessageHandler.b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
          paramDecodeProtoPkgContext.c = 1025;
        }
      }
      else if ((BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) && (!paramMessageHandler.b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get())))) {
        paramDecodeProtoPkgContext.c = 1025;
      }
    }
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<dataline printer> message come: cmd[0x211, 0x9]");
    }
    C2CType0x211_SubC2CType0x9.MsgBody localMsgBody = new C2CType0x211_SubC2CType0x9.MsgBody();
    try
    {
      paramArrayOfByte = (C2CType0x211_SubC2CType0x9.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
      ((DataLineHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMsg, paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgType0x211Decoder", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", paramMessageHandler);
      }
    }
  }
  
  private void c(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, byte[] paramArrayOfByte)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    byte[] arrayOfByte;
    if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
      arrayOfByte = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
    }
    try
    {
      paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
      if (paramMsg != null) {
        ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addTmpSig(String.valueOf(l1), paramMsg);
      }
    }
    catch (Exception paramMsg)
    {
      label169:
      break label169;
    }
    paramMsg = arrayOfByte;
    break label177;
    paramMsg = null;
    label177:
    paramMessageHandler.a.getQlinkServiceMgr().a(l1, i, l2, l3, paramMsg, paramArrayOfByte);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    b(paramMessageHandler, paramMsg, paramList, paramDecodeProtoPkgContext);
    a(paramMessageHandler, paramMsg, paramDecodeProtoPkgContext, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.MsgType0x211Decoder
 * JD-Core Version:    0.7.0.1
 */