package com.tencent.mobileqq.mini.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class DiskLruCache$Editor
{
  private boolean committed;
  private final DiskLruCache.Entry entry;
  private boolean hasErrors;
  private final boolean[] written;
  
  private DiskLruCache$Editor(DiskLruCache paramDiskLruCache, DiskLruCache.Entry paramEntry)
  {
    this.entry = paramEntry;
    if (DiskLruCache.Entry.access$600(paramEntry)) {
      paramDiskLruCache = null;
    } else {
      paramDiskLruCache = new boolean[DiskLruCache.access$1800(paramDiskLruCache)];
    }
    this.written = paramDiskLruCache;
  }
  
  public void abort()
  {
    DiskLruCache.access$2200(this.this$0, this, false);
  }
  
  public void abortUnlessCommitted()
  {
    if (!this.committed) {}
    try
    {
      abort();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void commit()
  {
    if (this.hasErrors)
    {
      DiskLruCache.access$2200(this.this$0, this, false);
      this.this$0.remove(DiskLruCache.Entry.access$1100(this.entry));
    }
    else
    {
      DiskLruCache.access$2200(this.this$0, this, true);
    }
    this.committed = true;
  }
  
  public String getString(int paramInt)
  {
    InputStream localInputStream = newInputStream(paramInt);
    if (localInputStream != null) {
      return DiskLruCache.access$1700(localInputStream);
    }
    return null;
  }
  
  public InputStream newInputStream(int paramInt)
  {
    synchronized (this.this$0)
    {
      if (DiskLruCache.Entry.access$700(this.entry) == this) {
        if (!DiskLruCache.Entry.access$600(this.entry)) {
          return null;
        }
      }
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.entry.getCleanFile(paramInt));
        return localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        label52:
        break label52;
      }
      return null;
      throw new IllegalStateException();
    }
  }
  
  public OutputStream newOutputStream(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < DiskLruCache.access$1800(this.this$0)))
    {
      synchronized (this.this$0)
      {
        File localFile;
        if (DiskLruCache.Entry.access$700(this.entry) == this)
        {
          if (!DiskLruCache.Entry.access$600(this.entry)) {
            this.written[paramInt] = true;
          }
          localFile = this.entry.getDirtyFile(paramInt);
        }
        try
        {
          localObject1 = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          Object localObject1;
          label73:
          break label73;
        }
        DiskLruCache.access$1900(this.this$0).mkdirs();
        try
        {
          localObject1 = new FileOutputStream(localFile);
          localObject1 = new DiskLruCache.Editor.FaultHidingOutputStream(this, (OutputStream)localObject1, null);
          return localObject1;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          label109:
          StringBuilder localStringBuilder;
          break label109;
        }
        localObject1 = DiskLruCache.access$2000();
        return localObject1;
        throw new IllegalStateException();
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected index ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" to be greater than 0 and less than the maximum value count of ");
      localStringBuilder.append(DiskLruCache.access$1800(this.this$0));
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  /* Error */
  public void set(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 151	java/io/OutputStreamWriter
    //   6: dup
    //   7: aload_0
    //   8: iload_1
    //   9: invokevirtual 153	com/tencent/mobileqq/mini/cache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   12: getstatic 159	com/tencent/mobileqq/mini/cache/Util:UTF_8	Ljava/nio/charset/Charset;
    //   15: invokespecial 162	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 167	java/io/Writer:write	(Ljava/lang/String;)V
    //   24: aload_3
    //   25: invokestatic 171	com/tencent/mobileqq/mini/cache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   28: return
    //   29: astore 4
    //   31: aload_3
    //   32: astore_2
    //   33: aload 4
    //   35: astore_3
    //   36: goto +7 -> 43
    //   39: astore_3
    //   40: aload 4
    //   42: astore_2
    //   43: aload_2
    //   44: invokestatic 171	com/tencent/mobileqq/mini/cache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	Editor
    //   0	49	1	paramInt	int
    //   0	49	2	paramString	String
    //   18	18	3	localObject1	Object
    //   39	9	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   29	12	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   19	24	29	finally
    //   3	19	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.DiskLruCache.Editor
 * JD-Core Version:    0.7.0.1
 */