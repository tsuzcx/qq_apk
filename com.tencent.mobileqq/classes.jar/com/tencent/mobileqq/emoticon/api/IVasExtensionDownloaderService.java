package com.tencent.mobileqq.emoticon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.AbsDownloader;

@QAPI(process={"all"})
public abstract interface IVasExtensionDownloaderService
  extends QRouteApi
{
  public abstract AbsDownloader createVasExtensionDownloader();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.IVasExtensionDownloaderService
 * JD-Core Version:    0.7.0.1
 */