package com.tencent.smtt.utils;

class Elf$Elf64_Phdr
  extends Elf.Elf_Phdr
{
  long p_align;
  long p_filesz;
  long p_flags;
  long p_memsz;
  long p_paddr;
  long p_vaddr;
  
  public long getFlags()
  {
    return this.p_flags;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.Elf.Elf64_Phdr
 * JD-Core Version:    0.7.0.1
 */