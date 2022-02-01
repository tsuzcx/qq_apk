package com.tencent.tbs.one.impl.loader.dex;

abstract class Elf$Elf_Sym
{
  char st_info;
  int st_name;
  char st_other;
  short st_shndx;
  
  char getBinding()
  {
    return (char)(this.st_info >> '\004');
  }
  
  abstract long getSize();
  
  char getType()
  {
    return (char)(this.st_info & 0xF);
  }
  
  void setBinding(char paramChar)
  {
    setBindingAndType(paramChar, getType());
  }
  
  void setBindingAndType(char paramChar1, char paramChar2)
  {
    this.st_info = ((char)((paramChar1 << '\004') + (paramChar2 & 0xF)));
  }
  
  void setType(char paramChar)
  {
    setBindingAndType(getBinding(), paramChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf.Elf_Sym
 * JD-Core Version:    0.7.0.1
 */