package com.tencent.smtt.utils;

public abstract class Elf$Elf_Shdr
{
  int sh_info;
  int sh_link;
  int sh_name;
  int sh_type;
  
  public abstract long getOffset();
  
  public abstract int getSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.Elf.Elf_Shdr
 * JD-Core Version:    0.7.0.1
 */