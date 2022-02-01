package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import eipc.EIPCCallback;

@QAPI(process={"all"})
public abstract interface IVasUpdateManager
  extends IVasManager
{
  public abstract <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> paramClass, String paramString, EIPCCallback paramEIPCCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasUpdateManager
 * JD-Core Version:    0.7.0.1
 */