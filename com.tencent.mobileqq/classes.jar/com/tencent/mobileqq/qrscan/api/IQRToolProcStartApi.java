package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.IToolProcStart;

@QAPI(process={"all"})
public abstract interface IQRToolProcStartApi
  extends QRouteApi
{
  public abstract IToolProcStart get();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRToolProcStartApi
 * JD-Core Version:    0.7.0.1
 */