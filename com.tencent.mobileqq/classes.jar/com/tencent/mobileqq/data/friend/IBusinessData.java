package com.tencent.mobileqq.data.friend;

import com.tencent.mobileqq.persistence.Entity;

public abstract interface IBusinessData<T extends Entity>
{
  public abstract void a(T paramT);
  
  public abstract void a(T paramT, Object... paramVarArgs);
  
  public abstract void b(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.friend.IBusinessData
 * JD-Core Version:    0.7.0.1
 */