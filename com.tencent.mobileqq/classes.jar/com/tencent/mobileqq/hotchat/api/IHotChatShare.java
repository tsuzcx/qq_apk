package com.tencent.mobileqq.hotchat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHotChatShare
  extends QRouteApi
{
  public abstract void handleShare(IHotChatInfo paramIHotChatInfo);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IHotChatShare
 * JD-Core Version:    0.7.0.1
 */