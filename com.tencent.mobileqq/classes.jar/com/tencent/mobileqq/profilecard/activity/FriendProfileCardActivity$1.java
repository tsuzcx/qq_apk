package com.tencent.mobileqq.profilecard.activity;

import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.Iterator;
import java.util.List;

class FriendProfileCardActivity$1
  implements AbsListView.OnScrollListener
{
  FriendProfileCardActivity$1(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FriendProfileCardActivity.access$000(this.this$0) != null)
    {
      Iterator localIterator = FriendProfileCardActivity.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((AbsListView.OnScrollListener)localIterator.next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      DropFrameMonitor.b().a("vas_profilecard_list", false);
    } else {
      DropFrameMonitor.b().a("vas_profilecard_list");
    }
    if (FriendProfileCardActivity.access$000(this.this$0) != null)
    {
      Iterator localIterator = FriendProfileCardActivity.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((AbsListView.OnScrollListener)localIterator.next()).onScrollStateChanged(paramAbsListView, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.1
 * JD-Core Version:    0.7.0.1
 */