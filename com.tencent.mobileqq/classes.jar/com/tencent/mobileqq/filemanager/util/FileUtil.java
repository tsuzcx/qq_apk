package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileUtil
{
  public static long a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return 0L;
        try
        {
          paramString = new File(paramString);
          if ((paramString != null) && (paramString.exists()) && (paramString.length() > 0L))
          {
            long l = paramString.length();
            return l;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileUtils", 2, FileManagerUtil.a());
    return 0L;
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 47	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 48	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 52	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_0
    //   14: aload_2
    //   15: invokestatic 58	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   18: astore_1
    //   19: aload_2
    //   20: iconst_0
    //   21: putfield 52	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload_0
    //   25: aload_2
    //   26: invokestatic 58	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore_0
    //   30: aload_0
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_0
    //   35: aload_1
    //   36: invokevirtual 61	java/lang/OutOfMemoryError:printStackTrace	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: aload_2
    //   45: astore_1
    //   46: goto -11 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramString	String
    //   18	1	1	localBitmap	android.graphics.Bitmap
    //   32	11	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   45	1	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   7	19	2	localOptions	android.graphics.BitmapFactory.Options
    //   41	4	2	localOutOfMemoryError3	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   0	19	32	java/lang/OutOfMemoryError
    //   19	30	41	java/lang/OutOfMemoryError
  }
  
  public static String a(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    return FileSizeFormat.a(paramLong, paramInt);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new File(Utils.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.endsWith(File.separator)) {}
    for (paramString1 = "";; paramString1 = File.separator) {
      return paramString1 + paramString2;
    }
  }
  
  public static ArrayList a(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramString.length)
      {
        Object localObject = paramString[i];
        if ((!paramBoolean) && (localObject.getName().startsWith("."))) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localObject.isDirectory()) || (localObject.length() != 0L))
          {
            FileInfo localFileInfo = new FileInfo();
            localFileInfo.d(localObject.getName());
            localFileInfo.a(localObject.isDirectory());
            localFileInfo.e(localObject.getPath());
            localFileInfo.a(localObject.length());
            localFileInfo.b(localObject.lastModified());
            localArrayList.add(localFileInfo);
          }
        }
      }
      if (paramInt == 0) {
        Collections.sort(localArrayList, new FileUtil.MyFileCompare());
      }
      for (;;)
      {
        return localArrayList;
        Collections.sort(localArrayList, new FileCompare());
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        int i = 0;
        while (i < paramFile.length)
        {
          a(paramFile[i]);
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: ireturn
    //   12: new 201	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 203	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 204	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc 205
    //   26: invokespecial 208	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   29: astore_1
    //   30: aload_0
    //   31: getstatic 214	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   34: bipush 70
    //   36: aload_1
    //   37: invokevirtual 220	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   40: istore_3
    //   41: iload_3
    //   42: istore_2
    //   43: aload_1
    //   44: ifnull -34 -> 10
    //   47: aload_1
    //   48: invokevirtual 225	java/io/OutputStream:flush	()V
    //   51: aload_1
    //   52: invokevirtual 228	java/io/OutputStream:close	()V
    //   55: iload_3
    //   56: ireturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +11 -> 72
    //   64: aload_1
    //   65: invokevirtual 225	java/io/OutputStream:flush	()V
    //   68: aload_1
    //   69: invokevirtual 228	java/io/OutputStream:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -15 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramBitmap	android.graphics.Bitmap
    //   0	78	1	paramString	String
    //   9	34	2	bool1	boolean
    //   40	16	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	30	57	finally
    //   30	41	74	finally
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool1 = new File(paramString).exists();
      return bool1;
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.isFileExists", 2, "" + paramString.getMessage());
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while (i < 0);
    return paramString.substring(0, i + 1);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 0) {
        bool2 = bool3;
      }
    }
    try
    {
      bool3 = a(new File(paramString));
      bool1 = bool3;
      if (bool3)
      {
        bool2 = bool3;
        FileManagerUtil.b(paramString);
        bool1 = bool3;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.delete", 2, "" + paramString.getMessage());
    }
    return bool1;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */