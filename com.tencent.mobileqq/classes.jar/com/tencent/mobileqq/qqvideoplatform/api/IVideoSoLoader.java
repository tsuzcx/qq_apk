package com.tencent.mobileqq.qqvideoplatform.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;

@QAPI(process={"all"})
public abstract interface IVideoSoLoader
  extends QRouteApi
{
  public abstract boolean loadDownProxySync();
  
  public abstract void loadSo(LoadSoCallback paramLoadSoCallback);
  
  public abstract boolean loadTPCoreSync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
 * JD-Core Version:    0.7.0.1
 */