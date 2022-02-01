package org.light.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic64Structure
  extends Elf.DynamicStructure
{
  public Dynamic64Structure(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramHeader.bigEndian) {
      paramHeader = ByteOrder.BIG_ENDIAN;
    } else {
      paramHeader = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(paramHeader);
    paramLong += paramInt * 16;
    this.tag = paramElfParser.readLong(localByteBuffer, paramLong);
    this.val = paramElfParser.readLong(localByteBuffer, paramLong + 8L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.relinker.elf.Dynamic64Structure
 * JD-Core Version:    0.7.0.1
 */