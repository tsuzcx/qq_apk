package com.tencent.plato.sdk.utils;

import android.os.Environment;
import android.util.Log;
import com.tencent.plato.core.utils.PLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils
{
  private static String LOG_FILE_NAME = "plato-log.txt";
  private static String PATH_SDCARD_DIR = "plato";
  private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  private static String getLogPath()
  {
    Object localObject = "";
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localObject = Environment.getExternalStorageDirectory();
      localObject = ((File)localObject).getAbsolutePath() + File.separator + PATH_SDCARD_DIR;
    }
    return localObject;
  }
  
  public static void writetoFile(String paramString1, String paramString2, String paramString3)
  {
    Date localDate = new Date();
    paramString1 = myLogSdf.format(localDate) + "  " + paramString1 + "  " + paramString2 + "  " + paramString3;
    paramString2 = getLogPath();
    if ((paramString2 != null) && (!"".equals(paramString2))) {}
    try
    {
      paramString3 = new File(paramString2);
      if (!paramString3.exists()) {
        paramString3.mkdir();
      }
      paramString2 = new FileWriter(new File(paramString2 + File.separator + LOG_FILE_NAME), true);
      paramString3 = new BufferedWriter(paramString2);
      paramString3.write(paramString1);
      paramString3.newLine();
      paramString3.close();
      paramString2.close();
      return;
    }
    catch (IOException paramString1)
    {
      PLog.e("LogUtils", "LogUtils write log error. " + Log.getStackTraceString(paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */