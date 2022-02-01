package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;

public class DeferredFileOutputStream
  extends ThresholdingOutputStream
{
  private boolean closed = false;
  private OutputStream currentOutputStream;
  private final File directory;
  private ByteArrayOutputStream memoryOutputStream;
  private File outputFile;
  private final String prefix;
  private final String suffix;
  
  public DeferredFileOutputStream(int paramInt1, int paramInt2, File paramFile)
  {
    this(paramInt1, paramFile, null, null, null, paramInt2);
    if (paramInt2 >= 0) {
      return;
    }
    throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
  }
  
  public DeferredFileOutputStream(int paramInt1, int paramInt2, String paramString1, String paramString2, File paramFile)
  {
    this(paramInt1, null, paramString1, paramString2, paramFile, paramInt2);
    if (paramString1 != null)
    {
      if (paramInt2 >= 0) {
        return;
      }
      throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
    }
    throw new IllegalArgumentException("Temporary file prefix is missing");
  }
  
  public DeferredFileOutputStream(int paramInt, File paramFile)
  {
    this(paramInt, paramFile, null, null, null, 1024);
  }
  
  private DeferredFileOutputStream(int paramInt1, File paramFile1, String paramString1, String paramString2, File paramFile2, int paramInt2)
  {
    super(paramInt1);
    this.outputFile = paramFile1;
    this.prefix = paramString1;
    this.suffix = paramString2;
    this.directory = paramFile2;
    this.memoryOutputStream = new ByteArrayOutputStream(paramInt2);
    this.currentOutputStream = this.memoryOutputStream;
  }
  
  public DeferredFileOutputStream(int paramInt, String paramString1, String paramString2, File paramFile)
  {
    this(paramInt, null, paramString1, paramString2, paramFile, 1024);
    if (paramString1 != null) {
      return;
    }
    throw new IllegalArgumentException("Temporary file prefix is missing");
  }
  
  public void close()
  {
    super.close();
    this.closed = true;
  }
  
  public byte[] getData()
  {
    ByteArrayOutputStream localByteArrayOutputStream = this.memoryOutputStream;
    if (localByteArrayOutputStream != null) {
      return localByteArrayOutputStream.toByteArray();
    }
    return null;
  }
  
  public File getFile()
  {
    return this.outputFile;
  }
  
  protected OutputStream getStream()
  {
    return this.currentOutputStream;
  }
  
  public boolean isInMemory()
  {
    return isThresholdExceeded() ^ true;
  }
  
  protected void thresholdReached()
  {
    Object localObject = this.prefix;
    if (localObject != null) {
      this.outputFile = File.createTempFile((String)localObject, this.suffix, this.directory);
    }
    FileUtils.forceMkdirParent(this.outputFile);
    localObject = new FileOutputStream(this.outputFile);
    try
    {
      this.memoryOutputStream.writeTo((OutputStream)localObject);
      this.currentOutputStream = ((OutputStream)localObject);
      this.memoryOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      ((FileOutputStream)localObject).close();
      throw localIOException;
    }
  }
  
  /* Error */
  public void writeTo(OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	org/apache/commons/io/output/DeferredFileOutputStream:closed	Z
    //   4: ifeq +70 -> 74
    //   7: aload_0
    //   8: invokevirtual 100	org/apache/commons/io/output/DeferredFileOutputStream:isInMemory	()Z
    //   11: ifeq +12 -> 23
    //   14: aload_0
    //   15: getfield 51	org/apache/commons/io/output/DeferredFileOutputStream:memoryOutputStream	Lorg/apache/commons/io/output/ByteArrayOutputStream;
    //   18: aload_1
    //   19: invokevirtual 95	org/apache/commons/io/output/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   22: return
    //   23: new 102	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: getfield 40	org/apache/commons/io/output/DeferredFileOutputStream:outputFile	Ljava/io/File;
    //   31: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_3
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_3
    //   38: aload_1
    //   39: invokestatic 109	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 110	java/io/FileInputStream:close	()V
    //   47: return
    //   48: astore_1
    //   49: goto +8 -> 57
    //   52: astore_1
    //   53: aload_1
    //   54: astore_2
    //   55: aload_1
    //   56: athrow
    //   57: aload_2
    //   58: ifnull +10 -> 68
    //   61: aload_3
    //   62: invokevirtual 110	java/io/FileInputStream:close	()V
    //   65: goto +7 -> 72
    //   68: aload_3
    //   69: invokevirtual 110	java/io/FileInputStream:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: new 75	java/io/IOException
    //   77: dup
    //   78: ldc 112
    //   80: invokespecial 113	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_2
    //   85: goto -13 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	DeferredFileOutputStream
    //   0	88	1	paramOutputStream	OutputStream
    //   36	22	2	localOutputStream	OutputStream
    //   84	1	2	localThrowable	java.lang.Throwable
    //   34	35	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   37	43	48	finally
    //   55	57	48	finally
    //   37	43	52	java/lang/Throwable
    //   61	65	84	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.DeferredFileOutputStream
 * JD-Core Version:    0.7.0.1
 */