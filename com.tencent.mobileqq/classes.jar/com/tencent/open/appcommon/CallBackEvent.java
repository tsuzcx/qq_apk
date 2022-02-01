package com.tencent.open.appcommon;

import java.util.ArrayList;
import java.util.List;

public class CallBackEvent
{
  protected static volatile CallBackEvent a;
  protected List<CallBackEvent.CallBackEventListener> a;
  protected boolean a;
  
  public CallBackEvent()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static CallBackEvent a()
  {
    if (jdField_a_of_type_ComTencentOpenAppcommonCallBackEvent == null) {
      jdField_a_of_type_ComTencentOpenAppcommonCallBackEvent = new CallBackEvent();
    }
    return jdField_a_of_type_ComTencentOpenAppcommonCallBackEvent;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      b(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      CallBackEvent.CallBackEventListener[] arrayOfCallBackEventListener = new CallBackEvent.CallBackEventListener[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfCallBackEventListener);
      int j = arrayOfCallBackEventListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCallBackEventListener[i].a(paramBoolean);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.CallBackEvent
 * JD-Core Version:    0.7.0.1
 */