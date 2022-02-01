package com.tencent.mobileqq.guild.file.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildFileEntryApi
  extends QRouteApi
{
  public abstract boolean isShowEntry();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.config.api.IGuildFileEntryApi
 * JD-Core Version:    0.7.0.1
 */