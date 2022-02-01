package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

public class FileManagerReporterImpl
  implements IFileManagerReporter
{
  public void addData(String paramString)
  {
    FileManagerReporter.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileManagerReporterImpl
 * JD-Core Version:    0.7.0.1
 */