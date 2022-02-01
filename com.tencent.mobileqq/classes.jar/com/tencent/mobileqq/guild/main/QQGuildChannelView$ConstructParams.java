package com.tencent.mobileqq.guild.main;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper.IAutoCollapseHandler;

public class QQGuildChannelView$ConstructParams
{
  public final View a;
  public final FacadeArgsData b;
  public final QQGuildChannelView.OnListViewScroll c;
  private final ChannelListViewHelper.IAutoCollapseHandler d;
  
  QQGuildChannelView$ConstructParams(@NonNull View paramView, @NonNull FacadeArgsData paramFacadeArgsData, QQGuildChannelView.OnListViewScroll paramOnListViewScroll, ChannelListViewHelper.IAutoCollapseHandler paramIAutoCollapseHandler)
  {
    this.a = paramView;
    this.b = paramFacadeArgsData;
    this.c = paramOnListViewScroll;
    this.d = paramIAutoCollapseHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.ConstructParams
 * JD-Core Version:    0.7.0.1
 */