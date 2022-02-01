package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

public abstract interface HttpDataSource$Factory
  extends DataSource.Factory
{
  @Deprecated
  public abstract void clearAllDefaultRequestProperties();
  
  @Deprecated
  public abstract void clearDefaultRequestProperty(String paramString);
  
  public abstract HttpDataSource createDataSource();
  
  public abstract HttpDataSource createDataSource(int paramInt);
  
  public abstract HttpDataSource.RequestProperties getDefaultRequestProperties();
  
  @Deprecated
  public abstract void setDefaultRequestProperty(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.Factory
 * JD-Core Version:    0.7.0.1
 */