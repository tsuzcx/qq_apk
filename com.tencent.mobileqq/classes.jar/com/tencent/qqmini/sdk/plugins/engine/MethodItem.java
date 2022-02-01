package com.tencent.qqmini.sdk.plugins.engine;

import android.support.annotation.NonNull;
import java.lang.reflect.Method;

class MethodItem
{
  @NonNull
  public final Method a;
  public final boolean b;
  
  public MethodItem(Method paramMethod, boolean paramBoolean)
  {
    this.a = paramMethod;
    this.b = paramBoolean;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MethodItem{method=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isSync=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.MethodItem
 * JD-Core Version:    0.7.0.1
 */