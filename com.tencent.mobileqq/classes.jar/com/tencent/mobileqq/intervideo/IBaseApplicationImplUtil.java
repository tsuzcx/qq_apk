package com.tencent.mobileqq.intervideo;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IBaseApplicationImplUtil
  extends QRouteApi
{
  public abstract Context getContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IBaseApplicationImplUtil
 * JD-Core Version:    0.7.0.1
 */