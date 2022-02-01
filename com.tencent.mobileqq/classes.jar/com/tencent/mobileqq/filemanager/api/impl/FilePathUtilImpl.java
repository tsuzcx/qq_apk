package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.filemanager.util.QQFilePathUtil;

public class FilePathUtilImpl
  implements IFilePathUtil
{
  public String copyImageFileToMediaStorage(String paramString)
  {
    return QQFilePathUtil.b(paramString);
  }
  
  public boolean fileExistsAndNotEmpty(String paramString)
  {
    return QQFilePathUtil.a(paramString);
  }
  
  public String getRealPath(String paramString)
  {
    return QQFilePathUtil.c(paramString);
  }
  
  public String renameImageFileToMediaStorage(String paramString)
  {
    return QQFilePathUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FilePathUtilImpl
 * JD-Core Version:    0.7.0.1
 */