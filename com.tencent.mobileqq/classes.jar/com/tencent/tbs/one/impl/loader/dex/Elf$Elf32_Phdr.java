package com.tencent.tbs.one.impl.loader.dex;

class Elf$Elf32_Phdr
  extends Elf.Elf_Phdr
{
  int p_align;
  int p_filesz;
  int p_flags;
  int p_memsz;
  int p_paddr;
  int p_vaddr;
  
  public long getFlags()
  {
    return this.p_flags;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf.Elf32_Phdr
 * JD-Core Version:    0.7.0.1
 */