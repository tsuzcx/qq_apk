package org.extra.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ApkLibraryInstaller
  implements ReLinker.LibraryInstaller
{
  private static final int COPY_BUFFER_SIZE = 4096;
  private static final int MAX_TRIES = 5;
  
  private void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private long copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1)
      {
        paramOutputStream.flush();
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private ApkLibraryInstaller.ZipFileInZipEntry findAPKWithLibrary(Context paramContext, String[] paramArrayOfString, String paramString, ReLinkerInstance paramReLinkerInstance)
  {
    String[] arrayOfString = sourceDirectories(paramContext);
    int n = arrayOfString.length;
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      int k = 0;
      String str;
      int j;
      if (i < n)
      {
        str = arrayOfString[i];
        j = 0;
        label38:
        paramContext = (Context)localObject1;
        if (j >= 5) {}
      }
      try
      {
        paramContext = new ZipFile(new File(str), 1);
        break label77;
        j += 1;
        break label38;
        label77:
        if (paramContext != null)
        {
          j = 0;
          while (j < 5)
          {
            int i1 = paramArrayOfString.length;
            int m = 0;
            while (m < i1)
            {
              localObject1 = paramArrayOfString[m];
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("lib");
              ((StringBuilder)localObject2).append(File.separatorChar);
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(File.separatorChar);
              ((StringBuilder)localObject2).append(paramString);
              localObject1 = ((StringBuilder)localObject2).toString();
              localObject2 = new Object[2];
              localObject2[k] = localObject1;
              localObject2[1] = str;
              paramReLinkerInstance.log("Looking for %s in APK %s...", (Object[])localObject2);
              localObject1 = paramContext.getEntry((String)localObject1);
              if (localObject1 != null) {
                return new ApkLibraryInstaller.ZipFileInZipEntry(paramContext, (ZipEntry)localObject1);
              }
              m += 1;
              k = 0;
            }
            j += 1;
          }
        }
      }
      catch (IOException paramContext)
      {
        try
        {
          paramContext.close();
          label247:
          i += 1;
          localObject1 = paramContext;
          continue;
          return null;
          paramContext = paramContext;
        }
        catch (IOException localIOException)
        {
          break label247;
        }
      }
    }
  }
  
  private String[] sourceDirectories(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.splitSourceDirs != null) && (paramContext.splitSourceDirs.length != 0))
    {
      String[] arrayOfString = new String[paramContext.splitSourceDirs.length + 1];
      arrayOfString[0] = paramContext.sourceDir;
      System.arraycopy(paramContext.splitSourceDirs, 0, arrayOfString, 1, paramContext.splitSourceDirs.length);
      return arrayOfString;
    }
    return new String[] { paramContext.sourceDir };
  }
  
  /* Error */
  public void installLibrary(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile, ReLinkerInstance paramReLinkerInstance)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: aload 5
    //   9: invokespecial 131	org/extra/relinker/ApkLibraryInstaller:findAPKWithLibrary	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Lorg/extra/relinker/ReLinkerInstance;)Lorg/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry;
    //   12: astore 12
    //   14: aload 12
    //   16: ifnull +262 -> 278
    //   19: iconst_0
    //   20: istore 6
    //   22: iload 6
    //   24: iconst_5
    //   25: if_icmpge +224 -> 249
    //   28: aload 5
    //   30: ldc 133
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_3
    //   39: aastore
    //   40: invokevirtual 86	org/extra/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload 4
    //   45: invokevirtual 137	java/io/File:exists	()Z
    //   48: ifne +18 -> 66
    //   51: aload 4
    //   53: invokevirtual 140	java/io/File:createNewFile	()Z
    //   56: istore 7
    //   58: iload 7
    //   60: ifne +6 -> 66
    //   63: goto +312 -> 375
    //   66: aload 12
    //   68: getfield 144	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   71: aload 12
    //   73: getfield 148	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipEntry	Ljava/util/zip/ZipEntry;
    //   76: invokevirtual 152	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   79: astore_2
    //   80: new 154	java/io/FileOutputStream
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   89: astore_1
    //   90: aload_0
    //   91: aload_2
    //   92: aload_1
    //   93: invokespecial 159	org/extra/relinker/ApkLibraryInstaller:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   96: lstore 8
    //   98: aload_1
    //   99: invokevirtual 163	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   102: invokevirtual 168	java/io/FileDescriptor:sync	()V
    //   105: aload 4
    //   107: invokevirtual 172	java/io/File:length	()J
    //   110: lstore 10
    //   112: lload 8
    //   114: lload 10
    //   116: lcmp
    //   117: ifeq +16 -> 133
    //   120: aload_0
    //   121: aload_2
    //   122: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   130: goto +245 -> 375
    //   133: aload_0
    //   134: aload_2
    //   135: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   138: aload_0
    //   139: aload_1
    //   140: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   143: aload 4
    //   145: iconst_1
    //   146: iconst_0
    //   147: invokevirtual 178	java/io/File:setReadable	(ZZ)Z
    //   150: pop
    //   151: aload 4
    //   153: iconst_1
    //   154: iconst_0
    //   155: invokevirtual 181	java/io/File:setExecutable	(ZZ)Z
    //   158: pop
    //   159: aload 4
    //   161: iconst_1
    //   162: invokevirtual 185	java/io/File:setWritable	(Z)Z
    //   165: pop
    //   166: aload 12
    //   168: ifnull +19 -> 187
    //   171: aload 12
    //   173: getfield 144	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   176: ifnull +11 -> 187
    //   179: aload 12
    //   181: getfield 144	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   184: invokevirtual 96	java/util/zip/ZipFile:close	()V
    //   187: return
    //   188: astore 4
    //   190: aload_1
    //   191: astore_3
    //   192: aload 4
    //   194: astore_1
    //   195: goto +26 -> 221
    //   198: astore_1
    //   199: aload 13
    //   201: astore_3
    //   202: goto +19 -> 221
    //   205: aconst_null
    //   206: astore_1
    //   207: goto +26 -> 233
    //   210: aconst_null
    //   211: astore_1
    //   212: goto +29 -> 241
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_2
    //   218: aload 13
    //   220: astore_3
    //   221: aload_0
    //   222: aload_2
    //   223: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   226: aload_0
    //   227: aload_3
    //   228: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   231: aload_1
    //   232: athrow
    //   233: aload_0
    //   234: aload_2
    //   235: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   238: goto -113 -> 125
    //   241: aload_0
    //   242: aload_2
    //   243: invokespecial 174	org/extra/relinker/ApkLibraryInstaller:closeSilently	(Ljava/io/Closeable;)V
    //   246: goto -121 -> 125
    //   249: aload 5
    //   251: ldc 187
    //   253: invokevirtual 189	org/extra/relinker/ReLinkerInstance:log	(Ljava/lang/String;)V
    //   256: aload 12
    //   258: ifnull +19 -> 277
    //   261: aload 12
    //   263: getfield 144	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   266: ifnull +11 -> 277
    //   269: aload 12
    //   271: getfield 144	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   274: invokevirtual 96	java/util/zip/ZipFile:close	()V
    //   277: return
    //   278: new 191	org/extra/relinker/MissingLibraryException
    //   281: dup
    //   282: aload_3
    //   283: invokespecial 192	org/extra/relinker/MissingLibraryException:<init>	(Ljava/lang/String;)V
    //   286: athrow
    //   287: astore_1
    //   288: aload 12
    //   290: astore_2
    //   291: goto +6 -> 297
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_2
    //   298: ifnull +17 -> 315
    //   301: aload_2
    //   302: getfield 144	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   305: ifnull +10 -> 315
    //   308: aload_2
    //   309: getfield 144	org/extra/relinker/ApkLibraryInstaller$ZipFileInZipEntry:zipFile	Ljava/util/zip/ZipFile;
    //   312: invokevirtual 96	java/util/zip/ZipFile:close	()V
    //   315: goto +5 -> 320
    //   318: aload_1
    //   319: athrow
    //   320: goto -2 -> 318
    //   323: astore_1
    //   324: goto +51 -> 375
    //   327: astore_1
    //   328: goto +40 -> 368
    //   331: astore_1
    //   332: goto +29 -> 361
    //   335: astore_1
    //   336: goto -126 -> 210
    //   339: astore_1
    //   340: goto -135 -> 205
    //   343: astore 14
    //   345: goto -104 -> 241
    //   348: astore 14
    //   350: goto -117 -> 233
    //   353: astore_1
    //   354: return
    //   355: astore_1
    //   356: return
    //   357: astore_2
    //   358: goto -43 -> 315
    //   361: aconst_null
    //   362: astore_2
    //   363: aload_2
    //   364: astore_1
    //   365: goto -132 -> 233
    //   368: aconst_null
    //   369: astore_2
    //   370: aload_2
    //   371: astore_1
    //   372: goto -131 -> 241
    //   375: iload 6
    //   377: iconst_1
    //   378: iadd
    //   379: istore 6
    //   381: goto -359 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	ApkLibraryInstaller
    //   0	384	1	paramContext	Context
    //   0	384	2	paramArrayOfString	String[]
    //   0	384	3	paramString	String
    //   0	384	4	paramFile	File
    //   0	384	5	paramReLinkerInstance	ReLinkerInstance
    //   20	360	6	i	int
    //   56	3	7	bool	boolean
    //   96	17	8	l1	long
    //   110	5	10	l2	long
    //   12	277	12	localZipFileInZipEntry	ApkLibraryInstaller.ZipFileInZipEntry
    //   1	218	13	localObject	Object
    //   343	1	14	localFileNotFoundException	java.io.FileNotFoundException
    //   348	1	14	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   90	112	188	finally
    //   80	90	198	finally
    //   66	80	215	finally
    //   28	43	287	finally
    //   43	58	287	finally
    //   120	125	287	finally
    //   125	130	287	finally
    //   133	166	287	finally
    //   221	233	287	finally
    //   233	238	287	finally
    //   241	246	287	finally
    //   249	256	287	finally
    //   278	287	287	finally
    //   3	14	294	finally
    //   43	58	323	java/io/IOException
    //   66	80	327	java/io/FileNotFoundException
    //   66	80	331	java/io/IOException
    //   80	90	335	java/io/FileNotFoundException
    //   80	90	339	java/io/IOException
    //   90	112	343	java/io/FileNotFoundException
    //   90	112	348	java/io/IOException
    //   171	187	353	java/io/IOException
    //   261	277	355	java/io/IOException
    //   301	315	357	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.extra.relinker.ApkLibraryInstaller
 * JD-Core Version:    0.7.0.1
 */