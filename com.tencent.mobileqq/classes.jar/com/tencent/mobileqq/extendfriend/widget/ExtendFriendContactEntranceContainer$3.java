package com.tencent.mobileqq.extendfriend.widget;

import com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

class ExtendFriendContactEntranceContainer$3
  implements Runnable
{
  ExtendFriendContactEntranceContainer$3(ExtendFriendContactEntranceContainer paramExtendFriendContactEntranceContainer, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ((IEntryExtendForbiddenUtils)QRoute.api(IEntryExtendForbiddenUtils.class)).getForbiddenInfo(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer.3
 * JD-Core Version:    0.7.0.1
 */