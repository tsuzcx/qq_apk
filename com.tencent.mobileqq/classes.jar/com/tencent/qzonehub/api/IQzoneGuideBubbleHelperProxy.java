package com.tencent.qzonehub.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneGuideBubbleHelperProxy
  extends QRouteApi
{
  public abstract void setX(View paramView, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneGuideBubbleHelperProxy
 * JD-Core Version:    0.7.0.1
 */