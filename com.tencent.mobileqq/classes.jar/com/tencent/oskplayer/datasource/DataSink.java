package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.proxy.FileType;

public abstract interface DataSink
{
  public abstract void close();
  
  public abstract String getLogTag();
  
  public abstract DataSink open(DataSpec paramDataSpec, long paramLong, FileType paramFileType);
  
  public abstract void setLogTag(String paramString);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DataSink
 * JD-Core Version:    0.7.0.1
 */