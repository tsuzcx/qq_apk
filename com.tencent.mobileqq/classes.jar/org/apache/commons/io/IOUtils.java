package org.apache.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.output.ByteArrayOutputStream;

public class IOUtils
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final char DIR_SEPARATOR;
  public static final char DIR_SEPARATOR_UNIX = '/';
  public static final char DIR_SEPARATOR_WINDOWS = '\\';
  public static final int EOF = -1;
  public static final String LINE_SEPARATOR;
  public static final String LINE_SEPARATOR_UNIX = "\n";
  public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
  private static final int SKIP_BUFFER_SIZE = 2048;
  private static byte[] SKIP_BYTE_BUFFER;
  private static char[] SKIP_CHAR_BUFFER;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 38	java/io/File:separatorChar	C
    //   5: putstatic 40	org/apache/commons/io/IOUtils:DIR_SEPARATOR	C
    //   8: new 42	org/apache/commons/io/output/StringBuilderWriter
    //   11: dup
    //   12: iconst_4
    //   13: invokespecial 46	org/apache/commons/io/output/StringBuilderWriter:<init>	(I)V
    //   16: astore_3
    //   17: new 48	java/io/PrintWriter
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 51	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 54	java/io/PrintWriter:println	()V
    //   32: aload_3
    //   33: invokevirtual 58	org/apache/commons/io/output/StringBuilderWriter:toString	()Ljava/lang/String;
    //   36: putstatic 60	org/apache/commons/io/IOUtils:LINE_SEPARATOR	Ljava/lang/String;
    //   39: aload 4
    //   41: ifnull +12 -> 53
    //   44: iconst_0
    //   45: ifeq +48 -> 93
    //   48: aload 4
    //   50: invokevirtual 63	java/io/PrintWriter:close	()V
    //   53: aload_3
    //   54: ifnull +11 -> 65
    //   57: iconst_0
    //   58: ifeq +97 -> 155
    //   61: aload_3
    //   62: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   65: return
    //   66: astore_0
    //   67: new 66	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: astore_0
    //   76: aload_0
    //   77: athrow
    //   78: astore_1
    //   79: aload_3
    //   80: ifnull +11 -> 91
    //   83: aload_0
    //   84: ifnull +85 -> 169
    //   87: aload_3
    //   88: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   91: aload_1
    //   92: athrow
    //   93: aload 4
    //   95: invokevirtual 63	java/io/PrintWriter:close	()V
    //   98: goto -45 -> 53
    //   101: astore_1
    //   102: aload_2
    //   103: astore_0
    //   104: goto -25 -> 79
    //   107: astore_0
    //   108: aload_0
    //   109: athrow
    //   110: astore_1
    //   111: aload 4
    //   113: ifnull +12 -> 125
    //   116: aload_0
    //   117: ifnull +21 -> 138
    //   120: aload 4
    //   122: invokevirtual 63	java/io/PrintWriter:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore 4
    //   129: aload_0
    //   130: aload 4
    //   132: invokevirtual 72	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   135: goto -10 -> 125
    //   138: aload 4
    //   140: invokevirtual 63	java/io/PrintWriter:close	()V
    //   143: goto -18 -> 125
    //   146: astore_0
    //   147: new 66	java/lang/NullPointerException
    //   150: dup
    //   151: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   154: athrow
    //   155: aload_3
    //   156: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   159: return
    //   160: astore_2
    //   161: aload_0
    //   162: aload_2
    //   163: invokevirtual 72	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   166: goto -75 -> 91
    //   169: aload_3
    //   170: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   173: goto -82 -> 91
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_0
    //   179: goto -68 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	1	0	localThrowable1	Throwable
    //   75	9	0	localThrowable2	Throwable
    //   103	1	0	localObject1	Object
    //   107	23	0	localThrowable3	Throwable
    //   146	16	0	localThrowable4	Throwable
    //   178	1	0	localObject2	Object
    //   78	14	1	localObject3	Object
    //   101	1	1	localObject4	Object
    //   110	16	1	localObject5	Object
    //   176	1	1	localObject6	Object
    //   1	102	2	localObject7	Object
    //   160	3	2	localThrowable5	Throwable
    //   16	154	3	localStringBuilderWriter	org.apache.commons.io.output.StringBuilderWriter
    //   25	96	4	localPrintWriter	java.io.PrintWriter
    //   127	12	4	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   48	53	66	java/lang/Throwable
    //   17	27	75	java/lang/Throwable
    //   67	75	75	java/lang/Throwable
    //   93	98	75	java/lang/Throwable
    //   125	127	75	java/lang/Throwable
    //   129	135	75	java/lang/Throwable
    //   138	143	75	java/lang/Throwable
    //   76	78	78	finally
    //   17	27	101	finally
    //   48	53	101	finally
    //   67	75	101	finally
    //   93	98	101	finally
    //   120	125	101	finally
    //   125	127	101	finally
    //   129	135	101	finally
    //   138	143	101	finally
    //   27	39	107	java/lang/Throwable
    //   108	110	110	finally
    //   120	125	127	java/lang/Throwable
    //   61	65	146	java/lang/Throwable
    //   87	91	160	java/lang/Throwable
    //   27	39	176	finally
  }
  
  public static BufferedInputStream buffer(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    if ((paramInputStream instanceof BufferedInputStream)) {
      return (BufferedInputStream)paramInputStream;
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  public static BufferedInputStream buffer(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    if ((paramInputStream instanceof BufferedInputStream)) {
      return (BufferedInputStream)paramInputStream;
    }
    return new BufferedInputStream(paramInputStream, paramInt);
  }
  
  public static BufferedOutputStream buffer(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new NullPointerException();
    }
    if ((paramOutputStream instanceof BufferedOutputStream)) {
      return (BufferedOutputStream)paramOutputStream;
    }
    return new BufferedOutputStream(paramOutputStream);
  }
  
  public static BufferedOutputStream buffer(OutputStream paramOutputStream, int paramInt)
  {
    if (paramOutputStream == null) {
      throw new NullPointerException();
    }
    if ((paramOutputStream instanceof BufferedOutputStream)) {
      return (BufferedOutputStream)paramOutputStream;
    }
    return new BufferedOutputStream(paramOutputStream, paramInt);
  }
  
  public static BufferedReader buffer(Reader paramReader)
  {
    if ((paramReader instanceof BufferedReader)) {
      return (BufferedReader)paramReader;
    }
    return new BufferedReader(paramReader);
  }
  
  public static BufferedReader buffer(Reader paramReader, int paramInt)
  {
    if ((paramReader instanceof BufferedReader)) {
      return (BufferedReader)paramReader;
    }
    return new BufferedReader(paramReader, paramInt);
  }
  
  public static BufferedWriter buffer(Writer paramWriter)
  {
    if ((paramWriter instanceof BufferedWriter)) {
      return (BufferedWriter)paramWriter;
    }
    return new BufferedWriter(paramWriter);
  }
  
  public static BufferedWriter buffer(Writer paramWriter, int paramInt)
  {
    if ((paramWriter instanceof BufferedWriter)) {
      return (BufferedWriter)paramWriter;
    }
    return new BufferedWriter(paramWriter, paramInt);
  }
  
  public static void close(URLConnection paramURLConnection)
  {
    if ((paramURLConnection instanceof HttpURLConnection)) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
  }
  
  @Deprecated
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  @Deprecated
  public static void closeQuietly(InputStream paramInputStream)
  {
    closeQuietly(paramInputStream);
  }
  
  @Deprecated
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    closeQuietly(paramOutputStream);
  }
  
  @Deprecated
  public static void closeQuietly(Reader paramReader)
  {
    closeQuietly(paramReader);
  }
  
  @Deprecated
  public static void closeQuietly(Writer paramWriter)
  {
    closeQuietly(paramWriter);
  }
  
  @Deprecated
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (IOException paramServerSocket) {}
  }
  
  @Deprecated
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (IOException paramSocket) {}
  }
  
  @Deprecated
  public static void closeQuietly(Selector paramSelector)
  {
    if (paramSelector != null) {}
    try
    {
      paramSelector.close();
      return;
    }
    catch (IOException paramSelector) {}
  }
  
  @Deprecated
  public static void closeQuietly(Closeable... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        closeQuietly(paramVarArgs[i]);
        i += 1;
      }
    }
  }
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    if (paramInputStream1 == paramInputStream2) {
      return true;
    }
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    for (int i = ((InputStream)localObject).read(); -1 != i; i = ((InputStream)localObject).read()) {
      if (i != paramInputStream1.read()) {
        return false;
      }
    }
    if (paramInputStream1.read() == -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean contentEquals(Reader paramReader1, Reader paramReader2)
  {
    if (paramReader1 == paramReader2) {}
    do
    {
      return true;
      paramReader1 = toBufferedReader(paramReader1);
      paramReader2 = toBufferedReader(paramReader2);
      for (int i = paramReader1.read(); -1 != i; i = paramReader1.read()) {
        if (i != paramReader2.read()) {
          return false;
        }
      }
    } while (paramReader2.read() == -1);
    return false;
  }
  
  public static boolean contentEqualsIgnoreEOL(Reader paramReader1, Reader paramReader2)
  {
    if (paramReader1 == paramReader2) {}
    do
    {
      return true;
      BufferedReader localBufferedReader1 = toBufferedReader(paramReader1);
      BufferedReader localBufferedReader2 = toBufferedReader(paramReader2);
      paramReader2 = localBufferedReader1.readLine();
      for (paramReader1 = localBufferedReader2.readLine(); (paramReader2 != null) && (paramReader1 != null) && (paramReader2.equals(paramReader1)); paramReader1 = localBufferedReader2.readLine()) {
        paramReader2 = localBufferedReader1.readLine();
      }
      if (paramReader2 != null) {
        break;
      }
    } while (paramReader1 == null);
    return false;
    return paramReader2.equals(paramReader1);
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static int copy(Reader paramReader, Writer paramWriter)
  {
    long l = copyLarge(paramReader, paramWriter);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
  {
    return copyLarge(paramInputStream, paramOutputStream, new byte[paramInt]);
  }
  
  @Deprecated
  public static void copy(InputStream paramInputStream, Writer paramWriter)
  {
    copy(paramInputStream, paramWriter, Charset.defaultCharset());
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString)
  {
    copy(paramInputStream, paramWriter, Charsets.toCharset(paramString));
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter, Charset paramCharset)
  {
    copy(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)), paramWriter);
  }
  
  @Deprecated
  public static void copy(Reader paramReader, OutputStream paramOutputStream)
  {
    copy(paramReader, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString)
  {
    copy(paramReader, paramOutputStream, Charsets.toCharset(paramString));
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream, Charset paramCharset)
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream, Charsets.toCharset(paramCharset));
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    return copy(paramInputStream, paramOutputStream, 4096);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2)
  {
    return copyLarge(paramInputStream, paramOutputStream, paramLong1, paramLong2, new byte[4096]);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (paramLong1 > 0L) {
      skipFully(paramInputStream, paramLong1);
    }
    if (paramLong2 == 0L) {
      return 0L;
    }
    int j = paramArrayOfByte.length;
    if ((paramLong2 > 0L) && (paramLong2 < j)) {}
    for (int i = (int)paramLong2;; i = j)
    {
      paramLong1 = 0L;
      while (i > 0)
      {
        int k = paramInputStream.read(paramArrayOfByte, 0, i);
        if (-1 == k) {
          break;
        }
        paramOutputStream.write(paramArrayOfByte, 0, k);
        long l = paramLong1 + k;
        paramLong1 = l;
        if (paramLong2 > 0L)
        {
          i = (int)Math.min(paramLong2 - l, j);
          paramLong1 = l;
        }
      }
      return paramLong1;
    }
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
    return l;
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter)
  {
    return copyLarge(paramReader, paramWriter, new char[4096]);
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2)
  {
    return copyLarge(paramReader, paramWriter, paramLong1, paramLong2, new char[4096]);
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2, char[] paramArrayOfChar)
  {
    if (paramLong1 > 0L) {
      skipFully(paramReader, paramLong1);
    }
    long l;
    if (paramLong2 == 0L)
    {
      l = 0L;
      return l;
    }
    int j = paramArrayOfChar.length;
    int i = j;
    if (paramLong2 > 0L)
    {
      i = j;
      if (paramLong2 < paramArrayOfChar.length) {
        i = (int)paramLong2;
      }
    }
    paramLong1 = 0L;
    for (;;)
    {
      l = paramLong1;
      if (i <= 0) {
        break;
      }
      j = paramReader.read(paramArrayOfChar, 0, i);
      l = paramLong1;
      if (-1 == j) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, j);
      l = paramLong1 + j;
      paramLong1 = l;
      if (paramLong2 > 0L)
      {
        i = (int)Math.min(paramLong2 - l, paramArrayOfChar.length);
        paramLong1 = l;
      }
    }
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter, char[] paramArrayOfChar)
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramReader.read(paramArrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, i);
    }
    return l;
  }
  
  public static LineIterator lineIterator(InputStream paramInputStream, String paramString)
  {
    return lineIterator(paramInputStream, Charsets.toCharset(paramString));
  }
  
  public static LineIterator lineIterator(InputStream paramInputStream, Charset paramCharset)
  {
    return new LineIterator(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)));
  }
  
  public static LineIterator lineIterator(Reader paramReader)
  {
    return new LineIterator(paramReader);
  }
  
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    return read(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
    }
    int i = paramInt2;
    for (;;)
    {
      int j;
      if (i > 0)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt2 - i + paramInt1, i);
        if (-1 != j) {}
      }
      else
      {
        return paramInt2 - i;
      }
      i -= j;
    }
  }
  
  public static int read(Reader paramReader, char[] paramArrayOfChar)
  {
    return read(paramReader, paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static int read(Reader paramReader, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
    }
    int i = paramInt2;
    for (;;)
    {
      int j;
      if (i > 0)
      {
        j = paramReader.read(paramArrayOfChar, paramInt2 - i + paramInt1, i);
        if (-1 != j) {}
      }
      else
      {
        return paramInt2 - i;
      }
      i -= j;
    }
  }
  
  public static int read(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    while ((paramByteBuffer.remaining() > 0) && (-1 != paramReadableByteChannel.read(paramByteBuffer))) {}
    return i - paramByteBuffer.remaining();
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = read(paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != paramInt2) {
      throw new EOFException("Length to read: " + paramInt2 + " actual: " + paramInt1);
    }
  }
  
  public static void readFully(Reader paramReader, char[] paramArrayOfChar)
  {
    readFully(paramReader, paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static void readFully(Reader paramReader, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt1 = read(paramReader, paramArrayOfChar, paramInt1, paramInt2);
    if (paramInt1 != paramInt2) {
      throw new EOFException("Length to read: " + paramInt2 + " actual: " + paramInt1);
    }
  }
  
  public static void readFully(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    int j = read(paramReadableByteChannel, paramByteBuffer);
    if (j != i) {
      throw new EOFException("Length to read: " + i + " actual: " + j);
    }
  }
  
  public static byte[] readFully(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    readFully(paramInputStream, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  @Deprecated
  public static List<String> readLines(InputStream paramInputStream)
  {
    return readLines(paramInputStream, Charset.defaultCharset());
  }
  
  public static List<String> readLines(InputStream paramInputStream, String paramString)
  {
    return readLines(paramInputStream, Charsets.toCharset(paramString));
  }
  
  public static List<String> readLines(InputStream paramInputStream, Charset paramCharset)
  {
    return readLines(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)));
  }
  
  public static List<String> readLines(Reader paramReader)
  {
    BufferedReader localBufferedReader = toBufferedReader(paramReader);
    ArrayList localArrayList = new ArrayList();
    for (paramReader = localBufferedReader.readLine(); paramReader != null; paramReader = localBufferedReader.readLine()) {
      localArrayList.add(paramReader);
    }
    return localArrayList;
  }
  
  public static byte[] resourceToByteArray(String paramString)
  {
    return resourceToByteArray(paramString, null);
  }
  
  public static byte[] resourceToByteArray(String paramString, ClassLoader paramClassLoader)
  {
    return toByteArray(resourceToURL(paramString, paramClassLoader));
  }
  
  public static String resourceToString(String paramString, Charset paramCharset)
  {
    return resourceToString(paramString, paramCharset, null);
  }
  
  public static String resourceToString(String paramString, Charset paramCharset, ClassLoader paramClassLoader)
  {
    return toString(resourceToURL(paramString, paramClassLoader), paramCharset);
  }
  
  public static URL resourceToURL(String paramString)
  {
    return resourceToURL(paramString, null);
  }
  
  public static URL resourceToURL(String paramString, ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null) {}
    for (paramClassLoader = IOUtils.class.getResource(paramString); paramClassLoader == null; paramClassLoader = paramClassLoader.getResource(paramString)) {
      throw new IOException("Resource not found: " + paramString);
    }
    return paramClassLoader;
  }
  
  public static long skip(InputStream paramInputStream, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
    }
    if (SKIP_BYTE_BUFFER == null) {
      SKIP_BYTE_BUFFER = new byte[2048];
    }
    long l2;
    for (long l1 = paramLong;; l1 -= l2) {
      if (l1 > 0L)
      {
        l2 = paramInputStream.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l1, 2048L));
        if (l2 >= 0L) {}
      }
      else
      {
        return paramLong - l1;
      }
    }
  }
  
  public static long skip(Reader paramReader, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
    }
    if (SKIP_CHAR_BUFFER == null) {
      SKIP_CHAR_BUFFER = new char[2048];
    }
    long l2;
    for (long l1 = paramLong;; l1 -= l2) {
      if (l1 > 0L)
      {
        l2 = paramReader.read(SKIP_CHAR_BUFFER, 0, (int)Math.min(l1, 2048L));
        if (l2 >= 0L) {}
      }
      else
      {
        return paramLong - l1;
      }
    }
  }
  
  public static long skip(ReadableByteChannel paramReadableByteChannel, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate((int)Math.min(paramLong, 2048L));
    int i;
    for (long l = paramLong;; l -= i) {
      if (l > 0L)
      {
        localByteBuffer.position(0);
        localByteBuffer.limit((int)Math.min(l, 2048L));
        i = paramReadableByteChannel.read(localByteBuffer);
        if (i != -1) {}
      }
      else
      {
        return paramLong - l;
      }
    }
  }
  
  public static void skipFully(InputStream paramInputStream, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
    }
    long l = skip(paramInputStream, paramLong);
    if (l != paramLong) {
      throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
    }
  }
  
  public static void skipFully(Reader paramReader, long paramLong)
  {
    long l = skip(paramReader, paramLong);
    if (l != paramLong) {
      throw new EOFException("Chars to skip: " + paramLong + " actual: " + l);
    }
  }
  
  public static void skipFully(ReadableByteChannel paramReadableByteChannel, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
    }
    long l = skip(paramReadableByteChannel, paramLong);
    if (l != paramLong) {
      throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
    }
  }
  
  public static InputStream toBufferedInputStream(InputStream paramInputStream)
  {
    return ByteArrayOutputStream.toBufferedInputStream(paramInputStream);
  }
  
  public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt)
  {
    return ByteArrayOutputStream.toBufferedInputStream(paramInputStream, paramInt);
  }
  
  public static BufferedReader toBufferedReader(Reader paramReader)
  {
    if ((paramReader instanceof BufferedReader)) {
      return (BufferedReader)paramReader;
    }
    return new BufferedReader(paramReader);
  }
  
  public static BufferedReader toBufferedReader(Reader paramReader, int paramInt)
  {
    if ((paramReader instanceof BufferedReader)) {
      return (BufferedReader)paramReader;
    }
    return new BufferedReader(paramReader, paramInt);
  }
  
  /* Error */
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 437	org/apache/commons/io/output/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 444	org/apache/commons/io/output/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: aload_3
    //   12: invokestatic 446	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   15: pop
    //   16: aload_3
    //   17: invokevirtual 449	org/apache/commons/io/output/ByteArrayOutputStream:toByteArray	()[B
    //   20: astore_0
    //   21: aload_3
    //   22: ifnull +11 -> 33
    //   25: iconst_0
    //   26: ifeq +18 -> 44
    //   29: aload_3
    //   30: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: new 66	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: aload_3
    //   45: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: athrow
    //   53: astore_1
    //   54: aload_3
    //   55: ifnull +11 -> 66
    //   58: aload_0
    //   59: ifnull +18 -> 77
    //   62: aload_3
    //   63: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   66: aload_1
    //   67: athrow
    //   68: astore_2
    //   69: aload_0
    //   70: aload_2
    //   71: invokevirtual 72	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   74: goto -8 -> 66
    //   77: aload_3
    //   78: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   81: goto -15 -> 66
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: goto -33 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramInputStream	InputStream
    //   53	14	1	localObject1	Object
    //   84	1	1	localObject2	Object
    //   9	1	2	localObject3	Object
    //   68	18	2	localThrowable	Throwable
    //   7	71	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/lang/Throwable
    //   10	21	50	java/lang/Throwable
    //   51	53	53	finally
    //   62	66	68	java/lang/Throwable
    //   10	21	84	finally
  }
  
  public static byte[] toByteArray(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    if (paramInt < 0) {
      throw new IllegalArgumentException("Size must be equal or greater than zero: " + paramInt);
    }
    if (paramInt == 0) {
      paramInputStream = new byte[0];
    }
    do
    {
      return paramInputStream;
      byte[] arrayOfByte = new byte[paramInt];
      while (i < paramInt)
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j == -1) {
          break;
        }
        i += j;
      }
      paramInputStream = arrayOfByte;
    } while (i == paramInt);
    throw new IOException("Unexpected read size. current: " + i + ", expected: " + paramInt);
  }
  
  public static byte[] toByteArray(InputStream paramInputStream, long paramLong)
  {
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + paramLong);
    }
    return toByteArray(paramInputStream, (int)paramLong);
  }
  
  @Deprecated
  public static byte[] toByteArray(Reader paramReader)
  {
    return toByteArray(paramReader, Charset.defaultCharset());
  }
  
  public static byte[] toByteArray(Reader paramReader, String paramString)
  {
    return toByteArray(paramReader, Charsets.toCharset(paramString));
  }
  
  /* Error */
  public static byte[] toByteArray(Reader paramReader, Charset paramCharset)
  {
    // Byte code:
    //   0: new 437	org/apache/commons/io/output/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 444	org/apache/commons/io/output/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: aload_3
    //   12: aload_1
    //   13: invokestatic 215	org/apache/commons/io/IOUtils:copy	(Ljava/io/Reader;Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   16: aload_3
    //   17: invokevirtual 449	org/apache/commons/io/output/ByteArrayOutputStream:toByteArray	()[B
    //   20: astore_0
    //   21: aload_3
    //   22: ifnull +11 -> 33
    //   25: iconst_0
    //   26: ifeq +18 -> 44
    //   29: aload_3
    //   30: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: new 66	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: aload_3
    //   45: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: astore_1
    //   51: aload_1
    //   52: athrow
    //   53: astore_0
    //   54: aload_3
    //   55: ifnull +11 -> 66
    //   58: aload_1
    //   59: ifnull +18 -> 77
    //   62: aload_3
    //   63: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   66: aload_0
    //   67: athrow
    //   68: astore_2
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 72	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   74: goto -8 -> 66
    //   77: aload_3
    //   78: invokevirtual 450	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   81: goto -15 -> 66
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: goto -33 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramReader	Reader
    //   0	90	1	paramCharset	Charset
    //   9	1	2	localObject	Object
    //   68	18	2	localThrowable	Throwable
    //   7	71	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/lang/Throwable
    //   10	21	50	java/lang/Throwable
    //   51	53	53	finally
    //   62	66	68	java/lang/Throwable
    //   10	21	84	finally
  }
  
  @Deprecated
  public static byte[] toByteArray(String paramString)
  {
    return paramString.getBytes(Charset.defaultCharset());
  }
  
  public static byte[] toByteArray(URI paramURI)
  {
    return toByteArray(paramURI.toURL());
  }
  
  public static byte[] toByteArray(URL paramURL)
  {
    paramURL = paramURL.openConnection();
    try
    {
      byte[] arrayOfByte = toByteArray(paramURL);
      return arrayOfByte;
    }
    finally
    {
      close(paramURL);
    }
  }
  
  public static byte[] toByteArray(URLConnection paramURLConnection)
  {
    InputStream localInputStream = paramURLConnection.getInputStream();
    paramURLConnection = null;
    try
    {
      byte[] arrayOfByte = toByteArray(localInputStream);
      if ((localInputStream == null) || (0 != 0)) {
        try
        {
          localInputStream.close();
          return arrayOfByte;
        }
        catch (Throwable paramURLConnection)
        {
          throw new NullPointerException();
        }
      }
      localInputStream.close();
      return arrayOfByte;
    }
    catch (Throwable localThrowable1)
    {
      paramURLConnection = localThrowable1;
      throw localThrowable1;
    }
    finally
    {
      if (localInputStream != null) {
        if (paramURLConnection == null) {
          break label70;
        }
      }
    }
    for (;;)
    {
      try
      {
        localInputStream.close();
        throw localObject;
      }
      catch (Throwable localThrowable2)
      {
        paramURLConnection.addSuppressed(localThrowable2);
        continue;
      }
      label70:
      localThrowable2.close();
    }
  }
  
  @Deprecated
  public static char[] toCharArray(InputStream paramInputStream)
  {
    return toCharArray(paramInputStream, Charset.defaultCharset());
  }
  
  public static char[] toCharArray(InputStream paramInputStream, String paramString)
  {
    return toCharArray(paramInputStream, Charsets.toCharset(paramString));
  }
  
  public static char[] toCharArray(InputStream paramInputStream, Charset paramCharset)
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramInputStream, localCharArrayWriter, paramCharset);
    return localCharArrayWriter.toCharArray();
  }
  
  public static char[] toCharArray(Reader paramReader)
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramReader, localCharArrayWriter);
    return localCharArrayWriter.toCharArray();
  }
  
  @Deprecated
  public static InputStream toInputStream(CharSequence paramCharSequence)
  {
    return toInputStream(paramCharSequence, Charset.defaultCharset());
  }
  
  public static InputStream toInputStream(CharSequence paramCharSequence, String paramString)
  {
    return toInputStream(paramCharSequence, Charsets.toCharset(paramString));
  }
  
  public static InputStream toInputStream(CharSequence paramCharSequence, Charset paramCharset)
  {
    return toInputStream(paramCharSequence.toString(), paramCharset);
  }
  
  @Deprecated
  public static InputStream toInputStream(String paramString)
  {
    return toInputStream(paramString, Charset.defaultCharset());
  }
  
  public static InputStream toInputStream(String paramString1, String paramString2)
  {
    return new ByteArrayInputStream(paramString1.getBytes(Charsets.toCharset(paramString2)));
  }
  
  public static InputStream toInputStream(String paramString, Charset paramCharset)
  {
    return new ByteArrayInputStream(paramString.getBytes(Charsets.toCharset(paramCharset)));
  }
  
  @Deprecated
  public static String toString(InputStream paramInputStream)
  {
    return toString(paramInputStream, Charset.defaultCharset());
  }
  
  public static String toString(InputStream paramInputStream, String paramString)
  {
    return toString(paramInputStream, Charsets.toCharset(paramString));
  }
  
  /* Error */
  public static String toString(InputStream paramInputStream, Charset paramCharset)
  {
    // Byte code:
    //   0: new 42	org/apache/commons/io/output/StringBuilderWriter
    //   3: dup
    //   4: invokespecial 535	org/apache/commons/io/output/StringBuilderWriter:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: aload_3
    //   12: aload_1
    //   13: invokestatic 194	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/Writer;Ljava/nio/charset/Charset;)V
    //   16: aload_3
    //   17: invokevirtual 58	org/apache/commons/io/output/StringBuilderWriter:toString	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_3
    //   22: ifnull +11 -> 33
    //   25: iconst_0
    //   26: ifeq +18 -> 44
    //   29: aload_3
    //   30: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: new 66	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: aload_3
    //   45: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: astore_1
    //   51: aload_1
    //   52: athrow
    //   53: astore_0
    //   54: aload_3
    //   55: ifnull +11 -> 66
    //   58: aload_1
    //   59: ifnull +18 -> 77
    //   62: aload_3
    //   63: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   66: aload_0
    //   67: athrow
    //   68: astore_2
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 72	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   74: goto -8 -> 66
    //   77: aload_3
    //   78: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   81: goto -15 -> 66
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: goto -33 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramInputStream	InputStream
    //   0	90	1	paramCharset	Charset
    //   9	1	2	localObject	Object
    //   68	18	2	localThrowable	Throwable
    //   7	71	3	localStringBuilderWriter	org.apache.commons.io.output.StringBuilderWriter
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/lang/Throwable
    //   10	21	50	java/lang/Throwable
    //   51	53	53	finally
    //   62	66	68	java/lang/Throwable
    //   10	21	84	finally
  }
  
  /* Error */
  public static String toString(Reader paramReader)
  {
    // Byte code:
    //   0: new 42	org/apache/commons/io/output/StringBuilderWriter
    //   3: dup
    //   4: invokespecial 535	org/apache/commons/io/output/StringBuilderWriter:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: aload_3
    //   12: invokestatic 211	org/apache/commons/io/IOUtils:copy	(Ljava/io/Reader;Ljava/io/Writer;)I
    //   15: pop
    //   16: aload_3
    //   17: invokevirtual 58	org/apache/commons/io/output/StringBuilderWriter:toString	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_3
    //   22: ifnull +11 -> 33
    //   25: iconst_0
    //   26: ifeq +18 -> 44
    //   29: aload_3
    //   30: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: new 66	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: aload_3
    //   45: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: athrow
    //   53: astore_1
    //   54: aload_3
    //   55: ifnull +11 -> 66
    //   58: aload_0
    //   59: ifnull +18 -> 77
    //   62: aload_3
    //   63: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   66: aload_1
    //   67: athrow
    //   68: astore_2
    //   69: aload_0
    //   70: aload_2
    //   71: invokevirtual 72	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   74: goto -8 -> 66
    //   77: aload_3
    //   78: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   81: goto -15 -> 66
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: goto -33 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramReader	Reader
    //   53	14	1	localObject1	Object
    //   84	1	1	localObject2	Object
    //   9	1	2	localObject3	Object
    //   68	18	2	localThrowable	Throwable
    //   7	71	3	localStringBuilderWriter	org.apache.commons.io.output.StringBuilderWriter
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/lang/Throwable
    //   10	21	50	java/lang/Throwable
    //   51	53	53	finally
    //   62	66	68	java/lang/Throwable
    //   10	21	84	finally
  }
  
  @Deprecated
  public static String toString(URI paramURI)
  {
    return toString(paramURI, Charset.defaultCharset());
  }
  
  public static String toString(URI paramURI, String paramString)
  {
    return toString(paramURI, Charsets.toCharset(paramString));
  }
  
  public static String toString(URI paramURI, Charset paramCharset)
  {
    return toString(paramURI.toURL(), Charsets.toCharset(paramCharset));
  }
  
  @Deprecated
  public static String toString(URL paramURL)
  {
    return toString(paramURL, Charset.defaultCharset());
  }
  
  public static String toString(URL paramURL, String paramString)
  {
    return toString(paramURL, Charsets.toCharset(paramString));
  }
  
  public static String toString(URL paramURL, Charset paramCharset)
  {
    InputStream localInputStream = paramURL.openStream();
    paramURL = null;
    try
    {
      paramCharset = toString(localInputStream, paramCharset);
      if ((localInputStream == null) || (0 != 0)) {
        try
        {
          localInputStream.close();
          return paramCharset;
        }
        catch (Throwable paramURL)
        {
          throw new NullPointerException();
        }
      }
      localInputStream.close();
      return paramCharset;
    }
    catch (Throwable paramCharset)
    {
      paramURL = paramCharset;
      throw paramCharset;
    }
    finally
    {
      if (localInputStream != null) {
        if (paramURL == null) {
          break label71;
        }
      }
    }
    for (;;)
    {
      try
      {
        localInputStream.close();
        throw paramCharset;
      }
      catch (Throwable localThrowable)
      {
        paramURL.addSuppressed(localThrowable);
        continue;
      }
      label71:
      localThrowable.close();
    }
  }
  
  @Deprecated
  public static String toString(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, Charset.defaultCharset());
  }
  
  public static String toString(byte[] paramArrayOfByte, String paramString)
  {
    return new String(paramArrayOfByte, Charsets.toCharset(paramString));
  }
  
  @Deprecated
  public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream)
  {
    write(paramCharSequence, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, String paramString)
  {
    write(paramCharSequence, paramOutputStream, Charsets.toCharset(paramString));
  }
  
  public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, Charset paramCharset)
  {
    if (paramCharSequence != null) {
      write(paramCharSequence.toString(), paramOutputStream, paramCharset);
    }
  }
  
  public static void write(CharSequence paramCharSequence, Writer paramWriter)
  {
    if (paramCharSequence != null) {
      write(paramCharSequence.toString(), paramWriter);
    }
  }
  
  @Deprecated
  public static void write(String paramString, OutputStream paramOutputStream)
  {
    write(paramString, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void write(String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    write(paramString1, paramOutputStream, Charsets.toCharset(paramString2));
  }
  
  public static void write(String paramString, OutputStream paramOutputStream, Charset paramCharset)
  {
    if (paramString != null) {
      paramOutputStream.write(paramString.getBytes(Charsets.toCharset(paramCharset)));
    }
  }
  
  public static void write(String paramString, Writer paramWriter)
  {
    if (paramString != null) {
      paramWriter.write(paramString);
    }
  }
  
  @Deprecated
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream)
  {
    write(paramStringBuffer, paramOutputStream, (String)null);
  }
  
  @Deprecated
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream, String paramString)
  {
    if (paramStringBuffer != null) {
      paramOutputStream.write(paramStringBuffer.toString().getBytes(Charsets.toCharset(paramString)));
    }
  }
  
  @Deprecated
  public static void write(StringBuffer paramStringBuffer, Writer paramWriter)
  {
    if (paramStringBuffer != null) {
      paramWriter.write(paramStringBuffer.toString());
    }
  }
  
  public static void write(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    if (paramArrayOfByte != null) {
      paramOutputStream.write(paramArrayOfByte);
    }
  }
  
  @Deprecated
  public static void write(byte[] paramArrayOfByte, Writer paramWriter)
  {
    write(paramArrayOfByte, paramWriter, Charset.defaultCharset());
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter, String paramString)
  {
    write(paramArrayOfByte, paramWriter, Charsets.toCharset(paramString));
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter, Charset paramCharset)
  {
    if (paramArrayOfByte != null) {
      paramWriter.write(new String(paramArrayOfByte, Charsets.toCharset(paramCharset)));
    }
  }
  
  @Deprecated
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream)
  {
    write(paramArrayOfChar, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream, String paramString)
  {
    write(paramArrayOfChar, paramOutputStream, Charsets.toCharset(paramString));
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream, Charset paramCharset)
  {
    if (paramArrayOfChar != null) {
      paramOutputStream.write(new String(paramArrayOfChar).getBytes(Charsets.toCharset(paramCharset)));
    }
  }
  
  public static void write(char[] paramArrayOfChar, Writer paramWriter)
  {
    if (paramArrayOfChar != null) {
      paramWriter.write(paramArrayOfChar);
    }
  }
  
  public static void writeChunked(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    if (paramArrayOfByte != null)
    {
      int j = paramArrayOfByte.length;
      int i = 0;
      while (j > 0)
      {
        int k = Math.min(j, 4096);
        paramOutputStream.write(paramArrayOfByte, i, k);
        j -= k;
        i += k;
      }
    }
  }
  
  public static void writeChunked(char[] paramArrayOfChar, Writer paramWriter)
  {
    if (paramArrayOfChar != null)
    {
      int j = paramArrayOfChar.length;
      int i = 0;
      while (j > 0)
      {
        int k = Math.min(j, 4096);
        paramWriter.write(paramArrayOfChar, i, k);
        j -= k;
        i += k;
      }
    }
  }
  
  @Deprecated
  public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream)
  {
    writeLines(paramCollection, paramString, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void writeLines(Collection<?> paramCollection, String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    writeLines(paramCollection, paramString1, paramOutputStream, Charsets.toCharset(paramString2));
  }
  
  public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream, Charset paramCharset)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      String str = paramString;
      if (paramString == null) {
        str = LINE_SEPARATOR;
      }
      paramString = Charsets.toCharset(paramCharset);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        paramCharset = paramCollection.next();
        if (paramCharset != null) {
          paramOutputStream.write(paramCharset.toString().getBytes(paramString));
        }
        paramOutputStream.write(str.getBytes(paramString));
      }
    }
  }
  
  public static void writeLines(Collection<?> paramCollection, String paramString, Writer paramWriter)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      String str = paramString;
      if (paramString == null) {
        str = LINE_SEPARATOR;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        paramString = paramCollection.next();
        if (paramString != null) {
          paramWriter.write(paramString.toString());
        }
        paramWriter.write(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.IOUtils
 * JD-Core Version:    0.7.0.1
 */