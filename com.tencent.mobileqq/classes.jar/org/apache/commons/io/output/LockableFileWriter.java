package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

public class LockableFileWriter
  extends Writer
{
  private static final String LCK = ".lck";
  private final File lockFile;
  private final Writer out;
  
  public LockableFileWriter(File paramFile)
  {
    this(paramFile, false, null);
  }
  
  public LockableFileWriter(File paramFile, String paramString)
  {
    this(paramFile, paramString, false, null);
  }
  
  public LockableFileWriter(File paramFile, String paramString1, boolean paramBoolean, String paramString2)
  {
    this(paramFile, Charsets.toCharset(paramString1), paramBoolean, paramString2);
  }
  
  public LockableFileWriter(File paramFile, Charset paramCharset)
  {
    this(paramFile, paramCharset, false, null);
  }
  
  public LockableFileWriter(File paramFile, Charset paramCharset, boolean paramBoolean, String paramString)
  {
    File localFile = paramFile.getAbsoluteFile();
    if (localFile.getParentFile() != null) {
      FileUtils.forceMkdir(localFile.getParentFile());
    }
    if (!localFile.isDirectory())
    {
      paramFile = paramString;
      if (paramString == null) {
        paramFile = System.getProperty("java.io.tmpdir");
      }
      paramFile = new File(paramFile);
      FileUtils.forceMkdir(paramFile);
      testLockDir(paramFile);
      paramString = new StringBuilder();
      paramString.append(localFile.getName());
      paramString.append(".lck");
      this.lockFile = new File(paramFile, paramString.toString());
      createLock();
      this.out = initWriter(localFile, paramCharset, paramBoolean);
      return;
    }
    throw new IOException("File specified is a directory");
  }
  
  public LockableFileWriter(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, null);
  }
  
  @Deprecated
  public LockableFileWriter(File paramFile, boolean paramBoolean, String paramString)
  {
    this(paramFile, Charset.defaultCharset(), paramBoolean, paramString);
  }
  
  public LockableFileWriter(String paramString)
  {
    this(paramString, false, null);
  }
  
  public LockableFileWriter(String paramString, boolean paramBoolean)
  {
    this(paramString, paramBoolean, null);
  }
  
  public LockableFileWriter(String paramString1, boolean paramBoolean, String paramString2)
  {
    this(new File(paramString1), paramBoolean, paramString2);
  }
  
  private void createLock()
  {
    try
    {
      if (this.lockFile.createNewFile())
      {
        this.lockFile.deleteOnExit();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can't write file, lock ");
      localStringBuilder.append(this.lockFile.getAbsolutePath());
      localStringBuilder.append(" exists");
      throw new IOException(localStringBuilder.toString());
    }
    finally {}
  }
  
  private Writer initWriter(File paramFile, Charset paramCharset, boolean paramBoolean)
  {
    boolean bool = paramFile.exists();
    try
    {
      paramCharset = new OutputStreamWriter(new FileOutputStream(paramFile.getAbsolutePath(), paramBoolean), Charsets.toCharset(paramCharset));
      return paramCharset;
    }
    catch (RuntimeException paramCharset) {}catch (IOException paramCharset) {}
    FileUtils.deleteQuietly(this.lockFile);
    if (!bool) {
      FileUtils.deleteQuietly(paramFile);
    }
    throw paramCharset;
  }
  
  private void testLockDir(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.canWrite()) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not write to lockDir: ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      throw new IOException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not find lockDir: ");
    localStringBuilder.append(paramFile.getAbsolutePath());
    throw new IOException(localStringBuilder.toString());
  }
  
  public void close()
  {
    try
    {
      this.out.close();
      return;
    }
    finally
    {
      this.lockFile.delete();
    }
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
 * Qualified Name:     org.apache.commons.io.output.LockableFileWriter
 * JD-Core Version:    0.7.0.1
 */