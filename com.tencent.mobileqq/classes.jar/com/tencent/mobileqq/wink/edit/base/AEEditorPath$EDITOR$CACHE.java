package com.tencent.mobileqq.wink.edit.base;

import java.io.File;

public class AEEditorPath$EDITOR$CACHE
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.BASE.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("compress");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("bgm");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("comic");
    d = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.base.AEEditorPath.EDITOR.CACHE
 * JD-Core Version:    0.7.0.1
 */