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
    if (localFile.isDirectory()) {
      throw new IOException("File specified is a directory");
    }
    paramFile = paramString;
    if (paramString == null) {
      paramFile = System.getProperty("java.io.tmpdir");
    }
    paramFile = new File(paramFile);
    FileUtils.forceMkdir(paramFile);
    testLockDir(paramFile);
    this.lockFile = new File(paramFile, localFile.getName() + ".lck");
    createLock();
    this.out = initWriter(localFile, paramCharset, paramBoolean);
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
      if (!this.lockFile.createNewFile()) {
        throw new IOException("Can't write file, lock " + this.lockFile.getAbsolutePath() + " exists");
      }
    }
    finally {}
    this.lockFile.deleteOnExit();
  }
  
  private Writer initWriter(File paramFile, Charset paramCharset, boolean paramBoolean)
  {
    boolean bool = paramFile.exists();
    try
    {
      paramCharset = new OutputStreamWriter(new FileOutputStream(paramFile.getAbsolutePath(), paramBoolean), Charsets.toCharset(paramCharset));
      return paramCharset;
    }
    catch (RuntimeException paramCharset)
    {
      FileUtils.deleteQuietly(this.lockFile);
      if (!bool) {
        FileUtils.deleteQuietly(paramFile);
      }
      throw paramCharset;
    }
    catch (IOException paramCharset)
    {
      label33:
      break label33;
    }
  }
  
  private void testLockDir(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IOException("Could not find lockDir: " + paramFile.getAbsolutePath());
    }
    if (!paramFile.canWrite()) {
      throw new IOException("Could not write to lockDir: " + paramFile.getAbsolutePath());
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.output.LockableFileWriter
 * JD-Core Version:    0.7.0.1
 */