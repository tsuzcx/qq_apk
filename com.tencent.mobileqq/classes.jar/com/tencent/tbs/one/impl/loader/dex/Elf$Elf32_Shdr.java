package com.tencent.tbs.one.impl.loader.dex;

class Elf$Elf32_Shdr
  extends Elf.Elf_Shdr
{
  int sh_addr;
  int sh_addralign;
  int sh_entsize;
  int sh_flags;
  int sh_offset;
  int sh_size;
  
  public long getOffset()
  {
    return this.sh_offset;
  }
  
  public int getSize()
  {
    return this.sh_size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf.Elf32_Shdr
 * JD-Core Version:    0.7.0.1
 */