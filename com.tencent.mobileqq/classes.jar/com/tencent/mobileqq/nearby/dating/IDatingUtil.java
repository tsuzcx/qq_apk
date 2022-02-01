package com.tencent.mobileqq.nearby.dating;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDatingUtil
  extends QRouteApi
{
  public abstract void updateConfigurableShowloveWord(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.dating.IDatingUtil
 * JD-Core Version:    0.7.0.1
 */