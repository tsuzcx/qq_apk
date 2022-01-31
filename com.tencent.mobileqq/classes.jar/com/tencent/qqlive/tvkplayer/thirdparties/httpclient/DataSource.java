package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.net.Uri;
import android.support.annotation.Nullable;
import java.util.List;
import java.util.Map;

public abstract interface DataSource
{
  public abstract void addTransferListener(TransferListener paramTransferListener);
  
  public abstract void close();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  @Nullable
  public abstract Uri getUri();
  
  public abstract long open(DataSpec paramDataSpec);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.DataSource
 * JD-Core Version:    0.7.0.1
 */