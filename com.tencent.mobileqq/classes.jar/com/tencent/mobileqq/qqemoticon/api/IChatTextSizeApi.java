package com.tencent.mobileqq.qqemoticon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IChatTextSizeApi
  extends QRouteApi
{
  public abstract int getChatTextSizeWithDP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.IChatTextSizeApi
 * JD-Core Version:    0.7.0.1
 */