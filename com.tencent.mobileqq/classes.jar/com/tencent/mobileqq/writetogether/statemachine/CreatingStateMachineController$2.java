package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.ITemplateWhenCreating;
import java.util.List;

class CreatingStateMachineController$2
  extends StateProcessor<CreatingState>
{
  CreatingStateMachineController$2(CreatingStateMachineController paramCreatingStateMachineController, CreatingState paramCreatingState, List paramList)
  {
    super(paramCreatingState, paramList);
  }
  
  public void a(CreatingState paramCreatingState)
  {
    super.a(paramCreatingState);
    if (CreatingStateMachineController.b(this.a).b() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      CreatingStateMachineController.a(this.a).c(true);
      return;
    }
    CreatingStateMachineController.a(this.a).c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.CreatingStateMachineController.2
 * JD-Core Version:    0.7.0.1
 */