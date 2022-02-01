package com.tencent.mobileqq.data;

import acnh;
import aoos;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class MessageForLongTextMsg
  extends MessageForText
{
  public boolean loading;
  public String mFileName;
  public long mFileSize;
  public String mResid;
  @aoos
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
    return acnh.x(this.istroop);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongTextMsg
 * JD-Core Version:    0.7.0.1
 */