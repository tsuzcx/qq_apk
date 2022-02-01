package com.tencent.mobileqq.guild.notice;

import android.view.View;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

class GuildNoticeFragment$2
  implements OverScrollViewListener
{
  GuildNoticeFragment$2(GuildNoticeFragment paramGuildNoticeFragment) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    GuildNoticeFragment.a(this.a).hideOverScrollerFooterView();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeFragment.2
 * JD-Core Version:    0.7.0.1
 */