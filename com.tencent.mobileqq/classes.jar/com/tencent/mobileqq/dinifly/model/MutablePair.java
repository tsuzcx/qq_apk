package com.tencent.mobileqq.dinifly.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Pair;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class MutablePair<T>
{
  @Nullable
  T first;
  @Nullable
  T second;
  
  private static boolean objectsEqual(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Pair)) {}
    do
    {
      return false;
      paramObject = (Pair)paramObject;
    } while ((!objectsEqual(paramObject.first, this.first)) || (!objectsEqual(paramObject.second, this.second)));
    return true;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.first == null)
    {
      i = 0;
      if (this.second != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.first.hashCode();
      break;
      label33:
      j = this.second.hashCode();
    }
  }
  
  public void set(T paramT1, T paramT2)
  {
    this.first = paramT1;
    this.second = paramT2;
  }
  
  public String toString()
  {
    return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.MutablePair
 * JD-Core Version:    0.7.0.1
 */