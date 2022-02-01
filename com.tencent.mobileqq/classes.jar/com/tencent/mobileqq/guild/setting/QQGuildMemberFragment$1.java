package com.tencent.mobileqq.guild.setting;

import android.view.View;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SwipListView;

class QQGuildMemberFragment$1
  implements OverScrollViewListener
{
  QQGuildMemberFragment$1(QQGuildMemberFragment paramQQGuildMemberFragment) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.a.o.hideOverScrollerFooterView();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.1
 * JD-Core Version:    0.7.0.1
 */