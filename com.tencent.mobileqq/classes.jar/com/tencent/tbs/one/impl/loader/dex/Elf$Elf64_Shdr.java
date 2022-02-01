package com.tencent.tbs.one.impl.loader.dex;

class Elf$Elf64_Shdr
  extends Elf.Elf_Shdr
{
  long sh_addr;
  long sh_addralign;
  long sh_entsize;
  long sh_flags;
  long sh_offset;
  long sh_size;
  
  public long getOffset()
  {
    return this.sh_offset;
  }
  
  public int getSize()
  {
    return (int)this.sh_size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf.Elf64_Shdr
 * JD-Core Version:    0.7.0.1
 */