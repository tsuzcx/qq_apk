package com.tencent.mqpsdk;

public abstract interface INetTransportProvider
{
  public abstract INetTransportProvider.INetTransportCodec getCodec(String paramString);
  
  public abstract int send(Object paramObject);
  
  public abstract void setNetTransportEventListener(String paramString, INetTransportProvider.INetTransportEventListener paramINetTransportEventListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqpsdk.INetTransportProvider
 * JD-Core Version:    0.7.0.1
 */