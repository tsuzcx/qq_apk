package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

public abstract class HttpDataSource$BaseFactory
  implements HttpDataSource.Factory
{
  private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
  
  @Deprecated
  public final void clearAllDefaultRequestProperties()
  {
    this.defaultRequestProperties.clear();
  }
  
  @Deprecated
  public final void clearDefaultRequestProperty(String paramString)
  {
    this.defaultRequestProperties.remove(paramString);
  }
  
  public final HttpDataSource createDataSource()
  {
    return createDataSourceInternal(this.defaultRequestProperties);
  }
  
  public final HttpDataSource createDataSource(int paramInt)
  {
    return createDataSourceInternal(paramInt, this.defaultRequestProperties);
  }
  
  protected abstract HttpDataSource createDataSourceInternal(int paramInt, HttpDataSource.RequestProperties paramRequestProperties);
  
  protected abstract HttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties paramRequestProperties);
  
  public final HttpDataSource.RequestProperties getDefaultRequestProperties()
  {
    return this.defaultRequestProperties;
  }
  
  @Deprecated
  public final void setDefaultRequestProperty(String paramString1, String paramString2)
  {
    this.defaultRequestProperties.set(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.BaseFactory
 * JD-Core Version:    0.7.0.1
 */