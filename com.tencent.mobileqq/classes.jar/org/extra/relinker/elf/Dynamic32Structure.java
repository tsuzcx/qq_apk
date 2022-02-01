package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic32Structure
  extends Elf.DynamicStructure
{
  public Dynamic32Structure(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramHeader.bigEndian) {}
    for (paramHeader = ByteOrder.BIG_ENDIAN;; paramHeader = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(paramHeader);
      paramLong = paramInt * 8 + paramLong;
      this.tag = paramElfParser.readWord(localByteBuffer, paramLong);
      this.val = paramElfParser.readWord(localByteBuffer, paramLong + 4L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.extra.relinker.elf.Dynamic32Structure
 * JD-Core Version:    0.7.0.1
 */