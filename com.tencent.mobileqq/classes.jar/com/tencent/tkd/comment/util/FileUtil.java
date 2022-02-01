package com.tencent.tkd.comment.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;

public class FileUtil
{
  private static final int BUFFER_SIZE = 4096;
  private static final String TKD_COMMENT_DIR = "tkd_comment";
  private static final WeakHashMap<String, ReadWriteLock> lockMap = new WeakHashMap();
  
  private static void cleanDirectory(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        File localFile = null;
        try
        {
          File[] arrayOfFile = paramFile.listFiles();
        }
        catch (Error localError)
        {
          localError.printStackTrace();
          localStringBuilder = null;
        }
        if (localStringBuilder != null)
        {
          int j = localStringBuilder.length;
          int i = 0;
          paramFile = localFile;
          while (i < j)
          {
            localFile = localStringBuilder[i];
            try
            {
              delete(localFile);
            }
            catch (IOException paramFile) {}
            i += 1;
          }
          if (paramFile == null) {
            return;
          }
          throw paramFile;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to list contents of ");
        localStringBuilder.append(paramFile);
        throw new IOException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" is not a directory");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(" does not exist");
    paramFile = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramFile;
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
    if (paramFile == null) {
      return;
    }
    if ((paramFile.isDirectory()) && (notSymbolLink(paramFile))) {
      cleanDirectory(paramFile);
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
      localThrowable.printStackTrace();
    }
    try
    {
      boolean bool = paramFile.delete();
      return bool;
    }
    catch (Throwable paramFile) {}
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
    if (paramString != null) {}
    try
    {
      Object localObject = (ReadWriteLock)lockMap.get(paramString);
      if (localObject != null) {
        return localObject;
      }
      localObject = new ReentrantReadWriteLock();
      lockMap.put(paramString, localObject);
      return localObject;
    }
    finally
    {
      label60:
      break label60;
    }
    throw new NullPointerException("can not lock a null file");
    throw paramString;
  }
  
