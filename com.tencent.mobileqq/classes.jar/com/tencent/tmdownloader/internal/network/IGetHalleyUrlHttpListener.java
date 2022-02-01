package com.tencent.tmdownloader.internal.network;

import com.tencent.tmassistant.common.jce.GetHalleyUrlReq;
import com.tencent.tmassistant.common.jce.GetHalleyUrlRsp;

public abstract interface IGetHalleyUrlHttpListener
{
  public abstract void onHalleyUrlHttpRequestFinish(GetHalleyUrlReq paramGetHalleyUrlReq, GetHalleyUrlRsp paramGetHalleyUrlRsp, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.network.IGetHalleyUrlHttpListener
 * JD-Core Version:    0.7.0.1
 */