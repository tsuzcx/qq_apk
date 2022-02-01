package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.client.SaveTimeUpdater;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.UserStateBar;
import java.util.List;

class UserStateMachineController$3
  extends StateProcessor<UserState>
{
  UserStateMachineController$3(UserStateMachineController paramUserStateMachineController, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(UserState paramUserState)
  {
    UserStateMachineController.a(this.a).i();
    UserStateMachineController.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.3
 * JD-Core Version:    0.7.0.1
 */