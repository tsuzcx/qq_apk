package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildPtvPanelApi
  extends QRouteApi
{
  public abstract void doShowPtvGuild(Context paramContext, boolean paramBoolean, Bundle paramBundle, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildPtvPanelApi
 * JD-Core Version:    0.7.0.1
 */