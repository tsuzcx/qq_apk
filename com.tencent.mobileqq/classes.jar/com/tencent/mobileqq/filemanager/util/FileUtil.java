package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.Environment;
import aszq;
import aszt;
import ataj;
import bftf;
import bfvi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileUtil
{
  public static String combinPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.endsWith(File.separator)) {}
    for (paramString1 = "";; paramString1 = File.separator) {
      return paramString1 + paramString2;
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_0
    //   9: invokevirtual 45	java/io/File:isFile	()Z
    //   12: ifeq +89 -> 101
    //   15: aload_1
    //   16: invokevirtual 48	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 51	java/io/File:delete	()Z
    //   26: pop
    //   27: new 53	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 56	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore 4
    //   37: new 58	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 5
    //   47: sipush 4096
    //   50: newarray byte
    //   52: astore 6
    //   54: aload 5
    //   56: aload 6
    //   58: invokevirtual 63	java/io/FileInputStream:read	([B)I
    //   61: istore_3
    //   62: iload_3
    //   63: iconst_m1
    //   64: if_icmpeq +116 -> 180
    //   67: aload 4
    //   69: aload 6
    //   71: iconst_0
    //   72: iload_3
    //   73: invokevirtual 67	java/io/FileOutputStream:write	([BII)V
    //   76: goto -22 -> 54
    //   79: astore 6
    //   81: aload 4
    //   83: ifnull +8 -> 91
    //   86: aload 4
    //   88: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   91: aload 5
    //   93: ifnull +8 -> 101
    //   96: aload 5
    //   98: invokevirtual 71	java/io/FileInputStream:close	()V
    //   101: aload_0
    //   102: invokevirtual 74	java/io/File:isDirectory	()Z
    //   105: ifeq +135 -> 240
    //   108: aload_0
    //   109: invokevirtual 78	java/io/File:listFiles	()[Ljava/io/File;
    //   112: astore_0
    //   113: aload_1
    //   114: invokevirtual 81	java/io/File:mkdir	()Z
    //   117: pop
    //   118: iload_2
    //   119: aload_0
    //   120: arraylength
    //   121: if_icmpge +119 -> 240
    //   124: aload_0
    //   125: iload_2
    //   126: aaload
    //   127: invokevirtual 85	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   130: new 20	java/io/File
    //   133: dup
    //   134: new 13	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   141: aload_1
    //   142: invokevirtual 85	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   145: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: getstatic 24	java/io/File:separator	Ljava/lang/String;
    //   151: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: iload_2
    //   156: aaload
    //   157: invokevirtual 91	java/io/File:getName	()Ljava/lang/String;
    //   160: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: invokestatic 96	com/tencent/mobileqq/filemanager/util/FileUtil:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   172: pop
    //   173: iload_2
    //   174: iconst_1
    //   175: iadd
    //   176: istore_2
    //   177: goto -59 -> 118
    //   180: aload 4
    //   182: invokevirtual 99	java/io/FileOutputStream:flush	()V
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   195: aload 5
    //   197: ifnull -96 -> 101
    //   200: aload 5
    //   202: invokevirtual 71	java/io/FileInputStream:close	()V
    //   205: goto -104 -> 101
    //   208: astore 4
    //   210: goto -109 -> 101
    //   213: astore_0
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 6
    //   219: astore_1
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 71	java/io/FileInputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: iconst_1
    //   241: ireturn
    //   242: astore 4
    //   244: goto -49 -> 195
    //   247: astore 4
    //   249: goto -158 -> 91
    //   252: astore 4
    //   254: goto -153 -> 101
    //   257: astore 4
    //   259: goto -29 -> 230
    //   262: astore_1
    //   263: goto -25 -> 238
    //   266: astore_0
    //   267: aload 6
    //   269: astore_1
    //   270: goto -50 -> 220
    //   273: astore_0
    //   274: aload 5
    //   276: astore_1
    //   277: goto -57 -> 220
    //   280: astore 4
    //   282: aconst_null
    //   283: astore 4
    //   285: aload 7
    //   287: astore 5
    //   289: goto -208 -> 81
    //   292: astore 5
    //   294: aload 7
    //   296: astore 5
    //   298: goto -217 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramFile1	File
    //   0	301	1	paramFile2	File
    //   7	170	2	i	int
    //   61	12	3	j	int
    //   35	156	4	localFileOutputStream	java.io.FileOutputStream
    //   208	1	4	localIOException1	java.io.IOException
    //   215	11	4	localObject1	Object
    //   242	1	4	localIOException2	java.io.IOException
    //   247	1	4	localIOException3	java.io.IOException
    //   252	1	4	localIOException4	java.io.IOException
    //   257	1	4	localIOException5	java.io.IOException
    //   280	1	4	localIOException6	java.io.IOException
    //   283	1	4	localObject2	Object
    //   45	243	5	localObject3	Object
    //   292	1	5	localIOException7	java.io.IOException
    //   296	1	5	localObject4	Object
    //   1	69	6	arrayOfByte	byte[]
    //   79	189	6	localIOException8	java.io.IOException
    //   4	291	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   47	54	79	java/io/IOException
    //   54	62	79	java/io/IOException
    //   67	76	79	java/io/IOException
    //   180	185	79	java/io/IOException
    //   200	205	208	java/io/IOException
    //   15	27	213	finally
    //   27	37	213	finally
    //   190	195	242	java/io/IOException
    //   86	91	247	java/io/IOException
    //   96	101	252	java/io/IOException
    //   225	230	257	java/io/IOException
    //   234	238	262	java/io/IOException
    //   37	47	266	finally
    //   47	54	273	finally
    //   54	62	273	finally
    //   67	76	273	finally
    //   180	185	273	finally
    //   15	27	280	java/io/IOException
    //   27	37	280	java/io/IOException
    //   37	47	292	java/io/IOException
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean deleteFile(String paramString)
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
      bool3 = deleteFile(new File(paramString));
      bool1 = bool3;
      if (bool3)
      {
        bool2 = bool3;
        aszt.d(paramString);
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
  
  public static void deleteSubFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        int i = 0;
        while (i < paramFile.length)
        {
          deleteFile(paramFile[i]);
          i += 1;
        }
      }
    }
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    return ataj.a(paramString);
  }
  
  public static String filesizeToString(long paramLong)
  {
    return bfvi.a(paramLong);
  }
  
  public static String filesizeToString(long paramLong, int paramInt)
  {
    return bfvi.a(paramLong, paramInt);
  }
  
  /* Error */
  public static android.graphics.Bitmap getBitmapByPath(String paramString)
  {
    // Byte code:
    //   0: new 150	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 151	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 155	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_0
    //   14: aload_2
    //   15: invokestatic 161	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   18: astore_1
    //   19: aload_2
    //   20: iconst_0
    //   21: putfield 155	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload_0
    //   25: aload_2
    //   26: invokestatic 161	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore_0
    //   30: aload_0
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_0
    //   35: aload_1
    //   36: invokevirtual 164	java/lang/OutOfMemoryError:printStackTrace	()V
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
  
  public static String getExtension(String paramString)
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
  
  public static String getFileDirectoryOf(String paramString)
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
  
  public static FileInfo getFileInfo(File paramFile)
  {
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.d(paramFile.getName());
    localFileInfo.b(paramFile.isDirectory());
    return localFileInfo;
  }
  
  public static String getFileNameNoEx(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf('.');
        str = paramString;
        if (i > -1)
        {
          str = paramString;
          if (i < paramString.length()) {
            str = paramString.substring(0, i);
          }
        }
      }
    }
    return str;
  }
  
  public static long getFileSize(String paramString)
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
    QLog.e("FileUtils", 2, aszt.a());
    return 0L;
  }
  
  public static ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt)
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
            localFileInfo.b(localObject.isDirectory());
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
        Collections.sort(localArrayList, new aszq());
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static String getSDPath()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    return null;
  }
  
  public static String getThumbnailPath(Context paramContext)
  {
    paramContext = new File(bftf.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static boolean isFileExists(String paramString)
  {
    return ataj.b(paramString);
  }
  
  public static boolean moveFile(File paramFile1, File paramFile2)
  {
    if (copyFile(paramFile1, paramFile2))
    {
      deleteFile(paramFile1);
      return true;
    }
    return false;
  }
  
  /* Error */
  public static boolean writeBitmapToFile(android.graphics.Bitmap paramBitmap, String paramString)
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
    //   12: new 305	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 53	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 306	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc_w 307
    //   27: invokespecial 310	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   30: astore_1
    //   31: aload_0
    //   32: getstatic 316	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   35: bipush 70
    //   37: aload_1
    //   38: invokevirtual 322	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: istore_3
    //   42: iload_3
    //   43: istore_2
    //   44: aload_1
    //   45: ifnull -35 -> 10
    //   48: aload_1
    //   49: invokevirtual 325	java/io/OutputStream:flush	()V
    //   52: aload_1
    //   53: invokevirtual 326	java/io/OutputStream:close	()V
    //   56: iload_3
    //   57: ireturn
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +11 -> 73
    //   65: aload_1
    //   66: invokevirtual 325	java/io/OutputStream:flush	()V
    //   69: aload_1
    //   70: invokevirtual 326	java/io/OutputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: astore_0
    //   76: goto -24 -> 52
    //   79: astore 4
    //   81: goto -12 -> 69
    //   84: astore_0
    //   85: goto -24 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramBitmap	android.graphics.Bitmap
    //   0	88	1	paramString	String
    //   9	35	2	bool1	boolean
    //   41	16	3	bool2	boolean
    //   79	1	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   12	31	58	finally
    //   48	52	75	java/io/IOException
    //   65	69	79	java/io/IOException
    //   31	42	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */