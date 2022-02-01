package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.FileUtils;

public class FileWriterWithEncoding
  extends Writer
{
  private final Writer out;
  
  public FileWriterWithEncoding(File paramFile, String paramString)
  {
    this(paramFile, paramString, false);
  }
  
  public FileWriterWithEncoding(File paramFile, String paramString, boolean paramBoolean)
  {
    this.out = initWriter(paramFile, paramString, paramBoolean);
  }
  
  public FileWriterWithEncoding(File paramFile, Charset paramCharset)
  {
    this(paramFile, paramCharset, false);
  }
  
  public FileWriterWithEncoding(File paramFile, Charset paramCharset, boolean paramBoolean)
  {
    this.out = initWriter(paramFile, paramCharset, paramBoolean);
  }
  
  public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder)
  {
    this(paramFile, paramCharsetEncoder, false);
  }
  
  public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder, boolean paramBoolean)
  {
    this.out = initWriter(paramFile, paramCharsetEncoder, paramBoolean);
  }
  
  public FileWriterWithEncoding(String paramString1, String paramString2)
  {
    this(new File(paramString1), paramString2, false);
  }
  
  public FileWriterWithEncoding(String paramString1, String paramString2, boolean paramBoolean)
  {
    this(new File(paramString1), paramString2, paramBoolean);
  }
  
  public FileWriterWithEncoding(String paramString, Charset paramCharset)
  {
    this(new File(paramString), paramCharset, false);
  }
  
  public FileWriterWithEncoding(String paramString, Charset paramCharset, boolean paramBoolean)
  {
    this(new File(paramString), paramCharset, paramBoolean);
  }
  
  public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder)
  {
    this(new File(paramString), paramCharsetEncoder, false);
  }
  
  public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder, boolean paramBoolean)
  {
    this(new File(paramString), paramCharsetEncoder, paramBoolean);
  }
  
  private static Writer initWriter(File paramFile, Object paramObject, boolean paramBoolean)
  {
    boolean bool;
    FileOutputStream localFileOutputStream;
    if (paramFile != null) {
      if (paramObject != null)
      {
        bool = paramFile.exists();
        try
        {
          localFileOutputStream = new FileOutputStream(paramFile, paramBoolean);
          try
          {
            if ((paramObject instanceof Charset)) {
              return new OutputStreamWriter(localFileOutputStream, (Charset)paramObject);
            }
            if ((paramObject instanceof CharsetEncoder)) {
              return new OutputStreamWriter(localFileOutputStream, (CharsetEncoder)paramObject);
            }
            paramObject = new OutputStreamWriter(localFileOutputStream, (String)paramObject);
            return paramObject;
          }
          catch (RuntimeException paramObject) {}catch (IOException paramObject) {}
          localFileOutputStream = null;
        }
        catch (RuntimeException paramObject) {}catch (IOException paramObject) {}
        if (localFileOutputStream == null) {}
      }
    }
    try
    {
      localFileOutputStream.close();
      label108:
      if (!bool) {
        FileUtils.deleteQuietly(paramFile);
      }
      throw paramObject;
      throw new NullPointerException("Encoding is missing");
      throw new NullPointerException("File is missing");
    }
    catch (IOException localIOException)
    {
      break label108;
    }
  }
  
  public void close()
  {
    this.out.close();
  }
  
  public void flush()
  {
    this.out.flush();
  }
  
  public void write(int paramInt)
  {
    this.out.write(paramInt);
  }
  
  public void write(String paramString)
  {
    this.out.write(paramString);
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    this.out.write(paramString, paramInt1, paramInt2);
  }
  
  public void write(char[] paramArrayOfChar)
  {
    this.out.write(paramArrayOfChar);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.FileWriterWithEncoding
 * JD-Core Version:    0.7.0.1
 */