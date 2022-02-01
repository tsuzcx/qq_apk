package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyAppInterfaceUtils
  extends QRouteApi
{
  public abstract void freePartBitmapCache();
  
  public abstract boolean issEnableFreshPreload();
  
  public abstract boolean issEnableFreshStaticLayout();
  
  public abstract void setsEnableFreshPreload(boolean paramBoolean);
  
  public abstract void setsEnableFreshStaticLayout(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyAppInterfaceUtils
 * JD-Core Version:    0.7.0.1
 */