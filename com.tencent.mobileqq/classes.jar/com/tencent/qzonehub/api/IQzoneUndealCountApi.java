package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneUndealCountApi
  extends QRouteApi
{
  public static final String UNDEALCOUNT_FEEDALERT_LAST_GET_TIME = "getMapLastGetTime";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneUndealCountApi
 * JD-Core Version:    0.7.0.1
 */