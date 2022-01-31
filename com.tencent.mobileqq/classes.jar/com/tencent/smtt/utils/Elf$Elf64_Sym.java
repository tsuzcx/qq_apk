package com.tencent.smtt.utils;

class Elf$Elf64_Sym
  extends Elf.Elf_Sym
{
  long st_size;
  long st_value;
  
  long getSize()
  {
    return this.st_size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.Elf.Elf64_Sym
 * JD-Core Version:    0.7.0.1
 */