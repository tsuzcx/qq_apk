package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import java.util.List;

class UserStateMachineController$7
  extends StateProcessor<UserState>
{
  UserStateMachineController$7(UserStateMachineController paramUserStateMachineController, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(UserState paramUserState)
  {
    UserStateMachineController.b(this.a);
    UserStateMachineController.a(this.a).a();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.7
 * JD-Core Version:    0.7.0.1
 */