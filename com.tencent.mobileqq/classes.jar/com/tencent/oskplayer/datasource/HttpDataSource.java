package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.util.Predicate;
import java.util.List;
import java.util.Map;

public abstract interface HttpDataSource
  extends UriDataSource
{
  public abstract void clearAllRequestProperties();
  
  public abstract void clearRequestProperty(String paramString);
  
  public abstract void close();
  
  public abstract long getContentLength();
  
  public abstract Predicate<String> getContentPredicator();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public abstract long getTotalLength();
  
  public abstract long open(DataSpec paramDataSpec);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */