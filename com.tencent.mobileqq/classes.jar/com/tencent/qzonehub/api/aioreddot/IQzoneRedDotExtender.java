package com.tencent.qzonehub.api.aioreddot;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneRedDotExtender
  extends QRouteApi
{
  public abstract Object getQzoneRedDotExtender(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.aioreddot.IQzoneRedDotExtender
 * JD-Core Version:    0.7.0.1
 */