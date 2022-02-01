package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageRecord;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface UpCallBack
{
  public abstract MessageRecord a(im_msg_body.RichText paramRichText);
  
  public abstract void a(UpCallBack.SendResult paramSendResult);
  
  public abstract void b(UpCallBack.SendResult paramSendResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.UpCallBack
 * JD-Core Version:    0.7.0.1
 */