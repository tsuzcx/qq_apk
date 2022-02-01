package com.tencent.mobileqq.pic.operator;

import java.util.HashMap;

public class OperatorMap<T extends AbstractPicOperator>
{
  HashMap<Integer, Class<? extends T>> a = new HashMap();
  private Class<T> b;
  
  public OperatorMap(Class<T> paramClass)
  {
    this.b = paramClass;
  }
  
  public Class<? extends T> a(int paramInt)
  {
    Class localClass2 = (Class)this.a.get(Integer.valueOf(paramInt));
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this.b;
    }
    return localClass1;
  }
  
  public void a(int paramInt, Class<? extends T> paramClass)
  {
    this.a.put(Integer.valueOf(paramInt), paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.OperatorMap
 * JD-Core Version:    0.7.0.1
 */