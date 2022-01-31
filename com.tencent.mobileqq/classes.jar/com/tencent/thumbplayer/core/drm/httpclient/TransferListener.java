package com.tencent.thumbplayer.core.drm.httpclient;

public abstract interface TransferListener
{
  public abstract void onBytesTransferred(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean, int paramInt);
  
  public abstract void onTransferEnd(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean);
  
  public abstract void onTransferInitializing(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean);
  
  public abstract void onTransferStart(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.TransferListener
 * JD-Core Version:    0.7.0.1
 */