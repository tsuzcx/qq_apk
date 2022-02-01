package com.tencent.mobileqq.guild.main;

import android.view.View;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper.IAutoCollapseHandler;

public class QQGuildChannelView$ConstructParamsBuilder
{
  private View a;
  private FacadeArgsData b;
  private QQGuildChannelView.OnListViewScroll c;
  private ChannelListViewHelper.IAutoCollapseHandler d;
  
  public QQGuildChannelView.ConstructParams a()
  {
    return new QQGuildChannelView.ConstructParams(this.a, this.b, this.c, this.d);
  }
  
  public ConstructParamsBuilder a(View paramView)
  {
    this.a = paramView;
    return this;
  }
  
  public ConstructParamsBuilder a(QQGuildChannelView.OnListViewScroll paramOnListViewScroll)
  {
    this.c = paramOnListViewScroll;
    return this;
  }
  
  public ConstructParamsBuilder a(FacadeArgsData paramFacadeArgsData)
  {
    this.b = paramFacadeArgsData;
    return this;
  }
  
  public ConstructParamsBuilder a(ChannelListViewHelper.IAutoCollapseHandler paramIAutoCollapseHandler)
  {
    this.d = paramIAutoCollapseHandler;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.ConstructParamsBuilder
 * JD-Core Version:    0.7.0.1
 */