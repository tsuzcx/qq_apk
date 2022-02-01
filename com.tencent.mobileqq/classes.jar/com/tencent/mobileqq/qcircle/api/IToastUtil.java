package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IToastUtil
  extends QRouteApi
{
  public abstract void determineShowByCode(long paramLong, Context paramContext, int paramInt1, String paramString, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IToastUtil
 * JD-Core Version:    0.7.0.1
 */