package com.tencent.tbs.one.impl.loader.dex;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf.Elf64_Sym
 * JD-Core Version:    0.7.0.1
 */