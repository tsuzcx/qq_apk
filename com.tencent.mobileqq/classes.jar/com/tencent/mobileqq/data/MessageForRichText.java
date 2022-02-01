package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.message.RecordForTest;
import tencent.im.msg.im_msg_body.RichText;

public abstract class MessageForRichText
  extends ChatMessage
{
  @RecordForTest
  public im_msg_body.RichText richText = null;
  
  public void prewriteForMsgbackup()
  {
    prewrite();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForRichText
 * JD-Core Version:    0.7.0.1
 */