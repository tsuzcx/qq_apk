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
    boolean bool1 = paramObject instanceof Pair;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Pair)paramObject;
    bool1 = bool2;
    if (objectsEqual(paramObject.first, this.first))
    {
      bool1 = bool2;
      if (objectsEqual(paramObject.second, this.second)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    Object localObject = this.first;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.second;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public void set(T paramT1, T paramT2)
  {
    this.first = paramT1;
    this.second = paramT2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Pair{");
    localStringBuilder.append(String.valueOf(this.first));
    localStringBuilder.append(" ");
    localStringBuilder.append(String.valueOf(this.second));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.MutablePair
 * JD-Core Version:    0.7.0.1
 */