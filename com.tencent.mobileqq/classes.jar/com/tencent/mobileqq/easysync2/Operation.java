package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Operation
{
  char a;
  int b;
  int c;
  String d = "";
  
  void a()
  {
    this.a = '\000';
    this.b = 0;
    this.c = 0;
    this.d = "";
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Operation)) {
      return false;
    }
    Object localObject = (Operation)paramObject;
    if ((this.a == ((Operation)localObject).a) && (this.b == ((Operation)localObject).b) && (this.c == ((Operation)localObject).c))
    {
      paramObject = this.d;
      localObject = ((Operation)localObject).d;
      if (paramObject == localObject) {
        return bool;
      }
      if ((paramObject != null) && (paramObject.equals(localObject))) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[opcode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", chars=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",lines=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", attribs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Operation
 * JD-Core Version:    0.7.0.1
 */