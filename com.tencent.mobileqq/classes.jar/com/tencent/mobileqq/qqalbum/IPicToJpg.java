package com.tencent.mobileqq.qqalbum;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPicToJpg
  extends QRouteApi
{
  public static final String TAG = "PicToJpg";
  
  public abstract boolean picToJpg(PicData paramPicData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqalbum.IPicToJpg
 * JD-Core Version:    0.7.0.1
 */