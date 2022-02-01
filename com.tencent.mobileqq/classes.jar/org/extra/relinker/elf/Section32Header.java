package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Section32Header
  extends Elf.SectionHeader
{
  public Section32Header(ElfParser paramElfParser, Elf.Header paramHeader, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramHeader.bigEndian) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.info = paramElfParser.readWord(localByteBuffer, paramHeader.shoff + paramHeader.shentsize * paramInt + 28L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.extra.relinker.elf.Section32Header
 * JD-Core Version:    0.7.0.1
 */