package org.light.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Section64Header
  extends Elf.SectionHeader
{
  public Section64Header(ElfParser paramElfParser, Elf.Header paramHeader, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramHeader.bigEndian) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.info = paramElfParser.readWord(localByteBuffer, paramHeader.shoff + paramHeader.shentsize * paramInt + 44L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.relinker.elf.Section64Header
 * JD-Core Version:    0.7.0.1
 */