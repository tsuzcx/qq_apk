package com.tencent.mobileqq.kandian.biz.privatechat;

import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJPrivateChatListFragment$refreshPrivateChatList$1
  implements Runnable
{
  RIJPrivateChatListFragment$refreshPrivateChatList$1(RIJPrivateChatListFragment paramRIJPrivateChatListFragment, List paramList) {}
  
  public final void run()
  {
    RIJPrivateChatListFragment.a(this.this$0).a(this.a);
    View localView = RIJPrivateChatListFragment.c(this.this$0);
    int i;
    if ((((Collection)this.a).isEmpty() ^ true)) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.RIJPrivateChatListFragment.refreshPrivateChatList.1
 * JD-Core Version:    0.7.0.1
 */