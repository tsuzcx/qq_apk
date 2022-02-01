package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.proxy.FileType;

public abstract interface DataSource
{
  public abstract long available();
  
  public abstract void close();
  
  public abstract FileType getFileType();
  
  public abstract String getLogTag();
  
  public abstract long getTotalLength();
  
  public abstract long open(DataSpec paramDataSpec);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void setLogTag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DataSource
 * JD-Core Version:    0.7.0.1
 */