package com.tencent.timi.game.initer.impl;

import com.tencent.timi.game.utils.Logger;

class IniterServiceImpl$1
  implements Runnable
{
  IniterServiceImpl$1(IniterServiceImpl paramIniterServiceImpl) {}
  
  public void run()
  {
    boolean bool = IniterServiceImpl.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkTimiGameRes#run -- needReleaseTg= ");
    localStringBuilder.append(bool);
    Logger.c("IniterServiceImpl", localStringBuilder.toString());
    if (bool) {
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.IniterServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */