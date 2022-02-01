package com.tencent.mobileqq.cuckoo;

public class MethodCopyOnWriteSet
{
  private volatile transient MethodCallback[] a = new MethodCallback[0];
  
  public int a(Object paramObject)
  {
    int i = 0;
    while (i < this.a.length)
    {
      if (paramObject.equals(this.a[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean a(MethodCallback paramMethodCallback)
  {
    try
    {
      int i = a(paramMethodCallback);
      if (i >= 0) {
        return false;
      }
      MethodCallback[] arrayOfMethodCallback = new MethodCallback[this.a.length + 1];
      System.arraycopy(this.a, 0, arrayOfMethodCallback, 0, this.a.length);
      arrayOfMethodCallback[this.a.length] = paramMethodCallback;
      this.a = arrayOfMethodCallback;
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.MethodCopyOnWriteSet
 * JD-Core Version:    0.7.0.1
 */