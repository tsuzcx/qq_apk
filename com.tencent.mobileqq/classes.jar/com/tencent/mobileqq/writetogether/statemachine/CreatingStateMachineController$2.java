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
    if (CreatingStateMachineController.a(this.a).b() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      CreatingStateMachineController.a(this.a).j_(true);
      return;
    }
    CreatingStateMachineController.a(this.a).j_(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.CreatingStateMachineController.2
 * JD-Core Version:    0.7.0.1
 */