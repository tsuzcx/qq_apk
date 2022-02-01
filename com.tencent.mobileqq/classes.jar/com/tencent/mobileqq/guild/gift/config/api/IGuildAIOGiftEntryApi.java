package com.tencent.mobileqq.guild.gift.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildAIOGiftEntryApi
  extends QRouteApi
{
  public abstract boolean isShowEntry(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.gift.config.api.IGuildAIOGiftEntryApi
 * JD-Core Version:    0.7.0.1
 */