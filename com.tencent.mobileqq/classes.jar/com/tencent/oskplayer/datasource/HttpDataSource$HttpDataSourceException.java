package com.tencent.oskplayer.datasource;

import java.io.IOException;

public class HttpDataSource$HttpDataSourceException
  extends IOException
{
  public final DataSpec dataSpec;
  
  public HttpDataSource$HttpDataSourceException(DataSpec paramDataSpec)
  {
    this.dataSpec = paramDataSpec;
  }
  
  public HttpDataSource$HttpDataSourceException(IOException paramIOException, DataSpec paramDataSpec)
  {
    super(paramIOException);
    this.dataSpec = paramDataSpec;
  }
  
  public HttpDataSource$HttpDataSourceException(String paramString, DataSpec paramDataSpec)
  {
    super(paramString);
    this.dataSpec = paramDataSpec;
  }
  
  public HttpDataSource$HttpDataSourceException(String paramString, IOException paramIOException, DataSpec paramDataSpec)
  {
    super(paramString, paramIOException);
    this.dataSpec = paramDataSpec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.HttpDataSource.HttpDataSourceException
 * JD-Core Version:    0.7.0.1
 */