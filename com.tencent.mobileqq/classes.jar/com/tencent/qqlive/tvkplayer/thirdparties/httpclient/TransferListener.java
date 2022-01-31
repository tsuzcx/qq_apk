package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

public abstract interface TransferListener
{
  public abstract void onBytesTransferred(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean, int paramInt);
  
  public abstract void onTransferEnd(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean);
  
  public abstract void onTransferInitializing(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean);
  
  public abstract void onTransferStart(DataSource paramDataSource, DataSpec paramDataSpec, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.TransferListener
 * JD-Core Version:    0.7.0.1
 */