  private static boolean notSymbolLink(File paramFile)
  {
    return paramFile.getCanonicalPath().equals(paramFile.getAbsolutePath());
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
  
  /* Error */
  public static Object readObject(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 9
    //   5: aload_0
    //   6: ifnull +337 -> 343
    //   9: aload_0
    //   10: invokevirtual 37	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   22: invokestatic 172	com/tencent/tkd/comment/util/FileUtil:getFileLock	(Ljava/lang/String;)Ljava/util/concurrent/locks/ReadWriteLock;
    //   25: invokeinterface 176 1 0
    //   30: astore 10
    //   32: aload 10
    //   34: invokeinterface 181 1 0
    //   39: new 158	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_1
    //   48: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   51: aload_0
    //   52: invokevirtual 191	java/io/File:length	()J
    //   55: l2i
    //   56: invokevirtual 194	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:get	(I)[B
    //   59: astore_0
    //   60: new 196	java/io/ByteArrayInputStream
    //   63: dup
    //   64: aload_0
    //   65: iconst_0
    //   66: aload_1
    //   67: aload_0
    //   68: invokevirtual 200	java/io/FileInputStream:read	([B)I
    //   71: invokespecial 203	java/io/ByteArrayInputStream:<init>	([BII)V
    //   74: astore_3
    //   75: new 205	java/io/ObjectInputStream
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 208	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore_2
    //   84: aload_1
    //   85: astore 4
    //   87: aload_2
    //   88: astore 5
    //   90: aload_3
    //   91: astore 6
    //   93: aload_0
    //   94: astore 7
    //   96: aload_2
    //   97: invokevirtual 211	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   100: astore 8
    //   102: aload_0
    //   103: ifnull +10 -> 113
    //   106: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   109: aload_0
    //   110: invokevirtual 215	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:release	([B)V
    //   113: aload_2
    //   114: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   117: pop
    //   118: aload_3
    //   119: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   122: pop
    //   123: aload 8
    //   125: astore_0
    //   126: aload_1
    //   127: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   130: pop
    //   131: goto +154 -> 285
    //   134: astore 8
    //   136: goto +105 -> 241
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_1
    //   144: astore 4
    //   146: aload_2
    //   147: astore_1
    //   148: aload_3
    //   149: astore_2
    //   150: aload 5
    //   152: astore_3
    //   153: goto +151 -> 304
    //   156: astore 8
    //   158: aconst_null
    //   159: astore_2
    //   160: goto +81 -> 241
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: astore 5
    //   169: aload_1
    //   170: astore 4
    //   172: aload 5
    //   174: astore_1
    //   175: goto +129 -> 304
    //   178: astore_2
    //   179: aload_1
    //   180: astore 4
    //   182: aload_2
    //   183: astore_1
    //   184: goto +47 -> 231
    //   187: astore_3
    //   188: goto +17 -> 205
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_1
    //   195: astore 4
    //   197: aload_2
    //   198: astore_1
    //   199: goto +32 -> 231
    //   202: astore_3
    //   203: aconst_null
    //   204: astore_1
    //   205: aconst_null
    //   206: astore 6
    //   208: aconst_null
    //   209: astore 5
    //   211: aload_2
    //   212: astore_0
    //   213: aload_1
    //   214: astore 4
    //   216: aload 6
    //   218: astore_1
    //   219: aload 5
    //   221: astore_2
    //   222: goto +82 -> 304
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_0
    //   228: aload_0
    //   229: astore 4
    //   231: aconst_null
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_1
    //   236: astore 8
    //   238: aload 4
    //   240: astore_1
    //   241: aload_1
    //   242: astore 4
    //   244: aload_2
    //   245: astore 5
    //   247: aload_3
    //   248: astore 6
    //   250: aload_0
    //   251: astore 7
    //   253: aload 8
    //   255: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   258: aload_0
    //   259: ifnull +10 -> 269
    //   262: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   265: aload_0
    //   266: invokevirtual 215	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:release	([B)V
    //   269: aload_2
    //   270: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   273: pop
    //   274: aload_3
    //   275: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   278: pop
    //   279: aload 9
    //   281: astore_0
    //   282: goto -156 -> 126
    //   285: aload 10
    //   287: invokeinterface 222 1 0
    //   292: aload_0
    //   293: areturn
    //   294: astore_3
    //   295: aload 7
    //   297: astore_0
    //   298: aload 6
    //   300: astore_2
    //   301: aload 5
    //   303: astore_1
    //   304: aload_0
    //   305: ifnull +10 -> 315
    //   308: invokestatic 187	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:getInstance	()Lcom/tencent/tkd/comment/util/io/ByteArrayPoolChunk;
    //   311: aload_0
    //   312: invokevirtual 215	com/tencent/tkd/comment/util/io/ByteArrayPoolChunk:release	([B)V
    //   315: aload_1
    //   316: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   319: pop
    //   320: aload_2
    //   321: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   324: pop
    //   325: aload 4
    //   327: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   330: pop
    //   331: aload_3
    //   332: athrow
    //   333: astore_0
    //   334: aload 10
    //   336: invokeinterface 222 1 0
    //   341: aload_0
    //   342: athrow
    //   343: aconst_null
    //   344: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramFile	File
    //   47	172	1	localObject1	Object
    //   225	11	1	localThrowable1	Throwable
    //   240	76	1	localObject2	Object
    //   1	166	2	localObject3	Object
    //   178	5	2	localThrowable2	Throwable
    //   191	21	2	localThrowable3	Throwable
    //   221	100	2	localObject4	Object
    //   74	79	3	localObject5	Object
    //   163	1	3	localObject6	Object
    //   187	1	3	localObject7	Object
    //   202	1	3	localObject8	Object
    //   234	41	3	localCloseable	Closeable
    //   294	38	3	localObject9	Object
    //   85	241	4	localObject10	Object
    //   88	1	5	localObject11	Object
    //   139	12	5	localObject12	Object
    //   167	135	5	localObject13	Object
    //   91	208	6	localObject14	Object
    //   94	202	7	localFile	File
    //   100	24	8	localObject15	Object
    //   134	1	8	localThrowable4	Throwable
    //   156	1	8	localThrowable5	Throwable
    //   236	18	8	localThrowable6	Throwable
    //   3	277	9	localObject16	Object
    //   30	305	10	localLock	java.util.concurrent.locks.Lock
    // Exception table:
    //   from	to	target	type
    //   96	102	134	java/lang/Throwable
    //   75	84	139	finally
    //   75	84	156	java/lang/Throwable
    //   60	75	163	finally
    //   60	75	178	java/lang/Throwable
    //   48	60	187	finally
    //   48	60	191	java/lang/Throwable
    //   39	48	202	finally
    //   39	48	225	java/lang/Throwable
    //   96	102	294	finally
    //   253	258	294	finally
    //   32	39	333	finally
    //   106	113	333	finally
    //   113	123	333	finally
    //   126	131	333	finally
    //   262	269	333	finally
    //   269	279	333	finally
    //   308	315	333	finally
    //   315	333	333	finally
  }
  
  /* Error */
  public static String readStringFromInputStream(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: new 230	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 231	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   14: astore_3
    //   15: aload_3
    //   16: astore 4
    //   18: new 233	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 234	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore 6
    //   27: sipush 4096
    //   30: newarray byte
    //   32: astore 4
    //   34: aload_3
    //   35: aload 4
    //   37: invokevirtual 235	java/io/BufferedInputStream:read	([B)I
    //   40: istore_2
    //   41: iload_2
    //   42: iconst_m1
    //   43: if_icmpeq +15 -> 58
    //   46: aload 6
    //   48: aload 4
    //   50: iconst_0
    //   51: iload_2
    //   52: invokevirtual 238	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -21 -> 34
    //   58: aload_1
    //   59: ifnull +27 -> 86
    //   62: aload_1
    //   63: invokevirtual 241	java/lang/String:length	()I
    //   66: ifle +20 -> 86
    //   69: new 147	java/lang/String
    //   72: dup
    //   73: aload 6
    //   75: invokevirtual 245	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   78: aload_1
    //   79: invokespecial 248	java/lang/String:<init>	([BLjava/lang/String;)V
    //   82: astore_1
    //   83: goto +16 -> 99
    //   86: new 147	java/lang/String
    //   89: dup
    //   90: aload 6
    //   92: invokevirtual 245	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   95: invokespecial 250	java/lang/String:<init>	([B)V
    //   98: astore_1
    //   99: aload 6
    //   101: aload_0
    //   102: aload_3
    //   103: invokestatic 254	com/tencent/tkd/comment/util/FileUtil:readStringFromInputStreamFinally	(Ljava/io/ByteArrayOutputStream;Ljava/io/InputStream;Ljava/io/BufferedInputStream;)V
    //   106: aload_1
    //   107: areturn
    //   108: astore 5
    //   110: aload 6
    //   112: astore_1
    //   113: goto +79 -> 192
    //   116: astore_1
    //   117: goto +4 -> 121
    //   120: astore_1
    //   121: goto +39 -> 160
    //   124: astore_1
    //   125: aload 7
    //   127: astore 6
    //   129: goto +31 -> 160
    //   132: astore_1
    //   133: aload 7
    //   135: astore 6
    //   137: goto +23 -> 160
    //   140: astore 5
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_3
    //   145: astore_1
    //   146: goto +46 -> 192
    //   149: astore_1
    //   150: goto +4 -> 154
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_3
    //   156: aload 7
    //   158: astore 6
    //   160: aload 6
    //   162: astore 5
    //   164: aload_3
    //   165: astore 4
    //   167: aload_1
    //   168: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   171: aload 6
    //   173: aload_0
    //   174: aload_3
    //   175: invokestatic 254	com/tencent/tkd/comment/util/FileUtil:readStringFromInputStreamFinally	(Ljava/io/ByteArrayOutputStream;Ljava/io/InputStream;Ljava/io/BufferedInputStream;)V
    //   178: ldc_w 256
    //   181: areturn
    //   182: astore_3
    //   183: aload 5
    //   185: astore_1
    //   186: aload_3
    //   187: astore 5
    //   189: aload 4
    //   191: astore_3
    //   192: aload_1
    //   193: aload_0
    //   194: aload_3
    //   195: invokestatic 254	com/tencent/tkd/comment/util/FileUtil:readStringFromInputStreamFinally	(Ljava/io/ByteArrayOutputStream;Ljava/io/InputStream;Ljava/io/BufferedInputStream;)V
    //   198: goto +6 -> 204
    //   201: aload 5
    //   203: athrow
    //   204: goto -3 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramInputStream	InputStream
    //   0	207	1	paramString	String
    //   40	12	2	i	int
    //   14	161	3	localBufferedInputStream	BufferedInputStream
    //   182	5	3	localObject1	Object
    //   191	4	3	localObject2	Object
    //   16	174	4	localObject3	Object
    //   1	1	5	localObject4	Object
    //   108	1	5	localObject5	Object
    //   140	1	5	localObject6	Object
    //   162	40	5	localObject7	Object
    //   25	147	6	localObject8	Object
    //   4	153	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   27	34	108	finally
    //   34	41	108	finally
    //   46	55	108	finally
    //   62	83	108	finally
    //   86	99	108	finally
    //   27	34	116	java/lang/OutOfMemoryError
    //   34	41	116	java/lang/OutOfMemoryError
    //   46	55	116	java/lang/OutOfMemoryError
    //   62	83	116	java/lang/OutOfMemoryError
    //   86	99	116	java/lang/OutOfMemoryError
    //   27	34	120	java/lang/Exception
    //   34	41	120	java/lang/Exception
    //   46	55	120	java/lang/Exception
    //   62	83	120	java/lang/Exception
    //   86	99	120	java/lang/Exception
    //   18	27	124	java/lang/OutOfMemoryError
    //   18	27	132	java/lang/Exception
    //   6	15	140	finally
    //   6	15	149	java/lang/OutOfMemoryError
    //   6	15	153	java/lang/Exception
    //   18	27	182	finally
    //   167	171	182	finally
  }
  
  private static void readStringFromInputStreamFinally(ByteArrayOutputStream paramByteArrayOutputStream, InputStream paramInputStream, BufferedInputStream paramBufferedInputStream)
  {
    if (paramByteArrayOutputStream != null) {
      try
      {
        paramByteArrayOutputStream.close();
      }
      catch (IOException paramByteArrayOutputStream)
      {
        paramByteArrayOutputStream.printStackTrace();
      }
    }
    if (paramBufferedInputStream != null) {
      try
      {
        paramBufferedInputStream.close();
      }
      catch (IOException paramByteArrayOutputStream)
      {
        paramByteArrayOutputStream.printStackTrace();
      }
    }
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramByteArrayOutputStream)
      {
        paramByteArrayOutputStream.printStackTrace();
      }
    }
  }
  
  private static boolean safetyCloseStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return true;
    }
    catch (IOException paramCloseable)
    {
      label12:
      break label12;
    }
    return false;
  }
  
  /* Error */
  public static boolean unzip(InputStream paramInputStream, File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 271	java/util/zip/ZipInputStream
    //   8: dup
    //   9: new 230	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 231	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: invokespecial 272	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 276	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +72 -> 99
    //   30: aload_3
    //   31: invokevirtual 281	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   34: ldc_w 283
    //   37: invokevirtual 287	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   40: ifeq +6 -> 46
    //   43: goto -22 -> 21
    //   46: aload_3
    //   47: invokevirtual 288	java/util/zip/ZipEntry:isDirectory	()Z
    //   50: ifne +30 -> 80
    //   53: aload_2
    //   54: ifnull +17 -> 71
    //   57: aload_2
    //   58: aload_3
    //   59: invokevirtual 281	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   62: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifne +6 -> 71
    //   68: goto -47 -> 21
    //   71: aload_3
    //   72: aload_1
    //   73: aload_0
    //   74: invokestatic 292	com/tencent/tkd/comment/util/FileUtil:upZipInner	(Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/util/zip/ZipInputStream;)V
    //   77: goto -56 -> 21
    //   80: new 33	java/io/File
    //   83: dup
    //   84: aload_1
    //   85: aload_3
    //   86: invokevirtual 281	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   89: invokespecial 82	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   92: invokevirtual 85	java/io/File:mkdirs	()Z
    //   95: pop
    //   96: goto -75 -> 21
    //   99: aload_0
    //   100: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   103: iconst_1
    //   104: ireturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_1
    //   113: goto +41 -> 154
    //   116: astore_1
    //   117: goto +13 -> 130
    //   120: astore_1
    //   121: aload_3
    //   122: astore_0
    //   123: goto +31 -> 154
    //   126: astore_1
    //   127: aload 4
    //   129: astore_0
    //   130: aload_0
    //   131: astore_3
    //   132: aload_1
    //   133: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   136: aload_0
    //   137: ifnull +15 -> 152
    //   140: aload_0
    //   141: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   144: goto +8 -> 152
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: aload_0
    //   155: ifnull +15 -> 170
    //   158: aload_0
    //   159: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   162: goto +8 -> 170
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   170: goto +5 -> 175
    //   173: aload_1
    //   174: athrow
    //   175: goto -2 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramInputStream	InputStream
    //   0	178	1	paramFile	File
    //   0	178	2	paramString	String
    //   4	128	3	localObject1	Object
    //   1	127	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   99	103	105	java/io/IOException
    //   21	26	112	finally
    //   30	43	112	finally
    //   46	53	112	finally
    //   57	68	112	finally
    //   71	77	112	finally
    //   80	96	112	finally
    //   21	26	116	java/lang/Throwable
    //   30	43	116	java/lang/Throwable
    //   46	53	116	java/lang/Throwable
    //   57	68	116	java/lang/Throwable
    //   71	77	116	java/lang/Throwable
    //   80	96	116	java/lang/Throwable
    //   5	21	120	finally
    //   132	136	120	finally
    //   5	21	126	java/lang/Throwable
    //   140	144	147	java/io/IOException
    //   158	162	165	java/io/IOException
  }
  
  /* Error */
  private static void upZipInner(java.util.zip.ZipEntry paramZipEntry, File paramFile, java.util.zip.ZipInputStream paramZipInputStream)
  {
    // Byte code:
    //   0: new 33	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: aload_0
    //   6: invokevirtual 281	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   9: invokespecial 82	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokevirtual 296	java/io/File:getParentFile	()Ljava/io/File;
    //   17: invokevirtual 85	java/io/File:mkdirs	()Z
    //   20: pop
    //   21: new 298	java/io/FileOutputStream
    //   24: dup
    //   25: aload_0
    //   26: iconst_0
    //   27: invokespecial 301	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   30: astore_0
    //   31: ldc_w 302
    //   34: newarray byte
    //   36: astore_1
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 303	java/util/zip/ZipInputStream:read	([B)I
    //   42: istore_3
    //   43: iload_3
    //   44: iconst_m1
    //   45: if_icmpeq +13 -> 58
    //   48: aload_0
    //   49: aload_1
    //   50: iconst_0
    //   51: iload_3
    //   52: invokevirtual 304	java/io/FileOutputStream:write	([BII)V
    //   55: goto -18 -> 37
    //   58: aload_0
    //   59: invokevirtual 305	java/io/FileOutputStream:close	()V
    //   62: return
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   68: return
    //   69: astore_1
    //   70: goto +13 -> 83
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   78: aload_0
    //   79: invokevirtual 305	java/io/FileOutputStream:close	()V
    //   82: return
    //   83: aload_0
    //   84: invokevirtual 305	java/io/FileOutputStream:close	()V
    //   87: goto +8 -> 95
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   95: goto +5 -> 100
    //   98: aload_1
    //   99: athrow
    //   100: goto -2 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramZipEntry	java.util.zip.ZipEntry
    //   0	103	1	paramFile	File
    //   0	103	2	paramZipInputStream	java.util.zip.ZipInputStream
    //   42	10	3	i	int
    // Exception table:
    //   from	to	target	type
    //   58	62	63	java/lang/Exception
    //   78	82	63	java/lang/Exception
    //   37	43	69	finally
    //   48	55	69	finally
    //   74	78	69	finally
    //   37	43	73	java/io/IOException
    //   48	55	73	java/io/IOException
    //   83	87	90	java/lang/Exception
  }
  
  /* Error */
  public static boolean writeObject(File paramFile, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   12: invokestatic 172	com/tencent/tkd/comment/util/FileUtil:getFileLock	(Ljava/lang/String;)Ljava/util/concurrent/locks/ReadWriteLock;
    //   15: invokeinterface 311 1 0
    //   20: astore 9
    //   22: aload 9
    //   24: invokeinterface 181 1 0
    //   29: aconst_null
    //   30: astore 8
    //   32: aconst_null
    //   33: astore 7
    //   35: aload_0
    //   36: invokevirtual 37	java/io/File:exists	()Z
    //   39: ifne +40 -> 79
    //   42: aload_0
    //   43: invokevirtual 314	java/io/File:createNewFile	()Z
    //   46: istore_2
    //   47: iload_2
    //   48: ifne +31 -> 79
    //   51: aconst_null
    //   52: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   55: ifeq +15 -> 70
    //   58: aconst_null
    //   59: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   62: ifeq +8 -> 70
    //   65: aconst_null
    //   66: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   69: pop
    //   70: aload 9
    //   72: invokeinterface 222 1 0
    //   77: iconst_0
    //   78: ireturn
    //   79: new 233	java/io/ByteArrayOutputStream
    //   82: dup
    //   83: sipush 4096
    //   86: invokespecial 317	java/io/ByteArrayOutputStream:<init>	(I)V
    //   89: astore 6
    //   91: new 319	java/io/ObjectOutputStream
    //   94: dup
    //   95: aload 6
    //   97: invokespecial 322	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   100: astore 5
    //   102: aload 5
    //   104: aload_1
    //   105: invokevirtual 325	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   108: aload 5
    //   110: invokevirtual 328	java/io/ObjectOutputStream:flush	()V
    //   113: new 298	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 329	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore 7
    //   123: aload 6
    //   125: aload 7
    //   127: invokevirtual 332	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   130: aload 6
    //   132: invokevirtual 333	java/io/ByteArrayOutputStream:flush	()V
    //   135: iload_3
    //   136: istore_2
    //   137: aload 5
    //   139: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   142: ifeq +141 -> 283
    //   145: iload_3
    //   146: istore_2
    //   147: aload 6
    //   149: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   152: ifeq +131 -> 283
    //   155: aload 7
    //   157: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   160: istore 4
    //   162: iload_3
    //   163: istore_2
    //   164: iload 4
    //   166: ifeq +117 -> 283
    //   169: iconst_1
    //   170: istore_2
    //   171: goto +112 -> 283
    //   174: astore_0
    //   175: aload 7
    //   177: astore_1
    //   178: goto +13 -> 191
    //   181: astore_1
    //   182: aload 7
    //   184: astore_0
    //   185: goto +12 -> 197
    //   188: astore_0
    //   189: aconst_null
    //   190: astore_1
    //   191: goto +108 -> 299
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_0
    //   197: goto +46 -> 243
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_1
    //   203: aload 8
    //   205: astore 5
    //   207: goto +92 -> 299
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_0
    //   213: aload 7
    //   215: astore 5
    //   217: goto +26 -> 243
    //   220: astore_0
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: astore 6
    //   226: aload 8
    //   228: astore 5
    //   230: goto +69 -> 299
    //   233: astore_1
    //   234: aconst_null
    //   235: astore_0
    //   236: aload_0
    //   237: astore 6
    //   239: aload 7
    //   241: astore 5
    //   243: aload_1
    //   244: invokevirtual 106	java/lang/Throwable:printStackTrace	()V
    //   247: iload_3
    //   248: istore_2
    //   249: aload 5
    //   251: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   254: ifeq +29 -> 283
    //   257: iload_3
    //   258: istore_2
    //   259: aload 6
    //   261: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   264: ifeq +19 -> 283
    //   267: aload_0
    //   268: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   271: istore 4
    //   273: iload_3
    //   274: istore_2
    //   275: iload 4
    //   277: ifeq +6 -> 283
    //   280: goto -111 -> 169
    //   283: aload 9
    //   285: invokeinterface 222 1 0
    //   290: iload_2
    //   291: ireturn
    //   292: astore 7
    //   294: aload_0
    //   295: astore_1
    //   296: aload 7
    //   298: astore_0
    //   299: aload 5
    //   301: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   304: ifeq +16 -> 320
    //   307: aload 6
    //   309: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   312: ifeq +8 -> 320
    //   315: aload_1
    //   316: invokestatic 219	com/tencent/tkd/comment/util/FileUtil:safetyCloseStream	(Ljava/io/Closeable;)Z
    //   319: pop
    //   320: aload_0
    //   321: athrow
    //   322: astore_0
    //   323: aload 9
    //   325: invokeinterface 222 1 0
    //   330: goto +5 -> 335
    //   333: aload_0
    //   334: athrow
    //   335: goto -2 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramFile	File
    //   0	338	1	paramObject	Object
    //   46	245	2	bool1	boolean
    //   1	273	3	bool2	boolean
    //   160	116	4	bool3	boolean
    //   100	200	5	localObject1	Object
    //   89	219	6	localObject2	Object
    //   33	207	7	localFileOutputStream	java.io.FileOutputStream
    //   292	5	7	localObject3	Object
    //   30	197	8	localObject4	Object
    //   20	304	9	localLock	java.util.concurrent.locks.Lock
    // Exception table:
    //   from	to	target	type
    //   123	135	174	finally
    //   123	135	181	java/lang/Throwable
    //   102	123	188	finally
    //   102	123	194	java/lang/Throwable
    //   91	102	200	finally
    //   91	102	210	java/lang/Throwable
    //   35	47	220	finally
    //   79	91	220	finally
    //   35	47	233	java/lang/Throwable
    //   79	91	233	java/lang/Throwable
    //   243	247	292	finally
    //   22	29	322	finally
    //   51	70	322	finally
    //   137	145	322	finally
    //   147	162	322	finally
    //   249	257	322	finally
    //   259	273	322	finally
    //   299	320	322	finally
    //   320	322	322	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */