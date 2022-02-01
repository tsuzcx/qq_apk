package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;

public class OpAssembler
{
  private StringBuilder a = new StringBuilder();
  
  public void a(Operation paramOperation)
  {
    this.a.append(paramOperation.d);
    if (paramOperation.c > 0)
    {
      StringBuilder localStringBuilder = this.a;
      localStringBuilder.append('|');
      localStringBuilder.append(Changeset.a(paramOperation.c));
    }
    this.a.append(paramOperation.a);
    this.a.append(Changeset.a(paramOperation.b));
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = this.a;
    localStringBuilder.delete(0, localStringBuilder.length());
  }
  
  @NonNull
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OpAssembler
 * JD-Core Version:    0.7.0.1
 */