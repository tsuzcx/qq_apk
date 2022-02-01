package com.tencent.mobileqq.bubble;

import android.os.Build.VERSION;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;

class QQAnimationDrawable$Task<T>
{
  final AbstractCollection<T> a;
  
  public QQAnimationDrawable$Task(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.a = new ArrayDeque();
      return;
    }
    this.a = new ArrayBlockingQueue(30);
  }
  
  public T a()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      if ((this.a instanceof ArrayDeque)) {
        return ((ArrayDeque)this.a).poll();
      }
    }
    else if ((this.a instanceof ArrayBlockingQueue)) {
      return ((ArrayBlockingQueue)this.a).poll();
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(T paramT)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      if ((this.a instanceof ArrayDeque)) {
        ((ArrayDeque)this.a).offer(paramT);
      }
    }
    while (!(this.a instanceof ArrayBlockingQueue)) {
      return;
    }
    ((ArrayBlockingQueue)this.a).offer(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable.Task
 * JD-Core Version:    0.7.0.1
 */