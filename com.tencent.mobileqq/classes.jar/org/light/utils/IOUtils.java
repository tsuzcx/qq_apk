package org.light.utils;

import android.database.Cursor;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IOUtils
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final char DIR_SEPARATOR = File.separatorChar;
  public static final char DIR_SEPARATOR_UNIX = '/';
  public static final char DIR_SEPARATOR_WINDOWS = '\\';
  public static final String LINE_SEPARATOR;
  public static final String LINE_SEPARATOR_UNIX = "\n";
  public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
  
  static
  {
    StringWriter localStringWriter = new StringWriter(4);
    new PrintWriter(localStringWriter).println();
    LINE_SEPARATOR = localStringWriter.toString();
  }
  
  public static void closeQuietly(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    try
    {
      paramCursor.close();
      return;
    }
    catch (Throwable paramCursor)
    {
      paramCursor.printStackTrace();
    }
  }
  
  public static void closeQuietly(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  public static void closeQuietly(Reader paramReader)
  {
    if (paramReader != null) {}
    try
    {
      paramReader.close();
      return;
    }
    catch (IOException paramReader) {}
  }
  
  public static void closeQuietly(Writer paramWriter)
  {
    if (paramWriter != null) {}
    try
    {
      paramWriter.close();
      return;
    }
    catch (IOException paramWriter) {}
  }
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
  {
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
    Object localObject = paramReader1;
    if (!(paramReader1 instanceof BufferedReader)) {
      localObject = new BufferedReader(paramReader1);
    }
    paramReader1 = paramReader2;
    if (!(paramReader2 instanceof BufferedReader)) {
      paramReader1 = new BufferedReader(paramReader2);
    }
    for (int i = ((Reader)localObject).read(); -1 != i; i = ((Reader)localObject).read()) {
      if (i != paramReader1.read()) {
        return false;
      }
    }
    if (paramReader1.read() == -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
  
  public static void copy(InputStream paramInputStream, Writer paramWriter)
  {
    copy(new InputStreamReader(paramInputStream), paramWriter);
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString)
  {
    if (paramString == null)
    {
      copy(paramInputStream, paramWriter);
      return;
    }
    copy(new InputStreamReader(paramInputStream, paramString), paramWriter);
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream)
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream);
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString)
  {
    if (paramString == null)
    {
      copy(paramReader, paramOutputStream);
      return;
    }
    paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString);
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter)
  {
    char[] arrayOfChar = new char[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramReader.read(arrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(arrayOfChar, 0, i);
    }
    return l;
  }
  
  public static List readLines(InputStream paramInputStream)
  {
    return readLines(new InputStreamReader(paramInputStream));
  }
  
  public static List readLines(InputStream paramInputStream, String paramString)
  {
    if (paramString == null) {
      return readLines(paramInputStream);
    }
    return readLines(new InputStreamReader(paramInputStream, paramString));
  }
  
  public static List readLines(Reader paramReader)
  {
    BufferedReader localBufferedReader = new BufferedReader(paramReader);
    ArrayList localArrayList = new ArrayList();
    for (paramReader = localBufferedReader.readLine(); paramReader != null; paramReader = localBufferedReader.readLine()) {
      localArrayList.add(paramReader);
    }
    return localArrayList;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] toByteArray(Reader paramReader)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramReader, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] toByteArray(Reader paramReader, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramReader, localByteArrayOutputStream, paramString);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] toByteArray(String paramString)
  {
    return paramString.getBytes();
  }
  
  public static char[] toCharArray(InputStream paramInputStream)
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramInputStream, localCharArrayWriter);
    return localCharArrayWriter.toCharArray();
  }
  
  public static char[] toCharArray(InputStream paramInputStream, String paramString)
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramInputStream, localCharArrayWriter, paramString);
    return localCharArrayWriter.toCharArray();
  }
  
  public static char[] toCharArray(Reader paramReader)
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramReader, localCharArrayWriter);
    return localCharArrayWriter.toCharArray();
  }
  
  public static InputStream toInputStream(String paramString)
  {
    return new ByteArrayInputStream(paramString.getBytes());
  }
  
  public static InputStream toInputStream(String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    for (paramString1 = paramString1.getBytes(paramString2);; paramString1 = paramString1.getBytes()) {
      return new ByteArrayInputStream(paramString1);
    }
  }
  
  public static InputStream toInputStream(byte[] paramArrayOfByte)
  {
    return new ByteArrayInputStream(paramArrayOfByte);
  }
  
  public static String toString(InputStream paramInputStream)
  {
    StringWriter localStringWriter = new StringWriter();
    copy(paramInputStream, localStringWriter);
    return localStringWriter.toString();
  }
  
  public static String toString(InputStream paramInputStream, String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    copy(paramInputStream, localStringWriter, paramString);
    return localStringWriter.toString();
  }
  
  public static String toString(Reader paramReader)
  {
    StringWriter localStringWriter = new StringWriter();
    copy(paramReader, localStringWriter);
    return localStringWriter.toString();
  }
  
  public static String toString(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte);
  }
  
  public static String toString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramString == null) {
      return new String(paramArrayOfByte);
    }
    return new String(paramArrayOfByte, paramString);
  }
  
  public static void write(String paramString, OutputStream paramOutputStream)
  {
    if (paramString != null) {
      paramOutputStream.write(paramString.getBytes());
    }
  }
  
  public static void write(String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        write(paramString1, paramOutputStream);
      }
    }
    else {
      return;
    }
    paramOutputStream.write(paramString1.getBytes(paramString2));
  }
  
  public static void write(String paramString, Writer paramWriter)
  {
    if (paramString != null) {
      paramWriter.write(paramString);
    }
  }
  
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream)
  {
    if (paramStringBuffer != null) {
      paramOutputStream.write(paramStringBuffer.toString().getBytes());
    }
  }
  
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream, String paramString)
  {
    if (paramStringBuffer != null)
    {
      if (paramString == null) {
        write(paramStringBuffer, paramOutputStream);
      }
    }
    else {
      return;
    }
    paramOutputStream.write(paramStringBuffer.toString().getBytes(paramString));
  }
  
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
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter)
  {
    if (paramArrayOfByte != null) {
      paramWriter.write(new String(paramArrayOfByte));
    }
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      if (paramString == null) {
        write(paramArrayOfByte, paramWriter);
      }
    }
    else {
      return;
    }
    paramWriter.write(new String(paramArrayOfByte, paramString));
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream)
  {
    if (paramArrayOfChar != null) {
      paramOutputStream.write(new String(paramArrayOfChar).getBytes());
    }
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream, String paramString)
  {
    if (paramArrayOfChar != null)
    {
      if (paramString == null) {
        write(paramArrayOfChar, paramOutputStream);
      }
    }
    else {
      return;
    }
    paramOutputStream.write(new String(paramArrayOfChar).getBytes(paramString));
  }
  
  public static void write(char[] paramArrayOfChar, Writer paramWriter)
  {
    if (paramArrayOfChar != null) {
      paramWriter.write(paramArrayOfChar);
    }
  }
  
  public static void writeLines(Collection paramCollection, String paramString, OutputStream paramOutputStream)
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
          paramOutputStream.write(paramString.toString().getBytes());
        }
        paramOutputStream.write(str.getBytes());
      }
    }
  }
  
  public static void writeLines(Collection paramCollection, String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    if (paramString2 == null) {
      writeLines(paramCollection, paramString1, paramOutputStream);
    }
    for (;;)
    {
      return;
      if (paramCollection != null)
      {
        String str = paramString1;
        if (paramString1 == null) {
          str = LINE_SEPARATOR;
        }
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          paramString1 = paramCollection.next();
          if (paramString1 != null) {
            paramOutputStream.write(paramString1.toString().getBytes(paramString2));
          }
          paramOutputStream.write(str.getBytes(paramString2));
        }
      }
    }
  }
  
  public static void writeLines(Collection paramCollection, String paramString, Writer paramWriter)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */