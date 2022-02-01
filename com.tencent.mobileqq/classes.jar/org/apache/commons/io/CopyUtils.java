package org.apache.commons.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

@Deprecated
public class CopyUtils
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (-1 == j) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
    return i;
  }
  
  public static int copy(Reader paramReader, Writer paramWriter)
  {
    char[] arrayOfChar = new char[4096];
    int i = 0;
    for (;;)
    {
      int j = paramReader.read(arrayOfChar);
      if (-1 == j) {
        break;
      }
      paramWriter.write(arrayOfChar, 0, j);
      i += j;
    }
    return i;
  }
  
  @Deprecated
  public static void copy(InputStream paramInputStream, Writer paramWriter)
  {
    copy(new InputStreamReader(paramInputStream, Charset.defaultCharset()), paramWriter);
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString)
  {
    copy(new InputStreamReader(paramInputStream, paramString), paramWriter);
  }
  
  @Deprecated
  public static void copy(Reader paramReader, OutputStream paramOutputStream)
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream, Charset.defaultCharset());
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString)
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString);
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
  }
  
  @Deprecated
  public static void copy(String paramString, OutputStream paramOutputStream)
  {
    paramString = new StringReader(paramString);
    paramOutputStream = new OutputStreamWriter(paramOutputStream, Charset.defaultCharset());
    copy(paramString, paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static void copy(String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    paramString1 = new StringReader(paramString1);
    paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString2);
    copy(paramString1, paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static void copy(String paramString, Writer paramWriter)
  {
    paramWriter.write(paramString);
  }
  
  public static void copy(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    paramOutputStream.write(paramArrayOfByte);
  }
  
  @Deprecated
  public static void copy(byte[] paramArrayOfByte, Writer paramWriter)
  {
    copy(new ByteArrayInputStream(paramArrayOfByte), paramWriter);
  }
  
  public static void copy(byte[] paramArrayOfByte, Writer paramWriter, String paramString)
  {
    copy(new ByteArrayInputStream(paramArrayOfByte), paramWriter, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.CopyUtils
 * JD-Core Version:    0.7.0.1
 */