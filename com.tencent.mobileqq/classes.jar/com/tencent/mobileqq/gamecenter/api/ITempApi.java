package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITempApi
  extends QRouteApi
{
  public abstract void addTinySessionKey(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public abstract Intent getIntentFromMsg(Context paramContext, Message paramMessage, AppInterface paramAppInterface);
  
  public abstract void refreshAppBadge(AppInterface paramAppInterface);
  
  public abstract void updateRecentList(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.ITempApi
 * JD-Core Version:    0.7.0.1
 */