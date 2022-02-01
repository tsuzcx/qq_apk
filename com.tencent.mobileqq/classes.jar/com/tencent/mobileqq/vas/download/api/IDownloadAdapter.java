package com.tencent.mobileqq.vas.download.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.DownloadTask;

@QAPI(process={"all"})
public abstract interface IDownloadAdapter
  extends QRouteApi
{
  public abstract void vipReportCgi(DownloadTask paramDownloadTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.download.api.IDownloadAdapter
 * JD-Core Version:    0.7.0.1
 */