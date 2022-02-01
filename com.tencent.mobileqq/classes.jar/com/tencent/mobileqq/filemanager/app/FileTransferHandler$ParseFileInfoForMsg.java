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
  private boolean b;
  private msg_comm.Msg c;
  private msg_comm.MsgHead d;
  private int e;
  private int f;
  private im_msg_body.NotOnlineFile g;
  
  public FileTransferHandler$ParseFileInfoForMsg(FileTransferHandler paramFileTransferHandler, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, int paramInt1, int paramInt2)
  {
    this.c = paramMsg;
    this.d = paramMsgHead;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  private boolean a(msg_comm.Msg paramMsg)
  {
    if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<---decodeC2CMsgPkg_OfflineFile return null:hasBody:");
      localStringBuilder.append(paramMsg.msg_body.has());
      localStringBuilder.append("hasRichT:");
      localStringBuilder.append(((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      QLog.e("FileTransferHandler<FileAssistant>", 2, localStringBuilder.toString());
    }
    return true;
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
  
  boolean a()
  {
    return this.b;
  }
  
  public im_msg_body.NotOnlineFile b()
  {
    return this.g;
  }
  
  public ParseFileInfoForMsg c()
  {
    Object localObject;
    if ((MessageUtils.d(this.e)) && (this.d.c2c_cmd.has()) && (this.f == 169))
    {
      if (a(this.c))
      {
        this.b = true;
        return this;
      }
      localObject = (im_msg_body.RichText)((im_msg_body.MsgBody)this.c.msg_body.get()).rich_text.get();
      if (a((im_msg_body.RichText)localObject))
      {
        this.b = true;
        return this;
      }
      this.g = ((im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject).not_online_file.get());
    }
    else
    {
      if ((this.e != 529) || (this.f != 4)) {
        break label246;
      }
    }
    try
    {
      localObject = ((im_msg_body.MsgBody)this.c.msg_body.get()).msg_content.get().toByteArray();
      SubMsgType0x4.MsgBody localMsgBody = new SubMsgType0x4.MsgBody();
      try
      {
        localObject = (SubMsgType0x4.MsgBody)localMsgBody.mergeFrom((byte[])localObject);
        if (a((SubMsgType0x4.MsgBody)localObject))
        {
          this.b = true;
          return this;
        }
        this.g = ((im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.get());
        this.b = false;
        return this;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", localInvalidProtocolBufferMicroException);
        }
        this.b = true;
        return this;
      }
      this.b = true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", localException);
      }
      this.b = true;
      return this;
    }
    label246:
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.ParseFileInfoForMsg
 * JD-Core Version:    0.7.0.1
 */