package com.tencent.mobileqq.search.api;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMessageFacadeFetcher
  extends QRouteApi
{
  public abstract Message getLastMessage(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.IMessageFacadeFetcher
 * JD-Core Version:    0.7.0.1
 */