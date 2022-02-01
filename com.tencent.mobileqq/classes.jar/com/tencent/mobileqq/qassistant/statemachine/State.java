package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;

public class State
  implements IState
{
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public String d()
  {
    String str = getClass().getName();
    return str.substring(str.lastIndexOf('$') + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.State
 * JD-Core Version:    0.7.0.1
 */