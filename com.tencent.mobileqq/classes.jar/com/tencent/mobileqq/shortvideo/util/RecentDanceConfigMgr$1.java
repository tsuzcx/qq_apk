package com.tencent.mobileqq.shortvideo.util;

import java.util.concurrent.atomic.AtomicReference;

final class RecentDanceConfigMgr$1
  implements Runnable
{
  RecentDanceConfigMgr$1(String paramString) {}
  
  public void run()
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = RecentDanceConfigMgr.b(this.a);
    if (localRecentDanceConfigMgr != null) {
      RecentDanceConfigMgr.b().getAndSet(localRecentDanceConfigMgr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.1
 * JD-Core Version:    0.7.0.1
 */