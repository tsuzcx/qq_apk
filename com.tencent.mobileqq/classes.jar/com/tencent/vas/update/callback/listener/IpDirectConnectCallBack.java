package com.tencent.vas.update.callback.listener;

import com.tencent.vas.update.entity.DownloadInfoParams;

public abstract interface IpDirectConnectCallBack
{
  public abstract void onPrepareIpDirectConnect(DownloadInfoParams paramDownloadInfoParams, IpDirectConnectCallBack.IGetDirectConnectIpsComplete paramIGetDirectConnectIpsComplete);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.callback.listener.IpDirectConnectCallBack
 * JD-Core Version:    0.7.0.1
 */