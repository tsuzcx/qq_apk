package de.robv.android.xposed;

import java.util.concurrent.atomic.AtomicInteger;

final class XposedHelpers$1
  extends ThreadLocal<AtomicInteger>
{
  protected AtomicInteger initialValue()
  {
    return new AtomicInteger();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedHelpers.1
 * JD-Core Version:    0.7.0.1
 */