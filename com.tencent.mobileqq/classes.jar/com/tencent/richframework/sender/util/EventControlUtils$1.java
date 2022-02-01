package com.tencent.richframework.sender.util;

import java.util.TimerTask;

final class EventControlUtils$1
  extends TimerTask
{
  public void run()
  {
    EventControlUtils.OnDebounceListener localOnDebounceListener = this.a;
    if (localOnDebounceListener != null) {
      localOnDebounceListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.util.EventControlUtils.1
 * JD-Core Version:    0.7.0.1
 */