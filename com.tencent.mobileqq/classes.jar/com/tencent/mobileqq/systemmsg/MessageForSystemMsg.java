package com.tencent.mobileqq.systemmsg;

import android.content.res.Resources;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class MessageForSystemMsg
  extends ChatMessage
{
  public static final String TAG = "MessageForSystemMsg";
  public int mSysmsgMenuFlag = 0;
  public structmsg.StructMsg structMsg;
  
  public MessageForSystemMsg()
  {
    this.mSysmsgMenuFlag |= 0x1;
  }
  
  public static String getSysMsgDesc(Resources paramResources, structmsg.StructMsg paramStructMsg)
  {
    if ((paramStructMsg == null) || (paramResources == null))
    {
      paramStructMsg = "";
      return paramStructMsg;
    }
    int i = paramStructMsg.msg_type.get();
    if (i == 1) {
      switch (paramStructMsg.msg.sub_type.get())
      {
      case 2: 
      case 3: 
      default: 
        paramResources = paramStructMsg.msg.msg_describe.get();
        label87:
        String str = paramStructMsg.msg.req_uin_nick.get() + paramResources;
        paramResources = str;
        if (QLog.isColorLevel())
        {
          QLog.i("MessageForSystemMsg", 2, String.format("getSysMsgDesc, msg: %s, sub: %s, desc: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramStructMsg.msg.sub_type.get()), paramStructMsg.msg.msg_describe.get() }));
          paramResources = str;
        }
        break;
      }
    }
    for (;;)
    {
      paramStructMsg = paramResources;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("MessageForSystemMsg", 2, String.format("getSysMsgDesc, msg: %s, suffix: %s", new Object[] { Integer.valueOf(i), paramResources }));
      return paramResources;
      paramResources = paramResources.getString(2131689583);
      break label87;
      paramResources = paramResources.getString(2131689498);
      break label87;
      paramResources = paramResources.getString(2131689497);
      break label87;
      paramResources = paramResources.getString(2131717653);
      break label87;
      if (i == 2)
      {
        paramResources = "";
        int j = paramStructMsg.msg.group_msg_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("MessageForSystemMsg", 2, "groupMsgType:" + j + "|req_uin_nick:" + paramStructMsg.msg.req_uin_nick.get() + "|actor_uin_nick:" + paramStructMsg.msg.actor_uin_nick.get() + "|action_uin_nick:" + paramStructMsg.msg.action_uin_nick.get() + "|msg_describe:" + paramStructMsg.msg.msg_describe.get());
        }
        j = TroopUtils.getMsgSenderType(j);
        if (j == 1) {
          paramResources = paramStructMsg.msg.action_uin_nick.get();
        }
        for (;;)
        {
          paramResources = TroopUtils.getMsgInfo(paramStructMsg, paramResources + paramStructMsg.msg.msg_describe.get());
          break;
          if (j == 2) {
            paramResources = paramStructMsg.msg.req_uin_nick.get();
          }
        }
      }
      paramResources = String.format("%s %s", new Object[] { paramStructMsg.msg.req_uin_nick.get(), paramStructMsg.msg.msg_describe.get() });
    }
  }
  
  public static structmsg.StructMsg parseStructMsg(byte[] paramArrayOfByte)
  {
    structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
    try
    {
      localStructMsg.mergeFrom(paramArrayOfByte);
      return localStructMsg;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("MessageForSystemMsg", 2, paramArrayOfByte, new Object[0]);
    }
    return localStructMsg;
  }
  
  public void doParse()
  {
    this.structMsg = parseStructMsg(this.msgData);
  }
  
  public structmsg.StructMsg getSystemMsg()
  {
    if ((this.structMsg == null) && (!this.mIsParsed)) {
      parse();
    }
    return this.structMsg;
  }
  
  public void postRead() {}
  
  public void prewrite()
  {
    if (this.structMsg != null) {}
    try
    {
      this.msgData = this.structMsg.toByteArray();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.MessageForSystemMsg
 * JD-Core Version:    0.7.0.1
 */