package com.tencent.mobileqq.data.entitymanager;

public abstract interface Interceptor<T>
{
  public abstract T intercept(Interceptor.Chain<T> paramChain);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.entitymanager.Interceptor
 * JD-Core Version:    0.7.0.1
 */