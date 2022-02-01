package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.Iterator;
import java.util.List;

class BaseMsgBoxActivity$2$1
  implements Runnable
{
  BaseMsgBoxActivity$2$1(BaseMsgBoxActivity.2 param2, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.a) && (this.d.a.mRecentAdapter != null) && (this.d.a.mRecentListData != null))
    {
      Iterator localIterator = this.d.a.mRecentListData.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData.getRecentUserUin().equals(this.b))
        {
          localRecentBaseData.mTitleName = this.c;
          this.d.a.mRecentAdapter.a(this.b, this.d.a.mBoxMsgType);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.2.1
 * JD-Core Version:    0.7.0.1
 */