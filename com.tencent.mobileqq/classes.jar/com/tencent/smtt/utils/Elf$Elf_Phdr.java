package com.tencent.smtt.utils;

abstract class Elf$Elf_Phdr
{
  int p_offset;
  int p_type;
  
  String flagsString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("(");
    if ((getFlags() & 0x4) != 0L)
    {
      str = "R";
      localStringBuilder = localStringBuilder.append(str);
      if ((getFlags() & 0x2) == 0L) {
        break label91;
      }
      str = "W";
      label51:
      localStringBuilder = localStringBuilder.append(str);
      if ((getFlags() & 1L) == 0L) {
        break label97;
      }
    }
    label91:
    label97:
    for (String str = "X";; str = "_")
    {
      return str + ")";
      str = "_";
      break;
      str = "_";
      break label51;
    }
  }
  
  abstract long getFlags();
  
  String programType()
  {
    switch (this.p_type)
    {
    default: 
      return "Unknown Section";
    case 0: 
      return "NULL";
    case 1: 
      return "Loadable Segment";
    case 2: 
      return "Dynamic Segment";
    case 3: 
      return "Interpreter Path";
    case 4: 
      return "Note";
    case 5: 
      return "PT_SHLIB";
    }
    return "Program Header";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.Elf.Elf_Phdr
 * JD-Core Version:    0.7.0.1
 */