package com.tencent.mtt.hippy.dom;

import android.os.Looper;

final class e$1
  extends ThreadLocal<e>
{
  protected e a()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper == null) {
      throw new IllegalStateException("The current thread must have a looper!");
    }
    return new e(localLooper, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e.1
 * JD-Core Version:    0.7.0.1
 */