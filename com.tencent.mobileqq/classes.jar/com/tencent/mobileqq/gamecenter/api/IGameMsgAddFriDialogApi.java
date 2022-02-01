package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={""})
@QRouteFactory(singleton=false)
public abstract interface IGameMsgAddFriDialogApi
  extends QRouteApi
{
  public abstract void showDialog(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriDialogApi
 * JD-Core Version:    0.7.0.1
 */