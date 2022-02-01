package de.robv.android.xposed.services;

import java.io.InputStream;

public final class FileResult
{
  public final byte[] content;
  public final long mtime;
  public final long size;
  public final InputStream stream;
  
  FileResult(long paramLong1, long paramLong2)
  {
    this.content = null;
    this.stream = null;
    this.size = paramLong1;
    this.mtime = paramLong2;
  }
  
  FileResult(InputStream paramInputStream, long paramLong1, long paramLong2)
  {
    this.content = null;
    this.stream = paramInputStream;
    this.size = paramLong1;
    this.mtime = paramLong2;
  }
  
  FileResult(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    this.content = paramArrayOfByte;
    this.stream = null;
    this.size = paramLong1;
    this.mtime = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    if (this.content != null)
    {
      localStringBuilder.append("content.length: ");
      localStringBuilder.append(this.content.length);
      localStringBuilder.append(", ");
    }
    if (this.stream != null)
    {
      localStringBuilder.append("stream: ");
      localStringBuilder.append(this.stream.toString());
      localStringBuilder.append(", ");
    }
    localStringBuilder.append("size: ");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", mtime: ");
    localStringBuilder.append(this.mtime);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.services.FileResult
 * JD-Core Version:    0.7.0.1
 */