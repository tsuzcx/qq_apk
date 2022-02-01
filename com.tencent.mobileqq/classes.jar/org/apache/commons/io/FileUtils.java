package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileUtils
{
  public static final File[] EMPTY_FILE_ARRAY = new File[0];
  private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
  public static final long ONE_EB = 1152921504606846976L;
  public static final BigInteger ONE_EB_BI;
  public static final long ONE_GB = 1073741824L;
  public static final BigInteger ONE_GB_BI;
  public static final long ONE_KB = 1024L;
  public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024L);
  public static final long ONE_MB = 1048576L;
  public static final BigInteger ONE_MB_BI;
  public static final long ONE_PB = 1125899906842624L;
  public static final BigInteger ONE_PB_BI;
  public static final long ONE_TB = 1099511627776L;
  public static final BigInteger ONE_TB_BI;
  public static final BigInteger ONE_YB;
  public static final BigInteger ONE_ZB;
  
  static
  {
    BigInteger localBigInteger = ONE_KB_BI;
    ONE_MB_BI = localBigInteger.multiply(localBigInteger);
    ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    ONE_ZB = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
  }
  
  public static String byteCountToDisplaySize(long paramLong)
  {
    return byteCountToDisplaySize(BigInteger.valueOf(paramLong));
  }
  
  public static String byteCountToDisplaySize(BigInteger paramBigInteger)
  {
    if (paramBigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_EB_BI)));
      localStringBuilder.append(" EB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_PB_BI)));
      localStringBuilder.append(" PB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_TB_BI)));
      localStringBuilder.append(" TB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_GB_BI)));
      localStringBuilder.append(" GB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_MB_BI)));
      localStringBuilder.append(" MB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_KB_BI)));
      localStringBuilder.append(" KB");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramBigInteger));
    localStringBuilder.append(" bytes");
    return localStringBuilder.toString();
  }
  
  private static void checkDirectory(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" is not a directory");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(" does not exist");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void checkFileRequirements(File paramFile1, File paramFile2)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 != null)
      {
        if (paramFile1.exists()) {
          return;
        }
        paramFile2 = new StringBuilder();
        paramFile2.append("Source '");
        paramFile2.append(paramFile1);
        paramFile2.append("' does not exist");
        throw new FileNotFoundException(paramFile2.toString());
      }
      throw new NullPointerException("Destination must not be null");
    }
    throw new NullPointerException("Source must not be null");
  }
  
  /* Error */
  public static java.util.zip.Checksum checksum(File paramFile, java.util.zip.Checksum paramChecksum)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 127	java/io/File:isDirectory	()Z
    //   4: ifne +66 -> 70
    //   7: new 161	java/util/zip/CheckedInputStream
    //   10: dup
    //   11: new 163	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: aload_1
    //   20: invokespecial 168	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   23: astore_2
    //   24: aconst_null
    //   25: astore_0
    //   26: aload_2
    //   27: new 170	org/apache/commons/io/output/NullOutputStream
    //   30: dup
    //   31: invokespecial 171	org/apache/commons/io/output/NullOutputStream:<init>	()V
    //   34: invokestatic 177	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual 182	java/io/InputStream:close	()V
    //   42: aload_1
    //   43: areturn
    //   44: astore_1
    //   45: goto +8 -> 53
    //   48: astore_1
    //   49: aload_1
    //   50: astore_0
    //   51: aload_1
    //   52: athrow
    //   53: aload_0
    //   54: ifnull +10 -> 64
    //   57: aload_2
    //   58: invokevirtual 182	java/io/InputStream:close	()V
    //   61: goto +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 182	java/io/InputStream:close	()V
    //   68: aload_1
    //   69: athrow
    //   70: new 134	java/lang/IllegalArgumentException
    //   73: dup
    //   74: ldc 184
    //   76: invokespecial 137	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   79: athrow
    //   80: astore_0
    //   81: goto -13 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramFile	File
    //   0	84	1	paramChecksum	java.util.zip.Checksum
    //   23	42	2	localCheckedInputStream	java.util.zip.CheckedInputStream
    // Exception table:
    //   from	to	target	type
    //   26	38	44	finally
    //   51	53	44	finally
    //   26	38	48	java/lang/Throwable
    //   57	61	80	java/lang/Throwable
  }
  
  public static long checksumCRC32(File paramFile)
  {
    CRC32 localCRC32 = new CRC32();
    checksum(paramFile, localCRC32);
    return localCRC32.getValue();
  }
  
  public static void cleanDirectory(File paramFile)
  {
    File[] arrayOfFile = verifiedListFiles(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        forceDelete(localFile);
      }
      catch (IOException paramFile) {}
      i += 1;
    }
    if (paramFile == null) {
      return;
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  private static void cleanDirectoryOnExit(File paramFile)
  {
    File[] arrayOfFile = verifiedListFiles(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        forceDeleteOnExit(localFile);
      }
      catch (IOException paramFile) {}
      i += 1;
    }
    if (paramFile == null) {
      return;
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  /* Error */
  public static boolean contentEquals(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 124	java/io/File:exists	()Z
    //   4: istore_2
    //   5: iload_2
    //   6: aload_1
    //   7: invokevirtual 124	java/io/File:exists	()Z
    //   10: if_icmpeq +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: iload_2
    //   16: ifne +5 -> 21
    //   19: iconst_1
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 127	java/io/File:isDirectory	()Z
    //   25: ifne +155 -> 180
    //   28: aload_1
    //   29: invokevirtual 127	java/io/File:isDirectory	()Z
    //   32: ifne +148 -> 180
    //   35: aload_0
    //   36: invokevirtual 214	java/io/File:length	()J
    //   39: aload_1
    //   40: invokevirtual 214	java/io/File:length	()J
    //   43: lcmp
    //   44: ifeq +5 -> 49
    //   47: iconst_0
    //   48: ireturn
    //   49: aload_0
    //   50: invokevirtual 218	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   53: aload_1
    //   54: invokevirtual 218	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   57: invokevirtual 222	java/io/File:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +5 -> 65
    //   63: iconst_1
    //   64: ireturn
    //   65: new 163	java/io/FileInputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: astore 5
    //   75: aconst_null
    //   76: astore 4
    //   78: aload 4
    //   80: astore_3
    //   81: new 163	java/io/FileInputStream
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore 6
    //   91: aload 5
    //   93: aload 6
    //   95: invokestatic 225	org/apache/commons/io/IOUtils:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   98: istore_2
    //   99: aload 4
    //   101: astore_3
    //   102: aload 6
    //   104: invokevirtual 182	java/io/InputStream:close	()V
    //   107: aload 5
    //   109: invokevirtual 182	java/io/InputStream:close	()V
    //   112: iload_2
    //   113: ireturn
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_1
    //   117: goto +7 -> 124
    //   120: astore_1
    //   121: aload_1
    //   122: athrow
    //   123: astore_0
    //   124: aload_1
    //   125: ifnull +14 -> 139
    //   128: aload 4
    //   130: astore_3
    //   131: aload 6
    //   133: invokevirtual 182	java/io/InputStream:close	()V
    //   136: goto +11 -> 147
    //   139: aload 4
    //   141: astore_3
    //   142: aload 6
    //   144: invokevirtual 182	java/io/InputStream:close	()V
    //   147: aload 4
    //   149: astore_3
    //   150: aload_0
    //   151: athrow
    //   152: astore_0
    //   153: goto +8 -> 161
    //   156: astore_0
    //   157: aload_0
    //   158: astore_3
    //   159: aload_0
    //   160: athrow
    //   161: aload_3
    //   162: ifnull +11 -> 173
    //   165: aload 5
    //   167: invokevirtual 182	java/io/InputStream:close	()V
    //   170: goto +8 -> 178
    //   173: aload 5
    //   175: invokevirtual 182	java/io/InputStream:close	()V
    //   178: aload_0
    //   179: athrow
    //   180: new 198	java/io/IOException
    //   183: dup
    //   184: ldc 227
    //   186: invokespecial 228	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   189: athrow
    //   190: astore_1
    //   191: goto -44 -> 147
    //   194: astore_1
    //   195: goto -17 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramFile1	File
    //   0	198	1	paramFile2	File
    //   4	109	2	bool	boolean
    //   80	82	3	localObject1	Object
    //   76	72	4	localObject2	Object
    //   73	101	5	localFileInputStream1	FileInputStream
    //   89	54	6	localFileInputStream2	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   91	99	114	finally
    //   91	99	120	java/lang/Throwable
    //   121	123	123	finally
    //   81	91	152	finally
    //   102	107	152	finally
    //   131	136	152	finally
    //   142	147	152	finally
    //   150	152	152	finally
    //   159	161	152	finally
    //   81	91	156	java/lang/Throwable
    //   102	107	156	java/lang/Throwable
    //   142	147	156	java/lang/Throwable
    //   150	152	156	java/lang/Throwable
    //   131	136	190	java/lang/Throwable
    //   165	170	194	java/lang/Throwable
  }
  
  /* Error */
  public static boolean contentEqualsIgnoreEOL(File paramFile1, File paramFile2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 124	java/io/File:exists	()Z
    //   4: istore_3
    //   5: iload_3
    //   6: aload_1
    //   7: invokevirtual 124	java/io/File:exists	()Z
    //   10: if_icmpeq +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: iload_3
    //   16: ifne +5 -> 21
    //   19: iconst_1
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 127	java/io/File:isDirectory	()Z
    //   25: ifne +214 -> 239
    //   28: aload_1
    //   29: invokevirtual 127	java/io/File:isDirectory	()Z
    //   32: ifne +207 -> 239
    //   35: aload_0
    //   36: invokevirtual 218	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   39: aload_1
    //   40: invokevirtual 218	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   43: invokevirtual 222	java/io/File:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +5 -> 51
    //   49: iconst_1
    //   50: ireturn
    //   51: aload_2
    //   52: ifnonnull +25 -> 77
    //   55: new 232	java/io/InputStreamReader
    //   58: dup
    //   59: new 163	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokestatic 238	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   70: invokespecial 241	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   73: astore_0
    //   74: goto +20 -> 94
    //   77: new 232	java/io/InputStreamReader
    //   80: dup
    //   81: new 163	java/io/FileInputStream
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: aload_2
    //   90: invokespecial 244	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   93: astore_0
    //   94: aconst_null
    //   95: astore 5
    //   97: aload_2
    //   98: ifnonnull +29 -> 127
    //   101: aload 5
    //   103: astore 4
    //   105: new 232	java/io/InputStreamReader
    //   108: dup
    //   109: new 163	java/io/FileInputStream
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   117: invokestatic 238	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   120: invokespecial 241	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   123: astore_1
    //   124: goto +24 -> 148
    //   127: aload 5
    //   129: astore 4
    //   131: new 232	java/io/InputStreamReader
    //   134: dup
    //   135: new 163	java/io/FileInputStream
    //   138: dup
    //   139: aload_1
    //   140: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: aload_2
    //   144: invokespecial 244	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   147: astore_1
    //   148: aload_0
    //   149: aload_1
    //   150: invokestatic 247	org/apache/commons/io/IOUtils:contentEqualsIgnoreEOL	(Ljava/io/Reader;Ljava/io/Reader;)Z
    //   153: istore_3
    //   154: aload 5
    //   156: astore 4
    //   158: aload_1
    //   159: invokevirtual 250	java/io/Reader:close	()V
    //   162: aload_0
    //   163: invokevirtual 250	java/io/Reader:close	()V
    //   166: iload_3
    //   167: ireturn
    //   168: astore_2
    //   169: aconst_null
    //   170: astore 4
    //   172: goto +9 -> 181
    //   175: astore 4
    //   177: aload 4
    //   179: athrow
    //   180: astore_2
    //   181: aload 4
    //   183: ifnull +14 -> 197
    //   186: aload 5
    //   188: astore 4
    //   190: aload_1
    //   191: invokevirtual 250	java/io/Reader:close	()V
    //   194: goto +11 -> 205
    //   197: aload 5
    //   199: astore 4
    //   201: aload_1
    //   202: invokevirtual 250	java/io/Reader:close	()V
    //   205: aload 5
    //   207: astore 4
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: goto +9 -> 221
    //   215: astore_1
    //   216: aload_1
    //   217: astore 4
    //   219: aload_1
    //   220: athrow
    //   221: aload 4
    //   223: ifnull +10 -> 233
    //   226: aload_0
    //   227: invokevirtual 250	java/io/Reader:close	()V
    //   230: goto +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 250	java/io/Reader:close	()V
    //   237: aload_1
    //   238: athrow
    //   239: new 198	java/io/IOException
    //   242: dup
    //   243: ldc 227
    //   245: invokespecial 228	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   248: athrow
    //   249: astore_1
    //   250: goto -45 -> 205
    //   253: astore_0
    //   254: goto -17 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramFile1	File
    //   0	257	1	paramFile2	File
    //   0	257	2	paramString	String
    //   4	163	3	bool	boolean
    //   103	68	4	localObject1	Object
    //   175	7	4	localThrowable	java.lang.Throwable
    //   188	34	4	localObject2	Object
    //   95	111	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   148	154	168	finally
    //   148	154	175	java/lang/Throwable
    //   177	180	180	finally
    //   105	124	211	finally
    //   131	148	211	finally
    //   158	162	211	finally
    //   190	194	211	finally
    //   201	205	211	finally
    //   209	211	211	finally
    //   219	221	211	finally
    //   105	124	215	java/lang/Throwable
    //   131	148	215	java/lang/Throwable
    //   158	162	215	java/lang/Throwable
    //   201	205	215	java/lang/Throwable
    //   209	211	215	java/lang/Throwable
    //   190	194	249	java/lang/Throwable
    //   226	230	253	java/lang/Throwable
  }
  
  public static File[] convertFileCollectionToFileArray(Collection<File> paramCollection)
  {
    return (File[])paramCollection.toArray(new File[paramCollection.size()]);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2)
  {
    copyDirectory(paramFile1, paramFile2, true);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    copyDirectory(paramFile1, paramFile2, paramFileFilter, true);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean)
  {
    checkFileRequirements(paramFile1, paramFile2);
    if (paramFile1.isDirectory())
    {
      if (!paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath()))
      {
        ArrayList localArrayList2 = null;
        ArrayList localArrayList1 = localArrayList2;
        if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath()))
        {
          File[] arrayOfFile;
          if (paramFileFilter == null) {
            arrayOfFile = paramFile1.listFiles();
          } else {
            arrayOfFile = paramFile1.listFiles(paramFileFilter);
          }
          localArrayList1 = localArrayList2;
          if (arrayOfFile != null)
          {
            localArrayList1 = localArrayList2;
            if (arrayOfFile.length > 0)
            {
              localArrayList2 = new ArrayList(arrayOfFile.length);
              int j = arrayOfFile.length;
              int i = 0;
              for (;;)
              {
                localArrayList1 = localArrayList2;
                if (i >= j) {
                  break;
                }
                localArrayList2.add(new File(paramFile2, arrayOfFile[i].getName()).getCanonicalPath());
                i += 1;
              }
            }
          }
        }
        doCopyDirectory(paramFile1, paramFile2, paramFileFilter, paramBoolean, localArrayList1);
        return;
      }
      paramFileFilter = new StringBuilder();
      paramFileFilter.append("Source '");
      paramFileFilter.append(paramFile1);
      paramFileFilter.append("' and destination '");
      paramFileFilter.append(paramFile2);
      paramFileFilter.append("' are the same");
      throw new IOException(paramFileFilter.toString());
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Source '");
    paramFile2.append(paramFile1);
    paramFile2.append("' exists but is not a directory");
    paramFile1 = new IOException(paramFile2.toString());
    for (;;)
    {
      throw paramFile1;
    }
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    copyDirectory(paramFile1, paramFile2, null, paramBoolean);
  }
  
  public static void copyDirectoryToDirectory(File paramFile1, File paramFile2)
  {
    if (paramFile1 != null)
    {
      if ((paramFile1.exists()) && (!paramFile1.isDirectory()))
      {
        paramFile1 = new StringBuilder();
        paramFile1.append("Source '");
        paramFile1.append(paramFile2);
        paramFile1.append("' is not a directory");
        throw new IllegalArgumentException(paramFile1.toString());
      }
      if (paramFile2 != null)
      {
        if ((paramFile2.exists()) && (!paramFile2.isDirectory()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' is not a directory");
          throw new IllegalArgumentException(paramFile1.toString());
        }
        copyDirectory(paramFile1, new File(paramFile2, paramFile1.getName()), true);
        return;
      }
      throw new NullPointerException("Destination must not be null");
    }
    throw new NullPointerException("Source must not be null");
  }
  
  /* Error */
  public static long copyFile(File paramFile, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: new 163	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: aload_1
    //   13: invokestatic 327	org/apache/commons/io/IOUtils:copyLarge	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   16: lstore_2
    //   17: aload 4
    //   19: invokevirtual 328	java/io/FileInputStream:close	()V
    //   22: lload_2
    //   23: lreturn
    //   24: astore_0
    //   25: aconst_null
    //   26: astore_1
    //   27: goto +7 -> 34
    //   30: astore_1
    //   31: aload_1
    //   32: athrow
    //   33: astore_0
    //   34: aload_1
    //   35: ifnull +11 -> 46
    //   38: aload 4
    //   40: invokevirtual 328	java/io/FileInputStream:close	()V
    //   43: goto +8 -> 51
    //   46: aload 4
    //   48: invokevirtual 328	java/io/FileInputStream:close	()V
    //   51: aload_0
    //   52: athrow
    //   53: astore_1
    //   54: goto -3 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramFile	File
    //   0	57	1	paramOutputStream	java.io.OutputStream
    //   16	7	2	l	long
    //   8	39	4	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   10	17	24	finally
    //   10	17	30	java/lang/Throwable
    //   31	33	33	finally
    //   38	43	53	java/lang/Throwable
  }
  
  public static void copyFile(File paramFile1, File paramFile2)
  {
    copyFile(paramFile1, paramFile2, true);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    checkFileRequirements(paramFile1, paramFile2);
    if (!paramFile1.isDirectory())
    {
      if (!paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath()))
      {
        localObject = paramFile2.getParentFile();
        if ((localObject != null) && (!((File)localObject).mkdirs()) && (!((File)localObject).isDirectory()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(localObject);
          paramFile1.append("' directory cannot be created");
          throw new IOException(paramFile1.toString());
        }
        if ((paramFile2.exists()) && (!paramFile2.canWrite()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' exists but is read-only");
          throw new IOException(paramFile1.toString());
        }
        doCopyFile(paramFile1, paramFile2, paramBoolean);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Source '");
      ((StringBuilder)localObject).append(paramFile1);
      ((StringBuilder)localObject).append("' and destination '");
      ((StringBuilder)localObject).append(paramFile2);
      ((StringBuilder)localObject).append("' are the same");
      throw new IOException(((StringBuilder)localObject).toString());
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Source '");
    paramFile2.append(paramFile1);
    paramFile2.append("' exists but is a directory");
    throw new IOException(paramFile2.toString());
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2)
  {
    copyFileToDirectory(paramFile1, paramFile2, true);
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile2 != null)
    {
      if ((paramFile2.exists()) && (!paramFile2.isDirectory()))
      {
        paramFile1 = new StringBuilder();
        paramFile1.append("Destination '");
        paramFile1.append(paramFile2);
        paramFile1.append("' is not a directory");
        throw new IllegalArgumentException(paramFile1.toString());
      }
      copyFile(paramFile1, new File(paramFile2, paramFile1.getName()), paramBoolean);
      return;
    }
    throw new NullPointerException("Destination must not be null");
  }
  
  /* Error */
  public static void copyInputStreamToFile(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 356	org/apache/commons/io/FileUtils:copyToFile	(Ljava/io/InputStream;Ljava/io/File;)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 182	java/io/InputStream:close	()V
    //   13: return
    //   14: astore_1
    //   15: aconst_null
    //   16: astore_2
    //   17: goto +7 -> 24
    //   20: astore_2
    //   21: aload_2
    //   22: athrow
    //   23: astore_1
    //   24: aload_0
    //   25: ifnull +18 -> 43
    //   28: aload_2
    //   29: ifnull +10 -> 39
    //   32: aload_0
    //   33: invokevirtual 182	java/io/InputStream:close	()V
    //   36: goto +7 -> 43
    //   39: aload_0
    //   40: invokevirtual 182	java/io/InputStream:close	()V
    //   43: aload_1
    //   44: athrow
    //   45: astore_0
    //   46: goto -3 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramInputStream	InputStream
    //   0	49	1	paramFile	File
    //   16	1	2	localObject	Object
    //   20	9	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	5	14	finally
    //   0	5	20	java/lang/Throwable
    //   21	23	23	finally
    //   32	36	45	java/lang/Throwable
  }
  
  public static void copyToDirectory(File paramFile1, File paramFile2)
  {
    if (paramFile1 != null)
    {
      if (paramFile1.isFile())
      {
        copyFileToDirectory(paramFile1, paramFile2);
        return;
      }
      if (paramFile1.isDirectory())
      {
        copyDirectoryToDirectory(paramFile1, paramFile2);
        return;
      }
      paramFile2 = new StringBuilder();
      paramFile2.append("The source ");
      paramFile2.append(paramFile1);
      paramFile2.append(" does not exist");
      throw new IOException(paramFile2.toString());
    }
    throw new NullPointerException("Source must not be null");
  }
  
  public static void copyToDirectory(Iterable<File> paramIterable, File paramFile)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        copyFileToDirectory((File)paramIterable.next(), paramFile);
      }
      return;
    }
    paramIterable = new NullPointerException("Sources must not be null");
    for (;;)
    {
      throw paramIterable;
    }
  }
  
  /* Error */
  public static void copyToFile(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_2
    //   6: aload_1
    //   7: invokestatic 389	org/apache/commons/io/FileUtils:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   10: astore 5
    //   12: aload_0
    //   13: aload 5
    //   15: invokestatic 177	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   18: pop
    //   19: aload 5
    //   21: ifnull +11 -> 32
    //   24: aload 4
    //   26: astore_2
    //   27: aload 5
    //   29: invokevirtual 392	java/io/OutputStream:close	()V
    //   32: aload_0
    //   33: ifnull +7 -> 40
    //   36: aload_0
    //   37: invokevirtual 182	java/io/InputStream:close	()V
    //   40: return
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_3
    //   44: goto +11 -> 55
    //   47: astore_1
    //   48: aload_1
    //   49: athrow
    //   50: astore_2
    //   51: aload_1
    //   52: astore_3
    //   53: aload_2
    //   54: astore_1
    //   55: aload 5
    //   57: ifnull +26 -> 83
    //   60: aload_3
    //   61: ifnull +14 -> 75
    //   64: aload 4
    //   66: astore_2
    //   67: aload 5
    //   69: invokevirtual 392	java/io/OutputStream:close	()V
    //   72: goto +11 -> 83
    //   75: aload 4
    //   77: astore_2
    //   78: aload 5
    //   80: invokevirtual 392	java/io/OutputStream:close	()V
    //   83: aload 4
    //   85: astore_2
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: goto +8 -> 97
    //   92: astore_1
    //   93: aload_1
    //   94: astore_2
    //   95: aload_1
    //   96: athrow
    //   97: aload_0
    //   98: ifnull +18 -> 116
    //   101: aload_2
    //   102: ifnull +10 -> 112
    //   105: aload_0
    //   106: invokevirtual 182	java/io/InputStream:close	()V
    //   109: goto +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 182	java/io/InputStream:close	()V
    //   116: aload_1
    //   117: athrow
    //   118: astore_2
    //   119: goto -36 -> 83
    //   122: astore_0
    //   123: goto -7 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramInputStream	InputStream
    //   0	126	1	paramFile	File
    //   5	22	2	localObject1	Object
    //   50	4	2	localObject2	Object
    //   66	36	2	localObject3	Object
    //   118	1	2	localThrowable	java.lang.Throwable
    //   43	18	3	localFile	File
    //   1	83	4	localObject4	Object
    //   10	69	5	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   12	19	41	finally
    //   12	19	47	java/lang/Throwable
    //   48	50	50	finally
    //   6	12	88	finally
    //   27	32	88	finally
    //   67	72	88	finally
    //   78	83	88	finally
    //   86	88	88	finally
    //   95	97	88	finally
    //   6	12	92	java/lang/Throwable
    //   27	32	92	java/lang/Throwable
    //   78	83	92	java/lang/Throwable
    //   86	88	92	java/lang/Throwable
    //   67	72	118	java/lang/Throwable
    //   105	109	122	java/lang/Throwable
  }
  
  public static void copyURLToFile(URL paramURL, File paramFile)
  {
    copyInputStreamToFile(paramURL.openStream(), paramFile);
  }
  
  public static void copyURLToFile(URL paramURL, File paramFile, int paramInt1, int paramInt2)
  {
    paramURL = paramURL.openConnection();
    paramURL.setConnectTimeout(paramInt1);
    paramURL.setReadTimeout(paramInt2);
    copyInputStreamToFile(paramURL.getInputStream(), paramFile);
  }
  
  /* Error */
  static String decodeUrl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 5
    //   3: aload_0
    //   4: ifnull +260 -> 264
    //   7: aload_0
    //   8: astore 5
    //   10: aload_0
    //   11: bipush 37
    //   13: invokevirtual 426	java/lang/String:indexOf	(I)I
    //   16: iflt +248 -> 264
    //   19: aload_0
    //   20: invokevirtual 428	java/lang/String:length	()I
    //   23: istore 4
    //   25: new 90	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   32: astore 5
    //   34: iload 4
    //   36: invokestatic 434	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   39: astore 6
    //   41: iconst_0
    //   42: istore_1
    //   43: iload_1
    //   44: iload 4
    //   46: if_icmpge +211 -> 257
    //   49: iload_1
    //   50: istore_3
    //   51: aload_0
    //   52: iload_1
    //   53: invokevirtual 438	java/lang/String:charAt	(I)C
    //   56: bipush 37
    //   58: if_icmpne +181 -> 239
    //   61: iload_1
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_3
    //   65: iadd
    //   66: istore_1
    //   67: aload 6
    //   69: aload_0
    //   70: iload_2
    //   71: iconst_1
    //   72: iadd
    //   73: iload_1
    //   74: invokevirtual 442	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: bipush 16
    //   79: invokestatic 448	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   82: i2b
    //   83: invokevirtual 452	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   86: pop
    //   87: iload_1
    //   88: iload 4
    //   90: if_icmpge +28 -> 118
    //   93: aload_0
    //   94: iload_1
    //   95: invokevirtual 438	java/lang/String:charAt	(I)C
    //   98: istore_2
    //   99: iload_2
    //   100: bipush 37
    //   102: if_icmpeq +6 -> 108
    //   105: goto +13 -> 118
    //   108: iload_1
    //   109: istore_2
    //   110: goto -47 -> 63
    //   113: iload_1
    //   114: istore_2
    //   115: goto +83 -> 198
    //   118: aload 6
    //   120: invokevirtual 455	java/nio/ByteBuffer:position	()I
    //   123: ifle +32 -> 155
    //   126: aload 6
    //   128: invokevirtual 459	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   131: pop
    //   132: aload 5
    //   134: getstatic 465	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   137: aload 6
    //   139: invokevirtual 469	java/nio/charset/Charset:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   142: invokevirtual 472	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   145: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 6
    //   151: invokevirtual 475	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   154: pop
    //   155: goto -112 -> 43
    //   158: astore_0
    //   159: aload 6
    //   161: invokevirtual 455	java/nio/ByteBuffer:position	()I
    //   164: ifle +32 -> 196
    //   167: aload 6
    //   169: invokevirtual 459	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   172: pop
    //   173: aload 5
    //   175: getstatic 465	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   178: aload 6
    //   180: invokevirtual 469	java/nio/charset/Charset:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   183: invokevirtual 472	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   186: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 6
    //   192: invokevirtual 475	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   195: pop
    //   196: aload_0
    //   197: athrow
    //   198: iload_2
    //   199: istore_3
    //   200: aload 6
    //   202: invokevirtual 455	java/nio/ByteBuffer:position	()I
    //   205: ifle +34 -> 239
    //   208: aload 6
    //   210: invokevirtual 459	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   213: pop
    //   214: aload 5
    //   216: getstatic 465	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   219: aload 6
    //   221: invokevirtual 469	java/nio/charset/Charset:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   224: invokevirtual 472	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   227: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 6
    //   233: invokevirtual 475	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   236: pop
    //   237: iload_2
    //   238: istore_3
    //   239: aload 5
    //   241: aload_0
    //   242: iload_3
    //   243: invokevirtual 438	java/lang/String:charAt	(I)C
    //   246: invokevirtual 478	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: iload_3
    //   251: iconst_1
    //   252: iadd
    //   253: istore_1
    //   254: goto -211 -> 43
    //   257: aload 5
    //   259: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: astore 5
    //   264: aload 5
    //   266: areturn
    //   267: astore 7
    //   269: goto -71 -> 198
    //   272: astore 7
    //   274: goto -161 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramString	String
    //   42	212	1	i	int
    //   62	176	2	j	int
    //   50	203	3	k	int
    //   23	68	4	m	int
    //   1	264	5	localObject	Object
    //   39	193	6	localByteBuffer	java.nio.ByteBuffer
    //   267	1	7	localRuntimeException1	RuntimeException
    //   272	1	7	localRuntimeException2	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   67	87	158	finally
    //   93	99	158	finally
    //   67	87	267	java/lang/RuntimeException
    //   93	99	272	java/lang/RuntimeException
  }
  
  public static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    if (!isSymlink(paramFile)) {
      cleanDirectory(paramFile);
    }
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to delete directory ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".");
    throw new IOException(localStringBuilder.toString());
  }
  
  private static void deleteDirectoryOnExit(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    paramFile.deleteOnExit();
    if (!isSymlink(paramFile)) {
      cleanDirectoryOnExit(paramFile);
    }
  }
  
  public static boolean deleteQuietly(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        cleanDirectory(paramFile);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          boolean bool = paramFile.delete();
          return bool;
        }
        catch (Exception paramFile) {}
        localException = localException;
      }
    }
    return false;
  }
  
  public static boolean directoryContains(File paramFile1, File paramFile2)
  {
    if (paramFile1 != null)
    {
      if (paramFile1.isDirectory())
      {
        if (paramFile2 == null) {
          return false;
        }
        if (paramFile1.exists())
        {
          if (!paramFile2.exists()) {
            return false;
          }
          return FilenameUtils.directoryContains(paramFile1.getCanonicalPath(), paramFile2.getCanonicalPath());
        }
        return false;
      }
      paramFile2 = new StringBuilder();
      paramFile2.append("Not a directory: ");
      paramFile2.append(paramFile1);
      throw new IllegalArgumentException(paramFile2.toString());
    }
    throw new IllegalArgumentException("Directory must not be null");
  }
  
  private static void doCopyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List<String> paramList)
  {
    File[] arrayOfFile;
    if (paramFileFilter == null) {
      arrayOfFile = paramFile1.listFiles();
    } else {
      arrayOfFile = paramFile1.listFiles(paramFileFilter);
    }
    if (arrayOfFile != null)
    {
      if (paramFile2.exists())
      {
        if (!paramFile2.isDirectory())
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' exists but is not a directory");
          throw new IOException(paramFile1.toString());
        }
      }
      else if ((!paramFile2.mkdirs()) && (!paramFile2.isDirectory()))
      {
        paramFile1 = new StringBuilder();
        paramFile1.append("Destination '");
        paramFile1.append(paramFile2);
        paramFile1.append("' directory cannot be created");
        throw new IOException(paramFile1.toString());
      }
      if (paramFile2.canWrite())
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile1 = arrayOfFile[i];
          File localFile2 = new File(paramFile2, localFile1.getName());
          if ((paramList == null) || (!paramList.contains(localFile1.getCanonicalPath()))) {
            if (localFile1.isDirectory()) {
              doCopyDirectory(localFile1, localFile2, paramFileFilter, paramBoolean, paramList);
            } else {
              doCopyFile(localFile1, localFile2, paramBoolean);
            }
          }
          i += 1;
        }
        if (paramBoolean) {
          paramFile2.setLastModified(paramFile1.lastModified());
        }
        return;
      }
      paramFile1 = new StringBuilder();
      paramFile1.append("Destination '");
      paramFile1.append(paramFile2);
      paramFile1.append("' cannot be written to");
      throw new IOException(paramFile1.toString());
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Failed to list contents of ");
    paramFile2.append(paramFile1);
    paramFile1 = new IOException(paramFile2.toString());
    for (;;)
    {
      throw paramFile1;
    }
  }
  
  /* Error */
  private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 124	java/io/File:exists	()Z
    //   4: ifeq +55 -> 59
    //   7: aload_1
    //   8: invokevirtual 127	java/io/File:isDirectory	()Z
    //   11: ifne +6 -> 17
    //   14: goto +45 -> 59
    //   17: new 90	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   24: astore_0
    //   25: aload_0
    //   26: ldc_w 321
    //   29: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_0
    //   40: ldc_w 348
    //   43: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: new 198	java/io/IOException
    //   50: dup
    //   51: aload_0
    //   52: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 228	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: new 163	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore 11
    //   69: aconst_null
    //   70: astore 10
    //   72: aload 10
    //   74: astore 9
    //   76: aload 11
    //   78: invokevirtual 530	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   81: astore 12
    //   83: new 532	java/io/FileOutputStream
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 533	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: astore 9
    //   93: aload 9
    //   95: invokevirtual 534	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   98: astore 13
    //   100: aload 12
    //   102: invokevirtual 538	java/nio/channels/FileChannel:size	()J
    //   105: lstore 7
    //   107: lconst_0
    //   108: lstore_3
    //   109: goto +347 -> 456
    //   112: aload 13
    //   114: aload 12
    //   116: lload_3
    //   117: lload 5
    //   119: invokevirtual 542	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   122: lstore 5
    //   124: lload 5
    //   126: lconst_0
    //   127: lcmp
    //   128: ifne +6 -> 134
    //   131: goto +11 -> 142
    //   134: lload_3
    //   135: lload 5
    //   137: ladd
    //   138: lstore_3
    //   139: goto +317 -> 456
    //   142: aload 13
    //   144: ifnull +8 -> 152
    //   147: aload 13
    //   149: invokevirtual 543	java/nio/channels/FileChannel:close	()V
    //   152: aload 9
    //   154: invokevirtual 544	java/io/FileOutputStream:close	()V
    //   157: aload 12
    //   159: ifnull +12 -> 171
    //   162: aload 10
    //   164: astore 9
    //   166: aload 12
    //   168: invokevirtual 543	java/nio/channels/FileChannel:close	()V
    //   171: aload 11
    //   173: invokevirtual 328	java/io/FileInputStream:close	()V
    //   176: aload_0
    //   177: invokevirtual 214	java/io/File:length	()J
    //   180: lstore_3
    //   181: aload_1
    //   182: invokevirtual 214	java/io/File:length	()J
    //   185: lstore 5
    //   187: lload_3
    //   188: lload 5
    //   190: lcmp
    //   191: ifne +17 -> 208
    //   194: iload_2
    //   195: ifeq +12 -> 207
    //   198: aload_1
    //   199: aload_0
    //   200: invokevirtual 517	java/io/File:lastModified	()J
    //   203: invokevirtual 521	java/io/File:setLastModified	(J)Z
    //   206: pop
    //   207: return
    //   208: new 90	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   215: astore 9
    //   217: aload 9
    //   219: ldc_w 546
    //   222: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 9
    //   228: aload_0
    //   229: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 9
    //   235: ldc_w 548
    //   238: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 9
    //   244: aload_1
    //   245: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 9
    //   251: ldc_w 550
    //   254: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 9
    //   260: lload_3
    //   261: invokevirtual 553	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 9
    //   267: ldc_w 555
    //   270: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 9
    //   276: lload 5
    //   278: invokevirtual 553	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: new 198	java/io/IOException
    //   285: dup
    //   286: aload 9
    //   288: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokespecial 228	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   294: athrow
    //   295: astore_0
    //   296: aconst_null
    //   297: astore_1
    //   298: goto +7 -> 305
    //   301: astore_1
    //   302: aload_1
    //   303: athrow
    //   304: astore_0
    //   305: aload 13
    //   307: ifnull +20 -> 327
    //   310: aload_1
    //   311: ifnull +11 -> 322
    //   314: aload 13
    //   316: invokevirtual 543	java/nio/channels/FileChannel:close	()V
    //   319: goto +8 -> 327
    //   322: aload 13
    //   324: invokevirtual 543	java/nio/channels/FileChannel:close	()V
    //   327: aload_0
    //   328: athrow
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_1
    //   332: goto +7 -> 339
    //   335: astore_1
    //   336: aload_1
    //   337: athrow
    //   338: astore_0
    //   339: aload_1
    //   340: ifnull +11 -> 351
    //   343: aload 9
    //   345: invokevirtual 544	java/io/FileOutputStream:close	()V
    //   348: goto +8 -> 356
    //   351: aload 9
    //   353: invokevirtual 544	java/io/FileOutputStream:close	()V
    //   356: aload_0
    //   357: athrow
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_1
    //   361: goto +7 -> 368
    //   364: astore_1
    //   365: aload_1
    //   366: athrow
    //   367: astore_0
    //   368: aload 12
    //   370: ifnull +28 -> 398
    //   373: aload_1
    //   374: ifnull +15 -> 389
    //   377: aload 10
    //   379: astore 9
    //   381: aload 12
    //   383: invokevirtual 543	java/nio/channels/FileChannel:close	()V
    //   386: goto +12 -> 398
    //   389: aload 10
    //   391: astore 9
    //   393: aload 12
    //   395: invokevirtual 543	java/nio/channels/FileChannel:close	()V
    //   398: aload 10
    //   400: astore 9
    //   402: aload_0
    //   403: athrow
    //   404: astore_0
    //   405: goto +9 -> 414
    //   408: astore_0
    //   409: aload_0
    //   410: astore 9
    //   412: aload_0
    //   413: athrow
    //   414: aload 9
    //   416: ifnull +11 -> 427
    //   419: aload 11
    //   421: invokevirtual 328	java/io/FileInputStream:close	()V
    //   424: goto +8 -> 432
    //   427: aload 11
    //   429: invokevirtual 328	java/io/FileInputStream:close	()V
    //   432: goto +5 -> 437
    //   435: aload_0
    //   436: athrow
    //   437: goto -2 -> 435
    //   440: astore_1
    //   441: goto -114 -> 327
    //   444: astore_1
    //   445: goto -89 -> 356
    //   448: astore_1
    //   449: goto -51 -> 398
    //   452: astore_1
    //   453: goto -21 -> 432
    //   456: lload_3
    //   457: lload 7
    //   459: lcmp
    //   460: ifge -318 -> 142
    //   463: lload 7
    //   465: lload_3
    //   466: lsub
    //   467: lstore 5
    //   469: lload 5
    //   471: ldc2_w 9
    //   474: lcmp
    //   475: ifle +11 -> 486
    //   478: ldc2_w 9
    //   481: lstore 5
    //   483: goto -371 -> 112
    //   486: goto -374 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramFile1	File
    //   0	489	1	paramFile2	File
    //   0	489	2	paramBoolean	boolean
    //   108	358	3	l1	long
    //   117	1	5	localObject1	Object
    //   122	360	5	l2	long
    //   105	359	7	l3	long
    //   74	341	9	localObject2	Object
    //   70	329	10	localObject3	Object
    //   67	361	11	localFileInputStream	FileInputStream
    //   81	313	12	localFileChannel1	java.nio.channels.FileChannel
    //   98	225	13	localFileChannel2	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   100	107	295	finally
    //   112	124	295	finally
    //   100	107	301	java/lang/Throwable
    //   112	124	301	java/lang/Throwable
    //   302	304	304	finally
    //   93	100	329	finally
    //   147	152	329	finally
    //   314	319	329	finally
    //   322	327	329	finally
    //   327	329	329	finally
    //   93	100	335	java/lang/Throwable
    //   147	152	335	java/lang/Throwable
    //   322	327	335	java/lang/Throwable
    //   327	329	335	java/lang/Throwable
    //   336	338	338	finally
    //   83	93	358	finally
    //   152	157	358	finally
    //   343	348	358	finally
    //   351	356	358	finally
    //   356	358	358	finally
    //   83	93	364	java/lang/Throwable
    //   152	157	364	java/lang/Throwable
    //   351	356	364	java/lang/Throwable
    //   356	358	364	java/lang/Throwable
    //   365	367	367	finally
    //   76	83	404	finally
    //   166	171	404	finally
    //   381	386	404	finally
    //   393	398	404	finally
    //   402	404	404	finally
    //   412	414	404	finally
    //   76	83	408	java/lang/Throwable
    //   166	171	408	java/lang/Throwable
    //   393	398	408	java/lang/Throwable
    //   402	404	408	java/lang/Throwable
    //   314	319	440	java/lang/Throwable
    //   343	348	444	java/lang/Throwable
    //   381	386	448	java/lang/Throwable
    //   419	424	452	java/lang/Throwable
  }
  
  public static void forceDelete(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      deleteDirectory(paramFile);
      return;
    }
    boolean bool = paramFile.exists();
    if (!paramFile.delete())
    {
      if (!bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File does not exist: ");
        localStringBuilder.append(paramFile);
        throw new FileNotFoundException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to delete file: ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public static void forceDeleteOnExit(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      deleteDirectoryOnExit(paramFile);
      return;
    }
    paramFile.deleteOnExit();
  }
  
  public static void forceMkdir(File paramFile)
  {
    StringBuilder localStringBuilder;
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("File ");
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" exists and is not a directory. Unable to create directory.");
      throw new IOException(localStringBuilder.toString());
    }
    if (!paramFile.mkdirs())
    {
      if (paramFile.isDirectory()) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to create directory ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public static void forceMkdirParent(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if (paramFile == null) {
      return;
    }
    forceMkdir(paramFile);
  }
  
  public static File getFile(File paramFile, String... paramVarArgs)
  {
    if (paramFile != null)
    {
      if (paramVarArgs != null)
      {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          paramFile = new File(paramFile, paramVarArgs[i]);
          i += 1;
        }
        return paramFile;
      }
      throw new NullPointerException("names must not be null");
    }
    paramFile = new NullPointerException("directory must not be null");
    for (;;)
    {
      throw paramFile;
    }
  }
  
  public static File getFile(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      File localFile = null;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (localFile == null) {
          localFile = new File(str);
        } else {
          localFile = new File(localFile, str);
        }
        i += 1;
      }
      return localFile;
    }
    paramVarArgs = new NullPointerException("names must not be null");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  public static File getTempDirectory()
  {
    return new File(getTempDirectoryPath());
  }
  
  public static String getTempDirectoryPath()
  {
    return System.getProperty("java.io.tmpdir");
  }
  
  public static File getUserDirectory()
  {
    return new File(getUserDirectoryPath());
  }
  
  public static String getUserDirectoryPath()
  {
    return System.getProperty("user.home");
  }
  
  private static void innerListFiles(Collection<File> paramCollection, File paramFile, IOFileFilter paramIOFileFilter, boolean paramBoolean)
  {
    paramFile = paramFile.listFiles(paramIOFileFilter);
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (localObject.isDirectory())
        {
          if (paramBoolean) {
            paramCollection.add(localObject);
          }
          innerListFiles(paramCollection, localObject, paramIOFileFilter, paramBoolean);
        }
        else
        {
          paramCollection.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  public static boolean isFileNewer(File paramFile, long paramLong)
  {
    if (paramFile != null)
    {
      boolean bool2 = paramFile.exists();
      boolean bool1 = false;
      if (!bool2) {
        return false;
      }
      if (paramFile.lastModified() > paramLong) {
        bool1 = true;
      }
      return bool1;
    }
    throw new IllegalArgumentException("No specified file");
  }
  
  public static boolean isFileNewer(File paramFile1, File paramFile2)
  {
    if (paramFile2 != null)
    {
      if (paramFile2.exists()) {
        return isFileNewer(paramFile1, paramFile2.lastModified());
      }
      paramFile1 = new StringBuilder();
      paramFile1.append("The reference file '");
      paramFile1.append(paramFile2);
      paramFile1.append("' doesn't exist");
      throw new IllegalArgumentException(paramFile1.toString());
    }
    throw new IllegalArgumentException("No specified reference file");
  }
  
  public static boolean isFileNewer(File paramFile, Date paramDate)
  {
    if (paramDate != null) {
      return isFileNewer(paramFile, paramDate.getTime());
    }
    throw new IllegalArgumentException("No specified date");
  }
  
  public static boolean isFileOlder(File paramFile, long paramLong)
  {
    if (paramFile != null)
    {
      boolean bool2 = paramFile.exists();
      boolean bool1 = false;
      if (!bool2) {
        return false;
      }
      if (paramFile.lastModified() < paramLong) {
        bool1 = true;
      }
      return bool1;
    }
    throw new IllegalArgumentException("No specified file");
  }
  
  public static boolean isFileOlder(File paramFile1, File paramFile2)
  {
    if (paramFile2 != null)
    {
      if (paramFile2.exists()) {
        return isFileOlder(paramFile1, paramFile2.lastModified());
      }
      paramFile1 = new StringBuilder();
      paramFile1.append("The reference file '");
      paramFile1.append(paramFile2);
      paramFile1.append("' doesn't exist");
      throw new IllegalArgumentException(paramFile1.toString());
    }
    throw new IllegalArgumentException("No specified reference file");
  }
  
  public static boolean isFileOlder(File paramFile, Date paramDate)
  {
    if (paramDate != null) {
      return isFileOlder(paramFile, paramDate.getTime());
    }
    throw new IllegalArgumentException("No specified date");
  }
  
  public static boolean isSymlink(File paramFile)
  {
    if (paramFile != null) {
      return Files.isSymbolicLink(paramFile.toPath());
    }
    throw new NullPointerException("File must not be null");
  }
  
  public static Iterator<File> iterateFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    return listFiles(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
  }
  
  public static Iterator<File> iterateFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean)
  {
    return listFiles(paramFile, paramArrayOfString, paramBoolean).iterator();
  }
  
  public static Iterator<File> iterateFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    return listFilesAndDirs(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
  }
  
  public static LineIterator lineIterator(File paramFile)
  {
    return lineIterator(paramFile, null);
  }
  
  public static LineIterator lineIterator(File paramFile, String paramString)
  {
    File localFile2 = null;
    File localFile1 = null;
    try
    {
      paramFile = openInputStream(paramFile);
      localFile1 = paramFile;
      localFile2 = paramFile;
      paramFile = IOUtils.lineIterator(paramFile, paramString);
      return paramFile;
    }
    catch (RuntimeException paramFile) {}catch (IOException paramFile)
    {
      localFile1 = localFile2;
    }
    if (localFile1 != null) {}
    try
    {
      localFile1.close();
      label36:
      throw paramFile;
    }
    catch (IOException paramString)
    {
      break label36;
    }
  }
  
  public static Collection<File> listFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    validateListFilesParameters(paramFile, paramIOFileFilter1);
    paramIOFileFilter1 = setUpEffectiveFileFilter(paramIOFileFilter1);
    paramIOFileFilter2 = setUpEffectiveDirFilter(paramIOFileFilter2);
    LinkedList localLinkedList = new LinkedList();
    innerListFiles(localLinkedList, paramFile, FileFilterUtils.or(new IOFileFilter[] { paramIOFileFilter1, paramIOFileFilter2 }), false);
    return localLinkedList;
  }
  
  public static Collection<File> listFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {
      paramArrayOfString = TrueFileFilter.INSTANCE;
    } else {
      paramArrayOfString = new SuffixFileFilter(toSuffixes(paramArrayOfString));
    }
    IOFileFilter localIOFileFilter;
    if (paramBoolean) {
      localIOFileFilter = TrueFileFilter.INSTANCE;
    } else {
      localIOFileFilter = FalseFileFilter.INSTANCE;
    }
    return listFiles(paramFile, paramArrayOfString, localIOFileFilter);
  }
  
  public static Collection<File> listFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    validateListFilesParameters(paramFile, paramIOFileFilter1);
    paramIOFileFilter1 = setUpEffectiveFileFilter(paramIOFileFilter1);
    paramIOFileFilter2 = setUpEffectiveDirFilter(paramIOFileFilter2);
    LinkedList localLinkedList = new LinkedList();
    if (paramFile.isDirectory()) {
      localLinkedList.add(paramFile);
    }
    innerListFiles(localLinkedList, paramFile, FileFilterUtils.or(new IOFileFilter[] { paramIOFileFilter1, paramIOFileFilter2 }), true);
    return localLinkedList;
  }
  
  public static void moveDirectory(File paramFile1, File paramFile2)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 != null)
      {
        if (paramFile1.exists())
        {
          if (paramFile1.isDirectory())
          {
            if (!paramFile2.exists())
            {
              if (!paramFile1.renameTo(paramFile2))
              {
                Object localObject = paramFile2.getCanonicalPath();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(paramFile1.getCanonicalPath());
                localStringBuilder.append(File.separator);
                if (!((String)localObject).startsWith(localStringBuilder.toString()))
                {
                  copyDirectory(paramFile1, paramFile2);
                  deleteDirectory(paramFile1);
                  if (!paramFile1.exists()) {
                    return;
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("Failed to delete original directory '");
                  ((StringBuilder)localObject).append(paramFile1);
                  ((StringBuilder)localObject).append("' after copy to '");
                  ((StringBuilder)localObject).append(paramFile2);
                  ((StringBuilder)localObject).append("'");
                  throw new IOException(((StringBuilder)localObject).toString());
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Cannot move directory: ");
                ((StringBuilder)localObject).append(paramFile1);
                ((StringBuilder)localObject).append(" to a subdirectory of itself: ");
                ((StringBuilder)localObject).append(paramFile2);
                throw new IOException(((StringBuilder)localObject).toString());
              }
              return;
            }
            paramFile1 = new StringBuilder();
            paramFile1.append("Destination '");
            paramFile1.append(paramFile2);
            paramFile1.append("' already exists");
            throw new FileExistsException(paramFile1.toString());
          }
          paramFile2 = new StringBuilder();
          paramFile2.append("Source '");
          paramFile2.append(paramFile1);
          paramFile2.append("' is not a directory");
          throw new IOException(paramFile2.toString());
        }
        paramFile2 = new StringBuilder();
        paramFile2.append("Source '");
        paramFile2.append(paramFile1);
        paramFile2.append("' does not exist");
        throw new FileNotFoundException(paramFile2.toString());
      }
      throw new NullPointerException("Destination must not be null");
    }
    throw new NullPointerException("Source must not be null");
  }
  
  public static void moveDirectoryToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 != null)
      {
        if ((!paramFile2.exists()) && (paramBoolean)) {
          paramFile2.mkdirs();
        }
        if (paramFile2.exists())
        {
          if (paramFile2.isDirectory())
          {
            moveDirectory(paramFile1, new File(paramFile2, paramFile1.getName()));
            return;
          }
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' is not a directory");
          throw new IOException(paramFile1.toString());
        }
        paramFile1 = new StringBuilder();
        paramFile1.append("Destination directory '");
        paramFile1.append(paramFile2);
        paramFile1.append("' does not exist [createDestDir=");
        paramFile1.append(paramBoolean);
        paramFile1.append("]");
        throw new FileNotFoundException(paramFile1.toString());
      }
      throw new NullPointerException("Destination directory must not be null");
    }
    throw new NullPointerException("Source must not be null");
  }
  
  public static void moveFile(File paramFile1, File paramFile2)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 != null)
      {
        if (paramFile1.exists())
        {
          if (!paramFile1.isDirectory())
          {
            if (!paramFile2.exists())
            {
              if (!paramFile2.isDirectory())
              {
                if (!paramFile1.renameTo(paramFile2))
                {
                  copyFile(paramFile1, paramFile2);
                  if (paramFile1.delete()) {
                    return;
                  }
                  deleteQuietly(paramFile2);
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("Failed to delete original file '");
                  localStringBuilder.append(paramFile1);
                  localStringBuilder.append("' after copy to '");
                  localStringBuilder.append(paramFile2);
                  localStringBuilder.append("'");
                  throw new IOException(localStringBuilder.toString());
                }
                return;
              }
              paramFile1 = new StringBuilder();
              paramFile1.append("Destination '");
              paramFile1.append(paramFile2);
              paramFile1.append("' is a directory");
              throw new IOException(paramFile1.toString());
            }
            paramFile1 = new StringBuilder();
            paramFile1.append("Destination '");
            paramFile1.append(paramFile2);
            paramFile1.append("' already exists");
            throw new FileExistsException(paramFile1.toString());
          }
          paramFile2 = new StringBuilder();
          paramFile2.append("Source '");
          paramFile2.append(paramFile1);
          paramFile2.append("' is a directory");
          throw new IOException(paramFile2.toString());
        }
        paramFile2 = new StringBuilder();
        paramFile2.append("Source '");
        paramFile2.append(paramFile1);
        paramFile2.append("' does not exist");
        throw new FileNotFoundException(paramFile2.toString());
      }
      throw new NullPointerException("Destination must not be null");
    }
    throw new NullPointerException("Source must not be null");
  }
  
  public static void moveFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 != null)
      {
        if ((!paramFile2.exists()) && (paramBoolean)) {
          paramFile2.mkdirs();
        }
        if (paramFile2.exists())
        {
          if (paramFile2.isDirectory())
          {
            moveFile(paramFile1, new File(paramFile2, paramFile1.getName()));
            return;
          }
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' is not a directory");
          throw new IOException(paramFile1.toString());
        }
        paramFile1 = new StringBuilder();
        paramFile1.append("Destination directory '");
        paramFile1.append(paramFile2);
        paramFile1.append("' does not exist [createDestDir=");
        paramFile1.append(paramBoolean);
        paramFile1.append("]");
        throw new FileNotFoundException(paramFile1.toString());
      }
      throw new NullPointerException("Destination directory must not be null");
    }
    throw new NullPointerException("Source must not be null");
  }
  
  public static void moveToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 != null)
      {
        if (paramFile1.exists())
        {
          if (paramFile1.isDirectory())
          {
            moveDirectoryToDirectory(paramFile1, paramFile2, paramBoolean);
            return;
          }
          moveFileToDirectory(paramFile1, paramFile2, paramBoolean);
          return;
        }
        paramFile2 = new StringBuilder();
        paramFile2.append("Source '");
        paramFile2.append(paramFile1);
        paramFile2.append("' does not exist");
        throw new FileNotFoundException(paramFile2.toString());
      }
      throw new NullPointerException("Destination must not be null");
    }
    throw new NullPointerException("Source must not be null");
  }
  
  public static FileInputStream openInputStream(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        if (paramFile.canRead()) {
          return new FileInputStream(paramFile);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File '");
        localStringBuilder.append(paramFile);
        localStringBuilder.append("' cannot be read");
        throw new IOException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("File '");
      localStringBuilder.append(paramFile);
      localStringBuilder.append("' exists but is a directory");
      throw new IOException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("File '");
    localStringBuilder.append(paramFile);
    localStringBuilder.append("' does not exist");
    throw new FileNotFoundException(localStringBuilder.toString());
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
  {
    return openOutputStream(paramFile, false);
  }
  
  public static FileOutputStream openOutputStream(File paramFile, boolean paramBoolean)
  {
    Object localObject;
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        if (!paramFile.canWrite())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("File '");
          ((StringBuilder)localObject).append(paramFile);
          ((StringBuilder)localObject).append("' cannot be written to");
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("File '");
        ((StringBuilder)localObject).append(paramFile);
        ((StringBuilder)localObject).append("' exists but is a directory");
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = paramFile.getParentFile();
      if ((localObject != null) && (!((File)localObject).mkdirs()) && (!((File)localObject).isDirectory()))
      {
        paramFile = new StringBuilder();
        paramFile.append("Directory '");
        paramFile.append(localObject);
        paramFile.append("' could not be created");
        throw new IOException(paramFile.toString());
      }
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }
  
  /* Error */
  public static byte[] readFileToByteArray(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 664	org/apache/commons/io/FileUtils:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: aload_0
    //   13: invokevirtual 214	java/io/File:length	()J
    //   16: lstore_1
    //   17: lload_1
    //   18: lconst_0
    //   19: lcmp
    //   20: ifle +16 -> 36
    //   23: aload 4
    //   25: astore_3
    //   26: aload 5
    //   28: lload_1
    //   29: invokestatic 788	org/apache/commons/io/IOUtils:toByteArray	(Ljava/io/InputStream;J)[B
    //   32: astore_0
    //   33: goto +12 -> 45
    //   36: aload 4
    //   38: astore_3
    //   39: aload 5
    //   41: invokestatic 791	org/apache/commons/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   44: astore_0
    //   45: aload 5
    //   47: ifnull +8 -> 55
    //   50: aload 5
    //   52: invokevirtual 182	java/io/InputStream:close	()V
    //   55: aload_0
    //   56: areturn
    //   57: astore_0
    //   58: goto +8 -> 66
    //   61: astore_0
    //   62: aload_0
    //   63: astore_3
    //   64: aload_0
    //   65: athrow
    //   66: aload 5
    //   68: ifnull +20 -> 88
    //   71: aload_3
    //   72: ifnull +11 -> 83
    //   75: aload 5
    //   77: invokevirtual 182	java/io/InputStream:close	()V
    //   80: goto +8 -> 88
    //   83: aload 5
    //   85: invokevirtual 182	java/io/InputStream:close	()V
    //   88: aload_0
    //   89: athrow
    //   90: astore_3
    //   91: goto -3 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramFile	File
    //   16	13	1	l	long
    //   11	61	3	localObject1	Object
    //   90	1	3	localThrowable	java.lang.Throwable
    //   7	30	4	localObject2	Object
    //   4	80	5	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   12	17	57	finally
    //   26	33	57	finally
    //   39	45	57	finally
    //   64	66	57	finally
    //   12	17	61	java/lang/Throwable
    //   26	33	61	java/lang/Throwable
    //   39	45	61	java/lang/Throwable
    //   75	80	90	java/lang/Throwable
  }
  
  @Deprecated
  public static String readFileToString(File paramFile)
  {
    return readFileToString(paramFile, Charset.defaultCharset());
  }
  
  public static String readFileToString(File paramFile, String paramString)
  {
    return readFileToString(paramFile, Charsets.toCharset(paramString));
  }
  
  /* Error */
  public static String readFileToString(File paramFile, Charset paramCharset)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 664	org/apache/commons/io/FileUtils:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_0
    //   7: aload_2
    //   8: aload_1
    //   9: invokestatic 808	org/apache/commons/io/Charsets:toCharset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   12: invokestatic 811	org/apache/commons/io/IOUtils:toString	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_2
    //   17: ifnull +7 -> 24
    //   20: aload_2
    //   21: invokevirtual 182	java/io/InputStream:close	()V
    //   24: aload_1
    //   25: areturn
    //   26: astore_1
    //   27: goto +8 -> 35
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: athrow
    //   35: aload_2
    //   36: ifnull +18 -> 54
    //   39: aload_0
    //   40: ifnull +10 -> 50
    //   43: aload_2
    //   44: invokevirtual 182	java/io/InputStream:close	()V
    //   47: goto +7 -> 54
    //   50: aload_2
    //   51: invokevirtual 182	java/io/InputStream:close	()V
    //   54: aload_1
    //   55: athrow
    //   56: astore_0
    //   57: goto -3 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramFile	File
    //   0	60	1	paramCharset	Charset
    //   4	47	2	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   7	16	26	finally
    //   33	35	26	finally
    //   7	16	30	java/lang/Throwable
    //   43	47	56	java/lang/Throwable
  }
  
  @Deprecated
  public static List<String> readLines(File paramFile)
  {
    return readLines(paramFile, Charset.defaultCharset());
  }
  
  public static List<String> readLines(File paramFile, String paramString)
  {
    return readLines(paramFile, Charsets.toCharset(paramString));
  }
  
  /* Error */
  public static List<String> readLines(File paramFile, Charset paramCharset)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 664	org/apache/commons/io/FileUtils:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_0
    //   7: aload_2
    //   8: aload_1
    //   9: invokestatic 808	org/apache/commons/io/Charsets:toCharset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   12: invokestatic 822	org/apache/commons/io/IOUtils:readLines	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/util/List;
    //   15: astore_1
    //   16: aload_2
    //   17: ifnull +7 -> 24
    //   20: aload_2
    //   21: invokevirtual 182	java/io/InputStream:close	()V
    //   24: aload_1
    //   25: areturn
    //   26: astore_1
    //   27: goto +8 -> 35
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: athrow
    //   35: aload_2
    //   36: ifnull +18 -> 54
    //   39: aload_0
    //   40: ifnull +10 -> 50
    //   43: aload_2
    //   44: invokevirtual 182	java/io/InputStream:close	()V
    //   47: goto +7 -> 54
    //   50: aload_2
    //   51: invokevirtual 182	java/io/InputStream:close	()V
    //   54: aload_1
    //   55: athrow
    //   56: astore_0
    //   57: goto -3 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramFile	File
    //   0	60	1	paramCharset	Charset
    //   4	47	2	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   7	16	26	finally
    //   33	35	26	finally
    //   7	16	30	java/lang/Throwable
    //   43	47	56	java/lang/Throwable
  }
  
  private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter == null) {
      return FalseFileFilter.INSTANCE;
    }
    return FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, DirectoryFileFilter.INSTANCE });
  }
  
  private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter paramIOFileFilter)
  {
    return FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE) });
  }
  
  public static long sizeOf(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        return sizeOfDirectory0(paramFile);
      }
      return paramFile.length();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(" does not exist");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static long sizeOf0(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return sizeOfDirectory0(paramFile);
    }
    return paramFile.length();
  }
  
  public static BigInteger sizeOfAsBigInteger(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        return sizeOfDirectoryBig0(paramFile);
      }
      return BigInteger.valueOf(paramFile.length());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(" does not exist");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static BigInteger sizeOfBig0(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return sizeOfDirectoryBig0(paramFile);
    }
    return BigInteger.valueOf(paramFile.length());
  }
  
  public static long sizeOfDirectory(File paramFile)
  {
    checkDirectory(paramFile);
    return sizeOfDirectory0(paramFile);
  }
  
  private static long sizeOfDirectory0(File paramFile)
  {
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return 0L;
    }
    int j = paramFile.length;
    int i = 0;
    for (l1 = 0L; i < j; l1 = l2)
    {
      File localFile = paramFile[i];
      l2 = l1;
      try
      {
        if (!isSymlink(localFile))
        {
          l2 = sizeOf0(localFile);
          l1 += l2;
          l2 = l1;
          if (l1 < 0L) {
            return l1;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          l2 = l1;
        }
      }
      i += 1;
    }
    return l1;
  }
  
  public static BigInteger sizeOfDirectoryAsBigInteger(File paramFile)
  {
    checkDirectory(paramFile);
    return sizeOfDirectoryBig0(paramFile);
  }
  
  private static BigInteger sizeOfDirectoryBig0(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      return BigInteger.ZERO;
    }
    paramFile = BigInteger.ZERO;
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      File localFile2;
      Object localObject;
      if (i < j)
      {
        localFile2 = arrayOfFile[i];
        localObject = paramFile;
      }
      try
      {
        if (!isSymlink(localFile2)) {
          localObject = paramFile.add(sizeOfBig0(localFile2));
        }
        i += 1;
        paramFile = (File)localObject;
        continue;
        return paramFile;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          File localFile1 = paramFile;
        }
      }
    }
  }
  
  public static File toFile(URL paramURL)
  {
    if ((paramURL != null) && ("file".equalsIgnoreCase(paramURL.getProtocol()))) {
      return new File(decodeUrl(paramURL.getFile().replace('/', File.separatorChar)));
    }
    return null;
  }
  
  public static File[] toFiles(URL[] paramArrayOfURL)
  {
    if ((paramArrayOfURL != null) && (paramArrayOfURL.length != 0))
    {
      File[] arrayOfFile = new File[paramArrayOfURL.length];
      int i = 0;
      while (i < paramArrayOfURL.length)
      {
        URL localURL = paramArrayOfURL[i];
        if (localURL != null) {
          if (localURL.getProtocol().equals("file"))
          {
            arrayOfFile[i] = toFile(localURL);
          }
          else
          {
            paramArrayOfURL = new StringBuilder();
            paramArrayOfURL.append("URL could not be converted to a File: ");
            paramArrayOfURL.append(localURL);
            throw new IllegalArgumentException(paramArrayOfURL.toString());
          }
        }
        i += 1;
      }
      return arrayOfFile;
    }
    return EMPTY_FILE_ARRAY;
  }
  
  private static String[] toSuffixes(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(".");
      localStringBuilder.append(paramArrayOfString[i]);
      arrayOfString[i] = localStringBuilder.toString();
      i += 1;
    }
    return arrayOfString;
  }
  
  public static URL[] toURLs(File[] paramArrayOfFile)
  {
    URL[] arrayOfURL = new URL[paramArrayOfFile.length];
    int i = 0;
    while (i < arrayOfURL.length)
    {
      arrayOfURL[i] = paramArrayOfFile[i].toURI().toURL();
      i += 1;
    }
    return arrayOfURL;
  }
  
  public static void touch(File paramFile)
  {
    if (!paramFile.exists()) {
      openOutputStream(paramFile).close();
    }
    if (paramFile.setLastModified(System.currentTimeMillis())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to set the last modification time for ");
    localStringBuilder.append(paramFile);
    throw new IOException(localStringBuilder.toString());
  }
  
  private static void validateListFilesParameters(File paramFile, IOFileFilter paramIOFileFilter)
  {
    if (paramFile.isDirectory())
    {
      if (paramIOFileFilter != null) {
        return;
      }
      throw new NullPointerException("Parameter 'fileFilter' is null");
    }
    paramIOFileFilter = new StringBuilder();
    paramIOFileFilter.append("Parameter 'directory' is not a directory: ");
    paramIOFileFilter.append(paramFile);
    throw new IllegalArgumentException(paramIOFileFilter.toString());
  }
  
  private static File[] verifiedListFiles(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        localObject = paramFile.listFiles();
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to list contents of ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(" is not a directory");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(" does not exist");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static boolean waitFor(File paramFile, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramInt;
    for (paramInt = 0;; paramInt = 1) {
      for (;;)
      {
        try
        {
          if (!paramFile.exists())
          {
            l3 = System.currentTimeMillis();
            l3 = l1 + l2 * 1000L - l3;
            if (l3 < 0L)
            {
              if (paramInt != 0) {
                Thread.currentThread().interrupt();
              }
              return false;
            }
          }
        }
        finally
        {
          long l3;
          if (paramInt != 0) {
            Thread.currentThread().interrupt();
          }
          continue;
          throw paramFile;
          continue;
        }
        try
        {
          Thread.sleep(Math.min(100L, l3));
        }
        catch (InterruptedException localInterruptedException) {}catch (Exception paramFile) {}
      }
    }
    if (paramInt != 0) {
      Thread.currentThread().interrupt();
    }
    return true;
  }
  
  @Deprecated
  public static void write(File paramFile, CharSequence paramCharSequence)
  {
    write(paramFile, paramCharSequence, Charset.defaultCharset(), false);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, String paramString)
  {
    write(paramFile, paramCharSequence, paramString, false);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    write(paramFile, paramCharSequence, Charsets.toCharset(paramString), paramBoolean);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset)
  {
    write(paramFile, paramCharSequence, paramCharset, false);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      paramCharSequence = null;
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    writeStringToFile(paramFile, paramCharSequence, paramCharset, paramBoolean);
  }
  
  @Deprecated
  public static void write(File paramFile, CharSequence paramCharSequence, boolean paramBoolean)
  {
    write(paramFile, paramCharSequence, Charset.defaultCharset(), paramBoolean);
  }
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte)
  {
    writeByteArrayToFile(paramFile, paramArrayOfByte, false);
  }
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    writeByteArrayToFile(paramFile, paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  /* Error */
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload 4
    //   3: invokestatic 775	org/apache/commons/io/FileUtils:openOutputStream	(Ljava/io/File;Z)Ljava/io/FileOutputStream;
    //   6: astore 5
    //   8: aload 5
    //   10: aload_1
    //   11: iload_2
    //   12: iload_3
    //   13: invokevirtual 960	java/io/OutputStream:write	([BII)V
    //   16: aload 5
    //   18: ifnull +8 -> 26
    //   21: aload 5
    //   23: invokevirtual 392	java/io/OutputStream:close	()V
    //   26: return
    //   27: astore_0
    //   28: aconst_null
    //   29: astore_1
    //   30: goto +7 -> 37
    //   33: astore_1
    //   34: aload_1
    //   35: athrow
    //   36: astore_0
    //   37: aload 5
    //   39: ifnull +20 -> 59
    //   42: aload_1
    //   43: ifnull +11 -> 54
    //   46: aload 5
    //   48: invokevirtual 392	java/io/OutputStream:close	()V
    //   51: goto +8 -> 59
    //   54: aload 5
    //   56: invokevirtual 392	java/io/OutputStream:close	()V
    //   59: aload_0
    //   60: athrow
    //   61: astore_1
    //   62: goto -3 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramFile	File
    //   0	65	1	paramArrayOfByte	byte[]
    //   0	65	2	paramInt1	int
    //   0	65	3	paramInt2	int
    //   0	65	4	paramBoolean	boolean
    //   6	49	5	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   8	16	27	finally
    //   8	16	33	java/lang/Throwable
    //   34	36	36	finally
    //   46	51	61	java/lang/Throwable
  }
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    writeByteArrayToFile(paramFile, paramArrayOfByte, 0, paramArrayOfByte.length, paramBoolean);
  }
  
  public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection)
  {
    writeLines(paramFile, paramString, paramCollection, null, false);
  }
  
  public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2)
  {
    writeLines(paramFile, paramString1, paramCollection, paramString2, false);
  }
  
  /* Error */
  public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 970	java/io/BufferedOutputStream
    //   3: dup
    //   4: aload_0
    //   5: iload 4
    //   7: invokestatic 775	org/apache/commons/io/FileUtils:openOutputStream	(Ljava/io/File;Z)Ljava/io/FileOutputStream;
    //   10: invokespecial 973	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   13: astore 5
    //   15: aload_2
    //   16: aload_3
    //   17: aload 5
    //   19: aload_1
    //   20: invokestatic 976	org/apache/commons/io/IOUtils:writeLines	(Ljava/util/Collection;Ljava/lang/String;Ljava/io/OutputStream;Ljava/lang/String;)V
    //   23: aload 5
    //   25: invokevirtual 392	java/io/OutputStream:close	()V
    //   28: return
    //   29: astore_0
    //   30: aconst_null
    //   31: astore_1
    //   32: goto +7 -> 39
    //   35: astore_1
    //   36: aload_1
    //   37: athrow
    //   38: astore_0
    //   39: aload_1
    //   40: ifnull +11 -> 51
    //   43: aload 5
    //   45: invokevirtual 392	java/io/OutputStream:close	()V
    //   48: goto +8 -> 56
    //   51: aload 5
    //   53: invokevirtual 392	java/io/OutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_1
    //   59: goto -3 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramFile	File
    //   0	62	1	paramString1	String
    //   0	62	2	paramCollection	Collection<?>
    //   0	62	3	paramString2	String
    //   0	62	4	paramBoolean	boolean
    //   13	39	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   15	23	29	finally
    //   15	23	35	java/lang/Throwable
    //   36	38	38	finally
    //   43	48	58	java/lang/Throwable
  }
  
  public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection, boolean paramBoolean)
  {
    writeLines(paramFile, paramString, paramCollection, null, paramBoolean);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection)
  {
    writeLines(paramFile, null, paramCollection, null, false);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString)
  {
    writeLines(paramFile, null, paramCollection, paramString, false);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString, boolean paramBoolean)
  {
    writeLines(paramFile, null, paramCollection, paramString, paramBoolean);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection, boolean paramBoolean)
  {
    writeLines(paramFile, null, paramCollection, null, paramBoolean);
  }
  
  @Deprecated
  public static void writeStringToFile(File paramFile, String paramString)
  {
    writeStringToFile(paramFile, paramString, Charset.defaultCharset(), false);
  }
  
  public static void writeStringToFile(File paramFile, String paramString1, String paramString2)
  {
    writeStringToFile(paramFile, paramString1, paramString2, false);
  }
  
  public static void writeStringToFile(File paramFile, String paramString1, String paramString2, boolean paramBoolean)
  {
    writeStringToFile(paramFile, paramString1, Charsets.toCharset(paramString2), paramBoolean);
  }
  
  public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset)
  {
    writeStringToFile(paramFile, paramString, paramCharset, false);
  }
  
  /* Error */
  public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: invokestatic 775	org/apache/commons/io/FileUtils:openOutputStream	(Ljava/io/File;Z)Ljava/io/FileOutputStream;
    //   5: astore 4
    //   7: aload_1
    //   8: aload 4
    //   10: aload_2
    //   11: invokestatic 995	org/apache/commons/io/IOUtils:write	(Ljava/lang/String;Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   14: aload 4
    //   16: ifnull +8 -> 24
    //   19: aload 4
    //   21: invokevirtual 392	java/io/OutputStream:close	()V
    //   24: return
    //   25: astore_0
    //   26: aconst_null
    //   27: astore_1
    //   28: goto +7 -> 35
    //   31: astore_1
    //   32: aload_1
    //   33: athrow
    //   34: astore_0
    //   35: aload 4
    //   37: ifnull +20 -> 57
    //   40: aload_1
    //   41: ifnull +11 -> 52
    //   44: aload 4
    //   46: invokevirtual 392	java/io/OutputStream:close	()V
    //   49: goto +8 -> 57
    //   52: aload 4
    //   54: invokevirtual 392	java/io/OutputStream:close	()V
    //   57: aload_0
    //   58: athrow
    //   59: astore_1
    //   60: goto -3 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramFile	File
    //   0	63	1	paramString	String
    //   0	63	2	paramCharset	Charset
    //   0	63	3	paramBoolean	boolean
    //   5	48	4	localFileOutputStream	FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   7	14	25	finally
    //   7	14	31	java/lang/Throwable
    //   32	34	34	finally
    //   44	49	59	java/lang/Throwable
  }
  
  @Deprecated
  public static void writeStringToFile(File paramFile, String paramString, boolean paramBoolean)
  {
    writeStringToFile(paramFile, paramString, Charset.defaultCharset(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.FileUtils
 * JD-Core Version:    0.7.0.1
 */