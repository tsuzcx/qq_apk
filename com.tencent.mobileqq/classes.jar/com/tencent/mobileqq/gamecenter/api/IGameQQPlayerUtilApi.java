package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IGameQQPlayerUtilApi
  extends QRouteApi
{
  public abstract String getMsgExtraString(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void openGameMsgAIO(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi
 * JD-Core Version:    0.7.0.1
 */