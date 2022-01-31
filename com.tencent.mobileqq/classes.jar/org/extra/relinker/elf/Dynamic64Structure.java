package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic64Structure
  extends Elf.DynamicStructure
{
  public Dynamic64Structure(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramHeader.bigEndian) {}
    for (paramHeader = ByteOrder.BIG_ENDIAN;; paramHeader = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(paramHeader);
      paramLong = paramInt * 16 + paramLong;
      this.tag = paramElfParser.readLong(localByteBuffer, paramLong);
      this.val = paramElfParser.readLong(localByteBuffer, paramLong + 8L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.extra.relinker.elf.Dynamic64Structure
 * JD-Core Version:    0.7.0.1
 */