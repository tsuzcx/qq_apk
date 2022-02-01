package com.tencent.mobileqq.chat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IChatActivityApi
  extends QRouteApi
{
  public abstract int FORWARD_REQUEST();
  
  public abstract String KEY_AIO_MSG_SOURCE();
  
  public abstract String OPEN_CHAT_FRAGMENT();
  
  public abstract int TYPE_DETAIL_MSG_REMIND();
  
  public abstract Class getChatActivityClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.api.IChatActivityApi
 * JD-Core Version:    0.7.0.1
 */