package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.Logging;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LogPackingJob
  extends CancellableJob<byte[]>
{
  public static final int ERROR_CODE_PACK_LOG_FAILED = 1001;
  private static final String TEMP_ZIP_PREFIX = "log_";
  private static final String TEMP_ZIP_SUFFIX = ".zip.tmp";
  private String mLogPath;
  private int mProgress = 0;
  private File mTempZip;
  private ZipOutputStream mTempZipOutStream;
  private ZipEntry mZipEntry;
  
  public LogPackingJob(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      fail(1001, "Log path not exist or not directory!", new Throwable());
      return;
    }
    this.mLogPath = paramString;
    this.mZipEntry = new ZipEntry("onelog");
    this.mTempZip = createTempFileNecessary("log_", ".zip.tmp", localFile);
    Logging.d("Created temporary zip file: %s", new Object[] { this.mTempZip.getAbsolutePath() });
    try
    {
      this.mTempZipOutStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.mTempZip)));
      this.mTempZipOutStream.putNextEntry(this.mZipEntry);
      return;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  private void addFileToZip(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 77	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: ldc 15
    //   6: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   9: ifeq +20 -> 29
    //   12: ldc 116
    //   14: iconst_1
    //   15: anewarray 73	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: invokevirtual 77	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 83	com/tencent/tbs/one/impl/base/Logging:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: return
    //   29: aload_0
    //   30: getfield 34	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mProgress	I
    //   33: istore_2
    //   34: aload_0
    //   35: iload_2
    //   36: iconst_1
    //   37: iadd
    //   38: putfield 34	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mProgress	I
    //   41: aload_0
    //   42: iload_2
    //   43: invokevirtual 120	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:setProgress	(I)V
    //   46: ldc 122
    //   48: iconst_1
    //   49: anewarray 73	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: invokevirtual 77	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: aastore
    //   59: invokestatic 83	com/tencent/tbs/one/impl/base/Logging:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: sipush 4096
    //   65: newarray byte
    //   67: astore 4
    //   69: new 124	java/io/BufferedInputStream
    //   72: dup
    //   73: new 126	java/io/FileInputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: sipush 4096
    //   84: invokespecial 130	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   87: astore_3
    //   88: aload_3
    //   89: astore_1
    //   90: aload_3
    //   91: aload 4
    //   93: iconst_0
    //   94: sipush 4096
    //   97: invokevirtual 134	java/io/BufferedInputStream:read	([BII)I
    //   100: istore_2
    //   101: iload_2
    //   102: iconst_m1
    //   103: if_icmpeq +43 -> 146
    //   106: aload_3
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 98	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mTempZipOutStream	Ljava/util/zip/ZipOutputStream;
    //   112: aload 4
    //   114: iconst_0
    //   115: iload_2
    //   116: invokevirtual 138	java/util/zip/ZipOutputStream:write	([BII)V
    //   119: goto -31 -> 88
    //   122: astore 4
    //   124: aload_3
    //   125: astore_1
    //   126: aload 4
    //   128: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   131: aload_3
    //   132: ifnull -104 -> 28
    //   135: aload_3
    //   136: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   139: return
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   145: return
    //   146: aload_3
    //   147: astore_1
    //   148: aload_0
    //   149: getfield 98	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mTempZipOutStream	Ljava/util/zip/ZipOutputStream;
    //   152: invokevirtual 144	java/util/zip/ZipOutputStream:flush	()V
    //   155: aload_3
    //   156: ifnull -128 -> 28
    //   159: aload_3
    //   160: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   163: return
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   169: return
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   181: aload_3
    //   182: athrow
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   188: goto -7 -> 181
    //   191: astore_3
    //   192: goto -19 -> 173
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_3
    //   199: goto -75 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	LogPackingJob
    //   0	202	1	paramFile	File
    //   33	83	2	i	int
    //   87	73	3	localBufferedInputStream	java.io.BufferedInputStream
    //   170	12	3	localObject1	Object
    //   191	1	3	localObject2	Object
    //   198	1	3	localObject3	Object
    //   67	46	4	arrayOfByte	byte[]
    //   122	5	4	localIOException1	IOException
    //   195	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   90	101	122	java/io/IOException
    //   108	119	122	java/io/IOException
    //   148	155	122	java/io/IOException
    //   135	139	140	java/io/IOException
    //   159	163	164	java/io/IOException
    //   69	88	170	finally
    //   177	181	183	java/io/IOException
    //   90	101	191	finally
    //   108	119	191	finally
    //   126	131	191	finally
    //   148	155	191	finally
    //   69	88	195	java/io/IOException
  }
  
  private void closeTempZipOutputStreamNecessary()
  {
    if (this.mTempZipOutStream != null) {}
    try
    {
      this.mTempZipOutStream.closeEntry();
      this.mTempZipOutStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.mTempZipOutStream = null;
    }
  }
  
  private File createTempFileNecessary(String paramString1, String paramString2, File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      String str = arrayOfFile[i].getName();
      if ((str.startsWith(paramString1)) && (str.endsWith(paramString2))) {
        arrayOfFile[i].delete();
      }
      i += 1;
    }
    return new File(paramFile, paramString1 + System.currentTimeMillis() + paramString2);
  }
  
  private void deleteTempFileNecessary()
  {
    if (this.mTempZip != null)
    {
      this.mTempZip.delete();
      this.mTempZip = null;
      Logging.d("Deleted temporary zip file.", new Object[0]);
    }
  }
  
  /* Error */
  private void replaceWrongZipByte(File paramFile)
  {
    // Byte code:
    //   0: new 192	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_1
    //   5: ldc 194
    //   7: invokespecial 195	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_1
    //   15: ldc 197
    //   17: iconst_2
    //   18: invokestatic 203	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   21: istore_2
    //   22: aload 4
    //   24: astore_1
    //   25: aload 4
    //   27: ldc2_w 204
    //   30: invokevirtual 209	java/io/RandomAccessFile:seek	(J)V
    //   33: aload 4
    //   35: astore_1
    //   36: aload 4
    //   38: invokevirtual 212	java/io/RandomAccessFile:read	()I
    //   41: istore_3
    //   42: iload_3
    //   43: iload_2
    //   44: iand
    //   45: ifle +31 -> 76
    //   48: aload 4
    //   50: astore_1
    //   51: aload 4
    //   53: ldc2_w 204
    //   56: invokevirtual 209	java/io/RandomAccessFile:seek	(J)V
    //   59: aload 4
    //   61: astore_1
    //   62: aload 4
    //   64: iload_2
    //   65: iconst_m1
    //   66: ixor
    //   67: sipush 255
    //   70: iand
    //   71: iload_3
    //   72: iand
    //   73: invokevirtual 214	java/io/RandomAccessFile:write	(I)V
    //   76: aload 4
    //   78: ifnull +8 -> 86
    //   81: aload 4
    //   83: invokevirtual 215	java/io/RandomAccessFile:close	()V
    //   86: return
    //   87: astore_1
    //   88: ldc 217
    //   90: iconst_1
    //   91: anewarray 73	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_1
    //   97: aastore
    //   98: invokestatic 220	com/tencent/tbs/one/impl/base/Logging:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: return
    //   102: astore 5
    //   104: aconst_null
    //   105: astore 4
    //   107: aload 4
    //   109: astore_1
    //   110: ldc 217
    //   112: iconst_1
    //   113: anewarray 73	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload 5
    //   120: aastore
    //   121: invokestatic 220	com/tencent/tbs/one/impl/base/Logging:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload 4
    //   126: ifnull -40 -> 86
    //   129: aload 4
    //   131: invokevirtual 215	java/io/RandomAccessFile:close	()V
    //   134: return
    //   135: astore_1
    //   136: ldc 217
    //   138: iconst_1
    //   139: anewarray 73	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: aastore
    //   146: invokestatic 220	com/tencent/tbs/one/impl/base/Logging:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: return
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 215	java/io/RandomAccessFile:close	()V
    //   162: aload 4
    //   164: athrow
    //   165: astore_1
    //   166: ldc 217
    //   168: iconst_1
    //   169: anewarray 73	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 220	com/tencent/tbs/one/impl/base/Logging:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: goto -17 -> 162
    //   182: astore 4
    //   184: goto -30 -> 154
    //   187: astore 5
    //   189: goto -82 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	LogPackingJob
    //   0	192	1	paramFile	File
    //   21	46	2	i	int
    //   41	32	3	j	int
    //   10	120	4	localRandomAccessFile	java.io.RandomAccessFile
    //   150	13	4	localObject1	Object
    //   182	1	4	localObject2	Object
    //   102	17	5	localException1	java.lang.Exception
    //   187	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   81	86	87	java/io/IOException
    //   0	12	102	java/lang/Exception
    //   129	134	135	java/io/IOException
    //   0	12	150	finally
    //   158	162	165	java/io/IOException
    //   15	22	182	finally
    //   25	33	182	finally
    //   36	42	182	finally
    //   51	59	182	finally
    //   62	76	182	finally
    //   110	124	182	finally
    //   15	22	187	java/lang/Exception
    //   25	33	187	java/lang/Exception
    //   36	42	187	java/lang/Exception
    //   51	59	187	java/lang/Exception
    //   62	76	187	java/lang/Exception
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 223	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 224	java/util/LinkedList:<init>	()V
    //   7: astore_2
    //   8: new 223	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 224	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: new 36	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 56	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mLogPath	Ljava/lang/String;
    //   24: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 45	java/io/File:isDirectory	()Z
    //   34: ifne +57 -> 91
    //   37: new 164	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   44: bipush 34
    //   46: invokevirtual 227	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 56	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mLogPath	Ljava/lang/String;
    //   53: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: bipush 34
    //   58: invokevirtual 227	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   61: ldc 229
    //   63: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_2
    //   70: aload_0
    //   71: sipush 1001
    //   74: aload_2
    //   75: new 49	java/lang/Throwable
    //   78: dup
    //   79: aload_2
    //   80: invokespecial 230	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   83: invokevirtual 54	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:fail	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_0
    //   87: invokespecial 232	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:deleteTempFileNecessary	()V
    //   90: return
    //   91: aload 4
    //   93: invokevirtual 153	java/io/File:listFiles	()[Ljava/io/File;
    //   96: astore 4
    //   98: iconst_0
    //   99: istore_1
    //   100: iload_1
    //   101: aload 4
    //   103: arraylength
    //   104: if_icmpge +41 -> 145
    //   107: aload 4
    //   109: iload_1
    //   110: aaload
    //   111: invokevirtual 45	java/io/File:isDirectory	()Z
    //   114: ifeq +19 -> 133
    //   117: aload_2
    //   118: aload 4
    //   120: iload_1
    //   121: aaload
    //   122: invokevirtual 236	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -30 -> 100
    //   133: aload_3
    //   134: aload 4
    //   136: iload_1
    //   137: aaload
    //   138: invokevirtual 236	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: goto -16 -> 126
    //   145: aload_2
    //   146: invokevirtual 239	java/util/LinkedList:isEmpty	()Z
    //   149: ifne +62 -> 211
    //   152: aload_2
    //   153: invokevirtual 243	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   156: checkcast 36	java/io/File
    //   159: invokevirtual 153	java/io/File:listFiles	()[Ljava/io/File;
    //   162: astore 4
    //   164: iconst_0
    //   165: istore_1
    //   166: iload_1
    //   167: aload 4
    //   169: arraylength
    //   170: if_icmpge -25 -> 145
    //   173: aload 4
    //   175: iload_1
    //   176: aaload
    //   177: invokevirtual 45	java/io/File:isDirectory	()Z
    //   180: ifeq +19 -> 199
    //   183: aload_2
    //   184: aload 4
    //   186: iload_1
    //   187: aaload
    //   188: invokevirtual 236	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   191: pop
    //   192: iload_1
    //   193: iconst_1
    //   194: iadd
    //   195: istore_1
    //   196: goto -30 -> 166
    //   199: aload_3
    //   200: aload 4
    //   202: iload_1
    //   203: aaload
    //   204: invokevirtual 236	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: goto -16 -> 192
    //   211: aload_3
    //   212: new 245	com/tencent/tbs/one/impl/common/statistic/LogPackingJob$1
    //   215: dup
    //   216: aload_0
    //   217: invokespecial 248	com/tencent/tbs/one/impl/common/statistic/LogPackingJob$1:<init>	(Lcom/tencent/tbs/one/impl/common/statistic/LogPackingJob;)V
    //   220: invokestatic 254	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   223: aload_3
    //   224: invokevirtual 258	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   227: astore_2
    //   228: aload_2
    //   229: invokeinterface 263 1 0
    //   234: ifeq +19 -> 253
    //   237: aload_0
    //   238: aload_2
    //   239: invokeinterface 266 1 0
    //   244: checkcast 36	java/io/File
    //   247: invokespecial 268	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:addFileToZip	(Ljava/io/File;)V
    //   250: goto -22 -> 228
    //   253: aload_0
    //   254: invokespecial 270	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:closeTempZipOutputStreamNecessary	()V
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 69	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mTempZip	Ljava/io/File;
    //   262: invokespecial 272	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:replaceWrongZipByte	(Ljava/io/File;)V
    //   265: new 274	java/io/ByteArrayOutputStream
    //   268: dup
    //   269: invokespecial 275	java/io/ByteArrayOutputStream:<init>	()V
    //   272: astore 5
    //   274: new 126	java/io/FileInputStream
    //   277: dup
    //   278: aload_0
    //   279: getfield 69	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:mTempZip	Ljava/io/File;
    //   282: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   285: astore_3
    //   286: aload_3
    //   287: astore_2
    //   288: sipush 8192
    //   291: newarray byte
    //   293: astore 4
    //   295: aload_3
    //   296: astore_2
    //   297: aload_3
    //   298: aload 4
    //   300: invokevirtual 278	java/io/FileInputStream:read	([B)I
    //   303: istore_1
    //   304: iload_1
    //   305: iconst_m1
    //   306: if_icmpeq +51 -> 357
    //   309: aload_3
    //   310: astore_2
    //   311: aload 5
    //   313: aload 4
    //   315: iconst_0
    //   316: iload_1
    //   317: invokevirtual 279	java/io/ByteArrayOutputStream:write	([BII)V
    //   320: goto -25 -> 295
    //   323: astore 4
    //   325: aload_3
    //   326: astore_2
    //   327: aload 4
    //   329: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   332: aload_3
    //   333: ifnull +7 -> 340
    //   336: aload_3
    //   337: invokevirtual 280	java/io/FileInputStream:close	()V
    //   340: aload 5
    //   342: invokevirtual 281	java/io/ByteArrayOutputStream:close	()V
    //   345: aconst_null
    //   346: astore_2
    //   347: aload_0
    //   348: invokespecial 232	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:deleteTempFileNecessary	()V
    //   351: aload_0
    //   352: aload_2
    //   353: invokevirtual 285	com/tencent/tbs/one/impl/common/statistic/LogPackingJob:finish	(Ljava/lang/Object;)V
    //   356: return
    //   357: aload_3
    //   358: astore_2
    //   359: aload 5
    //   361: invokevirtual 286	java/io/ByteArrayOutputStream:flush	()V
    //   364: aload_3
    //   365: astore_2
    //   366: aload 5
    //   368: invokevirtual 290	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   371: astore 4
    //   373: aload 4
    //   375: astore_2
    //   376: aload_3
    //   377: ifnull +7 -> 384
    //   380: aload_3
    //   381: invokevirtual 280	java/io/FileInputStream:close	()V
    //   384: aload 5
    //   386: invokevirtual 281	java/io/ByteArrayOutputStream:close	()V
    //   389: goto -42 -> 347
    //   392: astore_3
    //   393: aload_3
    //   394: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   397: goto -50 -> 347
    //   400: astore_3
    //   401: aload_3
    //   402: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   405: goto -21 -> 384
    //   408: astore_2
    //   409: aload_2
    //   410: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   413: goto -73 -> 340
    //   416: astore_2
    //   417: aload_2
    //   418: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   421: aconst_null
    //   422: astore_2
    //   423: goto -76 -> 347
    //   426: astore_3
    //   427: aconst_null
    //   428: astore_2
    //   429: aload_2
    //   430: ifnull +7 -> 437
    //   433: aload_2
    //   434: invokevirtual 280	java/io/FileInputStream:close	()V
    //   437: aload 5
    //   439: invokevirtual 281	java/io/ByteArrayOutputStream:close	()V
    //   442: aload_3
    //   443: athrow
    //   444: astore_2
    //   445: aload_2
    //   446: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   449: goto -12 -> 437
    //   452: astore_2
    //   453: aload_2
    //   454: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   457: goto -15 -> 442
    //   460: astore_3
    //   461: goto -32 -> 429
    //   464: astore 4
    //   466: aconst_null
    //   467: astore_3
    //   468: goto -143 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	LogPackingJob
    //   99	218	1	i	int
    //   7	369	2	localObject1	Object
    //   408	2	2	localIOException1	IOException
    //   416	2	2	localIOException2	IOException
    //   422	12	2	localObject2	Object
    //   444	2	2	localIOException3	IOException
    //   452	2	2	localIOException4	IOException
    //   15	366	3	localObject3	Object
    //   392	2	3	localIOException5	IOException
    //   400	2	3	localIOException6	IOException
    //   426	17	3	localObject4	Object
    //   460	1	3	localObject5	Object
    //   467	1	3	localObject6	Object
    //   27	287	4	localObject7	Object
    //   323	5	4	localIOException7	IOException
    //   371	3	4	arrayOfByte	byte[]
    //   464	1	4	localIOException8	IOException
    //   272	166	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   288	295	323	java/io/IOException
    //   297	304	323	java/io/IOException
    //   311	320	323	java/io/IOException
    //   359	364	323	java/io/IOException
    //   366	373	323	java/io/IOException
    //   384	389	392	java/io/IOException
    //   380	384	400	java/io/IOException
    //   336	340	408	java/io/IOException
    //   340	345	416	java/io/IOException
    //   274	286	426	finally
    //   433	437	444	java/io/IOException
    //   437	442	452	java/io/IOException
    //   288	295	460	finally
    //   297	304	460	finally
    //   311	320	460	finally
    //   327	332	460	finally
    //   359	364	460	finally
    //   366	373	460	finally
    //   274	286	464	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.LogPackingJob
 * JD-Core Version:    0.7.0.1
 */