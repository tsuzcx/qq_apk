package com.tencent.viola.core;

import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8Value;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V8ViolaBridge$V8RefHandler
  implements ReferenceHandler
{
  private boolean releasing;
  private final List<V8Value> v8Objects = new ArrayList();
  
  public void tryReleasePendingV8Object()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("still alive size: ");
    ((StringBuilder)localObject1).append(this.v8Objects.size());
    ViolaLogUtils.e("V8ViolaBridge", ((StringBuilder)localObject1).toString());
    this.releasing = true;
    try
    {
      localObject1 = this.v8Objects.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        V8Value localV8Value = (V8Value)((Iterator)localObject1).next();
        if (!localV8Value.isReleased()) {
          localV8Value.close();
        }
      }
      this.v8Objects.clear();
      this.releasing = false;
      return;
    }
    finally
    {
      this.releasing = false;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void v8HandleCreated(V8Value paramV8Value)
  {
    if (!this.v8Objects.contains(paramV8Value)) {
      this.v8Objects.add(paramV8Value);
    }
  }
  
  public void v8HandleDisposed(V8Value paramV8Value)
  {
    if (this.releasing) {
      return;
    }
    Iterator localIterator = this.v8Objects.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == paramV8Value) {
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge.V8RefHandler
 * JD-Core Version:    0.7.0.1
 */