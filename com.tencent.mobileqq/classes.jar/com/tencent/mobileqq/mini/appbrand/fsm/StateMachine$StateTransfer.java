package com.tencent.mobileqq.mini.appbrand.fsm;

public class StateMachine$StateTransfer<E>
{
  private E event;
  private StateMachine<T, E>.State<T> fromState;
  private StateMachine<T, E>.State<T> nextState;
  
  public StateMachine$StateTransfer(StateMachine paramStateMachine) {}
  
  public StateMachine<T, E>.State<T> from()
  {
    return this.fromState;
  }
  
  public StateTransfer from(StateMachine<T, E>.State<T> paramStateMachine)
  {
    this.fromState = paramStateMachine;
    return this;
  }
  
  public StateMachine<T, E>.State<T> next()
  {
    return this.nextState;
  }
  
  public StateTransfer next(StateMachine<T, E>.State<T> paramStateMachine)
  {
    this.nextState = paramStateMachine;
    return this;
  }
  
  public StateTransfer registEvent(E paramE)
  {
    this.event = paramE;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.fsm.StateMachine.StateTransfer
 * JD-Core Version:    0.7.0.1
 */