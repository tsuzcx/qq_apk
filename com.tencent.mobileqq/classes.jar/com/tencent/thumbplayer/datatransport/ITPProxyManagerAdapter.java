package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public abstract interface ITPProxyManagerAdapter
{
  public abstract ITPDownloadProxy getDownloadProxy();
  
  public abstract void pushEvent(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.ITPProxyManagerAdapter
 * JD-Core Version:    0.7.0.1
 */