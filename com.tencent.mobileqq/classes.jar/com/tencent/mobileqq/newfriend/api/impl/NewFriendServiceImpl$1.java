package com.tencent.mobileqq.newfriend.api.impl;

import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import java.util.Comparator;

class NewFriendServiceImpl$1
  implements Comparator<NewFriendMessage>
{
  NewFriendServiceImpl$1(NewFriendServiceImpl paramNewFriendServiceImpl) {}
  
  public int a(NewFriendMessage paramNewFriendMessage1, NewFriendMessage paramNewFriendMessage2)
  {
    if ((!paramNewFriendMessage1.b()) && (paramNewFriendMessage2.b())) {
      return -1;
    }
    if ((paramNewFriendMessage1.b()) && (!paramNewFriendMessage2.b())) {
      return 1;
    }
    return (int)(paramNewFriendMessage2.d - paramNewFriendMessage1.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */