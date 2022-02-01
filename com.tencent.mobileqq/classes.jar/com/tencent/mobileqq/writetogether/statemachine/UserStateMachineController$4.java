package com.tencent.mobileqq.writetogether.statemachine;

import android.content.Context;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.data.IEditorModel;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.UserStateBar;
import java.util.List;

class UserStateMachineController$4
  extends StateProcessor<UserState>
{
  UserStateMachineController$4(UserStateMachineController paramUserStateMachineController, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a((UserState)UserStateMachineController.a(this.a).b());
  }
  
  public void a(UserState paramUserState)
  {
    UserStateMachineController.a(this.a).b();
    if (UserStateMachineController.a(this.a).a()) {
      UserStateMachineController.a(this.a).d();
    }
    UserStateMachineController.a(this.a).a(WriteTogetherUtils.c(UserStateMachineController.a(this.a).getString(2131720179), UserStateMachineController.a(this.a).a()), 0);
    UserStateMachineController.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.4
 * JD-Core Version:    0.7.0.1
 */