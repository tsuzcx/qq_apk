package com.tencent.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ThrowablesUtils
{
  public static String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.util.ThrowablesUtils
 * JD-Core Version:    0.7.0.1
 */