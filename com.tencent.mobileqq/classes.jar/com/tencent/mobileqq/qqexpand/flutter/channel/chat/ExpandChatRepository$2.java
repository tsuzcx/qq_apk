package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ExpandChatRepository$2
  extends FriendListObserver
{
  ExpandChatRepository$2(ExpandChatRepository paramExpandChatRepository) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.2.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.2
 * JD-Core Version:    0.7.0.1
 */