package com.tencent.mobileqq.guild.setting;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;

class QQGuildMemberFragment$3
  implements AbsListView.OnScrollListener
{
  QQGuildMemberFragment$3(QQGuildMemberFragment paramQQGuildMemberFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      QQGuildMemberFragment.a(this.a).b(false);
    }
    if ((this.a.o.getOverScrollFooterView() != null) && (!QQGuildMemberFragment.a(this.a).p()) && (QQGuildMemberFragment.b(this.a).getCount() - this.a.o.getLastVisiblePosition() < 10)) {
      QQGuildMemberFragment.a(this.a).s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */