package com.tencent.mobileqq.conditionsearch;

import anrz;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ConditionSearchFriendActivity$1
  implements Runnable
{
  ConditionSearchFriendActivity$1(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_Anrz.d();
    int[] arrayOfInt = this.this$0.jdField_a_of_type_Anrz.a();
    this.this$0.b = arrayOfInt[0];
    this.this$0.c = arrayOfInt[1];
    this.this$0.f = ConditionSearchFriendActivity.a(this.this$0, arrayOfInt[0]);
    this.this$0.g = ConditionSearchFriendActivity.a(this.this$0, arrayOfInt[1]);
    ThreadManager.getUIHandler().post(new ConditionSearchFriendActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */