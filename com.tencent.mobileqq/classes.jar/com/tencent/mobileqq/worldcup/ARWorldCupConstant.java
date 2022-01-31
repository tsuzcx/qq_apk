package com.tencent.mobileqq.worldcup;

import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public final class ARWorldCupConstant
{
  public static String a;
  public static String b;
  public static String c;
  
  static
  {
    File localFile = new File(AppConstants.aJ, "worldcup");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    a = localFile.getAbsolutePath();
    localFile = new File(localFile.getAbsolutePath(), "cover_video");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    b = localFile.getAbsolutePath();
    localFile = new File(a, "record");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    c = localFile.getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupConstant
 * JD-Core Version:    0.7.0.1
 */