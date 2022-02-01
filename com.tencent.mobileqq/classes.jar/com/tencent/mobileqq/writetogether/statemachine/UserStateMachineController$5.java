package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.UserStateBar;
import java.util.List;

class UserStateMachineController$5
  extends StateProcessor<UserState>
{
  UserStateMachineController$5(UserStateMachineController paramUserStateMachineController, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(UserState paramUserState)
  {
    UserStateMachineController.a(this.a).a();
    if (!UserStateMachineController.a(this.a).a()) {
      UserStateMachineController.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.5
 * JD-Core Version:    0.7.0.1
 */