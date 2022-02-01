package com.tencent.mobileqq.util;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class SSODebugUtil
{
  public static String a;
  public static String b = "testserver";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/");
    a = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SSODebugUtil
 * JD-Core Version:    0.7.0.1
 */