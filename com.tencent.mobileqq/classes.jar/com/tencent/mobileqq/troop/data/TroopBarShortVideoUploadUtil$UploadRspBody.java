package com.tencent.mobileqq.troop.data;

import java.nio.ByteBuffer;

class TroopBarShortVideoUploadUtil$UploadRspBody
{
  public final int a;
  public final long a;
  public final long b;
  
  public TroopBarShortVideoUploadUtil$UploadRspBody(ByteBuffer paramByteBuffer)
  {
    this.jdField_a_of_type_Int = (paramByteBuffer.get() & 0xFFFF);
    this.jdField_a_of_type_Long = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.b = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.UploadRspBody
 * JD-Core Version:    0.7.0.1
 */