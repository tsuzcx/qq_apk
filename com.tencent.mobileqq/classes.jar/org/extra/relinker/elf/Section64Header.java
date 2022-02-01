package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Section64Header
  extends Elf.SectionHeader
{
  public Section64Header(ElfParser paramElfParser, Elf.Header paramHeader, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    ByteOrder localByteOrder;
    if (paramHeader.bigEndian) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.info = paramElfParser.readWord(localByteBuffer, paramHeader.shoff + paramInt * paramHeader.shentsize + 44L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.extra.relinker.elf.Section64Header
 * JD-Core Version:    0.7.0.1
 */