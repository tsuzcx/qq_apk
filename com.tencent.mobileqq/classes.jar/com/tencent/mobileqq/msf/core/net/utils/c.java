package com.tencent.mobileqq.msf.core.net.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class c
  implements FilenameFilter
{
  c(MsfCmdConfig.b paramb, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return Pattern.compile(this.a).matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.c
 * JD-Core Version:    0.7.0.1
 */