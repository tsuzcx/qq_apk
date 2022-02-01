package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.MessageRecord;

public class MsgDecoderWrapper
{
  public final MessageRecord a;
  public final byte[] a;
  
  public MsgDecoderWrapper(MessageRecord paramMessageRecord, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  static MsgDecoderWrapper a()
  {
    return new MsgDecoderWrapper(new MessageRecord(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MsgDecoderWrapper
 * JD-Core Version:    0.7.0.1
 */