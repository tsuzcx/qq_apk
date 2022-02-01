package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.client.SaveTimeUpdater;
import com.tencent.mobileqq.writetogether.data.IEditorModel;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.UserStateBar;
import java.util.List;

class UserStateMachineController$11
  extends StateProcessor<UserState>
{
  UserStateMachineController$11(UserStateMachineController paramUserStateMachineController, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(UserState paramUserState)
  {
    super.a(paramUserState);
    UserStateMachineController.f(this.a).f();
    UserStateMachineController.c(this.a).j();
    UserStateMachineController.d(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.11
 * JD-Core Version:    0.7.0.1
 */