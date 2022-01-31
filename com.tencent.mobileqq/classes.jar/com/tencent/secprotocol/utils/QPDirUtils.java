package com.tencent.secprotocol.utils;

import android.content.Context;
import java.io.File;

public class QPDirUtils
{
  private static final String QQPROTECT_DIR = "qqprotect";
  private static final String QQPROTECT_QSEC_LIBS_DIR = ".poxy_libs";
  
  public static String getQQProtectDir(Context paramContext)
  {
    return paramContext.getDir("qqprotect", 0).toString();
  }
  
  public static String getQQProtectQSecLibsDir(Context paramContext)
  {
    return getQQProtectDir(paramContext) + File.separator + ".poxy_libs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.secprotocol.utils.QPDirUtils
 * JD-Core Version:    0.7.0.1
 */