package com.tencent.mobileqq.webview.swift.utils;

import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class SwiftBrowserIdleTaskHelper$1
  implements MessageQueue.IdleHandler
{
  SwiftBrowserIdleTaskHelper$1(SwiftBrowserIdleTaskHelper paramSwiftBrowserIdleTaskHelper) {}
  
  public boolean queueIdle()
  {
    int i;
    do
    {
      if (SwiftBrowserIdleTaskHelper.c().isEmpty()) {
        break;
      }
      SwiftBrowserIdleTaskHelper.IdleTask localIdleTask = (SwiftBrowserIdleTaskHelper.IdleTask)SwiftBrowserIdleTaskHelper.c().remove(0);
      i = localIdleTask.a();
      if (2 == i)
      {
        SwiftBrowserIdleTaskHelper.c().add(localIdleTask);
        break;
      }
    } while (1 != i);
    this.a.b = (true ^ SwiftBrowserIdleTaskHelper.c().isEmpty());
    return this.a.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.1
 * JD-Core Version:    0.7.0.1
 */