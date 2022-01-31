package com.tencent.mobileqq.systemmsg;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.mobileim.structmsg.structmsg.StructMsg;

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
  
  protected void doParse()
  {
    try
    {
      this.structMsg = new structmsg.StructMsg();
      this.structMsg.mergeFrom(this.msgData);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.MessageForSystemMsg
 * JD-Core Version:    0.7.0.1
 */