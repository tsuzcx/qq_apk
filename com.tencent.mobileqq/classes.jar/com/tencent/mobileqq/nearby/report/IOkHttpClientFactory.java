package com.tencent.mobileqq.nearby.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import okhttp3.OkHttpClient;

@QAPI(process={"all"})
public abstract interface IOkHttpClientFactory
  extends QRouteApi
{
  public abstract OkHttpClient getRequestClient();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.IOkHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */