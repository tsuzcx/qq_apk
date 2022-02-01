package com.tencent.mobileqq.guild.notice;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

class GuildNoticeFragment$1
  implements AbsListView.OnScrollListener
{
  GuildNoticeFragment$1(GuildNoticeFragment paramGuildNoticeFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((GuildNoticeFragment.a(this.a).getOverScrollFooterView() != null) && (this.a.a.getCount() - GuildNoticeFragment.a(this.a).getLastVisiblePosition() < 10)) {
      GuildNoticeFragment.b(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeFragment.1
 * JD-Core Version:    0.7.0.1
 */