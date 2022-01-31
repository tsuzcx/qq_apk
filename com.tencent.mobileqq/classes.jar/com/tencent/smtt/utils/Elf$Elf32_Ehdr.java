package com.tencent.smtt.utils;

class Elf$Elf32_Ehdr
  extends Elf.Ehdr
{
  int e_entry;
  int e_phoff;
  int e_shoff;
  
  long getProgramOffset()
  {
    return this.e_phoff;
  }
  
  long getSectionOffset()
  {
    return this.e_shoff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.Elf.Elf32_Ehdr
 * JD-Core Version:    0.7.0.1
 */