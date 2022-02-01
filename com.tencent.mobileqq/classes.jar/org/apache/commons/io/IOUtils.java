package org.apache.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
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
  public static final char DIR_SEPARATOR = File.separatorChar;
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
    //   0: getstatic 38	java/io/File:separatorChar	C
    //   3: putstatic 40	org/apache/commons/io/IOUtils:DIR_SEPARATOR	C
    //   6: new 42	org/apache/commons/io/output/StringBuilderWriter
    //   9: dup
    //   10: iconst_4
    //   11: invokespecial 46	org/apache/commons/io/output/StringBuilderWriter:<init>	(I)V
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_3
    //   19: astore_1
    //   20: new 48	java/io/PrintWriter
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 51	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   29: astore 5
    //   31: aload 5
    //   33: invokevirtual 54	java/io/PrintWriter:println	()V
    //   36: aload 4
    //   38: invokevirtual 58	org/apache/commons/io/output/StringBuilderWriter:toString	()Ljava/lang/String;
    //   41: putstatic 60	org/apache/commons/io/IOUtils:LINE_SEPARATOR	Ljava/lang/String;
    //   44: aload_3
    //   45: astore_1
    //   46: aload 5
    //   48: invokevirtual 63	java/io/PrintWriter:close	()V
    //   51: aload 4
    //   53: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   56: return
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_2
    //   60: goto +11 -> 71
    //   63: astore_0
    //   64: aload_0
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: astore_2
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: ifnull +13 -> 85
    //   75: aload_3
    //   76: astore_1
    //   77: aload 5
    //   79: invokevirtual 63	java/io/PrintWriter:close	()V
    //   82: goto +10 -> 92
    //   85: aload_3
    //   86: astore_1
    //   87: aload 5
    //   89: invokevirtual 63	java/io/PrintWriter:close	()V
    //   92: aload_3
    //   93: astore_1
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: goto +8 -> 105
    //   100: astore_0
    //   101: aload_0
    //   102: astore_1
    //   103: aload_0
    //   104: athrow
    //   105: aload_1
    //   106: ifnull +11 -> 117
    //   109: aload 4
    //   111: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   114: goto +8 -> 122
    //   117: aload 4
    //   119: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore_1
    //   125: goto -33 -> 92
    //   128: astore_1
    //   129: goto -7 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   57	1	0	localObject1	Object
    //   63	5	0	localThrowable1	java.lang.Throwable
    //   70	25	0	localObject2	Object
    //   96	1	0	localObject3	Object
    //   100	23	0	localThrowable2	java.lang.Throwable
    //   19	27	1	localObject4	Object
    //   66	4	1	localObject5	Object
    //   76	30	1	localObject6	Object
    //   124	1	1	localThrowable3	java.lang.Throwable
    //   128	1	1	localThrowable4	java.lang.Throwable
    //   59	13	2	localThrowable5	java.lang.Throwable
    //   17	76	3	localObject7	Object
    //   14	104	4	localStringBuilderWriter	org.apache.commons.io.output.StringBuilderWriter
    //   29	59	5	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   31	44	57	finally
    //   31	44	63	java/lang/Throwable
    //   64	66	66	finally
    //   20	31	96	finally
    //   46	51	96	finally
    //   77	82	96	finally
    //   87	92	96	finally
    //   94	96	96	finally
    //   103	105	96	finally
    //   20	31	100	java/lang/Throwable
    //   46	51	100	java/lang/Throwable
    //   87	92	100	java/lang/Throwable
    //   94	96	100	java/lang/Throwable
    //   77	82	124	java/lang/Throwable
    //   109	114	128	java/lang/Throwable
  }
  
  public static BufferedInputStream buffer(InputStream paramInputStream)
  {
    if (paramInputStream != null)
    {
      if ((paramInputStream instanceof BufferedInputStream)) {
        return (BufferedInputStream)paramInputStream;
      }
      return new BufferedInputStream(paramInputStream);
    }
    throw new NullPointerException();
  }
  
  public static BufferedInputStream buffer(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream != null)
    {
      if ((paramInputStream instanceof BufferedInputStream)) {
        return (BufferedInputStream)paramInputStream;
      }
      return new BufferedInputStream(paramInputStream, paramInt);
    }
    throw new NullPointerException();
  }
  
  public static BufferedOutputStream buffer(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null)
    {
      if ((paramOutputStream instanceof BufferedOutputStream)) {
        return (BufferedOutputStream)paramOutputStream;
      }
      return new BufferedOutputStream(paramOutputStream);
    }
    throw new NullPointerException();
  }
  
  public static BufferedOutputStream buffer(OutputStream paramOutputStream, int paramInt)
  {
    if (paramOutputStream != null)
    {
      if ((paramOutputStream instanceof BufferedOutputStream)) {
        return (BufferedOutputStream)paramOutputStream;
      }
      return new BufferedOutputStream(paramOutputStream, paramInt);
    }
    throw new NullPointerException();
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
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      closeQuietly(paramVarArgs[i]);
      i += 1;
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
    return paramInputStream1.read() == -1;
  }
  
  public static boolean contentEquals(Reader paramReader1, Reader paramReader2)
  {
    if (paramReader1 == paramReader2) {
      return true;
    }
    paramReader1 = toBufferedReader(paramReader1);
    paramReader2 = toBufferedReader(paramReader2);
    for (int i = paramReader1.read(); -1 != i; i = paramReader1.read()) {
      if (i != paramReader2.read()) {
        return false;
      }
    }
    return paramReader2.read() == -1;
  }
  
  public static boolean contentEqualsIgnoreEOL(Reader paramReader1, Reader paramReader2)
  {
    if (paramReader1 == paramReader2) {
      return true;
    }
    BufferedReader localBufferedReader1 = toBufferedReader(paramReader1);
    BufferedReader localBufferedReader2 = toBufferedReader(paramReader2);
    paramReader1 = localBufferedReader1.readLine();
    for (paramReader2 = localBufferedReader2.readLine(); (paramReader1 != null) && (paramReader2 != null) && (paramReader1.equals(paramReader2)); paramReader2 = localBufferedReader2.readLine()) {
      paramReader1 = localBufferedReader1.readLine();
    }
    if (paramReader1 == null) {
      return paramReader2 == null;
    }
    return paramReader1.equals(paramReader2);
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
    int i;
    if ((paramLong2 > 0L) && (paramLong2 < j)) {
      i = (int)paramLong2;
    } else {
      i = j;
    }
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
    if (paramLong2 == 0L) {
      return 0L;
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
    while (i > 0)
    {
      j = paramReader.read(paramArrayOfChar, 0, i);
      if (-1 == j) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, j);
      long l = paramLong1 + j;
      paramLong1 = l;
      if (paramLong2 > 0L)
      {
        i = (int)Math.min(paramLong2 - l, paramArrayOfChar.length);
        paramLong1 = l;
      }
    }
    return paramLong1;
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
    if (paramInt2 >= 0)
    {
      int i = paramInt2;
      while (i > 0)
      {
        int j = paramInputStream.read(paramArrayOfByte, paramInt2 - i + paramInt1, i);
        if (-1 == j) {
          break;
        }
        i -= j;
      }
      return paramInt2 - i;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Length must not be negative: ");
    paramInputStream.append(paramInt2);
    paramInputStream = new IllegalArgumentException(paramInputStream.toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static int read(Reader paramReader, char[] paramArrayOfChar)
  {
    return read(paramReader, paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static int read(Reader paramReader, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      int i = paramInt2;
      while (i > 0)
      {
        int j = paramReader.read(paramArrayOfChar, paramInt2 - i + paramInt1, i);
        if (-1 == j) {
          break;
        }
        i -= j;
      }
      return paramInt2 - i;
    }
    paramReader = new StringBuilder();
    paramReader.append("Length must not be negative: ");
    paramReader.append(paramInt2);
    paramReader = new IllegalArgumentException(paramReader.toString());
    for (;;)
    {
      throw paramReader;
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
    if (paramInt1 == paramInt2) {
      return;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Length to read: ");
    paramInputStream.append(paramInt2);
    paramInputStream.append(" actual: ");
    paramInputStream.append(paramInt1);
    throw new EOFException(paramInputStream.toString());
  }
  
  public static void readFully(Reader paramReader, char[] paramArrayOfChar)
  {
    readFully(paramReader, paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static void readFully(Reader paramReader, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt1 = read(paramReader, paramArrayOfChar, paramInt1, paramInt2);
    if (paramInt1 == paramInt2) {
      return;
    }
    paramReader = new StringBuilder();
    paramReader.append("Length to read: ");
    paramReader.append(paramInt2);
    paramReader.append(" actual: ");
    paramReader.append(paramInt1);
    throw new EOFException(paramReader.toString());
  }
  
  public static void readFully(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    int j = read(paramReadableByteChannel, paramByteBuffer);
    if (j == i) {
      return;
    }
    paramReadableByteChannel = new StringBuilder();
    paramReadableByteChannel.append("Length to read: ");
    paramReadableByteChannel.append(i);
    paramReadableByteChannel.append(" actual: ");
    paramReadableByteChannel.append(j);
    throw new EOFException(paramReadableByteChannel.toString());
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
    if (paramClassLoader == null) {
      paramClassLoader = IOUtils.class.getResource(paramString);
    } else {
      paramClassLoader = paramClassLoader.getResource(paramString);
    }
    if (paramClassLoader != null) {
      return paramClassLoader;
    }
    paramClassLoader = new StringBuilder();
    paramClassLoader.append("Resource not found: ");
    paramClassLoader.append(paramString);
    throw new IOException(paramClassLoader.toString());
  }
  
  public static long skip(InputStream paramInputStream, long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (SKIP_BYTE_BUFFER == null) {
        SKIP_BYTE_BUFFER = new byte[2048];
      }
      long l2;
      for (long l1 = paramLong; l1 > 0L; l1 -= l2)
      {
        l2 = paramInputStream.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l1, 2048L));
        if (l2 < 0L) {
          break;
        }
      }
      return paramLong - l1;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Skip count must be non-negative, actual: ");
    paramInputStream.append(paramLong);
    paramInputStream = new IllegalArgumentException(paramInputStream.toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static long skip(Reader paramReader, long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (SKIP_CHAR_BUFFER == null) {
        SKIP_CHAR_BUFFER = new char[2048];
      }
      long l2;
      for (long l1 = paramLong; l1 > 0L; l1 -= l2)
      {
        l2 = paramReader.read(SKIP_CHAR_BUFFER, 0, (int)Math.min(l1, 2048L));
        if (l2 < 0L) {
          break;
        }
      }
      return paramLong - l1;
    }
    paramReader = new StringBuilder();
    paramReader.append("Skip count must be non-negative, actual: ");
    paramReader.append(paramLong);
    paramReader = new IllegalArgumentException(paramReader.toString());
    for (;;)
    {
      throw paramReader;
    }
  }
  
  public static long skip(ReadableByteChannel paramReadableByteChannel, long paramLong)
  {
    if (paramLong >= 0L)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((int)Math.min(paramLong, 2048L));
      int i;
      for (long l = paramLong; l > 0L; l -= i)
      {
        localByteBuffer.position(0);
        localByteBuffer.limit((int)Math.min(l, 2048L));
        i = paramReadableByteChannel.read(localByteBuffer);
        if (i == -1) {
          break;
        }
      }
      return paramLong - l;
    }
    paramReadableByteChannel = new StringBuilder();
    paramReadableByteChannel.append("Skip count must be non-negative, actual: ");
    paramReadableByteChannel.append(paramLong);
    paramReadableByteChannel = new IllegalArgumentException(paramReadableByteChannel.toString());
    for (;;)
    {
      throw paramReadableByteChannel;
    }
  }
  
  public static void skipFully(InputStream paramInputStream, long paramLong)
  {
    if (paramLong >= 0L)
    {
      long l = skip(paramInputStream, paramLong);
      if (l == paramLong) {
        return;
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("Bytes to skip: ");
      paramInputStream.append(paramLong);
      paramInputStream.append(" actual: ");
      paramInputStream.append(l);
      throw new EOFException(paramInputStream.toString());
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Bytes to skip must not be negative: ");
    paramInputStream.append(paramLong);
    throw new IllegalArgumentException(paramInputStream.toString());
  }
  
  public static void skipFully(Reader paramReader, long paramLong)
  {
    long l = skip(paramReader, paramLong);
    if (l == paramLong) {
      return;
    }
    paramReader = new StringBuilder();
    paramReader.append("Chars to skip: ");
    paramReader.append(paramLong);
    paramReader.append(" actual: ");
    paramReader.append(l);
    throw new EOFException(paramReader.toString());
  }
  
  public static void skipFully(ReadableByteChannel paramReadableByteChannel, long paramLong)
  {
    if (paramLong >= 0L)
    {
      long l = skip(paramReadableByteChannel, paramLong);
      if (l == paramLong) {
        return;
      }
      paramReadableByteChannel = new StringBuilder();
      paramReadableByteChannel.append("Bytes to skip: ");
      paramReadableByteChannel.append(paramLong);
      paramReadableByteChannel.append(" actual: ");
      paramReadableByteChannel.append(l);
      throw new EOFException(paramReadableByteChannel.toString());
    }
    paramReadableByteChannel = new StringBuilder();
    paramReadableByteChannel.append("Bytes to skip must not be negative: ");
    paramReadableByteChannel.append(paramLong);
    throw new IllegalArgumentException(paramReadableByteChannel.toString());
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
    //   0: new 433	org/apache/commons/io/output/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 440	org/apache/commons/io/output/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_2
    //   11: astore_1
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 442	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   17: pop
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: invokevirtual 445	org/apache/commons/io/output/ByteArrayOutputStream:toByteArray	()[B
    //   24: astore_0
    //   25: aload_3
    //   26: invokevirtual 446	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: goto +8 -> 40
    //   35: astore_0
    //   36: aload_0
    //   37: astore_1
    //   38: aload_0
    //   39: athrow
    //   40: aload_1
    //   41: ifnull +10 -> 51
    //   44: aload_3
    //   45: invokevirtual 446	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   48: goto +7 -> 55
    //   51: aload_3
    //   52: invokevirtual 446	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   55: aload_0
    //   56: athrow
    //   57: astore_1
    //   58: goto -3 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramInputStream	InputStream
    //   11	30	1	localObject1	Object
    //   57	1	1	localThrowable	java.lang.Throwable
    //   9	10	2	localObject2	Object
    //   7	45	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   12	18	31	finally
    //   20	25	31	finally
    //   38	40	31	finally
    //   12	18	35	java/lang/Throwable
    //   20	25	35	java/lang/Throwable
    //   44	48	57	java/lang/Throwable
  }
  
  public static byte[] toByteArray(InputStream paramInputStream, int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = 0;
      if (paramInt == 0) {
        return new byte[0];
      }
      byte[] arrayOfByte = new byte[paramInt];
      while (i < paramInt)
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j == -1) {
          break;
        }
        i += j;
      }
      if (i == paramInt) {
        return arrayOfByte;
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("Unexpected read size. current: ");
      paramInputStream.append(i);
      paramInputStream.append(", expected: ");
      paramInputStream.append(paramInt);
      throw new IOException(paramInputStream.toString());
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Size must be equal or greater than zero: ");
    paramInputStream.append(paramInt);
    paramInputStream = new IllegalArgumentException(paramInputStream.toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static byte[] toByteArray(InputStream paramInputStream, long paramLong)
  {
    if (paramLong <= 2147483647L) {
      return toByteArray(paramInputStream, (int)paramLong);
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Size cannot be greater than Integer max value: ");
    paramInputStream.append(paramLong);
    throw new IllegalArgumentException(paramInputStream.toString());
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
    //   0: new 433	org/apache/commons/io/output/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 440	org/apache/commons/io/output/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: astore_2
    //   13: aload_0
    //   14: aload 4
    //   16: aload_1
    //   17: invokestatic 211	org/apache/commons/io/IOUtils:copy	(Ljava/io/Reader;Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   20: aload_3
    //   21: astore_2
    //   22: aload 4
    //   24: invokevirtual 445	org/apache/commons/io/output/ByteArrayOutputStream:toByteArray	()[B
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 446	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: goto +8 -> 44
    //   39: astore_0
    //   40: aload_0
    //   41: astore_2
    //   42: aload_0
    //   43: athrow
    //   44: aload_2
    //   45: ifnull +11 -> 56
    //   48: aload 4
    //   50: invokevirtual 446	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   53: goto +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 446	org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   61: aload_0
    //   62: athrow
    //   63: astore_1
    //   64: goto -3 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramReader	Reader
    //   0	67	1	paramCharset	Charset
    //   12	33	2	localObject1	Object
    //   10	11	3	localObject2	Object
    //   7	50	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   13	20	35	finally
    //   22	28	35	finally
    //   42	44	35	finally
    //   13	20	39	java/lang/Throwable
    //   22	28	39	java/lang/Throwable
    //   48	53	63	java/lang/Throwable
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
  
  /* Error */
  public static byte[] toByteArray(URLConnection paramURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 490	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 492	org/apache/commons/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   9: astore_0
    //   10: aload_2
    //   11: ifnull +7 -> 18
    //   14: aload_2
    //   15: invokevirtual 493	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: areturn
    //   20: astore_0
    //   21: aconst_null
    //   22: astore_1
    //   23: goto +7 -> 30
    //   26: astore_1
    //   27: aload_1
    //   28: athrow
    //   29: astore_0
    //   30: aload_2
    //   31: ifnull +18 -> 49
    //   34: aload_1
    //   35: ifnull +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 493	java/io/InputStream:close	()V
    //   42: goto +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 493	java/io/InputStream:close	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_1
    //   52: goto -3 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramURLConnection	URLConnection
    //   22	1	1	localObject	Object
    //   26	9	1	localThrowable1	java.lang.Throwable
    //   51	1	1	localThrowable2	java.lang.Throwable
    //   4	42	2	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   5	10	20	finally
    //   5	10	26	java/lang/Throwable
    //   27	29	29	finally
    //   38	42	51	java/lang/Throwable
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
    //   4: invokespecial 531	org/apache/commons/io/output/StringBuilderWriter:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: astore_2
    //   13: aload_0
    //   14: aload 4
    //   16: aload_1
    //   17: invokestatic 190	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/Writer;Ljava/nio/charset/Charset;)V
    //   20: aload_3
    //   21: astore_2
    //   22: aload 4
    //   24: invokevirtual 58	org/apache/commons/io/output/StringBuilderWriter:toString	()Ljava/lang/String;
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: goto +8 -> 44
    //   39: astore_0
    //   40: aload_0
    //   41: astore_2
    //   42: aload_0
    //   43: athrow
    //   44: aload_2
    //   45: ifnull +11 -> 56
    //   48: aload 4
    //   50: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   53: goto +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   61: aload_0
    //   62: athrow
    //   63: astore_1
    //   64: goto -3 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramInputStream	InputStream
    //   0	67	1	paramCharset	Charset
    //   12	33	2	localObject1	Object
    //   10	11	3	localObject2	Object
    //   7	50	4	localStringBuilderWriter	org.apache.commons.io.output.StringBuilderWriter
    // Exception table:
    //   from	to	target	type
    //   13	20	35	finally
    //   22	28	35	finally
    //   42	44	35	finally
    //   13	20	39	java/lang/Throwable
    //   22	28	39	java/lang/Throwable
    //   48	53	63	java/lang/Throwable
  }
  
  /* Error */
  public static String toString(Reader paramReader)
  {
    // Byte code:
    //   0: new 42	org/apache/commons/io/output/StringBuilderWriter
    //   3: dup
    //   4: invokespecial 531	org/apache/commons/io/output/StringBuilderWriter:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_2
    //   11: astore_1
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 207	org/apache/commons/io/IOUtils:copy	(Ljava/io/Reader;Ljava/io/Writer;)I
    //   17: pop
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: invokevirtual 58	org/apache/commons/io/output/StringBuilderWriter:toString	()Ljava/lang/String;
    //   24: astore_0
    //   25: aload_3
    //   26: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: goto +8 -> 40
    //   35: astore_0
    //   36: aload_0
    //   37: astore_1
    //   38: aload_0
    //   39: athrow
    //   40: aload_1
    //   41: ifnull +10 -> 51
    //   44: aload_3
    //   45: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   48: goto +7 -> 55
    //   51: aload_3
    //   52: invokevirtual 64	org/apache/commons/io/output/StringBuilderWriter:close	()V
    //   55: aload_0
    //   56: athrow
    //   57: astore_1
    //   58: goto -3 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramReader	Reader
    //   11	30	1	localObject1	Object
    //   57	1	1	localThrowable	java.lang.Throwable
    //   9	10	2	localObject2	Object
    //   7	45	3	localStringBuilderWriter	org.apache.commons.io.output.StringBuilderWriter
    // Exception table:
    //   from	to	target	type
    //   12	18	31	finally
    //   20	25	31	finally
    //   38	40	31	finally
    //   12	18	35	java/lang/Throwable
    //   20	25	35	java/lang/Throwable
    //   44	48	57	java/lang/Throwable
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
  
  /* Error */
  public static String toString(URL paramURL, Charset paramCharset)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 542	java/net/URL:openStream	()Ljava/io/InputStream;
    //   4: astore_2
    //   5: aload_2
    //   6: aload_1
    //   7: invokestatic 529	org/apache/commons/io/IOUtils:toString	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   10: astore_0
    //   11: aload_2
    //   12: ifnull +7 -> 19
    //   15: aload_2
    //   16: invokevirtual 493	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: areturn
    //   21: astore_0
    //   22: aconst_null
    //   23: astore_1
    //   24: goto +7 -> 31
    //   27: astore_1
    //   28: aload_1
    //   29: athrow
    //   30: astore_0
    //   31: aload_2
    //   32: ifnull +18 -> 50
    //   35: aload_1
    //   36: ifnull +10 -> 46
    //   39: aload_2
    //   40: invokevirtual 493	java/io/InputStream:close	()V
    //   43: goto +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 493	java/io/InputStream:close	()V
    //   50: aload_0
    //   51: athrow
    //   52: astore_1
    //   53: goto -3 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramURL	URL
    //   0	56	1	paramCharset	Charset
    //   4	43	2	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   5	11	21	finally
    //   5	11	27	java/lang/Throwable
    //   28	30	30	finally
    //   39	43	52	java/lang/Throwable
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
    if (paramCollection == null) {
      return;
    }
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
  
  public static void writeLines(Collection<?> paramCollection, String paramString, Writer paramWriter)
  {
    if (paramCollection == null) {
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.IOUtils
 * JD-Core Version:    0.7.0.1
 */