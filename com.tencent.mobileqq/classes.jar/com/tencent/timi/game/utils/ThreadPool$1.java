package com.tencent.timi.game.utils;

import com.tencent.mobileqq.app.ThreadManager;

final class ThreadPool$1
  implements Runnable
{
  public void run()
  {
    ThreadManager.excute(this.a, this.b, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.ThreadPool.1
 * JD-Core Version:    0.7.0.1
 */