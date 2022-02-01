package com.tencent.mobileqq.guild.main.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelGuide;

public class QQGuildAddChannelBuilder
  extends QQGuildChannelItemBuilder
{
  public View a(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131624998, null);
      paramObject = new QQGuildAddChannelBuilder.Holder(this, null);
      paramObject.a = ((ImageView)paramView.findViewById(2131434552));
      paramObject.b = ((TextView)paramView.findViewById(2131434553));
      paramView.setTag(paramObject);
    }
    paramView.setOnClickListener(paramOnClickListener);
    return paramView;
  }
  
  public void a(View paramView, int paramInt, QQChannelItemData paramQQChannelItemData, Context paramContext)
  {
    if (!(paramQQChannelItemData instanceof QQGuildChannelGuide)) {
      return;
    }
    paramView = (QQGuildAddChannelBuilder.Holder)paramView.getTag();
    paramQQChannelItemData = (QQGuildChannelGuide)paramQQChannelItemData;
    paramView.b.setText(paramQQChannelItemData.c());
    paramView.a.setImageResource(paramQQChannelItemData.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildAddChannelBuilder
 * JD-Core Version:    0.7.0.1
 */