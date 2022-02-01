package com.tencent.mobileqq.guild.message.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IGuildRoamMessageHandler
  extends QRouteApi
{
  public abstract boolean reqPullRoamMsg(String paramString, long paramLong1, long paramLong2, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler
 * JD-Core Version:    0.7.0.1
 */