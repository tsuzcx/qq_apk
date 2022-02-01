package com.tencent.mobileqq.kandian.repo.follow;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import java.util.List;

class FollowListInfoModule$5
  implements Runnable
{
  FollowListInfoModule$5(FollowListInfoModule paramFollowListInfoModule, List paramList, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(true, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule.5
 * JD-Core Version:    0.7.0.1
 */