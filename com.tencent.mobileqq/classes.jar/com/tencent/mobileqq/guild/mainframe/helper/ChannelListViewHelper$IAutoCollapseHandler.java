package com.tencent.mobileqq.guild.mainframe.helper;

import android.view.View.OnTouchListener;
import com.tencent.mobileqq.guild.main.QQGuildChannelView.OnListViewStateChange;
import com.tencent.widget.AbsListView;

public abstract interface ChannelListViewHelper$IAutoCollapseHandler
  extends View.OnTouchListener, QQGuildChannelView.OnListViewStateChange
{
  public abstract void a(AbsListView paramAbsListView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper.IAutoCollapseHandler
 * JD-Core Version:    0.7.0.1
 */