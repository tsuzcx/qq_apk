package com.tencent.proxyinner.utility;

import android.content.Context;
import android.os.Environment;
import com.tencent.proxyinner.log.XLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.util.EncodingUtils;

public class UtilFile
{
  public static boolean copyFile(String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      if (new File(paramString1).exists())
      {
        paramString1 = new FileInputStream(paramString1);
        paramString2 = new FileOutputStream(paramString2);
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int j = paramString1.read(arrayOfByte);
          if (j == -1) {
            break;
          }
          i += j;
          System.out.println(i);
          paramString2.write(arrayOfByte, 0, j);
        }
        paramString1.close();
      }
    }
    catch (Exception paramString1)
    {
      System.out.println("复制单个文件操作出错");
      paramString1.printStackTrace();
      return false;
    }
    return true;
  }
  
  public static void deleteDir(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    label22:
    if (i < arrayOfFile.length)
    {
      if ((arrayOfFile[i] == null) || (!arrayOfFile[i].isFile())) {
        break label57;
      }
      arrayOfFile[i].delete();
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label57:
      if ((arrayOfFile[i] != null) && (arrayOfFile[i].isDirectory())) {
        deleteDir(arrayOfFile[i]);
      }
    }
  }
  
  private static void deleteFoler(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        deleteFoler(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  public static File getEarliestFile(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      paramFile = null;
    }
    Object localObject2;
    long l1;
    File[] arrayOfFile;
    do
    {
      do
      {
        return paramFile;
        localObject2 = null;
        localObject1 = null;
        l1 = 9223372036854775807L;
        arrayOfFile = paramFile.listFiles();
        paramFile = (File)localObject1;
      } while (arrayOfFile == null);
      paramFile = (File)localObject1;
    } while (arrayOfFile.length <= 0);
    int j = arrayOfFile.length;
    int i = 0;
    Object localObject1 = localObject2;
    for (;;)
    {
      paramFile = (File)localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = arrayOfFile[i];
      paramFile = (File)localObject1;
      long l2 = l1;
      if (localObject2 != null)
      {
        paramFile = (File)localObject1;
        l2 = l1;
        if (localObject2.exists())
        {
          long l3 = localObject2.lastModified();
          paramFile = (File)localObject1;
          l2 = l1;
          if (l3 < l1)
          {
            l2 = l3;
            paramFile = localObject2;
          }
        }
      }
      i += 1;
      localObject1 = paramFile;
      l1 = l2;
    }
  }
  
  public static int getFileCount(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return 0;
      paramFile = paramFile.listFiles();
    } while (paramFile == null);
    return paramFile.length;
  }
  
  public static long getFileSize(File paramFile)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramFile != null)
    {
      l1 = l2;
      if (paramFile.exists())
      {
        if (paramFile.isDirectory()) {
          break label34;
        }
        l1 = paramFile.length();
      }
    }
    label34:
    do
    {
      do
      {
        return l1;
        paramFile = paramFile.listFiles();
        l1 = l2;
      } while (paramFile == null);
      l1 = l2;
    } while (paramFile.length <= 0);
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      l1 = l2;
      if (i >= j) {
        break;
      }
      l2 += getFileSize(paramFile[i]);
      i += 1;
    }
  }
  
  public static String getPluginRootDir(Context paramContext, String paramString)
  {
    paramContext = paramContext.getDir("SixGodPlugin", 0).getAbsolutePath() + File.separator + paramString + File.separator;
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  public static String getPluginSecondaryDexesPath(Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = new File(getPluginSecondaryDexesRoot(paramContext, paramString) + File.separator + paramInt);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramContext = paramContext.listFiles();
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = paramContext[paramInt];
      if ((paramString.getName().endsWith(".dex")) && (valideDexfile(paramString.getName()))) {
        localStringBuilder.append(paramString.getAbsolutePath()).append(File.pathSeparator);
      }
      paramInt += 1;
    }
    if (localStringBuilder.toString().endsWith(File.pathSeparator)) {
      localStringBuilder.delete(localStringBuilder.toString().length() - 1, localStringBuilder.toString().length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public static String getPluginSecondaryDexesRoot(Context paramContext, String paramString)
  {
    paramContext = getPluginRootDir(paramContext, paramString) + File.separator + "multi_dexes";
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  public static String getSixgodPluginRootDir(Context paramContext)
  {
    paramContext = paramContext.getDir("SixGodPlugin", 0).getAbsolutePath() + File.separator;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  public static String readSDCardFile(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + paramString);
      str1 = str2;
      paramString = new byte[localFileInputStream.available()];
      str1 = str2;
      localFileInputStream.read(paramString);
      str1 = str2;
      paramString = EncodingUtils.getString(paramString, "UTF-8");
      str1 = paramString;
      localFileInputStream.close();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return str1;
  }
  
  public static boolean valideDexfile(String paramString)
  {
    return Pattern.compile("classes[\\d]+\\.dex").matcher(paramString).matches();
  }
  
  public static void writeTextToFile(String paramString1, String paramString2)
  {
    paramString2 = "sdcard/" + paramString2;
    try
    {
      paramString2 = new FileOutputStream(paramString2);
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramString2);
      localOutputStreamWriter.write(paramString1);
      localOutputStreamWriter.flush();
      paramString2.close();
      return;
    }
    catch (Exception paramString1)
    {
      XLog.i("UtilFile", "写Json数据失败 ");
    }
  }
  
  public void copyFolder(String paramString1, String paramString2)
  {
    for (;;)
    {
      String[] arrayOfString;
      int i;
      FileInputStream localFileInputStream;
      FileOutputStream localFileOutputStream;
      try
      {
        new File(paramString2).mkdirs();
        arrayOfString = new File(paramString1).list();
        i = 0;
        if (i < arrayOfString.length)
        {
          if (paramString1.endsWith(File.separator))
          {
            localFile = new File(paramString1 + arrayOfString[i]);
            if (!localFile.isFile()) {
              break label235;
            }
            localFileInputStream = new FileInputStream(localFile);
            localFileOutputStream = new FileOutputStream(paramString2 + "/" + localFile.getName().toString());
            byte[] arrayOfByte = new byte[5120];
            int j = localFileInputStream.read(arrayOfByte);
            if (j == -1) {
              break label220;
            }
            localFileOutputStream.write(arrayOfByte, 0, j);
            continue;
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramString1)
      {
        System.out.println("复制整个文件夹内容操作出错");
        paramString1.printStackTrace();
      }
      File localFile = new File(paramString1 + File.separator + arrayOfString[i]);
      continue;
      label220:
      localFileOutputStream.flush();
      localFileOutputStream.close();
      localFileInputStream.close();
      label235:
      if (localFile.isDirectory()) {
        copyFolder(paramString1 + "/" + arrayOfString[i], paramString2 + "/" + arrayOfString[i]);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.UtilFile
 * JD-Core Version:    0.7.0.1
 */