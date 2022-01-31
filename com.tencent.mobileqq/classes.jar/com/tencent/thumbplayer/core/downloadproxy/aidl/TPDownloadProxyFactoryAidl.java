package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.IInterface;

public abstract interface TPDownloadProxyFactoryAidl
  extends IInterface
{
  public abstract String getNativeVersion();
  
  public abstract ITPDownloadProxyAidl getTPDownloadProxy(int paramInt);
  
  public abstract boolean isReadyForDownload();
  
  public abstract boolean isReadyForPlay();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
 * JD-Core Version:    0.7.0.1
 */