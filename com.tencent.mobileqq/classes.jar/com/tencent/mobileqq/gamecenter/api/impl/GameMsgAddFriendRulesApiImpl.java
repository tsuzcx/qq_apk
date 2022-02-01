package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriendRulesApi;
import com.tencent.mobileqq.gamecenter.utils.GameMsgAddFriendRules;

public class GameMsgAddFriendRulesApiImpl
  implements IGameMsgAddFriendRulesApi
{
  private GameMsgAddFriendRules mInstance;
  
  public void doInit(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.mInstance = new GameMsgAddFriendRules(paramAppInterface, paramString1, paramString2, paramInt);
  }
  
  public boolean isAbleToAction()
  {
    GameMsgAddFriendRules localGameMsgAddFriendRules = this.mInstance;
    if (localGameMsgAddFriendRules == null) {
      return false;
    }
    return localGameMsgAddFriendRules.b();
  }
  
  public void recordAction()
  {
    GameMsgAddFriendRules localGameMsgAddFriendRules = this.mInstance;
    if (localGameMsgAddFriendRules != null) {
      localGameMsgAddFriendRules.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgAddFriendRulesApiImpl
 * JD-Core Version:    0.7.0.1
 */