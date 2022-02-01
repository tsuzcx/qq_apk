package com.tencent.mobileqq.dov.story.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISVParamManager
  extends QRouteApi
{
  public abstract int getBitRate(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.ISVParamManager
 * JD-Core Version:    0.7.0.1
 */