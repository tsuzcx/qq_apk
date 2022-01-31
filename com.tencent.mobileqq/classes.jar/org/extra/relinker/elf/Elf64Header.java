package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Elf64Header
  extends Elf.Header
{
  private final ElfParser parser;
  
  public Elf64Header(boolean paramBoolean, ElfParser paramElfParser)
  {
    this.bigEndian = paramBoolean;
    this.parser = paramElfParser;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramElfParser.readHalf(localByteBuffer, 16L);
      this.phoff = paramElfParser.readLong(localByteBuffer, 32L);
      this.shoff = paramElfParser.readLong(localByteBuffer, 40L);
      this.phentsize = paramElfParser.readHalf(localByteBuffer, 54L);
      this.phnum = paramElfParser.readHalf(localByteBuffer, 56L);
      this.shentsize = paramElfParser.readHalf(localByteBuffer, 58L);
      this.shnum = paramElfParser.readHalf(localByteBuffer, 60L);
      this.shstrndx = paramElfParser.readHalf(localByteBuffer, 62L);
      return;
    }
  }
  
  public Elf.DynamicStructure getDynamicStructure(long paramLong, int paramInt)
  {
    return new Dynamic64Structure(this.parser, this, paramLong, paramInt);
  }
  
  public Elf.ProgramHeader getProgramHeader(long paramLong)
  {
    return new Program64Header(this.parser, this, paramLong);
  }
  
  public Elf.SectionHeader getSectionHeader(int paramInt)
  {
    return new Section64Header(this.parser, this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     org.extra.relinker.elf.Elf64Header
 * JD-Core Version:    0.7.0.1
 */