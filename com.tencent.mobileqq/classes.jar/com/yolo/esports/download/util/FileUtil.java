package com.yolo.esports.download.util;

import android.os.Environment;
import java.io.File;

public class FileUtil
{
  public static boolean a()
  {
    return ("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite());
  }
  
  public static boolean a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool2 = paramString.isDirectory();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramString = paramString.listFiles();
    if ((paramString == null) || (paramString.length == 0)) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */