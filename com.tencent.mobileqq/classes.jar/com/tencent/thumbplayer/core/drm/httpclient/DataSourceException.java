package com.tencent.thumbplayer.core.drm.httpclient;

import java.io.IOException;

public final class DataSourceException
  extends IOException
{
  public static final int POSITION_OUT_OF_RANGE = 0;
  public final int reason;
  
  public DataSourceException(int paramInt)
  {
    this.reason = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DataSourceException
 * JD-Core Version:    0.7.0.1
 */