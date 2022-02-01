package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriDialogApi;
import com.tencent.mobileqq.gamecenter.ui.GameMsgAddFriendDialog;

public class GameMsgAddFriDialogApiImpl
  implements IGameMsgAddFriDialogApi
{
  private GameMsgAddFriendDialog dialog = new GameMsgAddFriendDialog();
  
  public void showDialog(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.dialog.a(paramAppInterface, paramActivity, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgAddFriDialogApiImpl
 * JD-Core Version:    0.7.0.1
 */