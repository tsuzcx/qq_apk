package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHuayangCrashReport
  extends QRouteApi
{
  public abstract void handleReport(Throwable paramThrowable);
  
  public abstract void report(Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport
 * JD-Core Version:    0.7.0.1
 */