package com.tencent.qqprotect.common;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QPDirUtils
{
  public static String a()
  {
    return BaseApplication.getContext().getDir("qqprotect", 0).toString();
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qseclibs");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.QPDirUtils
 * JD-Core Version:    0.7.0.1
 */