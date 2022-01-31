package com.tencent.mobileqq.shortvideo.util;

import java.util.concurrent.atomic.AtomicReference;

final class RecentDanceConfigMgr$1
  implements Runnable
{
  RecentDanceConfigMgr$1(String paramString) {}
  
  public void run()
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = RecentDanceConfigMgr.a(this.a);
    if (localRecentDanceConfigMgr != null) {
      RecentDanceConfigMgr.a().getAndSet(localRecentDanceConfigMgr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.1
 * JD-Core Version:    0.7.0.1
 */