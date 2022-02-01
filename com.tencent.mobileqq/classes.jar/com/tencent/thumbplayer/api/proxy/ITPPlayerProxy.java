package com.tencent.thumbplayer.api.proxy;

public abstract interface ITPPlayerProxy
{
  public abstract void pushEvent(int paramInt);
  
  public abstract void setIsActive(boolean paramBoolean);
  
  public abstract void setProxyServiceType(int paramInt);
  
  public abstract void setTPPlayerProxyListener(ITPPlayerProxyListener paramITPPlayerProxyListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
 * JD-Core Version:    0.7.0.1
 */