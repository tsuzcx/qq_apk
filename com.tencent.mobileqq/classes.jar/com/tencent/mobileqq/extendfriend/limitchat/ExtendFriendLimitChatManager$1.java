package com.tencent.mobileqq.extendfriend.limitchat;

import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.LimitChatProtoStateMachine;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;

class ExtendFriendLimitChatManager$1
  extends ExtendFriendObserver
{
  ExtendFriendLimitChatManager$1(ExtendFriendLimitChatManager paramExtendFriendLimitChatManager) {}
  
  public void onCancleUnlimitMatch(boolean paramBoolean)
  {
    this.a.a().a(paramBoolean);
  }
  
  public void onUnLimitMatchPush(boolean paramBoolean, MatchInfo paramMatchInfo)
  {
    this.a.a().a(paramBoolean, paramMatchInfo);
  }
  
  public void onUnLimitMatchResponse(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    this.a.a().a(paramBoolean, paramInt, paramMatchInfo, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager.1
 * JD-Core Version:    0.7.0.1
 */