package com.tencent.mobileqq.kandian.repo.follow;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import java.util.List;

class FollowListInfoModule$4
  implements Runnable
{
  FollowListInfoModule$4(FollowListInfoModule paramFollowListInfoModule, List paramList, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(true, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule.4
 * JD-Core Version:    0.7.0.1
 */