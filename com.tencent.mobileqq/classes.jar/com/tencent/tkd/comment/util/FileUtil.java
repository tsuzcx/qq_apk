package com.tencent.tkd.comment.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.jetbrains.annotations.NotNull;

public class FileUtil
{
  private static final int BUFFER_SIZE = 4096;
  private static final String TKD_COMMENT_DIR = "tkd_comment";
  private static final WeakHashMap<String, ReadWriteLock> lockMap = new WeakHashMap();
  
  private static void cleanDirectory(File paramFile)
  {
    if (paramFile == null) {}
    for (;;)
    {
      return;
      if (!paramFile.exists()) {
        throw new IllegalArgumentException(paramFile + " does not exist");
      }
      if (!paramFile.isDirectory()) {
        throw new IllegalArgumentException(paramFile + " is not a directory");
      }
      Object localObject;
      int j;
      int i;
      try
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
          throw new IOException("Failed to list contents of " + paramFile);
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
          localObject = null;
        }
        j = localObject.length;
        paramFile = null;
        i = 0;
      }
      label126:
      File localFile;
      if (i < j) {
        localFile = localObject[i];
      }
      try
      {
        delete(localFile);
        label141:
        i += 1;
        break label126;
        if (paramFile == null) {
          continue;
        }
        throw paramFile;
      }
      catch (IOException paramFile)
      {
        break label141;
      }
    }
  }
  
  @NotNull
  public static File createDir(@NotNull File paramFile, @NotNull String paramString)
  {
    paramFile = new File(paramFile, paramString);
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    return paramFile;
  }
  
  private static void delete(File paramFile)
  {
    if (paramFile == null) {}
    boolean bool;
    do
    {
      return;
      if ((paramFile.isDirectory()) && (notSymbolLink(paramFile))) {
        cleanDirectory(paramFile);
      }
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static boolean deleteQuietly(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if (!paramFile.exists()) {
      return true;
    }
    try
    {
      if (paramFile.isDirectory()) {
        cleanDirectory(paramFile);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          boolean bool = paramFile.delete();
          return bool;
        }
        catch (Throwable paramFile) {}
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
  
  @NotNull
  public static File getCommentFileDir(@NotNull Context paramContext)
  {
    return createDir(getFileDir(paramContext), "tkd_comment");
  }
  
  public static File getFileDir(@NotNull Context paramContext)
  {
    return paramContext.getFilesDir();
  }
  
  private static ReadWriteLock getFileLock(String paramString)
  {
    WeakHashMap localWeakHashMap = lockMap;
    if (paramString == null) {
      try
      {
        throw new NullPointerException("can not lock a null file");
      }
      finally {}
    }
    Object localObject = (ReadWriteLock)lockMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = new ReentrantReadWriteLock();
    lockMap.put(paramString, localObject);
    return localObject;
  }
  
  private static boolean notSymbolLink(File paramFile)
  {
    return paramFile.getCanonicalPath().equals(paramFile.getAbsolutePath());
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
  
  /* Error */
  public static Object readObject(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_0
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 37	java/io/File:exists	()Z
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokestatic 172	com/tencent/tkd/comment/util/FileUtil:getFileLock	(Ljava/lang/String;)Ljava/util/concurrent/locks/ReadWriteLock;
    //   23: invokeinterface 176 1 0
    //   28: astore 11
    //   30: aload 11
    //   32: invokeinterface 181 1 0
    //   37: new 166	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 4
    //   47: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   50: aload_0
    //   51: invokevirtual 191	java/io/File:length	()J
    //   54: l2i
    //   55: invokevirtual 194	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:get	(I)[B
    //   58: astore_2
    //   59: new 196	java/io/ByteArrayInputStream
    //   62: dup
    //   63: aload_2
    //   64: iconst_0
    //   65: aload 4
    //   67: aload_2
    //   68: invokevirtual 200	java/io/FileInputStream:read	([B)I
    //   71: invokespecial 203	java/io/ByteArrayInputStream:<init>	([BII)V
    //   74: astore 5
    //   76: new 205	java/io/ObjectInputStream
    //   79: dup
    //   80: aload 5
    //   82: invokespecial 208	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_0
    //   86: aload_2
    //   87: astore 9
    //   89: aload 5
    //   91: astore 8
    //   93: aload 4
    //   95: astore 7
    //   97: aload_0
    //   98: astore 6
    //   100: aload_0
    //   101: invokevirtual 211	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   104: astore_1
    //   105: aload_2
    //   106: ifnull +10 -> 116
    //   109: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   112: aload_2
    //   113: invokevirtual 215	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:release	([B)V
    //   116: aload_0
    //   117: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   120: pop
    //   121: aload 5
    //   123: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   126: pop
    //   127: aload 4
    //   129: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   132: pop
    //   133: aload 11
    //   135: invokeinterface 222 1 0
    //   140: aload_1
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aconst_null
    //   148: astore 4
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_3
    //   153: astore 9
    //   155: aload_2
    //   156: astore 8
    //   158: aload 4
    //   160: astore 7
    //   162: aload_0
    //   163: astore 6
    //   165: aload_1
    //   166: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   169: aload_3
    //   170: ifnull +10 -> 180
    //   173: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   176: aload_3
    //   177: invokevirtual 215	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:release	([B)V
    //   180: aload_0
    //   181: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   184: pop
    //   185: aload_2
    //   186: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   189: pop
    //   190: aload 4
    //   192: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   195: pop
    //   196: aload 10
    //   198: astore_1
    //   199: goto -66 -> 133
    //   202: astore_0
    //   203: aload 11
    //   205: invokeinterface 222 1 0
    //   210: aload_0
    //   211: athrow
    //   212: astore_0
    //   213: aconst_null
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 4
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_3
    //   223: ifnull +10 -> 233
    //   226: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   229: aload_3
    //   230: invokevirtual 215	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:release	([B)V
    //   233: aload_2
    //   234: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   237: pop
    //   238: aload_1
    //   239: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   242: pop
    //   243: aload 4
    //   245: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   248: pop
    //   249: aload_0
    //   250: athrow
    //   251: astore_0
    //   252: aconst_null
    //   253: astore_3
    //   254: aconst_null
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -36 -> 222
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_1
    //   264: aconst_null
    //   265: astore 5
    //   267: aload_2
    //   268: astore_3
    //   269: aload 5
    //   271: astore_2
    //   272: goto -50 -> 222
    //   275: astore_0
    //   276: aconst_null
    //   277: astore 6
    //   279: aload_2
    //   280: astore_3
    //   281: aload 5
    //   283: astore_1
    //   284: aload 6
    //   286: astore_2
    //   287: goto -65 -> 222
    //   290: astore_0
    //   291: aload 9
    //   293: astore_3
    //   294: aload 8
    //   296: astore_1
    //   297: aload 7
    //   299: astore 4
    //   301: aload 6
    //   303: astore_2
    //   304: goto -82 -> 222
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_3
    //   310: aconst_null
    //   311: astore_2
    //   312: aconst_null
    //   313: astore_0
    //   314: goto -162 -> 152
    //   317: astore_1
    //   318: aconst_null
    //   319: astore 5
    //   321: aconst_null
    //   322: astore_0
    //   323: aload_2
    //   324: astore_3
    //   325: aload 5
    //   327: astore_2
    //   328: goto -176 -> 152
    //   331: astore_1
    //   332: aconst_null
    //   333: astore_0
    //   334: aload_2
    //   335: astore_3
    //   336: aload 5
    //   338: astore_2
    //   339: goto -187 -> 152
    //   342: astore_1
    //   343: aload_2
    //   344: astore_3
    //   345: aload 5
    //   347: astore_2
    //   348: goto -196 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFile	File
    //   104	37	1	localObject1	Object
    //   142	24	1	localThrowable1	Throwable
    //   198	99	1	localObject2	Object
    //   307	1	1	localThrowable2	Throwable
    //   317	1	1	localThrowable3	Throwable
    //   331	1	1	localThrowable4	Throwable
    //   342	1	1	localThrowable5	Throwable
    //   58	290	2	localObject3	Object
    //   144	201	3	localObject4	Object
    //   45	255	4	localObject5	Object
    //   74	272	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   98	204	6	localFile	File
    //   95	203	7	localObject6	Object
    //   91	204	8	localObject7	Object
    //   87	205	9	localObject8	Object
    //   1	196	10	localObject9	Object
    //   28	176	11	localLock	java.util.concurrent.locks.Lock
    // Exception table:
    //   from	to	target	type
    //   37	47	142	java/lang/Throwable
    //   30	37	202	finally
    //   109	116	202	finally
    //   116	133	202	finally
    //   173	180	202	finally
    //   180	196	202	finally
    //   226	233	202	finally
    //   233	251	202	finally
    //   37	47	212	finally
    //   47	59	251	finally
    //   59	76	261	finally
    //   76	86	275	finally
    //   100	105	290	finally
    //   165	169	290	finally
    //   47	59	307	java/lang/Throwable
    //   59	76	317	java/lang/Throwable
    //   76	86	331	java/lang/Throwable
    //   100	105	342	java/lang/Throwable
  }
  
  /* Error */
  public static String readStringFromInputStream(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 230	java/io/BufferedInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 231	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore_3
    //   12: new 233	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 234	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore 4
    //   21: aload_3
    //   22: astore 6
    //   24: aload 4
    //   26: astore 5
    //   28: sipush 4096
    //   31: newarray byte
    //   33: astore 7
    //   35: aload_3
    //   36: astore 6
    //   38: aload 4
    //   40: astore 5
    //   42: aload_3
    //   43: aload 7
    //   45: invokevirtual 235	java/io/BufferedInputStream:read	([B)I
    //   48: istore_2
    //   49: iload_2
    //   50: iconst_m1
    //   51: if_icmpeq +51 -> 102
    //   54: aload_3
    //   55: astore 6
    //   57: aload 4
    //   59: astore 5
    //   61: aload 4
    //   63: aload 7
    //   65: iconst_0
    //   66: iload_2
    //   67: invokevirtual 238	java/io/ByteArrayOutputStream:write	([BII)V
    //   70: goto -35 -> 35
    //   73: astore 5
    //   75: aload 4
    //   77: astore_1
    //   78: aload 5
    //   80: astore 4
    //   82: aload_3
    //   83: astore 6
    //   85: aload_1
    //   86: astore 5
    //   88: aload 4
    //   90: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   93: aload_1
    //   94: aload_0
    //   95: aload_3
    //   96: invokestatic 242	com/tencent/tkd/comment/util/FileUtil:readStringFromInputStreamFinally	(Ljava/io/ByteArrayOutputStream;Ljava/io/InputStream;Ljava/io/BufferedInputStream;)V
    //   99: ldc 244
    //   101: areturn
    //   102: aload_1
    //   103: ifnull +47 -> 150
    //   106: aload_3
    //   107: astore 6
    //   109: aload 4
    //   111: astore 5
    //   113: aload_1
    //   114: invokevirtual 247	java/lang/String:length	()I
    //   117: ifle +33 -> 150
    //   120: aload_3
    //   121: astore 6
    //   123: aload 4
    //   125: astore 5
    //   127: new 147	java/lang/String
    //   130: dup
    //   131: aload 4
    //   133: invokevirtual 251	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   136: aload_1
    //   137: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   140: astore_1
    //   141: aload 4
    //   143: aload_0
    //   144: aload_3
    //   145: invokestatic 242	com/tencent/tkd/comment/util/FileUtil:readStringFromInputStreamFinally	(Ljava/io/ByteArrayOutputStream;Ljava/io/InputStream;Ljava/io/BufferedInputStream;)V
    //   148: aload_1
    //   149: areturn
    //   150: aload_3
    //   151: astore 6
    //   153: aload 4
    //   155: astore 5
    //   157: new 147	java/lang/String
    //   160: dup
    //   161: aload 4
    //   163: invokevirtual 251	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   166: invokespecial 256	java/lang/String:<init>	([B)V
    //   169: astore_1
    //   170: goto -29 -> 141
    //   173: astore 5
    //   175: aload 4
    //   177: astore_1
    //   178: aload 5
    //   180: astore 4
    //   182: goto -100 -> 82
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_3
    //   188: aconst_null
    //   189: astore 5
    //   191: aload 5
    //   193: aload_0
    //   194: aload_3
    //   195: invokestatic 242	com/tencent/tkd/comment/util/FileUtil:readStringFromInputStreamFinally	(Ljava/io/ByteArrayOutputStream;Ljava/io/InputStream;Ljava/io/BufferedInputStream;)V
    //   198: aload_1
    //   199: athrow
    //   200: astore_1
    //   201: aconst_null
    //   202: astore 5
    //   204: goto -13 -> 191
    //   207: astore_1
    //   208: aload 6
    //   210: astore_3
    //   211: goto -20 -> 191
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_3
    //   218: aconst_null
    //   219: astore_1
    //   220: goto -138 -> 82
    //   223: astore 4
    //   225: aconst_null
    //   226: astore_1
    //   227: goto -145 -> 82
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_3
    //   234: aload 5
    //   236: astore_1
    //   237: goto -55 -> 182
    //   240: astore 4
    //   242: aload 5
    //   244: astore_1
    //   245: goto -63 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramInputStream	InputStream
    //   0	248	1	paramString	String
    //   48	19	2	i	int
    //   11	223	3	localObject1	Object
    //   19	162	4	localObject2	Object
    //   214	1	4	localException1	Exception
    //   223	1	4	localException2	Exception
    //   230	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   240	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	59	5	localObject3	Object
    //   73	6	5	localException3	Exception
    //   86	70	5	localObject4	Object
    //   173	6	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   189	54	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   22	187	6	localObject5	Object
    //   33	31	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	35	73	java/lang/Exception
    //   42	49	73	java/lang/Exception
    //   61	70	73	java/lang/Exception
    //   113	120	73	java/lang/Exception
    //   127	141	73	java/lang/Exception
    //   157	170	73	java/lang/Exception
    //   28	35	173	java/lang/OutOfMemoryError
    //   42	49	173	java/lang/OutOfMemoryError
    //   61	70	173	java/lang/OutOfMemoryError
    //   113	120	173	java/lang/OutOfMemoryError
    //   127	141	173	java/lang/OutOfMemoryError
    //   157	170	173	java/lang/OutOfMemoryError
    //   3	12	185	finally
    //   12	21	200	finally
    //   28	35	207	finally
    //   42	49	207	finally
    //   61	70	207	finally
    //   88	93	207	finally
    //   113	120	207	finally
    //   127	141	207	finally
    //   157	170	207	finally
    //   3	12	214	java/lang/Exception
    //   12	21	223	java/lang/Exception
    //   3	12	230	java/lang/OutOfMemoryError
    //   12	21	240	java/lang/OutOfMemoryError
  }
  
  private static void readStringFromInputStreamFinally(ByteArrayOutputStream paramByteArrayOutputStream, InputStream paramInputStream, BufferedInputStream paramBufferedInputStream)
  {
    if (paramByteArrayOutputStream != null) {}
    try
    {
      paramByteArrayOutputStream.close();
      if (paramBufferedInputStream == null) {}
    }
    catch (IOException paramByteArrayOutputStream)
    {
      try
      {
        paramBufferedInputStream.close();
        if (paramInputStream != null) {}
        try
        {
          paramInputStream.close();
          return;
        }
        catch (IOException paramByteArrayOutputStream)
        {
          paramByteArrayOutputStream.printStackTrace();
        }
        paramByteArrayOutputStream = paramByteArrayOutputStream;
        paramByteArrayOutputStream.printStackTrace();
      }
      catch (IOException paramByteArrayOutputStream)
      {
        for (;;)
        {
          paramByteArrayOutputStream.printStackTrace();
        }
      }
    }
  }
  
  private static boolean safetyCloseStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return true;
      }
      catch (IOException paramCloseable) {}
    }
    return false;
  }
  
  /* Error */
  public static boolean unzip(InputStream paramInputStream, File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 271	java/util/zip/ZipInputStream
    //   6: dup
    //   7: new 230	java/io/BufferedInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 231	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: invokespecial 272	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore 5
    //   20: aload 5
    //   22: astore_0
    //   23: aload 5
    //   25: invokevirtual 276	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnull +128 -> 160
    //   35: aload 5
    //   37: astore_0
    //   38: aload 6
    //   40: invokevirtual 281	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   43: ldc_w 283
    //   46: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   49: ifne -29 -> 20
    //   52: aload 5
    //   54: astore_0
    //   55: aload 6
    //   57: invokevirtual 288	java/util/zip/ZipEntry:isDirectory	()Z
    //   60: ifne +62 -> 122
    //   63: aload_2
    //   64: ifnull +18 -> 82
    //   67: aload 5
    //   69: astore_0
    //   70: aload_2
    //   71: aload 6
    //   73: invokevirtual 281	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   76: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq -59 -> 20
    //   82: aload 5
    //   84: astore_0
    //   85: aload 6
    //   87: aload_1
    //   88: aload 5
    //   90: invokestatic 292	com/tencent/tkd/comment/util/FileUtil:upZipInner	(Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/util/zip/ZipInputStream;)V
    //   93: goto -73 -> 20
    //   96: astore_2
    //   97: aload 5
    //   99: astore_1
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   106: iload 4
    //   108: istore_3
    //   109: aload_1
    //   110: ifnull +10 -> 120
    //   113: aload_1
    //   114: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   117: iload 4
    //   119: istore_3
    //   120: iload_3
    //   121: ireturn
    //   122: aload 5
    //   124: astore_0
    //   125: new 33	java/io/File
    //   128: dup
    //   129: aload_1
    //   130: aload 6
    //   132: invokevirtual 281	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   135: invokespecial 82	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   138: invokevirtual 85	java/io/File:mkdirs	()Z
    //   141: pop
    //   142: goto -122 -> 20
    //   145: astore_2
    //   146: aload_0
    //   147: astore_1
    //   148: aload_2
    //   149: astore_0
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   158: aload_0
    //   159: athrow
    //   160: iconst_1
    //   161: istore_3
    //   162: aload 5
    //   164: ifnull -44 -> 120
    //   167: aload 5
    //   169: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   172: iconst_1
    //   173: ireturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   179: iconst_1
    //   180: ireturn
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   193: goto -35 -> 158
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -49 -> 150
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_1
    //   205: goto -105 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramInputStream	InputStream
    //   0	208	1	paramFile	File
    //   0	208	2	paramString	String
    //   108	54	3	bool1	boolean
    //   1	117	4	bool2	boolean
    //   18	150	5	localZipInputStream	ZipInputStream
    //   28	103	6	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   23	30	96	java/lang/Throwable
    //   38	52	96	java/lang/Throwable
    //   55	63	96	java/lang/Throwable
    //   70	82	96	java/lang/Throwable
    //   85	93	96	java/lang/Throwable
    //   125	142	96	java/lang/Throwable
    //   23	30	145	finally
    //   38	52	145	finally
    //   55	63	145	finally
    //   70	82	145	finally
    //   85	93	145	finally
    //   102	106	145	finally
    //   125	142	145	finally
    //   167	172	174	java/io/IOException
    //   113	117	181	java/io/IOException
    //   154	158	188	java/io/IOException
    //   3	20	196	finally
    //   3	20	202	java/lang/Throwable
  }
  
  private static void upZipInner(ZipEntry paramZipEntry, File paramFile, ZipInputStream paramZipInputStream)
  {
    paramZipEntry = new File(paramFile, paramZipEntry.getName());
    paramZipEntry.getParentFile().mkdirs();
    paramZipEntry = new FileOutputStream(paramZipEntry, false);
    paramFile = new byte[32768];
    try
    {
      for (;;)
      {
        int i = paramZipInputStream.read(paramFile);
        if (i == -1) {
          break;
        }
        paramZipEntry.write(paramFile, 0, i);
      }
      try
      {
        paramZipEntry.close();
        throw paramFile;
      }
      catch (Exception paramZipEntry)
      {
        for (;;)
        {
          paramZipEntry.printStackTrace();
        }
      }
    }
    catch (IOException paramFile)
    {
      paramFile = paramFile;
      paramFile.printStackTrace();
      for (;;)
      {
        try
        {
          paramZipEntry.close();
          return;
        }
        catch (Exception paramZipEntry)
        {
          paramZipEntry.printStackTrace();
          return;
        }
        try
        {
          paramZipEntry.close();
          return;
        }
        catch (Exception paramZipEntry)
        {
          paramZipEntry.printStackTrace();
          return;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public static boolean writeObject(File paramFile, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokestatic 172	com/tencent/tkd/comment/util/FileUtil:getFileLock	(Ljava/lang/String;)Ljava/util/concurrent/locks/ReadWriteLock;
    //   21: invokeinterface 311 1 0
    //   26: astore 8
    //   28: aload 8
    //   30: invokeinterface 181 1 0
    //   35: aload_0
    //   36: invokevirtual 37	java/io/File:exists	()Z
    //   39: ifne +44 -> 83
    //   42: aload_0
    //   43: invokevirtual 314	java/io/File:createNewFile	()Z
    //   46: istore_3
    //   47: iload_3
    //   48: ifne +35 -> 83
    //   51: aconst_null
    //   52: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   55: ifeq +19 -> 74
    //   58: aconst_null
    //   59: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   62: ifeq +12 -> 74
    //   65: aconst_null
    //   66: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq +3 -> 74
    //   74: aload 8
    //   76: invokeinterface 222 1 0
    //   81: iconst_0
    //   82: ireturn
    //   83: new 233	java/io/ByteArrayOutputStream
    //   86: dup
    //   87: sipush 4096
    //   90: invokespecial 317	java/io/ByteArrayOutputStream:<init>	(I)V
    //   93: astore 4
    //   95: new 319	java/io/ObjectOutputStream
    //   98: dup
    //   99: aload 4
    //   101: invokespecial 322	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore 5
    //   106: aload 5
    //   108: aload_1
    //   109: invokevirtual 325	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   112: aload 5
    //   114: invokevirtual 328	java/io/ObjectOutputStream:flush	()V
    //   117: new 298	java/io/FileOutputStream
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 329	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   125: astore_0
    //   126: aload 4
    //   128: aload_0
    //   129: invokevirtual 332	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   132: aload 4
    //   134: invokevirtual 333	java/io/ByteArrayOutputStream:flush	()V
    //   137: aload 5
    //   139: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   142: ifeq +29 -> 171
    //   145: aload 4
    //   147: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   150: ifeq +21 -> 171
    //   153: aload_0
    //   154: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   157: istore_3
    //   158: iload_3
    //   159: ifeq +12 -> 171
    //   162: aload 8
    //   164: invokeinterface 222 1 0
    //   169: iload_2
    //   170: ireturn
    //   171: iconst_0
    //   172: istore_2
    //   173: goto -11 -> 162
    //   176: astore 4
    //   178: aconst_null
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: aload 6
    //   184: astore 5
    //   186: aload 4
    //   188: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   191: aload_1
    //   192: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   195: ifeq +165 -> 360
    //   198: aload_0
    //   199: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   202: ifeq +158 -> 360
    //   205: aload 5
    //   207: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   210: ifne -48 -> 162
    //   213: goto +147 -> 360
    //   216: aload_1
    //   217: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   220: ifeq +19 -> 239
    //   223: aload 4
    //   225: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   228: ifeq +11 -> 239
    //   231: aload 6
    //   233: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   236: ifeq +3 -> 239
    //   239: aload_0
    //   240: athrow
    //   241: astore_0
    //   242: aload 8
    //   244: invokeinterface 222 1 0
    //   249: aload_0
    //   250: athrow
    //   251: astore_0
    //   252: aconst_null
    //   253: astore_1
    //   254: aload 7
    //   256: astore 6
    //   258: goto -42 -> 216
    //   261: astore_0
    //   262: aload 7
    //   264: astore 6
    //   266: aload 5
    //   268: astore_1
    //   269: goto -53 -> 216
    //   272: astore_1
    //   273: aload_0
    //   274: astore 6
    //   276: aload_1
    //   277: astore_0
    //   278: aload 5
    //   280: astore_1
    //   281: goto -65 -> 216
    //   284: astore 6
    //   286: aload_0
    //   287: astore 4
    //   289: aload 6
    //   291: astore_0
    //   292: aload 5
    //   294: astore 6
    //   296: goto -80 -> 216
    //   299: astore 5
    //   301: aload 4
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_1
    //   306: aload 5
    //   308: astore 4
    //   310: aload 6
    //   312: astore 5
    //   314: goto -128 -> 186
    //   317: astore 7
    //   319: aload 4
    //   321: astore_0
    //   322: aload 5
    //   324: astore_1
    //   325: aload 7
    //   327: astore 4
    //   329: aload 6
    //   331: astore 5
    //   333: goto -147 -> 186
    //   336: astore 7
    //   338: aload 4
    //   340: astore_1
    //   341: aload 5
    //   343: astore 6
    //   345: aload 7
    //   347: astore 4
    //   349: aload_0
    //   350: astore 5
    //   352: aload_1
    //   353: astore_0
    //   354: aload 6
    //   356: astore_1
    //   357: goto -171 -> 186
    //   360: iconst_0
    //   361: istore_2
    //   362: goto -200 -> 162
    //   365: astore_0
    //   366: aconst_null
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_1
    //   371: aload 7
    //   373: astore 6
    //   375: goto -159 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramFile	File
    //   0	378	1	paramObject	Object
    //   1	361	2	bool1	boolean
    //   46	113	3	bool2	boolean
    //   93	53	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   176	48	4	localThrowable1	Throwable
    //   287	81	4	localObject1	Object
    //   104	189	5	localObject2	Object
    //   299	8	5	localThrowable2	Throwable
    //   312	39	5	localObject3	Object
    //   6	269	6	localObject4	Object
    //   284	6	6	localObject5	Object
    //   294	80	6	localObject6	Object
    //   3	260	7	localObject7	Object
    //   317	9	7	localThrowable3	Throwable
    //   336	36	7	localThrowable4	Throwable
    //   26	217	8	localLock	java.util.concurrent.locks.Lock
    // Exception table:
    //   from	to	target	type
    //   35	47	176	java/lang/Throwable
    //   83	95	176	java/lang/Throwable
    //   28	35	241	finally
    //   51	70	241	finally
    //   137	158	241	finally
    //   191	205	241	finally
    //   205	213	241	finally
    //   216	239	241	finally
    //   239	241	241	finally
    //   95	106	251	finally
    //   106	126	261	finally
    //   126	137	272	finally
    //   186	191	284	finally
    //   95	106	299	java/lang/Throwable
    //   106	126	317	java/lang/Throwable
    //   126	137	336	java/lang/Throwable
    //   35	47	365	finally
    //   83	95	365	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */