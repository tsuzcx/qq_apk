package com.tencent.mobileqq.dov.story.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAudioHelper
  extends QRouteApi
{
  public abstract boolean isHuaWeiGreen();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.IAudioHelper
 * JD-Core Version:    0.7.0.1
 */