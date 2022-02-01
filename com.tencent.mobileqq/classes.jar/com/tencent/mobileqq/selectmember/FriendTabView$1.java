package com.tencent.mobileqq.selectmember;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener;

class FriendTabView$1
  implements PinnedFooterExpandableListView.FooterExpandListViewListener
{
  FriendTabView$1(FriendTabView paramFriendTabView) {}
  
  public void onClickHeader(PinnedFooterExpandableListView paramPinnedFooterExpandableListView, View paramView, int paramInt)
  {
    if (!this.a.a)
    {
      int i = paramInt - 1;
      if (i >= 0)
      {
        paramPinnedFooterExpandableListView.collapseGroup(i);
      }
      else if (QLog.isColorLevel())
      {
        paramPinnedFooterExpandableListView = new StringBuilder();
        paramPinnedFooterExpandableListView.append("header group unusal: ");
        paramPinnedFooterExpandableListView.append(paramInt);
        QLog.d("FriendTabView", 2, paramPinnedFooterExpandableListView.toString());
      }
      paramPinnedFooterExpandableListView = this.a;
      paramPinnedFooterExpandableListView.a = true;
      FriendTabView.a(paramPinnedFooterExpandableListView).setFooterEnable(false);
      return;
    }
    if (paramPinnedFooterExpandableListView.isGroupExpanded(paramInt))
    {
      paramPinnedFooterExpandableListView.collapseGroup(paramInt);
      return;
    }
    paramPinnedFooterExpandableListView.expandGroup(paramInt);
  }
  
  public void onHeaderDisable()
  {
    FriendTabView localFriendTabView = this.a;
    localFriendTabView.a = true;
    FriendTabView.a(localFriendTabView).setFooterEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTabView.1
 * JD-Core Version:    0.7.0.1
 */