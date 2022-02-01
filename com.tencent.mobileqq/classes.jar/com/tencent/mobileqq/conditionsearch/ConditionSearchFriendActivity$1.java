package com.tencent.mobileqq.conditionsearch;

import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ConditionSearchFriendActivity$1
  implements Runnable
{
  ConditionSearchFriendActivity$1(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((ConditionSearchFriendActivity)localObject).c = ((ConditionSearchFriendActivity)localObject).a.h();
    localObject = this.this$0.a.i();
    ConditionSearchFriendActivity localConditionSearchFriendActivity = this.this$0;
    localConditionSearchFriendActivity.d = localObject[0];
    localConditionSearchFriendActivity.e = localObject[1];
    localConditionSearchFriendActivity.h = ConditionSearchFriendActivity.a(localConditionSearchFriendActivity, localObject[0]);
    localConditionSearchFriendActivity = this.this$0;
    localConditionSearchFriendActivity.i = ConditionSearchFriendActivity.a(localConditionSearchFriendActivity, localObject[1]);
    ThreadManager.getUIHandler().post(new ConditionSearchFriendActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */