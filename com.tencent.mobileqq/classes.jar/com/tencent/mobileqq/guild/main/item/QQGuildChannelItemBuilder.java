package com.tencent.mobileqq.guild.main.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.main.IChannelListControl;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;

public abstract class QQGuildChannelItemBuilder
{
  protected IChannelListControl a;
  
  public abstract View a(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener);
  
  public abstract void a(View paramView, int paramInt, QQChannelItemData paramQQChannelItemData, Context paramContext);
  
  public void a(IChannelListControl paramIChannelListControl)
  {
    this.a = paramIChannelListControl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildChannelItemBuilder
 * JD-Core Version:    0.7.0.1
 */