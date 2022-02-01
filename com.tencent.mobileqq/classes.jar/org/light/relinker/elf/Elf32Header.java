package org.light.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Elf32Header
  extends Elf.Header
{
  private final ElfParser parser;
  
  public Elf32Header(boolean paramBoolean, ElfParser paramElfParser)
  {
    this.bigEndian = paramBoolean;
    this.parser = paramElfParser;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramBoolean) {}
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN;; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      this.type = paramElfParser.readHalf(localByteBuffer, 16L);
      this.phoff = paramElfParser.readWord(localByteBuffer, 28L);
      this.shoff = paramElfParser.readWord(localByteBuffer, 32L);
      this.phentsize = paramElfParser.readHalf(localByteBuffer, 42L);
      this.phnum = paramElfParser.readHalf(localByteBuffer, 44L);
      this.shentsize = paramElfParser.readHalf(localByteBuffer, 46L);
      this.shnum = paramElfParser.readHalf(localByteBuffer, 48L);
      this.shstrndx = paramElfParser.readHalf(localByteBuffer, 50L);
      return;
    }
  }
  
  public Elf.DynamicStructure getDynamicStructure(long paramLong, int paramInt)
  {
    return new Dynamic32Structure(this.parser, this, paramLong, paramInt);
  }
  
  public Elf.ProgramHeader getProgramHeader(long paramLong)
  {
    return new Program32Header(this.parser, this, paramLong);
  }
  
  public Elf.SectionHeader getSectionHeader(int paramInt)
  {
    return new Section32Header(this.parser, this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.relinker.elf.Elf32Header
 * JD-Core Version:    0.7.0.1
 */