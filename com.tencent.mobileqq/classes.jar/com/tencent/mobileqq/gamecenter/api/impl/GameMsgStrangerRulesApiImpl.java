package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgStrangerRulesApi;
import com.tencent.mobileqq.gamecenter.utils.GameMsgStrangerRules;

public class GameMsgStrangerRulesApiImpl
  implements IGameMsgStrangerRulesApi
{
  private GameMsgStrangerRules mInstance;
  
  public void doInit(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    this.mInstance = new GameMsgStrangerRules(paramAppInterface, paramString, paramInt);
  }
  
  public boolean isAbleToAction()
  {
    GameMsgStrangerRules localGameMsgStrangerRules = this.mInstance;
    if (localGameMsgStrangerRules != null) {
      return localGameMsgStrangerRules.a();
    }
    return false;
  }
  
  public void recordAction()
  {
    GameMsgStrangerRules localGameMsgStrangerRules = this.mInstance;
    if (localGameMsgStrangerRules != null) {
      localGameMsgStrangerRules.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgStrangerRulesApiImpl
 * JD-Core Version:    0.7.0.1
 */