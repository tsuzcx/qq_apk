package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.friend.api.IFriendDataService;
import mqq.app.AppRuntime;

class OnLineStatusPresenter$1
  implements Runnable
{
  OnLineStatusPresenter$1(OnLineStatusPresenter paramOnLineStatusPresenter, IFriendDataService paramIFriendDataService, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    this.a.getFriend(this.b.getCurrentUin(), true, true, true);
    this.this$0.a("FriendsEntityNotLoad", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter.1
 * JD-Core Version:    0.7.0.1
 */