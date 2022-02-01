package com.tencent.mobileqq.flutter.channel.expand.chat;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ExpandChatRepository$2
  extends FriendListObserver
{
  ExpandChatRepository$2(ExpandChatRepository paramExpandChatRepository) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.2.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.2
 * JD-Core Version:    0.7.0.1
 */