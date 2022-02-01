package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;

class FileTransferHandler$ParseFileInfoForMsg
{
  private int jdField_a_of_type_Int;
  private msg_comm.Msg jdField_a_of_type_MsfMsgcommMsg_comm$Msg;
  private msg_comm.MsgHead jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead;
  private im_msg_body.NotOnlineFile jdField_a_of_type_TencentImMsgIm_msg_body$NotOnlineFile;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public FileTransferHandler$ParseFileInfoForMsg(FileTransferHandler paramFileTransferHandler, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg = paramMsg;
    this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead = paramMsgHead;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  private boolean a(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + paramMsg.msg_body.has() + "hasRichT:" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      }
      return true;
    }
    return false;
  }
  
  private boolean a(im_msg_body.RichText paramRichText)
  {
    if (!paramRichText.not_online_file.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "hasNotOnlineFile");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(SubMsgType0x4.MsgBody paramMsgBody)
  {
    if (!paramMsgBody.msg_not_online_file.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
      }
      return true;
    }
    return false;
  }
  
  public ParseFileInfoForMsg a()
  {
    Object localObject;
    if ((MessageUtils.c(this.jdField_a_of_type_Int)) && (this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead.c2c_cmd.has()) && (this.b == 169))
    {
      if (a(this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg))
      {
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      localObject = (im_msg_body.RichText)((im_msg_body.MsgBody)this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).rich_text.get();
      if (a((im_msg_body.RichText)localObject))
      {
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      this.jdField_a_of_type_TencentImMsgIm_msg_body$NotOnlineFile = ((im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject).not_online_file.get());
    }
    label222:
    label229:
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return this;
      if ((this.jdField_a_of_type_Int != 529) || (this.b != 4)) {
        break;
      }
      try
      {
        localObject = ((im_msg_body.MsgBody)this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_body.get()).msg_content.get().toByteArray();
        SubMsgType0x4.MsgBody localMsgBody = new SubMsgType0x4.MsgBody();
        this.jdField_a_of_type_TencentImMsgIm_msg_body$NotOnlineFile = ((im_msg_body.NotOnlineFile)localInvalidProtocolBufferMicroException.msg_not_online_file.get());
      }
      catch (Exception localException)
      {
        try
        {
          localObject = (SubMsgType0x4.MsgBody)localMsgBody.mergeFrom((byte[])localObject);
          if (!a((SubMsgType0x4.MsgBody)localObject)) {
            break label229;
          }
          this.jdField_a_of_type_Boolean = true;
          return this;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (!QLog.isColorLevel()) {
            break label222;
          }
          QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", localInvalidProtocolBufferMicroException);
          this.jdField_a_of_type_Boolean = true;
          return this;
        }
        localException = localException;
        if (QLog.isColorLevel()) {
          QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", localException);
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public im_msg_body.NotOnlineFile a()
  {
    return this.jdField_a_of_type_TencentImMsgIm_msg_body$NotOnlineFile;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.ParseFileInfoForMsg
 * JD-Core Version:    0.7.0.1
 */