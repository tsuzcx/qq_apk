package com.tencent.mobileqq.guild.privatechannel;

import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;

class GuildSelectMemberLayout$2
  implements AbsListView.OnScrollListener
{
  GuildSelectMemberLayout$2(GuildSelectMemberLayout paramGuildSelectMemberLayout) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (GuildSelectMemberLayout.b(this.a) != null) {
      GuildSelectMemberLayout.b(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    InputMethodUtil.b(this.a.i);
    if (GuildSelectMemberLayout.b(this.a) != null) {
      GuildSelectMemberLayout.b(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((this.a.e.getOverScrollFooterView() != null) && (this.a.g.getCount() - this.a.e.getLastVisiblePosition() < 10)) {
      GuildSelectMemberLayout.b(this.a).a(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.2
 * JD-Core Version:    0.7.0.1
 */