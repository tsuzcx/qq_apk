package com.tribe.async.dispatch;

import android.os.SystemClock;
import com.tribe.async.utils.MonotonicClock;

final class PendingPost$1
  implements MonotonicClock
{
  public long now()
  {
    return SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.dispatch.PendingPost.1
 * JD-Core Version:    0.7.0.1
 */