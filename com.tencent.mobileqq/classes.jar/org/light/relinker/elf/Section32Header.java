package org.light.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Section32Header
  extends Elf.SectionHeader
{
  public Section32Header(ElfParser paramElfParser, Elf.Header paramHeader, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    ByteOrder localByteOrder;
    if (paramHeader.bigEndian) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.info = paramElfParser.readWord(localByteBuffer, paramHeader.shoff + paramInt * paramHeader.shentsize + 28L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.relinker.elf.Section32Header
 * JD-Core Version:    0.7.0.1
 */