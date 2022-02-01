package com.tencent.open.base;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  protected static final String a = File.separator;
  
  public static void a(File paramFile1, File paramFile2)
  {
    paramFile2 = new ZipOutputStream(new BufferedOutputStream(new CheckedOutputStream(new FileOutputStream(paramFile2), new CRC32())));
    paramFile2.setLevel(0);
    a(paramFile1, paramFile2, "", false);
    paramFile2.flush();
    paramFile2.close();
  }
  
  public static void a(File paramFile, String paramString)
  {
    a(paramFile, new File(paramString));
  }
  
  /* Error */
  protected static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore 4
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   17: astore 7
    //   19: aload 6
    //   21: astore 4
    //   23: aload 7
    //   25: aload_2
    //   26: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: astore 4
    //   34: aload 7
    //   36: aload_0
    //   37: invokevirtual 76	java/io/File:getName	()Ljava/lang/String;
    //   40: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 6
    //   46: astore 4
    //   48: new 78	java/util/zip/ZipEntry
    //   51: dup
    //   52: aload 7
    //   54: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 82	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   60: astore_2
    //   61: aload 6
    //   63: astore 4
    //   65: aload_2
    //   66: lconst_0
    //   67: invokevirtual 86	java/util/zip/ZipEntry:setTime	(J)V
    //   70: aload 6
    //   72: astore 4
    //   74: aload_1
    //   75: aload_2
    //   76: invokevirtual 90	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   79: aload 6
    //   81: astore 4
    //   83: new 92	java/io/BufferedInputStream
    //   86: dup
    //   87: new 94	java/io/FileInputStream
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: astore_0
    //   99: sipush 8192
    //   102: newarray byte
    //   104: astore_2
    //   105: aload_0
    //   106: aload_2
    //   107: iconst_0
    //   108: sipush 8192
    //   111: invokevirtual 102	java/io/BufferedInputStream:read	([BII)I
    //   114: istore_3
    //   115: iload_3
    //   116: iconst_m1
    //   117: if_icmpeq +13 -> 130
    //   120: aload_1
    //   121: aload_2
    //   122: iconst_0
    //   123: iload_3
    //   124: invokevirtual 106	java/util/zip/ZipOutputStream:write	([BII)V
    //   127: goto -22 -> 105
    //   130: aload_1
    //   131: invokevirtual 109	java/util/zip/ZipOutputStream:closeEntry	()V
    //   134: aload_0
    //   135: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   138: return
    //   139: astore_1
    //   140: aload_0
    //   141: astore 4
    //   143: aload_1
    //   144: astore_0
    //   145: goto +30 -> 175
    //   148: astore_1
    //   149: aload_0
    //   150: astore 4
    //   152: aload_1
    //   153: astore_0
    //   154: goto +12 -> 166
    //   157: astore_0
    //   158: goto +17 -> 175
    //   161: astore_0
    //   162: aload 5
    //   164: astore 4
    //   166: new 65	java/lang/Exception
    //   169: dup
    //   170: aload_0
    //   171: invokespecial 113	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   174: athrow
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 110	java/io/BufferedInputStream:close	()V
    //   185: goto +5 -> 190
    //   188: aload_0
    //   189: athrow
    //   190: goto -2 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramFile	File
    //   0	193	1	paramZipOutputStream	ZipOutputStream
    //   0	193	2	paramString	String
    //   114	10	3	i	int
    //   8	173	4	localObject1	Object
    //   1	162	5	localObject2	Object
    //   4	76	6	localObject3	Object
    //   17	36	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   99	105	139	finally
    //   105	115	139	finally
    //   120	127	139	finally
    //   130	134	139	finally
    //   99	105	148	java/lang/Exception
    //   105	115	148	java/lang/Exception
    //   120	127	148	java/lang/Exception
    //   130	134	148	java/lang/Exception
    //   10	19	157	finally
    //   23	30	157	finally
    //   34	44	157	finally
    //   48	61	157	finally
    //   65	70	157	finally
    //   74	79	157	finally
    //   83	99	157	finally
    //   166	175	157	finally
    //   10	19	161	java/lang/Exception
    //   23	30	161	java/lang/Exception
    //   34	44	161	java/lang/Exception
    //   48	61	161	java/lang/Exception
    //   65	70	161	java/lang/Exception
    //   74	79	161	java/lang/Exception
    //   83	99	161	java/lang/Exception
  }
  
  protected static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString, boolean paramBoolean)
  {
    if (paramFile.isDirectory())
    {
      b(paramFile, paramZipOutputStream, paramString, paramBoolean);
      return;
    }
    a(paramFile, paramZipOutputStream, paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(new File(paramString1), paramString2);
  }
  
  protected static void b(File paramFile, ZipOutputStream paramZipOutputStream, String paramString, boolean paramBoolean)
  {
    File[] arrayOfFile = paramFile.listFiles();
    Arrays.sort(arrayOfFile);
    Object localObject;
    if (arrayOfFile.length == 0)
    {
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(paramFile.getName());
        ((StringBuilder)localObject).append(a);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = paramString;
      }
      localObject = new ZipEntry((String)localObject);
      ((ZipEntry)localObject).setTime(0L);
      paramZipOutputStream.putNextEntry((ZipEntry)localObject);
      paramZipOutputStream.closeEntry();
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(paramFile.getName());
        ((StringBuilder)localObject).append(a);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = paramString;
      }
      a(localFile, paramZipOutputStream, (String)localObject, true);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.ZipUtils
 * JD-Core Version:    0.7.0.1
 */