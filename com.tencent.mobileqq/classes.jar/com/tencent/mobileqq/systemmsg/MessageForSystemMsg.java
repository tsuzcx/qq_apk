package com.tencent.mobileqq.systemmsg;

import android.content.res.Resources;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class MessageForSystemMsg
  extends ChatMessage
{
  public static final int SYSMSG_MENU_FLAG_DEFAULT = 0;
  public static final int SYSMSG_MENU_FLAG_DEL = 1;
  public static final int SYSMSG_MENU_FLAG_MASK_DEL = 15;
  public static final String TAG = "MessageForSystemMsg";
  public int mSysmsgMenuFlag = 0;
  public structmsg.StructMsg structMsg = null;
  
  public MessageForSystemMsg()
  {
    this.mSysmsgMenuFlag |= 0x1;
  }
  
  public static String getSysMsgDesc(Resources paramResources, structmsg.StructMsg paramStructMsg)
  {
    Object localObject = "";
    if (paramStructMsg != null)
    {
      if (paramResources == null) {
        return "";
      }
      int i = paramStructMsg.msg_type.get();
      int j;
      if (i == 1)
      {
        j = paramStructMsg.msg.sub_type.get();
        if (j != 1)
        {
          if (j != 4)
          {
            if (j != 5)
            {
              if (j != 6) {
                paramResources = paramStructMsg.msg.msg_describe.get();
              } else {
                paramResources = paramResources.getString(2131718177);
              }
            }
            else {
              paramResources = paramResources.getString(2131689525);
            }
          }
          else {
            paramResources = paramResources.getString(2131689526);
          }
        }
        else {
          paramResources = paramResources.getString(2131689622);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramStructMsg.msg.req_uin_nick.get());
        ((StringBuilder)localObject).append(paramResources);
        localObject = ((StringBuilder)localObject).toString();
        paramResources = (Resources)localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("MessageForSystemMsg", 2, String.format("getSysMsgDesc, msg: %s, sub: %s, desc: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramStructMsg.msg.sub_type.get()), paramStructMsg.msg.msg_describe.get() }));
          paramResources = (Resources)localObject;
        }
      }
      else if (i == 2)
      {
        j = paramStructMsg.msg.group_msg_type.get();
        if (QLog.isColorLevel())
        {
          paramResources = new StringBuilder();
          paramResources.append("groupMsgType:");
          paramResources.append(j);
          paramResources.append("|req_uin_nick:");
          paramResources.append(paramStructMsg.msg.req_uin_nick.get());
          paramResources.append("|actor_uin_nick:");
          paramResources.append(paramStructMsg.msg.actor_uin_nick.get());
          paramResources.append("|action_uin_nick:");
          paramResources.append(paramStructMsg.msg.action_uin_nick.get());
          paramResources.append("|msg_describe:");
          paramResources.append(paramStructMsg.msg.msg_describe.get());
          QLog.d("MessageForSystemMsg", 2, paramResources.toString());
        }
        j = TroopSystemMsgUtils.a(j);
        if (j == 1)
        {
          paramResources = paramStructMsg.msg.action_uin_nick.get();
        }
        else
        {
          paramResources = (Resources)localObject;
          if (j == 2) {
            paramResources = paramStructMsg.msg.req_uin_nick.get();
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramResources);
        ((StringBuilder)localObject).append(paramStructMsg.msg.msg_describe.get());
        paramResources = TroopSystemMsgUtils.a(paramStructMsg, ((StringBuilder)localObject).toString());
      }
      else
      {
        paramResources = String.format("%s %s", new Object[] { paramStructMsg.msg.req_uin_nick.get(), paramStructMsg.msg.msg_describe.get() });
      }
      if (QLog.isColorLevel()) {
        QLog.i("MessageForSystemMsg", 2, String.format("getSysMsgDesc, msg: %s, suffix: %s", new Object[] { Integer.valueOf(i), paramResources }));
      }
      return paramResources;
    }
    return "";
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
  
  protected void doParse()
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
  
  protected void postRead() {}
  
  protected void prewrite()
  {
    structmsg.StructMsg localStructMsg = this.structMsg;
    if (localStructMsg != null) {
      try
      {
        this.msgData = localStructMsg.toByteArray();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.MessageForSystemMsg
 * JD-Core Version:    0.7.0.1
 */