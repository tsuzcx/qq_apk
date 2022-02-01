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
    ((ConditionSearchFriendActivity)localObject).jdField_a_of_type_Int = ((ConditionSearchFriendActivity)localObject).jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d();
    localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    ConditionSearchFriendActivity localConditionSearchFriendActivity = this.this$0;
    localConditionSearchFriendActivity.b = localObject[0];
    localConditionSearchFriendActivity.c = localObject[1];
    localConditionSearchFriendActivity.f = ConditionSearchFriendActivity.a(localConditionSearchFriendActivity, localObject[0]);
    localConditionSearchFriendActivity = this.this$0;
    localConditionSearchFriendActivity.g = ConditionSearchFriendActivity.a(localConditionSearchFriendActivity, localObject[1]);
    ThreadManager.getUIHandler().post(new ConditionSearchFriendActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */