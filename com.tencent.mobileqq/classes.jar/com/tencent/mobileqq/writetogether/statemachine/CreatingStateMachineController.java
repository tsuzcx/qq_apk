package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogetherui.ITemplateWhenCreating;
import java.util.Arrays;
import java.util.Collections;

public class CreatingStateMachineController
{
  private StateMachine<CreatingState> a;
  private ITemplateWhenCreating b;
  
  public CreatingStateMachineController(ITemplateWhenCreating paramITemplateWhenCreating)
  {
    this.b = paramITemplateWhenCreating;
  }
  
  public CreatingState a()
  {
    return (CreatingState)this.a.a();
  }
  
  public void a(CreatingState paramCreatingState)
  {
    this.a.a(paramCreatingState);
  }
  
  public CreatingState b()
  {
    return (CreatingState)this.a.b();
  }
  
  public void c()
  {
    this.a = new StateMachine(CreatingState.TEMPLATE_NO, "CreatingStateMachineController");
    this.a.a(new CreatingStateMachineController.1(this, CreatingState.TEMPLATE_FIRST_USE, Collections.singletonList(CreatingState.TEMPLATE_NO)));
    this.a.a(new CreatingStateMachineController.2(this, CreatingState.TEMPLATE_SHOW_ENTRANCE, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_LAYER })));
    this.a.a(new CreatingStateMachineController.3(this, CreatingState.TEMPLATE_SHOW_LAYER, Arrays.asList(new CreatingState[] { CreatingState.TEMPLATE_NO, CreatingState.TEMPLATE_FIRST_USE, CreatingState.TEMPLATE_SHOW_ENTRANCE })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.CreatingStateMachineController
 * JD-Core Version:    0.7.0.1
 */