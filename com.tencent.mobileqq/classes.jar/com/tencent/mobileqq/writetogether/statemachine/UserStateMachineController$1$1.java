package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;

class UserStateMachineController$1$1
  implements Runnable
{
  UserStateMachineController$1$1(UserStateMachineController.1 param1) {}
  
  public void run()
  {
    boolean bool = WriteTogetherUtils.b(UserStateMachineController.a(this.a.a));
    if (UserStateMachineController.b(this.a.a).a() == UserState.COMMIT_WHILE_ALERT)
    {
      UserStateMachineController.b(this.a.a).a(UserState.SAVING);
      return;
    }
    if (UserStateMachineController.b(this.a.a).a() == UserState.ACCEPT_WHILE_ALERT)
    {
      UserStateMachineController.b(this.a.a).a(UserState.LAST_SAVE);
      return;
    }
    StateMachine localStateMachine = UserStateMachineController.b(this.a.a);
    UserState localUserState;
    if ((bool ^ true)) {
      localUserState = UserState.LAST_EDIT;
    } else {
      localUserState = UserState.NEW_DOC;
    }
    localStateMachine.a(localUserState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.1.1
 * JD-Core Version:    0.7.0.1
 */