package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class MsgProcessPtt
  extends MsgProcessRichMedia<MessageForPtt>
{
  public MsgProcessPtt(MessageForPtt paramMessageForPtt)
  {
    super(paramMessageForPtt);
  }
  
  public void a()
  {
    Object localObject = (MessageForPtt)this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("packMsg uinType:");
    localStringBuilder.append(((MessageForPtt)localObject).istroop);
    b(localStringBuilder.toString());
    localObject = ((MessageForPtt)this.b).getRichText();
    ((MessageForPtt)this.b).richText = ((im_msg_body.RichText)localObject);
  }
  
  public List<MsgBackupResEntity> b()
  {
    MsgBackupResEntity localMsgBackupResEntity = f();
    localMsgBackupResEntity.msgSubType = 15;
    localMsgBackupResEntity.filePath = ((MessageForPtt)this.b).getLocalFilePath();
    if (!a(localMsgBackupResEntity.filePath)) {
      return null;
    }
    a(localMsgBackupResEntity.filePath, localMsgBackupResEntity);
    Object localObject = a(15);
    ((HashMap)localObject).put("selfuin", ((MessageForPtt)this.b).selfuin);
    ((HashMap)localObject).put("uuid", ((MessageForPtt)this.b).urlAtServer);
    ((HashMap)localObject).put("md5", ((MessageForPtt)this.b).md5);
    ((HashMap)localObject).put("selfuin", ((MessageForPtt)this.b).selfuin);
    if (((MessageForPtt)this.b).istroop == 1) {
      ((HashMap)localObject).put("chatType", "1");
    } else if (((MessageForPtt)this.b).istroop == 3000) {
      ((HashMap)localObject).put("chatType", "2");
    } else {
      ((HashMap)localObject).put("chatType", "3");
    }
    localMsgBackupResEntity.extraDataStr = a((Map)localObject);
    localObject = new ArrayList();
    ((List)localObject).add(localMsgBackupResEntity);
    return localObject;
  }
  
  protected int c()
  {
    return 3;
  }
  
  public void d()
  {
    ((MessageForPtt)this.b).url = MsgProcessPttImport.b(((MessageForPtt)this.b).md5, ((MessageForPtt)this.b).selfuin);
    if (((MessageForPtt)this.b).isSendFromLocal()) {
      ((MessageForPtt)this.b).issend = 2;
    }
    ((MessageForPtt)this.b).isReadPtt = true;
    ((MessageForPtt)this.b).serial();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPtt
 * JD-Core Version:    0.7.0.1
 */