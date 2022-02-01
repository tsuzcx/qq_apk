package com.tencent.mobileqq.data;

import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class MessageForLongTextMsg
  extends MessageForText
{
  public boolean loading;
  public String mFileName = null;
  public long mFileSize = 0L;
  public String mResid = null;
  @RecordForTest
  public StructMsgForGeneralShare structingMsg;
  
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
    return MsgProxyUtils.m(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    super.postRead();
  }
  
  public void prewrite()
  {
    super.prewrite();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongTextMsg
 * JD-Core Version:    0.7.0.1
 */