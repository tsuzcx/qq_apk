package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IResourceLoaderDrawableApi
  extends QRouteApi
{
  public abstract int getDrawableId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IResourceLoaderDrawableApi
 * JD-Core Version:    0.7.0.1
 */