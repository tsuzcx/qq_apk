package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class MessageForLongTextMsg
  extends MessageForText
{
  public boolean loading;
  public String mFileName;
  public long mFileSize;
  public String mResid;
  public AbsStructMsg structingMsg;
  
  protected void doParse()
  {
    doParse(false);
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.v(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    super.postRead();
  }
  
  protected void prewrite()
  {
    super.prewrite();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongTextMsg
 * JD-Core Version:    0.7.0.1
 */