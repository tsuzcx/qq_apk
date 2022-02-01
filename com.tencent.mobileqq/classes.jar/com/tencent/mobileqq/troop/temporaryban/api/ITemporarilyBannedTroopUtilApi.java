package com.tencent.mobileqq.troop.temporaryban.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ITemporarilyBannedTroopUtilApi
  extends QRouteApi
{
  public abstract boolean checkTemporarilyBannedTroop(Context paramContext, AppInterface paramAppInterface, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.api.ITemporarilyBannedTroopUtilApi
 * JD-Core Version:    0.7.0.1
 */