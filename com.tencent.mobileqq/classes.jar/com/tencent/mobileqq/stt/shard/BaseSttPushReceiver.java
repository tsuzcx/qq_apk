package com.tencent.mobileqq.stt.shard;

import java.nio.ByteBuffer;

public abstract class BaseSttPushReceiver
{
  protected volatile AIOSttResult a;
  
  protected BaseSttPushReceiver(AIOSttResult paramAIOSttResult)
  {
    this.a = paramAIOSttResult;
  }
  
  protected BaseSttPushReceiver.SttPushPacket a(BaseSttPushReceiver.SttPushPacket paramSttPushPacket, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    BaseSttPushReceiver.SttPushPacket localSttPushPacket = paramSttPushPacket;
    if (paramSttPushPacket == null) {
      localSttPushPacket = new BaseSttPushReceiver.SttPushPacket();
    }
    if (localSttPushPacket.jdField_a_of_type_JavaNioByteBuffer == null) {
      localSttPushPacket.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt3);
    }
    if (paramInt2 >= paramInt3)
    {
      localSttPushPacket.jdField_a_of_type_Boolean = true;
      localSttPushPacket.jdField_a_of_type_JavaNioByteBuffer.position(0);
      localSttPushPacket.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte);
      localSttPushPacket.b = paramInt2;
      return localSttPushPacket;
    }
    long l1 = localSttPushPacket.jdField_a_of_type_Long;
    long l2 = paramInt4;
    if (0L == (l1 & l2))
    {
      localSttPushPacket.jdField_a_of_type_JavaNioByteBuffer.position(paramInt1);
      localSttPushPacket.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte);
      localSttPushPacket.b += paramInt2;
      localSttPushPacket.jdField_a_of_type_Long |= l2;
      if (localSttPushPacket.b >= paramInt3) {
        localSttPushPacket.jdField_a_of_type_Boolean = true;
      }
    }
    return localSttPushPacket;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.shard.BaseSttPushReceiver
 * JD-Core Version:    0.7.0.1
 */