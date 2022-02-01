package com.tencent.mobileqq.colornote.smallscreen;

public class UpcomingNotifyState
{
  private int a = 1;
  private UpcomingNotifyState.OnStateChangeListener b;
  
  public UpcomingNotifyState() {}
  
  public UpcomingNotifyState(UpcomingNotifyState.OnStateChangeListener paramOnStateChangeListener)
  {
    this.b = paramOnStateChangeListener;
  }
  
  public void a()
  {
    int i = this.a;
    UpcomingNotifyState.OnStateChangeListener localOnStateChangeListener;
    if (i == 1)
    {
      localOnStateChangeListener = this.b;
      if (localOnStateChangeListener != null)
      {
        localOnStateChangeListener.a(1);
        this.a = 2;
      }
    }
    else if (i == 2)
    {
      localOnStateChangeListener = this.b;
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.a(2);
      }
    }
  }
  
  public void b()
  {
    if (this.a == 2)
    {
      UpcomingNotifyState.OnStateChangeListener localOnStateChangeListener = this.b;
      if (localOnStateChangeListener != null)
      {
        localOnStateChangeListener.a();
        this.a = 3;
      }
    }
  }
  
  public void c()
  {
    if (this.a == 3)
    {
      UpcomingNotifyState.OnStateChangeListener localOnStateChangeListener = this.b;
      if (localOnStateChangeListener != null)
      {
        localOnStateChangeListener.b();
        this.a = 1;
      }
    }
  }
  
  public int d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.UpcomingNotifyState
 * JD-Core Version:    0.7.0.1
 */