package com.tencent.mobileqq.writetogether.statemachine.core;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class StateProcessor<E>
{
  protected E d;
  protected List<E> e;
  protected String f;
  
  public StateProcessor(E paramE, List<E> paramList)
  {
    this.d = paramE;
    this.e = paramList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onExit] curState: ");
      localStringBuilder.append(this.d);
      QLog.d("StateProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleEvent] state: ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", event: ");
      localStringBuilder.append(paramInt);
      QLog.d("StateProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void a(E paramE)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onEnter] enter: ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", lastState: ");
      localStringBuilder.append(paramE);
      QLog.d("StateProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public E c()
  {
    return this.d;
  }
  
  @NonNull
  List<E> d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor
 * JD-Core Version:    0.7.0.1
 */