package com.tencent.mobileqq.selectmember;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener;

class FriendTeamListInnerFrame$1
  implements PinnedFooterExpandableListView.FooterExpandListViewListener
{
  FriendTeamListInnerFrame$1(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
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
        QLog.d("FriendTeamListInnerFrameNew", 2, paramPinnedFooterExpandableListView.toString());
      }
      paramPinnedFooterExpandableListView = this.a;
      paramPinnedFooterExpandableListView.a = true;
      FriendTeamListInnerFrame.a(paramPinnedFooterExpandableListView).setFooterEnable(false);
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
    FriendTeamListInnerFrame localFriendTeamListInnerFrame = this.a;
    localFriendTeamListInnerFrame.a = true;
    FriendTeamListInnerFrame.a(localFriendTeamListInnerFrame).setFooterEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */