package com.tencent.tbs.one.impl.loader.dex;

public abstract class Elf$Ehdr
{
  short e_ehsize;
  int e_flags;
  short e_machine;
  short e_phentsize;
  short e_phnum;
  short e_shentsize;
  short e_shnum;
  short e_shstrndx;
  short e_type;
  int e_version;
  
  abstract long getProgramOffset();
  
  abstract long getSectionOffset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf.Ehdr
 * JD-Core Version:    0.7.0.1
 */