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
  
  public void doInit(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    this.mInstance = new GameMsgSendTimesRules(paramAppInterface, paramString, paramInt1, paramInt2, null, null, paramList);
  }
  
  public boolean isAbleToAction()
  {
    GameMsgSendTimesRules localGameMsgSendTimesRules = this.mInstance;
    if (localGameMsgSendTimesRules != null) {
      return localGameMsgSendTimesRules.a();
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
      localGameMsgSendTimesRules.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgSendTimesRulesApiImpl
 * JD-Core Version:    0.7.0.1
 */