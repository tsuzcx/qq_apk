package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgSayHelloRulesApi;
import com.tencent.mobileqq.gamecenter.utils.GameMsgSayHelloRules;
import java.util.List;

public class GameMsgSayHelloRulesApiImpl
  implements IGameMsgSayHelloRulesApi
{
  private GameMsgSayHelloRules mInstance;
  
  public void doInit(AppInterface paramAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, List<ChatMessage> paramList)
  {
    this.mInstance = new GameMsgSayHelloRules(paramAppInterface, paramString1, paramInt1, paramInt2, paramString2, paramString3, paramList);
  }
  
  public boolean isAbleToAction()
  {
    GameMsgSayHelloRules localGameMsgSayHelloRules = this.mInstance;
    if (localGameMsgSayHelloRules != null) {
      return localGameMsgSayHelloRules.a();
    }
    return false;
  }
  
  public void onMsgUpdate(MessageRecord paramMessageRecord)
  {
    GameMsgSayHelloRules localGameMsgSayHelloRules = this.mInstance;
    if (localGameMsgSayHelloRules != null) {
      localGameMsgSayHelloRules.a(paramMessageRecord);
    }
  }
  
  public void recordAction()
  {
    GameMsgSayHelloRules localGameMsgSayHelloRules = this.mInstance;
    if (localGameMsgSayHelloRules != null) {
      localGameMsgSayHelloRules.b();
    }
  }
  
  public void updateRelation(int paramInt)
  {
    GameMsgSayHelloRules localGameMsgSayHelloRules = this.mInstance;
    if (localGameMsgSayHelloRules != null) {
      localGameMsgSayHelloRules.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgSayHelloRulesApiImpl
 * JD-Core Version:    0.7.0.1
 */