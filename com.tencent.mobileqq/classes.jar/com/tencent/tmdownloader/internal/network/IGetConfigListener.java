package com.tencent.tmdownloader.internal.network;

import com.tencent.tmassistant.common.jce.GetConfigRequest;
import com.tencent.tmassistant.common.jce.GetConfigResponse;

public abstract interface IGetConfigListener
{
  public abstract void onPushConfigRequestFinish(GetConfigRequest paramGetConfigRequest, GetConfigResponse paramGetConfigResponse, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.network.IGetConfigListener
 * JD-Core Version:    0.7.0.1
 */