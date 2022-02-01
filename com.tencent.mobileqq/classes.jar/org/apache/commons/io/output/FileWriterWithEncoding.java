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
    if (paramFile == null) {
      throw new NullPointerException("File is missing");
    }
    if (paramObject == null) {
      throw new NullPointerException("Encoding is missing");
    }
    boolean bool = paramFile.exists();
    for (;;)
    {
      try
      {
        localFileOutputStream = new FileOutputStream(paramFile, paramBoolean);
      }
      catch (RuntimeException paramObject)
      {
        FileOutputStream localFileOutputStream;
        localObject = null;
        continue;
      }
      catch (IOException paramObject)
      {
        Object localObject = null;
        continue;
      }
      try
      {
        if ((paramObject instanceof Charset)) {
          return new OutputStreamWriter(localFileOutputStream, (Charset)paramObject);
        }
        if ((paramObject instanceof CharsetEncoder))
        {
          paramObject = new OutputStreamWriter(localFileOutputStream, (CharsetEncoder)paramObject);
          return paramObject;
        }
      }
      catch (IOException paramObject)
      {
        if (localFileOutputStream == null) {}
      }
      catch (RuntimeException paramObject)
      {
        try
        {
          localFileOutputStream.close();
          if (!bool) {
            FileUtils.deleteQuietly(paramFile);
          }
          throw paramObject;
          paramObject = new OutputStreamWriter(localFileOutputStream, (String)paramObject);
          return paramObject;
          paramObject = paramObject;
        }
        catch (IOException localIOException)
        {
          paramObject.addSuppressed(localIOException);
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.output.FileWriterWithEncoding
 * JD-Core Version:    0.7.0.1
 */