package com.tencent.mobileqq.mini.cache;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class DiskLruCache$Editor$FaultHidingOutputStream
  extends FilterOutputStream
{
  private DiskLruCache$Editor$FaultHidingOutputStream(DiskLruCache.Editor paramEditor, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void close()
  {
    try
    {
      this.out.close();
      return;
    }
    catch (IOException localIOException)
    {
      DiskLruCache.Editor.access$2302(this.this$1, true);
    }
  }
  
  public void flush()
  {
    try
    {
      this.out.flush();
      return;
    }
    catch (IOException localIOException)
    {
      DiskLruCache.Editor.access$2302(this.this$1, true);
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      this.out.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      DiskLruCache.Editor.access$2302(this.this$1, true);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      DiskLruCache.Editor.access$2302(this.this$1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.DiskLruCache.Editor.FaultHidingOutputStream
 * JD-Core Version:    0.7.0.1
 */