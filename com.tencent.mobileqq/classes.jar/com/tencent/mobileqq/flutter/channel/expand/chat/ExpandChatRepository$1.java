package com.tencent.mobileqq.flutter.channel.expand.chat;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

class ExpandChatRepository$1
  implements Observer
{
  ExpandChatRepository$1(ExpandChatRepository paramExpandChatRepository) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.1.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.1
 * JD-Core Version:    0.7.0.1
 */