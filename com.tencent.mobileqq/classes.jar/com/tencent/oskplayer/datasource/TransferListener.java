package com.tencent.oskplayer.datasource;

public abstract interface TransferListener
{
  public abstract void onBytesTransferred(int paramInt);
  
  public abstract void onTransferEnd();
  
  public abstract void onTransferStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.TransferListener
 * JD-Core Version:    0.7.0.1
 */