package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.io.IOException;

public class HttpDataSource$HttpDataSourceException
  extends IOException
{
  public static final int TYPE_CLOSE = 3;
  public static final int TYPE_OPEN = 1;
  public static final int TYPE_READ = 2;
  public final DataSpec dataSpec;
  public final int type;
  
  public HttpDataSource$HttpDataSourceException(DataSpec paramDataSpec, int paramInt)
  {
    this.dataSpec = paramDataSpec;
    this.type = paramInt;
  }
  
  public HttpDataSource$HttpDataSourceException(IOException paramIOException, DataSpec paramDataSpec, int paramInt)
  {
    super(paramIOException);
    this.dataSpec = paramDataSpec;
    this.type = paramInt;
  }
  
  public HttpDataSource$HttpDataSourceException(String paramString, DataSpec paramDataSpec, int paramInt)
  {
    super(paramString);
    this.dataSpec = paramDataSpec;
    this.type = paramInt;
  }
  
  public HttpDataSource$HttpDataSourceException(String paramString, IOException paramIOException, DataSpec paramDataSpec, int paramInt)
  {
    super(paramString, paramIOException);
    this.dataSpec = paramDataSpec;
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.HttpDataSourceException
 * JD-Core Version:    0.7.0.1
 */