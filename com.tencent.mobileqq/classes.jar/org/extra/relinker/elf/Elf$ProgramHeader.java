package org.extra.relinker.elf;

public abstract class Elf$ProgramHeader
{
  public static final int PT_DYNAMIC = 2;
  public static final int PT_LOAD = 1;
  public long memsz;
  public long offset;
  public long type;
  public long vaddr;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.extra.relinker.elf.Elf.ProgramHeader
 * JD-Core Version:    0.7.0.1
 */