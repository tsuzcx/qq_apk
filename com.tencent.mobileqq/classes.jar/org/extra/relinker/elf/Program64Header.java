package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Program64Header
  extends Elf.ProgramHeader
{
  public Program64Header(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    ByteOrder localByteOrder;
    if (paramHeader.bigEndian) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    paramLong = paramHeader.phoff + paramLong * paramHeader.phentsize;
    this.type = paramElfParser.readWord(localByteBuffer, paramLong);
    this.offset = paramElfParser.readLong(localByteBuffer, 8L + paramLong);
    this.vaddr = paramElfParser.readLong(localByteBuffer, 16L + paramLong);
    this.memsz = paramElfParser.readLong(localByteBuffer, paramLong + 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.extra.relinker.elf.Program64Header
 * JD-Core Version:    0.7.0.1
 */