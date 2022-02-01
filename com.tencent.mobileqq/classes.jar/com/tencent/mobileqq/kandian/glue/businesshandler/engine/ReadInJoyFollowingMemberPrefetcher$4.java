package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import java.lang.ref.WeakReference;

class ReadInJoyFollowingMemberPrefetcher$4
  implements Runnable
{
  ReadInJoyFollowingMemberPrefetcher$4(ReadInJoyFollowingMemberPrefetcher paramReadInJoyFollowingMemberPrefetcher, boolean paramBoolean) {}
  
  public void run()
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following members");
    }
    FollowListInfoModule localFollowListInfoModule = (FollowListInfoModule)ReadInJoyFollowingMemberPrefetcher.a(this.this$0).get();
    if (localFollowListInfoModule != null)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preload all following members, force=");
        localStringBuilder.append(this.a);
        com.tencent.qphone.base.util.QLog.d("ReadInJoyFollowingMemberPrefetcher", 2, localStringBuilder.toString());
      }
      try
      {
        if ((ReadInJoyFollowingMemberPrefetcher.b(this.this$0).get() != null) && (!ReadInJoyFollowingMemberPrefetcher.a(this.this$0)))
        {
          ReadInJoyFollowingMemberPrefetcher.a(this.this$0, true);
          ReadInJoyLogicEngineEventDispatcher.a().a(this.this$0);
          this.this$0.m();
          localFollowListInfoModule.a(1000, 1, true);
          return;
        }
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "fetch following member when appinterface is null or uninitialized!");
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyFollowingMemberPrefetcher.4
 * JD-Core Version:    0.7.0.1
 */