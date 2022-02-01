package com.tencent.mobileqq.nearby.gameroom;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.QQCustomDialog;

@QAPI(process={"all"})
public abstract interface IGameRoomUtilsDelegate
  extends QRouteApi
{
  public abstract void enterNewGame(Context paramContext, int paramInt);
  
  public abstract void gotoGameChatPie(Context paramContext, Object paramObject, int paramInt, String paramString1, String paramString2);
  
  public abstract QQCustomDialog showConfirmDialog(Context paramContext, String paramString1, String paramString2);
  
  public abstract QQCustomDialog showCreateNewGameDialog(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void showErrorCodeDialog(Context paramContext, int paramInt1, String paramString, int paramInt2);
  
  public abstract QQCustomDialog showMyInviteDialog(Activity paramActivity, String paramString, int paramInt);
  
  public abstract QQCustomDialog showMyInviteDialog(Activity paramActivity, String paramString, int paramInt, long paramLong);
  
  public abstract QQCustomDialog showTeamExistDialog(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.IGameRoomUtilsDelegate
 * JD-Core Version:    0.7.0.1
 */