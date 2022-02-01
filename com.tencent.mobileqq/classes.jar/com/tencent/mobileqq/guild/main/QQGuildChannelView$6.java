package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper.IAutoCollapseHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class QQGuildChannelView$6
  implements AbsListView.OnScrollListener
{
  private boolean c = false;
  
  QQGuildChannelView$6(QQGuildChannelView paramQQGuildChannelView, AbsListView.OnScrollListener paramOnScrollListener) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c) {
      return;
    }
    AbsListView.OnScrollListener localOnScrollListener = this.a;
    if (localOnScrollListener != null)
    {
      this.c = true;
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      this.c = false;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.c) {
      return;
    }
    AbsListView.OnScrollListener localOnScrollListener = this.a;
    if (localOnScrollListener != null)
    {
      this.c = true;
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
      this.c = false;
    }
    QQGuildChannelView.h(this.b).a(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.6
 * JD-Core Version:    0.7.0.1
 */