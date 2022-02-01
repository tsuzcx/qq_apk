package org.light.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic32Structure
  extends Elf.DynamicStructure
{
  public Dynamic32Structure(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramHeader.bigEndian) {
      paramHeader = ByteOrder.BIG_ENDIAN;
    } else {
      paramHeader = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(paramHeader);
    paramLong += paramInt * 8;
    this.tag = paramElfParser.readWord(localByteBuffer, paramLong);
    this.val = paramElfParser.readWord(localByteBuffer, paramLong + 4L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.relinker.elf.Dynamic32Structure
 * JD-Core Version:    0.7.0.1
 */