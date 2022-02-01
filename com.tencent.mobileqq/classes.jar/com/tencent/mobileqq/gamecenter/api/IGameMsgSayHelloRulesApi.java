package com.tencent.mobileqq.gamecenter.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;

@QAPI(process={""})
@QRouteFactory(singleton=false)
public abstract interface IGameMsgSayHelloRulesApi
  extends QRouteApi
{
  public abstract void doInit(int paramInt1, AppInterface paramAppInterface, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, List<ChatMessage> paramList);
  
  public abstract boolean isAbleToAction();
  
  public abstract void onMsgUpdate(MessageRecord paramMessageRecord);
  
  public abstract void recordAction();
  
  public abstract void updateRelation(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgSayHelloRulesApi
 * JD-Core Version:    0.7.0.1
 */