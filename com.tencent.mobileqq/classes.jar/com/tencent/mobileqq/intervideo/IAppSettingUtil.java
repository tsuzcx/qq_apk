package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAppSettingUtil
  extends QRouteApi
{
  public abstract String getSubVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IAppSettingUtil
 * JD-Core Version:    0.7.0.1
 */