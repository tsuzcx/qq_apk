package com.tencent.mobileqq.msf.core.net.utils;

import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class d
  implements FilenameFilter
{
  d(MsfCmdConfig.c paramc, Pair paramPair) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.endsWith(".xml")) {
        return false;
      }
      return Pattern.compile((String)this.a.first).matcher(paramString.substring(0, paramString.length() - 4)).matches();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.d
 * JD-Core Version:    0.7.0.1
 */