package com.tencent.mobileqq.qipc.api;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface QIPCApiCallback
{
  public abstract void onCallback(QIPCApiResult paramQIPCApiResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.QIPCApiCallback
 * JD-Core Version:    0.7.0.1
 */