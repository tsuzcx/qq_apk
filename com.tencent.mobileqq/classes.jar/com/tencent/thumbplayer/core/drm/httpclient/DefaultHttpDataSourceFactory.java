package com.tencent.thumbplayer.core.drm.httpclient;

import androidx.annotation.Nullable;

public final class DefaultHttpDataSourceFactory
  extends HttpDataSource.BaseFactory
{
  private final boolean allowCrossProtocolRedirects;
  private final int connectTimeoutMillis;
  @Nullable
  private final TransferListener listener;
  private final int readTimeoutMillis;
  private final String userAgent;
  
  public DefaultHttpDataSourceFactory(String paramString)
  {
    this(paramString, null);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramString, null, paramInt1, paramInt2, paramBoolean);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, @Nullable TransferListener paramTransferListener)
  {
    this(paramString, paramTransferListener, 8000, 8000, false);
  }
  
  public DefaultHttpDataSourceFactory(String paramString, @Nullable TransferListener paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.listener = paramTransferListener;
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
  }
  
  protected DefaultHttpDataSource createDataSourceInternal(int paramInt, HttpDataSource.RequestProperties paramRequestProperties)
  {
    paramRequestProperties = new DefaultHttpDataSource(this.userAgent, null, paramInt, paramInt, this.allowCrossProtocolRedirects, paramRequestProperties);
    TransferListener localTransferListener = this.listener;
    if (localTransferListener != null) {
      paramRequestProperties.addTransferListener(localTransferListener);
    }
    return paramRequestProperties;
  }
  
  protected DefaultHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties paramRequestProperties)
  {
    paramRequestProperties = new DefaultHttpDataSource(this.userAgent, null, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, paramRequestProperties);
    TransferListener localTransferListener = this.listener;
    if (localTransferListener != null) {
      paramRequestProperties.addTransferListener(localTransferListener);
    }
    return paramRequestProperties;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DefaultHttpDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */