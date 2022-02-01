package com.tencent.mobileqq.dov.edit.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStartDovEditPic
  extends QRouteApi
{
  public abstract void enterCropActivity(Activity paramActivity, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dov.edit.api.IStartDovEditPic
 * JD-Core Version:    0.7.0.1
 */