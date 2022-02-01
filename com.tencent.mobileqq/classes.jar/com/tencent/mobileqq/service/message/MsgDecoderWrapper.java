package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.MessageRecord;

public class MsgDecoderWrapper
{
  public final MessageRecord a;
  public final byte[] b;
  
  public MsgDecoderWrapper(MessageRecord paramMessageRecord, byte[] paramArrayOfByte)
  {
    this.a = paramMessageRecord;
    this.b = paramArrayOfByte;
  }
  
  static MsgDecoderWrapper a()
  {
    return new MsgDecoderWrapper(new MessageRecord(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MsgDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */