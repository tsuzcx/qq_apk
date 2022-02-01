package com.tencent.tbs.one.impl.loader.dex;

class Elf$Elf64_Ehdr
  extends Elf.Ehdr
{
  long e_entry;
  long e_phoff;
  long e_shoff;
  
  long getProgramOffset()
  {
    return this.e_phoff;
  }
  
  long getSectionOffset()
  {
    return this.e_shoff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf.Elf64_Ehdr
 * JD-Core Version:    0.7.0.1
 */