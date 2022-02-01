package com.tencent.mobileqq.troop.createtroopblacklist.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ICreateTroopBlackListUtilApi
  extends QRouteApi
{
  public abstract boolean checkAndHandleCreateGroupBlackListResult(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi
 * JD-Core Version:    0.7.0.1
 */