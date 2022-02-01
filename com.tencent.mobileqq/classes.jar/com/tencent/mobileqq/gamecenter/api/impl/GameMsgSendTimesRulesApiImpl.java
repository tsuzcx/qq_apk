package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgSendTimesRulesApi;
import com.tencent.mobileqq.gamecenter.utils.GameMsgSendTimesRules;
import java.util.List;

public class GameMsgSendTimesRulesApiImpl
  implements IGameMsgSendTimesRulesApi
{
  private GameMsgSendTimesRules mInstance;
  
  public void doInit(int paramInt1, AppInterface paramAppInterface, String paramString, int paramInt2, int paramInt3, List<ChatMessage> paramList)
  {
    this.mInstance = new GameMsgSendTimesRules(paramInt1, paramAppInterface, paramString, paramInt2, paramInt3, null, null, paramList);
  }
  
  public boolean isAbleToAction()
  {
    GameMsgSendTimesRules localGameMsgSendTimesRules = this.mInstance;
    if (localGameMsgSendTimesRules != null) {
      return localGameMsgSendTimesRules.b();
    }
    return false;
  }
  
  public boolean isSend3Tips(List<ChatMessage> paramList)
  {
    GameMsgSendTimesRules localGameMsgSendTimesRules = this.mInstance;
    if (localGameMsgSendTimesRules != null) {
      return localGameMsgSendTimesRules.a(paramList);
    }
    return false;
  }
  
  public void onMsgUpdate(MessageRecord paramMessageRecord)
  {
    GameMsgSendTimesRules localGameMsgSendTimesRules = this.mInstance;
    if (localGameMsgSendTimesRules != null) {
      localGameMsgSendTimesRules.a(paramMessageRecord);
    }
  }
  
  public void recordAction()
  {
    GameMsgSendTimesRules localGameMsgSendTimesRules = this.mInstance;
    if (localGameMsgSendTimesRules != null) {
      localGameMsgSendTimesRules.c();
    }
  }
  
  public void updateRelation(int paramInt)
  {
    GameMsgSendTimesRules localGameMsgSendTimesRules = this.mInstance;
    if (localGameMsgSendTimesRules != null) {
      localGameMsgSendTimesRules.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgSendTimesRulesApiImpl
 * JD-Core Version:    0.7.0.1
 */