package com.tencent.mobileqq.vas.font.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFontSoLoaderAdapter
  extends QRouteApi
{
  public abstract boolean isVipFontSoDownloaded();
  
  public abstract boolean isVipFontSoLoaded();
  
  public abstract boolean loadSo();
  
  public abstract void setVipFontSoLoad(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter
 * JD-Core Version:    0.7.0.1
 */