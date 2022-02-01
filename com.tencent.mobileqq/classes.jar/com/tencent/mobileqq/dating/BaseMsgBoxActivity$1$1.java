package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.activity.recent.RecentAdapter;

class BaseMsgBoxActivity$1$1
  implements Runnable
{
  BaseMsgBoxActivity$1$1(BaseMsgBoxActivity.1 param1, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if ((this.a) && (this.c.a.mRecentAdapter != null)) {
      this.c.a.mRecentAdapter.a(this.b, this.c.a.mBoxMsgType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.1.1
 * JD-Core Version:    0.7.0.1
 */