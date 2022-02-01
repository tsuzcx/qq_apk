package com.tencent.mobileqq.cmshow.brickengine.apollo;

import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$6
  extends IApolloRunnableTask
{
  public void run()
  {
    String str;
    if (1 == this.a) {
      str = "me.restoreAnimationState();";
    } else {
      str = "friend.restoreAnimationState();";
    }
    this.this$0.c.lock();
    try
    {
      if (this.this$0.b != null) {
        this.this$0.b.execScriptString(str);
      }
      if (this.this$0.a != null) {
        this.this$0.a.onRender();
      }
      return;
    }
    finally
    {
      this.this$0.c.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.6
 * JD-Core Version:    0.7.0.1
 */