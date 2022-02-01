package com.tencent.mobileqq.colornote.smallscreen;

public class UpcomingNotifyState
{
  private int jdField_a_of_type_Int = 1;
  private UpcomingNotifyState.OnStateChangeListener jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState$OnStateChangeListener;
  
  public UpcomingNotifyState() {}
  
  public UpcomingNotifyState(UpcomingNotifyState.OnStateChangeListener paramOnStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState$OnStateChangeListener = paramOnStateChangeListener;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_Int;
    UpcomingNotifyState.OnStateChangeListener localOnStateChangeListener;
    if (i == 1)
    {
      localOnStateChangeListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState$OnStateChangeListener;
      if (localOnStateChangeListener != null)
      {
        localOnStateChangeListener.a(1);
        this.jdField_a_of_type_Int = 2;
      }
    }
    else if (i == 2)
    {
      localOnStateChangeListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState$OnStateChangeListener;
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.a(2);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      UpcomingNotifyState.OnStateChangeListener localOnStateChangeListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState$OnStateChangeListener;
      if (localOnStateChangeListener != null)
      {
        localOnStateChangeListener.a();
        this.jdField_a_of_type_Int = 3;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 3)
    {
      UpcomingNotifyState.OnStateChangeListener localOnStateChangeListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState$OnStateChangeListener;
      if (localOnStateChangeListener != null)
      {
        localOnStateChangeListener.b();
        this.jdField_a_of_type_Int = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.UpcomingNotifyState
 * JD-Core Version:    0.7.0.1
 */