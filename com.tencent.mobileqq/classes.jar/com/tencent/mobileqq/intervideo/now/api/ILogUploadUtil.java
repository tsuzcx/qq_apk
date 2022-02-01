package com.tencent.mobileqq.intervideo.now.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ILogUploadUtil
  extends QRouteApi
{
  public abstract void upload(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.api.ILogUploadUtil
 * JD-Core Version:    0.7.0.1
 */