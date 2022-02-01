package com.tencent.mobileqq.kandian.base.utils;

import androidx.annotation.NonNull;

public class ValueReference<V>
{
  private V a;
  
  public ValueReference(V paramV)
  {
    this.a = paramV;
  }
  
  public V a()
  {
    return this.a;
  }
  
  public void a(V paramV)
  {
    this.a = paramV;
  }
  
  @NonNull
  public String toString()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject.toString();
    }
    return "null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ValueReference
 * JD-Core Version:    0.7.0.1
 */