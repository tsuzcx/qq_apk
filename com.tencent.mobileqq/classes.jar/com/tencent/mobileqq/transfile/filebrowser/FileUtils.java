package com.tencent.mobileqq.transfile.filebrowser;

import com.tencent.mobileqq.filemanager.util.FileUtil;
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
    Object localObject = null;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return 1;
    }
    if (!FileUtil.a(paramString1)) {
      return 2;
    }
    for (;;)
    {
      try
      {
        paramString1 = new FileInputStream(paramString1);
      }
      catch (IOException paramString1)
      {
        paramString1 = null;
        paramString2 = str;
        continue;
      }
      try
      {
        paramString2 = new FileOutputStream(paramString2);
        try
        {
          byte[] arrayOfByte = new byte[1024];
          int i = paramString1.read(arrayOfByte);
          if (i > 0)
          {
            paramString2.write(arrayOfByte, 0, i);
            continue;
            if (paramString2 == null) {}
          }
        }
        catch (IOException localIOException)
        {
          str = paramString2;
          paramString2 = paramString1;
          paramString1 = str;
        }
      }
      catch (IOException paramString2)
      {
        str = null;
        paramString2 = paramString1;
        paramString1 = str;
        continue;
      }
      try
      {
        paramString2.close();
        if (paramString1 != null) {
          paramString1.close();
        }
      }
      catch (Exception paramString1)
      {
        continue;
      }
      return 3;
      paramString1.close();
      try
      {
        paramString2.close();
        return 0;
      }
      catch (IOException paramString1)
      {
        paramString1 = paramString2;
        paramString2 = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.FileUtils
 * JD-Core Version:    0.7.0.1
 */