package org.apache.commons.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
  public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
  public static final long ONE_PB = 1125899906842624L;
  public static final BigInteger ONE_PB_BI;
  public static final long ONE_TB = 1099511627776L;
  public static final BigInteger ONE_TB_BI;
  public static final BigInteger ONE_YB;
  public static final BigInteger ONE_ZB;
  
  static
  {
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
    if (paramBigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_EB_BI)) + " EB";
    }
    if (paramBigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_PB_BI)) + " PB";
    }
    if (paramBigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_TB_BI)) + " TB";
    }
    if (paramBigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_GB_BI)) + " GB";
    }
    if (paramBigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_MB_BI)) + " MB";
    }
    if (paramBigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_KB_BI)) + " KB";
    }
    return String.valueOf(paramBigInteger) + " bytes";
  }
  
  private static void checkDirectory(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
  }
  
  private static void checkFileRequirements(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
  }
  
  /* Error */
  public static java.util.zip.Checksum checksum(File paramFile, java.util.zip.Checksum paramChecksum)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 137	java/io/File:isDirectory	()Z
    //   4: ifeq +13 -> 17
    //   7: new 126	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 161
    //   13: invokespecial 134	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 163	java/util/zip/CheckedInputStream
    //   20: dup
    //   21: new 165	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: aload_1
    //   30: invokespecial 170	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   33: astore_2
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_2
    //   37: new 172	org/apache/commons/io/output/NullOutputStream
    //   40: dup
    //   41: invokespecial 173	org/apache/commons/io/output/NullOutputStream:<init>	()V
    //   44: invokestatic 179	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   47: pop
    //   48: aload_2
    //   49: ifnull +11 -> 60
    //   52: iconst_0
    //   53: ifeq +18 -> 71
    //   56: aload_2
    //   57: invokevirtual 184	java/io/InputStream:close	()V
    //   60: aload_1
    //   61: areturn
    //   62: astore_0
    //   63: new 143	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: aload_2
    //   72: invokevirtual 184	java/io/InputStream:close	()V
    //   75: aload_1
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: athrow
    //   80: astore_1
    //   81: aload_2
    //   82: ifnull +11 -> 93
    //   85: aload_0
    //   86: ifnull +18 -> 104
    //   89: aload_2
    //   90: invokevirtual 184	java/io/InputStream:close	()V
    //   93: aload_1
    //   94: athrow
    //   95: astore_2
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   101: goto -8 -> 93
    //   104: aload_2
    //   105: invokevirtual 184	java/io/InputStream:close	()V
    //   108: goto -15 -> 93
    //   111: astore_1
    //   112: goto -31 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramFile	File
    //   0	115	1	paramChecksum	java.util.zip.Checksum
    //   33	57	2	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   95	10	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   56	60	62	java/lang/Throwable
    //   36	48	77	java/lang/Throwable
    //   78	80	80	finally
    //   89	93	95	java/lang/Throwable
    //   36	48	111	finally
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
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        forceDelete(localFile);
        label27:
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        break label27;
      }
    }
  }
  
  private static void cleanDirectoryOnExit(File paramFile)
  {
    File[] arrayOfFile = verifiedListFiles(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        forceDeleteOnExit(localFile);
        label27:
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        break label27;
      }
    }
  }
  
  /* Error */
  public static boolean contentEquals(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: invokevirtual 124	java/io/File:exists	()Z
    //   9: istore_3
    //   10: iload_3
    //   11: aload_1
    //   12: invokevirtual 124	java/io/File:exists	()Z
    //   15: if_icmpeq +5 -> 20
    //   18: iload_2
    //   19: ireturn
    //   20: iload_3
    //   21: ifne +5 -> 26
    //   24: iconst_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokevirtual 137	java/io/File:isDirectory	()Z
    //   30: ifne +10 -> 40
    //   33: aload_1
    //   34: invokevirtual 137	java/io/File:isDirectory	()Z
    //   37: ifeq +13 -> 50
    //   40: new 203	java/io/IOException
    //   43: dup
    //   44: ldc 218
    //   46: invokespecial 219	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: aload_0
    //   51: invokevirtual 222	java/io/File:length	()J
    //   54: aload_1
    //   55: invokevirtual 222	java/io/File:length	()J
    //   58: lcmp
    //   59: ifne -41 -> 18
    //   62: aload_0
    //   63: invokevirtual 226	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   66: aload_1
    //   67: invokevirtual 226	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   70: invokevirtual 230	java/io/File:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +5 -> 78
    //   76: iconst_1
    //   77: ireturn
    //   78: new 165	java/io/FileInputStream
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore 5
    //   88: new 165	java/io/FileInputStream
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore 6
    //   98: aload 5
    //   100: aload 6
    //   102: invokestatic 233	org/apache/commons/io/IOUtils:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   105: istore_3
    //   106: aload 6
    //   108: ifnull +12 -> 120
    //   111: iconst_0
    //   112: ifeq +64 -> 176
    //   115: aload 6
    //   117: invokevirtual 184	java/io/InputStream:close	()V
    //   120: iload_3
    //   121: istore_2
    //   122: aload 5
    //   124: ifnull -106 -> 18
    //   127: iconst_0
    //   128: ifeq +63 -> 191
    //   131: aload 5
    //   133: invokevirtual 184	java/io/InputStream:close	()V
    //   136: iload_3
    //   137: ireturn
    //   138: astore_0
    //   139: new 143	java/lang/NullPointerException
    //   142: dup
    //   143: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   146: athrow
    //   147: astore_0
    //   148: new 143	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: astore_1
    //   157: aload_1
    //   158: athrow
    //   159: astore_0
    //   160: aload 5
    //   162: ifnull +12 -> 174
    //   165: aload_1
    //   166: ifnull +82 -> 248
    //   169: aload 5
    //   171: invokevirtual 184	java/io/InputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: aload 6
    //   178: invokevirtual 184	java/io/InputStream:close	()V
    //   181: goto -61 -> 120
    //   184: astore_0
    //   185: aload 4
    //   187: astore_1
    //   188: goto -28 -> 160
    //   191: aload 5
    //   193: invokevirtual 184	java/io/InputStream:close	()V
    //   196: iload_3
    //   197: ireturn
    //   198: astore_1
    //   199: aload_1
    //   200: athrow
    //   201: astore_0
    //   202: aload 6
    //   204: ifnull +12 -> 216
    //   207: aload_1
    //   208: ifnull +21 -> 229
    //   211: aload 6
    //   213: invokevirtual 184	java/io/InputStream:close	()V
    //   216: aload_0
    //   217: athrow
    //   218: astore 6
    //   220: aload_1
    //   221: aload 6
    //   223: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   226: goto -10 -> 216
    //   229: aload 6
    //   231: invokevirtual 184	java/io/InputStream:close	()V
    //   234: goto -18 -> 216
    //   237: astore 4
    //   239: aload_1
    //   240: aload 4
    //   242: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   245: goto -71 -> 174
    //   248: aload 5
    //   250: invokevirtual 184	java/io/InputStream:close	()V
    //   253: goto -79 -> 174
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -57 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramFile1	File
    //   0	262	1	paramFile2	File
    //   4	118	2	bool1	boolean
    //   9	188	3	bool2	boolean
    //   1	185	4	localObject	Object
    //   237	4	4	localThrowable1	Throwable
    //   86	163	5	localFileInputStream1	FileInputStream
    //   96	116	6	localFileInputStream2	FileInputStream
    //   218	12	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   131	136	138	java/lang/Throwable
    //   115	120	147	java/lang/Throwable
    //   88	98	156	java/lang/Throwable
    //   148	156	156	java/lang/Throwable
    //   176	181	156	java/lang/Throwable
    //   216	218	156	java/lang/Throwable
    //   220	226	156	java/lang/Throwable
    //   229	234	156	java/lang/Throwable
    //   157	159	159	finally
    //   88	98	184	finally
    //   115	120	184	finally
    //   148	156	184	finally
    //   176	181	184	finally
    //   211	216	184	finally
    //   216	218	184	finally
    //   220	226	184	finally
    //   229	234	184	finally
    //   98	106	198	java/lang/Throwable
    //   199	201	201	finally
    //   211	216	218	java/lang/Throwable
    //   169	174	237	java/lang/Throwable
    //   98	106	256	finally
  }
  
  /* Error */
  public static boolean contentEqualsIgnoreEOL(File paramFile1, File paramFile2, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: invokevirtual 124	java/io/File:exists	()Z
    //   10: istore 5
    //   12: iload 5
    //   14: aload_1
    //   15: invokevirtual 124	java/io/File:exists	()Z
    //   18: if_icmpeq +7 -> 25
    //   21: iconst_0
    //   22: istore_3
    //   23: iload_3
    //   24: ireturn
    //   25: iload 4
    //   27: istore_3
    //   28: iload 5
    //   30: ifeq -7 -> 23
    //   33: aload_0
    //   34: invokevirtual 137	java/io/File:isDirectory	()Z
    //   37: ifne +10 -> 47
    //   40: aload_1
    //   41: invokevirtual 137	java/io/File:isDirectory	()Z
    //   44: ifeq +13 -> 57
    //   47: new 203	java/io/IOException
    //   50: dup
    //   51: ldc 218
    //   53: invokespecial 219	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: iload 4
    //   59: istore_3
    //   60: aload_0
    //   61: invokevirtual 226	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   64: aload_1
    //   65: invokevirtual 226	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   68: invokevirtual 230	java/io/File:equals	(Ljava/lang/Object;)Z
    //   71: ifne -48 -> 23
    //   74: aload_2
    //   75: ifnonnull +77 -> 152
    //   78: new 237	java/io/InputStreamReader
    //   81: dup
    //   82: new 165	java/io/FileInputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: invokestatic 243	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   93: invokespecial 246	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   96: astore_0
    //   97: aload_2
    //   98: ifnonnull +74 -> 172
    //   101: new 237	java/io/InputStreamReader
    //   104: dup
    //   105: new 165	java/io/FileInputStream
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: invokestatic 243	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   116: invokespecial 246	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   119: astore_1
    //   120: aload_0
    //   121: aload_1
    //   122: invokestatic 249	org/apache/commons/io/IOUtils:contentEqualsIgnoreEOL	(Ljava/io/Reader;Ljava/io/Reader;)Z
    //   125: istore_3
    //   126: aload_1
    //   127: ifnull +11 -> 138
    //   130: iconst_0
    //   131: ifeq +88 -> 219
    //   134: aload_1
    //   135: invokevirtual 252	java/io/Reader:close	()V
    //   138: aload_0
    //   139: ifnull +11 -> 150
    //   142: iconst_0
    //   143: ifeq +92 -> 235
    //   146: aload_0
    //   147: invokevirtual 252	java/io/Reader:close	()V
    //   150: iload_3
    //   151: ireturn
    //   152: new 237	java/io/InputStreamReader
    //   155: dup
    //   156: new 165	java/io/FileInputStream
    //   159: dup
    //   160: aload_0
    //   161: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   164: aload_2
    //   165: invokespecial 255	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   168: astore_0
    //   169: goto -72 -> 97
    //   172: new 237	java/io/InputStreamReader
    //   175: dup
    //   176: new 165	java/io/FileInputStream
    //   179: dup
    //   180: aload_1
    //   181: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   184: aload_2
    //   185: invokespecial 255	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   188: astore_1
    //   189: goto -69 -> 120
    //   192: astore_2
    //   193: aload_2
    //   194: athrow
    //   195: astore_1
    //   196: aload_0
    //   197: ifnull +11 -> 208
    //   200: aload_2
    //   201: ifnull +86 -> 287
    //   204: aload_0
    //   205: invokevirtual 252	java/io/Reader:close	()V
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: new 143	java/lang/NullPointerException
    //   214: dup
    //   215: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   218: athrow
    //   219: aload_1
    //   220: invokevirtual 252	java/io/Reader:close	()V
    //   223: goto -85 -> 138
    //   226: astore_0
    //   227: new 143	java/lang/NullPointerException
    //   230: dup
    //   231: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   234: athrow
    //   235: aload_0
    //   236: invokevirtual 252	java/io/Reader:close	()V
    //   239: goto -89 -> 150
    //   242: astore_2
    //   243: aload_2
    //   244: athrow
    //   245: astore 6
    //   247: aload_1
    //   248: ifnull +11 -> 259
    //   251: aload_2
    //   252: ifnull +19 -> 271
    //   255: aload_1
    //   256: invokevirtual 252	java/io/Reader:close	()V
    //   259: aload 6
    //   261: athrow
    //   262: astore_1
    //   263: aload_2
    //   264: aload_1
    //   265: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   268: goto -9 -> 259
    //   271: aload_1
    //   272: invokevirtual 252	java/io/Reader:close	()V
    //   275: goto -16 -> 259
    //   278: astore_0
    //   279: aload_2
    //   280: aload_0
    //   281: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   284: goto -76 -> 208
    //   287: aload_0
    //   288: invokevirtual 252	java/io/Reader:close	()V
    //   291: goto -83 -> 208
    //   294: astore 6
    //   296: aconst_null
    //   297: astore_2
    //   298: goto -51 -> 247
    //   301: astore_1
    //   302: aload 7
    //   304: astore_2
    //   305: goto -109 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramFile1	File
    //   0	308	1	paramFile2	File
    //   0	308	2	paramString	String
    //   22	129	3	bool1	boolean
    //   4	54	4	bool2	boolean
    //   10	19	5	bool3	boolean
    //   245	15	6	localObject1	Object
    //   294	1	6	localObject2	Object
    //   1	302	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	120	192	java/lang/Throwable
    //   172	189	192	java/lang/Throwable
    //   211	219	192	java/lang/Throwable
    //   219	223	192	java/lang/Throwable
    //   259	262	192	java/lang/Throwable
    //   263	268	192	java/lang/Throwable
    //   271	275	192	java/lang/Throwable
    //   193	195	195	finally
    //   134	138	210	java/lang/Throwable
    //   146	150	226	java/lang/Throwable
    //   120	126	242	java/lang/Throwable
    //   243	245	245	finally
    //   255	259	262	java/lang/Throwable
    //   204	208	278	java/lang/Throwable
    //   120	126	294	finally
    //   101	120	301	finally
    //   134	138	301	finally
    //   172	189	301	finally
    //   211	219	301	finally
    //   219	223	301	finally
    //   255	259	301	finally
    //   259	262	301	finally
    //   263	268	301	finally
    //   271	275	301	finally
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
    if (!paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is not a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath()))
    {
      if (paramFileFilter == null) {}
      for (File[] arrayOfFile = paramFile1.listFiles();; arrayOfFile = paramFile1.listFiles(paramFileFilter))
      {
        localArrayList1 = localArrayList2;
        if (arrayOfFile == null) {
          break;
        }
        localArrayList1 = localArrayList2;
        if (arrayOfFile.length <= 0) {
          break;
        }
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
    doCopyDirectory(paramFile1, paramFile2, paramFileFilter, paramBoolean, localArrayList1);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    copyDirectory(paramFile1, paramFile2, null, paramBoolean);
  }
  
  public static void copyDirectoryToDirectory(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if ((paramFile1.exists()) && (!paramFile1.isDirectory())) {
      throw new IllegalArgumentException("Source '" + paramFile2 + "' is not a directory");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if ((paramFile2.exists()) && (!paramFile2.isDirectory())) {
      throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
    }
    copyDirectory(paramFile1, new File(paramFile2, paramFile1.getName()), true);
  }
  
  public static long copyFile(File paramFile, OutputStream paramOutputStream)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    paramFile = null;
    try
    {
      long l = IOUtils.copyLarge(localFileInputStream, paramOutputStream);
      if ((localFileInputStream == null) || (0 != 0)) {
        try
        {
          localFileInputStream.close();
          return l;
        }
        catch (Throwable paramFile)
        {
          throw new NullPointerException();
        }
      }
      localFileInputStream.close();
      return l;
    }
    catch (Throwable paramOutputStream)
    {
      paramFile = paramOutputStream;
      throw paramOutputStream;
    }
    finally
    {
      if (localFileInputStream != null) {
        if (paramFile == null) {
          break label84;
        }
      }
    }
    for (;;)
    {
      try
      {
        localFileInputStream.close();
        throw paramOutputStream;
      }
      catch (Throwable localThrowable)
      {
        paramFile.addSuppressed(localThrowable);
        continue;
      }
      label84:
      localThrowable.close();
    }
  }
  
  public static void copyFile(File paramFile1, File paramFile2)
  {
    copyFile(paramFile1, paramFile2, true);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    checkFileRequirements(paramFile1, paramFile2);
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    File localFile = paramFile2.getParentFile();
    if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
      throw new IOException("Destination '" + localFile + "' directory cannot be created");
    }
    if ((paramFile2.exists()) && (!paramFile2.canWrite())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
    }
    doCopyFile(paramFile1, paramFile2, paramBoolean);
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2)
  {
    copyFileToDirectory(paramFile1, paramFile2, true);
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if ((paramFile2.exists()) && (!paramFile2.isDirectory())) {
      throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
    }
    copyFile(paramFile1, new File(paramFile2, paramFile1.getName()), paramBoolean);
  }
  
  public static void copyInputStreamToFile(InputStream paramInputStream, File paramFile)
  {
    File localFile = null;
    try
    {
      copyToFile(paramInputStream, paramFile);
      if ((paramInputStream == null) || (0 != 0)) {
        try
        {
          paramInputStream.close();
          return;
        }
        catch (Throwable paramInputStream)
        {
          throw new NullPointerException();
        }
      }
      paramInputStream.close();
      return;
    }
    catch (Throwable paramFile)
    {
      localFile = paramFile;
      throw paramFile;
    }
    finally
    {
      if (paramInputStream != null) {
        if (localFile == null) {
          break label63;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramInputStream.close();
        throw paramFile;
      }
      catch (Throwable paramInputStream)
      {
        localFile.addSuppressed(paramInputStream);
        continue;
      }
      label63:
      paramInputStream.close();
    }
  }
  
  public static void copyToDirectory(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
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
    throw new IOException("The source " + paramFile1 + " does not exist");
  }
  
  public static void copyToDirectory(Iterable<File> paramIterable, File paramFile)
  {
    if (paramIterable == null) {
      throw new NullPointerException("Sources must not be null");
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      copyFileToDirectory((File)paramIterable.next(), paramFile);
    }
  }
  
  /* Error */
  public static void copyToFile(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 394	org/apache/commons/io/FileUtils:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   6: astore 4
    //   8: aload_0
    //   9: aload 4
    //   11: invokestatic 179	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   14: pop
    //   15: aload 4
    //   17: ifnull +12 -> 29
    //   20: iconst_0
    //   21: ifeq +48 -> 69
    //   24: aload 4
    //   26: invokevirtual 397	java/io/OutputStream:close	()V
    //   29: aload_0
    //   30: ifnull +11 -> 41
    //   33: iconst_0
    //   34: ifeq +97 -> 131
    //   37: aload_0
    //   38: invokevirtual 184	java/io/InputStream:close	()V
    //   41: return
    //   42: astore_1
    //   43: new 143	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: astore_1
    //   52: aload_1
    //   53: athrow
    //   54: astore_2
    //   55: aload_0
    //   56: ifnull +11 -> 67
    //   59: aload_1
    //   60: ifnull +85 -> 145
    //   63: aload_0
    //   64: invokevirtual 184	java/io/InputStream:close	()V
    //   67: aload_2
    //   68: athrow
    //   69: aload 4
    //   71: invokevirtual 397	java/io/OutputStream:close	()V
    //   74: goto -45 -> 29
    //   77: astore_2
    //   78: aload_3
    //   79: astore_1
    //   80: goto -25 -> 55
    //   83: astore_1
    //   84: aload_1
    //   85: athrow
    //   86: astore_2
    //   87: aload 4
    //   89: ifnull +12 -> 101
    //   92: aload_1
    //   93: ifnull +21 -> 114
    //   96: aload 4
    //   98: invokevirtual 397	java/io/OutputStream:close	()V
    //   101: aload_2
    //   102: athrow
    //   103: astore 4
    //   105: aload_1
    //   106: aload 4
    //   108: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   111: goto -10 -> 101
    //   114: aload 4
    //   116: invokevirtual 397	java/io/OutputStream:close	()V
    //   119: goto -18 -> 101
    //   122: astore_0
    //   123: new 143	java/lang/NullPointerException
    //   126: dup
    //   127: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   130: athrow
    //   131: aload_0
    //   132: invokevirtual 184	java/io/InputStream:close	()V
    //   135: return
    //   136: astore_0
    //   137: aload_1
    //   138: aload_0
    //   139: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   142: goto -75 -> 67
    //   145: aload_0
    //   146: invokevirtual 184	java/io/InputStream:close	()V
    //   149: goto -82 -> 67
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: goto -68 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInputStream	InputStream
    //   0	158	1	paramFile	File
    //   54	14	2	localObject1	Object
    //   77	1	2	localObject2	Object
    //   86	16	2	localObject3	Object
    //   152	1	2	localObject4	Object
    //   1	78	3	localObject5	Object
    //   6	91	4	localFileOutputStream	FileOutputStream
    //   103	12	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	29	42	java/lang/Throwable
    //   2	8	51	java/lang/Throwable
    //   43	51	51	java/lang/Throwable
    //   69	74	51	java/lang/Throwable
    //   101	103	51	java/lang/Throwable
    //   105	111	51	java/lang/Throwable
    //   114	119	51	java/lang/Throwable
    //   52	54	54	finally
    //   2	8	77	finally
    //   24	29	77	finally
    //   43	51	77	finally
    //   69	74	77	finally
    //   96	101	77	finally
    //   101	103	77	finally
    //   105	111	77	finally
    //   114	119	77	finally
    //   8	15	83	java/lang/Throwable
    //   84	86	86	finally
    //   96	101	103	java/lang/Throwable
    //   37	41	122	java/lang/Throwable
    //   63	67	136	java/lang/Throwable
    //   8	15	152	finally
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
  
  static String decodeUrl(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.indexOf('%') >= 0)
      {
        int m = paramString.length();
        localObject = new StringBuilder();
        ByteBuffer localByteBuffer = ByteBuffer.allocate(m);
        int i = 0;
        while (i < m)
        {
          int j = i;
          int k;
          if (paramString.charAt(i) == '%')
          {
            k = i;
            label63:
            i = k;
          }
          try
          {
            localByteBuffer.put((byte)Integer.parseInt(paramString.substring(k + 1, k + 3), 16));
            j = k + 3;
            if (j < m)
            {
              i = j;
              int n = paramString.charAt(j);
              k = j;
              if (n == 37) {
                break label63;
              }
            }
            i = j;
            if (localByteBuffer.position() > 0)
            {
              localByteBuffer.flip();
              ((StringBuilder)localObject).append(StandardCharsets.UTF_8.decode(localByteBuffer).toString());
              localByteBuffer.clear();
              i = j;
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            j = i;
            if (localByteBuffer.position() > 0)
            {
              localByteBuffer.flip();
              ((StringBuilder)localObject).append(StandardCharsets.UTF_8.decode(localByteBuffer).toString());
              localByteBuffer.clear();
              j = i;
            }
            ((StringBuilder)localObject).append(paramString.charAt(j));
            i = j + 1;
          }
          finally
          {
            if (localByteBuffer.position() > 0)
            {
              localByteBuffer.flip();
              ((StringBuilder)localObject).append(StandardCharsets.UTF_8.decode(localByteBuffer).toString());
              localByteBuffer.clear();
            }
          }
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      if (!isSymlink(paramFile)) {
        cleanDirectory(paramFile);
      }
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  private static void deleteDirectoryOnExit(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      paramFile.deleteOnExit();
    } while (isSymlink(paramFile));
    cleanDirectoryOnExit(paramFile);
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
      try
      {
        label17:
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public static boolean directoryContains(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new IllegalArgumentException("Directory must not be null");
    }
    if (!paramFile1.isDirectory()) {
      throw new IllegalArgumentException("Not a directory: " + paramFile1);
    }
    if (paramFile2 == null) {}
    while ((!paramFile1.exists()) || (!paramFile2.exists())) {
      return false;
    }
    return FilenameUtils.directoryContains(paramFile1.getCanonicalPath(), paramFile2.getCanonicalPath());
  }
  
  private static void doCopyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List<String> paramList)
  {
    if (paramFileFilter == null) {}
    for (File[] arrayOfFile = paramFile1.listFiles(); arrayOfFile == null; arrayOfFile = paramFile1.listFiles(paramFileFilter)) {
      throw new IOException("Failed to list contents of " + paramFile1);
    }
    if (paramFile2.exists())
    {
      if (!paramFile2.isDirectory()) {
        throw new IOException("Destination '" + paramFile2 + "' exists but is not a directory");
      }
    }
    else if ((!paramFile2.mkdirs()) && (!paramFile2.isDirectory())) {
      throw new IOException("Destination '" + paramFile2 + "' directory cannot be created");
    }
    if (!paramFile2.canWrite()) {
      throw new IOException("Destination '" + paramFile2 + "' cannot be written to");
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile1 = arrayOfFile[i];
      File localFile2 = new File(paramFile2, localFile1.getName());
      if ((paramList == null) || (!paramList.contains(localFile1.getCanonicalPath())))
      {
        if (!localFile1.isDirectory()) {
          break label275;
        }
        doCopyDirectory(localFile1, localFile2, paramFileFilter, paramBoolean, paramList);
      }
      for (;;)
      {
        i += 1;
        break;
        label275:
        doCopyFile(localFile1, localFile2, paramBoolean);
      }
    }
    if (paramBoolean) {
      paramFile2.setLastModified(paramFile1.lastModified());
    }
  }
  
  /* Error */
  private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 124	java/io/File:exists	()Z
    //   4: ifeq +44 -> 48
    //   7: aload_1
    //   8: invokevirtual 137	java/io/File:isDirectory	()Z
    //   11: ifeq +37 -> 48
    //   14: new 203	java/io/IOException
    //   17: dup
    //   18: new 90	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 326
    //   28: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc_w 337
    //   38: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 219	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: new 165	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore 11
    //   58: aload 11
    //   60: invokevirtual 535	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   63: astore 12
    //   65: new 537	java/io/FileOutputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 538	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore 13
    //   75: aload 13
    //   77: invokevirtual 539	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   80: astore 14
    //   82: aload 12
    //   84: invokevirtual 543	java/nio/channels/FileChannel:size	()J
    //   87: lstore 9
    //   89: lconst_0
    //   90: lstore_3
    //   91: goto +413 -> 504
    //   94: aload 14
    //   96: aload 12
    //   98: lload_3
    //   99: lload 5
    //   101: invokevirtual 547	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   104: lstore 5
    //   106: lload 5
    //   108: lconst_0
    //   109: lcmp
    //   110: ifne +136 -> 246
    //   113: aload 14
    //   115: ifnull +12 -> 127
    //   118: iconst_0
    //   119: ifeq +204 -> 323
    //   122: aload 14
    //   124: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   127: aload 13
    //   129: ifnull +12 -> 141
    //   132: iconst_0
    //   133: ifeq +252 -> 385
    //   136: aload 13
    //   138: invokevirtual 549	java/io/FileOutputStream:close	()V
    //   141: aload 12
    //   143: ifnull +12 -> 155
    //   146: iconst_0
    //   147: ifeq +274 -> 421
    //   150: aload 12
    //   152: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   155: aload 11
    //   157: ifnull +12 -> 169
    //   160: iconst_0
    //   161: ifeq +296 -> 457
    //   164: aload 11
    //   166: invokevirtual 333	java/io/FileInputStream:close	()V
    //   169: aload_0
    //   170: invokevirtual 222	java/io/File:length	()J
    //   173: lstore_3
    //   174: aload_1
    //   175: invokevirtual 222	java/io/File:length	()J
    //   178: lstore 5
    //   180: lload_3
    //   181: lload 5
    //   183: lcmp
    //   184: ifeq +300 -> 484
    //   187: new 203	java/io/IOException
    //   190: dup
    //   191: new 90	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 551
    //   201: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   208: ldc_w 553
    //   211: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: ldc_w 555
    //   221: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: lload_3
    //   225: invokevirtual 558	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: ldc_w 560
    //   231: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: lload 5
    //   236: invokevirtual 558	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 219	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   245: athrow
    //   246: lload_3
    //   247: lload 5
    //   249: ladd
    //   250: lstore_3
    //   251: goto +253 -> 504
    //   254: astore_0
    //   255: new 143	java/lang/NullPointerException
    //   258: dup
    //   259: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   262: athrow
    //   263: astore_1
    //   264: aload_1
    //   265: athrow
    //   266: astore_0
    //   267: aload 13
    //   269: ifnull +12 -> 281
    //   272: aload_1
    //   273: ifnull +131 -> 404
    //   276: aload 13
    //   278: invokevirtual 549	java/io/FileOutputStream:close	()V
    //   281: aload_0
    //   282: athrow
    //   283: astore_1
    //   284: aload_1
    //   285: athrow
    //   286: astore_0
    //   287: aload 12
    //   289: ifnull +12 -> 301
    //   292: aload_1
    //   293: ifnull +147 -> 440
    //   296: aload 12
    //   298: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   301: aload_0
    //   302: athrow
    //   303: astore_0
    //   304: aload_0
    //   305: athrow
    //   306: astore_1
    //   307: aload 11
    //   309: ifnull +12 -> 321
    //   312: aload_0
    //   313: ifnull +163 -> 476
    //   316: aload 11
    //   318: invokevirtual 333	java/io/FileInputStream:close	()V
    //   321: aload_1
    //   322: athrow
    //   323: aload 14
    //   325: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   328: goto -201 -> 127
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -67 -> 267
    //   337: astore_0
    //   338: aload_0
    //   339: athrow
    //   340: astore_1
    //   341: aload 14
    //   343: ifnull +12 -> 355
    //   346: aload_0
    //   347: ifnull +21 -> 368
    //   350: aload 14
    //   352: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   355: aload_1
    //   356: athrow
    //   357: astore 14
    //   359: aload_0
    //   360: aload 14
    //   362: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   365: goto -10 -> 355
    //   368: aload 14
    //   370: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   373: goto -18 -> 355
    //   376: astore_0
    //   377: new 143	java/lang/NullPointerException
    //   380: dup
    //   381: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   384: athrow
    //   385: aload 13
    //   387: invokevirtual 549	java/io/FileOutputStream:close	()V
    //   390: goto -249 -> 141
    //   393: astore 13
    //   395: aload_1
    //   396: aload 13
    //   398: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   401: goto -120 -> 281
    //   404: aload 13
    //   406: invokevirtual 549	java/io/FileOutputStream:close	()V
    //   409: goto -128 -> 281
    //   412: astore_0
    //   413: new 143	java/lang/NullPointerException
    //   416: dup
    //   417: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   420: athrow
    //   421: aload 12
    //   423: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   426: goto -271 -> 155
    //   429: astore 12
    //   431: aload_1
    //   432: aload 12
    //   434: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   437: goto -136 -> 301
    //   440: aload 12
    //   442: invokevirtual 548	java/nio/channels/FileChannel:close	()V
    //   445: goto -144 -> 301
    //   448: astore_0
    //   449: new 143	java/lang/NullPointerException
    //   452: dup
    //   453: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   456: athrow
    //   457: aload 11
    //   459: invokevirtual 333	java/io/FileInputStream:close	()V
    //   462: goto -293 -> 169
    //   465: astore 11
    //   467: aload_0
    //   468: aload 11
    //   470: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   473: goto -152 -> 321
    //   476: aload 11
    //   478: invokevirtual 333	java/io/FileInputStream:close	()V
    //   481: goto -160 -> 321
    //   484: iload_2
    //   485: ifeq +12 -> 497
    //   488: aload_1
    //   489: aload_0
    //   490: invokevirtual 526	java/io/File:lastModified	()J
    //   493: invokevirtual 530	java/io/File:setLastModified	(J)Z
    //   496: pop
    //   497: return
    //   498: astore_1
    //   499: aconst_null
    //   500: astore_0
    //   501: goto -160 -> 341
    //   504: lload_3
    //   505: lload 9
    //   507: lcmp
    //   508: ifge -395 -> 113
    //   511: lload 9
    //   513: lload_3
    //   514: lsub
    //   515: lstore 7
    //   517: lload 7
    //   519: lstore 5
    //   521: lload 7
    //   523: ldc2_w 9
    //   526: lcmp
    //   527: ifle -433 -> 94
    //   530: ldc2_w 9
    //   533: lstore 5
    //   535: goto -441 -> 94
    //   538: astore_0
    //   539: aconst_null
    //   540: astore_1
    //   541: goto -254 -> 287
    //   544: astore_1
    //   545: aconst_null
    //   546: astore_0
    //   547: goto -240 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	paramFile1	File
    //   0	550	1	paramFile2	File
    //   0	550	2	paramBoolean	boolean
    //   90	424	3	l1	long
    //   99	1	5	localObject	Object
    //   104	430	5	l2	long
    //   515	7	7	l3	long
    //   87	425	9	l4	long
    //   56	402	11	localFileInputStream	FileInputStream
    //   465	12	11	localThrowable1	Throwable
    //   63	359	12	localFileChannel1	java.nio.channels.FileChannel
    //   429	12	12	localThrowable2	Throwable
    //   73	313	13	localFileOutputStream	FileOutputStream
    //   393	12	13	localThrowable3	Throwable
    //   80	271	14	localFileChannel2	java.nio.channels.FileChannel
    //   357	12	14	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   122	127	254	java/lang/Throwable
    //   75	82	263	java/lang/Throwable
    //   255	263	263	java/lang/Throwable
    //   323	328	263	java/lang/Throwable
    //   355	357	263	java/lang/Throwable
    //   359	365	263	java/lang/Throwable
    //   368	373	263	java/lang/Throwable
    //   264	266	266	finally
    //   65	75	283	java/lang/Throwable
    //   281	283	283	java/lang/Throwable
    //   377	385	283	java/lang/Throwable
    //   385	390	283	java/lang/Throwable
    //   395	401	283	java/lang/Throwable
    //   404	409	283	java/lang/Throwable
    //   284	286	286	finally
    //   58	65	303	java/lang/Throwable
    //   301	303	303	java/lang/Throwable
    //   413	421	303	java/lang/Throwable
    //   421	426	303	java/lang/Throwable
    //   431	437	303	java/lang/Throwable
    //   440	445	303	java/lang/Throwable
    //   304	306	306	finally
    //   75	82	331	finally
    //   122	127	331	finally
    //   255	263	331	finally
    //   323	328	331	finally
    //   350	355	331	finally
    //   355	357	331	finally
    //   359	365	331	finally
    //   368	373	331	finally
    //   82	89	337	java/lang/Throwable
    //   94	106	337	java/lang/Throwable
    //   338	340	340	finally
    //   350	355	357	java/lang/Throwable
    //   136	141	376	java/lang/Throwable
    //   276	281	393	java/lang/Throwable
    //   150	155	412	java/lang/Throwable
    //   296	301	429	java/lang/Throwable
    //   164	169	448	java/lang/Throwable
    //   316	321	465	java/lang/Throwable
    //   82	89	498	finally
    //   94	106	498	finally
    //   65	75	538	finally
    //   136	141	538	finally
    //   276	281	538	finally
    //   281	283	538	finally
    //   377	385	538	finally
    //   385	390	538	finally
    //   395	401	538	finally
    //   404	409	538	finally
    //   58	65	544	finally
    //   150	155	544	finally
    //   296	301	544	finally
    //   301	303	544	finally
    //   413	421	544	finally
    //   421	426	544	finally
    //   431	437	544	finally
    //   440	445	544	finally
  }
  
  public static void forceDelete(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
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
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory()) {
        throw new IOException("File " + paramFile + " exists and is not a directory. Unable to create directory.");
      }
    }
    else if ((!paramFile.mkdirs()) && (!paramFile.isDirectory())) {
      throw new IOException("Unable to create directory " + paramFile);
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
    if (paramFile == null) {
      throw new NullPointerException("directory must not be null");
    }
    if (paramVarArgs == null) {
      throw new NullPointerException("names must not be null");
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramFile = new File(paramFile, paramVarArgs[i]);
      i += 1;
    }
    return paramFile;
  }
  
  public static File getFile(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new NullPointerException("names must not be null");
    }
    int j = paramVarArgs.length;
    File localFile = null;
    int i = 0;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (localFile == null) {}
      for (localFile = new File(str);; localFile = new File(localFile, str))
      {
        i += 1;
        break;
      }
    }
    return localFile;
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
      if (i < j)
      {
        Object localObject = paramFile[i];
        if (localObject.isDirectory())
        {
          if (paramBoolean) {
            paramCollection.add(localObject);
          }
          innerListFiles(paramCollection, localObject, paramIOFileFilter, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCollection.add(localObject);
        }
      }
    }
  }
  
  public static boolean isFileNewer(File paramFile, long paramLong)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("No specified file");
    }
    if (!paramFile.exists()) {}
    while (paramFile.lastModified() <= paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean isFileNewer(File paramFile1, File paramFile2)
  {
    if (paramFile2 == null) {
      throw new IllegalArgumentException("No specified reference file");
    }
    if (!paramFile2.exists()) {
      throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
    }
    return isFileNewer(paramFile1, paramFile2.lastModified());
  }
  
  public static boolean isFileNewer(File paramFile, Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("No specified date");
    }
    return isFileNewer(paramFile, paramDate.getTime());
  }
  
  public static boolean isFileOlder(File paramFile, long paramLong)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("No specified file");
    }
    if (!paramFile.exists()) {}
    while (paramFile.lastModified() >= paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean isFileOlder(File paramFile1, File paramFile2)
  {
    if (paramFile2 == null) {
      throw new IllegalArgumentException("No specified reference file");
    }
    if (!paramFile2.exists()) {
      throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
    }
    return isFileOlder(paramFile1, paramFile2.lastModified());
  }
  
  public static boolean isFileOlder(File paramFile, Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("No specified date");
    }
    return isFileOlder(paramFile, paramDate.getTime());
  }
  
  public static boolean isSymlink(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("File must not be null");
    }
    return Files.isSymbolicLink(paramFile.toPath());
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
    catch (RuntimeException paramFile)
    {
      if (localFile1 != null) {}
      try
      {
        localFile1.close();
        throw paramFile;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramFile.addSuppressed(paramString);
        }
      }
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        localFile1 = localFile2;
      }
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
    if (paramArrayOfString == null)
    {
      paramArrayOfString = TrueFileFilter.INSTANCE;
      if (!paramBoolean) {
        break label38;
      }
    }
    label38:
    for (IOFileFilter localIOFileFilter = TrueFileFilter.INSTANCE;; localIOFileFilter = FalseFileFilter.INSTANCE)
    {
      return listFiles(paramFile, paramArrayOfString, localIOFileFilter);
      paramArrayOfString = new SuffixFileFilter(toSuffixes(paramArrayOfString));
      break;
    }
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
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (!paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' is not a directory");
    }
    if (paramFile2.exists()) {
      throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath() + File.separator)) {
        throw new IOException("Cannot move directory: " + paramFile1 + " to a subdirectory of itself: " + paramFile2);
      }
      copyDirectory(paramFile1, paramFile2);
      deleteDirectory(paramFile1);
      if (paramFile1.exists()) {
        throw new IOException("Failed to delete original directory '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
      }
    }
  }
  
  public static void moveDirectoryToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination directory must not be null");
    }
    if ((!paramFile2.exists()) && (paramBoolean)) {
      paramFile2.mkdirs();
    }
    if (!paramFile2.exists()) {
      throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
    }
    if (!paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is not a directory");
    }
    moveDirectory(paramFile1, new File(paramFile2, paramFile1.getName()));
  }
  
  public static void moveFile(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' is a directory");
    }
    if (paramFile2.exists()) {
      throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
    }
    if (paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is a directory");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      copyFile(paramFile1, paramFile2);
      if (!paramFile1.delete())
      {
        deleteQuietly(paramFile2);
        throw new IOException("Failed to delete original file '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
      }
    }
  }
  
  public static void moveFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination directory must not be null");
    }
    if ((!paramFile2.exists()) && (paramBoolean)) {
      paramFile2.mkdirs();
    }
    if (!paramFile2.exists()) {
      throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
    }
    if (!paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is not a directory");
    }
    moveFile(paramFile1, new File(paramFile2, paramFile1.getName()));
  }
  
  public static void moveToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory())
    {
      moveDirectoryToDirectory(paramFile1, paramFile2, paramBoolean);
      return;
    }
    moveFileToDirectory(paramFile1, paramFile2, paramBoolean);
  }
  
  public static FileInputStream openInputStream(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
  {
    return openOutputStream(paramFile, false);
  }
  
  public static FileOutputStream openOutputStream(File paramFile, boolean paramBoolean)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
        throw new IOException("Directory '" + localFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }
  
  /* Error */
  public static byte[] readFileToByteArray(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 669	org/apache/commons/io/FileUtils:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 222	java/io/File:length	()J
    //   13: lstore_1
    //   14: lload_1
    //   15: lconst_0
    //   16: lcmp
    //   17: ifle +26 -> 43
    //   20: aload 5
    //   22: lload_1
    //   23: invokestatic 794	org/apache/commons/io/IOUtils:toByteArray	(Ljava/io/InputStream;J)[B
    //   26: astore_0
    //   27: aload 5
    //   29: ifnull +12 -> 41
    //   32: iconst_0
    //   33: ifeq +28 -> 61
    //   36: aload 5
    //   38: invokevirtual 184	java/io/InputStream:close	()V
    //   41: aload_0
    //   42: areturn
    //   43: aload 5
    //   45: invokestatic 797	org/apache/commons/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   48: astore_0
    //   49: goto -22 -> 27
    //   52: astore_0
    //   53: new 143	java/lang/NullPointerException
    //   56: dup
    //   57: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   60: athrow
    //   61: aload 5
    //   63: invokevirtual 184	java/io/InputStream:close	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aload_0
    //   70: athrow
    //   71: astore_3
    //   72: aload 5
    //   74: ifnull +12 -> 86
    //   77: aload_0
    //   78: ifnull +21 -> 99
    //   81: aload 5
    //   83: invokevirtual 184	java/io/InputStream:close	()V
    //   86: aload_3
    //   87: athrow
    //   88: astore 4
    //   90: aload_0
    //   91: aload 4
    //   93: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   96: goto -10 -> 86
    //   99: aload 5
    //   101: invokevirtual 184	java/io/InputStream:close	()V
    //   104: goto -18 -> 86
    //   107: astore_3
    //   108: aload 4
    //   110: astore_0
    //   111: goto -39 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramFile	File
    //   13	10	1	l	long
    //   71	16	3	localObject1	Object
    //   107	1	3	localObject2	Object
    //   7	1	4	localObject3	Object
    //   88	21	4	localThrowable	Throwable
    //   4	96	5	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   36	41	52	java/lang/Throwable
    //   9	14	68	java/lang/Throwable
    //   20	27	68	java/lang/Throwable
    //   43	49	68	java/lang/Throwable
    //   69	71	71	finally
    //   81	86	88	java/lang/Throwable
    //   9	14	107	finally
    //   20	27	107	finally
    //   43	49	107	finally
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
    //   1: invokestatic 669	org/apache/commons/io/FileUtils:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_0
    //   7: aload_2
    //   8: aload_1
    //   9: invokestatic 814	org/apache/commons/io/Charsets:toCharset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   12: invokestatic 817	org/apache/commons/io/IOUtils:toString	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_2
    //   17: ifnull +11 -> 28
    //   20: iconst_0
    //   21: ifeq +18 -> 39
    //   24: aload_2
    //   25: invokevirtual 184	java/io/InputStream:close	()V
    //   28: aload_1
    //   29: areturn
    //   30: astore_0
    //   31: new 143	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: aload_2
    //   40: invokevirtual 184	java/io/InputStream:close	()V
    //   43: aload_1
    //   44: areturn
    //   45: astore_0
    //   46: aload_0
    //   47: athrow
    //   48: astore_1
    //   49: aload_2
    //   50: ifnull +11 -> 61
    //   53: aload_0
    //   54: ifnull +18 -> 72
    //   57: aload_2
    //   58: invokevirtual 184	java/io/InputStream:close	()V
    //   61: aload_1
    //   62: athrow
    //   63: astore_2
    //   64: aload_0
    //   65: aload_2
    //   66: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   69: goto -8 -> 61
    //   72: aload_2
    //   73: invokevirtual 184	java/io/InputStream:close	()V
    //   76: goto -15 -> 61
    //   79: astore_1
    //   80: goto -31 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramFile	File
    //   0	83	1	paramCharset	Charset
    //   4	54	2	localFileInputStream	FileInputStream
    //   63	10	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	28	30	java/lang/Throwable
    //   7	16	45	java/lang/Throwable
    //   46	48	48	finally
    //   57	61	63	java/lang/Throwable
    //   7	16	79	finally
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
    //   1: invokestatic 669	org/apache/commons/io/FileUtils:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_3
    //   8: aload_1
    //   9: invokestatic 814	org/apache/commons/io/Charsets:toCharset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   12: invokestatic 828	org/apache/commons/io/IOUtils:readLines	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/util/List;
    //   15: astore_0
    //   16: aload_3
    //   17: ifnull +11 -> 28
    //   20: iconst_0
    //   21: ifeq +18 -> 39
    //   24: aload_3
    //   25: invokevirtual 184	java/io/InputStream:close	()V
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: new 143	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: aload_3
    //   40: invokevirtual 184	java/io/InputStream:close	()V
    //   43: aload_0
    //   44: areturn
    //   45: astore_1
    //   46: aload_1
    //   47: athrow
    //   48: astore_0
    //   49: aload_3
    //   50: ifnull +11 -> 61
    //   53: aload_1
    //   54: ifnull +18 -> 72
    //   57: aload_3
    //   58: invokevirtual 184	java/io/InputStream:close	()V
    //   61: aload_0
    //   62: athrow
    //   63: astore_2
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   69: goto -8 -> 61
    //   72: aload_3
    //   73: invokevirtual 184	java/io/InputStream:close	()V
    //   76: goto -15 -> 61
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: goto -33 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramFile	File
    //   0	85	1	paramCharset	Charset
    //   6	1	2	localObject	Object
    //   63	18	2	localThrowable	Throwable
    //   4	69	3	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   24	28	30	java/lang/Throwable
    //   7	16	45	java/lang/Throwable
    //   46	48	48	finally
    //   57	61	63	java/lang/Throwable
    //   7	16	79	finally
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
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (paramFile.isDirectory()) {
      return sizeOfDirectory0(paramFile);
    }
    return paramFile.length();
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
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (paramFile.isDirectory()) {
      return sizeOfDirectoryBig0(paramFile);
    }
    return BigInteger.valueOf(paramFile.length());
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
    if (paramFile == null)
    {
      l2 = 0L;
      return l2;
    }
    int j = paramFile.length;
    int i = 0;
    for (l1 = 0L;; l1 = l2)
    {
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
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
              break;
            }
            l2 = l1;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            l2 = l1;
          }
        }
      }
      i += 1;
    }
  }
  
  public static BigInteger sizeOfDirectoryAsBigInteger(File paramFile)
  {
    checkDirectory(paramFile);
    return sizeOfDirectoryBig0(paramFile);
  }
  
  private static BigInteger sizeOfDirectoryBig0(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    Object localObject;
    if (arrayOfFile == null)
    {
      localObject = BigInteger.ZERO;
      return localObject;
    }
    paramFile = BigInteger.ZERO;
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      localObject = paramFile;
      if (i >= j) {
        break;
      }
      File localFile2 = arrayOfFile[i];
      localObject = paramFile;
      try
      {
        if (!isSymlink(localFile2)) {
          localObject = paramFile.add(sizeOfBig0(localFile2));
        }
        i += 1;
        paramFile = (File)localObject;
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
    if ((paramURL == null) || (!"file".equalsIgnoreCase(paramURL.getProtocol()))) {
      return null;
    }
    return new File(decodeUrl(paramURL.getFile().replace('/', File.separatorChar)));
  }
  
  public static File[] toFiles(URL[] paramArrayOfURL)
  {
    if ((paramArrayOfURL == null) || (paramArrayOfURL.length == 0)) {
      return EMPTY_FILE_ARRAY;
    }
    File[] arrayOfFile = new File[paramArrayOfURL.length];
    int i = 0;
    while (i < paramArrayOfURL.length)
    {
      URL localURL = paramArrayOfURL[i];
      if (localURL != null)
      {
        if (!localURL.getProtocol().equals("file")) {
          throw new IllegalArgumentException("URL could not be converted to a File: " + localURL);
        }
        arrayOfFile[i] = toFile(localURL);
      }
      i += 1;
    }
    return arrayOfFile;
  }
  
  private static String[] toSuffixes(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfString[i] = ("." + paramArrayOfString[i]);
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
    if (!paramFile.setLastModified(System.currentTimeMillis())) {
      throw new IOException("Unable to set the last modification time for " + paramFile);
    }
  }
  
  private static void validateListFilesParameters(File paramFile, IOFileFilter paramIOFileFilter)
  {
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + paramFile);
    }
    if (paramIOFileFilter == null) {
      throw new NullPointerException("Parameter 'fileFilter' is null");
    }
  }
  
  private static File[] verifiedListFiles(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    return arrayOfFile;
  }
  
  public static boolean waitFor(File paramFile, int paramInt)
  {
    boolean bool = true;
    long l1 = System.currentTimeMillis();
    long l2 = paramInt;
    paramInt = 0;
    try
    {
      while (!paramFile.exists())
      {
        long l3 = System.currentTimeMillis();
        l3 = l1 + l2 * 1000L - l3;
        if (l3 < 0L)
        {
          if (paramInt != 0) {
            Thread.currentThread().interrupt();
          }
          bool = false;
          return bool;
        }
        try
        {
          Thread.sleep(Math.min(100L, l3));
        }
        catch (InterruptedException localInterruptedException)
        {
          paramInt = 1;
        }
        catch (Exception paramFile) {}
      }
      return true;
    }
    finally
    {
      if (paramInt != 0) {
        Thread.currentThread().interrupt();
      }
    }
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
    if (paramCharSequence == null) {}
    for (paramCharSequence = null;; paramCharSequence = paramCharSequence.toString())
    {
      writeStringToFile(paramFile, paramCharSequence, paramCharset, paramBoolean);
      return;
    }
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
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    FileOutputStream localFileOutputStream = openOutputStream(paramFile, paramBoolean);
    paramFile = null;
    try
    {
      localFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      if ((localFileOutputStream == null) || (0 != 0)) {
        try
        {
          localFileOutputStream.close();
          return;
        }
        catch (Throwable paramFile)
        {
          throw new NullPointerException();
        }
      }
      localFileOutputStream.close();
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramFile = paramArrayOfByte;
      throw paramArrayOfByte;
    }
    finally
    {
      if (localFileOutputStream != null) {
        if (paramFile == null) {
          break label81;
        }
      }
    }
    for (;;)
    {
      try
      {
        localFileOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Throwable localThrowable)
      {
        paramFile.addSuppressed(localThrowable);
        continue;
      }
      label81:
      localThrowable.close();
    }
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
  
  public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2, boolean paramBoolean)
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(openOutputStream(paramFile, paramBoolean));
    paramFile = null;
    try
    {
      IOUtils.writeLines(paramCollection, paramString2, localBufferedOutputStream, paramString1);
      if ((localBufferedOutputStream == null) || (0 != 0)) {
        try
        {
          localBufferedOutputStream.close();
          return;
        }
        catch (Throwable paramFile)
        {
          throw new NullPointerException();
        }
      }
      localBufferedOutputStream.close();
      return;
    }
    catch (Throwable paramString1)
    {
      paramFile = paramString1;
      throw paramString1;
    }
    finally
    {
      if (localBufferedOutputStream != null) {
        if (paramFile == null) {
          break label86;
        }
      }
    }
    for (;;)
    {
      try
      {
        localBufferedOutputStream.close();
        throw paramString1;
      }
      catch (Throwable paramCollection)
      {
        paramFile.addSuppressed(paramCollection);
        continue;
      }
      label86:
      localBufferedOutputStream.close();
    }
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
  
  public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset, boolean paramBoolean)
  {
    FileOutputStream localFileOutputStream = openOutputStream(paramFile, paramBoolean);
    paramFile = null;
    try
    {
      IOUtils.write(paramString, localFileOutputStream, paramCharset);
      if ((localFileOutputStream == null) || (0 != 0)) {
        try
        {
          localFileOutputStream.close();
          return;
        }
        catch (Throwable paramFile)
        {
          throw new NullPointerException();
        }
      }
      localFileOutputStream.close();
      return;
    }
    catch (Throwable paramString)
    {
      paramFile = paramString;
      throw paramString;
    }
    finally
    {
      if (localFileOutputStream != null) {
        if (paramFile == null) {
          break label77;
        }
      }
    }
    for (;;)
    {
      try
      {
        localFileOutputStream.close();
        throw paramString;
      }
      catch (Throwable paramCharset)
      {
        paramFile.addSuppressed(paramCharset);
        continue;
      }
      label77:
      localFileOutputStream.close();
    }
  }
  
  @Deprecated
  public static void writeStringToFile(File paramFile, String paramString, boolean paramBoolean)
  {
    writeStringToFile(paramFile, paramString, Charset.defaultCharset(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.FileUtils
 * JD-Core Version:    0.7.0.1
 */