package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDynamicNowManagerApi
  extends QRouteApi
{
  public abstract void addJumpCallback();
  
  public abstract void beginLive(Bundle paramBundle);
  
  public abstract int getFirstByFrom(String paramString);
  
  public abstract AppInterface getQQAppInterface();
  
  public abstract boolean isAppInstalled();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi
 * JD-Core Version:    0.7.0.1
 */