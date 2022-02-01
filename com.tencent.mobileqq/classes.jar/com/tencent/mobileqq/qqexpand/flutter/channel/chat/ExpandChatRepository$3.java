package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

class ExpandChatRepository$3
  implements Observer
{
  ExpandChatRepository$3(ExpandChatRepository paramExpandChatRepository) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.3.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.3
 * JD-Core Version:    0.7.0.1
 */