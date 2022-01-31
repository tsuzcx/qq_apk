package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class MessageForTroopPobing
  extends MessageForStructing
{
  public static final String TAG = "MessageForTroopPobing";
  public String mBrief;
  
  public static String buildCompatibleText()
  {
    return "大家好，我是新人请多关照";
  }
  
  public void doParse()
  {
    super.doParse();
    if (this.structingMsg != null)
    {
      this.mBrief = ((StructMsgForGeneralShare)this.structingMsg).mMsgBrief;
      this.msg = this.mBrief;
    }
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msg)) {
      return "新人入群";
    }
    return this.msg;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForTroopPobing{");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopPobing
 * JD-Core Version:    0.7.0.1
 */