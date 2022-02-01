package com.tencent.mobileqq.together.writetogether.statemachine;

import benq;
import bepx;
import bepy;
import beqk;

public class UserStateMachineController$1$1
  implements Runnable
{
  public UserStateMachineController$1$1(bepy parambepy) {}
  
  public void run()
  {
    if (!benq.a(bepx.a(this.a.a))) {}
    for (int i = 1; bepx.a(this.a.a).a() == UserState.COMMIT_WHILE_ALERT; i = 0)
    {
      bepx.a(this.a.a).a(UserState.SAVING);
      return;
    }
    if (bepx.a(this.a.a).a() == UserState.ACCEPT_WHILE_ALERT)
    {
      bepx.a(this.a.a).a(UserState.LAST_SAVE);
      return;
    }
    beqk localbeqk = bepx.a(this.a.a);
    if (i != 0) {}
    for (UserState localUserState = UserState.LAST_EDIT;; localUserState = UserState.NEW_DOC)
    {
      localbeqk.a(localUserState);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.statemachine.UserStateMachineController.1.1
 * JD-Core Version:    0.7.0.1
 */