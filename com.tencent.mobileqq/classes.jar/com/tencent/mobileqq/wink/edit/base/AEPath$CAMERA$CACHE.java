package com.tencent.mobileqq.wink.edit.base;

import java.io.File;

public class AEPath$CAMERA$CACHE
{
  public static final String a;
  public static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.BASE.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("camera");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("photo_compress");
    b = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.base.AEPath.CAMERA.CACHE
 * JD-Core Version:    0.7.0.1
 */