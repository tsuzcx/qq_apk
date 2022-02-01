package com.tencent.mobileqq.triton.font;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

public class FontFileReader
{
  private int current;
  private byte[] file;
  private int fsize;
  
  public FontFileReader(InputStream paramInputStream)
  {
    init(paramInputStream);
  }
  
  public FontFileReader(String paramString)
  {
    paramString = new FileInputStream(new File(paramString));
    try
    {
      init(paramString);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static String getFamilyName(String paramString)
  {
    String str1;
    if ((paramString != null) && (paramString.length() > 0))
    {
      str1 = new File(paramString).getName().replaceAll(" ", "_");
      try
      {
        paramString = readTTF(paramString);
        if (paramString != null)
        {
          if ((paramString.getFamilyNames() != null) && (!paramString.getFamilyNames().isEmpty()))
          {
            paramString = paramString.getFamilyNames().iterator();
            String str2;
            do
            {
              if (!paramString.hasNext()) {
                break;
              }
              str2 = (String)paramString.next();
            } while ((str2 == null) || (str2.matches(".*[一-鿿]+.*")));
            return str2;
          }
          if ((paramString.getFullName() != null) && (paramString.getFullName().length() > 0))
          {
            paramString = paramString.getFullName();
            return paramString;
          }
        }
        return str1;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return str1;
      }
    }
    else
    {
      return "";
    }
    return str1;
  }
  
  private void init(InputStream paramInputStream)
  {
    this.file = IOUtils.toByteArray(paramInputStream);
    this.fsize = this.file.length;
    this.current = 0;
  }
  
  private byte read()
  {
    int i = this.current;
    if (i < this.fsize)
    {
      localObject = this.file;
      this.current = (i + 1);
      return localObject[i];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Reached EOF, file size=");
    ((StringBuilder)localObject).append(this.fsize);
    throw new EOFException(((StringBuilder)localObject).toString());
  }
  
  public static TTFFile readTTF(InputStream paramInputStream)
  {
    TTFFile localTTFFile = new TTFFile();
    localTTFFile.readFont(new FontFileReader(paramInputStream));
    return localTTFFile;
  }
  
  public static TTFFile readTTF(String paramString)
  {
    TTFFile localTTFFile = new TTFFile();
    localTTFFile.readFont(new FontFileReader(paramString));
    return localTTFFile;
  }
  
  public byte[] getAllBytes()
  {
    return this.file;
  }
  
  public int getCurrentPos()
  {
    return this.current;
  }
  
  public int getFileSize()
  {
    return this.fsize;
  }
  
  public byte readTTFByte()
  {
    return read();
  }
  
  public int readTTFLong()
  {
    return (int)((((readTTFUByte() << 8) + readTTFUByte() << 8) + readTTFUByte() << 8) + readTTFUByte());
  }
  
  public String readTTFString(int paramInt)
  {
    int i = this.current;
    if (paramInt + i <= this.fsize)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.file, i, arrayOfByte, 0, paramInt);
      this.current += paramInt;
      if ((arrayOfByte.length > 0) && (arrayOfByte[0] == 0)) {
        localObject = "UTF-16BE";
      } else {
        localObject = "ISO-8859-1";
      }
      return new String(arrayOfByte, (String)localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Reached EOF, file size=");
    ((StringBuilder)localObject).append(this.fsize);
    throw new EOFException(((StringBuilder)localObject).toString());
  }
  
  public String readTTFString(int paramInt1, int paramInt2)
  {
    paramInt2 = this.current;
    if (paramInt1 + paramInt2 <= this.fsize)
    {
      localObject = new byte[paramInt1];
      System.arraycopy(this.file, paramInt2, localObject, 0, paramInt1);
      this.current += paramInt1;
      return new String((byte[])localObject, "UTF-16BE");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Reached EOF, file size=");
    ((StringBuilder)localObject).append(this.fsize);
    throw new EOFException(((StringBuilder)localObject).toString());
  }
  
  public int readTTFUByte()
  {
    int j = read();
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    return i;
  }
  
  public long readTTFULong()
  {
    return (((readTTFUByte() << 8) + readTTFUByte() << 8) + readTTFUByte() << 8) + readTTFUByte();
  }
  
  public int readTTFUShort()
  {
    return (readTTFUByte() << 8) + readTTFUByte();
  }
  
  public void seekSet(long paramLong)
  {
    if ((paramLong <= this.fsize) && (paramLong >= 0L))
    {
      this.current = ((int)paramLong);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Reached EOF, file size=");
    localStringBuilder.append(this.fsize);
    localStringBuilder.append(" offset=");
    localStringBuilder.append(paramLong);
    throw new EOFException(localStringBuilder.toString());
  }
  
  public void skip(long paramLong)
  {
    seekSet(this.current + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.FontFileReader
 * JD-Core Version:    0.7.0.1
 */