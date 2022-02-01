package com.tencent.qphone.base.util;

import java.io.File;

public class QLog$LogFile
  extends File
{
  public String stuffix = "";
  
  public QLog$LogFile(File paramFile, String paramString)
  {
    super(paramFile, paramString);
  }
  
  public QLog$LogFile(String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog.LogFile
 * JD-Core Version:    0.7.0.1
 */