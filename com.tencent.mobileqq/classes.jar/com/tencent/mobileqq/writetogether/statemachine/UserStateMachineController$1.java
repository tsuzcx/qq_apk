package com.tencent.mobileqq.writetogether.statemachine;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import java.util.List;

class UserStateMachineController$1
  extends StateProcessor<UserState>
{
  UserStateMachineController$1(UserStateMachineController paramUserStateMachineController, UserState paramUserState, List paramList)
  {
    super(paramUserState, paramList);
  }
  
  public void a(UserState paramUserState)
  {
    paramUserState = this.a;
    if (!WriteTogetherUtils.a(UserStateMachineController.a(this.a))) {}
    for (boolean bool = true;; bool = false)
    {
      UserStateMachineController.a(paramUserState, bool);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new UserStateMachineController.1.1(this), 3000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController.1
 * JD-Core Version:    0.7.0.1
 */