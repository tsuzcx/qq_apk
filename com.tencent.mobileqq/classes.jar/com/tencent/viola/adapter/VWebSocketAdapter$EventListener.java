package com.tencent.viola.adapter;

public abstract interface VWebSocketAdapter$EventListener
{
  public abstract void onClose(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onError(String paramString);
  
  public abstract void onMessage(String paramString);
  
  public abstract void onOpen();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.adapter.VWebSocketAdapter.EventListener
 * JD-Core Version:    0.7.0.1
 */