package com.tencent.mobileqq.msf.core.net.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class d
  implements FilenameFilter
{
  d(MsfCmdConfig.b paramb, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return Pattern.compile(this.a).matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.d
 * JD-Core Version:    0.7.0.1
 */