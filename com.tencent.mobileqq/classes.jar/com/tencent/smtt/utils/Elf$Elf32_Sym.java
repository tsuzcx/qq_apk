package com.tencent.smtt.utils;

class Elf$Elf32_Sym
  extends Elf.Elf_Sym
{
  int st_size;
  int st_value;
  
  long getSize()
  {
    return this.st_size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.Elf.Elf32_Sym
 * JD-Core Version:    0.7.0.1
 */