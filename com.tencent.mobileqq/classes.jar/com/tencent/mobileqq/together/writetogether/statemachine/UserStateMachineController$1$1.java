package com.tencent.mobileqq.together.writetogether.statemachine;

import bemv;
import beoy;
import beoz;
import bepl;

public class UserStateMachineController$1$1
  implements Runnable
{
  public UserStateMachineController$1$1(beoz parambeoz) {}
  
  public void run()
  {
    if (!bemv.a(beoy.a(this.a.a))) {}
    for (int i = 1; beoy.a(this.a.a).a() == UserState.COMMIT_WHILE_ALERT; i = 0)
    {
      beoy.a(this.a.a).a(UserState.SAVING);
      return;
    }
    if (beoy.a(this.a.a).a() == UserState.ACCEPT_WHILE_ALERT)
    {
      beoy.a(this.a.a).a(UserState.LAST_SAVE);
      return;
    }
    bepl localbepl = beoy.a(this.a.a);
    if (i != 0) {}
    for (UserState localUserState = UserState.LAST_EDIT;; localUserState = UserState.NEW_DOC)
    {
      localbepl.a(localUserState);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.statemachine.UserStateMachineController.1.1
 * JD-Core Version:    0.7.0.1
 */