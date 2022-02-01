package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;

class UserStateMachineController$1$1
  implements Runnable
{
  UserStateMachineController$1$1(UserStateMachineController.1 param1) {}
  
  public void run()
  {
    if (!WriteTogetherUtils.a(UserStateMachineController.a(this.a.a))) {}
    for (int i = 1; UserStateMachineController.a(this.a.a).a() == UserState.COMMIT_WHILE_ALERT; i = 0)
    {
      UserStateMachineController.a(this.a.a).a(UserState.SAVING);
      return;
    }
    if (UserStateMachineController.a(this.a.a).a() == UserState.ACCEPT_WHILE_ALERT)
    {
      UserStateMachineController.a(this.a.a).a(UserState.LAST_SAVE);
      return;
    }
    StateMachine localStateMachine = UserStateMachineController.a(this.a.a);
    if (i != 0) {}
    for (UserState localUserState = UserState.LAST_EDIT;; localUserState = UserState.NEW_DOC)
    {
      localStateMachine.a(localUserState);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.1.1
 * JD-Core Version:    0.7.0.1
 */