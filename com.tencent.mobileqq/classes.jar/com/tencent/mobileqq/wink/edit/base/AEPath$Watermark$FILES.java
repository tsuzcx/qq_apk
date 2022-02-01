package com.tencent.mobileqq.wink.edit.base;

import java.io.File;

public class AEPath$Watermark$FILES
{
  public static final String a;
  public static final String b;
  public static final String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.BASE.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("watermark");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("material_config");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("material_config_v2");
    c = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.base.AEPath.Watermark.FILES
 * JD-Core Version:    0.7.0.1
 */