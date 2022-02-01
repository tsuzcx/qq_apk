package com.tencent.mobileqq.gamecenter.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={""})
@QRouteFactory(singleton=false)
public abstract interface IGameMsgStrangerRulesApi
  extends QRouteApi
{
  public static final String GAME_MSG_SP_KEY_ADD_FRIEND_INFO = "game_msg_sp_key_add_friend_info_";
  public static final String GAME_MSG_SP_KEY_SAY_HELLO = "game_msg_sp_key_say_hello_";
  public static final String GAME_MSG_SP_KEY_SEND_MSG_WITHOUT_REPLY = "game_msg_sp_key_send_msg_without_reply_";
  
  public abstract void doInit(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract boolean isAbleToAction();
  
  public abstract void recordAction();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgStrangerRulesApi
 * JD-Core Version:    0.7.0.1
 */