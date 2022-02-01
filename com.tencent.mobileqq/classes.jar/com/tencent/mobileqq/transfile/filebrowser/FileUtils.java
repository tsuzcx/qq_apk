package com.tencent.mobileqq.transfile.filebrowser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils
{
  public static final int FILE_COPY_RET_ILLEGEL_PARAMETER = 1;
  public static final int FILE_COPY_RET_IOEXCEPTION = 3;
  public static final int FILE_COPY_RET_OK = 0;
  public static final int FILE_COPY_RET_SOURCE_NOT_ESIXTED = 2;
  static final String TAG = "FileUtils";
  
  public static int copyFile(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0)) {
      if (!com.tencent.mobileqq.utils.FileUtils.fileExists(paramString1)) {
        return 2;
      }
    }
    try
    {
      paramString1 = new FileInputStream(paramString1);
    }
    catch (IOException paramString1)
    {
      byte[] arrayOfByte;
      label58:
      int i;
      label88:
      break label98;
    }
    try
    {
      paramString2 = new FileOutputStream(paramString2);
    }
    catch (IOException paramString2)
    {
      break label93;
    }
    try
    {
      arrayOfByte = new byte[1024];
      i = paramString1.read(arrayOfByte);
      if (i > 0)
      {
        paramString2.write(arrayOfByte, 0, i);
        break label58;
      }
      paramString1.close();
    }
    catch (IOException localIOException)
    {
      break label102;
    }
    try
    {
      paramString2.close();
      return 0;
    }
    catch (IOException paramString1)
    {
      break label88;
    }
    paramString1 = null;
    break label102;
    label93:
    paramString2 = null;
    break label102;
    label98:
    paramString2 = null;
    paramString1 = paramString2;
    label102:
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      if (paramString2 != null) {
        paramString2.close();
      }
    }
    catch (Exception paramString1)
    {
      label118:
      break label118;
    }
    return 3;
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.FileUtils
 * JD-Core Version:    0.7.0.1
 */