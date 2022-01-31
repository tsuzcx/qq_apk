package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Program32Header
  extends Elf.ProgramHeader
{
  public Program32Header(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramHeader.bigEndian) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      paramLong = paramHeader.phoff + paramHeader.phentsize * paramLong;
      this.type = paramElfParser.readWord(localByteBuffer, paramLong);
      this.offset = paramElfParser.readWord(localByteBuffer, 4L + paramLong);
      this.vaddr = paramElfParser.readWord(localByteBuffer, 8L + paramLong);
      this.memsz = paramElfParser.readWord(localByteBuffer, paramLong + 20L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     org.extra.relinker.elf.Program32Header
 * JD-Core Version:    0.7.0.1
 */