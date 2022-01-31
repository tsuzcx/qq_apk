package com.tencent.smtt.utils;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.Elf.Elf64_Ehdr
 * JD-Core Version:    0.7.0.1
 */