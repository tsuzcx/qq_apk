package com.tencent.mobileqq.qqemoticon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAppleEmojiManager
  extends QRouteApi
{
  public abstract String getAppleEmojiSpName();
  
  public abstract void reDownloadAppleEmoji();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.IAppleEmojiManager
 * JD-Core Version:    0.7.0.1
 */