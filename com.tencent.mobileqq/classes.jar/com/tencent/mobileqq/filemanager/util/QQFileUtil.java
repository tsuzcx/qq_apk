package com.tencent.mobileqq.filemanager.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class QQFileUtil
{
  public static FileInfo a(File paramFile)
  {
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.d(paramFile.getName());
    localFileInfo.b(paramFile.isDirectory());
    return localFileInfo;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 36
    //   5: astore_2
    //   6: aload_2
    //   7: astore_3
    //   8: invokestatic 42	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   11: invokestatic 46	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14: invokeinterface 52 2 0
    //   19: checkcast 54	[Ljava/lang/StackTraceElement;
    //   22: astore 4
    //   24: aload_2
    //   25: astore_3
    //   26: aload 4
    //   28: arraylength
    //   29: istore_1
    //   30: iconst_0
    //   31: istore_0
    //   32: aload_2
    //   33: astore_3
    //   34: iload_0
    //   35: iload_1
    //   36: if_icmpge +88 -> 124
    //   39: aload 4
    //   41: iload_0
    //   42: aaload
    //   43: astore 5
    //   45: aload_2
    //   46: astore_3
    //   47: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +16 -> 66
    //   53: aload_2
    //   54: astore_3
    //   55: ldc 61
    //   57: iconst_1
    //   58: aload 5
    //   60: invokevirtual 66	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   63: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_2
    //   67: astore_3
    //   68: new 72	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   75: astore 6
    //   77: aload_2
    //   78: astore_3
    //   79: aload 6
    //   81: aload_2
    //   82: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: astore_3
    //   88: aload 6
    //   90: aload 5
    //   92: invokevirtual 66	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   95: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: astore_3
    //   101: aload 6
    //   103: ldc 79
    //   105: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_2
    //   110: astore_3
    //   111: aload 6
    //   113: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_2
    //   117: iload_0
    //   118: iconst_1
    //   119: iadd
    //   120: istore_0
    //   121: goto -89 -> 32
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_3
    //   128: areturn
    //   129: astore_2
    //   130: ldc 2
    //   132: monitorexit
    //   133: goto +5 -> 138
    //   136: aload_2
    //   137: athrow
    //   138: goto -2 -> 136
    //   141: astore_2
    //   142: goto -18 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	90	0	i	int
    //   29	8	1	j	int
    //   5	112	2	str1	String
    //   129	8	2	localObject	Object
    //   141	1	2	localException	Exception
    //   7	121	3	str2	String
    //   22	18	4	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   43	48	5	localStackTraceElement	java.lang.StackTraceElement
    //   75	37	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	24	129	finally
    //   26	30	129	finally
    //   47	53	129	finally
    //   55	66	129	finally
    //   68	77	129	finally
    //   79	86	129	finally
    //   88	99	129	finally
    //   101	109	129	finally
    //   111	117	129	finally
    //   8	24	141	java/lang/Exception
    //   26	30	141	java/lang/Exception
    //   47	53	141	java/lang/Exception
    //   55	66	141	java/lang/Exception
    //   68	77	141	java/lang/Exception
    //   79	86	141	java/lang/Exception
    //   88	99	141	java/lang/Exception
    //   101	109	141	java/lang/Exception
    //   111	117	141	java/lang/Exception
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.b(paramContext));
    localStringBuilder.append("thumbnails/");
    paramContext = new File(localStringBuilder.toString());
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    if (paramString1.endsWith(File.separator)) {
      paramString1 = "";
    } else {
      paramString1 = File.separator;
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static ArrayList<FileInfo> a(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        if (((paramBoolean) || (!localObject.getName().startsWith("."))) && ((localObject.isDirectory()) || (localObject.length() != 0L)))
        {
          FileInfo localFileInfo = new FileInfo();
          localFileInfo.d(localObject.getName());
          localFileInfo.b(localObject.isDirectory());
          localFileInfo.f(localObject.getPath());
          localFileInfo.a(localObject.length());
          localFileInfo.b(localObject.lastModified());
          localArrayList.add(localFileInfo);
        }
        i += 1;
      }
      if (paramInt == 0)
      {
        Collections.sort(localArrayList, new FileUtil.MyFileCompare());
        return localArrayList;
      }
      Collections.sort(localArrayList, new FileCompare());
      return localArrayList;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +76 -> 77
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +69 -> 77
    //   11: aconst_null
    //   12: astore_3
    //   13: new 171	java/io/BufferedOutputStream
    //   16: dup
    //   17: new 173	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: ldc 175
    //   27: invokespecial 178	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   30: astore_1
    //   31: aload_0
    //   32: getstatic 184	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   35: bipush 70
    //   37: aload_1
    //   38: invokevirtual 190	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: istore_2
    //   42: aload_1
    //   43: invokevirtual 195	java/io/OutputStream:flush	()V
    //   46: aload_1
    //   47: invokevirtual 198	java/io/OutputStream:close	()V
    //   50: iload_2
    //   51: ireturn
    //   52: astore_3
    //   53: aload_1
    //   54: astore_0
    //   55: aload_3
    //   56: astore_1
    //   57: goto +6 -> 63
    //   60: astore_1
    //   61: aload_3
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +11 -> 75
    //   67: aload_0
    //   68: invokevirtual 195	java/io/OutputStream:flush	()V
    //   71: aload_0
    //   72: invokevirtual 198	java/io/OutputStream:close	()V
    //   75: aload_1
    //   76: athrow
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_0
    //   80: goto -34 -> 46
    //   83: astore_3
    //   84: goto -13 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramBitmap	Bitmap
    //   0	87	1	paramString	String
    //   41	10	2	bool	boolean
    //   12	1	3	localObject1	Object
    //   52	10	3	localObject2	Object
    //   83	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   31	42	52	finally
    //   13	31	60	finally
    //   42	46	79	java/io/IOException
    //   67	71	83	java/io/IOException
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 203	java/io/File:isFile	()Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_2
    //   8: iload 4
    //   10: ifeq +178 -> 188
    //   13: aconst_null
    //   14: astore 8
    //   16: aconst_null
    //   17: astore 7
    //   19: aload_1
    //   20: invokevirtual 100	java/io/File:exists	()Z
    //   23: ifeq +8 -> 31
    //   26: aload_1
    //   27: invokevirtual 206	java/io/File:delete	()Z
    //   30: pop
    //   31: new 173	java/io/FileOutputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 209	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore 5
    //   41: new 211	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore 6
    //   51: sipush 4096
    //   54: newarray byte
    //   56: astore 7
    //   58: aload 6
    //   60: aload 7
    //   62: invokevirtual 216	java/io/FileInputStream:read	([B)I
    //   65: istore_3
    //   66: iload_3
    //   67: iconst_m1
    //   68: if_icmpeq +15 -> 83
    //   71: aload 5
    //   73: aload 7
    //   75: iconst_0
    //   76: iload_3
    //   77: invokevirtual 220	java/io/FileOutputStream:write	([BII)V
    //   80: goto -22 -> 58
    //   83: aload 5
    //   85: invokevirtual 221	java/io/FileOutputStream:flush	()V
    //   88: aload 5
    //   90: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   93: aload 6
    //   95: invokevirtual 223	java/io/FileInputStream:close	()V
    //   98: goto +90 -> 188
    //   101: goto +87 -> 188
    //   104: astore_0
    //   105: aload 6
    //   107: astore_1
    //   108: goto +27 -> 135
    //   111: goto +54 -> 165
    //   114: astore_0
    //   115: aload 7
    //   117: astore_1
    //   118: goto +17 -> 135
    //   121: aload 8
    //   123: astore 6
    //   125: goto +40 -> 165
    //   128: astore_0
    //   129: aconst_null
    //   130: astore 5
    //   132: aload 7
    //   134: astore_1
    //   135: aload 5
    //   137: ifnull +11 -> 148
    //   140: aload 5
    //   142: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   145: goto +3 -> 148
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 223	java/io/FileInputStream:close	()V
    //   156: aload_0
    //   157: athrow
    //   158: aconst_null
    //   159: astore 5
    //   161: aload 8
    //   163: astore 6
    //   165: aload 5
    //   167: ifnull +11 -> 178
    //   170: aload 5
    //   172: invokevirtual 222	java/io/FileOutputStream:close	()V
    //   175: goto +3 -> 178
    //   178: aload 6
    //   180: ifnull +8 -> 188
    //   183: aload 6
    //   185: invokevirtual 223	java/io/FileInputStream:close	()V
    //   188: aload_0
    //   189: invokevirtual 28	java/io/File:isDirectory	()Z
    //   192: ifeq +92 -> 284
    //   195: aload_0
    //   196: invokevirtual 122	java/io/File:listFiles	()[Ljava/io/File;
    //   199: astore_0
    //   200: aload_1
    //   201: invokevirtual 226	java/io/File:mkdir	()Z
    //   204: pop
    //   205: iload_2
    //   206: aload_0
    //   207: arraylength
    //   208: if_icmpge +76 -> 284
    //   211: aload_0
    //   212: iload_2
    //   213: aaload
    //   214: invokevirtual 230	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   217: astore 5
    //   219: new 72	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   226: astore 6
    //   228: aload 6
    //   230: aload_1
    //   231: invokevirtual 230	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   234: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 6
    //   240: getstatic 111	java/io/File:separator	Ljava/lang/String;
    //   243: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 6
    //   249: aload_0
    //   250: iload_2
    //   251: aaload
    //   252: invokevirtual 20	java/io/File:getName	()Ljava/lang/String;
    //   255: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 5
    //   261: new 16	java/io/File
    //   264: dup
    //   265: aload 6
    //   267: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   273: invokestatic 235	com/tencent/mobileqq/filemanager/util/QQFileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   276: pop
    //   277: iload_2
    //   278: iconst_1
    //   279: iadd
    //   280: istore_2
    //   281: goto -76 -> 205
    //   284: iconst_1
    //   285: ireturn
    //   286: astore 5
    //   288: goto -130 -> 158
    //   291: astore 6
    //   293: goto -172 -> 121
    //   296: astore 7
    //   298: goto -187 -> 111
    //   301: astore 5
    //   303: goto -210 -> 93
    //   306: astore 5
    //   308: goto -207 -> 101
    //   311: astore 5
    //   313: goto -165 -> 148
    //   316: astore_1
    //   317: goto -161 -> 156
    //   320: astore 5
    //   322: goto -144 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramFile1	File
    //   0	325	1	paramFile2	File
    //   7	274	2	i	int
    //   65	12	3	j	int
    //   4	5	4	bool	boolean
    //   39	221	5	localObject1	Object
    //   286	1	5	localIOException1	java.io.IOException
    //   301	1	5	localIOException2	java.io.IOException
    //   306	1	5	localIOException3	java.io.IOException
    //   311	1	5	localIOException4	java.io.IOException
    //   320	1	5	localIOException5	java.io.IOException
    //   49	217	6	localObject2	Object
    //   291	1	6	localIOException6	java.io.IOException
    //   17	116	7	arrayOfByte	byte[]
    //   296	1	7	localIOException7	java.io.IOException
    //   14	148	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   51	58	104	finally
    //   58	66	104	finally
    //   71	80	104	finally
    //   83	88	104	finally
    //   41	51	114	finally
    //   19	31	128	finally
    //   31	41	128	finally
    //   19	31	286	java/io/IOException
    //   31	41	286	java/io/IOException
    //   41	51	291	java/io/IOException
    //   51	58	296	java/io/IOException
    //   58	66	296	java/io/IOException
    //   71	80	296	java/io/IOException
    //   83	88	296	java/io/IOException
    //   88	93	301	java/io/IOException
    //   93	98	306	java/io/IOException
    //   183	188	306	java/io/IOException
    //   140	145	311	java/io/IOException
    //   152	156	316	java/io/IOException
    //   170	175	320	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    return FileUtils.fileExists(paramString);
  }
  
  public static boolean b(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          b(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    if (a(paramFile1, paramFile2))
    {
      b(paramFile1);
      return true;
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return FileUtils.fileExistsAndNotEmpty(paramString);
  }
  
  public static long c(String paramString)
  {
    long l2 = 0L;
    if (paramString == null) {
      return 0L;
    }
    try
    {
      paramString = new File(paramString);
      long l1 = l2;
      if (paramString.exists())
      {
        l1 = l2;
        if (paramString.length() > 0L) {
          l1 = paramString.length();
        }
      }
      return l1;
    }
    catch (Exception paramString)
    {
      label44:
      break label44;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FileUtils", 2, a());
    }
    return 0L;
  }
  
  public static void c(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        int i = 0;
        while (i < paramFile.length)
        {
          b(paramFile[i]);
          i += 1;
        }
      }
    }
  }
  
  public static boolean d(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramString != null)
    {
      bool1 = bool3;
      if (paramString.length() > 0) {
        try
        {
          bool3 = b(new File(paramString));
          bool1 = bool3;
          if (bool3)
          {
            bool2 = bool3;
            e(paramString);
            return bool3;
          }
        }
        catch (Exception paramString)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramString.getMessage());
            QLog.d("Tools.delete", 2, localStringBuilder.toString());
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public static void e(String paramString)
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static String f(String paramString)
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
  
  public static String g(String paramString)
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
  
  public static String h(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf("/");
    if (i >= 0) {
      return paramString.substring(0, i + 1);
    }
    return null;
  }
  
  public static Bitmap i(String paramString)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localBitmap1 = localBitmap2;
      localOptions.inJustDecodeBounds = true;
      localBitmap1 = localBitmap2;
      localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
      localBitmap1 = localBitmap2;
      localOptions.inJustDecodeBounds = false;
      localBitmap1 = localBitmap2;
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return localBitmap1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileUtil
 * JD-Core Version:    0.7.0.1
 */