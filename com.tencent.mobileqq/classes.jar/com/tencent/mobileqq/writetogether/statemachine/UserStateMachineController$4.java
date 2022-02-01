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
    a((UserState)UserStateMachineController.b(this.a).b());
  }
  
  public void a(UserState paramUserState)
  {
    UserStateMachineController.c(this.a).b();
    if (UserStateMachineController.c(this.a).c()) {
      UserStateMachineController.c(this.a).e();
    }
    UserStateMachineController.c(this.a).a(WriteTogetherUtils.c(UserStateMachineController.e(this.a).getString(2131917809), UserStateMachineController.f(this.a).i()), 0);
    UserStateMachineController.c(this.a).k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.4
 * JD-Core Version:    0.7.0.1
 */