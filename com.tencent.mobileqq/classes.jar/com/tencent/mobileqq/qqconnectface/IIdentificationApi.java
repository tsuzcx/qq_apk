package com.tencent.mobileqq.qqconnectface;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

@QAPI(process={"all"})
public abstract interface IIdentificationApi
  extends QRouteApi
{
  public abstract WebViewPlugin createIdentificationPlugin();
  
  public abstract Class<?> getDeleteFaceFragment();
  
  public abstract QIPCModule getIdentityIpcServer();
  
  public abstract void preResDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.IIdentificationApi
 * JD-Core Version:    0.7.0.1
 */