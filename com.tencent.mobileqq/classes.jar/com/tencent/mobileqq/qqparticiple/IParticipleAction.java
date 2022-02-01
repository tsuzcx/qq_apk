package com.tencent.mobileqq.qqparticiple;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IParticipleAction
  extends QRouteApi
{
  public abstract void participleTheContent(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqparticiple.IParticipleAction
 * JD-Core Version:    0.7.0.1
 */