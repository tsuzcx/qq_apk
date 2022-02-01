package com.tencent.mobileqq.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISecUtilApi
  extends QRouteApi
{
  public abstract String getFileMd5(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.ISecUtilApi
 * JD-Core Version:    0.7.0.1
 */