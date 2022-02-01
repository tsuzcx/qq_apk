package com.tencent.mobileqq.qcircle.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQCircleNativeFrameApi
  extends QRouteApi
{
  public abstract void enterNativePage(Bundle paramBundle);
  
  public abstract boolean isNewLayerMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
 * JD-Core Version:    0.7.0.1
 */