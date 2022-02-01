package org.extra.relinker.elf;

public abstract class Elf$Header
{
  public static final int ELFCLASS32 = 1;
  public static final int ELFCLASS64 = 2;
  public static final int ELFDATA2MSB = 2;
  public boolean bigEndian;
  public int phentsize;
  public int phnum;
  public long phoff;
  public int shentsize;
  public int shnum;
  public long shoff;
  public int shstrndx;
  public int type;
  
  public abstract Elf.DynamicStructure getDynamicStructure(long paramLong, int paramInt);
  
  public abstract Elf.ProgramHeader getProgramHeader(long paramLong);
  
  public abstract Elf.SectionHeader getSectionHeader(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.extra.relinker.elf.Elf.Header
 * JD-Core Version:    0.7.0.1
 */